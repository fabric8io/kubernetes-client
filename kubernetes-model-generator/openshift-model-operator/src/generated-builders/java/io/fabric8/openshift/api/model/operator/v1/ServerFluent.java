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
public class ServerFluent<A extends io.fabric8.openshift.api.model.operator.v1.ServerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ForwardPluginBuilder forwardPlugin;
  private String name;
  private List<String> zones = new ArrayList<String>();

  public ServerFluent() {
  }
  
  public ServerFluent(Server instance) {
    this.copyInstance(instance);
  }

  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
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
  
  public A addToZones(String... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.add(index, item);
    return (A) this;
  }
  
  public ForwardPlugin buildForwardPlugin() {
    return this.forwardPlugin != null ? this.forwardPlugin.build() : null;
  }
  
  protected void copyInstance(Server instance) {
    instance = instance != null ? instance : new Server();
    if (instance != null) {
        this.withForwardPlugin(instance.getForwardPlugin());
        this.withName(instance.getName());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ForwardPluginNested<A> editForwardPlugin() {
    return this.withNewForwardPluginLike(Optional.ofNullable(this.buildForwardPlugin()).orElse(null));
  }
  
  public ForwardPluginNested<A> editOrNewForwardPlugin() {
    return this.withNewForwardPluginLike(Optional.ofNullable(this.buildForwardPlugin()).orElse(new ForwardPluginBuilder().build()));
  }
  
  public ForwardPluginNested<A> editOrNewForwardPluginLike(ForwardPlugin item) {
    return this.withNewForwardPluginLike(Optional.ofNullable(this.buildForwardPlugin()).orElse(item));
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
    ServerFluent that = (ServerFluent) o;
    if (!(Objects.equals(forwardPlugin, that.forwardPlugin))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(zones, that.zones))) {
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
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasForwardPlugin() {
    return this.forwardPlugin != null;
  }
  
  public boolean hasMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(forwardPlugin, name, zones, additionalProperties);
  }
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
    }
    return (A) this;
  }
  
  public A setToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(forwardPlugin == null)) {
        sb.append("forwardPlugin:");
        sb.append(forwardPlugin);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(zones == null) && !(zones.isEmpty())) {
        sb.append("zones:");
        sb.append(zones);
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
  
  public A withForwardPlugin(ForwardPlugin forwardPlugin) {
    this._visitables.remove("forwardPlugin");
    if (forwardPlugin != null) {
        this.forwardPlugin = new ForwardPluginBuilder(forwardPlugin);
        this._visitables.get("forwardPlugin").add(this.forwardPlugin);
    } else {
        this.forwardPlugin = null;
        this._visitables.get("forwardPlugin").remove(this.forwardPlugin);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ForwardPluginNested<A> withNewForwardPlugin() {
    return new ForwardPluginNested(null);
  }
  
  public ForwardPluginNested<A> withNewForwardPluginLike(ForwardPlugin item) {
    return new ForwardPluginNested(item);
  }
  
  public A withZones(List<String> zones) {
    if (zones != null) {
        this.zones = new ArrayList();
        for (String item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(String... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (String item : zones) {
        this.addToZones(item);
      }
    }
    return (A) this;
  }
  public class ForwardPluginNested<N> extends ForwardPluginFluent<ForwardPluginNested<N>> implements Nested<N>{
  
    ForwardPluginBuilder builder;
  
    ForwardPluginNested(ForwardPlugin item) {
      this.builder = new ForwardPluginBuilder(this, item);
    }
  
    public N and() {
      return (N) ServerFluent.this.withForwardPlugin(builder.build());
    }
    
    public N endForwardPlugin() {
      return and();
    }
    
  }
}