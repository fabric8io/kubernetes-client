
package io.fabric8.openshift.api.model.autoscaling.v1;

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

/**
 * Configuration of scale down operation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "delayAfterAdd",
    "delayAfterDelete",
    "delayAfterFailure",
    "enabled",
    "unneededTime",
    "utilizationThreshold"
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
public class ClusterAutoscalerSpecScaleDown implements Editable<ClusterAutoscalerSpecScaleDownBuilder>, KubernetesResource
{

    @JsonProperty("delayAfterAdd")
    private String delayAfterAdd;
    @JsonProperty("delayAfterDelete")
    private String delayAfterDelete;
    @JsonProperty("delayAfterFailure")
    private String delayAfterFailure;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("unneededTime")
    private String unneededTime;
    @JsonProperty("utilizationThreshold")
    private String utilizationThreshold;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAutoscalerSpecScaleDown() {
    }

    public ClusterAutoscalerSpecScaleDown(String delayAfterAdd, String delayAfterDelete, String delayAfterFailure, Boolean enabled, String unneededTime, String utilizationThreshold) {
        super();
        this.delayAfterAdd = delayAfterAdd;
        this.delayAfterDelete = delayAfterDelete;
        this.delayAfterFailure = delayAfterFailure;
        this.enabled = enabled;
        this.unneededTime = unneededTime;
        this.utilizationThreshold = utilizationThreshold;
    }

    /**
     * How long after scale up that scale down evaluation resumes
     */
    @JsonProperty("delayAfterAdd")
    public String getDelayAfterAdd() {
        return delayAfterAdd;
    }

    /**
     * How long after scale up that scale down evaluation resumes
     */
    @JsonProperty("delayAfterAdd")
    public void setDelayAfterAdd(String delayAfterAdd) {
        this.delayAfterAdd = delayAfterAdd;
    }

    /**
     * How long after node deletion that scale down evaluation resumes, defaults to scan-interval
     */
    @JsonProperty("delayAfterDelete")
    public String getDelayAfterDelete() {
        return delayAfterDelete;
    }

    /**
     * How long after node deletion that scale down evaluation resumes, defaults to scan-interval
     */
    @JsonProperty("delayAfterDelete")
    public void setDelayAfterDelete(String delayAfterDelete) {
        this.delayAfterDelete = delayAfterDelete;
    }

    /**
     * How long after scale down failure that scale down evaluation resumes
     */
    @JsonProperty("delayAfterFailure")
    public String getDelayAfterFailure() {
        return delayAfterFailure;
    }

    /**
     * How long after scale down failure that scale down evaluation resumes
     */
    @JsonProperty("delayAfterFailure")
    public void setDelayAfterFailure(String delayAfterFailure) {
        this.delayAfterFailure = delayAfterFailure;
    }

    /**
     * Should CA scale down the cluster
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Should CA scale down the cluster
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * How long a node should be unneeded before it is eligible for scale down
     */
    @JsonProperty("unneededTime")
    public String getUnneededTime() {
        return unneededTime;
    }

    /**
     * How long a node should be unneeded before it is eligible for scale down
     */
    @JsonProperty("unneededTime")
    public void setUnneededTime(String unneededTime) {
        this.unneededTime = unneededTime;
    }

    /**
     * Node utilization level, defined as sum of requested resources divided by capacity, below which a node can be considered for scale down
     */
    @JsonProperty("utilizationThreshold")
    public String getUtilizationThreshold() {
        return utilizationThreshold;
    }

    /**
     * Node utilization level, defined as sum of requested resources divided by capacity, below which a node can be considered for scale down
     */
    @JsonProperty("utilizationThreshold")
    public void setUtilizationThreshold(String utilizationThreshold) {
        this.utilizationThreshold = utilizationThreshold;
    }

    @JsonIgnore
    public ClusterAutoscalerSpecScaleDownBuilder edit() {
        return new ClusterAutoscalerSpecScaleDownBuilder(this);
    }

    @JsonIgnore
    public ClusterAutoscalerSpecScaleDownBuilder toBuilder() {
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
        if (!(o instanceof ClusterAutoscalerSpecScaleDown)) {
            return false;
        }
        ClusterAutoscalerSpecScaleDown other = (ClusterAutoscalerSpecScaleDown) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$delayAfterAdd = this.getDelayAfterAdd();
        Object other$delayAfterAdd = other.getDelayAfterAdd();
        if (this$delayAfterAdd == null ? other$delayAfterAdd != null : !this$delayAfterAdd.equals(other$delayAfterAdd)) {
            return false;
        }
        Object this$delayAfterDelete = this.getDelayAfterDelete();
        Object other$delayAfterDelete = other.getDelayAfterDelete();
        if (this$delayAfterDelete == null ? other$delayAfterDelete != null : !this$delayAfterDelete.equals(other$delayAfterDelete)) {
            return false;
        }
        Object this$delayAfterFailure = this.getDelayAfterFailure();
        Object other$delayAfterFailure = other.getDelayAfterFailure();
        if (this$delayAfterFailure == null ? other$delayAfterFailure != null : !this$delayAfterFailure.equals(other$delayAfterFailure)) {
            return false;
        }
        Object this$enabled = this.getEnabled();
        Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) {
            return false;
        }
        Object this$unneededTime = this.getUnneededTime();
        Object other$unneededTime = other.getUnneededTime();
        if (this$unneededTime == null ? other$unneededTime != null : !this$unneededTime.equals(other$unneededTime)) {
            return false;
        }
        Object this$utilizationThreshold = this.getUtilizationThreshold();
        Object other$utilizationThreshold = other.getUtilizationThreshold();
        if (this$utilizationThreshold == null ? other$utilizationThreshold != null : !this$utilizationThreshold.equals(other$utilizationThreshold)) {
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
        return other instanceof ClusterAutoscalerSpecScaleDown;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $delayAfterAdd = this.getDelayAfterAdd();
        result = result * prime + ($delayAfterAdd == null ? 43 : $delayAfterAdd.hashCode());
        Object $delayAfterDelete = this.getDelayAfterDelete();
        result = result * prime + ($delayAfterDelete == null ? 43 : $delayAfterDelete.hashCode());
        Object $delayAfterFailure = this.getDelayAfterFailure();
        result = result * prime + ($delayAfterFailure == null ? 43 : $delayAfterFailure.hashCode());
        Object $enabled = this.getEnabled();
        result = result * prime + ($enabled == null ? 43 : $enabled.hashCode());
        Object $unneededTime = this.getUnneededTime();
        result = result * prime + ($unneededTime == null ? 43 : $unneededTime.hashCode());
        Object $utilizationThreshold = this.getUtilizationThreshold();
        result = result * prime + ($utilizationThreshold == null ? 43 : $utilizationThreshold.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterAutoscalerSpecScaleDown(" + "delayAfterAdd=" + this.getDelayAfterAdd() + ", delayAfterDelete=" + this.getDelayAfterDelete() + ", delayAfterFailure=" + this.getDelayAfterFailure() + ", enabled=" + this.getEnabled() + ", unneededTime=" + this.getUnneededTime() + ", utilizationThreshold=" + this.getUtilizationThreshold() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
