package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);


                // Check for presence of sensors

                // If Accelerometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
                    TextView tv = findViewById(R.id.AccQualityText);
                    tv.setText("Present");
                }
                else{
                    TextView tv = findViewById(R.id.AccQualityText);
                    tv.setText("Absent");
                }

                // If Barometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null){
                    TextView tv = findViewById(R.id.BarometerQualityText);
                    tv.setText("Present");
                }
                else{
                    TextView tv = findViewById(R.id.BarometerQualityText);
                    tv.setText("Absent");
                }

                // If Barometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null){
                    TextView tv = findViewById(R.id.BarometerQualityText);
                    tv.setText("Present");
                }
                else{
                    TextView tv = findViewById(R.id.BarometerQualityText);
                    tv.setText("Absent");
                }

                // If Compass/Magnetometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
                    TextView tv = findViewById(R.id.CompassQualityText);
                    tv.setText("Present");
                }
                else{
                    TextView tv = findViewById(R.id.CompassQualityText);
                    tv.setText("Absent");
                }


                // If Gyroscope is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
                    TextView tv = findViewById(R.id.GyroQualityText);
                    tv.setText("Present");
                }
                else{
                    TextView tv = findViewById(R.id.GyroQualityText);
                    tv.setText("Absent");
                }


                // If Proximity is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null){
                    TextView tv = findViewById(R.id.ProximityQualityText);
                    tv.setText("Present");
                }
                else{
                    TextView tv = findViewById(R.id.ProximityQualityText);
                    tv.setText("Absent");
                }
















            }
        });
    }
}
