package dongukc.service;

import dongukc.model.Quote;

public interface QuoteService {
    public Quote randomQuote();
    public Iterable<Quote> getQuotesByAuthorId(Long authorId);
    public Quote save(Quote quote);
}