package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class WorkspaceFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.WorkspaceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String datacenter;
  private String datastore;
  private String folder;
  private String resourcePool;
  private String server;
  private String vmGroup;

  public WorkspaceFluent() {
  }
  
  public WorkspaceFluent(Workspace instance) {
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
  
  protected void copyInstance(Workspace instance) {
    instance = instance != null ? instance : new Workspace();
    if (instance != null) {
        this.withDatacenter(instance.getDatacenter());
        this.withDatastore(instance.getDatastore());
        this.withFolder(instance.getFolder());
        this.withResourcePool(instance.getResourcePool());
        this.withServer(instance.getServer());
        this.withVmGroup(instance.getVmGroup());
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
    WorkspaceFluent that = (WorkspaceFluent) o;
    if (!(Objects.equals(datacenter, that.datacenter))) {
      return false;
    }
    if (!(Objects.equals(datastore, that.datastore))) {
      return false;
    }
    if (!(Objects.equals(folder, that.folder))) {
      return false;
    }
    if (!(Objects.equals(resourcePool, that.resourcePool))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
      return false;
    }
    if (!(Objects.equals(vmGroup, that.vmGroup))) {
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
  
  public String getDatacenter() {
    return this.datacenter;
  }
  
  public String getDatastore() {
    return this.datastore;
  }
  
  public String getFolder() {
    return this.folder;
  }
  
  public String getResourcePool() {
    return this.resourcePool;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public String getVmGroup() {
    return this.vmGroup;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDatacenter() {
    return this.datacenter != null;
  }
  
  public boolean hasDatastore() {
    return this.datastore != null;
  }
  
  public boolean hasFolder() {
    return this.folder != null;
  }
  
  public boolean hasResourcePool() {
    return this.resourcePool != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public boolean hasVmGroup() {
    return this.vmGroup != null;
  }
  
  public int hashCode() {
    return Objects.hash(datacenter, datastore, folder, resourcePool, server, vmGroup, additionalProperties);
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
    if (!(datacenter == null)) {
        sb.append("datacenter:");
        sb.append(datacenter);
        sb.append(",");
    }
    if (!(datastore == null)) {
        sb.append("datastore:");
        sb.append(datastore);
        sb.append(",");
    }
    if (!(folder == null)) {
        sb.append("folder:");
        sb.append(folder);
        sb.append(",");
    }
    if (!(resourcePool == null)) {
        sb.append("resourcePool:");
        sb.append(resourcePool);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
        sb.append(",");
    }
    if (!(vmGroup == null)) {
        sb.append("vmGroup:");
        sb.append(vmGroup);
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
  
  public A withDatacenter(String datacenter) {
    this.datacenter = datacenter;
    return (A) this;
  }
  
  public A withDatastore(String datastore) {
    this.datastore = datastore;
    return (A) this;
  }
  
  public A withFolder(String folder) {
    this.folder = folder;
    return (A) this;
  }
  
  public A withResourcePool(String resourcePool) {
    this.resourcePool = resourcePool;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withVmGroup(String vmGroup) {
    this.vmGroup = vmGroup;
    return (A) this;
  }
  
}