package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ManageDNSConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.ManageDNSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ManageDNSAWSConfigBuilder aws;
  private ManageDNSAzureConfigBuilder azure;
  private List<String> domains = new ArrayList<String>();
  private ManageDNSGCPConfigBuilder gcp;

  public ManageDNSConfigFluent() {
  }
  
  public ManageDNSConfigFluent(ManageDNSConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToDomains(Collection<String> items) {
    if (this.domains == null) {
      this.domains = new ArrayList();
    }
    for (String item : items) {
      this.domains.add(item);
    }
    return (A) this;
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
  
  public A addToDomains(String... items) {
    if (this.domains == null) {
      this.domains = new ArrayList();
    }
    for (String item : items) {
      this.domains.add(item);
    }
    return (A) this;
  }
  
  public A addToDomains(int index,String item) {
    if (this.domains == null) {
      this.domains = new ArrayList();
    }
    this.domains.add(index, item);
    return (A) this;
  }
  
  public ManageDNSAWSConfig buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public ManageDNSAzureConfig buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public ManageDNSGCPConfig buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  protected void copyInstance(ManageDNSConfig instance) {
    instance = instance != null ? instance : new ManageDNSConfig();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withDomains(instance.getDomains());
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
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new ManageDNSAWSConfigBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(ManageDNSAWSConfig item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new ManageDNSAzureConfigBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(ManageDNSAzureConfig item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new ManageDNSGCPConfigBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(ManageDNSGCPConfig item) {
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
    ManageDNSConfigFluent that = (ManageDNSConfigFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(domains, that.domains))) {
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
  
  public String getDomain(int index) {
    return this.domains.get(index);
  }
  
  public List<String> getDomains() {
    return this.domains;
  }
  
  public String getFirstDomain() {
    return this.domains.get(0);
  }
  
  public String getLastDomain() {
    return this.domains.get(domains.size() - 1);
  }
  
  public String getMatchingDomain(Predicate<String> predicate) {
      for (String item : domains) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public boolean hasDomains() {
    return this.domains != null && !(this.domains.isEmpty());
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasMatchingDomain(Predicate<String> predicate) {
      for (String item : domains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, domains, gcp, additionalProperties);
  }
  
  public A removeAllFromDomains(Collection<String> items) {
    if (this.domains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.domains.remove(item);
    }
    return (A) this;
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
  
  public A removeFromDomains(String... items) {
    if (this.domains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.domains.remove(item);
    }
    return (A) this;
  }
  
  public A setToDomains(int index,String item) {
    if (this.domains == null) {
      this.domains = new ArrayList();
    }
    this.domains.set(index, item);
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
    if (!(domains == null) && !(domains.isEmpty())) {
        sb.append("domains:");
        sb.append(domains);
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
  
  public A withAws(ManageDNSAWSConfig aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new ManageDNSAWSConfigBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(ManageDNSAzureConfig azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new ManageDNSAzureConfigBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withDomains(List<String> domains) {
    if (domains != null) {
        this.domains = new ArrayList();
        for (String item : domains) {
          this.addToDomains(item);
        }
    } else {
      this.domains = null;
    }
    return (A) this;
  }
  
  public A withDomains(String... domains) {
    if (this.domains != null) {
        this.domains.clear();
        _visitables.remove("domains");
    }
    if (domains != null) {
      for (String item : domains) {
        this.addToDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withGcp(ManageDNSGCPConfig gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new ManageDNSGCPConfigBuilder(gcp);
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
  
  public AwsNested<A> withNewAwsLike(ManageDNSAWSConfig item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(ManageDNSAzureConfig item) {
    return new AzureNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(ManageDNSGCPConfig item) {
    return new GcpNested(item);
  }
  public class AwsNested<N> extends ManageDNSAWSConfigFluent<AwsNested<N>> implements Nested<N>{
  
    ManageDNSAWSConfigBuilder builder;
  
    AwsNested(ManageDNSAWSConfig item) {
      this.builder = new ManageDNSAWSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ManageDNSConfigFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends ManageDNSAzureConfigFluent<AzureNested<N>> implements Nested<N>{
  
    ManageDNSAzureConfigBuilder builder;
  
    AzureNested(ManageDNSAzureConfig item) {
      this.builder = new ManageDNSAzureConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ManageDNSConfigFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class GcpNested<N> extends ManageDNSGCPConfigFluent<GcpNested<N>> implements Nested<N>{
  
    ManageDNSGCPConfigBuilder builder;
  
    GcpNested(ManageDNSGCPConfig item) {
      this.builder = new ManageDNSGCPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ManageDNSConfigFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}