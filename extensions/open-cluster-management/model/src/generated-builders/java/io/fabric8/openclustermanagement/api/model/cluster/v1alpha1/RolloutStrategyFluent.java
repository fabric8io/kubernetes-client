package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
public class RolloutStrategyFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.RolloutStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RolloutAllBuilder all;
  private RolloutProgressiveBuilder progressive;
  private RolloutProgressivePerGroupBuilder progressivePerGroup;
  private String type;

  public RolloutStrategyFluent() {
  }
  
  public RolloutStrategyFluent(RolloutStrategy instance) {
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
  
  public RolloutAll buildAll() {
    return this.all != null ? this.all.build() : null;
  }
  
  public RolloutProgressive buildProgressive() {
    return this.progressive != null ? this.progressive.build() : null;
  }
  
  public RolloutProgressivePerGroup buildProgressivePerGroup() {
    return this.progressivePerGroup != null ? this.progressivePerGroup.build() : null;
  }
  
  protected void copyInstance(RolloutStrategy instance) {
    instance = instance != null ? instance : new RolloutStrategy();
    if (instance != null) {
        this.withAll(instance.getAll());
        this.withProgressive(instance.getProgressive());
        this.withProgressivePerGroup(instance.getProgressivePerGroup());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllNested<A> editAll() {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(null));
  }
  
  public AllNested<A> editOrNewAll() {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(new RolloutAllBuilder().build()));
  }
  
  public AllNested<A> editOrNewAllLike(RolloutAll item) {
    return this.withNewAllLike(Optional.ofNullable(this.buildAll()).orElse(item));
  }
  
  public ProgressiveNested<A> editOrNewProgressive() {
    return this.withNewProgressiveLike(Optional.ofNullable(this.buildProgressive()).orElse(new RolloutProgressiveBuilder().build()));
  }
  
  public ProgressiveNested<A> editOrNewProgressiveLike(RolloutProgressive item) {
    return this.withNewProgressiveLike(Optional.ofNullable(this.buildProgressive()).orElse(item));
  }
  
  public ProgressivePerGroupNested<A> editOrNewProgressivePerGroup() {
    return this.withNewProgressivePerGroupLike(Optional.ofNullable(this.buildProgressivePerGroup()).orElse(new RolloutProgressivePerGroupBuilder().build()));
  }
  
  public ProgressivePerGroupNested<A> editOrNewProgressivePerGroupLike(RolloutProgressivePerGroup item) {
    return this.withNewProgressivePerGroupLike(Optional.ofNullable(this.buildProgressivePerGroup()).orElse(item));
  }
  
  public ProgressiveNested<A> editProgressive() {
    return this.withNewProgressiveLike(Optional.ofNullable(this.buildProgressive()).orElse(null));
  }
  
  public ProgressivePerGroupNested<A> editProgressivePerGroup() {
    return this.withNewProgressivePerGroupLike(Optional.ofNullable(this.buildProgressivePerGroup()).orElse(null));
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
    RolloutStrategyFluent that = (RolloutStrategyFluent) o;
    if (!(Objects.equals(all, that.all))) {
      return false;
    }
    if (!(Objects.equals(progressive, that.progressive))) {
      return false;
    }
    if (!(Objects.equals(progressivePerGroup, that.progressivePerGroup))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAll() {
    return this.all != null;
  }
  
  public boolean hasProgressive() {
    return this.progressive != null;
  }
  
  public boolean hasProgressivePerGroup() {
    return this.progressivePerGroup != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(all, progressive, progressivePerGroup, type, additionalProperties);
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
    if (!(all == null)) {
        sb.append("all:");
        sb.append(all);
        sb.append(",");
    }
    if (!(progressive == null)) {
        sb.append("progressive:");
        sb.append(progressive);
        sb.append(",");
    }
    if (!(progressivePerGroup == null)) {
        sb.append("progressivePerGroup:");
        sb.append(progressivePerGroup);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withAll(RolloutAll all) {
    this._visitables.remove("all");
    if (all != null) {
        this.all = new RolloutAllBuilder(all);
        this._visitables.get("all").add(this.all);
    } else {
        this.all = null;
        this._visitables.get("all").remove(this.all);
    }
    return (A) this;
  }
  
  public AllNested<A> withNewAll() {
    return new AllNested(null);
  }
  
  public AllNested<A> withNewAllLike(RolloutAll item) {
    return new AllNested(item);
  }
  
  public ProgressiveNested<A> withNewProgressive() {
    return new ProgressiveNested(null);
  }
  
  public ProgressiveNested<A> withNewProgressiveLike(RolloutProgressive item) {
    return new ProgressiveNested(item);
  }
  
  public ProgressivePerGroupNested<A> withNewProgressivePerGroup() {
    return new ProgressivePerGroupNested(null);
  }
  
  public ProgressivePerGroupNested<A> withNewProgressivePerGroupLike(RolloutProgressivePerGroup item) {
    return new ProgressivePerGroupNested(item);
  }
  
  public A withProgressive(RolloutProgressive progressive) {
    this._visitables.remove("progressive");
    if (progressive != null) {
        this.progressive = new RolloutProgressiveBuilder(progressive);
        this._visitables.get("progressive").add(this.progressive);
    } else {
        this.progressive = null;
        this._visitables.get("progressive").remove(this.progressive);
    }
    return (A) this;
  }
  
  public A withProgressivePerGroup(RolloutProgressivePerGroup progressivePerGroup) {
    this._visitables.remove("progressivePerGroup");
    if (progressivePerGroup != null) {
        this.progressivePerGroup = new RolloutProgressivePerGroupBuilder(progressivePerGroup);
        this._visitables.get("progressivePerGroup").add(this.progressivePerGroup);
    } else {
        this.progressivePerGroup = null;
        this._visitables.get("progressivePerGroup").remove(this.progressivePerGroup);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class AllNested<N> extends RolloutAllFluent<AllNested<N>> implements Nested<N>{
  
    RolloutAllBuilder builder;
  
    AllNested(RolloutAll item) {
      this.builder = new RolloutAllBuilder(this, item);
    }
  
    public N and() {
      return (N) RolloutStrategyFluent.this.withAll(builder.build());
    }
    
    public N endAll() {
      return and();
    }
    
  }
  public class ProgressiveNested<N> extends RolloutProgressiveFluent<ProgressiveNested<N>> implements Nested<N>{
  
    RolloutProgressiveBuilder builder;
  
    ProgressiveNested(RolloutProgressive item) {
      this.builder = new RolloutProgressiveBuilder(this, item);
    }
  
    public N and() {
      return (N) RolloutStrategyFluent.this.withProgressive(builder.build());
    }
    
    public N endProgressive() {
      return and();
    }
    
  }
  public class ProgressivePerGroupNested<N> extends RolloutProgressivePerGroupFluent<ProgressivePerGroupNested<N>> implements Nested<N>{
  
    RolloutProgressivePerGroupBuilder builder;
  
    ProgressivePerGroupNested(RolloutProgressivePerGroup item) {
      this.builder = new RolloutProgressivePerGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) RolloutStrategyFluent.this.withProgressivePerGroup(builder.build());
    }
    
    public N endProgressivePerGroup() {
      return and();
    }
    
  }
}