package io.fabric8.crd.example.joke;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("samples.javaoperatorsdk.io")
@Version("v1alpha1")
@JsonInclude(Include.NON_NULL)
public class Joke extends CustomResource<Void, Void> implements Namespaced {
    private String joke;
    private String category;
    private boolean safe;
    private String lang;
    private int id;

    public Joke() {
    }

    public Joke(int id, String joke, String category, boolean safe, String lang) {
        this.id = id;
        getMetadata().setName("" + id);
        this.joke = joke;
        this.category = category;
        this.safe = safe;
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
