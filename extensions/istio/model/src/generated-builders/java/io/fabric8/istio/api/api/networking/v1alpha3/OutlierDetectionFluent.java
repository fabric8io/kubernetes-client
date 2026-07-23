package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class OutlierDetectionFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.OutlierDetectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseEjectionTime;
  private Integer consecutive5xxErrors;
  private Integer consecutiveErrors;
  private Integer consecutiveGatewayErrors;
  private Integer consecutiveLocalOriginFailures;
  private String interval;
  private Integer maxEjectionPercent;
  private Integer minHealthPercent;
  private Boolean splitExternalLocalOriginErrors;

  public OutlierDetectionFluent() {
  }
  
  public OutlierDetectionFluent(OutlierDetection instance) {
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
  
  protected void copyInstance(OutlierDetection instance) {
    instance = instance != null ? instance : new OutlierDetection();
    if (instance != null) {
        this.withBaseEjectionTime(instance.getBaseEjectionTime());
        this.withConsecutive5xxErrors(instance.getConsecutive5xxErrors());
        this.withConsecutiveErrors(instance.getConsecutiveErrors());
        this.withConsecutiveGatewayErrors(instance.getConsecutiveGatewayErrors());
        this.withConsecutiveLocalOriginFailures(instance.getConsecutiveLocalOriginFailures());
        this.withInterval(instance.getInterval());
        this.withMaxEjectionPercent(instance.getMaxEjectionPercent());
        this.withMinHealthPercent(instance.getMinHealthPercent());
        this.withSplitExternalLocalOriginErrors(instance.getSplitExternalLocalOriginErrors());
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
    OutlierDetectionFluent that = (OutlierDetectionFluent) o;
    if (!(Objects.equals(baseEjectionTime, that.baseEjectionTime))) {
      return false;
    }
    if (!(Objects.equals(consecutive5xxErrors, that.consecutive5xxErrors))) {
      return false;
    }
    if (!(Objects.equals(consecutiveErrors, that.consecutiveErrors))) {
      return false;
    }
    if (!(Objects.equals(consecutiveGatewayErrors, that.consecutiveGatewayErrors))) {
      return false;
    }
    if (!(Objects.equals(consecutiveLocalOriginFailures, that.consecutiveLocalOriginFailures))) {
      return false;
    }
    if (!(Objects.equals(interval, that.interval))) {
      return false;
    }
    if (!(Objects.equals(maxEjectionPercent, that.maxEjectionPercent))) {
      return false;
    }
    if (!(Objects.equals(minHealthPercent, that.minHealthPercent))) {
      return false;
    }
    if (!(Objects.equals(splitExternalLocalOriginErrors, that.splitExternalLocalOriginErrors))) {
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
  
  public String getBaseEjectionTime() {
    return this.baseEjectionTime;
  }
  
  public Integer getConsecutive5xxErrors() {
    return this.consecutive5xxErrors;
  }
  
  public Integer getConsecutiveErrors() {
    return this.consecutiveErrors;
  }
  
  public Integer getConsecutiveGatewayErrors() {
    return this.consecutiveGatewayErrors;
  }
  
  public Integer getConsecutiveLocalOriginFailures() {
    return this.consecutiveLocalOriginFailures;
  }
  
  public String getInterval() {
    return this.interval;
  }
  
  public Integer getMaxEjectionPercent() {
    return this.maxEjectionPercent;
  }
  
  public Integer getMinHealthPercent() {
    return this.minHealthPercent;
  }
  
  public Boolean getSplitExternalLocalOriginErrors() {
    return this.splitExternalLocalOriginErrors;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseEjectionTime() {
    return this.baseEjectionTime != null;
  }
  
  public boolean hasConsecutive5xxErrors() {
    return this.consecutive5xxErrors != null;
  }
  
  public boolean hasConsecutiveErrors() {
    return this.consecutiveErrors != null;
  }
  
  public boolean hasConsecutiveGatewayErrors() {
    return this.consecutiveGatewayErrors != null;
  }
  
  public boolean hasConsecutiveLocalOriginFailures() {
    return this.consecutiveLocalOriginFailures != null;
  }
  
  public boolean hasInterval() {
    return this.interval != null;
  }
  
  public boolean hasMaxEjectionPercent() {
    return this.maxEjectionPercent != null;
  }
  
  public boolean hasMinHealthPercent() {
    return this.minHealthPercent != null;
  }
  
  public boolean hasSplitExternalLocalOriginErrors() {
    return this.splitExternalLocalOriginErrors != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseEjectionTime, consecutive5xxErrors, consecutiveErrors, consecutiveGatewayErrors, consecutiveLocalOriginFailures, interval, maxEjectionPercent, minHealthPercent, splitExternalLocalOriginErrors, additionalProperties);
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
    if (!(baseEjectionTime == null)) {
        sb.append("baseEjectionTime:");
        sb.append(baseEjectionTime);
        sb.append(",");
    }
    if (!(consecutive5xxErrors == null)) {
        sb.append("consecutive5xxErrors:");
        sb.append(consecutive5xxErrors);
        sb.append(",");
    }
    if (!(consecutiveErrors == null)) {
        sb.append("consecutiveErrors:");
        sb.append(consecutiveErrors);
        sb.append(",");
    }
    if (!(consecutiveGatewayErrors == null)) {
        sb.append("consecutiveGatewayErrors:");
        sb.append(consecutiveGatewayErrors);
        sb.append(",");
    }
    if (!(consecutiveLocalOriginFailures == null)) {
        sb.append("consecutiveLocalOriginFailures:");
        sb.append(consecutiveLocalOriginFailures);
        sb.append(",");
    }
    if (!(interval == null)) {
        sb.append("interval:");
        sb.append(interval);
        sb.append(",");
    }
    if (!(maxEjectionPercent == null)) {
        sb.append("maxEjectionPercent:");
        sb.append(maxEjectionPercent);
        sb.append(",");
    }
    if (!(minHealthPercent == null)) {
        sb.append("minHealthPercent:");
        sb.append(minHealthPercent);
        sb.append(",");
    }
    if (!(splitExternalLocalOriginErrors == null)) {
        sb.append("splitExternalLocalOriginErrors:");
        sb.append(splitExternalLocalOriginErrors);
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
  
  public A withBaseEjectionTime(String baseEjectionTime) {
    this.baseEjectionTime = baseEjectionTime;
    return (A) this;
  }
  
  public A withConsecutive5xxErrors(Integer consecutive5xxErrors) {
    this.consecutive5xxErrors = consecutive5xxErrors;
    return (A) this;
  }
  
  public A withConsecutiveErrors(Integer consecutiveErrors) {
    this.consecutiveErrors = consecutiveErrors;
    return (A) this;
  }
  
  public A withConsecutiveGatewayErrors(Integer consecutiveGatewayErrors) {
    this.consecutiveGatewayErrors = consecutiveGatewayErrors;
    return (A) this;
  }
  
  public A withConsecutiveLocalOriginFailures(Integer consecutiveLocalOriginFailures) {
    this.consecutiveLocalOriginFailures = consecutiveLocalOriginFailures;
    return (A) this;
  }
  
  public A withInterval(String interval) {
    this.interval = interval;
    return (A) this;
  }
  
  public A withMaxEjectionPercent(Integer maxEjectionPercent) {
    this.maxEjectionPercent = maxEjectionPercent;
    return (A) this;
  }
  
  public A withMinHealthPercent(Integer minHealthPercent) {
    this.minHealthPercent = minHealthPercent;
    return (A) this;
  }
  
  public A withSplitExternalLocalOriginErrors() {
    return withSplitExternalLocalOriginErrors(true);
  }
  
  public A withSplitExternalLocalOriginErrors(Boolean splitExternalLocalOriginErrors) {
    this.splitExternalLocalOriginErrors = splitExternalLocalOriginErrors;
    return (A) this;
  }
  
}