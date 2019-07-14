package com.example.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner languagesSp;
    Spinner themeSp;
    Button  btnOk;
    Locale locale;
    int    changedTheme;
    Activity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.buttonColor).setOnClickListener(okListner);


        btnOk = findViewById(R.id.button);
        initLanguage();


    }

//    private final View.OnClickListener okListner = new View.OnClickListener() {
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.buttonColor:
//                    Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
//            }
//
//        }
//    };



    void initLanguage(){
        languagesSp = (Spinner)findViewById(R.id.languagesSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languagesSp.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                switch (item){
                    case "Russian" :
                        locale = new Locale("ru");
                        break;
                    case "English" :
                        locale = new Locale("en");
                        break;
                    case "German":
                        locale = new Locale("de");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        languagesSp.setOnItemSelectedListener(itemSelectedListener);

        themeSp =(Spinner) findViewById(R.id.colorSpinner);
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this,R.array.themes, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSp.setAdapter(adapterColor);

        AdapterView.OnItemSelectedListener changeColorSelcetedListner = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                switch (item){
                    case "Green": changedTheme = Utils.changeThemeSpinner(Utils.THEME_GREEN);
                        break;
                    case "Black": changedTheme = Utils.changeThemeSpinner(Utils.THEME_BLACK);
                        break;
                    case "Blue": changedTheme = Utils.changeThemeSpinner(Utils.THEME_BLUE);
                        break;
//                    case "Blue": Utils.changeToTheme(MainActivity.this ,Utils.THEME_BLUE);
//                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        //themeSp.setOnItemClickListener((AdapterView.OnItemClickListener) changeColorSelcetedListner);
        themeSp.setOnItemSelectedListener(changeColorSelcetedListner);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration configuration = new Configuration();
                configuration.setLocale(locale);
                getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

                if (v.getId() == R.id.buttonColor) {
                    Utils.changeToTheme(MainActivity.this, changedTheme);
                }

                recreate();
            }
        });


    }


}
