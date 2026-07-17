package io.fabric8.openshift.api.model.operator.v1;

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
public class StaticIPAMDNSFluent<A extends io.fabric8.openshift.api.model.operator.v1.StaticIPAMDNSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String domain;
  private List<String> nameservers = new ArrayList<String>();
  private List<String> search = new ArrayList<String>();

  public StaticIPAMDNSFluent() {
  }
  
  public StaticIPAMDNSFluent(StaticIPAMDNS instance) {
    this.copyInstance(instance);
  }

  public A addAllToNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSearch(Collection<String> items) {
    if (this.search == null) {
      this.search = new ArrayList();
    }
    for (String item : items) {
      this.search.add(item);
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
  
  public A addToNameservers(String... items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public A addToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.add(index, item);
    return (A) this;
  }
  
  public A addToSearch(String... items) {
    if (this.search == null) {
      this.search = new ArrayList();
    }
    for (String item : items) {
      this.search.add(item);
    }
    return (A) this;
  }
  
  public A addToSearch(int index,String item) {
    if (this.search == null) {
      this.search = new ArrayList();
    }
    this.search.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(StaticIPAMDNS instance) {
    instance = instance != null ? instance : new StaticIPAMDNS();
    if (instance != null) {
        this.withDomain(instance.getDomain());
        this.withNameservers(instance.getNameservers());
        this.withSearch(instance.getSearch());
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
    StaticIPAMDNSFluent that = (StaticIPAMDNSFluent) o;
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(nameservers, that.nameservers))) {
      return false;
    }
    if (!(Objects.equals(search, that.search))) {
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
  
  public String getDomain() {
    return this.domain;
  }
  
  public String getFirstNameserver() {
    return this.nameservers.get(0);
  }
  
  public String getFirstSearch() {
    return this.search.get(0);
  }
  
  public String getLastNameserver() {
    return this.nameservers.get(nameservers.size() - 1);
  }
  
  public String getLastSearch() {
    return this.search.get(search.size() - 1);
  }
  
  public String getMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSearch(Predicate<String> predicate) {
      for (String item : search) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameserver(int index) {
    return this.nameservers.get(index);
  }
  
  public List<String> getNameservers() {
    return this.nameservers;
  }
  
  public List<String> getSearch() {
    return this.search;
  }
  
  public String getSearch(int index) {
    return this.search.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSearch(Predicate<String> predicate) {
      for (String item : search) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameservers() {
    return this.nameservers != null && !(this.nameservers.isEmpty());
  }
  
  public boolean hasSearch() {
    return this.search != null && !(this.search.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(domain, nameservers, search, additionalProperties);
  }
  
  public A removeAllFromNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSearch(Collection<String> items) {
    if (this.search == null) {
      return (A) this;
    }
    for (String item : items) {
      this.search.remove(item);
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
  
  public A removeFromNameservers(String... items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSearch(String... items) {
    if (this.search == null) {
      return (A) this;
    }
    for (String item : items) {
      this.search.remove(item);
    }
    return (A) this;
  }
  
  public A setToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.set(index, item);
    return (A) this;
  }
  
  public A setToSearch(int index,String item) {
    if (this.search == null) {
      this.search = new ArrayList();
    }
    this.search.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(nameservers == null) && !(nameservers.isEmpty())) {
        sb.append("nameservers:");
        sb.append(nameservers);
        sb.append(",");
    }
    if (!(search == null) && !(search.isEmpty())) {
        sb.append("search:");
        sb.append(search);
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
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withNameservers(List<String> nameservers) {
    if (nameservers != null) {
        this.nameservers = new ArrayList();
        for (String item : nameservers) {
          this.addToNameservers(item);
        }
    } else {
      this.nameservers = null;
    }
    return (A) this;
  }
  
  public A withNameservers(String... nameservers) {
    if (this.nameservers != null) {
        this.nameservers.clear();
        _visitables.remove("nameservers");
    }
    if (nameservers != null) {
      for (String item : nameservers) {
        this.addToNameservers(item);
      }
    }
    return (A) this;
  }
  
  public A withSearch(List<String> search) {
    if (search != null) {
        this.search = new ArrayList();
        for (String item : search) {
          this.addToSearch(item);
        }
    } else {
      this.search = null;
    }
    return (A) this;
  }
  
  public A withSearch(String... search) {
    if (this.search != null) {
        this.search.clear();
        _visitables.remove("search");
    }
    if (search != null) {
      for (String item : search) {
        this.addToSearch(item);
      }
    }
    return (A) this;
  }
  
}