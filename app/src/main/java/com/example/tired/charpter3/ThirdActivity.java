package com.example.tired.charpter3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private  TextView textID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textID = (TextView)findViewById(R.id.textView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,001,1,"字体大小");
        menu.add(1,002,2,"普通菜单项");
        menu.add(1,003,3,"字体颜色");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case 001:
                final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("设置字体大小");
                builder.setSingleChoiceItems(new String[]{"10号字体","16号字体","20号字体"},-1,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:textID.setTextSize(10);
                                dialogInterface.dismiss();
                                break;
                            case 1:textID.setTextSize(16);
                                dialogInterface.dismiss();
                                break;
                            case 2:textID.setTextSize(20);
                                dialogInterface.dismiss();
                                break;
                        }
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
                break;
            case 002:
                Toast.makeText(this,"你点击了普通菜单项", Toast.LENGTH_LONG).show();
                break;
            case 003:
                final AlertDialog.Builder builder2=new AlertDialog.Builder(this);
                builder2.setTitle("设置字体颜色");
                builder2.setSingleChoiceItems(new String[]{"红色","黑色"},-1,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:textID.setTextColor(Color.RED);
                                dialogInterface.dismiss();
                                break;
                            case 1:textID.setTextColor(Color.BLACK);
                                dialogInterface.dismiss();
                                break;
                        }
                    }
                });
                builder2.setNegativeButton("取消",null);
                builder2.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
