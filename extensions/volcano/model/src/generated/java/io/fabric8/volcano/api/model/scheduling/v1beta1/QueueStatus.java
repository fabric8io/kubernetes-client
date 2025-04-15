
package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * QueueStatus represents the status of Queue.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocated",
    "completed",
    "inqueue",
    "pending",
    "reservation",
    "running",
    "state",
    "unknown"
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
public class QueueStatus implements Editable<QueueStatusBuilder>, KubernetesResource
{

    @JsonProperty("allocated")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocated = new LinkedHashMap<>();
    @JsonProperty("completed")
    private Integer completed;
    @JsonProperty("inqueue")
    private Integer inqueue;
    @JsonProperty("pending")
    private Integer pending;
    @JsonProperty("reservation")
    private Reservation reservation;
    @JsonProperty("running")
    private Integer running;
    @JsonProperty("state")
    private String state;
    @JsonProperty("unknown")
    private Integer unknown;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QueueStatus() {
    }

    public QueueStatus(Map<String, Quantity> allocated, Integer completed, Integer inqueue, Integer pending, Reservation reservation, Integer running, String state, Integer unknown) {
        super();
        this.allocated = allocated;
        this.completed = completed;
        this.inqueue = inqueue;
        this.pending = pending;
        this.reservation = reservation;
        this.running = running;
        this.state = state;
        this.unknown = unknown;
    }

    /**
     * Allocated is allocated resources in queue
     */
    @JsonProperty("allocated")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocated() {
        return allocated;
    }

    /**
     * Allocated is allocated resources in queue
     */
    @JsonProperty("allocated")
    public void setAllocated(Map<String, Quantity> allocated) {
        this.allocated = allocated;
    }

    /**
     * The number of `Completed` PodGroup in this queue.
     */
    @JsonProperty("completed")
    public Integer getCompleted() {
        return completed;
    }

    /**
     * The number of `Completed` PodGroup in this queue.
     */
    @JsonProperty("completed")
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    /**
     * The number of `Inqueue` PodGroup in this queue.
     */
    @JsonProperty("inqueue")
    public Integer getInqueue() {
        return inqueue;
    }

    /**
     * The number of `Inqueue` PodGroup in this queue.
     */
    @JsonProperty("inqueue")
    public void setInqueue(Integer inqueue) {
        this.inqueue = inqueue;
    }

    /**
     * The number of 'Pending' PodGroup in this queue.
     */
    @JsonProperty("pending")
    public Integer getPending() {
        return pending;
    }

    /**
     * The number of 'Pending' PodGroup in this queue.
     */
    @JsonProperty("pending")
    public void setPending(Integer pending) {
        this.pending = pending;
    }

    /**
     * QueueStatus represents the status of Queue.
     */
    @JsonProperty("reservation")
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * QueueStatus represents the status of Queue.
     */
    @JsonProperty("reservation")
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * The number of 'Running' PodGroup in this queue.
     */
    @JsonProperty("running")
    public Integer getRunning() {
        return running;
    }

    /**
     * The number of 'Running' PodGroup in this queue.
     */
    @JsonProperty("running")
    public void setRunning(Integer running) {
        this.running = running;
    }

    /**
     * State is state of queue
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * State is state of queue
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * The number of 'Unknown' PodGroup in this queue.
     */
    @JsonProperty("unknown")
    public Integer getUnknown() {
        return unknown;
    }

    /**
     * The number of 'Unknown' PodGroup in this queue.
     */
    @JsonProperty("unknown")
    public void setUnknown(Integer unknown) {
        this.unknown = unknown;
    }

    @JsonIgnore
    public QueueStatusBuilder edit() {
        return new QueueStatusBuilder(this);
    }

    @JsonIgnore
    public QueueStatusBuilder toBuilder() {
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
