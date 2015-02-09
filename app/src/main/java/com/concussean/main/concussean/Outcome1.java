package com.concussean.main.concussean;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Outcome1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome1);

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
            finish();
            System.exit(0);
        }
        if(id == R.id.action_about)
        {
            finish();
            startActivity((new Intent(Outcome1.this, About.class)));
        }

        if(id == R.id.action_help)
        {
            finish();
            startActivity((new Intent(Outcome1.this, Help.class)));
        }

        if(id == R.id.action_home)
        {
            finish();
            startActivity((new Intent(Outcome1.this, MainActivity.class)));
        }

        if(id == R.id.action_restart)
        {
            finish();
            //startActivity((new Intent(Outcome1.this, Diagnose.class)));
            Intent i = new Intent(Outcome1.this, Diagnose.class);
            i.putExtra("qNo", 0);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


}
