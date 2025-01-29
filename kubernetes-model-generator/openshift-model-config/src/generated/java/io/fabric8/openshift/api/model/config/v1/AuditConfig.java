
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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

    @JsonProperty("auditFilePath")
    public String getAuditFilePath() {
        return auditFilePath;
    }

    @JsonProperty("auditFilePath")
    public void setAuditFilePath(String auditFilePath) {
        this.auditFilePath = auditFilePath;
    }

    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    @JsonProperty("maximumFileRetentionDays")
    public Integer getMaximumFileRetentionDays() {
        return maximumFileRetentionDays;
    }

    @JsonProperty("maximumFileRetentionDays")
    public void setMaximumFileRetentionDays(Integer maximumFileRetentionDays) {
        this.maximumFileRetentionDays = maximumFileRetentionDays;
    }

    @JsonProperty("maximumFileSizeMegabytes")
    public Integer getMaximumFileSizeMegabytes() {
        return maximumFileSizeMegabytes;
    }

    @JsonProperty("maximumFileSizeMegabytes")
    public void setMaximumFileSizeMegabytes(Integer maximumFileSizeMegabytes) {
        this.maximumFileSizeMegabytes = maximumFileSizeMegabytes;
    }

    @JsonProperty("maximumRetainedFiles")
    public Integer getMaximumRetainedFiles() {
        return maximumRetainedFiles;
    }

    @JsonProperty("maximumRetainedFiles")
    public void setMaximumRetainedFiles(Integer maximumRetainedFiles) {
        this.maximumRetainedFiles = maximumRetainedFiles;
    }

    @JsonProperty("policyConfiguration")
    public Object getPolicyConfiguration() {
        return policyConfiguration;
    }

    @JsonProperty("policyConfiguration")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setPolicyConfiguration(Object policyConfiguration) {
        this.policyConfiguration = policyConfiguration;
    }

    @JsonProperty("policyFile")
    public String getPolicyFile() {
        return policyFile;
    }

    @JsonProperty("policyFile")
    public void setPolicyFile(String policyFile) {
        this.policyFile = policyFile;
    }

    @JsonProperty("webHookKubeConfig")
    public String getWebHookKubeConfig() {
        return webHookKubeConfig;
    }

    @JsonProperty("webHookKubeConfig")
    public void setWebHookKubeConfig(String webHookKubeConfig) {
        this.webHookKubeConfig = webHookKubeConfig;
    }

    @JsonProperty("webHookMode")
    public String getWebHookMode() {
        return webHookMode;
    }

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
