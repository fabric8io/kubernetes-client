package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class GatewayClassSpecFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClassSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String controllerName;
  private String description;
  private ParametersReferenceBuilder parametersRef;

  public GatewayClassSpecFluent() {
  }
  
  public GatewayClassSpecFluent(GatewayClassSpec instance) {
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
  
  public ParametersReference buildParametersRef() {
    return this.parametersRef != null ? this.parametersRef.build() : null;
  }
  
  protected void copyInstance(GatewayClassSpec instance) {
    instance = instance != null ? instance : new GatewayClassSpec();
    if (instance != null) {
        this.withControllerName(instance.getControllerName());
        this.withDescription(instance.getDescription());
        this.withParametersRef(instance.getParametersRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParametersRefNested<A> editOrNewParametersRef() {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(new ParametersReferenceBuilder().build()));
  }
  
  public ParametersRefNested<A> editOrNewParametersRefLike(ParametersReference item) {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(item));
  }
  
  public ParametersRefNested<A> editParametersRef() {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(null));
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
    GatewayClassSpecFluent that = (GatewayClassSpecFluent) o;
    if (!(Objects.equals(controllerName, that.controllerName))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(parametersRef, that.parametersRef))) {
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
  
  public String getControllerName() {
    return this.controllerName;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasControllerName() {
    return this.controllerName != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasParametersRef() {
    return this.parametersRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(controllerName, description, parametersRef, additionalProperties);
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
    if (!(controllerName == null)) {
        sb.append("controllerName:");
        sb.append(controllerName);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(parametersRef == null)) {
        sb.append("parametersRef:");
        sb.append(parametersRef);
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
  
  public A withControllerName(String controllerName) {
    this.controllerName = controllerName;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public ParametersRefNested<A> withNewParametersRef() {
    return new ParametersRefNested(null);
  }
  
  public A withNewParametersRef(String group,String kind,String name,String namespace) {
    return (A) this.withParametersRef(new ParametersReference(group, kind, name, namespace));
  }
  
  public ParametersRefNested<A> withNewParametersRefLike(ParametersReference item) {
    return new ParametersRefNested(item);
  }
  
  public A withParametersRef(ParametersReference parametersRef) {
    this._visitables.remove("parametersRef");
    if (parametersRef != null) {
        this.parametersRef = new ParametersReferenceBuilder(parametersRef);
        this._visitables.get("parametersRef").add(this.parametersRef);
    } else {
        this.parametersRef = null;
        this._visitables.get("parametersRef").remove(this.parametersRef);
    }
    return (A) this;
  }
  public class ParametersRefNested<N> extends ParametersReferenceFluent<ParametersRefNested<N>> implements Nested<N>{
  
    ParametersReferenceBuilder builder;
  
    ParametersRefNested(ParametersReference item) {
      this.builder = new ParametersReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayClassSpecFluent.this.withParametersRef(builder.build());
    }
    
    public N endParametersRef() {
      return and();
    }
    
  }
}