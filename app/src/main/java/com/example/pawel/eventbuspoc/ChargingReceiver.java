package com.example.pawel.eventbuspoc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.text.format.Time;

import de.greenrobot.event.EventBus;


public class ChargingReceiver extends BroadcastReceiver {
    private EventBus bus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        ChargingEvent event = null;

        String eventData =  "(" + getCurrentDate() + ") --> " + " charger: ";
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            event=new ChargingEvent(eventData + " ON");
        } else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            event=new ChargingEvent(eventData + " OFF");
        }
        // Post the event
        bus.post(event);
    }

    private String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("EEE, MMM d, ''yy");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
}
