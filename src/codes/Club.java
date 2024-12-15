package codes;



import network.ListContainerClient;

import java.util.ArrayList;
import java.util.List;


public class Club {
    private Players[] clubPlayers = new Players[7];
    private int playerCount;
    private String clubName;
    private int maximumPlayerCount;

    public Club(){
        maximumPlayerCount = 7;
        playerCount = 0;
        for(int i=0; i<maximumPlayerCount; i++){
            clubPlayers[i] = new Players();
        }
    }

    public Club(String s, Players p){
        maximumPlayerCount = 7;
        playerCount = 0;
        clubName = s;
        for(int i=0; i<maximumPlayerCount; i++){
            clubPlayers[i] = new Players();
        }
        clubPlayers[playerCount] = p;
        playerCount++;
    }

    public void addPlayers(Players p){
        clubPlayers[playerCount] = p;
        playerCount++;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public List<Players> maximumSalary(){
        double maxSalary = -1;
        List<Players> tempPlayersList = new ArrayList();
        for(Players p : ListContainerClient.playersList){
            if(p.getWeeklySalary()>maxSalary){
                maxSalary = p.getWeeklySalary();
            }
        }
        for(Players p : ListContainerClient.playersList){
            if(p.getWeeklySalary() == maxSalary){
                tempPlayersList.add(p);
            }
        }
        return tempPlayersList;
    }


    public List<Players> maximumAge(){
        int maxAge = -1;
        List<Players> tempPlayersList = new ArrayList();
        for(Players p : ListContainerClient.playersList){
            if(p.getAge() > maxAge ){
                maxAge = p.getAge();
            }
        }
        for(Players p : ListContainerClient.playersList){
            if(p.getAge() == maxAge){
                tempPlayersList.add(p);
            }
        }
        return tempPlayersList;
    }


    public List<Players> maximumHeight(){
        double maxHeight = -1;
        List<Players> tempPlayersList = new ArrayList();
        for(Players p : ListContainerClient.playersList){
            if(p.getHeight() > maxHeight){
                maxHeight = p.getHeight();
            }
        }
        for(Players p : ListContainerClient.playersList){
            if(p.getHeight() == maxHeight){
                tempPlayersList.add(p);
            }
        }
        return tempPlayersList;
    }


    public double totalYearlySalary(){
        double yearlySalary = 0;
        for(Players p : ListContainerClient.playersList){
            yearlySalary += ((p.getWeeklySalary())*52);
        }
        return yearlySalary;
    }


    public boolean checkNumberValidation(int num){
        for( Players p : clubPlayers){
            if(p.getNumber() == num) return false;
        }
        return  true;
    }

}
