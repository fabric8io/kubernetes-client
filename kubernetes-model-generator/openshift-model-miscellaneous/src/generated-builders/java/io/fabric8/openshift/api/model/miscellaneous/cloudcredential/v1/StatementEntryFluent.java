package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
public class StatementEntryFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.StatementEntryFluent<A>> extends BaseFluent<A>{

  private List<String> action = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private String effect;
  private Map<String,Map<String,Object>> policyCondition;
  private String resource;

  public StatementEntryFluent() {
  }
  
  public StatementEntryFluent(StatementEntry instance) {
    this.copyInstance(instance);
  }

  public A addAllToAction(Collection<String> items) {
    if (this.action == null) {
      this.action = new ArrayList();
    }
    for (String item : items) {
      this.action.add(item);
    }
    return (A) this;
  }
  
  public A addToAction(String... items) {
    if (this.action == null) {
      this.action = new ArrayList();
    }
    for (String item : items) {
      this.action.add(item);
    }
    return (A) this;
  }
  
  public A addToAction(int index,String item) {
    if (this.action == null) {
      this.action = new ArrayList();
    }
    this.action.add(index, item);
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
  
  public A addToPolicyCondition(Map<String,Map<String,Object>> map) {
    if (this.policyCondition == null && map != null) {
      this.policyCondition = new LinkedHashMap();
    }
    if (map != null) {
      this.policyCondition.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPolicyCondition(String key,Map<String,Object> value) {
    if (this.policyCondition == null && key != null && value != null) {
      this.policyCondition = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.policyCondition.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(StatementEntry instance) {
    instance = instance != null ? instance : new StatementEntry();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withEffect(instance.getEffect());
        this.withPolicyCondition(instance.getPolicyCondition());
        this.withResource(instance.getResource());
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
    StatementEntryFluent that = (StatementEntryFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(effect, that.effect))) {
      return false;
    }
    if (!(Objects.equals(policyCondition, that.policyCondition))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public List<String> getAction() {
    return this.action;
  }
  
  public String getAction(int index) {
    return this.action.get(index);
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getEffect() {
    return this.effect;
  }
  
  public String getFirstAction() {
    return this.action.get(0);
  }
  
  public String getLastAction() {
    return this.action.get(action.size() - 1);
  }
  
  public String getMatchingAction(Predicate<String> predicate) {
      for (String item : action) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,Map<String,Object>> getPolicyCondition() {
    return this.policyCondition;
  }
  
  public String getResource() {
    return this.resource;
  }
  
  public boolean hasAction() {
    return this.action != null && !(this.action.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEffect() {
    return this.effect != null;
  }
  
  public boolean hasMatchingAction(Predicate<String> predicate) {
      for (String item : action) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicyCondition() {
    return this.policyCondition != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, effect, policyCondition, resource, additionalProperties);
  }
  
  public A removeAllFromAction(Collection<String> items) {
    if (this.action == null) {
      return (A) this;
    }
    for (String item : items) {
      this.action.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAction(String... items) {
    if (this.action == null) {
      return (A) this;
    }
    for (String item : items) {
      this.action.remove(item);
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
  
  public A removeFromPolicyCondition(String key) {
    if (this.policyCondition == null) {
      return (A) this;
    }
    if (key != null && this.policyCondition != null) {
      this.policyCondition.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPolicyCondition(Map<String,Map<String,Object>> map) {
    if (this.policyCondition == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.policyCondition != null) {
          this.policyCondition.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToAction(int index,String item) {
    if (this.action == null) {
      this.action = new ArrayList();
    }
    this.action.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null) && !(action.isEmpty())) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(effect == null)) {
        sb.append("effect:");
        sb.append(effect);
        sb.append(",");
    }
    if (!(policyCondition == null) && !(policyCondition.isEmpty())) {
        sb.append("policyCondition:");
        sb.append(policyCondition);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(List<String> action) {
    if (action != null) {
        this.action = new ArrayList();
        for (String item : action) {
          this.addToAction(item);
        }
    } else {
      this.action = null;
    }
    return (A) this;
  }
  
  public A withAction(String... action) {
    if (this.action != null) {
        this.action.clear();
        _visitables.remove("action");
    }
    if (action != null) {
      for (String item : action) {
        this.addToAction(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withEffect(String effect) {
    this.effect = effect;
    return (A) this;
  }
  
  public <K,V>A withPolicyCondition(Map<String,Map<String,Object>> policyCondition) {
    if (policyCondition == null) {
      this.policyCondition = null;
    } else {
      this.policyCondition = new LinkedHashMap(policyCondition);
    }
    return (A) this;
  }
  
  public A withResource(String resource) {
    this.resource = resource;
    return (A) this;
  }
  
}