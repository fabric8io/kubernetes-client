package io.fabric8.kubernetes.api.model.authorization.v1beta1;

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
public class SubjectAccessReviewStatusFluent<A extends io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReviewStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowed;
  private Boolean denied;
  private String evaluationError;
  private String reason;

  public SubjectAccessReviewStatusFluent() {
  }
  
  public SubjectAccessReviewStatusFluent(SubjectAccessReviewStatus instance) {
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
  
  protected void copyInstance(SubjectAccessReviewStatus instance) {
    instance = instance != null ? instance : new SubjectAccessReviewStatus();
    if (instance != null) {
        this.withAllowed(instance.getAllowed());
        this.withDenied(instance.getDenied());
        this.withEvaluationError(instance.getEvaluationError());
        this.withReason(instance.getReason());
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
    SubjectAccessReviewStatusFluent that = (SubjectAccessReviewStatusFluent) o;
    if (!(Objects.equals(allowed, that.allowed))) {
      return false;
    }
    if (!(Objects.equals(denied, that.denied))) {
      return false;
    }
    if (!(Objects.equals(evaluationError, that.evaluationError))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
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
  
  public Boolean getAllowed() {
    return this.allowed;
  }
  
  public Boolean getDenied() {
    return this.denied;
  }
  
  public String getEvaluationError() {
    return this.evaluationError;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowed() {
    return this.allowed != null;
  }
  
  public boolean hasDenied() {
    return this.denied != null;
  }
  
  public boolean hasEvaluationError() {
    return this.evaluationError != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowed, denied, evaluationError, reason, additionalProperties);
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
    if (!(allowed == null)) {
        sb.append("allowed:");
        sb.append(allowed);
        sb.append(",");
    }
    if (!(denied == null)) {
        sb.append("denied:");
        sb.append(denied);
        sb.append(",");
    }
    if (!(evaluationError == null)) {
        sb.append("evaluationError:");
        sb.append(evaluationError);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
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
  
  public A withAllowed() {
    return withAllowed(true);
  }
  
  public A withAllowed(Boolean allowed) {
    this.allowed = allowed;
    return (A) this;
  }
  
  public A withDenied() {
    return withDenied(true);
  }
  
  public A withDenied(Boolean denied) {
    this.denied = denied;
    return (A) this;
  }
  
  public A withEvaluationError(String evaluationError) {
    this.evaluationError = evaluationError;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
}