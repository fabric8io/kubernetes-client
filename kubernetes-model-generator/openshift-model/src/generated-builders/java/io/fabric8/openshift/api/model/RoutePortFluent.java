package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
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
public class RoutePortFluent<A extends io.fabric8.openshift.api.model.RoutePortFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IntOrStringBuilder targetPort;

  public RoutePortFluent() {
  }
  
  public RoutePortFluent(RoutePort instance) {
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
  
  public IntOrString buildTargetPort() {
    return this.targetPort != null ? this.targetPort.build() : null;
  }
  
  protected void copyInstance(RoutePort instance) {
    instance = instance != null ? instance : new RoutePort();
    if (instance != null) {
        this.withTargetPort(instance.getTargetPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TargetPortNested<A> editOrNewTargetPort() {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(new IntOrStringBuilder().build()));
  }
  
  public TargetPortNested<A> editOrNewTargetPortLike(IntOrString item) {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(item));
  }
  
  public TargetPortNested<A> editTargetPort() {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(null));
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
    RoutePortFluent that = (RoutePortFluent) o;
    if (!(Objects.equals(targetPort, that.targetPort))) {
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
  
  public boolean hasTargetPort() {
    return this.targetPort != null;
  }
  
  public int hashCode() {
    return Objects.hash(targetPort, additionalProperties);
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
    if (!(targetPort == null)) {
        sb.append("targetPort:");
        sb.append(targetPort);
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
  
  public TargetPortNested<A> withNewTargetPort() {
    return new TargetPortNested(null);
  }
  
  public A withNewTargetPort(Object value) {
    return (A) this.withTargetPort(new IntOrString(value));
  }
  
  public TargetPortNested<A> withNewTargetPortLike(IntOrString item) {
    return new TargetPortNested(item);
  }
  
  public A withTargetPort(IntOrString targetPort) {
    this._visitables.remove("targetPort");
    if (targetPort != null) {
        this.targetPort = new IntOrStringBuilder(targetPort);
        this._visitables.get("targetPort").add(this.targetPort);
    } else {
        this.targetPort = null;
        this._visitables.get("targetPort").remove(this.targetPort);
    }
    return (A) this;
  }
  public class TargetPortNested<N> extends IntOrStringFluent<TargetPortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    TargetPortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RoutePortFluent.this.withTargetPort(builder.build());
    }
    
    public N endTargetPort() {
      return and();
    }
    
  }
}