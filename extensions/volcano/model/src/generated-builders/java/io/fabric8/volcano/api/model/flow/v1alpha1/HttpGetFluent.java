package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.HTTPHeader;
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
public class HttpGetFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.HttpGetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPHeader httpHeader;
  private String path;
  private Integer port;
  private String taskName;

  public HttpGetFluent() {
  }
  
  public HttpGetFluent(HttpGet instance) {
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
  
  protected void copyInstance(HttpGet instance) {
    instance = instance != null ? instance : new HttpGet();
    if (instance != null) {
        this.withHttpHeader(instance.getHttpHeader());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withTaskName(instance.getTaskName());
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
    HttpGetFluent that = (HttpGetFluent) o;
    if (!(Objects.equals(httpHeader, that.httpHeader))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(taskName, that.taskName))) {
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
  
  public HTTPHeader getHttpHeader() {
    return this.httpHeader;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getTaskName() {
    return this.taskName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpHeader() {
    return this.httpHeader != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasTaskName() {
    return this.taskName != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpHeader, path, port, taskName, additionalProperties);
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
    if (!(httpHeader == null)) {
        sb.append("httpHeader:");
        sb.append(httpHeader);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(taskName == null)) {
        sb.append("taskName:");
        sb.append(taskName);
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
  
  public A withHttpHeader(HTTPHeader httpHeader) {
    this.httpHeader = httpHeader;
    return (A) this;
  }
  
  public A withNewHttpHeader(String name,String value) {
    return (A) this.withHttpHeader(new HTTPHeader(name, value));
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withTaskName(String taskName) {
    this.taskName = taskName;
    return (A) this;
  }
  
}