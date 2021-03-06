package dongukc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dongukc.model.Author;
import dongukc.model.Quote;
import dongukc.service.AuthorService;
import dongukc.service.QuoteService;

@RestController
public class QuoteController {

    @Autowired
    private AuthorService authorService;
    
    @Autowired   
    private QuoteService quoteService;
    
    
    @RequestMapping("/api/quote/random")
    public Quote random() {
        return quoteService.randomQuote();
    }
    
    @RequestMapping("/api/quote/{author_id}")
    public Iterable<Quote> getInfo(@PathVariable("author_id") Long authorId) {
       return quoteService.getQuotesByAuthorId(authorId);
    }
    
    @RequestMapping(value = "/api/quote", method = RequestMethod.POST)
    public void saveQuote(@RequestBody Quote quote) {
    	
        Author a = authorService.findByName(quote.getAuthorName());
        
        if (a == null) {
        	System.out.println("Saving author");
        	a = new Author(quote.getAuthorName());
        	authorService.save(a);
        	a = authorService.findByName(quote.getAuthorName());
        }
        
        quote.setAuthorId(a.getId());
        
        System.out.println("Saving quote");
        quoteService.save(quote);
    }
    
    @RequestMapping("/api/author/{author_id}")
    public Author getAuthor(@PathVariable("author_id") Long authorId) {
       return authorService.findById(authorId);
    }
}