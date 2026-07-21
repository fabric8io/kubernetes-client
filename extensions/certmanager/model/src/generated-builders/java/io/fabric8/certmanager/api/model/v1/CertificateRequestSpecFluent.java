package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceBuilder;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Duration;
import java.lang.Boolean;
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
public class CertificateRequestSpecFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateRequestSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Duration duration;
  private Map<String,List<String>> extra;
  private List<String> groups = new ArrayList<String>();
  private Boolean isCA;
  private IssuerReferenceBuilder issuerRef;
  private String request;
  private String uid;
  private List<String> usages = new ArrayList<String>();
  private String username;

  public CertificateRequestSpecFluent() {
  }
  
  public CertificateRequestSpecFluent(CertificateRequestSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToGroups(Collection<String> items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (String item : items) {
      this.groups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUsages(Collection<String> items) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    for (String item : items) {
      this.usages.add(item);
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
  
  public A addToExtra(Map<String,List<String>> map) {
    if (this.extra == null && map != null) {
      this.extra = new LinkedHashMap();
    }
    if (map != null) {
      this.extra.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExtra(String key,List<String> value) {
    if (this.extra == null && key != null && value != null) {
      this.extra = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.extra.put(key, value);
    }
    return (A) this;
  }
  
  public A addToGroups(String... items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (String item : items) {
      this.groups.add(item);
    }
    return (A) this;
  }
  
  public A addToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.add(index, item);
    return (A) this;
  }
  
  public A addToUsages(String... items) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    for (String item : items) {
      this.usages.add(item);
    }
    return (A) this;
  }
  
  public A addToUsages(int index,String item) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    this.usages.add(index, item);
    return (A) this;
  }
  
  public IssuerReference buildIssuerRef() {
    return this.issuerRef != null ? this.issuerRef.build() : null;
  }
  
  protected void copyInstance(CertificateRequestSpec instance) {
    instance = instance != null ? instance : new CertificateRequestSpec();
    if (instance != null) {
        this.withDuration(instance.getDuration());
        this.withExtra(instance.getExtra());
        this.withGroups(instance.getGroups());
        this.withIsCA(instance.getIsCA());
        this.withIssuerRef(instance.getIssuerRef());
        this.withRequest(instance.getRequest());
        this.withUid(instance.getUid());
        this.withUsages(instance.getUsages());
        this.withUsername(instance.getUsername());
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
    CertificateRequestSpecFluent that = (CertificateRequestSpecFluent) o;
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(extra, that.extra))) {
      return false;
    }
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(isCA, that.isCA))) {
      return false;
    }
    if (!(Objects.equals(issuerRef, that.issuerRef))) {
      return false;
    }
    if (!(Objects.equals(request, that.request))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
      return false;
    }
    if (!(Objects.equals(usages, that.usages))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public Duration getDuration() {
    return this.duration;
  }
  
  public Map<String,List<String>> getExtra() {
    return this.extra;
  }
  
  public String getFirstGroup() {
    return this.groups.get(0);
  }
  
  public String getFirstUsage() {
    return this.usages.get(0);
  }
  
  public String getGroup(int index) {
    return this.groups.get(index);
  }
  
  public List<String> getGroups() {
    return this.groups;
  }
  
  public Boolean getIsCA() {
    return this.isCA;
  }
  
  public String getLastGroup() {
    return this.groups.get(groups.size() - 1);
  }
  
  public String getLastUsage() {
    return this.usages.get(usages.size() - 1);
  }
  
  public String getMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUsage(Predicate<String> predicate) {
      for (String item : usages) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRequest() {
    return this.request;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public String getUsage(int index) {
    return this.usages.get(index);
  }
  
  public List<String> getUsages() {
    return this.usages;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasExtra() {
    return this.extra != null;
  }
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasIsCA() {
    return this.isCA != null;
  }
  
  public boolean hasIssuerRef() {
    return this.issuerRef != null;
  }
  
  public boolean hasMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUsage(Predicate<String> predicate) {
      for (String item : usages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequest() {
    return this.request != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public boolean hasUsages() {
    return this.usages != null && !(this.usages.isEmpty());
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(duration, extra, groups, isCA, issuerRef, request, uid, usages, username, additionalProperties);
  }
  
  public A removeAllFromGroups(Collection<String> items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUsages(Collection<String> items) {
    if (this.usages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.usages.remove(item);
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
  
  public A removeFromExtra(String key) {
    if (this.extra == null) {
      return (A) this;
    }
    if (key != null && this.extra != null) {
      this.extra.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExtra(Map<String,List<String>> map) {
    if (this.extra == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.extra != null) {
          this.extra.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromGroups(String... items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUsages(String... items) {
    if (this.usages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.usages.remove(item);
    }
    return (A) this;
  }
  
  public A setToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.set(index, item);
    return (A) this;
  }
  
  public A setToUsages(int index,String item) {
    if (this.usages == null) {
      this.usages = new ArrayList();
    }
    this.usages.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(extra == null) && !(extra.isEmpty())) {
        sb.append("extra:");
        sb.append(extra);
        sb.append(",");
    }
    if (!(groups == null) && !(groups.isEmpty())) {
        sb.append("groups:");
        sb.append(groups);
        sb.append(",");
    }
    if (!(isCA == null)) {
        sb.append("isCA:");
        sb.append(isCA);
        sb.append(",");
    }
    if (!(issuerRef == null)) {
        sb.append("issuerRef:");
        sb.append(issuerRef);
        sb.append(",");
    }
    if (!(request == null)) {
        sb.append("request:");
        sb.append(request);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
        sb.append(",");
    }
    if (!(usages == null) && !(usages.isEmpty())) {
        sb.append("usages:");
        sb.append(usages);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public A withDuration(Duration duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public <K,V>A withExtra(Map<String,List<String>> extra) {
    if (extra == null) {
      this.extra = null;
    } else {
      this.extra = new LinkedHashMap(extra);
    }
    return (A) this;
  }
  
  public A withGroups(List<String> groups) {
    if (groups != null) {
        this.groups = new ArrayList();
        for (String item : groups) {
          this.addToGroups(item);
        }
    } else {
      this.groups = null;
    }
    return (A) this;
  }
  
  public A withGroups(String... groups) {
    if (this.groups != null) {
        this.groups.clear();
        _visitables.remove("groups");
    }
    if (groups != null) {
      for (String item : groups) {
        this.addToGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withIsCA() {
    return withIsCA(true);
  }
  
  public A withIsCA(Boolean isCA) {
    this.isCA = isCA;
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
  
  public A withRequest(String request) {
    this.request = request;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
  public A withUsages(List<String> usages) {
    if (usages != null) {
        this.usages = new ArrayList();
        for (String item : usages) {
          this.addToUsages(item);
        }
    } else {
      this.usages = null;
    }
    return (A) this;
  }
  
  public A withUsages(String... usages) {
    if (this.usages != null) {
        this.usages.clear();
        _visitables.remove("usages");
    }
    if (usages != null) {
      for (String item : usages) {
        this.addToUsages(item);
      }
    }
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  public class IssuerRefNested<N> extends IssuerReferenceFluent<IssuerRefNested<N>> implements Nested<N>{
  
    IssuerReferenceBuilder builder;
  
    IssuerRefNested(IssuerReference item) {
      this.builder = new IssuerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateRequestSpecFluent.this.withIssuerRef(builder.build());
    }
    
    public N endIssuerRef() {
      return and();
    }
    
  }
}