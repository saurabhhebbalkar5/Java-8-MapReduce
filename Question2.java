package saurabh_assignment2;

import java.util.ArrayList;
import java.util.List;
import static saurabh_assignment2.WeatherStation.stations;

/**
 *
 * @author Saurabh
 */
public class Question2 {
  
    public static void main(String[] args) {
        
        //Pune City Measurement List
        List<Measurement> pune = new ArrayList<Measurement>();
        
        pune.add(new Measurement(10,20.0));
        pune.add(new Measurement(15,5.0));
        pune.add(new Measurement(20,30.0));
        pune.add(new Measurement(25,21.0));
        pune.add(new Measurement(30,17.0));
        
        //Mumbai City Measurement List
        List<Measurement> mumbai = new ArrayList<Measurement>();
        mumbai.add(new Measurement(12,1.0));
        mumbai.add(new Measurement(17,4.0));
        mumbai.add(new Measurement(22,9.0));
        mumbai.add(new Measurement(26,12.0));
        mumbai.add(new Measurement(29,20.0));
        
        
        WeatherStation ws1 = new WeatherStation("Pune",pune);
        stations.add(ws1);
        
        WeatherStation ws2 = new WeatherStation("Mumbai",mumbai);
        stations.add(ws2);
        
        System.out.println("Output for Second Question");
        System.out.println("The Count for t1 and t2 are:");
        System.out.println(ws1.countTemperature(10.0, 20.0, 5.0));
        
    }  
    
}


