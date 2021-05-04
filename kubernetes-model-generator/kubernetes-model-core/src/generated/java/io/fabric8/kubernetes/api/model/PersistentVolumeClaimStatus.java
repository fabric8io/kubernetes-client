
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "accessModes",
    "capacity",
    "conditions",
    "phase"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class PersistentVolumeClaimStatus implements KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> accessModes = new ArrayList<java.lang.String>();
    @JsonProperty("capacity")
    private Map<String, Quantity> capacity;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PersistentVolumeClaimCondition> conditions = new ArrayList<PersistentVolumeClaimCondition>();
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PersistentVolumeClaimStatus() {
    }

    /**
     * 
     * @param phase
     * @param accessModes
     * @param conditions
     * @param capacity
     */
    public PersistentVolumeClaimStatus(List<java.lang.String> accessModes, Map<String, Quantity> capacity, List<PersistentVolumeClaimCondition> conditions, java.lang.String phase) {
        super();
        this.accessModes = accessModes;
        this.capacity = capacity;
        this.conditions = conditions;
        this.phase = phase;
    }

    @JsonProperty("accessModes")
    public List<java.lang.String> getAccessModes() {
        return accessModes;
    }

    @JsonProperty("accessModes")
    public void setAccessModes(List<java.lang.String> accessModes) {
        this.accessModes = accessModes;
    }

    @JsonProperty("capacity")
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("conditions")
    public List<PersistentVolumeClaimCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<PersistentVolumeClaimCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
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
