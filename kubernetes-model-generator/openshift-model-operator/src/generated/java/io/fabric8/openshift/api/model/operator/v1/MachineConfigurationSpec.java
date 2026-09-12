
package io.fabric8.openshift.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failedRevisionLimit",
    "forceRedeploymentReason",
    "irreconcilableValidationOverrides",
    "logLevel",
    "managedBootImages",
    "managementState",
    "nodeDisruptionPolicy",
    "observedConfig",
    "operatorLogLevel",
    "succeededRevisionLimit",
    "unsupportedConfigOverrides"
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
public class MachineConfigurationSpec implements Editable<MachineConfigurationSpecBuilder>, KubernetesResource
{

    @JsonProperty("failedRevisionLimit")
    private Integer failedRevisionLimit;
    @JsonProperty("forceRedeploymentReason")
    private String forceRedeploymentReason;
    @JsonProperty("irreconcilableValidationOverrides")
    private IrreconcilableValidationOverrides irreconcilableValidationOverrides;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managedBootImages")
    private ManagedBootImages managedBootImages;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("nodeDisruptionPolicy")
    private NodeDisruptionPolicyConfig nodeDisruptionPolicy;
    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("succeededRevisionLimit")
    private Integer succeededRevisionLimit;
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigurationSpec() {
    }

