package io.fabric8.openshift.api.model.hive.baremetal.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder libvirtSSHPrivateKeySecretRef;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
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
  
  public LocalObjectReference buildLibvirtSSHPrivateKeySecretRef() {
    return this.libvirtSSHPrivateKeySecretRef != null ? this.libvirtSSHPrivateKeySecretRef.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withLibvirtSSHPrivateKeySecretRef(instance.getLibvirtSSHPrivateKeySecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LibvirtSSHPrivateKeySecretRefNested<A> editLibvirtSSHPrivateKeySecretRef() {
    return this.withNewLibvirtSSHPrivateKeySecretRefLike(Optional.ofNullable(this.buildLibvirtSSHPrivateKeySecretRef()).orElse(null));
  }
  
  public LibvirtSSHPrivateKeySecretRefNested<A> editOrNewLibvirtSSHPrivateKeySecretRef() {
    return this.withNewLibvirtSSHPrivateKeySecretRefLike(Optional.ofNullable(this.buildLibvirtSSHPrivateKeySecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public LibvirtSSHPrivateKeySecretRefNested<A> editOrNewLibvirtSSHPrivateKeySecretRefLike(LocalObjectReference item) {
    return this.withNewLibvirtSSHPrivateKeySecretRefLike(Optional.ofNullable(this.buildLibvirtSSHPrivateKeySecretRef()).orElse(item));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(libvirtSSHPrivateKeySecretRef, that.libvirtSSHPrivateKeySecretRef))) {
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
  
  public boolean hasLibvirtSSHPrivateKeySecretRef() {
    return this.libvirtSSHPrivateKeySecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(libvirtSSHPrivateKeySecretRef, additionalProperties);
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
    if (!(libvirtSSHPrivateKeySecretRef == null)) {
        sb.append("libvirtSSHPrivateKeySecretRef:");
        sb.append(libvirtSSHPrivateKeySecretRef);
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
  
  public A withLibvirtSSHPrivateKeySecretRef(LocalObjectReference libvirtSSHPrivateKeySecretRef) {
    this._visitables.remove("libvirtSSHPrivateKeySecretRef");
    if (libvirtSSHPrivateKeySecretRef != null) {
        this.libvirtSSHPrivateKeySecretRef = new LocalObjectReferenceBuilder(libvirtSSHPrivateKeySecretRef);
        this._visitables.get("libvirtSSHPrivateKeySecretRef").add(this.libvirtSSHPrivateKeySecretRef);
    } else {
        this.libvirtSSHPrivateKeySecretRef = null;
        this._visitables.get("libvirtSSHPrivateKeySecretRef").remove(this.libvirtSSHPrivateKeySecretRef);
    }
    return (A) this;
  }
  
  public LibvirtSSHPrivateKeySecretRefNested<A> withNewLibvirtSSHPrivateKeySecretRef() {
    return new LibvirtSSHPrivateKeySecretRefNested(null);
  }
  
  public A withNewLibvirtSSHPrivateKeySecretRef(String name) {
    return (A) this.withLibvirtSSHPrivateKeySecretRef(new LocalObjectReference(name));
  }
  
  public LibvirtSSHPrivateKeySecretRefNested<A> withNewLibvirtSSHPrivateKeySecretRefLike(LocalObjectReference item) {
    return new LibvirtSSHPrivateKeySecretRefNested(item);
  }
  public class LibvirtSSHPrivateKeySecretRefNested<N> extends LocalObjectReferenceFluent<LibvirtSSHPrivateKeySecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    LibvirtSSHPrivateKeySecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withLibvirtSSHPrivateKeySecretRef(builder.build());
    }
    
    public N endLibvirtSSHPrivateKeySecretRef() {
      return and();
    }
    
  }
}