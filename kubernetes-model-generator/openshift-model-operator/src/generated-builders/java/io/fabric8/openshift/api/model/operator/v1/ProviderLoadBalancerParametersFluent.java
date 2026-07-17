package io.fabric8.openshift.api.model.operator.v1;

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
public class ProviderLoadBalancerParametersFluent<A extends io.fabric8.openshift.api.model.operator.v1.ProviderLoadBalancerParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSLoadBalancerParametersBuilder aws;
  private GCPLoadBalancerParametersBuilder gcp;
  private IBMLoadBalancerParametersBuilder ibm;
  private OpenStackLoadBalancerParametersBuilder openstack;
  private String type;

  public ProviderLoadBalancerParametersFluent() {
  }
  
  public ProviderLoadBalancerParametersFluent(ProviderLoadBalancerParameters instance) {
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
  
  public AWSLoadBalancerParameters buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public GCPLoadBalancerParameters buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public IBMLoadBalancerParameters buildIbm() {
    return this.ibm != null ? this.ibm.build() : null;
  }
  
  public OpenStackLoadBalancerParameters buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  protected void copyInstance(ProviderLoadBalancerParameters instance) {
    instance = instance != null ? instance : new ProviderLoadBalancerParameters();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withGcp(instance.getGcp());
        this.withIbm(instance.getIbm());
        this.withOpenstack(instance.getOpenstack());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public IbmNested<A> editIbm() {
    return this.withNewIbmLike(Optional.ofNullable(this.buildIbm()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSLoadBalancerParametersBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSLoadBalancerParameters item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPLoadBalancerParametersBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPLoadBalancerParameters item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmNested<A> editOrNewIbm() {
    return this.withNewIbmLike(Optional.ofNullable(this.buildIbm()).orElse(new IBMLoadBalancerParametersBuilder().build()));
  }
  
  public IbmNested<A> editOrNewIbmLike(IBMLoadBalancerParameters item) {
    return this.withNewIbmLike(Optional.ofNullable(this.buildIbm()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new OpenStackLoadBalancerParametersBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(OpenStackLoadBalancerParameters item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
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
    ProviderLoadBalancerParametersFluent that = (ProviderLoadBalancerParametersFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibm, that.ibm))) {
      return false;
    }
    if (!(Objects.equals(openstack, that.openstack))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
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
  
  public boolean hasIbm() {
    return this.ibm != null;
  }
  
  public boolean hasOpenstack() {
    return this.openstack != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, gcp, ibm, openstack, type, additionalProperties);
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
    if (!(ibm == null)) {
        sb.append("ibm:");
        sb.append(ibm);
        sb.append(",");
    }
    if (!(openstack == null)) {
        sb.append("openstack:");
        sb.append(openstack);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withAws(AWSLoadBalancerParameters aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSLoadBalancerParametersBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withGcp(GCPLoadBalancerParameters gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPLoadBalancerParametersBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbm(IBMLoadBalancerParameters ibm) {
    this._visitables.remove("ibm");
    if (ibm != null) {
        this.ibm = new IBMLoadBalancerParametersBuilder(ibm);
        this._visitables.get("ibm").add(this.ibm);
    } else {
        this.ibm = null;
        this._visitables.get("ibm").remove(this.ibm);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(AWSLoadBalancerParameters item) {
    return new AwsNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public A withNewGcp(String clientAccess) {
    return (A) this.withGcp(new GCPLoadBalancerParameters(clientAccess));
  }
  
  public GcpNested<A> withNewGcpLike(GCPLoadBalancerParameters item) {
    return new GcpNested(item);
  }
  
  public IbmNested<A> withNewIbm() {
    return new IbmNested(null);
  }
  
  public A withNewIbm(String protocol) {
    return (A) this.withIbm(new IBMLoadBalancerParameters(protocol));
  }
  
  public IbmNested<A> withNewIbmLike(IBMLoadBalancerParameters item) {
    return new IbmNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public A withNewOpenstack(String floatingIP) {
    return (A) this.withOpenstack(new OpenStackLoadBalancerParameters(floatingIP));
  }
  
  public OpenstackNested<A> withNewOpenstackLike(OpenStackLoadBalancerParameters item) {
    return new OpenstackNested(item);
  }
  
  public A withOpenstack(OpenStackLoadBalancerParameters openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new OpenStackLoadBalancerParametersBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class AwsNested<N> extends AWSLoadBalancerParametersFluent<AwsNested<N>> implements Nested<N>{
  
    AWSLoadBalancerParametersBuilder builder;
  
    AwsNested(AWSLoadBalancerParameters item) {
      this.builder = new AWSLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) ProviderLoadBalancerParametersFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPLoadBalancerParametersFluent<GcpNested<N>> implements Nested<N>{
  
    GCPLoadBalancerParametersBuilder builder;
  
    GcpNested(GCPLoadBalancerParameters item) {
      this.builder = new GCPLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) ProviderLoadBalancerParametersFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmNested<N> extends IBMLoadBalancerParametersFluent<IbmNested<N>> implements Nested<N>{
  
    IBMLoadBalancerParametersBuilder builder;
  
    IbmNested(IBMLoadBalancerParameters item) {
      this.builder = new IBMLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) ProviderLoadBalancerParametersFluent.this.withIbm(builder.build());
    }
    
    public N endIbm() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends OpenStackLoadBalancerParametersFluent<OpenstackNested<N>> implements Nested<N>{
  
    OpenStackLoadBalancerParametersBuilder builder;
  
    OpenstackNested(OpenStackLoadBalancerParameters item) {
      this.builder = new OpenStackLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) ProviderLoadBalancerParametersFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
}