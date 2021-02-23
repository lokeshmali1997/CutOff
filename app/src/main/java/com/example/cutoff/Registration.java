package com.example.cutoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cutoff.models.ApiResponse;
import com.example.cutoff.retrofitutil.ApiClient;
import com.example.cutoff.retrofitutil.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
    private  EditText username, useremail, userpassword, usermobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView textviewlogin = findViewById(R.id.textviewLogin);
        username = findViewById(R.id.name);
        useremail = findViewById(R.id.email);
        userpassword = findViewById(R.id.password);
        usermobile  = findViewById(R.id.mobnumber);
        Button   register   = findViewById(R.id.register_button);

        textviewlogin.setOnClickListener(view -> startActivity(new Intent(Registration.this,Login.class)));

                register.setOnClickListener(view -> {
                    if (!validateName() | !validateEmail() | !validateMobile() | !validatePassword())
                    {
                        return;
                    }
                    String username1 = username.getText().toString();
                    String useremail1 = useremail.getText().toString();
                    String userpass1 = userpassword.getText().toString();
                    String usernum1 = usermobile.getText().toString();
                    Call<ApiResponse> call = ApiClient.getApiClient()
                            .create(ApiInterface.class)
                            .performUserSignIn(username1, useremail1, userpass1, usernum1);
                            call.enqueue(new Callback<ApiResponse>() {
                                @Override
                                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                                    if (response.body().getSuccess().equals("true")) {
                                        Toast.makeText(Registration.this, "Success", Toast.LENGTH_SHORT).show();
                                        userpassword.setText("");
                                        username.setText("");
                                        useremail.setText("");
                                        usermobile.setText("");
                                    } else if (response.body().getSuccess().equals("false")) {
                                        Toast.makeText(Registration.this, "It seems you have already registered !!!", Toast.LENGTH_SHORT).show();
                                        userpassword.setText("");
                                        username.setText("");
                                        useremail.setText("");
                                        usermobile.setText("");
                                    }
                                }
                                @Override
                                public void onFailure(Call<ApiResponse> call, Throwable t) {

                                }
                            });
                });
    }

    private boolean validateName()
    {
        String val = username.getText().toString().trim();

        if (val.isEmpty())
        {
            username.setError("Field can not Empty!!!");
            return false;
        }
        else
        {
            username.setError(null);
            username.setEnabled(true);
            return true;
        }
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

    private boolean validateMobile()
    {
        String val = usermobile.getText().toString().trim();
        String checkPhoneNumber = "[0-9]{10}";

        if (val.isEmpty())
        {
            usermobile.setError("Field can not Empty!!!");
            return false;
        }
        else if (!val.matches(checkPhoneNumber))
        {
            usermobile.setError("Enter Valid Phone Number!!");
            return false;
        }
        else
        {
            usermobile.setError(null);
            usermobile.setEnabled(true);
            return true;
        }
    }

}