package com.example.tired.charpter3;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = (Button) findViewById(R.id.button);

        LayoutInflater inflater=SecondActivity.this.getLayoutInflater();
        View v= inflater.inflate(R.layout.alert_dialog,null,false);
        Context context=SecondActivity.this;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(v);
        final AlertDialog alertDialog=builder.create();
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alertDialog.show();
            }
        });

        v.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"CANCEL",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"SIGN IN",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}
