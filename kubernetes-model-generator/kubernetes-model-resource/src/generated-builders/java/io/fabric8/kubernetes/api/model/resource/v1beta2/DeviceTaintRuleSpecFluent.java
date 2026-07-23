package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
public class DeviceTaintRuleSpecFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.DeviceTaintRuleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DeviceTaintSelectorBuilder deviceSelector;
  private DeviceTaintBuilder taint;

  public DeviceTaintRuleSpecFluent() {
  }
  
  public DeviceTaintRuleSpecFluent(DeviceTaintRuleSpec instance) {
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
  
  public DeviceTaintSelector buildDeviceSelector() {
    return this.deviceSelector != null ? this.deviceSelector.build() : null;
  }
  
  public DeviceTaint buildTaint() {
    return this.taint != null ? this.taint.build() : null;
  }
  
  protected void copyInstance(DeviceTaintRuleSpec instance) {
    instance = instance != null ? instance : new DeviceTaintRuleSpec();
    if (instance != null) {
        this.withDeviceSelector(instance.getDeviceSelector());
        this.withTaint(instance.getTaint());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeviceSelectorNested<A> editDeviceSelector() {
    return this.withNewDeviceSelectorLike(Optional.ofNullable(this.buildDeviceSelector()).orElse(null));
  }
  
  public DeviceSelectorNested<A> editOrNewDeviceSelector() {
    return this.withNewDeviceSelectorLike(Optional.ofNullable(this.buildDeviceSelector()).orElse(new DeviceTaintSelectorBuilder().build()));
  }
  
  public DeviceSelectorNested<A> editOrNewDeviceSelectorLike(DeviceTaintSelector item) {
    return this.withNewDeviceSelectorLike(Optional.ofNullable(this.buildDeviceSelector()).orElse(item));
  }
  
  public TaintNested<A> editOrNewTaint() {
    return this.withNewTaintLike(Optional.ofNullable(this.buildTaint()).orElse(new DeviceTaintBuilder().build()));
  }
  
  public TaintNested<A> editOrNewTaintLike(DeviceTaint item) {
    return this.withNewTaintLike(Optional.ofNullable(this.buildTaint()).orElse(item));
  }
  
  public TaintNested<A> editTaint() {
    return this.withNewTaintLike(Optional.ofNullable(this.buildTaint()).orElse(null));
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
    DeviceTaintRuleSpecFluent that = (DeviceTaintRuleSpecFluent) o;
    if (!(Objects.equals(deviceSelector, that.deviceSelector))) {
      return false;
    }
    if (!(Objects.equals(taint, that.taint))) {
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
  
  public boolean hasDeviceSelector() {
    return this.deviceSelector != null;
  }
  
  public boolean hasTaint() {
    return this.taint != null;
  }
  
  public int hashCode() {
    return Objects.hash(deviceSelector, taint, additionalProperties);
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
    if (!(deviceSelector == null)) {
        sb.append("deviceSelector:");
        sb.append(deviceSelector);
        sb.append(",");
    }
    if (!(taint == null)) {
        sb.append("taint:");
        sb.append(taint);
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
  
  public A withDeviceSelector(DeviceTaintSelector deviceSelector) {
    this._visitables.remove("deviceSelector");
    if (deviceSelector != null) {
        this.deviceSelector = new DeviceTaintSelectorBuilder(deviceSelector);
        this._visitables.get("deviceSelector").add(this.deviceSelector);
    } else {
        this.deviceSelector = null;
        this._visitables.get("deviceSelector").remove(this.deviceSelector);
    }
    return (A) this;
  }
  
  public DeviceSelectorNested<A> withNewDeviceSelector() {
    return new DeviceSelectorNested(null);
  }
  
  public A withNewDeviceSelector(String device,String driver,String pool) {
    return (A) this.withDeviceSelector(new DeviceTaintSelector(device, driver, pool));
  }
  
  public DeviceSelectorNested<A> withNewDeviceSelectorLike(DeviceTaintSelector item) {
    return new DeviceSelectorNested(item);
  }
  
  public TaintNested<A> withNewTaint() {
    return new TaintNested(null);
  }
  
  public A withNewTaint(String effect,String key,String timeAdded,String value) {
    return (A) this.withTaint(new DeviceTaint(effect, key, timeAdded, value));
  }
  
  public TaintNested<A> withNewTaintLike(DeviceTaint item) {
    return new TaintNested(item);
  }
  
  public A withTaint(DeviceTaint taint) {
    this._visitables.remove("taint");
    if (taint != null) {
        this.taint = new DeviceTaintBuilder(taint);
        this._visitables.get("taint").add(this.taint);
    } else {
        this.taint = null;
        this._visitables.get("taint").remove(this.taint);
    }
    return (A) this;
  }
  public class DeviceSelectorNested<N> extends DeviceTaintSelectorFluent<DeviceSelectorNested<N>> implements Nested<N>{
  
    DeviceTaintSelectorBuilder builder;
  
    DeviceSelectorNested(DeviceTaintSelector item) {
      this.builder = new DeviceTaintSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceTaintRuleSpecFluent.this.withDeviceSelector(builder.build());
    }
    
    public N endDeviceSelector() {
      return and();
    }
    
  }
  public class TaintNested<N> extends DeviceTaintFluent<TaintNested<N>> implements Nested<N>{
  
    DeviceTaintBuilder builder;
  
    TaintNested(DeviceTaint item) {
      this.builder = new DeviceTaintBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceTaintRuleSpecFluent.this.withTaint(builder.build());
    }
    
    public N endTaint() {
      return and();
    }
    
  }
}