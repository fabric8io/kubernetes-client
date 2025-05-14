
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendQuotaGiB",
    "controlPlaneHardwareSpeed",
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
public class EtcdSpec implements Editable<EtcdSpecBuilder>, KubernetesResource
{

    @JsonProperty("backendQuotaGiB")
    private Integer backendQuotaGiB;
    @JsonProperty("controlPlaneHardwareSpeed")
    private String controlPlaneHardwareSpeed;
    @JsonProperty("failedRevisionLimit")
    private Integer failedRevisionLimit;
    @JsonProperty("forceRedeploymentReason")
    private String forceRedeploymentReason;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
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
    public EtcdSpec() {
    }

    public EtcdSpec(Integer backendQuotaGiB, String controlPlaneHardwareSpeed, Integer failedRevisionLimit, String forceRedeploymentReason, String logLevel, String managementState, Object observedConfig, String operatorLogLevel, Integer succeededRevisionLimit, Object unsupportedConfigOverrides) {
        super();
        this.backendQuotaGiB = backendQuotaGiB;
        this.controlPlaneHardwareSpeed = controlPlaneHardwareSpeed;
        this.failedRevisionLimit = failedRevisionLimit;
        this.forceRedeploymentReason = forceRedeploymentReason;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.succeededRevisionLimit = succeededRevisionLimit;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * backendQuotaGiB sets the etcd backend storage size limit in gibibytes. The value should be an integer not less than 8 and not more than 32. When not specified, the default value is 8.
     */
    @JsonProperty("backendQuotaGiB")
    public Integer getBackendQuotaGiB() {
        return backendQuotaGiB;
    }

    /**
     * backendQuotaGiB sets the etcd backend storage size limit in gibibytes. The value should be an integer not less than 8 and not more than 32. When not specified, the default value is 8.
     */
    @JsonProperty("backendQuotaGiB")
    public void setBackendQuotaGiB(Integer backendQuotaGiB) {
        this.backendQuotaGiB = backendQuotaGiB;
    }

    /**
     * HardwareSpeed allows user to change the etcd tuning profile which configures the latency parameters for heartbeat interval and leader election timeouts allowing the cluster to tolerate longer round-trip-times between etcd members. Valid values are "", "Standard" and "Slower".<br><p> 	"" means no opinion and the platform is left to choose a reasonable default<br><p> 	which is subject to change without notice.<br><p> <br><p> Possible enum values:<br><p>  - `"Slower"` provides more tolerance for slower hardware and/or higher latency networks. Sets (values subject to change): ETCD_HEARTBEAT_INTERVAL: 5x Standard ETCD_LEADER_ELECTION_TIMEOUT: 2.5x Standard<br><p>  - `"Standard"` provides the normal tolerances for hardware speed and latency. Currently sets (values subject to change at any time): ETCD_HEARTBEAT_INTERVAL: 100ms ETCD_LEADER_ELECTION_TIMEOUT: 1000ms
     */
    @JsonProperty("controlPlaneHardwareSpeed")
    public String getControlPlaneHardwareSpeed() {
        return controlPlaneHardwareSpeed;
    }

    /**
     * HardwareSpeed allows user to change the etcd tuning profile which configures the latency parameters for heartbeat interval and leader election timeouts allowing the cluster to tolerate longer round-trip-times between etcd members. Valid values are "", "Standard" and "Slower".<br><p> 	"" means no opinion and the platform is left to choose a reasonable default<br><p> 	which is subject to change without notice.<br><p> <br><p> Possible enum values:<br><p>  - `"Slower"` provides more tolerance for slower hardware and/or higher latency networks. Sets (values subject to change): ETCD_HEARTBEAT_INTERVAL: 5x Standard ETCD_LEADER_ELECTION_TIMEOUT: 2.5x Standard<br><p>  - `"Standard"` provides the normal tolerances for hardware speed and latency. Currently sets (values subject to change at any time): ETCD_HEARTBEAT_INTERVAL: 100ms ETCD_LEADER_ELECTION_TIMEOUT: 1000ms
     */
    @JsonProperty("controlPlaneHardwareSpeed")
    public void setControlPlaneHardwareSpeed(String controlPlaneHardwareSpeed) {
        this.controlPlaneHardwareSpeed = controlPlaneHardwareSpeed;
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
    public EtcdSpecBuilder edit() {
        return new EtcdSpecBuilder(this);
    }

    @JsonIgnore
    public EtcdSpecBuilder toBuilder() {
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
