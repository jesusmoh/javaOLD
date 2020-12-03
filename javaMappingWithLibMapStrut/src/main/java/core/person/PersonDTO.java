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
public class PersonDTO {

    private String name;
    private String lastname;
    private int yearsold;

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

    public int getYearsold() {
        return yearsold;
    }

    public void setYearsold(int yearsold) {
        this.yearsold = yearsold;
    }

    public PersonDTO(String name, String lastname, int yearsold) {
        this.name = name;
        this.lastname = lastname;
        this.yearsold = yearsold;
    }

  

    public PersonDTO() {
        super();
    }

}
