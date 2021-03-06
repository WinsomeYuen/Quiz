package com.example.android.quiz;

import java.text.NumberFormat;
import java.text.StringCharacterIterator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiz.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.quiz.MESSAGE";
    private Questions myQuestionLib = new Questions();

    private TextView myTotal;
    private TextView myQuestion;
    private Button myButton1;
    private Button myButton2;
    private Button myButton3;

    private String myAnswer;
    private int myScore = 0;
    private int currentQ = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_main);

        myTotal = (TextView)findViewById(R.id.score);
        myQuestion = (TextView)findViewById(R.id.question);
        myButton1 = (Button) findViewById(R.id.button2);
        myButton2 = (Button) findViewById(R.id.button3);
        myButton3 = (Button) findViewById(R.id.button4);

        updateQuestion();

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myButton1.getText() == myAnswer){
                    myScore+=1;
                    updateScore(myScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myButton2.getText() == myAnswer){
                    myScore+=1;
                    updateScore(myScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        myButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myButton3.getText() == myAnswer){
                    myScore+=1;
                    updateScore(myScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
    }

    public void updateQuestion(){
        if(currentQ == 9){
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            TextView editText = (TextView) findViewById(R.id.score);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
            return;
        }
        myQuestion.setText(myQuestionLib.getQuestion(currentQ));
        myButton1.setText(myQuestionLib.getChoice1(currentQ));
        myButton2.setText(myQuestionLib.getChoice2(currentQ));
        myButton3.setText(myQuestionLib.getChoice3(currentQ));

        myAnswer = myQuestionLib.getCorrectanswer(currentQ);
        currentQ++;
    }

    public void updateScore(int point){
        myTotal.setText(""+myScore);
    }

    /** Called when the user taps the Quit button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        TextView editText = (TextView) findViewById(R.id.score);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}