package com.concussean.main.concussean;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Diagnose extends ActionBarActivity {

    String[] questions;
    int size = 20; //number of questions
    int questionNo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);



        TextView t = new TextView(this);

        questionNo = getIntent().getExtras().getInt("qNo");

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



        t = (TextView) findViewById(R.id.question_txt);
        t.setText(questions[questionNo]);
        Button yesBtn = (Button) findViewById((R.id.yes_btn));
        Button noBtn = (Button) findViewById((R.id.no_btn));
        setOnClick(t, yesBtn, 1);
        setOnClick(t, noBtn, 2);
    }
    private void setOnClick(final TextView t, final Button btn, final int choice) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNo != 10 && questionNo != 11 && questionNo != 19)
                {
                    if (choice == 1)
                    {
                        //go to Outcome 1 or 2
                        if (questionNo <= 9)
                        {
                            //go to Outcome 1
                            finish();
                            startActivity((new Intent(Diagnose.this, Outcome1.class)));
                        }
                        else
                        {
                            //go to Outcome 2
                            finish();
                            startActivity((new Intent(Diagnose.this, Outcome2.class)));
                        }
                    }
                    else
                    {
                        //questionNo ++;
                        //t.setText(questions[questionNo]);
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", questionNo+1);
                        finish();
                        startActivity(i);
                    }

                }
                else if (questionNo == 10)
                {
                    if (choice == 1)
                    {
                        //questionNo ++;
                        //t.setText(questions[questionNo]);
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", questionNo+1);
                        finish();
                        startActivity(i);
                    }
                    else
                    {
                        //questionNo = 12;
                        //t.setText(questions[questionNo]);
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", 12);
                        finish();
                        startActivity(i);
                    }
                }
                else if (questionNo == 11)
                {
                    if (choice == 1)
                    {
                        //questionNo ++;
                        //t.setText(questions[questionNo]);
                        Intent i = new Intent(Diagnose.this, Diagnose.class);
                        i.putExtra("qNo", questionNo+1);
                        finish();
                        startActivity(i);
                    }
                    else
                    {
                        //go to Outcome 1
                        finish();
                        startActivity((new Intent(Diagnose.this, Outcome1.class)));
                    }
                }
                else if (questionNo == 19)
                {
                    if (choice == 1)
                    {
                        //go to Outcome 2
                        finish();
                        startActivity((new Intent(Diagnose.this, Outcome2.class)));
                    }
                    else
                    {
                        //go to Outcome 3
                        finish();
                        startActivity((new Intent(Diagnose.this, Outcome3.class)));
                    }
                }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit)
        {
            finish();
            System.exit(0);
        }
        if(id == R.id.action_about)
        {
            finish();
            startActivity((new Intent(Diagnose.this, About.class)));
        }

        if(id == R.id.action_help)
        {
            finish();
            startActivity((new Intent(Diagnose.this, Help.class)));
        }

        if(id == R.id.action_home)
        {
            finish();
            startActivity((new Intent(Diagnose.this, MainActivity.class)));
        }

        if(id == R.id.action_restart)
        {
            finish();
            //startActivity((new Intent(Outcome1.this, Diagnose.class)));
            Intent i = new Intent(Diagnose.this, Diagnose.class);
            i.putExtra("qNo", 0);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
