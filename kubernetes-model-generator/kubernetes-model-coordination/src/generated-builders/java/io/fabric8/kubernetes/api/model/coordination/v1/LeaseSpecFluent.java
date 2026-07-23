package io.fabric8.kubernetes.api.model.coordination.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LeaseSpecFluent<A extends io.fabric8.kubernetes.api.model.coordination.v1.LeaseSpecFluent<A>> extends BaseFluent<A>{

  private ZonedDateTime acquireTime;
  private Map<String,Object> additionalProperties;
  private String holderIdentity;
  private Integer leaseDurationSeconds;
  private Integer leaseTransitions;
  private String preferredHolder;
  private ZonedDateTime renewTime;
  private String strategy;

  public LeaseSpecFluent() {
  }
  
  public LeaseSpecFluent(LeaseSpec instance) {
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
  
  protected void copyInstance(LeaseSpec instance) {
    instance = instance != null ? instance : new LeaseSpec();
    if (instance != null) {
        this.withAcquireTime(instance.getAcquireTime());
        this.withHolderIdentity(instance.getHolderIdentity());
        this.withLeaseDurationSeconds(instance.getLeaseDurationSeconds());
        this.withLeaseTransitions(instance.getLeaseTransitions());
        this.withPreferredHolder(instance.getPreferredHolder());
        this.withRenewTime(instance.getRenewTime());
        this.withStrategy(instance.getStrategy());
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
    LeaseSpecFluent that = (LeaseSpecFluent) o;
    if (!(Objects.equals(acquireTime, that.acquireTime))) {
      return false;
    }
    if (!(Objects.equals(holderIdentity, that.holderIdentity))) {
      return false;
    }
    if (!(Objects.equals(leaseDurationSeconds, that.leaseDurationSeconds))) {
      return false;
    }
    if (!(Objects.equals(leaseTransitions, that.leaseTransitions))) {
      return false;
    }
    if (!(Objects.equals(preferredHolder, that.preferredHolder))) {
      return false;
    }
    if (!(Objects.equals(renewTime, that.renewTime))) {
      return false;
    }
    if (!(Objects.equals(strategy, that.strategy))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public ZonedDateTime getAcquireTime() {
    return this.acquireTime;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getHolderIdentity() {
    return this.holderIdentity;
  }
  
  public Integer getLeaseDurationSeconds() {
    return this.leaseDurationSeconds;
  }
  
  public Integer getLeaseTransitions() {
    return this.leaseTransitions;
  }
  
  public String getPreferredHolder() {
    return this.preferredHolder;
  }
  
  public ZonedDateTime getRenewTime() {
    return this.renewTime;
  }
  
  public String getStrategy() {
    return this.strategy;
  }
  
  public boolean hasAcquireTime() {
    return this.acquireTime != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHolderIdentity() {
    return this.holderIdentity != null;
  }
  
  public boolean hasLeaseDurationSeconds() {
    return this.leaseDurationSeconds != null;
  }
  
  public boolean hasLeaseTransitions() {
    return this.leaseTransitions != null;
  }
  
  public boolean hasPreferredHolder() {
    return this.preferredHolder != null;
  }
  
  public boolean hasRenewTime() {
    return this.renewTime != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(acquireTime, holderIdentity, leaseDurationSeconds, leaseTransitions, preferredHolder, renewTime, strategy, additionalProperties);
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
    if (!(acquireTime == null)) {
        sb.append("acquireTime:");
        sb.append(acquireTime);
        sb.append(",");
    }
    if (!(holderIdentity == null)) {
        sb.append("holderIdentity:");
        sb.append(holderIdentity);
        sb.append(",");
    }
    if (!(leaseDurationSeconds == null)) {
        sb.append("leaseDurationSeconds:");
        sb.append(leaseDurationSeconds);
        sb.append(",");
    }
    if (!(leaseTransitions == null)) {
        sb.append("leaseTransitions:");
        sb.append(leaseTransitions);
        sb.append(",");
    }
    if (!(preferredHolder == null)) {
        sb.append("preferredHolder:");
        sb.append(preferredHolder);
        sb.append(",");
    }
    if (!(renewTime == null)) {
        sb.append("renewTime:");
        sb.append(renewTime);
        sb.append(",");
    }
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcquireTime(ZonedDateTime acquireTime) {
    this.acquireTime = acquireTime;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withHolderIdentity(String holderIdentity) {
    this.holderIdentity = holderIdentity;
    return (A) this;
  }
  
  public A withLeaseDurationSeconds(Integer leaseDurationSeconds) {
    this.leaseDurationSeconds = leaseDurationSeconds;
    return (A) this;
  }
  
  public A withLeaseTransitions(Integer leaseTransitions) {
    this.leaseTransitions = leaseTransitions;
    return (A) this;
  }
  
  public A withPreferredHolder(String preferredHolder) {
    this.preferredHolder = preferredHolder;
    return (A) this;
  }
  
  public A withRenewTime(ZonedDateTime renewTime) {
    this.renewTime = renewTime;
    return (A) this;
  }
  
  public A withStrategy(String strategy) {
    this.strategy = strategy;
    return (A) this;
  }
  
}