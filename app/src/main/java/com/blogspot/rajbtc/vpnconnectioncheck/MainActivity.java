package com.blogspot.rajbtc.vpnconnectioncheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);



        Context context=getApplicationContext();
        ConnectivityManager cManager=(ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
     //   if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            Network activeNet=cManager.getActiveNetwork();
            NetworkCapabilities netCaps=cManager.getNetworkCapabilities(activeNet);
            boolean vpnConnection=netCaps.hasTransport(NetworkCapabilities.TRANSPORT_VPN);

            if(vpnConnection){
                Toast.makeText(getApplicationContext(),"Vpn  connected",Toast.LENGTH_SHORT).show();
                textView.setText("Connected!");
            }

            else{
                textView.setText("Not Connected!");
                Toast.makeText(getApplicationContext(),"Vpn not connected",Toast.LENGTH_SHORT).show();
            }



//        }else{
//
//        }Toast.makeText(getApplicationContext(),"Old Version",Toast.LENGTH_SHORT).show();

    }

}