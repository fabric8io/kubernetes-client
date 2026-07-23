package io.fabric8.openshift.api.model.operator.v1alpha1;

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
public class NodeStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.NodeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer currentDeploymentGeneration;
  private List<String> lastFailedDeploymentErrors = new ArrayList<String>();
  private Integer lastFailedDeploymentGeneration;
  private String nodeName;
  private Integer targetDeploymentGeneration;

  public NodeStatusFluent() {
  }
  
  public NodeStatusFluent(NodeStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToLastFailedDeploymentErrors(Collection<String> items) {
    if (this.lastFailedDeploymentErrors == null) {
      this.lastFailedDeploymentErrors = new ArrayList();
    }
    for (String item : items) {
      this.lastFailedDeploymentErrors.add(item);
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
  
  public A addToLastFailedDeploymentErrors(String... items) {
    if (this.lastFailedDeploymentErrors == null) {
      this.lastFailedDeploymentErrors = new ArrayList();
    }
    for (String item : items) {
      this.lastFailedDeploymentErrors.add(item);
    }
    return (A) this;
  }
  
  public A addToLastFailedDeploymentErrors(int index,String item) {
    if (this.lastFailedDeploymentErrors == null) {
      this.lastFailedDeploymentErrors = new ArrayList();
    }
    this.lastFailedDeploymentErrors.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NodeStatus instance) {
    instance = instance != null ? instance : new NodeStatus();
    if (instance != null) {
        this.withCurrentDeploymentGeneration(instance.getCurrentDeploymentGeneration());
        this.withLastFailedDeploymentErrors(instance.getLastFailedDeploymentErrors());
        this.withLastFailedDeploymentGeneration(instance.getLastFailedDeploymentGeneration());
        this.withNodeName(instance.getNodeName());
        this.withTargetDeploymentGeneration(instance.getTargetDeploymentGeneration());
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
    NodeStatusFluent that = (NodeStatusFluent) o;
    if (!(Objects.equals(currentDeploymentGeneration, that.currentDeploymentGeneration))) {
      return false;
    }
    if (!(Objects.equals(lastFailedDeploymentErrors, that.lastFailedDeploymentErrors))) {
      return false;
    }
    if (!(Objects.equals(lastFailedDeploymentGeneration, that.lastFailedDeploymentGeneration))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(targetDeploymentGeneration, that.targetDeploymentGeneration))) {
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
  
  public Integer getCurrentDeploymentGeneration() {
    return this.currentDeploymentGeneration;
  }
  
  public String getFirstLastFailedDeploymentError() {
    return this.lastFailedDeploymentErrors.get(0);
  }
  
  public String getLastFailedDeploymentError(int index) {
    return this.lastFailedDeploymentErrors.get(index);
  }
  
  public List<String> getLastFailedDeploymentErrors() {
    return this.lastFailedDeploymentErrors;
  }
  
  public Integer getLastFailedDeploymentGeneration() {
    return this.lastFailedDeploymentGeneration;
  }
  
  public String getLastLastFailedDeploymentError() {
    return this.lastFailedDeploymentErrors.get(lastFailedDeploymentErrors.size() - 1);
  }
  
  public String getMatchingLastFailedDeploymentError(Predicate<String> predicate) {
      for (String item : lastFailedDeploymentErrors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Integer getTargetDeploymentGeneration() {
    return this.targetDeploymentGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentDeploymentGeneration() {
    return this.currentDeploymentGeneration != null;
  }
  
  public boolean hasLastFailedDeploymentErrors() {
    return this.lastFailedDeploymentErrors != null && !(this.lastFailedDeploymentErrors.isEmpty());
  }
  
  public boolean hasLastFailedDeploymentGeneration() {
    return this.lastFailedDeploymentGeneration != null;
  }
  
  public boolean hasMatchingLastFailedDeploymentError(Predicate<String> predicate) {
      for (String item : lastFailedDeploymentErrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasTargetDeploymentGeneration() {
    return this.targetDeploymentGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentDeploymentGeneration, lastFailedDeploymentErrors, lastFailedDeploymentGeneration, nodeName, targetDeploymentGeneration, additionalProperties);
  }
  
  public A removeAllFromLastFailedDeploymentErrors(Collection<String> items) {
    if (this.lastFailedDeploymentErrors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.lastFailedDeploymentErrors.remove(item);
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
  
  public A removeFromLastFailedDeploymentErrors(String... items) {
    if (this.lastFailedDeploymentErrors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.lastFailedDeploymentErrors.remove(item);
    }
    return (A) this;
  }
  
  public A setToLastFailedDeploymentErrors(int index,String item) {
    if (this.lastFailedDeploymentErrors == null) {
      this.lastFailedDeploymentErrors = new ArrayList();
    }
    this.lastFailedDeploymentErrors.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(currentDeploymentGeneration == null)) {
        sb.append("currentDeploymentGeneration:");
        sb.append(currentDeploymentGeneration);
        sb.append(",");
    }
    if (!(lastFailedDeploymentErrors == null) && !(lastFailedDeploymentErrors.isEmpty())) {
        sb.append("lastFailedDeploymentErrors:");
        sb.append(lastFailedDeploymentErrors);
        sb.append(",");
    }
    if (!(lastFailedDeploymentGeneration == null)) {
        sb.append("lastFailedDeploymentGeneration:");
        sb.append(lastFailedDeploymentGeneration);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(targetDeploymentGeneration == null)) {
        sb.append("targetDeploymentGeneration:");
        sb.append(targetDeploymentGeneration);
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
  
  public A withCurrentDeploymentGeneration(Integer currentDeploymentGeneration) {
    this.currentDeploymentGeneration = currentDeploymentGeneration;
    return (A) this;
  }
  
  public A withLastFailedDeploymentErrors(List<String> lastFailedDeploymentErrors) {
    if (lastFailedDeploymentErrors != null) {
        this.lastFailedDeploymentErrors = new ArrayList();
        for (String item : lastFailedDeploymentErrors) {
          this.addToLastFailedDeploymentErrors(item);
        }
    } else {
      this.lastFailedDeploymentErrors = null;
    }
    return (A) this;
  }
  
  public A withLastFailedDeploymentErrors(String... lastFailedDeploymentErrors) {
    if (this.lastFailedDeploymentErrors != null) {
        this.lastFailedDeploymentErrors.clear();
        _visitables.remove("lastFailedDeploymentErrors");
    }
    if (lastFailedDeploymentErrors != null) {
      for (String item : lastFailedDeploymentErrors) {
        this.addToLastFailedDeploymentErrors(item);
      }
    }
    return (A) this;
  }
  
  public A withLastFailedDeploymentGeneration(Integer lastFailedDeploymentGeneration) {
    this.lastFailedDeploymentGeneration = lastFailedDeploymentGeneration;
    return (A) this;
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withTargetDeploymentGeneration(Integer targetDeploymentGeneration) {
    this.targetDeploymentGeneration = targetDeploymentGeneration;
    return (A) this;
  }
  
}