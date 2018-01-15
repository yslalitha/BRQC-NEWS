package com.brqc.app.jnj.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.activity.BRQCChoosePreferenceActivity;
import com.brqc.app.jnj.constants.BRQCConstants;
import com.brqc.app.jnj.utils.BRQCPreferences;

/**
 * Created by ajay on 1/9/2018.
 */

public class BRQCLoginFragment extends Fragment {


    private EditText userNameET;
    private EditText passwordET;
    private Button submitBTN;


    private String userName;
    private String password;


    public static Fragment newInstance(Context context) {
        BRQCLoginFragment mBRQCLoginFragment = new BRQCLoginFragment();
        return mBRQCLoginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_screen, null);

        SharedPreferences prefs = getContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        prefs.edit().clear().commit();
        userNameET = root.findViewById(R.id.login_username);
        passwordET = root.findViewById(R.id.login_password);
        submitBTN = root.findViewById(R.id.login_button);
        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform dummy login
                userName = userNameET.getText().toString();
                password = passwordET.getText().toString();


                SharedPreferences mSharedPreferences = BRQCPreferences.getMySharedPreferencesInstance(getContext());
              //  if (userName != null && !userName.isEmpty() && mSharedPreferences.getString(BRQCConstants.USERNAME, "AJAY").contains("AJAY")

               //         && password != null && !password.isEmpty() && mSharedPreferences.getString(BRQCConstants.PASSWORD, "AJAY").contains("AJAY")) {
                    // Start New Journey Activity
                    Toast.makeText(getContext(), "valid credentials !!!!", Toast.LENGTH_LONG).show();

                    Intent mIntent = new Intent(getActivity(), BRQCChoosePreferenceActivity.class);
                    startActivity(mIntent);

              //  } else {
                    Toast.makeText(getContext(), "Please enter valid credentials !!!!", Toast.LENGTH_LONG).show();
              //  }
            }
        });
        return root;
    }


}
