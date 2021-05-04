
package io.fabric8.openshift.api.model.operator.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "failedRevisionLimit",
    "forceRedeploymentReason",
    "logLevel",
    "managementState",
    "observedConfig",
    "operatorLogLevel",
    "succeededRevisionLimit",
    "unsupportedConfigOverrides"
})
@ToString
@EqualsAndHashCode
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
public class EtcdSpec implements KubernetesResource
{

    @JsonProperty("failedRevisionLimit")
    private Integer failedRevisionLimit;
    @JsonProperty("forceRedeploymentReason")
    private String forceRedeploymentReason;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("observedConfig")
    private HasMetadata observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("succeededRevisionLimit")
    private Integer succeededRevisionLimit;
    @JsonProperty("unsupportedConfigOverrides")
    private HasMetadata unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EtcdSpec() {
    }

    /**
     * 
     * @param forceRedeploymentReason
     * @param logLevel
     * @param unsupportedConfigOverrides
     * @param operatorLogLevel
     * @param failedRevisionLimit
     * @param observedConfig
     * @param managementState
     * @param succeededRevisionLimit
     */
    public EtcdSpec(Integer failedRevisionLimit, String forceRedeploymentReason, String logLevel, String managementState, HasMetadata observedConfig, String operatorLogLevel, Integer succeededRevisionLimit, HasMetadata unsupportedConfigOverrides) {
        super();
        this.failedRevisionLimit = failedRevisionLimit;
        this.forceRedeploymentReason = forceRedeploymentReason;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.succeededRevisionLimit = succeededRevisionLimit;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonProperty("failedRevisionLimit")
    public Integer getFailedRevisionLimit() {
        return failedRevisionLimit;
    }

    @JsonProperty("failedRevisionLimit")
    public void setFailedRevisionLimit(Integer failedRevisionLimit) {
        this.failedRevisionLimit = failedRevisionLimit;
    }

    @JsonProperty("forceRedeploymentReason")
    public String getForceRedeploymentReason() {
        return forceRedeploymentReason;
    }

    @JsonProperty("forceRedeploymentReason")
    public void setForceRedeploymentReason(String forceRedeploymentReason) {
        this.forceRedeploymentReason = forceRedeploymentReason;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("observedConfig")
    public HasMetadata getObservedConfig() {
        return observedConfig;
    }

    @JsonProperty("observedConfig")
    public void setObservedConfig(HasMetadata observedConfig) {
        this.observedConfig = observedConfig;
    }

    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    @JsonProperty("succeededRevisionLimit")
    public Integer getSucceededRevisionLimit() {
        return succeededRevisionLimit;
    }

    @JsonProperty("succeededRevisionLimit")
    public void setSucceededRevisionLimit(Integer succeededRevisionLimit) {
        this.succeededRevisionLimit = succeededRevisionLimit;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public HasMetadata getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public void setUnsupportedConfigOverrides(HasMetadata unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
