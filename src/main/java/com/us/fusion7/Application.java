package com.us.fusion7;

import com.us.person.Person;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;

import java.util.Scanner;

/**
 * Created by yangyibo on 17/1/3.
 */
public class Application {
    private static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("fusionAgeKS");
    }

    public static void run() {

        KieSession ks = getSession();
//        // and start inserting your facts into the entry point
//
        Person p1 = new Person("白展堂", 2);
        Person p2 = new Person("李大嘴", 16);

        EntryPoint boyStream = ks.getEntryPoint("boy");
//        boyStream.insert( p1 );
//        boyStream.insert( p2 );
//
//
//        EntryPoint  youthStream= ks.getEntryPoint( "youth" );
//        youthStream.insert( p1 );
//        youthStream.insert( p2 );

//        EntryPoint  ageSumStream= ks.getEntryPoint( "ageSum" );
//      for (int i=0;i<5;i++){
//          ageSumStream.insert( p1 );
//          ageSumStream.insert( p2 );
        ks.insert(p1);
        ks.insert(p2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
//      }


        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则------------------------------");

        ks.dispose();
    }


    public static void main(String[] args) {
        run();
    }

}
