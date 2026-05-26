package com.oryanend.checker.services;

import com.oryanend.checker.entities.Answer;

import dev.langchain4j.model.chat.ChatLanguageModel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiService {

    private final ChatLanguageModel groqModel;
    private final ChatLanguageModel openRouterModel;
    private final ChatLanguageModel claudeModel;

    public AiService(
            @Qualifier("groqModel")
            ChatLanguageModel groqModel,

            @Qualifier("openRouterModel")
            ChatLanguageModel openRouterModel,

            @Qualifier("claudeModel")
            ChatLanguageModel claudeModel
    ) {
        this.groqModel = groqModel;
        this.openRouterModel = openRouterModel;
        this.claudeModel = claudeModel;
    }

    public Answer ask(String question) {

        String prompt = """
                Você é especialista em ENADE.

                Escolha apenas UMA alternativa correta.

                Que seja simples e direto, não dê nenhuma explicação.
                
                Foque apenas na alternativa.
                
                QUESTÃO:
                """ + question;

        String groqResponse = groqModel.generate(prompt);
        String openRouterResponse = openRouterModel.generate(prompt);
        String claudeResponse = openRouterModel.generate(prompt);

        Map<String, String> answers = new HashMap<>();
        answers.put("groq", groqResponse);
        answers.put("openRouter", openRouterResponse);
        answers.put("claude", claudeResponse);

        boolean same = groqResponse.trim().equalsIgnoreCase(openRouterResponse.trim());
        return new Answer(answers, same);
    }
}