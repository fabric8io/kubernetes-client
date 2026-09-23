package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

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
public class EvictionRequestSpecFluent<A extends io.fabric8.kubernetes.api.model.lifecycle.v1alpha1.EvictionRequestSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String intent;
  private String requester;
  private EvictionRequestTargetBuilder target;

  public EvictionRequestSpecFluent() {
  }
  
  public EvictionRequestSpecFluent(EvictionRequestSpec instance) {
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
  
  public EvictionRequestTarget buildTarget() {
    return this.target != null ? this.target.build() : null;
  }
  
  protected void copyInstance(EvictionRequestSpec instance) {
    instance = instance != null ? instance : new EvictionRequestSpec();
    if (instance != null) {
        this.withIntent(instance.getIntent());
        this.withRequester(instance.getRequester());
        this.withTarget(instance.getTarget());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TargetNested<A> editOrNewTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(new EvictionRequestTargetBuilder().build()));
  }
  
  public TargetNested<A> editOrNewTargetLike(EvictionRequestTarget item) {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(item));
  }
  
  public TargetNested<A> editTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(null));
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
    EvictionRequestSpecFluent that = (EvictionRequestSpecFluent) o;
    if (!(Objects.equals(intent, that.intent))) {
      return false;
    }
    if (!(Objects.equals(requester, that.requester))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
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
  
  public String getIntent() {
    return this.intent;
  }
  
  public String getRequester() {
    return this.requester;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIntent() {
    return this.intent != null;
  }
  
  public boolean hasRequester() {
    return this.requester != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(intent, requester, target, additionalProperties);
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
    if (!(intent == null)) {
        sb.append("intent:");
        sb.append(intent);
        sb.append(",");
    }
    if (!(requester == null)) {
        sb.append("requester:");
        sb.append(requester);
        sb.append(",");
    }
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
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
  
  public A withIntent(String intent) {
    this.intent = intent;
    return (A) this;
  }
  
  public TargetNested<A> withNewTarget() {
    return new TargetNested(null);
  }
  
  public TargetNested<A> withNewTargetLike(EvictionRequestTarget item) {
    return new TargetNested(item);
  }
  
  public A withRequester(String requester) {
    this.requester = requester;
    return (A) this;
  }
  
  public A withTarget(EvictionRequestTarget target) {
    this._visitables.remove("target");
    if (target != null) {
        this.target = new EvictionRequestTargetBuilder(target);
        this._visitables.get("target").add(this.target);
    } else {
        this.target = null;
        this._visitables.get("target").remove(this.target);
    }
    return (A) this;
  }
  public class TargetNested<N> extends EvictionRequestTargetFluent<TargetNested<N>> implements Nested<N>{
  
    EvictionRequestTargetBuilder builder;
  
    TargetNested(EvictionRequestTarget item) {
      this.builder = new EvictionRequestTargetBuilder(this, item);
    }
  
    public N and() {
      return (N) EvictionRequestSpecFluent.this.withTarget(builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}