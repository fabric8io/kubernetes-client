package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class PolicyTemplateFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.PolicyTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PolicyDependencyBuilder> extraDependencies = new ArrayList<PolicyDependencyBuilder>();
  private Boolean ignorePending;
  private Object objectDefinition;

  public PolicyTemplateFluent() {
  }
  
  public PolicyTemplateFluent(PolicyTemplate instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtraDependencies(Collection<PolicyDependency> items) {
    if (this.extraDependencies == null) {
      this.extraDependencies = new ArrayList();
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("extraDependencies").add(builder);
        this.extraDependencies.add(builder);
    }
    return (A) this;
  }
  
  public ExtraDependenciesNested<A> addNewExtraDependency() {
    return new ExtraDependenciesNested(-1, null);
  }
  
  public A addNewExtraDependency(String apiVersion,String compliance,String kind,String name,String namespace) {
    return (A) this.addToExtraDependencies(new PolicyDependency(apiVersion, compliance, kind, name, namespace));
  }
  
  public ExtraDependenciesNested<A> addNewExtraDependencyLike(PolicyDependency item) {
    return new ExtraDependenciesNested(-1, item);
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
  
  public A addToExtraDependencies(PolicyDependency... items) {
    if (this.extraDependencies == null) {
      this.extraDependencies = new ArrayList();
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("extraDependencies").add(builder);
        this.extraDependencies.add(builder);
    }
    return (A) this;
  }
  
  public A addToExtraDependencies(int index,PolicyDependency item) {
    if (this.extraDependencies == null) {
      this.extraDependencies = new ArrayList();
    }
    PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
    if (index < 0 || index >= extraDependencies.size()) {
        _visitables.get("extraDependencies").add(builder);
        extraDependencies.add(builder);
    } else {
        _visitables.get("extraDependencies").add(builder);
        extraDependencies.add(index, builder);
    }
    return (A) this;
  }
  
  public List<PolicyDependency> buildExtraDependencies() {
    return this.extraDependencies != null ? build(extraDependencies) : null;
  }
  
  public PolicyDependency buildExtraDependency(int index) {
    return this.extraDependencies.get(index).build();
  }
  
  public PolicyDependency buildFirstExtraDependency() {
    return this.extraDependencies.get(0).build();
  }
  
  public PolicyDependency buildLastExtraDependency() {
    return this.extraDependencies.get(extraDependencies.size() - 1).build();
  }
  
  public PolicyDependency buildMatchingExtraDependency(Predicate<PolicyDependencyBuilder> predicate) {
      for (PolicyDependencyBuilder item : extraDependencies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PolicyTemplate instance) {
    instance = instance != null ? instance : new PolicyTemplate();
    if (instance != null) {
        this.withExtraDependencies(instance.getExtraDependencies());
        this.withIgnorePending(instance.getIgnorePending());
        this.withObjectDefinition(instance.getObjectDefinition());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExtraDependenciesNested<A> editExtraDependency(int index) {
    if (extraDependencies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "extraDependencies"));
    }
    return this.setNewExtraDependencyLike(index, this.buildExtraDependency(index));
  }
  
  public ExtraDependenciesNested<A> editFirstExtraDependency() {
    if (extraDependencies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "extraDependencies"));
    }
    return this.setNewExtraDependencyLike(0, this.buildExtraDependency(0));
  }
  
  public ExtraDependenciesNested<A> editLastExtraDependency() {
    int index = extraDependencies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "extraDependencies"));
    }
    return this.setNewExtraDependencyLike(index, this.buildExtraDependency(index));
  }
  
  public ExtraDependenciesNested<A> editMatchingExtraDependency(Predicate<PolicyDependencyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < extraDependencies.size();i++) {
      if (predicate.test(extraDependencies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "extraDependencies"));
    }
    return this.setNewExtraDependencyLike(index, this.buildExtraDependency(index));
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
    PolicyTemplateFluent that = (PolicyTemplateFluent) o;
    if (!(Objects.equals(extraDependencies, that.extraDependencies))) {
      return false;
    }
    if (!(Objects.equals(ignorePending, that.ignorePending))) {
      return false;
    }
    if (!(Objects.equals(objectDefinition, that.objectDefinition))) {
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
  
  public Boolean getIgnorePending() {
    return this.ignorePending;
  }
  
  public Object getObjectDefinition() {
    return this.objectDefinition;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExtraDependencies() {
    return this.extraDependencies != null && !(this.extraDependencies.isEmpty());
  }
  
  public boolean hasIgnorePending() {
    return this.ignorePending != null;
  }
  
  public boolean hasMatchingExtraDependency(Predicate<PolicyDependencyBuilder> predicate) {
      for (PolicyDependencyBuilder item : extraDependencies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObjectDefinition() {
    return this.objectDefinition != null;
  }
  
  public int hashCode() {
    return Objects.hash(extraDependencies, ignorePending, objectDefinition, additionalProperties);
  }
  
  public A removeAllFromExtraDependencies(Collection<PolicyDependency> items) {
    if (this.extraDependencies == null) {
      return (A) this;
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("extraDependencies").remove(builder);
        this.extraDependencies.remove(builder);
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
  
  public A removeFromExtraDependencies(PolicyDependency... items) {
    if (this.extraDependencies == null) {
      return (A) this;
    }
    for (PolicyDependency item : items) {
        PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
        _visitables.get("extraDependencies").remove(builder);
        this.extraDependencies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExtraDependencies(Predicate<PolicyDependencyBuilder> predicate) {
    if (extraDependencies == null) {
      return (A) this;
    }
    Iterator<PolicyDependencyBuilder> each = extraDependencies.iterator();
    List visitables = _visitables.get("extraDependencies");
    while (each.hasNext()) {
        PolicyDependencyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExtraDependenciesNested<A> setNewExtraDependencyLike(int index,PolicyDependency item) {
    return new ExtraDependenciesNested(index, item);
  }
  
  public A setToExtraDependencies(int index,PolicyDependency item) {
    if (this.extraDependencies == null) {
      this.extraDependencies = new ArrayList();
    }
    PolicyDependencyBuilder builder = new PolicyDependencyBuilder(item);
    if (index < 0 || index >= extraDependencies.size()) {
        _visitables.get("extraDependencies").add(builder);
        extraDependencies.add(builder);
    } else {
        _visitables.get("extraDependencies").add(builder);
        extraDependencies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(extraDependencies == null) && !(extraDependencies.isEmpty())) {
        sb.append("extraDependencies:");
        sb.append(extraDependencies);
        sb.append(",");
    }
    if (!(ignorePending == null)) {
        sb.append("ignorePending:");
        sb.append(ignorePending);
        sb.append(",");
    }
    if (!(objectDefinition == null)) {
        sb.append("objectDefinition:");
        sb.append(objectDefinition);
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
  
  public A withExtraDependencies(List<PolicyDependency> extraDependencies) {
    if (this.extraDependencies != null) {
      this._visitables.get("extraDependencies").clear();
    }
    if (extraDependencies != null) {
        this.extraDependencies = new ArrayList();
        for (PolicyDependency item : extraDependencies) {
          this.addToExtraDependencies(item);
        }
    } else {
      this.extraDependencies = null;
    }
    return (A) this;
  }
  
  public A withExtraDependencies(PolicyDependency... extraDependencies) {
    if (this.extraDependencies != null) {
        this.extraDependencies.clear();
        _visitables.remove("extraDependencies");
    }
    if (extraDependencies != null) {
      for (PolicyDependency item : extraDependencies) {
        this.addToExtraDependencies(item);
      }
    }
    return (A) this;
  }
  
  public A withIgnorePending() {
    return withIgnorePending(true);
  }
  
  public A withIgnorePending(Boolean ignorePending) {
    this.ignorePending = ignorePending;
    return (A) this;
  }
  
  public A withObjectDefinition(Object objectDefinition) {
    this.objectDefinition = objectDefinition;
    return (A) this;
  }
  public class ExtraDependenciesNested<N> extends PolicyDependencyFluent<ExtraDependenciesNested<N>> implements Nested<N>{
  
    PolicyDependencyBuilder builder;
    int index;
  
    ExtraDependenciesNested(int index,PolicyDependency item) {
      this.index = index;
      this.builder = new PolicyDependencyBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyTemplateFluent.this.setToExtraDependencies(index, builder.build());
    }
    
    public N endExtraDependency() {
      return and();
    }
    
  }
}