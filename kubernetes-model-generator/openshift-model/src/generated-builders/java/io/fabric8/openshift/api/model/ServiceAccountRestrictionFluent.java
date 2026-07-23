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
public class ServiceAccountRestrictionFluent<A extends io.fabric8.openshift.api.model.ServiceAccountRestrictionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> namespaces = new ArrayList<String>();
  private ArrayList<ServiceAccountReferenceBuilder> serviceaccounts = new ArrayList<ServiceAccountReferenceBuilder>();

  public ServiceAccountRestrictionFluent() {
  }
  
  public ServiceAccountRestrictionFluent(ServiceAccountRestriction instance) {
    this.copyInstance(instance);
  }

  public A addAllToNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addAllToServiceaccounts(Collection<ServiceAccountReference> items) {
    if (this.serviceaccounts == null) {
      this.serviceaccounts = new ArrayList();
    }
    for (ServiceAccountReference item : items) {
        ServiceAccountReferenceBuilder builder = new ServiceAccountReferenceBuilder(item);
        _visitables.get("serviceaccounts").add(builder);
        this.serviceaccounts.add(builder);
    }
    return (A) this;
  }
  
  public ServiceaccountsNested<A> addNewServiceaccount() {
    return new ServiceaccountsNested(-1, null);
  }
  
  public A addNewServiceaccount(String name,String namespace) {
    return (A) this.addToServiceaccounts(new ServiceAccountReference(name, namespace));
  }
  
  public ServiceaccountsNested<A> addNewServiceaccountLike(ServiceAccountReference item) {
    return new ServiceaccountsNested(-1, item);
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
  
  public A addToNamespaces(String... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (String item : items) {
      this.namespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.add(index, item);
    return (A) this;
  }
  
  public A addToServiceaccounts(ServiceAccountReference... items) {
    if (this.serviceaccounts == null) {
      this.serviceaccounts = new ArrayList();
    }
    for (ServiceAccountReference item : items) {
        ServiceAccountReferenceBuilder builder = new ServiceAccountReferenceBuilder(item);
        _visitables.get("serviceaccounts").add(builder);
        this.serviceaccounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceaccounts(int index,ServiceAccountReference item) {
    if (this.serviceaccounts == null) {
      this.serviceaccounts = new ArrayList();
    }
    ServiceAccountReferenceBuilder builder = new ServiceAccountReferenceBuilder(item);
    if (index < 0 || index >= serviceaccounts.size()) {
        _visitables.get("serviceaccounts").add(builder);
        serviceaccounts.add(builder);
    } else {
        _visitables.get("serviceaccounts").add(builder);
        serviceaccounts.add(index, builder);
    }
    return (A) this;
  }
  
  public ServiceAccountReference buildFirstServiceaccount() {
    return this.serviceaccounts.get(0).build();
  }
  
  public ServiceAccountReference buildLastServiceaccount() {
    return this.serviceaccounts.get(serviceaccounts.size() - 1).build();
  }
  
  public ServiceAccountReference buildMatchingServiceaccount(Predicate<ServiceAccountReferenceBuilder> predicate) {
      for (ServiceAccountReferenceBuilder item : serviceaccounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ServiceAccountReference buildServiceaccount(int index) {
    return this.serviceaccounts.get(index).build();
  }
  
  public List<ServiceAccountReference> buildServiceaccounts() {
    return this.serviceaccounts != null ? build(serviceaccounts) : null;
  }
  
  protected void copyInstance(ServiceAccountRestriction instance) {
    instance = instance != null ? instance : new ServiceAccountRestriction();
    if (instance != null) {
        this.withNamespaces(instance.getNamespaces());
        this.withServiceaccounts(instance.getServiceaccounts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceaccountsNested<A> editFirstServiceaccount() {
    if (serviceaccounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "serviceaccounts"));
    }
    return this.setNewServiceaccountLike(0, this.buildServiceaccount(0));
  }
  
  public ServiceaccountsNested<A> editLastServiceaccount() {
    int index = serviceaccounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "serviceaccounts"));
    }
    return this.setNewServiceaccountLike(index, this.buildServiceaccount(index));
  }
  
  public ServiceaccountsNested<A> editMatchingServiceaccount(Predicate<ServiceAccountReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < serviceaccounts.size();i++) {
      if (predicate.test(serviceaccounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "serviceaccounts"));
    }
    return this.setNewServiceaccountLike(index, this.buildServiceaccount(index));
  }
  
  public ServiceaccountsNested<A> editServiceaccount(int index) {
    if (serviceaccounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "serviceaccounts"));
    }
    return this.setNewServiceaccountLike(index, this.buildServiceaccount(index));
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
    ServiceAccountRestrictionFluent that = (ServiceAccountRestrictionFluent) o;
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(serviceaccounts, that.serviceaccounts))) {
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
  
  public String getFirstNamespace() {
    return this.namespaces.get(0);
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace(int index) {
    return this.namespaces.get(index);
  }
  
  public List<String> getNamespaces() {
    return this.namespaces;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceaccount(Predicate<ServiceAccountReferenceBuilder> predicate) {
      for (ServiceAccountReferenceBuilder item : serviceaccounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasServiceaccounts() {
    return this.serviceaccounts != null && !(this.serviceaccounts.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(namespaces, serviceaccounts, additionalProperties);
  }
  
  public A removeAllFromNamespaces(Collection<String> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceaccounts(Collection<ServiceAccountReference> items) {
    if (this.serviceaccounts == null) {
      return (A) this;
    }
    for (ServiceAccountReference item : items) {
        ServiceAccountReferenceBuilder builder = new ServiceAccountReferenceBuilder(item);
        _visitables.get("serviceaccounts").remove(builder);
        this.serviceaccounts.remove(builder);
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
  
  public A removeFromNamespaces(String... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.namespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromServiceaccounts(ServiceAccountReference... items) {
    if (this.serviceaccounts == null) {
      return (A) this;
    }
    for (ServiceAccountReference item : items) {
        ServiceAccountReferenceBuilder builder = new ServiceAccountReferenceBuilder(item);
        _visitables.get("serviceaccounts").remove(builder);
        this.serviceaccounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceaccounts(Predicate<ServiceAccountReferenceBuilder> predicate) {
    if (serviceaccounts == null) {
      return (A) this;
    }
    Iterator<ServiceAccountReferenceBuilder> each = serviceaccounts.iterator();
    List visitables = _visitables.get("serviceaccounts");
    while (each.hasNext()) {
        ServiceAccountReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ServiceaccountsNested<A> setNewServiceaccountLike(int index,ServiceAccountReference item) {
    return new ServiceaccountsNested(index, item);
  }
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
    return (A) this;
  }
  
  public A setToServiceaccounts(int index,ServiceAccountReference item) {
    if (this.serviceaccounts == null) {
      this.serviceaccounts = new ArrayList();
    }
    ServiceAccountReferenceBuilder builder = new ServiceAccountReferenceBuilder(item);
    if (index < 0 || index >= serviceaccounts.size()) {
        _visitables.get("serviceaccounts").add(builder);
        serviceaccounts.add(builder);
    } else {
        _visitables.get("serviceaccounts").add(builder);
        serviceaccounts.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(serviceaccounts == null) && !(serviceaccounts.isEmpty())) {
        sb.append("serviceaccounts:");
        sb.append(serviceaccounts);
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
  
  public A withNamespaces(List<String> namespaces) {
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (String item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(String... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (String item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceaccounts(List<ServiceAccountReference> serviceaccounts) {
    if (this.serviceaccounts != null) {
      this._visitables.get("serviceaccounts").clear();
    }
    if (serviceaccounts != null) {
        this.serviceaccounts = new ArrayList();
        for (ServiceAccountReference item : serviceaccounts) {
          this.addToServiceaccounts(item);
        }
    } else {
      this.serviceaccounts = null;
    }
    return (A) this;
  }
  
  public A withServiceaccounts(ServiceAccountReference... serviceaccounts) {
    if (this.serviceaccounts != null) {
        this.serviceaccounts.clear();
        _visitables.remove("serviceaccounts");
    }
    if (serviceaccounts != null) {
      for (ServiceAccountReference item : serviceaccounts) {
        this.addToServiceaccounts(item);
      }
    }
    return (A) this;
  }
  public class ServiceaccountsNested<N> extends ServiceAccountReferenceFluent<ServiceaccountsNested<N>> implements Nested<N>{
  
    ServiceAccountReferenceBuilder builder;
    int index;
  
    ServiceaccountsNested(int index,ServiceAccountReference item) {
      this.index = index;
      this.builder = new ServiceAccountReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceAccountRestrictionFluent.this.setToServiceaccounts(index, builder.build());
    }
    
    public N endServiceaccount() {
      return and();
    }
    
  }
}