package CollectionAssignment;

import java.util.*;

public class Homework3 {

    public static void main(String[] args){
        Map<String,Integer> productMap = new HashMap<>();
        productMap.put("FaceWash",300);
        productMap.put("Toner",500);
        productMap.put("Cleanser",700);
        productMap.put("Moisture",1000);
        productMap.put("Suncream",500);
        System.out.println(productMap.keySet());
        System.out.println(productMap.entrySet());
        Optional<Integer> highestPrice = productMap.values().stream().max(Integer::compareTo);
     for( Map.Entry<String,Integer> entry : productMap.entrySet()) {
//         System.out.println(entry.getKey()+entry.getValue());
         if(Objects.equals(entry.getValue(), highestPrice.get())) System.out.println("The highest price product : " + entry.getKey()+"\nprice : "+entry.getValue());

     };







    }
}
