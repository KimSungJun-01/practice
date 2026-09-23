package com.practice.shared.member.out;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MemberApiClient {
    private final RestClient restclient = RestClient.builder()
            .baseUrl("http://localhost:8080/api/v1/member")
            .build();

    public String getRandomSecureTip() {
        return restclient.get()
                .uri("/members/randomSecureTip")
                .retrieve()
                .body(String.class);
    }
}
