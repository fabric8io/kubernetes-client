
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "resourceClaimName",
    "resourceClaimTemplateName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodResourceClaim implements Editable<PodResourceClaimBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonProperty("resourceClaimTemplateName")
    private String resourceClaimTemplateName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodResourceClaim() {
    }

    public PodResourceClaim(String name, String resourceClaimName, String resourceClaimTemplateName) {
        super();
        this.name = name;
        this.resourceClaimName = resourceClaimName;
        this.resourceClaimTemplateName = resourceClaimTemplateName;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("resourceClaimName")
    public String getResourceClaimName() {
        return resourceClaimName;
    }

    @JsonProperty("resourceClaimName")
    public void setResourceClaimName(String resourceClaimName) {
        this.resourceClaimName = resourceClaimName;
    }

    @JsonProperty("resourceClaimTemplateName")
    public String getResourceClaimTemplateName() {
        return resourceClaimTemplateName;
    }

    @JsonProperty("resourceClaimTemplateName")
    public void setResourceClaimTemplateName(String resourceClaimTemplateName) {
        this.resourceClaimTemplateName = resourceClaimTemplateName;
    }

    @JsonIgnore
    public PodResourceClaimBuilder edit() {
        return new PodResourceClaimBuilder(this);
    }

    @JsonIgnore
    public PodResourceClaimBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
