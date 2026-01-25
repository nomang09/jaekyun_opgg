package com.staredu.grammar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name) {
        return "hello " + name;
    }

    static class Hello{
        private String name;
        private Integer age;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public Integer getAge(){
            return age;
        }

        public void setAge(Integer age){
            this.age = age;
        }
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
    }
}
