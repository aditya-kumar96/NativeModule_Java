package com.nativelogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText email,Password;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Make sure this XML file exists
        email = findViewById(R.id.edit_text_id);
        Password = findViewById(R.id.edit_password);
        submit = findViewById(R.id.edit_submit);


        submit.setOnClickListener(v -> {
            String emailId = email.getText().toString().trim();
            String password = Password.getText().toString().trim();
            Intent resultIntent = new Intent();

            if(emailId.equals("admin") && password.equals("123")){
                resultIntent.putExtra("result","Login Success");
                setResult(RESULT_OK, resultIntent);
            }else {
                resultIntent.putExtra("result", "Invalid Credentials");
                setResult(RESULT_OK, resultIntent);
            }
            finish();
        });




    }
}
