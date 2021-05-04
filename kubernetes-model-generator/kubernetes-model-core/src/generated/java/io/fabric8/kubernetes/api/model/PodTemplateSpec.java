
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class PodTemplateSpec implements KubernetesResource
{

    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private PodSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodTemplateSpec() {
    }

    /**
     * 
     * @param metadata
     * @param spec
     */
    public PodTemplateSpec(ObjectMeta metadata, PodSpec spec) {
        super();
        this.metadata = metadata;
        this.spec = spec;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("spec")
    public PodSpec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(PodSpec spec) {
        this.spec = spec;
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
