package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class EBSBlockDeviceSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.EBSBlockDeviceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean deleteOnTermination;
  private Boolean encrypted;
  private Long iops;
  private AWSResourceReferenceBuilder kmsKey;
  private Long volumeSize;
  private String volumeType;

  public EBSBlockDeviceSpecFluent() {
  }
  
  public EBSBlockDeviceSpecFluent(EBSBlockDeviceSpec instance) {
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
  
  public AWSResourceReference buildKmsKey() {
    return this.kmsKey != null ? this.kmsKey.build() : null;
  }
  
  protected void copyInstance(EBSBlockDeviceSpec instance) {
    instance = instance != null ? instance : new EBSBlockDeviceSpec();
    if (instance != null) {
        this.withDeleteOnTermination(instance.getDeleteOnTermination());
        this.withEncrypted(instance.getEncrypted());
        this.withIops(instance.getIops());
        this.withKmsKey(instance.getKmsKey());
        this.withVolumeSize(instance.getVolumeSize());
        this.withVolumeType(instance.getVolumeType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KmsKeyNested<A> editKmsKey() {
    return this.withNewKmsKeyLike(Optional.ofNullable(this.buildKmsKey()).orElse(null));
  }
  
  public KmsKeyNested<A> editOrNewKmsKey() {
    return this.withNewKmsKeyLike(Optional.ofNullable(this.buildKmsKey()).orElse(new AWSResourceReferenceBuilder().build()));
  }
  
  public KmsKeyNested<A> editOrNewKmsKeyLike(AWSResourceReference item) {
    return this.withNewKmsKeyLike(Optional.ofNullable(this.buildKmsKey()).orElse(item));
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
    EBSBlockDeviceSpecFluent that = (EBSBlockDeviceSpecFluent) o;
    if (!(Objects.equals(deleteOnTermination, that.deleteOnTermination))) {
      return false;
    }
    if (!(Objects.equals(encrypted, that.encrypted))) {
      return false;
    }
    if (!(Objects.equals(iops, that.iops))) {
      return false;
    }
    if (!(Objects.equals(kmsKey, that.kmsKey))) {
      return false;
    }
    if (!(Objects.equals(volumeSize, that.volumeSize))) {
      return false;
    }
    if (!(Objects.equals(volumeType, that.volumeType))) {
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
  
  public Boolean getDeleteOnTermination() {
    return this.deleteOnTermination;
  }
  
  public Boolean getEncrypted() {
    return this.encrypted;
  }
  
  public Long getIops() {
    return this.iops;
  }
  
  public Long getVolumeSize() {
    return this.volumeSize;
  }
  
  public String getVolumeType() {
    return this.volumeType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeleteOnTermination() {
    return this.deleteOnTermination != null;
  }
  
  public boolean hasEncrypted() {
    return this.encrypted != null;
  }
  
  public boolean hasIops() {
    return this.iops != null;
  }
  
  public boolean hasKmsKey() {
    return this.kmsKey != null;
  }
  
  public boolean hasVolumeSize() {
    return this.volumeSize != null;
  }
  
  public boolean hasVolumeType() {
    return this.volumeType != null;
  }
  
  public int hashCode() {
    return Objects.hash(deleteOnTermination, encrypted, iops, kmsKey, volumeSize, volumeType, additionalProperties);
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
    if (!(deleteOnTermination == null)) {
        sb.append("deleteOnTermination:");
        sb.append(deleteOnTermination);
        sb.append(",");
    }
    if (!(encrypted == null)) {
        sb.append("encrypted:");
        sb.append(encrypted);
        sb.append(",");
    }
    if (!(iops == null)) {
        sb.append("iops:");
        sb.append(iops);
        sb.append(",");
    }
    if (!(kmsKey == null)) {
        sb.append("kmsKey:");
        sb.append(kmsKey);
        sb.append(",");
    }
    if (!(volumeSize == null)) {
        sb.append("volumeSize:");
        sb.append(volumeSize);
        sb.append(",");
    }
    if (!(volumeType == null)) {
        sb.append("volumeType:");
        sb.append(volumeType);
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
  
  public A withDeleteOnTermination() {
    return withDeleteOnTermination(true);
  }
  
  public A withDeleteOnTermination(Boolean deleteOnTermination) {
    this.deleteOnTermination = deleteOnTermination;
    return (A) this;
  }
  
  public A withEncrypted() {
    return withEncrypted(true);
  }
  
  public A withEncrypted(Boolean encrypted) {
    this.encrypted = encrypted;
    return (A) this;
  }
  
  public A withIops(Long iops) {
    this.iops = iops;
    return (A) this;
  }
  
  public A withKmsKey(AWSResourceReference kmsKey) {
    this._visitables.remove("kmsKey");
    if (kmsKey != null) {
        this.kmsKey = new AWSResourceReferenceBuilder(kmsKey);
        this._visitables.get("kmsKey").add(this.kmsKey);
    } else {
        this.kmsKey = null;
        this._visitables.get("kmsKey").remove(this.kmsKey);
    }
    return (A) this;
  }
  
  public KmsKeyNested<A> withNewKmsKey() {
    return new KmsKeyNested(null);
  }
  
  public KmsKeyNested<A> withNewKmsKeyLike(AWSResourceReference item) {
    return new KmsKeyNested(item);
  }
  
  public A withVolumeSize(Long volumeSize) {
    this.volumeSize = volumeSize;
    return (A) this;
  }
  
  public A withVolumeType(String volumeType) {
    this.volumeType = volumeType;
    return (A) this;
  }
  public class KmsKeyNested<N> extends AWSResourceReferenceFluent<KmsKeyNested<N>> implements Nested<N>{
  
    AWSResourceReferenceBuilder builder;
  
    KmsKeyNested(AWSResourceReference item) {
      this.builder = new AWSResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EBSBlockDeviceSpecFluent.this.withKmsKey(builder.build());
    }
    
    public N endKmsKey() {
      return and();
    }
    
  }
}