package co.gobd.gofetch.model;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class Order {
    private String[] genre;

    private String title;

    private String image;

    private String rating;

    private String releaseYear;

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Order [genre = " + genre + ", title = " + title + ", image = " + image + ", rating = " + rating + ", releaseYear = " + releaseYear + "]";
    }
}