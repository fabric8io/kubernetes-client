package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class StaticPodOperatorSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.StaticPodOperatorSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer failedRevisionLimit;
  private String forceRedeploymentReason;
  private String logLevel;
  private String managementState;
  private Object observedConfig;
  private String operatorLogLevel;
  private Integer succeededRevisionLimit;
  private Object unsupportedConfigOverrides;

  public StaticPodOperatorSpecFluent() {
  }
  
  public StaticPodOperatorSpecFluent(StaticPodOperatorSpec instance) {
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
  
  protected void copyInstance(StaticPodOperatorSpec instance) {
    instance = instance != null ? instance : new StaticPodOperatorSpec();
    if (instance != null) {
        this.withFailedRevisionLimit(instance.getFailedRevisionLimit());
        this.withForceRedeploymentReason(instance.getForceRedeploymentReason());
        this.withLogLevel(instance.getLogLevel());
        this.withManagementState(instance.getManagementState());
        this.withObservedConfig(instance.getObservedConfig());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withSucceededRevisionLimit(instance.getSucceededRevisionLimit());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
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
    StaticPodOperatorSpecFluent that = (StaticPodOperatorSpecFluent) o;
    if (!(Objects.equals(failedRevisionLimit, that.failedRevisionLimit))) {
      return false;
    }
    if (!(Objects.equals(forceRedeploymentReason, that.forceRedeploymentReason))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(observedConfig, that.observedConfig))) {
      return false;
    }
    if (!(Objects.equals(operatorLogLevel, that.operatorLogLevel))) {
      return false;
    }
    if (!(Objects.equals(succeededRevisionLimit, that.succeededRevisionLimit))) {
      return false;
    }
    if (!(Objects.equals(unsupportedConfigOverrides, that.unsupportedConfigOverrides))) {
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
  
  public Integer getFailedRevisionLimit() {
    return this.failedRevisionLimit;
  }
  
  public String getForceRedeploymentReason() {
    return this.forceRedeploymentReason;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public Object getObservedConfig() {
    return this.observedConfig;
  }
  
  public String getOperatorLogLevel() {
    return this.operatorLogLevel;
  }
  
  public Integer getSucceededRevisionLimit() {
    return this.succeededRevisionLimit;
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailedRevisionLimit() {
    return this.failedRevisionLimit != null;
  }
  
  public boolean hasForceRedeploymentReason() {
    return this.forceRedeploymentReason != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasObservedConfig() {
    return this.observedConfig != null;
  }
  
  public boolean hasOperatorLogLevel() {
    return this.operatorLogLevel != null;
  }
  
  public boolean hasSucceededRevisionLimit() {
    return this.succeededRevisionLimit != null;
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(failedRevisionLimit, forceRedeploymentReason, logLevel, managementState, observedConfig, operatorLogLevel, succeededRevisionLimit, unsupportedConfigOverrides, additionalProperties);
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
    if (!(failedRevisionLimit == null)) {
        sb.append("failedRevisionLimit:");
        sb.append(failedRevisionLimit);
        sb.append(",");
    }
    if (!(forceRedeploymentReason == null)) {
        sb.append("forceRedeploymentReason:");
        sb.append(forceRedeploymentReason);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(observedConfig == null)) {
        sb.append("observedConfig:");
        sb.append(observedConfig);
        sb.append(",");
    }
    if (!(operatorLogLevel == null)) {
        sb.append("operatorLogLevel:");
        sb.append(operatorLogLevel);
        sb.append(",");
    }
    if (!(succeededRevisionLimit == null)) {
        sb.append("succeededRevisionLimit:");
        sb.append(succeededRevisionLimit);
        sb.append(",");
    }
    if (!(unsupportedConfigOverrides == null)) {
        sb.append("unsupportedConfigOverrides:");
        sb.append(unsupportedConfigOverrides);
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
  
  public A withFailedRevisionLimit(Integer failedRevisionLimit) {
    this.failedRevisionLimit = failedRevisionLimit;
    return (A) this;
  }
  
  public A withForceRedeploymentReason(String forceRedeploymentReason) {
    this.forceRedeploymentReason = forceRedeploymentReason;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public A withObservedConfig(Object observedConfig) {
    this.observedConfig = observedConfig;
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withSucceededRevisionLimit(Integer succeededRevisionLimit) {
    this.succeededRevisionLimit = succeededRevisionLimit;
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  
}