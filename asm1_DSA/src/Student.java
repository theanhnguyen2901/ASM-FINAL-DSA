public class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 9) {
            return "Excellent student";
        } else if (marks >= 7) {
            return "Strong student";
        } else if (marks >= 6) {
            return "Good student";
        } else if (marks >= 5) {
            return "Weak student";
        } else {
            return "Failing student";
        }
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', marks=" + marks + ", grade=" + getGrade() + "}";
    }
}
