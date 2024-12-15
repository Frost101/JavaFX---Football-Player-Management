package codes;

import java.io.Serializable;

public class Country implements Serializable {

    String countryName;
    int playerCount;

    public Country(){
        playerCount = 0;
    }

    public Country(String countryName){
        this.countryName = countryName;
        playerCount = 1;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getCountryName() {
        return countryName;
    }

    public void increaseCount(){
        playerCount++;
    }
}
