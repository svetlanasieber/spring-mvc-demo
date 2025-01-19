package main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;



@RestController
@RequestMapping("/info") 
public class MyController {

    private Map<Integer, String> users = Map.of(
            1, "Ivan",
            2, "Joro",
            3, "Hristo"
    );


    @GetMapping("/time-now")
    public String getTimeNow() {

        return "Time now is " + LocalTime.now();
    }


    @GetMapping("/today")
    public String getDayOfWeek() {

        return "Today is " + LocalDateTime.now().getDayOfWeek().name();
    }

    @GetMapping("/users/{id}")
    public String getUsernameById(@PathVariable int id, @RequestParam("fistName") String fistName, @RequestParam("age") int age) {

        return users.get(id);
    }
}
