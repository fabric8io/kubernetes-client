package io.fabric8.openshift.api.model.hive.v1;

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
public class ServiceProviderCredentialsFluent<A extends io.fabric8.openshift.api.model.hive.v1.ServiceProviderCredentialsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSServiceProviderCredentialsBuilder aws;

  public ServiceProviderCredentialsFluent() {
  }
  
  public ServiceProviderCredentialsFluent(ServiceProviderCredentials instance) {
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
  
  public AWSServiceProviderCredentials buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  protected void copyInstance(ServiceProviderCredentials instance) {
    instance = instance != null ? instance : new ServiceProviderCredentials();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSServiceProviderCredentialsBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSServiceProviderCredentials item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
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
    ServiceProviderCredentialsFluent that = (ServiceProviderCredentialsFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
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
  
  public int hashCode() {
    return Objects.hash(aws, additionalProperties);
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
  
  public A withAws(AWSServiceProviderCredentials aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSServiceProviderCredentialsBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(AWSServiceProviderCredentials item) {
    return new AwsNested(item);
  }
  public class AwsNested<N> extends AWSServiceProviderCredentialsFluent<AwsNested<N>> implements Nested<N>{
  
    AWSServiceProviderCredentialsBuilder builder;
  
    AwsNested(AWSServiceProviderCredentials item) {
      this.builder = new AWSServiceProviderCredentialsBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceProviderCredentialsFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
}