package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.openshift.api.model.config.v1.TLSProfileSpec;
import java.lang.Integer;
import java.lang.Long;
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
public class IngressControllerStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer availableReplicas;
  private ArrayList<OperatorConditionBuilder> conditions = new ArrayList<OperatorConditionBuilder>();
  private String domain;
  private EndpointPublishingStrategyBuilder endpointPublishingStrategy;
  private LabelSelectorBuilder namespaceSelector;
  private Long observedGeneration;
  private LabelSelectorBuilder routeSelector;
  private String selector;
  private TLSProfileSpec tlsProfile;

  public IngressControllerStatusFluent() {
  }
  
  public IngressControllerStatusFluent(IngressControllerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<OperatorCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new OperatorCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(OperatorCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(OperatorCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,OperatorCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public OperatorCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<OperatorCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public EndpointPublishingStrategy buildEndpointPublishingStrategy() {
    return this.endpointPublishingStrategy != null ? this.endpointPublishingStrategy.build() : null;
  }
  
  public OperatorCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public OperatorCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public OperatorCondition buildMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
      for (OperatorConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildRouteSelector() {
    return this.routeSelector != null ? this.routeSelector.build() : null;
  }
  
  protected void copyInstance(IngressControllerStatus instance) {
    instance = instance != null ? instance : new IngressControllerStatus();
    if (instance != null) {
        this.withAvailableReplicas(instance.getAvailableReplicas());
        this.withConditions(instance.getConditions());
        this.withDomain(instance.getDomain());
        this.withEndpointPublishingStrategy(instance.getEndpointPublishingStrategy());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withRouteSelector(instance.getRouteSelector());
        this.withSelector(instance.getSelector());
        this.withTlsProfile(instance.getTlsProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public EndpointPublishingStrategyNested<A> editEndpointPublishingStrategy() {
    return this.withNewEndpointPublishingStrategyLike(Optional.ofNullable(this.buildEndpointPublishingStrategy()).orElse(null));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public EndpointPublishingStrategyNested<A> editOrNewEndpointPublishingStrategy() {
    return this.withNewEndpointPublishingStrategyLike(Optional.ofNullable(this.buildEndpointPublishingStrategy()).orElse(new EndpointPublishingStrategyBuilder().build()));
  }
  
  public EndpointPublishingStrategyNested<A> editOrNewEndpointPublishingStrategyLike(EndpointPublishingStrategy item) {
    return this.withNewEndpointPublishingStrategyLike(Optional.ofNullable(this.buildEndpointPublishingStrategy()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public RouteSelectorNested<A> editOrNewRouteSelector() {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public RouteSelectorNested<A> editOrNewRouteSelectorLike(LabelSelector item) {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(item));
  }
  
  public RouteSelectorNested<A> editRouteSelector() {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(null));
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
    IngressControllerStatusFluent that = (IngressControllerStatusFluent) o;
    if (!(Objects.equals(availableReplicas, that.availableReplicas))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(endpointPublishingStrategy, that.endpointPublishingStrategy))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(routeSelector, that.routeSelector))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(tlsProfile, that.tlsProfile))) {
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
  
  public Integer getAvailableReplicas() {
    return this.availableReplicas;
  }
  
  public String getDomain() {
    return this.domain;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getSelector() {
    return this.selector;
  }
  
  public TLSProfileSpec getTlsProfile() {
    return this.tlsProfile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableReplicas() {
    return this.availableReplicas != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasEndpointPublishingStrategy() {
    return this.endpointPublishingStrategy != null;
  }
  
  public boolean hasMatchingCondition(Predicate<OperatorConditionBuilder> predicate) {
      for (OperatorConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasRouteSelector() {
    return this.routeSelector != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasTlsProfile() {
    return this.tlsProfile != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableReplicas, conditions, domain, endpointPublishingStrategy, namespaceSelector, observedGeneration, routeSelector, selector, tlsProfile, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<OperatorCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(OperatorCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (OperatorCondition item : items) {
        OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<OperatorConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<OperatorConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        OperatorConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,OperatorCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,OperatorCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    OperatorConditionBuilder builder = new OperatorConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableReplicas == null)) {
        sb.append("availableReplicas:");
        sb.append(availableReplicas);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(endpointPublishingStrategy == null)) {
        sb.append("endpointPublishingStrategy:");
        sb.append(endpointPublishingStrategy);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(routeSelector == null)) {
        sb.append("routeSelector:");
        sb.append(routeSelector);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(tlsProfile == null)) {
        sb.append("tlsProfile:");
        sb.append(tlsProfile);
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
  
  public A withAvailableReplicas(Integer availableReplicas) {
    this.availableReplicas = availableReplicas;
    return (A) this;
  }
  
  public A withConditions(List<OperatorCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (OperatorCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(OperatorCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (OperatorCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withEndpointPublishingStrategy(EndpointPublishingStrategy endpointPublishingStrategy) {
    this._visitables.remove("endpointPublishingStrategy");
    if (endpointPublishingStrategy != null) {
        this.endpointPublishingStrategy = new EndpointPublishingStrategyBuilder(endpointPublishingStrategy);
        this._visitables.get("endpointPublishingStrategy").add(this.endpointPublishingStrategy);
    } else {
        this.endpointPublishingStrategy = null;
        this._visitables.get("endpointPublishingStrategy").remove(this.endpointPublishingStrategy);
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public EndpointPublishingStrategyNested<A> withNewEndpointPublishingStrategy() {
    return new EndpointPublishingStrategyNested(null);
  }
  
  public EndpointPublishingStrategyNested<A> withNewEndpointPublishingStrategyLike(EndpointPublishingStrategy item) {
    return new EndpointPublishingStrategyNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public RouteSelectorNested<A> withNewRouteSelector() {
    return new RouteSelectorNested(null);
  }
  
  public RouteSelectorNested<A> withNewRouteSelectorLike(LabelSelector item) {
    return new RouteSelectorNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withRouteSelector(LabelSelector routeSelector) {
    this._visitables.remove("routeSelector");
    if (routeSelector != null) {
        this.routeSelector = new LabelSelectorBuilder(routeSelector);
        this._visitables.get("routeSelector").add(this.routeSelector);
    } else {
        this.routeSelector = null;
        this._visitables.get("routeSelector").remove(this.routeSelector);
    }
    return (A) this;
  }
  
  public A withSelector(String selector) {
    this.selector = selector;
    return (A) this;
  }
  
  public A withTlsProfile(TLSProfileSpec tlsProfile) {
    this.tlsProfile = tlsProfile;
    return (A) this;
  }
  public class ConditionsNested<N> extends OperatorConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    OperatorConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,OperatorCondition item) {
      this.index = index;
      this.builder = new OperatorConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class EndpointPublishingStrategyNested<N> extends EndpointPublishingStrategyFluent<EndpointPublishingStrategyNested<N>> implements Nested<N>{
  
    EndpointPublishingStrategyBuilder builder;
  
    EndpointPublishingStrategyNested(EndpointPublishingStrategy item) {
      this.builder = new EndpointPublishingStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerStatusFluent.this.withEndpointPublishingStrategy(builder.build());
    }
    
    public N endEndpointPublishingStrategy() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerStatusFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class RouteSelectorNested<N> extends LabelSelectorFluent<RouteSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    RouteSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerStatusFluent.this.withRouteSelector(builder.build());
    }
    
    public N endRouteSelector() {
      return and();
    }
    
  }
}