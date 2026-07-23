package io.fabric8.openshift.api.model.monitoring.v1;

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
public class PodDNSConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.PodDNSConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> nameservers = new ArrayList<String>();
  private ArrayList<PodDNSConfigOptionBuilder> options = new ArrayList<PodDNSConfigOptionBuilder>();
  private List<String> searches = new ArrayList<String>();

  public PodDNSConfigFluent() {
  }
  
  public PodDNSConfigFluent(PodDNSConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOptions(Collection<PodDNSConfigOption> items) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    for (PodDNSConfigOption item : items) {
        PodDNSConfigOptionBuilder builder = new PodDNSConfigOptionBuilder(item);
        _visitables.get("options").add(builder);
        this.options.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSearches(Collection<String> items) {
    if (this.searches == null) {
      this.searches = new ArrayList();
    }
    for (String item : items) {
      this.searches.add(item);
    }
    return (A) this;
  }
  
  public OptionsNested<A> addNewOption() {
    return new OptionsNested(-1, null);
  }
  
  public A addNewOption(String name,String value) {
    return (A) this.addToOptions(new PodDNSConfigOption(name, value));
  }
  
  public OptionsNested<A> addNewOptionLike(PodDNSConfigOption item) {
    return new OptionsNested(-1, item);
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
  
  public A addToNameservers(String... items) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    for (String item : items) {
      this.nameservers.add(item);
    }
    return (A) this;
  }
  
  public A addToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.add(index, item);
    return (A) this;
  }
  
  public A addToOptions(PodDNSConfigOption... items) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    for (PodDNSConfigOption item : items) {
        PodDNSConfigOptionBuilder builder = new PodDNSConfigOptionBuilder(item);
        _visitables.get("options").add(builder);
        this.options.add(builder);
    }
    return (A) this;
  }
  
  public A addToOptions(int index,PodDNSConfigOption item) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    PodDNSConfigOptionBuilder builder = new PodDNSConfigOptionBuilder(item);
    if (index < 0 || index >= options.size()) {
        _visitables.get("options").add(builder);
        options.add(builder);
    } else {
        _visitables.get("options").add(builder);
        options.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSearches(String... items) {
    if (this.searches == null) {
      this.searches = new ArrayList();
    }
    for (String item : items) {
      this.searches.add(item);
    }
    return (A) this;
  }
  
  public A addToSearches(int index,String item) {
    if (this.searches == null) {
      this.searches = new ArrayList();
    }
    this.searches.add(index, item);
    return (A) this;
  }
  
  public PodDNSConfigOption buildFirstOption() {
    return this.options.get(0).build();
  }
  
  public PodDNSConfigOption buildLastOption() {
    return this.options.get(options.size() - 1).build();
  }
  
  public PodDNSConfigOption buildMatchingOption(Predicate<PodDNSConfigOptionBuilder> predicate) {
      for (PodDNSConfigOptionBuilder item : options) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodDNSConfigOption buildOption(int index) {
    return this.options.get(index).build();
  }
  
  public List<PodDNSConfigOption> buildOptions() {
    return this.options != null ? build(options) : null;
  }
  
  protected void copyInstance(PodDNSConfig instance) {
    instance = instance != null ? instance : new PodDNSConfig();
    if (instance != null) {
        this.withNameservers(instance.getNameservers());
        this.withOptions(instance.getOptions());
        this.withSearches(instance.getSearches());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OptionsNested<A> editFirstOption() {
    if (options.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "options"));
    }
    return this.setNewOptionLike(0, this.buildOption(0));
  }
  
  public OptionsNested<A> editLastOption() {
    int index = options.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "options"));
    }
    return this.setNewOptionLike(index, this.buildOption(index));
  }
  
  public OptionsNested<A> editMatchingOption(Predicate<PodDNSConfigOptionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < options.size();i++) {
      if (predicate.test(options.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "options"));
    }
    return this.setNewOptionLike(index, this.buildOption(index));
  }
  
  public OptionsNested<A> editOption(int index) {
    if (options.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "options"));
    }
    return this.setNewOptionLike(index, this.buildOption(index));
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
    PodDNSConfigFluent that = (PodDNSConfigFluent) o;
    if (!(Objects.equals(nameservers, that.nameservers))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(searches, that.searches))) {
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
  
  public String getFirstNameserver() {
    return this.nameservers.get(0);
  }
  
  public String getFirstSearch() {
    return this.searches.get(0);
  }
  
  public String getLastNameserver() {
    return this.nameservers.get(nameservers.size() - 1);
  }
  
  public String getLastSearch() {
    return this.searches.get(searches.size() - 1);
  }
  
  public String getMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSearch(Predicate<String> predicate) {
      for (String item : searches) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameserver(int index) {
    return this.nameservers.get(index);
  }
  
  public List<String> getNameservers() {
    return this.nameservers;
  }
  
  public String getSearch(int index) {
    return this.searches.get(index);
  }
  
  public List<String> getSearches() {
    return this.searches;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingNameserver(Predicate<String> predicate) {
      for (String item : nameservers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOption(Predicate<PodDNSConfigOptionBuilder> predicate) {
      for (PodDNSConfigOptionBuilder item : options) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSearch(Predicate<String> predicate) {
      for (String item : searches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameservers() {
    return this.nameservers != null && !(this.nameservers.isEmpty());
  }
  
  public boolean hasOptions() {
    return this.options != null && !(this.options.isEmpty());
  }
  
  public boolean hasSearches() {
    return this.searches != null && !(this.searches.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(nameservers, options, searches, additionalProperties);
  }
  
  public A removeAllFromNameservers(Collection<String> items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOptions(Collection<PodDNSConfigOption> items) {
    if (this.options == null) {
      return (A) this;
    }
    for (PodDNSConfigOption item : items) {
        PodDNSConfigOptionBuilder builder = new PodDNSConfigOptionBuilder(item);
        _visitables.get("options").remove(builder);
        this.options.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSearches(Collection<String> items) {
    if (this.searches == null) {
      return (A) this;
    }
    for (String item : items) {
      this.searches.remove(item);
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
  
  public A removeFromNameservers(String... items) {
    if (this.nameservers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameservers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOptions(PodDNSConfigOption... items) {
    if (this.options == null) {
      return (A) this;
    }
    for (PodDNSConfigOption item : items) {
        PodDNSConfigOptionBuilder builder = new PodDNSConfigOptionBuilder(item);
        _visitables.get("options").remove(builder);
        this.options.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSearches(String... items) {
    if (this.searches == null) {
      return (A) this;
    }
    for (String item : items) {
      this.searches.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOptions(Predicate<PodDNSConfigOptionBuilder> predicate) {
    if (options == null) {
      return (A) this;
    }
    Iterator<PodDNSConfigOptionBuilder> each = options.iterator();
    List visitables = _visitables.get("options");
    while (each.hasNext()) {
        PodDNSConfigOptionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OptionsNested<A> setNewOptionLike(int index,PodDNSConfigOption item) {
    return new OptionsNested(index, item);
  }
  
  public A setToNameservers(int index,String item) {
    if (this.nameservers == null) {
      this.nameservers = new ArrayList();
    }
    this.nameservers.set(index, item);
    return (A) this;
  }
  
  public A setToOptions(int index,PodDNSConfigOption item) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    PodDNSConfigOptionBuilder builder = new PodDNSConfigOptionBuilder(item);
    if (index < 0 || index >= options.size()) {
        _visitables.get("options").add(builder);
        options.add(builder);
    } else {
        _visitables.get("options").add(builder);
        options.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSearches(int index,String item) {
    if (this.searches == null) {
      this.searches = new ArrayList();
    }
    this.searches.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(nameservers == null) && !(nameservers.isEmpty())) {
        sb.append("nameservers:");
        sb.append(nameservers);
        sb.append(",");
    }
    if (!(options == null) && !(options.isEmpty())) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(searches == null) && !(searches.isEmpty())) {
        sb.append("searches:");
        sb.append(searches);
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
  
  public A withNameservers(List<String> nameservers) {
    if (nameservers != null) {
        this.nameservers = new ArrayList();
        for (String item : nameservers) {
          this.addToNameservers(item);
        }
    } else {
      this.nameservers = null;
    }
    return (A) this;
  }
  
  public A withNameservers(String... nameservers) {
    if (this.nameservers != null) {
        this.nameservers.clear();
        _visitables.remove("nameservers");
    }
    if (nameservers != null) {
      for (String item : nameservers) {
        this.addToNameservers(item);
      }
    }
    return (A) this;
  }
  
  public A withOptions(List<PodDNSConfigOption> options) {
    if (this.options != null) {
      this._visitables.get("options").clear();
    }
    if (options != null) {
        this.options = new ArrayList();
        for (PodDNSConfigOption item : options) {
          this.addToOptions(item);
        }
    } else {
      this.options = null;
    }
    return (A) this;
  }
  
  public A withOptions(PodDNSConfigOption... options) {
    if (this.options != null) {
        this.options.clear();
        _visitables.remove("options");
    }
    if (options != null) {
      for (PodDNSConfigOption item : options) {
        this.addToOptions(item);
      }
    }
    return (A) this;
  }
  
  public A withSearches(List<String> searches) {
    if (searches != null) {
        this.searches = new ArrayList();
        for (String item : searches) {
          this.addToSearches(item);
        }
    } else {
      this.searches = null;
    }
    return (A) this;
  }
  
  public A withSearches(String... searches) {
    if (this.searches != null) {
        this.searches.clear();
        _visitables.remove("searches");
    }
    if (searches != null) {
      for (String item : searches) {
        this.addToSearches(item);
      }
    }
    return (A) this;
  }
  public class OptionsNested<N> extends PodDNSConfigOptionFluent<OptionsNested<N>> implements Nested<N>{
  
    PodDNSConfigOptionBuilder builder;
    int index;
  
    OptionsNested(int index,PodDNSConfigOption item) {
      this.index = index;
      this.builder = new PodDNSConfigOptionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodDNSConfigFluent.this.setToOptions(index, builder.build());
    }
    
    public N endOption() {
      return and();
    }
    
  }
}