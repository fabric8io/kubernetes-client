package io.fabric8.kubernetes.api.model;

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
public class StorageOSVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.StorageOSVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fsType;
  private Boolean readOnly;
  private LocalObjectReferenceBuilder secretRef;
  private String volumeName;
  private String volumeNamespace;

  public StorageOSVolumeSourceFluent() {
  }
  
  public StorageOSVolumeSourceFluent(StorageOSVolumeSource instance) {
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
  
  public LocalObjectReference buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(StorageOSVolumeSource instance) {
    instance = instance != null ? instance : new StorageOSVolumeSource();
    if (instance != null) {
        this.withFsType(instance.getFsType());
        this.withReadOnly(instance.getReadOnly());
        this.withSecretRef(instance.getSecretRef());
        this.withVolumeName(instance.getVolumeName());
        this.withVolumeNamespace(instance.getVolumeNamespace());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(LocalObjectReference item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    StorageOSVolumeSourceFluent that = (StorageOSVolumeSourceFluent) o;
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
      return false;
    }
    if (!(Objects.equals(volumeName, that.volumeName))) {
      return false;
    }
    if (!(Objects.equals(volumeNamespace, that.volumeNamespace))) {
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
  
  public String getFsType() {
    return this.fsType;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public String getVolumeName() {
    return this.volumeName;
  }
  
  public String getVolumeNamespace() {
    return this.volumeNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public boolean hasVolumeName() {
    return this.volumeName != null;
  }
  
  public boolean hasVolumeNamespace() {
    return this.volumeNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(fsType, readOnly, secretRef, volumeName, volumeNamespace, additionalProperties);
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
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
        sb.append(",");
    }
    if (!(volumeName == null)) {
        sb.append("volumeName:");
        sb.append(volumeName);
        sb.append(",");
    }
    if (!(volumeNamespace == null)) {
        sb.append("volumeNamespace:");
        sb.append(volumeNamespace);
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
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public A withNewSecretRef(String name) {
    return (A) this.withSecretRef(new LocalObjectReference(name));
  }
  
  public SecretRefNested<A> withNewSecretRefLike(LocalObjectReference item) {
    return new SecretRefNested(item);
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withSecretRef(LocalObjectReference secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new LocalObjectReferenceBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  
  public A withVolumeName(String volumeName) {
    this.volumeName = volumeName;
    return (A) this;
  }
  
  public A withVolumeNamespace(String volumeNamespace) {
    this.volumeNamespace = volumeNamespace;
    return (A) this;
  }
  public class SecretRefNested<N> extends LocalObjectReferenceFluent<SecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageOSVolumeSourceFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}