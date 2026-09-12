
package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.NodeSystemInfo;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.sundr.builder.annotations.Buildable;

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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
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

    @JsonProperty("deletion")
    public MachineDeletionStatus getDeletion() {
        return deletion;
    }

    @JsonProperty("deletion")
    public void setDeletion(MachineDeletionStatus deletion) {
        this.deletion = deletion;
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

    @JsonProperty("v1beta2")
    public MachineV1Beta2Status getV1beta2() {
        return v1beta2;
    }

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
        Object this$bootstrapReady = this.getBootstrapReady();
        Object other$bootstrapReady = other.getBootstrapReady();
        if (this$bootstrapReady == null ? other$bootstrapReady != null : !this$bootstrapReady.equals(other$bootstrapReady)) {
            return false;
        }
        Object this$certificatesExpiryDate = this.getCertificatesExpiryDate();
        Object other$certificatesExpiryDate = other.getCertificatesExpiryDate();
        if (this$certificatesExpiryDate == null ? other$certificatesExpiryDate != null : !this$certificatesExpiryDate.equals(other$certificatesExpiryDate)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$deletion = this.getDeletion();
        Object other$deletion = other.getDeletion();
        if (this$deletion == null ? other$deletion != null : !this$deletion.equals(other$deletion)) {
            return false;
        }
        Object this$failureMessage = this.getFailureMessage();
        Object other$failureMessage = other.getFailureMessage();
        if (this$failureMessage == null ? other$failureMessage != null : !this$failureMessage.equals(other$failureMessage)) {
            return false;
        }
        Object this$failureReason = this.getFailureReason();
        Object other$failureReason = other.getFailureReason();
        if (this$failureReason == null ? other$failureReason != null : !this$failureReason.equals(other$failureReason)) {
            return false;
        }
        Object this$infrastructureReady = this.getInfrastructureReady();
        Object other$infrastructureReady = other.getInfrastructureReady();
        if (this$infrastructureReady == null ? other$infrastructureReady != null : !this$infrastructureReady.equals(other$infrastructureReady)) {
            return false;
        }
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$nodeInfo = this.getNodeInfo();
        Object other$nodeInfo = other.getNodeInfo();
        if (this$nodeInfo == null ? other$nodeInfo != null : !this$nodeInfo.equals(other$nodeInfo)) {
            return false;
        }
        Object this$nodeRef = this.getNodeRef();
        Object other$nodeRef = other.getNodeRef();
        if (this$nodeRef == null ? other$nodeRef != null : !this$nodeRef.equals(other$nodeRef)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$v1beta2 = this.getV1beta2();
        Object other$v1beta2 = other.getV1beta2();
        if (this$v1beta2 == null ? other$v1beta2 != null : !this$v1beta2.equals(other$v1beta2)) {
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
        Object $bootstrapReady = this.getBootstrapReady();
        result = result * prime + ($bootstrapReady == null ? 43 : $bootstrapReady.hashCode());
        Object $certificatesExpiryDate = this.getCertificatesExpiryDate();
        result = result * prime + ($certificatesExpiryDate == null ? 43 : $certificatesExpiryDate.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $deletion = this.getDeletion();
        result = result * prime + ($deletion == null ? 43 : $deletion.hashCode());
        Object $failureMessage = this.getFailureMessage();
        result = result * prime + ($failureMessage == null ? 43 : $failureMessage.hashCode());
        Object $failureReason = this.getFailureReason();
        result = result * prime + ($failureReason == null ? 43 : $failureReason.hashCode());
        Object $infrastructureReady = this.getInfrastructureReady();
        result = result * prime + ($infrastructureReady == null ? 43 : $infrastructureReady.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $nodeInfo = this.getNodeInfo();
        result = result * prime + ($nodeInfo == null ? 43 : $nodeInfo.hashCode());
        Object $nodeRef = this.getNodeRef();
        result = result * prime + ($nodeRef == null ? 43 : $nodeRef.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $v1beta2 = this.getV1beta2();
        result = result * prime + ($v1beta2 == null ? 43 : $v1beta2.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineStatus(" + "addresses=" + this.getAddresses() + ", bootstrapReady=" + this.getBootstrapReady() + ", certificatesExpiryDate=" + this.getCertificatesExpiryDate() + ", conditions=" + this.getConditions() + ", deletion=" + this.getDeletion() + ", failureMessage=" + this.getFailureMessage() + ", failureReason=" + this.getFailureReason() + ", infrastructureReady=" + this.getInfrastructureReady() + ", lastUpdated=" + this.getLastUpdated() + ", nodeInfo=" + this.getNodeInfo() + ", nodeRef=" + this.getNodeRef() + ", observedGeneration=" + this.getObservedGeneration() + ", phase=" + this.getPhase() + ", v1beta2=" + this.getV1beta2() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
