package io.fabric8.istio.api.api.extensions.v1alpha1;

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
public class TrafficExtensionLuaFluent<A extends io.fabric8.istio.api.api.extensions.v1alpha1.TrafficExtensionLuaFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LuaConfigBuilder lua;

  public TrafficExtensionLuaFluent() {
  }
  
  public TrafficExtensionLuaFluent(TrafficExtensionLua instance) {
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
  
  public LuaConfig buildLua() {
    return this.lua != null ? this.lua.build() : null;
  }
  
  protected void copyInstance(TrafficExtensionLua instance) {
    instance = instance != null ? instance : new TrafficExtensionLua();
    if (instance != null) {
        this.withLua(instance.getLua());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LuaNested<A> editLua() {
    return this.withNewLuaLike(Optional.ofNullable(this.buildLua()).orElse(null));
  }
  
  public LuaNested<A> editOrNewLua() {
    return this.withNewLuaLike(Optional.ofNullable(this.buildLua()).orElse(new LuaConfigBuilder().build()));
  }
  
  public LuaNested<A> editOrNewLuaLike(LuaConfig item) {
    return this.withNewLuaLike(Optional.ofNullable(this.buildLua()).orElse(item));
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
    TrafficExtensionLuaFluent that = (TrafficExtensionLuaFluent) o;
    if (!(Objects.equals(lua, that.lua))) {
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
  
  public boolean hasLua() {
    return this.lua != null;
  }
  
  public int hashCode() {
    return Objects.hash(lua, additionalProperties);
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
    if (!(lua == null)) {
        sb.append("lua:");
        sb.append(lua);
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
  
  public A withLua(LuaConfig lua) {
    this._visitables.remove("lua");
    if (lua != null) {
        this.lua = new LuaConfigBuilder(lua);
        this._visitables.get("lua").add(this.lua);
    } else {
        this.lua = null;
        this._visitables.get("lua").remove(this.lua);
    }
    return (A) this;
  }
  
  public LuaNested<A> withNewLua() {
    return new LuaNested(null);
  }
  
  public A withNewLua(String inlineCode) {
    return (A) this.withLua(new LuaConfig(inlineCode));
  }
  
  public LuaNested<A> withNewLuaLike(LuaConfig item) {
    return new LuaNested(item);
  }
  public class LuaNested<N> extends LuaConfigFluent<LuaNested<N>> implements Nested<N>{
  
    LuaConfigBuilder builder;
  
    LuaNested(LuaConfig item) {
      this.builder = new LuaConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficExtensionLuaFluent.this.withLua(builder.build());
    }
    
    public N endLua() {
      return and();
    }
    
  }
}