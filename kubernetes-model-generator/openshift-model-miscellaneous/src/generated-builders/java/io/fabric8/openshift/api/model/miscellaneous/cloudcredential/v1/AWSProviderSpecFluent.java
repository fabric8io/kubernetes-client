package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
public class AWSProviderSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.AWSProviderSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ArrayList<StatementEntryBuilder> statementEntries = new ArrayList<StatementEntryBuilder>();
  private String stsIAMRoleARN;

  public AWSProviderSpecFluent() {
  }
  
  public AWSProviderSpecFluent(AWSProviderSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToStatementEntries(Collection<StatementEntry> items) {
    if (this.statementEntries == null) {
      this.statementEntries = new ArrayList();
    }
    for (StatementEntry item : items) {
        StatementEntryBuilder builder = new StatementEntryBuilder(item);
        _visitables.get("statementEntries").add(builder);
        this.statementEntries.add(builder);
    }
    return (A) this;
  }
  
  public StatementEntriesNested<A> addNewStatementEntry() {
    return new StatementEntriesNested(-1, null);
  }
  
  public StatementEntriesNested<A> addNewStatementEntryLike(StatementEntry item) {
    return new StatementEntriesNested(-1, item);
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
  
  public A addToStatementEntries(StatementEntry... items) {
    if (this.statementEntries == null) {
      this.statementEntries = new ArrayList();
    }
    for (StatementEntry item : items) {
        StatementEntryBuilder builder = new StatementEntryBuilder(item);
        _visitables.get("statementEntries").add(builder);
        this.statementEntries.add(builder);
    }
    return (A) this;
  }
  
  public A addToStatementEntries(int index,StatementEntry item) {
    if (this.statementEntries == null) {
      this.statementEntries = new ArrayList();
    }
    StatementEntryBuilder builder = new StatementEntryBuilder(item);
    if (index < 0 || index >= statementEntries.size()) {
        _visitables.get("statementEntries").add(builder);
        statementEntries.add(builder);
    } else {
        _visitables.get("statementEntries").add(builder);
        statementEntries.add(index, builder);
    }
    return (A) this;
  }
  
  public StatementEntry buildFirstStatementEntry() {
    return this.statementEntries.get(0).build();
  }
  
  public StatementEntry buildLastStatementEntry() {
    return this.statementEntries.get(statementEntries.size() - 1).build();
  }
  
  public StatementEntry buildMatchingStatementEntry(Predicate<StatementEntryBuilder> predicate) {
      for (StatementEntryBuilder item : statementEntries) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<StatementEntry> buildStatementEntries() {
    return this.statementEntries != null ? build(statementEntries) : null;
  }
  
  public StatementEntry buildStatementEntry(int index) {
    return this.statementEntries.get(index).build();
  }
  
  protected void copyInstance(AWSProviderSpec instance) {
    instance = instance != null ? instance : new AWSProviderSpec();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withStatementEntries(instance.getStatementEntries());
        this.withStsIAMRoleARN(instance.getStsIAMRoleARN());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StatementEntriesNested<A> editFirstStatementEntry() {
    if (statementEntries.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "statementEntries"));
    }
    return this.setNewStatementEntryLike(0, this.buildStatementEntry(0));
  }
  
  public StatementEntriesNested<A> editLastStatementEntry() {
    int index = statementEntries.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "statementEntries"));
    }
    return this.setNewStatementEntryLike(index, this.buildStatementEntry(index));
  }
  
  public StatementEntriesNested<A> editMatchingStatementEntry(Predicate<StatementEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < statementEntries.size();i++) {
      if (predicate.test(statementEntries.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "statementEntries"));
    }
    return this.setNewStatementEntryLike(index, this.buildStatementEntry(index));
  }
  
  public StatementEntriesNested<A> editStatementEntry(int index) {
    if (statementEntries.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "statementEntries"));
    }
    return this.setNewStatementEntryLike(index, this.buildStatementEntry(index));
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
    AWSProviderSpecFluent that = (AWSProviderSpecFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(statementEntries, that.statementEntries))) {
      return false;
    }
    if (!(Objects.equals(stsIAMRoleARN, that.stsIAMRoleARN))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getStsIAMRoleARN() {
    return this.stsIAMRoleARN;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingStatementEntry(Predicate<StatementEntryBuilder> predicate) {
      for (StatementEntryBuilder item : statementEntries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStatementEntries() {
    return this.statementEntries != null && !(this.statementEntries.isEmpty());
  }
  
  public boolean hasStsIAMRoleARN() {
    return this.stsIAMRoleARN != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, statementEntries, stsIAMRoleARN, additionalProperties);
  }
  
  public A removeAllFromStatementEntries(Collection<StatementEntry> items) {
    if (this.statementEntries == null) {
      return (A) this;
    }
    for (StatementEntry item : items) {
        StatementEntryBuilder builder = new StatementEntryBuilder(item);
        _visitables.get("statementEntries").remove(builder);
        this.statementEntries.remove(builder);
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
  
  public A removeFromStatementEntries(StatementEntry... items) {
    if (this.statementEntries == null) {
      return (A) this;
    }
    for (StatementEntry item : items) {
        StatementEntryBuilder builder = new StatementEntryBuilder(item);
        _visitables.get("statementEntries").remove(builder);
        this.statementEntries.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromStatementEntries(Predicate<StatementEntryBuilder> predicate) {
    if (statementEntries == null) {
      return (A) this;
    }
    Iterator<StatementEntryBuilder> each = statementEntries.iterator();
    List visitables = _visitables.get("statementEntries");
    while (each.hasNext()) {
        StatementEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public StatementEntriesNested<A> setNewStatementEntryLike(int index,StatementEntry item) {
    return new StatementEntriesNested(index, item);
  }
  
  public A setToStatementEntries(int index,StatementEntry item) {
    if (this.statementEntries == null) {
      this.statementEntries = new ArrayList();
    }
    StatementEntryBuilder builder = new StatementEntryBuilder(item);
    if (index < 0 || index >= statementEntries.size()) {
        _visitables.get("statementEntries").add(builder);
        statementEntries.add(builder);
    } else {
        _visitables.get("statementEntries").add(builder);
        statementEntries.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(statementEntries == null) && !(statementEntries.isEmpty())) {
        sb.append("statementEntries:");
        sb.append(statementEntries);
        sb.append(",");
    }
    if (!(stsIAMRoleARN == null)) {
        sb.append("stsIAMRoleARN:");
        sb.append(stsIAMRoleARN);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withStatementEntries(List<StatementEntry> statementEntries) {
    if (this.statementEntries != null) {
      this._visitables.get("statementEntries").clear();
    }
    if (statementEntries != null) {
        this.statementEntries = new ArrayList();
        for (StatementEntry item : statementEntries) {
          this.addToStatementEntries(item);
        }
    } else {
      this.statementEntries = null;
    }
    return (A) this;
  }
  
  public A withStatementEntries(StatementEntry... statementEntries) {
    if (this.statementEntries != null) {
        this.statementEntries.clear();
        _visitables.remove("statementEntries");
    }
    if (statementEntries != null) {
      for (StatementEntry item : statementEntries) {
        this.addToStatementEntries(item);
      }
    }
    return (A) this;
  }
  
  public A withStsIAMRoleARN(String stsIAMRoleARN) {
    this.stsIAMRoleARN = stsIAMRoleARN;
    return (A) this;
  }
  public class StatementEntriesNested<N> extends StatementEntryFluent<StatementEntriesNested<N>> implements Nested<N>{
  
    StatementEntryBuilder builder;
    int index;
  
    StatementEntriesNested(int index,StatementEntry item) {
      this.index = index;
      this.builder = new StatementEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSProviderSpecFluent.this.setToStatementEntries(index, builder.build());
    }
    
    public N endStatementEntry() {
      return and();
    }
    
  }
}