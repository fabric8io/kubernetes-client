package io.fabric8.openshift.api.model.operator.v1;

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
public class NodeStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.NodeStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer currentRevision;
  private Integer lastFailedCount;
  private String lastFailedReason;
  private Integer lastFailedRevision;
  private List<String> lastFailedRevisionErrors = new ArrayList<String>();
  private String lastFailedTime;
  private Integer lastFallbackCount;
  private String nodeName;
  private Integer targetRevision;

  public NodeStatusFluent() {
  }
  
  public NodeStatusFluent(NodeStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToLastFailedRevisionErrors(Collection<String> items) {
    if (this.lastFailedRevisionErrors == null) {
      this.lastFailedRevisionErrors = new ArrayList();
    }
    for (String item : items) {
      this.lastFailedRevisionErrors.add(item);
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
  
  public A addToLastFailedRevisionErrors(String... items) {
    if (this.lastFailedRevisionErrors == null) {
      this.lastFailedRevisionErrors = new ArrayList();
    }
    for (String item : items) {
      this.lastFailedRevisionErrors.add(item);
    }
    return (A) this;
  }
  
  public A addToLastFailedRevisionErrors(int index,String item) {
    if (this.lastFailedRevisionErrors == null) {
      this.lastFailedRevisionErrors = new ArrayList();
    }
    this.lastFailedRevisionErrors.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NodeStatus instance) {
    instance = instance != null ? instance : new NodeStatus();
    if (instance != null) {
        this.withCurrentRevision(instance.getCurrentRevision());
        this.withLastFailedCount(instance.getLastFailedCount());
        this.withLastFailedReason(instance.getLastFailedReason());
        this.withLastFailedRevision(instance.getLastFailedRevision());
        this.withLastFailedRevisionErrors(instance.getLastFailedRevisionErrors());
        this.withLastFailedTime(instance.getLastFailedTime());
        this.withLastFallbackCount(instance.getLastFallbackCount());
        this.withNodeName(instance.getNodeName());
        this.withTargetRevision(instance.getTargetRevision());
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
    if (!(Objects.equals(currentRevision, that.currentRevision))) {
      return false;
    }
    if (!(Objects.equals(lastFailedCount, that.lastFailedCount))) {
      return false;
    }
    if (!(Objects.equals(lastFailedReason, that.lastFailedReason))) {
      return false;
    }
    if (!(Objects.equals(lastFailedRevision, that.lastFailedRevision))) {
      return false;
    }
    if (!(Objects.equals(lastFailedRevisionErrors, that.lastFailedRevisionErrors))) {
      return false;
    }
    if (!(Objects.equals(lastFailedTime, that.lastFailedTime))) {
      return false;
    }
    if (!(Objects.equals(lastFallbackCount, that.lastFallbackCount))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(targetRevision, that.targetRevision))) {
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
  
  public Integer getCurrentRevision() {
    return this.currentRevision;
  }
  
  public String getFirstLastFailedRevisionError() {
    return this.lastFailedRevisionErrors.get(0);
  }
  
  public Integer getLastFailedCount() {
    return this.lastFailedCount;
  }
  
  public String getLastFailedReason() {
    return this.lastFailedReason;
  }
  
  public Integer getLastFailedRevision() {
    return this.lastFailedRevision;
  }
  
  public String getLastFailedRevisionError(int index) {
    return this.lastFailedRevisionErrors.get(index);
  }
  
  public List<String> getLastFailedRevisionErrors() {
    return this.lastFailedRevisionErrors;
  }
  
  public String getLastFailedTime() {
    return this.lastFailedTime;
  }
  
  public Integer getLastFallbackCount() {
    return this.lastFallbackCount;
  }
  
  public String getLastLastFailedRevisionError() {
    return this.lastFailedRevisionErrors.get(lastFailedRevisionErrors.size() - 1);
  }
  
  public String getMatchingLastFailedRevisionError(Predicate<String> predicate) {
      for (String item : lastFailedRevisionErrors) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Integer getTargetRevision() {
    return this.targetRevision;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentRevision() {
    return this.currentRevision != null;
  }
  
  public boolean hasLastFailedCount() {
    return this.lastFailedCount != null;
  }
  
  public boolean hasLastFailedReason() {
    return this.lastFailedReason != null;
  }
  
  public boolean hasLastFailedRevision() {
    return this.lastFailedRevision != null;
  }
  
  public boolean hasLastFailedRevisionErrors() {
    return this.lastFailedRevisionErrors != null && !(this.lastFailedRevisionErrors.isEmpty());
  }
  
  public boolean hasLastFailedTime() {
    return this.lastFailedTime != null;
  }
  
  public boolean hasLastFallbackCount() {
    return this.lastFallbackCount != null;
  }
  
  public boolean hasMatchingLastFailedRevisionError(Predicate<String> predicate) {
      for (String item : lastFailedRevisionErrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasTargetRevision() {
    return this.targetRevision != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentRevision, lastFailedCount, lastFailedReason, lastFailedRevision, lastFailedRevisionErrors, lastFailedTime, lastFallbackCount, nodeName, targetRevision, additionalProperties);
  }
  
  public A removeAllFromLastFailedRevisionErrors(Collection<String> items) {
    if (this.lastFailedRevisionErrors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.lastFailedRevisionErrors.remove(item);
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
  
  public A removeFromLastFailedRevisionErrors(String... items) {
    if (this.lastFailedRevisionErrors == null) {
      return (A) this;
    }
    for (String item : items) {
      this.lastFailedRevisionErrors.remove(item);
    }
    return (A) this;
  }
  
  public A setToLastFailedRevisionErrors(int index,String item) {
    if (this.lastFailedRevisionErrors == null) {
      this.lastFailedRevisionErrors = new ArrayList();
    }
    this.lastFailedRevisionErrors.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(currentRevision == null)) {
        sb.append("currentRevision:");
        sb.append(currentRevision);
        sb.append(",");
    }
    if (!(lastFailedCount == null)) {
        sb.append("lastFailedCount:");
        sb.append(lastFailedCount);
        sb.append(",");
    }
    if (!(lastFailedReason == null)) {
        sb.append("lastFailedReason:");
        sb.append(lastFailedReason);
        sb.append(",");
    }
    if (!(lastFailedRevision == null)) {
        sb.append("lastFailedRevision:");
        sb.append(lastFailedRevision);
        sb.append(",");
    }
    if (!(lastFailedRevisionErrors == null) && !(lastFailedRevisionErrors.isEmpty())) {
        sb.append("lastFailedRevisionErrors:");
        sb.append(lastFailedRevisionErrors);
        sb.append(",");
    }
    if (!(lastFailedTime == null)) {
        sb.append("lastFailedTime:");
        sb.append(lastFailedTime);
        sb.append(",");
    }
    if (!(lastFallbackCount == null)) {
        sb.append("lastFallbackCount:");
        sb.append(lastFallbackCount);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(targetRevision == null)) {
        sb.append("targetRevision:");
        sb.append(targetRevision);
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
  
  public A withCurrentRevision(Integer currentRevision) {
    this.currentRevision = currentRevision;
    return (A) this;
  }
  
  public A withLastFailedCount(Integer lastFailedCount) {
    this.lastFailedCount = lastFailedCount;
    return (A) this;
  }
  
  public A withLastFailedReason(String lastFailedReason) {
    this.lastFailedReason = lastFailedReason;
    return (A) this;
  }
  
  public A withLastFailedRevision(Integer lastFailedRevision) {
    this.lastFailedRevision = lastFailedRevision;
    return (A) this;
  }
  
  public A withLastFailedRevisionErrors(List<String> lastFailedRevisionErrors) {
    if (lastFailedRevisionErrors != null) {
        this.lastFailedRevisionErrors = new ArrayList();
        for (String item : lastFailedRevisionErrors) {
          this.addToLastFailedRevisionErrors(item);
        }
    } else {
      this.lastFailedRevisionErrors = null;
    }
    return (A) this;
  }
  
  public A withLastFailedRevisionErrors(String... lastFailedRevisionErrors) {
    if (this.lastFailedRevisionErrors != null) {
        this.lastFailedRevisionErrors.clear();
        _visitables.remove("lastFailedRevisionErrors");
    }
    if (lastFailedRevisionErrors != null) {
      for (String item : lastFailedRevisionErrors) {
        this.addToLastFailedRevisionErrors(item);
      }
    }
    return (A) this;
  }
  
  public A withLastFailedTime(String lastFailedTime) {
    this.lastFailedTime = lastFailedTime;
    return (A) this;
  }
  
  public A withLastFallbackCount(Integer lastFallbackCount) {
    this.lastFallbackCount = lastFallbackCount;
    return (A) this;
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withTargetRevision(Integer targetRevision) {
    this.targetRevision = targetRevision;
    return (A) this;
  }
  
}