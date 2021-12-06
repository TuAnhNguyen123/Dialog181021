package com.example.dialog181021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonAlertDialog, buttonCustomAlertDialog;
    int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAlertDialog       = findViewById(R.id.buttonShowAlertDialog);
        buttonCustomAlertDialog = findViewById(R.id.buttonCustomlertDialog);
        buttonAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPosition = -1;

                AlertDialog.Builder builer = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog_MinWidth);
                String[] arrColors = {"Black","Pink","Blue","Gray","Orange","Red"};
                builer.setTitle("Pick Color")
                .setIcon(android.R.drawable.star_on)
                .setSingleChoiceItems(arrColors, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPosition = i;
                    }
                });
                builer.setPositiveButton("Yes!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mPosition > -1){
                            Toast.makeText(MainActivity.this, arrColors[mPosition], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builer.setNegativeButton("No!!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "NO", Toast.LENGTH_SHORT).show();
                    }
                });
                builer.setCancelable(false);
                builer.show();
            }
        });
        buttonCustomAlertDialog.setOnClickListener(new View.OnClickListener() {
            //dialog_cofirm.xml
            @Override
            public void onClick(View view) {
                AppDialog.setDialogConfirm(MainActivity.this, new OnListenerConfirmDialog() {
                    @Override
                    public void onDelete() {
                        Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



//        buttonCustomAlertDialog.setOnClickListener(new View.OnClickListener() {
//        //dialog_confirm_b.xml
//            @Override
//            public void onClick(View view) {
//                AppDialogB.showCustomDialog_b(MainActivity.this, new OnListenerCofirmDialogB() {
//                    @Override
//                    public void onDone() {
//                        Toast.makeText(MainActivity.this, "Done!!", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        Toast.makeText(MainActivity.this, "Cancel!!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//
//        });
    }
}