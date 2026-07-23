package io.fabric8.tekton.v1;

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
public class MatrixFluent<A extends io.fabric8.tekton.v1.MatrixFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IncludeParamsBuilder> include = new ArrayList<IncludeParamsBuilder>();
  private ArrayList<ParamBuilder> params = new ArrayList<ParamBuilder>();

  public MatrixFluent() {
  }
  
  public MatrixFluent(Matrix instance) {
    this.copyInstance(instance);
  }

  public A addAllToInclude(Collection<IncludeParams> items) {
    if (this.include == null) {
      this.include = new ArrayList();
    }
    for (IncludeParams item : items) {
        IncludeParamsBuilder builder = new IncludeParamsBuilder(item);
        _visitables.get("include").add(builder);
        this.include.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToParams(Collection<Param> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public IncludeNested<A> addNewInclude() {
    return new IncludeNested(-1, null);
  }
  
  public IncludeNested<A> addNewIncludeLike(IncludeParams item) {
    return new IncludeNested(-1, item);
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public ParamsNested<A> addNewParamLike(Param item) {
    return new ParamsNested(-1, item);
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
  
  public A addToInclude(IncludeParams... items) {
    if (this.include == null) {
      this.include = new ArrayList();
    }
    for (IncludeParams item : items) {
        IncludeParamsBuilder builder = new IncludeParamsBuilder(item);
        _visitables.get("include").add(builder);
        this.include.add(builder);
    }
    return (A) this;
  }
  
  public A addToInclude(int index,IncludeParams item) {
    if (this.include == null) {
      this.include = new ArrayList();
    }
    IncludeParamsBuilder builder = new IncludeParamsBuilder(item);
    if (index < 0 || index >= include.size()) {
        _visitables.get("include").add(builder);
        include.add(builder);
    } else {
        _visitables.get("include").add(builder);
        include.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToParams(Param... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,Param item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamBuilder builder = new ParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
    }
    return (A) this;
  }
  
  public IncludeParams buildFirstInclude() {
    return this.include.get(0).build();
  }
  
  public Param buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public List<IncludeParams> buildInclude() {
    return this.include != null ? build(include) : null;
  }
  
  public IncludeParams buildInclude(int index) {
    return this.include.get(index).build();
  }
  
  public IncludeParams buildLastInclude() {
    return this.include.get(include.size() - 1).build();
  }
  
  public Param buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public IncludeParams buildMatchingInclude(Predicate<IncludeParamsBuilder> predicate) {
      for (IncludeParamsBuilder item : include) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Param buildMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Param buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<Param> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  protected void copyInstance(Matrix instance) {
    instance = instance != null ? instance : new Matrix();
    if (instance != null) {
        this.withInclude(instance.getInclude());
        this.withParams(instance.getParams());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IncludeNested<A> editFirstInclude() {
    if (include.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "include"));
    }
    return this.setNewIncludeLike(0, this.buildInclude(0));
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public IncludeNested<A> editInclude(int index) {
    if (include.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "include"));
    }
    return this.setNewIncludeLike(index, this.buildInclude(index));
  }
  
  public IncludeNested<A> editLastInclude() {
    int index = include.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "include"));
    }
    return this.setNewIncludeLike(index, this.buildInclude(index));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public IncludeNested<A> editMatchingInclude(Predicate<IncludeParamsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < include.size();i++) {
      if (predicate.test(include.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "include"));
    }
    return this.setNewIncludeLike(index, this.buildInclude(index));
  }
  
  public ParamsNested<A> editMatchingParam(Predicate<ParamBuilder> predicate) {
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
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
    MatrixFluent that = (MatrixFluent) o;
    if (!(Objects.equals(include, that.include))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
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
  
  public boolean hasInclude() {
    return this.include != null && !(this.include.isEmpty());
  }
  
  public boolean hasMatchingInclude(Predicate<IncludeParamsBuilder> predicate) {
      for (IncludeParamsBuilder item : include) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingParam(Predicate<ParamBuilder> predicate) {
      for (ParamBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(include, params, additionalProperties);
  }
  
  public A removeAllFromInclude(Collection<IncludeParams> items) {
    if (this.include == null) {
      return (A) this;
    }
    for (IncludeParams item : items) {
        IncludeParamsBuilder builder = new IncludeParamsBuilder(item);
        _visitables.get("include").remove(builder);
        this.include.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromParams(Collection<Param> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
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
  
  public A removeFromInclude(IncludeParams... items) {
    if (this.include == null) {
      return (A) this;
    }
    for (IncludeParams item : items) {
        IncludeParamsBuilder builder = new IncludeParamsBuilder(item);
        _visitables.get("include").remove(builder);
        this.include.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromParams(Param... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (Param item : items) {
        ParamBuilder builder = new ParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInclude(Predicate<IncludeParamsBuilder> predicate) {
    if (include == null) {
      return (A) this;
    }
    Iterator<IncludeParamsBuilder> each = include.iterator();
    List visitables = _visitables.get("include");
    while (each.hasNext()) {
        IncludeParamsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromParams(Predicate<ParamBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<ParamBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        ParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public IncludeNested<A> setNewIncludeLike(int index,IncludeParams item) {
    return new IncludeNested(index, item);
  }
  
  public ParamsNested<A> setNewParamLike(int index,Param item) {
    return new ParamsNested(index, item);
  }
  
  public A setToInclude(int index,IncludeParams item) {
    if (this.include == null) {
      this.include = new ArrayList();
    }
    IncludeParamsBuilder builder = new IncludeParamsBuilder(item);
    if (index < 0 || index >= include.size()) {
        _visitables.get("include").add(builder);
        include.add(builder);
    } else {
        _visitables.get("include").add(builder);
        include.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToParams(int index,Param item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ParamBuilder builder = new ParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(include == null) && !(include.isEmpty())) {
        sb.append("include:");
        sb.append(include);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
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
  
  public A withInclude(List<IncludeParams> include) {
    if (this.include != null) {
      this._visitables.get("include").clear();
    }
    if (include != null) {
        this.include = new ArrayList();
        for (IncludeParams item : include) {
          this.addToInclude(item);
        }
    } else {
      this.include = null;
    }
    return (A) this;
  }
  
  public A withInclude(IncludeParams... include) {
    if (this.include != null) {
        this.include.clear();
        _visitables.remove("include");
    }
    if (include != null) {
      for (IncludeParams item : include) {
        this.addToInclude(item);
      }
    }
    return (A) this;
  }
  
  public A withParams(List<Param> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (Param item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(Param... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (Param item : params) {
        this.addToParams(item);
      }
    }
    return (A) this;
  }
  public class IncludeNested<N> extends IncludeParamsFluent<IncludeNested<N>> implements Nested<N>{
  
    IncludeParamsBuilder builder;
    int index;
  
    IncludeNested(int index,IncludeParams item) {
      this.index = index;
      this.builder = new IncludeParamsBuilder(this, item);
    }
  
    public N and() {
      return (N) MatrixFluent.this.setToInclude(index, builder.build());
    }
    
    public N endInclude() {
      return and();
    }
    
  }
  public class ParamsNested<N> extends ParamFluent<ParamsNested<N>> implements Nested<N>{
  
    ParamBuilder builder;
    int index;
  
    ParamsNested(int index,Param item) {
      this.index = index;
      this.builder = new ParamBuilder(this, item);
    }
  
    public N and() {
      return (N) MatrixFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
}