package com.concussean.main.concussean;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById((R.id.start_btn));
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
                //startActivity((new Intent(MainActivity.this, Diagnose.class)));
                Intent i = new Intent(MainActivity.this, Diagnose.class);
                i.putExtra("qNo", 0);
                startActivity(i);
            }
        });
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
            finish();
            System.exit(0);
        }

        if(id == R.id.action_about)
        {
            finish();
            startActivity((new Intent(MainActivity.this, About.class)));
        }

        if(id == R.id.action_help)
        {
            finish();
            startActivity((new Intent(MainActivity.this, Help.class)));
        }



        return super.onOptionsItemSelected(item);
    }




}
