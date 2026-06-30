package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class PreferredSchedulingTermFluent<A extends io.fabric8.kubernetes.api.model.PreferredSchedulingTermFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NodeSelectorTermBuilder preference;
  private Integer weight;

  public PreferredSchedulingTermFluent() {
  }
  
  public PreferredSchedulingTermFluent(PreferredSchedulingTerm instance) {
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
  
  public NodeSelectorTerm buildPreference() {
    return this.preference != null ? this.preference.build() : null;
  }
  
  protected void copyInstance(PreferredSchedulingTerm instance) {
    instance = instance != null ? instance : new PreferredSchedulingTerm();
    if (instance != null) {
        this.withPreference(instance.getPreference());
        this.withWeight(instance.getWeight());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PreferenceNested<A> editOrNewPreference() {
    return this.withNewPreferenceLike(Optional.ofNullable(this.buildPreference()).orElse(new NodeSelectorTermBuilder().build()));
  }
  
  public PreferenceNested<A> editOrNewPreferenceLike(NodeSelectorTerm item) {
    return this.withNewPreferenceLike(Optional.ofNullable(this.buildPreference()).orElse(item));
  }
  
  public PreferenceNested<A> editPreference() {
    return this.withNewPreferenceLike(Optional.ofNullable(this.buildPreference()).orElse(null));
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
    PreferredSchedulingTermFluent that = (PreferredSchedulingTermFluent) o;
    if (!(Objects.equals(preference, that.preference))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPreference() {
    return this.preference != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(preference, weight, additionalProperties);
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
    if (!(preference == null)) {
        sb.append("preference:");
        sb.append(preference);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public PreferenceNested<A> withNewPreference() {
    return new PreferenceNested(null);
  }
  
  public PreferenceNested<A> withNewPreferenceLike(NodeSelectorTerm item) {
    return new PreferenceNested(item);
  }
  
  public A withPreference(NodeSelectorTerm preference) {
    this._visitables.remove("preference");
    if (preference != null) {
        this.preference = new NodeSelectorTermBuilder(preference);
        this._visitables.get("preference").add(this.preference);
    } else {
        this.preference = null;
        this._visitables.get("preference").remove(this.preference);
    }
    return (A) this;
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class PreferenceNested<N> extends NodeSelectorTermFluent<PreferenceNested<N>> implements Nested<N>{
  
    NodeSelectorTermBuilder builder;
  
    PreferenceNested(NodeSelectorTerm item) {
      this.builder = new NodeSelectorTermBuilder(this, item);
    }
  
    public N and() {
      return (N) PreferredSchedulingTermFluent.this.withPreference(builder.build());
    }
    
    public N endPreference() {
      return and();
    }
    
  }
}