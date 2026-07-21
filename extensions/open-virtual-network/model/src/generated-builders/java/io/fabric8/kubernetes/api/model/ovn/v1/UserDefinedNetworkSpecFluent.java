package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class UserDefinedNetworkSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.UserDefinedNetworkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Layer2ConfigBuilder layer2;
  private Layer3ConfigBuilder layer3;
  private String topology;

  public UserDefinedNetworkSpecFluent() {
  }
  
  public UserDefinedNetworkSpecFluent(UserDefinedNetworkSpec instance) {
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
  
  public Layer2Config buildLayer2() {
    return this.layer2 != null ? this.layer2.build() : null;
  }
  
  public Layer3Config buildLayer3() {
    return this.layer3 != null ? this.layer3.build() : null;
  }
  
  protected void copyInstance(UserDefinedNetworkSpec instance) {
    instance = instance != null ? instance : new UserDefinedNetworkSpec();
    if (instance != null) {
        this.withLayer2(instance.getLayer2());
        this.withLayer3(instance.getLayer3());
        this.withTopology(instance.getTopology());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public Layer2Nested<A> editLayer2() {
    return this.withNewLayer2Like(Optional.ofNullable(this.buildLayer2()).orElse(null));
  }
  
  public Layer3Nested<A> editLayer3() {
    return this.withNewLayer3Like(Optional.ofNullable(this.buildLayer3()).orElse(null));
  }
  
  public Layer2Nested<A> editOrNewLayer2() {
    return this.withNewLayer2Like(Optional.ofNullable(this.buildLayer2()).orElse(new Layer2ConfigBuilder().build()));
  }
  
  public Layer2Nested<A> editOrNewLayer2Like(Layer2Config item) {
    return this.withNewLayer2Like(Optional.ofNullable(this.buildLayer2()).orElse(item));
  }
  
  public Layer3Nested<A> editOrNewLayer3() {
    return this.withNewLayer3Like(Optional.ofNullable(this.buildLayer3()).orElse(new Layer3ConfigBuilder().build()));
  }
  
  public Layer3Nested<A> editOrNewLayer3Like(Layer3Config item) {
    return this.withNewLayer3Like(Optional.ofNullable(this.buildLayer3()).orElse(item));
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
    UserDefinedNetworkSpecFluent that = (UserDefinedNetworkSpecFluent) o;
    if (!(Objects.equals(layer2, that.layer2))) {
      return false;
    }
    if (!(Objects.equals(layer3, that.layer3))) {
      return false;
    }
    if (!(Objects.equals(topology, that.topology))) {
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
  
  public String getTopology() {
    return this.topology;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLayer2() {
    return this.layer2 != null;
  }
  
  public boolean hasLayer3() {
    return this.layer3 != null;
  }
  
  public boolean hasTopology() {
    return this.topology != null;
  }
  
  public int hashCode() {
    return Objects.hash(layer2, layer3, topology, additionalProperties);
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
    if (!(layer2 == null)) {
        sb.append("layer2:");
        sb.append(layer2);
        sb.append(",");
    }
    if (!(layer3 == null)) {
        sb.append("layer3:");
        sb.append(layer3);
        sb.append(",");
    }
    if (!(topology == null)) {
        sb.append("topology:");
        sb.append(topology);
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
  
  public A withLayer2(Layer2Config layer2) {
    this._visitables.remove("layer2");
    if (layer2 != null) {
        this.layer2 = new Layer2ConfigBuilder(layer2);
        this._visitables.get("layer2").add(this.layer2);
    } else {
        this.layer2 = null;
        this._visitables.get("layer2").remove(this.layer2);
    }
    return (A) this;
  }
  
  public A withLayer3(Layer3Config layer3) {
    this._visitables.remove("layer3");
    if (layer3 != null) {
        this.layer3 = new Layer3ConfigBuilder(layer3);
        this._visitables.get("layer3").add(this.layer3);
    } else {
        this.layer3 = null;
        this._visitables.get("layer3").remove(this.layer3);
    }
    return (A) this;
  }
  
  public Layer2Nested<A> withNewLayer2() {
    return new Layer2Nested(null);
  }
  
  public Layer2Nested<A> withNewLayer2Like(Layer2Config item) {
    return new Layer2Nested(item);
  }
  
  public Layer3Nested<A> withNewLayer3() {
    return new Layer3Nested(null);
  }
  
  public Layer3Nested<A> withNewLayer3Like(Layer3Config item) {
    return new Layer3Nested(item);
  }
  
  public A withTopology(String topology) {
    this.topology = topology;
    return (A) this;
  }
  public class Layer2Nested<N> extends Layer2ConfigFluent<Layer2Nested<N>> implements Nested<N>{
  
    Layer2ConfigBuilder builder;
  
    Layer2Nested(Layer2Config item) {
      this.builder = new Layer2ConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) UserDefinedNetworkSpecFluent.this.withLayer2(builder.build());
    }
    
    public N endLayer2() {
      return and();
    }
    
  }
  public class Layer3Nested<N> extends Layer3ConfigFluent<Layer3Nested<N>> implements Nested<N>{
  
    Layer3ConfigBuilder builder;
  
    Layer3Nested(Layer3Config item) {
      this.builder = new Layer3ConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) UserDefinedNetworkSpecFluent.this.withLayer3(builder.build());
    }
    
    public N endLayer3() {
      return and();
    }
    
  }
}