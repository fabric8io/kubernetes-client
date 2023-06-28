
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
    "resourceClaimName",
    "resourceClaimTemplateName"
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
public class ClaimSource implements KubernetesResource
{

    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonProperty("resourceClaimTemplateName")
    private String resourceClaimTemplateName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClaimSource() {
    }

    public ClaimSource(String resourceClaimName, String resourceClaimTemplateName) {
        super();
        this.resourceClaimName = resourceClaimName;
        this.resourceClaimTemplateName = resourceClaimTemplateName;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