    public MachineConfigurationSpec(Integer failedRevisionLimit, String forceRedeploymentReason, IrreconcilableValidationOverrides irreconcilableValidationOverrides, String logLevel, ManagedBootImages managedBootImages, String managementState, NodeDisruptionPolicyConfig nodeDisruptionPolicy, Object observedConfig, String operatorLogLevel, Integer succeededRevisionLimit, Object unsupportedConfigOverrides) {
        super();
        this.failedRevisionLimit = failedRevisionLimit;
        this.forceRedeploymentReason = forceRedeploymentReason;
        this.irreconcilableValidationOverrides = irreconcilableValidationOverrides;
        this.logLevel = logLevel;
        this.managedBootImages = managedBootImages;
        this.managementState = managementState;
        this.nodeDisruptionPolicy = nodeDisruptionPolicy;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.succeededRevisionLimit = succeededRevisionLimit;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * failedRevisionLimit is the number of failed static pod installer revisions to keep on disk and in the api -1 = unlimited, 0 or unset = 5 (default)
     */
    @JsonProperty("failedRevisionLimit")
    public Integer getFailedRevisionLimit() {
        return failedRevisionLimit;
    }

    /**
     * failedRevisionLimit is the number of failed static pod installer revisions to keep on disk and in the api -1 = unlimited, 0 or unset = 5 (default)
     */
    @JsonProperty("failedRevisionLimit")
    public void setFailedRevisionLimit(Integer failedRevisionLimit) {
        this.failedRevisionLimit = failedRevisionLimit;
    }

    /**
     * forceRedeploymentReason can be used to force the redeployment of the operand by providing a unique string. This provides a mechanism to kick a previously failed deployment and provide a reason why you think it will work this time instead of failing again on the same config.
     */
    @JsonProperty("forceRedeploymentReason")
    public String getForceRedeploymentReason() {
        return forceRedeploymentReason;
    }

    /**
     * forceRedeploymentReason can be used to force the redeployment of the operand by providing a unique string. This provides a mechanism to kick a previously failed deployment and provide a reason why you think it will work this time instead of failing again on the same config.
     */
    @JsonProperty("forceRedeploymentReason")
    public void setForceRedeploymentReason(String forceRedeploymentReason) {
        this.forceRedeploymentReason = forceRedeploymentReason;
    }

    @JsonProperty("irreconcilableValidationOverrides")
    public IrreconcilableValidationOverrides getIrreconcilableValidationOverrides() {
        return irreconcilableValidationOverrides;
    }

    @JsonProperty("irreconcilableValidationOverrides")
    public void setIrreconcilableValidationOverrides(IrreconcilableValidationOverrides irreconcilableValidationOverrides) {
        this.irreconcilableValidationOverrides = irreconcilableValidationOverrides;
    }

    /**
     * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("managedBootImages")
    public ManagedBootImages getManagedBootImages() {
        return managedBootImages;
    }

    @JsonProperty("managedBootImages")
    public void setManagedBootImages(ManagedBootImages managedBootImages) {
        this.managedBootImages = managedBootImages;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("nodeDisruptionPolicy")
    public NodeDisruptionPolicyConfig getNodeDisruptionPolicy() {
        return nodeDisruptionPolicy;
    }

    @JsonProperty("nodeDisruptionPolicy")
    public void setNodeDisruptionPolicy(NodeDisruptionPolicyConfig nodeDisruptionPolicy) {
        this.nodeDisruptionPolicy = nodeDisruptionPolicy;
    }

    @JsonProperty("observedConfig")
    public Object getObservedConfig() {
        return observedConfig;
    }

    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setObservedConfig(Object observedConfig) {
        this.observedConfig = observedConfig;
    }

    /**
     * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    /**
     * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    /**
     * succeededRevisionLimit is the number of successful static pod installer revisions to keep on disk and in the api -1 = unlimited, 0 or unset = 5 (default)
     */
    @JsonProperty("succeededRevisionLimit")
    public Integer getSucceededRevisionLimit() {
        return succeededRevisionLimit;
    }

    /**
     * succeededRevisionLimit is the number of successful static pod installer revisions to keep on disk and in the api -1 = unlimited, 0 or unset = 5 (default)
     */
    @JsonProperty("succeededRevisionLimit")
    public void setSucceededRevisionLimit(Integer succeededRevisionLimit) {
        this.succeededRevisionLimit = succeededRevisionLimit;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonIgnore
    public MachineConfigurationSpecBuilder edit() {
        return new MachineConfigurationSpecBuilder(this);
    }

    @JsonIgnore
    public MachineConfigurationSpecBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigurationSpec)) {
            return false;
        }
        MachineConfigurationSpec other = (MachineConfigurationSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failedRevisionLimit = this.getFailedRevisionLimit();
        Object other$failedRevisionLimit = other.getFailedRevisionLimit();
        if (this$failedRevisionLimit == null ? other$failedRevisionLimit != null : !this$failedRevisionLimit.equals(other$failedRevisionLimit)) {
            return false;
        }
        Object this$forceRedeploymentReason = this.getForceRedeploymentReason();
        Object other$forceRedeploymentReason = other.getForceRedeploymentReason();
        if (this$forceRedeploymentReason == null ? other$forceRedeploymentReason != null : !this$forceRedeploymentReason.equals(other$forceRedeploymentReason)) {
            return false;
        }
        Object this$irreconcilableValidationOverrides = this.getIrreconcilableValidationOverrides();
        Object other$irreconcilableValidationOverrides = other.getIrreconcilableValidationOverrides();
        if (this$irreconcilableValidationOverrides == null ? other$irreconcilableValidationOverrides != null : !this$irreconcilableValidationOverrides.equals(other$irreconcilableValidationOverrides)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$managedBootImages = this.getManagedBootImages();
        Object other$managedBootImages = other.getManagedBootImages();
        if (this$managedBootImages == null ? other$managedBootImages != null : !this$managedBootImages.equals(other$managedBootImages)) {
            return false;
        }
        Object this$managementState = this.getManagementState();
        Object other$managementState = other.getManagementState();
        if (this$managementState == null ? other$managementState != null : !this$managementState.equals(other$managementState)) {
            return false;
        }
        Object this$nodeDisruptionPolicy = this.getNodeDisruptionPolicy();
        Object other$nodeDisruptionPolicy = other.getNodeDisruptionPolicy();
        if (this$nodeDisruptionPolicy == null ? other$nodeDisruptionPolicy != null : !this$nodeDisruptionPolicy.equals(other$nodeDisruptionPolicy)) {
            return false;
        }
        Object this$observedConfig = this.getObservedConfig();
        Object other$observedConfig = other.getObservedConfig();
        if (this$observedConfig == null ? other$observedConfig != null : !this$observedConfig.equals(other$observedConfig)) {
            return false;
        }
        Object this$operatorLogLevel = this.getOperatorLogLevel();
        Object other$operatorLogLevel = other.getOperatorLogLevel();
        if (this$operatorLogLevel == null ? other$operatorLogLevel != null : !this$operatorLogLevel.equals(other$operatorLogLevel)) {
            return false;
        }
        Object this$succeededRevisionLimit = this.getSucceededRevisionLimit();
        Object other$succeededRevisionLimit = other.getSucceededRevisionLimit();
        if (this$succeededRevisionLimit == null ? other$succeededRevisionLimit != null : !this$succeededRevisionLimit.equals(other$succeededRevisionLimit)) {
            return false;
        }
        Object this$unsupportedConfigOverrides = this.getUnsupportedConfigOverrides();
        Object other$unsupportedConfigOverrides = other.getUnsupportedConfigOverrides();
        if (this$unsupportedConfigOverrides == null ? other$unsupportedConfigOverrides != null : !this$unsupportedConfigOverrides.equals(other$unsupportedConfigOverrides)) {
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
        return other instanceof MachineConfigurationSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failedRevisionLimit = this.getFailedRevisionLimit();
        result = result * prime + ($failedRevisionLimit == null ? 43 : $failedRevisionLimit.hashCode());
        Object $forceRedeploymentReason = this.getForceRedeploymentReason();
        result = result * prime + ($forceRedeploymentReason == null ? 43 : $forceRedeploymentReason.hashCode());
        Object $irreconcilableValidationOverrides = this.getIrreconcilableValidationOverrides();
        result = result * prime + ($irreconcilableValidationOverrides == null ? 43 : $irreconcilableValidationOverrides.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $managedBootImages = this.getManagedBootImages();
        result = result * prime + ($managedBootImages == null ? 43 : $managedBootImages.hashCode());
        Object $managementState = this.getManagementState();
        result = result * prime + ($managementState == null ? 43 : $managementState.hashCode());
        Object $nodeDisruptionPolicy = this.getNodeDisruptionPolicy();
        result = result * prime + ($nodeDisruptionPolicy == null ? 43 : $nodeDisruptionPolicy.hashCode());
        Object $observedConfig = this.getObservedConfig();
        result = result * prime + ($observedConfig == null ? 43 : $observedConfig.hashCode());
        Object $operatorLogLevel = this.getOperatorLogLevel();
        result = result * prime + ($operatorLogLevel == null ? 43 : $operatorLogLevel.hashCode());
        Object $succeededRevisionLimit = this.getSucceededRevisionLimit();
        result = result * prime + ($succeededRevisionLimit == null ? 43 : $succeededRevisionLimit.hashCode());
        Object $unsupportedConfigOverrides = this.getUnsupportedConfigOverrides();
        result = result * prime + ($unsupportedConfigOverrides == null ? 43 : $unsupportedConfigOverrides.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigurationSpec(" + "failedRevisionLimit=" + this.getFailedRevisionLimit() + ", forceRedeploymentReason=" + this.getForceRedeploymentReason() + ", irreconcilableValidationOverrides=" + this.getIrreconcilableValidationOverrides() + ", logLevel=" + this.getLogLevel() + ", managedBootImages=" + this.getManagedBootImages() + ", managementState=" + this.getManagementState() + ", nodeDisruptionPolicy=" + this.getNodeDisruptionPolicy() + ", observedConfig=" + this.getObservedConfig() + ", operatorLogLevel=" + this.getOperatorLogLevel() + ", succeededRevisionLimit=" + this.getSucceededRevisionLimit() + ", unsupportedConfigOverrides=" + this.getUnsupportedConfigOverrides() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
