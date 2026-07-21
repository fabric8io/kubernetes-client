package io.fabric8.tekton.triggers.v1beta1;

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
public class TriggerTemplateSpecFluent<A extends io.fabric8.tekton.triggers.v1beta1.TriggerTemplateSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ParamSpecBuilder> params = new ArrayList<ParamSpecBuilder>();
  private ArrayList<TriggerResourceTemplateBuilder> resourcetemplates = new ArrayList<TriggerResourceTemplateBuilder>();

  public TriggerTemplateSpecFluent() {
  }
  
  public TriggerTemplateSpecFluent(TriggerTemplateSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToParams(Collection<ParamSpec> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourcetemplates(Collection<TriggerResourceTemplate> items) {
    if (this.resourcetemplates == null) {
      this.resourcetemplates = new ArrayList();
    }
    for (TriggerResourceTemplate item : items) {
        TriggerResourceTemplateBuilder builder = new TriggerResourceTemplateBuilder(item);
        _visitables.get("resourcetemplates").add(builder);
        this.resourcetemplates.add(builder);
    }
    return (A) this;
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public A addNewParam(String _default,String description,String name) {
    return (A) this.addToParams(new ParamSpec(_default, description, name));
  }
  
  public ParamsNested<A> addNewParamLike(ParamSpec item) {
    return new ParamsNested(-1, item);
  }
  
  public ResourcetemplatesNested<A> addNewResourcetemplate() {
    return new ResourcetemplatesNested(-1, null);
  }
  
  public ResourcetemplatesNested<A> addNewResourcetemplateLike(TriggerResourceTemplate item) {
    return new ResourcetemplatesNested(-1, item);
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
  
  public A addToParams(ParamSpec... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,ParamSpec item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamSpecBuilder builder = new ParamSpecBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourcetemplates(TriggerResourceTemplate... items) {
    if (this.resourcetemplates == null) {
      this.resourcetemplates = new ArrayList();
    }
    for (TriggerResourceTemplate item : items) {
        TriggerResourceTemplateBuilder builder = new TriggerResourceTemplateBuilder(item);
        _visitables.get("resourcetemplates").add(builder);
        this.resourcetemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourcetemplates(int index,TriggerResourceTemplate item) {
    if (this.resourcetemplates == null) {
      this.resourcetemplates = new ArrayList();
    }
    TriggerResourceTemplateBuilder builder = new TriggerResourceTemplateBuilder(item);
    if (index < 0 || index >= resourcetemplates.size()) {
        _visitables.get("resourcetemplates").add(builder);
        resourcetemplates.add(builder);
    } else {
        _visitables.get("resourcetemplates").add(builder);
        resourcetemplates.add(index, builder);
    }
    return (A) this;
  }
  
  public ParamSpec buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public TriggerResourceTemplate buildFirstResourcetemplate() {
    return this.resourcetemplates.get(0).build();
  }
  
  public ParamSpec buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public TriggerResourceTemplate buildLastResourcetemplate() {
    return this.resourcetemplates.get(resourcetemplates.size() - 1).build();
  }
  
  public ParamSpec buildMatchingParam(Predicate<ParamSpecBuilder> predicate) {
      for (ParamSpecBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TriggerResourceTemplate buildMatchingResourcetemplate(Predicate<TriggerResourceTemplateBuilder> predicate) {
      for (TriggerResourceTemplateBuilder item : resourcetemplates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ParamSpec buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<ParamSpec> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  public TriggerResourceTemplate buildResourcetemplate(int index) {
    return this.resourcetemplates.get(index).build();
  }
  
  public List<TriggerResourceTemplate> buildResourcetemplates() {
    return this.resourcetemplates != null ? build(resourcetemplates) : null;
  }
  
  protected void copyInstance(TriggerTemplateSpec instance) {
    instance = instance != null ? instance : new TriggerTemplateSpec();
    if (instance != null) {
        this.withParams(instance.getParams());
        this.withResourcetemplates(instance.getResourcetemplates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public ResourcetemplatesNested<A> editFirstResourcetemplate() {
    if (resourcetemplates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourcetemplates"));
    }
    return this.setNewResourcetemplateLike(0, this.buildResourcetemplate(0));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ResourcetemplatesNested<A> editLastResourcetemplate() {
    int index = resourcetemplates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourcetemplates"));
    }
    return this.setNewResourcetemplateLike(index, this.buildResourcetemplate(index));
  }
  
  public ParamsNested<A> editMatchingParam(Predicate<ParamSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < params.size();i++) {
      if (predicate.test(params.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ResourcetemplatesNested<A> editMatchingResourcetemplate(Predicate<TriggerResourceTemplateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourcetemplates.size();i++) {
      if (predicate.test(resourcetemplates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourcetemplates"));
    }
    return this.setNewResourcetemplateLike(index, this.buildResourcetemplate(index));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ResourcetemplatesNested<A> editResourcetemplate(int index) {
    if (resourcetemplates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourcetemplates"));
    }
    return this.setNewResourcetemplateLike(index, this.buildResourcetemplate(index));
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
    TriggerTemplateSpecFluent that = (TriggerTemplateSpecFluent) o;
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(resourcetemplates, that.resourcetemplates))) {
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
  
  public boolean hasMatchingParam(Predicate<ParamSpecBuilder> predicate) {
      for (ParamSpecBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourcetemplate(Predicate<TriggerResourceTemplateBuilder> predicate) {
      for (TriggerResourceTemplateBuilder item : resourcetemplates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public boolean hasResourcetemplates() {
    return this.resourcetemplates != null && !(this.resourcetemplates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(params, resourcetemplates, additionalProperties);
  }
  
  public A removeAllFromParams(Collection<ParamSpec> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourcetemplates(Collection<TriggerResourceTemplate> items) {
    if (this.resourcetemplates == null) {
      return (A) this;
    }
    for (TriggerResourceTemplate item : items) {
        TriggerResourceTemplateBuilder builder = new TriggerResourceTemplateBuilder(item);
        _visitables.get("resourcetemplates").remove(builder);
        this.resourcetemplates.remove(builder);
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
  
  public A removeFromParams(ParamSpec... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ParamSpec item : items) {
        ParamSpecBuilder builder = new ParamSpecBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourcetemplates(TriggerResourceTemplate... items) {
    if (this.resourcetemplates == null) {
      return (A) this;
    }
    for (TriggerResourceTemplate item : items) {
        TriggerResourceTemplateBuilder builder = new TriggerResourceTemplateBuilder(item);
        _visitables.get("resourcetemplates").remove(builder);
        this.resourcetemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParams(Predicate<ParamSpecBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<ParamSpecBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        ParamSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourcetemplates(Predicate<TriggerResourceTemplateBuilder> predicate) {
    if (resourcetemplates == null) {
      return (A) this;
    }
    Iterator<TriggerResourceTemplateBuilder> each = resourcetemplates.iterator();
    List visitables = _visitables.get("resourcetemplates");
    while (each.hasNext()) {
        TriggerResourceTemplateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParamsNested<A> setNewParamLike(int index,ParamSpec item) {
    return new ParamsNested(index, item);
  }
  
  public ResourcetemplatesNested<A> setNewResourcetemplateLike(int index,TriggerResourceTemplate item) {
    return new ResourcetemplatesNested(index, item);
  }
  
  public A setToParams(int index,ParamSpec item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamSpecBuilder builder = new ParamSpecBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourcetemplates(int index,TriggerResourceTemplate item) {
    if (this.resourcetemplates == null) {
      this.resourcetemplates = new ArrayList();
    }
    TriggerResourceTemplateBuilder builder = new TriggerResourceTemplateBuilder(item);
    if (index < 0 || index >= resourcetemplates.size()) {
        _visitables.get("resourcetemplates").add(builder);
        resourcetemplates.add(builder);
    } else {
        _visitables.get("resourcetemplates").add(builder);
        resourcetemplates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(resourcetemplates == null) && !(resourcetemplates.isEmpty())) {
        sb.append("resourcetemplates:");
        sb.append(resourcetemplates);
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
  
  public A withParams(List<ParamSpec> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (ParamSpec item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(ParamSpec... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (ParamSpec item : params) {
        this.addToParams(item);
      }
    }
    return (A) this;
  }
  
  public A withResourcetemplates(List<TriggerResourceTemplate> resourcetemplates) {
    if (this.resourcetemplates != null) {
      this._visitables.get("resourcetemplates").clear();
    }
    if (resourcetemplates != null) {
        this.resourcetemplates = new ArrayList();
        for (TriggerResourceTemplate item : resourcetemplates) {
          this.addToResourcetemplates(item);
        }
    } else {
      this.resourcetemplates = null;
    }
    return (A) this;
  }
  
  public A withResourcetemplates(TriggerResourceTemplate... resourcetemplates) {
    if (this.resourcetemplates != null) {
        this.resourcetemplates.clear();
        _visitables.remove("resourcetemplates");
    }
    if (resourcetemplates != null) {
      for (TriggerResourceTemplate item : resourcetemplates) {
        this.addToResourcetemplates(item);
      }
    }
    return (A) this;
  }
  public class ParamsNested<N> extends ParamSpecFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamSpecBuilder builder;
    int index;
  
    ParamsNested(int index,ParamSpec item) {
      this.index = index;
      this.builder = new ParamSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerTemplateSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class ResourcetemplatesNested<N> extends TriggerResourceTemplateFluent<ResourcetemplatesNested<N>> implements Nested<N>{
  
    TriggerResourceTemplateBuilder builder;
    int index;
  
    ResourcetemplatesNested(int index,TriggerResourceTemplate item) {
      this.index = index;
      this.builder = new TriggerResourceTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) TriggerTemplateSpecFluent.this.setToResourcetemplates(index, builder.build());
    }
    
    public N endResourcetemplate() {
      return and();
    }
    
  }
}