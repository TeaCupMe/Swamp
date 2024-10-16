import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        int SIZE = 10000000;
        System.out.printf("Hello and welcome!\n");
        ArrayList<Student> students_arr = new ArrayList<Student>();
        LinkedList<Student> students_list = new LinkedList<Student>();
        HashMap<Long, Student> students_map = new HashMap<Long, Student>();
        HashSet<Student> students_set = new HashSet<Student>();
        String[] names = {
                "Джон", "Сэм", "Келли", "Линда", "Фред",
                "Курт", "Кэт", "Картер", "Шесть", "Кортана",
        };

        for (long i = 0; i < SIZE; i++) {
            Student student = new Student((long) i, names[0]);
            students_arr.add(student);
            students_list.add(student);
            students_map.put((long) i, student);
            students_set.add(student);
        }

        addLastInCollections((long) SIZE, names, students_arr, students_list, students_map, students_set);
        System.out.println("\n---------------\n");
        addFirstInCollections((long) SIZE, names, students_arr, students_list, students_map, students_set);
        System.out.println("\n---------------\n");
        removeFirstFromCollections((long) SIZE, names, students_arr, students_list, students_map, students_set);
        System.out.println("\n---------------\n");
        removeLastFromCollections((long) SIZE, names, students_arr, students_list, students_map, students_set);
    }

    private static void addLastInCollections(long SIZE, String[] names,
                                             ArrayList<Student> students_arr,
                                             LinkedList<Student> students_list,
                                             HashMap<Long, Student> students_map,
                                             HashSet<Student> students_set) {
        long start, finish;
        // Array
        Student student = new Student(SIZE, names[0]);
        start = System.nanoTime();
        students_arr.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        students_list.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        students_map.put(SIZE, student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        students_set.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в set = %d нс\n", finish - start);
    }

    private static void addFirstInCollections(long SIZE, String[] names,
                                              ArrayList<Student> students_arr,
                                              LinkedList<Student> students_list,
                                              HashMap<Long, Student> students_map,
                                              HashSet<Student> students_set) {
        long start, finish;
        // Array
        Student student = new Student(SIZE, names[0]);
        start = System.nanoTime();
        students_arr.addFirst(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        students_list.addFirst(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        students_map.put(SIZE, student);
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        students_set.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в set = %d нс\n", finish - start);
    }

    private static void removeFirstFromCollections(long SIZE, String[] names,
                                                   ArrayList<Student> students_arr,
                                                   LinkedList<Student> students_list,
                                                   HashMap<Long, Student> students_map,
                                                   HashSet<Student> students_set) {
        long start, finish;
        // Array
        start = System.nanoTime();
        students_arr.removeFirst();
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        students_list.removeFirst();
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        students_map.remove(0);
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в map = %d нс\n", finish - start);

        // Set

        Student student = getStudentById(students_set, (long) 0);
        start = System.nanoTime();
        students_set.remove(student);
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в set = %d нс\n", finish - start);
    }

    private static void removeLastFromCollections(long SIZE, String[] names,
                                                  ArrayList<Student> students_arr,
                                                  LinkedList<Student> students_list,
                                                  HashMap<Long, Student> students_map,
                                                  HashSet<Student> students_set) {
        long start, finish;
        Student student = students_arr.getLast();
        // Array
        start = System.nanoTime();
        students_arr.removeLast();
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        students_list.removeLast();
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        students_map.remove(SIZE-1);
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в map = %d нс\n", finish - start);

        // Set

        start = System.nanoTime();
        students_set.remove(student);
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в set = %d нс\n", finish - start);
    }

    public static Student getStudentById(HashSet<Student> students_set, Long id) {
        for (Student student : students_set) {
            if (student.getId() == id) {
                return student;
            }
        }
        return getStudentById(students_set, id+1);
    }
}