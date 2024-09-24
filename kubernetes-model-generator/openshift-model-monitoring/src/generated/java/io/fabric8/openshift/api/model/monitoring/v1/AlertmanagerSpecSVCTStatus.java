
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerSpecSVCTStatus implements Editable<AlertmanagerSpecSVCTStatusBuilder> , KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<>();
    @JsonProperty("allocatedResourceStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> allocatedResourceStatuses = new LinkedHashMap<>();
    @JsonProperty("allocatedResources")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> allocatedResources = new LinkedHashMap<>();
    @JsonProperty("capacity")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> capacity = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecSVCTStatusConditions> conditions = new ArrayList<>();
    @JsonProperty("currentVolumeAttributesClassName")
    private String currentVolumeAttributesClassName;
    @JsonProperty("modifyVolumeStatus")
    private AlertmanagerSpecSVCTStatusModifyVolumeStatus modifyVolumeStatus;
    @JsonProperty("phase")
    private String phase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpecSVCTStatus() {
    }

    public AlertmanagerSpecSVCTStatus(List<String> accessModes, Map<String, String> allocatedResourceStatuses, Map<String, Object> allocatedResources, Map<String, Object> capacity, List<AlertmanagerSpecSVCTStatusConditions> conditions, String currentVolumeAttributesClassName, AlertmanagerSpecSVCTStatusModifyVolumeStatus modifyVolumeStatus, String phase) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAllocatedResourceStatuses() {
        return allocatedResourceStatuses;
    }

    @JsonProperty("allocatedResourceStatuses")
    public void setAllocatedResourceStatuses(Map<String, String> allocatedResourceStatuses) {
        this.allocatedResourceStatuses = allocatedResourceStatuses;
    }

    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getAllocatedResources() {
        return allocatedResources;
    }

    @JsonProperty("allocatedResources")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setAllocatedResources(Map<String, Object> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setCapacity(Map<String, Object> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecSVCTStatusConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<AlertmanagerSpecSVCTStatusConditions> conditions) {
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
    public AlertmanagerSpecSVCTStatusModifyVolumeStatus getModifyVolumeStatus() {
        return modifyVolumeStatus;
    }

    @JsonProperty("modifyVolumeStatus")
    public void setModifyVolumeStatus(AlertmanagerSpecSVCTStatusModifyVolumeStatus modifyVolumeStatus) {
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
    public AlertmanagerSpecSVCTStatusBuilder edit() {
        return new AlertmanagerSpecSVCTStatusBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecSVCTStatusBuilder toBuilder() {
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
