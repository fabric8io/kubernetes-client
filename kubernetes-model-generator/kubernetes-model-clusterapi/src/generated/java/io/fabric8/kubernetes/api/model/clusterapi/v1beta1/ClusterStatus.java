
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
 * ClusterStatus defines the observed state of Cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "controlPlaneReady",
    "failureDomains",
    "failureMessage",
    "failureReason",
    "infrastructureReady",
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
public class ClusterStatus implements Editable<ClusterStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("controlPlaneReady")
    private Boolean controlPlaneReady;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, FailureDomainSpec> failureDomains = new LinkedHashMap<>();
    @JsonProperty("failureMessage")
    private String failureMessage;
    @JsonProperty("failureReason")
    private String failureReason;
    @JsonProperty("infrastructureReady")
    private Boolean infrastructureReady;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("v1beta2")
    private ClusterV1Beta2Status v1beta2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterStatus() {
    }

    public ClusterStatus(List<Condition> conditions, Boolean controlPlaneReady, Map<String, FailureDomainSpec> failureDomains, String failureMessage, String failureReason, Boolean infrastructureReady, Long observedGeneration, String phase, ClusterV1Beta2Status v1beta2) {
        super();
        this.conditions = conditions;
        this.controlPlaneReady = controlPlaneReady;
        this.failureDomains = failureDomains;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.infrastructureReady = infrastructureReady;
        this.observedGeneration = observedGeneration;
        this.phase = phase;
        this.v1beta2 = v1beta2;
    }

    /**
     * conditions defines current service state of the cluster.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines current service state of the cluster.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * controlPlaneReady denotes if the control plane became ready during initial provisioning to receive requests. NOTE: this field is part of the Cluster API contract and it is used to orchestrate provisioning. The value of this field is never updated after provisioning is completed. Please use conditions to check the operational state of the control plane.
     */
    @JsonProperty("controlPlaneReady")
    public Boolean getControlPlaneReady() {
        return controlPlaneReady;
    }

    /**
     * controlPlaneReady denotes if the control plane became ready during initial provisioning to receive requests. NOTE: this field is part of the Cluster API contract and it is used to orchestrate provisioning. The value of this field is never updated after provisioning is completed. Please use conditions to check the operational state of the control plane.
     */
    @JsonProperty("controlPlaneReady")
    public void setControlPlaneReady(Boolean controlPlaneReady) {
        this.controlPlaneReady = controlPlaneReady;
    }

    /**
     * failureDomains is a slice of failure domain objects synced from the infrastructure provider.
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, FailureDomainSpec> getFailureDomains() {
        return failureDomains;
    }

    /**
     * failureDomains is a slice of failure domain objects synced from the infrastructure provider.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(Map<String, FailureDomainSpec> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * failureMessage indicates that there is a fatal problem reconciling the state, and will be set to a descriptive error message.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    /**
     * failureMessage indicates that there is a fatal problem reconciling the state, and will be set to a descriptive error message.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    /**
     * failureReason indicates that there is a fatal problem reconciling the state, and will be set to a token value suitable for programmatic interpretation.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
     */
    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * failureReason indicates that there is a fatal problem reconciling the state, and will be set to a token value suitable for programmatic interpretation.<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more details.
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
     * phase represents the current phase of cluster actuation.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * phase represents the current phase of cluster actuation.
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * ClusterStatus defines the observed state of Cluster.
     */
    @JsonProperty("v1beta2")
    public ClusterV1Beta2Status getV1beta2() {
        return v1beta2;
    }

    /**
     * ClusterStatus defines the observed state of Cluster.
     */
    @JsonProperty("v1beta2")
    public void setV1beta2(ClusterV1Beta2Status v1beta2) {
        this.v1beta2 = v1beta2;
    }

    @JsonIgnore
    public ClusterStatusBuilder edit() {
        return new ClusterStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterStatusBuilder toBuilder() {
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
