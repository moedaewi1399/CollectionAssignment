package CollectionAssignment;

import java.util.*;

public class Homework7 {
    public static void main(String[] args){
        Map<String, List<String>> popularPlaces = new HashMap<>();
        popularPlaces.put("Tokyo",Arrays.asList("shinjuku","shibuya","asakusa"));
        popularPlaces.put("Osaka",Arrays.asList("Dotonbori","Osaka Castle"));
        popularPlaces.forEach((city,places)-> System.out.println(city+":"+places));
    }
}
