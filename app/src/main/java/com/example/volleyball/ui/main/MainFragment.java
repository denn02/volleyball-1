package com.example.volleyball.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.volleyball.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        Button rsls = v.findViewById(R.id.btnResults);
        Button str = v.findViewById(R.id.btnStart);
        str.setOnClickListener(this);
        rsls.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnResults:
                Navigation.findNavController(v).navigate(R.id.mainToResultGames);
                break;
            case R.id.btnStart:
                Navigation.findNavController(v).navigate(R.id.mainToMatch);
        }
    }
}
