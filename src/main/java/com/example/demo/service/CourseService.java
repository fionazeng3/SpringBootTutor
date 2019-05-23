package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses(){

        return courseRepository.findAllClasses();
    }

    public List<Course> addClass(Course newClass) {
        return courseRepository.addClass(newClass);
    }

    public List<Course> deleteClass(Course unwantedClass) {
        return courseRepository.deleteClass(unwantedClass);
    }

    public List<Course> updateClass(List<Course> changeForm) {
        return courseRepository.updateClass(changeForm);
    }



}
