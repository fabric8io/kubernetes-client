
package io.fabric8.openshift.api.model.installer.v1;

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
import io.fabric8.openshift.api.model.installer.aws.v1.Metadata;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterPlatformMetadata contains metadata for platfrom.
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
    "powervc",
    "powervs",
    "vsphere"
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
public class ClusterPlatformMetadata implements Editable<ClusterPlatformMetadataBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private Metadata aws;
    @JsonProperty("azure")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object azure;
    @JsonProperty("baremetal")
    private io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata baremetal;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.installer.gcp.v1.Metadata gcp;
    @JsonProperty("ibmcloud")
    private io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata ibmcloud;
    @JsonProperty("nutanix")
    private io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata nutanix;
    @JsonProperty("openstack")
    private io.fabric8.openshift.api.model.installer.openstack.v1.Metadata openstack;
    @JsonProperty("ovirt")
    private io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata ovirt;
    @JsonProperty("powervc")
    private io.fabric8.openshift.api.model.installer.powervc.v1.Metadata powervc;
    @JsonProperty("powervs")
    private io.fabric8.openshift.api.model.installer.powervs.v1.Metadata powervs;
    @JsonProperty("vsphere")
    private io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterPlatformMetadata() {
    }

    public ClusterPlatformMetadata(Metadata aws, Object azure, io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata baremetal, io.fabric8.openshift.api.model.installer.gcp.v1.Metadata gcp, io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata ibmcloud, io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata nutanix, io.fabric8.openshift.api.model.installer.openstack.v1.Metadata openstack, io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata ovirt, io.fabric8.openshift.api.model.installer.powervc.v1.Metadata powervc, io.fabric8.openshift.api.model.installer.powervs.v1.Metadata powervs, io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.powervc = powervc;
        this.powervs = powervs;
        this.vsphere = vsphere;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("aws")
    public Metadata getAws() {
        return aws;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("aws")
    public void setAws(Metadata aws) {
        this.aws = aws;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("azure")
    public Object getAzure() {
        return azure;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("azure")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setAzure(Object azure) {
        this.azure = azure;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("baremetal")
    public io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata getBaremetal() {
        return baremetal;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("baremetal")
    public void setBaremetal(io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata baremetal) {
        this.baremetal = baremetal;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.installer.gcp.v1.Metadata getGcp() {
        return gcp;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.installer.gcp.v1.Metadata gcp) {
        this.gcp = gcp;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("ibmcloud")
    public io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata getIbmcloud() {
        return ibmcloud;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("nutanix")
    public io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata getNutanix() {
        return nutanix;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("nutanix")
    public void setNutanix(io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata nutanix) {
        this.nutanix = nutanix;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("openstack")
    public io.fabric8.openshift.api.model.installer.openstack.v1.Metadata getOpenstack() {
        return openstack;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("openstack")
    public void setOpenstack(io.fabric8.openshift.api.model.installer.openstack.v1.Metadata openstack) {
        this.openstack = openstack;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("ovirt")
    public io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata getOvirt() {
        return ovirt;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("ovirt")
    public void setOvirt(io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata ovirt) {
        this.ovirt = ovirt;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("powervc")
    public io.fabric8.openshift.api.model.installer.powervc.v1.Metadata getPowervc() {
        return powervc;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("powervc")
    public void setPowervc(io.fabric8.openshift.api.model.installer.powervc.v1.Metadata powervc) {
        this.powervc = powervc;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("powervs")
    public io.fabric8.openshift.api.model.installer.powervs.v1.Metadata getPowervs() {
        return powervs;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("powervs")
    public void setPowervs(io.fabric8.openshift.api.model.installer.powervs.v1.Metadata powervs) {
        this.powervs = powervs;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("vsphere")
    public io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata getVsphere() {
        return vsphere;
    }

    /**
     * ClusterPlatformMetadata contains metadata for platfrom.
     */
    @JsonProperty("vsphere")
    public void setVsphere(io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public ClusterPlatformMetadataBuilder edit() {
        return new ClusterPlatformMetadataBuilder(this);
    }

    @JsonIgnore
    public ClusterPlatformMetadataBuilder toBuilder() {
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
        if (!(o instanceof ClusterPlatformMetadata)) {
            return false;
        }
        ClusterPlatformMetadata other = (ClusterPlatformMetadata) o;
        if (!other.canEqual(this)) {
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
        Object this$powervc = this.getPowervc();
        Object other$powervc = other.getPowervc();
        if (this$powervc == null ? other$powervc != null : !this$powervc.equals(other$powervc)) {
            return false;
        }
        Object this$powervs = this.getPowervs();
        Object other$powervs = other.getPowervs();
        if (this$powervs == null ? other$powervs != null : !this$powervs.equals(other$powervs)) {
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
        return other instanceof ClusterPlatformMetadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $azure = this.getAzure();
        result = result * prime + ($azure == null ? 43 : $azure.hashCode());
        Object $baremetal = this.getBaremetal();
        result = result * prime + ($baremetal == null ? 43 : $baremetal.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $ibmcloud = this.getIbmcloud();
        result = result * prime + ($ibmcloud == null ? 43 : $ibmcloud.hashCode());
        Object $nutanix = this.getNutanix();
        result = result * prime + ($nutanix == null ? 43 : $nutanix.hashCode());
        Object $openstack = this.getOpenstack();
        result = result * prime + ($openstack == null ? 43 : $openstack.hashCode());
        Object $ovirt = this.getOvirt();
        result = result * prime + ($ovirt == null ? 43 : $ovirt.hashCode());
        Object $powervc = this.getPowervc();
        result = result * prime + ($powervc == null ? 43 : $powervc.hashCode());
        Object $powervs = this.getPowervs();
        result = result * prime + ($powervs == null ? 43 : $powervs.hashCode());
        Object $vsphere = this.getVsphere();
        result = result * prime + ($vsphere == null ? 43 : $vsphere.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterPlatformMetadata(" + "aws=" + this.getAws() + ", azure=" + this.getAzure() + ", baremetal=" + this.getBaremetal() + ", gcp=" + this.getGcp() + ", ibmcloud=" + this.getIbmcloud() + ", nutanix=" + this.getNutanix() + ", openstack=" + this.getOpenstack() + ", ovirt=" + this.getOvirt() + ", powervc=" + this.getPowervc() + ", powervs=" + this.getPowervs() + ", vsphere=" + this.getVsphere() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
