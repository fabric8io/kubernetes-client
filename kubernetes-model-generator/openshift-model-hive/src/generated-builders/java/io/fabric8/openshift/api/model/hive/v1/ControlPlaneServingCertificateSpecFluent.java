package io.fabric8.openshift.api.model.hive.v1;

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
public class ControlPlaneServingCertificateSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ControlPlaneServingCertificateSpecFluent<A>> extends BaseFluent<A>{

  private String _default;
  private ArrayList<ControlPlaneAdditionalCertificateBuilder> additional = new ArrayList<ControlPlaneAdditionalCertificateBuilder>();
  private Map<String,Object> additionalProperties;

  public ControlPlaneServingCertificateSpecFluent() {
  }
  
  public ControlPlaneServingCertificateSpecFluent(ControlPlaneServingCertificateSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditional(Collection<ControlPlaneAdditionalCertificate> items) {
    if (this.additional == null) {
      this.additional = new ArrayList();
    }
    for (ControlPlaneAdditionalCertificate item : items) {
        ControlPlaneAdditionalCertificateBuilder builder = new ControlPlaneAdditionalCertificateBuilder(item);
        _visitables.get("additional").add(builder);
        this.additional.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalNested<A> addNewAdditional() {
    return new AdditionalNested(-1, null);
  }
  
  public A addNewAdditional(String domain,String name) {
    return (A) this.addToAdditional(new ControlPlaneAdditionalCertificate(domain, name));
  }
  
  public AdditionalNested<A> addNewAdditionalLike(ControlPlaneAdditionalCertificate item) {
    return new AdditionalNested(-1, item);
  }
  
  public A addToAdditional(ControlPlaneAdditionalCertificate... items) {
    if (this.additional == null) {
      this.additional = new ArrayList();
    }
    for (ControlPlaneAdditionalCertificate item : items) {
        ControlPlaneAdditionalCertificateBuilder builder = new ControlPlaneAdditionalCertificateBuilder(item);
        _visitables.get("additional").add(builder);
        this.additional.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditional(int index,ControlPlaneAdditionalCertificate item) {
    if (this.additional == null) {
      this.additional = new ArrayList();
    }
    ControlPlaneAdditionalCertificateBuilder builder = new ControlPlaneAdditionalCertificateBuilder(item);
    if (index < 0 || index >= additional.size()) {
        _visitables.get("additional").add(builder);
        additional.add(builder);
    } else {
        _visitables.get("additional").add(builder);
        additional.add(index, builder);
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
  
  public List<ControlPlaneAdditionalCertificate> buildAdditional() {
    return this.additional != null ? build(additional) : null;
  }
  
  public ControlPlaneAdditionalCertificate buildAdditional(int index) {
    return this.additional.get(index).build();
  }
  
  public ControlPlaneAdditionalCertificate buildFirstAdditional() {
    return this.additional.get(0).build();
  }
  
  public ControlPlaneAdditionalCertificate buildLastAdditional() {
    return this.additional.get(additional.size() - 1).build();
  }
  
  public ControlPlaneAdditionalCertificate buildMatchingAdditional(Predicate<ControlPlaneAdditionalCertificateBuilder> predicate) {
      for (ControlPlaneAdditionalCertificateBuilder item : additional) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ControlPlaneServingCertificateSpec instance) {
    instance = instance != null ? instance : new ControlPlaneServingCertificateSpec();
    if (instance != null) {
        this.withAdditional(instance.getAdditional());
        this.withDefault(instance.getDefault());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalNested<A> editAdditional(int index) {
    if (additional.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additional"));
    }
    return this.setNewAdditionalLike(index, this.buildAdditional(index));
  }
  
  public AdditionalNested<A> editFirstAdditional() {
    if (additional.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additional"));
    }
    return this.setNewAdditionalLike(0, this.buildAdditional(0));
  }
  
  public AdditionalNested<A> editLastAdditional() {
    int index = additional.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additional"));
    }
    return this.setNewAdditionalLike(index, this.buildAdditional(index));
  }
  
  public AdditionalNested<A> editMatchingAdditional(Predicate<ControlPlaneAdditionalCertificateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additional.size();i++) {
      if (predicate.test(additional.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additional"));
    }
    return this.setNewAdditionalLike(index, this.buildAdditional(index));
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
    ControlPlaneServingCertificateSpecFluent that = (ControlPlaneServingCertificateSpecFluent) o;
    if (!(Objects.equals(additional, that.additional))) {
      return false;
    }
    if (!(Objects.equals(_default, that._default))) {
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
  
  public String getDefault() {
    return this._default;
  }
  
  public boolean hasAdditional() {
    return this.additional != null && !(this.additional.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasMatchingAdditional(Predicate<ControlPlaneAdditionalCertificateBuilder> predicate) {
      for (ControlPlaneAdditionalCertificateBuilder item : additional) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(additional, _default, additionalProperties);
  }
  
  public A removeAllFromAdditional(Collection<ControlPlaneAdditionalCertificate> items) {
    if (this.additional == null) {
      return (A) this;
    }
    for (ControlPlaneAdditionalCertificate item : items) {
        ControlPlaneAdditionalCertificateBuilder builder = new ControlPlaneAdditionalCertificateBuilder(item);
        _visitables.get("additional").remove(builder);
        this.additional.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditional(ControlPlaneAdditionalCertificate... items) {
    if (this.additional == null) {
      return (A) this;
    }
    for (ControlPlaneAdditionalCertificate item : items) {
        ControlPlaneAdditionalCertificateBuilder builder = new ControlPlaneAdditionalCertificateBuilder(item);
        _visitables.get("additional").remove(builder);
        this.additional.remove(builder);
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
  
  public A removeMatchingFromAdditional(Predicate<ControlPlaneAdditionalCertificateBuilder> predicate) {
    if (additional == null) {
      return (A) this;
    }
    Iterator<ControlPlaneAdditionalCertificateBuilder> each = additional.iterator();
    List visitables = _visitables.get("additional");
    while (each.hasNext()) {
        ControlPlaneAdditionalCertificateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalNested<A> setNewAdditionalLike(int index,ControlPlaneAdditionalCertificate item) {
    return new AdditionalNested(index, item);
  }
  
  public A setToAdditional(int index,ControlPlaneAdditionalCertificate item) {
    if (this.additional == null) {
      this.additional = new ArrayList();
    }
    ControlPlaneAdditionalCertificateBuilder builder = new ControlPlaneAdditionalCertificateBuilder(item);
    if (index < 0 || index >= additional.size()) {
        _visitables.get("additional").add(builder);
        additional.add(builder);
    } else {
        _visitables.get("additional").add(builder);
        additional.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additional == null) && !(additional.isEmpty())) {
        sb.append("additional:");
        sb.append(additional);
        sb.append(",");
    }
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditional(List<ControlPlaneAdditionalCertificate> additional) {
    if (this.additional != null) {
      this._visitables.get("additional").clear();
    }
    if (additional != null) {
        this.additional = new ArrayList();
        for (ControlPlaneAdditionalCertificate item : additional) {
          this.addToAdditional(item);
        }
    } else {
      this.additional = null;
    }
    return (A) this;
  }
  
  public A withAdditional(ControlPlaneAdditionalCertificate... additional) {
    if (this.additional != null) {
        this.additional.clear();
        _visitables.remove("additional");
    }
    if (additional != null) {
      for (ControlPlaneAdditionalCertificate item : additional) {
        this.addToAdditional(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDefault(String _default) {
    this._default = _default;
    return (A) this;
  }
  public class AdditionalNested<N> extends ControlPlaneAdditionalCertificateFluent<AdditionalNested<N>> implements Nested<N>{
  
    ControlPlaneAdditionalCertificateBuilder builder;
    int index;
  
    AdditionalNested(int index,ControlPlaneAdditionalCertificate item) {
      this.index = index;
      this.builder = new ControlPlaneAdditionalCertificateBuilder(this, item);
    }
  
    public N and() {
      return (N) ControlPlaneServingCertificateSpecFluent.this.setToAdditional(index, builder.build());
    }
    
    public N endAdditional() {
      return and();
    }
    
  }
}