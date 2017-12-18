package com.gmail.robalascott.footballscorekeeper;

/**
 * Created by robscott on 2017-12-11.
 */

public class TeamObject {
    private String Name;
    private int goal = 0;
    private int cardRed = 0;
    private int cardYellow = 0;
    private int shots = 0;

    public TeamObject(String teamA, int i, int i1, int i2,int i3) {
        this.Name = teamA;
        this.goal = i;
        this.cardRed = i1;
        this.cardYellow = i2;
        this.shots = i3;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void addGoal() {
        this.goal++;
    }
    public int getCardRed() {
        return cardRed;
    }

    public void setCardRed(int cardRed) {
        this.cardRed = cardRed;
    }

    public void addCardRed() {
        this.cardRed++;
    }
    public int getCardYellow() {
        return cardYellow;
    }

    public void setCardYellow(int cardYellowTeamA) {
        this.cardYellow = cardYellowTeamA;
    }
    public void addCardYellow() {
        this.cardYellow++;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }
    public void addShots() {
        this.shots++;
    }
}
