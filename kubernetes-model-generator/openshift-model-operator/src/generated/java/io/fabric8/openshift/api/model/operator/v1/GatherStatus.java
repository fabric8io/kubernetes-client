
package io.fabric8.openshift.api.model.operator.v1;

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
 * gatherStatus provides information about the last known gather event.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gatherers",
    "lastGatherDuration",
    "lastGatherTime"
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
public class GatherStatus implements Editable<GatherStatusBuilder>, KubernetesResource
{

    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GathererStatus> gatherers = new ArrayList<>();
    @JsonProperty("lastGatherDuration")
    private String lastGatherDuration;
    @JsonProperty("lastGatherTime")
    private String lastGatherTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatherStatus() {
    }

    public GatherStatus(List<GathererStatus> gatherers, String lastGatherDuration, String lastGatherTime) {
        super();
        this.gatherers = gatherers;
        this.lastGatherDuration = lastGatherDuration;
        this.lastGatherTime = lastGatherTime;
    }

    /**
     * gatherers is a list of active gatherers (and their statuses) in the last gathering.
     */
    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GathererStatus> getGatherers() {
        return gatherers;
    }

    /**
     * gatherers is a list of active gatherers (and their statuses) in the last gathering.
     */
    @JsonProperty("gatherers")
    public void setGatherers(List<GathererStatus> gatherers) {
        this.gatherers = gatherers;
    }

    /**
     * gatherStatus provides information about the last known gather event.
     */
    @JsonProperty("lastGatherDuration")
    public String getLastGatherDuration() {
        return lastGatherDuration;
    }

    /**
     * gatherStatus provides information about the last known gather event.
     */
    @JsonProperty("lastGatherDuration")
    public void setLastGatherDuration(String lastGatherDuration) {
        this.lastGatherDuration = lastGatherDuration;
    }

    /**
     * gatherStatus provides information about the last known gather event.
     */
    @JsonProperty("lastGatherTime")
    public String getLastGatherTime() {
        return lastGatherTime;
    }

    /**
     * gatherStatus provides information about the last known gather event.
     */
    @JsonProperty("lastGatherTime")
    public void setLastGatherTime(String lastGatherTime) {
        this.lastGatherTime = lastGatherTime;
    }

    @JsonIgnore
    public GatherStatusBuilder edit() {
        return new GatherStatusBuilder(this);
    }

    @JsonIgnore
    public GatherStatusBuilder toBuilder() {
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
        if (!(o instanceof GatherStatus)) {
            return false;
        }
        GatherStatus other = (GatherStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$gatherers = this.getGatherers();
        Object other$gatherers = other.getGatherers();
        if (this$gatherers == null ? other$gatherers != null : !this$gatherers.equals(other$gatherers)) {
            return false;
        }
        Object this$lastGatherDuration = this.getLastGatherDuration();
        Object other$lastGatherDuration = other.getLastGatherDuration();
        if (this$lastGatherDuration == null ? other$lastGatherDuration != null : !this$lastGatherDuration.equals(other$lastGatherDuration)) {
            return false;
        }
        Object this$lastGatherTime = this.getLastGatherTime();
        Object other$lastGatherTime = other.getLastGatherTime();
        if (this$lastGatherTime == null ? other$lastGatherTime != null : !this$lastGatherTime.equals(other$lastGatherTime)) {
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
        return other instanceof GatherStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $gatherers = this.getGatherers();
        result = result * prime + ($gatherers == null ? 43 : $gatherers.hashCode());
        Object $lastGatherDuration = this.getLastGatherDuration();
        result = result * prime + ($lastGatherDuration == null ? 43 : $lastGatherDuration.hashCode());
        Object $lastGatherTime = this.getLastGatherTime();
        result = result * prime + ($lastGatherTime == null ? 43 : $lastGatherTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GatherStatus(" + "gatherers=" + this.getGatherers() + ", lastGatherDuration=" + this.getLastGatherDuration() + ", lastGatherTime=" + this.getLastGatherTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
