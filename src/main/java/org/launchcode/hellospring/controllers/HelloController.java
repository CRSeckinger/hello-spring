package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@Controller
//@ResponseBody
//@RequestMapping("hello")
public class HelloController {

    //Handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //now lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    //create a Handler that handles requests as a form /Hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    //handles a request of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    //lives at /form
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'POST'>" +
                "<input type = 'text' name = 'name' />" +
                "<select name='languages' id=language-select>" +
                "    <option value='choice'>Please choose a language</option>" +
                "    <option value='english'>English</option>" + //hello
                "    <option value='french'>French</option>" + //bonjour
                "    <option value='german'>German</option>" + //guten tag
                "    <option value='italian'>Italian</option>" + //ciao
                "    <option value='spanish'>Spanish</option>" + //hola
                "    <option value='hungarian'>Hungarian</option>" + //szia
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("hello")
    @ResponseBody
    public String sayHello(@RequestParam String name, @RequestParam String languages) {
        return createMessage(name, languages);
    }

    public static String createMessage(String name, String languages) {
        String result = "";
        if (languages.equals("english")) {
            result = "Hello " + name;
        } else if (languages.equals("french")) {
            result = "Bonjour " + name;
        } else if (languages.equals("german")) {
            result = "Guten Tag " + name;
        } else if (languages.equals("italian")) {
            result = "Ciao " + name;
        } else if (languages.equals("spanish")) {
            result = "Hola " + name;
        } else if (languages.equals("hungarian")) {
            result = "Szia " + name;
        } if (languages.equals("choices")) {
            result = name + "Pick a language";
        }
        return result;
    }

}
