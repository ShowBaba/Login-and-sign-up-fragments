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

import java.util.zip.Inflater;

public class FragmentLogin extends Fragment {

    Button btnLogin, btnSignup;
    EditText username, passweord;
    CallBackFragment callBackFragment;
    String userName, pass;
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
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        username = view.findViewById(R.id.username);
        passweord = view.findViewById(R.id.password);

        btnLogin = view.findViewById(R.id.login_btn);
        btnSignup = view.findViewById(R.id.signup_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = username.getText().toString();
                pass = passweord.getText().toString();

                String uNmae, uPass;
                uNmae = sharedPreferences.getString("username", null);
                uPass = sharedPreferences.getString("pass", null);

                if (userName.equals(uNmae) && pass.equals(uPass)){
                    Toast.makeText(getContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBackFragment != null){
                    callBackFragment.changeFragment();
                }

            }
        });

        return view;
    }

    public void setCallBackFragment(CallBackFragment callBackFragment){
        this.callBackFragment = callBackFragment;
    }
}
