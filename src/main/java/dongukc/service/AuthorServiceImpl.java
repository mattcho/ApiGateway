package dongukc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import dongukc.model.Author;

public class AuthorServiceImpl implements AuthorService {
	
	@Value("${service.author.uri}")
	private String authorServiceUri;

	@Override
	public Author findByName(String name) {
		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri + "/name?name=" + name;
    	Author author = restTemplate.getForObject(uri, Author.class);
    	return author;
	}

	@Override
	public Author save(String authorName) {
		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri;
    	return restTemplate.postForObject(uri, authorName, Author.class);
	}

	public Author findById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri + "/" + id;
    	Author author = restTemplate.getForObject(uri, Author.class);
    	return author;
	}

}
