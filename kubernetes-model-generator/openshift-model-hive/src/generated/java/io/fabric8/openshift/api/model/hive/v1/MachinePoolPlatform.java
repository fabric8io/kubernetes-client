
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
public class MachinePoolPlatform implements KubernetesResource
{

    @JsonProperty("aws")
    private io.fabric8.openshift.api.model.hive.aws.v1.MachinePoolPlatform aws;
    @JsonProperty("azure")
    private io.fabric8.openshift.api.model.hive.azure.v1.MachinePool azure;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.hive.gcp.v1.MachinePool gcp;
    @JsonProperty("ibmcloud")
    private io.fabric8.openshift.api.model.hive.ibmcloud.v1.MachinePool ibmcloud;
    @JsonProperty("openstack")
    private io.fabric8.openshift.api.model.hive.openstack.v1.MachinePool openstack;
    @JsonProperty("ovirt")
    private io.fabric8.openshift.api.model.hive.ovirt.v1.MachinePool ovirt;
    @JsonProperty("vsphere")
    private io.fabric8.openshift.api.model.hive.vsphere.v1.MachinePool vsphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePoolPlatform() {
    }

    public MachinePoolPlatform(io.fabric8.openshift.api.model.hive.aws.v1.MachinePoolPlatform aws, io.fabric8.openshift.api.model.hive.azure.v1.MachinePool azure, io.fabric8.openshift.api.model.hive.gcp.v1.MachinePool gcp, io.fabric8.openshift.api.model.hive.ibmcloud.v1.MachinePool ibmcloud, io.fabric8.openshift.api.model.hive.openstack.v1.MachinePool openstack, io.fabric8.openshift.api.model.hive.ovirt.v1.MachinePool ovirt, io.fabric8.openshift.api.model.hive.vsphere.v1.MachinePool vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.openstack = openstack;
        this.ovirt = ovirt;
        this.vsphere = vsphere;
    }

    @JsonProperty("aws")
    public io.fabric8.openshift.api.model.hive.aws.v1.MachinePoolPlatform getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(io.fabric8.openshift.api.model.hive.aws.v1.MachinePoolPlatform aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public io.fabric8.openshift.api.model.hive.azure.v1.MachinePool getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(io.fabric8.openshift.api.model.hive.azure.v1.MachinePool azure) {
        this.azure = azure;
    }

    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.hive.gcp.v1.MachinePool getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.hive.gcp.v1.MachinePool gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public io.fabric8.openshift.api.model.hive.ibmcloud.v1.MachinePool getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(io.fabric8.openshift.api.model.hive.ibmcloud.v1.MachinePool ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("openstack")
    public io.fabric8.openshift.api.model.hive.openstack.v1.MachinePool getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(io.fabric8.openshift.api.model.hive.openstack.v1.MachinePool openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("ovirt")
    public io.fabric8.openshift.api.model.hive.ovirt.v1.MachinePool getOvirt() {
        return ovirt;
    }

    @JsonProperty("ovirt")
    public void setOvirt(io.fabric8.openshift.api.model.hive.ovirt.v1.MachinePool ovirt) {
        this.ovirt = ovirt;
    }

    @JsonProperty("vsphere")
    public io.fabric8.openshift.api.model.hive.vsphere.v1.MachinePool getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(io.fabric8.openshift.api.model.hive.vsphere.v1.MachinePool vsphere) {
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
