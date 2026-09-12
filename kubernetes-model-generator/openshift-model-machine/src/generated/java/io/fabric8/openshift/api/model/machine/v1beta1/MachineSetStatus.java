
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachineSetStatus defines the observed state of MachineSet
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authoritativeAPI",
    "availableReplicas",
    "conditions",
    "errorMessage",
    "errorReason",
    "fullyLabeledReplicas",
    "observedGeneration",
    "readyReplicas",
    "replicas",
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
public class MachineSetStatus implements Editable<MachineSetStatusBuilder>, KubernetesResource
{

    @JsonProperty("authoritativeAPI")
    private String authoritativeAPI;
    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorReason")
    private String errorReason;
    @JsonProperty("fullyLabeledReplicas")
    private Integer fullyLabeledReplicas;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("synchronizedGeneration")
    private Long synchronizedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSetStatus() {
    }

    public MachineSetStatus(String authoritativeAPI, Integer availableReplicas, List<Condition> conditions, String errorMessage, String errorReason, Integer fullyLabeledReplicas, Long observedGeneration, Integer readyReplicas, Integer replicas, Long synchronizedGeneration) {
        super();
        this.authoritativeAPI = authoritativeAPI;
        this.availableReplicas = availableReplicas;
        this.conditions = conditions;
        this.errorMessage = errorMessage;
        this.errorReason = errorReason;
        this.fullyLabeledReplicas = fullyLabeledReplicas;
        this.observedGeneration = observedGeneration;
        this.readyReplicas = readyReplicas;
        this.replicas = replicas;
        this.synchronizedGeneration = synchronizedGeneration;
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
     * The number of available replicas (ready for at least minReadySeconds) for this MachineSet.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * The number of available replicas (ready for at least minReadySeconds) for this MachineSet.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * conditions defines the current state of the MachineSet
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines the current state of the MachineSet
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * MachineSetStatus defines the observed state of MachineSet
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * MachineSetStatus defines the observed state of MachineSet
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * In the event that there is a terminal problem reconciling the replicas, both ErrorReason and ErrorMessage will be set. ErrorReason will be populated with a succinct value suitable for machine interpretation, while ErrorMessage will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> These fields should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the MachineTemplate's spec or the configuration of the machine controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the machine controller, or the responsible machine controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the MachineSet object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * In the event that there is a terminal problem reconciling the replicas, both ErrorReason and ErrorMessage will be set. ErrorReason will be populated with a succinct value suitable for machine interpretation, while ErrorMessage will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> These fields should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the MachineTemplate's spec or the configuration of the machine controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the machine controller, or the responsible machine controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the MachineSet object and/or logged in the controller's output.
     */
    @JsonProperty("errorReason")
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    /**
     * The number of replicas that have labels matching the labels of the machine template of the MachineSet.
     */
    @JsonProperty("fullyLabeledReplicas")
    public Integer getFullyLabeledReplicas() {
        return fullyLabeledReplicas;
    }

    /**
     * The number of replicas that have labels matching the labels of the machine template of the MachineSet.
     */
    @JsonProperty("fullyLabeledReplicas")
    public void setFullyLabeledReplicas(Integer fullyLabeledReplicas) {
        this.fullyLabeledReplicas = fullyLabeledReplicas;
    }

    /**
     * observedGeneration reflects the generation of the most recently observed MachineSet.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration reflects the generation of the most recently observed MachineSet.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * The number of ready replicas for this MachineSet. A machine is considered ready when the node has been created and is "Ready".
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * The number of ready replicas for this MachineSet. A machine is considered ready when the node has been created and is "Ready".
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * replicas is the most recently observed number of replicas.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the most recently observed number of replicas.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
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
    public MachineSetStatusBuilder edit() {
        return new MachineSetStatusBuilder(this);
    }

    @JsonIgnore
    public MachineSetStatusBuilder toBuilder() {
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
        if (!(o instanceof MachineSetStatus)) {
            return false;
        }
        MachineSetStatus other = (MachineSetStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authoritativeAPI = this.getAuthoritativeAPI();
        Object other$authoritativeAPI = other.getAuthoritativeAPI();
        if (this$authoritativeAPI == null ? other$authoritativeAPI != null : !this$authoritativeAPI.equals(other$authoritativeAPI)) {
            return false;
        }
        Object this$availableReplicas = this.getAvailableReplicas();
        Object other$availableReplicas = other.getAvailableReplicas();
        if (this$availableReplicas == null ? other$availableReplicas != null : !this$availableReplicas.equals(other$availableReplicas)) {
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
        Object this$fullyLabeledReplicas = this.getFullyLabeledReplicas();
        Object other$fullyLabeledReplicas = other.getFullyLabeledReplicas();
        if (this$fullyLabeledReplicas == null ? other$fullyLabeledReplicas != null : !this$fullyLabeledReplicas.equals(other$fullyLabeledReplicas)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$readyReplicas = this.getReadyReplicas();
        Object other$readyReplicas = other.getReadyReplicas();
        if (this$readyReplicas == null ? other$readyReplicas != null : !this$readyReplicas.equals(other$readyReplicas)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
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
        return other instanceof MachineSetStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authoritativeAPI = this.getAuthoritativeAPI();
        result = result * prime + ($authoritativeAPI == null ? 43 : $authoritativeAPI.hashCode());
        Object $availableReplicas = this.getAvailableReplicas();
        result = result * prime + ($availableReplicas == null ? 43 : $availableReplicas.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $errorMessage = this.getErrorMessage();
        result = result * prime + ($errorMessage == null ? 43 : $errorMessage.hashCode());
        Object $errorReason = this.getErrorReason();
        result = result * prime + ($errorReason == null ? 43 : $errorReason.hashCode());
        Object $fullyLabeledReplicas = this.getFullyLabeledReplicas();
        result = result * prime + ($fullyLabeledReplicas == null ? 43 : $fullyLabeledReplicas.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $readyReplicas = this.getReadyReplicas();
        result = result * prime + ($readyReplicas == null ? 43 : $readyReplicas.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $synchronizedGeneration = this.getSynchronizedGeneration();
        result = result * prime + ($synchronizedGeneration == null ? 43 : $synchronizedGeneration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineSetStatus(" + "authoritativeAPI=" + this.getAuthoritativeAPI() + ", availableReplicas=" + this.getAvailableReplicas() + ", conditions=" + this.getConditions() + ", errorMessage=" + this.getErrorMessage() + ", errorReason=" + this.getErrorReason() + ", fullyLabeledReplicas=" + this.getFullyLabeledReplicas() + ", observedGeneration=" + this.getObservedGeneration() + ", readyReplicas=" + this.getReadyReplicas() + ", replicas=" + this.getReplicas() + ", synchronizedGeneration=" + this.getSynchronizedGeneration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
