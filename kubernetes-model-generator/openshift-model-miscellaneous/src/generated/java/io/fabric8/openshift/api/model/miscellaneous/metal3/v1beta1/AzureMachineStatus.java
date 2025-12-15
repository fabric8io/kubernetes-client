
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.NodeAddress;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1.Condition;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureMachineStatus defines the observed state of AzureMachine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "conditions",
    "failureMessage",
    "failureReason",
    "longRunningOperationStates",
    "ready",
    "vmState"
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
public class AzureMachineStatus implements Editable<AzureMachineStatusBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAddress> addresses = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("failureMessage")
    private String failureMessage;
    @JsonProperty("failureReason")
    private String failureReason;
    @JsonProperty("longRunningOperationStates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Future> longRunningOperationStates = new ArrayList<>();
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("vmState")
    private String vmState;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureMachineStatus() {
    }

    public AzureMachineStatus(List<NodeAddress> addresses, List<Condition> conditions, String failureMessage, String failureReason, List<Future> longRunningOperationStates, Boolean ready, String vmState) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.longRunningOperationStates = longRunningOperationStates;
        this.ready = ready;
        this.vmState = vmState;
    }

    /**
     * Addresses contains the Azure instance associated addresses.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    /**
     * Addresses contains the Azure instance associated addresses.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * Conditions defines current service state of the AzureMachine.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines current service state of the AzureMachine.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ErrorMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    /**
     * ErrorMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    /**
     * ErrorReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * ErrorReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
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
     * VMState is the provisioning state of the Azure virtual machine.
     */
    @JsonProperty("vmState")
    public String getVmState() {
        return vmState;
    }

    /**
     * VMState is the provisioning state of the Azure virtual machine.
     */
    @JsonProperty("vmState")
    public void setVmState(String vmState) {
        this.vmState = vmState;
    }

    @JsonIgnore
    public AzureMachineStatusBuilder edit() {
        return new AzureMachineStatusBuilder(this);
    }

    @JsonIgnore
    public AzureMachineStatusBuilder toBuilder() {
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
