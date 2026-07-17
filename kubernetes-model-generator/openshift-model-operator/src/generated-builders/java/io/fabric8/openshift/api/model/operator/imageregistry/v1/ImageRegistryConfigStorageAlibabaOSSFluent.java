package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class ImageRegistryConfigStorageAlibabaOSSFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageAlibabaOSSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bucket;
  private EncryptionAlibabaBuilder encryption;
  private String endpointAccessibility;
  private String region;

  public ImageRegistryConfigStorageAlibabaOSSFluent() {
  }
  
  public ImageRegistryConfigStorageAlibabaOSSFluent(ImageRegistryConfigStorageAlibabaOSS instance) {
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
  
  public EncryptionAlibaba buildEncryption() {
    return this.encryption != null ? this.encryption.build() : null;
  }
  
  protected void copyInstance(ImageRegistryConfigStorageAlibabaOSS instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageAlibabaOSS();
    if (instance != null) {
        this.withBucket(instance.getBucket());
        this.withEncryption(instance.getEncryption());
        this.withEndpointAccessibility(instance.getEndpointAccessibility());
        this.withRegion(instance.getRegion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EncryptionNested<A> editEncryption() {
    return this.withNewEncryptionLike(Optional.ofNullable(this.buildEncryption()).orElse(null));
  }
  
  public EncryptionNested<A> editOrNewEncryption() {
    return this.withNewEncryptionLike(Optional.ofNullable(this.buildEncryption()).orElse(new EncryptionAlibabaBuilder().build()));
  }
  
  public EncryptionNested<A> editOrNewEncryptionLike(EncryptionAlibaba item) {
    return this.withNewEncryptionLike(Optional.ofNullable(this.buildEncryption()).orElse(item));
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
    ImageRegistryConfigStorageAlibabaOSSFluent that = (ImageRegistryConfigStorageAlibabaOSSFluent) o;
    if (!(Objects.equals(bucket, that.bucket))) {
      return false;
    }
    if (!(Objects.equals(encryption, that.encryption))) {
      return false;
    }
    if (!(Objects.equals(endpointAccessibility, that.endpointAccessibility))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
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
  
  public String getBucket() {
    return this.bucket;
  }
  
  public String getEndpointAccessibility() {
    return this.endpointAccessibility;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBucket() {
    return this.bucket != null;
  }
  
  public boolean hasEncryption() {
    return this.encryption != null;
  }
  
  public boolean hasEndpointAccessibility() {
    return this.endpointAccessibility != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public int hashCode() {
    return Objects.hash(bucket, encryption, endpointAccessibility, region, additionalProperties);
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
    if (!(bucket == null)) {
        sb.append("bucket:");
        sb.append(bucket);
        sb.append(",");
    }
    if (!(encryption == null)) {
        sb.append("encryption:");
        sb.append(encryption);
        sb.append(",");
    }
    if (!(endpointAccessibility == null)) {
        sb.append("endpointAccessibility:");
        sb.append(endpointAccessibility);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
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
  
  public A withBucket(String bucket) {
    this.bucket = bucket;
    return (A) this;
  }
  
  public A withEncryption(EncryptionAlibaba encryption) {
    this._visitables.remove("encryption");
    if (encryption != null) {
        this.encryption = new EncryptionAlibabaBuilder(encryption);
        this._visitables.get("encryption").add(this.encryption);
    } else {
        this.encryption = null;
        this._visitables.get("encryption").remove(this.encryption);
    }
    return (A) this;
  }
  
  public A withEndpointAccessibility(String endpointAccessibility) {
    this.endpointAccessibility = endpointAccessibility;
    return (A) this;
  }
  
  public EncryptionNested<A> withNewEncryption() {
    return new EncryptionNested(null);
  }
  
  public EncryptionNested<A> withNewEncryptionLike(EncryptionAlibaba item) {
    return new EncryptionNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  public class EncryptionNested<N> extends EncryptionAlibabaFluent<EncryptionNested<N>> implements Nested<N>{
  
    EncryptionAlibabaBuilder builder;
  
    EncryptionNested(EncryptionAlibaba item) {
      this.builder = new EncryptionAlibabaBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageAlibabaOSSFluent.this.withEncryption(builder.build());
    }
    
    public N endEncryption() {
      return and();
    }
    
  }
}