package io.fabric8.kubernetes.api.model.node.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class RuntimeClassFluent<A extends io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String handler;
  private String kind;
  private ObjectMetaBuilder metadata;
  private OverheadBuilder overhead;
  private SchedulingBuilder scheduling;

  public RuntimeClassFluent() {
  }
  
  public RuntimeClassFluent(RuntimeClass instance) {
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
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public Overhead buildOverhead() {
    return this.overhead != null ? this.overhead.build() : null;
  }
  
  public Scheduling buildScheduling() {
    return this.scheduling != null ? this.scheduling.build() : null;
  }
  
  protected void copyInstance(RuntimeClass instance) {
    instance = instance != null ? instance : new RuntimeClass();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withHandler(instance.getHandler());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withOverhead(instance.getOverhead());
        this.withScheduling(instance.getScheduling());
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
  
  public OverheadNested<A> editOrNewOverhead() {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(new OverheadBuilder().build()));
  }
  
  public OverheadNested<A> editOrNewOverheadLike(Overhead item) {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(item));
  }
  
  public SchedulingNested<A> editOrNewScheduling() {
    return this.withNewSchedulingLike(Optional.ofNullable(this.buildScheduling()).orElse(new SchedulingBuilder().build()));
  }
  
  public SchedulingNested<A> editOrNewSchedulingLike(Scheduling item) {
    return this.withNewSchedulingLike(Optional.ofNullable(this.buildScheduling()).orElse(item));
  }
  
  public OverheadNested<A> editOverhead() {
    return this.withNewOverheadLike(Optional.ofNullable(this.buildOverhead()).orElse(null));
  }
  
  public SchedulingNested<A> editScheduling() {
    return this.withNewSchedulingLike(Optional.ofNullable(this.buildScheduling()).orElse(null));
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
    RuntimeClassFluent that = (RuntimeClassFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(handler, that.handler))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(overhead, that.overhead))) {
      return false;
    }
    if (!(Objects.equals(scheduling, that.scheduling))) {
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
  
  public String getHandler() {
    return this.handler;
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
  
  public boolean hasHandler() {
    return this.handler != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasOverhead() {
    return this.overhead != null;
  }
  
  public boolean hasScheduling() {
    return this.scheduling != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, handler, kind, metadata, overhead, scheduling, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(handler == null)) {
        sb.append("handler:");
        sb.append(handler);
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
    if (!(overhead == null)) {
        sb.append("overhead:");
        sb.append(overhead);
        sb.append(",");
    }
    if (!(scheduling == null)) {
        sb.append("scheduling:");
        sb.append(scheduling);
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
  
  public A withHandler(String handler) {
    this.handler = handler;
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
  
  public OverheadNested<A> withNewOverhead() {
    return new OverheadNested(null);
  }
  
  public OverheadNested<A> withNewOverheadLike(Overhead item) {
    return new OverheadNested(item);
  }
  
  public SchedulingNested<A> withNewScheduling() {
    return new SchedulingNested(null);
  }
  
  public SchedulingNested<A> withNewSchedulingLike(Scheduling item) {
    return new SchedulingNested(item);
  }
  
  public A withOverhead(Overhead overhead) {
    this._visitables.remove("overhead");
    if (overhead != null) {
        this.overhead = new OverheadBuilder(overhead);
        this._visitables.get("overhead").add(this.overhead);
    } else {
        this.overhead = null;
        this._visitables.get("overhead").remove(this.overhead);
    }
    return (A) this;
  }
  
  public A withScheduling(Scheduling scheduling) {
    this._visitables.remove("scheduling");
    if (scheduling != null) {
        this.scheduling = new SchedulingBuilder(scheduling);
        this._visitables.get("scheduling").add(this.scheduling);
    } else {
        this.scheduling = null;
        this._visitables.get("scheduling").remove(this.scheduling);
    }
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) RuntimeClassFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class OverheadNested<N> extends OverheadFluent<OverheadNested<N>> implements Nested<N>{
  
    OverheadBuilder builder;
  
    OverheadNested(Overhead item) {
      this.builder = new OverheadBuilder(this, item);
    }
  
    public N and() {
      return (N) RuntimeClassFluent.this.withOverhead(builder.build());
    }
    
    public N endOverhead() {
      return and();
    }
    
  }
  public class SchedulingNested<N> extends SchedulingFluent<SchedulingNested<N>> implements Nested<N>{
  
    SchedulingBuilder builder;
  
    SchedulingNested(Scheduling item) {
      this.builder = new SchedulingBuilder(this, item);
    }
  
    public N and() {
      return (N) RuntimeClassFluent.this.withScheduling(builder.build());
    }
    
    public N endScheduling() {
      return and();
    }
    
  }
}