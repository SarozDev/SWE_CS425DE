package edu.miu.cs.cs425.demos.studentrecordsmgmtapp;

import edu.miu.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = {
                new Student(110001, "Dave", LocalDate.of(1951,11,18)),
                new Student(110002, "Anna", LocalDate.of(1990,12,7)),
                new Student(110003, "Erica", LocalDate.of(1974,1,31)),
                new Student(110004, "Carlos", LocalDate.of(2009,8,22)),
                new Student(110005, "Bob", LocalDate.of(1990,3,5))
        };

//        System.out.println("Student Records: ");
//        for (Student student: students){
//            System.out.println(student);
//        }
        printListOfStudents(students);

        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);
        System.out.println("\nList of Platinum Alumni Students:");
        for (Student student:platinumAlumniStudents){
            System.out.println(student);
        }
    }

    public static void printListOfStudents(Student[] students){
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("List of Students:");
        for (Student student: students){
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students){
        List<Student> platinumAlumniStudents = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Student student: students){
            if(student.getDateOfAdmission().isBefore(currentDate.minusYears(30))){
                platinumAlumniStudents.add(student);
            }
        }

        platinumAlumniStudents.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
        return  platinumAlumniStudents;
    }
}

