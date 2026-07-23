package io.fabric8.certmanager.api.model.v1;

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
public class NameConstraintItemFluent<A extends io.fabric8.certmanager.api.model.v1.NameConstraintItemFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> dnsDomains = new ArrayList<String>();
  private List<String> emailAddresses = new ArrayList<String>();
  private List<String> ipRanges = new ArrayList<String>();
  private List<String> uriDomains = new ArrayList<String>();

  public NameConstraintItemFluent() {
  }
  
  public NameConstraintItemFluent(NameConstraintItem instance) {
    this.copyInstance(instance);
  }

  public A addAllToDnsDomains(Collection<String> items) {
    if (this.dnsDomains == null) {
      this.dnsDomains = new ArrayList();
    }
    for (String item : items) {
      this.dnsDomains.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEmailAddresses(Collection<String> items) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    for (String item : items) {
      this.emailAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIpRanges(Collection<String> items) {
    if (this.ipRanges == null) {
      this.ipRanges = new ArrayList();
    }
    for (String item : items) {
      this.ipRanges.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUriDomains(Collection<String> items) {
    if (this.uriDomains == null) {
      this.uriDomains = new ArrayList();
    }
    for (String item : items) {
      this.uriDomains.add(item);
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
  
  public A addToDnsDomains(String... items) {
    if (this.dnsDomains == null) {
      this.dnsDomains = new ArrayList();
    }
    for (String item : items) {
      this.dnsDomains.add(item);
    }
    return (A) this;
  }
  
  public A addToDnsDomains(int index,String item) {
    if (this.dnsDomains == null) {
      this.dnsDomains = new ArrayList();
    }
    this.dnsDomains.add(index, item);
    return (A) this;
  }
  
  public A addToEmailAddresses(String... items) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    for (String item : items) {
      this.emailAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addToEmailAddresses(int index,String item) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    this.emailAddresses.add(index, item);
    return (A) this;
  }
  
  public A addToIpRanges(String... items) {
    if (this.ipRanges == null) {
      this.ipRanges = new ArrayList();
    }
    for (String item : items) {
      this.ipRanges.add(item);
    }
    return (A) this;
  }
  
  public A addToIpRanges(int index,String item) {
    if (this.ipRanges == null) {
      this.ipRanges = new ArrayList();
    }
    this.ipRanges.add(index, item);
    return (A) this;
  }
  
  public A addToUriDomains(String... items) {
    if (this.uriDomains == null) {
      this.uriDomains = new ArrayList();
    }
    for (String item : items) {
      this.uriDomains.add(item);
    }
    return (A) this;
  }
  
  public A addToUriDomains(int index,String item) {
    if (this.uriDomains == null) {
      this.uriDomains = new ArrayList();
    }
    this.uriDomains.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NameConstraintItem instance) {
    instance = instance != null ? instance : new NameConstraintItem();
    if (instance != null) {
        this.withDnsDomains(instance.getDnsDomains());
        this.withEmailAddresses(instance.getEmailAddresses());
        this.withIpRanges(instance.getIpRanges());
        this.withUriDomains(instance.getUriDomains());
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
    NameConstraintItemFluent that = (NameConstraintItemFluent) o;
    if (!(Objects.equals(dnsDomains, that.dnsDomains))) {
      return false;
    }
    if (!(Objects.equals(emailAddresses, that.emailAddresses))) {
      return false;
    }
    if (!(Objects.equals(ipRanges, that.ipRanges))) {
      return false;
    }
    if (!(Objects.equals(uriDomains, that.uriDomains))) {
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
  
  public String getDnsDomain(int index) {
    return this.dnsDomains.get(index);
  }
  
  public List<String> getDnsDomains() {
    return this.dnsDomains;
  }
  
  public String getEmailAddress(int index) {
    return this.emailAddresses.get(index);
  }
  
  public List<String> getEmailAddresses() {
    return this.emailAddresses;
  }
  
  public String getFirstDnsDomain() {
    return this.dnsDomains.get(0);
  }
  
  public String getFirstEmailAddress() {
    return this.emailAddresses.get(0);
  }
  
  public String getFirstIpRange() {
    return this.ipRanges.get(0);
  }
  
  public String getFirstUriDomain() {
    return this.uriDomains.get(0);
  }
  
  public String getIpRange(int index) {
    return this.ipRanges.get(index);
  }
  
  public List<String> getIpRanges() {
    return this.ipRanges;
  }
  
  public String getLastDnsDomain() {
    return this.dnsDomains.get(dnsDomains.size() - 1);
  }
  
  public String getLastEmailAddress() {
    return this.emailAddresses.get(emailAddresses.size() - 1);
  }
  
  public String getLastIpRange() {
    return this.ipRanges.get(ipRanges.size() - 1);
  }
  
  public String getLastUriDomain() {
    return this.uriDomains.get(uriDomains.size() - 1);
  }
  
  public String getMatchingDnsDomain(Predicate<String> predicate) {
      for (String item : dnsDomains) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingEmailAddress(Predicate<String> predicate) {
      for (String item : emailAddresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIpRange(Predicate<String> predicate) {
      for (String item : ipRanges) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUriDomain(Predicate<String> predicate) {
      for (String item : uriDomains) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUriDomain(int index) {
    return this.uriDomains.get(index);
  }
  
  public List<String> getUriDomains() {
    return this.uriDomains;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDnsDomains() {
    return this.dnsDomains != null && !(this.dnsDomains.isEmpty());
  }
  
  public boolean hasEmailAddresses() {
    return this.emailAddresses != null && !(this.emailAddresses.isEmpty());
  }
  
  public boolean hasIpRanges() {
    return this.ipRanges != null && !(this.ipRanges.isEmpty());
  }
  
  public boolean hasMatchingDnsDomain(Predicate<String> predicate) {
      for (String item : dnsDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEmailAddress(Predicate<String> predicate) {
      for (String item : emailAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpRange(Predicate<String> predicate) {
      for (String item : ipRanges) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUriDomain(Predicate<String> predicate) {
      for (String item : uriDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUriDomains() {
    return this.uriDomains != null && !(this.uriDomains.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(dnsDomains, emailAddresses, ipRanges, uriDomains, additionalProperties);
  }
  
  public A removeAllFromDnsDomains(Collection<String> items) {
    if (this.dnsDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsDomains.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEmailAddresses(Collection<String> items) {
    if (this.emailAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.emailAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIpRanges(Collection<String> items) {
    if (this.ipRanges == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipRanges.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUriDomains(Collection<String> items) {
    if (this.uriDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.uriDomains.remove(item);
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
  
  public A removeFromDnsDomains(String... items) {
    if (this.dnsDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsDomains.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEmailAddresses(String... items) {
    if (this.emailAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.emailAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIpRanges(String... items) {
    if (this.ipRanges == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipRanges.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUriDomains(String... items) {
    if (this.uriDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.uriDomains.remove(item);
    }
    return (A) this;
  }
  
  public A setToDnsDomains(int index,String item) {
    if (this.dnsDomains == null) {
      this.dnsDomains = new ArrayList();
    }
    this.dnsDomains.set(index, item);
    return (A) this;
  }
  
  public A setToEmailAddresses(int index,String item) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList();
    }
    this.emailAddresses.set(index, item);
    return (A) this;
  }
  
  public A setToIpRanges(int index,String item) {
    if (this.ipRanges == null) {
      this.ipRanges = new ArrayList();
    }
    this.ipRanges.set(index, item);
    return (A) this;
  }
  
  public A setToUriDomains(int index,String item) {
    if (this.uriDomains == null) {
      this.uriDomains = new ArrayList();
    }
    this.uriDomains.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dnsDomains == null) && !(dnsDomains.isEmpty())) {
        sb.append("dnsDomains:");
        sb.append(dnsDomains);
        sb.append(",");
    }
    if (!(emailAddresses == null) && !(emailAddresses.isEmpty())) {
        sb.append("emailAddresses:");
        sb.append(emailAddresses);
        sb.append(",");
    }
    if (!(ipRanges == null) && !(ipRanges.isEmpty())) {
        sb.append("ipRanges:");
        sb.append(ipRanges);
        sb.append(",");
    }
    if (!(uriDomains == null) && !(uriDomains.isEmpty())) {
        sb.append("uriDomains:");
        sb.append(uriDomains);
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
  
  public A withDnsDomains(List<String> dnsDomains) {
    if (dnsDomains != null) {
        this.dnsDomains = new ArrayList();
        for (String item : dnsDomains) {
          this.addToDnsDomains(item);
        }
    } else {
      this.dnsDomains = null;
    }
    return (A) this;
  }
  
  public A withDnsDomains(String... dnsDomains) {
    if (this.dnsDomains != null) {
        this.dnsDomains.clear();
        _visitables.remove("dnsDomains");
    }
    if (dnsDomains != null) {
      for (String item : dnsDomains) {
        this.addToDnsDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withEmailAddresses(List<String> emailAddresses) {
    if (emailAddresses != null) {
        this.emailAddresses = new ArrayList();
        for (String item : emailAddresses) {
          this.addToEmailAddresses(item);
        }
    } else {
      this.emailAddresses = null;
    }
    return (A) this;
  }
  
  public A withEmailAddresses(String... emailAddresses) {
    if (this.emailAddresses != null) {
        this.emailAddresses.clear();
        _visitables.remove("emailAddresses");
    }
    if (emailAddresses != null) {
      for (String item : emailAddresses) {
        this.addToEmailAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withIpRanges(List<String> ipRanges) {
    if (ipRanges != null) {
        this.ipRanges = new ArrayList();
        for (String item : ipRanges) {
          this.addToIpRanges(item);
        }
    } else {
      this.ipRanges = null;
    }
    return (A) this;
  }
  
  public A withIpRanges(String... ipRanges) {
    if (this.ipRanges != null) {
        this.ipRanges.clear();
        _visitables.remove("ipRanges");
    }
    if (ipRanges != null) {
      for (String item : ipRanges) {
        this.addToIpRanges(item);
      }
    }
    return (A) this;
  }
  
  public A withUriDomains(List<String> uriDomains) {
    if (uriDomains != null) {
        this.uriDomains = new ArrayList();
        for (String item : uriDomains) {
          this.addToUriDomains(item);
        }
    } else {
      this.uriDomains = null;
    }
    return (A) this;
  }
  
  public A withUriDomains(String... uriDomains) {
    if (this.uriDomains != null) {
        this.uriDomains.clear();
        _visitables.remove("uriDomains");
    }
    if (uriDomains != null) {
      for (String item : uriDomains) {
        this.addToUriDomains(item);
      }
    }
    return (A) this;
  }
  
}