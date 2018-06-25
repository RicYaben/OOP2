package Week_7;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Week 6 – Problem 3
 * The third problem’s focus is on little bit more advanced use of Streams and Lambdas. Note that book (Deitel&Deitel)
 * can provide good help with achieving some of the tasks in this exercise.
 * In this exercise you will need to store details about students, group them by their gender and then output their
 * names in sorted fashion.
 *
 * Start by creating class ​Student​ with following fields:
 *  ● String first Name
 *  ● String last Name
 *  ● int age
 *  ● double gpa
 *  ● int gender1
 *  ● int nationality1
 *
 * On the input there will be ​N students and their details (see ​Input format for exact information). Store these in a
 * collection (​List<Student> is a suitable collection for this). Then use streams to groups ​Student​s by their gender
 * and store it in a collection (​Map<String, List<Students>>​ is a suitable collection). Then sort names in each gender
 * alphabetically and output them.
 *
 * Input format:
 *  ● Integer ​N​ - number of students to be added
 *  ● On ​N*5 ​following lines:
 *      ○ First name and last name (separated by a space) ○ age
 *      ○ GPA
 *      ○ gender2
 *      ○ nationality2
 * (1 ​For gender and nationality, also ​enum​s​ ​are suitable.)
 * (2 The gender and nationality are expressed as a number on the input (e.g. 0 for males, 1 for females etc.))
 *
 *
 * Output format:
 *  ● N full names (first name followed by last name, space separated), grouped by gender, sorted alphabetically by
 *    their last name in their respective group. If there is two people that have the same last name, sort them after
 *    their first name. Print a blank line after each group.
 */

class Student {

    private String firstName;
    private String lastName;
    private int gender;
    private int age;
    private double gpa;
    private int nationality;

    public Student(String firstName, String lastName, int age, double gpa, int gender, int nationality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.gpa = gpa;
        this.nationality = nationality;
    }

    public int getGender() {
        return gender;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

}

public class W7P3{
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        List<Student> list = new LinkedList<>();
        for(int index = 0; index < students; index ++){
            list.add(new Student(scanner.next(),
                    scanner.next(),
                    scanner.nextInt() ,
                    scanner.nextDouble(),
                    scanner.nextInt(),
                    scanner.nextInt())
            );
        }

        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student :: getGender));

        map.forEach((k,v) -> v.sort(Comparator.comparing(Student :: getLastName).thenComparing(Student :: getFirstName)));
        map.forEach((k,v) ->{
            v.forEach(Student -> System.out.println(Student.getFirstName() + " " + Student.getLastName()));
            System.out.println();
        });
    }
}
