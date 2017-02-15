package dongukc.service;

import org.springframework.stereotype.Service;

import dongukc.model.Author;

@Service
public interface AuthorService {

    Author findByName(String name);
    Author save(String authorName);
    Author findById(Long id);

}