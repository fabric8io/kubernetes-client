
package io.fabric8.openshift.api.model.hive.v1;

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
import io.fabric8.openshift.api.model.hive.agent.v1.BareMetalPlatform;
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
    "agentBareMetal",
    "aws",
    "azure",
    "baremetal",
    "gcp",
    "ibmcloud",
    "openstack",
    "ovirt",
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
public class Platform implements KubernetesResource
{

    @JsonProperty("agentBareMetal")
    private BareMetalPlatform agentBareMetal;
    @JsonProperty("aws")
    private io.fabric8.openshift.api.model.hive.aws.v1.Platform aws;
    @JsonProperty("azure")
    private io.fabric8.openshift.api.model.hive.azure.v1.Platform azure;
    @JsonProperty("baremetal")
    private io.fabric8.openshift.api.model.hive.baremetal.v1.Platform baremetal;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.hive.gcp.v1.Platform gcp;
    @JsonProperty("ibmcloud")
    private io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform ibmcloud;
    @JsonProperty("openstack")
    private io.fabric8.openshift.api.model.hive.openstack.v1.Platform openstack;
    @JsonProperty("ovirt")
    private io.fabric8.openshift.api.model.hive.ovirt.v1.Platform ovirt;
    @JsonProperty("vsphere")
    private io.fabric8.openshift.api.model.hive.vsphere.v1.Platform vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(BareMetalPlatform agentBareMetal, io.fabric8.openshift.api.model.hive.aws.v1.Platform aws, io.fabric8.openshift.api.model.hive.azure.v1.Platform azure, io.fabric8.openshift.api.model.hive.baremetal.v1.Platform baremetal, io.fabric8.openshift.api.model.hive.gcp.v1.Platform gcp, io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform ibmcloud, io.fabric8.openshift.api.model.hive.openstack.v1.Platform openstack, io.fabric8.openshift.api.model.hive.ovirt.v1.Platform ovirt, io.fabric8.openshift.api.model.hive.vsphere.v1.Platform vsphere) {
        super();
        this.agentBareMetal = agentBareMetal;
        this.aws = aws;
        this.azure = azure;
        this.baremetal = baremetal;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.vsphere = vsphere;
    }

    @JsonProperty("agentBareMetal")
    public BareMetalPlatform getAgentBareMetal() {
        return agentBareMetal;
    }

    @JsonProperty("agentBareMetal")
    public void setAgentBareMetal(BareMetalPlatform agentBareMetal) {
        this.agentBareMetal = agentBareMetal;
    }

    @JsonProperty("aws")
    public io.fabric8.openshift.api.model.hive.aws.v1.Platform getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(io.fabric8.openshift.api.model.hive.aws.v1.Platform aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public io.fabric8.openshift.api.model.hive.azure.v1.Platform getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(io.fabric8.openshift.api.model.hive.azure.v1.Platform azure) {
        this.azure = azure;
    }

    @JsonProperty("baremetal")
    public io.fabric8.openshift.api.model.hive.baremetal.v1.Platform getBaremetal() {
        return baremetal;
    }

    @JsonProperty("baremetal")
    public void setBaremetal(io.fabric8.openshift.api.model.hive.baremetal.v1.Platform baremetal) {
        this.baremetal = baremetal;
    }

    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.hive.gcp.v1.Platform getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.hive.gcp.v1.Platform gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("openstack")
    public io.fabric8.openshift.api.model.hive.openstack.v1.Platform getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(io.fabric8.openshift.api.model.hive.openstack.v1.Platform openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public io.fabric8.openshift.api.model.hive.ovirt.v1.Platform getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    public void setOvirt(io.fabric8.openshift.api.model.hive.ovirt.v1.Platform ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("vsphere")
    public io.fabric8.openshift.api.model.hive.vsphere.v1.Platform getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(io.fabric8.openshift.api.model.hive.vsphere.v1.Platform vsphere) {
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
