/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model;

/**
 *
 * @author JOrtiz
 */
public class Person {
    private Long personId;
    private String name;
    private String email;

    public Person(){

    }

    public Person(Long personId, String name, String email) {
        this.personId = personId;
        this.name = name;
        this.email = email;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
