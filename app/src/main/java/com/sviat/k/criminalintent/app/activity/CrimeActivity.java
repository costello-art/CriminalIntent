package com.sviat.k.criminalintent.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sviat.k.criminalintent.app.CrimeFragment;
import com.sviat.k.criminalintent.app.R;
import com.sviat.k.criminalintent.app.SingleFragmentActivity;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);

        return CrimeFragment.newInstance(crimeId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, createFragment(), "tagCrimeFragment").commit();
    }
}