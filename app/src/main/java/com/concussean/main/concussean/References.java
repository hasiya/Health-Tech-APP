package com.concussean.main.concussean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Vibrator;
import android.widget.TextView;


public class References extends ActionBarActivity {

    Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);
        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        TextView ref_1 = (TextView)findViewById(R.id.ref_1);
        ref_1.setText(Html.fromHtml(
                "&#8226; Scottish Intercollegiate Guidelines Network, 110 Early Management of Patients with a Head Injury, " +
                        "<a href=\"http://www.sign.ac.uk/pdf/sign110.pdf\">http://www.sign.ac.uk/pdf/sign110.pdf</a><br/>"));
        ref_1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref_2 = (TextView)findViewById(R.id.ref_2);
        ref_2.setText(Html.fromHtml(
                "&#8226; Harmon KG, Drezner JA, Gammons M, et al. American Medical Society for Sports Medicine " +
                        "position statement: concussion in sport, Br J Sports Med 2013,47, 15–26<br/> " +
                        "<a href=\"http://bjsm.bmj.com/content/47/1/15.full\">http://bjsm.bmj.com/content/47/1/15.full</a><br/>"));
        ref_2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref_3 = (TextView)findViewById(R.id.ref_3);
        ref_3.setText(Html.fromHtml(
                "&#8226; McCrory P, Meeuwisse WH, Aubry M,et al. Consensus statement on concussion in sport: the 4th International " +
                        "Conference on Concussion in Sport held in Zurich, November 2012, Br J Sports Med 2013;47:250–258. <br/> " +
                        "<a href=\"http://bjsm.bmj.com/content/47/5/250.full\">http://bjsm.bmj.com/content/47/5/250.full</a><br/>"));
        ref_3.setMovementMethod(LinkMovementMethod.getInstance());
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
            startActivity((new Intent(References.this, MainActivity.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(References.this, Help.class)));
        }
        if(id == R.id.action_about)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(References.this, About.class)));
        }
        return super.onOptionsItemSelected(item);
    }
}
