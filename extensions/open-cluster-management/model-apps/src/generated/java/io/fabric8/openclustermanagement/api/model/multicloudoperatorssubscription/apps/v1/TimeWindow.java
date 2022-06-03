
package io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "daysofweek",
    "hours",
    "location",
    "windowtype"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class TimeWindow implements KubernetesResource
{

    @JsonProperty("daysofweek")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> daysofweek = new ArrayList<String>();
    @JsonProperty("hours")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HourRange> hours = new ArrayList<HourRange>();
    @JsonProperty("location")
    private String location;
    @JsonProperty("windowtype")
    private String windowtype;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeWindow() {
    }

    /**
     * 
     * @param hours
     * @param daysofweek
     * @param windowtype
     * @param location
     */
    public TimeWindow(List<String> daysofweek, List<HourRange> hours, String location, String windowtype) {
        super();
        this.daysofweek = daysofweek;
        this.hours = hours;
        this.location = location;
        this.windowtype = windowtype;
    }

    @JsonProperty("daysofweek")
    public List<String> getDaysofweek() {
        return daysofweek;
    }

    @JsonProperty("daysofweek")
    public void setDaysofweek(List<String> daysofweek) {
        this.daysofweek = daysofweek;
    }

    @JsonProperty("hours")
    public List<HourRange> getHours() {
        return hours;
    }

    @JsonProperty("hours")
    public void setHours(List<HourRange> hours) {
        this.hours = hours;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("windowtype")
    public String getWindowtype() {
        return windowtype;
    }

    @JsonProperty("windowtype")
    public void setWindowtype(String windowtype) {
        this.windowtype = windowtype;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
