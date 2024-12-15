package codes;


import codes.Club;
import codes.FileOperations;
import codes.Players;

import java.util.Scanner;

public class Option3MainMenu{
    public static void addNewPlayer(){
        Scanner sc = new Scanner(System.in);
        String [] s = new String[8];
        Boolean clubFound = false , clubCapacity = true , checkValidation = true , validationType[] = {true,true,true,true};


        Players p = new Players();


        System.out.print("Player's Name: ");
        s[0] = sc.nextLine();
        p.setName(s[0]);
        //Checking Name Validation
        for(Players temp : FileOperations.playersList){
            if(p.getName().equalsIgnoreCase(temp.getName())){
                checkValidation = false;
                validationType[0] = false;
                System.out.println();
                System.out.println("Invalid input!A player with the inputted name is already in the database.");
                System.out.println();
                return;

            }
        }
        System.out.print("Country: ");
        s[1] = sc.nextLine();
        p.setCountry(s[1]);
        System.out.print("Age in years: ");
        s[2] = sc.nextLine();
        p.setAge(Integer.parseInt(s[2]));
        System.out.print("Height in meters: ");
        s[3] = sc.nextLine();
        p.setHeight(Double.parseDouble(s[3]));
        System.out.print("Club Name: ");
        s[4] = sc.nextLine();
        p.setClub(s[4]);
        //checking capacity
        Club tempClub = new Club();
        for(Club c : FileOperations.clubsList){
            if(p.getClub().equalsIgnoreCase(c.getClubName())){
                clubFound = true;
                tempClub = c;
                if(c.getPlayerCount()>=7){
                    clubCapacity = false;
                    validationType[2] = false;
                    checkValidation = false;
                    System.out.println();
                    System.out.println("Invalid Club!Maximum player capacity of this club has been achieved!");
                    System.out.println();
                    return;
                }
                break;
            }
        }
        System.out.print("Position(Goalkeeper,Defender,Midfielder,Forward): ");
        s[5] = sc.nextLine();
        p.setPosition(s[5]);
        //Checking Position
        if(!(p.getPosition().equalsIgnoreCase("Goalkeeper") || p.getPosition().equalsIgnoreCase("Defender") || p.getPosition().equalsIgnoreCase("Midfielder") || p.getPosition().equalsIgnoreCase("Forward"))){
            checkValidation = false;
            validationType[1] = false;
            System.out.println();
            System.out.println("Invalid position.Only Goalkeeper,Defender,Midfielder and Forward are accepted.");
            System.out.println();
            return;
        }
        System.out.print("Number: ");
        s[6] = sc.nextLine();
        p.setNumber(Integer.parseInt(s[6]));
        //checking Number validation
        if(clubFound){
            int number = Integer.parseInt(s[6]);
            Boolean numberValidity = tempClub.checkNumberValidation(number);
            if( numberValidity == false) {
                checkValidation = false;
                validationType[3] = false;
                System.out.println();
                System.out.println("Invalid number.A player with the same number is already in this club.");
                System.out.println();
                return;
            }
        }
        System.out.print("Weekly Salary: ");
        s[7] = sc.nextLine();
        p.setWeeklySalary(Double.parseDouble(s[7]));



        if(clubFound && clubCapacity){
            FileOperations.playersList.add(p);
            tempClub.addPlayers(p);
        }
        else{
            FileOperations.playersList.add(p);
            Club temp = new Club();
            temp.setClubName(p.getClub());
            temp.addPlayers(p);
            FileOperations.clubsList.add(temp);
        }
        System.out.println();
        System.out.println("Player is added successfully!");
        System.out.println();

    }
}
