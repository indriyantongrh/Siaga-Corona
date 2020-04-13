package com.PersonalLancer.project_covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.PersonalLancer.project_covid19.Api.BaseApiService;
import com.PersonalLancer.project_covid19.Api.UtilsApi;
import com.PersonalLancer.project_covid19.Model.ModelIndonesia.ResponseIndonesia;
import com.PersonalLancer.project_covid19.Model.ResponseResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL = 1 ;
    TextView tvSembuh, tvGugur, tvNegatif, tvTerkomfirmasi, lastUpdate;
    BaseApiService mApiService;
    ConnectivityManager conMgr;
    Button btnCall;
    ArrayList<ResponseIndonesia> responseIndonesiaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "Tidak ada akses Internet", Toast.LENGTH_LONG).show();

            }
        }


        tvGugur = findViewById(R.id.tvGugur);
        tvNegatif = findViewById(R.id.tvNegatif);
        tvSembuh = findViewById(R.id.tvSembuh);
        tvTerkomfirmasi = findViewById(R.id.tvTerkonfirmasi);
        lastUpdate = findViewById(R.id.lastUpdate);
        btnCall = findViewById(R.id.btnCall);

        mApiService = UtilsApi.getAPIService();
        // getData();
        getDataCovid();

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

    }


    private void getDataCovid() {

        mApiService.getDataIndonesia().enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                ///Toast.makeText(MainActivity.this, "Data "+response.body(), Toast.LENGTH_LONG).show();
                if (response.body() != null) {
                    ResponseResult responseResult = response.body();

                    int meninggal = responseResult.getDeaths().getValue();
                    int terkonfirmasi = responseResult.getConfirmed().getValue();
                    int sembuh = responseResult.getRecovered().getValue();
                    int negatif = responseResult.getActiveCare().getValue();
                    String LastUpdate = responseResult.getMetadata().getLastUpdatedAt();

                    tvTerkomfirmasi.setText(String.valueOf(terkonfirmasi));
                    tvNegatif.setText(String.valueOf(negatif));
                    tvGugur.setText(String.valueOf(meninggal));
                    tvSembuh.setText(String.valueOf(sembuh));
                    lastUpdate.setText("Update Terakhir : " + LastUpdate);
                    ///Toast.makeText(MainActivity.this, "Data "+meninggal, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Koneksi gagal ", Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {

            }
        });
    }


    public void call() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            PackageManager packageManager = getPackageManager();
            String phoneNumber = "081212123119";

            if (packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                //call phone
                Intent intent = new Intent(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel:" + phoneNumber)); // TODO: Consider calling
                startActivity(intent);
            }
        }






     /*   Intent intent = getIntent();
        if (intent.getData() != null) {
            Log.d("intent received", intent.getData().toString());
            String phoneNumber = intent.getData().toString(); //contains tel:phone_no
            phoneNumber = phoneNumber.substring(4);
            Log.d("intent received", "Received phone number : " + phoneNumber);
            /// do what you like here
        } else {
            Log.d("intent received", "null intent received");
        }*/
    }
}
