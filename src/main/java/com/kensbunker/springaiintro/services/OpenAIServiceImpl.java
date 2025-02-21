package com.kensbunker.springaiintro.services;

import com.kensbunker.springaiintro.model.Answer;
import com.kensbunker.springaiintro.model.GetCapitalRequest;
import com.kensbunker.springaiintro.model.Question;
import java.util.Map;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class OpenAIServiceImpl implements OpenAIService {

  private final ChatModel chatModel;

  @Value("classpath:templates/get-capital-prompt.st")
  private Resource getCapitalPrompt;

  public OpenAIServiceImpl(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  @Override
  public String getAnswer(String question) {
    PromptTemplate promptTemplate = new PromptTemplate(question);
    Prompt prompt = promptTemplate.create();

    ChatResponse response = chatModel.call(prompt);
    return response.getResult().getOutput().getText();
  }

  @Override
  public Answer getAnswer(Question question) {
    System.out.println("I was called");
    PromptTemplate promptTemplate = new PromptTemplate(question.question());
    Prompt prompt = promptTemplate.create();

    ChatResponse response = chatModel.call(prompt);
    return new Answer(response.getResult().getOutput().getText());
  }

  @Override
  public Answer getCapital(GetCapitalRequest getCapitalRequest) {
    PromptTemplate promptTemplate =
        new PromptTemplate(getCapitalPrompt);
    Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", getCapitalRequest.stateOrCountry()));
    ChatResponse response = chatModel.call(prompt);
    return new Answer(response.getResult().getOutput().getText());
  }
}
