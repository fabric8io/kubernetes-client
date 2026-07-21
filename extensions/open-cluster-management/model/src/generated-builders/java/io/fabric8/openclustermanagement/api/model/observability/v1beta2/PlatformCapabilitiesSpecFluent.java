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
public class PlatformCapabilitiesSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.PlatformCapabilitiesSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PlatformAnalyticsSpecBuilder analytics;
  private PlatformLogsSpecBuilder logs;
  private PlatformMetricsSpecBuilder metrics;

  public PlatformCapabilitiesSpecFluent() {
  }
  
  public PlatformCapabilitiesSpecFluent(PlatformCapabilitiesSpec instance) {
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
  
  public PlatformAnalyticsSpec buildAnalytics() {
    return this.analytics != null ? this.analytics.build() : null;
  }
  
  public PlatformLogsSpec buildLogs() {
    return this.logs != null ? this.logs.build() : null;
  }
  
  public PlatformMetricsSpec buildMetrics() {
    return this.metrics != null ? this.metrics.build() : null;
  }
  
  protected void copyInstance(PlatformCapabilitiesSpec instance) {
    instance = instance != null ? instance : new PlatformCapabilitiesSpec();
    if (instance != null) {
        this.withAnalytics(instance.getAnalytics());
        this.withLogs(instance.getLogs());
        this.withMetrics(instance.getMetrics());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AnalyticsNested<A> editAnalytics() {
    return this.withNewAnalyticsLike(Optional.ofNullable(this.buildAnalytics()).orElse(null));
  }
  
  public LogsNested<A> editLogs() {
    return this.withNewLogsLike(Optional.ofNullable(this.buildLogs()).orElse(null));
  }
  
  public MetricsNested<A> editMetrics() {
    return this.withNewMetricsLike(Optional.ofNullable(this.buildMetrics()).orElse(null));
  }
  
  public AnalyticsNested<A> editOrNewAnalytics() {
    return this.withNewAnalyticsLike(Optional.ofNullable(this.buildAnalytics()).orElse(new PlatformAnalyticsSpecBuilder().build()));
  }
  
  public AnalyticsNested<A> editOrNewAnalyticsLike(PlatformAnalyticsSpec item) {
    return this.withNewAnalyticsLike(Optional.ofNullable(this.buildAnalytics()).orElse(item));
  }
  
  public LogsNested<A> editOrNewLogs() {
    return this.withNewLogsLike(Optional.ofNullable(this.buildLogs()).orElse(new PlatformLogsSpecBuilder().build()));
  }
  
  public LogsNested<A> editOrNewLogsLike(PlatformLogsSpec item) {
    return this.withNewLogsLike(Optional.ofNullable(this.buildLogs()).orElse(item));
  }
  
  public MetricsNested<A> editOrNewMetrics() {
    return this.withNewMetricsLike(Optional.ofNullable(this.buildMetrics()).orElse(new PlatformMetricsSpecBuilder().build()));
  }
  
  public MetricsNested<A> editOrNewMetricsLike(PlatformMetricsSpec item) {
    return this.withNewMetricsLike(Optional.ofNullable(this.buildMetrics()).orElse(item));
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
    PlatformCapabilitiesSpecFluent that = (PlatformCapabilitiesSpecFluent) o;
    if (!(Objects.equals(analytics, that.analytics))) {
      return false;
    }
    if (!(Objects.equals(logs, that.logs))) {
      return false;
    }
    if (!(Objects.equals(metrics, that.metrics))) {
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
  
  public boolean hasAnalytics() {
    return this.analytics != null;
  }
  
  public boolean hasLogs() {
    return this.logs != null;
  }
  
  public boolean hasMetrics() {
    return this.metrics != null;
  }
  
  public int hashCode() {
    return Objects.hash(analytics, logs, metrics, additionalProperties);
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
    if (!(analytics == null)) {
        sb.append("analytics:");
        sb.append(analytics);
        sb.append(",");
    }
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
  
  public A withAnalytics(PlatformAnalyticsSpec analytics) {
    this._visitables.remove("analytics");
    if (analytics != null) {
        this.analytics = new PlatformAnalyticsSpecBuilder(analytics);
        this._visitables.get("analytics").add(this.analytics);
    } else {
        this.analytics = null;
        this._visitables.get("analytics").remove(this.analytics);
    }
    return (A) this;
  }
  
  public A withLogs(PlatformLogsSpec logs) {
    this._visitables.remove("logs");
    if (logs != null) {
        this.logs = new PlatformLogsSpecBuilder(logs);
        this._visitables.get("logs").add(this.logs);
    } else {
        this.logs = null;
        this._visitables.get("logs").remove(this.logs);
    }
    return (A) this;
  }
  
  public A withMetrics(PlatformMetricsSpec metrics) {
    this._visitables.remove("metrics");
    if (metrics != null) {
        this.metrics = new PlatformMetricsSpecBuilder(metrics);
        this._visitables.get("metrics").add(this.metrics);
    } else {
        this.metrics = null;
        this._visitables.get("metrics").remove(this.metrics);
    }
    return (A) this;
  }
  
  public AnalyticsNested<A> withNewAnalytics() {
    return new AnalyticsNested(null);
  }
  
  public AnalyticsNested<A> withNewAnalyticsLike(PlatformAnalyticsSpec item) {
    return new AnalyticsNested(item);
  }
  
  public LogsNested<A> withNewLogs() {
    return new LogsNested(null);
  }
  
  public LogsNested<A> withNewLogsLike(PlatformLogsSpec item) {
    return new LogsNested(item);
  }
  
  public MetricsNested<A> withNewMetrics() {
    return new MetricsNested(null);
  }
  
  public MetricsNested<A> withNewMetricsLike(PlatformMetricsSpec item) {
    return new MetricsNested(item);
  }
  public class AnalyticsNested<N> extends PlatformAnalyticsSpecFluent<AnalyticsNested<N>> implements Nested<N>{
  
    PlatformAnalyticsSpecBuilder builder;
  
    AnalyticsNested(PlatformAnalyticsSpec item) {
      this.builder = new PlatformAnalyticsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformCapabilitiesSpecFluent.this.withAnalytics(builder.build());
    }
    
    public N endAnalytics() {
      return and();
    }
    
  }
  public class LogsNested<N> extends PlatformLogsSpecFluent<LogsNested<N>> implements Nested<N>{
  
    PlatformLogsSpecBuilder builder;
  
    LogsNested(PlatformLogsSpec item) {
      this.builder = new PlatformLogsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformCapabilitiesSpecFluent.this.withLogs(builder.build());
    }
    
    public N endLogs() {
      return and();
    }
    
  }
  public class MetricsNested<N> extends PlatformMetricsSpecFluent<MetricsNested<N>> implements Nested<N>{
  
    PlatformMetricsSpecBuilder builder;
  
    MetricsNested(PlatformMetricsSpec item) {
      this.builder = new PlatformMetricsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformCapabilitiesSpecFluent.this.withMetrics(builder.build());
    }
    
    public N endMetrics() {
      return and();
    }
    
  }
}