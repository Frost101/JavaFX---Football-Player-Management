package codes;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class FileOperations{

    private static final String FILE_NAME = "players.txt";
    public static List<Players> playersList = new ArrayList();
    public static List<Club> clubsList = new ArrayList();
    public static List<Country> countryList = new ArrayList();
    public static List<Players> sellList = new ArrayList();

    //Reading from players.txt
    public static void readFromFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Players p = new Players();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setWeeklySalary(Double.parseDouble(tokens[7]));
            playersList.add(p);
        }
        br.close();
        for(Players p : playersList){
            boolean found = false;
            for(Club c : clubsList){
                if(c.getClubName().equalsIgnoreCase(p.getClub())){
                    c.addPlayers(p);
                    found = true;
                    break;
                }
            }
            if(found == false){
                Club c = new Club(p.getClub(),p);
                clubsList.add(c);
            }
        }

        for(Players p : playersList){
            boolean found = false;
            for(Country c : countryList){
                if(c.getCountryName().equalsIgnoreCase(p.getCountry())){
                    c.increaseCount();
                    found = true;
                    break;
                }
            }
            if(found == false){
                Country c = new Country(p.getCountry());
                countryList.add(c);
            }
        }
    }

    //Writing to players.txt
    public static void writeToFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Players p : playersList) {
            bw.write(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklySalary());
            bw.write("\n");
        }
        bw.close();
    }
}
