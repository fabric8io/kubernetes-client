
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachineStatus defines the observed state of Machine
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "authoritativeAPI",
    "conditions",
    "errorMessage",
    "errorReason",
    "lastOperation",
    "lastUpdated",
    "nodeRef",
    "phase",
    "providerStatus",
    "synchronizedGeneration"
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
public class MachineStatus implements Editable<MachineStatusBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAddress> addresses = new ArrayList<>();
    @JsonProperty("authoritativeAPI")
    private String authoritativeAPI;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorReason")
    private String errorReason;
    @JsonProperty("lastOperation")
    private LastOperation lastOperation;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("nodeRef")
    private ObjectReference nodeRef;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object providerStatus;
    @JsonProperty("synchronizedGeneration")
    private Long synchronizedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineStatus() {
    }

    public MachineStatus(List<NodeAddress> addresses, String authoritativeAPI, List<Condition> conditions, String errorMessage, String errorReason, LastOperation lastOperation, String lastUpdated, ObjectReference nodeRef, String phase, Object providerStatus, Long synchronizedGeneration) {
        super();
        this.addresses = addresses;
        this.authoritativeAPI = authoritativeAPI;
        this.conditions = conditions;
        this.errorMessage = errorMessage;
        this.errorReason = errorReason;
        this.lastOperation = lastOperation;
        this.lastUpdated = lastUpdated;
        this.nodeRef = nodeRef;
        this.phase = phase;
        this.providerStatus = providerStatus;
        this.synchronizedGeneration = synchronizedGeneration;
    }

    /**
     * Addresses is a list of addresses assigned to the machine. Queried from cloud provider, if available.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    /**
     * Addresses is a list of addresses assigned to the machine. Queried from cloud provider, if available.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * authoritativeAPI is the API that is authoritative for this resource. Valid values are MachineAPI, ClusterAPI and Migrating. This value is updated by the migration controller to reflect the authoritative API. Machine API and Cluster API controllers use this value to determine whether or not to reconcile the resource. When set to Migrating, the migration controller is currently performing the handover of authority from one API to the other.
     */
    @JsonProperty("authoritativeAPI")
    public String getAuthoritativeAPI() {
        return authoritativeAPI;
    }

    /**
     * authoritativeAPI is the API that is authoritative for this resource. Valid values are MachineAPI, ClusterAPI and Migrating. This value is updated by the migration controller to reflect the authoritative API. Machine API and Cluster API controllers use this value to determine whether or not to reconcile the resource. When set to Migrating, the migration controller is currently performing the handover of authority from one API to the other.
     */
    @JsonProperty("authoritativeAPI")
    public void setAuthoritativeAPI(String authoritativeAPI) {
        this.authoritativeAPI = authoritativeAPI;
    }

    /**
     * Conditions defines the current state of the Machine
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines the current state of the Machine
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ErrorMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * ErrorMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * ErrorReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * ErrorReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("lastOperation")
    public LastOperation getLastOperation() {
        return lastOperation;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("lastOperation")
    public void setLastOperation(LastOperation lastOperation) {
        this.lastOperation = lastOperation;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("nodeRef")
    public ObjectReference getNodeRef() {
        return nodeRef;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("nodeRef")
    public void setNodeRef(ObjectReference nodeRef) {
        this.nodeRef = nodeRef;
    }

    /**
     * Phase represents the current phase of machine actuation. One of: Failed, Provisioning, Provisioned, Running, Deleting
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Phase represents the current phase of machine actuation. One of: Failed, Provisioning, Provisioned, Running, Deleting
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("providerStatus")
    public Object getProviderStatus() {
        return providerStatus;
    }

    /**
     * MachineStatus defines the observed state of Machine
     */
    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setProviderStatus(Object providerStatus) {
        this.providerStatus = providerStatus;
    }

    /**
     * synchronizedGeneration is the generation of the authoritative resource that the non-authoritative resource is synchronised with. This field is set when the authoritative resource is updated and the sync controller has updated the non-authoritative resource to match.
     */
    @JsonProperty("synchronizedGeneration")
    public Long getSynchronizedGeneration() {
        return synchronizedGeneration;
    }

    /**
     * synchronizedGeneration is the generation of the authoritative resource that the non-authoritative resource is synchronised with. This field is set when the authoritative resource is updated and the sync controller has updated the non-authoritative resource to match.
     */
    @JsonProperty("synchronizedGeneration")
    public void setSynchronizedGeneration(Long synchronizedGeneration) {
        this.synchronizedGeneration = synchronizedGeneration;
    }

    @JsonIgnore
    public MachineStatusBuilder edit() {
        return new MachineStatusBuilder(this);
    }

    @JsonIgnore
    public MachineStatusBuilder toBuilder() {
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
