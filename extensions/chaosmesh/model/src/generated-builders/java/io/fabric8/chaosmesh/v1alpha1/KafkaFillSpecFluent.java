package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class KafkaFillSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.KafkaFillSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String host;
  private Long maxBytes;
  private Integer messageSize;
  private String password;
  private Integer port;
  private String reloadCommand;
  private String topic;
  private String username;

  public KafkaFillSpecFluent() {
  }
  
  public KafkaFillSpecFluent(KafkaFillSpec instance) {
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
  
  protected void copyInstance(KafkaFillSpec instance) {
    instance = instance != null ? instance : new KafkaFillSpec();
    if (instance != null) {
        this.withHost(instance.getHost());
        this.withMaxBytes(instance.getMaxBytes());
        this.withMessageSize(instance.getMessageSize());
        this.withPassword(instance.getPassword());
        this.withPort(instance.getPort());
        this.withReloadCommand(instance.getReloadCommand());
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
    KafkaFillSpecFluent that = (KafkaFillSpecFluent) o;
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(maxBytes, that.maxBytes))) {
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
    if (!(Objects.equals(reloadCommand, that.reloadCommand))) {
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
  
  public Long getMaxBytes() {
    return this.maxBytes;
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
  
  public String getReloadCommand() {
    return this.reloadCommand;
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
  
  public boolean hasMaxBytes() {
    return this.maxBytes != null;
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
  
  public boolean hasReloadCommand() {
    return this.reloadCommand != null;
  }
  
  public boolean hasTopic() {
    return this.topic != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(host, maxBytes, messageSize, password, port, reloadCommand, topic, username, additionalProperties);
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
    if (!(maxBytes == null)) {
        sb.append("maxBytes:");
        sb.append(maxBytes);
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
    if (!(reloadCommand == null)) {
        sb.append("reloadCommand:");
        sb.append(reloadCommand);
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
  
  public A withMaxBytes(Long maxBytes) {
    this.maxBytes = maxBytes;
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
  
  public A withReloadCommand(String reloadCommand) {
    this.reloadCommand = reloadCommand;
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