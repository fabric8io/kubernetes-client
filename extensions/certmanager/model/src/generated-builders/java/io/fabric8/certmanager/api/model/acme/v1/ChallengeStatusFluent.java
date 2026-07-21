package io.fabric8.certmanager.api.model.acme.v1;

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
public class ChallengeStatusFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ChallengeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean presented;
  private Boolean processing;
  private String reason;
  private String state;

  public ChallengeStatusFluent() {
  }
  
  public ChallengeStatusFluent(ChallengeStatus instance) {
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
  
  protected void copyInstance(ChallengeStatus instance) {
    instance = instance != null ? instance : new ChallengeStatus();
    if (instance != null) {
        this.withPresented(instance.getPresented());
        this.withProcessing(instance.getProcessing());
        this.withReason(instance.getReason());
        this.withState(instance.getState());
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
    ChallengeStatusFluent that = (ChallengeStatusFluent) o;
    if (!(Objects.equals(presented, that.presented))) {
      return false;
    }
    if (!(Objects.equals(processing, that.processing))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public Boolean getPresented() {
    return this.presented;
  }
  
  public Boolean getProcessing() {
    return this.processing;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPresented() {
    return this.presented != null;
  }
  
  public boolean hasProcessing() {
    return this.processing != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(presented, processing, reason, state, additionalProperties);
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
    if (!(presented == null)) {
        sb.append("presented:");
        sb.append(presented);
        sb.append(",");
    }
    if (!(processing == null)) {
        sb.append("processing:");
        sb.append(processing);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
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
  
  public A withPresented() {
    return withPresented(true);
  }
  
  public A withPresented(Boolean presented) {
    this.presented = presented;
    return (A) this;
  }
  
  public A withProcessing() {
    return withProcessing(true);
  }
  
  public A withProcessing(Boolean processing) {
    this.processing = processing;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
}