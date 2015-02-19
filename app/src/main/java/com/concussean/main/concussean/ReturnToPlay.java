package com.concussean.main.concussean;

import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;


public class ReturnToPlay extends ActionBarActivity {

    Vibrator vib;
    Boolean isBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_to_play);

        View root = this.getWindow().getDecorView();
        root.setBackgroundColor(Color.parseColor("#e4e4e4"));


        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        WebView retrn = (WebView)findViewById(R.id.return_play);
        retrn.setBackgroundColor(0x00000000);
        String content = "<br/>" +
                "<b>Advice for gradual return to sport after a head injury</b><br/><br/>" +
                "<ul>" +
                "<li>You have sustained a concussion or minor head injury.</li>" +
                "<li>Before you return to sport full time it is important that you follow a " +
                "step-wise return to play protocol to allow you to return safely.</li>" +
                "<li>It is likely that you may experience a number of symptoms as a result " +
                "of your head injury, such as: mild headache, dizziness, memory problems, poor " +
                "concentration, irritability, tiredness, sleep disruption.</li>" +
                "<li>You must be sure that your symptoms have completely cleared at each " +
                "exercise level for at least 24 hours before you progress to the next level.</li>" +
                "<li>If symptoms develop at any exercise level then you should return to level one and have 24 hours rest.</li>" +
                "<li>Contact your GP if your symptoms are not improving.</li>" +
                "</ul>";

        retrn.loadDataWithBaseURL(null,content,"text/html", "utf-8", null);

    }

    public void onBackPressed() {
        //super.onBackPressed();
        Log.d("Back Button Pressed: ", "");
        isBack = true;
        vib.vibrate(50);
        finish();
        Intent i = new Intent(ReturnToPlay.this, Post.class);
        i.putExtra("isBack", isBack);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_return_to_play, menu);
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
            startActivity((new Intent(ReturnToPlay.this, MainActivity.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(ReturnToPlay.this, Help.class)));
        }
        if(id == R.id.action_about)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(ReturnToPlay.this, About.class)));
        }

        if(id == android.R.id.home){
            isBack = true;
            vib.vibrate(50);
            finish();
            Intent i = new Intent(ReturnToPlay.this, Post.class);
            i.putExtra("isBack", isBack);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
