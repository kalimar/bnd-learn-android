package com.bignerdanch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

  private static final String TAG = "QuizActivity";
  private static final String KEY_INDEX = "index";
  private static final String KEY_ANSWERED = "answered";

  private Button mTrueButton;
  private Button mFalseButton;
  private ImageButton mNextButton;
  private ImageButton mPrevButton;
  private TextView mQuestionTextView;
  private ArrayList<Integer> mAnsweredQuestions = new ArrayList<>();

  private Question[] mQuestionBank = new Question[] {
    new Question(R.string.question_africa, true),
    new Question(R.string.question_americas, false),
    new Question(R.string.question_asia, true),
    new Question(R.string.question_australia, false),
    new Question(R.string.question_mideast, true),
    new Question(R.string.question_oceans, false)
  };

  private int mCurrentIndex = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "oncCreate(Bundle) called");
    setContentView(R.layout.activity_quiz);

    if (savedInstanceState != null) {
      mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
      mAnsweredQuestions = savedInstanceState.getIntegerArrayList(KEY_ANSWERED);
    }

    mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
    mQuestionTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        updateQuestion();
      }
    });

    // Casting the view to Button is apparently redundant
    mTrueButton = (Button) findViewById(R.id.true_button);
    mTrueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mTrueButton.setClickable(false);
        mFalseButton.setClickable(false);
        checkAnswer(true);
        mAnsweredQuestions.add(mCurrentIndex);
      }
    });
    mFalseButton = (Button) findViewById(R.id.false_button);
    mFalseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mTrueButton.setClickable(false);
        mFalseButton.setClickable(false);
        checkAnswer(false);
        mAnsweredQuestions.add(mCurrentIndex);
      }
    });

    mNextButton = (ImageButton) findViewById(R.id.next_button);
    mNextButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        updateQuestion();
      }
    });

    mPrevButton = (ImageButton) findViewById(R.id.prev_button);
    mPrevButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mCurrentIndex == 0) {
          mCurrentIndex = mQuestionBank.length - 1;
        } else {
          mCurrentIndex = (mCurrentIndex - 1);
        }
        updateQuestion();
      }
    });

    updateQuestion();
  }

  @Override
  public void onStart() {
    super.onStart();
    Log.d(TAG, "onStart() called");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d(TAG, "onResume() called");
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d(TAG, "onPause() called");
  }

  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    Log.i(TAG, "onSaveInstanceState");
    savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    savedInstanceState.putIntegerArrayList(KEY_ANSWERED, mAnsweredQuestions);
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.d(TAG, "onStop() called");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy() called");
  }

  private void updateQuestion() {
    int question = mQuestionBank[mCurrentIndex].getTextResId();
    mQuestionTextView.setText(question);
    if(mAnsweredQuestions.contains(mCurrentIndex)) {
      mTrueButton.setClickable(false);
      mFalseButton.setClickable(false);
    } else {
      mTrueButton.setClickable(true);
      mFalseButton.setClickable(true);
    }
  }

  private void checkAnswer(boolean userPressedTrue) {
    boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

    int messageResId = 0;

    if (userPressedTrue == answerIsTrue) {
      messageResId = R.string.correct_toast;
    } else {
      messageResId = R.string.incorrect_toast;
    }

    Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
  }
}
