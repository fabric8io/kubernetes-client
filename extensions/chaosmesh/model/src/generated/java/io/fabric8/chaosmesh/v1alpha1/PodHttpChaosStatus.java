
package io.fabric8.chaosmesh.v1alpha1;

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
 * PodHttpChaosStatus defines the actual state of PodHttpChaos.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failedMessage",
    "observedGeneration",
    "pid",
    "startTime"
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
public class PodHttpChaosStatus implements Editable<PodHttpChaosStatusBuilder>, KubernetesResource
{

    @JsonProperty("failedMessage")
    private String failedMessage;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("pid")
    private Long pid;
    @JsonProperty("startTime")
    private Long startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosStatus() {
    }

    public PodHttpChaosStatus(String failedMessage, Long observedGeneration, Long pid, Long startTime) {
        super();
        this.failedMessage = failedMessage;
        this.observedGeneration = observedGeneration;
        this.pid = pid;
        this.startTime = startTime;
    }

    /**
     * PodHttpChaosStatus defines the actual state of PodHttpChaos.
     */
    @JsonProperty("failedMessage")
    public String getFailedMessage() {
        return failedMessage;
    }

    /**
     * PodHttpChaosStatus defines the actual state of PodHttpChaos.
     */
    @JsonProperty("failedMessage")
    public void setFailedMessage(String failedMessage) {
        this.failedMessage = failedMessage;
    }

    /**
     * PodHttpChaosStatus defines the actual state of PodHttpChaos.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * PodHttpChaosStatus defines the actual state of PodHttpChaos.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Pid represents a running tproxy process id.
     */
    @JsonProperty("pid")
    public Long getPid() {
        return pid;
    }

    /**
     * Pid represents a running tproxy process id.
     */
    @JsonProperty("pid")
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * StartTime represents the start time of a tproxy process.
     */
    @JsonProperty("startTime")
    public Long getStartTime() {
        return startTime;
    }

    /**
     * StartTime represents the start time of a tproxy process.
     */
    @JsonProperty("startTime")
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public PodHttpChaosStatusBuilder edit() {
        return new PodHttpChaosStatusBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosStatusBuilder toBuilder() {
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
        if (!(o instanceof PodHttpChaosStatus)) {
            return false;
        }
        PodHttpChaosStatus other = (PodHttpChaosStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failedMessage = this.getFailedMessage();
        Object other$failedMessage = other.getFailedMessage();
        if (this$failedMessage == null ? other$failedMessage != null : !this$failedMessage.equals(other$failedMessage)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$pid = this.getPid();
        Object other$pid = other.getPid();
        if (this$pid == null ? other$pid != null : !this$pid.equals(other$pid)) {
            return false;
        }
        Object this$startTime = this.getStartTime();
        Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
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
        return other instanceof PodHttpChaosStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failedMessage = this.getFailedMessage();
        result = result * prime + ($failedMessage == null ? 43 : $failedMessage.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $pid = this.getPid();
        result = result * prime + ($pid == null ? 43 : $pid.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodHttpChaosStatus(" + "failedMessage=" + this.getFailedMessage() + ", observedGeneration=" + this.getObservedGeneration() + ", pid=" + this.getPid() + ", startTime=" + this.getStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
