
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TimeWindow defines a time window for the subscription to run or be blocked
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "daysofweek",
    "hours",
    "location",
    "windowtype"
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
public class TimeWindow implements Editable<TimeWindowBuilder>, KubernetesResource
{

    @JsonProperty("daysofweek")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> daysofweek = new ArrayList<>();
    @JsonProperty("hours")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HourRange> hours = new ArrayList<>();
    @JsonProperty("location")
    private String location;
    @JsonProperty("windowtype")
    private String windowtype;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TimeWindow() {
    }

    public TimeWindow(List<String> daysofweek, List<HourRange> hours, String location, String windowtype) {
        super();
        this.daysofweek = daysofweek;
        this.hours = hours;
        this.location = location;
        this.windowtype = windowtype;
    }

    /**
     * A list of days of a week, valid values include: Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
     */
    @JsonProperty("daysofweek")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDaysofweek() {
        return daysofweek;
    }

    /**
     * A list of days of a week, valid values include: Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
     */
    @JsonProperty("daysofweek")
    public void setDaysofweek(List<String> daysofweek) {
        this.daysofweek = daysofweek;
    }

    /**
     * A list of hour ranges
     */
    @JsonProperty("hours")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HourRange> getHours() {
        return hours;
    }

    /**
     * A list of hour ranges
     */
    @JsonProperty("hours")
    public void setHours(List<HourRange> hours) {
        this.hours = hours;
    }

    /**
     * time zone location, refer to TZ identifier in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * time zone location, refer to TZ identifier in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Activiate time window or not. The subscription deployment will only be handled during these active windows Valid values include: active,blocked,Active,Blocked
     */
    @JsonProperty("windowtype")
    public String getWindowtype() {
        return windowtype;
    }

    /**
     * Activiate time window or not. The subscription deployment will only be handled during these active windows Valid values include: active,blocked,Active,Blocked
     */
    @JsonProperty("windowtype")
    public void setWindowtype(String windowtype) {
        this.windowtype = windowtype;
    }

    @JsonIgnore
    public TimeWindowBuilder edit() {
        return new TimeWindowBuilder(this);
    }

    @JsonIgnore
    public TimeWindowBuilder toBuilder() {
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

}
