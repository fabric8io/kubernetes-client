
package io.fabric8.knative.sources.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.Destination;
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
 * PingSourceSpec defines the desired state of the PingSource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ceOverrides",
    "contentType",
    "data",
    "dataBase64",
    "schedule",
    "sink",
    "timezone"
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
public class PingSourceSpec implements Editable<PingSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("data")
    private String data;
    @JsonProperty("dataBase64")
    private String dataBase64;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("sink")
    private Destination sink;
    @JsonProperty("timezone")
    private String timezone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PingSourceSpec() {
    }

    public PingSourceSpec(CloudEventOverrides ceOverrides, String contentType, String data, String dataBase64, String schedule, Destination sink, String timezone) {
        super();
        this.ceOverrides = ceOverrides;
        this.contentType = contentType;
        this.data = data;
        this.dataBase64 = dataBase64;
        this.schedule = schedule;
        this.sink = sink;
        this.timezone = timezone;
    }

    /**
     * PingSourceSpec defines the desired state of the PingSource.
     */
    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    /**
     * PingSourceSpec defines the desired state of the PingSource.
     */
    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    /**
     * ContentType is the media type of Data or DataBase64. Default is empty.
     */
    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    /**
     * ContentType is the media type of Data or DataBase64. Default is empty.
     */
    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Data is data used as the body of the event posted to the sink. Default is empty. Mutually exclusive with DataBase64.
     */
    @JsonProperty("data")
    public String getData() {
        return data;
    }

    /**
     * Data is data used as the body of the event posted to the sink. Default is empty. Mutually exclusive with DataBase64.
     */
    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    /**
     * DataBase64 is the base64-encoded string of the actual event's body posted to the sink. Default is empty. Mutually exclusive with Data.
     */
    @JsonProperty("dataBase64")
    public String getDataBase64() {
        return dataBase64;
    }

    /**
     * DataBase64 is the base64-encoded string of the actual event's body posted to the sink. Default is empty. Mutually exclusive with Data.
     */
    @JsonProperty("dataBase64")
    public void setDataBase64(String dataBase64) {
        this.dataBase64 = dataBase64;
    }

    /**
     * Schedule is the cron schedule. Defaults to `&#42; &#42; &#42; &#42; &#42;`.
     */
    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    /**
     * Schedule is the cron schedule. Defaults to `&#42; &#42; &#42; &#42; &#42;`.
     */
    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * PingSourceSpec defines the desired state of the PingSource.
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * PingSourceSpec defines the desired state of the PingSource.
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    /**
     * Timezone modifies the actual time relative to the specified timezone. Defaults to the system time zone. More general information about time zones: https://www.iana.org/time-zones List of valid timezone values: https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * Timezone modifies the actual time relative to the specified timezone. Defaults to the system time zone. More general information about time zones: https://www.iana.org/time-zones List of valid timezone values: https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonIgnore
    public PingSourceSpecBuilder edit() {
        return new PingSourceSpecBuilder(this);
    }

    @JsonIgnore
    public PingSourceSpecBuilder toBuilder() {
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
