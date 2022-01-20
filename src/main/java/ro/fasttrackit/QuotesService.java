package ro.fasttrackit;

import ro.fasttrackit.exceptions.InvalidIdException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuotesService {
    private final List<Quote> quotes;

    public QuotesService(String path) {
        this.quotes = path == null
                ? new ArrayList<>()
                : Engine.readData(path);
    }

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getQuote());
        }
        return result;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getAuthor().equalsIgnoreCase(author)) {
                result.add(quote);
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getAuthor());
        }
        return result;
    }

    public void setFavourite(int id) {
        for (Quote quote : quotes) {
            if (id == quote.getId()) {
                quote.setFavourite(true);
                return;
            }
        }
        throw new InvalidIdException("The id you entered doesn't exist");
    }

    public List<Quote> getFavourites() {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.isFavourite()) {
                result.add(quote);
            }
        }
        return result;
    }

    public String getRandomQuote() {
        Random rnd = new Random();
        int quoteId = rnd.nextInt(quotes.size());
        for (Quote quote : quotes) {
            if (quote.getId() == quoteId) {
                return quote.getQuote();
            }
        }
        throw new InvalidIdException("Something went wrong.");
    }

    @Override
    public String toString() {
        return "QuotesService{" +
                "quotes=" + quotes +
                '}';
    }
}
