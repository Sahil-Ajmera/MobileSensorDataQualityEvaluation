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
    private int good = 0;
    private int bad = 0;
    private int average = 0;
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

        //final Button button = findViewById(R.id.button);

        //button.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v) {

                good = 0;
                bad =  0;
                average = 0;

                // Initialize sensor manager service
                sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);


                // Check for presence of sensors

                // If Accelerometer is present in the device
                if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){

                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).getName();
                    float sensorres = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).getResolution();
                    float sensormaxrange = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).getMaximumRange();
                    String sensorvendor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER).getVendor();



                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("ACCELERATION","");
                    sensor = sensor.trim();
                    final TextView tv1 = findViewById(R.id.AccelerometerInfo);
                    tv1.setText("Name: "+sensor+"\n"+"Resolution: "+String.valueOf(sensorres)+"\n"+"Max Range: "+String.valueOf(sensormaxrange)+"\n"+"Vendor: "+sensorvendor);
                    final TextView tv = findViewById(R.id.AccQualityText);

                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        average++;
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
                                        average++;
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        good++;
                                        tv.setText("Good");
                                    }
                                    else{
                                        bad++;
                                        tv.setText("Bad");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    average++;
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
                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE).getName();
                    String sensorvendor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE).getVendor();
                    float sensorres = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE).getResolution();
                    float sensormaxrange = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE).getMaximumRange();

                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("BAROMETER","");
                    sensor = sensor.trim();
                    final TextView tv = findViewById(R.id.BarometerQualityText);
                    final TextView tv1 = findViewById(R.id.BarometerInfo);
                    tv1.setText("Name: "+sensor+"\n"+"Resolution: "+String.valueOf(sensorres)+"\n"+"Max Range: "+String.valueOf(sensormaxrange)+"\n"+"Vendor: "+sensorvendor);

                    //System.out.println("*******************"+sensor+"*****************");
                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        average++;
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
                                        average++;
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        bad++;
                                        tv.setText("Bad");
                                    }
                                    else{
                                        good++;
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    average++;
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
                    // Preprocessing on the input compass string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD).getName();
                    String sensorvendor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD).getVendor();
                    float sensorres = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD).getResolution();
                    float sensormaxrange = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD).getMaximumRange();

                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("MAGNETOMETER","");
                    sensor = sensor.replaceAll("MAGNETIC FIELD","");
                    sensor = sensor.replaceAll("COMPASS","");
                    sensor = sensor.trim();
                    //System.out.println("***************"+sensor+"***********************");
                    final TextView tv = findViewById(R.id.CompassQualityText);
                    final TextView tv1 = findViewById(R.id.CompassInfo);
                    tv1.setText("Name: "+sensor+"\n"+"Resolution: "+String.valueOf(sensorres)+"\n"+"Max Range: "+String.valueOf(sensormaxrange)+"\n"+"Vendor: "+sensorvendor);

                    //System.out.println("*******************"+sensor+"*****************");
                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        average++;
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
                                        average++;
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        bad++;
                                        tv.setText("Bad");
                                    }
                                    else{
                                        good++;
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    average++;
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
                    // Preprocessing on the input Gyroscope string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE).getName();
                    float sensormaxrange = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE).getMaximumRange();
                    float sensorres =  sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE).getResolution();
                    String sensorvendor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE).getVendor();
                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("GYROSCOPE","");
                    sensor = sensor.trim();
                    final TextView tv = findViewById(R.id.GyroQualityText);
                    final TextView tv1 = findViewById(R.id.GyroInfo);
                    tv1.setText("Name: "+sensor+"\n"+"Resolution: "+String.valueOf(sensorres)+"\n"+"Max Range: "+String.valueOf(sensormaxrange)+"\n"+"Vendor: "+sensorvendor);
                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        average++;
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
                                        average++;
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        bad++;
                                        tv.setText("Bad");
                                    }
                                    else{
                                        good++;
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    average++;
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
                    // Preprocessing on the input accelerometer string
                    String sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).getName();
                    String sensorvendor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).getVendor();
                    float sensorres = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).getResolution();
                    float sensormaxrange = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).getMaximumRange();

                    sensor = sensor.toUpperCase();
                    sensor = sensor.replaceAll("SENSOR","");
                    sensor = sensor.replaceAll("PROXIMITY","");
                    sensor = sensor.trim();
                    System.out.println("***************"+sensor+"***********************");
                    final TextView tv = findViewById(R.id.ProximityQualityText);
                    final TextView tv1 = findViewById(R.id.ProximityInfo);
                    tv1.setText("Name: "+sensor+"\n"+"Resolution: "+String.valueOf(sensorres)+"\n"+"Max Range: "+String.valueOf(sensormaxrange)+"\n"+"Vendor: "+sensorvendor);

                    //System.out.println("*******************"+sensor+"*****************");
                    //  For cases that have not been covered by data set
                    if(sensor.isEmpty()){
                        average++;
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
                        LiveData<List<Float>> lst = execThread.getProximityScore(sensor);

                        //System.out.println("***************"+sensor+"*********************");
                        //LiveData<List<Float>> lst = database.daoAccess().getAccScore("LSM");
                        execThread.getProximityScore(sensor).observeForever(new Observer<List<Float>>() {
                            @Override
                            public void onChanged(List<Float> floats) {
                                try {
                                    // Provide good/ bad / average recommendation for the sensor

                                    float val = floats.get(0);
                                    //Compute Difference from the 3 clusters

                                    //Compute difference from 0.62460502 Med
                                    double diff1 = Math.abs(0.62460502-val);

                                    // Compute difference from 0.43485789 Low
                                    double diff2 = Math.abs(0.43485789 - val);

                                    // Compute difference from 0.85836386 High
                                    double diff3 = Math.abs(0.85836386 - val);

                                    double minimumdiff = Math.min(Math.min(diff1, diff2), diff3);

                                    if(minimumdiff == diff1){
                                        average++;
                                        tv.setText("Average");
                                    }
                                    else if(minimumdiff == diff2){
                                        bad++;
                                        tv.setText("Bad");
                                    }
                                    else{
                                        good++;
                                        tv.setText("Good");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    average++;
                                    //System.out.println("***************"+ex+"*********************");
                                    // For exception cases return Average
                                    tv.setText("Average");
                                }
                            }
                        });
                    }

                }
                else{
                    TextView tv = findViewById(R.id.ProximityQualityText);
                    tv.setText("Absent");
                }


                // Calculation for overall quality based on total of 5 sensors.
                TextView tv = findViewById(R.id.OverallQualityText);

                if(good == 2 && bad == 2){
                    tv.setText("Average");
                }
                else if(good == 2 && average == 2){
                    tv.setText("Average");
                }
                else if(bad == 2 && average == 2){
                    tv.setText("Average");
                }
                else{
                    if(good >= 2){
                        tv.setText("Good");
                    }
                    else if(bad >= 2){
                        tv.setText("Bad");
                    }
                    else{
                        tv.setText("Average");
                    }
                }





            }
        //});
    }
//}
