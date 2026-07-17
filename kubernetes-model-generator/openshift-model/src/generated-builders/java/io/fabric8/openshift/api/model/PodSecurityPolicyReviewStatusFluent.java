package io.fabric8.openshift.api.model;

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
public class PodSecurityPolicyReviewStatusFluent<A extends io.fabric8.openshift.api.model.PodSecurityPolicyReviewStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ServiceAccountPodSecurityPolicyReviewStatusBuilder> allowedServiceAccounts = new ArrayList<ServiceAccountPodSecurityPolicyReviewStatusBuilder>();

  public PodSecurityPolicyReviewStatusFluent() {
  }
  
  public PodSecurityPolicyReviewStatusFluent(PodSecurityPolicyReviewStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedServiceAccounts(Collection<ServiceAccountPodSecurityPolicyReviewStatus> items) {
    if (this.allowedServiceAccounts == null) {
      this.allowedServiceAccounts = new ArrayList();
    }
    for (ServiceAccountPodSecurityPolicyReviewStatus item : items) {
        ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(item);
        _visitables.get("allowedServiceAccounts").add(builder);
        this.allowedServiceAccounts.add(builder);
    }
    return (A) this;
  }
  
  public AllowedServiceAccountsNested<A> addNewAllowedServiceAccount() {
    return new AllowedServiceAccountsNested(-1, null);
  }
  
  public AllowedServiceAccountsNested<A> addNewAllowedServiceAccountLike(ServiceAccountPodSecurityPolicyReviewStatus item) {
    return new AllowedServiceAccountsNested(-1, item);
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
  
  public A addToAllowedServiceAccounts(ServiceAccountPodSecurityPolicyReviewStatus... items) {
    if (this.allowedServiceAccounts == null) {
      this.allowedServiceAccounts = new ArrayList();
    }
    for (ServiceAccountPodSecurityPolicyReviewStatus item : items) {
        ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(item);
        _visitables.get("allowedServiceAccounts").add(builder);
        this.allowedServiceAccounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllowedServiceAccounts(int index,ServiceAccountPodSecurityPolicyReviewStatus item) {
    if (this.allowedServiceAccounts == null) {
      this.allowedServiceAccounts = new ArrayList();
    }
    ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(item);
    if (index < 0 || index >= allowedServiceAccounts.size()) {
        _visitables.get("allowedServiceAccounts").add(builder);
        allowedServiceAccounts.add(builder);
    } else {
        _visitables.get("allowedServiceAccounts").add(builder);
        allowedServiceAccounts.add(index, builder);
    }
    return (A) this;
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatus buildAllowedServiceAccount(int index) {
    return this.allowedServiceAccounts.get(index).build();
  }
  
  public List<ServiceAccountPodSecurityPolicyReviewStatus> buildAllowedServiceAccounts() {
    return this.allowedServiceAccounts != null ? build(allowedServiceAccounts) : null;
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatus buildFirstAllowedServiceAccount() {
    return this.allowedServiceAccounts.get(0).build();
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatus buildLastAllowedServiceAccount() {
    return this.allowedServiceAccounts.get(allowedServiceAccounts.size() - 1).build();
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatus buildMatchingAllowedServiceAccount(Predicate<ServiceAccountPodSecurityPolicyReviewStatusBuilder> predicate) {
      for (ServiceAccountPodSecurityPolicyReviewStatusBuilder item : allowedServiceAccounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodSecurityPolicyReviewStatus instance) {
    instance = instance != null ? instance : new PodSecurityPolicyReviewStatus();
    if (instance != null) {
        this.withAllowedServiceAccounts(instance.getAllowedServiceAccounts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllowedServiceAccountsNested<A> editAllowedServiceAccount(int index) {
    if (allowedServiceAccounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedServiceAccounts"));
    }
    return this.setNewAllowedServiceAccountLike(index, this.buildAllowedServiceAccount(index));
  }
  
  public AllowedServiceAccountsNested<A> editFirstAllowedServiceAccount() {
    if (allowedServiceAccounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedServiceAccounts"));
    }
    return this.setNewAllowedServiceAccountLike(0, this.buildAllowedServiceAccount(0));
  }
  
  public AllowedServiceAccountsNested<A> editLastAllowedServiceAccount() {
    int index = allowedServiceAccounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedServiceAccounts"));
    }
    return this.setNewAllowedServiceAccountLike(index, this.buildAllowedServiceAccount(index));
  }
  
  public AllowedServiceAccountsNested<A> editMatchingAllowedServiceAccount(Predicate<ServiceAccountPodSecurityPolicyReviewStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allowedServiceAccounts.size();i++) {
      if (predicate.test(allowedServiceAccounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allowedServiceAccounts"));
    }
    return this.setNewAllowedServiceAccountLike(index, this.buildAllowedServiceAccount(index));
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
    PodSecurityPolicyReviewStatusFluent that = (PodSecurityPolicyReviewStatusFluent) o;
    if (!(Objects.equals(allowedServiceAccounts, that.allowedServiceAccounts))) {
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
  
  public boolean hasAllowedServiceAccounts() {
    return this.allowedServiceAccounts != null && !(this.allowedServiceAccounts.isEmpty());
  }
  
  public boolean hasMatchingAllowedServiceAccount(Predicate<ServiceAccountPodSecurityPolicyReviewStatusBuilder> predicate) {
      for (ServiceAccountPodSecurityPolicyReviewStatusBuilder item : allowedServiceAccounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(allowedServiceAccounts, additionalProperties);
  }
  
  public A removeAllFromAllowedServiceAccounts(Collection<ServiceAccountPodSecurityPolicyReviewStatus> items) {
    if (this.allowedServiceAccounts == null) {
      return (A) this;
    }
    for (ServiceAccountPodSecurityPolicyReviewStatus item : items) {
        ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(item);
        _visitables.get("allowedServiceAccounts").remove(builder);
        this.allowedServiceAccounts.remove(builder);
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
  
  public A removeFromAllowedServiceAccounts(ServiceAccountPodSecurityPolicyReviewStatus... items) {
    if (this.allowedServiceAccounts == null) {
      return (A) this;
    }
    for (ServiceAccountPodSecurityPolicyReviewStatus item : items) {
        ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(item);
        _visitables.get("allowedServiceAccounts").remove(builder);
        this.allowedServiceAccounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllowedServiceAccounts(Predicate<ServiceAccountPodSecurityPolicyReviewStatusBuilder> predicate) {
    if (allowedServiceAccounts == null) {
      return (A) this;
    }
    Iterator<ServiceAccountPodSecurityPolicyReviewStatusBuilder> each = allowedServiceAccounts.iterator();
    List visitables = _visitables.get("allowedServiceAccounts");
    while (each.hasNext()) {
        ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllowedServiceAccountsNested<A> setNewAllowedServiceAccountLike(int index,ServiceAccountPodSecurityPolicyReviewStatus item) {
    return new AllowedServiceAccountsNested(index, item);
  }
  
  public A setToAllowedServiceAccounts(int index,ServiceAccountPodSecurityPolicyReviewStatus item) {
    if (this.allowedServiceAccounts == null) {
      this.allowedServiceAccounts = new ArrayList();
    }
    ServiceAccountPodSecurityPolicyReviewStatusBuilder builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(item);
    if (index < 0 || index >= allowedServiceAccounts.size()) {
        _visitables.get("allowedServiceAccounts").add(builder);
        allowedServiceAccounts.add(builder);
    } else {
        _visitables.get("allowedServiceAccounts").add(builder);
        allowedServiceAccounts.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedServiceAccounts == null) && !(allowedServiceAccounts.isEmpty())) {
        sb.append("allowedServiceAccounts:");
        sb.append(allowedServiceAccounts);
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
  
  public A withAllowedServiceAccounts(List<ServiceAccountPodSecurityPolicyReviewStatus> allowedServiceAccounts) {
    if (this.allowedServiceAccounts != null) {
      this._visitables.get("allowedServiceAccounts").clear();
    }
    if (allowedServiceAccounts != null) {
        this.allowedServiceAccounts = new ArrayList();
        for (ServiceAccountPodSecurityPolicyReviewStatus item : allowedServiceAccounts) {
          this.addToAllowedServiceAccounts(item);
        }
    } else {
      this.allowedServiceAccounts = null;
    }
    return (A) this;
  }
  
  public A withAllowedServiceAccounts(ServiceAccountPodSecurityPolicyReviewStatus... allowedServiceAccounts) {
    if (this.allowedServiceAccounts != null) {
        this.allowedServiceAccounts.clear();
        _visitables.remove("allowedServiceAccounts");
    }
    if (allowedServiceAccounts != null) {
      for (ServiceAccountPodSecurityPolicyReviewStatus item : allowedServiceAccounts) {
        this.addToAllowedServiceAccounts(item);
      }
    }
    return (A) this;
  }
  public class AllowedServiceAccountsNested<N> extends ServiceAccountPodSecurityPolicyReviewStatusFluent<AllowedServiceAccountsNested<N>> implements Nested<N>{
  
    ServiceAccountPodSecurityPolicyReviewStatusBuilder builder;
    int index;
  
    AllowedServiceAccountsNested(int index,ServiceAccountPodSecurityPolicyReviewStatus item) {
      this.index = index;
      this.builder = new ServiceAccountPodSecurityPolicyReviewStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityPolicyReviewStatusFluent.this.setToAllowedServiceAccounts(index, builder.build());
    }
    
    public N endAllowedServiceAccount() {
      return and();
    }
    
  }
}