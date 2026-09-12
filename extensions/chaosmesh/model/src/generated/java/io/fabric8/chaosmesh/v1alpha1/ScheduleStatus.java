
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

/**
 * ScheduleStatus is the status of a schedule object
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "active",
    "time"
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
public class ScheduleStatus implements Editable<ScheduleStatusBuilder>, KubernetesResource
{

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> active = new ArrayList<>();
    @JsonProperty("time")
    private String time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScheduleStatus() {
    }

    public ScheduleStatus(List<ObjectReference> active, String time) {
        super();
        this.active = active;
        this.time = time;
    }

    /**
     * ScheduleStatus is the status of a schedule object
     */
    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getActive() {
        return active;
    }

    /**
     * ScheduleStatus is the status of a schedule object
     */
    @JsonProperty("active")
    public void setActive(List<ObjectReference> active) {
        this.active = active;
    }

    /**
     * ScheduleStatus is the status of a schedule object
     */
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    /**
     * ScheduleStatus is the status of a schedule object
     */
    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonIgnore
    public ScheduleStatusBuilder edit() {
        return new ScheduleStatusBuilder(this);
    }

    @JsonIgnore
    public ScheduleStatusBuilder toBuilder() {
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
        if (!(o instanceof ScheduleStatus)) {
            return false;
        }
        ScheduleStatus other = (ScheduleStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$active = this.getActive();
        Object other$active = other.getActive();
        if (this$active == null ? other$active != null : !this$active.equals(other$active)) {
            return false;
        }
        Object this$time = this.getTime();
        Object other$time = other.getTime();
        if (this$time == null ? other$time != null : !this$time.equals(other$time)) {
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
        return other instanceof ScheduleStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $active = this.getActive();
        result = result * prime + ($active == null ? 43 : $active.hashCode());
        Object $time = this.getTime();
        result = result * prime + ($time == null ? 43 : $time.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ScheduleStatus(" + "active=" + this.getActive() + ", time=" + this.getTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
