package androidtraining.com.keralaplaces;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        checkConnection();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent gotomainActivity = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(gotomainActivity);

            }
        },5000);

    }

    public void checkConnection() {

        if(isOnline()){
            Toast.makeText(this, "internet connected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "need internet connect", Toast.LENGTH_SHORT).show();
        }

    }

    protected boolean isOnline() {

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }

    }
}
