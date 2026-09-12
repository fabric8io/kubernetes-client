
package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

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
 * OutageEntry records time period of an outage
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end",
    "endLogs",
    "message",
    "start",
    "startLogs"
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
public class OutageEntry implements Editable<OutageEntryBuilder>, KubernetesResource
{

    @JsonProperty("end")
    private String end;
    @JsonProperty("endLogs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LogEntry> endLogs = new ArrayList<>();
    @JsonProperty("message")
    private String message;
    @JsonProperty("start")
    private String start;
    @JsonProperty("startLogs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LogEntry> startLogs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OutageEntry() {
    }

    public OutageEntry(String end, List<LogEntry> endLogs, String message, String start, List<LogEntry> startLogs) {
        super();
        this.end = end;
        this.endLogs = endLogs;
        this.message = message;
        this.start = start;
        this.startLogs = startLogs;
    }

    /**
     * OutageEntry records time period of an outage
     */
    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    /**
     * OutageEntry records time period of an outage
     */
    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * endLogs contains log entries related to the end of this outage. Should contain the success entry that resolved the outage and possibly a few of the failure log entries that preceded it.
     */
    @JsonProperty("endLogs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getEndLogs() {
        return endLogs;
    }

    /**
     * endLogs contains log entries related to the end of this outage. Should contain the success entry that resolved the outage and possibly a few of the failure log entries that preceded it.
     */
    @JsonProperty("endLogs")
    public void setEndLogs(List<LogEntry> endLogs) {
        this.endLogs = endLogs;
    }

    /**
     * message summarizes outage details in a human readable format.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message summarizes outage details in a human readable format.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * OutageEntry records time period of an outage
     */
    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    /**
     * OutageEntry records time period of an outage
     */
    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * startLogs contains log entries related to the start of this outage. Should contain the original failure, any entries where the failure mode changed.
     */
    @JsonProperty("startLogs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getStartLogs() {
        return startLogs;
    }

    /**
     * startLogs contains log entries related to the start of this outage. Should contain the original failure, any entries where the failure mode changed.
     */
    @JsonProperty("startLogs")
    public void setStartLogs(List<LogEntry> startLogs) {
        this.startLogs = startLogs;
    }

    @JsonIgnore
    public OutageEntryBuilder edit() {
        return new OutageEntryBuilder(this);
    }

    @JsonIgnore
    public OutageEntryBuilder toBuilder() {
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
        if (!(o instanceof OutageEntry)) {
            return false;
        }
        OutageEntry other = (OutageEntry) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$end = this.getEnd();
        Object other$end = other.getEnd();
        if (this$end == null ? other$end != null : !this$end.equals(other$end)) {
            return false;
        }
        Object this$endLogs = this.getEndLogs();
        Object other$endLogs = other.getEndLogs();
        if (this$endLogs == null ? other$endLogs != null : !this$endLogs.equals(other$endLogs)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$start = this.getStart();
        Object other$start = other.getStart();
        if (this$start == null ? other$start != null : !this$start.equals(other$start)) {
            return false;
        }
        Object this$startLogs = this.getStartLogs();
        Object other$startLogs = other.getStartLogs();
        if (this$startLogs == null ? other$startLogs != null : !this$startLogs.equals(other$startLogs)) {
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
        return other instanceof OutageEntry;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $end = this.getEnd();
        result = result * prime + ($end == null ? 43 : $end.hashCode());
        Object $endLogs = this.getEndLogs();
        result = result * prime + ($endLogs == null ? 43 : $endLogs.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $start = this.getStart();
        result = result * prime + ($start == null ? 43 : $start.hashCode());
        Object $startLogs = this.getStartLogs();
        result = result * prime + ($startLogs == null ? 43 : $startLogs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OutageEntry(" + "end=" + this.getEnd() + ", endLogs=" + this.getEndLogs() + ", message=" + this.getMessage() + ", start=" + this.getStart() + ", startLogs=" + this.getStartLogs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
