
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * PodVolumeHealth contains health information for a volume used by a pod, reported by the CSI node plugin via the kubelet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "healthConditions",
    "lastTransitionTime",
    "name"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodVolumeHealth implements Editable<PodVolumeHealthBuilder>, KubernetesResource
{

    @JsonProperty("healthConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeHealthCondition> healthConditions = new ArrayList<>();
    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodVolumeHealth() {
    }

    public PodVolumeHealth(List<VolumeHealthCondition> healthConditions, String lastTransitionTime, String name) {
        super();
        this.healthConditions = healthConditions;
        this.lastTransitionTime = lastTransitionTime;
        this.name = name;
    }

    /**
     * conditions is the set of adverse conditions reported by the CSI node plugin for this volume on this node. At most 16 conditions may be reported.
     */
    @JsonProperty("healthConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeHealthCondition> getHealthConditions() {
        return healthConditions;
    }

    /**
     * conditions is the set of adverse conditions reported by the CSI node plugin for this volume on this node. At most 16 conditions may be reported.
     */
    @JsonProperty("healthConditions")
    public void setHealthConditions(List<VolumeHealthCondition> healthConditions) {
        this.healthConditions = healthConditions;
    }

    /**
     * PodVolumeHealth contains health information for a volume used by a pod, reported by the CSI node plugin via the kubelet.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * PodVolumeHealth contains health information for a volume used by a pod, reported by the CSI node plugin via the kubelet.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * name matches an entry in pod.spec.volumes.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name matches an entry in pod.spec.volumes.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public PodVolumeHealthBuilder edit() {
        return new PodVolumeHealthBuilder(this);
    }

    @JsonIgnore
    public PodVolumeHealthBuilder toBuilder() {
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
        if (!(o instanceof PodVolumeHealth)) {
            return false;
        }
        PodVolumeHealth other = (PodVolumeHealth) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$healthConditions = this.getHealthConditions();
        Object other$healthConditions = other.getHealthConditions();
        if (this$healthConditions == null ? other$healthConditions != null : !this$healthConditions.equals(other$healthConditions)) {
            return false;
        }
        Object this$lastTransitionTime = this.getLastTransitionTime();
        Object other$lastTransitionTime = other.getLastTransitionTime();
        if (this$lastTransitionTime == null ? other$lastTransitionTime != null : !this$lastTransitionTime.equals(other$lastTransitionTime)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof PodVolumeHealth;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $healthConditions = this.getHealthConditions();
        result = result * prime + ($healthConditions == null ? 43 : $healthConditions.hashCode());
        Object $lastTransitionTime = this.getLastTransitionTime();
        result = result * prime + ($lastTransitionTime == null ? 43 : $lastTransitionTime.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodVolumeHealth(" + "healthConditions=" + this.getHealthConditions() + ", lastTransitionTime=" + this.getLastTransitionTime() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
