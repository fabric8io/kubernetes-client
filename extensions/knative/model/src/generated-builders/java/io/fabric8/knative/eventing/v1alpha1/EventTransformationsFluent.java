package io.fabric8.knative.eventing.v1alpha1;

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
public class EventTransformationsFluent<A extends io.fabric8.knative.eventing.v1alpha1.EventTransformationsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private JsonataEventTransformationSpecBuilder jsonata;

  public EventTransformationsFluent() {
  }
  
  public EventTransformationsFluent(EventTransformations instance) {
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
  
  public JsonataEventTransformationSpec buildJsonata() {
    return this.jsonata != null ? this.jsonata.build() : null;
  }
  
  protected void copyInstance(EventTransformations instance) {
    instance = instance != null ? instance : new EventTransformations();
    if (instance != null) {
        this.withJsonata(instance.getJsonata());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JsonataNested<A> editJsonata() {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(null));
  }
  
  public JsonataNested<A> editOrNewJsonata() {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(new JsonataEventTransformationSpecBuilder().build()));
  }
  
  public JsonataNested<A> editOrNewJsonataLike(JsonataEventTransformationSpec item) {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(item));
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
    EventTransformationsFluent that = (EventTransformationsFluent) o;
    if (!(Objects.equals(jsonata, that.jsonata))) {
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
  
  public boolean hasJsonata() {
    return this.jsonata != null;
  }
  
  public int hashCode() {
    return Objects.hash(jsonata, additionalProperties);
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
    if (!(jsonata == null)) {
        sb.append("jsonata:");
        sb.append(jsonata);
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
  
  public A withJsonata(JsonataEventTransformationSpec jsonata) {
    this._visitables.remove("jsonata");
    if (jsonata != null) {
        this.jsonata = new JsonataEventTransformationSpecBuilder(jsonata);
        this._visitables.get("jsonata").add(this.jsonata);
    } else {
        this.jsonata = null;
        this._visitables.get("jsonata").remove(this.jsonata);
    }
    return (A) this;
  }
  
  public JsonataNested<A> withNewJsonata() {
    return new JsonataNested(null);
  }
  
  public A withNewJsonata(String expression) {
    return (A) this.withJsonata(new JsonataEventTransformationSpec(expression));
  }
  
  public JsonataNested<A> withNewJsonataLike(JsonataEventTransformationSpec item) {
    return new JsonataNested(item);
  }
  public class JsonataNested<N> extends JsonataEventTransformationSpecFluent<JsonataNested<N>> implements Nested<N>{
  
    JsonataEventTransformationSpecBuilder builder;
  
    JsonataNested(JsonataEventTransformationSpec item) {
      this.builder = new JsonataEventTransformationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTransformationsFluent.this.withJsonata(builder.build());
    }
    
    public N endJsonata() {
      return and();
    }
    
  }
}