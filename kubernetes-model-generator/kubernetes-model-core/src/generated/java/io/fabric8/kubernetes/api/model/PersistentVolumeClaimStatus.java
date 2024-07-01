
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessModes",
    "allocatedResourceStatuses",
    "allocatedResources",
    "capacity",
    "conditions",
    "currentVolumeAttributesClassName",
    "modifyVolumeStatus",
    "phase"
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
public class PersistentVolumeClaimStatus implements Editable<PersistentVolumeClaimStatusBuilder> , KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<String>();
    @JsonProperty("allocatedResourceStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> allocatedResourceStatuses = new LinkedHashMap<String, String>();
    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> allocatedResources = new LinkedHashMap<String, io.fabric8.kubernetes.api.model.Quantity>();
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.Quantity> capacity = new LinkedHashMap<String, io.fabric8.kubernetes.api.model.Quantity>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PersistentVolumeClaimCondition> conditions = new ArrayList<PersistentVolumeClaimCondition>();
    @JsonProperty("currentVolumeAttributesClassName")
    private String currentVolumeAttributesClassName;
    @JsonProperty("modifyVolumeStatus")
    private ModifyVolumeStatus modifyVolumeStatus;
    @JsonProperty("phase")
    private String phase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PersistentVolumeClaimStatus() {
    }

    public PersistentVolumeClaimStatus(List<String> accessModes, Map<String, String> allocatedResourceStatuses, Map<String, io.fabric8.kubernetes.api.model.Quantity> allocatedResources, Map<String, io.fabric8.kubernetes.api.model.Quantity> capacity, List<PersistentVolumeClaimCondition> conditions, String currentVolumeAttributesClassName, ModifyVolumeStatus modifyVolumeStatus, String phase) {
        super();
        this.accessModes = accessModes;
        this.allocatedResourceStatuses = allocatedResourceStatuses;
        this.allocatedResources = allocatedResources;
        this.capacity = capacity;
        this.conditions = conditions;
        this.currentVolumeAttributesClassName = currentVolumeAttributesClassName;
        this.modifyVolumeStatus = modifyVolumeStatus;
        this.phase = phase;
    }

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAccessModes() {
        return accessModes;
    }

    @JsonProperty("accessModes")
    public void setAccessModes(List<String> accessModes) {
        this.accessModes = accessModes;
    }

    @JsonProperty("allocatedResourceStatuses")
    public Map<String, String> getAllocatedResourceStatuses() {
        return allocatedResourceStatuses;
    }

    @JsonProperty("allocatedResourceStatuses")
    public void setAllocatedResourceStatuses(Map<String, String> allocatedResourceStatuses) {
        this.allocatedResourceStatuses = allocatedResourceStatuses;
    }

    @JsonProperty("allocatedResources")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getAllocatedResources() {
        return allocatedResources;
    }

    @JsonProperty("allocatedResources")
    public void setAllocatedResources(Map<String, io.fabric8.kubernetes.api.model.Quantity> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    @JsonProperty("capacity")
    public Map<String, io.fabric8.kubernetes.api.model.Quantity> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Map<String, io.fabric8.kubernetes.api.model.Quantity> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PersistentVolumeClaimCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<PersistentVolumeClaimCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentVolumeAttributesClassName")
    public String getCurrentVolumeAttributesClassName() {
        return currentVolumeAttributesClassName;
    }

    @JsonProperty("currentVolumeAttributesClassName")
    public void setCurrentVolumeAttributesClassName(String currentVolumeAttributesClassName) {
        this.currentVolumeAttributesClassName = currentVolumeAttributesClassName;
    }

    @JsonProperty("modifyVolumeStatus")
    public ModifyVolumeStatus getModifyVolumeStatus() {
        return modifyVolumeStatus;
    }

    @JsonProperty("modifyVolumeStatus")
    public void setModifyVolumeStatus(ModifyVolumeStatus modifyVolumeStatus) {
        this.modifyVolumeStatus = modifyVolumeStatus;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonIgnore
    public PersistentVolumeClaimStatusBuilder edit() {
        return new PersistentVolumeClaimStatusBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeClaimStatusBuilder toBuilder() {
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

}
