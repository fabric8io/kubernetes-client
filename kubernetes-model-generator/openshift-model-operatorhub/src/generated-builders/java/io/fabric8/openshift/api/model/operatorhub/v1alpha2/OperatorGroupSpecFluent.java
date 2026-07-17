package io.fabric8.openshift.api.model.operatorhub.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class OperatorGroupSpecFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha2.OperatorGroupSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder selector;
  private String serviceAccountName;
  private Boolean staticProvidedAPIs;
  private List<String> targetNamespaces = new ArrayList<String>();

  public OperatorGroupSpecFluent() {
  }
  
  public OperatorGroupSpecFluent(OperatorGroupSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTargetNamespaces(Collection<String> items) {
    if (this.targetNamespaces == null) {
      this.targetNamespaces = new ArrayList();
    }
    for (String item : items) {
      this.targetNamespaces.add(item);
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
  
  public A addToTargetNamespaces(String... items) {
    if (this.targetNamespaces == null) {
      this.targetNamespaces = new ArrayList();
    }
    for (String item : items) {
      this.targetNamespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToTargetNamespaces(int index,String item) {
    if (this.targetNamespaces == null) {
      this.targetNamespaces = new ArrayList();
    }
    this.targetNamespaces.add(index, item);
    return (A) this;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(OperatorGroupSpec instance) {
    instance = instance != null ? instance : new OperatorGroupSpec();
    if (instance != null) {
        this.withSelector(instance.getSelector());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withStaticProvidedAPIs(instance.getStaticProvidedAPIs());
        this.withTargetNamespaces(instance.getTargetNamespaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    OperatorGroupSpecFluent that = (OperatorGroupSpecFluent) o;
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(staticProvidedAPIs, that.staticProvidedAPIs))) {
      return false;
    }
    if (!(Objects.equals(targetNamespaces, that.targetNamespaces))) {
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
  
  public String getFirstTargetNamespace() {
    return this.targetNamespaces.get(0);
  }
  
  public String getLastTargetNamespace() {
    return this.targetNamespaces.get(targetNamespaces.size() - 1);
  }
  
  public String getMatchingTargetNamespace(Predicate<String> predicate) {
      for (String item : targetNamespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public Boolean getStaticProvidedAPIs() {
    return this.staticProvidedAPIs;
  }
  
  public String getTargetNamespace(int index) {
    return this.targetNamespaces.get(index);
  }
  
  public List<String> getTargetNamespaces() {
    return this.targetNamespaces;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTargetNamespace(Predicate<String> predicate) {
      for (String item : targetNamespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasStaticProvidedAPIs() {
    return this.staticProvidedAPIs != null;
  }
  
  public boolean hasTargetNamespaces() {
    return this.targetNamespaces != null && !(this.targetNamespaces.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(selector, serviceAccountName, staticProvidedAPIs, targetNamespaces, additionalProperties);
  }
  
  public A removeAllFromTargetNamespaces(Collection<String> items) {
    if (this.targetNamespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetNamespaces.remove(item);
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
  
  public A removeFromTargetNamespaces(String... items) {
    if (this.targetNamespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetNamespaces.remove(item);
    }
    return (A) this;
  }
  
  public A setToTargetNamespaces(int index,String item) {
    if (this.targetNamespaces == null) {
      this.targetNamespaces = new ArrayList();
    }
    this.targetNamespaces.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(staticProvidedAPIs == null)) {
        sb.append("staticProvidedAPIs:");
        sb.append(staticProvidedAPIs);
        sb.append(",");
    }
    if (!(targetNamespaces == null) && !(targetNamespaces.isEmpty())) {
        sb.append("targetNamespaces:");
        sb.append(targetNamespaces);
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
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withStaticProvidedAPIs() {
    return withStaticProvidedAPIs(true);
  }
  
  public A withStaticProvidedAPIs(Boolean staticProvidedAPIs) {
    this.staticProvidedAPIs = staticProvidedAPIs;
    return (A) this;
  }
  
  public A withTargetNamespaces(List<String> targetNamespaces) {
    if (targetNamespaces != null) {
        this.targetNamespaces = new ArrayList();
        for (String item : targetNamespaces) {
          this.addToTargetNamespaces(item);
        }
    } else {
      this.targetNamespaces = null;
    }
    return (A) this;
  }
  
  public A withTargetNamespaces(String... targetNamespaces) {
    if (this.targetNamespaces != null) {
        this.targetNamespaces.clear();
        _visitables.remove("targetNamespaces");
    }
    if (targetNamespaces != null) {
      for (String item : targetNamespaces) {
        this.addToTargetNamespaces(item);
      }
    }
    return (A) this;
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) OperatorGroupSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}