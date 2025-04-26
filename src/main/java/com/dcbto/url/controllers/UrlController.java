package com.dcbto.url.controllers;

import com.dcbto.url.model.Url;
import com.dcbto.url.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> value) {
        String originalUrl = value.get("url");
        String url = value.get(originalUrl);
        Map<String, String> response = new HashMap<String, String>();
        response.put("url", "https://xxx.com/"+url);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirectToOrigitalUrl(@PathVariable String shortUrl) {
        Optional<Url> urlOptional = urlService.getOriginalUrl(shortUrl);
        if (urlOptional.isPresent()) {
            Url url = urlOptional.get();
            System.out.println("Redirecting to original url: " + url.getOriginalUrl());
            return ResponseEntity.status(302).location(URI.create(url.getOriginalUrl())).build();
        }
        System.out.println("URL not found or expired: " + shortUrl);

        return ResponseEntity.notFound().build();
    }

}
