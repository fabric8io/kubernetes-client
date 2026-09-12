
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HostFirmwareSettingsStatus defines the observed state of HostFirmwareSettings.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "lastUpdated",
    "schema",
    "settings"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HostFirmwareSettingsStatus implements Editable<HostFirmwareSettingsStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("schema")
    private SchemaReference schema;
    @JsonProperty("settings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> settings = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostFirmwareSettingsStatus() {
    }

    public HostFirmwareSettingsStatus(List<Condition> conditions, String lastUpdated, SchemaReference schema, Map<String, String> settings) {
        super();
        this.conditions = conditions;
        this.lastUpdated = lastUpdated;
        this.schema = schema;
        this.settings = settings;
    }

    /**
     * Track whether settings stored in the spec are valid based on the schema
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Track whether settings stored in the spec are valid based on the schema
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * HostFirmwareSettingsStatus defines the observed state of HostFirmwareSettings.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * HostFirmwareSettingsStatus defines the observed state of HostFirmwareSettings.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * HostFirmwareSettingsStatus defines the observed state of HostFirmwareSettings.
     */
    @JsonProperty("schema")
    public SchemaReference getSchema() {
        return schema;
    }

    /**
     * HostFirmwareSettingsStatus defines the observed state of HostFirmwareSettings.
     */
    @JsonProperty("schema")
    public void setSchema(SchemaReference schema) {
        this.schema = schema;
    }

    /**
     * Settings are the firmware settings stored as name/value pairs
     */
    @JsonProperty("settings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSettings() {
        return settings;
    }

    /**
     * Settings are the firmware settings stored as name/value pairs
     */
    @JsonProperty("settings")
    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }

    @JsonIgnore
    public HostFirmwareSettingsStatusBuilder edit() {
        return new HostFirmwareSettingsStatusBuilder(this);
    }

    @JsonIgnore
    public HostFirmwareSettingsStatusBuilder toBuilder() {
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
        if (!(o instanceof HostFirmwareSettingsStatus)) {
            return false;
        }
        HostFirmwareSettingsStatus other = (HostFirmwareSettingsStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$schema = this.getSchema();
        Object other$schema = other.getSchema();
        if (this$schema == null ? other$schema != null : !this$schema.equals(other$schema)) {
            return false;
        }
        Object this$settings = this.getSettings();
        Object other$settings = other.getSettings();
        if (this$settings == null ? other$settings != null : !this$settings.equals(other$settings)) {
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
        return other instanceof HostFirmwareSettingsStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $schema = this.getSchema();
        result = result * prime + ($schema == null ? 43 : $schema.hashCode());
        Object $settings = this.getSettings();
        result = result * prime + ($settings == null ? 43 : $settings.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostFirmwareSettingsStatus(" + "conditions=" + this.getConditions() + ", lastUpdated=" + this.getLastUpdated() + ", schema=" + this.getSchema() + ", settings=" + this.getSettings() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
