import java.util.*;


public class Main {
    public static void main(String[] args) {
        long SIZE = 10000000;
        System.out.printf("Hello and welcome!\n");
        ArrayList<Student> studentsArr = new ArrayList<Student>();
        LinkedList<Student> studentsList = new LinkedList<Student>();
        HashMap<Long, Student> studentsMap = new HashMap<Long, Student>();
        HashSet<Student> studentsSet = new HashSet<Student>();
        String[] names = {
                "Name",
        };

        for (long i = 0; i < SIZE; i++) {
            Student student = new Student((long) i, names[0]);
            studentsArr.add(student);
            studentsList.add(student);
            studentsMap.put(i, student);
            studentsSet.add(student);
        }

        addLastInCollections(SIZE, names, studentsArr, studentsList, studentsMap, studentsSet);
        System.out.println("\n---------------\n");
        addFirstInCollections((long) SIZE, names, studentsArr, studentsList, studentsMap, studentsSet);
        System.out.println("\n---------------\n");
        removeFirstFromCollections((long) SIZE, names, studentsArr, studentsList, studentsMap, studentsSet);
        System.out.println("\n---------------\n");
        removeLastFromCollections((long) SIZE, names, studentsArr, studentsList, studentsMap, studentsSet);
        System.out.println("\n---------------\n");
        getCentralElement((long) SIZE, names, studentsArr, studentsList, studentsMap, studentsSet);
        System.out.println("\n---------------\n");
        getLastElement((long) SIZE, names, studentsArr, studentsList, studentsMap, studentsSet);

    }

    private static void addLastInCollections(long SIZE, String[] names,
                                             ArrayList<Student> studentsArr,
                                             LinkedList<Student> studentsList,
                                             HashMap<Long, Student> studentsMap,
                                             HashSet<Student> studentsSet) {
        long start, finish;
        // Array
        Student student = new Student(SIZE, names[0]);
        start = System.nanoTime();
        studentsArr.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в конец array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        studentsList.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в конец list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        studentsMap.put(SIZE, student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в конец map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        studentsSet.add(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления в конец set = %d нс\n", finish - start);
    }

    private static void addFirstInCollections(long SIZE, String[] names,
                                              ArrayList<Student> studentsArr,
                                              LinkedList<Student> studentsList,
                                              HashMap<Long, Student> studentsMap,
                                              HashSet<Student> studentsSet) {
        long start, finish;
        // Array
        Student student = new Student((long) -1, names[0]);
        start = System.nanoTime();
        studentsArr.addFirst(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        studentsList.addFirst(student);
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        studentsMap.put((long) -1, student); // Todo made
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        studentsSet.add(student); // Todo made
        finish = System.nanoTime();
        System.out.printf("Время добавления первого элемента в set = %d нс\n", finish - start);
    }

    private static void removeFirstFromCollections(long SIZE, String[] names,
                                                   ArrayList<Student> studentsArr,
                                                   LinkedList<Student> studentsList,
                                                   HashMap<Long, Student> studentsMap,
                                                   HashSet<Student> studentsSet) {
        long start, finish;
        Student student = studentsArr.getFirst();
        // Array
        start = System.nanoTime();
        studentsArr.removeFirst();
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        studentsList.removeFirst();
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        studentsMap.remove(0);
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        studentsSet.remove(student);
        finish = System.nanoTime();
        System.out.printf("Время удаления первого элемента в set = %d нс\n", finish - start);
    }

    private static void removeLastFromCollections(long SIZE, String[] names,
                                                  ArrayList<Student> studentsArr,
                                                  LinkedList<Student> studentsList,
                                                  HashMap<Long, Student> studentsMap,
                                                  HashSet<Student> studentsSet) {
        long start, finish;
        Student student = studentsArr.getLast();
        // Array
        start = System.nanoTime();
        studentsArr.removeLast();
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        studentsList.removeLast();
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        studentsMap.remove(SIZE-1);
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        studentsSet.remove(student);
        finish = System.nanoTime();
        System.out.printf("Время удаления последнего элемента в set = %d нс\n", finish - start);
    }

    private static void getCentralElement(long SIZE, String[] names,
                                                   ArrayList<Student> studentsArr,
                                                   LinkedList<Student> studentsList,
                                                   HashMap<Long, Student> studentsMap,
                                                   HashSet<Student> studentsSet) {
        long start, finish;
        // Array
        start = System.nanoTime();
        Student studentFromArr = studentsArr.get((int) SIZE/2);
        finish = System.nanoTime();
        System.out.printf("Время поиска центрального элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        Student studentFromList = studentsList.get((int) SIZE/2);
        finish = System.nanoTime();
        System.out.printf("Время поиска центрального элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        Student studentFromMap = studentsMap.get(SIZE/2);
        finish = System.nanoTime();
        System.out.printf("Время поиска центрального элемента в map = %d нс\n", finish - start);

        // Set
        start = System.nanoTime();
        Student studentFromSet = getStudentById(studentsSet, studentFromArr);
        finish = System.nanoTime();
        System.out.printf("Время поиска центрального элемента в set = %d нс\n", finish - start);
    }

    private static void getLastElement(long SIZE, String[] names,
                                          ArrayList<Student> studentsArr,
                                          LinkedList<Student> studentsList,
                                          HashMap<Long, Student> studentsMap,
                                          HashSet<Student> studentsSet) {
        long start, finish;
        // Array
        start = System.nanoTime();
        Student studentFromArr = studentsArr.get((int) SIZE-1);
        finish = System.nanoTime();
        System.out.printf("Время поиска последнего элемента в array = %d нс\n", finish - start);

        // List
        start = System.nanoTime();
        Student studentFromList = studentsList.get((int) SIZE-1);
        finish = System.nanoTime();
        System.out.printf("Время поиска последнего элемента в list = %d нс\n", finish - start);

        // Map
        start = System.nanoTime();
        Student studentFromMap = studentsMap.get(SIZE-1);
        finish = System.nanoTime();
        System.out.printf("Время поиска последнего элемента в map = %d нс\n", finish - start);

        // Set

        start = System.nanoTime();
        Student studentFromSet = getStudentById(studentsSet, studentFromArr);
        finish = System.nanoTime();
        System.out.printf("Время поиска последнего элемента в set = %d нс\n", finish - start);
    }

    public static Student getStudentById(HashSet<Student> studentsSet, Student student) {
        for (Student man : studentsSet) {
            if (man.equals(student)) {
                return man;
            }
        }
        return student;
    }
}