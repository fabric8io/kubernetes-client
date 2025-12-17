
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * VnetSpec configures an Azure virtual network.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrBlocks",
    "id",
    "name",
    "peerings",
    "resourceGroup",
    "tags"
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
public class VnetSpec implements Editable<VnetSpecBuilder>, KubernetesResource
{

    @JsonProperty("cidrBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cidrBlocks = new ArrayList<>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("peerings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VnetPeeringSpec> peerings = new ArrayList<>();
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> tags = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VnetSpec() {
    }

    public VnetSpec(List<String> cidrBlocks, String id, String name, List<VnetPeeringSpec> peerings, String resourceGroup, Map<String, String> tags) {
        super();
        this.cidrBlocks = cidrBlocks;
        this.id = id;
        this.name = name;
        this.peerings = peerings;
        this.resourceGroup = resourceGroup;
        this.tags = tags;
    }

    /**
     * CIDRBlocks defines the virtual network's address space, specified as one or more address prefixes in CIDR notation.
     */
    @JsonProperty("cidrBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCidrBlocks() {
        return cidrBlocks;
    }

    /**
     * CIDRBlocks defines the virtual network's address space, specified as one or more address prefixes in CIDR notation.
     */
    @JsonProperty("cidrBlocks")
    public void setCidrBlocks(List<String> cidrBlocks) {
        this.cidrBlocks = cidrBlocks;
    }

    /**
     * ID is the Azure resource ID of the virtual network. READ-ONLY
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID is the Azure resource ID of the virtual network. READ-ONLY
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name defines a name for the virtual network resource.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name defines a name for the virtual network resource.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Peerings defines a list of peerings of the newly created virtual network with existing virtual networks.
     */
    @JsonProperty("peerings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VnetPeeringSpec> getPeerings() {
        return peerings;
    }

    /**
     * Peerings defines a list of peerings of the newly created virtual network with existing virtual networks.
     */
    @JsonProperty("peerings")
    public void setPeerings(List<VnetPeeringSpec> peerings) {
        this.peerings = peerings;
    }

    /**
     * ResourceGroup is the name of the resource group of the existing virtual network or the resource group where a managed virtual network should be created.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * ResourceGroup is the name of the resource group of the existing virtual network or the resource group where a managed virtual network should be created.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * Tags is a collection of tags describing the resource.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getTags() {
        return tags;
    }

    /**
     * Tags is a collection of tags describing the resource.
     */
    @JsonProperty("tags")
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public VnetSpecBuilder edit() {
        return new VnetSpecBuilder(this);
    }

    @JsonIgnore
    public VnetSpecBuilder toBuilder() {
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
