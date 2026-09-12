
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

/**
 * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessModes",
    "dataSource",
    "dataSourceRef",
    "resources",
    "selector",
    "storageClassName",
    "volumeAttributesClassName",
    "volumeMode",
    "volumeName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PersistentVolumeClaimSpec implements Editable<PersistentVolumeClaimSpecBuilder>, KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<>();
    @JsonProperty("dataSource")
    private TypedLocalObjectReference dataSource;
    @JsonProperty("dataSourceRef")
    private TypedObjectReference dataSourceRef;
    @JsonProperty("resources")
    private VolumeResourceRequirements resources;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("storageClassName")
    private String storageClassName;
    @JsonProperty("volumeAttributesClassName")
    private String volumeAttributesClassName;
    @JsonProperty("volumeMode")
    private String volumeMode;
    @JsonProperty("volumeName")
    private String volumeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PersistentVolumeClaimSpec() {
    }

    public PersistentVolumeClaimSpec(List<String> accessModes, TypedLocalObjectReference dataSource, TypedObjectReference dataSourceRef, VolumeResourceRequirements resources, LabelSelector selector, String storageClassName, String volumeAttributesClassName, String volumeMode, String volumeName) {
        super();
        this.accessModes = accessModes;
        this.dataSource = dataSource;
        this.dataSourceRef = dataSourceRef;
        this.resources = resources;
        this.selector = selector;
        this.storageClassName = storageClassName;
        this.volumeAttributesClassName = volumeAttributesClassName;
        this.volumeMode = volumeMode;
        this.volumeName = volumeName;
    }

    /**
     * accessModes contains the desired access modes the volume should have. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
     */
    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAccessModes() {
        return accessModes;
    }

    /**
     * accessModes contains the desired access modes the volume should have. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
     */
    @JsonProperty("accessModes")
    public void setAccessModes(List<String> accessModes) {
        this.accessModes = accessModes;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("dataSource")
    public TypedLocalObjectReference getDataSource() {
        return dataSource;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("dataSource")
    public void setDataSource(TypedLocalObjectReference dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("dataSourceRef")
    public TypedObjectReference getDataSourceRef() {
        return dataSourceRef;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("dataSourceRef")
    public void setDataSourceRef(TypedObjectReference dataSourceRef) {
        this.dataSourceRef = dataSourceRef;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("resources")
    public VolumeResourceRequirements getResources() {
        return resources;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("resources")
    public void setResources(VolumeResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for provider-specific attributes
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * storageClassName is the name of the StorageClass required by the claim. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#class-1
     */
    @JsonProperty("storageClassName")
    public String getStorageClassName() {
        return storageClassName;
    }

    /**
     * storageClassName is the name of the StorageClass required by the claim. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#class-1
     */
    @JsonProperty("storageClassName")
    public void setStorageClassName(String storageClassName) {
        this.storageClassName = storageClassName;
    }

    /**
     * volumeAttributesClassName may be used to set the VolumeAttributesClass used by this claim. If specified, the CSI driver will create or update the volume with the attributes defined in the corresponding VolumeAttributesClass. This has a different purpose than storageClassName, it can be changed after the claim is created. An empty string or nil value indicates that no VolumeAttributesClass will be applied to the claim. If the claim enters an Infeasible error state, this field can be reset to its previous value (including nil) to cancel the modification. If the resource referred to by volumeAttributesClass does not exist, this PersistentVolumeClaim will be set to a Pending state, as reflected by the modifyVolumeStatus field, until such as a resource exists. More info: https://kubernetes.io/docs/concepts/storage/volume-attributes-classes/
     */
    @JsonProperty("volumeAttributesClassName")
    public String getVolumeAttributesClassName() {
        return volumeAttributesClassName;
    }

    /**
     * volumeAttributesClassName may be used to set the VolumeAttributesClass used by this claim. If specified, the CSI driver will create or update the volume with the attributes defined in the corresponding VolumeAttributesClass. This has a different purpose than storageClassName, it can be changed after the claim is created. An empty string or nil value indicates that no VolumeAttributesClass will be applied to the claim. If the claim enters an Infeasible error state, this field can be reset to its previous value (including nil) to cancel the modification. If the resource referred to by volumeAttributesClass does not exist, this PersistentVolumeClaim will be set to a Pending state, as reflected by the modifyVolumeStatus field, until such as a resource exists. More info: https://kubernetes.io/docs/concepts/storage/volume-attributes-classes/
     */
    @JsonProperty("volumeAttributesClassName")
    public void setVolumeAttributesClassName(String volumeAttributesClassName) {
        this.volumeAttributesClassName = volumeAttributesClassName;
    }

    /**
     * volumeMode defines what type of volume is required by the claim. Value of Filesystem is implied when not included in claim spec.
     */
    @JsonProperty("volumeMode")
    public String getVolumeMode() {
        return volumeMode;
    }

    /**
     * volumeMode defines what type of volume is required by the claim. Value of Filesystem is implied when not included in claim spec.
     */
    @JsonProperty("volumeMode")
    public void setVolumeMode(String volumeMode) {
        this.volumeMode = volumeMode;
    }

    /**
     * volumeName is the binding reference to the PersistentVolume backing this claim.
     */
    @JsonProperty("volumeName")
    public String getVolumeName() {
        return volumeName;
    }

    /**
     * volumeName is the binding reference to the PersistentVolume backing this claim.
     */
    @JsonProperty("volumeName")
    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    @JsonIgnore
    public PersistentVolumeClaimSpecBuilder edit() {
        return new PersistentVolumeClaimSpecBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeClaimSpecBuilder toBuilder() {
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
        if (!(o instanceof PersistentVolumeClaimSpec)) {
            return false;
        }
        PersistentVolumeClaimSpec other = (PersistentVolumeClaimSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessModes = this.getAccessModes();
        Object other$accessModes = other.getAccessModes();
        if (this$accessModes == null ? other$accessModes != null : !this$accessModes.equals(other$accessModes)) {
            return false;
        }
        Object this$dataSource = this.getDataSource();
        Object other$dataSource = other.getDataSource();
        if (this$dataSource == null ? other$dataSource != null : !this$dataSource.equals(other$dataSource)) {
            return false;
        }
        Object this$dataSourceRef = this.getDataSourceRef();
        Object other$dataSourceRef = other.getDataSourceRef();
        if (this$dataSourceRef == null ? other$dataSourceRef != null : !this$dataSourceRef.equals(other$dataSourceRef)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$storageClassName = this.getStorageClassName();
        Object other$storageClassName = other.getStorageClassName();
        if (this$storageClassName == null ? other$storageClassName != null : !this$storageClassName.equals(other$storageClassName)) {
            return false;
        }
        Object this$volumeAttributesClassName = this.getVolumeAttributesClassName();
        Object other$volumeAttributesClassName = other.getVolumeAttributesClassName();
        if (this$volumeAttributesClassName == null ? other$volumeAttributesClassName != null : !this$volumeAttributesClassName.equals(other$volumeAttributesClassName)) {
            return false;
        }
        Object this$volumeMode = this.getVolumeMode();
        Object other$volumeMode = other.getVolumeMode();
        if (this$volumeMode == null ? other$volumeMode != null : !this$volumeMode.equals(other$volumeMode)) {
            return false;
        }
        Object this$volumeName = this.getVolumeName();
        Object other$volumeName = other.getVolumeName();
        if (this$volumeName == null ? other$volumeName != null : !this$volumeName.equals(other$volumeName)) {
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
        return other instanceof PersistentVolumeClaimSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessModes = this.getAccessModes();
        result = result * prime + ($accessModes == null ? 43 : $accessModes.hashCode());
        Object $dataSource = this.getDataSource();
        result = result * prime + ($dataSource == null ? 43 : $dataSource.hashCode());
        Object $dataSourceRef = this.getDataSourceRef();
        result = result * prime + ($dataSourceRef == null ? 43 : $dataSourceRef.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $storageClassName = this.getStorageClassName();
        result = result * prime + ($storageClassName == null ? 43 : $storageClassName.hashCode());
        Object $volumeAttributesClassName = this.getVolumeAttributesClassName();
        result = result * prime + ($volumeAttributesClassName == null ? 43 : $volumeAttributesClassName.hashCode());
        Object $volumeMode = this.getVolumeMode();
        result = result * prime + ($volumeMode == null ? 43 : $volumeMode.hashCode());
        Object $volumeName = this.getVolumeName();
        result = result * prime + ($volumeName == null ? 43 : $volumeName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PersistentVolumeClaimSpec(" + "accessModes=" + this.getAccessModes() + ", dataSource=" + this.getDataSource() + ", dataSourceRef=" + this.getDataSourceRef() + ", resources=" + this.getResources() + ", selector=" + this.getSelector() + ", storageClassName=" + this.getStorageClassName() + ", volumeAttributesClassName=" + this.getVolumeAttributesClassName() + ", volumeMode=" + this.getVolumeMode() + ", volumeName=" + this.getVolumeName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
