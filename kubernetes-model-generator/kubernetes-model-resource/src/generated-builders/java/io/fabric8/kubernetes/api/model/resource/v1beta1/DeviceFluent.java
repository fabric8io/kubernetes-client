package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
public class DeviceFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta1.DeviceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BasicDeviceBuilder basic;
  private String name;

  public DeviceFluent() {
  }
  
  public DeviceFluent(Device instance) {
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
  
  public BasicDevice buildBasic() {
    return this.basic != null ? this.basic.build() : null;
  }
  
  protected void copyInstance(Device instance) {
    instance = instance != null ? instance : new Device();
    if (instance != null) {
        this.withBasic(instance.getBasic());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BasicNested<A> editBasic() {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(null));
  }
  
  public BasicNested<A> editOrNewBasic() {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(new BasicDeviceBuilder().build()));
  }
  
  public BasicNested<A> editOrNewBasicLike(BasicDevice item) {
    return this.withNewBasicLike(Optional.ofNullable(this.buildBasic()).orElse(item));
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
    DeviceFluent that = (DeviceFluent) o;
    if (!(Objects.equals(basic, that.basic))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBasic() {
    return this.basic != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(basic, name, additionalProperties);
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
    if (!(basic == null)) {
        sb.append("basic:");
        sb.append(basic);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withBasic(BasicDevice basic) {
    this._visitables.remove("basic");
    if (basic != null) {
        this.basic = new BasicDeviceBuilder(basic);
        this._visitables.get("basic").add(this.basic);
    } else {
        this.basic = null;
        this._visitables.get("basic").remove(this.basic);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public BasicNested<A> withNewBasic() {
    return new BasicNested(null);
  }
  
  public BasicNested<A> withNewBasicLike(BasicDevice item) {
    return new BasicNested(item);
  }
  public class BasicNested<N> extends BasicDeviceFluent<BasicNested<N>> implements Nested<N>{
  
    BasicDeviceBuilder builder;
  
    BasicNested(BasicDevice item) {
      this.builder = new BasicDeviceBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceFluent.this.withBasic(builder.build());
    }
    
    public N endBasic() {
      return and();
    }
    
  }
}