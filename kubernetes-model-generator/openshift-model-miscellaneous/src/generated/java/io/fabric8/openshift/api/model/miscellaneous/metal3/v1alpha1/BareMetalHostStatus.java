
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BareMetalHostStatus defines the observed state of BareMetalHost.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BareMetalHostStatus implements Editable<BareMetalHostStatusBuilder>, KubernetesResource
{

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

    public BareMetalHostStatus(Integer errorCount, String errorMessage, String errorType, CredentialsStatus goodCredentials, HardwareDetails hardware, String hardwareProfile, String lastUpdated, OperationHistory operationHistory, String operationalStatus, Boolean poweredOn, ProvisionStatus provisioning, CredentialsStatus triedCredentials) {
        super();
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

}
