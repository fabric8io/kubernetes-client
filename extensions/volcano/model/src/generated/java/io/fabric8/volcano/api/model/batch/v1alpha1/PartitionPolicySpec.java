
package io.fabric8.volcano.api.model.batch.v1alpha1;

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

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minPartitions",
    "networkTopology",
    "partitionSize",
    "totalPartitions"
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
public class PartitionPolicySpec implements Editable<PartitionPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("minPartitions")
    private Integer minPartitions;
    @JsonProperty("networkTopology")
    private NetworkTopologySpec networkTopology;
    @JsonProperty("partitionSize")
    private Integer partitionSize;
    @JsonProperty("totalPartitions")
    private Integer totalPartitions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PartitionPolicySpec() {
    }

    public PartitionPolicySpec(Integer minPartitions, NetworkTopologySpec networkTopology, Integer partitionSize, Integer totalPartitions) {
        super();
        this.minPartitions = minPartitions;
        this.networkTopology = networkTopology;
        this.partitionSize = partitionSize;
        this.totalPartitions = totalPartitions;
    }

    /**
     * MinPartitions defines the minimum number of sub-affinity groups required.
     */
    @JsonProperty("minPartitions")
    public Integer getMinPartitions() {
        return minPartitions;
    }

    /**
     * MinPartitions defines the minimum number of sub-affinity groups required.
     */
    @JsonProperty("minPartitions")
    public void setMinPartitions(Integer minPartitions) {
        this.minPartitions = minPartitions;
    }

    @JsonProperty("networkTopology")
    public NetworkTopologySpec getNetworkTopology() {
        return networkTopology;
    }

    @JsonProperty("networkTopology")
    public void setNetworkTopology(NetworkTopologySpec networkTopology) {
        this.networkTopology = networkTopology;
    }

    /**
     * PartitionSize is the number of pods included in each group.
     */
    @JsonProperty("partitionSize")
    public Integer getPartitionSize() {
        return partitionSize;
    }

    /**
     * PartitionSize is the number of pods included in each group.
     */
    @JsonProperty("partitionSize")
    public void setPartitionSize(Integer partitionSize) {
        this.partitionSize = partitionSize;
    }

    /**
     * TotalPartitions indicates how many groups a set of pods within a task is divided into. The product of TotalPartitions and PartitionSize should be equal to Replicas.
     */
    @JsonProperty("totalPartitions")
    public Integer getTotalPartitions() {
        return totalPartitions;
    }

    /**
     * TotalPartitions indicates how many groups a set of pods within a task is divided into. The product of TotalPartitions and PartitionSize should be equal to Replicas.
     */
    @JsonProperty("totalPartitions")
    public void setTotalPartitions(Integer totalPartitions) {
        this.totalPartitions = totalPartitions;
    }

    @JsonIgnore
    public PartitionPolicySpecBuilder edit() {
        return new PartitionPolicySpecBuilder(this);
    }

    @JsonIgnore
    public PartitionPolicySpecBuilder toBuilder() {
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
