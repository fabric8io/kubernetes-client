
package io.fabric8.servicecatalog.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "asyncOpInProgress",
    "conditions",
    "currentOperation",
    "dashboardURL",
    "defaultProvisionParameters",
    "deprovisionStatus",
    "externalProperties",
    "inProgressProperties",
    "lastOperation",
    "observedGeneration",
    "operationStartTime",
    "orphanMitigationInProgress",
    "provisionStatus",
    "reconciledGeneration"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ServiceInstanceStatus implements KubernetesResource
{

    @JsonProperty("asyncOpInProgress")
    private Boolean asyncOpInProgress;
    @JsonProperty("conditions")
    private List<ServiceInstanceCondition> conditions = new ArrayList<ServiceInstanceCondition>();
    @JsonProperty("currentOperation")
    private java.lang.String currentOperation;
    @JsonProperty("dashboardURL")
    private String dashboardURL;
    @JsonProperty("defaultProvisionParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> defaultProvisionParameters = new LinkedHashMap<String, Object>();
    @JsonProperty("deprovisionStatus")
    private java.lang.String deprovisionStatus;
    @JsonProperty("externalProperties")
    private ServiceInstancePropertiesState externalProperties;
    @JsonProperty("inProgressProperties")
    private ServiceInstancePropertiesState inProgressProperties;
    @JsonProperty("lastOperation")
    private String lastOperation;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("operationStartTime")
    private java.lang.String operationStartTime;
    @JsonProperty("orphanMitigationInProgress")
    private Boolean orphanMitigationInProgress;
    @JsonProperty("provisionStatus")
    private java.lang.String provisionStatus;
    @JsonProperty("reconciledGeneration")
    private Long reconciledGeneration;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceInstanceStatus() {
    }

    /**
     * 
     * @param dashboardURL
     * @param orphanMitigationInProgress
     * @param externalProperties
     * @param operationStartTime
     * @param currentOperation
     * @param inProgressProperties
     * @param provisionStatus
     * @param asyncOpInProgress
     * @param reconciledGeneration
     * @param lastOperation
     * @param conditions
     * @param deprovisionStatus
     * @param defaultProvisionParameters
     * @param observedGeneration
     */
    public ServiceInstanceStatus(Boolean asyncOpInProgress, List<ServiceInstanceCondition> conditions, java.lang.String currentOperation, String dashboardURL, Map<String, Object> defaultProvisionParameters, java.lang.String deprovisionStatus, ServiceInstancePropertiesState externalProperties, ServiceInstancePropertiesState inProgressProperties, String lastOperation, Long observedGeneration, java.lang.String operationStartTime, Boolean orphanMitigationInProgress, java.lang.String provisionStatus, Long reconciledGeneration) {
        super();
        this.asyncOpInProgress = asyncOpInProgress;
        this.conditions = conditions;
        this.currentOperation = currentOperation;
        this.dashboardURL = dashboardURL;
        this.defaultProvisionParameters = defaultProvisionParameters;
        this.deprovisionStatus = deprovisionStatus;
        this.externalProperties = externalProperties;
        this.inProgressProperties = inProgressProperties;
        this.lastOperation = lastOperation;
        this.observedGeneration = observedGeneration;
        this.operationStartTime = operationStartTime;
        this.orphanMitigationInProgress = orphanMitigationInProgress;
        this.provisionStatus = provisionStatus;
        this.reconciledGeneration = reconciledGeneration;
    }

    @JsonProperty("asyncOpInProgress")
    public Boolean getAsyncOpInProgress() {
        return asyncOpInProgress;
    }

    @JsonProperty("asyncOpInProgress")
    public void setAsyncOpInProgress(Boolean asyncOpInProgress) {
        this.asyncOpInProgress = asyncOpInProgress;
    }

    @JsonProperty("conditions")
    public List<ServiceInstanceCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ServiceInstanceCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentOperation")
    public java.lang.String getCurrentOperation() {
        return currentOperation;
    }

    @JsonProperty("currentOperation")
    public void setCurrentOperation(java.lang.String currentOperation) {
        this.currentOperation = currentOperation;
    }

    @JsonProperty("dashboardURL")
    public String getDashboardURL() {
        return dashboardURL;
    }

    @JsonProperty("dashboardURL")
    public void setDashboardURL(String dashboardURL) {
        this.dashboardURL = dashboardURL;
    }

    @JsonProperty("defaultProvisionParameters")
    public Map<String, Object> getDefaultProvisionParameters() {
        return defaultProvisionParameters;
    }

    @JsonProperty("defaultProvisionParameters")
    public void setDefaultProvisionParameters(Map<String, Object> defaultProvisionParameters) {
        this.defaultProvisionParameters = defaultProvisionParameters;
    }

    @JsonProperty("deprovisionStatus")
    public java.lang.String getDeprovisionStatus() {
        return deprovisionStatus;
    }

    @JsonProperty("deprovisionStatus")
    public void setDeprovisionStatus(java.lang.String deprovisionStatus) {
        this.deprovisionStatus = deprovisionStatus;
    }

    @JsonProperty("externalProperties")
    public ServiceInstancePropertiesState getExternalProperties() {
        return externalProperties;
    }

    @JsonProperty("externalProperties")
    public void setExternalProperties(ServiceInstancePropertiesState externalProperties) {
        this.externalProperties = externalProperties;
    }

    @JsonProperty("inProgressProperties")
    public ServiceInstancePropertiesState getInProgressProperties() {
        return inProgressProperties;
    }

    @JsonProperty("inProgressProperties")
    public void setInProgressProperties(ServiceInstancePropertiesState inProgressProperties) {
        this.inProgressProperties = inProgressProperties;
    }

    @JsonProperty("lastOperation")
    public String getLastOperation() {
        return lastOperation;
    }

    @JsonProperty("lastOperation")
    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("operationStartTime")
    public java.lang.String getOperationStartTime() {
        return operationStartTime;
    }

    @JsonProperty("operationStartTime")
    public void setOperationStartTime(java.lang.String operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    @JsonProperty("orphanMitigationInProgress")
    public Boolean getOrphanMitigationInProgress() {
        return orphanMitigationInProgress;
    }

    @JsonProperty("orphanMitigationInProgress")
    public void setOrphanMitigationInProgress(Boolean orphanMitigationInProgress) {
        this.orphanMitigationInProgress = orphanMitigationInProgress;
    }

    @JsonProperty("provisionStatus")
    public java.lang.String getProvisionStatus() {
        return provisionStatus;
    }

    @JsonProperty("provisionStatus")
    public void setProvisionStatus(java.lang.String provisionStatus) {
        this.provisionStatus = provisionStatus;
    }

    @JsonProperty("reconciledGeneration")
    public Long getReconciledGeneration() {
        return reconciledGeneration;
    }

    @JsonProperty("reconciledGeneration")
    public void setReconciledGeneration(Long reconciledGeneration) {
        this.reconciledGeneration = reconciledGeneration;
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
