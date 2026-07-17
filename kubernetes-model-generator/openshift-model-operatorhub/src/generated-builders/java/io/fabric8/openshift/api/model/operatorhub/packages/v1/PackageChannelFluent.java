package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
public class PackageChannelFluent<A extends io.fabric8.openshift.api.model.operatorhub.packages.v1.PackageChannelFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String currentCSV;
  private CSVDescriptionBuilder currentCSVDesc;
  private DeprecationBuilder deprecation;
  private ArrayList<ChannelEntryBuilder> entries = new ArrayList<ChannelEntryBuilder>();
  private String name;

  public PackageChannelFluent() {
  }
  
  public PackageChannelFluent(PackageChannel instance) {
    this.copyInstance(instance);
  }

  public A addAllToEntries(Collection<ChannelEntry> items) {
    if (this.entries == null) {
      this.entries = new ArrayList();
    }
    for (ChannelEntry item : items) {
        ChannelEntryBuilder builder = new ChannelEntryBuilder(item);
        _visitables.get("entries").add(builder);
        this.entries.add(builder);
    }
    return (A) this;
  }
  
  public EntriesNested<A> addNewEntry() {
    return new EntriesNested(-1, null);
  }
  
  public EntriesNested<A> addNewEntryLike(ChannelEntry item) {
    return new EntriesNested(-1, item);
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
  
  public A addToEntries(ChannelEntry... items) {
    if (this.entries == null) {
      this.entries = new ArrayList();
    }
    for (ChannelEntry item : items) {
        ChannelEntryBuilder builder = new ChannelEntryBuilder(item);
        _visitables.get("entries").add(builder);
        this.entries.add(builder);
    }
    return (A) this;
  }
  
  public A addToEntries(int index,ChannelEntry item) {
    if (this.entries == null) {
      this.entries = new ArrayList();
    }
    ChannelEntryBuilder builder = new ChannelEntryBuilder(item);
    if (index < 0 || index >= entries.size()) {
        _visitables.get("entries").add(builder);
        entries.add(builder);
    } else {
        _visitables.get("entries").add(builder);
        entries.add(index, builder);
    }
    return (A) this;
  }
  
  public CSVDescription buildCurrentCSVDesc() {
    return this.currentCSVDesc != null ? this.currentCSVDesc.build() : null;
  }
  
  public Deprecation buildDeprecation() {
    return this.deprecation != null ? this.deprecation.build() : null;
  }
  
  public List<ChannelEntry> buildEntries() {
    return this.entries != null ? build(entries) : null;
  }
  
  public ChannelEntry buildEntry(int index) {
    return this.entries.get(index).build();
  }
  
  public ChannelEntry buildFirstEntry() {
    return this.entries.get(0).build();
  }
  
  public ChannelEntry buildLastEntry() {
    return this.entries.get(entries.size() - 1).build();
  }
  
  public ChannelEntry buildMatchingEntry(Predicate<ChannelEntryBuilder> predicate) {
      for (ChannelEntryBuilder item : entries) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PackageChannel instance) {
    instance = instance != null ? instance : new PackageChannel();
    if (instance != null) {
        this.withCurrentCSV(instance.getCurrentCSV());
        this.withCurrentCSVDesc(instance.getCurrentCSVDesc());
        this.withDeprecation(instance.getDeprecation());
        this.withEntries(instance.getEntries());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CurrentCSVDescNested<A> editCurrentCSVDesc() {
    return this.withNewCurrentCSVDescLike(Optional.ofNullable(this.buildCurrentCSVDesc()).orElse(null));
  }
  
  public DeprecationNested<A> editDeprecation() {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(null));
  }
  
  public EntriesNested<A> editEntry(int index) {
    if (entries.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "entries"));
    }
    return this.setNewEntryLike(index, this.buildEntry(index));
  }
  
  public EntriesNested<A> editFirstEntry() {
    if (entries.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "entries"));
    }
    return this.setNewEntryLike(0, this.buildEntry(0));
  }
  
  public EntriesNested<A> editLastEntry() {
    int index = entries.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "entries"));
    }
    return this.setNewEntryLike(index, this.buildEntry(index));
  }
  
  public EntriesNested<A> editMatchingEntry(Predicate<ChannelEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < entries.size();i++) {
      if (predicate.test(entries.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "entries"));
    }
    return this.setNewEntryLike(index, this.buildEntry(index));
  }
  
  public CurrentCSVDescNested<A> editOrNewCurrentCSVDesc() {
    return this.withNewCurrentCSVDescLike(Optional.ofNullable(this.buildCurrentCSVDesc()).orElse(new CSVDescriptionBuilder().build()));
  }
  
  public CurrentCSVDescNested<A> editOrNewCurrentCSVDescLike(CSVDescription item) {
    return this.withNewCurrentCSVDescLike(Optional.ofNullable(this.buildCurrentCSVDesc()).orElse(item));
  }
  
  public DeprecationNested<A> editOrNewDeprecation() {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(new DeprecationBuilder().build()));
  }
  
  public DeprecationNested<A> editOrNewDeprecationLike(Deprecation item) {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(item));
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
    PackageChannelFluent that = (PackageChannelFluent) o;
    if (!(Objects.equals(currentCSV, that.currentCSV))) {
      return false;
    }
    if (!(Objects.equals(currentCSVDesc, that.currentCSVDesc))) {
      return false;
    }
    if (!(Objects.equals(deprecation, that.deprecation))) {
      return false;
    }
    if (!(Objects.equals(entries, that.entries))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getCurrentCSV() {
    return this.currentCSV;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentCSV() {
    return this.currentCSV != null;
  }
  
  public boolean hasCurrentCSVDesc() {
    return this.currentCSVDesc != null;
  }
  
  public boolean hasDeprecation() {
    return this.deprecation != null;
  }
  
  public boolean hasEntries() {
    return this.entries != null && !(this.entries.isEmpty());
  }
  
  public boolean hasMatchingEntry(Predicate<ChannelEntryBuilder> predicate) {
      for (ChannelEntryBuilder item : entries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentCSV, currentCSVDesc, deprecation, entries, name, additionalProperties);
  }
  
  public A removeAllFromEntries(Collection<ChannelEntry> items) {
    if (this.entries == null) {
      return (A) this;
    }
    for (ChannelEntry item : items) {
        ChannelEntryBuilder builder = new ChannelEntryBuilder(item);
        _visitables.get("entries").remove(builder);
        this.entries.remove(builder);
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
  
  public A removeFromEntries(ChannelEntry... items) {
    if (this.entries == null) {
      return (A) this;
    }
    for (ChannelEntry item : items) {
        ChannelEntryBuilder builder = new ChannelEntryBuilder(item);
        _visitables.get("entries").remove(builder);
        this.entries.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEntries(Predicate<ChannelEntryBuilder> predicate) {
    if (entries == null) {
      return (A) this;
    }
    Iterator<ChannelEntryBuilder> each = entries.iterator();
    List visitables = _visitables.get("entries");
    while (each.hasNext()) {
        ChannelEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EntriesNested<A> setNewEntryLike(int index,ChannelEntry item) {
    return new EntriesNested(index, item);
  }
  
  public A setToEntries(int index,ChannelEntry item) {
    if (this.entries == null) {
      this.entries = new ArrayList();
    }
    ChannelEntryBuilder builder = new ChannelEntryBuilder(item);
    if (index < 0 || index >= entries.size()) {
        _visitables.get("entries").add(builder);
        entries.add(builder);
    } else {
        _visitables.get("entries").add(builder);
        entries.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(currentCSV == null)) {
        sb.append("currentCSV:");
        sb.append(currentCSV);
        sb.append(",");
    }
    if (!(currentCSVDesc == null)) {
        sb.append("currentCSVDesc:");
        sb.append(currentCSVDesc);
        sb.append(",");
    }
    if (!(deprecation == null)) {
        sb.append("deprecation:");
        sb.append(deprecation);
        sb.append(",");
    }
    if (!(entries == null) && !(entries.isEmpty())) {
        sb.append("entries:");
        sb.append(entries);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withCurrentCSV(String currentCSV) {
    this.currentCSV = currentCSV;
    return (A) this;
  }
  
  public A withCurrentCSVDesc(CSVDescription currentCSVDesc) {
    this._visitables.remove("currentCSVDesc");
    if (currentCSVDesc != null) {
        this.currentCSVDesc = new CSVDescriptionBuilder(currentCSVDesc);
        this._visitables.get("currentCSVDesc").add(this.currentCSVDesc);
    } else {
        this.currentCSVDesc = null;
        this._visitables.get("currentCSVDesc").remove(this.currentCSVDesc);
    }
    return (A) this;
  }
  
  public A withDeprecation(Deprecation deprecation) {
    this._visitables.remove("deprecation");
    if (deprecation != null) {
        this.deprecation = new DeprecationBuilder(deprecation);
        this._visitables.get("deprecation").add(this.deprecation);
    } else {
        this.deprecation = null;
        this._visitables.get("deprecation").remove(this.deprecation);
    }
    return (A) this;
  }
  
  public A withEntries(List<ChannelEntry> entries) {
    if (this.entries != null) {
      this._visitables.get("entries").clear();
    }
    if (entries != null) {
        this.entries = new ArrayList();
        for (ChannelEntry item : entries) {
          this.addToEntries(item);
        }
    } else {
      this.entries = null;
    }
    return (A) this;
  }
  
  public A withEntries(ChannelEntry... entries) {
    if (this.entries != null) {
        this.entries.clear();
        _visitables.remove("entries");
    }
    if (entries != null) {
      for (ChannelEntry item : entries) {
        this.addToEntries(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public CurrentCSVDescNested<A> withNewCurrentCSVDesc() {
    return new CurrentCSVDescNested(null);
  }
  
  public CurrentCSVDescNested<A> withNewCurrentCSVDescLike(CSVDescription item) {
    return new CurrentCSVDescNested(item);
  }
  
  public DeprecationNested<A> withNewDeprecation() {
    return new DeprecationNested(null);
  }
  
  public A withNewDeprecation(String message) {
    return (A) this.withDeprecation(new Deprecation(message));
  }
  
  public DeprecationNested<A> withNewDeprecationLike(Deprecation item) {
    return new DeprecationNested(item);
  }
  public class CurrentCSVDescNested<N> extends CSVDescriptionFluent<CurrentCSVDescNested<N>> implements Nested<N>{
  
    CSVDescriptionBuilder builder;
  
    CurrentCSVDescNested(CSVDescription item) {
      this.builder = new CSVDescriptionBuilder(this, item);
    }
  
    public N and() {
      return (N) PackageChannelFluent.this.withCurrentCSVDesc(builder.build());
    }
    
    public N endCurrentCSVDesc() {
      return and();
    }
    
  }
  public class DeprecationNested<N> extends DeprecationFluent<DeprecationNested<N>> implements Nested<N>{
  
    DeprecationBuilder builder;
  
    DeprecationNested(Deprecation item) {
      this.builder = new DeprecationBuilder(this, item);
    }
  
    public N and() {
      return (N) PackageChannelFluent.this.withDeprecation(builder.build());
    }
    
    public N endDeprecation() {
      return and();
    }
    
  }
  public class EntriesNested<N> extends ChannelEntryFluent<EntriesNested<N>> implements Nested<N>{
  
    ChannelEntryBuilder builder;
    int index;
  
    EntriesNested(int index,ChannelEntry item) {
      this.index = index;
      this.builder = new ChannelEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) PackageChannelFluent.this.setToEntries(index, builder.build());
    }
    
    public N endEntry() {
      return and();
    }
    
  }
}