public class Student {
    Long id;
    String name;
    Student(long _id, String _name) {
        id = _id;
        name = _name;
    }

    static String toString(Student student) {
        return Formatter.format(String.format("Student {id: %d, name: %s}", student.id, student.name), "I", "Y");
    }



}
