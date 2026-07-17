package io.fabric8.openshift.api.model.operatorhub.v2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Condition;
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
public class OperatorConditionSpecFluent<A extends io.fabric8.openshift.api.model.operatorhub.v2.OperatorConditionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private List<String> deployments = new ArrayList<String>();
  private List<Condition> overrides = new ArrayList<Condition>();
  private List<String> serviceAccounts = new ArrayList<String>();

  public OperatorConditionSpecFluent() {
  }
  
  public OperatorConditionSpecFluent(OperatorConditionSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToDeployments(Collection<String> items) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    for (String item : items) {
      this.deployments.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOverrides(Collection<Condition> items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (Condition item : items) {
      this.overrides.add(item);
    }
    return (A) this;
  }
  
  public A addAllToServiceAccounts(Collection<String> items) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    for (String item : items) {
      this.serviceAccounts.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToDeployments(String... items) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    for (String item : items) {
      this.deployments.add(item);
    }
    return (A) this;
  }
  
  public A addToDeployments(int index,String item) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    this.deployments.add(index, item);
    return (A) this;
  }
  
  public A addToOverrides(Condition... items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (Condition item : items) {
      this.overrides.add(item);
    }
    return (A) this;
  }
  
  public A addToOverrides(int index,Condition item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    this.overrides.add(index, item);
    return (A) this;
  }
  
  public A addToServiceAccounts(String... items) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    for (String item : items) {
      this.serviceAccounts.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceAccounts(int index,String item) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    this.serviceAccounts.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(OperatorConditionSpec instance) {
    instance = instance != null ? instance : new OperatorConditionSpec();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withDeployments(instance.getDeployments());
        this.withOverrides(instance.getOverrides());
        this.withServiceAccounts(instance.getServiceAccounts());
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
    OperatorConditionSpecFluent that = (OperatorConditionSpecFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(deployments, that.deployments))) {
      return false;
    }
    if (!(Objects.equals(overrides, that.overrides))) {
      return false;
    }
    if (!(Objects.equals(serviceAccounts, that.serviceAccounts))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getDeployment(int index) {
    return this.deployments.get(index);
  }
  
  public List<String> getDeployments() {
    return this.deployments;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public String getFirstDeployment() {
    return this.deployments.get(0);
  }
  
  public Condition getFirstOverride() {
    return this.overrides.get(0);
  }
  
  public String getFirstServiceAccount() {
    return this.serviceAccounts.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastDeployment() {
    return this.deployments.get(deployments.size() - 1);
  }
  
  public Condition getLastOverride() {
    return this.overrides.get(overrides.size() - 1);
  }
  
  public String getLastServiceAccount() {
    return this.serviceAccounts.get(serviceAccounts.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingDeployment(Predicate<String> predicate) {
      for (String item : deployments) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Condition getMatchingOverride(Predicate<Condition> predicate) {
      for (Condition item : overrides) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingServiceAccount(Predicate<String> predicate) {
      for (String item : serviceAccounts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Condition getOverride(int index) {
    return this.overrides.get(index);
  }
  
  public List<Condition> getOverrides() {
    return this.overrides;
  }
  
  public String getServiceAccount(int index) {
    return this.serviceAccounts.get(index);
  }
  
  public List<String> getServiceAccounts() {
    return this.serviceAccounts;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDeployments() {
    return this.deployments != null && !(this.deployments.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDeployment(Predicate<String> predicate) {
      for (String item : deployments) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOverride(Predicate<Condition> predicate) {
      for (Condition item : overrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceAccount(Predicate<String> predicate) {
      for (String item : serviceAccounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOverrides() {
    return this.overrides != null && !(this.overrides.isEmpty());
  }
  
  public boolean hasServiceAccounts() {
    return this.serviceAccounts != null && !(this.serviceAccounts.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, deployments, overrides, serviceAccounts, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromDeployments(Collection<String> items) {
    if (this.deployments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.deployments.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOverrides(Collection<Condition> items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.overrides.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceAccounts(Collection<String> items) {
    if (this.serviceAccounts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceAccounts.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromDeployments(String... items) {
    if (this.deployments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.deployments.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOverrides(Condition... items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.overrides.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromServiceAccounts(String... items) {
    if (this.serviceAccounts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceAccounts.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToDeployments(int index,String item) {
    if (this.deployments == null) {
      this.deployments = new ArrayList();
    }
    this.deployments.set(index, item);
    return (A) this;
  }
  
  public A setToOverrides(int index,Condition item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    this.overrides.set(index, item);
    return (A) this;
  }
  
  public A setToServiceAccounts(int index,String item) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    this.serviceAccounts.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(deployments == null) && !(deployments.isEmpty())) {
        sb.append("deployments:");
        sb.append(deployments);
        sb.append(",");
    }
    if (!(overrides == null) && !(overrides.isEmpty())) {
        sb.append("overrides:");
        sb.append(overrides);
        sb.append(",");
    }
    if (!(serviceAccounts == null) && !(serviceAccounts.isEmpty())) {
        sb.append("serviceAccounts:");
        sb.append(serviceAccounts);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withDeployments(List<String> deployments) {
    if (deployments != null) {
        this.deployments = new ArrayList();
        for (String item : deployments) {
          this.addToDeployments(item);
        }
    } else {
      this.deployments = null;
    }
    return (A) this;
  }
  
  public A withDeployments(String... deployments) {
    if (this.deployments != null) {
        this.deployments.clear();
        _visitables.remove("deployments");
    }
    if (deployments != null) {
      for (String item : deployments) {
        this.addToDeployments(item);
      }
    }
    return (A) this;
  }
  
  public A withOverrides(List<Condition> overrides) {
    if (overrides != null) {
        this.overrides = new ArrayList();
        for (Condition item : overrides) {
          this.addToOverrides(item);
        }
    } else {
      this.overrides = null;
    }
    return (A) this;
  }
  
  public A withOverrides(Condition... overrides) {
    if (this.overrides != null) {
        this.overrides.clear();
        _visitables.remove("overrides");
    }
    if (overrides != null) {
      for (Condition item : overrides) {
        this.addToOverrides(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceAccounts(List<String> serviceAccounts) {
    if (serviceAccounts != null) {
        this.serviceAccounts = new ArrayList();
        for (String item : serviceAccounts) {
          this.addToServiceAccounts(item);
        }
    } else {
      this.serviceAccounts = null;
    }
    return (A) this;
  }
  
  public A withServiceAccounts(String... serviceAccounts) {
    if (this.serviceAccounts != null) {
        this.serviceAccounts.clear();
        _visitables.remove("serviceAccounts");
    }
    if (serviceAccounts != null) {
      for (String item : serviceAccounts) {
        this.addToServiceAccounts(item);
      }
    }
    return (A) this;
  }
  
}