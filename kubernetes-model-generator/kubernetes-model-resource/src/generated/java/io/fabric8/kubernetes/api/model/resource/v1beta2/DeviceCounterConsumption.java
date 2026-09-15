
package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DeviceCounterConsumption defines a set of counters that a device will consume from a CounterSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compatibilityGroups",
    "counterSet",
    "counters"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DeviceCounterConsumption implements Editable<DeviceCounterConsumptionBuilder>, KubernetesResource
{

    @JsonProperty("compatibilityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> compatibilityGroups = new ArrayList<>();
    @JsonProperty("counterSet")
    private String counterSet;
    @JsonProperty("counters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Counter> counters = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceCounterConsumption() {
    }

    public DeviceCounterConsumption(List<String> compatibilityGroups, String counterSet, Map<String, Counter> counters) {
        super();
        this.compatibilityGroups = compatibilityGroups;
        this.counterSet = counterSet;
        this.counters = counters;
    }

    /**
     * CompatibilityGroups is a list of opaque group names for this counter set consumption.<br><p> <br><p> Devices that consume counters from the same counter set may only be allocated at the same time ("co-allocated") if they all share at least one common group: the intersection of the CompatibilityGroups of all co-allocated devices on that counter set must be non-empty. Devices that consume from different counter sets are never compared via this field.<br><p> <br><p> An unset field, an explicit nil, and an empty list are equivalent and mean "no groups": such a device is only co-allocatable with sibling devices on the same counter set that also have no groups, and is never co-allocatable with a device that declares one or more groups.<br><p> <br><p> Group names are opaque and meaningful only within the publishing driver's pool.<br><p> <br><p> The maximum number of groups is 2, and the names must be unique.
     */
    @JsonProperty("compatibilityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCompatibilityGroups() {
        return compatibilityGroups;
    }

    /**
     * CompatibilityGroups is a list of opaque group names for this counter set consumption.<br><p> <br><p> Devices that consume counters from the same counter set may only be allocated at the same time ("co-allocated") if they all share at least one common group: the intersection of the CompatibilityGroups of all co-allocated devices on that counter set must be non-empty. Devices that consume from different counter sets are never compared via this field.<br><p> <br><p> An unset field, an explicit nil, and an empty list are equivalent and mean "no groups": such a device is only co-allocatable with sibling devices on the same counter set that also have no groups, and is never co-allocatable with a device that declares one or more groups.<br><p> <br><p> Group names are opaque and meaningful only within the publishing driver's pool.<br><p> <br><p> The maximum number of groups is 2, and the names must be unique.
     */
    @JsonProperty("compatibilityGroups")
    public void setCompatibilityGroups(List<String> compatibilityGroups) {
        this.compatibilityGroups = compatibilityGroups;
    }

    /**
     * CounterSet is the name of the set from which the counters defined will be consumed.
     */
    @JsonProperty("counterSet")
    public String getCounterSet() {
        return counterSet;
    }

    /**
     * CounterSet is the name of the set from which the counters defined will be consumed.
     */
    @JsonProperty("counterSet")
    public void setCounterSet(String counterSet) {
        this.counterSet = counterSet;
    }

    /**
     * Counters defines the counters that will be consumed by the device.<br><p> <br><p> The maximum number of counters is 32.
     */
    @JsonProperty("counters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Counter> getCounters() {
        return counters;
    }

    /**
     * Counters defines the counters that will be consumed by the device.<br><p> <br><p> The maximum number of counters is 32.
     */
    @JsonProperty("counters")
    public void setCounters(Map<String, Counter> counters) {
        this.counters = counters;
    }

    @JsonIgnore
    public DeviceCounterConsumptionBuilder edit() {
        return new DeviceCounterConsumptionBuilder(this);
    }

    @JsonIgnore
    public DeviceCounterConsumptionBuilder toBuilder() {
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
        if (!(o instanceof DeviceCounterConsumption)) {
            return false;
        }
        DeviceCounterConsumption other = (DeviceCounterConsumption) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$compatibilityGroups = this.getCompatibilityGroups();
        Object other$compatibilityGroups = other.getCompatibilityGroups();
        if (this$compatibilityGroups == null ? other$compatibilityGroups != null : !this$compatibilityGroups.equals(other$compatibilityGroups)) {
            return false;
        }
        Object this$counterSet = this.getCounterSet();
        Object other$counterSet = other.getCounterSet();
        if (this$counterSet == null ? other$counterSet != null : !this$counterSet.equals(other$counterSet)) {
            return false;
        }
        Object this$counters = this.getCounters();
        Object other$counters = other.getCounters();
        if (this$counters == null ? other$counters != null : !this$counters.equals(other$counters)) {
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
        return other instanceof DeviceCounterConsumption;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compatibilityGroups = this.getCompatibilityGroups();
        result = result * prime + ($compatibilityGroups == null ? 43 : $compatibilityGroups.hashCode());
        Object $counterSet = this.getCounterSet();
        result = result * prime + ($counterSet == null ? 43 : $counterSet.hashCode());
        Object $counters = this.getCounters();
        result = result * prime + ($counters == null ? 43 : $counters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceCounterConsumption(" + "compatibilityGroups=" + this.getCompatibilityGroups() + ", counterSet=" + this.getCounterSet() + ", counters=" + this.getCounters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
