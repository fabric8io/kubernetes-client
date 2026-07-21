package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class EnvoyFilterListenerMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterListenerMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterListenerMatchFilterChainMatchBuilder filterChain;
  private String listenerFilter;
  private String name;
  private String portName;
  private Long portNumber;

  public EnvoyFilterListenerMatchFluent() {
  }
  
  public EnvoyFilterListenerMatchFluent(EnvoyFilterListenerMatch instance) {
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
  
  public EnvoyFilterListenerMatchFilterChainMatch buildFilterChain() {
    return this.filterChain != null ? this.filterChain.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterListenerMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterListenerMatch();
    if (instance != null) {
        this.withFilterChain(instance.getFilterChain());
        this.withListenerFilter(instance.getListenerFilter());
        this.withName(instance.getName());
        this.withPortName(instance.getPortName());
        this.withPortNumber(instance.getPortNumber());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterChainNested<A> editFilterChain() {
    return this.withNewFilterChainLike(Optional.ofNullable(this.buildFilterChain()).orElse(null));
  }
  
  public FilterChainNested<A> editOrNewFilterChain() {
    return this.withNewFilterChainLike(Optional.ofNullable(this.buildFilterChain()).orElse(new EnvoyFilterListenerMatchFilterChainMatchBuilder().build()));
  }
  
  public FilterChainNested<A> editOrNewFilterChainLike(EnvoyFilterListenerMatchFilterChainMatch item) {
    return this.withNewFilterChainLike(Optional.ofNullable(this.buildFilterChain()).orElse(item));
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
    EnvoyFilterListenerMatchFluent that = (EnvoyFilterListenerMatchFluent) o;
    if (!(Objects.equals(filterChain, that.filterChain))) {
      return false;
    }
    if (!(Objects.equals(listenerFilter, that.listenerFilter))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(portName, that.portName))) {
      return false;
    }
    if (!(Objects.equals(portNumber, that.portNumber))) {
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
  
  public String getListenerFilter() {
    return this.listenerFilter;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPortName() {
    return this.portName;
  }
  
  public Long getPortNumber() {
    return this.portNumber;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilterChain() {
    return this.filterChain != null;
  }
  
  public boolean hasListenerFilter() {
    return this.listenerFilter != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPortName() {
    return this.portName != null;
  }
  
  public boolean hasPortNumber() {
    return this.portNumber != null;
  }
  
  public int hashCode() {
    return Objects.hash(filterChain, listenerFilter, name, portName, portNumber, additionalProperties);
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
    if (!(filterChain == null)) {
        sb.append("filterChain:");
        sb.append(filterChain);
        sb.append(",");
    }
    if (!(listenerFilter == null)) {
        sb.append("listenerFilter:");
        sb.append(listenerFilter);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(portName == null)) {
        sb.append("portName:");
        sb.append(portName);
        sb.append(",");
    }
    if (!(portNumber == null)) {
        sb.append("portNumber:");
        sb.append(portNumber);
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
  
  public A withFilterChain(EnvoyFilterListenerMatchFilterChainMatch filterChain) {
    this._visitables.remove("filterChain");
    if (filterChain != null) {
        this.filterChain = new EnvoyFilterListenerMatchFilterChainMatchBuilder(filterChain);
        this._visitables.get("filterChain").add(this.filterChain);
    } else {
        this.filterChain = null;
        this._visitables.get("filterChain").remove(this.filterChain);
    }
    return (A) this;
  }
  
  public A withListenerFilter(String listenerFilter) {
    this.listenerFilter = listenerFilter;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FilterChainNested<A> withNewFilterChain() {
    return new FilterChainNested(null);
  }
  
  public FilterChainNested<A> withNewFilterChainLike(EnvoyFilterListenerMatchFilterChainMatch item) {
    return new FilterChainNested(item);
  }
  
  public A withPortName(String portName) {
    this.portName = portName;
    return (A) this;
  }
  
  public A withPortNumber(Long portNumber) {
    this.portNumber = portNumber;
    return (A) this;
  }
  public class FilterChainNested<N> extends EnvoyFilterListenerMatchFilterChainMatchFluent<FilterChainNested<N>> implements Nested<N>{
  
    EnvoyFilterListenerMatchFilterChainMatchBuilder builder;
  
    FilterChainNested(EnvoyFilterListenerMatchFilterChainMatch item) {
      this.builder = new EnvoyFilterListenerMatchFilterChainMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterListenerMatchFluent.this.withFilterChain(builder.build());
    }
    
    public N endFilterChain() {
      return and();
    }
    
  }
}