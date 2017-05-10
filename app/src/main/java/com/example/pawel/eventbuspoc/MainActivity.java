package com.example.pawel.eventbuspoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.chargerButton) Button chargerButton;
    @BindView(R.id.exitApplication) Button exitApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.chargerButton)
    public void onChargerButonClicked() {
        Intent intent = new Intent(this, ChargingActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.exitApplication)
    public void onExitApplicationButonClicked() {
        finish();
    }
}
