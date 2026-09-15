
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.Condition;
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.MachineAddress;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Metal3MachineStatus defines the observed state of Metal3Machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "conditions",
    "failureMessage",
    "failureReason",
    "lastUpdated",
    "metaData",
    "networkData",
    "phase",
    "ready",
    "renderedData",
    "userData",
    "v1beta2"
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
public class Metal3MachineStatus implements Editable<Metal3MachineStatusBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineAddress> addresses = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("failureMessage")
    private String failureMessage;
    @JsonProperty("failureReason")
    private String failureReason;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("metaData")
    private SecretReference metaData;
    @JsonProperty("networkData")
    private SecretReference networkData;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("renderedData")
    private ObjectReference renderedData;
    @JsonProperty("userData")
    private SecretReference userData;
    @JsonProperty("v1beta2")
    private Metal3MachineV1Beta2Status v1beta2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3MachineStatus() {
    }

    public Metal3MachineStatus(List<MachineAddress> addresses, List<Condition> conditions, String failureMessage, String failureReason, String lastUpdated, SecretReference metaData, SecretReference networkData, String phase, Boolean ready, ObjectReference renderedData, SecretReference userData, Metal3MachineV1Beta2Status v1beta2) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.lastUpdated = lastUpdated;
        this.metaData = metaData;
        this.networkData = networkData;
        this.phase = phase;
        this.ready = ready;
        this.renderedData = renderedData;
        this.userData = userData;
        this.v1beta2 = v1beta2;
    }

    /**
     * Addresses is a list of addresses assigned to the machine. This field is copied from the infrastructure provider reference.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineAddress> getAddresses() {
        return addresses;
    }

    /**
     * Addresses is a list of addresses assigned to the machine. This field is copied from the infrastructure provider reference.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<MachineAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * Conditions defines current service state of the Metal3Machine.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines current service state of the Metal3Machine.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * FailureMessage will be set in the event that there is a terminal problem reconciling the metal3machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the metal3machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of metal3machines can be added as events to the metal3machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    /**
     * FailureMessage will be set in the event that there is a terminal problem reconciling the metal3machine and will contain a more verbose string suitable for logging and human consumption.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the metal3machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of metal3machines can be added as events to the metal3machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    /**
     * FailureReason will be set in the event that there is a terminal problem reconciling the metal3machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the metal3machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of metal3machines can be added as events to the metal3machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * FailureReason will be set in the event that there is a terminal problem reconciling the metal3machine and will contain a succinct value suitable for machine interpretation.<br><p> <br><p> This field should not be set for transitive errors that a controller faces that are expected to be fixed automatically over time (like service outages), but instead indicate that something is fundamentally wrong with the metal3machine's spec or the configuration of the controller, and that manual intervention is required. Examples of terminal errors would be invalid combinations of settings in the spec, values that are unsupported by the controller, or the responsible controller itself being critically misconfigured.<br><p> <br><p> Any transient errors that occur during the reconciliation of metal3machines can be added as events to the metal3machine object and/or logged in the controller's output.
     */
    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
        this.networkData = networkData;
    }

    /**
     * Phase represents the current phase of machine actuation. E.g. Pending, Running, Terminating, Failed etc.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Phase represents the current phase of machine actuation. E.g. Pending, Running, Terminating, Failed etc.
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * Ready is the state of the metal3. mhrivnak: " it would be good to document what this means, how to interpret it, under what circumstances the value changes, etc."
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * Ready is the state of the metal3. mhrivnak: " it would be good to document what this means, how to interpret it, under what circumstances the value changes, etc."
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("renderedData")
    public ObjectReference getRenderedData() {
        return renderedData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("renderedData")
    public void setRenderedData(ObjectReference renderedData) {
        this.renderedData = renderedData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("userData")
    public SecretReference getUserData() {
        return userData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("userData")
    public void setUserData(SecretReference userData) {
        this.userData = userData;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("v1beta2")
    public Metal3MachineV1Beta2Status getV1beta2() {
        return v1beta2;
    }

    /**
     * Metal3MachineStatus defines the observed state of Metal3Machine.
     */
    @JsonProperty("v1beta2")
    public void setV1beta2(Metal3MachineV1Beta2Status v1beta2) {
        this.v1beta2 = v1beta2;
    }

    @JsonIgnore
    public Metal3MachineStatusBuilder edit() {
        return new Metal3MachineStatusBuilder(this);
    }

    @JsonIgnore
    public Metal3MachineStatusBuilder toBuilder() {
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
        if (!(o instanceof Metal3MachineStatus)) {
            return false;
        }
        Metal3MachineStatus other = (Metal3MachineStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addresses = this.getAddresses();
        Object other$addresses = other.getAddresses();
        if (this$addresses == null ? other$addresses != null : !this$addresses.equals(other$addresses)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
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
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$metaData = this.getMetaData();
        Object other$metaData = other.getMetaData();
        if (this$metaData == null ? other$metaData != null : !this$metaData.equals(other$metaData)) {
            return false;
        }
        Object this$networkData = this.getNetworkData();
        Object other$networkData = other.getNetworkData();
        if (this$networkData == null ? other$networkData != null : !this$networkData.equals(other$networkData)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$ready = this.getReady();
        Object other$ready = other.getReady();
        if (this$ready == null ? other$ready != null : !this$ready.equals(other$ready)) {
            return false;
        }
        Object this$renderedData = this.getRenderedData();
        Object other$renderedData = other.getRenderedData();
        if (this$renderedData == null ? other$renderedData != null : !this$renderedData.equals(other$renderedData)) {
            return false;
        }
        Object this$userData = this.getUserData();
        Object other$userData = other.getUserData();
        if (this$userData == null ? other$userData != null : !this$userData.equals(other$userData)) {
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
        return other instanceof Metal3MachineStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addresses = this.getAddresses();
        result = result * prime + ($addresses == null ? 43 : $addresses.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $failureMessage = this.getFailureMessage();
        result = result * prime + ($failureMessage == null ? 43 : $failureMessage.hashCode());
        Object $failureReason = this.getFailureReason();
        result = result * prime + ($failureReason == null ? 43 : $failureReason.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $metaData = this.getMetaData();
        result = result * prime + ($metaData == null ? 43 : $metaData.hashCode());
        Object $networkData = this.getNetworkData();
        result = result * prime + ($networkData == null ? 43 : $networkData.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $ready = this.getReady();
        result = result * prime + ($ready == null ? 43 : $ready.hashCode());
        Object $renderedData = this.getRenderedData();
        result = result * prime + ($renderedData == null ? 43 : $renderedData.hashCode());
        Object $userData = this.getUserData();
        result = result * prime + ($userData == null ? 43 : $userData.hashCode());
        Object $v1beta2 = this.getV1beta2();
        result = result * prime + ($v1beta2 == null ? 43 : $v1beta2.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3MachineStatus(" + "addresses=" + this.getAddresses() + ", conditions=" + this.getConditions() + ", failureMessage=" + this.getFailureMessage() + ", failureReason=" + this.getFailureReason() + ", lastUpdated=" + this.getLastUpdated() + ", metaData=" + this.getMetaData() + ", networkData=" + this.getNetworkData() + ", phase=" + this.getPhase() + ", ready=" + this.getReady() + ", renderedData=" + this.getRenderedData() + ", userData=" + this.getUserData() + ", v1beta2=" + this.getV1beta2() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
