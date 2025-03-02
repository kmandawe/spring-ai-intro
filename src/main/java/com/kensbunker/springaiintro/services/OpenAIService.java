package com.kensbunker.springaiintro.services;

import com.kensbunker.springaiintro.model.Answer;
import com.kensbunker.springaiintro.model.GetCapitalRequest;
import com.kensbunker.springaiintro.model.GetCapitalResponse;
import com.kensbunker.springaiintro.model.Question;

public interface OpenAIService {
  String getAnswer(String question);

  Answer getAnswer(Question question);

  GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

  Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
