package com.oryanend.checker.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Value("${groq.api-key}")
    private String groqApiKey;

    @Value("${openrouter.api-key}")
    private String openRouterApiKey;

    @Value("${claude.api-key}")
    private String claudeApiKey;

    @Bean(name = "groqModel")
    public ChatLanguageModel groqModel() {

        return OpenAiChatModel.builder()
                .apiKey(groqApiKey)
                .baseUrl("https://api.groq.com/openai/v1")
                .modelName("llama-3.3-70b-versatile")
                .build();
    }

    @Bean(name = "openRouterModel")
    public ChatLanguageModel openRouterModel() {

        return OpenAiChatModel.builder()
                .apiKey(openRouterApiKey)
                .baseUrl("https://openrouter.ai/api/v1")
                .modelName("google/gemma-3-4b-it")
                .build();
    }

    @Bean(name = "claudeModel")
    public ChatLanguageModel claudeModel() {

        return OpenAiChatModel.builder()
                .apiKey(claudeApiKey)
                .baseUrl("https://openrouter.ai/api/v1")
                .modelName("openai/gpt-3.5-turbo")
                .build();
    }
}
