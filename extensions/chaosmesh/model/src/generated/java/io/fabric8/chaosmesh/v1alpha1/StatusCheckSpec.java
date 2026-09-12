
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
public class StatusCheckSpec implements Editable<StatusCheckSpecBuilder>, KubernetesResource
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
    public StatusCheckSpec() {
    }

    public StatusCheckSpec(String duration, Integer failureThreshold, HTTPStatusCheck http, Integer intervalSeconds, String mode, Integer recordsHistoryLimit, Integer successThreshold, Integer timeoutSeconds, String type) {
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

    @JsonProperty("http")
    public HTTPStatusCheck getHttp() {
        return http;
    }

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
    public StatusCheckSpecBuilder edit() {
        return new StatusCheckSpecBuilder(this);
    }

    @JsonIgnore
    public StatusCheckSpecBuilder toBuilder() {
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
        if (!(o instanceof StatusCheckSpec)) {
            return false;
        }
        StatusCheckSpec other = (StatusCheckSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$failureThreshold = this.getFailureThreshold();
        Object other$failureThreshold = other.getFailureThreshold();
        if (this$failureThreshold == null ? other$failureThreshold != null : !this$failureThreshold.equals(other$failureThreshold)) {
            return false;
        }
        Object this$http = this.getHttp();
        Object other$http = other.getHttp();
        if (this$http == null ? other$http != null : !this$http.equals(other$http)) {
            return false;
        }
        Object this$intervalSeconds = this.getIntervalSeconds();
        Object other$intervalSeconds = other.getIntervalSeconds();
        if (this$intervalSeconds == null ? other$intervalSeconds != null : !this$intervalSeconds.equals(other$intervalSeconds)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$recordsHistoryLimit = this.getRecordsHistoryLimit();
        Object other$recordsHistoryLimit = other.getRecordsHistoryLimit();
        if (this$recordsHistoryLimit == null ? other$recordsHistoryLimit != null : !this$recordsHistoryLimit.equals(other$recordsHistoryLimit)) {
            return false;
        }
        Object this$successThreshold = this.getSuccessThreshold();
        Object other$successThreshold = other.getSuccessThreshold();
        if (this$successThreshold == null ? other$successThreshold != null : !this$successThreshold.equals(other$successThreshold)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof StatusCheckSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $failureThreshold = this.getFailureThreshold();
        result = result * prime + ($failureThreshold == null ? 43 : $failureThreshold.hashCode());
        Object $http = this.getHttp();
        result = result * prime + ($http == null ? 43 : $http.hashCode());
        Object $intervalSeconds = this.getIntervalSeconds();
        result = result * prime + ($intervalSeconds == null ? 43 : $intervalSeconds.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $recordsHistoryLimit = this.getRecordsHistoryLimit();
        result = result * prime + ($recordsHistoryLimit == null ? 43 : $recordsHistoryLimit.hashCode());
        Object $successThreshold = this.getSuccessThreshold();
        result = result * prime + ($successThreshold == null ? 43 : $successThreshold.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatusCheckSpec(" + "duration=" + this.getDuration() + ", failureThreshold=" + this.getFailureThreshold() + ", http=" + this.getHttp() + ", intervalSeconds=" + this.getIntervalSeconds() + ", mode=" + this.getMode() + ", recordsHistoryLimit=" + this.getRecordsHistoryLimit() + ", successThreshold=" + this.getSuccessThreshold() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
