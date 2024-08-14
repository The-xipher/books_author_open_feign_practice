package com.ust.feignclients;

import com.ust.dto.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "author-service")
public interface AuthorServiceClient {
    @GetMapping("api/v1/author/{id}")
    public Author getAuthorById(@PathVariable String id);

}
