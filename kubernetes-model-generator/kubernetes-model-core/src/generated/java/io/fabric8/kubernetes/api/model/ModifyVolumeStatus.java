
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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

/**
 * ModifyVolumeStatus represents the status object of ControllerModifyVolume operation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "targetVolumeAttributesClassName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ModifyVolumeStatus implements Editable<ModifyVolumeStatusBuilder>, KubernetesResource
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("targetVolumeAttributesClassName")
    private String targetVolumeAttributesClassName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ModifyVolumeStatus() {
    }

    public ModifyVolumeStatus(String status, String targetVolumeAttributesClassName) {
        super();
        this.status = status;
        this.targetVolumeAttributesClassName = targetVolumeAttributesClassName;
    }

    /**
     * status is the status of the ControllerModifyVolume operation. It can be in any of following states:<br><p>  - Pending<br><p>    Pending indicates that the PersistentVolumeClaim cannot be modified due to unmet requirements, such as<br><p>    the specified VolumeAttributesClass not existing.<br><p>  - InProgress<br><p>    InProgress indicates that the volume is being modified.<br><p>  - Infeasible<br><p>   Infeasible indicates that the request has been rejected as invalid by the CSI driver. To<br><p> 	  resolve the error, a valid VolumeAttributesClass needs to be specified.<br><p> Note: New statuses can be added in the future. Consumers should check for unknown statuses and fail appropriately.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * status is the status of the ControllerModifyVolume operation. It can be in any of following states:<br><p>  - Pending<br><p>    Pending indicates that the PersistentVolumeClaim cannot be modified due to unmet requirements, such as<br><p>    the specified VolumeAttributesClass not existing.<br><p>  - InProgress<br><p>    InProgress indicates that the volume is being modified.<br><p>  - Infeasible<br><p>   Infeasible indicates that the request has been rejected as invalid by the CSI driver. To<br><p> 	  resolve the error, a valid VolumeAttributesClass needs to be specified.<br><p> Note: New statuses can be added in the future. Consumers should check for unknown statuses and fail appropriately.
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * targetVolumeAttributesClassName is the name of the VolumeAttributesClass the PVC currently being reconciled
     */
    @JsonProperty("targetVolumeAttributesClassName")
    public String getTargetVolumeAttributesClassName() {
        return targetVolumeAttributesClassName;
    }

    /**
     * targetVolumeAttributesClassName is the name of the VolumeAttributesClass the PVC currently being reconciled
     */
    @JsonProperty("targetVolumeAttributesClassName")
    public void setTargetVolumeAttributesClassName(String targetVolumeAttributesClassName) {
        this.targetVolumeAttributesClassName = targetVolumeAttributesClassName;
    }

    @JsonIgnore
    public ModifyVolumeStatusBuilder edit() {
        return new ModifyVolumeStatusBuilder(this);
    }

    @JsonIgnore
    public ModifyVolumeStatusBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ModifyVolumeStatus)) {
            return false;
        }
        ModifyVolumeStatus other = (ModifyVolumeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$targetVolumeAttributesClassName = this.getTargetVolumeAttributesClassName();
        Object other$targetVolumeAttributesClassName = other.getTargetVolumeAttributesClassName();
        if (this$targetVolumeAttributesClassName == null ? other$targetVolumeAttributesClassName != null : !this$targetVolumeAttributesClassName.equals(other$targetVolumeAttributesClassName)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ModifyVolumeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $targetVolumeAttributesClassName = this.getTargetVolumeAttributesClassName();
        result = result * prime + ($targetVolumeAttributesClassName == null ? 43 : $targetVolumeAttributesClassName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ModifyVolumeStatus(" + "status=" + this.getStatus() + ", targetVolumeAttributesClassName=" + this.getTargetVolumeAttributesClassName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
