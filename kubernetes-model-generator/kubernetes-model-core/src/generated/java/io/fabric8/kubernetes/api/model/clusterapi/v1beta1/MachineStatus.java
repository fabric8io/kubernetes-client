
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.NodeSystemInfo;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "bootstrapReady",
    "certificatesExpiryDate",
    "conditions",
    "failureMessage",
    "failureReason",
    "infrastructureReady",
    "lastUpdated",
    "nodeInfo",
    "nodeRef",
    "observedGeneration",
    "phase"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class MachineStatus implements Editable<MachineStatusBuilder> , KubernetesResource
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineStatus() {
    }

    public MachineStatus(List<MachineAddress> addresses, Boolean bootstrapReady, String certificatesExpiryDate, List<Condition> conditions, String failureMessage, String failureReason, Boolean infrastructureReady, String lastUpdated, NodeSystemInfo nodeInfo, ObjectReference nodeRef, Long observedGeneration, String phase) {
        super();
        this.addresses = addresses;
        this.bootstrapReady = bootstrapReady;
        this.certificatesExpiryDate = certificatesExpiryDate;
        this.conditions = conditions;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.infrastructureReady = infrastructureReady;
        this.lastUpdated = lastUpdated;
        this.nodeInfo = nodeInfo;
        this.nodeRef = nodeRef;
        this.observedGeneration = observedGeneration;
        this.phase = phase;
    }

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<MachineAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("bootstrapReady")
    public Boolean getBootstrapReady() {
        return bootstrapReady;
    }

    @JsonProperty("bootstrapReady")
    public void setBootstrapReady(Boolean bootstrapReady) {
        this.bootstrapReady = bootstrapReady;
    }

    @JsonProperty("certificatesExpiryDate")
    public String getCertificatesExpiryDate() {
        return certificatesExpiryDate;
    }

    @JsonProperty("certificatesExpiryDate")
    public void setCertificatesExpiryDate(String certificatesExpiryDate) {
        this.certificatesExpiryDate = certificatesExpiryDate;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @JsonProperty("infrastructureReady")
    public Boolean getInfrastructureReady() {
        return infrastructureReady;
    }

    @JsonProperty("infrastructureReady")
    public void setInfrastructureReady(Boolean infrastructureReady) {
        this.infrastructureReady = infrastructureReady;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("nodeInfo")
    public NodeSystemInfo getNodeInfo() {
        return nodeInfo;
    }

    @JsonProperty("nodeInfo")
    public void setNodeInfo(NodeSystemInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    @JsonProperty("nodeRef")
    public ObjectReference getNodeRef() {
        return nodeRef;
    }

    @JsonProperty("nodeRef")
    public void setNodeRef(ObjectReference nodeRef) {
        this.nodeRef = nodeRef;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
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
