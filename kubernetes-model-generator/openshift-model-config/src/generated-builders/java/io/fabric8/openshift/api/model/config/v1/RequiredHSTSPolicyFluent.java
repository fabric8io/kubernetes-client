package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import java.lang.Integer;
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
public class RequiredHSTSPolicyFluent<A extends io.fabric8.openshift.api.model.config.v1.RequiredHSTSPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> domainPatterns = new ArrayList<String>();
  private String includeSubDomainsPolicy;
  private MaxAgePolicyBuilder maxAge;
  private LabelSelectorBuilder namespaceSelector;
  private String preloadPolicy;

  public RequiredHSTSPolicyFluent() {
  }
  
  public RequiredHSTSPolicyFluent(RequiredHSTSPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToDomainPatterns(Collection<String> items) {
    if (this.domainPatterns == null) {
      this.domainPatterns = new ArrayList();
    }
    for (String item : items) {
      this.domainPatterns.add(item);
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
  
  public A addToDomainPatterns(String... items) {
    if (this.domainPatterns == null) {
      this.domainPatterns = new ArrayList();
    }
    for (String item : items) {
      this.domainPatterns.add(item);
    }
    return (A) this;
  }
  
  public A addToDomainPatterns(int index,String item) {
    if (this.domainPatterns == null) {
      this.domainPatterns = new ArrayList();
    }
    this.domainPatterns.add(index, item);
    return (A) this;
  }
  
  public MaxAgePolicy buildMaxAge() {
    return this.maxAge != null ? this.maxAge.build() : null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  protected void copyInstance(RequiredHSTSPolicy instance) {
    instance = instance != null ? instance : new RequiredHSTSPolicy();
    if (instance != null) {
        this.withDomainPatterns(instance.getDomainPatterns());
        this.withIncludeSubDomainsPolicy(instance.getIncludeSubDomainsPolicy());
        this.withMaxAge(instance.getMaxAge());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withPreloadPolicy(instance.getPreloadPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MaxAgeNested<A> editMaxAge() {
    return this.withNewMaxAgeLike(Optional.ofNullable(this.buildMaxAge()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public MaxAgeNested<A> editOrNewMaxAge() {
    return this.withNewMaxAgeLike(Optional.ofNullable(this.buildMaxAge()).orElse(new MaxAgePolicyBuilder().build()));
  }
  
  public MaxAgeNested<A> editOrNewMaxAgeLike(MaxAgePolicy item) {
    return this.withNewMaxAgeLike(Optional.ofNullable(this.buildMaxAge()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
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
    RequiredHSTSPolicyFluent that = (RequiredHSTSPolicyFluent) o;
    if (!(Objects.equals(domainPatterns, that.domainPatterns))) {
      return false;
    }
    if (!(Objects.equals(includeSubDomainsPolicy, that.includeSubDomainsPolicy))) {
      return false;
    }
    if (!(Objects.equals(maxAge, that.maxAge))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(preloadPolicy, that.preloadPolicy))) {
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
  
  public String getDomainPattern(int index) {
    return this.domainPatterns.get(index);
  }
  
  public List<String> getDomainPatterns() {
    return this.domainPatterns;
  }
  
  public String getFirstDomainPattern() {
    return this.domainPatterns.get(0);
  }
  
  public String getIncludeSubDomainsPolicy() {
    return this.includeSubDomainsPolicy;
  }
  
  public String getLastDomainPattern() {
    return this.domainPatterns.get(domainPatterns.size() - 1);
  }
  
  public String getMatchingDomainPattern(Predicate<String> predicate) {
      for (String item : domainPatterns) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPreloadPolicy() {
    return this.preloadPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDomainPatterns() {
    return this.domainPatterns != null && !(this.domainPatterns.isEmpty());
  }
  
  public boolean hasIncludeSubDomainsPolicy() {
    return this.includeSubDomainsPolicy != null;
  }
  
  public boolean hasMatchingDomainPattern(Predicate<String> predicate) {
      for (String item : domainPatterns) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxAge() {
    return this.maxAge != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasPreloadPolicy() {
    return this.preloadPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(domainPatterns, includeSubDomainsPolicy, maxAge, namespaceSelector, preloadPolicy, additionalProperties);
  }
  
  public A removeAllFromDomainPatterns(Collection<String> items) {
    if (this.domainPatterns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.domainPatterns.remove(item);
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
  
  public A removeFromDomainPatterns(String... items) {
    if (this.domainPatterns == null) {
      return (A) this;
    }
    for (String item : items) {
      this.domainPatterns.remove(item);
    }
    return (A) this;
  }
  
  public A setToDomainPatterns(int index,String item) {
    if (this.domainPatterns == null) {
      this.domainPatterns = new ArrayList();
    }
    this.domainPatterns.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(domainPatterns == null) && !(domainPatterns.isEmpty())) {
        sb.append("domainPatterns:");
        sb.append(domainPatterns);
        sb.append(",");
    }
    if (!(includeSubDomainsPolicy == null)) {
        sb.append("includeSubDomainsPolicy:");
        sb.append(includeSubDomainsPolicy);
        sb.append(",");
    }
    if (!(maxAge == null)) {
        sb.append("maxAge:");
        sb.append(maxAge);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(preloadPolicy == null)) {
        sb.append("preloadPolicy:");
        sb.append(preloadPolicy);
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
  
  public A withDomainPatterns(List<String> domainPatterns) {
    if (domainPatterns != null) {
        this.domainPatterns = new ArrayList();
        for (String item : domainPatterns) {
          this.addToDomainPatterns(item);
        }
    } else {
      this.domainPatterns = null;
    }
    return (A) this;
  }
  
  public A withDomainPatterns(String... domainPatterns) {
    if (this.domainPatterns != null) {
        this.domainPatterns.clear();
        _visitables.remove("domainPatterns");
    }
    if (domainPatterns != null) {
      for (String item : domainPatterns) {
        this.addToDomainPatterns(item);
      }
    }
    return (A) this;
  }
  
  public A withIncludeSubDomainsPolicy(String includeSubDomainsPolicy) {
    this.includeSubDomainsPolicy = includeSubDomainsPolicy;
    return (A) this;
  }
  
  public A withMaxAge(MaxAgePolicy maxAge) {
    this._visitables.remove("maxAge");
    if (maxAge != null) {
        this.maxAge = new MaxAgePolicyBuilder(maxAge);
        this._visitables.get("maxAge").add(this.maxAge);
    } else {
        this.maxAge = null;
        this._visitables.get("maxAge").remove(this.maxAge);
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public MaxAgeNested<A> withNewMaxAge() {
    return new MaxAgeNested(null);
  }
  
  public A withNewMaxAge(Integer largestMaxAge,Integer smallestMaxAge) {
    return (A) this.withMaxAge(new MaxAgePolicy(largestMaxAge, smallestMaxAge));
  }
  
  public MaxAgeNested<A> withNewMaxAgeLike(MaxAgePolicy item) {
    return new MaxAgeNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public A withPreloadPolicy(String preloadPolicy) {
    this.preloadPolicy = preloadPolicy;
    return (A) this;
  }
  public class MaxAgeNested<N> extends MaxAgePolicyFluent<MaxAgeNested<N>> implements Nested<N>{
  
    MaxAgePolicyBuilder builder;
  
    MaxAgeNested(MaxAgePolicy item) {
      this.builder = new MaxAgePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) RequiredHSTSPolicyFluent.this.withMaxAge(builder.build());
    }
    
    public N endMaxAge() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) RequiredHSTSPolicyFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
}