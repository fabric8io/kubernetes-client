package io.fabric8.istio.api.api.telemetry.v1alpha1;

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
public class MetricsFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.MetricsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<MetricsOverridesBuilder> overrides = new ArrayList<MetricsOverridesBuilder>();
  private ArrayList<ProviderRefBuilder> providers = new ArrayList<ProviderRefBuilder>();
  private String reportingInterval;

  public MetricsFluent() {
  }
  
  public MetricsFluent(Metrics instance) {
    this.copyInstance(instance);
  }

  public A addAllToOverrides(Collection<MetricsOverrides> items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (MetricsOverrides item : items) {
        MetricsOverridesBuilder builder = new MetricsOverridesBuilder(item);
        _visitables.get("overrides").add(builder);
        this.overrides.add(builder);
    }
    return (A) this;
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
  
  public OverridesNested<A> addNewOverride() {
    return new OverridesNested(-1, null);
  }
  
  public OverridesNested<A> addNewOverrideLike(MetricsOverrides item) {
    return new OverridesNested(-1, item);
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
  
  public A addToOverrides(MetricsOverrides... items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (MetricsOverrides item : items) {
        MetricsOverridesBuilder builder = new MetricsOverridesBuilder(item);
        _visitables.get("overrides").add(builder);
        this.overrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToOverrides(int index,MetricsOverrides item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    MetricsOverridesBuilder builder = new MetricsOverridesBuilder(item);
    if (index < 0 || index >= overrides.size()) {
        _visitables.get("overrides").add(builder);
        overrides.add(builder);
    } else {
        _visitables.get("overrides").add(builder);
        overrides.add(index, builder);
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
  
  public MetricsOverrides buildFirstOverride() {
    return this.overrides.get(0).build();
  }
  
  public ProviderRef buildFirstProvider() {
    return this.providers.get(0).build();
  }
  
  public MetricsOverrides buildLastOverride() {
    return this.overrides.get(overrides.size() - 1).build();
  }
  
  public ProviderRef buildLastProvider() {
    return this.providers.get(providers.size() - 1).build();
  }
  
  public MetricsOverrides buildMatchingOverride(Predicate<MetricsOverridesBuilder> predicate) {
      for (MetricsOverridesBuilder item : overrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ProviderRef buildMatchingProvider(Predicate<ProviderRefBuilder> predicate) {
      for (ProviderRefBuilder item : providers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetricsOverrides buildOverride(int index) {
    return this.overrides.get(index).build();
  }
  
  public List<MetricsOverrides> buildOverrides() {
    return this.overrides != null ? build(overrides) : null;
  }
  
  public ProviderRef buildProvider(int index) {
    return this.providers.get(index).build();
  }
  
  public List<ProviderRef> buildProviders() {
    return this.providers != null ? build(providers) : null;
  }
  
  protected void copyInstance(Metrics instance) {
    instance = instance != null ? instance : new Metrics();
    if (instance != null) {
        this.withOverrides(instance.getOverrides());
        this.withProviders(instance.getProviders());
        this.withReportingInterval(instance.getReportingInterval());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OverridesNested<A> editFirstOverride() {
    if (overrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "overrides"));
    }
    return this.setNewOverrideLike(0, this.buildOverride(0));
  }
  
  public ProvidersNested<A> editFirstProvider() {
    if (providers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "providers"));
    }
    return this.setNewProviderLike(0, this.buildProvider(0));
  }
  
  public OverridesNested<A> editLastOverride() {
    int index = overrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public ProvidersNested<A> editLastProvider() {
    int index = providers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "providers"));
    }
    return this.setNewProviderLike(index, this.buildProvider(index));
  }
  
  public OverridesNested<A> editMatchingOverride(Predicate<MetricsOverridesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < overrides.size();i++) {
      if (predicate.test(overrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
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
  
  public OverridesNested<A> editOverride(int index) {
    if (overrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
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
    MetricsFluent that = (MetricsFluent) o;
    if (!(Objects.equals(overrides, that.overrides))) {
      return false;
    }
    if (!(Objects.equals(providers, that.providers))) {
      return false;
    }
    if (!(Objects.equals(reportingInterval, that.reportingInterval))) {
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
  
  public String getReportingInterval() {
    return this.reportingInterval;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingOverride(Predicate<MetricsOverridesBuilder> predicate) {
      for (MetricsOverridesBuilder item : overrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingProvider(Predicate<ProviderRefBuilder> predicate) {
      for (ProviderRefBuilder item : providers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOverrides() {
    return this.overrides != null && !(this.overrides.isEmpty());
  }
  
  public boolean hasProviders() {
    return this.providers != null && !(this.providers.isEmpty());
  }
  
  public boolean hasReportingInterval() {
    return this.reportingInterval != null;
  }
  
  public int hashCode() {
    return Objects.hash(overrides, providers, reportingInterval, additionalProperties);
  }
  
  public A removeAllFromOverrides(Collection<MetricsOverrides> items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (MetricsOverrides item : items) {
        MetricsOverridesBuilder builder = new MetricsOverridesBuilder(item);
        _visitables.get("overrides").remove(builder);
        this.overrides.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromOverrides(MetricsOverrides... items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (MetricsOverrides item : items) {
        MetricsOverridesBuilder builder = new MetricsOverridesBuilder(item);
        _visitables.get("overrides").remove(builder);
        this.overrides.remove(builder);
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
  
  public A removeMatchingFromOverrides(Predicate<MetricsOverridesBuilder> predicate) {
    if (overrides == null) {
      return (A) this;
    }
    Iterator<MetricsOverridesBuilder> each = overrides.iterator();
    List visitables = _visitables.get("overrides");
    while (each.hasNext()) {
        MetricsOverridesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public OverridesNested<A> setNewOverrideLike(int index,MetricsOverrides item) {
    return new OverridesNested(index, item);
  }
  
  public ProvidersNested<A> setNewProviderLike(int index,ProviderRef item) {
    return new ProvidersNested(index, item);
  }
  
  public A setToOverrides(int index,MetricsOverrides item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    MetricsOverridesBuilder builder = new MetricsOverridesBuilder(item);
    if (index < 0 || index >= overrides.size()) {
        _visitables.get("overrides").add(builder);
        overrides.add(builder);
    } else {
        _visitables.get("overrides").add(builder);
        overrides.set(index, builder);
    }
    return (A) this;
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
    if (!(overrides == null) && !(overrides.isEmpty())) {
        sb.append("overrides:");
        sb.append(overrides);
        sb.append(",");
    }
    if (!(providers == null) && !(providers.isEmpty())) {
        sb.append("providers:");
        sb.append(providers);
        sb.append(",");
    }
    if (!(reportingInterval == null)) {
        sb.append("reportingInterval:");
        sb.append(reportingInterval);
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
  
  public A withOverrides(List<MetricsOverrides> overrides) {
    if (this.overrides != null) {
      this._visitables.get("overrides").clear();
    }
    if (overrides != null) {
        this.overrides = new ArrayList();
        for (MetricsOverrides item : overrides) {
          this.addToOverrides(item);
        }
    } else {
      this.overrides = null;
    }
    return (A) this;
  }
  
  public A withOverrides(MetricsOverrides... overrides) {
    if (this.overrides != null) {
        this.overrides.clear();
        _visitables.remove("overrides");
    }
    if (overrides != null) {
      for (MetricsOverrides item : overrides) {
        this.addToOverrides(item);
      }
    }
    return (A) this;
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
  
  public A withReportingInterval(String reportingInterval) {
    this.reportingInterval = reportingInterval;
    return (A) this;
  }
  public class OverridesNested<N> extends MetricsOverridesFluent<OverridesNested<N>> implements Nested<N>{
  
    MetricsOverridesBuilder builder;
    int index;
  
    OverridesNested(int index,MetricsOverrides item) {
      this.index = index;
      this.builder = new MetricsOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) MetricsFluent.this.setToOverrides(index, builder.build());
    }
    
    public N endOverride() {
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
      return (N) MetricsFluent.this.setToProviders(index, builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
}