
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

/**
 * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driverConfig",
    "logLevel",
    "managementState",
    "observedConfig",
    "operatorLogLevel",
    "storageClassState",
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
public class ClusterCSIDriverSpec implements Editable<ClusterCSIDriverSpecBuilder>, KubernetesResource
{

    @JsonProperty("driverConfig")
    private CSIDriverConfigSpec driverConfig;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("storageClassState")
    private String storageClassState;
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterCSIDriverSpec() {
    }

    public ClusterCSIDriverSpec(CSIDriverConfigSpec driverConfig, String logLevel, String managementState, Object observedConfig, String operatorLogLevel, String storageClassState, Object unsupportedConfigOverrides) {
        super();
        this.driverConfig = driverConfig;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.storageClassState = storageClassState;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
     */
    @JsonProperty("driverConfig")
    public CSIDriverConfigSpec getDriverConfig() {
        return driverConfig;
    }

    /**
     * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
     */
    @JsonProperty("driverConfig")
    public void setDriverConfig(CSIDriverConfigSpec driverConfig) {
        this.driverConfig = driverConfig;
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

    /**
     * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
     */
    @JsonProperty("observedConfig")
    public Object getObservedConfig() {
        return observedConfig;
    }

    /**
     * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
     */
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
     * storageClassState determines if CSI operator should create and manage storage classes. If this field value is empty or Managed - CSI operator will continuously reconcile storage class and create if necessary. If this field value is Unmanaged - CSI operator will not reconcile any previously created storage class. If this field value is Removed - CSI operator will delete the storage class it created previously. When omitted, this means the user has no opinion and the platform chooses a reasonable default, which is subject to change over time. The current default behaviour is Managed.
     */
    @JsonProperty("storageClassState")
    public String getStorageClassState() {
        return storageClassState;
    }

    /**
     * storageClassState determines if CSI operator should create and manage storage classes. If this field value is empty or Managed - CSI operator will continuously reconcile storage class and create if necessary. If this field value is Unmanaged - CSI operator will not reconcile any previously created storage class. If this field value is Removed - CSI operator will delete the storage class it created previously. When omitted, this means the user has no opinion and the platform chooses a reasonable default, which is subject to change over time. The current default behaviour is Managed.
     */
    @JsonProperty("storageClassState")
    public void setStorageClassState(String storageClassState) {
        this.storageClassState = storageClassState;
    }

    /**
     * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
     */
    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    /**
     * ClusterCSIDriverSpec is the desired behavior of CSI driver operator
     */
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonIgnore
    public ClusterCSIDriverSpecBuilder edit() {
        return new ClusterCSIDriverSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterCSIDriverSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterCSIDriverSpec)) {
            return false;
        }
        ClusterCSIDriverSpec other = (ClusterCSIDriverSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$driverConfig = this.getDriverConfig();
        Object other$driverConfig = other.getDriverConfig();
        if (this$driverConfig == null ? other$driverConfig != null : !this$driverConfig.equals(other$driverConfig)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$managementState = this.getManagementState();
        Object other$managementState = other.getManagementState();
        if (this$managementState == null ? other$managementState != null : !this$managementState.equals(other$managementState)) {
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
        Object this$storageClassState = this.getStorageClassState();
        Object other$storageClassState = other.getStorageClassState();
        if (this$storageClassState == null ? other$storageClassState != null : !this$storageClassState.equals(other$storageClassState)) {
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
        return other instanceof ClusterCSIDriverSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $driverConfig = this.getDriverConfig();
        result = result * prime + ($driverConfig == null ? 43 : $driverConfig.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $managementState = this.getManagementState();
        result = result * prime + ($managementState == null ? 43 : $managementState.hashCode());
        Object $observedConfig = this.getObservedConfig();
        result = result * prime + ($observedConfig == null ? 43 : $observedConfig.hashCode());
        Object $operatorLogLevel = this.getOperatorLogLevel();
        result = result * prime + ($operatorLogLevel == null ? 43 : $operatorLogLevel.hashCode());
        Object $storageClassState = this.getStorageClassState();
        result = result * prime + ($storageClassState == null ? 43 : $storageClassState.hashCode());
        Object $unsupportedConfigOverrides = this.getUnsupportedConfigOverrides();
        result = result * prime + ($unsupportedConfigOverrides == null ? 43 : $unsupportedConfigOverrides.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterCSIDriverSpec(" + "driverConfig=" + this.getDriverConfig() + ", logLevel=" + this.getLogLevel() + ", managementState=" + this.getManagementState() + ", observedConfig=" + this.getObservedConfig() + ", operatorLogLevel=" + this.getOperatorLogLevel() + ", storageClassState=" + this.getStorageClassState() + ", unsupportedConfigOverrides=" + this.getUnsupportedConfigOverrides() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
