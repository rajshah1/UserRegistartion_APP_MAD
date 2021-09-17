package io.rajshah.userprofile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup radioGroup_Dept;
    RadioButton radioButton_CS,radioButton_DS,radioButton_Bio,radioButton_SIS;
    public static final int Activity_Cancel = 300;
    String selectedProgram;
    public static String ENTERED_DATA = "Entered_Data";
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

        radioGroup_Dept.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton_CS){
                    selectedProgram=radioButton_CS.getText().toString();
                }
                else if (i == R.id.radioButton_Bio){
                    selectedProgram=radioButton_Bio.getText().toString();
                }
                else if (i == R.id.radioButton_DS){
                    selectedProgram=radioButton_DS.getText().toString();
                }
                else if (i == R.id.radioButton_SIS){
                    selectedProgram=radioButton_SIS.getText().toString();
                }
            }
        });
    }
    private void setActionBarConfig() {
        ActionBar aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#000000"));
        assert aBar != null;
        aBar.setBackgroundDrawable(cd);
        aBar.setTitle(R.string.Second_ActionBar);
    }

    public void sendDataBack(View view){
        if (selectedProgram == null || selectedProgram.length() == 0) {
            Toast.makeText(MainActivity2.this, "Please Select One Department", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(ENTERED_DATA,selectedProgram);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
    public void closeActivity(View view){
        setResult(Activity_Cancel);
        finish();
    }
}