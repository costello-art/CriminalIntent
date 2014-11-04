package com.sviat.k.criminalintent.app.activity;

import android.support.v4.app.Fragment;
import com.sviat.k.criminalintent.app.CrimeListFragment;

/**
 * Created by Sviat on 03.11.14.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
