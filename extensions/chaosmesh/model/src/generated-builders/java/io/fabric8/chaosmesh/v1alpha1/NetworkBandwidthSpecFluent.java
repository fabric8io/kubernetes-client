package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class NetworkBandwidthSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.NetworkBandwidthSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long buffer;
  private String device;
  private String hostname;
  private String ipAddress;
  private Long limit;
  private Long minburst;
  private Long peakrate;
  private String rate;

  public NetworkBandwidthSpecFluent() {
  }
  
  public NetworkBandwidthSpecFluent(NetworkBandwidthSpec instance) {
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
  
  protected void copyInstance(NetworkBandwidthSpec instance) {
    instance = instance != null ? instance : new NetworkBandwidthSpec();
    if (instance != null) {
        this.withBuffer(instance.getBuffer());
        this.withDevice(instance.getDevice());
        this.withHostname(instance.getHostname());
        this.withIpAddress(instance.getIpAddress());
        this.withLimit(instance.getLimit());
        this.withMinburst(instance.getMinburst());
        this.withPeakrate(instance.getPeakrate());
        this.withRate(instance.getRate());
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
    NetworkBandwidthSpecFluent that = (NetworkBandwidthSpecFluent) o;
    if (!(Objects.equals(buffer, that.buffer))) {
      return false;
    }
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(ipAddress, that.ipAddress))) {
      return false;
    }
    if (!(Objects.equals(limit, that.limit))) {
      return false;
    }
    if (!(Objects.equals(minburst, that.minburst))) {
      return false;
    }
    if (!(Objects.equals(peakrate, that.peakrate))) {
      return false;
    }
    if (!(Objects.equals(rate, that.rate))) {
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
  
  public Long getBuffer() {
    return this.buffer;
  }
  
  public String getDevice() {
    return this.device;
  }
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getIpAddress() {
    return this.ipAddress;
  }
  
  public Long getLimit() {
    return this.limit;
  }
  
  public Long getMinburst() {
    return this.minburst;
  }
  
  public Long getPeakrate() {
    return this.peakrate;
  }
  
  public String getRate() {
    return this.rate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBuffer() {
    return this.buffer != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasIpAddress() {
    return this.ipAddress != null;
  }
  
  public boolean hasLimit() {
    return this.limit != null;
  }
  
  public boolean hasMinburst() {
    return this.minburst != null;
  }
  
  public boolean hasPeakrate() {
    return this.peakrate != null;
  }
  
  public boolean hasRate() {
    return this.rate != null;
  }
  
  public int hashCode() {
    return Objects.hash(buffer, device, hostname, ipAddress, limit, minburst, peakrate, rate, additionalProperties);
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
    if (!(buffer == null)) {
        sb.append("buffer:");
        sb.append(buffer);
        sb.append(",");
    }
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(ipAddress == null)) {
        sb.append("ipAddress:");
        sb.append(ipAddress);
        sb.append(",");
    }
    if (!(limit == null)) {
        sb.append("limit:");
        sb.append(limit);
        sb.append(",");
    }
    if (!(minburst == null)) {
        sb.append("minburst:");
        sb.append(minburst);
        sb.append(",");
    }
    if (!(peakrate == null)) {
        sb.append("peakrate:");
        sb.append(peakrate);
        sb.append(",");
    }
    if (!(rate == null)) {
        sb.append("rate:");
        sb.append(rate);
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
  
  public A withBuffer(Long buffer) {
    this.buffer = buffer;
    return (A) this;
  }
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return (A) this;
  }
  
  public A withLimit(Long limit) {
    this.limit = limit;
    return (A) this;
  }
  
  public A withMinburst(Long minburst) {
    this.minburst = minburst;
    return (A) this;
  }
  
  public A withPeakrate(Long peakrate) {
    this.peakrate = peakrate;
    return (A) this;
  }
  
  public A withRate(String rate) {
    this.rate = rate;
    return (A) this;
  }
  
}