
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
