
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * AttachedVolume describes a volume attached to a node
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "devicePath",
    "name"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AttachedVolume implements Editable<AttachedVolumeBuilder>, KubernetesResource
{

    @JsonProperty("devicePath")
    private String devicePath;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AttachedVolume() {
    }

    public AttachedVolume(String devicePath, String name) {
        super();
        this.devicePath = devicePath;
        this.name = name;
    }

    /**
     * DevicePath represents the device path where the volume should be available
     */
    @JsonProperty("devicePath")
    public String getDevicePath() {
        return devicePath;
    }

    /**
     * DevicePath represents the device path where the volume should be available
     */
    @JsonProperty("devicePath")
    public void setDevicePath(String devicePath) {
        this.devicePath = devicePath;
    }

    /**
     * Name of the attached volume
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the attached volume
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public AttachedVolumeBuilder edit() {
        return new AttachedVolumeBuilder(this);
    }

    @JsonIgnore
    public AttachedVolumeBuilder toBuilder() {
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
        if (!(o instanceof AttachedVolume)) {
            return false;
        }
        AttachedVolume other = (AttachedVolume) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$devicePath = this.getDevicePath();
        Object other$devicePath = other.getDevicePath();
        if (this$devicePath == null ? other$devicePath != null : !this$devicePath.equals(other$devicePath)) {
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
        return other instanceof AttachedVolume;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $devicePath = this.getDevicePath();
        result = result * prime + ($devicePath == null ? 43 : $devicePath.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AttachedVolume(" + "devicePath=" + this.getDevicePath() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
