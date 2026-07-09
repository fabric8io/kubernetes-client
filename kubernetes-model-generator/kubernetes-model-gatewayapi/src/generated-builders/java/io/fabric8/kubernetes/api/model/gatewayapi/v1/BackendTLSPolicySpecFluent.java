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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class BackendTLSPolicySpecFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.BackendTLSPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> options;
  private ArrayList<LocalPolicyTargetReferenceWithSectionNameBuilder> targetRefs = new ArrayList<LocalPolicyTargetReferenceWithSectionNameBuilder>();
  private BackendTLSPolicyValidationBuilder validation;

  public BackendTLSPolicySpecFluent() {
  }
  
  public BackendTLSPolicySpecFluent(BackendTLSPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTargetRefs(Collection<LocalPolicyTargetReferenceWithSectionName> items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (LocalPolicyTargetReferenceWithSectionName item : items) {
        LocalPolicyTargetReferenceWithSectionNameBuilder builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public TargetRefsNested<A> addNewTargetRef() {
    return new TargetRefsNested(-1, null);
  }
  
  public A addNewTargetRef(String group,String kind,String name,String sectionName) {
    return (A) this.addToTargetRefs(new LocalPolicyTargetReferenceWithSectionName(group, kind, name, sectionName));
  }
  
  public TargetRefsNested<A> addNewTargetRefLike(LocalPolicyTargetReferenceWithSectionName item) {
    return new TargetRefsNested(-1, item);
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
  
  public A addToTargetRefs(LocalPolicyTargetReferenceWithSectionName... items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (LocalPolicyTargetReferenceWithSectionName item : items) {
        LocalPolicyTargetReferenceWithSectionNameBuilder builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(int index,LocalPolicyTargetReferenceWithSectionName item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    LocalPolicyTargetReferenceWithSectionNameBuilder builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public LocalPolicyTargetReferenceWithSectionName buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public LocalPolicyTargetReferenceWithSectionName buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public LocalPolicyTargetReferenceWithSectionName buildMatchingTargetRef(Predicate<LocalPolicyTargetReferenceWithSectionNameBuilder> predicate) {
      for (LocalPolicyTargetReferenceWithSectionNameBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalPolicyTargetReferenceWithSectionName buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<LocalPolicyTargetReferenceWithSectionName> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  public BackendTLSPolicyValidation buildValidation() {
    return this.validation != null ? this.validation.build() : null;
  }
  
  protected void copyInstance(BackendTLSPolicySpec instance) {
    instance = instance != null ? instance : new BackendTLSPolicySpec();
    if (instance != null) {
        this.withOptions(instance.getOptions());
        this.withTargetRefs(instance.getTargetRefs());
        this.withValidation(instance.getValidation());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public TargetRefsNested<A> editMatchingTargetRef(Predicate<LocalPolicyTargetReferenceWithSectionNameBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targetRefs.size();i++) {
      if (predicate.test(targetRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public ValidationNested<A> editOrNewValidation() {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(new BackendTLSPolicyValidationBuilder().build()));
  }
  
  public ValidationNested<A> editOrNewValidationLike(BackendTLSPolicyValidation item) {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(item));
  }
  
  public TargetRefsNested<A> editTargetRef(int index) {
    if (targetRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public ValidationNested<A> editValidation() {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(null));
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
    BackendTLSPolicySpecFluent that = (BackendTLSPolicySpecFluent) o;
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(targetRefs, that.targetRefs))) {
      return false;
    }
    if (!(Objects.equals(validation, that.validation))) {
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
  
  public Map<String,String> getOptions() {
    return this.options;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingTargetRef(Predicate<LocalPolicyTargetReferenceWithSectionNameBuilder> predicate) {
      for (LocalPolicyTargetReferenceWithSectionNameBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasTargetRefs() {
    return this.targetRefs != null && !(this.targetRefs.isEmpty());
  }
  
  public boolean hasValidation() {
    return this.validation != null;
  }
  
  public int hashCode() {
    return Objects.hash(options, targetRefs, validation, additionalProperties);
  }
  
  public A removeAllFromTargetRefs(Collection<LocalPolicyTargetReferenceWithSectionName> items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (LocalPolicyTargetReferenceWithSectionName item : items) {
        LocalPolicyTargetReferenceWithSectionNameBuilder builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
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
  
  public A removeFromTargetRefs(LocalPolicyTargetReferenceWithSectionName... items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (LocalPolicyTargetReferenceWithSectionName item : items) {
        LocalPolicyTargetReferenceWithSectionNameBuilder builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargetRefs(Predicate<LocalPolicyTargetReferenceWithSectionNameBuilder> predicate) {
    if (targetRefs == null) {
      return (A) this;
    }
    Iterator<LocalPolicyTargetReferenceWithSectionNameBuilder> each = targetRefs.iterator();
    List visitables = _visitables.get("targetRefs");
    while (each.hasNext()) {
        LocalPolicyTargetReferenceWithSectionNameBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,LocalPolicyTargetReferenceWithSectionName item) {
    return new TargetRefsNested(index, item);
  }
  
  public A setToTargetRefs(int index,LocalPolicyTargetReferenceWithSectionName item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    LocalPolicyTargetReferenceWithSectionNameBuilder builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(options == null) && !(options.isEmpty())) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(targetRefs == null) && !(targetRefs.isEmpty())) {
        sb.append("targetRefs:");
        sb.append(targetRefs);
        sb.append(",");
    }
    if (!(validation == null)) {
        sb.append("validation:");
        sb.append(validation);
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
  
  public ValidationNested<A> withNewValidation() {
    return new ValidationNested(null);
  }
  
  public ValidationNested<A> withNewValidationLike(BackendTLSPolicyValidation item) {
    return new ValidationNested(item);
  }
  
  public <K,V>A withOptions(Map<String,String> options) {
    if (options == null) {
      this.options = null;
    } else {
      this.options = new LinkedHashMap(options);
    }
    return (A) this;
  }
  
  public A withTargetRefs(List<LocalPolicyTargetReferenceWithSectionName> targetRefs) {
    if (this.targetRefs != null) {
      this._visitables.get("targetRefs").clear();
    }
    if (targetRefs != null) {
        this.targetRefs = new ArrayList();
        for (LocalPolicyTargetReferenceWithSectionName item : targetRefs) {
          this.addToTargetRefs(item);
        }
    } else {
      this.targetRefs = null;
    }
    return (A) this;
  }
  
  public A withTargetRefs(LocalPolicyTargetReferenceWithSectionName... targetRefs) {
    if (this.targetRefs != null) {
        this.targetRefs.clear();
        _visitables.remove("targetRefs");
    }
    if (targetRefs != null) {
      for (LocalPolicyTargetReferenceWithSectionName item : targetRefs) {
        this.addToTargetRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withValidation(BackendTLSPolicyValidation validation) {
    this._visitables.remove("validation");
    if (validation != null) {
        this.validation = new BackendTLSPolicyValidationBuilder(validation);
        this._visitables.get("validation").add(this.validation);
    } else {
        this.validation = null;
        this._visitables.get("validation").remove(this.validation);
    }
    return (A) this;
  }
  public class TargetRefsNested<N> extends LocalPolicyTargetReferenceWithSectionNameFluent<TargetRefsNested<N>> implements Nested<N>{
  
    LocalPolicyTargetReferenceWithSectionNameBuilder builder;
    int index;
  
    TargetRefsNested(int index,LocalPolicyTargetReferenceWithSectionName item) {
      this.index = index;
      this.builder = new LocalPolicyTargetReferenceWithSectionNameBuilder(this, item);
    }
  
    public N and() {
      return (N) BackendTLSPolicySpecFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class ValidationNested<N> extends BackendTLSPolicyValidationFluent<ValidationNested<N>> implements Nested<N>{
  
    BackendTLSPolicyValidationBuilder builder;
  
    ValidationNested(BackendTLSPolicyValidation item) {
      this.builder = new BackendTLSPolicyValidationBuilder(this, item);
    }
  
    public N and() {
      return (N) BackendTLSPolicySpecFluent.this.withValidation(builder.build());
    }
    
    public N endValidation() {
      return and();
    }
    
  }
}