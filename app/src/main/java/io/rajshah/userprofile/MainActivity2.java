package io.rajshah.userprofile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup radioGroup_Dept;
    RadioButton radioButton_CS,radioButton_DS,radioButton_Bio,radioButton_SIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setActionBarConfig();
        radioGroup_Dept=findViewById(R.id.radioGroup_Dept);
        radioButton_CS=findViewById(R.id.radioButton_CS);
        radioButton_SIS=findViewById(R.id.radioButton_SIS);
        radioButton_Bio=findViewById(R.id.radioButton_Bio);
        radioButton_DS=findViewById(R.id.radioButton_DS);
    }
    private void setActionBarConfig() {
        ActionBar aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#000000"));
        assert aBar != null;
        aBar.setBackgroundDrawable(cd);
        aBar.setTitle(R.string.Second_ActionBar);
    }
}