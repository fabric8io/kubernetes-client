package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class AccessLoggingFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.AccessLoggingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean disabled;
  private AccessLoggingFilterBuilder filter;
  private AccessLoggingLogSelectorBuilder match;
  private ArrayList<ProviderRefBuilder> providers = new ArrayList<ProviderRefBuilder>();

  public AccessLoggingFluent() {
  }
  
  public AccessLoggingFluent(AccessLogging instance) {
    this.copyInstance(instance);
  }

  public A addAllToProviders(Collection<ProviderRef> items) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    for (ProviderRef item : items) {
        ProviderRefBuilder builder = new ProviderRefBuilder(item);
        _visitables.get("providers").add(builder);
        this.providers.add(builder);
    }
    return (A) this;
  }
  
  public ProvidersNested<A> addNewProvider() {
    return new ProvidersNested(-1, null);
  }
  
  public A addNewProvider(String name) {
    return (A) this.addToProviders(new ProviderRef(name));
  }
  
  public ProvidersNested<A> addNewProviderLike(ProviderRef item) {
    return new ProvidersNested(-1, item);
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
  
  public A addToProviders(ProviderRef... items) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    for (ProviderRef item : items) {
        ProviderRefBuilder builder = new ProviderRefBuilder(item);
        _visitables.get("providers").add(builder);
        this.providers.add(builder);
    }
    return (A) this;
  }
  
  public A addToProviders(int index,ProviderRef item) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    ProviderRefBuilder builder = new ProviderRefBuilder(item);
    if (index < 0 || index >= providers.size()) {
        _visitables.get("providers").add(builder);
        providers.add(builder);
    } else {
        _visitables.get("providers").add(builder);
        providers.add(index, builder);
    }
    return (A) this;
  }
  
  public AccessLoggingFilter buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  public ProviderRef buildFirstProvider() {
    return this.providers.get(0).build();
  }
  
  public ProviderRef buildLastProvider() {
    return this.providers.get(providers.size() - 1).build();
  }
  
  public AccessLoggingLogSelector buildMatch() {
    return this.match != null ? this.match.build() : null;
  }
  
  public ProviderRef buildMatchingProvider(Predicate<ProviderRefBuilder> predicate) {
      for (ProviderRefBuilder item : providers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ProviderRef buildProvider(int index) {
    return this.providers.get(index).build();
  }
  
  public List<ProviderRef> buildProviders() {
    return this.providers != null ? build(providers) : null;
  }
  
  protected void copyInstance(AccessLogging instance) {
    instance = instance != null ? instance : new AccessLogging();
    if (instance != null) {
        this.withDisabled(instance.getDisabled());
        this.withFilter(instance.getFilter());
        this.withMatch(instance.getMatch());
        this.withProviders(instance.getProviders());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public ProvidersNested<A> editFirstProvider() {
    if (providers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "providers"));
    }
    return this.setNewProviderLike(0, this.buildProvider(0));
  }
  
  public ProvidersNested<A> editLastProvider() {
    int index = providers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "providers"));
    }
    return this.setNewProviderLike(index, this.buildProvider(index));
  }
  
  public MatchNested<A> editMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(null));
  }
  
  public ProvidersNested<A> editMatchingProvider(Predicate<ProviderRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < providers.size();i++) {
      if (predicate.test(providers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "providers"));
    }
    return this.setNewProviderLike(index, this.buildProvider(index));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new AccessLoggingFilterBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(AccessLoggingFilter item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
  }
  
  public MatchNested<A> editOrNewMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(new AccessLoggingLogSelectorBuilder().build()));
  }
  
  public MatchNested<A> editOrNewMatchLike(AccessLoggingLogSelector item) {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(item));
  }
  
  public ProvidersNested<A> editProvider(int index) {
    if (providers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "providers"));
    }
    return this.setNewProviderLike(index, this.buildProvider(index));
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
    AccessLoggingFluent that = (AccessLoggingFluent) o;
    if (!(Objects.equals(disabled, that.disabled))) {
      return false;
    }
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(providers, that.providers))) {
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
  
  public Boolean getDisabled() {
    return this.disabled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisabled() {
    return this.disabled != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasMatch() {
    return this.match != null;
  }
  
  public boolean hasMatchingProvider(Predicate<ProviderRefBuilder> predicate) {
      for (ProviderRefBuilder item : providers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProviders() {
    return this.providers != null && !(this.providers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(disabled, filter, match, providers, additionalProperties);
  }
  
  public A removeAllFromProviders(Collection<ProviderRef> items) {
    if (this.providers == null) {
      return (A) this;
    }
    for (ProviderRef item : items) {
        ProviderRefBuilder builder = new ProviderRefBuilder(item);
        _visitables.get("providers").remove(builder);
        this.providers.remove(builder);
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
  
  public A removeFromProviders(ProviderRef... items) {
    if (this.providers == null) {
      return (A) this;
    }
    for (ProviderRef item : items) {
        ProviderRefBuilder builder = new ProviderRefBuilder(item);
        _visitables.get("providers").remove(builder);
        this.providers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromProviders(Predicate<ProviderRefBuilder> predicate) {
    if (providers == null) {
      return (A) this;
    }
    Iterator<ProviderRefBuilder> each = providers.iterator();
    List visitables = _visitables.get("providers");
    while (each.hasNext()) {
        ProviderRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ProvidersNested<A> setNewProviderLike(int index,ProviderRef item) {
    return new ProvidersNested(index, item);
  }
  
  public A setToProviders(int index,ProviderRef item) {
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    ProviderRefBuilder builder = new ProviderRefBuilder(item);
    if (index < 0 || index >= providers.size()) {
        _visitables.get("providers").add(builder);
        providers.add(builder);
    } else {
        _visitables.get("providers").add(builder);
        providers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disabled == null)) {
        sb.append("disabled:");
        sb.append(disabled);
        sb.append(",");
    }
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(match == null)) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(providers == null) && !(providers.isEmpty())) {
        sb.append("providers:");
        sb.append(providers);
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
  
  public A withDisabled() {
    return withDisabled(true);
  }
  
  public A withDisabled(Boolean disabled) {
    this.disabled = disabled;
    return (A) this;
  }
  
  public A withFilter(AccessLoggingFilter filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new AccessLoggingFilterBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public A withMatch(AccessLoggingLogSelector match) {
    this._visitables.remove("match");
    if (match != null) {
        this.match = new AccessLoggingLogSelectorBuilder(match);
        this._visitables.get("match").add(this.match);
    } else {
        this.match = null;
        this._visitables.get("match").remove(this.match);
    }
    return (A) this;
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public A withNewFilter(String expression) {
    return (A) this.withFilter(new AccessLoggingFilter(expression));
  }
  
  public FilterNested<A> withNewFilterLike(AccessLoggingFilter item) {
    return new FilterNested(item);
  }
  
  public MatchNested<A> withNewMatch() {
    return new MatchNested(null);
  }
  
  public MatchNested<A> withNewMatchLike(AccessLoggingLogSelector item) {
    return new MatchNested(item);
  }
  
  public A withProviders(List<ProviderRef> providers) {
    if (this.providers != null) {
      this._visitables.get("providers").clear();
    }
    if (providers != null) {
        this.providers = new ArrayList();
        for (ProviderRef item : providers) {
          this.addToProviders(item);
        }
    } else {
      this.providers = null;
    }
    return (A) this;
  }
  
  public A withProviders(ProviderRef... providers) {
    if (this.providers != null) {
        this.providers.clear();
        _visitables.remove("providers");
    }
    if (providers != null) {
      for (ProviderRef item : providers) {
        this.addToProviders(item);
      }
    }
    return (A) this;
  }
  public class FilterNested<N> extends AccessLoggingFilterFluent<FilterNested<N>> implements Nested<N>{
  
    AccessLoggingFilterBuilder builder;
  
    FilterNested(AccessLoggingFilter item) {
      this.builder = new AccessLoggingFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessLoggingFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class MatchNested<N> extends AccessLoggingLogSelectorFluent<MatchNested<N>> implements Nested<N>{
  
    AccessLoggingLogSelectorBuilder builder;
  
    MatchNested(AccessLoggingLogSelector item) {
      this.builder = new AccessLoggingLogSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessLoggingFluent.this.withMatch(builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class ProvidersNested<N> extends ProviderRefFluent<ProvidersNested<N>> implements Nested<N>{
  
    ProviderRefBuilder builder;
    int index;
  
    ProvidersNested(int index,ProviderRef item) {
      this.index = index;
      this.builder = new ProviderRefBuilder(this, item);
    }
  
    public N and() {
      return (N) AccessLoggingFluent.this.setToProviders(index, builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
}