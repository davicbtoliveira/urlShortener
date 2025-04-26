package com.dcbto.url.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcbto.url.model.Url;
import java.util.List;
import java.util.Optional;


@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{

    Optional<Url> findByShortUrl(String shortUrl);

} 
