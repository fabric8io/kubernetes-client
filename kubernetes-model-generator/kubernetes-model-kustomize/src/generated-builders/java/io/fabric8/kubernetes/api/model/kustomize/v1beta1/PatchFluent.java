package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class PatchFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.PatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PatchArgsBuilder options;
  private String patch;
  private String path;
  private SelectorBuilder target;

  public PatchFluent() {
  }
  
  public PatchFluent(Patch instance) {
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
  
  public PatchArgs buildOptions() {
    return this.options != null ? this.options.build() : null;
  }
  
  public Selector buildTarget() {
    return this.target != null ? this.target.build() : null;
  }
  
  protected void copyInstance(Patch instance) {
    instance = instance != null ? instance : new Patch();
    if (instance != null) {
        this.withOptions(instance.getOptions());
        this.withPatch(instance.getPatch());
        this.withPath(instance.getPath());
        this.withTarget(instance.getTarget());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OptionsNested<A> editOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(null));
  }
  
  public OptionsNested<A> editOrNewOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(new PatchArgsBuilder().build()));
  }
  
  public OptionsNested<A> editOrNewOptionsLike(PatchArgs item) {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(item));
  }
  
  public TargetNested<A> editOrNewTarget() {
    return this.withNewTargetLike(Optional.ofNullable(this.buildTarget()).orElse(new SelectorBuilder().build()));
  }
  
  public TargetNested<A> editOrNewTargetLike(Selector item) {
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
    PatchFluent that = (PatchFluent) o;
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(patch, that.patch))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
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
  
  public String getPatch() {
    return this.patch;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasPatch() {
    return this.patch != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(options, patch, path, target, additionalProperties);
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
    if (!(options == null)) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(patch == null)) {
        sb.append("patch:");
        sb.append(patch);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
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
  
  public OptionsNested<A> withNewOptions() {
    return new OptionsNested(null);
  }
  
  public A withNewOptions(Boolean allowKindChange,Boolean allowNameChange) {
    return (A) this.withOptions(new PatchArgs(allowKindChange, allowNameChange));
  }
  
  public OptionsNested<A> withNewOptionsLike(PatchArgs item) {
    return new OptionsNested(item);
  }
  
  public TargetNested<A> withNewTarget() {
    return new TargetNested(null);
  }
  
  public TargetNested<A> withNewTargetLike(Selector item) {
    return new TargetNested(item);
  }
  
  public A withOptions(PatchArgs options) {
    this._visitables.remove("options");
    if (options != null) {
        this.options = new PatchArgsBuilder(options);
        this._visitables.get("options").add(this.options);
    } else {
        this.options = null;
        this._visitables.get("options").remove(this.options);
    }
    return (A) this;
  }
  
  public A withPatch(String patch) {
    this.patch = patch;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withTarget(Selector target) {
    this._visitables.remove("target");
    if (target != null) {
        this.target = new SelectorBuilder(target);
        this._visitables.get("target").add(this.target);
    } else {
        this.target = null;
        this._visitables.get("target").remove(this.target);
    }
    return (A) this;
  }
  public class OptionsNested<N> extends PatchArgsFluent<OptionsNested<N>> implements Nested<N>{
  
    PatchArgsBuilder builder;
  
    OptionsNested(PatchArgs item) {
      this.builder = new PatchArgsBuilder(this, item);
    }
  
    public N and() {
      return (N) PatchFluent.this.withOptions(builder.build());
    }
    
    public N endOptions() {
      return and();
    }
    
  }
  public class TargetNested<N> extends SelectorFluent<TargetNested<N>> implements Nested<N>{
  
    SelectorBuilder builder;
  
    TargetNested(Selector item) {
      this.builder = new SelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PatchFluent.this.withTarget(builder.build());
    }
    
    public N endTarget() {
      return and();
    }
    
  }
}