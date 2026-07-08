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
public class ConfigMapFluent<A extends io.fabric8.kubernetes.api.model.ConfigMapFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Map<String,String> binaryData;
  private Map<String,String> data;
  private Boolean immutable;
  private String kind;
  private ObjectMetaBuilder metadata;

  public ConfigMapFluent() {
  }
  
  public ConfigMapFluent(ConfigMap instance) {
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
  
  public A addToBinaryData(Map<String,String> map) {
    if (this.binaryData == null && map != null) {
      this.binaryData = new LinkedHashMap();
    }
    if (map != null) {
      this.binaryData.putAll(map);
    }
    return (A) this;
  }
  
  public A addToBinaryData(String key,String value) {
    if (this.binaryData == null && key != null && value != null) {
      this.binaryData = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.binaryData.put(key, value);
    }
    return (A) this;
  }
  
  public A addToData(Map<String,String> map) {
    if (this.data == null && map != null) {
      this.data = new LinkedHashMap();
    }
    if (map != null) {
      this.data.putAll(map);
    }
    return (A) this;
  }
  
  public A addToData(String key,String value) {
    if (this.data == null && key != null && value != null) {
      this.data = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.data.put(key, value);
    }
    return (A) this;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(ConfigMap instance) {
    instance = instance != null ? instance : new ConfigMap();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBinaryData(instance.getBinaryData());
        this.withData(instance.getData());
        this.withImmutable(instance.getImmutable());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    ConfigMapFluent that = (ConfigMapFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(binaryData, that.binaryData))) {
      return false;
    }
    if (!(Objects.equals(data, that.data))) {
      return false;
    }
    if (!(Objects.equals(immutable, that.immutable))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public Map<String,String> getBinaryData() {
    return this.binaryData;
  }
  
  public Map<String,String> getData() {
    return this.data;
  }
  
  public Boolean getImmutable() {
    return this.immutable;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBinaryData() {
    return this.binaryData != null;
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasImmutable() {
    return this.immutable != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, binaryData, data, immutable, kind, metadata, additionalProperties);
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
  
  public A removeFromBinaryData(String key) {
    if (this.binaryData == null) {
      return (A) this;
    }
    if (key != null && this.binaryData != null) {
      this.binaryData.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromBinaryData(Map<String,String> map) {
    if (this.binaryData == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.binaryData != null) {
          this.binaryData.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromData(String key) {
    if (this.data == null) {
      return (A) this;
    }
    if (key != null && this.data != null) {
      this.data.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromData(Map<String,String> map) {
    if (this.data == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.data != null) {
          this.data.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(binaryData == null) && !(binaryData.isEmpty())) {
        sb.append("binaryData:");
        sb.append(binaryData);
        sb.append(",");
    }
    if (!(data == null) && !(data.isEmpty())) {
        sb.append("data:");
        sb.append(data);
        sb.append(",");
    }
    if (!(immutable == null)) {
        sb.append("immutable:");
        sb.append(immutable);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public <K,V>A withBinaryData(Map<String,String> binaryData) {
    if (binaryData == null) {
      this.binaryData = null;
    } else {
      this.binaryData = new LinkedHashMap(binaryData);
    }
    return (A) this;
  }
  
  public <K,V>A withData(Map<String,String> data) {
    if (data == null) {
      this.data = null;
    } else {
      this.data = new LinkedHashMap(data);
    }
    return (A) this;
  }
  
  public A withImmutable() {
    return withImmutable(true);
  }
  
  public A withImmutable(Boolean immutable) {
    this.immutable = immutable;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigMapFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}