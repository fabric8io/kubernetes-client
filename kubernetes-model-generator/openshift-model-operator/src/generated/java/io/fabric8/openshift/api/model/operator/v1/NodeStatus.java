
package io.fabric8.openshift.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "currentRevision",
    "lastFailedRevision",
    "lastFailedRevisionErrors",
    "nodeName",
    "targetRevision"
})
@ToString
@EqualsAndHashCode
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
public class NodeStatus implements KubernetesResource
{

    @JsonProperty("currentRevision")
    private Integer currentRevision;
    @JsonProperty("lastFailedRevision")
    private Integer lastFailedRevision;
    @JsonProperty("lastFailedRevisionErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> lastFailedRevisionErrors = new ArrayList<String>();
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("targetRevision")
    private Integer targetRevision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NodeStatus() {
    }

    /**
     * 
     * @param nodeName
     * @param currentRevision
     * @param lastFailedRevisionErrors
     * @param targetRevision
     * @param lastFailedRevision
     */
    public NodeStatus(Integer currentRevision, Integer lastFailedRevision, List<String> lastFailedRevisionErrors, String nodeName, Integer targetRevision) {
        super();
        this.currentRevision = currentRevision;
        this.lastFailedRevision = lastFailedRevision;
        this.lastFailedRevisionErrors = lastFailedRevisionErrors;
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

    @JsonProperty("lastFailedRevision")
    public Integer getLastFailedRevision() {
        return lastFailedRevision;
    }

    @JsonProperty("lastFailedRevision")
    public void setLastFailedRevision(Integer lastFailedRevision) {
        this.lastFailedRevision = lastFailedRevision;
    }

    @JsonProperty("lastFailedRevisionErrors")
    public List<String> getLastFailedRevisionErrors() {
        return lastFailedRevisionErrors;
    }

    @JsonProperty("lastFailedRevisionErrors")
    public void setLastFailedRevisionErrors(List<String> lastFailedRevisionErrors) {
        this.lastFailedRevisionErrors = lastFailedRevisionErrors;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
