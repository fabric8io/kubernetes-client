package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class DecisionGroupStatusFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.DecisionGroupStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer clusterCount;
  private Integer decisionGroupIndex;
  private String decisionGroupName;
  private List<String> decisions = new ArrayList<String>();

  public DecisionGroupStatusFluent() {
  }
  
  public DecisionGroupStatusFluent(DecisionGroupStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDecisions(Collection<String> items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (String item : items) {
      this.decisions.add(item);
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
  
  public A addToDecisions(String... items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (String item : items) {
      this.decisions.add(item);
    }
    return (A) this;
  }
  
  public A addToDecisions(int index,String item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    this.decisions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(DecisionGroupStatus instance) {
    instance = instance != null ? instance : new DecisionGroupStatus();
    if (instance != null) {
        this.withClusterCount(instance.getClusterCount());
        this.withDecisionGroupIndex(instance.getDecisionGroupIndex());
        this.withDecisionGroupName(instance.getDecisionGroupName());
        this.withDecisions(instance.getDecisions());
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
    DecisionGroupStatusFluent that = (DecisionGroupStatusFluent) o;
    if (!(Objects.equals(clusterCount, that.clusterCount))) {
      return false;
    }
    if (!(Objects.equals(decisionGroupIndex, that.decisionGroupIndex))) {
      return false;
    }
    if (!(Objects.equals(decisionGroupName, that.decisionGroupName))) {
      return false;
    }
    if (!(Objects.equals(decisions, that.decisions))) {
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
  
  public Integer getClusterCount() {
    return this.clusterCount;
  }
  
  public String getDecision(int index) {
    return this.decisions.get(index);
  }
  
  public Integer getDecisionGroupIndex() {
    return this.decisionGroupIndex;
  }
  
  public String getDecisionGroupName() {
    return this.decisionGroupName;
  }
  
  public List<String> getDecisions() {
    return this.decisions;
  }
  
  public String getFirstDecision() {
    return this.decisions.get(0);
  }
  
  public String getLastDecision() {
    return this.decisions.get(decisions.size() - 1);
  }
  
  public String getMatchingDecision(Predicate<String> predicate) {
      for (String item : decisions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterCount() {
    return this.clusterCount != null;
  }
  
  public boolean hasDecisionGroupIndex() {
    return this.decisionGroupIndex != null;
  }
  
  public boolean hasDecisionGroupName() {
    return this.decisionGroupName != null;
  }
  
  public boolean hasDecisions() {
    return this.decisions != null && !(this.decisions.isEmpty());
  }
  
  public boolean hasMatchingDecision(Predicate<String> predicate) {
      for (String item : decisions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clusterCount, decisionGroupIndex, decisionGroupName, decisions, additionalProperties);
  }
  
  public A removeAllFromDecisions(Collection<String> items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.decisions.remove(item);
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
  
  public A removeFromDecisions(String... items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.decisions.remove(item);
    }
    return (A) this;
  }
  
  public A setToDecisions(int index,String item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    this.decisions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterCount == null)) {
        sb.append("clusterCount:");
        sb.append(clusterCount);
        sb.append(",");
    }
    if (!(decisionGroupIndex == null)) {
        sb.append("decisionGroupIndex:");
        sb.append(decisionGroupIndex);
        sb.append(",");
    }
    if (!(decisionGroupName == null)) {
        sb.append("decisionGroupName:");
        sb.append(decisionGroupName);
        sb.append(",");
    }
    if (!(decisions == null) && !(decisions.isEmpty())) {
        sb.append("decisions:");
        sb.append(decisions);
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
  
  public A withClusterCount(Integer clusterCount) {
    this.clusterCount = clusterCount;
    return (A) this;
  }
  
  public A withDecisionGroupIndex(Integer decisionGroupIndex) {
    this.decisionGroupIndex = decisionGroupIndex;
    return (A) this;
  }
  
  public A withDecisionGroupName(String decisionGroupName) {
    this.decisionGroupName = decisionGroupName;
    return (A) this;
  }
  
  public A withDecisions(List<String> decisions) {
    if (decisions != null) {
        this.decisions = new ArrayList();
        for (String item : decisions) {
          this.addToDecisions(item);
        }
    } else {
      this.decisions = null;
    }
    return (A) this;
  }
  
  public A withDecisions(String... decisions) {
    if (this.decisions != null) {
        this.decisions.clear();
        _visitables.remove("decisions");
    }
    if (decisions != null) {
      for (String item : decisions) {
        this.addToDecisions(item);
      }
    }
    return (A) this;
  }
  
}