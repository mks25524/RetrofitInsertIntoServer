package com.example.mks.retrofitinsertintoserver;

import android.app.ProgressDialog;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    //declare views
    private EditText etName;
    private EditText etUsername;
    private EditText etSid;
    private EditText etEmail;
    private EditText etpassword;
    private EditText etBatch;


    private Button btSignup;


    //root for real device
    public static final String ROOT_URL="http://192.168.0.105:80/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize view

        etName= (EditText) findViewById(R.id.nameEt);
        etUsername= (EditText) findViewById(R.id.usernameEt);
        etSid= (EditText) findViewById(R.id.sidEt);
        etEmail= (EditText) findViewById(R.id.emailEt);
        etpassword= (EditText) findViewById(R.id.passwordEt);
        etBatch= (EditText) findViewById(R.id.batchEt);
        btSignup= (Button) findViewById(R.id.signupBt);


        //adding listener
        btSignup.setOnClickListener(this);

        //creating a method to fetch data
       // getStudentInfo();




    }






    @Override
    public void onClick(View v) {
        //calling insertuser on button click
        insertUser();
    }
    private void insertUser(){
        // creating a RestAdapter
        RestAdapter adapter=new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)// root setup
                .build();// adapter building cmplete

        //interface object create
        SignupAPI signupAPI=adapter.create(SignupAPI.class);

        signupAPI.insertUser(
                etName.getText().toString(),
                etUsername.getText().toString(),
                etSid.getText().toString(),
                etEmail.getText().toString(),
                etpassword.getText().toString(),
                etBatch.getText().toString(),
                // annonymous callback creations
                new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        // read server by success & show output using bufferReader
                        //bufferreader creation
                        BufferedReader reader=null;
                        String output="";
                        try{
                            //initialize bufferReader
                            reader=new BufferedReader(new InputStreamReader(response.getBody().in()));
                            output=reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this,output,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                }
        );

    }
}
