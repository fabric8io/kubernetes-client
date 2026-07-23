package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class OperatorSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.OperatorSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String imagePullPolicy;
  private String imagePullSpec;
  private LoggingConfigBuilder logging;
  private String managementState;
  private String version;

  public OperatorSpecFluent() {
  }
  
  public OperatorSpecFluent(OperatorSpec instance) {
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
  
  public LoggingConfig buildLogging() {
    return this.logging != null ? this.logging.build() : null;
  }
  
  protected void copyInstance(OperatorSpec instance) {
    instance = instance != null ? instance : new OperatorSpec();
    if (instance != null) {
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSpec(instance.getImagePullSpec());
        this.withLogging(instance.getLogging());
        this.withManagementState(instance.getManagementState());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LoggingNested<A> editLogging() {
    return this.withNewLoggingLike(Optional.ofNullable(this.buildLogging()).orElse(null));
  }
  
  public LoggingNested<A> editOrNewLogging() {
    return this.withNewLoggingLike(Optional.ofNullable(this.buildLogging()).orElse(new LoggingConfigBuilder().build()));
  }
  
  public LoggingNested<A> editOrNewLoggingLike(LoggingConfig item) {
    return this.withNewLoggingLike(Optional.ofNullable(this.buildLogging()).orElse(item));
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
    OperatorSpecFluent that = (OperatorSpecFluent) o;
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSpec, that.imagePullSpec))) {
      return false;
    }
    if (!(Objects.equals(logging, that.logging))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSpec() {
    return this.imagePullSpec;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSpec() {
    return this.imagePullSpec != null;
  }
  
  public boolean hasLogging() {
    return this.logging != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(imagePullPolicy, imagePullSpec, logging, managementState, version, additionalProperties);
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
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSpec == null)) {
        sb.append("imagePullSpec:");
        sb.append(imagePullSpec);
        sb.append(",");
    }
    if (!(logging == null)) {
        sb.append("logging:");
        sb.append(logging);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSpec(String imagePullSpec) {
    this.imagePullSpec = imagePullSpec;
    return (A) this;
  }
  
  public A withLogging(LoggingConfig logging) {
    this._visitables.remove("logging");
    if (logging != null) {
        this.logging = new LoggingConfigBuilder(logging);
        this._visitables.get("logging").add(this.logging);
    } else {
        this.logging = null;
        this._visitables.get("logging").remove(this.logging);
    }
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public LoggingNested<A> withNewLogging() {
    return new LoggingNested(null);
  }
  
  public A withNewLogging(Long level,String vmodule) {
    return (A) this.withLogging(new LoggingConfig(level, vmodule));
  }
  
  public LoggingNested<A> withNewLoggingLike(LoggingConfig item) {
    return new LoggingNested(item);
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class LoggingNested<N> extends LoggingConfigFluent<LoggingNested<N>> implements Nested<N>{
  
    LoggingConfigBuilder builder;
  
    LoggingNested(LoggingConfig item) {
      this.builder = new LoggingConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorSpecFluent.this.withLogging(builder.build());
    }
    
    public N endLogging() {
      return and();
    }
    
  }
}