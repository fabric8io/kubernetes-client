
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
    "annotations",
    "disableNameSuffixHash",
    "immutable",
    "labels"
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
public class GeneratorOptions implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("disableNameSuffixHash")
    private Boolean disableNameSuffixHash;
    @JsonProperty("immutable")
    private Boolean immutable;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GeneratorOptions() {
    }

    public GeneratorOptions(Map<String, String> annotations, Boolean disableNameSuffixHash, Boolean immutable, Map<String, String> labels) {
        super();
        this.annotations = annotations;
        this.disableNameSuffixHash = disableNameSuffixHash;
        this.immutable = immutable;
        this.labels = labels;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("disableNameSuffixHash")
    public Boolean getDisableNameSuffixHash() {
        return disableNameSuffixHash;
    }

    @JsonProperty("disableNameSuffixHash")
    public void setDisableNameSuffixHash(Boolean disableNameSuffixHash) {
        this.disableNameSuffixHash = disableNameSuffixHash;
    }

    @JsonProperty("immutable")
    public Boolean getImmutable() {
        return immutable;
    }

    @JsonProperty("immutable")
    public void setImmutable(Boolean immutable) {
        this.immutable = immutable;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
