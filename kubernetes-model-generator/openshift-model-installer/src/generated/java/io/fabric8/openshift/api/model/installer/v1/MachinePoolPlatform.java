
package io.fabric8.openshift.api.model.installer.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.openshift.api.model.installer.aws.v1.MachinePool;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "baremetal",
    "gcp",
    "ibmcloud",
    "nutanix",
    "openstack",
    "ovirt",
    "powervs",
    "vsphere"
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
public class MachinePoolPlatform implements Editable<MachinePoolPlatformBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private MachinePool aws;
    @JsonProperty("azure")
    private io.fabric8.openshift.api.model.installer.azure.v1.MachinePool azure;
    @JsonProperty("baremetal")
    private io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetal;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcp;
    @JsonProperty("ibmcloud")
    private io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool ibmcloud;
    @JsonProperty("nutanix")
    private io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool nutanix;
    @JsonProperty("openstack")
    private io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openstack;
    @JsonProperty("ovirt")
    private io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirt;
    @JsonProperty("powervs")
    private io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool powervs;
    @JsonProperty("vsphere")
    private io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePoolPlatform() {
    }

    public MachinePoolPlatform(MachinePool aws, io.fabric8.openshift.api.model.installer.azure.v1.MachinePool azure, io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetal, io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcp, io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool ibmcloud, io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool nutanix, io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openstack, io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirt, io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool powervs, io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.powervs = powervs;
        this.vsphere = vsphere;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("aws")
    public MachinePool getAws() {
        return aws;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("aws")
    public void setAws(MachinePool aws) {
        this.aws = aws;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("azure")
    public io.fabric8.openshift.api.model.installer.azure.v1.MachinePool getAzure() {
        return azure;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("azure")
    public void setAzure(io.fabric8.openshift.api.model.installer.azure.v1.MachinePool azure) {
        this.azure = azure;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("baremetal")
    public io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool getBaremetal() {
        return baremetal;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("baremetal")
    public void setBaremetal(io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetal) {
        this.baremetal = baremetal;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool getGcp() {
        return gcp;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcp) {
        this.gcp = gcp;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("ibmcloud")
    public io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool getIbmcloud() {
        return ibmcloud;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("nutanix")
    public io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool getNutanix() {
        return nutanix;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("nutanix")
    public void setNutanix(io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePool nutanix) {
        this.nutanix = nutanix;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("openstack")
    public io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool getOpenstack() {
        return openstack;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("openstack")
    public void setOpenstack(io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openstack) {
        this.openstack = openstack;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("ovirt")
    public io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool getOvirt() {
        return ovirt;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("ovirt")
    public void setOvirt(io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirt) {
        this.ovirt = ovirt;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("powervs")
    public io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool getPowervs() {
        return powervs;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("powervs")
    public void setPowervs(io.fabric8.openshift.api.model.installer.powervs.v1.MachinePool powervs) {
        this.powervs = powervs;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("vsphere")
    public io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool getVsphere() {
        return vsphere;
    }

    /**
     * MachinePoolPlatform is the platform-specific configuration for a machine pool. Only one of the platforms should be set.
     */
    @JsonProperty("vsphere")
    public void setVsphere(io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public MachinePoolPlatformBuilder edit() {
        return new MachinePoolPlatformBuilder(this);
    }

    @JsonIgnore
    public MachinePoolPlatformBuilder toBuilder() {
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
