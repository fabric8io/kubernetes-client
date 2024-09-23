
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineStatus implements Editable<MachineStatusBuilder> , KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NodeAddress> addresses = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineStatusConditions> conditions = new ArrayList<>();
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorReason")
    private String errorReason;
    @JsonProperty("lastOperation")
    private MachineStatusLastOperation lastOperation;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("nodeRef")
    private MachineStatusNodeRef nodeRef;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object providerStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineStatus() {
    }

    public MachineStatus(List<NodeAddress> addresses, List<MachineStatusConditions> conditions, String errorMessage, String errorReason, MachineStatusLastOperation lastOperation, String lastUpdated, MachineStatusNodeRef nodeRef, String phase, Object providerStatus) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NodeAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<NodeAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineStatusConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<MachineStatusConditions> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("errorReason")
    public String getErrorReason() {
        return errorReason;
    }

    @JsonProperty("errorReason")
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    @JsonProperty("lastOperation")
    public MachineStatusLastOperation getLastOperation() {
        return lastOperation;
    }

    @JsonProperty("lastOperation")
    public void setLastOperation(MachineStatusLastOperation lastOperation) {
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
    public MachineStatusNodeRef getNodeRef() {
        return nodeRef;
    }

    @JsonProperty("nodeRef")
    public void setNodeRef(MachineStatusNodeRef nodeRef) {
        this.nodeRef = nodeRef;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("providerStatus")
    public Object getProviderStatus() {
        return providerStatus;
    }

    @JsonProperty("providerStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setProviderStatus(Object providerStatus) {
        this.providerStatus = providerStatus;
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
