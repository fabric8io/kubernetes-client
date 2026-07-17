package io.fabric8.openshift.api.model.operator.v1;

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
public class LoadBalancerStrategyFluent<A extends io.fabric8.openshift.api.model.operator.v1.LoadBalancerStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowedSourceRanges = new ArrayList<String>();
  private String dnsManagementPolicy;
  private ProviderLoadBalancerParametersBuilder providerParameters;
  private String scope;

  public LoadBalancerStrategyFluent() {
  }
  
  public LoadBalancerStrategyFluent(LoadBalancerStrategy instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedSourceRanges(Collection<String> items) {
    if (this.allowedSourceRanges == null) {
      this.allowedSourceRanges = new ArrayList();
    }
    for (String item : items) {
      this.allowedSourceRanges.add(item);
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
  
  public A addToAllowedSourceRanges(String... items) {
    if (this.allowedSourceRanges == null) {
      this.allowedSourceRanges = new ArrayList();
    }
    for (String item : items) {
      this.allowedSourceRanges.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedSourceRanges(int index,String item) {
    if (this.allowedSourceRanges == null) {
      this.allowedSourceRanges = new ArrayList();
    }
    this.allowedSourceRanges.add(index, item);
    return (A) this;
  }
  
  public ProviderLoadBalancerParameters buildProviderParameters() {
    return this.providerParameters != null ? this.providerParameters.build() : null;
  }
  
  protected void copyInstance(LoadBalancerStrategy instance) {
    instance = instance != null ? instance : new LoadBalancerStrategy();
    if (instance != null) {
        this.withAllowedSourceRanges(instance.getAllowedSourceRanges());
        this.withDnsManagementPolicy(instance.getDnsManagementPolicy());
        this.withProviderParameters(instance.getProviderParameters());
        this.withScope(instance.getScope());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProviderParametersNested<A> editOrNewProviderParameters() {
    return this.withNewProviderParametersLike(Optional.ofNullable(this.buildProviderParameters()).orElse(new ProviderLoadBalancerParametersBuilder().build()));
  }
  
  public ProviderParametersNested<A> editOrNewProviderParametersLike(ProviderLoadBalancerParameters item) {
    return this.withNewProviderParametersLike(Optional.ofNullable(this.buildProviderParameters()).orElse(item));
  }
  
  public ProviderParametersNested<A> editProviderParameters() {
    return this.withNewProviderParametersLike(Optional.ofNullable(this.buildProviderParameters()).orElse(null));
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
    LoadBalancerStrategyFluent that = (LoadBalancerStrategyFluent) o;
    if (!(Objects.equals(allowedSourceRanges, that.allowedSourceRanges))) {
      return false;
    }
    if (!(Objects.equals(dnsManagementPolicy, that.dnsManagementPolicy))) {
      return false;
    }
    if (!(Objects.equals(providerParameters, that.providerParameters))) {
      return false;
    }
    if (!(Objects.equals(scope, that.scope))) {
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
  
  public String getAllowedSourceRange(int index) {
    return this.allowedSourceRanges.get(index);
  }
  
  public List<String> getAllowedSourceRanges() {
    return this.allowedSourceRanges;
  }
  
  public String getDnsManagementPolicy() {
    return this.dnsManagementPolicy;
  }
  
  public String getFirstAllowedSourceRange() {
    return this.allowedSourceRanges.get(0);
  }
  
  public String getLastAllowedSourceRange() {
    return this.allowedSourceRanges.get(allowedSourceRanges.size() - 1);
  }
  
  public String getMatchingAllowedSourceRange(Predicate<String> predicate) {
      for (String item : allowedSourceRanges) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getScope() {
    return this.scope;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedSourceRanges() {
    return this.allowedSourceRanges != null && !(this.allowedSourceRanges.isEmpty());
  }
  
  public boolean hasDnsManagementPolicy() {
    return this.dnsManagementPolicy != null;
  }
  
  public boolean hasMatchingAllowedSourceRange(Predicate<String> predicate) {
      for (String item : allowedSourceRanges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProviderParameters() {
    return this.providerParameters != null;
  }
  
  public boolean hasScope() {
    return this.scope != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowedSourceRanges, dnsManagementPolicy, providerParameters, scope, additionalProperties);
  }
  
  public A removeAllFromAllowedSourceRanges(Collection<String> items) {
    if (this.allowedSourceRanges == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedSourceRanges.remove(item);
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
  
  public A removeFromAllowedSourceRanges(String... items) {
    if (this.allowedSourceRanges == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedSourceRanges.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowedSourceRanges(int index,String item) {
    if (this.allowedSourceRanges == null) {
      this.allowedSourceRanges = new ArrayList();
    }
    this.allowedSourceRanges.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedSourceRanges == null) && !(allowedSourceRanges.isEmpty())) {
        sb.append("allowedSourceRanges:");
        sb.append(allowedSourceRanges);
        sb.append(",");
    }
    if (!(dnsManagementPolicy == null)) {
        sb.append("dnsManagementPolicy:");
        sb.append(dnsManagementPolicy);
        sb.append(",");
    }
    if (!(providerParameters == null)) {
        sb.append("providerParameters:");
        sb.append(providerParameters);
        sb.append(",");
    }
    if (!(scope == null)) {
        sb.append("scope:");
        sb.append(scope);
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
  
  public A withAllowedSourceRanges(List<String> allowedSourceRanges) {
    if (allowedSourceRanges != null) {
        this.allowedSourceRanges = new ArrayList();
        for (String item : allowedSourceRanges) {
          this.addToAllowedSourceRanges(item);
        }
    } else {
      this.allowedSourceRanges = null;
    }
    return (A) this;
  }
  
  public A withAllowedSourceRanges(String... allowedSourceRanges) {
    if (this.allowedSourceRanges != null) {
        this.allowedSourceRanges.clear();
        _visitables.remove("allowedSourceRanges");
    }
    if (allowedSourceRanges != null) {
      for (String item : allowedSourceRanges) {
        this.addToAllowedSourceRanges(item);
      }
    }
    return (A) this;
  }
  
  public A withDnsManagementPolicy(String dnsManagementPolicy) {
    this.dnsManagementPolicy = dnsManagementPolicy;
    return (A) this;
  }
  
  public ProviderParametersNested<A> withNewProviderParameters() {
    return new ProviderParametersNested(null);
  }
  
  public ProviderParametersNested<A> withNewProviderParametersLike(ProviderLoadBalancerParameters item) {
    return new ProviderParametersNested(item);
  }
  
  public A withProviderParameters(ProviderLoadBalancerParameters providerParameters) {
    this._visitables.remove("providerParameters");
    if (providerParameters != null) {
        this.providerParameters = new ProviderLoadBalancerParametersBuilder(providerParameters);
        this._visitables.get("providerParameters").add(this.providerParameters);
    } else {
        this.providerParameters = null;
        this._visitables.get("providerParameters").remove(this.providerParameters);
    }
    return (A) this;
  }
  
  public A withScope(String scope) {
    this.scope = scope;
    return (A) this;
  }
  public class ProviderParametersNested<N> extends ProviderLoadBalancerParametersFluent<ProviderParametersNested<N>> implements Nested<N>{
  
    ProviderLoadBalancerParametersBuilder builder;
  
    ProviderParametersNested(ProviderLoadBalancerParameters item) {
      this.builder = new ProviderLoadBalancerParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerStrategyFluent.this.withProviderParameters(builder.build());
    }
    
    public N endProviderParameters() {
      return and();
    }
    
  }
}