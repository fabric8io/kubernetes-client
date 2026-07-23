package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class MetaDataIPAddressFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.MetaDataIPAddressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String end;
  private String key;
  private String start;
  private Integer step;
  private String subnet;

  public MetaDataIPAddressFluent() {
  }
  
  public MetaDataIPAddressFluent(MetaDataIPAddress instance) {
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
  
  protected void copyInstance(MetaDataIPAddress instance) {
    instance = instance != null ? instance : new MetaDataIPAddress();
    if (instance != null) {
        this.withEnd(instance.getEnd());
        this.withKey(instance.getKey());
        this.withStart(instance.getStart());
        this.withStep(instance.getStep());
        this.withSubnet(instance.getSubnet());
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
    MetaDataIPAddressFluent that = (MetaDataIPAddressFluent) o;
    if (!(Objects.equals(end, that.end))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(start, that.start))) {
      return false;
    }
    if (!(Objects.equals(step, that.step))) {
      return false;
    }
    if (!(Objects.equals(subnet, that.subnet))) {
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
  
  public String getEnd() {
    return this.end;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public String getStart() {
    return this.start;
  }
  
  public Integer getStep() {
    return this.step;
  }
  
  public String getSubnet() {
    return this.subnet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnd() {
    return this.end != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasStart() {
    return this.start != null;
  }
  
  public boolean hasStep() {
    return this.step != null;
  }
  
  public boolean hasSubnet() {
    return this.subnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(end, key, start, step, subnet, additionalProperties);
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
    if (!(end == null)) {
        sb.append("end:");
        sb.append(end);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(start == null)) {
        sb.append("start:");
        sb.append(start);
        sb.append(",");
    }
    if (!(step == null)) {
        sb.append("step:");
        sb.append(step);
        sb.append(",");
    }
    if (!(subnet == null)) {
        sb.append("subnet:");
        sb.append(subnet);
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
  
  public A withEnd(String end) {
    this.end = end;
    return (A) this;
  }
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public A withStart(String start) {
    this.start = start;
    return (A) this;
  }
  
  public A withStep(Integer step) {
    this.step = step;
    return (A) this;
  }
  
  public A withSubnet(String subnet) {
    this.subnet = subnet;
    return (A) this;
  }
  
}