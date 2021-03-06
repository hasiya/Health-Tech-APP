package com.concussean.main.concussean;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;


public class Outcome1 extends ActionBarActivity {

    Vibrator vib;
    int prevQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome1);

        View root = this.getWindow().getDecorView();
        root.setBackgroundColor(Color.parseColor("#e4e4e4"));

        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        prevQ = getIntent().getExtras().getInt("prev");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button callBtn = (Button)findViewById(R.id.call_btn);
        callBtn.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View v){
                finish();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:999"));
                startActivity(callIntent);
            }
        });
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Log.d("Back Button Pressed: ", "");
        vib.vibrate(50);
        boolean isBack = true;
        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
        Intent i = new Intent(Outcome1.this, Diagnose.class);
        i.putExtra("qNo", prevQ);
        i.putExtra("isBack", isBack);
        finish();
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_outcome1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
            startActivity((new Intent(Outcome1.this, About.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Outcome1.this, Help.class)));
        }

        if(id == R.id.action_home)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Outcome1.this, MainActivity.class)));
        }

        if(id == R.id.action_restart)
        {
            vib.vibrate(50);
            finish();
            //startActivity((new Intent(Outcome1.this, Diagnose.class)));
            Intent i = new Intent(Outcome1.this, Diagnose.class);
            i.putExtra("qNo", 0);
            startActivity(i);
        }

        if(id == android.R.id.home) {
            Log.d("Home Pressed", "");
            vib.vibrate(50);
            boolean isBack = true;
            overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
            Intent i = new Intent(Outcome1.this, Diagnose.class);
            i.putExtra("qNo", prevQ);
            i.putExtra("isBack", isBack);
            finish();
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
