
package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.Duration;
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
 * Timeout to consider while applying the workload.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxFailures",
    "minSuccessTime",
    "progressDeadline"
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
public class RolloutConfig implements Editable<RolloutConfigBuilder>, KubernetesResource
{

    @JsonProperty("maxFailures")
    private IntOrString maxFailures;
    @JsonProperty("minSuccessTime")
    private Duration minSuccessTime;
    @JsonProperty("progressDeadline")
    private String progressDeadline;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RolloutConfig() {
    }

    public RolloutConfig(IntOrString maxFailures, Duration minSuccessTime, String progressDeadline) {
        super();
        this.maxFailures = maxFailures;
        this.minSuccessTime = minSuccessTime;
        this.progressDeadline = progressDeadline;
    }

    /**
     * Timeout to consider while applying the workload.
     */
    @JsonProperty("maxFailures")
    public IntOrString getMaxFailures() {
        return maxFailures;
    }

    /**
     * Timeout to consider while applying the workload.
     */
    @JsonProperty("maxFailures")
    public void setMaxFailures(IntOrString maxFailures) {
        this.maxFailures = maxFailures;
    }

    /**
     * Timeout to consider while applying the workload.
     */
    @JsonProperty("minSuccessTime")
    public Duration getMinSuccessTime() {
        return minSuccessTime;
    }

    /**
     * Timeout to consider while applying the workload.
     */
    @JsonProperty("minSuccessTime")
    public void setMinSuccessTime(Duration minSuccessTime) {
        this.minSuccessTime = minSuccessTime;
    }

    /**
     * ProgressDeadline defines how long workload applier controller will wait for the workload to reach a successful state in the cluster. If the workload does not reach a successful state after ProgressDeadline, will stop waiting and workload will be treated as "timeout" and be counted into MaxFailures. Once the MaxFailures is breached, the rollout will stop. ProgressDeadline default value is "None", meaning the workload applier will wait for a successful state indefinitely. ProgressDeadline must be defined in [0-9h]|[0-9m]|[0-9s] format examples; 2h , 90m , 360s
     */
    @JsonProperty("progressDeadline")
    public String getProgressDeadline() {
        return progressDeadline;
    }

    /**
     * ProgressDeadline defines how long workload applier controller will wait for the workload to reach a successful state in the cluster. If the workload does not reach a successful state after ProgressDeadline, will stop waiting and workload will be treated as "timeout" and be counted into MaxFailures. Once the MaxFailures is breached, the rollout will stop. ProgressDeadline default value is "None", meaning the workload applier will wait for a successful state indefinitely. ProgressDeadline must be defined in [0-9h]|[0-9m]|[0-9s] format examples; 2h , 90m , 360s
     */
    @JsonProperty("progressDeadline")
    public void setProgressDeadline(String progressDeadline) {
        this.progressDeadline = progressDeadline;
    }

    @JsonIgnore
    public RolloutConfigBuilder edit() {
        return new RolloutConfigBuilder(this);
    }

    @JsonIgnore
    public RolloutConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
