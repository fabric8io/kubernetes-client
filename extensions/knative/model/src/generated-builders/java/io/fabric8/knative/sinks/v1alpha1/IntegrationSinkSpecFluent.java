package io.fabric8.knative.sinks.v1alpha1;

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
public class IntegrationSinkSpecFluent<A extends io.fabric8.knative.sinks.v1alpha1.IntegrationSinkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AwsBuilder aws;
  private LogBuilder log;

  public IntegrationSinkSpecFluent() {
  }
  
  public IntegrationSinkSpecFluent(IntegrationSinkSpec instance) {
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
  
  public Aws buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public Log buildLog() {
    return this.log != null ? this.log.build() : null;
  }
  
  protected void copyInstance(IntegrationSinkSpec instance) {
    instance = instance != null ? instance : new IntegrationSinkSpec();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withLog(instance.getLog());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public LogNested<A> editLog() {
    return this.withNewLogLike(Optional.ofNullable(this.buildLog()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AwsBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(Aws item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public LogNested<A> editOrNewLog() {
    return this.withNewLogLike(Optional.ofNullable(this.buildLog()).orElse(new LogBuilder().build()));
  }
  
  public LogNested<A> editOrNewLogLike(Log item) {
    return this.withNewLogLike(Optional.ofNullable(this.buildLog()).orElse(item));
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
    IntegrationSinkSpecFluent that = (IntegrationSinkSpecFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(log, that.log))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasLog() {
    return this.log != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, log, additionalProperties);
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
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(log == null)) {
        sb.append("log:");
        sb.append(log);
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
  
  public A withAws(Aws aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AwsBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withLog(Log log) {
    this._visitables.remove("log");
    if (log != null) {
        this.log = new LogBuilder(log);
        this._visitables.get("log").add(this.log);
    } else {
        this.log = null;
        this._visitables.get("log").remove(this.log);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(Aws item) {
    return new AwsNested(item);
  }
  
  public LogNested<A> withNewLog() {
    return new LogNested(null);
  }
  
  public LogNested<A> withNewLogLike(Log item) {
    return new LogNested(item);
  }
  public class AwsNested<N> extends AwsFluent<AwsNested<N>> implements Nested<N>{
  
    AwsBuilder builder;
  
    AwsNested(Aws item) {
      this.builder = new AwsBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSinkSpecFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class LogNested<N> extends LogFluent<LogNested<N>> implements Nested<N>{
  
    LogBuilder builder;
  
    LogNested(Log item) {
      this.builder = new LogBuilder(this, item);
    }
  
    public N and() {
      return (N) IntegrationSinkSpecFluent.this.withLog(builder.build());
    }
    
    public N endLog() {
      return and();
    }
    
  }
}