
package io.fabric8.openshift.api.model.config.v1;

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
 * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
 */
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PlatformStatus implements Editable<PlatformStatusBuilder>, KubernetesResource
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

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("alibabaCloud")
    public AlibabaCloudPlatformStatus getAlibabaCloud() {
        return alibabaCloud;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("alibabaCloud")
    public void setAlibabaCloud(AlibabaCloudPlatformStatus alibabaCloud) {
        this.alibabaCloud = alibabaCloud;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("aws")
    public AWSPlatformStatus getAws() {
        return aws;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("aws")
    public void setAws(AWSPlatformStatus aws) {
        this.aws = aws;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("azure")
    public AzurePlatformStatus getAzure() {
        return azure;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("azure")
    public void setAzure(AzurePlatformStatus azure) {
        this.azure = azure;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("baremetal")
    public BareMetalPlatformStatus getBaremetal() {
        return baremetal;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("baremetal")
    public void setBaremetal(BareMetalPlatformStatus baremetal) {
        this.baremetal = baremetal;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("equinixMetal")
    public EquinixMetalPlatformStatus getEquinixMetal() {
        return equinixMetal;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("equinixMetal")
    public void setEquinixMetal(EquinixMetalPlatformStatus equinixMetal) {
        this.equinixMetal = equinixMetal;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("external")
    public ExternalPlatformStatus getExternal() {
        return external;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("external")
    public void setExternal(ExternalPlatformStatus external) {
        this.external = external;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("gcp")
    public GCPPlatformStatus getGcp() {
        return gcp;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("gcp")
    public void setGcp(GCPPlatformStatus gcp) {
        this.gcp = gcp;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("ibmcloud")
    public IBMCloudPlatformStatus getIbmcloud() {
        return ibmcloud;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(IBMCloudPlatformStatus ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("kubevirt")
    public KubevirtPlatformStatus getKubevirt() {
        return kubevirt;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("kubevirt")
    public void setKubevirt(KubevirtPlatformStatus kubevirt) {
        this.kubevirt = kubevirt;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("nutanix")
    public NutanixPlatformStatus getNutanix() {
        return nutanix;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("nutanix")
    public void setNutanix(NutanixPlatformStatus nutanix) {
        this.nutanix = nutanix;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("openstack")
    public OpenStackPlatformStatus getOpenstack() {
        return openstack;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("openstack")
    public void setOpenstack(OpenStackPlatformStatus openstack) {
        this.openstack = openstack;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("ovirt")
    public OvirtPlatformStatus getOvirt() {
        return ovirt;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("ovirt")
    public void setOvirt(OvirtPlatformStatus ovirt) {
        this.ovirt = ovirt;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("powervs")
    public PowerVSPlatformStatus getPowervs() {
        return powervs;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("powervs")
    public void setPowervs(PowerVSPlatformStatus powervs) {
        this.powervs = powervs;
    }

    /**
     * type is the underlying infrastructure provider for the cluster. This value controls whether infrastructure automation such as service load balancers, dynamic volume provisioning, machine creation and deletion, and other integrations are enabled. If None, no infrastructure automation is enabled. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", "EquinixMetal", "PowerVS", "AlibabaCloud", "Nutanix" and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.<br><p> <br><p> This value will be synced with to the `status.platform` and `status.platformStatus.type`. Currently this value cannot be changed once set.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the underlying infrastructure provider for the cluster. This value controls whether infrastructure automation such as service load balancers, dynamic volume provisioning, machine creation and deletion, and other integrations are enabled. If None, no infrastructure automation is enabled. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", "EquinixMetal", "PowerVS", "AlibabaCloud", "Nutanix" and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.<br><p> <br><p> This value will be synced with to the `status.platform` and `status.platformStatus.type`. Currently this value cannot be changed once set.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("vsphere")
    public VSpherePlatformStatus getVsphere() {
        return vsphere;
    }

    /**
     * PlatformStatus holds the current status specific to the underlying infrastructure provider of the current cluster. Since these are used at status-level for the underlying cluster, it is supposed that only one of the status structs is set.
     */
    @JsonProperty("vsphere")
    public void setVsphere(VSpherePlatformStatus vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public PlatformStatusBuilder edit() {
        return new PlatformStatusBuilder(this);
    }

    @JsonIgnore
    public PlatformStatusBuilder toBuilder() {
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
