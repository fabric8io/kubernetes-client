package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class MetricsOverridesFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.MetricsOverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean disabled;
  private MetricSelectorBuilder match;
  private Map<String,MetricsOverridesTagOverride> tagOverrides;

  public MetricsOverridesFluent() {
  }
  
  public MetricsOverridesFluent(MetricsOverrides instance) {
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
  
  public A addToTagOverrides(Map<String,MetricsOverridesTagOverride> map) {
    if (this.tagOverrides == null && map != null) {
      this.tagOverrides = new LinkedHashMap();
    }
    if (map != null) {
      this.tagOverrides.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTagOverrides(String key,MetricsOverridesTagOverride value) {
    if (this.tagOverrides == null && key != null && value != null) {
      this.tagOverrides = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.tagOverrides.put(key, value);
    }
    return (A) this;
  }
  
  public MetricSelector buildMatch() {
    return this.match != null ? this.match.build() : null;
  }
  
  protected void copyInstance(MetricsOverrides instance) {
    instance = instance != null ? instance : new MetricsOverrides();
    if (instance != null) {
        this.withDisabled(instance.getDisabled());
        this.withMatch(instance.getMatch());
        this.withTagOverrides(instance.getTagOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(null));
  }
  
  public MatchNested<A> editOrNewMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(new MetricSelectorBuilder().build()));
  }
  
  public MatchNested<A> editOrNewMatchLike(MetricSelector item) {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(item));
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
    MetricsOverridesFluent that = (MetricsOverridesFluent) o;
    if (!(Objects.equals(disabled, that.disabled))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(tagOverrides, that.tagOverrides))) {
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
  
  public Boolean getDisabled() {
    return this.disabled;
  }
  
  public Map<String,MetricsOverridesTagOverride> getTagOverrides() {
    return this.tagOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisabled() {
    return this.disabled != null;
  }
  
  public boolean hasMatch() {
    return this.match != null;
  }
  
  public boolean hasTagOverrides() {
    return this.tagOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(disabled, match, tagOverrides, additionalProperties);
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
  
  public A removeFromTagOverrides(String key) {
    if (this.tagOverrides == null) {
      return (A) this;
    }
    if (key != null && this.tagOverrides != null) {
      this.tagOverrides.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTagOverrides(Map<String,MetricsOverridesTagOverride> map) {
    if (this.tagOverrides == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.tagOverrides != null) {
          this.tagOverrides.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disabled == null)) {
        sb.append("disabled:");
        sb.append(disabled);
        sb.append(",");
    }
    if (!(match == null)) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(tagOverrides == null) && !(tagOverrides.isEmpty())) {
        sb.append("tagOverrides:");
        sb.append(tagOverrides);
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
  
  public A withDisabled() {
    return withDisabled(true);
  }
  
  public A withDisabled(Boolean disabled) {
    this.disabled = disabled;
    return (A) this;
  }
  
  public A withMatch(MetricSelector match) {
    this._visitables.remove("match");
    if (match != null) {
        this.match = new MetricSelectorBuilder(match);
        this._visitables.get("match").add(this.match);
    } else {
        this.match = null;
        this._visitables.get("match").remove(this.match);
    }
    return (A) this;
  }
  
  public MatchNested<A> withNewMatch() {
    return new MatchNested(null);
  }
  
  public MatchNested<A> withNewMatchLike(MetricSelector item) {
    return new MatchNested(item);
  }
  
  public <K,V>A withTagOverrides(Map<String,MetricsOverridesTagOverride> tagOverrides) {
    if (tagOverrides == null) {
      this.tagOverrides = null;
    } else {
      this.tagOverrides = new LinkedHashMap(tagOverrides);
    }
    return (A) this;
  }
  public class MatchNested<N> extends MetricSelectorFluent<MatchNested<N>> implements Nested<N>{
  
    MetricSelectorBuilder builder;
  
    MatchNested(MetricSelector item) {
      this.builder = new MetricSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricsOverridesFluent.this.withMatch(builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
}