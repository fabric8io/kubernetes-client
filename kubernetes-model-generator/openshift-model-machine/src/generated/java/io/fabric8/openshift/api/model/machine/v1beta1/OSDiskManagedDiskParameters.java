
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
     * StorageAccountType is the storage account type to use. Possible values include "Standard_LRS", "Premium_LRS".
     */
    @JsonProperty("storageAccountType")
    public String getStorageAccountType() {
        return storageAccountType;
    }

    /**
     * StorageAccountType is the storage account type to use. Possible values include "Standard_LRS", "Premium_LRS".
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

}
