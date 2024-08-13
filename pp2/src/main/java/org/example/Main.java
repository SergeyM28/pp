package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("ArrayLists: ");
        List<Integer> numbers1 = generateArrayList(10, 10);
        System.out.println(numbers1);
        List<Integer> numbers2 = generateArrayList(2, 10);
        System.out.println(numbers2);
        numbers1.addAll(numbers2);
        System.out.println(numbers1);
        numbers1.set(1, 100);
        System.out.println(numbers1);

        System.out.println();

        List<Integer> numbers3 = generateLinkedList(10, 10);
        System.out.println(numbers3);
        System.out.println(numbers3.lastIndexOf(10));

        //Операции с ArrayList
        System.out.println("Big ArrayList:");
        List<Integer> numbers4 = generateArrayList(100000000, 10);
        long startTime = System.currentTimeMillis();
        numbers4.add(1, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("First operation time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        int counter = 0;
        for(int elem : numbers4){
            if(elem == 10){
                counter += 1;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Second operation time: " + (endTime - startTime));
        System.out.println("Counter = " + counter);

        //Операции с LinkedList
        System.out.println("Big LinkedList:");
        List<Integer> numbers5 = generateLinkedList(100000000, 10);
        startTime = System.currentTimeMillis();
        numbers5.add(1, 1);
        endTime = System.currentTimeMillis();
        System.out.println("First operation time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        counter = 0;
        for(int elem : numbers5){
            if(elem == 10){
                counter += 1;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Second operation time: " + (endTime - startTime));
        System.out.println("Counter = " + counter);

        System.out.println(
    """
    \nДействительно наблюдаем, 
    что итерироваться по ArrayList быстрее, 
    а добавлять элемент в него дольше,
    чем в LinkedList\n
    """
        );
    }
    static List<Integer> generateArrayList (int size, int maxValue){
        List<Integer> myArrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++){
            myArrayList.add(random.nextInt(0, maxValue + 1));
        }
        return myArrayList;
    }

    static List<Integer> generateLinkedList (int size, int maxValue){
        List<Integer> myLinkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++){
            myLinkedList.add(random.nextInt(0, maxValue + 1));
        }
        return myLinkedList;
    }
}