package dongukc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import dongukc.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
//	@Value("${service.author.uri}")
//	private String authorServiceUri;
	private String authorServiceUri = "http://authorservice/api/author";
	
	@Autowired
    RestTemplate restTemplate;

	@Override
	public Author findByName(String name) {
//		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri + "/name?name=" + name;
    	Author author = restTemplate.getForObject(uri, Author.class);
    	return author;
	}

	@Override
	public Long save(Author a) {
//		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri;
    	ResponseEntity<Long> re = restTemplate.postForEntity(uri, a, Long.class);
    	return re.getBody();
	}
	
	@HystrixCommand(fallbackMethod = "reliableFindById")
	public Author findById(Long id) {
//		RestTemplate restTemplate = new RestTemplate();
    	String uri = authorServiceUri + "/" + id;
    	Author author = restTemplate.getForObject(uri, Author.class);
    	return author;
	}
	
	public Author reliableFindById(Long id) {
		Author a = new Author("Mr. Reliable");
		return a;
	}
}