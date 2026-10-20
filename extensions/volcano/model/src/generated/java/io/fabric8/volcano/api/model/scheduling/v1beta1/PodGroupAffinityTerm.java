
package io.fabric8.volcano.api.model.scheduling.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namespaceSelector",
    "podGroupSelector",
    "topologyTier",
    "topologyTierName",
    "weight"
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
public class PodGroupAffinityTerm implements Editable<PodGroupAffinityTermBuilder>, KubernetesResource
{

    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("podGroupSelector")
    private LabelSelector podGroupSelector;
    @JsonProperty("topologyTier")
    private Integer topologyTier;
    @JsonProperty("topologyTierName")
    private String topologyTierName;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodGroupAffinityTerm() {
    }

    public PodGroupAffinityTerm(LabelSelector namespaceSelector, LabelSelector podGroupSelector, Integer topologyTier, String topologyTierName, Integer weight) {
        super();
        this.namespaceSelector = namespaceSelector;
        this.podGroupSelector = podGroupSelector;
        this.topologyTier = topologyTier;
        this.topologyTierName = topologyTierName;
        this.weight = weight;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("podGroupSelector")
    public LabelSelector getPodGroupSelector() {
        return podGroupSelector;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("podGroupSelector")
    public void setPodGroupSelector(LabelSelector podGroupSelector) {
        this.podGroupSelector = podGroupSelector;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("topologyTier")
    public Integer getTopologyTier() {
        return topologyTier;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("topologyTier")
    public void setTopologyTier(Integer topologyTier) {
        this.topologyTier = topologyTier;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("topologyTierName")
    public String getTopologyTierName() {
        return topologyTierName;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("topologyTierName")
    public void setTopologyTierName(String topologyTierName) {
        this.topologyTierName = topologyTierName;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * PodGroupAffinityTerm selects matching PodGroups and the topology tier for HyperNode comparison.
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public PodGroupAffinityTermBuilder edit() {
        return new PodGroupAffinityTermBuilder(this);
    }

    @JsonIgnore
    public PodGroupAffinityTermBuilder toBuilder() {
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
