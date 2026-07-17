package io.fabric8.openshift.api.model.monitoring.v1;

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
public class RulesFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.RulesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RulesAlertBuilder alert;

  public RulesFluent() {
  }
  
  public RulesFluent(Rules instance) {
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
  
  public RulesAlert buildAlert() {
    return this.alert != null ? this.alert.build() : null;
  }
  
  protected void copyInstance(Rules instance) {
    instance = instance != null ? instance : new Rules();
    if (instance != null) {
        this.withAlert(instance.getAlert());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlertNested<A> editAlert() {
    return this.withNewAlertLike(Optional.ofNullable(this.buildAlert()).orElse(null));
  }
  
  public AlertNested<A> editOrNewAlert() {
    return this.withNewAlertLike(Optional.ofNullable(this.buildAlert()).orElse(new RulesAlertBuilder().build()));
  }
  
  public AlertNested<A> editOrNewAlertLike(RulesAlert item) {
    return this.withNewAlertLike(Optional.ofNullable(this.buildAlert()).orElse(item));
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
    RulesFluent that = (RulesFluent) o;
    if (!(Objects.equals(alert, that.alert))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlert() {
    return this.alert != null;
  }
  
  public int hashCode() {
    return Objects.hash(alert, additionalProperties);
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
    if (!(alert == null)) {
        sb.append("alert:");
        sb.append(alert);
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
  
  public A withAlert(RulesAlert alert) {
    this._visitables.remove("alert");
    if (alert != null) {
        this.alert = new RulesAlertBuilder(alert);
        this._visitables.get("alert").add(this.alert);
    } else {
        this.alert = null;
        this._visitables.get("alert").remove(this.alert);
    }
    return (A) this;
  }
  
  public AlertNested<A> withNewAlert() {
    return new AlertNested(null);
  }
  
  public A withNewAlert(String forGracePeriod,String forOutageTolerance,String resendDelay) {
    return (A) this.withAlert(new RulesAlert(forGracePeriod, forOutageTolerance, resendDelay));
  }
  
  public AlertNested<A> withNewAlertLike(RulesAlert item) {
    return new AlertNested(item);
  }
  public class AlertNested<N> extends RulesAlertFluent<AlertNested<N>> implements Nested<N>{
  
    RulesAlertBuilder builder;
  
    AlertNested(RulesAlert item) {
      this.builder = new RulesAlertBuilder(this, item);
    }
  
    public N and() {
      return (N) RulesFluent.this.withAlert(builder.build());
    }
    
    public N endAlert() {
      return and();
    }
    
  }
}