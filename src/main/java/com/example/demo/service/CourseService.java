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

    public List<Course> addClass(String className) {
        return courseRepository.addClass(className);
    }

    public List<Course> deleteClass(String className) {
        return courseRepository.deleteClass(className);
    }

    public List<Course> updateClass(String fromName, String toName) {
        return courseRepository.updateClass(fromName, toName);
    }



}
