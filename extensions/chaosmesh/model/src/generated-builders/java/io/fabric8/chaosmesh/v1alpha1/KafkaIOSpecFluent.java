package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class KafkaIOSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.KafkaIOSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String configFile;
  private Boolean nonReadable;
  private Boolean nonWritable;
  private String topic;

  public KafkaIOSpecFluent() {
  }
  
  public KafkaIOSpecFluent(KafkaIOSpec instance) {
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
  
  protected void copyInstance(KafkaIOSpec instance) {
    instance = instance != null ? instance : new KafkaIOSpec();
    if (instance != null) {
        this.withConfigFile(instance.getConfigFile());
        this.withNonReadable(instance.getNonReadable());
        this.withNonWritable(instance.getNonWritable());
        this.withTopic(instance.getTopic());
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
    KafkaIOSpecFluent that = (KafkaIOSpecFluent) o;
    if (!(Objects.equals(configFile, that.configFile))) {
      return false;
    }
    if (!(Objects.equals(nonReadable, that.nonReadable))) {
      return false;
    }
    if (!(Objects.equals(nonWritable, that.nonWritable))) {
      return false;
    }
    if (!(Objects.equals(topic, that.topic))) {
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
  
  public String getConfigFile() {
    return this.configFile;
  }
  
  public Boolean getNonReadable() {
    return this.nonReadable;
  }
  
  public Boolean getNonWritable() {
    return this.nonWritable;
  }
  
  public String getTopic() {
    return this.topic;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigFile() {
    return this.configFile != null;
  }
  
  public boolean hasNonReadable() {
    return this.nonReadable != null;
  }
  
  public boolean hasNonWritable() {
    return this.nonWritable != null;
  }
  
  public boolean hasTopic() {
    return this.topic != null;
  }
  
  public int hashCode() {
    return Objects.hash(configFile, nonReadable, nonWritable, topic, additionalProperties);
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
    if (!(configFile == null)) {
        sb.append("configFile:");
        sb.append(configFile);
        sb.append(",");
    }
    if (!(nonReadable == null)) {
        sb.append("nonReadable:");
        sb.append(nonReadable);
        sb.append(",");
    }
    if (!(nonWritable == null)) {
        sb.append("nonWritable:");
        sb.append(nonWritable);
        sb.append(",");
    }
    if (!(topic == null)) {
        sb.append("topic:");
        sb.append(topic);
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
  
  public A withConfigFile(String configFile) {
    this.configFile = configFile;
    return (A) this;
  }
  
  public A withNonReadable() {
    return withNonReadable(true);
  }
  
  public A withNonReadable(Boolean nonReadable) {
    this.nonReadable = nonReadable;
    return (A) this;
  }
  
  public A withNonWritable() {
    return withNonWritable(true);
  }
  
  public A withNonWritable(Boolean nonWritable) {
    this.nonWritable = nonWritable;
    return (A) this;
  }
  
  public A withTopic(String topic) {
    this.topic = topic;
    return (A) this;
  }
  
}