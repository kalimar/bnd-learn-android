package com.bignerdanch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by kalimarmaia on 5/28/19.
 */

public class CrimeListActivity  extends SingleFragmentActivity{

  @Override
  protected Fragment createFragment() {
    return new CrimeListFragment();
  }
}
