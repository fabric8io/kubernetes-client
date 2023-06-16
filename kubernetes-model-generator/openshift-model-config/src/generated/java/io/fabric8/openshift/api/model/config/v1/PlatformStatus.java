
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@Setter
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
public class PlatformStatus implements KubernetesResource
{

    @JsonProperty("alibabaCloud")
    private AlibabaCloudPlatformStatus alibabaCloud;
    @JsonProperty("aws")
    private AWSPlatformStatus aws;
    @JsonProperty("azure")
    private AzurePlatformStatus azure;
    @JsonProperty("baremetal")
    private BareMetalPlatformStatus baremetal;
    @JsonProperty("equinixMetal")
    private EquinixMetalPlatformStatus equinixMetal;
    @JsonProperty("external")
    private ExternalPlatformStatus external;
    @JsonProperty("gcp")
    private GCPPlatformStatus gcp;
    @JsonProperty("ibmcloud")
    private IBMCloudPlatformStatus ibmcloud;
    @JsonProperty("kubevirt")
    private KubevirtPlatformStatus kubevirt;
    @JsonProperty("nutanix")
    private NutanixPlatformStatus nutanix;
    @JsonProperty("openstack")
    private OpenStackPlatformStatus openstack;
    @JsonProperty("ovirt")
    private OvirtPlatformStatus ovirt;
    @JsonProperty("powervs")
    private PowerVSPlatformStatus powervs;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vsphere")
    private VSpherePlatformStatus vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlatformStatus() {
    }

    public PlatformStatus(AlibabaCloudPlatformStatus alibabaCloud, AWSPlatformStatus aws, AzurePlatformStatus azure, BareMetalPlatformStatus baremetal, EquinixMetalPlatformStatus equinixMetal, ExternalPlatformStatus external, GCPPlatformStatus gcp, IBMCloudPlatformStatus ibmcloud, KubevirtPlatformStatus kubevirt, NutanixPlatformStatus nutanix, OpenStackPlatformStatus openstack, OvirtPlatformStatus ovirt, PowerVSPlatformStatus powervs, String type, VSpherePlatformStatus vsphere) {
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
    public AlibabaCloudPlatformStatus getAlibabaCloud() {
        return alibabaCloud;
    }

    @JsonProperty("alibabaCloud")
    public void setAlibabaCloud(AlibabaCloudPlatformStatus alibabaCloud) {
        this.alibabaCloud = alibabaCloud;
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

    @JsonProperty("external")
    public ExternalPlatformStatus getExternal() {
        return external;
    }

    @JsonProperty("external")
    public void setExternal(ExternalPlatformStatus external) {
        this.external = external;
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

    @JsonProperty("nutanix")
    public NutanixPlatformStatus getNutanix() {
        return nutanix;
    }

    @JsonProperty("nutanix")
    public void setNutanix(NutanixPlatformStatus nutanix) {
        this.nutanix = nutanix;
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

    @JsonProperty("powervs")
    public PowerVSPlatformStatus getPowervs() {
        return powervs;
    }

    @JsonProperty("powervs")
    public void setPowervs(PowerVSPlatformStatus powervs) {
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
