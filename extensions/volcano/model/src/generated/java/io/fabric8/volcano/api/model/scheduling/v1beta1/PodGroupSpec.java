
package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
import io.fabric8.kubernetes.api.model.Quantity;
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
 * PodGroupSpec represents the template of a pod group.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minMember",
    "minResources",
    "minTaskMember",
    "networkTopology",
    "priorityClassName",
    "queue",
    "subGroupPolicy"
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
public class PodGroupSpec implements Editable<PodGroupSpecBuilder>, KubernetesResource
{

    @JsonProperty("minMember")
    private Integer minMember;
    @JsonProperty("minResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> minResources = new LinkedHashMap<>();
    @JsonProperty("minTaskMember")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Integer> minTaskMember = new LinkedHashMap<>();
    @JsonProperty("networkTopology")
    private NetworkTopologySpec networkTopology;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("queue")
    private String queue;
    @JsonProperty("subGroupPolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubGroupPolicySpec> subGroupPolicy = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodGroupSpec() {
    }

    public PodGroupSpec(Integer minMember, Map<String, Quantity> minResources, Map<String, Integer> minTaskMember, NetworkTopologySpec networkTopology, String priorityClassName, String queue, List<SubGroupPolicySpec> subGroupPolicy) {
        super();
        this.minMember = minMember;
        this.minResources = minResources;
        this.minTaskMember = minTaskMember;
        this.networkTopology = networkTopology;
        this.priorityClassName = priorityClassName;
        this.queue = queue;
        this.subGroupPolicy = subGroupPolicy;
    }

    /**
     * MinMember defines the minimal number of members/tasks to run the pod group; if there's not enough resources to start all tasks, the scheduler will not start anyone.
     */
    @JsonProperty("minMember")
    public Integer getMinMember() {
        return minMember;
    }

    /**
     * MinMember defines the minimal number of members/tasks to run the pod group; if there's not enough resources to start all tasks, the scheduler will not start anyone.
     */
    @JsonProperty("minMember")
    public void setMinMember(Integer minMember) {
        this.minMember = minMember;
    }

    /**
     * MinResources defines the minimal resource of members/tasks to run the pod group; if there's not enough resources to start all tasks, the scheduler will not start anyone.
     */
    @JsonProperty("minResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMinResources() {
        return minResources;
    }

    /**
     * MinResources defines the minimal resource of members/tasks to run the pod group; if there's not enough resources to start all tasks, the scheduler will not start anyone.
     */
    @JsonProperty("minResources")
    public void setMinResources(Map<String, Quantity> minResources) {
        this.minResources = minResources;
    }

    /**
     * MinTaskMember defines the minimal number of pods to run for each task in the pod group; if there's not enough resources to start each task, the scheduler will not start anyone. SubGroupPolicy covers all capabilities of minTaskMember, while providing richer network topology and Gang scheduling management capabilities. Recommend using SubGroupPolicy to uniformly manage Gang scheduling for each Task group.
     */
    @JsonProperty("minTaskMember")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Integer> getMinTaskMember() {
        return minTaskMember;
    }

    /**
     * MinTaskMember defines the minimal number of pods to run for each task in the pod group; if there's not enough resources to start each task, the scheduler will not start anyone. SubGroupPolicy covers all capabilities of minTaskMember, while providing richer network topology and Gang scheduling management capabilities. Recommend using SubGroupPolicy to uniformly manage Gang scheduling for each Task group.
     */
    @JsonProperty("minTaskMember")
    public void setMinTaskMember(Map<String, Integer> minTaskMember) {
        this.minTaskMember = minTaskMember;
    }

    /**
     * PodGroupSpec represents the template of a pod group.
     */
    @JsonProperty("networkTopology")
    public NetworkTopologySpec getNetworkTopology() {
        return networkTopology;
    }

    /**
     * PodGroupSpec represents the template of a pod group.
     */
    @JsonProperty("networkTopology")
    public void setNetworkTopology(NetworkTopologySpec networkTopology) {
        this.networkTopology = networkTopology;
    }

    /**
     * If specified, indicates the PodGroup's priority. "system-node-critical" and "system-cluster-critical" are two special keywords which indicate the highest priorities with the former being the highest priority. Any other name must be defined by creating a PriorityClass object with that name. If not specified, the PodGroup priority will be default or zero if there is no default.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * If specified, indicates the PodGroup's priority. "system-node-critical" and "system-cluster-critical" are two special keywords which indicate the highest priorities with the former being the highest priority. Any other name must be defined by creating a PriorityClass object with that name. If not specified, the PodGroup priority will be default or zero if there is no default.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * Queue defines the queue to allocate resource for PodGroup; if queue does not exist, the PodGroup will not be scheduled. Defaults to `default` Queue with the lowest weight.
     */
    @JsonProperty("queue")
    public String getQueue() {
        return queue;
    }

    /**
     * Queue defines the queue to allocate resource for PodGroup; if queue does not exist, the PodGroup will not be scheduled. Defaults to `default` Queue with the lowest weight.
     */
    @JsonProperty("queue")
    public void setQueue(String queue) {
        this.queue = queue;
    }

    /**
     * Compared with minTaskMember, it offers more comprehensive topology scheduling and Gang scheduling management capabilities. Concurrent use with minTaskMember is not recommended, and SubGroupPolicy is the long-term evolution direction.
     */
    @JsonProperty("subGroupPolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubGroupPolicySpec> getSubGroupPolicy() {
        return subGroupPolicy;
    }

    /**
     * Compared with minTaskMember, it offers more comprehensive topology scheduling and Gang scheduling management capabilities. Concurrent use with minTaskMember is not recommended, and SubGroupPolicy is the long-term evolution direction.
     */
    @JsonProperty("subGroupPolicy")
    public void setSubGroupPolicy(List<SubGroupPolicySpec> subGroupPolicy) {
        this.subGroupPolicy = subGroupPolicy;
    }

    @JsonIgnore
    public PodGroupSpecBuilder edit() {
        return new PodGroupSpecBuilder(this);
    }

    @JsonIgnore
    public PodGroupSpecBuilder toBuilder() {
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
