package com.oryanend.checker.controller;

import com.oryanend.checker.entities.Answer;
import com.oryanend.checker.services.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {
    @Autowired
    private AiService aiService;

    @PostMapping("/ask")
    public Answer ask(@RequestBody String answer) {
        return aiService.ask(answer);
    }
}
