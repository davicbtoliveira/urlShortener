package com.dcbto.url.services;

import com.dcbto.url.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcbto.url.repositories.UrlRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repo;

    public String shortenUrl(String originalUrl) {

        String shortUrl = generateShortUrl();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setExpirationDate(LocalDateTime.now().plusDays(30));
        repo.save(url);
        return shortUrl;
    }

    public Optional<Url> getOriginalUrl(String shortUrl) {
        Optional<Url> url = repo.findByShortUrl(shortUrl);
        if(url.isPresent()) {
            Url originalUrl = url.get();
            if(originalUrl.getExpirationDate().isAfter(LocalDateTime.now())) {
                return Optional.of(originalUrl);
            }
            else {
                repo.delete(originalUrl);
            }
        }
        return Optional.empty();
    }


    public String generateShortUrl() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVXZWYabcdefghijklmnopqrstuvwxyz";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        int length = 5 + random.nextInt(6);
        for (int i = 0; i < length; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }
}
