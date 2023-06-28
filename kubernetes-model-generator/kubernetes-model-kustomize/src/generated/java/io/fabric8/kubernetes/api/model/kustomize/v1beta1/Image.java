
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
    "digest",
    "name",
    "newName",
    "newTag",
    "tagSuffix"
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
public class Image implements KubernetesResource
{

    @JsonProperty("digest")
    private String digest;
    @JsonProperty("name")
    private String name;
    @JsonProperty("newName")
    private String newName;
    @JsonProperty("newTag")
    private String newTag;
    @JsonProperty("tagSuffix")
    private String tagSuffix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    public Image(String digest, String name, String newName, String newTag, String tagSuffix) {
        super();
        this.digest = digest;
        this.name = name;
        this.newName = newName;
        this.newTag = newTag;
        this.tagSuffix = tagSuffix;
    }

    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(String digest) {
        this.digest = digest;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("newName")
    public String getNewName() {
        return newName;
    }

    @JsonProperty("newName")
    public void setNewName(String newName) {
        this.newName = newName;
    }

    @JsonProperty("newTag")
    public String getNewTag() {
        return newTag;
    }

    @JsonProperty("newTag")
    public void setNewTag(String newTag) {
        this.newTag = newTag;
    }

    @JsonProperty("tagSuffix")
    public String getTagSuffix() {
        return tagSuffix;
    }

    @JsonProperty("tagSuffix")
    public void setTagSuffix(String tagSuffix) {
        this.tagSuffix = tagSuffix;
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
