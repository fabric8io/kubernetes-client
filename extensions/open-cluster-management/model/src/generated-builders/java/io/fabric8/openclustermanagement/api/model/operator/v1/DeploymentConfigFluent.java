package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DeploymentConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.DeploymentConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ContainerConfigBuilder> containers = new ArrayList<ContainerConfigBuilder>();
  private String name;

  public DeploymentConfigFluent() {
  }
  
  public DeploymentConfigFluent(DeploymentConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainers(Collection<ContainerConfig> items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (ContainerConfig item : items) {
        ContainerConfigBuilder builder = new ContainerConfigBuilder(item);
        _visitables.get("containers").add(builder);
        this.containers.add(builder);
    }
    return (A) this;
  }
  
  public ContainersNested<A> addNewContainer() {
    return new ContainersNested(-1, null);
  }
  
  public ContainersNested<A> addNewContainerLike(ContainerConfig item) {
    return new ContainersNested(-1, item);
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
  
  public A addToContainers(ContainerConfig... items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (ContainerConfig item : items) {
        ContainerConfigBuilder builder = new ContainerConfigBuilder(item);
        _visitables.get("containers").add(builder);
        this.containers.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainers(int index,ContainerConfig item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    ContainerConfigBuilder builder = new ContainerConfigBuilder(item);
    if (index < 0 || index >= containers.size()) {
        _visitables.get("containers").add(builder);
        containers.add(builder);
    } else {
        _visitables.get("containers").add(builder);
        containers.add(index, builder);
    }
    return (A) this;
  }
  
  public ContainerConfig buildContainer(int index) {
    return this.containers.get(index).build();
  }
  
  public List<ContainerConfig> buildContainers() {
    return this.containers != null ? build(containers) : null;
  }
  
  public ContainerConfig buildFirstContainer() {
    return this.containers.get(0).build();
  }
  
  public ContainerConfig buildLastContainer() {
    return this.containers.get(containers.size() - 1).build();
  }
  
  public ContainerConfig buildMatchingContainer(Predicate<ContainerConfigBuilder> predicate) {
      for (ContainerConfigBuilder item : containers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DeploymentConfig instance) {
    instance = instance != null ? instance : new DeploymentConfig();
    if (instance != null) {
        this.withContainers(instance.getContainers());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainersNested<A> editContainer(int index) {
    if (containers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ContainersNested<A> editFirstContainer() {
    if (containers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(0, this.buildContainer(0));
  }
  
  public ContainersNested<A> editLastContainer() {
    int index = containers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ContainersNested<A> editMatchingContainer(Predicate<ContainerConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containers.size();i++) {
      if (predicate.test(containers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
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
    DeploymentConfigFluent that = (DeploymentConfigFluent) o;
    if (!(Objects.equals(containers, that.containers))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainers() {
    return this.containers != null && !(this.containers.isEmpty());
  }
  
  public boolean hasMatchingContainer(Predicate<ContainerConfigBuilder> predicate) {
      for (ContainerConfigBuilder item : containers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(containers, name, additionalProperties);
  }
  
  public A removeAllFromContainers(Collection<ContainerConfig> items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (ContainerConfig item : items) {
        ContainerConfigBuilder builder = new ContainerConfigBuilder(item);
        _visitables.get("containers").remove(builder);
        this.containers.remove(builder);
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
  
  public A removeFromContainers(ContainerConfig... items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (ContainerConfig item : items) {
        ContainerConfigBuilder builder = new ContainerConfigBuilder(item);
        _visitables.get("containers").remove(builder);
        this.containers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainers(Predicate<ContainerConfigBuilder> predicate) {
    if (containers == null) {
      return (A) this;
    }
    Iterator<ContainerConfigBuilder> each = containers.iterator();
    List visitables = _visitables.get("containers");
    while (each.hasNext()) {
        ContainerConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainersNested<A> setNewContainerLike(int index,ContainerConfig item) {
    return new ContainersNested(index, item);
  }
  
  public A setToContainers(int index,ContainerConfig item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    ContainerConfigBuilder builder = new ContainerConfigBuilder(item);
    if (index < 0 || index >= containers.size()) {
        _visitables.get("containers").add(builder);
        containers.add(builder);
    } else {
        _visitables.get("containers").add(builder);
        containers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containers == null) && !(containers.isEmpty())) {
        sb.append("containers:");
        sb.append(containers);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withContainers(List<ContainerConfig> containers) {
    if (this.containers != null) {
      this._visitables.get("containers").clear();
    }
    if (containers != null) {
        this.containers = new ArrayList();
        for (ContainerConfig item : containers) {
          this.addToContainers(item);
        }
    } else {
      this.containers = null;
    }
    return (A) this;
  }
  
  public A withContainers(ContainerConfig... containers) {
    if (this.containers != null) {
        this.containers.clear();
        _visitables.remove("containers");
    }
    if (containers != null) {
      for (ContainerConfig item : containers) {
        this.addToContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  public class ContainersNested<N> extends ContainerConfigFluent<ContainersNested<N>> implements Nested<N>{
  
    ContainerConfigBuilder builder;
    int index;
  
    ContainersNested(int index,ContainerConfig item) {
      this.index = index;
      this.builder = new ContainerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DeploymentConfigFluent.this.setToContainers(index, builder.build());
    }
    
    public N endContainer() {
      return and();
    }
    
  }
}