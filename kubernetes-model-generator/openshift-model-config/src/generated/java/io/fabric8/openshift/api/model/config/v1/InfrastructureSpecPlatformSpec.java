
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
public class InfrastructureSpecPlatformSpec implements Editable<InfrastructureSpecPlatformSpecBuilder> , KubernetesResource
{

    @JsonProperty("alibabaCloud")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object alibabaCloud;
    @JsonProperty("aws")
    private InfrastructureSpecPSAws aws;
    @JsonProperty("azure")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object azure;
    @JsonProperty("baremetal")
    private InfrastructureSpecPSBaremetal baremetal;
    @JsonProperty("equinixMetal")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object equinixMetal;
    @JsonProperty("external")
    private InfrastructureSpecPSExternal external;
    @JsonProperty("gcp")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object gcp;
    @JsonProperty("ibmcloud")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object ibmcloud;
    @JsonProperty("kubevirt")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object kubevirt;
    @JsonProperty("nutanix")
    private InfrastructureSpecPSNutanix nutanix;
    @JsonProperty("openstack")
    private InfrastructureSpecPSOpenstack openstack;
    @JsonProperty("ovirt")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object ovirt;
    @JsonProperty("powervs")
    private InfrastructureSpecPSPowervs powervs;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vsphere")
    private InfrastructureSpecPSVsphere vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfrastructureSpecPlatformSpec() {
    }

    public InfrastructureSpecPlatformSpec(Object alibabaCloud, InfrastructureSpecPSAws aws, Object azure, InfrastructureSpecPSBaremetal baremetal, Object equinixMetal, InfrastructureSpecPSExternal external, Object gcp, Object ibmcloud, Object kubevirt, InfrastructureSpecPSNutanix nutanix, InfrastructureSpecPSOpenstack openstack, Object ovirt, InfrastructureSpecPSPowervs powervs, String type, InfrastructureSpecPSVsphere vsphere) {
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
    public Object getAlibabaCloud() {
        return alibabaCloud;
    }

    @JsonProperty("alibabaCloud")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setAlibabaCloud(Object alibabaCloud) {
        this.alibabaCloud = alibabaCloud;
    }

    @JsonProperty("aws")
    public InfrastructureSpecPSAws getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(InfrastructureSpecPSAws aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public Object getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setAzure(Object azure) {
        this.azure = azure;
    }

    @JsonProperty("baremetal")
    public InfrastructureSpecPSBaremetal getBaremetal() {
        return baremetal;
    }

    @JsonProperty("baremetal")
    public void setBaremetal(InfrastructureSpecPSBaremetal baremetal) {
        this.baremetal = baremetal;
    }

    @JsonProperty("equinixMetal")
    public Object getEquinixMetal() {
        return equinixMetal;
    }

    @JsonProperty("equinixMetal")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setEquinixMetal(Object equinixMetal) {
        this.equinixMetal = equinixMetal;
    }

    @JsonProperty("external")
    public InfrastructureSpecPSExternal getExternal() {
        return external;
    }

    @JsonProperty("external")
    public void setExternal(InfrastructureSpecPSExternal external) {
        this.external = external;
    }

    @JsonProperty("gcp")
    public Object getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setGcp(Object gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public Object getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setIbmcloud(Object ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("kubevirt")
    public Object getKubevirt() {
        return kubevirt;
    }

    @JsonProperty("kubevirt")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setKubevirt(Object kubevirt) {
        this.kubevirt = kubevirt;
    }

    @JsonProperty("nutanix")
    public InfrastructureSpecPSNutanix getNutanix() {
        return nutanix;
    }

    @JsonProperty("nutanix")
    public void setNutanix(InfrastructureSpecPSNutanix nutanix) {
        this.nutanix = nutanix;
    }

    @JsonProperty("openstack")
    public InfrastructureSpecPSOpenstack getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(InfrastructureSpecPSOpenstack openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public Object getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setOvirt(Object ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("powervs")
    public InfrastructureSpecPSPowervs getPowervs() {
        return powervs;
    }

    @JsonProperty("powervs")
    public void setPowervs(InfrastructureSpecPSPowervs powervs) {
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
    public InfrastructureSpecPSVsphere getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(InfrastructureSpecPSVsphere vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public InfrastructureSpecPlatformSpecBuilder edit() {
        return new InfrastructureSpecPlatformSpecBuilder(this);
    }

    @JsonIgnore
    public InfrastructureSpecPlatformSpecBuilder toBuilder() {
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
