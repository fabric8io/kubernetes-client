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
public class RegistrationDriverHubFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.RegistrationDriverHubFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authType;
  private AwsIrsaConfigBuilder awsirsa;
  private CSRConfigBuilder csr;
  private GRPCRegistrationConfigBuilder grpc;

  public RegistrationDriverHubFluent() {
  }
  
  public RegistrationDriverHubFluent(RegistrationDriverHub instance) {
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
  
  public AwsIrsaConfig buildAwsirsa() {
    return this.awsirsa != null ? this.awsirsa.build() : null;
  }
  
  public CSRConfig buildCsr() {
    return this.csr != null ? this.csr.build() : null;
  }
  
  public GRPCRegistrationConfig buildGrpc() {
    return this.grpc != null ? this.grpc.build() : null;
  }
  
  protected void copyInstance(RegistrationDriverHub instance) {
    instance = instance != null ? instance : new RegistrationDriverHub();
    if (instance != null) {
        this.withAuthType(instance.getAuthType());
        this.withAwsirsa(instance.getAwsirsa());
        this.withCsr(instance.getCsr());
        this.withGrpc(instance.getGrpc());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsirsaNested<A> editAwsirsa() {
    return this.withNewAwsirsaLike(Optional.ofNullable(this.buildAwsirsa()).orElse(null));
  }
  
  public CsrNested<A> editCsr() {
    return this.withNewCsrLike(Optional.ofNullable(this.buildCsr()).orElse(null));
  }
  
  public GrpcNested<A> editGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(null));
  }
  
  public AwsirsaNested<A> editOrNewAwsirsa() {
    return this.withNewAwsirsaLike(Optional.ofNullable(this.buildAwsirsa()).orElse(new AwsIrsaConfigBuilder().build()));
  }
  
  public AwsirsaNested<A> editOrNewAwsirsaLike(AwsIrsaConfig item) {
    return this.withNewAwsirsaLike(Optional.ofNullable(this.buildAwsirsa()).orElse(item));
  }
  
  public CsrNested<A> editOrNewCsr() {
    return this.withNewCsrLike(Optional.ofNullable(this.buildCsr()).orElse(new CSRConfigBuilder().build()));
  }
  
  public CsrNested<A> editOrNewCsrLike(CSRConfig item) {
    return this.withNewCsrLike(Optional.ofNullable(this.buildCsr()).orElse(item));
  }
  
  public GrpcNested<A> editOrNewGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(new GRPCRegistrationConfigBuilder().build()));
  }
  
  public GrpcNested<A> editOrNewGrpcLike(GRPCRegistrationConfig item) {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(item));
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
    RegistrationDriverHubFluent that = (RegistrationDriverHubFluent) o;
    if (!(Objects.equals(authType, that.authType))) {
      return false;
    }
    if (!(Objects.equals(awsirsa, that.awsirsa))) {
      return false;
    }
    if (!(Objects.equals(csr, that.csr))) {
      return false;
    }
    if (!(Objects.equals(grpc, that.grpc))) {
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
  
  public boolean hasAwsirsa() {
    return this.awsirsa != null;
  }
  
  public boolean hasCsr() {
    return this.csr != null;
  }
  
  public boolean hasGrpc() {
    return this.grpc != null;
  }
  
  public int hashCode() {
    return Objects.hash(authType, awsirsa, csr, grpc, additionalProperties);
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
    if (!(awsirsa == null)) {
        sb.append("awsirsa:");
        sb.append(awsirsa);
        sb.append(",");
    }
    if (!(csr == null)) {
        sb.append("csr:");
        sb.append(csr);
        sb.append(",");
    }
    if (!(grpc == null)) {
        sb.append("grpc:");
        sb.append(grpc);
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
  
  public A withAwsirsa(AwsIrsaConfig awsirsa) {
    this._visitables.remove("awsirsa");
    if (awsirsa != null) {
        this.awsirsa = new AwsIrsaConfigBuilder(awsirsa);
        this._visitables.get("awsirsa").add(this.awsirsa);
    } else {
        this.awsirsa = null;
        this._visitables.get("awsirsa").remove(this.awsirsa);
    }
    return (A) this;
  }
  
  public A withCsr(CSRConfig csr) {
    this._visitables.remove("csr");
    if (csr != null) {
        this.csr = new CSRConfigBuilder(csr);
        this._visitables.get("csr").add(this.csr);
    } else {
        this.csr = null;
        this._visitables.get("csr").remove(this.csr);
    }
    return (A) this;
  }
  
  public A withGrpc(GRPCRegistrationConfig grpc) {
    this._visitables.remove("grpc");
    if (grpc != null) {
        this.grpc = new GRPCRegistrationConfigBuilder(grpc);
        this._visitables.get("grpc").add(this.grpc);
    } else {
        this.grpc = null;
        this._visitables.get("grpc").remove(this.grpc);
    }
    return (A) this;
  }
  
  public AwsirsaNested<A> withNewAwsirsa() {
    return new AwsirsaNested(null);
  }
  
  public AwsirsaNested<A> withNewAwsirsaLike(AwsIrsaConfig item) {
    return new AwsirsaNested(item);
  }
  
  public CsrNested<A> withNewCsr() {
    return new CsrNested(null);
  }
  
  public CsrNested<A> withNewCsrLike(CSRConfig item) {
    return new CsrNested(item);
  }
  
  public GrpcNested<A> withNewGrpc() {
    return new GrpcNested(null);
  }
  
  public GrpcNested<A> withNewGrpcLike(GRPCRegistrationConfig item) {
    return new GrpcNested(item);
  }
  public class AwsirsaNested<N> extends AwsIrsaConfigFluent<AwsirsaNested<N>> implements Nested<N>{
  
    AwsIrsaConfigBuilder builder;
  
    AwsirsaNested(AwsIrsaConfig item) {
      this.builder = new AwsIrsaConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationDriverHubFluent.this.withAwsirsa(builder.build());
    }
    
    public N endAwsirsa() {
      return and();
    }
    
  }
  public class CsrNested<N> extends CSRConfigFluent<CsrNested<N>> implements Nested<N>{
  
    CSRConfigBuilder builder;
  
    CsrNested(CSRConfig item) {
      this.builder = new CSRConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationDriverHubFluent.this.withCsr(builder.build());
    }
    
    public N endCsr() {
      return and();
    }
    
  }
  public class GrpcNested<N> extends GRPCRegistrationConfigFluent<GrpcNested<N>> implements Nested<N>{
  
    GRPCRegistrationConfigBuilder builder;
  
    GrpcNested(GRPCRegistrationConfig item) {
      this.builder = new GRPCRegistrationConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationDriverHubFluent.this.withGrpc(builder.build());
    }
    
    public N endGrpc() {
      return and();
    }
    
  }
}