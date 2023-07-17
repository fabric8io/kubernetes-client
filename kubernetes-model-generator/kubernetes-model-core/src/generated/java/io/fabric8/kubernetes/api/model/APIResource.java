
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "categories",
    "group",
    "name",
    "namespaced",
    "shortNames",
    "singularName",
    "storageVersionHash",
    "verbs",
    "version"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class APIResource implements KubernetesResource
{

    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> categories = new ArrayList<String>();
    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespaced")
    private Boolean namespaced;
    @JsonProperty("shortNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> shortNames = new ArrayList<String>();
    @JsonProperty("singularName")
    private String singularName;
    @JsonProperty("storageVersionHash")
    private String storageVersionHash;
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verbs = new ArrayList<String>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public APIResource() {
    }

    public APIResource(List<String> categories, String group, String kind, String name, Boolean namespaced, List<String> shortNames, String singularName, String storageVersionHash, List<String> verbs, String version) {
        super();
        this.categories = categories;
        this.group = group;
        this.kind = kind;
        this.name = name;
        this.namespaced = namespaced;
        this.shortNames = shortNames;
        this.singularName = singularName;
        this.storageVersionHash = storageVersionHash;
        this.verbs = verbs;
        this.version = version;
    }

    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("namespaced")
    public Boolean getNamespaced() {
        return namespaced;
    }

    @JsonProperty("namespaced")
    public void setNamespaced(Boolean namespaced) {
        this.namespaced = namespaced;
    }

    @JsonProperty("shortNames")
    public List<String> getShortNames() {
        return shortNames;
    }

    @JsonProperty("shortNames")
    public void setShortNames(List<String> shortNames) {
        this.shortNames = shortNames;
    }

    @JsonProperty("singularName")
    public String getSingularName() {
        return singularName;
    }

    @JsonProperty("singularName")
    public void setSingularName(String singularName) {
        this.singularName = singularName;
    }

    @JsonProperty("storageVersionHash")
    public String getStorageVersionHash() {
        return storageVersionHash;
    }

    @JsonProperty("storageVersionHash")
    public void setStorageVersionHash(String storageVersionHash) {
        this.storageVersionHash = storageVersionHash;
    }

    @JsonProperty("verbs")
    public List<String> getVerbs() {
        return verbs;
    }

    @JsonProperty("verbs")
    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
