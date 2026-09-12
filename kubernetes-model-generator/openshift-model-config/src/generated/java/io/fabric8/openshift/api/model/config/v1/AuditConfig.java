
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AuditConfig holds configuration for the audit capabilities
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "auditFilePath",
    "enabled",
    "logFormat",
    "maximumFileRetentionDays",
    "maximumFileSizeMegabytes",
    "maximumRetainedFiles",
    "policyConfiguration",
    "policyFile",
    "webHookKubeConfig",
    "webHookMode"
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
public class AuditConfig implements Editable<AuditConfigBuilder>, KubernetesResource
{

    @JsonProperty("auditFilePath")
    private String auditFilePath;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("logFormat")
    private String logFormat;
    @JsonProperty("maximumFileRetentionDays")
    private Integer maximumFileRetentionDays;
    @JsonProperty("maximumFileSizeMegabytes")
    private Integer maximumFileSizeMegabytes;
    @JsonProperty("maximumRetainedFiles")
    private Integer maximumRetainedFiles;
    @JsonProperty("policyConfiguration")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object policyConfiguration;
    @JsonProperty("policyFile")
    private String policyFile;
    @JsonProperty("webHookKubeConfig")
    private String webHookKubeConfig;
    @JsonProperty("webHookMode")
    private String webHookMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuditConfig() {
    }

    public AuditConfig(String auditFilePath, Boolean enabled, String logFormat, Integer maximumFileRetentionDays, Integer maximumFileSizeMegabytes, Integer maximumRetainedFiles, Object policyConfiguration, String policyFile, String webHookKubeConfig, String webHookMode) {
        super();
        this.auditFilePath = auditFilePath;
        this.enabled = enabled;
        this.logFormat = logFormat;
        this.maximumFileRetentionDays = maximumFileRetentionDays;
        this.maximumFileSizeMegabytes = maximumFileSizeMegabytes;
        this.maximumRetainedFiles = maximumRetainedFiles;
        this.policyConfiguration = policyConfiguration;
        this.policyFile = policyFile;
        this.webHookKubeConfig = webHookKubeConfig;
        this.webHookMode = webHookMode;
    }

    /**
     * All requests coming to the apiserver will be logged to this file.
     */
    @JsonProperty("auditFilePath")
    public String getAuditFilePath() {
        return auditFilePath;
    }

    /**
     * All requests coming to the apiserver will be logged to this file.
     */
    @JsonProperty("auditFilePath")
    public void setAuditFilePath(String auditFilePath) {
        this.auditFilePath = auditFilePath;
    }

    /**
     * If this flag is set, audit log will be printed in the logs. The logs contains, method, user and a requested URL.
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * If this flag is set, audit log will be printed in the logs. The logs contains, method, user and a requested URL.
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Format of saved audits (legacy or json).
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * Format of saved audits (legacy or json).
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * Maximum number of days to retain old log files based on the timestamp encoded in their filename.
     */
    @JsonProperty("maximumFileRetentionDays")
    public Integer getMaximumFileRetentionDays() {
        return maximumFileRetentionDays;
    }

    /**
     * Maximum number of days to retain old log files based on the timestamp encoded in their filename.
     */
    @JsonProperty("maximumFileRetentionDays")
    public void setMaximumFileRetentionDays(Integer maximumFileRetentionDays) {
        this.maximumFileRetentionDays = maximumFileRetentionDays;
    }

    /**
     * Maximum size in megabytes of the log file before it gets rotated. Defaults to 100MB.
     */
    @JsonProperty("maximumFileSizeMegabytes")
    public Integer getMaximumFileSizeMegabytes() {
        return maximumFileSizeMegabytes;
    }

    /**
     * Maximum size in megabytes of the log file before it gets rotated. Defaults to 100MB.
     */
    @JsonProperty("maximumFileSizeMegabytes")
    public void setMaximumFileSizeMegabytes(Integer maximumFileSizeMegabytes) {
        this.maximumFileSizeMegabytes = maximumFileSizeMegabytes;
    }

