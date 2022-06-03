
package io.fabric8.servicecatalog.api.model;

import java.util.ArrayList;
import java.util.HashMap;
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
    "externalProperties",
    "inProgressProperties",
    "lastOperation",
    "operationStartTime",
    "orphanMitigationInProgress",
    "reconciledGeneration",
    "unbindStatus"
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
public class ServiceBindingStatus implements KubernetesResource
{

    @JsonProperty("asyncOpInProgress")
    private Boolean asyncOpInProgress;
    @JsonProperty("conditions")
    private List<ServiceBindingCondition> conditions = new ArrayList<ServiceBindingCondition>();
    @JsonProperty("currentOperation")
    private java.lang.String currentOperation;
    @JsonProperty("externalProperties")
    private ServiceBindingPropertiesState externalProperties;
    @JsonProperty("inProgressProperties")
    private ServiceBindingPropertiesState inProgressProperties;
    @JsonProperty("lastOperation")
    private String lastOperation;
    @JsonProperty("operationStartTime")
    private java.lang.String operationStartTime;
    @JsonProperty("orphanMitigationInProgress")
    private Boolean orphanMitigationInProgress;
    @JsonProperty("reconciledGeneration")
    private Long reconciledGeneration;
    @JsonProperty("unbindStatus")
    private java.lang.String unbindStatus;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceBindingStatus() {
    }

    /**
     * 
     * @param operationStartTime
     * @param currentOperation
     * @param inProgressProperties
     * @param asyncOpInProgress
     * @param reconciledGeneration
     * @param lastOperation
     * @param orphanMitigationInProgress
     * @param conditions
     * @param externalProperties
     * @param unbindStatus
     */
    public ServiceBindingStatus(Boolean asyncOpInProgress, List<ServiceBindingCondition> conditions, java.lang.String currentOperation, ServiceBindingPropertiesState externalProperties, ServiceBindingPropertiesState inProgressProperties, String lastOperation, java.lang.String operationStartTime, Boolean orphanMitigationInProgress, Long reconciledGeneration, java.lang.String unbindStatus) {
        super();
        this.asyncOpInProgress = asyncOpInProgress;
        this.conditions = conditions;
        this.currentOperation = currentOperation;
        this.externalProperties = externalProperties;
        this.inProgressProperties = inProgressProperties;
        this.lastOperation = lastOperation;
        this.operationStartTime = operationStartTime;
        this.orphanMitigationInProgress = orphanMitigationInProgress;
        this.reconciledGeneration = reconciledGeneration;
        this.unbindStatus = unbindStatus;
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
    public List<ServiceBindingCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ServiceBindingCondition> conditions) {
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

    @JsonProperty("externalProperties")
    public ServiceBindingPropertiesState getExternalProperties() {
        return externalProperties;
    }

    @JsonProperty("externalProperties")
    public void setExternalProperties(ServiceBindingPropertiesState externalProperties) {
        this.externalProperties = externalProperties;
    }

    @JsonProperty("inProgressProperties")
    public ServiceBindingPropertiesState getInProgressProperties() {
        return inProgressProperties;
    }

    @JsonProperty("inProgressProperties")
    public void setInProgressProperties(ServiceBindingPropertiesState inProgressProperties) {
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

    @JsonProperty("reconciledGeneration")
    public Long getReconciledGeneration() {
        return reconciledGeneration;
    }

    @JsonProperty("reconciledGeneration")
    public void setReconciledGeneration(Long reconciledGeneration) {
        this.reconciledGeneration = reconciledGeneration;
    }

    @JsonProperty("unbindStatus")
    public java.lang.String getUnbindStatus() {
        return unbindStatus;
    }

    @JsonProperty("unbindStatus")
    public void setUnbindStatus(java.lang.String unbindStatus) {
        this.unbindStatus = unbindStatus;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
