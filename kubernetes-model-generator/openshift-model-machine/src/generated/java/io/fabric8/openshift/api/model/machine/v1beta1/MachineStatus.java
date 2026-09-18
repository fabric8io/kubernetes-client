
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
     * addresses is a list of addresses assigned to the machine. Queried from cloud provider, if available.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    /**
     * addresses is a list of addresses assigned to the machine. Queried from cloud provider, if available.
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
     * conditions defines the current state of the Machine
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines the current state of the Machine
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * errorMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * errorMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * errorReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * errorReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.
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
     * phase represents the current phase of machine actuation. One of: Failed, Provisioning, Provisioned, Running, Deleting
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * phase represents the current phase of machine actuation. One of: Failed, Provisioning, Provisioned, Running, Deleting
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachineStatus)) {
            return false;
        }
        MachineStatus other = (MachineStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addresses = this.getAddresses();
        Object other$addresses = other.getAddresses();
        if (this$addresses == null ? other$addresses != null : !this$addresses.equals(other$addresses)) {
            return false;
        }
        Object this$authoritativeAPI = this.getAuthoritativeAPI();
        Object other$authoritativeAPI = other.getAuthoritativeAPI();
        if (this$authoritativeAPI == null ? other$authoritativeAPI != null : !this$authoritativeAPI.equals(other$authoritativeAPI)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$errorMessage = this.getErrorMessage();
        Object other$errorMessage = other.getErrorMessage();
        if (this$errorMessage == null ? other$errorMessage != null : !this$errorMessage.equals(other$errorMessage)) {
            return false;
        }
        Object this$errorReason = this.getErrorReason();
        Object other$errorReason = other.getErrorReason();
        if (this$errorReason == null ? other$errorReason != null : !this$errorReason.equals(other$errorReason)) {
            return false;
        }
        Object this$lastOperation = this.getLastOperation();
        Object other$lastOperation = other.getLastOperation();
        if (this$lastOperation == null ? other$lastOperation != null : !this$lastOperation.equals(other$lastOperation)) {
            return false;
        }
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$nodeRef = this.getNodeRef();
        Object other$nodeRef = other.getNodeRef();
        if (this$nodeRef == null ? other$nodeRef != null : !this$nodeRef.equals(other$nodeRef)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$providerStatus = this.getProviderStatus();
        Object other$providerStatus = other.getProviderStatus();
        if (this$providerStatus == null ? other$providerStatus != null : !this$providerStatus.equals(other$providerStatus)) {
            return false;
        }
        Object this$synchronizedGeneration = this.getSynchronizedGeneration();
        Object other$synchronizedGeneration = other.getSynchronizedGeneration();
        if (this$synchronizedGeneration == null ? other$synchronizedGeneration != null : !this$synchronizedGeneration.equals(other$synchronizedGeneration)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof MachineStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addresses = this.getAddresses();
        result = result * prime + ($addresses == null ? 43 : $addresses.hashCode());
        Object $authoritativeAPI = this.getAuthoritativeAPI();
        result = result * prime + ($authoritativeAPI == null ? 43 : $authoritativeAPI.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $errorMessage = this.getErrorMessage();
        result = result * prime + ($errorMessage == null ? 43 : $errorMessage.hashCode());
        Object $errorReason = this.getErrorReason();
        result = result * prime + ($errorReason == null ? 43 : $errorReason.hashCode());
        Object $lastOperation = this.getLastOperation();
        result = result * prime + ($lastOperation == null ? 43 : $lastOperation.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $nodeRef = this.getNodeRef();
        result = result * prime + ($nodeRef == null ? 43 : $nodeRef.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $providerStatus = this.getProviderStatus();
        result = result * prime + ($providerStatus == null ? 43 : $providerStatus.hashCode());
        Object $synchronizedGeneration = this.getSynchronizedGeneration();
        result = result * prime + ($synchronizedGeneration == null ? 43 : $synchronizedGeneration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineStatus(" + "addresses=" + this.getAddresses() + ", authoritativeAPI=" + this.getAuthoritativeAPI() + ", conditions=" + this.getConditions() + ", errorMessage=" + this.getErrorMessage() + ", errorReason=" + this.getErrorReason() + ", lastOperation=" + this.getLastOperation() + ", lastUpdated=" + this.getLastUpdated() + ", nodeRef=" + this.getNodeRef() + ", phase=" + this.getPhase() + ", providerStatus=" + this.getProviderStatus() + ", synchronizedGeneration=" + this.getSynchronizedGeneration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
