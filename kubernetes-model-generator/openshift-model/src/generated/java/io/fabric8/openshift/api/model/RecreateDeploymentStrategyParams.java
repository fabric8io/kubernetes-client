
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
 * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mid",
    "post",
    "pre",
    "timeoutSeconds"
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
public class RecreateDeploymentStrategyParams implements Editable<RecreateDeploymentStrategyParamsBuilder>, KubernetesResource
{

    @JsonProperty("mid")
    private LifecycleHook mid;
    @JsonProperty("post")
    private LifecycleHook post;
    @JsonProperty("pre")
    private LifecycleHook pre;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RecreateDeploymentStrategyParams() {
    }

    public RecreateDeploymentStrategyParams(LifecycleHook mid, LifecycleHook post, LifecycleHook pre, Long timeoutSeconds) {
        super();
        this.mid = mid;
        this.post = post;
        this.pre = pre;
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
     */
    @JsonProperty("mid")
    public LifecycleHook getMid() {
        return mid;
    }

    /**
     * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
     */
    @JsonProperty("mid")
    public void setMid(LifecycleHook mid) {
        this.mid = mid;
    }

    /**
     * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
     */
    @JsonProperty("post")
    public LifecycleHook getPost() {
        return post;
    }

    /**
     * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
     */
    @JsonProperty("post")
    public void setPost(LifecycleHook post) {
        this.post = post;
    }

    /**
     * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
     */
    @JsonProperty("pre")
    public LifecycleHook getPre() {
        return pre;
    }

    /**
     * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
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

    @JsonIgnore
    public RecreateDeploymentStrategyParamsBuilder edit() {
        return new RecreateDeploymentStrategyParamsBuilder(this);
    }

    @JsonIgnore
    public RecreateDeploymentStrategyParamsBuilder toBuilder() {
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
        if (!(o instanceof RecreateDeploymentStrategyParams)) {
            return false;
        }
        RecreateDeploymentStrategyParams other = (RecreateDeploymentStrategyParams) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mid = this.getMid();
        Object other$mid = other.getMid();
        if (this$mid == null ? other$mid != null : !this$mid.equals(other$mid)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RecreateDeploymentStrategyParams;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mid = this.getMid();
        result = result * prime + ($mid == null ? 43 : $mid.hashCode());
        Object $post = this.getPost();
        result = result * prime + ($post == null ? 43 : $post.hashCode());
        Object $pre = this.getPre();
        result = result * prime + ($pre == null ? 43 : $pre.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RecreateDeploymentStrategyParams(" + "mid=" + this.getMid() + ", post=" + this.getPost() + ", pre=" + this.getPre() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
