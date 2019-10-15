/**
 *  Prepopulated databse containing sensor score information.
 *
 *  This database should be in assets( If you make changes to databse please place the database to assets folder)
 *
 *  This databse is first copied to /data/com.example.capstoneproject/databases
 *
 *  Here it is converted to room database
 *
 *  Individual tables created for individual sensor scores
 */

package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    private SensorManager sensorManager;
    private String DB_NAME = "databases/Capstone";
    private Database database;
    private PrepopulateDBHelper prepopulateDBHelper = null;

    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Prepopulate Database here
        prepopulateDBHelper = PrepopulateDBHelper.getInstance(getApplicationContext());

        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Initialize sensor manager service
                sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);


                // Check for presence of sensors

                // If Accelerometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){

                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).getName();
                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("ACCELERATION","");
                    sensor = sensor.trim();
                    final TextView tv = findViewById(R.id.AccQualityText);

                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        tv.setText("Average");
                    }
                    else {

                        // Create a exec thread that sets up database
                        ExecThread execThread = new ExecThread(getApplicationContext());
                        //AccelerometerScore accelerometerScore =  new AccelerometerScore();
                        //accelerometerScore.setName("LSM");
                        //accelerometerScore.setFinalScore(123);
                        //execThread.insertAccScore(accelerometerScore);

                        // Call to get the value corresponding to a particular string
                        LiveData<List<Float>> lst = execThread.getAccScore(sensor);
                        //LiveData<List<Float>> lst = database.daoAccess().getAccScore("LSM");
                        execThread.getAccScore(sensor).observeForever(new Observer<List<Float>>() {
                            @Override
                            public void onChanged(List<Float> floats) {
                                try {
                                    // Provide good/ bad / average recommendation for the sensor

                                    float val = floats.get(0);
                                    //Compute Difference from the 3 clusters

                                    //Compute difference from -0.1668 Med
                                    double diff1 = Math.abs(-0.1668-val);

                                    // Compute difference from 0.1869 High
                                    double diff2 = Math.abs(0.1869 - val);

                                    // Compute difference from -0.4029 Low
                                    double diff3 = Math.abs(-0.4029 - val);

                                    double minimumdiff = Math.min(Math.min(diff1, diff2), diff3);

                                    if(minimumdiff == diff1){
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        tv.setText("Good");
                                    }
                                    else{
                                        tv.setText("Bad");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    // For exception cases return Average
                                    tv.setText("Average");
                                }
                            }
                        });
                    }

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
                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE).getName();
                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("BAROMETER","");
                    sensor = sensor.trim();
                    final TextView tv = findViewById(R.id.BarometerQualityText);
                    //System.out.println("*******************"+sensor+"*****************");
                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        tv.setText("Average");
                    }
                    else {

                        // Create a exec thread that sets up database
                        ExecThread execThread = new ExecThread(getApplicationContext());
                        //AccelerometerScore accelerometerScore =  new AccelerometerScore();
                        //accelerometerScore.setName("LSM");
                        //accelerometerScore.setFinalScore(123);
                        //execThread.insertAccScore(accelerometerScore);

                        // Call to get the value corresponding to a particular string
                        LiveData<List<Float>> lst = execThread.getBarometerScore(sensor);

                        //System.out.println("***************"+sensor+"*********************");
                        //LiveData<List<Float>> lst = database.daoAccess().getAccScore("LSM");
                        execThread.getBarometerScore(sensor).observeForever(new Observer<List<Float>>() {
                            @Override
                            public void onChanged(List<Float> floats) {
                                try {
                                    // Provide good/ bad / average recommendation for the sensor

                                    float val = floats.get(0);
                                    //Compute Difference from the 3 clusters

                                    //Compute difference from -0.01459545 Med
                                    double diff1 = Math.abs(-0.01459545-val);

                                    // Compute difference from -0.41666667 Low
                                    double diff2 = Math.abs(-0.41666667 - val);

                                    // Compute difference from 0.41569767 High
                                    double diff3 = Math.abs(0.41569767 - val);

                                    double minimumdiff = Math.min(Math.min(diff1, diff2), diff3);

                                    if(minimumdiff == diff1){
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        tv.setText("Bad");
                                    }
                                    else{
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    //System.out.println("***************"+ex+"*********************");
                                    // For exception cases return Average
                                    tv.setText("Average");
                                }
                            }
                        });
                    }

                }
                else{
                    TextView tv = findViewById(R.id.BarometerQualityText);
                    tv.setText("Absent");
                }

                // If Compass/Magnetometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD).getName();
                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("MAGNETOMETER","");
                    sensor = sensor.replaceAll("MAGNETIC FIELD","");
                    sensor = sensor.replaceAll("COMPASS","");
                    sensor = sensor.trim();
                    System.out.println("***************"+sensor+"***********************");
                    final TextView tv = findViewById(R.id.CompassQualityText);
                    //System.out.println("*******************"+sensor+"*****************");
                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        tv.setText("Average");
                    }
                    else {

                        // Create a exec thread that sets up database
                        ExecThread execThread = new ExecThread(getApplicationContext());
                        //AccelerometerScore accelerometerScore =  new AccelerometerScore();
                        //accelerometerScore.setName("LSM");
                        //accelerometerScore.setFinalScore(123);
                        //execThread.insertAccScore(accelerometerScore);

                        // Call to get the value corresponding to a particular string
                        LiveData<List<Float>> lst = execThread.getMagnetometerScore(sensor);

                        //System.out.println("***************"+sensor+"*********************");
                        //LiveData<List<Float>> lst = database.daoAccess().getAccScore("LSM");
                        execThread.getMagnetometerScore(sensor).observeForever(new Observer<List<Float>>() {
                            @Override
                            public void onChanged(List<Float> floats) {
                                try {
                                    // Provide good/ bad / average recommendation for the sensor

                                    float val = floats.get(0);
                                    //Compute Difference from the 3 clusters

                                    //Compute difference from 0.19382358 Med
                                    double diff1 = Math.abs(0.19382358-val);

                                    // Compute difference from 0.09190274 Low
                                    double diff2 = Math.abs(0.09190274 - val);

                                    // Compute difference from 0.26235772 High
                                    double diff3 = Math.abs(0.26235772 - val);

                                    double minimumdiff = Math.min(Math.min(diff1, diff2), diff3);

                                    if(minimumdiff == diff1){
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        tv.setText("Bad");
                                    }
                                    else{
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    //System.out.println("***************"+ex+"*********************");
                                    // For exception cases return Average
                                    tv.setText("Average");
                                }
                            }
                        });
                    }

                }
                else{
                    TextView tv = findViewById(R.id.CompassQualityText);
                    tv.setText("Absent");
                }


                // If Gyroscope is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE).getName();
                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("GYROSCOPE","");
                    sensor = sensor.trim();
                    final TextView tv = findViewById(R.id.GyroQualityText);

                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        tv.setText("Average");
                    }
                    else {

                        // Create a exec thread that sets up database
                        ExecThread execThread = new ExecThread(getApplicationContext());
                        //AccelerometerScore accelerometerScore =  new AccelerometerScore();
                        //accelerometerScore.setName("LSM");
                        //accelerometerScore.setFinalScore(123);
                        //execThread.insertAccScore(accelerometerScore);

                        // Call to get the value corresponding to a particular string
                        LiveData<List<Float>> lst = execThread.getGyroScore(sensor);

                        //System.out.println("***************"+sensor+"*********************");
                        //LiveData<List<Float>> lst = database.daoAccess().getAccScore("LSM");
                        execThread.getGyroScore(sensor).observeForever(new Observer<List<Float>>() {
                            @Override
                            public void onChanged(List<Float> floats) {
                                try {
                                    // Provide good/ bad / average recommendation for the sensor

                                    float val = floats.get(0);
                                    //Compute Difference from the 3 clusters

                                    //Compute difference from -0.0938176 Med
                                    double diff1 = Math.abs(-0.0938176-val);

                                    // Compute difference from -0.34779439 Low
                                    double diff2 = Math.abs(-0.34779439 - val);

                                    // Compute difference from 0.24757826 High
                                    double diff3 = Math.abs(0.24757826 - val);

                                    double minimumdiff = Math.min(Math.min(diff1, diff2), diff3);

                                    if(minimumdiff == diff1){
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        tv.setText("Bad");
                                    }
                                    else{
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    //System.out.println("***************"+ex+"*********************");
                                    // For exception cases return Average
                                    tv.setText("Average");
                                }
                            }
                        });
                    }

                }
                else{
                    //System.out.println("*************************"+);
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
