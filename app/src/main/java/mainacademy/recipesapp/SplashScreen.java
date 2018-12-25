package mainacademy.recipesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// this is not a timed delay splash screen
// this one simply loads a temporary background and launches the MainActivity

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);
        // close this activity
        finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.gc();
    }
}