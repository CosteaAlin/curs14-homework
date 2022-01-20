package ro.fasttrackit;

import java.util.Objects;

public class Quote {
    private final int id;
    private final String author;
    private final String quote;
    private boolean favourite;

    public Quote(int id, String author, String quote, boolean favourite) {
        this.id = id;
        this.author = author == null
                ? "No name"
                : author;
        this.quote = quote == null
                ? "No quote"
                : quote;
        this.favourite=favourite;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                ", favourite=" + favourite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return id == quote1.id && favourite == quote1.favourite && Objects.equals(author, quote1.author) && Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, quote, favourite);
    }
}
