import java.io.File;
import java.io.PrintStream;
import java.util.*;


public class Main {
    static Timer t;
    static Formatter formatter;
    static int INITIAL_SIZE = 10000000;
    final static String conf = "all";//rrayList";
    final static boolean outputToFile = false;
    final static boolean updateList = true;


    static Student[] students;
    static ArrayList<Student> arrayList;
    static LinkedList<Student> linkedList;
    static HashSet<Student> hashSet;
    static HashMap<Integer, Student> hashMap;

    public static void main(String[] args) {

        t = new Timer();
        if (outputToFile) {
            try {
                System.setOut(new PrintStream(new File(conf + "_" + Integer.toString(INITIAL_SIZE) + ".txt")));
                Formatter.performFormat = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        t.start();

        initialize();
        fill();
        addLast();
        addFirst();
        deleteLast();
        deleteFirst();
        get(125);
        getMiddle();
        getLast();

    }

    static void initialize() {
        // Initialization
        // List
        t.setTaskTitle("Initialization");
        t.setNextCheckpoint("Array");
        students = new Student[INITIAL_SIZE];
        t.checkpoint();

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            arrayList = new ArrayList<>(INITIAL_SIZE);
            t.checkpoint();
        }
        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            linkedList = new LinkedList<>();
            t.checkpoint();
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
            hashSet = new HashSet<Student>((int) INITIAL_SIZE);
            t.checkpoint();
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            hashMap = new HashMap<>((int) INITIAL_SIZE);
            t.checkpoint();
        }
    }

    static void fill() {
        t.setTaskTitle("Fill");
        if (updateList) {
            t.setNextCheckpoint("Array");
            for (int i = 0; i < INITIAL_SIZE; i++) {
                students[i] = new Student(i, "Matvei");
            }
            t.checkpoint();

            // ArrayList
            if (conf == "arrayList" || conf == "all") {
                t.setNextCheckpoint("ArrayList");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    arrayList.add(students[i]);
                }
                t.checkpoint();
            }
            // LinkedList
            if (conf == "linkedList" || conf == "all") {
                t.setNextCheckpoint("LinkedList");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    linkedList.add(students[i]);
                }
                t.checkpoint();
            }

