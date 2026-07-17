package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ClusterCSIDriverSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CSIDriverConfigSpecBuilder driverConfig;
  private String logLevel;
  private String managementState;
  private Object observedConfig;
  private String operatorLogLevel;
  private String storageClassState;
  private Object unsupportedConfigOverrides;

  public ClusterCSIDriverSpecFluent() {
  }
  
  public ClusterCSIDriverSpecFluent(ClusterCSIDriverSpec instance) {
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
  
  public CSIDriverConfigSpec buildDriverConfig() {
    return this.driverConfig != null ? this.driverConfig.build() : null;
  }
  
  protected void copyInstance(ClusterCSIDriverSpec instance) {
    instance = instance != null ? instance : new ClusterCSIDriverSpec();
    if (instance != null) {
        this.withDriverConfig(instance.getDriverConfig());
        this.withLogLevel(instance.getLogLevel());
        this.withManagementState(instance.getManagementState());
        this.withObservedConfig(instance.getObservedConfig());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withStorageClassState(instance.getStorageClassState());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DriverConfigNested<A> editDriverConfig() {
    return this.withNewDriverConfigLike(Optional.ofNullable(this.buildDriverConfig()).orElse(null));
  }
  
  public DriverConfigNested<A> editOrNewDriverConfig() {
    return this.withNewDriverConfigLike(Optional.ofNullable(this.buildDriverConfig()).orElse(new CSIDriverConfigSpecBuilder().build()));
  }
  
  public DriverConfigNested<A> editOrNewDriverConfigLike(CSIDriverConfigSpec item) {
    return this.withNewDriverConfigLike(Optional.ofNullable(this.buildDriverConfig()).orElse(item));
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
    ClusterCSIDriverSpecFluent that = (ClusterCSIDriverSpecFluent) o;
    if (!(Objects.equals(driverConfig, that.driverConfig))) {
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
    if (!(Objects.equals(storageClassState, that.storageClassState))) {
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
  
  public String getStorageClassState() {
    return this.storageClassState;
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDriverConfig() {
    return this.driverConfig != null;
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
  
  public boolean hasStorageClassState() {
    return this.storageClassState != null;
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(driverConfig, logLevel, managementState, observedConfig, operatorLogLevel, storageClassState, unsupportedConfigOverrides, additionalProperties);
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
    if (!(driverConfig == null)) {
        sb.append("driverConfig:");
        sb.append(driverConfig);
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
    if (!(storageClassState == null)) {
        sb.append("storageClassState:");
        sb.append(storageClassState);
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
  
  public A withDriverConfig(CSIDriverConfigSpec driverConfig) {
    this._visitables.remove("driverConfig");
    if (driverConfig != null) {
        this.driverConfig = new CSIDriverConfigSpecBuilder(driverConfig);
        this._visitables.get("driverConfig").add(this.driverConfig);
    } else {
        this.driverConfig = null;
        this._visitables.get("driverConfig").remove(this.driverConfig);
    }
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
  
  public DriverConfigNested<A> withNewDriverConfig() {
    return new DriverConfigNested(null);
  }
  
  public DriverConfigNested<A> withNewDriverConfigLike(CSIDriverConfigSpec item) {
    return new DriverConfigNested(item);
  }
  
  public A withObservedConfig(Object observedConfig) {
    this.observedConfig = observedConfig;
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withStorageClassState(String storageClassState) {
    this.storageClassState = storageClassState;
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  public class DriverConfigNested<N> extends CSIDriverConfigSpecFluent<DriverConfigNested<N>> implements Nested<N>{
  
    CSIDriverConfigSpecBuilder builder;
  
    DriverConfigNested(CSIDriverConfigSpec item) {
      this.builder = new CSIDriverConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterCSIDriverSpecFluent.this.withDriverConfig(builder.build());
    }
    
    public N endDriverConfig() {
      return and();
    }
    
  }
}