package com.example.service;

import com.example.config.GreetConfig;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.Map;

@Service
public class GreetService {

    private final GreetConfig greetConfig;

    public GreetService(GreetConfig greetConfig) {
        this.greetConfig = greetConfig;
    }

    public String getGreeting(String name, String locale) {
        String timeOfDay = getTimeOfDay();
        Map<String, String> greetings = greetConfig.getTimes().get(timeOfDay);
        String greetingTemplate = greetings.getOrDefault(locale, greetings.get("en"));
        return greetingTemplate.replace("{name}", name);
    }

    private String getTimeOfDay() {
        LocalTime now = LocalTime.now();
        if (now.isBefore(LocalTime.NOON)) {
            return "morning";
        } else if (now.isBefore(LocalTime.of(17, 0))) {
            return "afternoon";
        } else {
            return "evening";
        }
    }
}
