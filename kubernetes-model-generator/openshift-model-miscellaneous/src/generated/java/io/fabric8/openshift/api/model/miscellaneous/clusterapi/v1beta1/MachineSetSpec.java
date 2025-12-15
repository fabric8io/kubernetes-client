
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * MachineSetSpec defines the desired state of MachineSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterName",
    "deletePolicy",
    "machineNamingStrategy",
    "minReadySeconds",
    "replicas",
    "selector",
    "template"
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
public class MachineSetSpec implements Editable<MachineSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("deletePolicy")
    private String deletePolicy;
    @JsonProperty("machineNamingStrategy")
    private MachineNamingStrategy machineNamingStrategy;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("template")
    private MachineTemplateSpec template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSetSpec() {
    }

    public MachineSetSpec(String clusterName, String deletePolicy, MachineNamingStrategy machineNamingStrategy, Integer minReadySeconds, Integer replicas, LabelSelector selector, MachineTemplateSpec template) {
        super();
        this.clusterName = clusterName;
        this.deletePolicy = deletePolicy;
        this.machineNamingStrategy = machineNamingStrategy;
        this.minReadySeconds = minReadySeconds;
        this.replicas = replicas;
        this.selector = selector;
        this.template = template;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * deletePolicy defines the policy used to identify nodes to delete when downscaling. Defaults to "Random".  Valid values are "Random, "Newest", "Oldest"
     */
    @JsonProperty("deletePolicy")
    public String getDeletePolicy() {
        return deletePolicy;
    }

    /**
     * deletePolicy defines the policy used to identify nodes to delete when downscaling. Defaults to "Random".  Valid values are "Random, "Newest", "Oldest"
     */
    @JsonProperty("deletePolicy")
    public void setDeletePolicy(String deletePolicy) {
        this.deletePolicy = deletePolicy;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet.
     */
    @JsonProperty("machineNamingStrategy")
    public MachineNamingStrategy getMachineNamingStrategy() {
        return machineNamingStrategy;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet.
     */
    @JsonProperty("machineNamingStrategy")
    public void setMachineNamingStrategy(MachineNamingStrategy machineNamingStrategy) {
        this.machineNamingStrategy = machineNamingStrategy;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a Node for a newly created machine should be ready before considering the replica available. Defaults to 0 (machine will be considered available as soon as the Node is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * minReadySeconds is the minimum number of seconds for which a Node for a newly created machine should be ready before considering the replica available. Defaults to 0 (machine will be considered available as soon as the Node is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * replicas is the number of desired replicas. This is a pointer to distinguish between explicit zero and unspecified.<br><p> <br><p> Defaults to: &#42; if the Kubernetes autoscaler min size and max size annotations are set:<br><p>   - if it's a new MachineSet, use min size<br><p>   - if the replicas field of the old MachineSet is &lt; min size, use min size<br><p>   - if the replicas field of the old MachineSet is &gt; max size, use max size<br><p>   - if the replicas field of the old MachineSet is in the (min size, max size) range, keep the value from the oldMS<br><p> &#42; otherwise use 1 Note: Defaulting will be run whenever the replicas field is not set: &#42; A new MachineSet is created with replicas not set. &#42; On an existing MachineSet the replicas field was first set and is now unset. Those cases are especially relevant for the following Kubernetes autoscaler use cases: &#42; A new MachineSet is created and replicas should be managed by the autoscaler &#42; An existing MachineSet which initially wasn't controlled by the autoscaler<br><p>   should be later controlled by the autoscaler
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the number of desired replicas. This is a pointer to distinguish between explicit zero and unspecified.<br><p> <br><p> Defaults to: &#42; if the Kubernetes autoscaler min size and max size annotations are set:<br><p>   - if it's a new MachineSet, use min size<br><p>   - if the replicas field of the old MachineSet is &lt; min size, use min size<br><p>   - if the replicas field of the old MachineSet is &gt; max size, use max size<br><p>   - if the replicas field of the old MachineSet is in the (min size, max size) range, keep the value from the oldMS<br><p> &#42; otherwise use 1 Note: Defaulting will be run whenever the replicas field is not set: &#42; A new MachineSet is created with replicas not set. &#42; On an existing MachineSet the replicas field was first set and is now unset. Those cases are especially relevant for the following Kubernetes autoscaler use cases: &#42; A new MachineSet is created and replicas should be managed by the autoscaler &#42; An existing MachineSet which initially wasn't controlled by the autoscaler<br><p>   should be later controlled by the autoscaler
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet.
     */
    @JsonProperty("template")
    public MachineTemplateSpec getTemplate() {
        return template;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet.
     */
    @JsonProperty("template")
    public void setTemplate(MachineTemplateSpec template) {
        this.template = template;
    }

    @JsonIgnore
    public MachineSetSpecBuilder edit() {
        return new MachineSetSpecBuilder(this);
    }

    @JsonIgnore
    public MachineSetSpecBuilder toBuilder() {
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
