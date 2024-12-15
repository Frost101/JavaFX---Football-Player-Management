package codes;

import java.io.Serializable;

public class Players implements Serializable {
    String name;
    String country;
    int age;
    double height;
    String club;
    String position;
    int number;
    double weeklySalary;

    @Override
    public String toString(){
        return "Name: " + name + '\n' + "Country: " + country + '\n' + "Age(in years): " + age + '\n' + "Height(in meters): " + height + '\n' + "Club: " + club + '\n' + "Position: " + position + '\n' + "Number: " + number + '\n' + "Weekly Salary: " + weeklySalary + '\n';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClub() {
        return club;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }
}
