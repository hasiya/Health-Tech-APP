package com.concussean.main.concussean;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Vibrator;


public class Diagnose extends ActionBarActivity {

    Vibrator vib;
    String[] questions;
    int size = 20; //number of questions
    int questionNo = 0;
    String textSize = "";
    int prevQ = 0;
    Boolean isBack = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);

        String small = "S";
        String medium = "M";
        String large = "L";

        textSize = getIntent().getExtras().getString("textSize");

        TextView t = (TextView) findViewById(R.id.question_txt);

        Button small_btn = (Button)findViewById(R.id.font_small_btn);
        Button medium_btn = (Button)findViewById(R.id.font_medium_btn);
        Button large_btn = (Button)findViewById(R.id.font_large_btn);

        if(textSize == null){
            textSize = "M";
            medium_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
        }
        else if(textSize.equals(small)){
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            small_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
        }
        else if (textSize.equals(medium)){
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
            medium_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
        }
        else if(textSize.equals(large)){
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
            large_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
        }


        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);



        questionNo = getIntent().getExtras().getInt("qNo");

        if(questionNo == 0){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }else{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        /*if (questionNo == 0){
            Button b = (Button)findViewById(R.id.back_btn);
            b.setVisibility(View.INVISIBLE);
        }
*/
        if (questionNo == 12){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                int prev = extras.getInt("prev");
                if (prev != 0) {
                    prevQ = extras.getInt("prev");
                }
            }
        }

        questions = new String[size];
        questions[0] = "Since the incident, have they lost consciousness at any time?";
        questions[1] = "Do they have any difficulty speaking, reading or understanding what you're saying?";
        questions[2] = "Have they lost feeling or control of any part of their body?";
        questions[3] = "Do they have difficulty balancing?";
        questions[4] = "Do they have weakness in any of their limbs?";
        questions[5] = "Do they have any changes to their sight?";
        questions[6] = "Do they have any fluid or blood coming from inside their ear?";
        questions[7] = "Do they have any fluid coming from inside their nose?";
        questions[8] = "Have they lost hearing in one or both ears?";
        questions[9] = "Have they any bruising behind one or both ears?";
        questions[10] = "Do they have a black eye?";
        questions[11] = "Did they suffer trauma directly to the affected eye?";
        questions[12] = "Do they have a headache?";
        questions[13] = "Do they have neck pain?";
        questions[14] = "Are they dizzy?";
        questions[15] = "Have they vomited or feel like they will vomit?";
        questions[16] = "Do they feel confused?";
        questions[17] = "Do they feel unusually tired or low on energy?";
        questions[18] = "Are they abnormally emotional or irritable?";
        questions[19] = "Are they experiencing a 'fogginess' to their thoughts?";


        t.setText(questions[questionNo]);

        isBack = getIntent().getExtras().getBoolean("isBack");

        if(isBack == null){

        }

        else if(isBack == true){
            overridePendingTransition( R.anim.slide_in_copy, R.anim.slide_out_copy);

        }
        else{
            overridePendingTransition( R.anim.slide_in, R.anim.slide_out);
        }


        Button yesBtn = (Button) findViewById((R.id.yes_btn));
        Button noBtn = (Button) findViewById((R.id.no_btn));
        setOnClick(t, yesBtn, 1);
        setOnClick(t, noBtn, 2);
    }
    private void setOnClick(final TextView t, final Button btn, final int choice) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBack = false;
                vib.vibrate(50);
                if (questionNo != 10 && questionNo != 11 && questionNo != 19)
                {
                    if (choice == 1)
                    {
                        //go to Outcome 1 or 2
                        if (questionNo <= 9)
                        {
                            //go to Outcome 1
                             finish();
                            //startActivity((new Intent(Diagnose.this, Outcome1.class)));
                            Intent i = new Intent(Diagnose.this, Outcome1.class);
                            i.putExtra("prev", questionNo);
                            i.putExtra("textSize", textSize);
                            startActivity(i);
                        }
                        else
                        {
                            //go to Outcome 2
                            finish();
                            //startActivity((new Intent(Diagnose.this, Outcome2.class)));
                            Intent i = new Intent(Diagnose.this, Outcome2.class);
                            i.putExtra("prev", questionNo);
                            i.putExtra("textSize", textSize);
                            startActivity(i);
                        }
                    }
                    else
                    {
                        //questionNo ++;
                        //t.setText(questions[questionNo]);
                        //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        finish();
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", questionNo+1);
                        i.putExtra("textSize", textSize);

                        startActivity(i);
                    }

                }
                else if (questionNo == 10)
                {
                    if (choice == 1)
                    {
                        //questionNo ++;
                        //t.setText(questions[questionNo]);
                        finish();
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", questionNo+1);
                        i.putExtra("textSize", textSize);

                        startActivity(i);
                    }
                    else
                    {
                        //questionNo = 12;
                        //t.setText(questions[questionNo]);
                        finish();
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", 12);
                        i.putExtra("prev", 10);
                        i.putExtra("textSize", textSize);

                        startActivity(i);
                    }
                }
                else if (questionNo == 11)
                {
                    if (choice == 1)
                    {
                        //questionNo ++;
                        //t.setText(questions[questionNo]);
                        finish();
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", questionNo+1);
                        i.putExtra("prev", 11);
                        i.putExtra("textSize", textSize);

                        startActivity(i);
                    }
                    else
                    {
                        //go to Outcome 1
                        finish();
                        //startActivity((new Intent(Diagnose.this, Outcome1.class)));
                        Intent i = new Intent(Diagnose.this, Outcome1.class);
                        i.putExtra("prev", questionNo);
                        i.putExtra("textSize", textSize);
                        startActivity(i);
                    }
                }
                else if (questionNo == 19)
                {
                    if (choice == 1)
                    {
                        //go to Outcome 2
                        finish();
                        //startActivity((new Intent(Diagnose.this, Outcome2.class)));
                        Intent i = new Intent(Diagnose.this, Outcome2.class);
                        i.putExtra("prev", questionNo);
                        i.putExtra("textSize", textSize);
                        startActivity(i);
                    }
                    else
                    {
                        //go to Outcome 3
                        finish();
                        //startActivity((new Intent(Diagnose.this, Outcome3.class)));
                        Intent i = new Intent(Diagnose.this, Outcome3.class);
                        i.putExtra("prev", questionNo);
                        i.putExtra("textSize", textSize);
                        startActivity(i);
                    }
                }
            }
        });

    /*Button back = (Button)findViewById(R.id.back_btn);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            vib.vibrate(50);
            Log.d("Previous Question:", " " + prevQ);
            if (questionNo != 12){
                overridePendingTransition( R.anim.slide_out, R.anim.slide_in);
                Intent i = new Intent(Diagnose.this, Diagnose.class);
                i.putExtra("qNo", questionNo-1);
              //  finish();
                startActivity(i);
            }
            else{
                if (prevQ != 0){
                    overridePendingTransition( R.anim.slide_out, R.anim.slide_in);
                    Intent i = new Intent(Diagnose.this, Diagnose.class);
                    i.putExtra("qNo", prevQ);
                  //  finish();
                    startActivity(i);
                }
                else{
                    overridePendingTransition( R.anim.slide_out, R.anim.slide_in);
                    Intent i = new Intent(Diagnose.this, Diagnose.class);
                    i.putExtra("qNo", questionNo-1);
                 //   finish();
                    startActivity(i);
                }
            }
        }
    });*/

        final Button small_btn = (Button)findViewById(R.id.font_small_btn);
        final Button medium_btn = (Button)findViewById(R.id.font_medium_btn);
        final Button large_btn = (Button)findViewById(R.id.font_large_btn);

        small_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                small_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
                medium_btn.setBackground(getResources().getDrawable(R.drawable.font_btn));
                large_btn.setBackground(getResources().getDrawable(R.drawable.font_btn));
                textSize = "S";
            }
        });


        medium_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                small_btn.setBackground(getResources().getDrawable(R.drawable.font_btn));
                medium_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
                large_btn.setBackground(getResources().getDrawable(R.drawable.font_btn));
                textSize = "M";
            }
        });

        large_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                small_btn.setBackground(getResources().getDrawable(R.drawable.font_btn));
                medium_btn.setBackground(getResources().getDrawable(R.drawable.font_btn));
                large_btn.setBackground(getResources().getDrawable(R.drawable.font_forcus));
                textSize = "L";
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_diagnose, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
        }

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
            startActivity((new Intent(Diagnose.this, About.class)));
        }

        if(id == R.id.action_help)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Diagnose.this, Help.class)));
        }

        if(id == R.id.action_home)
        {
            vib.vibrate(50);
            finish();
            startActivity((new Intent(Diagnose.this, MainActivity.class)));
        }

        if(id == R.id.action_restart)
        {
            vib.vibrate(50);
            finish();
            //startActivity((new Intent(Outcome1.this, Diagnose.class)));
            Intent i = new Intent(Diagnose.this, Diagnose.class);
            i.putExtra("qNo", 0);
            startActivity(i);
        }

        if(id == android.R.id.home){
            Log.d("Home Pressed","");
            vib.vibrate(50);
            Log.d("Previous Question:", " " + prevQ);
            isBack = true;
            if (questionNo != 12){
               // overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                finish();
                Intent i = new Intent(Diagnose.this, Diagnose.class);
                i.putExtra("qNo", questionNo-1);
                i.putExtra("textSize", textSize);
                i.putExtra("isBack", isBack);
                startActivity(i);
            }
            else{
                if (prevQ != 0){
                    //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    Intent i = new Intent(Diagnose.this, Diagnose.class);
                    i.putExtra("qNo", prevQ);
                    i.putExtra("textSize", textSize);
                    i.putExtra("isBack", isBack);
                    startActivity(i);
                }
                else{
                   // overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    Intent i = new Intent(Diagnose.this, Diagnose.class);
                    i.putExtra("qNo", questionNo-1);
                    i.putExtra("textSize", textSize);
                    i.putExtra("isBack", isBack);
                    startActivity(i);
                }
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
