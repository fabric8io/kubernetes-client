package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class FrontendTLSConfigFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.FrontendTLSConfigFluent<A>> extends BaseFluent<A>{

  private TLSConfigBuilder _default;
  private Map<String,Object> additionalProperties;
  private ArrayList<TLSPortConfigBuilder> perPort = new ArrayList<TLSPortConfigBuilder>();

  public FrontendTLSConfigFluent() {
  }
  
  public FrontendTLSConfigFluent(FrontendTLSConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToPerPort(Collection<TLSPortConfig> items) {
    if (this.perPort == null) {
      this.perPort = new ArrayList();
    }
    for (TLSPortConfig item : items) {
        TLSPortConfigBuilder builder = new TLSPortConfigBuilder(item);
        _visitables.get("perPort").add(builder);
        this.perPort.add(builder);
    }
    return (A) this;
  }
  
  public PerPortNested<A> addNewPerPort() {
    return new PerPortNested(-1, null);
  }
  
  public PerPortNested<A> addNewPerPortLike(TLSPortConfig item) {
    return new PerPortNested(-1, item);
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
  
  public A addToPerPort(TLSPortConfig... items) {
    if (this.perPort == null) {
      this.perPort = new ArrayList();
    }
    for (TLSPortConfig item : items) {
        TLSPortConfigBuilder builder = new TLSPortConfigBuilder(item);
        _visitables.get("perPort").add(builder);
        this.perPort.add(builder);
    }
    return (A) this;
  }
  
  public A addToPerPort(int index,TLSPortConfig item) {
    if (this.perPort == null) {
      this.perPort = new ArrayList();
    }
    TLSPortConfigBuilder builder = new TLSPortConfigBuilder(item);
    if (index < 0 || index >= perPort.size()) {
        _visitables.get("perPort").add(builder);
        perPort.add(builder);
    } else {
        _visitables.get("perPort").add(builder);
        perPort.add(index, builder);
    }
    return (A) this;
  }
  
  public TLSConfig buildDefault() {
    return this._default != null ? this._default.build() : null;
  }
  
  public TLSPortConfig buildFirstPerPort() {
    return this.perPort.get(0).build();
  }
  
  public TLSPortConfig buildLastPerPort() {
    return this.perPort.get(perPort.size() - 1).build();
  }
  
  public TLSPortConfig buildMatchingPerPort(Predicate<TLSPortConfigBuilder> predicate) {
      for (TLSPortConfigBuilder item : perPort) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TLSPortConfig> buildPerPort() {
    return this.perPort != null ? build(perPort) : null;
  }
  
  public TLSPortConfig buildPerPort(int index) {
    return this.perPort.get(index).build();
  }
  
  protected void copyInstance(FrontendTLSConfig instance) {
    instance = instance != null ? instance : new FrontendTLSConfig();
    if (instance != null) {
        this.withDefault(instance.getDefault());
        this.withPerPort(instance.getPerPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultNested<A> editDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(null));
  }
  
  public PerPortNested<A> editFirstPerPort() {
    if (perPort.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "perPort"));
    }
    return this.setNewPerPortLike(0, this.buildPerPort(0));
  }
  
  public PerPortNested<A> editLastPerPort() {
    int index = perPort.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "perPort"));
    }
    return this.setNewPerPortLike(index, this.buildPerPort(index));
  }
  
  public PerPortNested<A> editMatchingPerPort(Predicate<TLSPortConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < perPort.size();i++) {
      if (predicate.test(perPort.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "perPort"));
    }
    return this.setNewPerPortLike(index, this.buildPerPort(index));
  }
  
  public DefaultNested<A> editOrNewDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(new TLSConfigBuilder().build()));
  }
  
  public DefaultNested<A> editOrNewDefaultLike(TLSConfig item) {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(item));
  }
  
  public PerPortNested<A> editPerPort(int index) {
    if (perPort.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "perPort"));
    }
    return this.setNewPerPortLike(index, this.buildPerPort(index));
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
    FrontendTLSConfigFluent that = (FrontendTLSConfigFluent) o;
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(perPort, that.perPort))) {
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
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasMatchingPerPort(Predicate<TLSPortConfigBuilder> predicate) {
      for (TLSPortConfigBuilder item : perPort) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPerPort() {
    return this.perPort != null && !(this.perPort.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(_default, perPort, additionalProperties);
  }
  
  public A removeAllFromPerPort(Collection<TLSPortConfig> items) {
    if (this.perPort == null) {
      return (A) this;
    }
    for (TLSPortConfig item : items) {
        TLSPortConfigBuilder builder = new TLSPortConfigBuilder(item);
        _visitables.get("perPort").remove(builder);
        this.perPort.remove(builder);
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
  
  public A removeFromPerPort(TLSPortConfig... items) {
    if (this.perPort == null) {
      return (A) this;
    }
    for (TLSPortConfig item : items) {
        TLSPortConfigBuilder builder = new TLSPortConfigBuilder(item);
        _visitables.get("perPort").remove(builder);
        this.perPort.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPerPort(Predicate<TLSPortConfigBuilder> predicate) {
    if (perPort == null) {
      return (A) this;
    }
    Iterator<TLSPortConfigBuilder> each = perPort.iterator();
    List visitables = _visitables.get("perPort");
    while (each.hasNext()) {
        TLSPortConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PerPortNested<A> setNewPerPortLike(int index,TLSPortConfig item) {
    return new PerPortNested(index, item);
  }
  
  public A setToPerPort(int index,TLSPortConfig item) {
    if (this.perPort == null) {
      this.perPort = new ArrayList();
    }
    TLSPortConfigBuilder builder = new TLSPortConfigBuilder(item);
    if (index < 0 || index >= perPort.size()) {
        _visitables.get("perPort").add(builder);
        perPort.add(builder);
    } else {
        _visitables.get("perPort").add(builder);
        perPort.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(perPort == null) && !(perPort.isEmpty())) {
        sb.append("perPort:");
        sb.append(perPort);
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
  
  public A withDefault(TLSConfig _default) {
    this._visitables.remove("_default");
    if (_default != null) {
        this._default = new TLSConfigBuilder(_default);
        this._visitables.get("_default").add(this._default);
    } else {
        this._default = null;
        this._visitables.get("_default").remove(this._default);
    }
    return (A) this;
  }
  
  public DefaultNested<A> withNewDefault() {
    return new DefaultNested(null);
  }
  
  public DefaultNested<A> withNewDefaultLike(TLSConfig item) {
    return new DefaultNested(item);
  }
  
  public A withPerPort(List<TLSPortConfig> perPort) {
    if (this.perPort != null) {
      this._visitables.get("perPort").clear();
    }
    if (perPort != null) {
        this.perPort = new ArrayList();
        for (TLSPortConfig item : perPort) {
          this.addToPerPort(item);
        }
    } else {
      this.perPort = null;
    }
    return (A) this;
  }
  
  public A withPerPort(TLSPortConfig... perPort) {
    if (this.perPort != null) {
        this.perPort.clear();
        _visitables.remove("perPort");
    }
    if (perPort != null) {
      for (TLSPortConfig item : perPort) {
        this.addToPerPort(item);
      }
    }
    return (A) this;
  }
  public class DefaultNested<N> extends TLSConfigFluent<DefaultNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    DefaultNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) FrontendTLSConfigFluent.this.withDefault(builder.build());
    }
    
    public N endDefault() {
      return and();
    }
    
  }
  public class PerPortNested<N> extends TLSPortConfigFluent<PerPortNested<N>> implements Nested<N>{
  
    TLSPortConfigBuilder builder;
    int index;
  
    PerPortNested(int index,TLSPortConfig item) {
      this.index = index;
      this.builder = new TLSPortConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) FrontendTLSConfigFluent.this.setToPerPort(index, builder.build());
    }
    
    public N endPerPort() {
      return and();
    }
    
  }
}