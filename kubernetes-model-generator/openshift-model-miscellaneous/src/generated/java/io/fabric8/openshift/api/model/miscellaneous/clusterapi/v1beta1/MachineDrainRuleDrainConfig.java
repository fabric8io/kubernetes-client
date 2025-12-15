
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
 * MachineDrainRuleDrainConfig configures if and how Pods are drained.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "behavior",
    "order"
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
public class MachineDrainRuleDrainConfig implements Editable<MachineDrainRuleDrainConfigBuilder>, KubernetesResource
{

    @JsonProperty("behavior")
    private String behavior;
    @JsonProperty("order")
    private Integer order;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDrainRuleDrainConfig() {
    }

    public MachineDrainRuleDrainConfig(String behavior, Integer order) {
        super();
        this.behavior = behavior;
        this.order = order;
    }

    /**
     * behavior defines the drain behavior. Can be either "Drain", "Skip", or "WaitCompleted". "Drain" means that the Pods to which this MachineDrainRule applies will be drained. If behavior is set to "Drain" the order in which Pods are drained can be configured with the order field. When draining Pods of a Node the Pods will be grouped by order and one group after another will be drained (by increasing order). Cluster API will wait until all Pods of a group are terminated / removed from the Node before starting with the next group. "Skip" means that the Pods to which this MachineDrainRule applies will be skipped during drain. "WaitCompleted" means that the pods to which this MachineDrainRule applies will never be evicted and we wait for them to be completed, it is enforced that pods marked with this behavior always have Order=0.
     */
    @JsonProperty("behavior")
    public String getBehavior() {
        return behavior;
    }

    /**
     * behavior defines the drain behavior. Can be either "Drain", "Skip", or "WaitCompleted". "Drain" means that the Pods to which this MachineDrainRule applies will be drained. If behavior is set to "Drain" the order in which Pods are drained can be configured with the order field. When draining Pods of a Node the Pods will be grouped by order and one group after another will be drained (by increasing order). Cluster API will wait until all Pods of a group are terminated / removed from the Node before starting with the next group. "Skip" means that the Pods to which this MachineDrainRule applies will be skipped during drain. "WaitCompleted" means that the pods to which this MachineDrainRule applies will never be evicted and we wait for them to be completed, it is enforced that pods marked with this behavior always have Order=0.
     */
    @JsonProperty("behavior")
    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    /**
     * order defines the order in which Pods are drained. Pods with higher order are drained after Pods with lower order. order can only be set if behavior is set to "Drain". If order is not set, 0 will be used. Valid values for order are from -2147483648 to 2147483647 (inclusive).
     */
    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    /**
     * order defines the order in which Pods are drained. Pods with higher order are drained after Pods with lower order. order can only be set if behavior is set to "Drain". If order is not set, 0 will be used. Valid values for order are from -2147483648 to 2147483647 (inclusive).
     */
    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonIgnore
    public MachineDrainRuleDrainConfigBuilder edit() {
        return new MachineDrainRuleDrainConfigBuilder(this);
    }

    @JsonIgnore
    public MachineDrainRuleDrainConfigBuilder toBuilder() {
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
