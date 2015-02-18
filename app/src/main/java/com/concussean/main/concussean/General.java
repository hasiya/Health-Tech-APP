package com.concussean.main.concussean;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class General extends ActionBarActivity {

    Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        TextView general = (TextView)findViewById(R.id.gen_advice);
        general.setText(Html.fromHtml(
                "<br/>" +
                        "<b>General advice</b><br/><br/>" +
                        "If any of the following symptoms do happen, you should return to your doctor or telephone NHS 24 for advice.<br/><br/>" +
                        "<b>Important symptoms to look out for:</b><br/><br/>" +
                        "•  Severe headache which is not helped by pain-killers such as paracetamol<br/>" +
                        "•  Vomiting (being sick) <br/>" +
                        "•  Confusion (not knowing where you are, getting things muddled up)<br/>" +
                        "•  Drowsiness (feeling very sleepy all the time)<br/>" +
                        "•  A fit (collapsing and feeling a bit out of touch afterwards) passing out suddenly <br/>" +
                        " •  Fluid coming out of your ear or nose<br/>" +
                        "•  Not seeing as well as usual.<br/>" +
                        "<br/>" +
                        "<b>Other symptoms</b><br/><br/>" +
                        "People who have had a head injury sometimes have other symptoms. " +
                        "You may feel a slight headache, dizziness, memory problems, poor concentration, " +
                        "irritability (being easily annoyed), tiredness, or poor sleep. " +
                        "These symptoms usually clear up after two weeks or so without any treatment, " +
                        "<b>so do not worry about them.</b><br/><br/>" +
                        "<b>But if these symptoms do not clear up after two weeks, you must go and see your own doctor.</b><br/>" +
                        "<b>Some extra advice to help you get well:</b><br>" +
                        "Following this advice will help you to recover from your head injury more quickly, and it may stop any symptoms from happening.<br><br>" +
                        "•  DO have plenty of rest and avoid stressful and noisy situations.<br/>" +
                        "•  DO NOT take any alcohol.<br/>" +
                        "•  DO NOT take sleeping pills, sedatives or tranquillisers. If in doubt contact your GP.<br/>" +
                        "•  DO NOT play any contact sport (eg football or squash) for at least three weeks without talking to your doctor first. <br/>" +
                        "<br/>"));
        general.setTextSize(16);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general, menu);
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
            startActivity((new Intent(General.this, MainActivity.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(General.this, Help.class)));
        }
        if(id == R.id.action_about)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(General.this, About.class)));
        }
        return super.onOptionsItemSelected(item);
    }
}
