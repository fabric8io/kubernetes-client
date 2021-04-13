package io.fabric8.crd.example.joke;

public class JokeRequestSpec {
    public enum Category {
        Any,
        Misc,
        Programming,
        Dark,
        Pun,
        Spooky,
        Christmas
    }

    public enum ExcludedTopic {
        nsfw,
        religious,
        political,
        racist,
        sexist,
        explicit
    }

    private Category category = Category.Any;
    private ExcludedTopic[] excluded = new ExcludedTopic[] { ExcludedTopic.nsfw, ExcludedTopic.racist, ExcludedTopic.sexist };
    private boolean safe;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ExcludedTopic[] getExcluded() {
        return excluded;
    }

    public void setExcluded(ExcludedTopic[] excluded) {
        this.excluded = excluded;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}
