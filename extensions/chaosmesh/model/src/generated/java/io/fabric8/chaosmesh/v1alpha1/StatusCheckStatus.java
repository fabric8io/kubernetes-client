
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
    "completionTime",
    "conditions",
    "count",
    "records",
    "startTime"
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
public class StatusCheckStatus implements Editable<StatusCheckStatusBuilder>, KubernetesResource
{

    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatusCheckCondition> conditions = new ArrayList<>();
    @JsonProperty("count")
    private Long count;
    @JsonProperty("records")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatusCheckRecord> records = new ArrayList<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatusCheckStatus() {
    }

    public StatusCheckStatus(String completionTime, List<StatusCheckCondition> conditions, Long count, List<StatusCheckRecord> records, String startTime) {
        super();
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.count = count;
        this.records = records;
        this.startTime = startTime;
    }

    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * Conditions represents the latest available observations of a StatusCheck's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatusCheckCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions represents the latest available observations of a StatusCheck's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<StatusCheckCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Count represents the total number of the status check executed.
     */
    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    /**
     * Count represents the total number of the status check executed.
     */
    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * Records contains the history of the execution of StatusCheck.
     */
    @JsonProperty("records")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatusCheckRecord> getRecords() {
        return records;
    }

    /**
     * Records contains the history of the execution of StatusCheck.
     */
    @JsonProperty("records")
    public void setRecords(List<StatusCheckRecord> records) {
        this.records = records;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public StatusCheckStatusBuilder edit() {
        return new StatusCheckStatusBuilder(this);
    }

    @JsonIgnore
    public StatusCheckStatusBuilder toBuilder() {
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
        if (!(o instanceof StatusCheckStatus)) {
            return false;
        }
        StatusCheckStatus other = (StatusCheckStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$completionTime = this.getCompletionTime();
        Object other$completionTime = other.getCompletionTime();
        if (this$completionTime == null ? other$completionTime != null : !this$completionTime.equals(other$completionTime)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$count = this.getCount();
        Object other$count = other.getCount();
        if (this$count == null ? other$count != null : !this$count.equals(other$count)) {
            return false;
        }
        Object this$records = this.getRecords();
        Object other$records = other.getRecords();
        if (this$records == null ? other$records != null : !this$records.equals(other$records)) {
            return false;
        }
        Object this$startTime = this.getStartTime();
        Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
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
        return other instanceof StatusCheckStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $completionTime = this.getCompletionTime();
        result = result * prime + ($completionTime == null ? 43 : $completionTime.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $count = this.getCount();
        result = result * prime + ($count == null ? 43 : $count.hashCode());
        Object $records = this.getRecords();
        result = result * prime + ($records == null ? 43 : $records.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatusCheckStatus(" + "completionTime=" + this.getCompletionTime() + ", conditions=" + this.getConditions() + ", count=" + this.getCount() + ", records=" + this.getRecords() + ", startTime=" + this.getStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
