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
public class ConfigOverrideFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ConfigOverrideFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DeploymentConfigBuilder> deployments = new ArrayList<DeploymentConfigBuilder>();

  public ConfigOverrideFluent() {
  }
  
  public ConfigOverrideFluent(ConfigOverride instance) {
    this.copyInstance(instance);
  }

  public A addAllToDeployments(Collection<DeploymentConfig> items) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deployments").add(builder);
        this.deployments.add(builder);
    }
    return (A) this;
  }
  
  public DeploymentsNested<A> addNewDeployment() {
    return new DeploymentsNested(-1, null);
  }
  
  public DeploymentsNested<A> addNewDeploymentLike(DeploymentConfig item) {
    return new DeploymentsNested(-1, item);
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
  
  public A addToDeployments(DeploymentConfig... items) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deployments").add(builder);
        this.deployments.add(builder);
    }
    return (A) this;
  }
  
  public A addToDeployments(int index,DeploymentConfig item) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
    if (index < 0 || index >= deployments.size()) {
        _visitables.get("deployments").add(builder);
        deployments.add(builder);
    } else {
        _visitables.get("deployments").add(builder);
        deployments.add(index, builder);
    }
    return (A) this;
  }
  
  public DeploymentConfig buildDeployment(int index) {
    return this.deployments.get(index).build();
  }
  
  public List<DeploymentConfig> buildDeployments() {
    return this.deployments != null ? build(deployments) : null;
  }
  
  public DeploymentConfig buildFirstDeployment() {
    return this.deployments.get(0).build();
  }
  
  public DeploymentConfig buildLastDeployment() {
    return this.deployments.get(deployments.size() - 1).build();
  }
  
  public DeploymentConfig buildMatchingDeployment(Predicate<DeploymentConfigBuilder> predicate) {
      for (DeploymentConfigBuilder item : deployments) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ConfigOverride instance) {
    instance = instance != null ? instance : new ConfigOverride();
    if (instance != null) {
        this.withDeployments(instance.getDeployments());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeploymentsNested<A> editDeployment(int index) {
    if (deployments.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "deployments"));
    }
    return this.setNewDeploymentLike(index, this.buildDeployment(index));
  }
  
  public DeploymentsNested<A> editFirstDeployment() {
    if (deployments.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "deployments"));
    }
    return this.setNewDeploymentLike(0, this.buildDeployment(0));
  }
  
  public DeploymentsNested<A> editLastDeployment() {
    int index = deployments.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "deployments"));
    }
    return this.setNewDeploymentLike(index, this.buildDeployment(index));
  }
  
  public DeploymentsNested<A> editMatchingDeployment(Predicate<DeploymentConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < deployments.size();i++) {
      if (predicate.test(deployments.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "deployments"));
    }
    return this.setNewDeploymentLike(index, this.buildDeployment(index));
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
    ConfigOverrideFluent that = (ConfigOverrideFluent) o;
    if (!(Objects.equals(deployments, that.deployments))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeployments() {
    return this.deployments != null && !(this.deployments.isEmpty());
  }
  
  public boolean hasMatchingDeployment(Predicate<DeploymentConfigBuilder> predicate) {
      for (DeploymentConfigBuilder item : deployments) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(deployments, additionalProperties);
  }
  
  public A removeAllFromDeployments(Collection<DeploymentConfig> items) {
    if (this.deployments == null) {
      return (A) this;
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deployments").remove(builder);
        this.deployments.remove(builder);
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
  
  public A removeFromDeployments(DeploymentConfig... items) {
    if (this.deployments == null) {
      return (A) this;
    }
    for (DeploymentConfig item : items) {
        DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
        _visitables.get("deployments").remove(builder);
        this.deployments.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDeployments(Predicate<DeploymentConfigBuilder> predicate) {
    if (deployments == null) {
      return (A) this;
    }
    Iterator<DeploymentConfigBuilder> each = deployments.iterator();
    List visitables = _visitables.get("deployments");
    while (each.hasNext()) {
        DeploymentConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DeploymentsNested<A> setNewDeploymentLike(int index,DeploymentConfig item) {
    return new DeploymentsNested(index, item);
  }
  
  public A setToDeployments(int index,DeploymentConfig item) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    DeploymentConfigBuilder builder = new DeploymentConfigBuilder(item);
    if (index < 0 || index >= deployments.size()) {
        _visitables.get("deployments").add(builder);
        deployments.add(builder);
    } else {
        _visitables.get("deployments").add(builder);
        deployments.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(deployments == null) && !(deployments.isEmpty())) {
        sb.append("deployments:");
        sb.append(deployments);
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
  
  public A withDeployments(List<DeploymentConfig> deployments) {
    if (this.deployments != null) {
      this._visitables.get("deployments").clear();
    }
    if (deployments != null) {
        this.deployments = new ArrayList();
        for (DeploymentConfig item : deployments) {
          this.addToDeployments(item);
        }
    } else {
      this.deployments = null;
    }
    return (A) this;
  }
  
  public A withDeployments(DeploymentConfig... deployments) {
    if (this.deployments != null) {
        this.deployments.clear();
        _visitables.remove("deployments");
    }
    if (deployments != null) {
      for (DeploymentConfig item : deployments) {
        this.addToDeployments(item);
      }
    }
    return (A) this;
  }
  public class DeploymentsNested<N> extends DeploymentConfigFluent<DeploymentsNested<N>> implements Nested<N>{
  
    DeploymentConfigBuilder builder;
    int index;
  
    DeploymentsNested(int index,DeploymentConfig item) {
      this.index = index;
      this.builder = new DeploymentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigOverrideFluent.this.setToDeployments(index, builder.build());
    }
    
    public N endDeployment() {
      return and();
    }
    
  }
}