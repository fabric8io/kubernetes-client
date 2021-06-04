
package io.fabric8.openshift.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "aws",
    "azure",
    "baremetal",
    "equinixMetal",
    "gcp",
    "ibmcloud",
    "kubevirt",
    "openstack",
    "ovirt",
    "type",
    "vsphere"
})
@ToString
@EqualsAndHashCode
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
public class PlatformStatus implements KubernetesResource
{

    @JsonProperty("aws")
    private AWSPlatformStatus aws;
    @JsonProperty("azure")
    private AzurePlatformStatus azure;
    @JsonProperty("baremetal")
    private BareMetalPlatformStatus baremetal;
    @JsonProperty("equinixMetal")
    private EquinixMetalPlatformStatus equinixMetal;
    @JsonProperty("gcp")
    private GCPPlatformStatus gcp;
    @JsonProperty("ibmcloud")
    private IBMCloudPlatformStatus ibmcloud;
    @JsonProperty("kubevirt")
    private KubevirtPlatformStatus kubevirt;
    @JsonProperty("openstack")
    private OpenStackPlatformStatus openstack;
    @JsonProperty("ovirt")
    private OvirtPlatformStatus ovirt;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vsphere")
    private VSpherePlatformStatus vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlatformStatus() {
    }

    /**
     * 
     * @param baremetal
     * @param vsphere
     * @param gcp
     * @param ibmcloud
     * @param equinixMetal
     * @param ovirt
     * @param kubevirt
     * @param openstack
     * @param aws
     * @param type
     * @param azure
     */
    public PlatformStatus(AWSPlatformStatus aws, AzurePlatformStatus azure, BareMetalPlatformStatus baremetal, EquinixMetalPlatformStatus equinixMetal, GCPPlatformStatus gcp, IBMCloudPlatformStatus ibmcloud, KubevirtPlatformStatus kubevirt, OpenStackPlatformStatus openstack, OvirtPlatformStatus ovirt, String type, VSpherePlatformStatus vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.equinixMetal = equinixMetal;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.kubevirt = kubevirt;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.type = type;
        this.vsphere = vsphere;
    }

    @JsonProperty("aws")
    public AWSPlatformStatus getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(AWSPlatformStatus aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public AzurePlatformStatus getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(AzurePlatformStatus azure) {
        this.azure = azure;
    }

    @JsonProperty("baremetal")
    public BareMetalPlatformStatus getBaremetal() {
        return baremetal;
    }

    @JsonProperty("baremetal")
    public void setBaremetal(BareMetalPlatformStatus baremetal) {
        this.baremetal = baremetal;
    }

    @JsonProperty("equinixMetal")
    public EquinixMetalPlatformStatus getEquinixMetal() {
        return equinixMetal;
    }

    @JsonProperty("equinixMetal")
    public void setEquinixMetal(EquinixMetalPlatformStatus equinixMetal) {
        this.equinixMetal = equinixMetal;
    }

    @JsonProperty("gcp")
    public GCPPlatformStatus getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(GCPPlatformStatus gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public IBMCloudPlatformStatus getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(IBMCloudPlatformStatus ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("kubevirt")
    public KubevirtPlatformStatus getKubevirt() {
        return kubevirt;
    }

    @JsonProperty("kubevirt")
    public void setKubevirt(KubevirtPlatformStatus kubevirt) {
        this.kubevirt = kubevirt;
    }

    @JsonProperty("openstack")
    public OpenStackPlatformStatus getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(OpenStackPlatformStatus openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public OvirtPlatformStatus getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    public void setOvirt(OvirtPlatformStatus ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("vsphere")
    public VSpherePlatformStatus getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(VSpherePlatformStatus vsphere) {
        this.vsphere = vsphere;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
