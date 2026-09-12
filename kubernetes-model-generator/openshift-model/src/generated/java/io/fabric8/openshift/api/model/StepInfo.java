
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
 * StepInfo contains details about a build step.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "durationMilliseconds",
    "name",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class StepInfo implements Editable<StepInfoBuilder>, KubernetesResource
{

    @JsonProperty("durationMilliseconds")
    private Long durationMilliseconds;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StepInfo() {
    }

    public StepInfo(Long durationMilliseconds, String name, String startTime) {
        super();
        this.durationMilliseconds = durationMilliseconds;
        this.name = name;
        this.startTime = startTime;
    }

    /**
     * durationMilliseconds identifies how long the step took to complete in milliseconds.
     */
    @JsonProperty("durationMilliseconds")
    public Long getDurationMilliseconds() {
        return durationMilliseconds;
    }

    /**
     * durationMilliseconds identifies how long the step took to complete in milliseconds.
     */
    @JsonProperty("durationMilliseconds")
    public void setDurationMilliseconds(Long durationMilliseconds) {
        this.durationMilliseconds = durationMilliseconds;
    }

    /**
     * name is a unique identifier for each build step.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is a unique identifier for each build step.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * StepInfo contains details about a build step.
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * StepInfo contains details about a build step.
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public StepInfoBuilder edit() {
        return new StepInfoBuilder(this);
    }

    @JsonIgnore
    public StepInfoBuilder toBuilder() {
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
        if (!(o instanceof StepInfo)) {
            return false;
        }
        StepInfo other = (StepInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$durationMilliseconds = this.getDurationMilliseconds();
        Object other$durationMilliseconds = other.getDurationMilliseconds();
        if (this$durationMilliseconds == null ? other$durationMilliseconds != null : !this$durationMilliseconds.equals(other$durationMilliseconds)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof StepInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $durationMilliseconds = this.getDurationMilliseconds();
        result = result * prime + ($durationMilliseconds == null ? 43 : $durationMilliseconds.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StepInfo(" + "durationMilliseconds=" + this.getDurationMilliseconds() + ", name=" + this.getName() + ", startTime=" + this.getStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
