package main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

// Handler Method is a method that handles HTTP requests

@RestController
@RequestMapping("/info") // base path for all handler methods
public class MyController {

    private Map<Integer, String> users = Map.of(
            1, "Ivan",
            2, "Joro",
            3, "Hristo"
    );

    // HTTP GET /info/time-now
    // 1. Колко е часът сега?
    @GetMapping("/time-now")
    public String getTimeNow() {

        return "Time now is " + LocalTime.now();
    }

    // HTTP GET /info/today
    // 2. Ден от седмицата?
    @GetMapping("/today")
    public String getDayOfWeek() {

        return "Today is " + LocalDateTime.now().getDayOfWeek().name();
    }

    @GetMapping("/users/{id}")
    public String getUsernameById(@PathVariable int id, @RequestParam("fistName") String fistName, @RequestParam("age") int age) {

        return users.get(id);
    }
}
