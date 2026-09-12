
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
 * PersistentVolumeClaimVolumeSource references the user's PVC in the same namespace. This volume finds the bound PV and mounts that volume for the pod. A PersistentVolumeClaimVolumeSource is, essentially, a wrapper around another type of volume that is owned by someone else (the system).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claimName",
    "readOnly"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PersistentVolumeClaimVolumeSource implements Editable<PersistentVolumeClaimVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("claimName")
    private String claimName;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PersistentVolumeClaimVolumeSource() {
    }

    public PersistentVolumeClaimVolumeSource(String claimName, Boolean readOnly) {
        super();
        this.claimName = claimName;
        this.readOnly = readOnly;
    }

    /**
     * claimName is the name of a PersistentVolumeClaim in the same namespace as the pod using this volume. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
     */
    @JsonProperty("claimName")
    public String getClaimName() {
        return claimName;
    }

    /**
     * claimName is the name of a PersistentVolumeClaim in the same namespace as the pod using this volume. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
     */
    @JsonProperty("claimName")
    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    /**
     * readOnly Will force the ReadOnly setting in VolumeMounts. Default false.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly Will force the ReadOnly setting in VolumeMounts. Default false.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonIgnore
    public PersistentVolumeClaimVolumeSourceBuilder edit() {
        return new PersistentVolumeClaimVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeClaimVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof PersistentVolumeClaimVolumeSource)) {
            return false;
        }
        PersistentVolumeClaimVolumeSource other = (PersistentVolumeClaimVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claimName = this.getClaimName();
        Object other$claimName = other.getClaimName();
        if (this$claimName == null ? other$claimName != null : !this$claimName.equals(other$claimName)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
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
        return other instanceof PersistentVolumeClaimVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claimName = this.getClaimName();
        result = result * prime + ($claimName == null ? 43 : $claimName.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PersistentVolumeClaimVolumeSource(" + "claimName=" + this.getClaimName() + ", readOnly=" + this.getReadOnly() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
