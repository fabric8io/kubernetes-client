package io.fabric8.chaosmesh.v1alpha1;

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
public class PodHttpChaosActionsFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosActionsFluent<A>> extends BaseFluent<A>{

  private Boolean abort;
  private Map<String,Object> additionalProperties;
  private String delay;
  private PodHttpChaosPatchActionsBuilder patch;
  private PodHttpChaosReplaceActionsBuilder replace;

  public PodHttpChaosActionsFluent() {
  }
  
  public PodHttpChaosActionsFluent(PodHttpChaosActions instance) {
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
  
  public PodHttpChaosPatchActions buildPatch() {
    return this.patch != null ? this.patch.build() : null;
  }
  
  public PodHttpChaosReplaceActions buildReplace() {
    return this.replace != null ? this.replace.build() : null;
  }
  
  protected void copyInstance(PodHttpChaosActions instance) {
    instance = instance != null ? instance : new PodHttpChaosActions();
    if (instance != null) {
        this.withAbort(instance.getAbort());
        this.withDelay(instance.getDelay());
        this.withPatch(instance.getPatch());
        this.withReplace(instance.getReplace());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PatchNested<A> editOrNewPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(new PodHttpChaosPatchActionsBuilder().build()));
  }
  
  public PatchNested<A> editOrNewPatchLike(PodHttpChaosPatchActions item) {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(item));
  }
  
  public ReplaceNested<A> editOrNewReplace() {
    return this.withNewReplaceLike(Optional.ofNullable(this.buildReplace()).orElse(new PodHttpChaosReplaceActionsBuilder().build()));
  }
  
  public ReplaceNested<A> editOrNewReplaceLike(PodHttpChaosReplaceActions item) {
    return this.withNewReplaceLike(Optional.ofNullable(this.buildReplace()).orElse(item));
  }
  
  public PatchNested<A> editPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(null));
  }
  
  public ReplaceNested<A> editReplace() {
    return this.withNewReplaceLike(Optional.ofNullable(this.buildReplace()).orElse(null));
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
    PodHttpChaosActionsFluent that = (PodHttpChaosActionsFluent) o;
    if (!(Objects.equals(abort, that.abort))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(patch, that.patch))) {
      return false;
    }
    if (!(Objects.equals(replace, that.replace))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Boolean getAbort() {
    return this.abort;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getDelay() {
    return this.delay;
  }
  
  public boolean hasAbort() {
    return this.abort != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasPatch() {
    return this.patch != null;
  }
  
  public boolean hasReplace() {
    return this.replace != null;
  }
  
  public int hashCode() {
    return Objects.hash(abort, delay, patch, replace, additionalProperties);
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
    if (!(abort == null)) {
        sb.append("abort:");
        sb.append(abort);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(patch == null)) {
        sb.append("patch:");
        sb.append(patch);
        sb.append(",");
    }
    if (!(replace == null)) {
        sb.append("replace:");
        sb.append(replace);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAbort() {
    return withAbort(true);
  }
  
  public A withAbort(Boolean abort) {
    this.abort = abort;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDelay(String delay) {
    this.delay = delay;
    return (A) this;
  }
  
  public PatchNested<A> withNewPatch() {
    return new PatchNested(null);
  }
  
  public PatchNested<A> withNewPatchLike(PodHttpChaosPatchActions item) {
    return new PatchNested(item);
  }
  
  public ReplaceNested<A> withNewReplace() {
    return new ReplaceNested(null);
  }
  
  public ReplaceNested<A> withNewReplaceLike(PodHttpChaosReplaceActions item) {
    return new ReplaceNested(item);
  }
  
  public A withPatch(PodHttpChaosPatchActions patch) {
    this._visitables.remove("patch");
    if (patch != null) {
        this.patch = new PodHttpChaosPatchActionsBuilder(patch);
        this._visitables.get("patch").add(this.patch);
    } else {
        this.patch = null;
        this._visitables.get("patch").remove(this.patch);
    }
    return (A) this;
  }
  
  public A withReplace(PodHttpChaosReplaceActions replace) {
    this._visitables.remove("replace");
    if (replace != null) {
        this.replace = new PodHttpChaosReplaceActionsBuilder(replace);
        this._visitables.get("replace").add(this.replace);
    } else {
        this.replace = null;
        this._visitables.get("replace").remove(this.replace);
    }
    return (A) this;
  }
  public class PatchNested<N> extends PodHttpChaosPatchActionsFluent<PatchNested<N>> implements Nested<N>{
  
    PodHttpChaosPatchActionsBuilder builder;
  
    PatchNested(PodHttpChaosPatchActions item) {
      this.builder = new PodHttpChaosPatchActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosActionsFluent.this.withPatch(builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
  public class ReplaceNested<N> extends PodHttpChaosReplaceActionsFluent<ReplaceNested<N>> implements Nested<N>{
  
    PodHttpChaosReplaceActionsBuilder builder;
  
    ReplaceNested(PodHttpChaosReplaceActions item) {
      this.builder = new PodHttpChaosReplaceActionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodHttpChaosActionsFluent.this.withReplace(builder.build());
    }
    
    public N endReplace() {
      return and();
    }
    
  }
}