
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claims",
    "limits",
    "requests"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceRequirements implements Editable<ResourceRequirementsBuilder> , KubernetesResource
{

    @JsonProperty("claims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceClaim> claims = new ArrayList<>();
    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> limits = new LinkedHashMap<>();
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> requests = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceRequirements() {
    }

    public ResourceRequirements(List<ResourceClaim> claims, Map<String, Quantity> limits, Map<String, Quantity> requests) {
        super();
        this.claims = claims;
        this.limits = limits;
        this.requests = requests;
    }

    @JsonProperty("claims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceClaim> getClaims() {
        return claims;
    }

    @JsonProperty("claims")
    public void setClaims(List<ResourceClaim> claims) {
        this.claims = claims;
    }

    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getLimits() {
        return limits;
    }

    @JsonProperty("limits")
    public void setLimits(Map<String, Quantity> limits) {
        this.limits = limits;
    }

    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(Map<String, Quantity> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public ResourceRequirementsBuilder edit() {
        return new ResourceRequirementsBuilder(this);
    }

    @JsonIgnore
    public ResourceRequirementsBuilder toBuilder() {
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
