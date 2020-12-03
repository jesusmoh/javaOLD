/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.person;

/**
 *
 * @author JOrtiz
 */
public class Person {

    private String name;
    private String lastname;
    private int yearold;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearold() {
        return yearold;
    }

    public void setYearold(int yearold) {
        this.yearold = yearold;
    }

  
    public Person() {
        super();
    }

    public Person(String name, String lastname, int yearold) {
        this.name = name;
        this.lastname = lastname;
        this.yearold = yearold;
    }

}
