package dongukc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dongukc.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
//	@Value("${service.author.uri}")
	private String authorServiceUri = "http://authorService/api/author";

	@Override
	public Author findByName(String name) {
		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri + "/name?name=" + name;
    	Author author = restTemplate.getForObject(uri, Author.class);
    	return author;
	}

	@Override
	public Long save(Author a) {
		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri;
    	ResponseEntity<Long> re = restTemplate.postForEntity(uri, a, Long.class);
    	return re.getBody();
	}

	public Author findById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri + "/" + id;
    	Author author = restTemplate.getForObject(uri, Author.class);
    	return author;
	}

}
