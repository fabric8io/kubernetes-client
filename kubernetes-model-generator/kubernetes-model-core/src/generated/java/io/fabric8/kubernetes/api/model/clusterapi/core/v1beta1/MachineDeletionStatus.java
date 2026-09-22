
package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeDrainStartTime",
    "waitForNodeVolumeDetachStartTime",
    "waitForPreDrainHookStartTime",
    "waitForPreTerminateHookStartTime"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineDeletionStatus implements Editable<MachineDeletionStatusBuilder>, KubernetesResource
{

    @JsonProperty("nodeDrainStartTime")
    private String nodeDrainStartTime;
    @JsonProperty("waitForNodeVolumeDetachStartTime")
    private String waitForNodeVolumeDetachStartTime;
    @JsonProperty("waitForPreDrainHookStartTime")
    private String waitForPreDrainHookStartTime;
    @JsonProperty("waitForPreTerminateHookStartTime")
    private String waitForPreTerminateHookStartTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDeletionStatus() {
    }

    public MachineDeletionStatus(String nodeDrainStartTime, String waitForNodeVolumeDetachStartTime, String waitForPreDrainHookStartTime, String waitForPreTerminateHookStartTime) {
        super();
        this.nodeDrainStartTime = nodeDrainStartTime;
        this.waitForNodeVolumeDetachStartTime = waitForNodeVolumeDetachStartTime;
        this.waitForPreDrainHookStartTime = waitForPreDrainHookStartTime;
        this.waitForPreTerminateHookStartTime = waitForPreTerminateHookStartTime;
    }

    @JsonProperty("nodeDrainStartTime")
    public String getNodeDrainStartTime() {
        return nodeDrainStartTime;
    }

    @JsonProperty("nodeDrainStartTime")
    public void setNodeDrainStartTime(String nodeDrainStartTime) {
        this.nodeDrainStartTime = nodeDrainStartTime;
    }

    @JsonProperty("waitForNodeVolumeDetachStartTime")
    public String getWaitForNodeVolumeDetachStartTime() {
        return waitForNodeVolumeDetachStartTime;
    }

    @JsonProperty("waitForNodeVolumeDetachStartTime")
    public void setWaitForNodeVolumeDetachStartTime(String waitForNodeVolumeDetachStartTime) {
        this.waitForNodeVolumeDetachStartTime = waitForNodeVolumeDetachStartTime;
    }

    @JsonProperty("waitForPreDrainHookStartTime")
    public String getWaitForPreDrainHookStartTime() {
        return waitForPreDrainHookStartTime;
    }

    @JsonProperty("waitForPreDrainHookStartTime")
    public void setWaitForPreDrainHookStartTime(String waitForPreDrainHookStartTime) {
        this.waitForPreDrainHookStartTime = waitForPreDrainHookStartTime;
    }

    @JsonProperty("waitForPreTerminateHookStartTime")
    public String getWaitForPreTerminateHookStartTime() {
        return waitForPreTerminateHookStartTime;
    }

    @JsonProperty("waitForPreTerminateHookStartTime")
    public void setWaitForPreTerminateHookStartTime(String waitForPreTerminateHookStartTime) {
        this.waitForPreTerminateHookStartTime = waitForPreTerminateHookStartTime;
    }

    @JsonIgnore
    public MachineDeletionStatusBuilder edit() {
        return new MachineDeletionStatusBuilder(this);
    }

    @JsonIgnore
    public MachineDeletionStatusBuilder toBuilder() {
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