    /**
     * Maximum number of old log files to retain.
     */
    @JsonProperty("maximumRetainedFiles")
    public Integer getMaximumRetainedFiles() {
        return maximumRetainedFiles;
    }

    /**
     * Maximum number of old log files to retain.
     */
    @JsonProperty("maximumRetainedFiles")
    public void setMaximumRetainedFiles(Integer maximumRetainedFiles) {
        this.maximumRetainedFiles = maximumRetainedFiles;
    }

    /**
     * AuditConfig holds configuration for the audit capabilities
     */
    @JsonProperty("policyConfiguration")
    public Object getPolicyConfiguration() {
        return policyConfiguration;
    }

    /**
     * AuditConfig holds configuration for the audit capabilities
     */
    @JsonProperty("policyConfiguration")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setPolicyConfiguration(Object policyConfiguration) {
        this.policyConfiguration = policyConfiguration;
    }

    /**
     * policyFile is a path to the file that defines the audit policy configuration.
     */
    @JsonProperty("policyFile")
    public String getPolicyFile() {
        return policyFile;
    }

    /**
     * policyFile is a path to the file that defines the audit policy configuration.
     */
    @JsonProperty("policyFile")
    public void setPolicyFile(String policyFile) {
        this.policyFile = policyFile;
    }

    /**
     * Path to a .kubeconfig formatted file that defines the audit webhook configuration.
     */
    @JsonProperty("webHookKubeConfig")
    public String getWebHookKubeConfig() {
        return webHookKubeConfig;
    }

    /**
     * Path to a .kubeconfig formatted file that defines the audit webhook configuration.
     */
    @JsonProperty("webHookKubeConfig")
    public void setWebHookKubeConfig(String webHookKubeConfig) {
        this.webHookKubeConfig = webHookKubeConfig;
    }

    /**
     * Strategy for sending audit events (block or batch).
     */
    @JsonProperty("webHookMode")
    public String getWebHookMode() {
        return webHookMode;
    }

    /**
     * Strategy for sending audit events (block or batch).
     */
    @JsonProperty("webHookMode")
    public void setWebHookMode(String webHookMode) {
        this.webHookMode = webHookMode;
    }

    @JsonIgnore
    public AuditConfigBuilder edit() {
        return new AuditConfigBuilder(this);
    }

