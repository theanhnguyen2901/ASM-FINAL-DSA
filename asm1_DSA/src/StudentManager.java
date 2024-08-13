import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {
    private Map<String, Student> studentMap;

    public StudentManager() {
        studentMap = new HashMap<>();
    }

    public boolean addStudent(String id, String name, double marks) {
        if (studentMap.containsKey(id)) {
            return false;
        }
        studentMap.put(id, new Student(id, name, marks));
        return true;
    }

    public Student getStudent(String id) {
        return studentMap.get(id);
    }

    public boolean updateMarks(String id, double marks) {
        Student student = studentMap.get(id);
        if (student != null) {
            student.setMarks(marks);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        return studentMap.remove(id) != null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    // Merge Sort implementation with order control
    public List<Student> mergeSortStudentsByMarks(boolean ascending) {
        List<Student> students = getAllStudents();
        return mergeSort(students, ascending);
    }

    private List<Student> mergeSort(List<Student> list, boolean ascending) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, mid));
        List<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        return merge(mergeSort(left, ascending), mergeSort(right, ascending), ascending);
    }

    private List<Student> merge(List<Student> left, List<Student> right, boolean ascending) {
        List<Student> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((ascending && left.get(leftIndex).getMarks() <= right.get(rightIndex).getMarks()) ||
                    (!ascending && left.get(leftIndex).getMarks() > right.get(rightIndex).getMarks())) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }
}
