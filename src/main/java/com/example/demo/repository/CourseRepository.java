package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {

    }

    public List<Course> addClass(String className) {
        Course javaOne = Course.builder()
                .className(className)
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
        return courses;

    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> deleteClass(String courseName) {
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getClassName().equals(courseName)) courses.remove(i);
        }
        return courses;
    }

    public List<Course> updateClass(String fromName, String toName) {
       this.deleteClass(fromName);
       this.addClass(toName);
        return courses;
    }


}
