package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class OSDiskFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.OSDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long diskSizeGB;
  private String diskType;
  private EncryptionKeyReferenceBuilder encryptionKey;

  public OSDiskFluent() {
  }
  
  public OSDiskFluent(OSDisk instance) {
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
  
  public EncryptionKeyReference buildEncryptionKey() {
    return this.encryptionKey != null ? this.encryptionKey.build() : null;
  }
  
  protected void copyInstance(OSDisk instance) {
    instance = instance != null ? instance : new OSDisk();
    if (instance != null) {
        this.withDiskSizeGB(instance.getDiskSizeGB());
        this.withDiskType(instance.getDiskType());
        this.withEncryptionKey(instance.getEncryptionKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EncryptionKeyNested<A> editEncryptionKey() {
    return this.withNewEncryptionKeyLike(Optional.ofNullable(this.buildEncryptionKey()).orElse(null));
  }
  
  public EncryptionKeyNested<A> editOrNewEncryptionKey() {
    return this.withNewEncryptionKeyLike(Optional.ofNullable(this.buildEncryptionKey()).orElse(new EncryptionKeyReferenceBuilder().build()));
  }
  
  public EncryptionKeyNested<A> editOrNewEncryptionKeyLike(EncryptionKeyReference item) {
    return this.withNewEncryptionKeyLike(Optional.ofNullable(this.buildEncryptionKey()).orElse(item));
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
    OSDiskFluent that = (OSDiskFluent) o;
    if (!(Objects.equals(diskSizeGB, that.diskSizeGB))) {
      return false;
    }
    if (!(Objects.equals(diskType, that.diskType))) {
      return false;
    }
    if (!(Objects.equals(encryptionKey, that.encryptionKey))) {
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
  
  public Long getDiskSizeGB() {
    return this.diskSizeGB;
  }
  
  public String getDiskType() {
    return this.diskType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiskSizeGB() {
    return this.diskSizeGB != null;
  }
  
  public boolean hasDiskType() {
    return this.diskType != null;
  }
  
  public boolean hasEncryptionKey() {
    return this.encryptionKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(diskSizeGB, diskType, encryptionKey, additionalProperties);
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
    if (!(diskSizeGB == null)) {
        sb.append("diskSizeGB:");
        sb.append(diskSizeGB);
        sb.append(",");
    }
    if (!(diskType == null)) {
        sb.append("diskType:");
        sb.append(diskType);
        sb.append(",");
    }
    if (!(encryptionKey == null)) {
        sb.append("encryptionKey:");
        sb.append(encryptionKey);
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
  
  public A withDiskSizeGB(Long diskSizeGB) {
    this.diskSizeGB = diskSizeGB;
    return (A) this;
  }
  
  public A withDiskType(String diskType) {
    this.diskType = diskType;
    return (A) this;
  }
  
  public A withEncryptionKey(EncryptionKeyReference encryptionKey) {
    this._visitables.remove("encryptionKey");
    if (encryptionKey != null) {
        this.encryptionKey = new EncryptionKeyReferenceBuilder(encryptionKey);
        this._visitables.get("encryptionKey").add(this.encryptionKey);
    } else {
        this.encryptionKey = null;
        this._visitables.get("encryptionKey").remove(this.encryptionKey);
    }
    return (A) this;
  }
  
  public EncryptionKeyNested<A> withNewEncryptionKey() {
    return new EncryptionKeyNested(null);
  }
  
  public EncryptionKeyNested<A> withNewEncryptionKeyLike(EncryptionKeyReference item) {
    return new EncryptionKeyNested(item);
  }
  public class EncryptionKeyNested<N> extends EncryptionKeyReferenceFluent<EncryptionKeyNested<N>> implements Nested<N>{
  
    EncryptionKeyReferenceBuilder builder;
  
    EncryptionKeyNested(EncryptionKeyReference item) {
      this.builder = new EncryptionKeyReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OSDiskFluent.this.withEncryptionKey(builder.build());
    }
    
    public N endEncryptionKey() {
      return and();
    }
    
  }
}