package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceBuilder;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OrderSpecFluent<A extends io.fabric8.certmanager.api.model.acme.v1.OrderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String commonName;
  private List<String> dnsNames = new ArrayList<String>();
  private Duration duration;
  private List<String> ipAddresses = new ArrayList<String>();
  private IssuerReferenceBuilder issuerRef;
  private String profile;
  private String request;

  public OrderSpecFluent() {
  }
  
  public OrderSpecFluent(OrderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDnsNames(Collection<String> items) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    for (String item : items) {
      this.dnsNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIpAddresses(Collection<String> items) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    for (String item : items) {
      this.ipAddresses.add(item);
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
  
  public A addToDnsNames(String... items) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    for (String item : items) {
      this.dnsNames.add(item);
    }
    return (A) this;
  }
  
  public A addToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.add(index, item);
    return (A) this;
  }
  
  public A addToIpAddresses(String... items) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    for (String item : items) {
      this.ipAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addToIpAddresses(int index,String item) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    this.ipAddresses.add(index, item);
    return (A) this;
  }
  
  public IssuerReference buildIssuerRef() {
    return this.issuerRef != null ? this.issuerRef.build() : null;
  }
  
  protected void copyInstance(OrderSpec instance) {
    instance = instance != null ? instance : new OrderSpec();
    if (instance != null) {
        this.withCommonName(instance.getCommonName());
        this.withDnsNames(instance.getDnsNames());
        this.withDuration(instance.getDuration());
        this.withIpAddresses(instance.getIpAddresses());
        this.withIssuerRef(instance.getIssuerRef());
        this.withProfile(instance.getProfile());
        this.withRequest(instance.getRequest());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IssuerRefNested<A> editIssuerRef() {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(null));
  }
  
  public IssuerRefNested<A> editOrNewIssuerRef() {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(new IssuerReferenceBuilder().build()));
  }
  
  public IssuerRefNested<A> editOrNewIssuerRefLike(IssuerReference item) {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(item));
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
    OrderSpecFluent that = (OrderSpecFluent) o;
    if (!(Objects.equals(commonName, that.commonName))) {
      return false;
    }
    if (!(Objects.equals(dnsNames, that.dnsNames))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(ipAddresses, that.ipAddresses))) {
      return false;
    }
    if (!(Objects.equals(issuerRef, that.issuerRef))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(request, that.request))) {
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
  
  public String getCommonName() {
    return this.commonName;
  }
  
  public String getDnsName(int index) {
    return this.dnsNames.get(index);
  }
  
  public List<String> getDnsNames() {
    return this.dnsNames;
  }
  
  public Duration getDuration() {
    return this.duration;
  }
  
  public String getFirstDnsName() {
    return this.dnsNames.get(0);
  }
  
  public String getFirstIpAddress() {
    return this.ipAddresses.get(0);
  }
  
  public String getIpAddress(int index) {
    return this.ipAddresses.get(index);
  }
  
  public List<String> getIpAddresses() {
    return this.ipAddresses;
  }
  
  public String getLastDnsName() {
    return this.dnsNames.get(dnsNames.size() - 1);
  }
  
  public String getLastIpAddress() {
    return this.ipAddresses.get(ipAddresses.size() - 1);
  }
  
  public String getMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIpAddress(Predicate<String> predicate) {
      for (String item : ipAddresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getProfile() {
    return this.profile;
  }
  
  public String getRequest() {
    return this.request;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCommonName() {
    return this.commonName != null;
  }
  
  public boolean hasDnsNames() {
    return this.dnsNames != null && !(this.dnsNames.isEmpty());
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasIpAddresses() {
    return this.ipAddresses != null && !(this.ipAddresses.isEmpty());
  }
  
  public boolean hasIssuerRef() {
    return this.issuerRef != null;
  }
  
  public boolean hasMatchingDnsName(Predicate<String> predicate) {
      for (String item : dnsNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpAddress(Predicate<String> predicate) {
      for (String item : ipAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public boolean hasRequest() {
    return this.request != null;
  }
  
  public int hashCode() {
    return Objects.hash(commonName, dnsNames, duration, ipAddresses, issuerRef, profile, request, additionalProperties);
  }
  
  public A removeAllFromDnsNames(Collection<String> items) {
    if (this.dnsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIpAddresses(Collection<String> items) {
    if (this.ipAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddresses.remove(item);
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
  
  public A removeFromDnsNames(String... items) {
    if (this.dnsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.dnsNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIpAddresses(String... items) {
    if (this.ipAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A setToDnsNames(int index,String item) {
    if (this.dnsNames == null) {
      this.dnsNames = new ArrayList();
    }
    this.dnsNames.set(index, item);
    return (A) this;
  }
  
  public A setToIpAddresses(int index,String item) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList();
    }
    this.ipAddresses.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(commonName == null)) {
        sb.append("commonName:");
        sb.append(commonName);
        sb.append(",");
    }
    if (!(dnsNames == null) && !(dnsNames.isEmpty())) {
        sb.append("dnsNames:");
        sb.append(dnsNames);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(ipAddresses == null) && !(ipAddresses.isEmpty())) {
        sb.append("ipAddresses:");
        sb.append(ipAddresses);
        sb.append(",");
    }
    if (!(issuerRef == null)) {
        sb.append("issuerRef:");
        sb.append(issuerRef);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(request == null)) {
        sb.append("request:");
        sb.append(request);
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
  
  public A withCommonName(String commonName) {
    this.commonName = commonName;
    return (A) this;
  }
  
  public A withDnsNames(List<String> dnsNames) {
    if (dnsNames != null) {
        this.dnsNames = new ArrayList();
        for (String item : dnsNames) {
          this.addToDnsNames(item);
        }
    } else {
      this.dnsNames = null;
    }
    return (A) this;
  }
  
  public A withDnsNames(String... dnsNames) {
    if (this.dnsNames != null) {
        this.dnsNames.clear();
        _visitables.remove("dnsNames");
    }
    if (dnsNames != null) {
      for (String item : dnsNames) {
        this.addToDnsNames(item);
      }
    }
    return (A) this;
  }
  
  public A withDuration(Duration duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withIpAddresses(List<String> ipAddresses) {
    if (ipAddresses != null) {
        this.ipAddresses = new ArrayList();
        for (String item : ipAddresses) {
          this.addToIpAddresses(item);
        }
    } else {
      this.ipAddresses = null;
    }
    return (A) this;
  }
  
  public A withIpAddresses(String... ipAddresses) {
    if (this.ipAddresses != null) {
        this.ipAddresses.clear();
        _visitables.remove("ipAddresses");
    }
    if (ipAddresses != null) {
      for (String item : ipAddresses) {
        this.addToIpAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withIssuerRef(IssuerReference issuerRef) {
    this._visitables.remove("issuerRef");
    if (issuerRef != null) {
        this.issuerRef = new IssuerReferenceBuilder(issuerRef);
        this._visitables.get("issuerRef").add(this.issuerRef);
    } else {
        this.issuerRef = null;
        this._visitables.get("issuerRef").remove(this.issuerRef);
    }
    return (A) this;
  }
  
  public IssuerRefNested<A> withNewIssuerRef() {
    return new IssuerRefNested(null);
  }
  
  public A withNewIssuerRef(String group,String kind,String name) {
    return (A) this.withIssuerRef(new IssuerReference(group, kind, name));
  }
  
  public IssuerRefNested<A> withNewIssuerRefLike(IssuerReference item) {
    return new IssuerRefNested(item);
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  
  public A withRequest(String request) {
    this.request = request;
    return (A) this;
  }
  public class IssuerRefNested<N> extends IssuerReferenceFluent<IssuerRefNested<N>> implements Nested<N>{
  
    IssuerReferenceBuilder builder;
  
    IssuerRefNested(IssuerReference item) {
      this.builder = new IssuerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OrderSpecFluent.this.withIssuerRef(builder.build());
    }
    
    public N endIssuerRef() {
      return and();
    }
    
  }
}