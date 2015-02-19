package com.concussean.main.concussean;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;


public class Post extends ActionBarActivity {

    Vibrator vib;
    Boolean isBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        View root = this.getWindow().getDecorView();
        root.setBackgroundColor(Color.parseColor("#e4e4e4"));

        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button gen_btn = (Button) findViewById((R.id.genrl_advice));
        gen_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                vib.vibrate(50);
                finish();
                //startActivity((new Intent(MainActivity.this, Diagnose.class)));
                Intent i = new Intent(Post.this, General.class);

                startActivity(i);
            }
        });

        Button retrn_btn = (Button)findViewById(R.id.retrn_play);
        retrn_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                vib.vibrate(50);
                finish();
                //startActivity((new Intent(MainActivity.this, Diagnose.class)));
                Intent i = new Intent(Post.this, ReturnToPlay.class);

                startActivity(i);
            }
        });

        try {
            isBack = getIntent().getExtras().getBoolean("isBack");
        }
        catch (Exception e){
            Log.d(e.getMessage(), "");
        }
        if (isBack == null)
        {

        }
        else if (isBack == false) {
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        }
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Log.d("Back Button Pressed: ", "");
        isBack = true;
        vib.vibrate(50);
        finish();
        Intent i = new Intent(Post.this, MainActivity.class);
        i.putExtra("isBack", isBack);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_ref, menu);
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
        if(id == R.id.action_home)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Post.this, MainActivity.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Post.this, Help.class)));
        }
        if(id == R.id.action_about)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Post.this, About.class)));
        }
        if (id == android.R.id.home){
            isBack = true;
            vib.vibrate(50);
            finish();
            Intent i = new Intent(Post.this, MainActivity.class);
            i.putExtra("isBack", isBack);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
