package io.fabric8.openshift.api.model.monitoring.v1;

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
public class RulesAlertFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.RulesAlertFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String forGracePeriod;
  private String forOutageTolerance;
  private String resendDelay;

  public RulesAlertFluent() {
  }
  
  public RulesAlertFluent(RulesAlert instance) {
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
  
  protected void copyInstance(RulesAlert instance) {
    instance = instance != null ? instance : new RulesAlert();
    if (instance != null) {
        this.withForGracePeriod(instance.getForGracePeriod());
        this.withForOutageTolerance(instance.getForOutageTolerance());
        this.withResendDelay(instance.getResendDelay());
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
    RulesAlertFluent that = (RulesAlertFluent) o;
    if (!(Objects.equals(forGracePeriod, that.forGracePeriod))) {
      return false;
    }
    if (!(Objects.equals(forOutageTolerance, that.forOutageTolerance))) {
      return false;
    }
    if (!(Objects.equals(resendDelay, that.resendDelay))) {
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
  
  public String getForGracePeriod() {
    return this.forGracePeriod;
  }
  
  public String getForOutageTolerance() {
    return this.forOutageTolerance;
  }
  
  public String getResendDelay() {
    return this.resendDelay;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasForGracePeriod() {
    return this.forGracePeriod != null;
  }
  
  public boolean hasForOutageTolerance() {
    return this.forOutageTolerance != null;
  }
  
  public boolean hasResendDelay() {
    return this.resendDelay != null;
  }
  
  public int hashCode() {
    return Objects.hash(forGracePeriod, forOutageTolerance, resendDelay, additionalProperties);
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
    if (!(forGracePeriod == null)) {
        sb.append("forGracePeriod:");
        sb.append(forGracePeriod);
        sb.append(",");
    }
    if (!(forOutageTolerance == null)) {
        sb.append("forOutageTolerance:");
        sb.append(forOutageTolerance);
        sb.append(",");
    }
    if (!(resendDelay == null)) {
        sb.append("resendDelay:");
        sb.append(resendDelay);
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
  
  public A withForGracePeriod(String forGracePeriod) {
    this.forGracePeriod = forGracePeriod;
    return (A) this;
  }
  
  public A withForOutageTolerance(String forOutageTolerance) {
    this.forOutageTolerance = forOutageTolerance;
    return (A) this;
  }
  
  public A withResendDelay(String resendDelay) {
    this.resendDelay = resendDelay;
    return (A) this;
  }
  
}