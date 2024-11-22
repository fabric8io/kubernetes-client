
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "daysOfMonth",
    "months",
    "times",
    "weekdays",
    "years"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class TimeInterval implements Editable<TimeIntervalBuilder> , KubernetesResource
{

    @JsonProperty("daysOfMonth")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DayOfMonthRange> daysOfMonth = new ArrayList<>();
    @JsonProperty("months")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> months = new ArrayList<>();
    @JsonProperty("times")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TimeRange> times = new ArrayList<>();
    @JsonProperty("weekdays")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> weekdays = new ArrayList<>();
    @JsonProperty("years")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> years = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeInterval() {
    }

    public TimeInterval(List<DayOfMonthRange> daysOfMonth, List<String> months, List<TimeRange> times, List<String> weekdays, List<String> years) {
        super();
        this.daysOfMonth = daysOfMonth;
        this.months = months;
        this.times = times;
        this.weekdays = weekdays;
        this.years = years;
    }

    @JsonProperty("daysOfMonth")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DayOfMonthRange> getDaysOfMonth() {
        return daysOfMonth;
    }

    @JsonProperty("daysOfMonth")
    public void setDaysOfMonth(List<DayOfMonthRange> daysOfMonth) {
        this.daysOfMonth = daysOfMonth;
    }

    @JsonProperty("months")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMonths() {
        return months;
    }

    @JsonProperty("months")
    public void setMonths(List<String> months) {
        this.months = months;
    }

    @JsonProperty("times")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TimeRange> getTimes() {
        return times;
    }

    @JsonProperty("times")
    public void setTimes(List<TimeRange> times) {
        this.times = times;
    }

    @JsonProperty("weekdays")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getWeekdays() {
        return weekdays;
    }

    @JsonProperty("weekdays")
    public void setWeekdays(List<String> weekdays) {
        this.weekdays = weekdays;
    }

    @JsonProperty("years")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getYears() {
        return years;
    }

    @JsonProperty("years")
    public void setYears(List<String> years) {
        this.years = years;
    }

    @JsonIgnore
    public TimeIntervalBuilder edit() {
        return new TimeIntervalBuilder(this);
    }

    @JsonIgnore
    public TimeIntervalBuilder toBuilder() {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
