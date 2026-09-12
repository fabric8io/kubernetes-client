
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * BareMetalHostStatus defines the observed state of BareMetalHost.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "errorCount",
    "errorMessage",
    "errorType",
    "goodCredentials",
    "hardware",
    "hardwareProfile",
    "lastUpdated",
    "operationHistory",
    "operationalStatus",
    "poweredOn",
    "provisioning",
    "triedCredentials"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BareMetalHostStatus implements Editable<BareMetalHostStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("errorCount")
    private Integer errorCount;
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorType")
    private String errorType;
    @JsonProperty("goodCredentials")
    private CredentialsStatus goodCredentials;
    @JsonProperty("hardware")
    private HardwareDetails hardware;
    @JsonProperty("hardwareProfile")
    private String hardwareProfile;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("operationHistory")
    private OperationHistory operationHistory;
    @JsonProperty("operationalStatus")
    private String operationalStatus;
    @JsonProperty("poweredOn")
    private Boolean poweredOn;
    @JsonProperty("provisioning")
    private ProvisionStatus provisioning;
    @JsonProperty("triedCredentials")
    private CredentialsStatus triedCredentials;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BareMetalHostStatus() {
    }

    public BareMetalHostStatus(List<Condition> conditions, Integer errorCount, String errorMessage, String errorType, CredentialsStatus goodCredentials, HardwareDetails hardware, String hardwareProfile, String lastUpdated, OperationHistory operationHistory, String operationalStatus, Boolean poweredOn, ProvisionStatus provisioning, CredentialsStatus triedCredentials) {
        super();
        this.conditions = conditions;
        this.errorCount = errorCount;
        this.errorMessage = errorMessage;
        this.errorType = errorType;
        this.goodCredentials = goodCredentials;
        this.hardware = hardware;
        this.hardwareProfile = hardwareProfile;
        this.lastUpdated = lastUpdated;
        this.operationHistory = operationHistory;
        this.operationalStatus = operationalStatus;
        this.poweredOn = poweredOn;
        this.provisioning = provisioning;
        this.triedCredentials = triedCredentials;
    }

    /**
     * Conditions defines current service state of the BareMetalHost.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines current service state of the BareMetalHost.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ErrorCount records how many times the host has encoutered an error since the last successful operation
     */
    @JsonProperty("errorCount")
    public Integer getErrorCount() {
        return errorCount;
    }

    /**
     * ErrorCount records how many times the host has encoutered an error since the last successful operation
     */
    @JsonProperty("errorCount")
    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    /**
     * The last error message reported by the provisioning subsystem.
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * The last error message reported by the provisioning subsystem.
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * ErrorType indicates the type of failure encountered when the OperationalStatus is OperationalStatusError
     */
    @JsonProperty("errorType")
    public String getErrorType() {
        return errorType;
    }

    /**
     * ErrorType indicates the type of failure encountered when the OperationalStatus is OperationalStatusError
     */
    @JsonProperty("errorType")
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("goodCredentials")
    public CredentialsStatus getGoodCredentials() {
        return goodCredentials;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("goodCredentials")
    public void setGoodCredentials(CredentialsStatus goodCredentials) {
        this.goodCredentials = goodCredentials;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("hardware")
    public HardwareDetails getHardware() {
        return hardware;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("hardware")
    public void setHardware(HardwareDetails hardware) {
        this.hardware = hardware;
    }

    /**
     * The name of the profile matching the hardware details. Hardware profiles are deprecated and should not be relied on.
     */
    @JsonProperty("hardwareProfile")
    public String getHardwareProfile() {
        return hardwareProfile;
    }

    /**
     * The name of the profile matching the hardware details. Hardware profiles are deprecated and should not be relied on.
     */
    @JsonProperty("hardwareProfile")
    public void setHardwareProfile(String hardwareProfile) {
        this.hardwareProfile = hardwareProfile;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("operationHistory")
    public OperationHistory getOperationHistory() {
        return operationHistory;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("operationHistory")
    public void setOperationHistory(OperationHistory operationHistory) {
        this.operationHistory = operationHistory;
    }

    /**
     * OperationalStatus holds the status of the host
     */
    @JsonProperty("operationalStatus")
    public String getOperationalStatus() {
        return operationalStatus;
    }

    /**
     * OperationalStatus holds the status of the host
     */
    @JsonProperty("operationalStatus")
    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    /**
     * The currently detected power state of the host. This field may get briefly out of sync with the actual state of the hardware while provisioning processes are running.
     */
    @JsonProperty("poweredOn")
    public Boolean getPoweredOn() {
        return poweredOn;
    }

    /**
     * The currently detected power state of the host. This field may get briefly out of sync with the actual state of the hardware while provisioning processes are running.
     */
    @JsonProperty("poweredOn")
    public void setPoweredOn(Boolean poweredOn) {
        this.poweredOn = poweredOn;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("provisioning")
    public ProvisionStatus getProvisioning() {
        return provisioning;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("provisioning")
    public void setProvisioning(ProvisionStatus provisioning) {
        this.provisioning = provisioning;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("triedCredentials")
    public CredentialsStatus getTriedCredentials() {
        return triedCredentials;
    }

    /**
     * BareMetalHostStatus defines the observed state of BareMetalHost.
     */
    @JsonProperty("triedCredentials")
    public void setTriedCredentials(CredentialsStatus triedCredentials) {
        this.triedCredentials = triedCredentials;
    }

    @JsonIgnore
    public BareMetalHostStatusBuilder edit() {
        return new BareMetalHostStatusBuilder(this);
    }

    @JsonIgnore
    public BareMetalHostStatusBuilder toBuilder() {
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
        if (!(o instanceof BareMetalHostStatus)) {
            return false;
        }
        BareMetalHostStatus other = (BareMetalHostStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$errorCount = this.getErrorCount();
        Object other$errorCount = other.getErrorCount();
        if (this$errorCount == null ? other$errorCount != null : !this$errorCount.equals(other$errorCount)) {
            return false;
        }
        Object this$errorMessage = this.getErrorMessage();
        Object other$errorMessage = other.getErrorMessage();
        if (this$errorMessage == null ? other$errorMessage != null : !this$errorMessage.equals(other$errorMessage)) {
            return false;
        }
        Object this$errorType = this.getErrorType();
        Object other$errorType = other.getErrorType();
        if (this$errorType == null ? other$errorType != null : !this$errorType.equals(other$errorType)) {
            return false;
        }
        Object this$goodCredentials = this.getGoodCredentials();
        Object other$goodCredentials = other.getGoodCredentials();
        if (this$goodCredentials == null ? other$goodCredentials != null : !this$goodCredentials.equals(other$goodCredentials)) {
            return false;
        }
        Object this$hardware = this.getHardware();
        Object other$hardware = other.getHardware();
        if (this$hardware == null ? other$hardware != null : !this$hardware.equals(other$hardware)) {
            return false;
        }
        Object this$hardwareProfile = this.getHardwareProfile();
        Object other$hardwareProfile = other.getHardwareProfile();
        if (this$hardwareProfile == null ? other$hardwareProfile != null : !this$hardwareProfile.equals(other$hardwareProfile)) {
            return false;
        }
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$operationHistory = this.getOperationHistory();
        Object other$operationHistory = other.getOperationHistory();
        if (this$operationHistory == null ? other$operationHistory != null : !this$operationHistory.equals(other$operationHistory)) {
            return false;
        }
        Object this$operationalStatus = this.getOperationalStatus();
        Object other$operationalStatus = other.getOperationalStatus();
        if (this$operationalStatus == null ? other$operationalStatus != null : !this$operationalStatus.equals(other$operationalStatus)) {
            return false;
        }
        Object this$poweredOn = this.getPoweredOn();
        Object other$poweredOn = other.getPoweredOn();
        if (this$poweredOn == null ? other$poweredOn != null : !this$poweredOn.equals(other$poweredOn)) {
            return false;
        }
        Object this$provisioning = this.getProvisioning();
        Object other$provisioning = other.getProvisioning();
        if (this$provisioning == null ? other$provisioning != null : !this$provisioning.equals(other$provisioning)) {
            return false;
        }
        Object this$triedCredentials = this.getTriedCredentials();
        Object other$triedCredentials = other.getTriedCredentials();
        if (this$triedCredentials == null ? other$triedCredentials != null : !this$triedCredentials.equals(other$triedCredentials)) {
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
        return other instanceof BareMetalHostStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $errorCount = this.getErrorCount();
        result = result * prime + ($errorCount == null ? 43 : $errorCount.hashCode());
        Object $errorMessage = this.getErrorMessage();
        result = result * prime + ($errorMessage == null ? 43 : $errorMessage.hashCode());
        Object $errorType = this.getErrorType();
        result = result * prime + ($errorType == null ? 43 : $errorType.hashCode());
        Object $goodCredentials = this.getGoodCredentials();
        result = result * prime + ($goodCredentials == null ? 43 : $goodCredentials.hashCode());
        Object $hardware = this.getHardware();
        result = result * prime + ($hardware == null ? 43 : $hardware.hashCode());
        Object $hardwareProfile = this.getHardwareProfile();
        result = result * prime + ($hardwareProfile == null ? 43 : $hardwareProfile.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $operationHistory = this.getOperationHistory();
        result = result * prime + ($operationHistory == null ? 43 : $operationHistory.hashCode());
        Object $operationalStatus = this.getOperationalStatus();
        result = result * prime + ($operationalStatus == null ? 43 : $operationalStatus.hashCode());
        Object $poweredOn = this.getPoweredOn();
        result = result * prime + ($poweredOn == null ? 43 : $poweredOn.hashCode());
        Object $provisioning = this.getProvisioning();
        result = result * prime + ($provisioning == null ? 43 : $provisioning.hashCode());
        Object $triedCredentials = this.getTriedCredentials();
        result = result * prime + ($triedCredentials == null ? 43 : $triedCredentials.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BareMetalHostStatus(" + "conditions=" + this.getConditions() + ", errorCount=" + this.getErrorCount() + ", errorMessage=" + this.getErrorMessage() + ", errorType=" + this.getErrorType() + ", goodCredentials=" + this.getGoodCredentials() + ", hardware=" + this.getHardware() + ", hardwareProfile=" + this.getHardwareProfile() + ", lastUpdated=" + this.getLastUpdated() + ", operationHistory=" + this.getOperationHistory() + ", operationalStatus=" + this.getOperationalStatus() + ", poweredOn=" + this.getPoweredOn() + ", provisioning=" + this.getProvisioning() + ", triedCredentials=" + this.getTriedCredentials() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
