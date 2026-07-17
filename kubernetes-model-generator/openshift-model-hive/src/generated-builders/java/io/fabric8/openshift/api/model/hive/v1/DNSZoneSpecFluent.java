package io.fabric8.openshift.api.model.hive.v1;

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
public class DNSZoneSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.DNSZoneSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSDNSZoneSpecBuilder aws;
  private AzureDNSZoneSpecBuilder azure;
  private GCPDNSZoneSpecBuilder gcp;
  private Boolean linkToParentDomain;
  private Boolean preserveOnDelete;
  private String zone;

  public DNSZoneSpecFluent() {
  }
  
  public DNSZoneSpecFluent(DNSZoneSpec instance) {
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
  
  public AWSDNSZoneSpec buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public AzureDNSZoneSpec buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public GCPDNSZoneSpec buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  protected void copyInstance(DNSZoneSpec instance) {
    instance = instance != null ? instance : new DNSZoneSpec();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withGcp(instance.getGcp());
        this.withLinkToParentDomain(instance.getLinkToParentDomain());
        this.withPreserveOnDelete(instance.getPreserveOnDelete());
        this.withZone(instance.getZone());
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
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSDNSZoneSpecBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSDNSZoneSpec item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new AzureDNSZoneSpecBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(AzureDNSZoneSpec item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPDNSZoneSpecBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPDNSZoneSpec item) {
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
    DNSZoneSpecFluent that = (DNSZoneSpecFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(linkToParentDomain, that.linkToParentDomain))) {
      return false;
    }
    if (!(Objects.equals(preserveOnDelete, that.preserveOnDelete))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
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
  
  public Boolean getLinkToParentDomain() {
    return this.linkToParentDomain;
  }
  
  public Boolean getPreserveOnDelete() {
    return this.preserveOnDelete;
  }
  
  public String getZone() {
    return this.zone;
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
  
  public boolean hasLinkToParentDomain() {
    return this.linkToParentDomain != null;
  }
  
  public boolean hasPreserveOnDelete() {
    return this.preserveOnDelete != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, gcp, linkToParentDomain, preserveOnDelete, zone, additionalProperties);
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
    if (!(linkToParentDomain == null)) {
        sb.append("linkToParentDomain:");
        sb.append(linkToParentDomain);
        sb.append(",");
    }
    if (!(preserveOnDelete == null)) {
        sb.append("preserveOnDelete:");
        sb.append(preserveOnDelete);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
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
  
  public A withAws(AWSDNSZoneSpec aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSDNSZoneSpecBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(AzureDNSZoneSpec azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new AzureDNSZoneSpecBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withGcp(GCPDNSZoneSpec gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPDNSZoneSpecBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withLinkToParentDomain() {
    return withLinkToParentDomain(true);
  }
  
  public A withLinkToParentDomain(Boolean linkToParentDomain) {
    this.linkToParentDomain = linkToParentDomain;
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(AWSDNSZoneSpec item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(AzureDNSZoneSpec item) {
    return new AzureNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(GCPDNSZoneSpec item) {
    return new GcpNested(item);
  }
  
  public A withPreserveOnDelete() {
    return withPreserveOnDelete(true);
  }
  
  public A withPreserveOnDelete(Boolean preserveOnDelete) {
    this.preserveOnDelete = preserveOnDelete;
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  public class AwsNested<N> extends AWSDNSZoneSpecFluent<AwsNested<N>> implements Nested<N>{
  
    AWSDNSZoneSpecBuilder builder;
  
    AwsNested(AWSDNSZoneSpec item) {
      this.builder = new AWSDNSZoneSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneSpecFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzureDNSZoneSpecFluent<AzureNested<N>> implements Nested<N>{
  
    AzureDNSZoneSpecBuilder builder;
  
    AzureNested(AzureDNSZoneSpec item) {
      this.builder = new AzureDNSZoneSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneSpecFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPDNSZoneSpecFluent<GcpNested<N>> implements Nested<N>{
  
    GCPDNSZoneSpecBuilder builder;
  
    GcpNested(GCPDNSZoneSpec item) {
      this.builder = new GCPDNSZoneSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneSpecFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}