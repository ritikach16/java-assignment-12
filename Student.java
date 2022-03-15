public class Student{
    private int id;
    private String name;
    private int age;
    private String gender;
    private String engDepartment;
    private int enrollmentYear;
    private double perTillDate;

    Student(int id, String name, int age, String gender, String engDepartment, int enrollmentYear, double perTillDate){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.enrollmentYear = enrollmentYear;
        this.perTillDate = perTillDate;
    }

    public String deptName(){
        return engDepartment;
    }

    public int getYear(){
        return enrollmentYear;
    }

    public String studentName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }

    public double getMarks(){
        return perTillDate;
    }

}
