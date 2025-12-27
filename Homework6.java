package CollectionAssignment;

import java.util.Map;
import java.util.TreeMap;

public class Homework6 {
    public static void main(String[] args){
        Map<String,Integer> CountryMap = new TreeMap<>();
        CountryMap.put("Myanmar",20000000);
        CountryMap.put("Japan",30000000);
        CountryMap.put("Swizz",1000000);

        System.out.println(CountryMap);
    }

}
