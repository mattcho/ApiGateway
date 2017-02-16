package dongukc.service;

import org.springframework.stereotype.Service;

import dongukc.model.Author;

@Service
public interface AuthorService {

    Author findByName(String name);
    Long save(Author author);
    Author findById(Long id);

}