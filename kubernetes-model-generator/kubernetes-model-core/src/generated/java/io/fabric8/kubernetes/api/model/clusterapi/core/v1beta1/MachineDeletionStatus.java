
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeDrainStartTime",
    "waitForNodeVolumeDetachStartTime"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineDeletionStatus implements Editable<MachineDeletionStatusBuilder>, KubernetesResource
{

    @JsonProperty("nodeDrainStartTime")
    private String nodeDrainStartTime;
    @JsonProperty("waitForNodeVolumeDetachStartTime")
    private String waitForNodeVolumeDetachStartTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineDeletionStatus() {
    }

    public MachineDeletionStatus(String nodeDrainStartTime, String waitForNodeVolumeDetachStartTime) {
        super();
        this.nodeDrainStartTime = nodeDrainStartTime;
        this.waitForNodeVolumeDetachStartTime = waitForNodeVolumeDetachStartTime;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachineDeletionStatus)) {
            return false;
        }
        MachineDeletionStatus other = (MachineDeletionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeDrainStartTime = this.getNodeDrainStartTime();
        Object other$nodeDrainStartTime = other.getNodeDrainStartTime();
        if (this$nodeDrainStartTime == null ? other$nodeDrainStartTime != null : !this$nodeDrainStartTime.equals(other$nodeDrainStartTime)) {
            return false;
        }
        Object this$waitForNodeVolumeDetachStartTime = this.getWaitForNodeVolumeDetachStartTime();
        Object other$waitForNodeVolumeDetachStartTime = other.getWaitForNodeVolumeDetachStartTime();
        if (this$waitForNodeVolumeDetachStartTime == null ? other$waitForNodeVolumeDetachStartTime != null : !this$waitForNodeVolumeDetachStartTime.equals(other$waitForNodeVolumeDetachStartTime)) {
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
        return other instanceof MachineDeletionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeDrainStartTime = this.getNodeDrainStartTime();
        result = result * prime + ($nodeDrainStartTime == null ? 43 : $nodeDrainStartTime.hashCode());
        Object $waitForNodeVolumeDetachStartTime = this.getWaitForNodeVolumeDetachStartTime();
        result = result * prime + ($waitForNodeVolumeDetachStartTime == null ? 43 : $waitForNodeVolumeDetachStartTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineDeletionStatus(" + "nodeDrainStartTime=" + this.getNodeDrainStartTime() + ", waitForNodeVolumeDetachStartTime=" + this.getWaitForNodeVolumeDetachStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
