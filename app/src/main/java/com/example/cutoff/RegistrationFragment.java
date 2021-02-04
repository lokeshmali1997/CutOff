package com.example.cutoff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegistrationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_registration, container, false);
        EditText username = v.findViewById(R.id.name);
        EditText useremail = v.findViewById(R.id.email);
        EditText userpass = v.findViewById(R.id.password);
        EditText usernum  = v.findViewById(R.id.mobnumber);
        Button  register   = v.findViewById(R.id.register_button);
        TextView backlogin = v.findViewById(R.id.textviewLogin);

        backlogin.setOnClickListener(view -> {
            FragmentManager fr = getFragmentManager();
            FragmentTransaction ft = fr.beginTransaction();
            ft.replace(R.id.maincontainer,new LoginFragment());
            ft.commit();
        });

        return v;

    }
}