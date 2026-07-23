package io.fabric8.openshift.api.model.config.v1;

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
public class APIServerServingCertsFluent<A extends io.fabric8.openshift.api.model.config.v1.APIServerServingCertsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<APIServerNamedServingCertBuilder> namedCertificates = new ArrayList<APIServerNamedServingCertBuilder>();

  public APIServerServingCertsFluent() {
  }
  
  public APIServerServingCertsFluent(APIServerServingCerts instance) {
    this.copyInstance(instance);
  }

  public A addAllToNamedCertificates(Collection<APIServerNamedServingCert> items) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    for (APIServerNamedServingCert item : items) {
        APIServerNamedServingCertBuilder builder = new APIServerNamedServingCertBuilder(item);
        _visitables.get("namedCertificates").add(builder);
        this.namedCertificates.add(builder);
    }
    return (A) this;
  }
  
  public NamedCertificatesNested<A> addNewNamedCertificate() {
    return new NamedCertificatesNested(-1, null);
  }
  
  public NamedCertificatesNested<A> addNewNamedCertificateLike(APIServerNamedServingCert item) {
    return new NamedCertificatesNested(-1, item);
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
  
  public A addToNamedCertificates(APIServerNamedServingCert... items) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    for (APIServerNamedServingCert item : items) {
        APIServerNamedServingCertBuilder builder = new APIServerNamedServingCertBuilder(item);
        _visitables.get("namedCertificates").add(builder);
        this.namedCertificates.add(builder);
    }
    return (A) this;
  }
  
  public A addToNamedCertificates(int index,APIServerNamedServingCert item) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    APIServerNamedServingCertBuilder builder = new APIServerNamedServingCertBuilder(item);
    if (index < 0 || index >= namedCertificates.size()) {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.add(builder);
    } else {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.add(index, builder);
    }
    return (A) this;
  }
  
  public APIServerNamedServingCert buildFirstNamedCertificate() {
    return this.namedCertificates.get(0).build();
  }
  
  public APIServerNamedServingCert buildLastNamedCertificate() {
    return this.namedCertificates.get(namedCertificates.size() - 1).build();
  }
  
  public APIServerNamedServingCert buildMatchingNamedCertificate(Predicate<APIServerNamedServingCertBuilder> predicate) {
      for (APIServerNamedServingCertBuilder item : namedCertificates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public APIServerNamedServingCert buildNamedCertificate(int index) {
    return this.namedCertificates.get(index).build();
  }
  
  public List<APIServerNamedServingCert> buildNamedCertificates() {
    return this.namedCertificates != null ? build(namedCertificates) : null;
  }
  
  protected void copyInstance(APIServerServingCerts instance) {
    instance = instance != null ? instance : new APIServerServingCerts();
    if (instance != null) {
        this.withNamedCertificates(instance.getNamedCertificates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamedCertificatesNested<A> editFirstNamedCertificate() {
    if (namedCertificates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(0, this.buildNamedCertificate(0));
  }
  
  public NamedCertificatesNested<A> editLastNamedCertificate() {
    int index = namedCertificates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(index, this.buildNamedCertificate(index));
  }
  
  public NamedCertificatesNested<A> editMatchingNamedCertificate(Predicate<APIServerNamedServingCertBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < namedCertificates.size();i++) {
      if (predicate.test(namedCertificates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(index, this.buildNamedCertificate(index));
  }
  
  public NamedCertificatesNested<A> editNamedCertificate(int index) {
    if (namedCertificates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(index, this.buildNamedCertificate(index));
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
    APIServerServingCertsFluent that = (APIServerServingCertsFluent) o;
    if (!(Objects.equals(namedCertificates, that.namedCertificates))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingNamedCertificate(Predicate<APIServerNamedServingCertBuilder> predicate) {
      for (APIServerNamedServingCertBuilder item : namedCertificates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamedCertificates() {
    return this.namedCertificates != null && !(this.namedCertificates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(namedCertificates, additionalProperties);
  }
  
  public A removeAllFromNamedCertificates(Collection<APIServerNamedServingCert> items) {
    if (this.namedCertificates == null) {
      return (A) this;
    }
    for (APIServerNamedServingCert item : items) {
        APIServerNamedServingCertBuilder builder = new APIServerNamedServingCertBuilder(item);
        _visitables.get("namedCertificates").remove(builder);
        this.namedCertificates.remove(builder);
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
  
  public A removeFromNamedCertificates(APIServerNamedServingCert... items) {
    if (this.namedCertificates == null) {
      return (A) this;
    }
    for (APIServerNamedServingCert item : items) {
        APIServerNamedServingCertBuilder builder = new APIServerNamedServingCertBuilder(item);
        _visitables.get("namedCertificates").remove(builder);
        this.namedCertificates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNamedCertificates(Predicate<APIServerNamedServingCertBuilder> predicate) {
    if (namedCertificates == null) {
      return (A) this;
    }
    Iterator<APIServerNamedServingCertBuilder> each = namedCertificates.iterator();
    List visitables = _visitables.get("namedCertificates");
    while (each.hasNext()) {
        APIServerNamedServingCertBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NamedCertificatesNested<A> setNewNamedCertificateLike(int index,APIServerNamedServingCert item) {
    return new NamedCertificatesNested(index, item);
  }
  
  public A setToNamedCertificates(int index,APIServerNamedServingCert item) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    APIServerNamedServingCertBuilder builder = new APIServerNamedServingCertBuilder(item);
    if (index < 0 || index >= namedCertificates.size()) {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.add(builder);
    } else {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(namedCertificates == null) && !(namedCertificates.isEmpty())) {
        sb.append("namedCertificates:");
        sb.append(namedCertificates);
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
  
  public A withNamedCertificates(List<APIServerNamedServingCert> namedCertificates) {
    if (this.namedCertificates != null) {
      this._visitables.get("namedCertificates").clear();
    }
    if (namedCertificates != null) {
        this.namedCertificates = new ArrayList();
        for (APIServerNamedServingCert item : namedCertificates) {
          this.addToNamedCertificates(item);
        }
    } else {
      this.namedCertificates = null;
    }
    return (A) this;
  }
  
  public A withNamedCertificates(APIServerNamedServingCert... namedCertificates) {
    if (this.namedCertificates != null) {
        this.namedCertificates.clear();
        _visitables.remove("namedCertificates");
    }
    if (namedCertificates != null) {
      for (APIServerNamedServingCert item : namedCertificates) {
        this.addToNamedCertificates(item);
      }
    }
    return (A) this;
  }
  public class NamedCertificatesNested<N> extends APIServerNamedServingCertFluent<NamedCertificatesNested<N>> implements Nested<N>{
  
    APIServerNamedServingCertBuilder builder;
    int index;
  
    NamedCertificatesNested(int index,APIServerNamedServingCert item) {
      this.index = index;
      this.builder = new APIServerNamedServingCertBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerServingCertsFluent.this.setToNamedCertificates(index, builder.build());
    }
    
    public N endNamedCertificate() {
      return and();
    }
    
  }
}