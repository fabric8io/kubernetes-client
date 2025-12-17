
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
 * VnetTemplateSpec defines the desired state of a virtual network.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrBlocks",
    "peerings",
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
public class VnetTemplateSpec implements Editable<VnetTemplateSpecBuilder>, KubernetesResource
{

    @JsonProperty("cidrBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cidrBlocks = new ArrayList<>();
    @JsonProperty("peerings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VnetPeeringClassSpec> peerings = new ArrayList<>();
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> tags = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VnetTemplateSpec() {
    }

    public VnetTemplateSpec(List<String> cidrBlocks, List<VnetPeeringClassSpec> peerings, Map<String, String> tags) {
        super();
        this.cidrBlocks = cidrBlocks;
        this.peerings = peerings;
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
     * Peerings defines a list of peerings of the newly created virtual network with existing virtual networks.
     */
    @JsonProperty("peerings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VnetPeeringClassSpec> getPeerings() {
        return peerings;
    }

    /**
     * Peerings defines a list of peerings of the newly created virtual network with existing virtual networks.
     */
    @JsonProperty("peerings")
    public void setPeerings(List<VnetPeeringClassSpec> peerings) {
        this.peerings = peerings;
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
    public VnetTemplateSpecBuilder edit() {
        return new VnetTemplateSpecBuilder(this);
    }

    @JsonIgnore
    public VnetTemplateSpecBuilder toBuilder() {
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
