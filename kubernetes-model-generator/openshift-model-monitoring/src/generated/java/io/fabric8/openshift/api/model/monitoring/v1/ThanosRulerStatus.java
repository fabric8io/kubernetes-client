
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * ThanosRulerStatus is the most recent observed status of the ThanosRuler. Read-only. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "conditions",
    "paused",
    "replicas",
    "unavailableReplicas",
    "updatedReplicas"
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
public class ThanosRulerStatus implements Editable<ThanosRulerStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("unavailableReplicas")
    private Integer unavailableReplicas;
    @JsonProperty("updatedReplicas")
    private Integer updatedReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ThanosRulerStatus() {
    }

    public ThanosRulerStatus(Integer availableReplicas, List<Condition> conditions, Boolean paused, Integer replicas, Integer unavailableReplicas, Integer updatedReplicas) {
        super();
        this.availableReplicas = availableReplicas;
        this.conditions = conditions;
        this.paused = paused;
        this.replicas = replicas;
        this.unavailableReplicas = unavailableReplicas;
        this.updatedReplicas = updatedReplicas;
    }

    /**
     * Total number of available pods (ready for at least minReadySeconds) targeted by this ThanosRuler deployment.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * Total number of available pods (ready for at least minReadySeconds) targeted by this ThanosRuler deployment.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * The current state of the ThanosRuler object.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * The current state of the ThanosRuler object.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Represents whether any actions on the underlying managed objects are being performed. Only delete actions will be performed.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * Represents whether any actions on the underlying managed objects are being performed. Only delete actions will be performed.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * Total number of non-terminated pods targeted by this ThanosRuler deployment (their labels match the selector).
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Total number of non-terminated pods targeted by this ThanosRuler deployment (their labels match the selector).
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * Total number of unavailable pods targeted by this ThanosRuler deployment.
     */
    @JsonProperty("unavailableReplicas")
    public Integer getUnavailableReplicas() {
        return unavailableReplicas;
    }

    /**
     * Total number of unavailable pods targeted by this ThanosRuler deployment.
     */
    @JsonProperty("unavailableReplicas")
    public void setUnavailableReplicas(Integer unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
    }

    /**
     * Total number of non-terminated pods targeted by this ThanosRuler deployment that have the desired version spec.
     */
    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    /**
     * Total number of non-terminated pods targeted by this ThanosRuler deployment that have the desired version spec.
     */
    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    @JsonIgnore
    public ThanosRulerStatusBuilder edit() {
        return new ThanosRulerStatusBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerStatusBuilder toBuilder() {
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
