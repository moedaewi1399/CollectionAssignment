package CollectionAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class HomeworkOne {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(5);
        numList.add(6);
        numList.add(10);
        Optional<Integer> maxNumber = numList.stream().max(Integer::compareTo);
        System.out.println(maxNumber.get());
        Optional<Integer> minNumber = numList.stream().min(Integer::compareTo);
        System.out.println(minNumber.get());
//        double average = (double) numList.stream().reduce(0, Integer::sum) / numList.size();
//        System.out.println(average);

        OptionalDouble average = numList.stream().mapToInt(Integer::intValue).average();

    }
    }



