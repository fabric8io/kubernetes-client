
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * AzureManagedMachinePoolStatus defines the observed state of AzureManagedMachinePool.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "errorMessage",
    "errorReason",
    "longRunningOperationStates",
    "ready",
    "replicas"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class AzureManagedMachinePoolStatus implements Editable<AzureManagedMachinePoolStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorReason")
    private String errorReason;
    @JsonProperty("longRunningOperationStates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Future> longRunningOperationStates = new ArrayList<>();
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureManagedMachinePoolStatus() {
    }

    public AzureManagedMachinePoolStatus(List<Condition> conditions, String errorMessage, String errorReason, List<Future> longRunningOperationStates, Boolean ready, Integer replicas) {
        super();
        this.conditions = conditions;
        this.errorMessage = errorMessage;
        this.errorReason = errorReason;
        this.longRunningOperationStates = longRunningOperationStates;
        this.ready = ready;
        this.replicas = replicas;
    }

    /**
     * Conditions defines current service state of the AzureManagedControlPlane.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines current service state of the AzureManagedControlPlane.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    /**
     * LongRunningOperationStates saves the states for Azure long-running operations so they can be continued on the next reconciliation loop.
     */
    @JsonProperty("longRunningOperationStates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Future> getLongRunningOperationStates() {
        return longRunningOperationStates;
    }

    /**
     * LongRunningOperationStates saves the states for Azure long-running operations so they can be continued on the next reconciliation loop.
     */
    @JsonProperty("longRunningOperationStates")
    public void setLongRunningOperationStates(List<Future> longRunningOperationStates) {
        this.longRunningOperationStates = longRunningOperationStates;
    }

    /**
     * Ready is true when the provider resource is ready.
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * Ready is true when the provider resource is ready.
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    /**
     * Replicas is the most recently observed number of replicas.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the most recently observed number of replicas.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonIgnore
    public AzureManagedMachinePoolStatusBuilder edit() {
        return new AzureManagedMachinePoolStatusBuilder(this);
    }

    @JsonIgnore
    public AzureManagedMachinePoolStatusBuilder toBuilder() {
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
