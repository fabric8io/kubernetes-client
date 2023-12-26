
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "status",
    "targetVolumeAttributesClassName"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ModifyVolumeStatus implements Editable<ModifyVolumeStatusBuilder> , KubernetesResource
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("targetVolumeAttributesClassName")
    private String targetVolumeAttributesClassName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModifyVolumeStatus() {
    }

    public ModifyVolumeStatus(String status, String targetVolumeAttributesClassName) {
        super();
        this.status = status;
        this.targetVolumeAttributesClassName = targetVolumeAttributesClassName;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("targetVolumeAttributesClassName")
    public String getTargetVolumeAttributesClassName() {
        return targetVolumeAttributesClassName;
    }

    @JsonProperty("targetVolumeAttributesClassName")
    public void setTargetVolumeAttributesClassName(String targetVolumeAttributesClassName) {
        this.targetVolumeAttributesClassName = targetVolumeAttributesClassName;
    }

    @JsonIgnore
    public ModifyVolumeStatusBuilder edit() {
        return new ModifyVolumeStatusBuilder(this);
    }

    @JsonIgnore
    public ModifyVolumeStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
