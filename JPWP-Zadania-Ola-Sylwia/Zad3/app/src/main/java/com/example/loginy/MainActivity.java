package com.example.loginy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDialog(View view) {

        //LayoutInflater inflater = getActivity().getLayoutInflater();
        //View vie = inflater.inflate(R.layout.okienko, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("LOGOWANIE");
        alert.setMessage("Zaloguj się:");



        alert.setPositiveButton("LOG IN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK-pomyślne logowanie", Toast.LENGTH_SHORT).show();

                //String login = loginTxt.getText().toString();
                //String password = passwordTxt.getText().toString();

                //if poprawne

                Intent intent = new Intent(MainActivity.this, WitajActivity.class);
                startActivity(intent);

                //else
            }
        });
        alert.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Wychodzimy w takim razie", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }


}
