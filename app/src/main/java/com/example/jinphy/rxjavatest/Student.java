package com.example.jinphy.rxjavatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinphy on 2017/7/25.
 */

public class Student {
    public static int id=0;
    private String name;
    private List<Course> courses;

    public static List<Student> getStudents() {
        List<Student> list = new ArrayList<>(10);
        for (int i=0;i<10;i++) {
            list.add(new Student());

        }
        return list;
    }

    public Student() {
        name = "name:"+id;
        courses = new ArrayList<>(10);
        for (int j=0;j<10;j++) {
            courses.add(new Course("course "+j+" of student "+id));
        }
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
