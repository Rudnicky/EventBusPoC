package com.example.pawel.eventbuspoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class ChargingActivity extends AppCompatActivity {

    private EventBus bus = EventBus.getDefault();
    @BindView(R.id.charginStatusTextView) TextView charginStatusTextView;
    @BindView(R.id.goBackButton) Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging);
        ButterKnife.bind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onStop() {
        bus.unregister(this);
        super.onStop();
    }

    @Override
    public void onDestroy() {
        bus.unregister(this);
        super.onDestroy();
    }

    @OnClick(R.id.goBackButton)
    public void onGoBackButonClicked() {
        finish();
    }

    public void onEvent(ChargingEvent event) {
        charginStatusTextView.setText(charginStatusTextView.getText()
        + "\n" + event.getData());
    }
}
