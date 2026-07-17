package io.fabric8.openshift.api.model.config.v1;

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
public class VSpherePlatformVCenterSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.VSpherePlatformVCenterSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> datacenters = new ArrayList<String>();
  private Integer port;
  private String server;

  public VSpherePlatformVCenterSpecFluent() {
  }
  
  public VSpherePlatformVCenterSpecFluent(VSpherePlatformVCenterSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDatacenters(Collection<String> items) {
    if (this.datacenters == null) {
      this.datacenters = new ArrayList();
    }
    for (String item : items) {
      this.datacenters.add(item);
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
  
  public A addToDatacenters(String... items) {
    if (this.datacenters == null) {
      this.datacenters = new ArrayList();
    }
    for (String item : items) {
      this.datacenters.add(item);
    }
    return (A) this;
  }
  
  public A addToDatacenters(int index,String item) {
    if (this.datacenters == null) {
      this.datacenters = new ArrayList();
    }
    this.datacenters.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(VSpherePlatformVCenterSpec instance) {
    instance = instance != null ? instance : new VSpherePlatformVCenterSpec();
    if (instance != null) {
        this.withDatacenters(instance.getDatacenters());
        this.withPort(instance.getPort());
        this.withServer(instance.getServer());
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
    VSpherePlatformVCenterSpecFluent that = (VSpherePlatformVCenterSpecFluent) o;
    if (!(Objects.equals(datacenters, that.datacenters))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
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
  
  public String getDatacenter(int index) {
    return this.datacenters.get(index);
  }
  
  public List<String> getDatacenters() {
    return this.datacenters;
  }
  
  public String getFirstDatacenter() {
    return this.datacenters.get(0);
  }
  
  public String getLastDatacenter() {
    return this.datacenters.get(datacenters.size() - 1);
  }
  
  public String getMatchingDatacenter(Predicate<String> predicate) {
      for (String item : datacenters) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDatacenters() {
    return this.datacenters != null && !(this.datacenters.isEmpty());
  }
  
  public boolean hasMatchingDatacenter(Predicate<String> predicate) {
      for (String item : datacenters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public int hashCode() {
    return Objects.hash(datacenters, port, server, additionalProperties);
  }
  
  public A removeAllFromDatacenters(Collection<String> items) {
    if (this.datacenters == null) {
      return (A) this;
    }
    for (String item : items) {
      this.datacenters.remove(item);
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
  
  public A removeFromDatacenters(String... items) {
    if (this.datacenters == null) {
      return (A) this;
    }
    for (String item : items) {
      this.datacenters.remove(item);
    }
    return (A) this;
  }
  
  public A setToDatacenters(int index,String item) {
    if (this.datacenters == null) {
      this.datacenters = new ArrayList();
    }
    this.datacenters.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(datacenters == null) && !(datacenters.isEmpty())) {
        sb.append("datacenters:");
        sb.append(datacenters);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
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
  
  public A withDatacenters(List<String> datacenters) {
    if (datacenters != null) {
        this.datacenters = new ArrayList();
        for (String item : datacenters) {
          this.addToDatacenters(item);
        }
    } else {
      this.datacenters = null;
    }
    return (A) this;
  }
  
  public A withDatacenters(String... datacenters) {
    if (this.datacenters != null) {
        this.datacenters.clear();
        _visitables.remove("datacenters");
    }
    if (datacenters != null) {
      for (String item : datacenters) {
        this.addToDatacenters(item);
      }
    }
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
}