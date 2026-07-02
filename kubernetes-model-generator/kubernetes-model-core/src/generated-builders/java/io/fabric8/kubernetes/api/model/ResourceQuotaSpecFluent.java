package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ResourceQuotaSpecFluent<A extends io.fabric8.kubernetes.api.model.ResourceQuotaSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> hard;
  private ScopeSelectorBuilder scopeSelector;
  private List<String> scopes = new ArrayList<String>();

  public ResourceQuotaSpecFluent() {
  }
  
  public ResourceQuotaSpecFluent(ResourceQuotaSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToScopes(Collection<String> items) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    for (String item : items) {
      this.scopes.add(item);
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
  
  public A addToHard(Map<String,Quantity> map) {
    if (this.hard == null && map != null) {
      this.hard = new LinkedHashMap();
    }
    if (map != null) {
      this.hard.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHard(String key,Quantity value) {
    if (this.hard == null && key != null && value != null) {
      this.hard = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.hard.put(key, value);
    }
    return (A) this;
  }
  
  public A addToScopes(String... items) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    for (String item : items) {
      this.scopes.add(item);
    }
    return (A) this;
  }
  
  public A addToScopes(int index,String item) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    this.scopes.add(index, item);
    return (A) this;
  }
  
  public ScopeSelector buildScopeSelector() {
    return this.scopeSelector != null ? this.scopeSelector.build() : null;
  }
  
  protected void copyInstance(ResourceQuotaSpec instance) {
    instance = instance != null ? instance : new ResourceQuotaSpec();
    if (instance != null) {
        this.withHard(instance.getHard());
        this.withScopeSelector(instance.getScopeSelector());
        this.withScopes(instance.getScopes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScopeSelectorNested<A> editOrNewScopeSelector() {
    return this.withNewScopeSelectorLike(Optional.ofNullable(this.buildScopeSelector()).orElse(new ScopeSelectorBuilder().build()));
  }
  
  public ScopeSelectorNested<A> editOrNewScopeSelectorLike(ScopeSelector item) {
    return this.withNewScopeSelectorLike(Optional.ofNullable(this.buildScopeSelector()).orElse(item));
  }
  
  public ScopeSelectorNested<A> editScopeSelector() {
    return this.withNewScopeSelectorLike(Optional.ofNullable(this.buildScopeSelector()).orElse(null));
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
    ResourceQuotaSpecFluent that = (ResourceQuotaSpecFluent) o;
    if (!(Objects.equals(hard, that.hard))) {
      return false;
    }
    if (!(Objects.equals(scopeSelector, that.scopeSelector))) {
      return false;
    }
    if (!(Objects.equals(scopes, that.scopes))) {
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
  
  public String getFirstScope() {
    return this.scopes.get(0);
  }
  
  public Map<String,Quantity> getHard() {
    return this.hard;
  }
  
  public String getLastScope() {
    return this.scopes.get(scopes.size() - 1);
  }
  
  public String getMatchingScope(Predicate<String> predicate) {
      for (String item : scopes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getScope(int index) {
    return this.scopes.get(index);
  }
  
  public List<String> getScopes() {
    return this.scopes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHard() {
    return this.hard != null;
  }
  
  public boolean hasMatchingScope(Predicate<String> predicate) {
      for (String item : scopes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasScopeSelector() {
    return this.scopeSelector != null;
  }
  
  public boolean hasScopes() {
    return this.scopes != null && !(this.scopes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hard, scopeSelector, scopes, additionalProperties);
  }
  
  public A removeAllFromScopes(Collection<String> items) {
    if (this.scopes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scopes.remove(item);
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
  
  public A removeFromHard(String key) {
    if (this.hard == null) {
      return (A) this;
    }
    if (key != null && this.hard != null) {
      this.hard.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHard(Map<String,Quantity> map) {
    if (this.hard == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.hard != null) {
          this.hard.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromScopes(String... items) {
    if (this.scopes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scopes.remove(item);
    }
    return (A) this;
  }
  
  public A setToScopes(int index,String item) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    this.scopes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hard == null) && !(hard.isEmpty())) {
        sb.append("hard:");
        sb.append(hard);
        sb.append(",");
    }
    if (!(scopeSelector == null)) {
        sb.append("scopeSelector:");
        sb.append(scopeSelector);
        sb.append(",");
    }
    if (!(scopes == null) && !(scopes.isEmpty())) {
        sb.append("scopes:");
        sb.append(scopes);
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
  
  public <K,V>A withHard(Map<String,Quantity> hard) {
    if (hard == null) {
      this.hard = null;
    } else {
      this.hard = new LinkedHashMap(hard);
    }
    return (A) this;
  }
  
  public ScopeSelectorNested<A> withNewScopeSelector() {
    return new ScopeSelectorNested(null);
  }
  
  public ScopeSelectorNested<A> withNewScopeSelectorLike(ScopeSelector item) {
    return new ScopeSelectorNested(item);
  }
  
  public A withScopeSelector(ScopeSelector scopeSelector) {
    this._visitables.remove("scopeSelector");
    if (scopeSelector != null) {
        this.scopeSelector = new ScopeSelectorBuilder(scopeSelector);
        this._visitables.get("scopeSelector").add(this.scopeSelector);
    } else {
        this.scopeSelector = null;
        this._visitables.get("scopeSelector").remove(this.scopeSelector);
    }
    return (A) this;
  }
  
  public A withScopes(List<String> scopes) {
    if (scopes != null) {
        this.scopes = new ArrayList();
        for (String item : scopes) {
          this.addToScopes(item);
        }
    } else {
      this.scopes = null;
    }
    return (A) this;
  }
  
  public A withScopes(String... scopes) {
    if (this.scopes != null) {
        this.scopes.clear();
        _visitables.remove("scopes");
    }
    if (scopes != null) {
      for (String item : scopes) {
        this.addToScopes(item);
      }
    }
    return (A) this;
  }
  public class ScopeSelectorNested<N> extends ScopeSelectorFluent<ScopeSelectorNested<N>> implements Nested<N>{
  
    ScopeSelectorBuilder builder;
  
    ScopeSelectorNested(ScopeSelector item) {
      this.builder = new ScopeSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceQuotaSpecFluent.this.withScopeSelector(builder.build());
    }
    
    public N endScopeSelector() {
      return and();
    }
    
  }
}