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
public class FrontendTLSValidationFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.FrontendTLSValidationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ObjectReferenceBuilder> caCertificateRefs = new ArrayList<ObjectReferenceBuilder>();
  private String mode;

  public FrontendTLSValidationFluent() {
  }
  
  public FrontendTLSValidationFluent(FrontendTLSValidation instance) {
    this.copyInstance(instance);
  }

  public A addAllToCaCertificateRefs(Collection<ObjectReference> items) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").add(builder);
        this.caCertificateRefs.add(builder);
    }
    return (A) this;
  }
  
  public CaCertificateRefsNested<A> addNewCaCertificateRef() {
    return new CaCertificateRefsNested(-1, null);
  }
  
  public A addNewCaCertificateRef(String group,String kind,String name,String namespace) {
    return (A) this.addToCaCertificateRefs(new ObjectReference(group, kind, name, namespace));
  }
  
  public CaCertificateRefsNested<A> addNewCaCertificateRefLike(ObjectReference item) {
    return new CaCertificateRefsNested(-1, item);
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
  
  public A addToCaCertificateRefs(ObjectReference... items) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").add(builder);
        this.caCertificateRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToCaCertificateRefs(int index,ObjectReference item) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= caCertificateRefs.size()) {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.add(builder);
    } else {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public ObjectReference buildCaCertificateRef(int index) {
    return this.caCertificateRefs.get(index).build();
  }
  
  public List<ObjectReference> buildCaCertificateRefs() {
    return this.caCertificateRefs != null ? build(caCertificateRefs) : null;
  }
  
  public ObjectReference buildFirstCaCertificateRef() {
    return this.caCertificateRefs.get(0).build();
  }
  
  public ObjectReference buildLastCaCertificateRef() {
    return this.caCertificateRefs.get(caCertificateRefs.size() - 1).build();
  }
  
  public ObjectReference buildMatchingCaCertificateRef(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : caCertificateRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(FrontendTLSValidation instance) {
    instance = instance != null ? instance : new FrontendTLSValidation();
    if (instance != null) {
        this.withCaCertificateRefs(instance.getCaCertificateRefs());
        this.withMode(instance.getMode());
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
  
  public CaCertificateRefsNested<A> editLastCaCertificateRef() {
    int index = caCertificateRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "caCertificateRefs"));
    }
    return this.setNewCaCertificateRefLike(index, this.buildCaCertificateRef(index));
  }
  
  public CaCertificateRefsNested<A> editMatchingCaCertificateRef(Predicate<ObjectReferenceBuilder> predicate) {
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
    FrontendTLSValidationFluent that = (FrontendTLSValidationFluent) o;
    if (!(Objects.equals(caCertificateRefs, that.caCertificateRefs))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCertificateRefs() {
    return this.caCertificateRefs != null && !(this.caCertificateRefs.isEmpty());
  }
  
  public boolean hasMatchingCaCertificateRef(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : caCertificateRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(caCertificateRefs, mode, additionalProperties);
  }
  
  public A removeAllFromCaCertificateRefs(Collection<ObjectReference> items) {
    if (this.caCertificateRefs == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").remove(builder);
        this.caCertificateRefs.remove(builder);
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
  
  public A removeFromCaCertificateRefs(ObjectReference... items) {
    if (this.caCertificateRefs == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("caCertificateRefs").remove(builder);
        this.caCertificateRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCaCertificateRefs(Predicate<ObjectReferenceBuilder> predicate) {
    if (caCertificateRefs == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = caCertificateRefs.iterator();
    List visitables = _visitables.get("caCertificateRefs");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CaCertificateRefsNested<A> setNewCaCertificateRefLike(int index,ObjectReference item) {
    return new CaCertificateRefsNested(index, item);
  }
  
  public A setToCaCertificateRefs(int index,ObjectReference item) {
    if (this.caCertificateRefs == null) {
      this.caCertificateRefs = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= caCertificateRefs.size()) {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.add(builder);
    } else {
        _visitables.get("caCertificateRefs").add(builder);
        caCertificateRefs.set(index, builder);
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
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withCaCertificateRefs(List<ObjectReference> caCertificateRefs) {
    if (this.caCertificateRefs != null) {
      this._visitables.get("caCertificateRefs").clear();
    }
    if (caCertificateRefs != null) {
        this.caCertificateRefs = new ArrayList();
        for (ObjectReference item : caCertificateRefs) {
          this.addToCaCertificateRefs(item);
        }
    } else {
      this.caCertificateRefs = null;
    }
    return (A) this;
  }
  
  public A withCaCertificateRefs(ObjectReference... caCertificateRefs) {
    if (this.caCertificateRefs != null) {
        this.caCertificateRefs.clear();
        _visitables.remove("caCertificateRefs");
    }
    if (caCertificateRefs != null) {
      for (ObjectReference item : caCertificateRefs) {
        this.addToCaCertificateRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  public class CaCertificateRefsNested<N> extends ObjectReferenceFluent<CaCertificateRefsNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    CaCertificateRefsNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) FrontendTLSValidationFluent.this.setToCaCertificateRefs(index, builder.build());
    }
    
    public N endCaCertificateRef() {
      return and();
    }
    
  }
}