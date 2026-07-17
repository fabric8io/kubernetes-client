package io.fabric8.openshift.api.model.config.v1alpha2;

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
public class PersistentVolumeConfigFluent<A extends io.fabric8.openshift.api.model.config.v1alpha2.PersistentVolumeConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PersistentVolumeClaimReferenceBuilder claim;
  private String mountPath;

  public PersistentVolumeConfigFluent() {
  }
  
  public PersistentVolumeConfigFluent(PersistentVolumeConfig instance) {
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
  
  public PersistentVolumeClaimReference buildClaim() {
    return this.claim != null ? this.claim.build() : null;
  }
  
  protected void copyInstance(PersistentVolumeConfig instance) {
    instance = instance != null ? instance : new PersistentVolumeConfig();
    if (instance != null) {
        this.withClaim(instance.getClaim());
        this.withMountPath(instance.getMountPath());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClaimNested<A> editClaim() {
    return this.withNewClaimLike(Optional.ofNullable(this.buildClaim()).orElse(null));
  }
  
  public ClaimNested<A> editOrNewClaim() {
    return this.withNewClaimLike(Optional.ofNullable(this.buildClaim()).orElse(new PersistentVolumeClaimReferenceBuilder().build()));
  }
  
  public ClaimNested<A> editOrNewClaimLike(PersistentVolumeClaimReference item) {
    return this.withNewClaimLike(Optional.ofNullable(this.buildClaim()).orElse(item));
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
    PersistentVolumeConfigFluent that = (PersistentVolumeConfigFluent) o;
    if (!(Objects.equals(claim, that.claim))) {
      return false;
    }
    if (!(Objects.equals(mountPath, that.mountPath))) {
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
  
  public String getMountPath() {
    return this.mountPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaim() {
    return this.claim != null;
  }
  
  public boolean hasMountPath() {
    return this.mountPath != null;
  }
  
  public int hashCode() {
    return Objects.hash(claim, mountPath, additionalProperties);
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
    if (!(claim == null)) {
        sb.append("claim:");
        sb.append(claim);
        sb.append(",");
    }
    if (!(mountPath == null)) {
        sb.append("mountPath:");
        sb.append(mountPath);
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
  
  public A withClaim(PersistentVolumeClaimReference claim) {
    this._visitables.remove("claim");
    if (claim != null) {
        this.claim = new PersistentVolumeClaimReferenceBuilder(claim);
        this._visitables.get("claim").add(this.claim);
    } else {
        this.claim = null;
        this._visitables.get("claim").remove(this.claim);
    }
    return (A) this;
  }
  
  public A withMountPath(String mountPath) {
    this.mountPath = mountPath;
    return (A) this;
  }
  
  public ClaimNested<A> withNewClaim() {
    return new ClaimNested(null);
  }
  
  public A withNewClaim(String name) {
    return (A) this.withClaim(new PersistentVolumeClaimReference(name));
  }
  
  public ClaimNested<A> withNewClaimLike(PersistentVolumeClaimReference item) {
    return new ClaimNested(item);
  }
  public class ClaimNested<N> extends PersistentVolumeClaimReferenceFluent<ClaimNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimReferenceBuilder builder;
  
    ClaimNested(PersistentVolumeClaimReference item) {
      this.builder = new PersistentVolumeClaimReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeConfigFluent.this.withClaim(builder.build());
    }
    
    public N endClaim() {
      return and();
    }
    
  }
}