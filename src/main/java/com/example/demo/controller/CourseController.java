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

    @PostMapping(path = "/add/{inputString}", produces = "application/json")
    public HttpEntity<Course> addClass(@PathVariable("inputString") String className) {
        List<Course> newList = courseService.addClass(className);
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{inputString}", produces = "application/json")
    public HttpEntity<Course> deleteClass(@PathVariable("inputString") String className) {
        List<Course> newList = courseService.deleteClass(className);
        return new ResponseEntity(newList, HttpStatus.OK);
    }

    @PutMapping(path = "/put/{fromName}/{toName}", produces = "application/json")
    public HttpEntity<Course> updateClass(@PathVariable("fromName") String fromName, @PathVariable("toName") String toName) {
        List<Course> newList = courseService.updateClass(fromName, toName);
        return new ResponseEntity(newList, HttpStatus.OK);
    }


}
