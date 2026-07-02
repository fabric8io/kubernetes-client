package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class StatusFluent<A extends io.fabric8.kubernetes.api.model.StatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private Integer code;
  private StatusDetailsBuilder details;
  private String kind;
  private String message;
  private ListMetaBuilder metadata;
  private String reason;
  private String status;

  public StatusFluent() {
  }
  
  public StatusFluent(Status instance) {
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
  
  public StatusDetails buildDetails() {
    return this.details != null ? this.details.build() : null;
  }
  
  public ListMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(Status instance) {
    instance = instance != null ? instance : new Status();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withCode(instance.getCode());
        this.withDetails(instance.getDetails());
        this.withKind(instance.getKind());
        this.withMessage(instance.getMessage());
        this.withMetadata(instance.getMetadata());
        this.withReason(instance.getReason());
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DetailsNested<A> editDetails() {
    return this.withNewDetailsLike(Optional.ofNullable(this.buildDetails()).orElse(null));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public DetailsNested<A> editOrNewDetails() {
    return this.withNewDetailsLike(Optional.ofNullable(this.buildDetails()).orElse(new StatusDetailsBuilder().build()));
  }
  
  public DetailsNested<A> editOrNewDetailsLike(StatusDetails item) {
    return this.withNewDetailsLike(Optional.ofNullable(this.buildDetails()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ListMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ListMeta item) {
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
    StatusFluent that = (StatusFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(code, that.code))) {
      return false;
    }
    if (!(Objects.equals(details, that.details))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public Integer getCode() {
    return this.code;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCode() {
    return this.code != null;
  }
  
  public boolean hasDetails() {
    return this.details != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, code, details, kind, message, metadata, reason, status, additionalProperties);
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
    if (!(code == null)) {
        sb.append("code:");
        sb.append(code);
        sb.append(",");
    }
    if (!(details == null)) {
        sb.append("details:");
        sb.append(details);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public A withCode(Integer code) {
    this.code = code;
    return (A) this;
  }
  
  public A withDetails(StatusDetails details) {
    this._visitables.remove("details");
    if (details != null) {
        this.details = new StatusDetailsBuilder(details);
        this._visitables.get("details").add(this.details);
    } else {
        this.details = null;
        this._visitables.get("details").remove(this.details);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withMetadata(ListMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ListMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public DetailsNested<A> withNewDetails() {
    return new DetailsNested(null);
  }
  
  public DetailsNested<A> withNewDetailsLike(StatusDetails item) {
    return new DetailsNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ListMeta item) {
    return new MetadataNested(item);
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  public class DetailsNested<N> extends StatusDetailsFluent<DetailsNested<N>> implements Nested<N>{
  
    StatusDetailsBuilder builder;
  
    DetailsNested(StatusDetails item) {
      this.builder = new StatusDetailsBuilder(this, item);
    }
  
    public N and() {
      return (N) StatusFluent.this.withDetails(builder.build());
    }
    
    public N endDetails() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ListMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ListMetaBuilder builder;
  
    MetadataNested(ListMeta item) {
      this.builder = new ListMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) StatusFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}