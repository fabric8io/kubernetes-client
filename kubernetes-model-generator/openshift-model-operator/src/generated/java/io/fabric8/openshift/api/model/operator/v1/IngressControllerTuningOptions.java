
package io.fabric8.openshift.api.model.operator.v1;

import java.util.HashMap;
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
    "headerBufferBytes",
    "headerBufferMaxRewriteBytes",
    "threadCount"
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
public class IngressControllerTuningOptions implements KubernetesResource
{

    @JsonProperty("headerBufferBytes")
    private Integer headerBufferBytes;
    @JsonProperty("headerBufferMaxRewriteBytes")
    private Integer headerBufferMaxRewriteBytes;
    @JsonProperty("threadCount")
    private Integer threadCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerTuningOptions() {
    }

    /**
     * 
     * @param headerBufferBytes
     * @param threadCount
     * @param headerBufferMaxRewriteBytes
     */
    public IngressControllerTuningOptions(Integer headerBufferBytes, Integer headerBufferMaxRewriteBytes, Integer threadCount) {
        super();
        this.headerBufferBytes = headerBufferBytes;
        this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
        this.threadCount = threadCount;
    }

    @JsonProperty("headerBufferBytes")
    public Integer getHeaderBufferBytes() {
        return headerBufferBytes;
    }

    @JsonProperty("headerBufferBytes")
    public void setHeaderBufferBytes(Integer headerBufferBytes) {
        this.headerBufferBytes = headerBufferBytes;
    }

    @JsonProperty("headerBufferMaxRewriteBytes")
    public Integer getHeaderBufferMaxRewriteBytes() {
        return headerBufferMaxRewriteBytes;
    }

    @JsonProperty("headerBufferMaxRewriteBytes")
    public void setHeaderBufferMaxRewriteBytes(Integer headerBufferMaxRewriteBytes) {
        this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
    }

    @JsonProperty("threadCount")
    public Integer getThreadCount() {
        return threadCount;
    }

    @JsonProperty("threadCount")
    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
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
