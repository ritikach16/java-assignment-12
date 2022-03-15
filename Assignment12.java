import java.util.*;
import java.util.stream.Collectors;

public class Assignment12 {

    void printNamesOfDept(List<Student> st){
        st.stream().map(Student::deptName)
                .distinct()
                .forEach(System.out::println);
    }

    void getStudentsEnrolledAfter2018(List<Student> st){
        st.stream()
                .filter(s -> s.getYear() > 2018)
                .map(Student::studentName)
                .forEach(System.out::println);
    }

    void getMaleStudentInCS(List<Student> st){
      Long count = st.stream()
              .filter(s -> s.deptName().equalsIgnoreCase("Computer Science"))
              .filter(s -> s.getGender().equals("Male")).count();
        System.out.println( "Male Students in CS dept are "+ count);
    }

    void countMaleAndFemaleStudents(List<Student> st){
        Map<String, Long> mp= st.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        for(Map.Entry<String, Long> s : mp.entrySet()){
            System.out.println("Count of " + s.getKey() + " : " + s.getValue());
        }
    }

    void averageAgeOfMaleAndFemaleStudents(List<Student> st){
        Map<String, Double> mp =  st.stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.averagingInt(Student::getAge)
                ));

        for(Map.Entry<String, Double> s : mp.entrySet()){
            System.out.println(s.getKey() + " : " + s.getValue());
        }
    }

    void highestStudentDetail(List<Student> st){
        Optional<Student> hs = st.stream()
                 .max(Comparator.comparing(Student::getMarks));

        System.out.println(hs.get().studentName());
    }

    void noOfStudentInEachDept(List<Student> st){
        Map<String, Long> mp = st.stream()
                .collect(Collectors.groupingBy(Student::deptName, Collectors.counting()));

        for(Map.Entry<String, Long> s : mp.entrySet()){
            System.out.println("No. of student in dept " + s.getKey() + " : " + s.getValue());
        }
    }

    void avgPercentageInEachDept(List<Student> st){
        Map<String, Double> mp =  st.stream()
                .collect(Collectors.groupingBy(
                        Student::deptName,
                        Collectors.averagingDouble(Student::getMarks)
                ));

        for(Map.Entry<String, Double> s : mp.entrySet()){
            System.out.println("Avg percentage in dept " + s.getKey() + " : " + s.getValue());
        }
    }

    void getDetailOfYoungestMaleInElectronicDept(List<Student> st){
        Optional<Student> hs = st.stream()
                        .filter(s -> s.deptName().equalsIgnoreCase("Electronic"))
                        .filter(s -> s.getGender().equalsIgnoreCase("Male"))
                        .min(Comparator.comparing(Student::getAge));

        System.out.println( "Youngest Male in Electronic dept: " + hs.get().studentName());
    }

    void countMaleAndFemaleStudentsInCSDept(List<Student> st){
        Map<String, Long> mp = st.stream()
                .filter(s -> s.deptName().equalsIgnoreCase("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

        for(Map.Entry<String, Long> s : mp.entrySet()){
            System.out.println(s.getKey() + " : " + s.getValue());
        }

    }


    public static void main(String[] args) {
        List<Student> student = new ArrayList<>();
        student.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        student.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        student.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        student.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        student.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        student.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        student.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        student.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        student.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        student.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        student.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        student.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        student.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        student.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        student.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        student.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        student.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));


        Assignment12 first = new Assignment12();
        first.printNamesOfDept(student);


        Assignment12 second = new Assignment12();
        second.getStudentsEnrolledAfter2018(student);


        Assignment12 third = new Assignment12();
        third.getMaleStudentInCS(student);


        Assignment12 forth = new Assignment12();
        forth.countMaleAndFemaleStudents(student);


        Assignment12 fifth = new Assignment12();
        fifth.averageAgeOfMaleAndFemaleStudents(student);


        Assignment12 sixth = new Assignment12();
        sixth.highestStudentDetail(student);


        Assignment12 seventh = new Assignment12();
        seventh.noOfStudentInEachDept(student);


        Assignment12 eighth = new Assignment12();
        eighth.avgPercentageInEachDept(student);


        Assignment12 ninth = new Assignment12();
        ninth.getDetailOfYoungestMaleInElectronicDept(student);


        Assignment12 tenth = new Assignment12();
        tenth.countMaleAndFemaleStudentsInCSDept(student);
    }

}
