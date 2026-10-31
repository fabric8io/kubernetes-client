package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class UserWorkloadMetricsSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.UserWorkloadMetricsSpecFluent<A>> extends BaseFluent<A>{

  private UserWorkloadMetricsDefaultSpecBuilder _default;
  private Map<String,Object> additionalProperties;
  private MetricsAlertsSpecBuilder alerts;

  public UserWorkloadMetricsSpecFluent() {
  }
  
  public UserWorkloadMetricsSpecFluent(UserWorkloadMetricsSpec instance) {
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
  
  public MetricsAlertsSpec buildAlerts() {
    return this.alerts != null ? this.alerts.build() : null;
  }
  
  public UserWorkloadMetricsDefaultSpec buildDefault() {
    return this._default != null ? this._default.build() : null;
  }
  
  protected void copyInstance(UserWorkloadMetricsSpec instance) {
    instance = instance != null ? instance : new UserWorkloadMetricsSpec();
    if (instance != null) {
        this.withAlerts(instance.getAlerts());
        this.withDefault(instance.getDefault());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlertsNested<A> editAlerts() {
    return this.withNewAlertsLike(Optional.ofNullable(this.buildAlerts()).orElse(null));
  }
  
  public DefaultNested<A> editDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(null));
  }
  
  public AlertsNested<A> editOrNewAlerts() {
    return this.withNewAlertsLike(Optional.ofNullable(this.buildAlerts()).orElse(new MetricsAlertsSpecBuilder().build()));
  }
  
  public AlertsNested<A> editOrNewAlertsLike(MetricsAlertsSpec item) {
    return this.withNewAlertsLike(Optional.ofNullable(this.buildAlerts()).orElse(item));
  }
  
  public DefaultNested<A> editOrNewDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(new UserWorkloadMetricsDefaultSpecBuilder().build()));
  }
  
  public DefaultNested<A> editOrNewDefaultLike(UserWorkloadMetricsDefaultSpec item) {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(item));
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
    UserWorkloadMetricsSpecFluent that = (UserWorkloadMetricsSpecFluent) o;
    if (!(Objects.equals(alerts, that.alerts))) {
      return false;
    }
    if (!(Objects.equals(_default, that._default))) {
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
  
  public boolean hasAlerts() {
    return this.alerts != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public int hashCode() {
    return Objects.hash(alerts, _default, additionalProperties);
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
    if (!(alerts == null)) {
        sb.append("alerts:");
        sb.append(alerts);
        sb.append(",");
    }
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
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
  
  public A withAlerts(MetricsAlertsSpec alerts) {
    this._visitables.remove("alerts");
    if (alerts != null) {
        this.alerts = new MetricsAlertsSpecBuilder(alerts);
        this._visitables.get("alerts").add(this.alerts);
    } else {
        this.alerts = null;
        this._visitables.get("alerts").remove(this.alerts);
    }
    return (A) this;
  }
  
  public A withDefault(UserWorkloadMetricsDefaultSpec _default) {
    this._visitables.remove("_default");
    if (_default != null) {
        this._default = new UserWorkloadMetricsDefaultSpecBuilder(_default);
        this._visitables.get("_default").add(this._default);
    } else {
        this._default = null;
        this._visitables.get("_default").remove(this._default);
    }
    return (A) this;
  }
  
  public AlertsNested<A> withNewAlerts() {
    return new AlertsNested(null);
  }
  
  public A withNewAlerts(Boolean enabled) {
    return (A) this.withAlerts(new MetricsAlertsSpec(enabled));
  }
  
  public AlertsNested<A> withNewAlertsLike(MetricsAlertsSpec item) {
    return new AlertsNested(item);
  }
  
  public DefaultNested<A> withNewDefault() {
    return new DefaultNested(null);
  }
  
  public A withNewDefault(Boolean enabled) {
    return (A) this.withDefault(new UserWorkloadMetricsDefaultSpec(enabled));
  }
  
  public DefaultNested<A> withNewDefaultLike(UserWorkloadMetricsDefaultSpec item) {
    return new DefaultNested(item);
  }
  public class AlertsNested<N> extends MetricsAlertsSpecFluent<AlertsNested<N>> implements Nested<N>{
  
    MetricsAlertsSpecBuilder builder;
  
    AlertsNested(MetricsAlertsSpec item) {
      this.builder = new MetricsAlertsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadMetricsSpecFluent.this.withAlerts(builder.build());
    }
    
    public N endAlerts() {
      return and();
    }
    
  }
  public class DefaultNested<N> extends UserWorkloadMetricsDefaultSpecFluent<DefaultNested<N>> implements Nested<N>{
  
    UserWorkloadMetricsDefaultSpecBuilder builder;
  
    DefaultNested(UserWorkloadMetricsDefaultSpec item) {
      this.builder = new UserWorkloadMetricsDefaultSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadMetricsSpecFluent.this.withDefault(builder.build());
    }
    
    public N endDefault() {
      return and();
    }
    
  }
}