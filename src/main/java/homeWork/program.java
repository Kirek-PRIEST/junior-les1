package homeWork;

import java.util.ArrayList;
import java.util.List;

public class program {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        int index = 1;
        while (index < 100) {
            nums.add(index++);
        }

         double avg = nums.stream()
                .filter(integer -> integer % 2 == 0)
                 .mapToInt(Integer::intValue)
                 .average()
                 .orElse(0);
        System.out.println("Среднее значение = " + avg);
    }
}
