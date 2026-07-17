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
public class GCPDiskFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.GCPDiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean autoDelete;
  private Boolean boot;
  private GCPEncryptionKeyReferenceBuilder encryptionKey;
  private String image;
  private Map<String,String> labels;
  private Long sizeGb;
  private String type;

  public GCPDiskFluent() {
  }
  
  public GCPDiskFluent(GCPDisk instance) {
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public GCPEncryptionKeyReference buildEncryptionKey() {
    return this.encryptionKey != null ? this.encryptionKey.build() : null;
  }
  
  protected void copyInstance(GCPDisk instance) {
    instance = instance != null ? instance : new GCPDisk();
    if (instance != null) {
        this.withAutoDelete(instance.getAutoDelete());
        this.withBoot(instance.getBoot());
        this.withEncryptionKey(instance.getEncryptionKey());
        this.withImage(instance.getImage());
        this.withLabels(instance.getLabels());
        this.withSizeGb(instance.getSizeGb());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EncryptionKeyNested<A> editEncryptionKey() {
    return this.withNewEncryptionKeyLike(Optional.ofNullable(this.buildEncryptionKey()).orElse(null));
  }
  
  public EncryptionKeyNested<A> editOrNewEncryptionKey() {
    return this.withNewEncryptionKeyLike(Optional.ofNullable(this.buildEncryptionKey()).orElse(new GCPEncryptionKeyReferenceBuilder().build()));
  }
  
  public EncryptionKeyNested<A> editOrNewEncryptionKeyLike(GCPEncryptionKeyReference item) {
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
    GCPDiskFluent that = (GCPDiskFluent) o;
    if (!(Objects.equals(autoDelete, that.autoDelete))) {
      return false;
    }
    if (!(Objects.equals(boot, that.boot))) {
      return false;
    }
    if (!(Objects.equals(encryptionKey, that.encryptionKey))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(sizeGb, that.sizeGb))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public Boolean getAutoDelete() {
    return this.autoDelete;
  }
  
  public Boolean getBoot() {
    return this.boot;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public Long getSizeGb() {
    return this.sizeGb;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoDelete() {
    return this.autoDelete != null;
  }
  
  public boolean hasBoot() {
    return this.boot != null;
  }
  
  public boolean hasEncryptionKey() {
    return this.encryptionKey != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasSizeGb() {
    return this.sizeGb != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(autoDelete, boot, encryptionKey, image, labels, sizeGb, type, additionalProperties);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(autoDelete == null)) {
        sb.append("autoDelete:");
        sb.append(autoDelete);
        sb.append(",");
    }
    if (!(boot == null)) {
        sb.append("boot:");
        sb.append(boot);
        sb.append(",");
    }
    if (!(encryptionKey == null)) {
        sb.append("encryptionKey:");
        sb.append(encryptionKey);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(sizeGb == null)) {
        sb.append("sizeGb:");
        sb.append(sizeGb);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withAutoDelete() {
    return withAutoDelete(true);
  }
  
  public A withAutoDelete(Boolean autoDelete) {
    this.autoDelete = autoDelete;
    return (A) this;
  }
  
  public A withBoot() {
    return withBoot(true);
  }
  
  public A withBoot(Boolean boot) {
    this.boot = boot;
    return (A) this;
  }
  
  public A withEncryptionKey(GCPEncryptionKeyReference encryptionKey) {
    this._visitables.remove("encryptionKey");
    if (encryptionKey != null) {
        this.encryptionKey = new GCPEncryptionKeyReferenceBuilder(encryptionKey);
        this._visitables.get("encryptionKey").add(this.encryptionKey);
    } else {
        this.encryptionKey = null;
        this._visitables.get("encryptionKey").remove(this.encryptionKey);
    }
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public EncryptionKeyNested<A> withNewEncryptionKey() {
    return new EncryptionKeyNested(null);
  }
  
  public EncryptionKeyNested<A> withNewEncryptionKeyLike(GCPEncryptionKeyReference item) {
    return new EncryptionKeyNested(item);
  }
  
  public A withSizeGb(Long sizeGb) {
    this.sizeGb = sizeGb;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class EncryptionKeyNested<N> extends GCPEncryptionKeyReferenceFluent<EncryptionKeyNested<N>> implements Nested<N>{
  
    GCPEncryptionKeyReferenceBuilder builder;
  
    EncryptionKeyNested(GCPEncryptionKeyReference item) {
      this.builder = new GCPEncryptionKeyReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPDiskFluent.this.withEncryptionKey(builder.build());
    }
    
    public N endEncryptionKey() {
      return and();
    }
    
  }
}