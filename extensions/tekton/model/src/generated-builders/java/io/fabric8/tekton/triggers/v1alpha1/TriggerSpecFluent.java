package io.fabric8.tekton.triggers.v1alpha1;

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
public class TriggerSpecFluent<A extends io.fabric8.tekton.triggers.v1alpha1.TriggerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TriggerSpecBindingBuilder> bindings = new ArrayList<TriggerSpecBindingBuilder>();
  private ArrayList<TriggerInterceptorBuilder> interceptors = new ArrayList<TriggerInterceptorBuilder>();
  private String name;
  private String serviceAccountName;
  private TriggerSpecTemplateBuilder template;

  public TriggerSpecFluent() {
  }
  
  public TriggerSpecFluent(TriggerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToBindings(Collection<TriggerSpecBinding> items) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    for (TriggerSpecBinding item : items) {
        TriggerSpecBindingBuilder builder = new TriggerSpecBindingBuilder(item);
        _visitables.get("bindings").add(builder);
        this.bindings.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToInterceptors(Collection<TriggerInterceptor> items) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").add(builder);
        this.interceptors.add(builder);
    }
    return (A) this;
  }
  
  public BindingsNested<A> addNewBinding() {
    return new BindingsNested(-1, null);
  }
  
  public A addNewBinding(String apiversion,String kind,String name,String ref,String value) {
    return (A) this.addToBindings(new TriggerSpecBinding(apiversion, kind, name, ref, value));
  }
  
  public BindingsNested<A> addNewBindingLike(TriggerSpecBinding item) {
    return new BindingsNested(-1, item);
  }
  
  public InterceptorsNested<A> addNewInterceptor() {
    return new InterceptorsNested(-1, null);
  }
  
  public InterceptorsNested<A> addNewInterceptorLike(TriggerInterceptor item) {
    return new InterceptorsNested(-1, item);
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
  
  public A addToBindings(TriggerSpecBinding... items) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    for (TriggerSpecBinding item : items) {
        TriggerSpecBindingBuilder builder = new TriggerSpecBindingBuilder(item);
        _visitables.get("bindings").add(builder);
        this.bindings.add(builder);
    }
    return (A) this;
  }
  
  public A addToBindings(int index,TriggerSpecBinding item) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    TriggerSpecBindingBuilder builder = new TriggerSpecBindingBuilder(item);
    if (index < 0 || index >= bindings.size()) {
        _visitables.get("bindings").add(builder);
        bindings.add(builder);
    } else {
        _visitables.get("bindings").add(builder);
        bindings.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToInterceptors(TriggerInterceptor... items) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").add(builder);
        this.interceptors.add(builder);
    }
    return (A) this;
  }
  
  public A addToInterceptors(int index,TriggerInterceptor item) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
    if (index < 0 || index >= interceptors.size()) {
        _visitables.get("interceptors").add(builder);
        interceptors.add(builder);
    } else {
        _visitables.get("interceptors").add(builder);
        interceptors.add(index, builder);
    }
    return (A) this;
  }
  
  public TriggerSpecBinding buildBinding(int index) {
    return this.bindings.get(index).build();
  }
  
  public List<TriggerSpecBinding> buildBindings() {
    return this.bindings != null ? build(bindings) : null;
  }
  
  public TriggerSpecBinding buildFirstBinding() {
    return this.bindings.get(0).build();
  }
  
  public TriggerInterceptor buildFirstInterceptor() {
    return this.interceptors.get(0).build();
  }
  
  public TriggerInterceptor buildInterceptor(int index) {
    return this.interceptors.get(index).build();
  }
  
  public List<TriggerInterceptor> buildInterceptors() {
    return this.interceptors != null ? build(interceptors) : null;
  }
  
  public TriggerSpecBinding buildLastBinding() {
    return this.bindings.get(bindings.size() - 1).build();
  }
  
  public TriggerInterceptor buildLastInterceptor() {
    return this.interceptors.get(interceptors.size() - 1).build();
  }
  
  public TriggerSpecBinding buildMatchingBinding(Predicate<TriggerSpecBindingBuilder> predicate) {
      for (TriggerSpecBindingBuilder item : bindings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TriggerInterceptor buildMatchingInterceptor(Predicate<TriggerInterceptorBuilder> predicate) {
      for (TriggerInterceptorBuilder item : interceptors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TriggerSpecTemplate buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(TriggerSpec instance) {
    instance = instance != null ? instance : new TriggerSpec();
    if (instance != null) {
        this.withBindings(instance.getBindings());
        this.withInterceptors(instance.getInterceptors());
        this.withName(instance.getName());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BindingsNested<A> editBinding(int index) {
    if (bindings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "bindings"));
    }
    return this.setNewBindingLike(index, this.buildBinding(index));
  }
  
  public BindingsNested<A> editFirstBinding() {
    if (bindings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "bindings"));
    }
    return this.setNewBindingLike(0, this.buildBinding(0));
  }
  
  public InterceptorsNested<A> editFirstInterceptor() {
    if (interceptors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "interceptors"));
    }
    return this.setNewInterceptorLike(0, this.buildInterceptor(0));
  }
  
  public InterceptorsNested<A> editInterceptor(int index) {
    if (interceptors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "interceptors"));
    }
    return this.setNewInterceptorLike(index, this.buildInterceptor(index));
  }
  
  public BindingsNested<A> editLastBinding() {
    int index = bindings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "bindings"));
    }
    return this.setNewBindingLike(index, this.buildBinding(index));
  }
  
  public InterceptorsNested<A> editLastInterceptor() {
    int index = interceptors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "interceptors"));
    }
    return this.setNewInterceptorLike(index, this.buildInterceptor(index));
  }
  
  public BindingsNested<A> editMatchingBinding(Predicate<TriggerSpecBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < bindings.size();i++) {
      if (predicate.test(bindings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "bindings"));
    }
    return this.setNewBindingLike(index, this.buildBinding(index));
  }
  
  public InterceptorsNested<A> editMatchingInterceptor(Predicate<TriggerInterceptorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < interceptors.size();i++) {
      if (predicate.test(interceptors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "interceptors"));
    }
    return this.setNewInterceptorLike(index, this.buildInterceptor(index));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new TriggerSpecTemplateBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(TriggerSpecTemplate item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
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
    TriggerSpecFluent that = (TriggerSpecFluent) o;
    if (!(Objects.equals(bindings, that.bindings))) {
      return false;
    }
    if (!(Objects.equals(interceptors, that.interceptors))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBindings() {
    return this.bindings != null && !(this.bindings.isEmpty());
  }
  
  public boolean hasInterceptors() {
    return this.interceptors != null && !(this.interceptors.isEmpty());
  }
  
  public boolean hasMatchingBinding(Predicate<TriggerSpecBindingBuilder> predicate) {
      for (TriggerSpecBindingBuilder item : bindings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInterceptor(Predicate<TriggerInterceptorBuilder> predicate) {
      for (TriggerInterceptorBuilder item : interceptors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(bindings, interceptors, name, serviceAccountName, template, additionalProperties);
  }
  
  public A removeAllFromBindings(Collection<TriggerSpecBinding> items) {
    if (this.bindings == null) {
      return (A) this;
    }
    for (TriggerSpecBinding item : items) {
        TriggerSpecBindingBuilder builder = new TriggerSpecBindingBuilder(item);
        _visitables.get("bindings").remove(builder);
        this.bindings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromInterceptors(Collection<TriggerInterceptor> items) {
    if (this.interceptors == null) {
      return (A) this;
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").remove(builder);
        this.interceptors.remove(builder);
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
  
  public A removeFromBindings(TriggerSpecBinding... items) {
    if (this.bindings == null) {
      return (A) this;
    }
    for (TriggerSpecBinding item : items) {
        TriggerSpecBindingBuilder builder = new TriggerSpecBindingBuilder(item);
        _visitables.get("bindings").remove(builder);
        this.bindings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromInterceptors(TriggerInterceptor... items) {
    if (this.interceptors == null) {
      return (A) this;
    }
    for (TriggerInterceptor item : items) {
        TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
        _visitables.get("interceptors").remove(builder);
        this.interceptors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBindings(Predicate<TriggerSpecBindingBuilder> predicate) {
    if (bindings == null) {
      return (A) this;
    }
    Iterator<TriggerSpecBindingBuilder> each = bindings.iterator();
    List visitables = _visitables.get("bindings");
    while (each.hasNext()) {
        TriggerSpecBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInterceptors(Predicate<TriggerInterceptorBuilder> predicate) {
    if (interceptors == null) {
      return (A) this;
    }
    Iterator<TriggerInterceptorBuilder> each = interceptors.iterator();
    List visitables = _visitables.get("interceptors");
    while (each.hasNext()) {
        TriggerInterceptorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BindingsNested<A> setNewBindingLike(int index,TriggerSpecBinding item) {
    return new BindingsNested(index, item);
  }
  
  public InterceptorsNested<A> setNewInterceptorLike(int index,TriggerInterceptor item) {
    return new InterceptorsNested(index, item);
  }
  
  public A setToBindings(int index,TriggerSpecBinding item) {
    if (this.bindings == null) {
      this.bindings = new ArrayList();
    }
    TriggerSpecBindingBuilder builder = new TriggerSpecBindingBuilder(item);
    if (index < 0 || index >= bindings.size()) {
        _visitables.get("bindings").add(builder);
        bindings.add(builder);
    } else {
        _visitables.get("bindings").add(builder);
        bindings.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToInterceptors(int index,TriggerInterceptor item) {
    if (this.interceptors == null) {
      this.interceptors = new ArrayList();
    }
    TriggerInterceptorBuilder builder = new TriggerInterceptorBuilder(item);
    if (index < 0 || index >= interceptors.size()) {
        _visitables.get("interceptors").add(builder);
        interceptors.add(builder);
    } else {
        _visitables.get("interceptors").add(builder);
        interceptors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bindings == null) && !(bindings.isEmpty())) {
        sb.append("bindings:");
        sb.append(bindings);
        sb.append(",");
    }
    if (!(interceptors == null) && !(interceptors.isEmpty())) {
        sb.append("interceptors:");
        sb.append(interceptors);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public A withBindings(List<TriggerSpecBinding> bindings) {
    if (this.bindings != null) {
      this._visitables.get("bindings").clear();
    }
    if (bindings != null) {
        this.bindings = new ArrayList();
        for (TriggerSpecBinding item : bindings) {
          this.addToBindings(item);
        }
    } else {
      this.bindings = null;
    }
    return (A) this;
  }
  
  public A withBindings(TriggerSpecBinding... bindings) {
    if (this.bindings != null) {
        this.bindings.clear();
        _visitables.remove("bindings");
    }
    if (bindings != null) {
      for (TriggerSpecBinding item : bindings) {
        this.addToBindings(item);
      }
    }
    return (A) this;
  }
  
  public A withInterceptors(List<TriggerInterceptor> interceptors) {
    if (this.interceptors != null) {
      this._visitables.get("interceptors").clear();
    }
    if (interceptors != null) {
        this.interceptors = new ArrayList();
        for (TriggerInterceptor item : interceptors) {
          this.addToInterceptors(item);
        }
    } else {
      this.interceptors = null;
    }
    return (A) this;
  }
  
  public A withInterceptors(TriggerInterceptor... interceptors) {
    if (this.interceptors != null) {
        this.interceptors.clear();
        _visitables.remove("interceptors");
    }
    if (interceptors != null) {
      for (TriggerInterceptor item : interceptors) {
        this.addToInterceptors(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(TriggerSpecTemplate item) {
    return new TemplateNested(item);
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withTemplate(TriggerSpecTemplate template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new TriggerSpecTemplateBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  public class BindingsNested<N> extends TriggerSpecBindingFluent<BindingsNested<N>> implements Nested<N>{
  
    TriggerSpecBindingBuilder builder;
    int index;
  
    BindingsNested(int index,TriggerSpecBinding item) {
      this.index = index;
      this.builder = new TriggerSpecBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.setToBindings(index, builder.build());
    }
    
    public N endBinding() {
      return and();
    }
    
  }
  public class InterceptorsNested<N> extends TriggerInterceptorFluent<InterceptorsNested<N>> implements Nested<N>{
  
    TriggerInterceptorBuilder builder;
    int index;
  
    InterceptorsNested(int index,TriggerInterceptor item) {
      this.index = index;
      this.builder = new TriggerInterceptorBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.setToInterceptors(index, builder.build());
    }
    
    public N endInterceptor() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends TriggerSpecTemplateFluent<TemplateNested<N>> implements Nested<N>{
  
    TriggerSpecTemplateBuilder builder;
  
    TemplateNested(TriggerSpecTemplate item) {
      this.builder = new TriggerSpecTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}