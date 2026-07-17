package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class LeaderElectionFluent<A extends io.fabric8.openshift.api.model.config.v1.LeaderElectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean disable;
  private String leaseDuration;
  private String name;
  private String namespace;
  private String renewDeadline;
  private String retryPeriod;

  public LeaderElectionFluent() {
  }
  
  public LeaderElectionFluent(LeaderElection instance) {
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
  
  protected void copyInstance(LeaderElection instance) {
    instance = instance != null ? instance : new LeaderElection();
    if (instance != null) {
        this.withDisable(instance.getDisable());
        this.withLeaseDuration(instance.getLeaseDuration());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withRenewDeadline(instance.getRenewDeadline());
        this.withRetryPeriod(instance.getRetryPeriod());
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
    LeaderElectionFluent that = (LeaderElectionFluent) o;
    if (!(Objects.equals(disable, that.disable))) {
      return false;
    }
    if (!(Objects.equals(leaseDuration, that.leaseDuration))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(renewDeadline, that.renewDeadline))) {
      return false;
    }
    if (!(Objects.equals(retryPeriod, that.retryPeriod))) {
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
  
  public Boolean getDisable() {
    return this.disable;
  }
  
  public String getLeaseDuration() {
    return this.leaseDuration;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getRenewDeadline() {
    return this.renewDeadline;
  }
  
  public String getRetryPeriod() {
    return this.retryPeriod;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisable() {
    return this.disable != null;
  }
  
  public boolean hasLeaseDuration() {
    return this.leaseDuration != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasRenewDeadline() {
    return this.renewDeadline != null;
  }
  
  public boolean hasRetryPeriod() {
    return this.retryPeriod != null;
  }
  
  public int hashCode() {
    return Objects.hash(disable, leaseDuration, name, namespace, renewDeadline, retryPeriod, additionalProperties);
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
    if (!(disable == null)) {
        sb.append("disable:");
        sb.append(disable);
        sb.append(",");
    }
    if (!(leaseDuration == null)) {
        sb.append("leaseDuration:");
        sb.append(leaseDuration);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(renewDeadline == null)) {
        sb.append("renewDeadline:");
        sb.append(renewDeadline);
        sb.append(",");
    }
    if (!(retryPeriod == null)) {
        sb.append("retryPeriod:");
        sb.append(retryPeriod);
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
  
  public A withDisable() {
    return withDisable(true);
  }
  
  public A withDisable(Boolean disable) {
    this.disable = disable;
    return (A) this;
  }
  
  public A withLeaseDuration(String leaseDuration) {
    this.leaseDuration = leaseDuration;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withRenewDeadline(String renewDeadline) {
    this.renewDeadline = renewDeadline;
    return (A) this;
  }
  
  public A withRetryPeriod(String retryPeriod) {
    this.retryPeriod = retryPeriod;
    return (A) this;
  }
  
}