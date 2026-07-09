package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class BackendTLSPolicyValidationFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.BackendTLSPolicyValidationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<LocalObjectReferenceBuilder> caCertificateRefs = new ArrayList<LocalObjectReferenceBuilder>();
  private String hostname;
  private ArrayList<SubjectAltNameBuilder> subjectAltNames = new ArrayList<SubjectAltNameBuilder>();
  private String wellKnownCACertificates;

  public BackendTLSPolicyValidationFluent() {
  }
  
  public BackendTLSPolicyValidationFluent(BackendTLSPolicyValidation instance) {
    this.copyInstance(instance);
  }

  public A addAllToCaCertificateRefs(Collection<LocalObjectReference> items) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").add(builder);
        this.caCertificateRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubjectAltNames(Collection<SubjectAltName> items) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    for (SubjectAltName item : items) {
        SubjectAltNameBuilder builder = new SubjectAltNameBuilder(item);
        _visitables.get("subjectAltNames").add(builder);
        this.subjectAltNames.add(builder);
    }
    return (A) this;
  }
  
  public CaCertificateRefsNested<A> addNewCaCertificateRef() {
    return new CaCertificateRefsNested(-1, null);
  }
  
  public A addNewCaCertificateRef(String group,String kind,String name) {
    return (A) this.addToCaCertificateRefs(new LocalObjectReference(group, kind, name));
  }
  
  public CaCertificateRefsNested<A> addNewCaCertificateRefLike(LocalObjectReference item) {
    return new CaCertificateRefsNested(-1, item);
  }
  
  public SubjectAltNamesNested<A> addNewSubjectAltName() {
    return new SubjectAltNamesNested(-1, null);
  }
  
  public A addNewSubjectAltName(String hostname,String type,String uri) {
    return (A) this.addToSubjectAltNames(new SubjectAltName(hostname, type, uri));
  }
  
  public SubjectAltNamesNested<A> addNewSubjectAltNameLike(SubjectAltName item) {
    return new SubjectAltNamesNested(-1, item);
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
  
  public A addToCaCertificateRefs(LocalObjectReference... items) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").add(builder);
        this.caCertificateRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToCaCertificateRefs(int index,LocalObjectReference item) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= caCertificateRefs.size()) {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.add(builder);
    } else {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubjectAltNames(SubjectAltName... items) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    for (SubjectAltName item : items) {
        SubjectAltNameBuilder builder = new SubjectAltNameBuilder(item);
        _visitables.get("subjectAltNames").add(builder);
        this.subjectAltNames.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubjectAltNames(int index,SubjectAltName item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    SubjectAltNameBuilder builder = new SubjectAltNameBuilder(item);
    if (index < 0 || index >= subjectAltNames.size()) {
        _visitables.get("subjectAltNames").add(builder);
        subjectAltNames.add(builder);
    } else {
        _visitables.get("subjectAltNames").add(builder);
        subjectAltNames.add(index, builder);
    }
    return (A) this;
  }
  
  public LocalObjectReference buildCaCertificateRef(int index) {
    return this.caCertificateRefs.get(index).build();
  }
  
  public List<LocalObjectReference> buildCaCertificateRefs() {
    return this.caCertificateRefs != null ? build(caCertificateRefs) : null;
  }
  
  public LocalObjectReference buildFirstCaCertificateRef() {
    return this.caCertificateRefs.get(0).build();
  }
  
  public SubjectAltName buildFirstSubjectAltName() {
    return this.subjectAltNames.get(0).build();
  }
  
  public LocalObjectReference buildLastCaCertificateRef() {
    return this.caCertificateRefs.get(caCertificateRefs.size() - 1).build();
  }
  
  public SubjectAltName buildLastSubjectAltName() {
    return this.subjectAltNames.get(subjectAltNames.size() - 1).build();
  }
  
  public LocalObjectReference buildMatchingCaCertificateRef(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : caCertificateRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubjectAltName buildMatchingSubjectAltName(Predicate<SubjectAltNameBuilder> predicate) {
      for (SubjectAltNameBuilder item : subjectAltNames) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubjectAltName buildSubjectAltName(int index) {
    return this.subjectAltNames.get(index).build();
  }
  
  public List<SubjectAltName> buildSubjectAltNames() {
    return this.subjectAltNames != null ? build(subjectAltNames) : null;
  }
  
  protected void copyInstance(BackendTLSPolicyValidation instance) {
    instance = instance != null ? instance : new BackendTLSPolicyValidation();
    if (instance != null) {
        this.withCaCertificateRefs(instance.getCaCertificateRefs());
        this.withHostname(instance.getHostname());
        this.withSubjectAltNames(instance.getSubjectAltNames());
        this.withWellKnownCACertificates(instance.getWellKnownCACertificates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaCertificateRefsNested<A> editCaCertificateRef(int index) {
    if (caCertificateRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "caCertificateRefs"));
    }
    return this.setNewCaCertificateRefLike(index, this.buildCaCertificateRef(index));
  }
  
  public CaCertificateRefsNested<A> editFirstCaCertificateRef() {
    if (caCertificateRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "caCertificateRefs"));
    }
    return this.setNewCaCertificateRefLike(0, this.buildCaCertificateRef(0));
  }
  
  public SubjectAltNamesNested<A> editFirstSubjectAltName() {
    if (subjectAltNames.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subjectAltNames"));
    }
    return this.setNewSubjectAltNameLike(0, this.buildSubjectAltName(0));
  }
  
  public CaCertificateRefsNested<A> editLastCaCertificateRef() {
    int index = caCertificateRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "caCertificateRefs"));
    }
    return this.setNewCaCertificateRefLike(index, this.buildCaCertificateRef(index));
  }
  
  public SubjectAltNamesNested<A> editLastSubjectAltName() {
    int index = subjectAltNames.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subjectAltNames"));
    }
    return this.setNewSubjectAltNameLike(index, this.buildSubjectAltName(index));
  }
  
  public CaCertificateRefsNested<A> editMatchingCaCertificateRef(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < caCertificateRefs.size();i++) {
      if (predicate.test(caCertificateRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "caCertificateRefs"));
    }
    return this.setNewCaCertificateRefLike(index, this.buildCaCertificateRef(index));
  }
  
  public SubjectAltNamesNested<A> editMatchingSubjectAltName(Predicate<SubjectAltNameBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subjectAltNames.size();i++) {
      if (predicate.test(subjectAltNames.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subjectAltNames"));
    }
    return this.setNewSubjectAltNameLike(index, this.buildSubjectAltName(index));
  }
  
  public SubjectAltNamesNested<A> editSubjectAltName(int index) {
    if (subjectAltNames.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subjectAltNames"));
    }
    return this.setNewSubjectAltNameLike(index, this.buildSubjectAltName(index));
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
    BackendTLSPolicyValidationFluent that = (BackendTLSPolicyValidationFluent) o;
    if (!(Objects.equals(caCertificateRefs, that.caCertificateRefs))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(subjectAltNames, that.subjectAltNames))) {
      return false;
    }
    if (!(Objects.equals(wellKnownCACertificates, that.wellKnownCACertificates))) {
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
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getWellKnownCACertificates() {
    return this.wellKnownCACertificates;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCertificateRefs() {
    return this.caCertificateRefs != null && !(this.caCertificateRefs.isEmpty());
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasMatchingCaCertificateRef(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : caCertificateRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubjectAltName(Predicate<SubjectAltNameBuilder> predicate) {
      for (SubjectAltNameBuilder item : subjectAltNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSubjectAltNames() {
    return this.subjectAltNames != null && !(this.subjectAltNames.isEmpty());
  }
  
  public boolean hasWellKnownCACertificates() {
    return this.wellKnownCACertificates != null;
  }
  
  public int hashCode() {
    return Objects.hash(caCertificateRefs, hostname, subjectAltNames, wellKnownCACertificates, additionalProperties);
  }
  
  public A removeAllFromCaCertificateRefs(Collection<LocalObjectReference> items) {
    if (this.caCertificateRefs == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").remove(builder);
        this.caCertificateRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubjectAltNames(Collection<SubjectAltName> items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (SubjectAltName item : items) {
        SubjectAltNameBuilder builder = new SubjectAltNameBuilder(item);
        _visitables.get("subjectAltNames").remove(builder);
        this.subjectAltNames.remove(builder);
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
  
  public A removeFromCaCertificateRefs(LocalObjectReference... items) {
    if (this.caCertificateRefs == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").remove(builder);
        this.caCertificateRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubjectAltNames(SubjectAltName... items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (SubjectAltName item : items) {
        SubjectAltNameBuilder builder = new SubjectAltNameBuilder(item);
        _visitables.get("subjectAltNames").remove(builder);
        this.subjectAltNames.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCaCertificateRefs(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (caCertificateRefs == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = caCertificateRefs.iterator();
    List visitables = _visitables.get("caCertificateRefs");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubjectAltNames(Predicate<SubjectAltNameBuilder> predicate) {
    if (subjectAltNames == null) {
      return (A) this;
    }
    Iterator<SubjectAltNameBuilder> each = subjectAltNames.iterator();
    List visitables = _visitables.get("subjectAltNames");
    while (each.hasNext()) {
        SubjectAltNameBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CaCertificateRefsNested<A> setNewCaCertificateRefLike(int index,LocalObjectReference item) {
    return new CaCertificateRefsNested(index, item);
  }
  
  public SubjectAltNamesNested<A> setNewSubjectAltNameLike(int index,SubjectAltName item) {
    return new SubjectAltNamesNested(index, item);
  }
  
  public A setToCaCertificateRefs(int index,LocalObjectReference item) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= caCertificateRefs.size()) {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.add(builder);
    } else {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubjectAltNames(int index,SubjectAltName item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    SubjectAltNameBuilder builder = new SubjectAltNameBuilder(item);
    if (index < 0 || index >= subjectAltNames.size()) {
        _visitables.get("subjectAltNames").add(builder);
        subjectAltNames.add(builder);
    } else {
        _visitables.get("subjectAltNames").add(builder);
        subjectAltNames.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(caCertificateRefs == null) && !(caCertificateRefs.isEmpty())) {
        sb.append("caCertificateRefs:");
        sb.append(caCertificateRefs);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(subjectAltNames == null) && !(subjectAltNames.isEmpty())) {
        sb.append("subjectAltNames:");
        sb.append(subjectAltNames);
        sb.append(",");
    }
    if (!(wellKnownCACertificates == null)) {
        sb.append("wellKnownCACertificates:");
        sb.append(wellKnownCACertificates);
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
  
  public A withCaCertificateRefs(List<LocalObjectReference> caCertificateRefs) {
    if (this.caCertificateRefs != null) {
      this._visitables.get("caCertificateRefs").clear();
    }
    if (caCertificateRefs != null) {
        this.caCertificateRefs = new ArrayList();
        for (LocalObjectReference item : caCertificateRefs) {
          this.addToCaCertificateRefs(item);
        }
    } else {
      this.caCertificateRefs = null;
    }
    return (A) this;
  }
  
  public A withCaCertificateRefs(LocalObjectReference... caCertificateRefs) {
    if (this.caCertificateRefs != null) {
        this.caCertificateRefs.clear();
        _visitables.remove("caCertificateRefs");
    }
    if (caCertificateRefs != null) {
      for (LocalObjectReference item : caCertificateRefs) {
        this.addToCaCertificateRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withSubjectAltNames(List<SubjectAltName> subjectAltNames) {
    if (this.subjectAltNames != null) {
      this._visitables.get("subjectAltNames").clear();
    }
    if (subjectAltNames != null) {
        this.subjectAltNames = new ArrayList();
        for (SubjectAltName item : subjectAltNames) {
          this.addToSubjectAltNames(item);
        }
    } else {
      this.subjectAltNames = null;
    }
    return (A) this;
  }
  
  public A withSubjectAltNames(SubjectAltName... subjectAltNames) {
    if (this.subjectAltNames != null) {
        this.subjectAltNames.clear();
        _visitables.remove("subjectAltNames");
    }
    if (subjectAltNames != null) {
      for (SubjectAltName item : subjectAltNames) {
        this.addToSubjectAltNames(item);
      }
    }
    return (A) this;
  }
  
  public A withWellKnownCACertificates(String wellKnownCACertificates) {
    this.wellKnownCACertificates = wellKnownCACertificates;
    return (A) this;
  }
  public class CaCertificateRefsNested<N> extends LocalObjectReferenceFluent<CaCertificateRefsNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    CaCertificateRefsNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BackendTLSPolicyValidationFluent.this.setToCaCertificateRefs(index, builder.build());
    }
    
    public N endCaCertificateRef() {
      return and();
    }
    
  }
  public class SubjectAltNamesNested<N> extends SubjectAltNameFluent<SubjectAltNamesNested<N>> implements Nested<N>{
  
    SubjectAltNameBuilder builder;
    int index;
  
    SubjectAltNamesNested(int index,SubjectAltName item) {
      this.index = index;
      this.builder = new SubjectAltNameBuilder(this, item);
    }
  
    public N and() {
      return (N) BackendTLSPolicyValidationFluent.this.setToSubjectAltNames(index, builder.build());
    }
    
    public N endSubjectAltName() {
      return and();
    }
    
  }
}