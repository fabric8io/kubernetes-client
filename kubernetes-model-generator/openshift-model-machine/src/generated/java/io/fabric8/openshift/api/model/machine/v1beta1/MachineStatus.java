
package io.fabric8.openshift.api.model.machine.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.NodeAddress;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "addresses",
    "conditions",
    "errorMessage",
    "errorReason",
    "lastOperation",
    "lastUpdated",
    "nodeRef",
    "phase",
    "providerStatus"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineStatus implements KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAddress> addresses = new ArrayList<NodeAddress>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("errorMessage")
    private java.lang.String errorMessage;
    @JsonProperty("errorReason")
    private java.lang.String errorReason;
    @JsonProperty("lastOperation")
    private LastOperation lastOperation;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("nodeRef")
    private io.fabric8.kubernetes.api.model.ObjectReference nodeRef;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("providerStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> providerStatus = new LinkedHashMap<String, Object>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineStatus() {
    }

    public MachineStatus(List<NodeAddress> addresses, List<Condition> conditions, java.lang.String errorMessage, java.lang.String errorReason, LastOperation lastOperation, String lastUpdated, io.fabric8.kubernetes.api.model.ObjectReference nodeRef, java.lang.String phase, Map<String, Object> providerStatus) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.errorMessage = errorMessage;
        this.errorReason = errorReason;
        this.lastOperation = lastOperation;
        this.lastUpdated = lastUpdated;
        this.nodeRef = nodeRef;
        this.phase = phase;
        this.providerStatus = providerStatus;
    }

    @JsonProperty("addresses")
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("errorMessage")
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("errorMessage")
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("errorReason")
    public java.lang.String getErrorReason() {
        return errorReason;
    }

    @JsonProperty("errorReason")
    public void setErrorReason(java.lang.String errorReason) {
        this.errorReason = errorReason;
    }

    @JsonProperty("lastOperation")
    public LastOperation getLastOperation() {
        return lastOperation;
    }

    @JsonProperty("lastOperation")
    public void setLastOperation(LastOperation lastOperation) {
        this.lastOperation = lastOperation;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("nodeRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getNodeRef() {
        return nodeRef;
    }

    @JsonProperty("nodeRef")
    public void setNodeRef(io.fabric8.kubernetes.api.model.ObjectReference nodeRef) {
        this.nodeRef = nodeRef;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }

    @JsonProperty("providerStatus")
    public Map<String, Object> getProviderStatus() {
        return providerStatus;
    }

    @JsonProperty("providerStatus")
    public void setProviderStatus(Map<String, Object> providerStatus) {
        this.providerStatus = providerStatus;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
