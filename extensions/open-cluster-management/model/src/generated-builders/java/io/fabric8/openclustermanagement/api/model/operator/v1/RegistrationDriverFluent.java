package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class RegistrationDriverFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.RegistrationDriverFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authType;
  private AwsIrsaBuilder awsIrsa;

  public RegistrationDriverFluent() {
  }
  
  public RegistrationDriverFluent(RegistrationDriver instance) {
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
  
  public AwsIrsa buildAwsIrsa() {
    return this.awsIrsa != null ? this.awsIrsa.build() : null;
  }
  
  protected void copyInstance(RegistrationDriver instance) {
    instance = instance != null ? instance : new RegistrationDriver();
    if (instance != null) {
        this.withAuthType(instance.getAuthType());
        this.withAwsIrsa(instance.getAwsIrsa());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsIrsaNested<A> editAwsIrsa() {
    return this.withNewAwsIrsaLike(Optional.ofNullable(this.buildAwsIrsa()).orElse(null));
  }
  
  public AwsIrsaNested<A> editOrNewAwsIrsa() {
    return this.withNewAwsIrsaLike(Optional.ofNullable(this.buildAwsIrsa()).orElse(new AwsIrsaBuilder().build()));
  }
  
  public AwsIrsaNested<A> editOrNewAwsIrsaLike(AwsIrsa item) {
    return this.withNewAwsIrsaLike(Optional.ofNullable(this.buildAwsIrsa()).orElse(item));
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
    RegistrationDriverFluent that = (RegistrationDriverFluent) o;
    if (!(Objects.equals(authType, that.authType))) {
      return false;
    }
    if (!(Objects.equals(awsIrsa, that.awsIrsa))) {
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
  
  public String getAuthType() {
    return this.authType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthType() {
    return this.authType != null;
  }
  
  public boolean hasAwsIrsa() {
    return this.awsIrsa != null;
  }
  
  public int hashCode() {
    return Objects.hash(authType, awsIrsa, additionalProperties);
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
    if (!(authType == null)) {
        sb.append("authType:");
        sb.append(authType);
        sb.append(",");
    }
    if (!(awsIrsa == null)) {
        sb.append("awsIrsa:");
        sb.append(awsIrsa);
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
  
  public A withAuthType(String authType) {
    this.authType = authType;
    return (A) this;
  }
  
  public A withAwsIrsa(AwsIrsa awsIrsa) {
    this._visitables.remove("awsIrsa");
    if (awsIrsa != null) {
        this.awsIrsa = new AwsIrsaBuilder(awsIrsa);
        this._visitables.get("awsIrsa").add(this.awsIrsa);
    } else {
        this.awsIrsa = null;
        this._visitables.get("awsIrsa").remove(this.awsIrsa);
    }
    return (A) this;
  }
  
  public AwsIrsaNested<A> withNewAwsIrsa() {
    return new AwsIrsaNested(null);
  }
  
  public A withNewAwsIrsa(String hubClusterArn,String managedClusterArn) {
    return (A) this.withAwsIrsa(new AwsIrsa(hubClusterArn, managedClusterArn));
  }
  
  public AwsIrsaNested<A> withNewAwsIrsaLike(AwsIrsa item) {
    return new AwsIrsaNested(item);
  }
  public class AwsIrsaNested<N> extends AwsIrsaFluent<AwsIrsaNested<N>> implements Nested<N>{
  
    AwsIrsaBuilder builder;
  
    AwsIrsaNested(AwsIrsa item) {
      this.builder = new AwsIrsaBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationDriverFluent.this.withAwsIrsa(builder.build());
    }
    
    public N endAwsIrsa() {
      return and();
    }
    
  }
}