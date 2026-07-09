package io.fabric8.kubernetes.api.model.networking.v1beta1;

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
public class IngressClassSpecFluent<A extends io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClassSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String controller;
  private IngressClassParametersReferenceBuilder parameters;

  public IngressClassSpecFluent() {
  }
  
  public IngressClassSpecFluent(IngressClassSpec instance) {
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
  
  public IngressClassParametersReference buildParameters() {
    return this.parameters != null ? this.parameters.build() : null;
  }
  
  protected void copyInstance(IngressClassSpec instance) {
    instance = instance != null ? instance : new IngressClassSpec();
    if (instance != null) {
        this.withController(instance.getController());
        this.withParameters(instance.getParameters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParametersNested<A> editOrNewParameters() {
    return this.withNewParametersLike(Optional.ofNullable(this.buildParameters()).orElse(new IngressClassParametersReferenceBuilder().build()));
  }
  
  public ParametersNested<A> editOrNewParametersLike(IngressClassParametersReference item) {
    return this.withNewParametersLike(Optional.ofNullable(this.buildParameters()).orElse(item));
  }
  
  public ParametersNested<A> editParameters() {
    return this.withNewParametersLike(Optional.ofNullable(this.buildParameters()).orElse(null));
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
    IngressClassSpecFluent that = (IngressClassSpecFluent) o;
    if (!(Objects.equals(controller, that.controller))) {
      return false;
    }
    if (!(Objects.equals(parameters, that.parameters))) {
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
  
  public String getController() {
    return this.controller;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasController() {
    return this.controller != null;
  }
  
  public boolean hasParameters() {
    return this.parameters != null;
  }
  
  public int hashCode() {
    return Objects.hash(controller, parameters, additionalProperties);
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
    if (!(controller == null)) {
        sb.append("controller:");
        sb.append(controller);
        sb.append(",");
    }
    if (!(parameters == null)) {
        sb.append("parameters:");
        sb.append(parameters);
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
  
  public A withController(String controller) {
    this.controller = controller;
    return (A) this;
  }
  
  public ParametersNested<A> withNewParameters() {
    return new ParametersNested(null);
  }
  
  public A withNewParameters(String apiGroup,String kind,String name,String namespace,String scope) {
    return (A) this.withParameters(new IngressClassParametersReference(apiGroup, kind, name, namespace, scope));
  }
  
  public ParametersNested<A> withNewParametersLike(IngressClassParametersReference item) {
    return new ParametersNested(item);
  }
  
  public A withParameters(IngressClassParametersReference parameters) {
    this._visitables.remove("parameters");
    if (parameters != null) {
        this.parameters = new IngressClassParametersReferenceBuilder(parameters);
        this._visitables.get("parameters").add(this.parameters);
    } else {
        this.parameters = null;
        this._visitables.get("parameters").remove(this.parameters);
    }
    return (A) this;
  }
  public class ParametersNested<N> extends IngressClassParametersReferenceFluent<ParametersNested<N>> implements Nested<N>{
  
    IngressClassParametersReferenceBuilder builder;
  
    ParametersNested(IngressClassParametersReference item) {
      this.builder = new IngressClassParametersReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressClassSpecFluent.this.withParameters(builder.build());
    }
    
    public N endParameters() {
      return and();
    }
    
  }
}