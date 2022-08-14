package edu.mriabov.restproject.controller;


import edu.mriabov.restproject.model.Contact;
import edu.mriabov.restproject.model.Response;
import edu.mriabov.restproject.proxy.ContactProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {
    final ContactProxy contactProxy;
    final RestTemplate restTemplate;
    final WebClient webClient;

    @GetMapping("/getMessages")
    public List<Contact> getMessages(@RequestParam("status") String status) {
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestBody Contact contact) {
        String uri = "http://localhost:8080/api/contact/saveMsg";
        HttpHeaders headers = new HttpHeaders();
        headers.add("invocationFrom", "RestTemplate");
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact, headers);
        return restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Response.class);
    }

    @PostMapping("/saveMessage")
    public Mono<Response> saveMessage(@RequestBody Contact contact) {
        String uri = "http://localhost:8080/api/contact/saveMsg";
        return webClient.post().uri(uri)
                .header("invocationFrom", "WebClient")
                .body(Mono.just(contact),Contact.class)
                .retrieve()
                .bodyToMono(Response.class);

    }
}
