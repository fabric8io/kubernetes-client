
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class VolumeResourceRequirements implements Editable<VolumeResourceRequirementsBuilder> , KubernetesResource
{

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
    public VolumeResourceRequirements() {
    }

    public VolumeResourceRequirements(Map<String, io.fabric8.kubernetes.api.model.Quantity> limits, Map<String, io.fabric8.kubernetes.api.model.Quantity> requests) {
        super();
        this.limits = limits;
        this.requests = requests;
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

    @JsonIgnore
    public VolumeResourceRequirementsBuilder edit() {
        return new VolumeResourceRequirementsBuilder(this);
    }

    @JsonIgnore
    public VolumeResourceRequirementsBuilder toBuilder() {
        return edit();
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
