package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GRPCConnectionStateFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.GRPCConnectionStateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String address;
  private String lastConnect;
  private String lastObservedState;

  public GRPCConnectionStateFluent() {
  }
  
  public GRPCConnectionStateFluent(GRPCConnectionState instance) {
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
  
  protected void copyInstance(GRPCConnectionState instance) {
    instance = instance != null ? instance : new GRPCConnectionState();
    if (instance != null) {
        this.withAddress(instance.getAddress());
        this.withLastConnect(instance.getLastConnect());
        this.withLastObservedState(instance.getLastObservedState());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    GRPCConnectionStateFluent that = (GRPCConnectionStateFluent) o;
    if (!(Objects.equals(address, that.address))) {
      return false;
    }
    if (!(Objects.equals(lastConnect, that.lastConnect))) {
      return false;
    }
    if (!(Objects.equals(lastObservedState, that.lastObservedState))) {
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
  
  public String getAddress() {
    return this.address;
  }
  
  public String getLastConnect() {
    return this.lastConnect;
  }
  
  public String getLastObservedState() {
    return this.lastObservedState;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddress() {
    return this.address != null;
  }
  
  public boolean hasLastConnect() {
    return this.lastConnect != null;
  }
  
  public boolean hasLastObservedState() {
    return this.lastObservedState != null;
  }
  
  public int hashCode() {
    return Objects.hash(address, lastConnect, lastObservedState, additionalProperties);
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
    if (!(address == null)) {
        sb.append("address:");
        sb.append(address);
        sb.append(",");
    }
    if (!(lastConnect == null)) {
        sb.append("lastConnect:");
        sb.append(lastConnect);
        sb.append(",");
    }
    if (!(lastObservedState == null)) {
        sb.append("lastObservedState:");
        sb.append(lastObservedState);
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
  
  public A withAddress(String address) {
    this.address = address;
    return (A) this;
  }
  
  public A withLastConnect(String lastConnect) {
    this.lastConnect = lastConnect;
    return (A) this;
  }
  
  public A withLastObservedState(String lastObservedState) {
    this.lastObservedState = lastObservedState;
    return (A) this;
  }
  
}