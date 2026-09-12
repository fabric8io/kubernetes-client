
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

/**
 * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
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
public class PlatformSpec implements Editable<PlatformSpecBuilder>, KubernetesResource
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

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("alibabaCloud")
    public AlibabaCloudPlatformSpec getAlibabaCloud() {
        return alibabaCloud;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("alibabaCloud")
    public void setAlibabaCloud(AlibabaCloudPlatformSpec alibabaCloud) {
        this.alibabaCloud = alibabaCloud;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("aws")
    public AWSPlatformSpec getAws() {
        return aws;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("aws")
    public void setAws(AWSPlatformSpec aws) {
        this.aws = aws;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("azure")
    public AzurePlatformSpec getAzure() {
        return azure;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("azure")
    public void setAzure(AzurePlatformSpec azure) {
        this.azure = azure;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("baremetal")
    public BareMetalPlatformSpec getBaremetal() {
        return baremetal;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("baremetal")
    public void setBaremetal(BareMetalPlatformSpec baremetal) {
        this.baremetal = baremetal;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("equinixMetal")
    public EquinixMetalPlatformSpec getEquinixMetal() {
        return equinixMetal;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("equinixMetal")
    public void setEquinixMetal(EquinixMetalPlatformSpec equinixMetal) {
        this.equinixMetal = equinixMetal;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("external")
    public ExternalPlatformSpec getExternal() {
        return external;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("external")
    public void setExternal(ExternalPlatformSpec external) {
        this.external = external;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("gcp")
    public GCPPlatformSpec getGcp() {
        return gcp;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("gcp")
    public void setGcp(GCPPlatformSpec gcp) {
        this.gcp = gcp;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("ibmcloud")
    public IBMCloudPlatformSpec getIbmcloud() {
        return ibmcloud;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(IBMCloudPlatformSpec ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("kubevirt")
    public KubevirtPlatformSpec getKubevirt() {
        return kubevirt;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("kubevirt")
    public void setKubevirt(KubevirtPlatformSpec kubevirt) {
        this.kubevirt = kubevirt;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("nutanix")
    public NutanixPlatformSpec getNutanix() {
        return nutanix;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("nutanix")
    public void setNutanix(NutanixPlatformSpec nutanix) {
        this.nutanix = nutanix;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("openstack")
    public OpenStackPlatformSpec getOpenstack() {
        return openstack;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("openstack")
    public void setOpenstack(OpenStackPlatformSpec openstack) {
        this.openstack = openstack;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("ovirt")
    public OvirtPlatformSpec getOvirt() {
        return ovirt;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("ovirt")
    public void setOvirt(OvirtPlatformSpec ovirt) {
        this.ovirt = ovirt;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("powervs")
    public PowerVSPlatformSpec getPowervs() {
        return powervs;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("powervs")
    public void setPowervs(PowerVSPlatformSpec powervs) {
        this.powervs = powervs;
    }

    /**
     * type is the underlying infrastructure provider for the cluster. This value controls whether infrastructure automation such as service load balancers, dynamic volume provisioning, machine creation and deletion, and other integrations are enabled. If None, no infrastructure automation is enabled. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", "KubeVirt", "EquinixMetal", "PowerVS", "AlibabaCloud", "Nutanix" and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the underlying infrastructure provider for the cluster. This value controls whether infrastructure automation such as service load balancers, dynamic volume provisioning, machine creation and deletion, and other integrations are enabled. If None, no infrastructure automation is enabled. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", "KubeVirt", "EquinixMetal", "PowerVS", "AlibabaCloud", "Nutanix" and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("vsphere")
    public VSpherePlatformSpec getVsphere() {
        return vsphere;
    }

    /**
     * PlatformSpec holds the desired state specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("vsphere")
    public void setVsphere(VSpherePlatformSpec vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public PlatformSpecBuilder edit() {
        return new PlatformSpecBuilder(this);
    }

    @JsonIgnore
    public PlatformSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PlatformSpec)) {
            return false;
        }
        PlatformSpec other = (PlatformSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alibabaCloud = this.getAlibabaCloud();
        Object other$alibabaCloud = other.getAlibabaCloud();
        if (this$alibabaCloud == null ? other$alibabaCloud != null : !this$alibabaCloud.equals(other$alibabaCloud)) {
            return false;
        }
        Object this$aws = this.getAws();
        Object other$aws = other.getAws();
        if (this$aws == null ? other$aws != null : !this$aws.equals(other$aws)) {
            return false;
        }
        Object this$azure = this.getAzure();
        Object other$azure = other.getAzure();
        if (this$azure == null ? other$azure != null : !this$azure.equals(other$azure)) {
            return false;
        }
        Object this$baremetal = this.getBaremetal();
        Object other$baremetal = other.getBaremetal();
        if (this$baremetal == null ? other$baremetal != null : !this$baremetal.equals(other$baremetal)) {
            return false;
        }
        Object this$equinixMetal = this.getEquinixMetal();
        Object other$equinixMetal = other.getEquinixMetal();
        if (this$equinixMetal == null ? other$equinixMetal != null : !this$equinixMetal.equals(other$equinixMetal)) {
            return false;
        }
        Object this$external = this.getExternal();
        Object other$external = other.getExternal();
        if (this$external == null ? other$external != null : !this$external.equals(other$external)) {
            return false;
        }
        Object this$gcp = this.getGcp();
        Object other$gcp = other.getGcp();
        if (this$gcp == null ? other$gcp != null : !this$gcp.equals(other$gcp)) {
            return false;
        }
        Object this$ibmcloud = this.getIbmcloud();
        Object other$ibmcloud = other.getIbmcloud();
        if (this$ibmcloud == null ? other$ibmcloud != null : !this$ibmcloud.equals(other$ibmcloud)) {
            return false;
        }
        Object this$kubevirt = this.getKubevirt();
        Object other$kubevirt = other.getKubevirt();
        if (this$kubevirt == null ? other$kubevirt != null : !this$kubevirt.equals(other$kubevirt)) {
            return false;
        }
        Object this$nutanix = this.getNutanix();
        Object other$nutanix = other.getNutanix();
        if (this$nutanix == null ? other$nutanix != null : !this$nutanix.equals(other$nutanix)) {
            return false;
        }
        Object this$openstack = this.getOpenstack();
        Object other$openstack = other.getOpenstack();
        if (this$openstack == null ? other$openstack != null : !this$openstack.equals(other$openstack)) {
            return false;
        }
        Object this$ovirt = this.getOvirt();
        Object other$ovirt = other.getOvirt();
        if (this$ovirt == null ? other$ovirt != null : !this$ovirt.equals(other$ovirt)) {
            return false;
        }
        Object this$powervs = this.getPowervs();
        Object other$powervs = other.getPowervs();
        if (this$powervs == null ? other$powervs != null : !this$powervs.equals(other$powervs)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$vsphere = this.getVsphere();
        Object other$vsphere = other.getVsphere();
        if (this$vsphere == null ? other$vsphere != null : !this$vsphere.equals(other$vsphere)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlatformSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alibabaCloud = this.getAlibabaCloud();
        result = result * prime + ($alibabaCloud == null ? 43 : $alibabaCloud.hashCode());
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $azure = this.getAzure();
        result = result * prime + ($azure == null ? 43 : $azure.hashCode());
        Object $baremetal = this.getBaremetal();
        result = result * prime + ($baremetal == null ? 43 : $baremetal.hashCode());
        Object $equinixMetal = this.getEquinixMetal();
        result = result * prime + ($equinixMetal == null ? 43 : $equinixMetal.hashCode());
        Object $external = this.getExternal();
        result = result * prime + ($external == null ? 43 : $external.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $ibmcloud = this.getIbmcloud();
        result = result * prime + ($ibmcloud == null ? 43 : $ibmcloud.hashCode());
        Object $kubevirt = this.getKubevirt();
        result = result * prime + ($kubevirt == null ? 43 : $kubevirt.hashCode());
        Object $nutanix = this.getNutanix();
        result = result * prime + ($nutanix == null ? 43 : $nutanix.hashCode());
        Object $openstack = this.getOpenstack();
        result = result * prime + ($openstack == null ? 43 : $openstack.hashCode());
        Object $ovirt = this.getOvirt();
        result = result * prime + ($ovirt == null ? 43 : $ovirt.hashCode());
        Object $powervs = this.getPowervs();
        result = result * prime + ($powervs == null ? 43 : $powervs.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $vsphere = this.getVsphere();
        result = result * prime + ($vsphere == null ? 43 : $vsphere.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlatformSpec(" + "alibabaCloud=" + this.getAlibabaCloud() + ", aws=" + this.getAws() + ", azure=" + this.getAzure() + ", baremetal=" + this.getBaremetal() + ", equinixMetal=" + this.getEquinixMetal() + ", external=" + this.getExternal() + ", gcp=" + this.getGcp() + ", ibmcloud=" + this.getIbmcloud() + ", kubevirt=" + this.getKubevirt() + ", nutanix=" + this.getNutanix() + ", openstack=" + this.getOpenstack() + ", ovirt=" + this.getOvirt() + ", powervs=" + this.getPowervs() + ", type=" + this.getType() + ", vsphere=" + this.getVsphere() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
