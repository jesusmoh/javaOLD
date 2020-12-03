
import core.person.Person;
import core.person.PersonDTO;
import core.mapper.PersonMapper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOrtiz
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        Person person= new Person("pepe","perez",20);
        
        PersonDTO personDto= PersonMapper.INSTANCIA.personaToPersonaDto(person);
      
        System.out.println(" ? "+personDto.getName());
        
    }
    
}
