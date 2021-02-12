package com.example.cutoff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cutoff.models.ApiResponse;
import com.example.cutoff.retrofitutil.ApiClient;
import com.example.cutoff.retrofitutil.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationFragment extends Fragment {
   // private View v;
    //private EditText username, useremail, userpassword,usermobile;
    //private Button register;

    //private static final String REGISTER_URL = "http://192.168.29.118/Api/insertion.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_registration, container, false);
        EditText username = v.findViewById(R.id.name);
        EditText useremail = v.findViewById(R.id.email);
        EditText userpassword = v.findViewById(R.id.password);
        EditText usermobile  = v.findViewById(R.id.mobnumber);
        Button register   = v.findViewById(R.id.register_button);
        TextView backlogin = v.findViewById(R.id.textviewLogin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username1 = username.getText().toString();
                String useremail1 = useremail.getText().toString();
                String userpass1 = userpassword.getText().toString();
                String usernum1 = usermobile.getText().toString();
                Call<ApiResponse> call = ApiClient.getApiClient().create(ApiInterface.class).performUserSignIn(username1, useremail1, userpass1, usernum1);

                call.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                            if (response.body().getSuccess().equals("true")) {
                                Toast.makeText(getActivity(), "Success ", Toast.LENGTH_SHORT).show();
                                userpassword.setText("");
                                username.setText("");
                                useremail.setText("");
                                usermobile.setText("");
                            } else if (response.body().getSuccess().equals("false")) {
                                Toast.makeText(getActivity(), "It seems you have already registered, Choose different Phone Number and Email ", Toast.LENGTH_SHORT).show();
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
                view.setVisibility(View.VISIBLE);

            }

            private void displayUserInfo(String message) {
                userpassword.setText("");
                v.setVisibility(View.VISIBLE);
            }
        });



        backlogin.setOnClickListener(view -> {
            FragmentManager fr = getFragmentManager();
            FragmentTransaction ft = fr.beginTransaction();
            ft.replace(R.id.maincontainer,new LoginFragment());
            ft.commit();
        });

        return v;
    }




}








/*
 Call<ApiResponse> call = ApiClient.getApiClient().create(ApiInterface.class).performUserSignIn(username1,useremail1,userpass1,usernum1);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.code()==200)
                {
                    if (response.body().getSuccess().equals("OK"))
                    {
                        if (response.body().getResult_code()==1)
                        {
                            Toast.makeText(getActivity(), "you can ", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            displayUserInfo("something went wrong");
                            userpass.setText("");
                        }

                    }
                    else
                    {
                        displayUserInfo("something went wrong");
                        userpass.setText("");
                    }

                }
                else
                {
                    displayUserInfo("something went wrong");
                    userpass.setText("");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
 */


/*
 private void displayUserInfo(String message) {
        userpass.setText("");
        v.setVisibility(View.VISIBLE);
    }
 */
























/*
  private void performregister(){
        String username1 = username.getText().toString();
        String useremail1 = useremail.getText().toString();
        String userpass1 = userpass.getText().toString();
        String usernum1 = usernum.getText().toString();
        register(username1,useremail1,userpass1,usernum1);

    }

    private void register(String username1, String useremail1, String userpass1, String usernum1)
    {
        String urlSuffix = "?username=" + username1 + "&useremail=" + useremail1 + "&userpass1=" + userpass1 + "&usernum=" + usernum1;
        class RegisterUser extends AsyncTask<String,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                loading = ProgressDialog.show(getActivity(),"please wait", null,true,true);
            }

            @Override
            protected void onPostExecute(String s)
            {
                super.onPostExecute(s);
                Toast.makeText(getActivity(), "No internet", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferedReader=null;
                try
                {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    bufferedReader = new BufferedReader (new InputStreamReader(conn.getInputStream()));
                    String result;

                }catch (Exception e)
                {
                    return null;
                }
                return null;
            }
        }
    }
 */