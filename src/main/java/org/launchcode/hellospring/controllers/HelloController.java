package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //create a Handler that handles requests as a form /Hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, "+ name + "!";
    }

    //handles a request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam (@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" +
                "<input type = 'text' name = 'name' />" +
                "<select name=\"languages\" id=\"language-select\">" +
                "    <option value=\"\">--Please choose a language--</option>\n" +
                "    <option value=\"english\">English</option>\n" + //hello
                "    <option value=\"french\">French</option>\n" + //bonjour
                "    <option value=\"german\">German</option>\n" + //guten tag
                "    <option value=\"italian\">Italian</option>\n" + //ciao
                "    <option value=\"spanish\">Spanish</option>\n" + //hola
                "    <option value=\"hungarian\">Hungarian</option>\n" + //szia
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
