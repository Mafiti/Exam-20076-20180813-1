package entity;

/**
 *
 * @author TAO
 * @date 2018/8/13
 */
public class Language {

    private int languageId;
    private String LanguageName;

    public Language(int languageId, String languageName) {
        this.languageId = languageId;
        LanguageName = languageName;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (languageId != language.languageId) return false;
        return LanguageName != null ? LanguageName.equals(language.LanguageName) : language.LanguageName == null;
    }

    @Override
    public int hashCode() {
        int result = languageId;
        result = 31 * result + (LanguageName != null ? LanguageName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", LanguageName='" + LanguageName + '\'' +
                '}';
    }
}
