package src;

import core.model.Jugador;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("main.xml");

        Jugador jugador= (Jugador) applicationContext.getBean("jugador1");
        Jugador jugadora= (Jugador) applicationContext.getBean("jugador1");

        Jugador jugadorb= (Jugador) applicationContext.getBean("jugador2");
        Jugador jugadorc= (Jugador) applicationContext.getBean("jugador2");

        System.out.println("----------------------------------------");
        System.out.println("scope=prototype"+ jugador.toString());
        System.out.println("scope=prototype"+ jugadora.toString());

        System.out.println("-----------------BEANS DIFERENTES-----------------------");
        System.out.println(jugador.hashCode());
        System.out.println(jugadora.hashCode());

        System.out.println("------------------BEANS IGUALES-------------------------");
        System.out.println(jugador.getCamiseta().hashCode());
        System.out.println(jugadora.getCamiseta().hashCode());

        System.out.println("-----------------AUTO WIRE ON XML-----------------------");
        System.out.println("scope=prototype"+ jugadorb.toString());
        System.out.println("scope=prototype"+ jugadorc.toString());



    }
}
