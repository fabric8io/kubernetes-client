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
public class TrafficExtensionWasmFluent<A extends io.fabric8.istio.api.api.extensions.v1alpha1.TrafficExtensionWasmFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WasmConfigBuilder wasm;

  public TrafficExtensionWasmFluent() {
  }
  
  public TrafficExtensionWasmFluent(TrafficExtensionWasm instance) {
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
  
  public WasmConfig buildWasm() {
    return this.wasm != null ? this.wasm.build() : null;
  }
  
  protected void copyInstance(TrafficExtensionWasm instance) {
    instance = instance != null ? instance : new TrafficExtensionWasm();
    if (instance != null) {
        this.withWasm(instance.getWasm());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WasmNested<A> editOrNewWasm() {
    return this.withNewWasmLike(Optional.ofNullable(this.buildWasm()).orElse(new WasmConfigBuilder().build()));
  }
  
  public WasmNested<A> editOrNewWasmLike(WasmConfig item) {
    return this.withNewWasmLike(Optional.ofNullable(this.buildWasm()).orElse(item));
  }
  
  public WasmNested<A> editWasm() {
    return this.withNewWasmLike(Optional.ofNullable(this.buildWasm()).orElse(null));
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
    TrafficExtensionWasmFluent that = (TrafficExtensionWasmFluent) o;
    if (!(Objects.equals(wasm, that.wasm))) {
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
  
  public boolean hasWasm() {
    return this.wasm != null;
  }
  
  public int hashCode() {
    return Objects.hash(wasm, additionalProperties);
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
    if (!(wasm == null)) {
        sb.append("wasm:");
        sb.append(wasm);
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
  
  public WasmNested<A> withNewWasm() {
    return new WasmNested(null);
  }
  
  public WasmNested<A> withNewWasmLike(WasmConfig item) {
    return new WasmNested(item);
  }
  
  public A withWasm(WasmConfig wasm) {
    this._visitables.remove("wasm");
    if (wasm != null) {
        this.wasm = new WasmConfigBuilder(wasm);
        this._visitables.get("wasm").add(this.wasm);
    } else {
        this.wasm = null;
        this._visitables.get("wasm").remove(this.wasm);
    }
    return (A) this;
  }
  public class WasmNested<N> extends WasmConfigFluent<WasmNested<N>> implements Nested<N>{
  
    WasmConfigBuilder builder;
  
    WasmNested(WasmConfig item) {
      this.builder = new WasmConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) TrafficExtensionWasmFluent.this.withWasm(builder.build());
    }
    
    public N endWasm() {
      return and();
    }
    
  }
}