package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AuditConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.AuditConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String auditFilePath;
  private Boolean enabled;
  private String logFormat;
  private Integer maximumFileRetentionDays;
  private Integer maximumFileSizeMegabytes;
  private Integer maximumRetainedFiles;
  private Object policyConfiguration;
  private String policyFile;
  private String webHookKubeConfig;
  private String webHookMode;

  public AuditConfigFluent() {
  }
  
  public AuditConfigFluent(AuditConfig instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(AuditConfig instance) {
    instance = instance != null ? instance : new AuditConfig();
    if (instance != null) {
        this.withAuditFilePath(instance.getAuditFilePath());
        this.withEnabled(instance.getEnabled());
        this.withLogFormat(instance.getLogFormat());
        this.withMaximumFileRetentionDays(instance.getMaximumFileRetentionDays());
        this.withMaximumFileSizeMegabytes(instance.getMaximumFileSizeMegabytes());
        this.withMaximumRetainedFiles(instance.getMaximumRetainedFiles());
        this.withPolicyConfiguration(instance.getPolicyConfiguration());
        this.withPolicyFile(instance.getPolicyFile());
        this.withWebHookKubeConfig(instance.getWebHookKubeConfig());
        this.withWebHookMode(instance.getWebHookMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    AuditConfigFluent that = (AuditConfigFluent) o;
    if (!(Objects.equals(auditFilePath, that.auditFilePath))) {
      return false;
    }
    if (!(Objects.equals(enabled, that.enabled))) {
      return false;
    }
    if (!(Objects.equals(logFormat, that.logFormat))) {
      return false;
    }
    if (!(Objects.equals(maximumFileRetentionDays, that.maximumFileRetentionDays))) {
      return false;
    }
    if (!(Objects.equals(maximumFileSizeMegabytes, that.maximumFileSizeMegabytes))) {
      return false;
    }
    if (!(Objects.equals(maximumRetainedFiles, that.maximumRetainedFiles))) {
      return false;
    }
    if (!(Objects.equals(policyConfiguration, that.policyConfiguration))) {
      return false;
    }
    if (!(Objects.equals(policyFile, that.policyFile))) {
      return false;
    }
    if (!(Objects.equals(webHookKubeConfig, that.webHookKubeConfig))) {
      return false;
    }
    if (!(Objects.equals(webHookMode, that.webHookMode))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getAuditFilePath() {
    return this.auditFilePath;
  }
  
  public Boolean getEnabled() {
    return this.enabled;
  }
  
  public String getLogFormat() {
    return this.logFormat;
  }
  
  public Integer getMaximumFileRetentionDays() {
    return this.maximumFileRetentionDays;
  }
  
  public Integer getMaximumFileSizeMegabytes() {
    return this.maximumFileSizeMegabytes;
  }
  
  public Integer getMaximumRetainedFiles() {
    return this.maximumRetainedFiles;
  }
  
  public Object getPolicyConfiguration() {
    return this.policyConfiguration;
  }
  
  public String getPolicyFile() {
    return this.policyFile;
  }
  
  public String getWebHookKubeConfig() {
    return this.webHookKubeConfig;
  }
  
  public String getWebHookMode() {
    return this.webHookMode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuditFilePath() {
    return this.auditFilePath != null;
  }
  
  public boolean hasEnabled() {
    return this.enabled != null;
  }
  
  public boolean hasLogFormat() {
    return this.logFormat != null;
  }
  
  public boolean hasMaximumFileRetentionDays() {
    return this.maximumFileRetentionDays != null;
  }
  
  public boolean hasMaximumFileSizeMegabytes() {
    return this.maximumFileSizeMegabytes != null;
  }
  
  public boolean hasMaximumRetainedFiles() {
    return this.maximumRetainedFiles != null;
  }
  
  public boolean hasPolicyConfiguration() {
    return this.policyConfiguration != null;
  }
  
  public boolean hasPolicyFile() {
    return this.policyFile != null;
  }
  
  public boolean hasWebHookKubeConfig() {
    return this.webHookKubeConfig != null;
  }
  
  public boolean hasWebHookMode() {
    return this.webHookMode != null;
  }
  
  public int hashCode() {
    return Objects.hash(auditFilePath, enabled, logFormat, maximumFileRetentionDays, maximumFileSizeMegabytes, maximumRetainedFiles, policyConfiguration, policyFile, webHookKubeConfig, webHookMode, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(auditFilePath == null)) {
        sb.append("auditFilePath:");
        sb.append(auditFilePath);
        sb.append(",");
    }
    if (!(enabled == null)) {
        sb.append("enabled:");
        sb.append(enabled);
        sb.append(",");
    }
    if (!(logFormat == null)) {
        sb.append("logFormat:");
        sb.append(logFormat);
        sb.append(",");
    }
    if (!(maximumFileRetentionDays == null)) {
        sb.append("maximumFileRetentionDays:");
        sb.append(maximumFileRetentionDays);
        sb.append(",");
    }
    if (!(maximumFileSizeMegabytes == null)) {
        sb.append("maximumFileSizeMegabytes:");
        sb.append(maximumFileSizeMegabytes);
        sb.append(",");
    }
    if (!(maximumRetainedFiles == null)) {
        sb.append("maximumRetainedFiles:");
        sb.append(maximumRetainedFiles);
        sb.append(",");
    }
    if (!(policyConfiguration == null)) {
        sb.append("policyConfiguration:");
        sb.append(policyConfiguration);
        sb.append(",");
    }
    if (!(policyFile == null)) {
        sb.append("policyFile:");
        sb.append(policyFile);
        sb.append(",");
    }
    if (!(webHookKubeConfig == null)) {
        sb.append("webHookKubeConfig:");
        sb.append(webHookKubeConfig);
        sb.append(",");
    }
    if (!(webHookMode == null)) {
        sb.append("webHookMode:");
        sb.append(webHookMode);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAuditFilePath(String auditFilePath) {
    this.auditFilePath = auditFilePath;
    return (A) this;
  }
  
  public A withEnabled() {
    return withEnabled(true);
  }
  
  public A withEnabled(Boolean enabled) {
    this.enabled = enabled;
    return (A) this;
  }
  
  public A withLogFormat(String logFormat) {
    this.logFormat = logFormat;
    return (A) this;
  }
  
  public A withMaximumFileRetentionDays(Integer maximumFileRetentionDays) {
    this.maximumFileRetentionDays = maximumFileRetentionDays;
    return (A) this;
  }
  
  public A withMaximumFileSizeMegabytes(Integer maximumFileSizeMegabytes) {
    this.maximumFileSizeMegabytes = maximumFileSizeMegabytes;
    return (A) this;
  }
  
  public A withMaximumRetainedFiles(Integer maximumRetainedFiles) {
    this.maximumRetainedFiles = maximumRetainedFiles;
    return (A) this;
  }
  
  public A withPolicyConfiguration(Object policyConfiguration) {
    this.policyConfiguration = policyConfiguration;
    return (A) this;
  }
  
  public A withPolicyFile(String policyFile) {
    this.policyFile = policyFile;
    return (A) this;
  }
  
  public A withWebHookKubeConfig(String webHookKubeConfig) {
    this.webHookKubeConfig = webHookKubeConfig;
    return (A) this;
  }
  
  public A withWebHookMode(String webHookMode) {
    this.webHookMode = webHookMode;
    return (A) this;
  }
  
}