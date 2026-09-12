
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
     * intervalSeconds is the time to wait between polling deployment status after update. If the value is nil, a default will be used.
     */
    @JsonProperty("intervalSeconds")
    public Long getIntervalSeconds() {
        return intervalSeconds;
    }

    /**
     * intervalSeconds is the time to wait between polling deployment status after update. If the value is nil, a default will be used.
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
     * timeoutSeconds is the time to wait for updates before giving up. If the value is nil, a default will be used.
     */
    @JsonProperty("timeoutSeconds")
    public Long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * timeoutSeconds is the time to wait for updates before giving up. If the value is nil, a default will be used.
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * updatePeriodSeconds is the time to wait between individual pod updates. If the value is nil, a default will be used.
     */
    @JsonProperty("updatePeriodSeconds")
    public Long getUpdatePeriodSeconds() {
        return updatePeriodSeconds;
    }

    /**
     * updatePeriodSeconds is the time to wait between individual pod updates. If the value is nil, a default will be used.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RollingDeploymentStrategyParams)) {
            return false;
        }
        RollingDeploymentStrategyParams other = (RollingDeploymentStrategyParams) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$intervalSeconds = this.getIntervalSeconds();
        Object other$intervalSeconds = other.getIntervalSeconds();
        if (this$intervalSeconds == null ? other$intervalSeconds != null : !this$intervalSeconds.equals(other$intervalSeconds)) {
            return false;
        }
        Object this$maxSurge = this.getMaxSurge();
        Object other$maxSurge = other.getMaxSurge();
        if (this$maxSurge == null ? other$maxSurge != null : !this$maxSurge.equals(other$maxSurge)) {
            return false;
        }
        Object this$maxUnavailable = this.getMaxUnavailable();
        Object other$maxUnavailable = other.getMaxUnavailable();
        if (this$maxUnavailable == null ? other$maxUnavailable != null : !this$maxUnavailable.equals(other$maxUnavailable)) {
            return false;
        }
        Object this$post = this.getPost();
        Object other$post = other.getPost();
        if (this$post == null ? other$post != null : !this$post.equals(other$post)) {
            return false;
        }
        Object this$pre = this.getPre();
        Object other$pre = other.getPre();
        if (this$pre == null ? other$pre != null : !this$pre.equals(other$pre)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
            return false;
        }
        Object this$updatePeriodSeconds = this.getUpdatePeriodSeconds();
        Object other$updatePeriodSeconds = other.getUpdatePeriodSeconds();
        if (this$updatePeriodSeconds == null ? other$updatePeriodSeconds != null : !this$updatePeriodSeconds.equals(other$updatePeriodSeconds)) {
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
        return other instanceof RollingDeploymentStrategyParams;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $intervalSeconds = this.getIntervalSeconds();
        result = result * prime + ($intervalSeconds == null ? 43 : $intervalSeconds.hashCode());
        Object $maxSurge = this.getMaxSurge();
        result = result * prime + ($maxSurge == null ? 43 : $maxSurge.hashCode());
        Object $maxUnavailable = this.getMaxUnavailable();
        result = result * prime + ($maxUnavailable == null ? 43 : $maxUnavailable.hashCode());
        Object $post = this.getPost();
        result = result * prime + ($post == null ? 43 : $post.hashCode());
        Object $pre = this.getPre();
        result = result * prime + ($pre == null ? 43 : $pre.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $updatePeriodSeconds = this.getUpdatePeriodSeconds();
        result = result * prime + ($updatePeriodSeconds == null ? 43 : $updatePeriodSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RollingDeploymentStrategyParams(" + "intervalSeconds=" + this.getIntervalSeconds() + ", maxSurge=" + this.getMaxSurge() + ", maxUnavailable=" + this.getMaxUnavailable() + ", post=" + this.getPost() + ", pre=" + this.getPre() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", updatePeriodSeconds=" + this.getUpdatePeriodSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
