
package io.fabric8.openshift.api.model.installer.v1;

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
import io.fabric8.openshift.api.model.config.v1.CustomFeatureGates;
import io.fabric8.openshift.api.model.installer.aws.v1.Metadata;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "baremetal",
    "clusterID",
    "clusterName",
    "customFeatureSet",
    "featureSet",
    "gcp",
    "ibmcloud",
    "infraID",
    "nutanix",
    "openstack",
    "ovirt",
    "powervs",
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
public class ClusterMetadata implements Editable<ClusterMetadataBuilder> , KubernetesResource
{

    @JsonProperty("aws")
    private Metadata aws;
    @JsonProperty("azure")
    private io.fabric8.openshift.api.model.installer.azure.v1.Metadata azure;
    @JsonProperty("baremetal")
    private io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata baremetal;
    @JsonProperty("clusterID")
    private String clusterID;
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("customFeatureSet")
    private CustomFeatureGates customFeatureSet;
    @JsonProperty("featureSet")
    private String featureSet;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.installer.gcp.v1.Metadata gcp;
    @JsonProperty("ibmcloud")
    private io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata ibmcloud;
    @JsonProperty("infraID")
    private String infraID;
    @JsonProperty("nutanix")
    private io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata nutanix;
    @JsonProperty("openstack")
    private io.fabric8.openshift.api.model.installer.openstack.v1.Metadata openstack;
    @JsonProperty("ovirt")
    private io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata ovirt;
    @JsonProperty("powervs")
    private io.fabric8.openshift.api.model.installer.powervs.v1.Metadata powervs;
    @JsonProperty("vsphere")
    private io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterMetadata() {
    }

    public ClusterMetadata(Metadata aws, io.fabric8.openshift.api.model.installer.azure.v1.Metadata azure, io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata baremetal, String clusterID, String clusterName, CustomFeatureGates customFeatureSet, String featureSet, io.fabric8.openshift.api.model.installer.gcp.v1.Metadata gcp, io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata ibmcloud, String infraID, io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata nutanix, io.fabric8.openshift.api.model.installer.openstack.v1.Metadata openstack, io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata ovirt, io.fabric8.openshift.api.model.installer.powervs.v1.Metadata powervs, io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.clusterID = clusterID;
        this.clusterName = clusterName;
        this.customFeatureSet = customFeatureSet;
        this.featureSet = featureSet;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.infraID = infraID;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.powervs = powervs;
        this.vsphere = vsphere;
    }

    @JsonProperty("aws")
    public Metadata getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(Metadata aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public io.fabric8.openshift.api.model.installer.azure.v1.Metadata getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(io.fabric8.openshift.api.model.installer.azure.v1.Metadata azure) {
        this.azure = azure;
    }

    @JsonProperty("baremetal")
    public io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata getBaremetal() {
        return baremetal;
    }

    @JsonProperty("baremetal")
    public void setBaremetal(io.fabric8.openshift.api.model.installer.baremetal.v1.Metadata baremetal) {
        this.baremetal = baremetal;
    }

    @JsonProperty("clusterID")
    public String getClusterID() {
        return clusterID;
    }

    @JsonProperty("clusterID")
    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @JsonProperty("customFeatureSet")
    public CustomFeatureGates getCustomFeatureSet() {
        return customFeatureSet;
    }

    @JsonProperty("customFeatureSet")
    public void setCustomFeatureSet(CustomFeatureGates customFeatureSet) {
        this.customFeatureSet = customFeatureSet;
    }

    @JsonProperty("featureSet")
    public String getFeatureSet() {
        return featureSet;
    }

    @JsonProperty("featureSet")
    public void setFeatureSet(String featureSet) {
        this.featureSet = featureSet;
    }

    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.installer.gcp.v1.Metadata getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.installer.gcp.v1.Metadata gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Metadata ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("infraID")
    public String getInfraID() {
        return infraID;
    }

    @JsonProperty("infraID")
    public void setInfraID(String infraID) {
        this.infraID = infraID;
    }

    @JsonProperty("nutanix")
    public io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata getNutanix() {
        return nutanix;
    }

    @JsonProperty("nutanix")
    public void setNutanix(io.fabric8.openshift.api.model.installer.nutanix.v1.Metadata nutanix) {
        this.nutanix = nutanix;
    }

    @JsonProperty("openstack")
    public io.fabric8.openshift.api.model.installer.openstack.v1.Metadata getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(io.fabric8.openshift.api.model.installer.openstack.v1.Metadata openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    public void setOvirt(io.fabric8.openshift.api.model.installer.ovirt.v1.Metadata ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("powervs")
    public io.fabric8.openshift.api.model.installer.powervs.v1.Metadata getPowervs() {
        return powervs;
    }

    @JsonProperty("powervs")
    public void setPowervs(io.fabric8.openshift.api.model.installer.powervs.v1.Metadata powervs) {
        this.powervs = powervs;
    }

    @JsonProperty("vsphere")
    public io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(io.fabric8.openshift.api.model.installer.vsphere.v1.Metadata vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public ClusterMetadataBuilder edit() {
        return new ClusterMetadataBuilder(this);
    }

    @JsonIgnore
    public ClusterMetadataBuilder toBuilder() {
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
