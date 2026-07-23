package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class ReadinessProbeExecFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ReadinessProbeExecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ExecHealthCheckConfigBuilder exec;

  public ReadinessProbeExecFluent() {
  }
  
  public ReadinessProbeExecFluent(ReadinessProbeExec instance) {
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
  
  public ExecHealthCheckConfig buildExec() {
    return this.exec != null ? this.exec.build() : null;
  }
  
  protected void copyInstance(ReadinessProbeExec instance) {
    instance = instance != null ? instance : new ReadinessProbeExec();
    if (instance != null) {
        this.withExec(instance.getExec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExecNested<A> editExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(null));
  }
  
  public ExecNested<A> editOrNewExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(new ExecHealthCheckConfigBuilder().build()));
  }
  
  public ExecNested<A> editOrNewExecLike(ExecHealthCheckConfig item) {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(item));
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
    ReadinessProbeExecFluent that = (ReadinessProbeExecFluent) o;
    if (!(Objects.equals(exec, that.exec))) {
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
  
  public boolean hasExec() {
    return this.exec != null;
  }
  
  public int hashCode() {
    return Objects.hash(exec, additionalProperties);
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
    if (!(exec == null)) {
        sb.append("exec:");
        sb.append(exec);
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
  
  public A withExec(ExecHealthCheckConfig exec) {
    this._visitables.remove("exec");
    if (exec != null) {
        this.exec = new ExecHealthCheckConfigBuilder(exec);
        this._visitables.get("exec").add(this.exec);
    } else {
        this.exec = null;
        this._visitables.get("exec").remove(this.exec);
    }
    return (A) this;
  }
  
  public ExecNested<A> withNewExec() {
    return new ExecNested(null);
  }
  
  public ExecNested<A> withNewExecLike(ExecHealthCheckConfig item) {
    return new ExecNested(item);
  }
  public class ExecNested<N> extends ExecHealthCheckConfigFluent<ExecNested<N>> implements Nested<N>{
  
    ExecHealthCheckConfigBuilder builder;
  
    ExecNested(ExecHealthCheckConfig item) {
      this.builder = new ExecHealthCheckConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeExecFluent.this.withExec(builder.build());
    }
    
    public N endExec() {
      return and();
    }
    
  }
}