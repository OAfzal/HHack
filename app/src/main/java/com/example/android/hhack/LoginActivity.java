package com.example.android.hhack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private final String USER_NAME = "ADMIN";
    private final String PASSWORD = "ADMIN";
    private Boolean isCorrect = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        final Toast toast= Toast.makeText(getApplicationContext(),"Wrong Credentials, Please renter!",Toast.LENGTH_SHORT);

        final EditText login_id = (EditText)findViewById(R.id.login_id);

        final EditText password = (EditText)findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login_id.getText().equals(USER_NAME) == false  || password.getText().equals(PASSWORD) == false)
                    toast.show();
            }
        });
    }


}