            // HashSet
            if (conf == "hashSet" || conf == "all") {
                t.setNextCheckpoint("HashSet");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    hashSet.add(students[i]);
                }
                t.checkpoint();
            }

            // HashMap
            if (conf == "hashMap" || conf == "all") {
                t.setNextCheckpoint("HashMap");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    hashMap.put(i, students[i]);
                }
                t.checkpoint();
            }
        } else {
            // ArrayList
            if (conf == "arrayList" || conf == "all") {
                t.setNextCheckpoint("ArrayList");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    arrayList.add(new Student(i, "Matvei"));
                }
                t.checkpoint();
            }

            // LinkedList
            if (conf == "linkedList" || conf == "all") {
                t.setNextCheckpoint("LinkedList");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    linkedList.add(new Student(i, "Matvei"));
                }
                t.checkpoint();
            }

            // HashSet
            if (conf == "hashSet" || conf == "all") {
                t.setNextCheckpoint("HashSet");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    hashSet.add(new Student(i, "Matvei"));
                }
                t.checkpoint();
            }

            // HashMap
            if (conf == "hashMap" || conf == "all") {
                t.setNextCheckpoint("HashMap");
                for (int i = 0; i < INITIAL_SIZE; i++) {
                    hashMap.put(i, new Student(i, "Matvei"));
                }
                t.checkpoint();
            }
        }
        // List

        if (!updateList) students = null;
    }

    static void addLast() {
        t.setTaskTitle("Add last");
        Student newbie = new Student(INITIAL_SIZE, "Motviy");

        // List
        if (updateList) {

            t.setNextCheckpoint("Array");
            Student[] backup = students.clone();
            students = new Student[students.length + 1];
            System.arraycopy(backup, 0, students, 0, backup.length);
            students[backup.length] = newbie;
            t.checkpoint();
        }

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            arrayList.add(newbie);
            t.checkpoint();
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            linkedList.addLast(newbie);
            t.checkpoint();
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
            hashSet.add(newbie);
            t.checkpoint();
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            hashMap.put(newbie.id.intValue(), newbie);
            t.checkpoint();
        }
    }

    static void addFirst() {
        t.setTaskTitle("Add first");
        Student newbie = new Student(INITIAL_SIZE + 1, "Motya");

        // List
        if (updateList) {
            t.setNextCheckpoint("Array");
            Student[] backup = students.clone();
            students = new Student[students.length + 1];
            System.arraycopy(backup, 0, students, 1, backup.length);
            students[0] = newbie;
            t.checkpoint();
        }

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            arrayList.add(0, newbie);
            t.checkpoint();
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            linkedList.addFirst(newbie);
            t.checkpoint();
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
            hashSet.add(newbie);
            t.checkpoint();
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            hashMap.put(newbie.id.intValue(), newbie);
            t.checkpoint();
        }
    }

    static void deleteLast() {
        t.setTaskTitle("Delete last");

        // List
        if (updateList) {
            t.setNextCheckpoint("List (no size change)");
            students[students.length - 1] = null;
            t.checkpoint();

            t.setNextCheckpoint("List (with size change)");
            Student[] backup = students.clone();
            students = new Student[students.length - 1];
            if (backup.length - 1 >= 0) System.arraycopy(backup, 0, students, 0, backup.length - 1);
            t.checkpoint();
        }

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            arrayList.remove(arrayList.size() - 1);
            t.checkpoint();
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            linkedList.removeLast();
            t.checkpoint();
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
            Student last = null;
            Iterator<Student> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                last = iterator.next();
                if (last.id == hashSet.size() - 1) {
                    break;
                }
            }
            hashSet.remove(last);
            t.checkpoint();
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            hashMap.remove(hashMap.size() - 1);
            t.checkpoint();
        }
    }

    static void deleteFirst() {
        t.setTaskTitle("Delete first");

        // List
        if (updateList) {
            t.setNextCheckpoint("List (no size change)");
            students[0] = null;
            t.checkpoint();

            t.setNextCheckpoint("List (with size change)");
            Student[] backup = students.clone();
            students = new Student[students.length - 1];
            if (backup.length - 1 >= 0) System.arraycopy(backup, 1, students, 0, backup.length - 1);
            t.checkpoint();
        }

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            arrayList.remove(0);
            t.checkpoint();
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            linkedList.removeFirst();
            t.checkpoint();
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
            Student last = null;
            Iterator<Student> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                last = iterator.next();
                if (last.id == 0) {
                    break;
                }
            }
            hashSet.remove(last);
            t.checkpoint();
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            hashMap.remove(0);
            t.checkpoint();
        }
    }

    static void get(int id) {
        t.setTaskTitle(String.format("Get element %d", id));
        Student target = null;

        // List
        if (updateList) {
            t.setNextCheckpoint("Array");
            target = students[id];
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }


        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            target = arrayList.get(id);
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            target = linkedList.get(id);
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
//            Student last = null;
            Iterator<Student> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                target = iterator.next();
                if (target.id == id) {
                    break;
                }
            }
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            target = hashMap.get(id);
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }
    }

    static void getMiddle() {
        get(INITIAL_SIZE / 2);
    }

    static void getLast() {
        t.setTaskTitle("Get Last");
        Student target = null;

        // List
        if (updateList) {
            t.setNextCheckpoint("Array");
            target = students[students.length - 1];
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
        }

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");
            target = arrayList.get(arrayList.size() - 1);
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");
            target = linkedList.getLast();
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");
//            Student last = null;
            Iterator<Student> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                target = iterator.next();
                if (target.id == hashSet.size() - 1) {
                    break;
                }
            }
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");
            target = hashMap.get(hashMap.size() - 1);
            t.checkpoint();
            System.out.println("\tFound student: " + Student.toString(target));
            target = null;
        }
    }

    static void template() {
        t.setTaskTitle("new");

        // List
        t.setNextCheckpoint("Array");

        t.checkpoint();

        // ArrayList
        if (conf == "arrayList" || conf == "all") {
            t.setNextCheckpoint("ArrayList");

            t.checkpoint();
        }

        // LinkedList
        if (conf == "linkedList" || conf == "all") {
            t.setNextCheckpoint("LinkedList");

            t.checkpoint();
        }

        // HashSet
        if (conf == "hashSet" || conf == "all") {
            t.setNextCheckpoint("HashSet");

            t.checkpoint();
        }

        // HashMap
        if (conf == "hashMap" || conf == "all") {
            t.setNextCheckpoint("HashMap");

            t.checkpoint();
        }
    }
}
