package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPDelaySpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.HTTPDelaySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String code;
  private String delay;
  private String method;
  private String path;
  private Integer port;
  private List<Integer> proxyPorts = new ArrayList<Integer>();
  private String target;

  public HTTPDelaySpecFluent() {
  }
  
  public HTTPDelaySpecFluent(HTTPDelaySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToProxyPorts(Collection<Integer> items) {
    if (this.proxyPorts == null) {
      this.proxyPorts = new ArrayList();
    }
    for (Integer item : items) {
      this.proxyPorts.add(item);
    }
    return (A) this;
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
  
  public A addToProxyPorts(Integer... items) {
    if (this.proxyPorts == null) {
      this.proxyPorts = new ArrayList();
    }
    for (Integer item : items) {
      this.proxyPorts.add(item);
    }
    return (A) this;
  }
  
  public A addToProxyPorts(int index,Integer item) {
    if (this.proxyPorts == null) {
      this.proxyPorts = new ArrayList();
    }
    this.proxyPorts.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(HTTPDelaySpec instance) {
    instance = instance != null ? instance : new HTTPDelaySpec();
    if (instance != null) {
        this.withCode(instance.getCode());
        this.withDelay(instance.getDelay());
        this.withMethod(instance.getMethod());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withProxyPorts(instance.getProxyPorts());
        this.withTarget(instance.getTarget());
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
    HTTPDelaySpecFluent that = (HTTPDelaySpecFluent) o;
    if (!(Objects.equals(code, that.code))) {
      return false;
    }
    if (!(Objects.equals(delay, that.delay))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(proxyPorts, that.proxyPorts))) {
      return false;
    }
    if (!(Objects.equals(target, that.target))) {
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
  
  public String getCode() {
    return this.code;
  }
  
  public String getDelay() {
    return this.delay;
  }
  
  public Integer getFirstProxyPort() {
    return this.proxyPorts.get(0);
  }
  
  public Integer getLastProxyPort() {
    return this.proxyPorts.get(proxyPorts.size() - 1);
  }
  
  public Integer getMatchingProxyPort(Predicate<Integer> predicate) {
      for (Integer item : proxyPorts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public Integer getProxyPort(int index) {
    return this.proxyPorts.get(index);
  }
  
  public List<Integer> getProxyPorts() {
    return this.proxyPorts;
  }
  
  public String getTarget() {
    return this.target;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCode() {
    return this.code != null;
  }
  
  public boolean hasDelay() {
    return this.delay != null;
  }
  
  public boolean hasMatchingProxyPort(Predicate<Integer> predicate) {
      for (Integer item : proxyPorts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProxyPorts() {
    return this.proxyPorts != null && !(this.proxyPorts.isEmpty());
  }
  
  public boolean hasTarget() {
    return this.target != null;
  }
  
  public int hashCode() {
    return Objects.hash(code, delay, method, path, port, proxyPorts, target, additionalProperties);
  }
  
  public A removeAllFromProxyPorts(Collection<Integer> items) {
    if (this.proxyPorts == null) {
      return (A) this;
    }
    for (Integer item : items) {
      this.proxyPorts.remove(item);
    }
    return (A) this;
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
  
  public A removeFromProxyPorts(Integer... items) {
    if (this.proxyPorts == null) {
      return (A) this;
    }
    for (Integer item : items) {
      this.proxyPorts.remove(item);
    }
    return (A) this;
  }
  
  public A setToProxyPorts(int index,Integer item) {
    if (this.proxyPorts == null) {
      this.proxyPorts = new ArrayList();
    }
    this.proxyPorts.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(code == null)) {
        sb.append("code:");
        sb.append(code);
        sb.append(",");
    }
    if (!(delay == null)) {
        sb.append("delay:");
        sb.append(delay);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
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
    if (!(proxyPorts == null) && !(proxyPorts.isEmpty())) {
        sb.append("proxyPorts:");
        sb.append(proxyPorts);
        sb.append(",");
    }
    if (!(target == null)) {
        sb.append("target:");
        sb.append(target);
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
  
  public A withCode(String code) {
    this.code = code;
    return (A) this;
  }
  
  public A withDelay(String delay) {
    this.delay = delay;
    return (A) this;
  }
  
  public A withMethod(String method) {
    this.method = method;
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withProxyPorts(List<Integer> proxyPorts) {
    if (proxyPorts != null) {
        this.proxyPorts = new ArrayList();
        for (Integer item : proxyPorts) {
          this.addToProxyPorts(item);
        }
    } else {
      this.proxyPorts = null;
    }
    return (A) this;
  }
  
  public A withProxyPorts(Integer... proxyPorts) {
    if (this.proxyPorts != null) {
        this.proxyPorts.clear();
        _visitables.remove("proxyPorts");
    }
    if (proxyPorts != null) {
      for (Integer item : proxyPorts) {
        this.addToProxyPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withTarget(String target) {
    this.target = target;
    return (A) this;
  }
  
}