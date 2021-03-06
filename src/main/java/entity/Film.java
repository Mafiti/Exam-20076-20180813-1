package entity;

/**
 *
 * @author TAO
 * @date 2018/8/13
 */
public class Film {

    private int filmId;
    private String title;
    private String description;
    private String language;

    public Film() {
    }

    public Film(int filmId, String title, String description, String language) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.language = language;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
