
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
public class PlatformSpec implements KubernetesResource
{

    @JsonProperty("alibabaCloud")
    private AlibabaCloudPlatformSpec alibabaCloud;
    @JsonProperty("aws")
    private AWSPlatformSpec aws;
    @JsonProperty("azure")
    private AzurePlatformSpec azure;
    @JsonProperty("baremetal")
    private BareMetalPlatformSpec baremetal;
    @JsonProperty("equinixMetal")
    private EquinixMetalPlatformSpec equinixMetal;
    @JsonProperty("external")
    private ExternalPlatformSpec external;
    @JsonProperty("gcp")
    private GCPPlatformSpec gcp;
    @JsonProperty("ibmcloud")
    private IBMCloudPlatformSpec ibmcloud;
    @JsonProperty("kubevirt")
    private KubevirtPlatformSpec kubevirt;
    @JsonProperty("nutanix")
    private NutanixPlatformSpec nutanix;
    @JsonProperty("openstack")
    private OpenStackPlatformSpec openstack;
    @JsonProperty("ovirt")
    private OvirtPlatformSpec ovirt;
    @JsonProperty("powervs")
    private PowerVSPlatformSpec powervs;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vsphere")
    private VSpherePlatformSpec vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlatformSpec() {
    }

    public PlatformSpec(AlibabaCloudPlatformSpec alibabaCloud, AWSPlatformSpec aws, AzurePlatformSpec azure, BareMetalPlatformSpec baremetal, EquinixMetalPlatformSpec equinixMetal, ExternalPlatformSpec external, GCPPlatformSpec gcp, IBMCloudPlatformSpec ibmcloud, KubevirtPlatformSpec kubevirt, NutanixPlatformSpec nutanix, OpenStackPlatformSpec openstack, OvirtPlatformSpec ovirt, PowerVSPlatformSpec powervs, String type, VSpherePlatformSpec vsphere) {
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
    public AlibabaCloudPlatformSpec getAlibabaCloud() {
        return alibabaCloud;
    }

    @JsonProperty("alibabaCloud")
    public void setAlibabaCloud(AlibabaCloudPlatformSpec alibabaCloud) {
        this.alibabaCloud = alibabaCloud;
    }

    @JsonProperty("aws")
    public AWSPlatformSpec getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(AWSPlatformSpec aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public AzurePlatformSpec getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(AzurePlatformSpec azure) {
        this.azure = azure;
    }

    @JsonProperty("baremetal")
    public BareMetalPlatformSpec getBaremetal() {
        return baremetal;
    }

    @JsonProperty("baremetal")
    public void setBaremetal(BareMetalPlatformSpec baremetal) {
        this.baremetal = baremetal;
    }

    @JsonProperty("equinixMetal")
    public EquinixMetalPlatformSpec getEquinixMetal() {
        return equinixMetal;
    }

    @JsonProperty("equinixMetal")
    public void setEquinixMetal(EquinixMetalPlatformSpec equinixMetal) {
        this.equinixMetal = equinixMetal;
    }

    @JsonProperty("external")
    public ExternalPlatformSpec getExternal() {
        return external;
    }

    @JsonProperty("external")
    public void setExternal(ExternalPlatformSpec external) {
        this.external = external;
    }

    @JsonProperty("gcp")
    public GCPPlatformSpec getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(GCPPlatformSpec gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public IBMCloudPlatformSpec getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(IBMCloudPlatformSpec ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("kubevirt")
    public KubevirtPlatformSpec getKubevirt() {
        return kubevirt;
    }

    @JsonProperty("kubevirt")
    public void setKubevirt(KubevirtPlatformSpec kubevirt) {
        this.kubevirt = kubevirt;
    }

    @JsonProperty("nutanix")
    public NutanixPlatformSpec getNutanix() {
        return nutanix;
    }

    @JsonProperty("nutanix")
    public void setNutanix(NutanixPlatformSpec nutanix) {
        this.nutanix = nutanix;
    }

    @JsonProperty("openstack")
    public OpenStackPlatformSpec getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(OpenStackPlatformSpec openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public OvirtPlatformSpec getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    public void setOvirt(OvirtPlatformSpec ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("powervs")
    public PowerVSPlatformSpec getPowervs() {
        return powervs;
    }

    @JsonProperty("powervs")
    public void setPowervs(PowerVSPlatformSpec powervs) {
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
    public VSpherePlatformSpec getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(VSpherePlatformSpec vsphere) {
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
