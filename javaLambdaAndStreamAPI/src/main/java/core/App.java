package core;

import java.util.*;
import java.util.stream.Collectors;


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
         Person ppp = new Person();
        ppp.setId(3);
        ppp.setName("enzo");
        
        List<Person> listPerson =  Arrays.asList(p,pp,ppp);
         
       // <editor-fold defaultstate="collapsed" desc=" CASE 1 CICLE">
           listPerson.forEach(pt->System.out.println("names "+pt.toString()));
       // </editor-fold> 
           
       // <editor-fold defaultstate="collapsed" desc=" CASE 2 FILTER >>> PREDICATE RETUNR BOOLEAN">
           List<Person> listPersonFiltered= listPerson.stream().filter(pe-> pe.getId()>0).collect(Collectors.toList());
           listPersonFiltered.forEach(fg -> System.out.println("filtered "+fg.getName()));
       // </editor-fold> 
       
       // <editor-fold defaultstate="collapsed" desc=" CASE 3 MAP >>> FUNTION RETUNR OBJET + BLOCK">
           List<Integer> idList= listPerson.stream().map(p1e-> p1e.getId()*20).collect(Collectors.toList());
           idList.forEach(intValue -> {System.out.println("map/transfor "+intValue);});
       // </editor-fold> 
         
       // <editor-fold defaultstate="collapsed" desc=" CASE 4 COMPLEX FILTER + MAP">
           List<Integer> idList2= listPerson.stream().map(p1e-> p1e.getId()*20).filter(per-> per>30).collect(Collectors.toList());
           idList2.forEach(intValue -> {System.out.println("mapcomplex line1 "+intValue);System.out.println("mapcomplex line2 "+intValue);});
       // </editor-fold>
       
       // <editor-fold defaultstate="collapsed" desc=" CASE 5 SORTER">
         Comparator<Person> byNameAsc = (Person o1 , Person o2) -> o1.getName().compareTo(o2.getName());
         listPerson.stream().sorted(byNameAsc).collect(Collectors.toList());
       // </editor-fold>
       
       // <editor-fold defaultstate="collapsed" desc=" CASE 6 X-MATCH">
        boolean rpt= listPerson.stream().anyMatch(kl-> kl.getName().startsWith("j"));
       // </editor-fold>
       
    }
    
    
}
