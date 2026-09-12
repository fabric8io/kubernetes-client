
package io.fabric8.chaosmesh.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "events",
    "id",
    "injectedCount",
    "phase",
    "recoveredCount",
    "selectorKey"
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
public class Record implements Editable<RecordBuilder>, KubernetesResource
{

    @JsonProperty("events")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RecordEvent> events = new ArrayList<>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("injectedCount")
    private Integer injectedCount;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("recoveredCount")
    private Integer recoveredCount;
    @JsonProperty("selectorKey")
    private String selectorKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Record() {
    }

    public Record(List<RecordEvent> events, String id, Integer injectedCount, String phase, Integer recoveredCount, String selectorKey) {
        super();
        this.events = events;
        this.id = id;
        this.injectedCount = injectedCount;
        this.phase = phase;
        this.recoveredCount = recoveredCount;
        this.selectorKey = selectorKey;
    }

    /**
     * Events are the essential details about the injections and recoveries
     */
    @JsonProperty("events")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RecordEvent> getEvents() {
        return events;
    }

    /**
     * Events are the essential details about the injections and recoveries
     */
    @JsonProperty("events")
    public void setEvents(List<RecordEvent> events) {
        this.events = events;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * InjectedCount is a counter to record the sum of successful injections
     */
    @JsonProperty("injectedCount")
    public Integer getInjectedCount() {
        return injectedCount;
    }

    /**
     * InjectedCount is a counter to record the sum of successful injections
     */
    @JsonProperty("injectedCount")
    public void setInjectedCount(Integer injectedCount) {
        this.injectedCount = injectedCount;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * RecoveredCount is a counter to record the sum of successful recoveries
     */
    @JsonProperty("recoveredCount")
    public Integer getRecoveredCount() {
        return recoveredCount;
    }

    /**
     * RecoveredCount is a counter to record the sum of successful recoveries
     */
    @JsonProperty("recoveredCount")
    public void setRecoveredCount(Integer recoveredCount) {
        this.recoveredCount = recoveredCount;
    }

    @JsonProperty("selectorKey")
    public String getSelectorKey() {
        return selectorKey;
    }

    @JsonProperty("selectorKey")
    public void setSelectorKey(String selectorKey) {
        this.selectorKey = selectorKey;
    }

    @JsonIgnore
    public RecordBuilder edit() {
        return new RecordBuilder(this);
    }

    @JsonIgnore
    public RecordBuilder toBuilder() {
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
        if (!(o instanceof Record)) {
            return false;
        }
        Record other = (Record) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$events = this.getEvents();
        Object other$events = other.getEvents();
        if (this$events == null ? other$events != null : !this$events.equals(other$events)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$injectedCount = this.getInjectedCount();
        Object other$injectedCount = other.getInjectedCount();
        if (this$injectedCount == null ? other$injectedCount != null : !this$injectedCount.equals(other$injectedCount)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$recoveredCount = this.getRecoveredCount();
        Object other$recoveredCount = other.getRecoveredCount();
        if (this$recoveredCount == null ? other$recoveredCount != null : !this$recoveredCount.equals(other$recoveredCount)) {
            return false;
        }
        Object this$selectorKey = this.getSelectorKey();
        Object other$selectorKey = other.getSelectorKey();
        if (this$selectorKey == null ? other$selectorKey != null : !this$selectorKey.equals(other$selectorKey)) {
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
        return other instanceof Record;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $events = this.getEvents();
        result = result * prime + ($events == null ? 43 : $events.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $injectedCount = this.getInjectedCount();
        result = result * prime + ($injectedCount == null ? 43 : $injectedCount.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $recoveredCount = this.getRecoveredCount();
        result = result * prime + ($recoveredCount == null ? 43 : $recoveredCount.hashCode());
        Object $selectorKey = this.getSelectorKey();
        result = result * prime + ($selectorKey == null ? 43 : $selectorKey.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Record(" + "events=" + this.getEvents() + ", id=" + this.getId() + ", injectedCount=" + this.getInjectedCount() + ", phase=" + this.getPhase() + ", recoveredCount=" + this.getRecoveredCount() + ", selectorKey=" + this.getSelectorKey() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
