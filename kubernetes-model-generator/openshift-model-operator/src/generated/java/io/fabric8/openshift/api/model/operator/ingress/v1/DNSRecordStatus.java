
package io.fabric8.openshift.api.model.operator.ingress.v1;

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
 * DNSRecordStatus is the most recently observed status of each record.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "observedGeneration",
    "zones"
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
public class DNSRecordStatus implements Editable<DNSRecordStatusBuilder>, KubernetesResource
{

    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DNSZoneStatus> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSRecordStatus() {
    }

    public DNSRecordStatus(Long observedGeneration, List<DNSZoneStatus> zones) {
        super();
        this.observedGeneration = observedGeneration;
        this.zones = zones;
    }

    /**
     * observedGeneration is the most recently observed generation of the DNSRecord.  When the DNSRecord is updated, the controller updates the corresponding record in each managed zone.  If an update for a particular zone fails, that failure is recorded in the status condition for the zone so that the controller can determine that it needs to retry the update for that specific zone.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the most recently observed generation of the DNSRecord.  When the DNSRecord is updated, the controller updates the corresponding record in each managed zone.  If an update for a particular zone fails, that failure is recorded in the status condition for the zone so that the controller can determine that it needs to retry the update for that specific zone.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * zones are the status of the record in each zone.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSZoneStatus> getZones() {
        return zones;
    }

    /**
     * zones are the status of the record in each zone.
     */
    @JsonProperty("zones")
    public void setZones(List<DNSZoneStatus> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public DNSRecordStatusBuilder edit() {
        return new DNSRecordStatusBuilder(this);
    }

    @JsonIgnore
    public DNSRecordStatusBuilder toBuilder() {
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
        if (!(o instanceof DNSRecordStatus)) {
            return false;
        }
        DNSRecordStatus other = (DNSRecordStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
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
        return other instanceof DNSRecordStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSRecordStatus(" + "observedGeneration=" + this.getObservedGeneration() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
