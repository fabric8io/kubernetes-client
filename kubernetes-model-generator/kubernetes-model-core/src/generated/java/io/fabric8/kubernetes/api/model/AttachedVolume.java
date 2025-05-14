
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AttachedVolume describes a volume attached to a node
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "devicePath",
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

}
