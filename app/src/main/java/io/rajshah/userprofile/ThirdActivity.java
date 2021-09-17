package io.rajshah.userprofile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView textViewName,textViewEmail,textViewID,textViewDept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setActionBarConfig();
        textViewName=findViewById(R.id.textViewName);
        textViewEmail=findViewById(R.id.textViewEmail);
        textViewID=findViewById(R.id.textViewID);
        textViewDept=findViewById(R.id.textViewDept);

        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.USER_KEY)){
            User user = (User)getIntent().getSerializableExtra(MainActivity.USER_KEY);

            textViewName.setText(user.getName());
            textViewEmail.setText(user.getEmail());
            textViewID.setText(user.getId());
            textViewDept.setText(user.getDepartment());
        }
    }
    private void setActionBarConfig() {
        ActionBar aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#000000"));
        assert aBar != null;
        aBar.setBackgroundDrawable(cd);
        aBar.setTitle(R.string.Third_ActionBar);
    }
}