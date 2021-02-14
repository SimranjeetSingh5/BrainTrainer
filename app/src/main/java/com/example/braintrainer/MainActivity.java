package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestions = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();
        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");

        new CountDownTimer(30100,1000) {

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void chooseAnswer(View view) {
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText("Correct!");
            score++;
        } else {
            resultTextView.setText("Wrong :(");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();
    }

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timer));
    }

    public void newQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i=0; i<4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a+b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                while (wrongAnswer == a+b) {
                    wrongAnswer = rand.nextInt(41);
                }

                answers.add(wrongAnswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button5);

        sumTextView  = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.score);
        timerTextView = findViewById(R.id.timer);

        playAgainButton = findViewById(R.id.playAgain);
        gameLayout = findViewById(R.id.gameLayout);

        goButton = findViewById(R.id.goButton);

        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
//
//    ConstraintLayout gameLayout;
//    Button goButton;
//    int locationOfAnswer;
//    ArrayList<Integer> answers = new ArrayList<>();
//    TextView resultTextView;
//    int score = 0;
//    int numberOfQuestions = 0;
//    TextView scoreTextView,sumTextView,timerTextView;
//    Button button1,button2,button3,button4,playAgain;
//
//    public void playAgain(View view){
//
//        score = 0;
//        numberOfQuestions = 0;
//        timerTextView.setText("30s");
//        scoreTextView.setText(Integer.toString(score)+ "/" + Integer.toString(numberOfQuestions));
//
//        playAgain.setVisibility(View.INVISIBLE);
//        resultTextView.setText("");
//
//        new CountDownTimer(30100,1000){
//
//            @Override
//            public void onTick(long l) {
//                timerTextView.setText(String.valueOf( l / 1000) +  "s");
//                newQuestion();
//            }
//
//            @Override
//            public void onFinish() {
//                playAgain(findViewById(View.INVISIBLE));
//                resultTextView.setText("Done!");
//                playAgain.setVisibility(View.VISIBLE);
//            }
//        }.start();
//
//    }
//
//
//    public void chooseAnswer(View view){
//        if(Integer.toString(locationOfAnswer).equals(view.getTag().toString())){
//            Log.i("Correct","Answer");
//            resultTextView.setText("Correct!");
//            score++;
//        } else {
//            Log.i("Wrong","Answer");
//            resultTextView.setText("Wrong :(");
//        }
//        numberOfQuestions++;
//        scoreTextView.setText(Integer.toString(score)+ "/" + Integer.toString(numberOfQuestions));
//        newQuestion();
//    }
//
//
//
//
    }
}