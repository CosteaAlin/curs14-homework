package ro.fasttrackit;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/quotes.txt";
        QuotesService quotesService = new QuotesService(path);
        System.out.println(quotesService.getAllQuotes());
        System.out.println(quotesService.getQuotesForAuthor("Andy Warhol"));
        System.out.println(quotesService.getAuthors());
        quotesService.setFavourite(2);
        System.out.println(quotesService.getFavourites());
        System.out.println(quotesService.getRandomQuote());
    }
}
