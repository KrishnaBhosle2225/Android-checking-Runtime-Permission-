package com.krishna.checkruntimepermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.checkpermission);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            checkPermission(Manifest.permission.CAMERA,101);
            }
        });

    }

    public void checkPermission(String permission, int request)
    {
        if (ContextCompat.checkSelfPermission(this,permission)== PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this,new String[]{permission},request);
        }
        else {
            Toast.makeText(MainActivity.this,"Permission already Granted",Toast.LENGTH_LONG).show();
        }
    }
}