
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
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

/**
 * PersistentVolumeClaimStatus is the current status of a persistent volume claim.
 */
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PersistentVolumeClaimStatus implements Editable<PersistentVolumeClaimStatusBuilder>, KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<>();
    @JsonProperty("allocatedResourceStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> allocatedResourceStatuses = new LinkedHashMap<>();
    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocatedResources = new LinkedHashMap<>();
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capacity = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PersistentVolumeClaimCondition> conditions = new ArrayList<>();
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
     */
    public PersistentVolumeClaimStatus() {
    }

    public PersistentVolumeClaimStatus(List<String> accessModes, Map<String, String> allocatedResourceStatuses, Map<String, Quantity> allocatedResources, Map<String, Quantity> capacity, List<PersistentVolumeClaimCondition> conditions, String currentVolumeAttributesClassName, ModifyVolumeStatus modifyVolumeStatus, String phase) {
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

    /**
     * accessModes contains the actual access modes the volume backing the PVC has. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
     */
    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAccessModes() {
        return accessModes;
    }

    /**
     * accessModes contains the actual access modes the volume backing the PVC has. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
     */
    @JsonProperty("accessModes")
    public void setAccessModes(List<String> accessModes) {
        this.accessModes = accessModes;
    }

    /**
     * allocatedResourceStatuses stores status of resource being resized for the given PVC. Key names follow standard Kubernetes label syntax. Valid values are either:<br><p> 	&#42; Un-prefixed keys:<br><p> 		- storage - the capacity of the volume.<br><p> 	&#42; Custom resources must use implementation-defined prefixed names such as "example.com/my-custom-resource"<br><p> Apart from above values - keys that are unprefixed or have kubernetes.io prefix are considered reserved and hence may not be used.<br><p> <br><p> ClaimResourceStatus can be in any of following states:<br><p> 	- ControllerResizeInProgress:<br><p> 		State set when resize controller starts resizing the volume in control-plane.<br><p> 	- ControllerResizeFailed:<br><p> 		State set when resize has failed in resize controller with a terminal error.<br><p> 	- NodeResizePending:<br><p> 		State set when resize controller has finished resizing the volume but further resizing of<br><p> 		volume is needed on the node.<br><p> 	- NodeResizeInProgress:<br><p> 		State set when kubelet starts resizing the volume.<br><p> 	- NodeResizeFailed:<br><p> 		State set when resizing has failed in kubelet with a terminal error. Transient errors don't set<br><p> 		NodeResizeFailed.<br><p> For example: if expanding a PVC for more capacity - this field can be one of the following states:<br><p> 	- pvc.status.allocatedResourceStatus['storage'] = "ControllerResizeInProgress"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "ControllerResizeFailed"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizePending"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizeInProgress"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizeFailed"<br><p> When this field is not set, it means that no resize operation is in progress for the given PVC.<br><p> <br><p> A controller that receives PVC update with previously unknown resourceName or ClaimResourceStatus should ignore the update for the purpose it was designed. For example - a controller that only is responsible for resizing capacity of the volume, should ignore PVC updates that change other valid resources associated with PVC.<br><p> <br><p> This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
     */
    @JsonProperty("allocatedResourceStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAllocatedResourceStatuses() {
        return allocatedResourceStatuses;
    }

    /**
     * allocatedResourceStatuses stores status of resource being resized for the given PVC. Key names follow standard Kubernetes label syntax. Valid values are either:<br><p> 	&#42; Un-prefixed keys:<br><p> 		- storage - the capacity of the volume.<br><p> 	&#42; Custom resources must use implementation-defined prefixed names such as "example.com/my-custom-resource"<br><p> Apart from above values - keys that are unprefixed or have kubernetes.io prefix are considered reserved and hence may not be used.<br><p> <br><p> ClaimResourceStatus can be in any of following states:<br><p> 	- ControllerResizeInProgress:<br><p> 		State set when resize controller starts resizing the volume in control-plane.<br><p> 	- ControllerResizeFailed:<br><p> 		State set when resize has failed in resize controller with a terminal error.<br><p> 	- NodeResizePending:<br><p> 		State set when resize controller has finished resizing the volume but further resizing of<br><p> 		volume is needed on the node.<br><p> 	- NodeResizeInProgress:<br><p> 		State set when kubelet starts resizing the volume.<br><p> 	- NodeResizeFailed:<br><p> 		State set when resizing has failed in kubelet with a terminal error. Transient errors don't set<br><p> 		NodeResizeFailed.<br><p> For example: if expanding a PVC for more capacity - this field can be one of the following states:<br><p> 	- pvc.status.allocatedResourceStatus['storage'] = "ControllerResizeInProgress"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "ControllerResizeFailed"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizePending"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizeInProgress"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizeFailed"<br><p> When this field is not set, it means that no resize operation is in progress for the given PVC.<br><p> <br><p> A controller that receives PVC update with previously unknown resourceName or ClaimResourceStatus should ignore the update for the purpose it was designed. For example - a controller that only is responsible for resizing capacity of the volume, should ignore PVC updates that change other valid resources associated with PVC.<br><p> <br><p> This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
     */
    @JsonProperty("allocatedResourceStatuses")
    public void setAllocatedResourceStatuses(Map<String, String> allocatedResourceStatuses) {
        this.allocatedResourceStatuses = allocatedResourceStatuses;
    }

    /**
     * allocatedResources tracks the resources allocated to a PVC including its capacity. Key names follow standard Kubernetes label syntax. Valid values are either:<br><p> 	&#42; Un-prefixed keys:<br><p> 		- storage - the capacity of the volume.<br><p> 	&#42; Custom resources must use implementation-defined prefixed names such as "example.com/my-custom-resource"<br><p> Apart from above values - keys that are unprefixed or have kubernetes.io prefix are considered reserved and hence may not be used.<br><p> <br><p> Capacity reported here may be larger than the actual capacity when a volume expansion operation is requested. For storage quota, the larger value from allocatedResources and PVC.spec.resources is used. If allocatedResources is not set, PVC.spec.resources alone is used for quota calculation. If a volume expansion capacity request is lowered, allocatedResources is only lowered if there are no expansion operations in progress and if the actual volume capacity is equal or lower than the requested capacity.<br><p> <br><p> A controller that receives PVC update with previously unknown resourceName should ignore the update for the purpose it was designed. For example - a controller that only is responsible for resizing capacity of the volume, should ignore PVC updates that change other valid resources associated with PVC.<br><p> <br><p> This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
     */
    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatedResources() {
        return allocatedResources;
    }

    /**
     * allocatedResources tracks the resources allocated to a PVC including its capacity. Key names follow standard Kubernetes label syntax. Valid values are either:<br><p> 	&#42; Un-prefixed keys:<br><p> 		- storage - the capacity of the volume.<br><p> 	&#42; Custom resources must use implementation-defined prefixed names such as "example.com/my-custom-resource"<br><p> Apart from above values - keys that are unprefixed or have kubernetes.io prefix are considered reserved and hence may not be used.<br><p> <br><p> Capacity reported here may be larger than the actual capacity when a volume expansion operation is requested. For storage quota, the larger value from allocatedResources and PVC.spec.resources is used. If allocatedResources is not set, PVC.spec.resources alone is used for quota calculation. If a volume expansion capacity request is lowered, allocatedResources is only lowered if there are no expansion operations in progress and if the actual volume capacity is equal or lower than the requested capacity.<br><p> <br><p> A controller that receives PVC update with previously unknown resourceName should ignore the update for the purpose it was designed. For example - a controller that only is responsible for resizing capacity of the volume, should ignore PVC updates that change other valid resources associated with PVC.<br><p> <br><p> This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
     */
    @JsonProperty("allocatedResources")
    public void setAllocatedResources(Map<String, Quantity> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    /**
     * capacity represents the actual resources of the underlying volume.
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    /**
     * capacity represents the actual resources of the underlying volume.
     */
    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    /**
     * conditions is the current Condition of persistent volume claim. If underlying persistent volume is being resized then the Condition will be set to 'Resizing'.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PersistentVolumeClaimCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is the current Condition of persistent volume claim. If underlying persistent volume is being resized then the Condition will be set to 'Resizing'.
     */
    @JsonProperty("conditions")
    public void setConditions(List<PersistentVolumeClaimCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * currentVolumeAttributesClassName is the current name of the VolumeAttributesClass the PVC is using. When unset, there is no VolumeAttributeClass applied to this PersistentVolumeClaim
     */
    @JsonProperty("currentVolumeAttributesClassName")
    public String getCurrentVolumeAttributesClassName() {
        return currentVolumeAttributesClassName;
    }

    /**
     * currentVolumeAttributesClassName is the current name of the VolumeAttributesClass the PVC is using. When unset, there is no VolumeAttributeClass applied to this PersistentVolumeClaim
     */
    @JsonProperty("currentVolumeAttributesClassName")
    public void setCurrentVolumeAttributesClassName(String currentVolumeAttributesClassName) {
        this.currentVolumeAttributesClassName = currentVolumeAttributesClassName;
    }

    /**
     * PersistentVolumeClaimStatus is the current status of a persistent volume claim.
     */
    @JsonProperty("modifyVolumeStatus")
    public ModifyVolumeStatus getModifyVolumeStatus() {
        return modifyVolumeStatus;
    }

    /**
     * PersistentVolumeClaimStatus is the current status of a persistent volume claim.
     */
    @JsonProperty("modifyVolumeStatus")
    public void setModifyVolumeStatus(ModifyVolumeStatus modifyVolumeStatus) {
        this.modifyVolumeStatus = modifyVolumeStatus;
    }

    /**
     * phase represents the current phase of PersistentVolumeClaim.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * phase represents the current phase of PersistentVolumeClaim.
     */
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
    @JsonIgnore
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