    @JsonIgnore
    public AuditConfigBuilder toBuilder() {
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
        if (!(o instanceof AuditConfig)) {
            return false;
        }
        AuditConfig other = (AuditConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$auditFilePath = this.getAuditFilePath();
        Object other$auditFilePath = other.getAuditFilePath();
        if (this$auditFilePath == null ? other$auditFilePath != null : !this$auditFilePath.equals(other$auditFilePath)) {
            return false;
        }
        Object this$enabled = this.getEnabled();
        Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) {
            return false;
        }
        Object this$logFormat = this.getLogFormat();
        Object other$logFormat = other.getLogFormat();
        if (this$logFormat == null ? other$logFormat != null : !this$logFormat.equals(other$logFormat)) {
            return false;
        }
        Object this$maximumFileRetentionDays = this.getMaximumFileRetentionDays();
        Object other$maximumFileRetentionDays = other.getMaximumFileRetentionDays();
        if (this$maximumFileRetentionDays == null ? other$maximumFileRetentionDays != null : !this$maximumFileRetentionDays.equals(other$maximumFileRetentionDays)) {
            return false;
        }
        Object this$maximumFileSizeMegabytes = this.getMaximumFileSizeMegabytes();
        Object other$maximumFileSizeMegabytes = other.getMaximumFileSizeMegabytes();
        if (this$maximumFileSizeMegabytes == null ? other$maximumFileSizeMegabytes != null : !this$maximumFileSizeMegabytes.equals(other$maximumFileSizeMegabytes)) {
            return false;
        }
        Object this$maximumRetainedFiles = this.getMaximumRetainedFiles();
        Object other$maximumRetainedFiles = other.getMaximumRetainedFiles();
        if (this$maximumRetainedFiles == null ? other$maximumRetainedFiles != null : !this$maximumRetainedFiles.equals(other$maximumRetainedFiles)) {
            return false;
        }
        Object this$policyConfiguration = this.getPolicyConfiguration();
        Object other$policyConfiguration = other.getPolicyConfiguration();
        if (this$policyConfiguration == null ? other$policyConfiguration != null : !this$policyConfiguration.equals(other$policyConfiguration)) {
            return false;
        }
        Object this$policyFile = this.getPolicyFile();
        Object other$policyFile = other.getPolicyFile();
        if (this$policyFile == null ? other$policyFile != null : !this$policyFile.equals(other$policyFile)) {
            return false;
        }
        Object this$webHookKubeConfig = this.getWebHookKubeConfig();
        Object other$webHookKubeConfig = other.getWebHookKubeConfig();
        if (this$webHookKubeConfig == null ? other$webHookKubeConfig != null : !this$webHookKubeConfig.equals(other$webHookKubeConfig)) {
            return false;
        }
        Object this$webHookMode = this.getWebHookMode();
        Object other$webHookMode = other.getWebHookMode();
        if (this$webHookMode == null ? other$webHookMode != null : !this$webHookMode.equals(other$webHookMode)) {
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
        return other instanceof AuditConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $auditFilePath = this.getAuditFilePath();
        result = result * prime + ($auditFilePath == null ? 43 : $auditFilePath.hashCode());
        Object $enabled = this.getEnabled();
        result = result * prime + ($enabled == null ? 43 : $enabled.hashCode());
        Object $logFormat = this.getLogFormat();
        result = result * prime + ($logFormat == null ? 43 : $logFormat.hashCode());
        Object $maximumFileRetentionDays = this.getMaximumFileRetentionDays();
        result = result * prime + ($maximumFileRetentionDays == null ? 43 : $maximumFileRetentionDays.hashCode());
        Object $maximumFileSizeMegabytes = this.getMaximumFileSizeMegabytes();
        result = result * prime + ($maximumFileSizeMegabytes == null ? 43 : $maximumFileSizeMegabytes.hashCode());
        Object $maximumRetainedFiles = this.getMaximumRetainedFiles();
        result = result * prime + ($maximumRetainedFiles == null ? 43 : $maximumRetainedFiles.hashCode());
        Object $policyConfiguration = this.getPolicyConfiguration();
        result = result * prime + ($policyConfiguration == null ? 43 : $policyConfiguration.hashCode());
        Object $policyFile = this.getPolicyFile();
        result = result * prime + ($policyFile == null ? 43 : $policyFile.hashCode());
        Object $webHookKubeConfig = this.getWebHookKubeConfig();
        result = result * prime + ($webHookKubeConfig == null ? 43 : $webHookKubeConfig.hashCode());
        Object $webHookMode = this.getWebHookMode();
        result = result * prime + ($webHookMode == null ? 43 : $webHookMode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AuditConfig(" + "auditFilePath=" + this.getAuditFilePath() + ", enabled=" + this.getEnabled() + ", logFormat=" + this.getLogFormat() + ", maximumFileRetentionDays=" + this.getMaximumFileRetentionDays() + ", maximumFileSizeMegabytes=" + this.getMaximumFileSizeMegabytes() + ", maximumRetainedFiles=" + this.getMaximumRetainedFiles() + ", policyConfiguration=" + this.getPolicyConfiguration() + ", policyFile=" + this.getPolicyFile() + ", webHookKubeConfig=" + this.getWebHookKubeConfig() + ", webHookMode=" + this.getWebHookMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
