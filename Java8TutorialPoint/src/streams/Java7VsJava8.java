package streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java7VsJava8 {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~ Using Java 7 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");

//        Count empty Strings
        List<String> strings = Arrays.asList("abc", "","bc", "efg", "abcd","", "jkl");
        System.out.println("List "+ strings);

        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty Strings: "+count);

        count = getCountLength3UsingJava7(strings);
        System.out.println("Strings of length 3: " + count);

        //Eliminate empty string
        List<String> filtered = deleteEmptyStringUsingJava7(strings);
        System.out.println("Filtered List: " + filtered);


//      Eliminate empty string and join using comma
        String mergedString = getMergedStringUsingJava7(strings,", ");
        System.out.println("Merged String: "+ mergedString);

        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);

//      get list of square of distinct numbers
        List<Integer> squareList = getSquares(numbers);
        System.out.println("List: "+ numbers);
        System.out.println("Square list: "+ squareList);

        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19,9);

        System.out.println("List: " + integers);
        System.out.println("Highest number in List: " + getMax(integers));
        System.out.println("Lowest number in List: " + getMin(integers));
        System.out.println("Sum of all numbers in List: " + getSum(integers));
        System.out.println("Average of all numbers in List: " + getAverage(integers));


        System.out.println("Random Numbers: ");
        Random random = new Random();
        for (int i = 0; i <10 ; i++) {
            System.out.println(random.nextInt());
        }

        System.out.println("~~~~~~~~~~~~~~~~~~ Using Java 8 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");

        System.out.println("List: "+ strings);

        count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Empty Strings: "+ count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("Strings of length 3: "+ count);

        filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered list: "+ filtered);


        mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String "+ mergedString);

        squareList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("Square List: "+ squareList);

        System.out.println("\nList: "+ integers);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List: "+ stats.getMax());
        System.out.println("Lowest number in List: "+ stats.getMin());
        System.out.println("Sum of all numbers: " + stats.getSum());
        System.out.println("Average of all numbers: "+ stats.getAverage());

        System.out.println("\nRandom numbers: ");
        random.ints().limit(10).sorted().forEach(System.out::println);


//        parallel processing
        count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("List: "+ strings);
        System.out.println("Empty Strings: "+ count);








    }

    private static int getCountEmptyStringUsingJava7(List<String> strings){
        int count = 0;
        for (String string: strings) {
            if (string.isEmpty()){
                count++;
            }
        }
        return count;
    }

    private static int getCountLength3UsingJava7(List<String> strings){
        int count = 0;

        for (String string: strings) {
            if (string.length() == 3){
                count++;
            }
        }
        return count;
    }

    private static List<String> deleteEmptyStringUsingJava7(List<String> strings){
        List<String> filteredList = new ArrayList<String>();

        for (String string: strings) {
            if (!string.isEmpty()) {
                filteredList.add(string);
            }
        }
        return filteredList;
    }


    private static String getMergedStringUsingJava7(List<String> strings, String separator){
        StringBuilder stringBuilder = new StringBuilder();
        for (String string:strings) {
            if (!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-2);
    }

    private static List<Integer> getSquares(List<Integer> numbers){
        List<Integer> squaresList = new ArrayList<Integer>();
        for (Integer number:numbers) {
            Integer square = new Integer(number.intValue() * number.intValue());
            if (!squaresList.contains(square)){
                squaresList.add(square);
            }
        }
        return  squaresList;
    }

    private static int getMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number.intValue() > max){
                max = number.intValue();
            }
        }
        return max;
    }

    private static int getMin(List<Integer> numbers){
        Integer min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min ){
                min = numbers.get(i);
            }
        }
        return min;
    }

    private static int getSum(List<Integer> numbers){
        Integer sum = numbers.get(0);
        for (int i = 1; i <numbers.size() ; i++) {
            sum += numbers.get(i);
        }
        return sum.intValue();
    }

    private static int getAverage(List<Integer> numbers){
        return getSum(numbers)/numbers.size();
    }
}
