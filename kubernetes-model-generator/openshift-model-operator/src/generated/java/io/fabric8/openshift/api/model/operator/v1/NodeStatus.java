
package io.fabric8.openshift.api.model.operator.v1;

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
    "currentRevision",
    "lastFailedCount",
    "lastFailedReason",
    "lastFailedRevision",
    "lastFailedRevisionErrors",
    "lastFailedTime",
    "lastFallbackCount",
    "nodeName",
    "targetRevision"
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
public class NodeStatus implements Editable<NodeStatusBuilder> , KubernetesResource
{

    @JsonProperty("currentRevision")
    private Integer currentRevision;
    @JsonProperty("lastFailedCount")
    private Integer lastFailedCount;
    @JsonProperty("lastFailedReason")
    private String lastFailedReason;
    @JsonProperty("lastFailedRevision")
    private Integer lastFailedRevision;
    @JsonProperty("lastFailedRevisionErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> lastFailedRevisionErrors = new ArrayList<>();
    @JsonProperty("lastFailedTime")
    private String lastFailedTime;
    @JsonProperty("lastFallbackCount")
    private Integer lastFallbackCount;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("targetRevision")
    private Integer targetRevision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NodeStatus() {
    }

    public NodeStatus(Integer currentRevision, Integer lastFailedCount, String lastFailedReason, Integer lastFailedRevision, List<String> lastFailedRevisionErrors, String lastFailedTime, Integer lastFallbackCount, String nodeName, Integer targetRevision) {
        super();
        this.currentRevision = currentRevision;
        this.lastFailedCount = lastFailedCount;
        this.lastFailedReason = lastFailedReason;
        this.lastFailedRevision = lastFailedRevision;
        this.lastFailedRevisionErrors = lastFailedRevisionErrors;
        this.lastFailedTime = lastFailedTime;
        this.lastFallbackCount = lastFallbackCount;
        this.nodeName = nodeName;
        this.targetRevision = targetRevision;
    }

    @JsonProperty("currentRevision")
    public Integer getCurrentRevision() {
        return currentRevision;
    }

    @JsonProperty("currentRevision")
    public void setCurrentRevision(Integer currentRevision) {
        this.currentRevision = currentRevision;
    }

    @JsonProperty("lastFailedCount")
    public Integer getLastFailedCount() {
        return lastFailedCount;
    }

    @JsonProperty("lastFailedCount")
    public void setLastFailedCount(Integer lastFailedCount) {
        this.lastFailedCount = lastFailedCount;
    }

    @JsonProperty("lastFailedReason")
    public String getLastFailedReason() {
        return lastFailedReason;
    }

    @JsonProperty("lastFailedReason")
    public void setLastFailedReason(String lastFailedReason) {
        this.lastFailedReason = lastFailedReason;
    }

    @JsonProperty("lastFailedRevision")
    public Integer getLastFailedRevision() {
        return lastFailedRevision;
    }

    @JsonProperty("lastFailedRevision")
    public void setLastFailedRevision(Integer lastFailedRevision) {
        this.lastFailedRevision = lastFailedRevision;
    }

    @JsonProperty("lastFailedRevisionErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLastFailedRevisionErrors() {
        return lastFailedRevisionErrors;
    }

    @JsonProperty("lastFailedRevisionErrors")
    public void setLastFailedRevisionErrors(List<String> lastFailedRevisionErrors) {
        this.lastFailedRevisionErrors = lastFailedRevisionErrors;
    }

    @JsonProperty("lastFailedTime")
    public String getLastFailedTime() {
        return lastFailedTime;
    }

    @JsonProperty("lastFailedTime")
    public void setLastFailedTime(String lastFailedTime) {
        this.lastFailedTime = lastFailedTime;
    }

    @JsonProperty("lastFallbackCount")
    public Integer getLastFallbackCount() {
        return lastFallbackCount;
    }

    @JsonProperty("lastFallbackCount")
    public void setLastFallbackCount(Integer lastFallbackCount) {
        this.lastFallbackCount = lastFallbackCount;
    }

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("targetRevision")
    public Integer getTargetRevision() {
        return targetRevision;
    }

    @JsonProperty("targetRevision")
    public void setTargetRevision(Integer targetRevision) {
        this.targetRevision = targetRevision;
    }

    @JsonIgnore
    public NodeStatusBuilder edit() {
        return new NodeStatusBuilder(this);
    }

    @JsonIgnore
    public NodeStatusBuilder toBuilder() {
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
