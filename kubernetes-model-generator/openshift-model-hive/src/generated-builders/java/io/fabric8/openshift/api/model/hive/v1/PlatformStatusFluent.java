package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatus;
import io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatusBuilder;
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
public class PlatformStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.PlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PlatformStatusBuilder aws;
  private io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusBuilder gcp;

  public PlatformStatusFluent() {
  }
  
  public PlatformStatusFluent(io.fabric8.openshift.api.model.hive.v1.PlatformStatus instance) {
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
  
  public PlatformStatus buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  protected void copyInstance(io.fabric8.openshift.api.model.hive.v1.PlatformStatus instance) {
    instance = instance != null ? instance : new io.fabric8.openshift.api.model.hive.v1.PlatformStatus();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withGcp(instance.getGcp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new PlatformStatusBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(PlatformStatus item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
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
    PlatformStatusFluent that = (PlatformStatusFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
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
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, gcp, additionalProperties);
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
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(gcp == null)) {
        sb.append("gcp:");
        sb.append(gcp);
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
  
  public A withAws(PlatformStatus aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new PlatformStatusBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withGcp(io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(PlatformStatus item) {
    return new AwsNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus item) {
    return new GcpNested(item);
  }
  public class AwsNested<N> extends io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatusFluent<AwsNested<N>> implements Nested<N>{
  
    PlatformStatusBuilder builder;
  
    AwsNested(PlatformStatus item) {
      this.builder = new PlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class GcpNested<N> extends io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusFluent<GcpNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusBuilder builder;
  
    GcpNested(io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus item) {
      this.builder = new io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformStatusFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}