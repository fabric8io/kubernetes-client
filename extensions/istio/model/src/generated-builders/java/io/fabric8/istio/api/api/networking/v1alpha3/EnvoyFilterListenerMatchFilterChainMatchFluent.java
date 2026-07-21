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
public class EnvoyFilterListenerMatchFilterChainMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterListenerMatchFilterChainMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String applicationProtocols;
  private Long destinationPort;
  private EnvoyFilterListenerMatchFilterMatchBuilder filter;
  private String name;
  private String sni;
  private String transportProtocol;

  public EnvoyFilterListenerMatchFilterChainMatchFluent() {
  }
  
  public EnvoyFilterListenerMatchFilterChainMatchFluent(EnvoyFilterListenerMatchFilterChainMatch instance) {
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
  
  public EnvoyFilterListenerMatchFilterMatch buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterListenerMatchFilterChainMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterListenerMatchFilterChainMatch();
    if (instance != null) {
        this.withApplicationProtocols(instance.getApplicationProtocols());
        this.withDestinationPort(instance.getDestinationPort());
        this.withFilter(instance.getFilter());
        this.withName(instance.getName());
        this.withSni(instance.getSni());
        this.withTransportProtocol(instance.getTransportProtocol());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new EnvoyFilterListenerMatchFilterMatchBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(EnvoyFilterListenerMatchFilterMatch item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
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
    EnvoyFilterListenerMatchFilterChainMatchFluent that = (EnvoyFilterListenerMatchFilterChainMatchFluent) o;
    if (!(Objects.equals(applicationProtocols, that.applicationProtocols))) {
      return false;
    }
    if (!(Objects.equals(destinationPort, that.destinationPort))) {
      return false;
    }
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(sni, that.sni))) {
      return false;
    }
    if (!(Objects.equals(transportProtocol, that.transportProtocol))) {
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
  
  public String getApplicationProtocols() {
    return this.applicationProtocols;
  }
  
  public Long getDestinationPort() {
    return this.destinationPort;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSni() {
    return this.sni;
  }
  
  public String getTransportProtocol() {
    return this.transportProtocol;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplicationProtocols() {
    return this.applicationProtocols != null;
  }
  
  public boolean hasDestinationPort() {
    return this.destinationPort != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSni() {
    return this.sni != null;
  }
  
  public boolean hasTransportProtocol() {
    return this.transportProtocol != null;
  }
  
  public int hashCode() {
    return Objects.hash(applicationProtocols, destinationPort, filter, name, sni, transportProtocol, additionalProperties);
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
    if (!(applicationProtocols == null)) {
        sb.append("applicationProtocols:");
        sb.append(applicationProtocols);
        sb.append(",");
    }
    if (!(destinationPort == null)) {
        sb.append("destinationPort:");
        sb.append(destinationPort);
        sb.append(",");
    }
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(sni == null)) {
        sb.append("sni:");
        sb.append(sni);
        sb.append(",");
    }
    if (!(transportProtocol == null)) {
        sb.append("transportProtocol:");
        sb.append(transportProtocol);
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
  
  public A withApplicationProtocols(String applicationProtocols) {
    this.applicationProtocols = applicationProtocols;
    return (A) this;
  }
  
  public A withDestinationPort(Long destinationPort) {
    this.destinationPort = destinationPort;
    return (A) this;
  }
  
  public A withFilter(EnvoyFilterListenerMatchFilterMatch filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new EnvoyFilterListenerMatchFilterMatchBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public FilterNested<A> withNewFilterLike(EnvoyFilterListenerMatchFilterMatch item) {
    return new FilterNested(item);
  }
  
  public A withSni(String sni) {
    this.sni = sni;
    return (A) this;
  }
  
  public A withTransportProtocol(String transportProtocol) {
    this.transportProtocol = transportProtocol;
    return (A) this;
  }
  public class FilterNested<N> extends EnvoyFilterListenerMatchFilterMatchFluent<FilterNested<N>> implements Nested<N>{
  
    EnvoyFilterListenerMatchFilterMatchBuilder builder;
  
    FilterNested(EnvoyFilterListenerMatchFilterMatch item) {
      this.builder = new EnvoyFilterListenerMatchFilterMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterListenerMatchFilterChainMatchFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
}