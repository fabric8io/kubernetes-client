package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Double;
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
public class TracingFluent<A extends io.fabric8.istio.api.api.telemetry.v1alpha1.TracingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,TracingCustomTag> customTags;
  private Boolean disableContextPropagation;
  private Boolean disableSpanReporting;
  private Boolean enableIstioTags;
  private TracingTracingSelectorBuilder match;
  private ArrayList<ProviderRefBuilder> providers = new ArrayList<ProviderRefBuilder>();
  private Double randomSamplingPercentage;
  private Boolean useRequestIdForTraceSampling;

  public TracingFluent() {
  }
  
  public TracingFluent(Tracing instance) {
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
  
  public A addToCustomTags(Map<String,TracingCustomTag> map) {
    if (this.customTags == null && map != null) {
      this.customTags = new LinkedHashMap();
    }
    if (map != null) {
      this.customTags.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCustomTags(String key,TracingCustomTag value) {
    if (this.customTags == null && key != null && value != null) {
      this.customTags = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.customTags.put(key, value);
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
  
  public ProviderRef buildFirstProvider() {
    return this.providers.get(0).build();
  }
  
  public ProviderRef buildLastProvider() {
    return this.providers.get(providers.size() - 1).build();
  }
  
  public TracingTracingSelector buildMatch() {
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
  
  protected void copyInstance(Tracing instance) {
    instance = instance != null ? instance : new Tracing();
    if (instance != null) {
        this.withCustomTags(instance.getCustomTags());
        this.withDisableContextPropagation(instance.getDisableContextPropagation());
        this.withDisableSpanReporting(instance.getDisableSpanReporting());
        this.withEnableIstioTags(instance.getEnableIstioTags());
        this.withMatch(instance.getMatch());
        this.withProviders(instance.getProviders());
        this.withRandomSamplingPercentage(instance.getRandomSamplingPercentage());
        this.withUseRequestIdForTraceSampling(instance.getUseRequestIdForTraceSampling());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public MatchNested<A> editOrNewMatch() {
    return this.withNewMatchLike(Optional.ofNullable(this.buildMatch()).orElse(new TracingTracingSelectorBuilder().build()));
  }
  
  public MatchNested<A> editOrNewMatchLike(TracingTracingSelector item) {
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
    TracingFluent that = (TracingFluent) o;
    if (!(Objects.equals(customTags, that.customTags))) {
      return false;
    }
    if (!(Objects.equals(disableContextPropagation, that.disableContextPropagation))) {
      return false;
    }
    if (!(Objects.equals(disableSpanReporting, that.disableSpanReporting))) {
      return false;
    }
    if (!(Objects.equals(enableIstioTags, that.enableIstioTags))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(providers, that.providers))) {
      return false;
    }
    if (!(Objects.equals(randomSamplingPercentage, that.randomSamplingPercentage))) {
      return false;
    }
    if (!(Objects.equals(useRequestIdForTraceSampling, that.useRequestIdForTraceSampling))) {
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
  
  public Map<String,TracingCustomTag> getCustomTags() {
    return this.customTags;
  }
  
  public Boolean getDisableContextPropagation() {
    return this.disableContextPropagation;
  }
  
  public Boolean getDisableSpanReporting() {
    return this.disableSpanReporting;
  }
  
  public Boolean getEnableIstioTags() {
    return this.enableIstioTags;
  }
  
  public Double getRandomSamplingPercentage() {
    return this.randomSamplingPercentage;
  }
  
  public Boolean getUseRequestIdForTraceSampling() {
    return this.useRequestIdForTraceSampling;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustomTags() {
    return this.customTags != null;
  }
  
  public boolean hasDisableContextPropagation() {
    return this.disableContextPropagation != null;
  }
  
  public boolean hasDisableSpanReporting() {
    return this.disableSpanReporting != null;
  }
  
  public boolean hasEnableIstioTags() {
    return this.enableIstioTags != null;
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
  
  public boolean hasRandomSamplingPercentage() {
    return this.randomSamplingPercentage != null;
  }
  
  public boolean hasUseRequestIdForTraceSampling() {
    return this.useRequestIdForTraceSampling != null;
  }
  
  public int hashCode() {
    return Objects.hash(customTags, disableContextPropagation, disableSpanReporting, enableIstioTags, match, providers, randomSamplingPercentage, useRequestIdForTraceSampling, additionalProperties);
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
  
  public A removeFromCustomTags(String key) {
    if (this.customTags == null) {
      return (A) this;
    }
    if (key != null && this.customTags != null) {
      this.customTags.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCustomTags(Map<String,TracingCustomTag> map) {
    if (this.customTags == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.customTags != null) {
          this.customTags.remove(key);
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
    if (!(customTags == null) && !(customTags.isEmpty())) {
        sb.append("customTags:");
        sb.append(customTags);
        sb.append(",");
    }
    if (!(disableContextPropagation == null)) {
        sb.append("disableContextPropagation:");
        sb.append(disableContextPropagation);
        sb.append(",");
    }
    if (!(disableSpanReporting == null)) {
        sb.append("disableSpanReporting:");
        sb.append(disableSpanReporting);
        sb.append(",");
    }
    if (!(enableIstioTags == null)) {
        sb.append("enableIstioTags:");
        sb.append(enableIstioTags);
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
    if (!(randomSamplingPercentage == null)) {
        sb.append("randomSamplingPercentage:");
        sb.append(randomSamplingPercentage);
        sb.append(",");
    }
    if (!(useRequestIdForTraceSampling == null)) {
        sb.append("useRequestIdForTraceSampling:");
        sb.append(useRequestIdForTraceSampling);
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
  
  public <K,V>A withCustomTags(Map<String,TracingCustomTag> customTags) {
    if (customTags == null) {
      this.customTags = null;
    } else {
      this.customTags = new LinkedHashMap(customTags);
    }
    return (A) this;
  }
  
  public A withDisableContextPropagation() {
    return withDisableContextPropagation(true);
  }
  
  public A withDisableContextPropagation(Boolean disableContextPropagation) {
    this.disableContextPropagation = disableContextPropagation;
    return (A) this;
  }
  
  public A withDisableSpanReporting() {
    return withDisableSpanReporting(true);
  }
  
  public A withDisableSpanReporting(Boolean disableSpanReporting) {
    this.disableSpanReporting = disableSpanReporting;
    return (A) this;
  }
  
  public A withEnableIstioTags() {
    return withEnableIstioTags(true);
  }
  
  public A withEnableIstioTags(Boolean enableIstioTags) {
    this.enableIstioTags = enableIstioTags;
    return (A) this;
  }
  
  public A withMatch(TracingTracingSelector match) {
    this._visitables.remove("match");
    if (match != null) {
        this.match = new TracingTracingSelectorBuilder(match);
        this._visitables.get("match").add(this.match);
    } else {
        this.match = null;
        this._visitables.get("match").remove(this.match);
    }
    return (A) this;
  }
  
  public MatchNested<A> withNewMatch() {
    return new MatchNested(null);
  }
  
  public MatchNested<A> withNewMatchLike(TracingTracingSelector item) {
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
  
  public A withRandomSamplingPercentage(Double randomSamplingPercentage) {
    this.randomSamplingPercentage = randomSamplingPercentage;
    return (A) this;
  }
  
  public A withUseRequestIdForTraceSampling() {
    return withUseRequestIdForTraceSampling(true);
  }
  
  public A withUseRequestIdForTraceSampling(Boolean useRequestIdForTraceSampling) {
    this.useRequestIdForTraceSampling = useRequestIdForTraceSampling;
    return (A) this;
  }
  public class MatchNested<N> extends TracingTracingSelectorFluent<MatchNested<N>> implements Nested<N>{
  
    TracingTracingSelectorBuilder builder;
  
    MatchNested(TracingTracingSelector item) {
      this.builder = new TracingTracingSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingFluent.this.withMatch(builder.build());
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
      return (N) TracingFluent.this.setToProviders(index, builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
}