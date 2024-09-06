
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alibabaCloud",
    "aws",
    "azure",
    "baremetal",
    "equinixMetal",
    "external",
    "gcp",
    "ibmcloud",
    "kubevirt",
    "nutanix",
    "openstack",
    "ovirt",
    "powervs",
    "type",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class InfrastructureStatusPlatformStatus implements Editable<InfrastructureStatusPlatformStatusBuilder> , KubernetesResource
{

    @JsonProperty("alibabaCloud")
    private InfrastructureStatusPSAlibabaCloud alibabaCloud;
    @JsonProperty("aws")
    private InfrastructureStatusPSAws aws;
    @JsonProperty("azure")
    private InfrastructureStatusPSAzure azure;
    @JsonProperty("baremetal")
    private InfrastructureStatusPSBaremetal baremetal;
    @JsonProperty("equinixMetal")
    private InfrastructureStatusPSEquinixMetal equinixMetal;
    @JsonProperty("external")
    private InfrastructureStatusPSExternal external;
    @JsonProperty("gcp")
    private InfrastructureStatusPSGcp gcp;
    @JsonProperty("ibmcloud")
    private InfrastructureStatusPSIbmcloud ibmcloud;
    @JsonProperty("kubevirt")
    private InfrastructureStatusPSKubevirt kubevirt;
    @JsonProperty("nutanix")
    private InfrastructureStatusPSNutanix nutanix;
    @JsonProperty("openstack")
    private InfrastructureStatusPSOpenstack openstack;
    @JsonProperty("ovirt")
    private InfrastructureStatusPSOvirt ovirt;
    @JsonProperty("powervs")
    private InfrastructureStatusPSPowervs powervs;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vsphere")
    private InfrastructureStatusPSVsphere vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfrastructureStatusPlatformStatus() {
    }

    public InfrastructureStatusPlatformStatus(InfrastructureStatusPSAlibabaCloud alibabaCloud, InfrastructureStatusPSAws aws, InfrastructureStatusPSAzure azure, InfrastructureStatusPSBaremetal baremetal, InfrastructureStatusPSEquinixMetal equinixMetal, InfrastructureStatusPSExternal external, InfrastructureStatusPSGcp gcp, InfrastructureStatusPSIbmcloud ibmcloud, InfrastructureStatusPSKubevirt kubevirt, InfrastructureStatusPSNutanix nutanix, InfrastructureStatusPSOpenstack openstack, InfrastructureStatusPSOvirt ovirt, InfrastructureStatusPSPowervs powervs, String type, InfrastructureStatusPSVsphere vsphere) {
        super();
        this.alibabaCloud = alibabaCloud;
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.equinixMetal = equinixMetal;
        this.external = external;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.kubevirt = kubevirt;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.powervs = powervs;
        this.type = type;
        this.vsphere = vsphere;
    }

    @JsonProperty("alibabaCloud")
    public InfrastructureStatusPSAlibabaCloud getAlibabaCloud() {
        return alibabaCloud;
    }

    @JsonProperty("alibabaCloud")
    public void setAlibabaCloud(InfrastructureStatusPSAlibabaCloud alibabaCloud) {
        this.alibabaCloud = alibabaCloud;
    }

    @JsonProperty("aws")
    public InfrastructureStatusPSAws getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(InfrastructureStatusPSAws aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public InfrastructureStatusPSAzure getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(InfrastructureStatusPSAzure azure) {
        this.azure = azure;
    }

    @JsonProperty("baremetal")
    public InfrastructureStatusPSBaremetal getBaremetal() {
        return baremetal;
    }

    @JsonProperty("baremetal")
    public void setBaremetal(InfrastructureStatusPSBaremetal baremetal) {
        this.baremetal = baremetal;
    }

    @JsonProperty("equinixMetal")
    public InfrastructureStatusPSEquinixMetal getEquinixMetal() {
        return equinixMetal;
    }

    @JsonProperty("equinixMetal")
    public void setEquinixMetal(InfrastructureStatusPSEquinixMetal equinixMetal) {
        this.equinixMetal = equinixMetal;
    }

    @JsonProperty("external")
    public InfrastructureStatusPSExternal getExternal() {
        return external;
    }

    @JsonProperty("external")
    public void setExternal(InfrastructureStatusPSExternal external) {
        this.external = external;
    }

    @JsonProperty("gcp")
    public InfrastructureStatusPSGcp getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(InfrastructureStatusPSGcp gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public InfrastructureStatusPSIbmcloud getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(InfrastructureStatusPSIbmcloud ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("kubevirt")
    public InfrastructureStatusPSKubevirt getKubevirt() {
        return kubevirt;
    }

    @JsonProperty("kubevirt")
    public void setKubevirt(InfrastructureStatusPSKubevirt kubevirt) {
        this.kubevirt = kubevirt;
    }

    @JsonProperty("nutanix")
    public InfrastructureStatusPSNutanix getNutanix() {
        return nutanix;
    }

    @JsonProperty("nutanix")
    public void setNutanix(InfrastructureStatusPSNutanix nutanix) {
        this.nutanix = nutanix;
    }

    @JsonProperty("openstack")
    public InfrastructureStatusPSOpenstack getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(InfrastructureStatusPSOpenstack openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public InfrastructureStatusPSOvirt getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    public void setOvirt(InfrastructureStatusPSOvirt ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("powervs")
    public InfrastructureStatusPSPowervs getPowervs() {
        return powervs;
    }

    @JsonProperty("powervs")
    public void setPowervs(InfrastructureStatusPSPowervs powervs) {
        this.powervs = powervs;
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
    public InfrastructureStatusPSVsphere getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(InfrastructureStatusPSVsphere vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public InfrastructureStatusPlatformStatusBuilder edit() {
        return new InfrastructureStatusPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public InfrastructureStatusPlatformStatusBuilder toBuilder() {
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
