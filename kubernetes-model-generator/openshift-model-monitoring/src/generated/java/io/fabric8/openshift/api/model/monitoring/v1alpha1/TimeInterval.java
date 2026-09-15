
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
 * TimeInterval describes intervals of time
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "daysOfMonth",
    "months",
    "times",
    "weekdays",
    "years"
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
public class TimeInterval implements Editable<TimeIntervalBuilder>, KubernetesResource
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

    /**
     * daysOfMonth defines a list of DayOfMonthRange
     */
    @JsonProperty("daysOfMonth")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DayOfMonthRange> getDaysOfMonth() {
        return daysOfMonth;
    }

    /**
     * daysOfMonth defines a list of DayOfMonthRange
     */
    @JsonProperty("daysOfMonth")
    public void setDaysOfMonth(List<DayOfMonthRange> daysOfMonth) {
        this.daysOfMonth = daysOfMonth;
    }

    /**
     * months defines a list of MonthRange
     */
    @JsonProperty("months")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMonths() {
        return months;
    }

    /**
     * months defines a list of MonthRange
     */
    @JsonProperty("months")
    public void setMonths(List<String> months) {
        this.months = months;
    }

    /**
     * times defines a list of TimeRange
     */
    @JsonProperty("times")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TimeRange> getTimes() {
        return times;
    }

    /**
     * times defines a list of TimeRange
     */
    @JsonProperty("times")
    public void setTimes(List<TimeRange> times) {
        this.times = times;
    }

    /**
     * weekdays defines a list of WeekdayRange
     */
    @JsonProperty("weekdays")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getWeekdays() {
        return weekdays;
    }

    /**
     * weekdays defines a list of WeekdayRange
     */
    @JsonProperty("weekdays")
    public void setWeekdays(List<String> weekdays) {
        this.weekdays = weekdays;
    }

    /**
     * years defines a list of YearRange
     */
    @JsonProperty("years")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getYears() {
        return years;
    }

    /**
     * years defines a list of YearRange
     */
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
        if (!(o instanceof TimeInterval)) {
            return false;
        }
        TimeInterval other = (TimeInterval) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$daysOfMonth = this.getDaysOfMonth();
        Object other$daysOfMonth = other.getDaysOfMonth();
        if (this$daysOfMonth == null ? other$daysOfMonth != null : !this$daysOfMonth.equals(other$daysOfMonth)) {
            return false;
        }
        Object this$months = this.getMonths();
        Object other$months = other.getMonths();
        if (this$months == null ? other$months != null : !this$months.equals(other$months)) {
            return false;
        }
        Object this$times = this.getTimes();
        Object other$times = other.getTimes();
        if (this$times == null ? other$times != null : !this$times.equals(other$times)) {
            return false;
        }
        Object this$weekdays = this.getWeekdays();
        Object other$weekdays = other.getWeekdays();
        if (this$weekdays == null ? other$weekdays != null : !this$weekdays.equals(other$weekdays)) {
            return false;
        }
        Object this$years = this.getYears();
        Object other$years = other.getYears();
        if (this$years == null ? other$years != null : !this$years.equals(other$years)) {
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
        return other instanceof TimeInterval;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $daysOfMonth = this.getDaysOfMonth();
        result = result * prime + ($daysOfMonth == null ? 43 : $daysOfMonth.hashCode());
        Object $months = this.getMonths();
        result = result * prime + ($months == null ? 43 : $months.hashCode());
        Object $times = this.getTimes();
        result = result * prime + ($times == null ? 43 : $times.hashCode());
        Object $weekdays = this.getWeekdays();
        result = result * prime + ($weekdays == null ? 43 : $weekdays.hashCode());
        Object $years = this.getYears();
        result = result * prime + ($years == null ? 43 : $years.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TimeInterval(" + "daysOfMonth=" + this.getDaysOfMonth() + ", months=" + this.getMonths() + ", times=" + this.getTimes() + ", weekdays=" + this.getWeekdays() + ", years=" + this.getYears() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
