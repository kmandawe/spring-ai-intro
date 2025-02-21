package com.kensbunker.springaiintro.services;

import com.kensbunker.springaiintro.model.Answer;
import com.kensbunker.springaiintro.model.GetCapitalRequest;
import com.kensbunker.springaiintro.model.Question;

public interface OpenAIService {
  String getAnswer(String question);

  Answer getAnswer(Question question);

  Answer getCapital(GetCapitalRequest getCapitalRequest);
}
