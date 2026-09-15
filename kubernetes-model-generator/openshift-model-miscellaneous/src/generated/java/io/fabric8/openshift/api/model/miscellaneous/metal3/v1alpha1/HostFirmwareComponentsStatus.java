
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
 * HostFirmwareComponentsStatus defines the observed state of HostFirmwareComponents.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "components",
    "conditions",
    "lastUpdated",
    "updates"
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
public class HostFirmwareComponentsStatus implements Editable<HostFirmwareComponentsStatusBuilder>, KubernetesResource
{

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FirmwareComponentStatus> components = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("updates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FirmwareUpdate> updates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostFirmwareComponentsStatus() {
    }

    public HostFirmwareComponentsStatus(List<FirmwareComponentStatus> components, List<Condition> conditions, String lastUpdated, List<FirmwareUpdate> updates) {
        super();
        this.components = components;
        this.conditions = conditions;
        this.lastUpdated = lastUpdated;
        this.updates = updates;
    }

    /**
     * Components is the list of all available firmware components and their information.
     */
    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FirmwareComponentStatus> getComponents() {
        return components;
    }

    /**
     * Components is the list of all available firmware components and their information.
     */
    @JsonProperty("components")
    public void setComponents(List<FirmwareComponentStatus> components) {
        this.components = components;
    }

    /**
     * Track whether updates stored in the spec are valid based on the schema
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Track whether updates stored in the spec are valid based on the schema
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * HostFirmwareComponentsStatus defines the observed state of HostFirmwareComponents.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * HostFirmwareComponentsStatus defines the observed state of HostFirmwareComponents.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Updates is the list of all firmware components that should be updated they are specified via name and url fields.
     */
    @JsonProperty("updates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FirmwareUpdate> getUpdates() {
        return updates;
    }

    /**
     * Updates is the list of all firmware components that should be updated they are specified via name and url fields.
     */
    @JsonProperty("updates")
    public void setUpdates(List<FirmwareUpdate> updates) {
        this.updates = updates;
    }

    @JsonIgnore
    public HostFirmwareComponentsStatusBuilder edit() {
        return new HostFirmwareComponentsStatusBuilder(this);
    }

    @JsonIgnore
    public HostFirmwareComponentsStatusBuilder toBuilder() {
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
        if (!(o instanceof HostFirmwareComponentsStatus)) {
            return false;
        }
        HostFirmwareComponentsStatus other = (HostFirmwareComponentsStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$components = this.getComponents();
        Object other$components = other.getComponents();
        if (this$components == null ? other$components != null : !this$components.equals(other$components)) {
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
        Object this$updates = this.getUpdates();
        Object other$updates = other.getUpdates();
        if (this$updates == null ? other$updates != null : !this$updates.equals(other$updates)) {
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
        return other instanceof HostFirmwareComponentsStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $components = this.getComponents();
        result = result * prime + ($components == null ? 43 : $components.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $updates = this.getUpdates();
        result = result * prime + ($updates == null ? 43 : $updates.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostFirmwareComponentsStatus(" + "components=" + this.getComponents() + ", conditions=" + this.getConditions() + ", lastUpdated=" + this.getLastUpdated() + ", updates=" + this.getUpdates() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
