package codes;


import java.util.ArrayList;
import java.util.List;

public class Option2MainMenu {

    public static List<Players> maximumSalaryClub(String clubName){
        List<Players> tempPlayersList = new ArrayList();
        Club c = new Club();
        tempPlayersList = c.maximumSalary();
        return tempPlayersList;
    }


    public static List<Players> maximumAgeClub(String clubName){
        List<Players> tempPlayersList = new ArrayList();
        Club c = new Club();
        tempPlayersList = c.maximumAge();
        return tempPlayersList;
    }


    public static List<Players> maximumHeightClub(String clubName){
        List<Players> tempPlayersList = new ArrayList();
        Club c = new Club();
        tempPlayersList = c.maximumHeight();
        return tempPlayersList;
    }


    public static double totalYearlySalaryClub(String clubName){
        double salary = 0;
        Club c = new Club();
        salary = c.totalYearlySalary();
        return salary;
    }

}
