package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {
    @Autowired // IOC 控制反转 本来courseService 是由java 控制的 现在spring 帮助控制 courseservice
            CourseService courseService; // Singleton bean 的封装

    @GetMapping(path = "/getAll", produces = "application/json")
    public HttpEntity findAllCourses() {
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @PostMapping(path = "/add", produces = "application/json")
    public HttpEntity<Course> addClass(@RequestBody Course newClass) {
        List<Course> newList = courseService.addClass(newClass);
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete", produces = "application/json")
    public HttpEntity<Course> deleteClass(@RequestBody Course unwantedClass) {
        List<Course> newList = courseService.deleteClass(unwantedClass);
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PutMapping(path = "/put", produces = "application/json")
    public HttpEntity<Course> updateClass(@RequestBody List<Course> changeForm) {
        List<Course> newList = courseService.updateClass(changeForm);
        return new ResponseEntity(newList, HttpStatus.OK);
    }


}
