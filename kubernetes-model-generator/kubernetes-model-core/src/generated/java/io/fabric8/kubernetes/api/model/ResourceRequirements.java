
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
    "claims",
    "limits",
    "requests"
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
public class ResourceRequirements implements KubernetesResource
{

    @JsonProperty("claims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceClaim> claims = new ArrayList<ResourceClaim>();
    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> limits = new LinkedHashMap<String, io.fabric8.kubernetes.api.model.Quantity>();
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> requests = new LinkedHashMap<String, io.fabric8.kubernetes.api.model.Quantity>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceRequirements() {
    }

    public ResourceRequirements(List<ResourceClaim> claims, Map<String, io.fabric8.kubernetes.api.model.Quantity> limits, Map<String, io.fabric8.kubernetes.api.model.Quantity> requests) {
        super();
        this.claims = claims;
        this.limits = limits;
        this.requests = requests;
    }

    @JsonProperty("claims")
    public List<ResourceClaim> getClaims() {
        return claims;
    }

    @JsonProperty("claims")
    public void setClaims(List<ResourceClaim> claims) {
        this.claims = claims;
    }

    @JsonProperty("limits")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getLimits() {
        return limits;
    }

    @JsonProperty("limits")
    public void setLimits(Map<String, io.fabric8.kubernetes.api.model.Quantity> limits) {
        this.limits = limits;
    }

    @JsonProperty("requests")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(Map<String, io.fabric8.kubernetes.api.model.Quantity> requests) {
        this.requests = requests;
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
