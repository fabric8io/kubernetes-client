package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class EnvoyFilterEnvoyConfigObjectPatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectPatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterApplyTo applyTo;
  private EnvoyFilterEnvoyConfigObjectMatchBuilder match;
  private EnvoyFilterPatchBuilder patch;

  public EnvoyFilterEnvoyConfigObjectPatchFluent() {
  }
  
  public EnvoyFilterEnvoyConfigObjectPatchFluent(EnvoyFilterEnvoyConfigObjectPatch instance) {
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
  
  public EnvoyFilterEnvoyConfigObjectMatch buildMatch() {
    return this.match != null ? this.match.build() : null;
  }
  
  public EnvoyFilterPatch buildPatch() {
    return this.patch != null ? this.patch.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterEnvoyConfigObjectPatch instance) {
    instance = instance != null ? instance : new EnvoyFilterEnvoyConfigObjectPatch();
    if (instance != null) {
        this.withApplyTo(instance.getApplyTo());
        this.withMatch(instance.getMatch());
        this.withPatch(instance.getPatch());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(null));
  }
  
  public MatchNested<A> editOrNewMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(new EnvoyFilterEnvoyConfigObjectMatchBuilder().build()));
  }
  
  public MatchNested<A> editOrNewMatchLike(EnvoyFilterEnvoyConfigObjectMatch item) {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(item));
  }
  
  public PatchNested<A> editOrNewPatch() {
    return this.withNewPatchLike(Optional.ofNullable(this.buildPatch()).orElse(new EnvoyFilterPatchBuilder().build()));
  }
  
  public PatchNested<A> editOrNewPatchLike(EnvoyFilterPatch item) {
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
    EnvoyFilterEnvoyConfigObjectPatchFluent that = (EnvoyFilterEnvoyConfigObjectPatchFluent) o;
    if (!(Objects.equals(applyTo, that.applyTo))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
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
  
  public EnvoyFilterApplyTo getApplyTo() {
    return this.applyTo;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplyTo() {
    return this.applyTo != null;
  }
  
  public boolean hasMatch() {
    return this.match != null;
  }
  
  public boolean hasPatch() {
    return this.patch != null;
  }
  
  public int hashCode() {
    return Objects.hash(applyTo, match, patch, additionalProperties);
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
    if (!(applyTo == null)) {
        sb.append("applyTo:");
        sb.append(applyTo);
        sb.append(",");
    }
    if (!(match == null)) {
        sb.append("match:");
        sb.append(match);
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
  
  public A withApplyTo(EnvoyFilterApplyTo applyTo) {
    this.applyTo = applyTo;
    return (A) this;
  }
  
  public A withMatch(EnvoyFilterEnvoyConfigObjectMatch match) {
    this._visitables.remove("match");
    if (match != null) {
        this.match = new EnvoyFilterEnvoyConfigObjectMatchBuilder(match);
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
  
  public MatchNested<A> withNewMatchLike(EnvoyFilterEnvoyConfigObjectMatch item) {
    return new MatchNested(item);
  }
  
  public PatchNested<A> withNewPatch() {
    return new PatchNested(null);
  }
  
  public PatchNested<A> withNewPatchLike(EnvoyFilterPatch item) {
    return new PatchNested(item);
  }
  
  public A withPatch(EnvoyFilterPatch patch) {
    this._visitables.remove("patch");
    if (patch != null) {
        this.patch = new EnvoyFilterPatchBuilder(patch);
        this._visitables.get("patch").add(this.patch);
    } else {
        this.patch = null;
        this._visitables.get("patch").remove(this.patch);
    }
    return (A) this;
  }
  public class MatchNested<N> extends EnvoyFilterEnvoyConfigObjectMatchFluent<MatchNested<N>> implements Nested<N>{
  
    EnvoyFilterEnvoyConfigObjectMatchBuilder builder;
  
    MatchNested(EnvoyFilterEnvoyConfigObjectMatch item) {
      this.builder = new EnvoyFilterEnvoyConfigObjectMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectPatchFluent.this.withMatch(builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class PatchNested<N> extends EnvoyFilterPatchFluent<PatchNested<N>> implements Nested<N>{
  
    EnvoyFilterPatchBuilder builder;
  
    PatchNested(EnvoyFilterPatch item) {
      this.builder = new EnvoyFilterPatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectPatchFluent.this.withPatch(builder.build());
    }
    
    public N endPatch() {
      return and();
    }
    
  }
}