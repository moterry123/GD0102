package com.tqc.gdd01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class GDD01_child extends Activity
 {
 Bundle bundle;
 Intent intent;
 /** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        intent=this.getIntent();
        bundle = intent.getExtras();

        String Sex = bundle.getString("Sex");
        double height = bundle.getDouble("height");
        double weight = bundle.getDouble("weight");

        String BMI_result = this.getBMI(height,weight);
        String BMI_advice = this.getAdvice(Sex,height,weight);

        TextView tvBMI=(TextView) findViewById(R.id.tvBMI);
        tvBMI.setText(BMI_result);
        TextView tvAdvice=(TextView) findViewById(R.id.tvAdvice);
        tvAdvice.setText(BMI_advice);

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
public void onClick(View v)
        {
        GDD01_child.this.finish();
        }
        });
        }

//BMI值格式化
private String format(double num)
        {
        // TO DO
                DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return decimalFormat.format(num);

        }

//取得BMI值
private String getBMI (double height, double weight)
        {
        // TO DO
        double bmi  = weight / (height * height);
        format(bmi);
        return getResources().getString(R.string.report_result)+format(bmi);
        }

//依BMI值取得建議
private String getAdvice (String Sex, double height, double weight)
        {
        // TO DO
                double bmi  = weight / (height * height);
                String s =" ";
                if (Sex.equals("M")){
                        if (bmi<20){
                                s = getResources().getString(R.string.advice_light);
                        } else if (bmi>25){
                                s = getResources().getString(R.string.advice_heavy);
                        } else {
                                s = getResources().getString(R.string.advice_average);
                        }

                } else {
                        if (bmi<18){
                                s = getResources().getString(R.string.advice_light);
                        } else if (bmi>22){
                                s = getResources().getString(R.string.advice_heavy);
                        } else {
                                s = getResources().getString(R.string.advice_average);
                        }

                }

        return s;
        }
        }
