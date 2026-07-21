package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class NetworkDelaySpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.NetworkDelaySpecFluent<A>> extends BaseFluent<A>{

  private String acceptTcpFlags;
  private Map<String,Object> additionalProperties;
  private String correlation;
  private String device;
  private String egressPort;
  private String hostname;
  private String ipAddress;
  private String ipProtocol;
  private String jitter;
  private String latency;
  private String sourcePort;

  public NetworkDelaySpecFluent() {
  }
  
  public NetworkDelaySpecFluent(NetworkDelaySpec instance) {
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
  
  protected void copyInstance(NetworkDelaySpec instance) {
    instance = instance != null ? instance : new NetworkDelaySpec();
    if (instance != null) {
        this.withAcceptTcpFlags(instance.getAcceptTcpFlags());
        this.withCorrelation(instance.getCorrelation());
        this.withDevice(instance.getDevice());
        this.withEgressPort(instance.getEgressPort());
        this.withHostname(instance.getHostname());
        this.withIpAddress(instance.getIpAddress());
        this.withIpProtocol(instance.getIpProtocol());
        this.withJitter(instance.getJitter());
        this.withLatency(instance.getLatency());
        this.withSourcePort(instance.getSourcePort());
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
    NetworkDelaySpecFluent that = (NetworkDelaySpecFluent) o;
    if (!(Objects.equals(acceptTcpFlags, that.acceptTcpFlags))) {
      return false;
    }
    if (!(Objects.equals(correlation, that.correlation))) {
      return false;
    }
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(egressPort, that.egressPort))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(ipAddress, that.ipAddress))) {
      return false;
    }
    if (!(Objects.equals(ipProtocol, that.ipProtocol))) {
      return false;
    }
    if (!(Objects.equals(jitter, that.jitter))) {
      return false;
    }
    if (!(Objects.equals(latency, that.latency))) {
      return false;
    }
    if (!(Objects.equals(sourcePort, that.sourcePort))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAcceptTcpFlags() {
    return this.acceptTcpFlags;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getCorrelation() {
    return this.correlation;
  }
  
  public String getDevice() {
    return this.device;
  }
  
  public String getEgressPort() {
    return this.egressPort;
  }
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getIpAddress() {
    return this.ipAddress;
  }
  
  public String getIpProtocol() {
    return this.ipProtocol;
  }
  
  public String getJitter() {
    return this.jitter;
  }
  
  public String getLatency() {
    return this.latency;
  }
  
  public String getSourcePort() {
    return this.sourcePort;
  }
  
  public boolean hasAcceptTcpFlags() {
    return this.acceptTcpFlags != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCorrelation() {
    return this.correlation != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasEgressPort() {
    return this.egressPort != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasIpAddress() {
    return this.ipAddress != null;
  }
  
  public boolean hasIpProtocol() {
    return this.ipProtocol != null;
  }
  
  public boolean hasJitter() {
    return this.jitter != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public boolean hasSourcePort() {
    return this.sourcePort != null;
  }
  
  public int hashCode() {
    return Objects.hash(acceptTcpFlags, correlation, device, egressPort, hostname, ipAddress, ipProtocol, jitter, latency, sourcePort, additionalProperties);
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
    if (!(acceptTcpFlags == null)) {
        sb.append("acceptTcpFlags:");
        sb.append(acceptTcpFlags);
        sb.append(",");
    }
    if (!(correlation == null)) {
        sb.append("correlation:");
        sb.append(correlation);
        sb.append(",");
    }
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(egressPort == null)) {
        sb.append("egressPort:");
        sb.append(egressPort);
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
    if (!(ipProtocol == null)) {
        sb.append("ipProtocol:");
        sb.append(ipProtocol);
        sb.append(",");
    }
    if (!(jitter == null)) {
        sb.append("jitter:");
        sb.append(jitter);
        sb.append(",");
    }
    if (!(latency == null)) {
        sb.append("latency:");
        sb.append(latency);
        sb.append(",");
    }
    if (!(sourcePort == null)) {
        sb.append("sourcePort:");
        sb.append(sourcePort);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcceptTcpFlags(String acceptTcpFlags) {
    this.acceptTcpFlags = acceptTcpFlags;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCorrelation(String correlation) {
    this.correlation = correlation;
    return (A) this;
  }
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withEgressPort(String egressPort) {
    this.egressPort = egressPort;
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
  
  public A withIpProtocol(String ipProtocol) {
    this.ipProtocol = ipProtocol;
    return (A) this;
  }
  
  public A withJitter(String jitter) {
    this.jitter = jitter;
    return (A) this;
  }
  
  public A withLatency(String latency) {
    this.latency = latency;
    return (A) this;
  }
  
  public A withSourcePort(String sourcePort) {
    this.sourcePort = sourcePort;
    return (A) this;
  }
  
}