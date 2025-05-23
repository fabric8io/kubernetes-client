
package io.fabric8.kubernetes.api.model.ovn.v1;

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
 * UserDefinedNetworkSpec defines the desired state of UserDefinedNetworkSpec.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "layer2",
    "layer3",
    "topology"
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
public class UserDefinedNetworkSpec implements Editable<UserDefinedNetworkSpecBuilder>, KubernetesResource
{

    @JsonProperty("layer2")
    private Layer2Config layer2;
    @JsonProperty("layer3")
    private Layer3Config layer3;
    @JsonProperty("topology")
    private String topology;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UserDefinedNetworkSpec() {
    }

    public UserDefinedNetworkSpec(Layer2Config layer2, Layer3Config layer3, String topology) {
        super();
        this.layer2 = layer2;
        this.layer3 = layer3;
        this.topology = topology;
    }

    /**
     * UserDefinedNetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer2")
    public Layer2Config getLayer2() {
        return layer2;
    }

    /**
     * UserDefinedNetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer2")
    public void setLayer2(Layer2Config layer2) {
        this.layer2 = layer2;
    }

    /**
     * UserDefinedNetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer3")
    public Layer3Config getLayer3() {
        return layer3;
    }

    /**
     * UserDefinedNetworkSpec defines the desired state of UserDefinedNetworkSpec.
     */
    @JsonProperty("layer3")
    public void setLayer3(Layer3Config layer3) {
        this.layer3 = layer3;
    }

    /**
     * Topology describes network configuration.<br><p> <br><p> Allowed values are "Layer3", "Layer2". Layer3 topology creates a layer 2 segment per node, each with a different subnet. Layer 3 routing is used to interconnect node subnets. Layer2 topology creates one logical switch shared by all nodes.
     */
    @JsonProperty("topology")
    public String getTopology() {
        return topology;
    }

    /**
     * Topology describes network configuration.<br><p> <br><p> Allowed values are "Layer3", "Layer2". Layer3 topology creates a layer 2 segment per node, each with a different subnet. Layer 3 routing is used to interconnect node subnets. Layer2 topology creates one logical switch shared by all nodes.
     */
    @JsonProperty("topology")
    public void setTopology(String topology) {
        this.topology = topology;
    }

    @JsonIgnore
    public UserDefinedNetworkSpecBuilder edit() {
        return new UserDefinedNetworkSpecBuilder(this);
    }

    @JsonIgnore
    public UserDefinedNetworkSpecBuilder toBuilder() {
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
