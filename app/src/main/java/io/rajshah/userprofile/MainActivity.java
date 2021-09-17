package io.rajshah.userprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 100;
    EditText editText_Name,editText_ID,editText_Email;
    TextView recivedDept;
    final public static String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarConfig();
        editText_Name=findViewById(R.id.editText_Name);
        editText_ID=findViewById(R.id.editText_ID);
        editText_Email=findViewById(R.id.editText_Email);
        recivedDept=findViewById(R.id.recivedDept);
    }
    /*
        Sets ActionBar Color to Black For Activity and Title
     */
    private void setActionBarConfig() {
        ActionBar aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#000000"));
        assert aBar != null;
        aBar.setBackgroundDrawable(cd);
        aBar.setTitle(R.string.Main_ActionBar);
    }

    public void submitData(View view){
        if (editText_Name.getText().toString() == null || editText_Name.getText().toString().length() == 0){
            Toast.makeText(MainActivity.this, "Please Enter Proper Name", Toast.LENGTH_SHORT).show();
        }
        else if (editText_Email.getText().toString() == null || editText_Email.getText().toString().length() == 0){
            Toast.makeText(MainActivity.this, "Please Enter Proper Email", Toast.LENGTH_SHORT).show();
        }else if(editText_ID.getText().toString() == null || editText_ID.getText().toString().length() == 0){
            Toast.makeText(MainActivity.this, "Please Enter Proper ID", Toast.LENGTH_SHORT).show();
        }else if (recivedDept.getText().toString() == null || recivedDept.getText().toString().length() == 0){
            Toast.makeText(MainActivity.this, "Please Select Proper Dept", Toast.LENGTH_SHORT).show();
        }
        else{
            User user = new User(editText_Name.getText().toString(),editText_Email.getText().toString(),editText_ID.getText().toString(), recivedDept.getText().toString());
            Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
            intent.putExtra(USER_KEY,user);
            startActivity(intent);
        }
    }

    public void departmentSelect(View view){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivityForResult(intent,REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){
            if(resultCode==RESULT_OK && data != null && data.hasExtra(MainActivity2.ENTERED_DATA)){
                recivedDept.setText(""+data.getStringExtra(MainActivity2.ENTERED_DATA));
            }
            else if (resultCode==RESULT_CANCELED || resultCode== MainActivity2.Activity_Cancel){
                recivedDept.setText("");
                Toast.makeText(this, "Department Selection Was Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}