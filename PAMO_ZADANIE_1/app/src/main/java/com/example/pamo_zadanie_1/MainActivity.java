package com.example.pamo_zadanie_1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pamo_zadanie_1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private int weight = 80;
    private int height = 170;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        TextView weightTextView = findViewById(R.id.weight_text);
        TextView heightTextView = findViewById(R.id.height_text);
        TextView bmi_result_text = findViewById(R.id.bmi_result_text);
        Button buttonDecreaseWeight = findViewById(R.id.buttonDecreaseWeight);
        Button buttonIncreaseWeight = findViewById(R.id.buttonIncreaseWeight);
        Button buttonDecreaseHeight = findViewById(R.id.buttonDecreaseHeight);
        Button buttonIncreaseHeight = findViewById(R.id.buttonIncreaseHeight);
        Button button_calculate = findViewById(R.id.button_calculate);


        weightTextView.setText(String.valueOf(weight));
        heightTextView.setText(String.valueOf(height));

        buttonDecreaseWeight.setOnClickListener(v -> {
            weight--;
            weightTextView.setText(String.valueOf(weight));
        });

        buttonIncreaseWeight.setOnClickListener(v -> {
            weight++;
            weightTextView.setText(String.valueOf(weight));
        });

        buttonDecreaseHeight.setOnClickListener(v -> {
            height--;
            heightTextView.setText(String.valueOf(height));
        });

        buttonIncreaseHeight.setOnClickListener(v -> {
            height++;
            heightTextView.setText(String.valueOf(height));
        });

        button_calculate.setOnClickListener(v -> {
//            https://bmi-online.pl/
//            Zakresy wartości BMI:
//
//            mniej niż 16 - wygłodzenie
//            16 - 16.99 - wychudzenie
//            17 - 18.49 - niedowaga
//            18.5 - 24.99 - wartość prawidłowa
//            25 - 29.99 - nadwaga
//            30 - 34.99 - I stopień otyłości
//            35 - 39.99 - II stopień otyłości
//            powyżej 40 - otyłość skrajna

            double bmi = calculateBMI(weight, height);
            String category = getBMICategory(bmi);
            bmi_result_text.setText(String.format("Twoje BMI: %.2f - %s", bmi, category));
        });

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Witaj w świecie - PJATK :)", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }
    private double calculateBMI(int weight, int height) {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    private String getBMICategory(double bmi) {
        if (bmi < 16) {
            return "Wygłodzenie";
        } else if (bmi < 17) {
            return "Wychudzenie";
        } else if (bmi < 18.5) {
            return "Niedowaga";
        } else if (bmi < 25) {
            return "Waga prawidłowa";
        } else if (bmi < 30) {
            return "Nadwaga";
        } else if (bmi < 35) {
            return "I stopień otyłości";
        } else if (bmi < 40) {
            return "II stopień otyłości";
        } else {
            return "Otyłość skrajna";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}