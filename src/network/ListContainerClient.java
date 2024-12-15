package network;

import codes.Club;
import codes.Country;
import codes.Players;

import java.util.ArrayList;
import java.util.List;

public class ListContainerClient {

    volatile public static List<Players> playersList = new ArrayList();
    public static List<Club> clubsList = new ArrayList();
    public static List<Country> countryList = new ArrayList();
    volatile public static List<Players> marketList= new ArrayList();
}
