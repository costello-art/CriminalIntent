package com.sviat.k.criminalintent.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Sviat on 02.11.14.
 */
public class CrimeFragment extends Fragment {
    private static final String TAG = "CrimeFragment";
    public static final String EXTRA_CRIME_ID = "com.sviat.k.criminalintent.app.crime_id";
    private Crime mCrime;

    private EditText mTextCrimeTitle;
    private Button mTimeButton;
    private CheckBox mCheckSolved;

    public CrimeFragment() {
        // Required empty public constructor
    }

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTextCrimeTitle = (EditText) v.findViewById(R.id.crime_title);

        mTextCrimeTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTextCrimeTitle = (EditText) v.findViewById(R.id.crime_title);
        mTextCrimeTitle.setText(mCrime.getTitle());

        mTimeButton = (Button) v.findViewById(R.id.buttonTimeCrime);
        mTimeButton.setText(mCrime.getDate().toString());

        mCheckSolved = (CheckBox) v.findViewById(R.id.checkBoxCrimeSolved);
        mCheckSolved.setChecked(mCrime.isSolved());

        mCheckSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}