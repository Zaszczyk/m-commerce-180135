package mateusz.lab01;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;


public class MainActivity extends FragmentActivity {

    final FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.simple);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new SimpleFragment();

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.test, fragment).addToBackStack("tag");
                transaction.commit();
            }
        });

        Button b2 = (Button) findViewById(R.id.advanced);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new AdvancedFragment();

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.test, fragment).addToBackStack("tag");
                transaction.commit();
            }
        });

        Button b3 = (Button) findViewById(R.id.about);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new AboutFragment();

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.test, fragment).addToBackStack("tag");
                transaction.commit();
            }
        });

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.exit(0);
            }
        });


    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        }
        else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
