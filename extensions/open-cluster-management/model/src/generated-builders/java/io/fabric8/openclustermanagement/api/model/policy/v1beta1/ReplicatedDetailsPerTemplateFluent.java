package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
public class ReplicatedDetailsPerTemplateFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.ReplicatedDetailsPerTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String compliant;
  private ArrayList<ReplicatedComplianceHistoryBuilder> history = new ArrayList<ReplicatedComplianceHistoryBuilder>();

  public ReplicatedDetailsPerTemplateFluent() {
  }
  
  public ReplicatedDetailsPerTemplateFluent(ReplicatedDetailsPerTemplate instance) {
    this.copyInstance(instance);
  }

  public A addAllToHistory(Collection<ReplicatedComplianceHistory> items) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    for (ReplicatedComplianceHistory item : items) {
        ReplicatedComplianceHistoryBuilder builder = new ReplicatedComplianceHistoryBuilder(item);
        _visitables.get("history").add(builder);
        this.history.add(builder);
    }
    return (A) this;
  }
  
  public HistoryNested<A> addNewHistory() {
    return new HistoryNested(-1, null);
  }
  
  public A addNewHistory(String lastTimestamp,String message) {
    return (A) this.addToHistory(new ReplicatedComplianceHistory(lastTimestamp, message));
  }
  
  public HistoryNested<A> addNewHistoryLike(ReplicatedComplianceHistory item) {
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
  
  public A addToHistory(ReplicatedComplianceHistory... items) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    for (ReplicatedComplianceHistory item : items) {
        ReplicatedComplianceHistoryBuilder builder = new ReplicatedComplianceHistoryBuilder(item);
        _visitables.get("history").add(builder);
        this.history.add(builder);
    }
    return (A) this;
  }
  
  public A addToHistory(int index,ReplicatedComplianceHistory item) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    ReplicatedComplianceHistoryBuilder builder = new ReplicatedComplianceHistoryBuilder(item);
    if (index < 0 || index >= history.size()) {
        _visitables.get("history").add(builder);
        history.add(builder);
    } else {
        _visitables.get("history").add(builder);
        history.add(index, builder);
    }
    return (A) this;
  }
  
  public ReplicatedComplianceHistory buildFirstHistory() {
    return this.history.get(0).build();
  }
  
  public List<ReplicatedComplianceHistory> buildHistory() {
    return this.history != null ? build(history) : null;
  }
  
  public ReplicatedComplianceHistory buildHistory(int index) {
    return this.history.get(index).build();
  }
  
  public ReplicatedComplianceHistory buildLastHistory() {
    return this.history.get(history.size() - 1).build();
  }
  
  public ReplicatedComplianceHistory buildMatchingHistory(Predicate<ReplicatedComplianceHistoryBuilder> predicate) {
      for (ReplicatedComplianceHistoryBuilder item : history) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ReplicatedDetailsPerTemplate instance) {
    instance = instance != null ? instance : new ReplicatedDetailsPerTemplate();
    if (instance != null) {
        this.withCompliant(instance.getCompliant());
        this.withHistory(instance.getHistory());
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
  
  public HistoryNested<A> editMatchingHistory(Predicate<ReplicatedComplianceHistoryBuilder> predicate) {
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
    ReplicatedDetailsPerTemplateFluent that = (ReplicatedDetailsPerTemplateFluent) o;
    if (!(Objects.equals(compliant, that.compliant))) {
      return false;
    }
    if (!(Objects.equals(history, that.history))) {
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
  
  public boolean hasMatchingHistory(Predicate<ReplicatedComplianceHistoryBuilder> predicate) {
      for (ReplicatedComplianceHistoryBuilder item : history) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(compliant, history, additionalProperties);
  }
  
  public A removeAllFromHistory(Collection<ReplicatedComplianceHistory> items) {
    if (this.history == null) {
      return (A) this;
    }
    for (ReplicatedComplianceHistory item : items) {
        ReplicatedComplianceHistoryBuilder builder = new ReplicatedComplianceHistoryBuilder(item);
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
  
  public A removeFromHistory(ReplicatedComplianceHistory... items) {
    if (this.history == null) {
      return (A) this;
    }
    for (ReplicatedComplianceHistory item : items) {
        ReplicatedComplianceHistoryBuilder builder = new ReplicatedComplianceHistoryBuilder(item);
        _visitables.get("history").remove(builder);
        this.history.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHistory(Predicate<ReplicatedComplianceHistoryBuilder> predicate) {
    if (history == null) {
      return (A) this;
    }
    Iterator<ReplicatedComplianceHistoryBuilder> each = history.iterator();
    List visitables = _visitables.get("history");
    while (each.hasNext()) {
        ReplicatedComplianceHistoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HistoryNested<A> setNewHistoryLike(int index,ReplicatedComplianceHistory item) {
    return new HistoryNested(index, item);
  }
  
  public A setToHistory(int index,ReplicatedComplianceHistory item) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    ReplicatedComplianceHistoryBuilder builder = new ReplicatedComplianceHistoryBuilder(item);
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
  
  public A withHistory(List<ReplicatedComplianceHistory> history) {
    if (this.history != null) {
      this._visitables.get("history").clear();
    }
    if (history != null) {
        this.history = new ArrayList();
        for (ReplicatedComplianceHistory item : history) {
          this.addToHistory(item);
        }
    } else {
      this.history = null;
    }
    return (A) this;
  }
  
  public A withHistory(ReplicatedComplianceHistory... history) {
    if (this.history != null) {
        this.history.clear();
        _visitables.remove("history");
    }
    if (history != null) {
      for (ReplicatedComplianceHistory item : history) {
        this.addToHistory(item);
      }
    }
    return (A) this;
  }
  public class HistoryNested<N> extends ReplicatedComplianceHistoryFluent<HistoryNested<N>> implements Nested<N>{
  
    ReplicatedComplianceHistoryBuilder builder;
    int index;
  
    HistoryNested(int index,ReplicatedComplianceHistory item) {
      this.index = index;
      this.builder = new ReplicatedComplianceHistoryBuilder(this, item);
    }
  
    public N and() {
      return (N) ReplicatedDetailsPerTemplateFluent.this.setToHistory(index, builder.build());
    }
    
    public N endHistory() {
      return and();
    }
    
  }
}