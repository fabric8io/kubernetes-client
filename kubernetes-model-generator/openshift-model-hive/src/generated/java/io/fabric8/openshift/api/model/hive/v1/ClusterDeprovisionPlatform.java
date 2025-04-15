
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
