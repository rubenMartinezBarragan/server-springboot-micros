package com.ccsw.tutorialgame.author;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ccsw.tutorialgame.author.model.AuthorDto;

@FeignClient(value = "SPRING-CLOUD-EUREKA-CLIENT-AUTHOR", url = "http://localhost:8080")
public interface AuthorClient {

	@GetMapping(value = "/author")
	List<AuthorDto> findAll();
}
