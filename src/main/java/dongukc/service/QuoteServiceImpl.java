package dongukc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dongukc.model.Quote;

@Service
public class QuoteServiceImpl implements QuoteService {
	
//	@Value("${service.quote.uri}")
//	private String quoteServiceUri;
	private String quoteServiceUri = "http://quoteService/api/quote";
	
	@Autowired
    RestTemplate restTemplate;
	   
    @Override
    public Quote randomQuote() {
    	
    	System.out.println("random Quote!");
    	
//    	RestTemplate restTemplate = new RestTemplate();
    	String uri = quoteServiceUri + "/random";
    	
    	System.out.println(uri);
    	
    	Quote quote = restTemplate.getForObject(uri, Quote.class);
    	return quote;
    }
    
    @Override
    public Iterable<Quote> getQuotesByAuthorId(Long authorId) {
//    	RestTemplate restTemplate = new RestTemplate();
    	String uri = quoteServiceUri + "/" + authorId;
    	List<Quote> list = restTemplate.getForObject(uri, ArrayList.class);
    	return list;
    }

	@Override
	public Quote save(Quote quote) {
//		RestTemplate restTemplate = new RestTemplate();
    	String uri = quoteServiceUri;
    	return restTemplate.postForObject(uri, quote, Quote.class);
	}
}

