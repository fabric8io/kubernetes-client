
package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
 * PodGroupStatus represents the current state of a pod group.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "failed",
    "phase",
    "running",
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
public class PodGroupStatus implements Editable<PodGroupStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodGroupCondition> conditions = new ArrayList<>();
    @JsonProperty("failed")
    private Integer failed;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("running")
    private Integer running;
    @JsonProperty("succeeded")
    private Integer succeeded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodGroupStatus() {
    }

    public PodGroupStatus(List<PodGroupCondition> conditions, Integer failed, String phase, Integer running, Integer succeeded) {
        super();
        this.conditions = conditions;
        this.failed = failed;
        this.phase = phase;
        this.running = running;
        this.succeeded = succeeded;
    }

    /**
     * The conditions of PodGroup.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodGroupCondition> getConditions() {
        return conditions;
    }

    /**
     * The conditions of PodGroup.
     */
    @JsonProperty("conditions")
    public void setConditions(List<PodGroupCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The number of pods which reached phase Failed.
     */
    @JsonProperty("failed")
    public Integer getFailed() {
        return failed;
    }

    /**
     * The number of pods which reached phase Failed.
     */
    @JsonProperty("failed")
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * Current phase of PodGroup.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Current phase of PodGroup.
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * The number of actively running pods.
     */
    @JsonProperty("running")
    public Integer getRunning() {
        return running;
    }

    /**
     * The number of actively running pods.
     */
    @JsonProperty("running")
    public void setRunning(Integer running) {
        this.running = running;
    }

    /**
     * The number of pods which reached phase Succeeded.
     */
    @JsonProperty("succeeded")
    public Integer getSucceeded() {
        return succeeded;
    }

    /**
     * The number of pods which reached phase Succeeded.
     */
    @JsonProperty("succeeded")
    public void setSucceeded(Integer succeeded) {
        this.succeeded = succeeded;
    }

    @JsonIgnore
    public PodGroupStatusBuilder edit() {
        return new PodGroupStatusBuilder(this);
    }

    @JsonIgnore
    public PodGroupStatusBuilder toBuilder() {
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
