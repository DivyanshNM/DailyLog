package com.DailyLog.retrieval.AI;

import dev.langchain4j.model.ollama.OllamaChatModel;

public class OllamaTest {

    public static void main(String[] args) {

        OllamaChatModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("qwen2.5:7b")
                .build();

        String response = model.chat("Explain JWT in simple words.");

        System.out.println(response);
    }
}