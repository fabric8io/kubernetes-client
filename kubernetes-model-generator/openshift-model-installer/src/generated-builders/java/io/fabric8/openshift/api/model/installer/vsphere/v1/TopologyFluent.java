package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class TopologyFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.TopologyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String computeCluster;
  private String datacenter;
  private String datastore;
  private String folder;
  private String hostGroup;
  private List<String> networks = new ArrayList<String>();
  private String resourcePool;
  private List<String> tagIDs = new ArrayList<String>();
  private String template;

  public TopologyFluent() {
  }
  
  public TopologyFluent(Topology instance) {
    this.copyInstance(instance);
  }

  public A addAllToNetworks(Collection<String> items) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    for (String item : items) {
      this.networks.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTagIDs(Collection<String> items) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    for (String item : items) {
      this.tagIDs.add(item);
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
  
  public A addToNetworks(String... items) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    for (String item : items) {
      this.networks.add(item);
    }
    return (A) this;
  }
  
  public A addToNetworks(int index,String item) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    this.networks.add(index, item);
    return (A) this;
  }
  
  public A addToTagIDs(String... items) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    for (String item : items) {
      this.tagIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToTagIDs(int index,String item) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    this.tagIDs.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Topology instance) {
    instance = instance != null ? instance : new Topology();
    if (instance != null) {
        this.withComputeCluster(instance.getComputeCluster());
        this.withDatacenter(instance.getDatacenter());
        this.withDatastore(instance.getDatastore());
        this.withFolder(instance.getFolder());
        this.withHostGroup(instance.getHostGroup());
        this.withNetworks(instance.getNetworks());
        this.withResourcePool(instance.getResourcePool());
        this.withTagIDs(instance.getTagIDs());
        this.withTemplate(instance.getTemplate());
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
    TopologyFluent that = (TopologyFluent) o;
    if (!(Objects.equals(computeCluster, that.computeCluster))) {
      return false;
    }
    if (!(Objects.equals(datacenter, that.datacenter))) {
      return false;
    }
    if (!(Objects.equals(datastore, that.datastore))) {
      return false;
    }
    if (!(Objects.equals(folder, that.folder))) {
      return false;
    }
    if (!(Objects.equals(hostGroup, that.hostGroup))) {
      return false;
    }
    if (!(Objects.equals(networks, that.networks))) {
      return false;
    }
    if (!(Objects.equals(resourcePool, that.resourcePool))) {
      return false;
    }
    if (!(Objects.equals(tagIDs, that.tagIDs))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public String getComputeCluster() {
    return this.computeCluster;
  }
  
  public String getDatacenter() {
    return this.datacenter;
  }
  
  public String getDatastore() {
    return this.datastore;
  }
  
  public String getFirstNetwork() {
    return this.networks.get(0);
  }
  
  public String getFirstTagID() {
    return this.tagIDs.get(0);
  }
  
  public String getFolder() {
    return this.folder;
  }
  
  public String getHostGroup() {
    return this.hostGroup;
  }
  
  public String getLastNetwork() {
    return this.networks.get(networks.size() - 1);
  }
  
  public String getLastTagID() {
    return this.tagIDs.get(tagIDs.size() - 1);
  }
  
  public String getMatchingNetwork(Predicate<String> predicate) {
      for (String item : networks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTagID(Predicate<String> predicate) {
      for (String item : tagIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetwork(int index) {
    return this.networks.get(index);
  }
  
  public List<String> getNetworks() {
    return this.networks;
  }
  
  public String getResourcePool() {
    return this.resourcePool;
  }
  
  public String getTagID(int index) {
    return this.tagIDs.get(index);
  }
  
  public List<String> getTagIDs() {
    return this.tagIDs;
  }
  
  public String getTemplate() {
    return this.template;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComputeCluster() {
    return this.computeCluster != null;
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
  
  public boolean hasHostGroup() {
    return this.hostGroup != null;
  }
  
  public boolean hasMatchingNetwork(Predicate<String> predicate) {
      for (String item : networks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTagID(Predicate<String> predicate) {
      for (String item : tagIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworks() {
    return this.networks != null && !(this.networks.isEmpty());
  }
  
  public boolean hasResourcePool() {
    return this.resourcePool != null;
  }
  
  public boolean hasTagIDs() {
    return this.tagIDs != null && !(this.tagIDs.isEmpty());
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(computeCluster, datacenter, datastore, folder, hostGroup, networks, resourcePool, tagIDs, template, additionalProperties);
  }
  
  public A removeAllFromNetworks(Collection<String> items) {
    if (this.networks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.networks.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTagIDs(Collection<String> items) {
    if (this.tagIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagIDs.remove(item);
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
  
  public A removeFromNetworks(String... items) {
    if (this.networks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.networks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTagIDs(String... items) {
    if (this.tagIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagIDs.remove(item);
    }
    return (A) this;
  }
  
  public A setToNetworks(int index,String item) {
    if (this.networks == null) {
      this.networks = new ArrayList();
    }
    this.networks.set(index, item);
    return (A) this;
  }
  
  public A setToTagIDs(int index,String item) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    this.tagIDs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(computeCluster == null)) {
        sb.append("computeCluster:");
        sb.append(computeCluster);
        sb.append(",");
    }
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
    if (!(hostGroup == null)) {
        sb.append("hostGroup:");
        sb.append(hostGroup);
        sb.append(",");
    }
    if (!(networks == null) && !(networks.isEmpty())) {
        sb.append("networks:");
        sb.append(networks);
        sb.append(",");
    }
    if (!(resourcePool == null)) {
        sb.append("resourcePool:");
        sb.append(resourcePool);
        sb.append(",");
    }
    if (!(tagIDs == null) && !(tagIDs.isEmpty())) {
        sb.append("tagIDs:");
        sb.append(tagIDs);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public A withComputeCluster(String computeCluster) {
    this.computeCluster = computeCluster;
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
  
  public A withHostGroup(String hostGroup) {
    this.hostGroup = hostGroup;
    return (A) this;
  }
  
  public A withNetworks(List<String> networks) {
    if (networks != null) {
        this.networks = new ArrayList();
        for (String item : networks) {
          this.addToNetworks(item);
        }
    } else {
      this.networks = null;
    }
    return (A) this;
  }
  
  public A withNetworks(String... networks) {
    if (this.networks != null) {
        this.networks.clear();
        _visitables.remove("networks");
    }
    if (networks != null) {
      for (String item : networks) {
        this.addToNetworks(item);
      }
    }
    return (A) this;
  }
  
  public A withResourcePool(String resourcePool) {
    this.resourcePool = resourcePool;
    return (A) this;
  }
  
  public A withTagIDs(List<String> tagIDs) {
    if (tagIDs != null) {
        this.tagIDs = new ArrayList();
        for (String item : tagIDs) {
          this.addToTagIDs(item);
        }
    } else {
      this.tagIDs = null;
    }
    return (A) this;
  }
  
  public A withTagIDs(String... tagIDs) {
    if (this.tagIDs != null) {
        this.tagIDs.clear();
        _visitables.remove("tagIDs");
    }
    if (tagIDs != null) {
      for (String item : tagIDs) {
        this.addToTagIDs(item);
      }
    }
    return (A) this;
  }
  
  public A withTemplate(String template) {
    this.template = template;
    return (A) this;
  }
  
}