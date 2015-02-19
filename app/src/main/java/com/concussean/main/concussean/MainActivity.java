package com.concussean.main.concussean;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Vibrator;
import android.app.ActionBar;



public class MainActivity extends ActionBarActivity {

    ActionBar actionBar;

    Vibrator vib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View root = this.getWindow().getDecorView();
        root.setBackgroundColor(Color.parseColor("#e4e4e4"));

        /*actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

       /* try {
            isBack = getIntent().getExtras().getBoolean("isBack");
        }
        catch (Exception e){
            Log.d(e.getMessage(), "");
        }
        if (isBack == null)
        {

        }
        else if (isBack == true) {
            overridePendingTransition(R.anim.slide_in_copy, R.anim.slide_out_copy);

        } else {
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }*/

        Button btn = (Button) findViewById((R.id.start_btn));
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                vib.vibrate(50);
                finish();
                //startActivity((new Intent(MainActivity.this, Diagnose.class)));
                Intent i = new Intent(MainActivity.this, Diagnose.class);
                i.putExtra("qNo", 0);
                startActivity(i);
            }
        });
        btn = (Button) findViewById((R.id.post_treatment_btn));
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                vib.vibrate(50);
                finish();
                //startActivity((new Intent(MainActivity.this, Diagnose.class)));
                Intent i = new Intent(MainActivity.this, Post.class);
                //i.putExtra("qNo", 0);
                startActivity(i);
            }
        });
        btn = (Button) findViewById((R.id.references_btn));
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                vib.vibrate(50);
                finish();
                //startActivity((new Intent(MainActivity.this, Diagnose.class)));
                Intent i = new Intent(MainActivity.this, References.class);
                //i.putExtra("qNo", 0);
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("Back Button Pressed: ", "");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit)
        {
            vib.vibrate(50);
            finish();
            System.exit(0);
        }

        if(id == R.id.action_about)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(MainActivity.this, About.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(MainActivity.this, Help.class)));
        }



        return super.onOptionsItemSelected(item);
    }




}
