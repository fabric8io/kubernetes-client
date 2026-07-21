package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
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
public class PrometheusSourceSpecFluent<A extends io.fabric8.knative.sources.v1alpha1.PrometheusSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authTokenFile;
  private String caCertConfigMap;
  private String promQL;
  private String schedule;
  private String serverURL;
  private String serviceAccountName;
  private DestinationBuilder sink;
  private String step;

  public PrometheusSourceSpecFluent() {
  }
  
  public PrometheusSourceSpecFluent(PrometheusSourceSpec instance) {
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
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(PrometheusSourceSpec instance) {
    instance = instance != null ? instance : new PrometheusSourceSpec();
    if (instance != null) {
        this.withAuthTokenFile(instance.getAuthTokenFile());
        this.withCaCertConfigMap(instance.getCaCertConfigMap());
        this.withPromQL(instance.getPromQL());
        this.withSchedule(instance.getSchedule());
        this.withServerURL(instance.getServerURL());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSink(instance.getSink());
        this.withStep(instance.getStep());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    PrometheusSourceSpecFluent that = (PrometheusSourceSpecFluent) o;
    if (!(Objects.equals(authTokenFile, that.authTokenFile))) {
      return false;
    }
    if (!(Objects.equals(caCertConfigMap, that.caCertConfigMap))) {
      return false;
    }
    if (!(Objects.equals(promQL, that.promQL))) {
      return false;
    }
    if (!(Objects.equals(schedule, that.schedule))) {
      return false;
    }
    if (!(Objects.equals(serverURL, that.serverURL))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
      return false;
    }
    if (!(Objects.equals(step, that.step))) {
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
  
  public String getAuthTokenFile() {
    return this.authTokenFile;
  }
  
  public String getCaCertConfigMap() {
    return this.caCertConfigMap;
  }
  
  public String getPromQL() {
    return this.promQL;
  }
  
  public String getSchedule() {
    return this.schedule;
  }
  
  public String getServerURL() {
    return this.serverURL;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getStep() {
    return this.step;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthTokenFile() {
    return this.authTokenFile != null;
  }
  
  public boolean hasCaCertConfigMap() {
    return this.caCertConfigMap != null;
  }
  
  public boolean hasPromQL() {
    return this.promQL != null;
  }
  
  public boolean hasSchedule() {
    return this.schedule != null;
  }
  
  public boolean hasServerURL() {
    return this.serverURL != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public boolean hasStep() {
    return this.step != null;
  }
  
  public int hashCode() {
    return Objects.hash(authTokenFile, caCertConfigMap, promQL, schedule, serverURL, serviceAccountName, sink, step, additionalProperties);
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
    if (!(authTokenFile == null)) {
        sb.append("authTokenFile:");
        sb.append(authTokenFile);
        sb.append(",");
    }
    if (!(caCertConfigMap == null)) {
        sb.append("caCertConfigMap:");
        sb.append(caCertConfigMap);
        sb.append(",");
    }
    if (!(promQL == null)) {
        sb.append("promQL:");
        sb.append(promQL);
        sb.append(",");
    }
    if (!(schedule == null)) {
        sb.append("schedule:");
        sb.append(schedule);
        sb.append(",");
    }
    if (!(serverURL == null)) {
        sb.append("serverURL:");
        sb.append(serverURL);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
        sb.append(",");
    }
    if (!(step == null)) {
        sb.append("step:");
        sb.append(step);
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
  
  public A withAuthTokenFile(String authTokenFile) {
    this.authTokenFile = authTokenFile;
    return (A) this;
  }
  
  public A withCaCertConfigMap(String caCertConfigMap) {
    this.caCertConfigMap = caCertConfigMap;
    return (A) this;
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withPromQL(String promQL) {
    this.promQL = promQL;
    return (A) this;
  }
  
  public A withSchedule(String schedule) {
    this.schedule = schedule;
    return (A) this;
  }
  
  public A withServerURL(String serverURL) {
    this.serverURL = serverURL;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  
  public A withStep(String step) {
    this.step = step;
    return (A) this;
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}