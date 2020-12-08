package core;

import java.util.*;


/**
 * Hello world!
 *
 */
public class App 
{
    
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person p = new Person();
        p.setId(1);
        p.setName("jesus");
        Person pp = new Person();
        pp.setId(2);
        pp.setName("manuel");
        
        List<Person> listPerson =  Arrays.asList(p,pp);
                
        listPerson.forEach(pt->System.out.println(pt.toString()));
    }
}
