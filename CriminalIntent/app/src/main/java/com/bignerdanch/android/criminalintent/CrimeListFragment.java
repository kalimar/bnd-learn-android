package com.bignerdanch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kalimarmaia on 5/28/19.
 */

public class CrimeListFragment extends Fragment {
  private RecyclerView mCrimeRecyclerView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_crime_list, container, false);


    return super.onCreateView(inflater, container, savedInstanceState);
  }
}
