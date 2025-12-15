
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
import io.fabric8.kubernetes.api.model.NodeSystemInfo;
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
 * MachineStatus defines the observed state of Machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "bootstrapReady",
    "certificatesExpiryDate",
    "conditions",
    "deletion",
    "failureMessage",
    "failureReason",
    "infrastructureReady",
    "lastUpdated",
    "nodeInfo",
    "nodeRef",
    "observedGeneration",
    "phase",
    "v1beta2"
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
public class MachineStatus implements Editable<MachineStatusBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineAddress> addresses = new ArrayList<>();
    @JsonProperty("bootstrapReady")
    private Boolean bootstrapReady;
    @JsonProperty("certificatesExpiryDate")
    private String certificatesExpiryDate;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("deletion")
    private MachineDeletionStatus deletion;
    @JsonProperty("failureMessage")
    private String failureMessage;
    @JsonProperty("failureReason")
    private String failureReason;
    @JsonProperty("infrastructureReady")
    private Boolean infrastructureReady;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("nodeInfo")
    private NodeSystemInfo nodeInfo;
    @JsonProperty("nodeRef")
    private ObjectReference nodeRef;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("v1beta2")
    private MachineV1Beta2Status v1beta2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineStatus() {
    }

    public MachineStatus(List<MachineAddress> addresses, Boolean bootstrapReady, String certificatesExpiryDate, List<Condition> conditions, MachineDeletionStatus deletion, String failureMessage, String failureReason, Boolean infrastructureReady, String lastUpdated, NodeSystemInfo nodeInfo, ObjectReference nodeRef, Long observedGeneration, String phase, MachineV1Beta2Status v1beta2) {
        super();
        this.addresses = addresses;
        this.bootstrapReady = bootstrapReady;
        this.certificatesExpiryDate = certificatesExpiryDate;
        this.conditions = conditions;
        this.deletion = deletion;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.infrastructureReady = infrastructureReady;
        this.lastUpdated = lastUpdated;
        this.nodeInfo = nodeInfo;
        this.nodeRef = nodeRef;
        this.observedGeneration = observedGeneration;
        this.phase = phase;
        this.v1beta2 = v1beta2;
    }

    /**
     * addresses is a list of addresses assigned to the machine. This field is copied from the infrastructure provider reference.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineAddress> getAddresses() {
        return addresses;
    }

    /**
     * addresses is a list of addresses assigned to the machine. This field is copied from the infrastructure provider reference.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<MachineAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * bootstrapReady is the state of the bootstrap provider.
     */
    @JsonProperty("bootstrapReady")
    public Boolean getBootstrapReady() {
        return bootstrapReady;
    }

    /**
     * bootstrapReady is the state of the bootstrap provider.
     */
    @JsonProperty("bootstrapReady")
    public void setBootstrapReady(Boolean bootstrapReady) {
        this.bootstrapReady = bootstrapReady;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("certificatesExpiryDate")
    public String getCertificatesExpiryDate() {
        return certificatesExpiryDate;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("certificatesExpiryDate")
    public void setCertificatesExpiryDate(String certificatesExpiryDate) {
        this.certificatesExpiryDate = certificatesExpiryDate;
    }

    /**
     * conditions defines current service state of the Machine.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines current service state of the Machine.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("deletion")
    public MachineDeletionStatus getDeletion() {
        return deletion;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("deletion")
    public void setDeletion(MachineDeletionStatus deletion) {
        this.deletion = deletion;
    }

    /**
     * failureMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    /**
     * failureMessage will be set in the event that there is a terminal problem reconciling the Machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    /**
     * failureReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * failureReason will be set in the event that there is a terminal problem reconciling the Machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the Machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of Machines can be added as events to the Machine object and/or logged in the controller's output.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    /**
     * infrastructureReady is the state of the infrastructure provider.
     */
    @JsonProperty("infrastructureReady")
    public Boolean getInfrastructureReady() {
        return infrastructureReady;
    }

    /**
     * infrastructureReady is the state of the infrastructure provider.
     */
    @JsonProperty("infrastructureReady")
    public void setInfrastructureReady(Boolean infrastructureReady) {
        this.infrastructureReady = infrastructureReady;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("nodeInfo")
    public NodeSystemInfo getNodeInfo() {
        return nodeInfo;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("nodeInfo")
    public void setNodeInfo(NodeSystemInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("nodeRef")
    public ObjectReference getNodeRef() {
        return nodeRef;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("nodeRef")
    public void setNodeRef(ObjectReference nodeRef) {
        this.nodeRef = nodeRef;
    }

    /**
     * observedGeneration is the latest generation observed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the latest generation observed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * phase represents the current phase of machine actuation.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * phase represents the current phase of machine actuation.
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("v1beta2")
    public MachineV1Beta2Status getV1beta2() {
        return v1beta2;
    }

    /**
     * MachineStatus defines the observed state of Machine.
     */
    @JsonProperty("v1beta2")
    public void setV1beta2(MachineV1Beta2Status v1beta2) {
        this.v1beta2 = v1beta2;
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
