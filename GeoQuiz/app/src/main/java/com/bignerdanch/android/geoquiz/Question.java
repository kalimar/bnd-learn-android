package com.bignerdanch.android.geoquiz;

/**
 * Created by kalimarmaia on 5/24/19.
 */

public class Question {
  private int mTextResId;
  private boolean mAnswerTrue;

  public Question(int textResId, boolean answerTrue) {
    mTextResId = textResId;
    mAnswerTrue = answerTrue;
  }

  public int getTextResId() {
    return mTextResId;
  }

  public void setTextResId(int textResId) {
    mTextResId = textResId;
  }

  public boolean isAnswerTrue() {
    return mAnswerTrue;
  }

  public void setAnswerTrue(boolean answerTrue) {
    mAnswerTrue = answerTrue;
  }
}
