package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Long;
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
public class ContainerRuntimeConfigurationFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.ContainerRuntimeConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String defaultRuntime;
  private String logLevel;
  private Quantity logSizeMax;
  private Quantity overlaySize;
  private Long pidsLimit;

  public ContainerRuntimeConfigurationFluent() {
  }
  
  public ContainerRuntimeConfigurationFluent(ContainerRuntimeConfiguration instance) {
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
  
  protected void copyInstance(ContainerRuntimeConfiguration instance) {
    instance = instance != null ? instance : new ContainerRuntimeConfiguration();
    if (instance != null) {
        this.withDefaultRuntime(instance.getDefaultRuntime());
        this.withLogLevel(instance.getLogLevel());
        this.withLogSizeMax(instance.getLogSizeMax());
        this.withOverlaySize(instance.getOverlaySize());
        this.withPidsLimit(instance.getPidsLimit());
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
    ContainerRuntimeConfigurationFluent that = (ContainerRuntimeConfigurationFluent) o;
    if (!(Objects.equals(defaultRuntime, that.defaultRuntime))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(logSizeMax, that.logSizeMax))) {
      return false;
    }
    if (!(Objects.equals(overlaySize, that.overlaySize))) {
      return false;
    }
    if (!(Objects.equals(pidsLimit, that.pidsLimit))) {
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
  
  public String getDefaultRuntime() {
    return this.defaultRuntime;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public Quantity getLogSizeMax() {
    return this.logSizeMax;
  }
  
  public Quantity getOverlaySize() {
    return this.overlaySize;
  }
  
  public Long getPidsLimit() {
    return this.pidsLimit;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefaultRuntime() {
    return this.defaultRuntime != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasLogSizeMax() {
    return this.logSizeMax != null;
  }
  
  public boolean hasOverlaySize() {
    return this.overlaySize != null;
  }
  
  public boolean hasPidsLimit() {
    return this.pidsLimit != null;
  }
  
  public int hashCode() {
    return Objects.hash(defaultRuntime, logLevel, logSizeMax, overlaySize, pidsLimit, additionalProperties);
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
    if (!(defaultRuntime == null)) {
        sb.append("defaultRuntime:");
        sb.append(defaultRuntime);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(logSizeMax == null)) {
        sb.append("logSizeMax:");
        sb.append(logSizeMax);
        sb.append(",");
    }
    if (!(overlaySize == null)) {
        sb.append("overlaySize:");
        sb.append(overlaySize);
        sb.append(",");
    }
    if (!(pidsLimit == null)) {
        sb.append("pidsLimit:");
        sb.append(pidsLimit);
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
  
  public A withDefaultRuntime(String defaultRuntime) {
    this.defaultRuntime = defaultRuntime;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withLogSizeMax(Quantity logSizeMax) {
    this.logSizeMax = logSizeMax;
    return (A) this;
  }
  
  public A withNewLogSizeMax(String amount) {
    return (A) this.withLogSizeMax(new Quantity(amount));
  }
  
  public A withNewLogSizeMax(String amount,String format) {
    return (A) this.withLogSizeMax(new Quantity(amount, format));
  }
  
  public A withNewOverlaySize(String amount) {
    return (A) this.withOverlaySize(new Quantity(amount));
  }
  
  public A withNewOverlaySize(String amount,String format) {
    return (A) this.withOverlaySize(new Quantity(amount, format));
  }
  
  public A withOverlaySize(Quantity overlaySize) {
    this.overlaySize = overlaySize;
    return (A) this;
  }
  
  public A withPidsLimit(Long pidsLimit) {
    this.pidsLimit = pidsLimit;
    return (A) this;
  }
  
}