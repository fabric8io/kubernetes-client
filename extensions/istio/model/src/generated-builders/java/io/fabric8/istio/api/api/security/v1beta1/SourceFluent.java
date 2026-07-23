package io.fabric8.istio.api.api.security.v1beta1;

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
public class SourceFluent<A extends io.fabric8.istio.api.api.security.v1beta1.SourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> ipBlocks = new ArrayList<String>();
  private List<String> namespaces = new ArrayList<String>();
  private List<String> notIpBlocks = new ArrayList<String>();
  private List<String> notNamespaces = new ArrayList<String>();
  private List<String> notPrincipals = new ArrayList<String>();
  private List<String> notRemoteIpBlocks = new ArrayList<String>();
  private List<String> notRequestPrincipals = new ArrayList<String>();
  private List<String> notServiceAccounts = new ArrayList<String>();
  private List<String> notTrustDomains = new ArrayList<String>();
  private List<String> principals = new ArrayList<String>();
  private List<String> remoteIpBlocks = new ArrayList<String>();
  private List<String> requestPrincipals = new ArrayList<String>();
  private List<String> serviceAccounts = new ArrayList<String>();
  private List<String> trustDomains = new ArrayList<String>();

  public SourceFluent() {
  }
  
  public SourceFluent(Source instance) {
    this.copyInstance(instance);
  }

  public A addAllToIpBlocks(Collection<String> items) {
    if (this.ipBlocks == null) {
      this.ipBlocks = new ArrayList();
    }
    for (String item : items) {
      this.ipBlocks.add(item);
    }
    return (A) this;
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
  
  public A addAllToNotIpBlocks(Collection<String> items) {
    if (this.notIpBlocks == null) {
      this.notIpBlocks = new ArrayList();
    }
    for (String item : items) {
      this.notIpBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotNamespaces(Collection<String> items) {
    if (this.notNamespaces == null) {
      this.notNamespaces = new ArrayList();
    }
    for (String item : items) {
      this.notNamespaces.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotPrincipals(Collection<String> items) {
    if (this.notPrincipals == null) {
      this.notPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.notPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotRemoteIpBlocks(Collection<String> items) {
    if (this.notRemoteIpBlocks == null) {
      this.notRemoteIpBlocks = new ArrayList();
    }
    for (String item : items) {
      this.notRemoteIpBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotRequestPrincipals(Collection<String> items) {
    if (this.notRequestPrincipals == null) {
      this.notRequestPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.notRequestPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotServiceAccounts(Collection<String> items) {
    if (this.notServiceAccounts == null) {
      this.notServiceAccounts = new ArrayList();
    }
    for (String item : items) {
      this.notServiceAccounts.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotTrustDomains(Collection<String> items) {
    if (this.notTrustDomains == null) {
      this.notTrustDomains = new ArrayList();
    }
    for (String item : items) {
      this.notTrustDomains.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPrincipals(Collection<String> items) {
    if (this.principals == null) {
      this.principals = new ArrayList();
    }
    for (String item : items) {
      this.principals.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRemoteIpBlocks(Collection<String> items) {
    if (this.remoteIpBlocks == null) {
      this.remoteIpBlocks = new ArrayList();
    }
    for (String item : items) {
      this.remoteIpBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRequestPrincipals(Collection<String> items) {
    if (this.requestPrincipals == null) {
      this.requestPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.requestPrincipals.add(item);
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
  
  public A addAllToTrustDomains(Collection<String> items) {
    if (this.trustDomains == null) {
      this.trustDomains = new ArrayList();
    }
    for (String item : items) {
      this.trustDomains.add(item);
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
  
  public A addToIpBlocks(String... items) {
    if (this.ipBlocks == null) {
      this.ipBlocks = new ArrayList();
    }
    for (String item : items) {
      this.ipBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addToIpBlocks(int index,String item) {
    if (this.ipBlocks == null) {
      this.ipBlocks = new ArrayList();
    }
    this.ipBlocks.add(index, item);
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
  
  public A addToNotIpBlocks(String... items) {
    if (this.notIpBlocks == null) {
      this.notIpBlocks = new ArrayList();
    }
    for (String item : items) {
      this.notIpBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addToNotIpBlocks(int index,String item) {
    if (this.notIpBlocks == null) {
      this.notIpBlocks = new ArrayList();
    }
    this.notIpBlocks.add(index, item);
    return (A) this;
  }
  
  public A addToNotNamespaces(String... items) {
    if (this.notNamespaces == null) {
      this.notNamespaces = new ArrayList();
    }
    for (String item : items) {
      this.notNamespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToNotNamespaces(int index,String item) {
    if (this.notNamespaces == null) {
      this.notNamespaces = new ArrayList();
    }
    this.notNamespaces.add(index, item);
    return (A) this;
  }
  
  public A addToNotPrincipals(String... items) {
    if (this.notPrincipals == null) {
      this.notPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.notPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addToNotPrincipals(int index,String item) {
    if (this.notPrincipals == null) {
      this.notPrincipals = new ArrayList();
    }
    this.notPrincipals.add(index, item);
    return (A) this;
  }
  
  public A addToNotRemoteIpBlocks(String... items) {
    if (this.notRemoteIpBlocks == null) {
      this.notRemoteIpBlocks = new ArrayList();
    }
    for (String item : items) {
      this.notRemoteIpBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addToNotRemoteIpBlocks(int index,String item) {
    if (this.notRemoteIpBlocks == null) {
      this.notRemoteIpBlocks = new ArrayList();
    }
    this.notRemoteIpBlocks.add(index, item);
    return (A) this;
  }
  
  public A addToNotRequestPrincipals(String... items) {
    if (this.notRequestPrincipals == null) {
      this.notRequestPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.notRequestPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addToNotRequestPrincipals(int index,String item) {
    if (this.notRequestPrincipals == null) {
      this.notRequestPrincipals = new ArrayList();
    }
    this.notRequestPrincipals.add(index, item);
    return (A) this;
  }
  
  public A addToNotServiceAccounts(String... items) {
    if (this.notServiceAccounts == null) {
      this.notServiceAccounts = new ArrayList();
    }
    for (String item : items) {
      this.notServiceAccounts.add(item);
    }
    return (A) this;
  }
  
  public A addToNotServiceAccounts(int index,String item) {
    if (this.notServiceAccounts == null) {
      this.notServiceAccounts = new ArrayList();
    }
    this.notServiceAccounts.add(index, item);
    return (A) this;
  }
  
  public A addToNotTrustDomains(String... items) {
    if (this.notTrustDomains == null) {
      this.notTrustDomains = new ArrayList();
    }
    for (String item : items) {
      this.notTrustDomains.add(item);
    }
    return (A) this;
  }
  
  public A addToNotTrustDomains(int index,String item) {
    if (this.notTrustDomains == null) {
      this.notTrustDomains = new ArrayList();
    }
    this.notTrustDomains.add(index, item);
    return (A) this;
  }
  
  public A addToPrincipals(String... items) {
    if (this.principals == null) {
      this.principals = new ArrayList();
    }
    for (String item : items) {
      this.principals.add(item);
    }
    return (A) this;
  }
  
  public A addToPrincipals(int index,String item) {
    if (this.principals == null) {
      this.principals = new ArrayList();
    }
    this.principals.add(index, item);
    return (A) this;
  }
  
  public A addToRemoteIpBlocks(String... items) {
    if (this.remoteIpBlocks == null) {
      this.remoteIpBlocks = new ArrayList();
    }
    for (String item : items) {
      this.remoteIpBlocks.add(item);
    }
    return (A) this;
  }
  
  public A addToRemoteIpBlocks(int index,String item) {
    if (this.remoteIpBlocks == null) {
      this.remoteIpBlocks = new ArrayList();
    }
    this.remoteIpBlocks.add(index, item);
    return (A) this;
  }
  
  public A addToRequestPrincipals(String... items) {
    if (this.requestPrincipals == null) {
      this.requestPrincipals = new ArrayList();
    }
    for (String item : items) {
      this.requestPrincipals.add(item);
    }
    return (A) this;
  }
  
  public A addToRequestPrincipals(int index,String item) {
    if (this.requestPrincipals == null) {
      this.requestPrincipals = new ArrayList();
    }
    this.requestPrincipals.add(index, item);
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
  
  public A addToTrustDomains(String... items) {
    if (this.trustDomains == null) {
      this.trustDomains = new ArrayList();
    }
    for (String item : items) {
      this.trustDomains.add(item);
    }
    return (A) this;
  }
  
  public A addToTrustDomains(int index,String item) {
    if (this.trustDomains == null) {
      this.trustDomains = new ArrayList();
    }
    this.trustDomains.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Source instance) {
    instance = instance != null ? instance : new Source();
    if (instance != null) {
        this.withIpBlocks(instance.getIpBlocks());
        this.withNamespaces(instance.getNamespaces());
        this.withNotIpBlocks(instance.getNotIpBlocks());
        this.withNotNamespaces(instance.getNotNamespaces());
        this.withNotPrincipals(instance.getNotPrincipals());
        this.withNotRemoteIpBlocks(instance.getNotRemoteIpBlocks());
        this.withNotRequestPrincipals(instance.getNotRequestPrincipals());
        this.withNotServiceAccounts(instance.getNotServiceAccounts());
        this.withNotTrustDomains(instance.getNotTrustDomains());
        this.withPrincipals(instance.getPrincipals());
        this.withRemoteIpBlocks(instance.getRemoteIpBlocks());
        this.withRequestPrincipals(instance.getRequestPrincipals());
        this.withServiceAccounts(instance.getServiceAccounts());
        this.withTrustDomains(instance.getTrustDomains());
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
    SourceFluent that = (SourceFluent) o;
    if (!(Objects.equals(ipBlocks, that.ipBlocks))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(notIpBlocks, that.notIpBlocks))) {
      return false;
    }
    if (!(Objects.equals(notNamespaces, that.notNamespaces))) {
      return false;
    }
    if (!(Objects.equals(notPrincipals, that.notPrincipals))) {
      return false;
    }
    if (!(Objects.equals(notRemoteIpBlocks, that.notRemoteIpBlocks))) {
      return false;
    }
    if (!(Objects.equals(notRequestPrincipals, that.notRequestPrincipals))) {
      return false;
    }
    if (!(Objects.equals(notServiceAccounts, that.notServiceAccounts))) {
      return false;
    }
    if (!(Objects.equals(notTrustDomains, that.notTrustDomains))) {
      return false;
    }
    if (!(Objects.equals(principals, that.principals))) {
      return false;
    }
    if (!(Objects.equals(remoteIpBlocks, that.remoteIpBlocks))) {
      return false;
    }
    if (!(Objects.equals(requestPrincipals, that.requestPrincipals))) {
      return false;
    }
    if (!(Objects.equals(serviceAccounts, that.serviceAccounts))) {
      return false;
    }
    if (!(Objects.equals(trustDomains, that.trustDomains))) {
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
  
  public String getFirstIpBlock() {
    return this.ipBlocks.get(0);
  }
  
  public String getFirstNamespace() {
    return this.namespaces.get(0);
  }
  
  public String getFirstNotIpBlock() {
    return this.notIpBlocks.get(0);
  }
  
  public String getFirstNotNamespace() {
    return this.notNamespaces.get(0);
  }
  
  public String getFirstNotPrincipal() {
    return this.notPrincipals.get(0);
  }
  
  public String getFirstNotRemoteIpBlock() {
    return this.notRemoteIpBlocks.get(0);
  }
  
  public String getFirstNotRequestPrincipal() {
    return this.notRequestPrincipals.get(0);
  }
  
  public String getFirstNotServiceAccount() {
    return this.notServiceAccounts.get(0);
  }
  
  public String getFirstNotTrustDomain() {
    return this.notTrustDomains.get(0);
  }
  
  public String getFirstPrincipal() {
    return this.principals.get(0);
  }
  
  public String getFirstRemoteIpBlock() {
    return this.remoteIpBlocks.get(0);
  }
  
  public String getFirstRequestPrincipal() {
    return this.requestPrincipals.get(0);
  }
  
  public String getFirstServiceAccount() {
    return this.serviceAccounts.get(0);
  }
  
  public String getFirstTrustDomain() {
    return this.trustDomains.get(0);
  }
  
  public String getIpBlock(int index) {
    return this.ipBlocks.get(index);
  }
  
  public List<String> getIpBlocks() {
    return this.ipBlocks;
  }
  
  public String getLastIpBlock() {
    return this.ipBlocks.get(ipBlocks.size() - 1);
  }
  
  public String getLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1);
  }
  
  public String getLastNotIpBlock() {
    return this.notIpBlocks.get(notIpBlocks.size() - 1);
  }
  
  public String getLastNotNamespace() {
    return this.notNamespaces.get(notNamespaces.size() - 1);
  }
  
  public String getLastNotPrincipal() {
    return this.notPrincipals.get(notPrincipals.size() - 1);
  }
  
  public String getLastNotRemoteIpBlock() {
    return this.notRemoteIpBlocks.get(notRemoteIpBlocks.size() - 1);
  }
  
  public String getLastNotRequestPrincipal() {
    return this.notRequestPrincipals.get(notRequestPrincipals.size() - 1);
  }
  
  public String getLastNotServiceAccount() {
    return this.notServiceAccounts.get(notServiceAccounts.size() - 1);
  }
  
  public String getLastNotTrustDomain() {
    return this.notTrustDomains.get(notTrustDomains.size() - 1);
  }
  
  public String getLastPrincipal() {
    return this.principals.get(principals.size() - 1);
  }
  
  public String getLastRemoteIpBlock() {
    return this.remoteIpBlocks.get(remoteIpBlocks.size() - 1);
  }
  
  public String getLastRequestPrincipal() {
    return this.requestPrincipals.get(requestPrincipals.size() - 1);
  }
  
  public String getLastServiceAccount() {
    return this.serviceAccounts.get(serviceAccounts.size() - 1);
  }
  
  public String getLastTrustDomain() {
    return this.trustDomains.get(trustDomains.size() - 1);
  }
  
  public String getMatchingIpBlock(Predicate<String> predicate) {
      for (String item : ipBlocks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotIpBlock(Predicate<String> predicate) {
      for (String item : notIpBlocks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotNamespace(Predicate<String> predicate) {
      for (String item : notNamespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotPrincipal(Predicate<String> predicate) {
      for (String item : notPrincipals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotRemoteIpBlock(Predicate<String> predicate) {
      for (String item : notRemoteIpBlocks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotRequestPrincipal(Predicate<String> predicate) {
      for (String item : notRequestPrincipals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotServiceAccount(Predicate<String> predicate) {
      for (String item : notServiceAccounts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotTrustDomain(Predicate<String> predicate) {
      for (String item : notTrustDomains) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPrincipal(Predicate<String> predicate) {
      for (String item : principals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRemoteIpBlock(Predicate<String> predicate) {
      for (String item : remoteIpBlocks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRequestPrincipal(Predicate<String> predicate) {
      for (String item : requestPrincipals) {
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
  
  public String getMatchingTrustDomain(Predicate<String> predicate) {
      for (String item : trustDomains) {
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
  
  public String getNotIpBlock(int index) {
    return this.notIpBlocks.get(index);
  }
  
  public List<String> getNotIpBlocks() {
    return this.notIpBlocks;
  }
  
  public String getNotNamespace(int index) {
    return this.notNamespaces.get(index);
  }
  
  public List<String> getNotNamespaces() {
    return this.notNamespaces;
  }
  
  public String getNotPrincipal(int index) {
    return this.notPrincipals.get(index);
  }
  
  public List<String> getNotPrincipals() {
    return this.notPrincipals;
  }
  
  public String getNotRemoteIpBlock(int index) {
    return this.notRemoteIpBlocks.get(index);
  }
  
  public List<String> getNotRemoteIpBlocks() {
    return this.notRemoteIpBlocks;
  }
  
  public String getNotRequestPrincipal(int index) {
    return this.notRequestPrincipals.get(index);
  }
  
  public List<String> getNotRequestPrincipals() {
    return this.notRequestPrincipals;
  }
  
  public String getNotServiceAccount(int index) {
    return this.notServiceAccounts.get(index);
  }
  
  public List<String> getNotServiceAccounts() {
    return this.notServiceAccounts;
  }
  
  public String getNotTrustDomain(int index) {
    return this.notTrustDomains.get(index);
  }
  
  public List<String> getNotTrustDomains() {
    return this.notTrustDomains;
  }
  
  public String getPrincipal(int index) {
    return this.principals.get(index);
  }
  
  public List<String> getPrincipals() {
    return this.principals;
  }
  
  public String getRemoteIpBlock(int index) {
    return this.remoteIpBlocks.get(index);
  }
  
  public List<String> getRemoteIpBlocks() {
    return this.remoteIpBlocks;
  }
  
  public String getRequestPrincipal(int index) {
    return this.requestPrincipals.get(index);
  }
  
  public List<String> getRequestPrincipals() {
    return this.requestPrincipals;
  }
  
  public String getServiceAccount(int index) {
    return this.serviceAccounts.get(index);
  }
  
  public List<String> getServiceAccounts() {
    return this.serviceAccounts;
  }
  
  public String getTrustDomain(int index) {
    return this.trustDomains.get(index);
  }
  
  public List<String> getTrustDomains() {
    return this.trustDomains;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpBlocks() {
    return this.ipBlocks != null && !(this.ipBlocks.isEmpty());
  }
  
  public boolean hasMatchingIpBlock(Predicate<String> predicate) {
      for (String item : ipBlocks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNamespace(Predicate<String> predicate) {
      for (String item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotIpBlock(Predicate<String> predicate) {
      for (String item : notIpBlocks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotNamespace(Predicate<String> predicate) {
      for (String item : notNamespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotPrincipal(Predicate<String> predicate) {
      for (String item : notPrincipals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotRemoteIpBlock(Predicate<String> predicate) {
      for (String item : notRemoteIpBlocks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotRequestPrincipal(Predicate<String> predicate) {
      for (String item : notRequestPrincipals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotServiceAccount(Predicate<String> predicate) {
      for (String item : notServiceAccounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotTrustDomain(Predicate<String> predicate) {
      for (String item : notTrustDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrincipal(Predicate<String> predicate) {
      for (String item : principals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRemoteIpBlock(Predicate<String> predicate) {
      for (String item : remoteIpBlocks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequestPrincipal(Predicate<String> predicate) {
      for (String item : requestPrincipals) {
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
  
  public boolean hasMatchingTrustDomain(Predicate<String> predicate) {
      for (String item : trustDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasNotIpBlocks() {
    return this.notIpBlocks != null && !(this.notIpBlocks.isEmpty());
  }
  
  public boolean hasNotNamespaces() {
    return this.notNamespaces != null && !(this.notNamespaces.isEmpty());
  }
  
  public boolean hasNotPrincipals() {
    return this.notPrincipals != null && !(this.notPrincipals.isEmpty());
  }
  
  public boolean hasNotRemoteIpBlocks() {
    return this.notRemoteIpBlocks != null && !(this.notRemoteIpBlocks.isEmpty());
  }
  
  public boolean hasNotRequestPrincipals() {
    return this.notRequestPrincipals != null && !(this.notRequestPrincipals.isEmpty());
  }
  
  public boolean hasNotServiceAccounts() {
    return this.notServiceAccounts != null && !(this.notServiceAccounts.isEmpty());
  }
  
  public boolean hasNotTrustDomains() {
    return this.notTrustDomains != null && !(this.notTrustDomains.isEmpty());
  }
  
  public boolean hasPrincipals() {
    return this.principals != null && !(this.principals.isEmpty());
  }
  
  public boolean hasRemoteIpBlocks() {
    return this.remoteIpBlocks != null && !(this.remoteIpBlocks.isEmpty());
  }
  
  public boolean hasRequestPrincipals() {
    return this.requestPrincipals != null && !(this.requestPrincipals.isEmpty());
  }
  
  public boolean hasServiceAccounts() {
    return this.serviceAccounts != null && !(this.serviceAccounts.isEmpty());
  }
  
  public boolean hasTrustDomains() {
    return this.trustDomains != null && !(this.trustDomains.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ipBlocks, namespaces, notIpBlocks, notNamespaces, notPrincipals, notRemoteIpBlocks, notRequestPrincipals, notServiceAccounts, notTrustDomains, principals, remoteIpBlocks, requestPrincipals, serviceAccounts, trustDomains, additionalProperties);
  }
  
  public A removeAllFromIpBlocks(Collection<String> items) {
    if (this.ipBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipBlocks.remove(item);
    }
    return (A) this;
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
  
  public A removeAllFromNotIpBlocks(Collection<String> items) {
    if (this.notIpBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notIpBlocks.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotNamespaces(Collection<String> items) {
    if (this.notNamespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notNamespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotPrincipals(Collection<String> items) {
    if (this.notPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notPrincipals.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotRemoteIpBlocks(Collection<String> items) {
    if (this.notRemoteIpBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notRemoteIpBlocks.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotRequestPrincipals(Collection<String> items) {
    if (this.notRequestPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notRequestPrincipals.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotServiceAccounts(Collection<String> items) {
    if (this.notServiceAccounts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notServiceAccounts.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotTrustDomains(Collection<String> items) {
    if (this.notTrustDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notTrustDomains.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPrincipals(Collection<String> items) {
    if (this.principals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.principals.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRemoteIpBlocks(Collection<String> items) {
    if (this.remoteIpBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remoteIpBlocks.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRequestPrincipals(Collection<String> items) {
    if (this.requestPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requestPrincipals.remove(item);
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
  
  public A removeAllFromTrustDomains(Collection<String> items) {
    if (this.trustDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.trustDomains.remove(item);
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
  
  public A removeFromIpBlocks(String... items) {
    if (this.ipBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipBlocks.remove(item);
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
  
  public A removeFromNotIpBlocks(String... items) {
    if (this.notIpBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notIpBlocks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotNamespaces(String... items) {
    if (this.notNamespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notNamespaces.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotPrincipals(String... items) {
    if (this.notPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notPrincipals.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotRemoteIpBlocks(String... items) {
    if (this.notRemoteIpBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notRemoteIpBlocks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotRequestPrincipals(String... items) {
    if (this.notRequestPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notRequestPrincipals.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotServiceAccounts(String... items) {
    if (this.notServiceAccounts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notServiceAccounts.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotTrustDomains(String... items) {
    if (this.notTrustDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notTrustDomains.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPrincipals(String... items) {
    if (this.principals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.principals.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRemoteIpBlocks(String... items) {
    if (this.remoteIpBlocks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remoteIpBlocks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRequestPrincipals(String... items) {
    if (this.requestPrincipals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.requestPrincipals.remove(item);
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
  
  public A removeFromTrustDomains(String... items) {
    if (this.trustDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.trustDomains.remove(item);
    }
    return (A) this;
  }
  
  public A setToIpBlocks(int index,String item) {
    if (this.ipBlocks == null) {
      this.ipBlocks = new ArrayList();
    }
    this.ipBlocks.set(index, item);
    return (A) this;
  }
  
  public A setToNamespaces(int index,String item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    this.namespaces.set(index, item);
    return (A) this;
  }
  
  public A setToNotIpBlocks(int index,String item) {
    if (this.notIpBlocks == null) {
      this.notIpBlocks = new ArrayList();
    }
    this.notIpBlocks.set(index, item);
    return (A) this;
  }
  
  public A setToNotNamespaces(int index,String item) {
    if (this.notNamespaces == null) {
      this.notNamespaces = new ArrayList();
    }
    this.notNamespaces.set(index, item);
    return (A) this;
  }
  
  public A setToNotPrincipals(int index,String item) {
    if (this.notPrincipals == null) {
      this.notPrincipals = new ArrayList();
    }
    this.notPrincipals.set(index, item);
    return (A) this;
  }
  
  public A setToNotRemoteIpBlocks(int index,String item) {
    if (this.notRemoteIpBlocks == null) {
      this.notRemoteIpBlocks = new ArrayList();
    }
    this.notRemoteIpBlocks.set(index, item);
    return (A) this;
  }
  
  public A setToNotRequestPrincipals(int index,String item) {
    if (this.notRequestPrincipals == null) {
      this.notRequestPrincipals = new ArrayList();
    }
    this.notRequestPrincipals.set(index, item);
    return (A) this;
  }
  
  public A setToNotServiceAccounts(int index,String item) {
    if (this.notServiceAccounts == null) {
      this.notServiceAccounts = new ArrayList();
    }
    this.notServiceAccounts.set(index, item);
    return (A) this;
  }
  
  public A setToNotTrustDomains(int index,String item) {
    if (this.notTrustDomains == null) {
      this.notTrustDomains = new ArrayList();
    }
    this.notTrustDomains.set(index, item);
    return (A) this;
  }
  
  public A setToPrincipals(int index,String item) {
    if (this.principals == null) {
      this.principals = new ArrayList();
    }
    this.principals.set(index, item);
    return (A) this;
  }
  
  public A setToRemoteIpBlocks(int index,String item) {
    if (this.remoteIpBlocks == null) {
      this.remoteIpBlocks = new ArrayList();
    }
    this.remoteIpBlocks.set(index, item);
    return (A) this;
  }
  
  public A setToRequestPrincipals(int index,String item) {
    if (this.requestPrincipals == null) {
      this.requestPrincipals = new ArrayList();
    }
    this.requestPrincipals.set(index, item);
    return (A) this;
  }
  
  public A setToServiceAccounts(int index,String item) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList();
    }
    this.serviceAccounts.set(index, item);
    return (A) this;
  }
  
  public A setToTrustDomains(int index,String item) {
    if (this.trustDomains == null) {
      this.trustDomains = new ArrayList();
    }
    this.trustDomains.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ipBlocks == null) && !(ipBlocks.isEmpty())) {
        sb.append("ipBlocks:");
        sb.append(ipBlocks);
        sb.append(",");
    }
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(notIpBlocks == null) && !(notIpBlocks.isEmpty())) {
        sb.append("notIpBlocks:");
        sb.append(notIpBlocks);
        sb.append(",");
    }
    if (!(notNamespaces == null) && !(notNamespaces.isEmpty())) {
        sb.append("notNamespaces:");
        sb.append(notNamespaces);
        sb.append(",");
    }
    if (!(notPrincipals == null) && !(notPrincipals.isEmpty())) {
        sb.append("notPrincipals:");
        sb.append(notPrincipals);
        sb.append(",");
    }
    if (!(notRemoteIpBlocks == null) && !(notRemoteIpBlocks.isEmpty())) {
        sb.append("notRemoteIpBlocks:");
        sb.append(notRemoteIpBlocks);
        sb.append(",");
    }
    if (!(notRequestPrincipals == null) && !(notRequestPrincipals.isEmpty())) {
        sb.append("notRequestPrincipals:");
        sb.append(notRequestPrincipals);
        sb.append(",");
    }
    if (!(notServiceAccounts == null) && !(notServiceAccounts.isEmpty())) {
        sb.append("notServiceAccounts:");
        sb.append(notServiceAccounts);
        sb.append(",");
    }
    if (!(notTrustDomains == null) && !(notTrustDomains.isEmpty())) {
        sb.append("notTrustDomains:");
        sb.append(notTrustDomains);
        sb.append(",");
    }
    if (!(principals == null) && !(principals.isEmpty())) {
        sb.append("principals:");
        sb.append(principals);
        sb.append(",");
    }
    if (!(remoteIpBlocks == null) && !(remoteIpBlocks.isEmpty())) {
        sb.append("remoteIpBlocks:");
        sb.append(remoteIpBlocks);
        sb.append(",");
    }
    if (!(requestPrincipals == null) && !(requestPrincipals.isEmpty())) {
        sb.append("requestPrincipals:");
        sb.append(requestPrincipals);
        sb.append(",");
    }
    if (!(serviceAccounts == null) && !(serviceAccounts.isEmpty())) {
        sb.append("serviceAccounts:");
        sb.append(serviceAccounts);
        sb.append(",");
    }
    if (!(trustDomains == null) && !(trustDomains.isEmpty())) {
        sb.append("trustDomains:");
        sb.append(trustDomains);
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
  
  public A withIpBlocks(List<String> ipBlocks) {
    if (ipBlocks != null) {
        this.ipBlocks = new ArrayList();
        for (String item : ipBlocks) {
          this.addToIpBlocks(item);
        }
    } else {
      this.ipBlocks = null;
    }
    return (A) this;
  }
  
  public A withIpBlocks(String... ipBlocks) {
    if (this.ipBlocks != null) {
        this.ipBlocks.clear();
        _visitables.remove("ipBlocks");
    }
    if (ipBlocks != null) {
      for (String item : ipBlocks) {
        this.addToIpBlocks(item);
      }
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
  
  public A withNotIpBlocks(List<String> notIpBlocks) {
    if (notIpBlocks != null) {
        this.notIpBlocks = new ArrayList();
        for (String item : notIpBlocks) {
          this.addToNotIpBlocks(item);
        }
    } else {
      this.notIpBlocks = null;
    }
    return (A) this;
  }
  
  public A withNotIpBlocks(String... notIpBlocks) {
    if (this.notIpBlocks != null) {
        this.notIpBlocks.clear();
        _visitables.remove("notIpBlocks");
    }
    if (notIpBlocks != null) {
      for (String item : notIpBlocks) {
        this.addToNotIpBlocks(item);
      }
    }
    return (A) this;
  }
  
  public A withNotNamespaces(List<String> notNamespaces) {
    if (notNamespaces != null) {
        this.notNamespaces = new ArrayList();
        for (String item : notNamespaces) {
          this.addToNotNamespaces(item);
        }
    } else {
      this.notNamespaces = null;
    }
    return (A) this;
  }
  
  public A withNotNamespaces(String... notNamespaces) {
    if (this.notNamespaces != null) {
        this.notNamespaces.clear();
        _visitables.remove("notNamespaces");
    }
    if (notNamespaces != null) {
      for (String item : notNamespaces) {
        this.addToNotNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public A withNotPrincipals(List<String> notPrincipals) {
    if (notPrincipals != null) {
        this.notPrincipals = new ArrayList();
        for (String item : notPrincipals) {
          this.addToNotPrincipals(item);
        }
    } else {
      this.notPrincipals = null;
    }
    return (A) this;
  }
  
  public A withNotPrincipals(String... notPrincipals) {
    if (this.notPrincipals != null) {
        this.notPrincipals.clear();
        _visitables.remove("notPrincipals");
    }
    if (notPrincipals != null) {
      for (String item : notPrincipals) {
        this.addToNotPrincipals(item);
      }
    }
    return (A) this;
  }
  
  public A withNotRemoteIpBlocks(List<String> notRemoteIpBlocks) {
    if (notRemoteIpBlocks != null) {
        this.notRemoteIpBlocks = new ArrayList();
        for (String item : notRemoteIpBlocks) {
          this.addToNotRemoteIpBlocks(item);
        }
    } else {
      this.notRemoteIpBlocks = null;
    }
    return (A) this;
  }
  
  public A withNotRemoteIpBlocks(String... notRemoteIpBlocks) {
    if (this.notRemoteIpBlocks != null) {
        this.notRemoteIpBlocks.clear();
        _visitables.remove("notRemoteIpBlocks");
    }
    if (notRemoteIpBlocks != null) {
      for (String item : notRemoteIpBlocks) {
        this.addToNotRemoteIpBlocks(item);
      }
    }
    return (A) this;
  }
  
  public A withNotRequestPrincipals(List<String> notRequestPrincipals) {
    if (notRequestPrincipals != null) {
        this.notRequestPrincipals = new ArrayList();
        for (String item : notRequestPrincipals) {
          this.addToNotRequestPrincipals(item);
        }
    } else {
      this.notRequestPrincipals = null;
    }
    return (A) this;
  }
  
  public A withNotRequestPrincipals(String... notRequestPrincipals) {
    if (this.notRequestPrincipals != null) {
        this.notRequestPrincipals.clear();
        _visitables.remove("notRequestPrincipals");
    }
    if (notRequestPrincipals != null) {
      for (String item : notRequestPrincipals) {
        this.addToNotRequestPrincipals(item);
      }
    }
    return (A) this;
  }
  
  public A withNotServiceAccounts(List<String> notServiceAccounts) {
    if (notServiceAccounts != null) {
        this.notServiceAccounts = new ArrayList();
        for (String item : notServiceAccounts) {
          this.addToNotServiceAccounts(item);
        }
    } else {
      this.notServiceAccounts = null;
    }
    return (A) this;
  }
  
  public A withNotServiceAccounts(String... notServiceAccounts) {
    if (this.notServiceAccounts != null) {
        this.notServiceAccounts.clear();
        _visitables.remove("notServiceAccounts");
    }
    if (notServiceAccounts != null) {
      for (String item : notServiceAccounts) {
        this.addToNotServiceAccounts(item);
      }
    }
    return (A) this;
  }
  
  public A withNotTrustDomains(List<String> notTrustDomains) {
    if (notTrustDomains != null) {
        this.notTrustDomains = new ArrayList();
        for (String item : notTrustDomains) {
          this.addToNotTrustDomains(item);
        }
    } else {
      this.notTrustDomains = null;
    }
    return (A) this;
  }
  
  public A withNotTrustDomains(String... notTrustDomains) {
    if (this.notTrustDomains != null) {
        this.notTrustDomains.clear();
        _visitables.remove("notTrustDomains");
    }
    if (notTrustDomains != null) {
      for (String item : notTrustDomains) {
        this.addToNotTrustDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withPrincipals(List<String> principals) {
    if (principals != null) {
        this.principals = new ArrayList();
        for (String item : principals) {
          this.addToPrincipals(item);
        }
    } else {
      this.principals = null;
    }
    return (A) this;
  }
  
  public A withPrincipals(String... principals) {
    if (this.principals != null) {
        this.principals.clear();
        _visitables.remove("principals");
    }
    if (principals != null) {
      for (String item : principals) {
        this.addToPrincipals(item);
      }
    }
    return (A) this;
  }
  
  public A withRemoteIpBlocks(List<String> remoteIpBlocks) {
    if (remoteIpBlocks != null) {
        this.remoteIpBlocks = new ArrayList();
        for (String item : remoteIpBlocks) {
          this.addToRemoteIpBlocks(item);
        }
    } else {
      this.remoteIpBlocks = null;
    }
    return (A) this;
  }
  
  public A withRemoteIpBlocks(String... remoteIpBlocks) {
    if (this.remoteIpBlocks != null) {
        this.remoteIpBlocks.clear();
        _visitables.remove("remoteIpBlocks");
    }
    if (remoteIpBlocks != null) {
      for (String item : remoteIpBlocks) {
        this.addToRemoteIpBlocks(item);
      }
    }
    return (A) this;
  }
  
  public A withRequestPrincipals(List<String> requestPrincipals) {
    if (requestPrincipals != null) {
        this.requestPrincipals = new ArrayList();
        for (String item : requestPrincipals) {
          this.addToRequestPrincipals(item);
        }
    } else {
      this.requestPrincipals = null;
    }
    return (A) this;
  }
  
  public A withRequestPrincipals(String... requestPrincipals) {
    if (this.requestPrincipals != null) {
        this.requestPrincipals.clear();
        _visitables.remove("requestPrincipals");
    }
    if (requestPrincipals != null) {
      for (String item : requestPrincipals) {
        this.addToRequestPrincipals(item);
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
  
  public A withTrustDomains(List<String> trustDomains) {
    if (trustDomains != null) {
        this.trustDomains = new ArrayList();
        for (String item : trustDomains) {
          this.addToTrustDomains(item);
        }
    } else {
      this.trustDomains = null;
    }
    return (A) this;
  }
  
  public A withTrustDomains(String... trustDomains) {
    if (this.trustDomains != null) {
        this.trustDomains.clear();
        _visitables.remove("trustDomains");
    }
    if (trustDomains != null) {
      for (String item : trustDomains) {
        this.addToTrustDomains(item);
      }
    }
    return (A) this;
  }
  
}