package saurabh_assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Saurabh
 */
public class WeatherStation {
    
    //Creating custom list of Measurement class
    List<Measurement> measurements = new ArrayList<Measurement>();
    
    //Creating custom static WeatherStation list
    static List<WeatherStation> stations = new ArrayList<WeatherStation>();
    
    String cityname;
    
    //Constructor to initialize cityname and measurements object
    WeatherStation(String cityname, List<Measurement> measurements ){
        
        this.cityname = cityname;
        this.measurements = measurements;
    }
      
    double maxTemperature(int startTime, int endTime){ 
        double temp = measurements.stream()
             //filtering the elements betweeen start and end time.
            .filter(e -> e.time >= startTime && e.time <= endTime)
             //typecasting the values into double stream
            .mapToDouble(t -> t.temperature)
             //printing the max value or else 0 to terminate the option.
            .max().orElse(0.0);
        return temp;
    }
    
    List countTemperature(double t1, double t2, double r){
        
        //Creating Custom List
        List <CountClass> countClassList = new ArrayList<CountClass>();
        
        //Map and Reduce for temperature 1
        //first input t1
        Integer temp1 =
                //multiple substreams
                stations.parallelStream()
                //hashmap and filter value to check t1 plus minus range.
               .map(e -> e.measurements.stream()
               .filter(t -> ((t1 + r >= t.temperature) && (t1 - r <= t.temperature)))
               .map(st-> st.temperature)
                // mapping the city names and adding their values with sum
               .collect(Collectors.toMap(a-> e.cityname, a->1,Integer::sum)))
                // flatmap flattens the input from stream gives only the value not the key
                //sum is used to add all the instances from both the stations and orElse is used to terminate optional
               .flatMap(ct->ct.values().stream()).reduce(Integer::sum).orElse(0);
        
        //creating count class object to pass input and temp1
        CountClass ccObjT1 = new CountClass(t1, temp1);
        
        //Map and Reduce for temperature 2
        //same code as above just second input t2 instead of t1
        Integer temp2 =
                stations.parallelStream()
                .map(e -> e.measurements.stream()
                .filter(t -> ((t2 + r >= t.temperature) && (t2 - r <= t.temperature) ) )
                .map(st -> st.temperature)
                .collect(Collectors.toMap(a-> e.cityname, a->1,Integer::sum)))
                .flatMap(ct->ct.values().stream()).reduce(Integer::sum).orElse(0);
        
        CountClass ccObjT2 = new CountClass(t2, temp2);
        
        countClassList.add(ccObjT1);
        countClassList.add(ccObjT2);
           
        return countClassList;
    }
}

//Creating class so that a custom list can be created to pass Double and Int value together
class CountClass{
     double temp;
     int cnt;
     
     CountClass(double temp, int cnt){
     this.temp=temp;
     this.cnt=cnt;
     }
     
     public String toString(){
     return "["+ temp +"," + cnt +"]";
     }
}