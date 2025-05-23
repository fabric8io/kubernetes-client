
package io.fabric8.kubernetes.api.model.batch.v1;

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
 * UncountedTerminatedPods holds UIDs of Pods that have terminated but haven't been accounted in Job status counters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failed",
    "succeeded"
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
public class UncountedTerminatedPods implements Editable<UncountedTerminatedPodsBuilder>, KubernetesResource
{

    @JsonProperty("failed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failed = new ArrayList<>();
    @JsonProperty("succeeded")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> succeeded = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UncountedTerminatedPods() {
    }

    public UncountedTerminatedPods(List<String> failed, List<String> succeeded) {
        super();
        this.failed = failed;
        this.succeeded = succeeded;
    }

    /**
     * failed holds UIDs of failed Pods.
     */
    @JsonProperty("failed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailed() {
        return failed;
    }

    /**
     * failed holds UIDs of failed Pods.
     */
    @JsonProperty("failed")
    public void setFailed(List<String> failed) {
        this.failed = failed;
    }

    /**
     * succeeded holds UIDs of succeeded Pods.
     */
    @JsonProperty("succeeded")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSucceeded() {
        return succeeded;
    }

    /**
     * succeeded holds UIDs of succeeded Pods.
     */
    @JsonProperty("succeeded")
    public void setSucceeded(List<String> succeeded) {
        this.succeeded = succeeded;
    }

    @JsonIgnore
    public UncountedTerminatedPodsBuilder edit() {
        return new UncountedTerminatedPodsBuilder(this);
    }

    @JsonIgnore
    public UncountedTerminatedPodsBuilder toBuilder() {
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
