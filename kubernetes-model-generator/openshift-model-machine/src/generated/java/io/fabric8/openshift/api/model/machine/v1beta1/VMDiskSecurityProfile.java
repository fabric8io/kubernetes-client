
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * VMDiskSecurityProfile specifies the security profile settings for the managed disk. It can be set only for Confidential VMs.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diskEncryptionSet",
    "securityEncryptionType"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VMDiskSecurityProfile implements Editable<VMDiskSecurityProfileBuilder>, KubernetesResource
{

    @JsonProperty("diskEncryptionSet")
    private DiskEncryptionSetParameters diskEncryptionSet;
    @JsonProperty("securityEncryptionType")
    private String securityEncryptionType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VMDiskSecurityProfile() {
    }

    public VMDiskSecurityProfile(DiskEncryptionSetParameters diskEncryptionSet, String securityEncryptionType) {
        super();
        this.diskEncryptionSet = diskEncryptionSet;
        this.securityEncryptionType = securityEncryptionType;
    }

    /**
     * VMDiskSecurityProfile specifies the security profile settings for the managed disk. It can be set only for Confidential VMs.
     */
    @JsonProperty("diskEncryptionSet")
    public DiskEncryptionSetParameters getDiskEncryptionSet() {
        return diskEncryptionSet;
    }

    /**
     * VMDiskSecurityProfile specifies the security profile settings for the managed disk. It can be set only for Confidential VMs.
     */
    @JsonProperty("diskEncryptionSet")
    public void setDiskEncryptionSet(DiskEncryptionSetParameters diskEncryptionSet) {
        this.diskEncryptionSet = diskEncryptionSet;
    }

    /**
     * securityEncryptionType specifies the encryption type of the managed disk. It is set to DiskWithVMGuestState to encrypt the managed disk along with the VMGuestState blob, and to VMGuestStateOnly to encrypt the VMGuestState blob only. When set to VMGuestStateOnly, the vTPM should be enabled. When set to DiskWithVMGuestState, both SecureBoot and vTPM should be enabled. If the above conditions are not fulfilled, the VM will not be created and the respective error will be returned. It can be set only for Confidential VMs. Confidential VMs are defined by their SecurityProfile.SecurityType being set to ConfidentialVM, the SecurityEncryptionType of their OS disk being set to one of the allowed values and by enabling the respective SecurityProfile.UEFISettings of the VM (i.e. vTPM and SecureBoot), depending on the selected SecurityEncryptionType. For further details on Azure Confidential VMs, please refer to the respective documentation: https://learn.microsoft.com/azure/confidential-computing/confidential-vm-overview
     */
    @JsonProperty("securityEncryptionType")
    public String getSecurityEncryptionType() {
        return securityEncryptionType;
    }

    /**
     * securityEncryptionType specifies the encryption type of the managed disk. It is set to DiskWithVMGuestState to encrypt the managed disk along with the VMGuestState blob, and to VMGuestStateOnly to encrypt the VMGuestState blob only. When set to VMGuestStateOnly, the vTPM should be enabled. When set to DiskWithVMGuestState, both SecureBoot and vTPM should be enabled. If the above conditions are not fulfilled, the VM will not be created and the respective error will be returned. It can be set only for Confidential VMs. Confidential VMs are defined by their SecurityProfile.SecurityType being set to ConfidentialVM, the SecurityEncryptionType of their OS disk being set to one of the allowed values and by enabling the respective SecurityProfile.UEFISettings of the VM (i.e. vTPM and SecureBoot), depending on the selected SecurityEncryptionType. For further details on Azure Confidential VMs, please refer to the respective documentation: https://learn.microsoft.com/azure/confidential-computing/confidential-vm-overview
     */
    @JsonProperty("securityEncryptionType")
    public void setSecurityEncryptionType(String securityEncryptionType) {
        this.securityEncryptionType = securityEncryptionType;
    }

    @JsonIgnore
    public VMDiskSecurityProfileBuilder edit() {
        return new VMDiskSecurityProfileBuilder(this);
    }

    @JsonIgnore
    public VMDiskSecurityProfileBuilder toBuilder() {
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
