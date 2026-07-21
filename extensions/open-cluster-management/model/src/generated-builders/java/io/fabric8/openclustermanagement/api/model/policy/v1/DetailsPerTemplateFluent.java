package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class DetailsPerTemplateFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.DetailsPerTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String compliant;
  private ArrayList<ComplianceHistoryBuilder> history = new ArrayList<ComplianceHistoryBuilder>();
  private ObjectMetaBuilder templateMeta;

  public DetailsPerTemplateFluent() {
  }
  
  public DetailsPerTemplateFluent(DetailsPerTemplate instance) {
    this.copyInstance(instance);
  }

  public A addAllToHistory(Collection<ComplianceHistory> items) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    for (ComplianceHistory item : items) {
        ComplianceHistoryBuilder builder = new ComplianceHistoryBuilder(item);
        _visitables.get("history").add(builder);
        this.history.add(builder);
    }
    return (A) this;
  }
  
  public HistoryNested<A> addNewHistory() {
    return new HistoryNested(-1, null);
  }
  
  public A addNewHistory(String eventName,String lastTimestamp,String message) {
    return (A) this.addToHistory(new ComplianceHistory(eventName, lastTimestamp, message));
  }
  
  public HistoryNested<A> addNewHistoryLike(ComplianceHistory item) {
    return new HistoryNested(-1, item);
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
  
  public A addToHistory(ComplianceHistory... items) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    for (ComplianceHistory item : items) {
        ComplianceHistoryBuilder builder = new ComplianceHistoryBuilder(item);
        _visitables.get("history").add(builder);
        this.history.add(builder);
    }
    return (A) this;
  }
  
  public A addToHistory(int index,ComplianceHistory item) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    ComplianceHistoryBuilder builder = new ComplianceHistoryBuilder(item);
    if (index < 0 || index >= history.size()) {
        _visitables.get("history").add(builder);
        history.add(builder);
    } else {
        _visitables.get("history").add(builder);
        history.add(index, builder);
    }
    return (A) this;
  }
  
  public ComplianceHistory buildFirstHistory() {
    return this.history.get(0).build();
  }
  
  public List<ComplianceHistory> buildHistory() {
    return this.history != null ? build(history) : null;
  }
  
  public ComplianceHistory buildHistory(int index) {
    return this.history.get(index).build();
  }
  
  public ComplianceHistory buildLastHistory() {
    return this.history.get(history.size() - 1).build();
  }
  
  public ComplianceHistory buildMatchingHistory(Predicate<ComplianceHistoryBuilder> predicate) {
      for (ComplianceHistoryBuilder item : history) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildTemplateMeta() {
    return this.templateMeta != null ? this.templateMeta.build() : null;
  }
  
  protected void copyInstance(DetailsPerTemplate instance) {
    instance = instance != null ? instance : new DetailsPerTemplate();
    if (instance != null) {
        this.withCompliant(instance.getCompliant());
        this.withHistory(instance.getHistory());
        this.withTemplateMeta(instance.getTemplateMeta());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HistoryNested<A> editFirstHistory() {
    if (history.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "history"));
    }
    return this.setNewHistoryLike(0, this.buildHistory(0));
  }
  
  public HistoryNested<A> editHistory(int index) {
    if (history.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "history"));
    }
    return this.setNewHistoryLike(index, this.buildHistory(index));
  }
  
  public HistoryNested<A> editLastHistory() {
    int index = history.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "history"));
    }
    return this.setNewHistoryLike(index, this.buildHistory(index));
  }
  
  public HistoryNested<A> editMatchingHistory(Predicate<ComplianceHistoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < history.size();i++) {
      if (predicate.test(history.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "history"));
    }
    return this.setNewHistoryLike(index, this.buildHistory(index));
  }
  
  public TemplateMetaNested<A> editOrNewTemplateMeta() {
    return this.withNewTemplateMetaLike(Optional.ofNullable(this.buildTemplateMeta()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public TemplateMetaNested<A> editOrNewTemplateMetaLike(ObjectMeta item) {
    return this.withNewTemplateMetaLike(Optional.ofNullable(this.buildTemplateMeta()).orElse(item));
  }
  
  public TemplateMetaNested<A> editTemplateMeta() {
    return this.withNewTemplateMetaLike(Optional.ofNullable(this.buildTemplateMeta()).orElse(null));
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
    DetailsPerTemplateFluent that = (DetailsPerTemplateFluent) o;
    if (!(Objects.equals(compliant, that.compliant))) {
      return false;
    }
    if (!(Objects.equals(history, that.history))) {
      return false;
    }
    if (!(Objects.equals(templateMeta, that.templateMeta))) {
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
  
  public String getCompliant() {
    return this.compliant;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompliant() {
    return this.compliant != null;
  }
  
  public boolean hasHistory() {
    return this.history != null && !(this.history.isEmpty());
  }
  
  public boolean hasMatchingHistory(Predicate<ComplianceHistoryBuilder> predicate) {
      for (ComplianceHistoryBuilder item : history) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTemplateMeta() {
    return this.templateMeta != null;
  }
  
  public int hashCode() {
    return Objects.hash(compliant, history, templateMeta, additionalProperties);
  }
  
  public A removeAllFromHistory(Collection<ComplianceHistory> items) {
    if (this.history == null) {
      return (A) this;
    }
    for (ComplianceHistory item : items) {
        ComplianceHistoryBuilder builder = new ComplianceHistoryBuilder(item);
        _visitables.get("history").remove(builder);
        this.history.remove(builder);
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
  
  public A removeFromHistory(ComplianceHistory... items) {
    if (this.history == null) {
      return (A) this;
    }
    for (ComplianceHistory item : items) {
        ComplianceHistoryBuilder builder = new ComplianceHistoryBuilder(item);
        _visitables.get("history").remove(builder);
        this.history.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHistory(Predicate<ComplianceHistoryBuilder> predicate) {
    if (history == null) {
      return (A) this;
    }
    Iterator<ComplianceHistoryBuilder> each = history.iterator();
    List visitables = _visitables.get("history");
    while (each.hasNext()) {
        ComplianceHistoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HistoryNested<A> setNewHistoryLike(int index,ComplianceHistory item) {
    return new HistoryNested(index, item);
  }
  
  public A setToHistory(int index,ComplianceHistory item) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    ComplianceHistoryBuilder builder = new ComplianceHistoryBuilder(item);
    if (index < 0 || index >= history.size()) {
        _visitables.get("history").add(builder);
        history.add(builder);
    } else {
        _visitables.get("history").add(builder);
        history.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(compliant == null)) {
        sb.append("compliant:");
        sb.append(compliant);
        sb.append(",");
    }
    if (!(history == null) && !(history.isEmpty())) {
        sb.append("history:");
        sb.append(history);
        sb.append(",");
    }
    if (!(templateMeta == null)) {
        sb.append("templateMeta:");
        sb.append(templateMeta);
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
  
  public A withCompliant(String compliant) {
    this.compliant = compliant;
    return (A) this;
  }
  
  public A withHistory(List<ComplianceHistory> history) {
    if (this.history != null) {
      this._visitables.get("history").clear();
    }
    if (history != null) {
        this.history = new ArrayList();
        for (ComplianceHistory item : history) {
          this.addToHistory(item);
        }
    } else {
      this.history = null;
    }
    return (A) this;
  }
  
  public A withHistory(ComplianceHistory... history) {
    if (this.history != null) {
        this.history.clear();
        _visitables.remove("history");
    }
    if (history != null) {
      for (ComplianceHistory item : history) {
        this.addToHistory(item);
      }
    }
    return (A) this;
  }
  
  public TemplateMetaNested<A> withNewTemplateMeta() {
    return new TemplateMetaNested(null);
  }
  
  public TemplateMetaNested<A> withNewTemplateMetaLike(ObjectMeta item) {
    return new TemplateMetaNested(item);
  }
  
  public A withTemplateMeta(ObjectMeta templateMeta) {
    this._visitables.remove("templateMeta");
    if (templateMeta != null) {
        this.templateMeta = new ObjectMetaBuilder(templateMeta);
        this._visitables.get("templateMeta").add(this.templateMeta);
    } else {
        this.templateMeta = null;
        this._visitables.get("templateMeta").remove(this.templateMeta);
    }
    return (A) this;
  }
  public class HistoryNested<N> extends ComplianceHistoryFluent<HistoryNested<N>> implements Nested<N>{
  
    ComplianceHistoryBuilder builder;
    int index;
  
    HistoryNested(int index,ComplianceHistory item) {
      this.index = index;
      this.builder = new ComplianceHistoryBuilder(this, item);
    }
  
    public N and() {
      return (N) DetailsPerTemplateFluent.this.setToHistory(index, builder.build());
    }
    
    public N endHistory() {
      return and();
    }
    
  }
  public class TemplateMetaNested<N> extends ObjectMetaFluent<TemplateMetaNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    TemplateMetaNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) DetailsPerTemplateFluent.this.withTemplateMeta(builder.build());
    }
    
    public N endTemplateMeta() {
      return and();
    }
    
  }
}