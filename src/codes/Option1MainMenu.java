package codes;



import network.ListContainerClient;

import java.util.ArrayList;
import java.util.List;

public class Option1MainMenu {


    public static Players searchByPlayerName(String playersName){
        Boolean found = false;
        Players player = new Players();
        for(Players p : ListContainerClient.playersList) {
            if(playersName.equalsIgnoreCase(p.getName())){
                player = p;
                found = true;
                break;
            }
        }
        if(found == false){
            player.setName("Not Found");
        }
        return player;
    }


    public static List<Players> searchByClubAndCountry(String countryName){

        List<Players> tempPlayersList = new ArrayList();


        for(Players p : ListContainerClient.playersList){
            if(countryName.equalsIgnoreCase(p.getCountry())){
                tempPlayersList.add(p);
            }
        }

        return tempPlayersList;
    }


    public static List<Players> searchByPosition(String position){
        Boolean found = false;
        List<Players> tempPlayersList = new ArrayList();
        for(Players p : ListContainerClient.playersList){
            if(position.equalsIgnoreCase(p.getPosition())){
                tempPlayersList.add(p);
                found = true;
            }
        }
        return tempPlayersList;
    }


    public static List<Players> searchBySalaryRange(Double minimumSalary, Double maximumSalary){

        List<Players> tempPlayersList = new ArrayList();

        for(Players p : ListContainerClient.playersList){
            if(p.getWeeklySalary() >= minimumSalary && p.getWeeklySalary() <= maximumSalary){
                tempPlayersList.add(p);
            }
        }
        return tempPlayersList;
    }


    public static List<Country> countryWisePlayerCount(){
        List<Country> tempList = new ArrayList();

        for(Players p : ListContainerClient.playersList){
            boolean found = false;
            for(Country c : tempList){
                if(c.getCountryName().equalsIgnoreCase(p.getCountry())){
                    c.increaseCount();
                    found = true;
                    break;
                }
            }
            if(found == false){
                Country c = new Country(p.getCountry());
                tempList.add(c);
            }
        }


        return tempList;
    }


}
