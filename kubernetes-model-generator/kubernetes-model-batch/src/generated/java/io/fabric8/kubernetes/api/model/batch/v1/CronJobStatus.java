
package io.fabric8.kubernetes.api.model.batch.v1;

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
 * CronJobStatus represents the current state of a cron job.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "active",
    "lastScheduleTime",
    "lastSuccessfulTime"
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
public class CronJobStatus implements Editable<CronJobStatusBuilder>, KubernetesResource
{

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> active = new ArrayList<>();
    @JsonProperty("lastScheduleTime")
    private String lastScheduleTime;
    @JsonProperty("lastSuccessfulTime")
    private String lastSuccessfulTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CronJobStatus() {
    }

    public CronJobStatus(List<ObjectReference> active, String lastScheduleTime, String lastSuccessfulTime) {
        super();
        this.active = active;
        this.lastScheduleTime = lastScheduleTime;
        this.lastSuccessfulTime = lastSuccessfulTime;
    }

    /**
     * A list of pointers to currently running jobs.
     */
    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getActive() {
        return active;
    }

    /**
     * A list of pointers to currently running jobs.
     */
    @JsonProperty("active")
    public void setActive(List<ObjectReference> active) {
        this.active = active;
    }

    /**
     * CronJobStatus represents the current state of a cron job.
     */
    @JsonProperty("lastScheduleTime")
    public String getLastScheduleTime() {
        return lastScheduleTime;
    }

    /**
     * CronJobStatus represents the current state of a cron job.
     */
    @JsonProperty("lastScheduleTime")
    public void setLastScheduleTime(String lastScheduleTime) {
        this.lastScheduleTime = lastScheduleTime;
    }

    /**
     * CronJobStatus represents the current state of a cron job.
     */
    @JsonProperty("lastSuccessfulTime")
    public String getLastSuccessfulTime() {
        return lastSuccessfulTime;
    }

    /**
     * CronJobStatus represents the current state of a cron job.
     */
    @JsonProperty("lastSuccessfulTime")
    public void setLastSuccessfulTime(String lastSuccessfulTime) {
        this.lastSuccessfulTime = lastSuccessfulTime;
    }

    @JsonIgnore
    public CronJobStatusBuilder edit() {
        return new CronJobStatusBuilder(this);
    }

    @JsonIgnore
    public CronJobStatusBuilder toBuilder() {
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
        if (!(o instanceof CronJobStatus)) {
            return false;
        }
        CronJobStatus other = (CronJobStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$active = this.getActive();
        Object other$active = other.getActive();
        if (this$active == null ? other$active != null : !this$active.equals(other$active)) {
            return false;
        }
        Object this$lastScheduleTime = this.getLastScheduleTime();
        Object other$lastScheduleTime = other.getLastScheduleTime();
        if (this$lastScheduleTime == null ? other$lastScheduleTime != null : !this$lastScheduleTime.equals(other$lastScheduleTime)) {
            return false;
        }
        Object this$lastSuccessfulTime = this.getLastSuccessfulTime();
        Object other$lastSuccessfulTime = other.getLastSuccessfulTime();
        if (this$lastSuccessfulTime == null ? other$lastSuccessfulTime != null : !this$lastSuccessfulTime.equals(other$lastSuccessfulTime)) {
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
        return other instanceof CronJobStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $active = this.getActive();
        result = result * prime + ($active == null ? 43 : $active.hashCode());
        Object $lastScheduleTime = this.getLastScheduleTime();
        result = result * prime + ($lastScheduleTime == null ? 43 : $lastScheduleTime.hashCode());
        Object $lastSuccessfulTime = this.getLastSuccessfulTime();
        result = result * prime + ($lastSuccessfulTime == null ? 43 : $lastSuccessfulTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CronJobStatus(" + "active=" + this.getActive() + ", lastScheduleTime=" + this.getLastScheduleTime() + ", lastSuccessfulTime=" + this.getLastSuccessfulTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
