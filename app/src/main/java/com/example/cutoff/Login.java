package com.example.cutoff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cutoff.models.ApiResponse;
import com.example.cutoff.retrofitutil.ApiInterface;
import com.example.cutoff.retrofitutil.ApiLoginClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText useremail, userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        useremail = findViewById(R.id.email);
        userpassword = findViewById(R.id.password);


        Button loginbutton = findViewById(R.id.login_button);
        TextView registation = findViewById(R.id.registration);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateEmail() | !validatePassword())
                {
                    return;
                }

                String useremail1 = useremail.getText().toString();
                String userpass1 = userpassword.getText().toString();
                Call<ApiResponse> call = ApiLoginClient.getApiLoginClient()
                        .create(ApiInterface.class)
                        .performUserLogin(useremail1, userpass1);
                call.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.body().getSuccess().equals("true")) {
                            Toast.makeText(Login.this, "Success", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Login.this,MainActivity.class));
                            userpassword.setText("");
                            useremail.setText("");
                        } else if (response.body().getSuccess().equals("false")) {
                            Toast.makeText(Login.this, "It's seems you have entered incorrect user details please try again!! ", Toast.LENGTH_LONG).show();
                            userpassword.setText("");
                            useremail.setText("");
                        }
                    }
                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {

                    }
                });
            }
        });

        registation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Login.this,Registration.class));
            }
        });

    }

    private boolean validateEmail()
    {
        String val = useremail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty())
        {
            useremail.setError("Field can not Empty!!!");
            return false;
        }
        else if (!val.matches(checkEmail))
        {
            useremail.setError("No WhiteSpace are allowed!!");
            return false;
        }
        else
        {
            useremail.setError(null);
            useremail.setEnabled(true);
            return true;
        }
    }

    private boolean validatePassword()
    {
        String val = userpassword.getText().toString().trim();
        String checkPassword = "[0-7]{8}";

        if (val.isEmpty())
        {
            userpassword.setError("Field can not Empty!!!");
            return false;
        }
        else if (userpassword.getText().toString().length() < 8)
        {
            userpassword.setError("Password cannot be more or less than 8!!");
            return false;
        }
        else
        {
            userpassword.setError(null);
            userpassword.setEnabled(true);
            return true;
        }
    }
}