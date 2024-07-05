
package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end",
    "endLogs",
    "message",
    "start",
    "startLogs"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class OutageEntry implements Editable<OutageEntryBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    @JsonProperty("endLogs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getEndLogs() {
        return endLogs;
    }

    @JsonProperty("endLogs")
    public void setEndLogs(List<LogEntry> endLogs) {
        this.endLogs = endLogs;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    @JsonProperty("startLogs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getStartLogs() {
        return startLogs;
    }

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
