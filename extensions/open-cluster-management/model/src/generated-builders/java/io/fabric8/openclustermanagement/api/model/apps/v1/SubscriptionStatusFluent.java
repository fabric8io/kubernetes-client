package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class SubscriptionStatusFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.SubscriptionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AnsibleJobsStatusBuilder ansiblejobs;
  private String appstatusReference;
  private String lastUpdateTime;
  private String message;
  private String phase;
  private String reason;
  private Map<String,SubscriptionPerClusterStatus> statuses;

  public SubscriptionStatusFluent() {
  }
  
  public SubscriptionStatusFluent(SubscriptionStatus instance) {
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
  
  public A addToStatuses(Map<String,SubscriptionPerClusterStatus> map) {
    if (this.statuses == null && map != null) {
      this.statuses = new LinkedHashMap();
    }
    if (map != null) {
      this.statuses.putAll(map);
    }
    return (A) this;
  }
  
  public A addToStatuses(String key,SubscriptionPerClusterStatus value) {
    if (this.statuses == null && key != null && value != null) {
      this.statuses = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.statuses.put(key, value);
    }
    return (A) this;
  }
  
  public AnsibleJobsStatus buildAnsiblejobs() {
    return this.ansiblejobs != null ? this.ansiblejobs.build() : null;
  }
  
  protected void copyInstance(SubscriptionStatus instance) {
    instance = instance != null ? instance : new SubscriptionStatus();
    if (instance != null) {
        this.withAnsiblejobs(instance.getAnsiblejobs());
        this.withAppstatusReference(instance.getAppstatusReference());
        this.withLastUpdateTime(instance.getLastUpdateTime());
        this.withMessage(instance.getMessage());
        this.withPhase(instance.getPhase());
        this.withReason(instance.getReason());
        this.withStatuses(instance.getStatuses());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AnsiblejobsNested<A> editAnsiblejobs() {
    return this.withNewAnsiblejobsLike(Optional.ofNullable(this.buildAnsiblejobs()).orElse(null));
  }
  
  public AnsiblejobsNested<A> editOrNewAnsiblejobs() {
    return this.withNewAnsiblejobsLike(Optional.ofNullable(this.buildAnsiblejobs()).orElse(new AnsibleJobsStatusBuilder().build()));
  }
  
  public AnsiblejobsNested<A> editOrNewAnsiblejobsLike(AnsibleJobsStatus item) {
    return this.withNewAnsiblejobsLike(Optional.ofNullable(this.buildAnsiblejobs()).orElse(item));
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
    SubscriptionStatusFluent that = (SubscriptionStatusFluent) o;
    if (!(Objects.equals(ansiblejobs, that.ansiblejobs))) {
      return false;
    }
    if (!(Objects.equals(appstatusReference, that.appstatusReference))) {
      return false;
    }
    if (!(Objects.equals(lastUpdateTime, that.lastUpdateTime))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(statuses, that.statuses))) {
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
  
  public String getAppstatusReference() {
    return this.appstatusReference;
  }
  
  public String getLastUpdateTime() {
    return this.lastUpdateTime;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public Map<String,SubscriptionPerClusterStatus> getStatuses() {
    return this.statuses;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnsiblejobs() {
    return this.ansiblejobs != null;
  }
  
  public boolean hasAppstatusReference() {
    return this.appstatusReference != null;
  }
  
  public boolean hasLastUpdateTime() {
    return this.lastUpdateTime != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasStatuses() {
    return this.statuses != null;
  }
  
  public int hashCode() {
    return Objects.hash(ansiblejobs, appstatusReference, lastUpdateTime, message, phase, reason, statuses, additionalProperties);
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
  
  public A removeFromStatuses(String key) {
    if (this.statuses == null) {
      return (A) this;
    }
    if (key != null && this.statuses != null) {
      this.statuses.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromStatuses(Map<String,SubscriptionPerClusterStatus> map) {
    if (this.statuses == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.statuses != null) {
          this.statuses.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ansiblejobs == null)) {
        sb.append("ansiblejobs:");
        sb.append(ansiblejobs);
        sb.append(",");
    }
    if (!(appstatusReference == null)) {
        sb.append("appstatusReference:");
        sb.append(appstatusReference);
        sb.append(",");
    }
    if (!(lastUpdateTime == null)) {
        sb.append("lastUpdateTime:");
        sb.append(lastUpdateTime);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(statuses == null) && !(statuses.isEmpty())) {
        sb.append("statuses:");
        sb.append(statuses);
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
  
  public A withAnsiblejobs(AnsibleJobsStatus ansiblejobs) {
    this._visitables.remove("ansiblejobs");
    if (ansiblejobs != null) {
        this.ansiblejobs = new AnsibleJobsStatusBuilder(ansiblejobs);
        this._visitables.get("ansiblejobs").add(this.ansiblejobs);
    } else {
        this.ansiblejobs = null;
        this._visitables.get("ansiblejobs").remove(this.ansiblejobs);
    }
    return (A) this;
  }
  
  public A withAppstatusReference(String appstatusReference) {
    this.appstatusReference = appstatusReference;
    return (A) this;
  }
  
  public A withLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public AnsiblejobsNested<A> withNewAnsiblejobs() {
    return new AnsiblejobsNested(null);
  }
  
  public AnsiblejobsNested<A> withNewAnsiblejobsLike(AnsibleJobsStatus item) {
    return new AnsiblejobsNested(item);
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public <K,V>A withStatuses(Map<String,SubscriptionPerClusterStatus> statuses) {
    if (statuses == null) {
      this.statuses = null;
    } else {
      this.statuses = new LinkedHashMap(statuses);
    }
    return (A) this;
  }
  public class AnsiblejobsNested<N> extends AnsibleJobsStatusFluent<AnsiblejobsNested<N>> implements Nested<N>{
  
    AnsibleJobsStatusBuilder builder;
  
    AnsiblejobsNested(AnsibleJobsStatus item) {
      this.builder = new AnsibleJobsStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionStatusFluent.this.withAnsiblejobs(builder.build());
    }
    
    public N endAnsiblejobs() {
      return and();
    }
    
  }
}