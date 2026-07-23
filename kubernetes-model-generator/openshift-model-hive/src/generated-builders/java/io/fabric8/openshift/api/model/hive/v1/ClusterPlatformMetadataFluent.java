package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.hive.aws.v1.Metadata;
import io.fabric8.openshift.api.model.hive.aws.v1.MetadataBuilder;
import io.fabric8.openshift.api.model.hive.aws.v1.MetadataFluent;
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
public class ClusterPlatformMetadataFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterPlatformMetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MetadataBuilder aws;
  private io.fabric8.openshift.api.model.hive.azure.v1.MetadataBuilder azure;
  private io.fabric8.openshift.api.model.hive.gcp.v1.MetadataBuilder gcp;

  public ClusterPlatformMetadataFluent() {
  }
  
  public ClusterPlatformMetadataFluent(ClusterPlatformMetadata instance) {
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
  
  public Metadata buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.azure.v1.Metadata buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.gcp.v1.Metadata buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  protected void copyInstance(ClusterPlatformMetadata instance) {
    instance = instance != null ? instance : new ClusterPlatformMetadata();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withGcp(instance.getGcp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AzureNested<A> editAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new MetadataBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(Metadata item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new io.fabric8.openshift.api.model.hive.azure.v1.MetadataBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(io.fabric8.openshift.api.model.hive.azure.v1.Metadata item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new io.fabric8.openshift.api.model.hive.gcp.v1.MetadataBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(io.fabric8.openshift.api.model.hive.gcp.v1.Metadata item) {
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
    ClusterPlatformMetadataFluent that = (ClusterPlatformMetadataFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
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
  
  public boolean hasAzure() {
    return this.azure != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, gcp, additionalProperties);
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
    if (!(azure == null)) {
        sb.append("azure:");
        sb.append(azure);
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
  
  public A withAws(Metadata aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new MetadataBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(io.fabric8.openshift.api.model.hive.azure.v1.Metadata azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new io.fabric8.openshift.api.model.hive.azure.v1.MetadataBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withGcp(io.fabric8.openshift.api.model.hive.gcp.v1.Metadata gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new io.fabric8.openshift.api.model.hive.gcp.v1.MetadataBuilder(gcp);
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
  
  public A withNewAws(String hostedZoneRole) {
    return (A) this.withAws(new Metadata(hostedZoneRole));
  }
  
  public AwsNested<A> withNewAwsLike(Metadata item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public A withNewAzure(String resourceGroupName) {
    return (A) this.withAzure(new io.fabric8.openshift.api.model.hive.azure.v1.Metadata(resourceGroupName));
  }
  
  public AzureNested<A> withNewAzureLike(io.fabric8.openshift.api.model.hive.azure.v1.Metadata item) {
    return new AzureNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public A withNewGcp(String networkProjectID) {
    return (A) this.withGcp(new io.fabric8.openshift.api.model.hive.gcp.v1.Metadata(networkProjectID));
  }
  
  public GcpNested<A> withNewGcpLike(io.fabric8.openshift.api.model.hive.gcp.v1.Metadata item) {
    return new GcpNested(item);
  }
  public class AwsNested<N> extends MetadataFluent<AwsNested<N>> implements Nested<N>{
  
    MetadataBuilder builder;
  
    AwsNested(Metadata item) {
      this.builder = new MetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPlatformMetadataFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends io.fabric8.openshift.api.model.hive.azure.v1.MetadataFluent<AzureNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.azure.v1.MetadataBuilder builder;
  
    AzureNested(io.fabric8.openshift.api.model.hive.azure.v1.Metadata item) {
      this.builder = new io.fabric8.openshift.api.model.hive.azure.v1.MetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPlatformMetadataFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class GcpNested<N> extends io.fabric8.openshift.api.model.hive.gcp.v1.MetadataFluent<GcpNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.gcp.v1.MetadataBuilder builder;
  
    GcpNested(io.fabric8.openshift.api.model.hive.gcp.v1.Metadata item) {
      this.builder = new io.fabric8.openshift.api.model.hive.gcp.v1.MetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPlatformMetadataFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}