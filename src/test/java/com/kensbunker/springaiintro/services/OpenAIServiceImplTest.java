package com.kensbunker.springaiintro.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest {

  @Autowired
  OpenAIService openAIService;

  @Test
  void getAnswer() {
    String answer = openAIService.getAnswer("It takes one person 5 hours to dig a 10 foot hole in the ground. How long would it take 5 people?");
    System.out.println("Got the answer");
    System.out.println(answer);
  }
}
