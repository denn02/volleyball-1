package com.example.volleyball.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
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
import android.widget.EditText;

import com.example.volleyball.GameFragment;
import com.example.volleyball.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;
    View view;
    final EditText team1 = (EditText) view.findViewById(R.id.EditTextTeam1);
    final EditText team2 = (EditText) view.findViewById(R.id.EditTextTeam2);

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
/*  any huita, 
*   try to put in GameFragment, 
*   but i don't know how put it in SurfaceView
*/

//        Intent intent = new Intent(this, GameFragment.newInstance(team1, team2));
//        intent.putExtra("team1", team1.getText().toString());
//        intent.putExtra("team2", team2.getText().toString());
//        startActivity(intent);
        switch (v.getId()) {
            case R.id.btnResults:
                Navigation.findNavController(v).navigate(R.id.mainToResultGames);
                break;
            case R.id.btnStart:
                Navigation.findNavController(v).navigate(R.id.mainToMatch);
        }
    }
}
