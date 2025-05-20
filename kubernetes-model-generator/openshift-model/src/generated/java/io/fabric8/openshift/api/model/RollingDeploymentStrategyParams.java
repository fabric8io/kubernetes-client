
package io.fabric8.openshift.api.model;

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
 * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "intervalSeconds",
    "maxSurge",
    "maxUnavailable",
    "post",
    "pre",
    "timeoutSeconds",
    "updatePeriodSeconds"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RollingDeploymentStrategyParams implements Editable<RollingDeploymentStrategyParamsBuilder>, KubernetesResource
{

    @JsonProperty("intervalSeconds")
    private Long intervalSeconds;
    @JsonProperty("maxSurge")
    private IntOrString maxSurge;
    @JsonProperty("maxUnavailable")
    private IntOrString maxUnavailable;
    @JsonProperty("post")
    private LifecycleHook post;
    @JsonProperty("pre")
    private LifecycleHook pre;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("updatePeriodSeconds")
    private Long updatePeriodSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RollingDeploymentStrategyParams() {
    }

    public RollingDeploymentStrategyParams(Long intervalSeconds, IntOrString maxSurge, IntOrString maxUnavailable, LifecycleHook post, LifecycleHook pre, Long timeoutSeconds, Long updatePeriodSeconds) {
        super();
        this.intervalSeconds = intervalSeconds;
        this.maxSurge = maxSurge;
        this.maxUnavailable = maxUnavailable;
        this.post = post;
        this.pre = pre;
        this.timeoutSeconds = timeoutSeconds;
        this.updatePeriodSeconds = updatePeriodSeconds;
    }

    /**
     * IntervalSeconds is the time to wait between polling deployment status after update. If the value is nil, a default will be used.
     */
    @JsonProperty("intervalSeconds")
    public Long getIntervalSeconds() {
        return intervalSeconds;
    }

    /**
     * IntervalSeconds is the time to wait between polling deployment status after update. If the value is nil, a default will be used.
     */
    @JsonProperty("intervalSeconds")
    public void setIntervalSeconds(Long intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("maxSurge")
    public IntOrString getMaxSurge() {
        return maxSurge;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("maxSurge")
    public void setMaxSurge(IntOrString maxSurge) {
        this.maxSurge = maxSurge;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("maxUnavailable")
    public IntOrString getMaxUnavailable() {
        return maxUnavailable;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(IntOrString maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("post")
    public LifecycleHook getPost() {
        return post;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("post")
    public void setPost(LifecycleHook post) {
        this.post = post;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("pre")
    public LifecycleHook getPre() {
        return pre;
    }

    /**
     * RollingDeploymentStrategyParams are the input to the Rolling deployment strategy.
     */
    @JsonProperty("pre")
    public void setPre(LifecycleHook pre) {
        this.pre = pre;
    }

    /**
     * TimeoutSeconds is the time to wait for updates before giving up. If the value is nil, a default will be used.
     */
    @JsonProperty("timeoutSeconds")
    public Long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * TimeoutSeconds is the time to wait for updates before giving up. If the value is nil, a default will be used.
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * UpdatePeriodSeconds is the time to wait between individual pod updates. If the value is nil, a default will be used.
     */
    @JsonProperty("updatePeriodSeconds")
    public Long getUpdatePeriodSeconds() {
        return updatePeriodSeconds;
    }

    /**
     * UpdatePeriodSeconds is the time to wait between individual pod updates. If the value is nil, a default will be used.
     */
    @JsonProperty("updatePeriodSeconds")
    public void setUpdatePeriodSeconds(Long updatePeriodSeconds) {
        this.updatePeriodSeconds = updatePeriodSeconds;
    }

    @JsonIgnore
    public RollingDeploymentStrategyParamsBuilder edit() {
        return new RollingDeploymentStrategyParamsBuilder(this);
    }

    @JsonIgnore
    public RollingDeploymentStrategyParamsBuilder toBuilder() {
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
