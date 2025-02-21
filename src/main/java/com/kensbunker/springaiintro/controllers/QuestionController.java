package com.kensbunker.springaiintro.controllers;

import com.kensbunker.springaiintro.model.Answer;
import com.kensbunker.springaiintro.model.Question;
import com.kensbunker.springaiintro.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

  private final OpenAIService openAIService;

  public QuestionController(OpenAIService openAIService) {
    this.openAIService = openAIService;
  }


  @PostMapping("/ask")
  public Answer askQuestion(@RequestBody Question question) {
    return openAIService.getAnswer(question);
  }
}
