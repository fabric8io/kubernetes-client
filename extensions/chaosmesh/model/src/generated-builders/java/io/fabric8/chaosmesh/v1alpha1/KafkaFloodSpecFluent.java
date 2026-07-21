package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class KafkaFloodSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.KafkaFloodSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String host;
  private Integer messageSize;
  private String password;
  private Integer port;
  private Integer threads;
  private String topic;
  private String username;

  public KafkaFloodSpecFluent() {
  }
  
  public KafkaFloodSpecFluent(KafkaFloodSpec instance) {
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
  
  protected void copyInstance(KafkaFloodSpec instance) {
    instance = instance != null ? instance : new KafkaFloodSpec();
    if (instance != null) {
        this.withHost(instance.getHost());
        this.withMessageSize(instance.getMessageSize());
        this.withPassword(instance.getPassword());
        this.withPort(instance.getPort());
        this.withThreads(instance.getThreads());
        this.withTopic(instance.getTopic());
        this.withUsername(instance.getUsername());
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
    KafkaFloodSpecFluent that = (KafkaFloodSpecFluent) o;
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(messageSize, that.messageSize))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(threads, that.threads))) {
      return false;
    }
    if (!(Objects.equals(topic, that.topic))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public String getHost() {
    return this.host;
  }
  
  public Integer getMessageSize() {
    return this.messageSize;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public Integer getThreads() {
    return this.threads;
  }
  
  public String getTopic() {
    return this.topic;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasMessageSize() {
    return this.messageSize != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasThreads() {
    return this.threads != null;
  }
  
  public boolean hasTopic() {
    return this.topic != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(host, messageSize, password, port, threads, topic, username, additionalProperties);
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
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(messageSize == null)) {
        sb.append("messageSize:");
        sb.append(messageSize);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(threads == null)) {
        sb.append("threads:");
        sb.append(threads);
        sb.append(",");
    }
    if (!(topic == null)) {
        sb.append("topic:");
        sb.append(topic);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public A withMessageSize(Integer messageSize) {
    this.messageSize = messageSize;
    return (A) this;
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withThreads(Integer threads) {
    this.threads = threads;
    return (A) this;
  }
  
  public A withTopic(String topic) {
    this.topic = topic;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  
}