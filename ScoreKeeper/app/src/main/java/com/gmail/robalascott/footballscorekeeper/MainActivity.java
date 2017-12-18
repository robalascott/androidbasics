package com.gmail.robalascott.footballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TeamObject teamA,teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        teamA = new TeamObject("TeamA",0,0,0,0);
        updateTeamA(teamA);
        teamB = new TeamObject("TeamB",0,0,0,0);
        updateTeamB(teamB);
        //
        findViewById(R.id.goalTeamA).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.shotsTeamAButton).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.yellowCardTeamAButton).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.redCardTeamAButton).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.goalTeamB).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.shotsTeamBButton).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.yellowCardTeamBButton).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.redCardTeamBButton).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.resetButton).setOnClickListener(mGlobal_OnClickListener);
    }

    final View.OnClickListener mGlobal_OnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            switch(v.getId()) {
                case R.id.goalTeamA:
                    teamA.addGoal();
                    TextView scoreTextView =  findViewById(R.id.scoreTeamA);
                    scoreTextView.setText("" + teamA.getGoal());
                    break;
                case R.id.shotsTeamAButton:
                    teamA.addShots();
                    Button shotsTeamAButton = findViewById(R.id.shotsTeamAButton);
                    shotsTeamAButton.setText(" Shots: " + teamA.getShots());
                    break;
                case R.id.yellowCardTeamAButton:
                    teamA.addCardYellow();
                    Button yellowTeamAButton = findViewById(R.id.yellowCardTeamAButton);
                    yellowTeamAButton.setText(" " + teamA.getCardYellow());
                    break;
                case R.id.redCardTeamAButton:
                    teamA.addCardRed();
                    Button redTeamAButton = findViewById(R.id.redCardTeamAButton);
                    redTeamAButton.setText(" " + teamA.getCardRed());
                    break;
                case R.id.goalTeamB:
                    teamB.addGoal();
                    TextView scoreTextViewB =  findViewById(R.id.scoreTeamB);
                    scoreTextViewB.setText("" + teamB.getGoal());
                    break;
                case R.id.shotsTeamBButton:
                    teamB.addShots();
                    Button shotsTeamBButton = findViewById(R.id.shotsTeamBButton);
                    shotsTeamBButton.setText(" Shots: " + teamB.getShots());
                    break;
                case R.id.yellowCardTeamBButton:
                    teamB.addCardYellow();
                    Button yellowTeamBButton = findViewById(R.id.yellowCardTeamBButton);
                    yellowTeamBButton.setText(" " + teamB.getCardYellow());
                    break;
                case R.id.redCardTeamBButton:
                    teamB.addCardRed();
                    Button redTeamBButton = findViewById(R.id.redCardTeamBButton);
                    redTeamBButton.setText(" " + teamB.getCardRed());
                    break;
                case R.id.resetButton:
                    teamA = new TeamObject("TeamA",0,0,0,0);
                    updateTeamA(teamA);
                    teamB = new TeamObject("TeamB",0,0,0,0);
                    updateTeamB(teamB);
                    break;
                default:break;
            }
        }
    };

    private void updateTeamA(TeamObject team) {
        TextView nameTextView =  findViewById(R.id.nameTeamA);
        nameTextView.setText("" + team.getName());
        TextView scoreTextView =  findViewById(R.id.scoreTeamA);
        scoreTextView.setText("" + team.getGoal());
        Button shotsTeamAButton = findViewById(R.id.shotsTeamAButton);
        shotsTeamAButton.setText(" Shots: " +  teamA.getShots());
        Button yellowTeamAButton = findViewById(R.id.yellowCardTeamAButton);
        yellowTeamAButton.setText(" " + teamA.getCardYellow());
        TextView redTextView = findViewById(R.id.redCardTeamAButton);
        redTextView.setText("" + team.getCardRed());
    }

    private void updateTeamB(TeamObject team) {
        TextView nameTextView =  findViewById(R.id.nameTeamB);
        nameTextView.setText("" + team.getName());
        TextView scoreTextView =  findViewById(R.id.scoreTeamB);
        scoreTextView.setText("" + team.getGoal());
        Button shotsTeamAButton = findViewById(R.id.shotsTeamBButton);
        shotsTeamAButton.setText(" Shots: " + teamA.getShots());
        Button yellowTeamAButton = findViewById(R.id.yellowCardTeamBButton);
        yellowTeamAButton.setText(" " + teamA.getCardYellow());
        TextView redTextView = findViewById(R.id.redCardTeamBButton);
        redTextView.setText("" + team.getCardRed());
    }

}
