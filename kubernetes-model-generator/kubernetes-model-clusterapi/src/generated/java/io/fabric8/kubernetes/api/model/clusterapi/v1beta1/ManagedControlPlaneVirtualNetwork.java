
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * ManagedControlPlaneVirtualNetwork describes a virtual network required to provision AKS clusters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrBlock",
    "name",
    "resourceGroup",
    "subnet"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class ManagedControlPlaneVirtualNetwork implements Editable<ManagedControlPlaneVirtualNetworkBuilder>, KubernetesResource
{

    @JsonProperty("cidrBlock")
    private String cidrBlock;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subnet")
    private ManagedControlPlaneSubnet subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedControlPlaneVirtualNetwork() {
    }

    public ManagedControlPlaneVirtualNetwork(String cidrBlock, String name, String resourceGroup, ManagedControlPlaneSubnet subnet) {
        super();
        this.cidrBlock = cidrBlock;
        this.name = name;
        this.resourceGroup = resourceGroup;
        this.subnet = subnet;
    }

    /**
     * ManagedControlPlaneVirtualNetwork describes a virtual network required to provision AKS clusters.
     */
    @JsonProperty("cidrBlock")
    public String getCidrBlock() {
        return cidrBlock;
    }

    /**
     * ManagedControlPlaneVirtualNetwork describes a virtual network required to provision AKS clusters.
     */
    @JsonProperty("cidrBlock")
    public void setCidrBlock(String cidrBlock) {
        this.cidrBlock = cidrBlock;
    }

    /**
     * Name is the name of the virtual network.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the virtual network.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ResourceGroup is the name of the Azure resource group for the VNet and Subnet.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * ResourceGroup is the name of the Azure resource group for the VNet and Subnet.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * ManagedControlPlaneVirtualNetwork describes a virtual network required to provision AKS clusters.
     */
    @JsonProperty("subnet")
    public ManagedControlPlaneSubnet getSubnet() {
        return subnet;
    }

    /**
     * ManagedControlPlaneVirtualNetwork describes a virtual network required to provision AKS clusters.
     */
    @JsonProperty("subnet")
    public void setSubnet(ManagedControlPlaneSubnet subnet) {
        this.subnet = subnet;
    }

    @JsonIgnore
    public ManagedControlPlaneVirtualNetworkBuilder edit() {
        return new ManagedControlPlaneVirtualNetworkBuilder(this);
    }

    @JsonIgnore
    public ManagedControlPlaneVirtualNetworkBuilder toBuilder() {
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
