package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class DeviceCapacityFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.DeviceCapacityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CapacityRequestPolicyBuilder requestPolicy;
  private Quantity value;

  public DeviceCapacityFluent() {
  }
  
  public DeviceCapacityFluent(DeviceCapacity instance) {
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
  
  public CapacityRequestPolicy buildRequestPolicy() {
    return this.requestPolicy != null ? this.requestPolicy.build() : null;
  }
  
  protected void copyInstance(DeviceCapacity instance) {
    instance = instance != null ? instance : new DeviceCapacity();
    if (instance != null) {
        this.withRequestPolicy(instance.getRequestPolicy());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestPolicyNested<A> editOrNewRequestPolicy() {
    return this.withNewRequestPolicyLike(Optional.ofNullable(this.buildRequestPolicy()).orElse(new CapacityRequestPolicyBuilder().build()));
  }
  
  public RequestPolicyNested<A> editOrNewRequestPolicyLike(CapacityRequestPolicy item) {
    return this.withNewRequestPolicyLike(Optional.ofNullable(this.buildRequestPolicy()).orElse(item));
  }
  
  public RequestPolicyNested<A> editRequestPolicy() {
    return this.withNewRequestPolicyLike(Optional.ofNullable(this.buildRequestPolicy()).orElse(null));
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
    DeviceCapacityFluent that = (DeviceCapacityFluent) o;
    if (!(Objects.equals(requestPolicy, that.requestPolicy))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public Quantity getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRequestPolicy() {
    return this.requestPolicy != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(requestPolicy, value, additionalProperties);
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
    if (!(requestPolicy == null)) {
        sb.append("requestPolicy:");
        sb.append(requestPolicy);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public RequestPolicyNested<A> withNewRequestPolicy() {
    return new RequestPolicyNested(null);
  }
  
  public RequestPolicyNested<A> withNewRequestPolicyLike(CapacityRequestPolicy item) {
    return new RequestPolicyNested(item);
  }
  
  public A withNewValue(String amount) {
    return (A) this.withValue(new Quantity(amount));
  }
  
  public A withNewValue(String amount,String format) {
    return (A) this.withValue(new Quantity(amount, format));
  }
  
  public A withRequestPolicy(CapacityRequestPolicy requestPolicy) {
    this._visitables.remove("requestPolicy");
    if (requestPolicy != null) {
        this.requestPolicy = new CapacityRequestPolicyBuilder(requestPolicy);
        this._visitables.get("requestPolicy").add(this.requestPolicy);
    } else {
        this.requestPolicy = null;
        this._visitables.get("requestPolicy").remove(this.requestPolicy);
    }
    return (A) this;
  }
  
  public A withValue(Quantity value) {
    this.value = value;
    return (A) this;
  }
  public class RequestPolicyNested<N> extends CapacityRequestPolicyFluent<RequestPolicyNested<N>> implements Nested<N>{
  
    CapacityRequestPolicyBuilder builder;
  
    RequestPolicyNested(CapacityRequestPolicy item) {
      this.builder = new CapacityRequestPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceCapacityFluent.this.withRequestPolicy(builder.build());
    }
    
    public N endRequestPolicy() {
      return and();
    }
    
  }
}