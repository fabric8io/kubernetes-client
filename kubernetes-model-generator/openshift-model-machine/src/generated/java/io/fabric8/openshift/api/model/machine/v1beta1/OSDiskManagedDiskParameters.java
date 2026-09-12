
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OSDiskManagedDiskParameters is the parameters of a OSDisk managed disk.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diskEncryptionSet",
    "securityProfile",
    "storageAccountType"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OSDiskManagedDiskParameters implements Editable<OSDiskManagedDiskParametersBuilder>, KubernetesResource
{

    @JsonProperty("diskEncryptionSet")
    private DiskEncryptionSetParameters diskEncryptionSet;
    @JsonProperty("securityProfile")
    private VMDiskSecurityProfile securityProfile;
    @JsonProperty("storageAccountType")
    private String storageAccountType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSDiskManagedDiskParameters() {
    }

    public OSDiskManagedDiskParameters(DiskEncryptionSetParameters diskEncryptionSet, VMDiskSecurityProfile securityProfile, String storageAccountType) {
        super();
        this.diskEncryptionSet = diskEncryptionSet;
        this.securityProfile = securityProfile;
        this.storageAccountType = storageAccountType;
    }

    /**
     * OSDiskManagedDiskParameters is the parameters of a OSDisk managed disk.
     */
    @JsonProperty("diskEncryptionSet")
    public DiskEncryptionSetParameters getDiskEncryptionSet() {
        return diskEncryptionSet;
    }

    /**
     * OSDiskManagedDiskParameters is the parameters of a OSDisk managed disk.
     */
    @JsonProperty("diskEncryptionSet")
    public void setDiskEncryptionSet(DiskEncryptionSetParameters diskEncryptionSet) {
        this.diskEncryptionSet = diskEncryptionSet;
    }

    /**
     * OSDiskManagedDiskParameters is the parameters of a OSDisk managed disk.
     */
    @JsonProperty("securityProfile")
    public VMDiskSecurityProfile getSecurityProfile() {
        return securityProfile;
    }

    /**
     * OSDiskManagedDiskParameters is the parameters of a OSDisk managed disk.
     */
    @JsonProperty("securityProfile")
    public void setSecurityProfile(VMDiskSecurityProfile securityProfile) {
        this.securityProfile = securityProfile;
    }

    /**
     * storageAccountType is the storage account type to use. Possible values include "Standard_LRS", "Premium_LRS".
     */
    @JsonProperty("storageAccountType")
    public String getStorageAccountType() {
        return storageAccountType;
    }

    /**
     * storageAccountType is the storage account type to use. Possible values include "Standard_LRS", "Premium_LRS".
     */
    @JsonProperty("storageAccountType")
    public void setStorageAccountType(String storageAccountType) {
        this.storageAccountType = storageAccountType;
    }

    @JsonIgnore
    public OSDiskManagedDiskParametersBuilder edit() {
        return new OSDiskManagedDiskParametersBuilder(this);
    }

    @JsonIgnore
    public OSDiskManagedDiskParametersBuilder toBuilder() {
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
        if (!(o instanceof OSDiskManagedDiskParameters)) {
            return false;
        }
        OSDiskManagedDiskParameters other = (OSDiskManagedDiskParameters) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$diskEncryptionSet = this.getDiskEncryptionSet();
        Object other$diskEncryptionSet = other.getDiskEncryptionSet();
        if (this$diskEncryptionSet == null ? other$diskEncryptionSet != null : !this$diskEncryptionSet.equals(other$diskEncryptionSet)) {
            return false;
        }
        Object this$securityProfile = this.getSecurityProfile();
        Object other$securityProfile = other.getSecurityProfile();
        if (this$securityProfile == null ? other$securityProfile != null : !this$securityProfile.equals(other$securityProfile)) {
            return false;
        }
        Object this$storageAccountType = this.getStorageAccountType();
        Object other$storageAccountType = other.getStorageAccountType();
        if (this$storageAccountType == null ? other$storageAccountType != null : !this$storageAccountType.equals(other$storageAccountType)) {
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
        return other instanceof OSDiskManagedDiskParameters;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $diskEncryptionSet = this.getDiskEncryptionSet();
        result = result * prime + ($diskEncryptionSet == null ? 43 : $diskEncryptionSet.hashCode());
        Object $securityProfile = this.getSecurityProfile();
        result = result * prime + ($securityProfile == null ? 43 : $securityProfile.hashCode());
        Object $storageAccountType = this.getStorageAccountType();
        result = result * prime + ($storageAccountType == null ? 43 : $storageAccountType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OSDiskManagedDiskParameters(" + "diskEncryptionSet=" + this.getDiskEncryptionSet() + ", securityProfile=" + this.getSecurityProfile() + ", storageAccountType=" + this.getStorageAccountType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
