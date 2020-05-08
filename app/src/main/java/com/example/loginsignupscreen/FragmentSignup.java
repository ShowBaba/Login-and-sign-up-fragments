package com.example.loginsignupscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSignup extends Fragment {

    Button btnLogin, btnSignup;
    EditText username, password, email;
    String userName, emailE, pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences("userFile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_layout, container, false);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        email = view.findViewById(R.id.email);
        btnSignup = view.findViewById(R.id.signup_btn);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = username.getText().toString();
                pass = password.getText().toString();
                emailE = email.getText().toString();

                editor.putString("Username", userName);
                editor.putString("pass", pass);
                editor.putString("email", emailE);
                editor.apply();
                Toast.makeText(getContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
