
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
 * Represents an ephemeral volume that is handled by a normal storage driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "volumeClaimTemplate"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EphemeralVolumeSource implements Editable<EphemeralVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("volumeClaimTemplate")
    private PersistentVolumeClaimTemplate volumeClaimTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EphemeralVolumeSource() {
    }

    public EphemeralVolumeSource(PersistentVolumeClaimTemplate volumeClaimTemplate) {
        super();
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    /**
     * Represents an ephemeral volume that is handled by a normal storage driver.
     */
    @JsonProperty("volumeClaimTemplate")
    public PersistentVolumeClaimTemplate getVolumeClaimTemplate() {
        return volumeClaimTemplate;
    }

    /**
     * Represents an ephemeral volume that is handled by a normal storage driver.
     */
    @JsonProperty("volumeClaimTemplate")
    public void setVolumeClaimTemplate(PersistentVolumeClaimTemplate volumeClaimTemplate) {
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    @JsonIgnore
    public EphemeralVolumeSourceBuilder edit() {
        return new EphemeralVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public EphemeralVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof EphemeralVolumeSource)) {
            return false;
        }
        EphemeralVolumeSource other = (EphemeralVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$volumeClaimTemplate = this.getVolumeClaimTemplate();
        Object other$volumeClaimTemplate = other.getVolumeClaimTemplate();
        if (this$volumeClaimTemplate == null ? other$volumeClaimTemplate != null : !this$volumeClaimTemplate.equals(other$volumeClaimTemplate)) {
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
        return other instanceof EphemeralVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $volumeClaimTemplate = this.getVolumeClaimTemplate();
        result = result * prime + ($volumeClaimTemplate == null ? 43 : $volumeClaimTemplate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EphemeralVolumeSource(" + "volumeClaimTemplate=" + this.getVolumeClaimTemplate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
