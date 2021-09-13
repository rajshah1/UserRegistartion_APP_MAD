package io.rajshah.userprofile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_Name,editText_ID,editText_Email;
    String userName,userEmail,userDept;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarConfig();
        editText_Name=findViewById(R.id.editText_Name);
        editText_ID=findViewById(R.id.editText_ID);
        editText_Email=findViewById(R.id.editText_Email);

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
        }/*else if (){

        }*/
        else{

        }
    }
}