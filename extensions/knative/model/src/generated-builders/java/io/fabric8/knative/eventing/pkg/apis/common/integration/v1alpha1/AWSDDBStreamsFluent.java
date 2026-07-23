package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
public class AWSDDBStreamsFluent<A extends io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1.AWSDDBStreamsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer delay;
  private Boolean overrideEndpoint;
  private String region;
  private String streamIteratorType;
  private String table;
  private String uriEndpointOverride;

  public AWSDDBStreamsFluent() {
  }
  
  public AWSDDBStreamsFluent(AWSDDBStreams instance) {
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
  
  protected void copyInstance(AWSDDBStreams instance) {
    instance = instance != null ? instance : new AWSDDBStreams();
    if (instance != null) {
        this.withDelay(instance.getDelay());
        this.withOverrideEndpoint(instance.getOverrideEndpoint());
        this.withRegion(instance.getRegion());
        this.withStreamIteratorType(instance.getStreamIteratorType());
        this.withTable(instance.getTable());
        this.withUriEndpointOverride(instance.getUriEndpointOverride());
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
    AWSDDBStreamsFluent that = (AWSDDBStreamsFluent) o;
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(overrideEndpoint, that.overrideEndpoint))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(streamIteratorType, that.streamIteratorType))) {
      return false;
    }
    if (!(Objects.equals(table, that.table))) {
      return false;
    }
    if (!(Objects.equals(uriEndpointOverride, that.uriEndpointOverride))) {
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
  
  public Integer getDelay() {
    return this.delay;
  }
  
  public Boolean getOverrideEndpoint() {
    return this.overrideEndpoint;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getStreamIteratorType() {
    return this.streamIteratorType;
  }
  
  public String getTable() {
    return this.table;
  }
  
  public String getUriEndpointOverride() {
    return this.uriEndpointOverride;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasOverrideEndpoint() {
    return this.overrideEndpoint != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasStreamIteratorType() {
    return this.streamIteratorType != null;
  }
  
  public boolean hasTable() {
    return this.table != null;
  }
  
  public boolean hasUriEndpointOverride() {
    return this.uriEndpointOverride != null;
  }
  
  public int hashCode() {
    return Objects.hash(delay, overrideEndpoint, region, streamIteratorType, table, uriEndpointOverride, additionalProperties);
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
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(overrideEndpoint == null)) {
        sb.append("overrideEndpoint:");
        sb.append(overrideEndpoint);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(streamIteratorType == null)) {
        sb.append("streamIteratorType:");
        sb.append(streamIteratorType);
        sb.append(",");
    }
    if (!(table == null)) {
        sb.append("table:");
        sb.append(table);
        sb.append(",");
    }
    if (!(uriEndpointOverride == null)) {
        sb.append("uriEndpointOverride:");
        sb.append(uriEndpointOverride);
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
  
  public A withDelay(Integer delay) {
    this.delay = delay;
    return (A) this;
  }
  
  public A withOverrideEndpoint() {
    return withOverrideEndpoint(true);
  }
  
  public A withOverrideEndpoint(Boolean overrideEndpoint) {
    this.overrideEndpoint = overrideEndpoint;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withStreamIteratorType(String streamIteratorType) {
    this.streamIteratorType = streamIteratorType;
    return (A) this;
  }
  
  public A withTable(String table) {
    this.table = table;
    return (A) this;
  }
  
  public A withUriEndpointOverride(String uriEndpointOverride) {
    this.uriEndpointOverride = uriEndpointOverride;
    return (A) this;
  }
  
}