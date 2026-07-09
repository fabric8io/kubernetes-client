package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class TargetSelectorFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.TargetSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> fieldPaths = new ArrayList<String>();
  private FieldOptionsBuilder options;
  private ArrayList<SelectorBuilder> reject = new ArrayList<SelectorBuilder>();
  private SelectorBuilder select;

  public TargetSelectorFluent() {
  }
  
  public TargetSelectorFluent(TargetSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToFieldPaths(Collection<String> items) {
    if (this.fieldPaths == null) {
      this.fieldPaths = new ArrayList();
    }
    for (String item : items) {
      this.fieldPaths.add(item);
    }
    return (A) this;
  }
  
  public A addAllToReject(Collection<Selector> items) {
    if (this.reject == null) {
      this.reject = new ArrayList();
    }
    for (Selector item : items) {
        SelectorBuilder builder = new SelectorBuilder(item);
        _visitables.get("reject").add(builder);
        this.reject.add(builder);
    }
    return (A) this;
  }
  
  public RejectNested<A> addNewReject() {
    return new RejectNested(-1, null);
  }
  
  public RejectNested<A> addNewRejectLike(Selector item) {
    return new RejectNested(-1, item);
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
  
  public A addToFieldPaths(String... items) {
    if (this.fieldPaths == null) {
      this.fieldPaths = new ArrayList();
    }
    for (String item : items) {
      this.fieldPaths.add(item);
    }
    return (A) this;
  }
  
  public A addToFieldPaths(int index,String item) {
    if (this.fieldPaths == null) {
      this.fieldPaths = new ArrayList();
    }
    this.fieldPaths.add(index, item);
    return (A) this;
  }
  
  public A addToReject(Selector... items) {
    if (this.reject == null) {
      this.reject = new ArrayList();
    }
    for (Selector item : items) {
        SelectorBuilder builder = new SelectorBuilder(item);
        _visitables.get("reject").add(builder);
        this.reject.add(builder);
    }
    return (A) this;
  }
  
  public A addToReject(int index,Selector item) {
    if (this.reject == null) {
      this.reject = new ArrayList();
    }
    SelectorBuilder builder = new SelectorBuilder(item);
    if (index < 0 || index >= reject.size()) {
        _visitables.get("reject").add(builder);
        reject.add(builder);
    } else {
        _visitables.get("reject").add(builder);
        reject.add(index, builder);
    }
    return (A) this;
  }
  
  public Selector buildFirstReject() {
    return this.reject.get(0).build();
  }
  
  public Selector buildLastReject() {
    return this.reject.get(reject.size() - 1).build();
  }
  
  public Selector buildMatchingReject(Predicate<SelectorBuilder> predicate) {
      for (SelectorBuilder item : reject) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FieldOptions buildOptions() {
    return this.options != null ? this.options.build() : null;
  }
  
  public List<Selector> buildReject() {
    return this.reject != null ? build(reject) : null;
  }
  
  public Selector buildReject(int index) {
    return this.reject.get(index).build();
  }
  
  public Selector buildSelect() {
    return this.select != null ? this.select.build() : null;
  }
  
  protected void copyInstance(TargetSelector instance) {
    instance = instance != null ? instance : new TargetSelector();
    if (instance != null) {
        this.withFieldPaths(instance.getFieldPaths());
        this.withOptions(instance.getOptions());
        this.withReject(instance.getReject());
        this.withSelect(instance.getSelect());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RejectNested<A> editFirstReject() {
    if (reject.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "reject"));
    }
    return this.setNewRejectLike(0, this.buildReject(0));
  }
  
  public RejectNested<A> editLastReject() {
    int index = reject.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "reject"));
    }
    return this.setNewRejectLike(index, this.buildReject(index));
  }
  
  public RejectNested<A> editMatchingReject(Predicate<SelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < reject.size();i++) {
      if (predicate.test(reject.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "reject"));
    }
    return this.setNewRejectLike(index, this.buildReject(index));
  }
  
  public OptionsNested<A> editOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(null));
  }
  
  public OptionsNested<A> editOrNewOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(new FieldOptionsBuilder().build()));
  }
  
  public OptionsNested<A> editOrNewOptionsLike(FieldOptions item) {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(item));
  }
  
  public SelectNested<A> editOrNewSelect() {
    return this.withNewSelectLike(Optional.ofNullable(this.buildSelect()).orElse(new SelectorBuilder().build()));
  }
  
  public SelectNested<A> editOrNewSelectLike(Selector item) {
    return this.withNewSelectLike(Optional.ofNullable(this.buildSelect()).orElse(item));
  }
  
  public RejectNested<A> editReject(int index) {
    if (reject.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "reject"));
    }
    return this.setNewRejectLike(index, this.buildReject(index));
  }
  
  public SelectNested<A> editSelect() {
    return this.withNewSelectLike(Optional.ofNullable(this.buildSelect()).orElse(null));
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
    TargetSelectorFluent that = (TargetSelectorFluent) o;
    if (!(Objects.equals(fieldPaths, that.fieldPaths))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(reject, that.reject))) {
      return false;
    }
    if (!(Objects.equals(select, that.select))) {
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
  
  public String getFieldPath(int index) {
    return this.fieldPaths.get(index);
  }
  
  public List<String> getFieldPaths() {
    return this.fieldPaths;
  }
  
  public String getFirstFieldPath() {
    return this.fieldPaths.get(0);
  }
  
  public String getLastFieldPath() {
    return this.fieldPaths.get(fieldPaths.size() - 1);
  }
  
  public String getMatchingFieldPath(Predicate<String> predicate) {
      for (String item : fieldPaths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFieldPaths() {
    return this.fieldPaths != null && !(this.fieldPaths.isEmpty());
  }
  
  public boolean hasMatchingFieldPath(Predicate<String> predicate) {
      for (String item : fieldPaths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingReject(Predicate<SelectorBuilder> predicate) {
      for (SelectorBuilder item : reject) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasReject() {
    return this.reject != null && !(this.reject.isEmpty());
  }
  
  public boolean hasSelect() {
    return this.select != null;
  }
  
  public int hashCode() {
    return Objects.hash(fieldPaths, options, reject, select, additionalProperties);
  }
  
  public A removeAllFromFieldPaths(Collection<String> items) {
    if (this.fieldPaths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.fieldPaths.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromReject(Collection<Selector> items) {
    if (this.reject == null) {
      return (A) this;
    }
    for (Selector item : items) {
        SelectorBuilder builder = new SelectorBuilder(item);
        _visitables.get("reject").remove(builder);
        this.reject.remove(builder);
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
  
  public A removeFromFieldPaths(String... items) {
    if (this.fieldPaths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.fieldPaths.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromReject(Selector... items) {
    if (this.reject == null) {
      return (A) this;
    }
    for (Selector item : items) {
        SelectorBuilder builder = new SelectorBuilder(item);
        _visitables.get("reject").remove(builder);
        this.reject.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromReject(Predicate<SelectorBuilder> predicate) {
    if (reject == null) {
      return (A) this;
    }
    Iterator<SelectorBuilder> each = reject.iterator();
    List visitables = _visitables.get("reject");
    while (each.hasNext()) {
        SelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RejectNested<A> setNewRejectLike(int index,Selector item) {
    return new RejectNested(index, item);
  }
  
  public A setToFieldPaths(int index,String item) {
    if (this.fieldPaths == null) {
      this.fieldPaths = new ArrayList();
    }
    this.fieldPaths.set(index, item);
    return (A) this;
  }
  
  public A setToReject(int index,Selector item) {
    if (this.reject == null) {
      this.reject = new ArrayList();
    }
    SelectorBuilder builder = new SelectorBuilder(item);
    if (index < 0 || index >= reject.size()) {
        _visitables.get("reject").add(builder);
        reject.add(builder);
    } else {
        _visitables.get("reject").add(builder);
        reject.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fieldPaths == null) && !(fieldPaths.isEmpty())) {
        sb.append("fieldPaths:");
        sb.append(fieldPaths);
        sb.append(",");
    }
    if (!(options == null)) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(reject == null) && !(reject.isEmpty())) {
        sb.append("reject:");
        sb.append(reject);
        sb.append(",");
    }
    if (!(select == null)) {
        sb.append("select:");
        sb.append(select);
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
  
  public A withFieldPaths(List<String> fieldPaths) {
    if (fieldPaths != null) {
        this.fieldPaths = new ArrayList();
        for (String item : fieldPaths) {
          this.addToFieldPaths(item);
        }
    } else {
      this.fieldPaths = null;
    }
    return (A) this;
  }
  
  public A withFieldPaths(String... fieldPaths) {
    if (this.fieldPaths != null) {
        this.fieldPaths.clear();
        _visitables.remove("fieldPaths");
    }
    if (fieldPaths != null) {
      for (String item : fieldPaths) {
        this.addToFieldPaths(item);
      }
    }
    return (A) this;
  }
  
  public OptionsNested<A> withNewOptions() {
    return new OptionsNested(null);
  }
  
  public A withNewOptions(Boolean create,String delimiter,String encoding,Integer index) {
    return (A) this.withOptions(new FieldOptions(create, delimiter, encoding, index));
  }
  
  public OptionsNested<A> withNewOptionsLike(FieldOptions item) {
    return new OptionsNested(item);
  }
  
  public SelectNested<A> withNewSelect() {
    return new SelectNested(null);
  }
  
  public SelectNested<A> withNewSelectLike(Selector item) {
    return new SelectNested(item);
  }
  
  public A withOptions(FieldOptions options) {
    this._visitables.remove("options");
    if (options != null) {
        this.options = new FieldOptionsBuilder(options);
        this._visitables.get("options").add(this.options);
    } else {
        this.options = null;
        this._visitables.get("options").remove(this.options);
    }
    return (A) this;
  }
  
  public A withReject(List<Selector> reject) {
    if (this.reject != null) {
      this._visitables.get("reject").clear();
    }
    if (reject != null) {
        this.reject = new ArrayList();
        for (Selector item : reject) {
          this.addToReject(item);
        }
    } else {
      this.reject = null;
    }
    return (A) this;
  }
  
  public A withReject(Selector... reject) {
    if (this.reject != null) {
        this.reject.clear();
        _visitables.remove("reject");
    }
    if (reject != null) {
      for (Selector item : reject) {
        this.addToReject(item);
      }
    }
    return (A) this;
  }
  
  public A withSelect(Selector select) {
    this._visitables.remove("select");
    if (select != null) {
        this.select = new SelectorBuilder(select);
        this._visitables.get("select").add(this.select);
    } else {
        this.select = null;
        this._visitables.get("select").remove(this.select);
    }
    return (A) this;
  }
  public class OptionsNested<N> extends FieldOptionsFluent<OptionsNested<N>> implements Nested<N>{
  
    FieldOptionsBuilder builder;
  
    OptionsNested(FieldOptions item) {
      this.builder = new FieldOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) TargetSelectorFluent.this.withOptions(builder.build());
    }
    
    public N endOptions() {
      return and();
    }
    
  }
  public class RejectNested<N> extends SelectorFluent<RejectNested<N>> implements Nested<N>{
  
    SelectorBuilder builder;
    int index;
  
    RejectNested(int index,Selector item) {
      this.index = index;
      this.builder = new SelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TargetSelectorFluent.this.setToReject(index, builder.build());
    }
    
    public N endReject() {
      return and();
    }
    
  }
  public class SelectNested<N> extends SelectorFluent<SelectNested<N>> implements Nested<N>{
  
    SelectorBuilder builder;
  
    SelectNested(Selector item) {
      this.builder = new SelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TargetSelectorFluent.this.withSelect(builder.build());
    }
    
    public N endSelect() {
      return and();
    }
    
  }
}