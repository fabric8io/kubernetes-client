
package io.fabric8.chaosmesh.v1alpha1;

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
 * StatusCheckTemplate represents a template of status check. A statusCheckTemplate would save in the ConfigMap named `template-status-check-&lt;template-name&gt;`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "failureThreshold",
    "http",
    "intervalSeconds",
    "mode",
    "recordsHistoryLimit",
    "successThreshold",
    "timeoutSeconds",
    "type"
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
public class StatusCheckTemplate implements Editable<StatusCheckTemplateBuilder>, KubernetesResource
{

    @JsonProperty("duration")
    private String duration;
    @JsonProperty("failureThreshold")
    private Integer failureThreshold;
    @JsonProperty("http")
    private HTTPStatusCheck http;
    @JsonProperty("intervalSeconds")
    private Integer intervalSeconds;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("recordsHistoryLimit")
    private Integer recordsHistoryLimit;
    @JsonProperty("successThreshold")
    private Integer successThreshold;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatusCheckTemplate() {
    }

    public StatusCheckTemplate(String duration, Integer failureThreshold, HTTPStatusCheck http, Integer intervalSeconds, String mode, Integer recordsHistoryLimit, Integer successThreshold, Integer timeoutSeconds, String type) {
        super();
        this.duration = duration;
        this.failureThreshold = failureThreshold;
        this.http = http;
        this.intervalSeconds = intervalSeconds;
        this.mode = mode;
        this.recordsHistoryLimit = recordsHistoryLimit;
        this.successThreshold = successThreshold;
        this.timeoutSeconds = timeoutSeconds;
        this.type = type;
    }

    /**
     * Duration defines the duration of the whole status check if the number of failed execution does not exceed the failure threshold. Duration is available to both `Synchronous` and `Continuous` mode. A duration string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "-1.5h" or "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration defines the duration of the whole status check if the number of failed execution does not exceed the failure threshold. Duration is available to both `Synchronous` and `Continuous` mode. A duration string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "-1.5h" or "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * FailureThreshold defines the minimum consecutive failure for the status check to be considered failed.
     */
    @JsonProperty("failureThreshold")
    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    /**
     * FailureThreshold defines the minimum consecutive failure for the status check to be considered failed.
     */
    @JsonProperty("failureThreshold")
    public void setFailureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    /**
     * StatusCheckTemplate represents a template of status check. A statusCheckTemplate would save in the ConfigMap named `template-status-check-&lt;template-name&gt;`.
     */
    @JsonProperty("http")
    public HTTPStatusCheck getHttp() {
        return http;
    }

    /**
     * StatusCheckTemplate represents a template of status check. A statusCheckTemplate would save in the ConfigMap named `template-status-check-&lt;template-name&gt;`.
     */
    @JsonProperty("http")
    public void setHttp(HTTPStatusCheck http) {
        this.http = http;
    }

    /**
     * IntervalSeconds defines how often (in seconds) to perform an execution of status check.
     */
    @JsonProperty("intervalSeconds")
    public Integer getIntervalSeconds() {
        return intervalSeconds;
    }

    /**
     * IntervalSeconds defines how often (in seconds) to perform an execution of status check.
     */
    @JsonProperty("intervalSeconds")
    public void setIntervalSeconds(Integer intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    /**
     * Mode defines the execution mode of the status check. Support type: Synchronous / Continuous
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the execution mode of the status check. Support type: Synchronous / Continuous
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * RecordsHistoryLimit defines the number of record to retain.
     */
    @JsonProperty("recordsHistoryLimit")
    public Integer getRecordsHistoryLimit() {
        return recordsHistoryLimit;
    }

    /**
     * RecordsHistoryLimit defines the number of record to retain.
     */
    @JsonProperty("recordsHistoryLimit")
    public void setRecordsHistoryLimit(Integer recordsHistoryLimit) {
        this.recordsHistoryLimit = recordsHistoryLimit;
    }

    /**
     * SuccessThreshold defines the minimum consecutive successes for the status check to be considered successful. SuccessThreshold only works for `Synchronous` mode.
     */
    @JsonProperty("successThreshold")
    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    /**
     * SuccessThreshold defines the minimum consecutive successes for the status check to be considered successful. SuccessThreshold only works for `Synchronous` mode.
     */
    @JsonProperty("successThreshold")
    public void setSuccessThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
    }

    /**
     * TimeoutSeconds defines the number of seconds after which an execution of status check times out.
     */
    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * TimeoutSeconds defines the number of seconds after which an execution of status check times out.
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * Type defines the specific status check type. Support type: HTTP
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the specific status check type. Support type: HTTP
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public StatusCheckTemplateBuilder edit() {
        return new StatusCheckTemplateBuilder(this);
    }

    @JsonIgnore
    public StatusCheckTemplateBuilder toBuilder() {
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
