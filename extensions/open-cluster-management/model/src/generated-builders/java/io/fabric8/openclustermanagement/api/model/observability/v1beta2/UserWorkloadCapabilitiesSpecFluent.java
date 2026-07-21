package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
public class UserWorkloadCapabilitiesSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.UserWorkloadCapabilitiesSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private UserWorkloadLogsSpecBuilder logs;
  private UserWorkloadMetricsSpecBuilder metrics;
  private UserWorkloadTracesSpecBuilder traces;

  public UserWorkloadCapabilitiesSpecFluent() {
  }
  
  public UserWorkloadCapabilitiesSpecFluent(UserWorkloadCapabilitiesSpec instance) {
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
  
  public UserWorkloadLogsSpec buildLogs() {
    return this.logs != null ? this.logs.build() : null;
  }
  
  public UserWorkloadMetricsSpec buildMetrics() {
    return this.metrics != null ? this.metrics.build() : null;
  }
  
  public UserWorkloadTracesSpec buildTraces() {
    return this.traces != null ? this.traces.build() : null;
  }
  
  protected void copyInstance(UserWorkloadCapabilitiesSpec instance) {
    instance = instance != null ? instance : new UserWorkloadCapabilitiesSpec();
    if (instance != null) {
        this.withLogs(instance.getLogs());
        this.withMetrics(instance.getMetrics());
        this.withTraces(instance.getTraces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LogsNested<A> editLogs() {
    return this.withNewLogsLike(Optional.ofNullable(this.buildLogs()).orElse(null));
  }
  
  public MetricsNested<A> editMetrics() {
    return this.withNewMetricsLike(Optional.ofNullable(this.buildMetrics()).orElse(null));
  }
  
  public LogsNested<A> editOrNewLogs() {
    return this.withNewLogsLike(Optional.ofNullable(this.buildLogs()).orElse(new UserWorkloadLogsSpecBuilder().build()));
  }
  
  public LogsNested<A> editOrNewLogsLike(UserWorkloadLogsSpec item) {
    return this.withNewLogsLike(Optional.ofNullable(this.buildLogs()).orElse(item));
  }
  
  public MetricsNested<A> editOrNewMetrics() {
    return this.withNewMetricsLike(Optional.ofNullable(this.buildMetrics()).orElse(new UserWorkloadMetricsSpecBuilder().build()));
  }
  
  public MetricsNested<A> editOrNewMetricsLike(UserWorkloadMetricsSpec item) {
    return this.withNewMetricsLike(Optional.ofNullable(this.buildMetrics()).orElse(item));
  }
  
  public TracesNested<A> editOrNewTraces() {
    return this.withNewTracesLike(Optional.ofNullable(this.buildTraces()).orElse(new UserWorkloadTracesSpecBuilder().build()));
  }
  
  public TracesNested<A> editOrNewTracesLike(UserWorkloadTracesSpec item) {
    return this.withNewTracesLike(Optional.ofNullable(this.buildTraces()).orElse(item));
  }
  
  public TracesNested<A> editTraces() {
    return this.withNewTracesLike(Optional.ofNullable(this.buildTraces()).orElse(null));
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
    UserWorkloadCapabilitiesSpecFluent that = (UserWorkloadCapabilitiesSpecFluent) o;
    if (!(Objects.equals(logs, that.logs))) {
      return false;
    }
    if (!(Objects.equals(metrics, that.metrics))) {
      return false;
    }
    if (!(Objects.equals(traces, that.traces))) {
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
  
  public boolean hasLogs() {
    return this.logs != null;
  }
  
  public boolean hasMetrics() {
    return this.metrics != null;
  }
  
  public boolean hasTraces() {
    return this.traces != null;
  }
  
  public int hashCode() {
    return Objects.hash(logs, metrics, traces, additionalProperties);
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
    if (!(logs == null)) {
        sb.append("logs:");
        sb.append(logs);
        sb.append(",");
    }
    if (!(metrics == null)) {
        sb.append("metrics:");
        sb.append(metrics);
        sb.append(",");
    }
    if (!(traces == null)) {
        sb.append("traces:");
        sb.append(traces);
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
  
  public A withLogs(UserWorkloadLogsSpec logs) {
    this._visitables.remove("logs");
    if (logs != null) {
        this.logs = new UserWorkloadLogsSpecBuilder(logs);
        this._visitables.get("logs").add(this.logs);
    } else {
        this.logs = null;
        this._visitables.get("logs").remove(this.logs);
    }
    return (A) this;
  }
  
  public A withMetrics(UserWorkloadMetricsSpec metrics) {
    this._visitables.remove("metrics");
    if (metrics != null) {
        this.metrics = new UserWorkloadMetricsSpecBuilder(metrics);
        this._visitables.get("metrics").add(this.metrics);
    } else {
        this.metrics = null;
        this._visitables.get("metrics").remove(this.metrics);
    }
    return (A) this;
  }
  
  public LogsNested<A> withNewLogs() {
    return new LogsNested(null);
  }
  
  public LogsNested<A> withNewLogsLike(UserWorkloadLogsSpec item) {
    return new LogsNested(item);
  }
  
  public MetricsNested<A> withNewMetrics() {
    return new MetricsNested(null);
  }
  
  public MetricsNested<A> withNewMetricsLike(UserWorkloadMetricsSpec item) {
    return new MetricsNested(item);
  }
  
  public TracesNested<A> withNewTraces() {
    return new TracesNested(null);
  }
  
  public TracesNested<A> withNewTracesLike(UserWorkloadTracesSpec item) {
    return new TracesNested(item);
  }
  
  public A withTraces(UserWorkloadTracesSpec traces) {
    this._visitables.remove("traces");
    if (traces != null) {
        this.traces = new UserWorkloadTracesSpecBuilder(traces);
        this._visitables.get("traces").add(this.traces);
    } else {
        this.traces = null;
        this._visitables.get("traces").remove(this.traces);
    }
    return (A) this;
  }
  public class LogsNested<N> extends UserWorkloadLogsSpecFluent<LogsNested<N>> implements Nested<N>{
  
    UserWorkloadLogsSpecBuilder builder;
  
    LogsNested(UserWorkloadLogsSpec item) {
      this.builder = new UserWorkloadLogsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadCapabilitiesSpecFluent.this.withLogs(builder.build());
    }
    
    public N endLogs() {
      return and();
    }
    
  }
  public class MetricsNested<N> extends UserWorkloadMetricsSpecFluent<MetricsNested<N>> implements Nested<N>{
  
    UserWorkloadMetricsSpecBuilder builder;
  
    MetricsNested(UserWorkloadMetricsSpec item) {
      this.builder = new UserWorkloadMetricsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadCapabilitiesSpecFluent.this.withMetrics(builder.build());
    }
    
    public N endMetrics() {
      return and();
    }
    
  }
  public class TracesNested<N> extends UserWorkloadTracesSpecFluent<TracesNested<N>> implements Nested<N>{
  
    UserWorkloadTracesSpecBuilder builder;
  
    TracesNested(UserWorkloadTracesSpec item) {
      this.builder = new UserWorkloadTracesSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) UserWorkloadCapabilitiesSpecFluent.this.withTraces(builder.build());
    }
    
    public N endTraces() {
      return and();
    }
    
  }
}