package com.magroun.chatgpt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import com.magroun.chatgpt.dto.ChatRequest;
import com.magroun.chatgpt.dto.ChatResponse;

@RestController
public class ChatController {

    @Autowired
    private WebClient openaiWebClient;

    @Value("${openai.model}")
    private String model;

    @GetMapping("/chat")
    public Mono<String> chat(@RequestParam String prompt) {
        ChatRequest request = new ChatRequest(model, prompt);

        return openaiWebClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .map(response -> {
                    if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
                        return "No response";
                    }
                    return response.getChoices().get(0).getMessage().getContent();
                });
    }
}
