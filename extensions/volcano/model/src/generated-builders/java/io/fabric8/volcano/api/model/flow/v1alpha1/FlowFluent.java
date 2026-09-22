package io.fabric8.volcano.api.model.flow.v1alpha1;

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
public class FlowFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.FlowFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DependsOnBuilder dependsOn;
  private String name;
  private PatchBuilder patch;

  public FlowFluent() {
  }
  
  public FlowFluent(Flow instance) {
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
  
  public DependsOn buildDependsOn() {
    return this.dependsOn != null ? this.dependsOn.build() : null;
  }
  
  public Patch buildPatch() {
    return this.patch != null ? this.patch.build() : null;
  }
  
  protected void copyInstance(Flow instance) {
    instance = instance != null ? instance : new Flow();
    if (instance != null) {
        this.withDependsOn(instance.getDependsOn());
        this.withName(instance.getName());
        this.withPatch(instance.getPatch());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DependsOnNested<A> editDependsOn() {
    return this.withNewDependsOnLike(Optional.ofNullable(this.buildDependsOn()).orElse(null));
  }
  
  public DependsOnNested<A> editOrNewDependsOn() {
    return this.withNewDependsOnLike(Optional.ofNullable(this.buildDependsOn()).orElse(new DependsOnBuilder().build()));
  }
  
  public DependsOnNested<A> editOrNewDependsOnLike(DependsOn item) {
    return this.withNewDependsOnLike(Optional.ofNullable(this.buildDependsOn()).orElse(item));
  }
  
  public PatchNested<A> editOrNewPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(new PatchBuilder().build()));
  }
  
  public PatchNested<A> editOrNewPatchLike(Patch item) {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(item));
  }
  
  public PatchNested<A> editPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(null));
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
    FlowFluent that = (FlowFluent) o;
    if (!(Objects.equals(dependsOn, that.dependsOn))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(patch, that.patch))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDependsOn() {
    return this.dependsOn != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPatch() {
    return this.patch != null;
  }
  
  public int hashCode() {
    return Objects.hash(dependsOn, name, patch, additionalProperties);
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
    if (!(dependsOn == null)) {
        sb.append("dependsOn:");
        sb.append(dependsOn);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(patch == null)) {
        sb.append("patch:");
        sb.append(patch);
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
  
  public A withDependsOn(DependsOn dependsOn) {
    this._visitables.remove("dependsOn");
    if (dependsOn != null) {
        this.dependsOn = new DependsOnBuilder(dependsOn);
        this._visitables.get("dependsOn").add(this.dependsOn);
    } else {
        this.dependsOn = null;
        this._visitables.get("dependsOn").remove(this.dependsOn);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public DependsOnNested<A> withNewDependsOn() {
    return new DependsOnNested(null);
  }
  
  public DependsOnNested<A> withNewDependsOnLike(DependsOn item) {
    return new DependsOnNested(item);
  }
  
  public PatchNested<A> withNewPatch() {
    return new PatchNested(null);
  }
  
  public PatchNested<A> withNewPatchLike(Patch item) {
    return new PatchNested(item);
  }
  
  public A withPatch(Patch patch) {
    this._visitables.remove("patch");
    if (patch != null) {
        this.patch = new PatchBuilder(patch);
        this._visitables.get("patch").add(this.patch);
    } else {
        this.patch = null;
        this._visitables.get("patch").remove(this.patch);
    }
    return (A) this;
  }
  public class DependsOnNested<N> extends DependsOnFluent<DependsOnNested<N>> implements Nested<N>{
  
    DependsOnBuilder builder;
  
    DependsOnNested(DependsOn item) {
      this.builder = new DependsOnBuilder(this, item);
    }
  
    public N and() {
      return (N) FlowFluent.this.withDependsOn(builder.build());
    }
    
    public N endDependsOn() {
      return and();
    }
    
  }
  public class PatchNested<N> extends PatchFluent<PatchNested<N>> implements Nested<N>{
  
    PatchBuilder builder;
  
    PatchNested(Patch item) {
      this.builder = new PatchBuilder(this, item);
    }
  
    public N and() {
      return (N) FlowFluent.this.withPatch(builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
}