package io.fabric8.chaosmesh.v1alpha1;

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
public class ClockSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.ClockSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clockIdsSlice;
  private Integer pid;
  private String timeOffset;

  public ClockSpecFluent() {
  }
  
  public ClockSpecFluent(ClockSpec instance) {
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
  
  protected void copyInstance(ClockSpec instance) {
    instance = instance != null ? instance : new ClockSpec();
    if (instance != null) {
        this.withClockIdsSlice(instance.getClockIdsSlice());
        this.withPid(instance.getPid());
        this.withTimeOffset(instance.getTimeOffset());
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
    ClockSpecFluent that = (ClockSpecFluent) o;
    if (!(Objects.equals(clockIdsSlice, that.clockIdsSlice))) {
      return false;
    }
    if (!(Objects.equals(pid, that.pid))) {
      return false;
    }
    if (!(Objects.equals(timeOffset, that.timeOffset))) {
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
  
  public String getClockIdsSlice() {
    return this.clockIdsSlice;
  }
  
  public Integer getPid() {
    return this.pid;
  }
  
  public String getTimeOffset() {
    return this.timeOffset;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClockIdsSlice() {
    return this.clockIdsSlice != null;
  }
  
  public boolean hasPid() {
    return this.pid != null;
  }
  
  public boolean hasTimeOffset() {
    return this.timeOffset != null;
  }
  
  public int hashCode() {
    return Objects.hash(clockIdsSlice, pid, timeOffset, additionalProperties);
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
    if (!(clockIdsSlice == null)) {
        sb.append("clockIdsSlice:");
        sb.append(clockIdsSlice);
        sb.append(",");
    }
    if (!(pid == null)) {
        sb.append("pid:");
        sb.append(pid);
        sb.append(",");
    }
    if (!(timeOffset == null)) {
        sb.append("timeOffset:");
        sb.append(timeOffset);
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
  
  public A withClockIdsSlice(String clockIdsSlice) {
    this.clockIdsSlice = clockIdsSlice;
    return (A) this;
  }
  
  public A withPid(Integer pid) {
    this.pid = pid;
    return (A) this;
  }
  
  public A withTimeOffset(String timeOffset) {
    this.timeOffset = timeOffset;
    return (A) this;
  }
  
}