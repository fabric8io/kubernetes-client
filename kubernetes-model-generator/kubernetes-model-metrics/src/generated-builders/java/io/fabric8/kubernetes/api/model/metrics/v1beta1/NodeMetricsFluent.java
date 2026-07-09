package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class NodeMetricsFluent<A extends io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ObjectMetaBuilder metadata;
  private String timestamp;
  private Map<String,Quantity> usage;
  private Duration window;

  public NodeMetricsFluent() {
  }
  
  public NodeMetricsFluent(NodeMetrics instance) {
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
  
  public A addToUsage(Map<String,Quantity> map) {
    if (this.usage == null && map != null) {
      this.usage = new LinkedHashMap();
    }
    if (map != null) {
      this.usage.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUsage(String key,Quantity value) {
    if (this.usage == null && key != null && value != null) {
      this.usage = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.usage.put(key, value);
    }
    return (A) this;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(NodeMetrics instance) {
    instance = instance != null ? instance : new NodeMetrics();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withTimestamp(instance.getTimestamp());
        this.withUsage(instance.getUsage());
        this.withWindow(instance.getWindow());
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
    NodeMetricsFluent that = (NodeMetricsFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(timestamp, that.timestamp))) {
      return false;
    }
    if (!(Objects.equals(usage, that.usage))) {
      return false;
    }
    if (!(Objects.equals(window, that.window))) {
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
  
  public String getKind() {
    return this.kind;
  }
  
  public String getTimestamp() {
    return this.timestamp;
  }
  
  public Map<String,Quantity> getUsage() {
    return this.usage;
  }
  
  public Duration getWindow() {
    return this.window;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasTimestamp() {
    return this.timestamp != null;
  }
  
  public boolean hasUsage() {
    return this.usage != null;
  }
  
  public boolean hasWindow() {
    return this.window != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, timestamp, usage, window, additionalProperties);
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
  
  public A removeFromUsage(String key) {
    if (this.usage == null) {
      return (A) this;
    }
    if (key != null && this.usage != null) {
      this.usage.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUsage(Map<String,Quantity> map) {
    if (this.usage == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.usage != null) {
          this.usage.remove(key);
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
    if (!(timestamp == null)) {
        sb.append("timestamp:");
        sb.append(timestamp);
        sb.append(",");
    }
    if (!(usage == null) && !(usage.isEmpty())) {
        sb.append("usage:");
        sb.append(usage);
        sb.append(",");
    }
    if (!(window == null)) {
        sb.append("window:");
        sb.append(window);
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
  
  public A withTimestamp(String timestamp) {
    this.timestamp = timestamp;
    return (A) this;
  }
  
  public <K,V>A withUsage(Map<String,Quantity> usage) {
    if (usage == null) {
      this.usage = null;
    } else {
      this.usage = new LinkedHashMap(usage);
    }
    return (A) this;
  }
  
  public A withWindow(Duration window) {
    this.window = window;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeMetricsFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}