package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class KlusterletAddonConfigStatusFluent<A extends io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ProxyConfigBuilder ocpGlobalProxy;

  public KlusterletAddonConfigStatusFluent() {
  }
  
  public KlusterletAddonConfigStatusFluent(KlusterletAddonConfigStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public ProxyConfig buildOcpGlobalProxy() {
    return this.ocpGlobalProxy != null ? this.ocpGlobalProxy.build() : null;
  }
  
  protected void copyInstance(KlusterletAddonConfigStatus instance) {
    instance = instance != null ? instance : new KlusterletAddonConfigStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withOcpGlobalProxy(instance.getOcpGlobalProxy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OcpGlobalProxyNested<A> editOcpGlobalProxy() {
    return this.withNewOcpGlobalProxyLike(Optional.ofNullable(this.buildOcpGlobalProxy()).orElse(null));
  }
  
  public OcpGlobalProxyNested<A> editOrNewOcpGlobalProxy() {
    return this.withNewOcpGlobalProxyLike(Optional.ofNullable(this.buildOcpGlobalProxy()).orElse(new ProxyConfigBuilder().build()));
  }
  
  public OcpGlobalProxyNested<A> editOrNewOcpGlobalProxyLike(ProxyConfig item) {
    return this.withNewOcpGlobalProxyLike(Optional.ofNullable(this.buildOcpGlobalProxy()).orElse(item));
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
    KlusterletAddonConfigStatusFluent that = (KlusterletAddonConfigStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(ocpGlobalProxy, that.ocpGlobalProxy))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOcpGlobalProxy() {
    return this.ocpGlobalProxy != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, ocpGlobalProxy, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(ocpGlobalProxy == null)) {
        sb.append("ocpGlobalProxy:");
        sb.append(ocpGlobalProxy);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public OcpGlobalProxyNested<A> withNewOcpGlobalProxy() {
    return new OcpGlobalProxyNested(null);
  }
  
  public A withNewOcpGlobalProxy(String httpProxy,String httpsProxy,String noProxy) {
    return (A) this.withOcpGlobalProxy(new ProxyConfig(httpProxy, httpsProxy, noProxy));
  }
  
  public OcpGlobalProxyNested<A> withNewOcpGlobalProxyLike(ProxyConfig item) {
    return new OcpGlobalProxyNested(item);
  }
  
  public A withOcpGlobalProxy(ProxyConfig ocpGlobalProxy) {
    this._visitables.remove("ocpGlobalProxy");
    if (ocpGlobalProxy != null) {
        this.ocpGlobalProxy = new ProxyConfigBuilder(ocpGlobalProxy);
        this._visitables.get("ocpGlobalProxy").add(this.ocpGlobalProxy);
    } else {
        this.ocpGlobalProxy = null;
        this._visitables.get("ocpGlobalProxy").remove(this.ocpGlobalProxy);
    }
    return (A) this;
  }
  public class OcpGlobalProxyNested<N> extends ProxyConfigFluent<OcpGlobalProxyNested<N>> implements Nested<N>{
  
    ProxyConfigBuilder builder;
  
    OcpGlobalProxyNested(ProxyConfig item) {
      this.builder = new ProxyConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigStatusFluent.this.withOcpGlobalProxy(builder.build());
    }
    
    public N endOcpGlobalProxy() {
      return and();
    }
    
  }
}