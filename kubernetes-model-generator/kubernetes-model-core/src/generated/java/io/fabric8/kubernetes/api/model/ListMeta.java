
package io.fabric8.kubernetes.api.model;

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
    "continue",
    "remainingItemCount",
    "resourceVersion",
    "selfLink"
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
public class ListMeta implements KubernetesResource
{

    @JsonProperty("continue")
    private String _continue;
    @JsonProperty("remainingItemCount")
    private Long remainingItemCount;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListMeta() {
    }

    public ListMeta(String _continue, Long remainingItemCount, String resourceVersion, String selfLink) {
        super();
        this._continue = _continue;
        this.remainingItemCount = remainingItemCount;
        this.resourceVersion = resourceVersion;
        this.selfLink = selfLink;
    }

    @JsonProperty("continue")
    public String getContinue() {
        return _continue;
    }

    @JsonProperty("continue")
    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    @JsonProperty("remainingItemCount")
    public Long getRemainingItemCount() {
        return remainingItemCount;
    }

    @JsonProperty("remainingItemCount")
    public void setRemainingItemCount(Long remainingItemCount) {
        this.remainingItemCount = remainingItemCount;
    }

    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
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
