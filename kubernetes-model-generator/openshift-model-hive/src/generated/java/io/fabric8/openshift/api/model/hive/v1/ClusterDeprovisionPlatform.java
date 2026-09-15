
package io.fabric8.openshift.api.model.hive.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "gcp",
    "ibmcloud",
    "openstack",
    "ovirt",
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
public class ClusterDeprovisionPlatform implements Editable<ClusterDeprovisionPlatformBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private AWSClusterDeprovision aws;
    @JsonProperty("azure")
    private AzureClusterDeprovision azure;
    @JsonProperty("gcp")
    private GCPClusterDeprovision gcp;
    @JsonProperty("ibmcloud")
    private IBMClusterDeprovision ibmcloud;
    @JsonProperty("openstack")
    private OpenStackClusterDeprovision openstack;
    @JsonProperty("ovirt")
    private OvirtClusterDeprovision ovirt;
    @JsonProperty("vsphere")
    private VSphereClusterDeprovision vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterDeprovisionPlatform() {
    }

    public ClusterDeprovisionPlatform(AWSClusterDeprovision aws, AzureClusterDeprovision azure, GCPClusterDeprovision gcp, IBMClusterDeprovision ibmcloud, OpenStackClusterDeprovision openstack, OvirtClusterDeprovision ovirt, VSphereClusterDeprovision vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.vsphere = vsphere;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("aws")
    public AWSClusterDeprovision getAws() {
        return aws;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("aws")
    public void setAws(AWSClusterDeprovision aws) {
        this.aws = aws;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("azure")
    public AzureClusterDeprovision getAzure() {
        return azure;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("azure")
    public void setAzure(AzureClusterDeprovision azure) {
        this.azure = azure;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("gcp")
    public GCPClusterDeprovision getGcp() {
        return gcp;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("gcp")
    public void setGcp(GCPClusterDeprovision gcp) {
        this.gcp = gcp;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("ibmcloud")
    public IBMClusterDeprovision getIbmcloud() {
        return ibmcloud;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(IBMClusterDeprovision ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("openstack")
    public OpenStackClusterDeprovision getOpenstack() {
        return openstack;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("openstack")
    public void setOpenstack(OpenStackClusterDeprovision openstack) {
        this.openstack = openstack;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("ovirt")
    public OvirtClusterDeprovision getOvirt() {
        return ovirt;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("ovirt")
    public void setOvirt(OvirtClusterDeprovision ovirt) {
        this.ovirt = ovirt;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("vsphere")
    public VSphereClusterDeprovision getVsphere() {
        return vsphere;
    }

    /**
     * ClusterDeprovisionPlatform contains platform-specific configuration for the deprovision
     */
    @JsonProperty("vsphere")
    public void setVsphere(VSphereClusterDeprovision vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public ClusterDeprovisionPlatformBuilder edit() {
        return new ClusterDeprovisionPlatformBuilder(this);
    }

    @JsonIgnore
    public ClusterDeprovisionPlatformBuilder toBuilder() {
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
        if (!(o instanceof ClusterDeprovisionPlatform)) {
            return false;
        }
        ClusterDeprovisionPlatform other = (ClusterDeprovisionPlatform) o;
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
        return other instanceof ClusterDeprovisionPlatform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $azure = this.getAzure();
        result = result * prime + ($azure == null ? 43 : $azure.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $ibmcloud = this.getIbmcloud();
        result = result * prime + ($ibmcloud == null ? 43 : $ibmcloud.hashCode());
        Object $openstack = this.getOpenstack();
        result = result * prime + ($openstack == null ? 43 : $openstack.hashCode());
        Object $ovirt = this.getOvirt();
        result = result * prime + ($ovirt == null ? 43 : $ovirt.hashCode());
        Object $vsphere = this.getVsphere();
        result = result * prime + ($vsphere == null ? 43 : $vsphere.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterDeprovisionPlatform(" + "aws=" + this.getAws() + ", azure=" + this.getAzure() + ", gcp=" + this.getGcp() + ", ibmcloud=" + this.getIbmcloud() + ", openstack=" + this.getOpenstack() + ", ovirt=" + this.getOvirt() + ", vsphere=" + this.getVsphere() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
