
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "baremetal",
    "external",
    "gcp",
    "ibmcloud",
    "none",
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private io.fabric8.openshift.api.model.installer.aws.v1.Platform aws;
    @JsonProperty("azure")
    private io.fabric8.openshift.api.model.installer.azure.v1.Platform azure;
    @JsonProperty("baremetal")
    private io.fabric8.openshift.api.model.installer.baremetal.v1.Platform baremetal;
    @JsonProperty("external")
    private io.fabric8.openshift.api.model.installer.external.v1.Platform external;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.installer.gcp.v1.Platform gcp;
    @JsonProperty("ibmcloud")
    private io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform ibmcloud;
    @JsonProperty("none")
    private io.fabric8.openshift.api.model.installer.none.v1.Platform none;
    @JsonProperty("nutanix")
    private io.fabric8.openshift.api.model.installer.nutanix.v1.Platform nutanix;
    @JsonProperty("openstack")
    private io.fabric8.openshift.api.model.installer.openstack.v1.Platform openstack;
    @JsonProperty("ovirt")
    private io.fabric8.openshift.api.model.installer.ovirt.v1.Platform ovirt;
    @JsonProperty("powervs")
    private io.fabric8.openshift.api.model.installer.powervs.v1.Platform powervs;
    @JsonProperty("vsphere")
    private io.fabric8.openshift.api.model.installer.vsphere.v1.Platform vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(io.fabric8.openshift.api.model.installer.aws.v1.Platform aws, io.fabric8.openshift.api.model.installer.azure.v1.Platform azure, io.fabric8.openshift.api.model.installer.baremetal.v1.Platform baremetal, io.fabric8.openshift.api.model.installer.external.v1.Platform external, io.fabric8.openshift.api.model.installer.gcp.v1.Platform gcp, io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform ibmcloud, io.fabric8.openshift.api.model.installer.none.v1.Platform none, io.fabric8.openshift.api.model.installer.nutanix.v1.Platform nutanix, io.fabric8.openshift.api.model.installer.openstack.v1.Platform openstack, io.fabric8.openshift.api.model.installer.ovirt.v1.Platform ovirt, io.fabric8.openshift.api.model.installer.powervs.v1.Platform powervs, io.fabric8.openshift.api.model.installer.vsphere.v1.Platform vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.external = external;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.none = none;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.powervs = powervs;
        this.vsphere = vsphere;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("aws")
    public io.fabric8.openshift.api.model.installer.aws.v1.Platform getAws() {
        return aws;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("aws")
    public void setAws(io.fabric8.openshift.api.model.installer.aws.v1.Platform aws) {
        this.aws = aws;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("azure")
    public io.fabric8.openshift.api.model.installer.azure.v1.Platform getAzure() {
        return azure;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("azure")
    public void setAzure(io.fabric8.openshift.api.model.installer.azure.v1.Platform azure) {
        this.azure = azure;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("baremetal")
    public io.fabric8.openshift.api.model.installer.baremetal.v1.Platform getBaremetal() {
        return baremetal;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("baremetal")
    public void setBaremetal(io.fabric8.openshift.api.model.installer.baremetal.v1.Platform baremetal) {
        this.baremetal = baremetal;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("external")
    public io.fabric8.openshift.api.model.installer.external.v1.Platform getExternal() {
        return external;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("external")
    public void setExternal(io.fabric8.openshift.api.model.installer.external.v1.Platform external) {
        this.external = external;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.installer.gcp.v1.Platform getGcp() {
        return gcp;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.installer.gcp.v1.Platform gcp) {
        this.gcp = gcp;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("ibmcloud")
    public io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform getIbmcloud() {
        return ibmcloud;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("none")
    public io.fabric8.openshift.api.model.installer.none.v1.Platform getNone() {
        return none;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("none")
    public void setNone(io.fabric8.openshift.api.model.installer.none.v1.Platform none) {
        this.none = none;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("nutanix")
    public io.fabric8.openshift.api.model.installer.nutanix.v1.Platform getNutanix() {
        return nutanix;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("nutanix")
    public void setNutanix(io.fabric8.openshift.api.model.installer.nutanix.v1.Platform nutanix) {
        this.nutanix = nutanix;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("openstack")
    public io.fabric8.openshift.api.model.installer.openstack.v1.Platform getOpenstack() {
        return openstack;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("openstack")
    public void setOpenstack(io.fabric8.openshift.api.model.installer.openstack.v1.Platform openstack) {
        this.openstack = openstack;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("ovirt")
    public io.fabric8.openshift.api.model.installer.ovirt.v1.Platform getOvirt() {
        return ovirt;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("ovirt")
    public void setOvirt(io.fabric8.openshift.api.model.installer.ovirt.v1.Platform ovirt) {
        this.ovirt = ovirt;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("powervs")
    public io.fabric8.openshift.api.model.installer.powervs.v1.Platform getPowervs() {
        return powervs;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("powervs")
    public void setPowervs(io.fabric8.openshift.api.model.installer.powervs.v1.Platform powervs) {
        this.powervs = powervs;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("vsphere")
    public io.fabric8.openshift.api.model.installer.vsphere.v1.Platform getVsphere() {
        return vsphere;
    }

    /**
     * Platform is the configuration for the specific platform upon which to perform the installation. Only one of the platform configuration should be set.
     */
    @JsonProperty("vsphere")
    public void setVsphere(io.fabric8.openshift.api.model.installer.vsphere.v1.Platform vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
