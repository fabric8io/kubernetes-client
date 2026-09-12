
package io.fabric8.volcano.api.model.batch.v1alpha1;

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

/**
 * TaskSpec specifies the task specification of Job.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dependsOn",
    "maxRetry",
    "minAvailable",
    "name",
    "policies",
    "replicas",
    "template",
    "topologyPolicy"
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
public class TaskSpec implements Editable<TaskSpecBuilder>, KubernetesResource
{

    @JsonProperty("dependsOn")
    private DependsOn dependsOn;
    @JsonProperty("maxRetry")
    private Integer maxRetry;
    @JsonProperty("minAvailable")
    private Integer minAvailable;
    @JsonProperty("name")
    private String name;
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LifecyclePolicy> policies = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonProperty("topologyPolicy")
    private String topologyPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskSpec() {
    }

    public TaskSpec(DependsOn dependsOn, Integer maxRetry, Integer minAvailable, String name, List<LifecyclePolicy> policies, Integer replicas, PodTemplateSpec template, String topologyPolicy) {
        super();
        this.dependsOn = dependsOn;
        this.maxRetry = maxRetry;
        this.minAvailable = minAvailable;
        this.name = name;
        this.policies = policies;
        this.replicas = replicas;
        this.template = template;
        this.topologyPolicy = topologyPolicy;
    }

    /**
     * TaskSpec specifies the task specification of Job.
     */
    @JsonProperty("dependsOn")
    public DependsOn getDependsOn() {
        return dependsOn;
    }

    /**
     * TaskSpec specifies the task specification of Job.
     */
    @JsonProperty("dependsOn")
    public void setDependsOn(DependsOn dependsOn) {
        this.dependsOn = dependsOn;
    }

    /**
     * Specifies the maximum number of retries before marking this Task failed. Defaults to 3.
     */
    @JsonProperty("maxRetry")
    public Integer getMaxRetry() {
        return maxRetry;
    }

    /**
     * Specifies the maximum number of retries before marking this Task failed. Defaults to 3.
     */
    @JsonProperty("maxRetry")
    public void setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
    }

    /**
     * The minimal available pods to run for this Task Defaults to the task replicas
     */
    @JsonProperty("minAvailable")
    public Integer getMinAvailable() {
        return minAvailable;
    }

    /**
     * The minimal available pods to run for this Task Defaults to the task replicas
     */
    @JsonProperty("minAvailable")
    public void setMinAvailable(Integer minAvailable) {
        this.minAvailable = minAvailable;
    }

    /**
     * Name specifies the name of tasks
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name specifies the name of tasks
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Specifies the lifecycle of task
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LifecyclePolicy> getPolicies() {
        return policies;
    }

    /**
     * Specifies the lifecycle of task
     */
    @JsonProperty("policies")
    public void setPolicies(List<LifecyclePolicy> policies) {
        this.policies = policies;
    }

    /**
     * Replicas specifies the replicas of this TaskSpec in Job
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas specifies the replicas of this TaskSpec in Job
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * TaskSpec specifies the task specification of Job.
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * TaskSpec specifies the task specification of Job.
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    /**
     * Specifies the topology policy of task
     */
    @JsonProperty("topologyPolicy")
    public String getTopologyPolicy() {
        return topologyPolicy;
    }

    /**
     * Specifies the topology policy of task
     */
    @JsonProperty("topologyPolicy")
    public void setTopologyPolicy(String topologyPolicy) {
        this.topologyPolicy = topologyPolicy;
    }

    @JsonIgnore
    public TaskSpecBuilder edit() {
        return new TaskSpecBuilder(this);
    }

    @JsonIgnore
    public TaskSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TaskSpec)) {
            return false;
        }
        TaskSpec other = (TaskSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dependsOn = this.getDependsOn();
        Object other$dependsOn = other.getDependsOn();
        if (this$dependsOn == null ? other$dependsOn != null : !this$dependsOn.equals(other$dependsOn)) {
            return false;
        }
        Object this$maxRetry = this.getMaxRetry();
        Object other$maxRetry = other.getMaxRetry();
        if (this$maxRetry == null ? other$maxRetry != null : !this$maxRetry.equals(other$maxRetry)) {
            return false;
        }
        Object this$minAvailable = this.getMinAvailable();
        Object other$minAvailable = other.getMinAvailable();
        if (this$minAvailable == null ? other$minAvailable != null : !this$minAvailable.equals(other$minAvailable)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$policies = this.getPolicies();
        Object other$policies = other.getPolicies();
        if (this$policies == null ? other$policies != null : !this$policies.equals(other$policies)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
            return false;
        }
        Object this$topologyPolicy = this.getTopologyPolicy();
        Object other$topologyPolicy = other.getTopologyPolicy();
        if (this$topologyPolicy == null ? other$topologyPolicy != null : !this$topologyPolicy.equals(other$topologyPolicy)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof TaskSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dependsOn = this.getDependsOn();
        result = result * prime + ($dependsOn == null ? 43 : $dependsOn.hashCode());
        Object $maxRetry = this.getMaxRetry();
        result = result * prime + ($maxRetry == null ? 43 : $maxRetry.hashCode());
        Object $minAvailable = this.getMinAvailable();
        result = result * prime + ($minAvailable == null ? 43 : $minAvailable.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $policies = this.getPolicies();
        result = result * prime + ($policies == null ? 43 : $policies.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $topologyPolicy = this.getTopologyPolicy();
        result = result * prime + ($topologyPolicy == null ? 43 : $topologyPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TaskSpec(" + "dependsOn=" + this.getDependsOn() + ", maxRetry=" + this.getMaxRetry() + ", minAvailable=" + this.getMinAvailable() + ", name=" + this.getName() + ", policies=" + this.getPolicies() + ", replicas=" + this.getReplicas() + ", template=" + this.getTemplate() + ", topologyPolicy=" + this.getTopologyPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
