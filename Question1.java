/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saurabh_assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saurabh
 */
public class Question1 {
    
    public static void main(String[] args) {
        
        List<Measurement> pune = new ArrayList<Measurement>();
        //Pune city measurements
        pune.add(new Measurement(10,20.0));
        pune.add(new Measurement(15,5.0));
        pune.add(new Measurement(20,30.0));
        pune.add(new Measurement(25,21.0));
        pune.add(new Measurement(30,17.0));
        
        //creating object of WeatherStation and passing values to constructor
        WeatherStation ws = new WeatherStation("Pune", pune);
        
        System.out.println("Output for First Question:-");
        
        System.out.println("The Max Temperature is: " + ws.maxTemperature(10,20));
        
    }
 
}
    

