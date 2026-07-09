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
public class ListenerTLSConfigFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerTLSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SecretObjectReferenceBuilder> certificateRefs = new ArrayList<SecretObjectReferenceBuilder>();
  private String mode;
  private Map<String,String> options;

  public ListenerTLSConfigFluent() {
  }
  
  public ListenerTLSConfigFluent(ListenerTLSConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCertificateRefs(Collection<SecretObjectReference> items) {
    if (this.certificateRefs == null) {
      this.certificateRefs = new ArrayList();
    }
    for (SecretObjectReference item : items) {
        SecretObjectReferenceBuilder builder = new SecretObjectReferenceBuilder(item);
        _visitables.get("certificateRefs").add(builder);
        this.certificateRefs.add(builder);
    }
    return (A) this;
  }
  
  public CertificateRefsNested<A> addNewCertificateRef() {
    return new CertificateRefsNested(-1, null);
  }
  
  public A addNewCertificateRef(String group,String kind,String name,String namespace) {
    return (A) this.addToCertificateRefs(new SecretObjectReference(group, kind, name, namespace));
  }
  
  public CertificateRefsNested<A> addNewCertificateRefLike(SecretObjectReference item) {
    return new CertificateRefsNested(-1, item);
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
  
  public A addToCertificateRefs(SecretObjectReference... items) {
    if (this.certificateRefs == null) {
      this.certificateRefs = new ArrayList();
    }
    for (SecretObjectReference item : items) {
        SecretObjectReferenceBuilder builder = new SecretObjectReferenceBuilder(item);
        _visitables.get("certificateRefs").add(builder);
        this.certificateRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToCertificateRefs(int index,SecretObjectReference item) {
    if (this.certificateRefs == null) {
      this.certificateRefs = new ArrayList();
    }
    SecretObjectReferenceBuilder builder = new SecretObjectReferenceBuilder(item);
    if (index < 0 || index >= certificateRefs.size()) {
        _visitables.get("certificateRefs").add(builder);
        certificateRefs.add(builder);
    } else {
        _visitables.get("certificateRefs").add(builder);
        certificateRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOptions(Map<String,String> map) {
    if (this.options == null && map != null) {
      this.options = new LinkedHashMap();
    }
    if (map != null) {
      this.options.putAll(map);
    }
    return (A) this;
  }
  
  public A addToOptions(String key,String value) {
    if (this.options == null && key != null && value != null) {
      this.options = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.options.put(key, value);
    }
    return (A) this;
  }
  
  public SecretObjectReference buildCertificateRef(int index) {
    return this.certificateRefs.get(index).build();
  }
  
  public List<SecretObjectReference> buildCertificateRefs() {
    return this.certificateRefs != null ? build(certificateRefs) : null;
  }
  
  public SecretObjectReference buildFirstCertificateRef() {
    return this.certificateRefs.get(0).build();
  }
  
  public SecretObjectReference buildLastCertificateRef() {
    return this.certificateRefs.get(certificateRefs.size() - 1).build();
  }
  
  public SecretObjectReference buildMatchingCertificateRef(Predicate<SecretObjectReferenceBuilder> predicate) {
      for (SecretObjectReferenceBuilder item : certificateRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ListenerTLSConfig instance) {
    instance = instance != null ? instance : new ListenerTLSConfig();
    if (instance != null) {
        this.withCertificateRefs(instance.getCertificateRefs());
        this.withMode(instance.getMode());
        this.withOptions(instance.getOptions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertificateRefsNested<A> editCertificateRef(int index) {
    if (certificateRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "certificateRefs"));
    }
    return this.setNewCertificateRefLike(index, this.buildCertificateRef(index));
  }
  
  public CertificateRefsNested<A> editFirstCertificateRef() {
    if (certificateRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "certificateRefs"));
    }
    return this.setNewCertificateRefLike(0, this.buildCertificateRef(0));
  }
  
  public CertificateRefsNested<A> editLastCertificateRef() {
    int index = certificateRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "certificateRefs"));
    }
    return this.setNewCertificateRefLike(index, this.buildCertificateRef(index));
  }
  
  public CertificateRefsNested<A> editMatchingCertificateRef(Predicate<SecretObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < certificateRefs.size();i++) {
      if (predicate.test(certificateRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "certificateRefs"));
    }
    return this.setNewCertificateRefLike(index, this.buildCertificateRef(index));
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
    ListenerTLSConfigFluent that = (ListenerTLSConfigFluent) o;
    if (!(Objects.equals(certificateRefs, that.certificateRefs))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public Map<String,String> getOptions() {
    return this.options;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificateRefs() {
    return this.certificateRefs != null && !(this.certificateRefs.isEmpty());
  }
  
  public boolean hasMatchingCertificateRef(Predicate<SecretObjectReferenceBuilder> predicate) {
      for (SecretObjectReferenceBuilder item : certificateRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificateRefs, mode, options, additionalProperties);
  }
  
  public A removeAllFromCertificateRefs(Collection<SecretObjectReference> items) {
    if (this.certificateRefs == null) {
      return (A) this;
    }
    for (SecretObjectReference item : items) {
        SecretObjectReferenceBuilder builder = new SecretObjectReferenceBuilder(item);
        _visitables.get("certificateRefs").remove(builder);
        this.certificateRefs.remove(builder);
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
  
  public A removeFromCertificateRefs(SecretObjectReference... items) {
    if (this.certificateRefs == null) {
      return (A) this;
    }
    for (SecretObjectReference item : items) {
        SecretObjectReferenceBuilder builder = new SecretObjectReferenceBuilder(item);
        _visitables.get("certificateRefs").remove(builder);
        this.certificateRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOptions(String key) {
    if (this.options == null) {
      return (A) this;
    }
    if (key != null && this.options != null) {
      this.options.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromOptions(Map<String,String> map) {
    if (this.options == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.options != null) {
          this.options.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromCertificateRefs(Predicate<SecretObjectReferenceBuilder> predicate) {
    if (certificateRefs == null) {
      return (A) this;
    }
    Iterator<SecretObjectReferenceBuilder> each = certificateRefs.iterator();
    List visitables = _visitables.get("certificateRefs");
    while (each.hasNext()) {
        SecretObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CertificateRefsNested<A> setNewCertificateRefLike(int index,SecretObjectReference item) {
    return new CertificateRefsNested(index, item);
  }
  
  public A setToCertificateRefs(int index,SecretObjectReference item) {
    if (this.certificateRefs == null) {
      this.certificateRefs = new ArrayList();
    }
    SecretObjectReferenceBuilder builder = new SecretObjectReferenceBuilder(item);
    if (index < 0 || index >= certificateRefs.size()) {
        _visitables.get("certificateRefs").add(builder);
        certificateRefs.add(builder);
    } else {
        _visitables.get("certificateRefs").add(builder);
        certificateRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certificateRefs == null) && !(certificateRefs.isEmpty())) {
        sb.append("certificateRefs:");
        sb.append(certificateRefs);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(options == null) && !(options.isEmpty())) {
        sb.append("options:");
        sb.append(options);
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
  
  public A withCertificateRefs(List<SecretObjectReference> certificateRefs) {
    if (this.certificateRefs != null) {
      this._visitables.get("certificateRefs").clear();
    }
    if (certificateRefs != null) {
        this.certificateRefs = new ArrayList();
        for (SecretObjectReference item : certificateRefs) {
          this.addToCertificateRefs(item);
        }
    } else {
      this.certificateRefs = null;
    }
    return (A) this;
  }
  
  public A withCertificateRefs(SecretObjectReference... certificateRefs) {
    if (this.certificateRefs != null) {
        this.certificateRefs.clear();
        _visitables.remove("certificateRefs");
    }
    if (certificateRefs != null) {
      for (SecretObjectReference item : certificateRefs) {
        this.addToCertificateRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public <K,V>A withOptions(Map<String,String> options) {
    if (options == null) {
      this.options = null;
    } else {
      this.options = new LinkedHashMap(options);
    }
    return (A) this;
  }
  public class CertificateRefsNested<N> extends SecretObjectReferenceFluent<CertificateRefsNested<N>> implements Nested<N>{
  
    SecretObjectReferenceBuilder builder;
    int index;
  
    CertificateRefsNested(int index,SecretObjectReference item) {
      this.index = index;
      this.builder = new SecretObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerTLSConfigFluent.this.setToCertificateRefs(index, builder.build());
    }
    
    public N endCertificateRef() {
      return and();
    }
    
  }
}