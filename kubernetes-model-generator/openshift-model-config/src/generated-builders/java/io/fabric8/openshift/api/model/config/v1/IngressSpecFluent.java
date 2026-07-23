package io.fabric8.openshift.api.model.config.v1;

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
public class IngressSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.IngressSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String appsDomain;
  private ArrayList<ComponentRouteSpecBuilder> componentRoutes = new ArrayList<ComponentRouteSpecBuilder>();
  private String domain;
  private LoadBalancerBuilder loadBalancer;
  private ArrayList<RequiredHSTSPolicyBuilder> requiredHSTSPolicies = new ArrayList<RequiredHSTSPolicyBuilder>();

  public IngressSpecFluent() {
  }
  
  public IngressSpecFluent(IngressSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToComponentRoutes(Collection<ComponentRouteSpec> items) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    for (ComponentRouteSpec item : items) {
        ComponentRouteSpecBuilder builder = new ComponentRouteSpecBuilder(item);
        _visitables.get("componentRoutes").add(builder);
        this.componentRoutes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequiredHSTSPolicies(Collection<RequiredHSTSPolicy> items) {
    if (this.requiredHSTSPolicies == null) {
      this.requiredHSTSPolicies = new ArrayList();
    }
    for (RequiredHSTSPolicy item : items) {
        RequiredHSTSPolicyBuilder builder = new RequiredHSTSPolicyBuilder(item);
        _visitables.get("requiredHSTSPolicies").add(builder);
        this.requiredHSTSPolicies.add(builder);
    }
    return (A) this;
  }
  
  public ComponentRoutesNested<A> addNewComponentRoute() {
    return new ComponentRoutesNested(-1, null);
  }
  
  public ComponentRoutesNested<A> addNewComponentRouteLike(ComponentRouteSpec item) {
    return new ComponentRoutesNested(-1, item);
  }
  
  public RequiredHSTSPoliciesNested<A> addNewRequiredHSTSPolicy() {
    return new RequiredHSTSPoliciesNested(-1, null);
  }
  
  public RequiredHSTSPoliciesNested<A> addNewRequiredHSTSPolicyLike(RequiredHSTSPolicy item) {
    return new RequiredHSTSPoliciesNested(-1, item);
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
  
  public A addToComponentRoutes(ComponentRouteSpec... items) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    for (ComponentRouteSpec item : items) {
        ComponentRouteSpecBuilder builder = new ComponentRouteSpecBuilder(item);
        _visitables.get("componentRoutes").add(builder);
        this.componentRoutes.add(builder);
    }
    return (A) this;
  }
  
  public A addToComponentRoutes(int index,ComponentRouteSpec item) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    ComponentRouteSpecBuilder builder = new ComponentRouteSpecBuilder(item);
    if (index < 0 || index >= componentRoutes.size()) {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.add(builder);
    } else {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequiredHSTSPolicies(RequiredHSTSPolicy... items) {
    if (this.requiredHSTSPolicies == null) {
      this.requiredHSTSPolicies = new ArrayList();
    }
    for (RequiredHSTSPolicy item : items) {
        RequiredHSTSPolicyBuilder builder = new RequiredHSTSPolicyBuilder(item);
        _visitables.get("requiredHSTSPolicies").add(builder);
        this.requiredHSTSPolicies.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequiredHSTSPolicies(int index,RequiredHSTSPolicy item) {
    if (this.requiredHSTSPolicies == null) {
      this.requiredHSTSPolicies = new ArrayList();
    }
    RequiredHSTSPolicyBuilder builder = new RequiredHSTSPolicyBuilder(item);
    if (index < 0 || index >= requiredHSTSPolicies.size()) {
        _visitables.get("requiredHSTSPolicies").add(builder);
        requiredHSTSPolicies.add(builder);
    } else {
        _visitables.get("requiredHSTSPolicies").add(builder);
        requiredHSTSPolicies.add(index, builder);
    }
    return (A) this;
  }
  
  public ComponentRouteSpec buildComponentRoute(int index) {
    return this.componentRoutes.get(index).build();
  }
  
  public List<ComponentRouteSpec> buildComponentRoutes() {
    return this.componentRoutes != null ? build(componentRoutes) : null;
  }
  
  public ComponentRouteSpec buildFirstComponentRoute() {
    return this.componentRoutes.get(0).build();
  }
  
  public RequiredHSTSPolicy buildFirstRequiredHSTSPolicy() {
    return this.requiredHSTSPolicies.get(0).build();
  }
  
  public ComponentRouteSpec buildLastComponentRoute() {
    return this.componentRoutes.get(componentRoutes.size() - 1).build();
  }
  
  public RequiredHSTSPolicy buildLastRequiredHSTSPolicy() {
    return this.requiredHSTSPolicies.get(requiredHSTSPolicies.size() - 1).build();
  }
  
  public LoadBalancer buildLoadBalancer() {
    return this.loadBalancer != null ? this.loadBalancer.build() : null;
  }
  
  public ComponentRouteSpec buildMatchingComponentRoute(Predicate<ComponentRouteSpecBuilder> predicate) {
      for (ComponentRouteSpecBuilder item : componentRoutes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RequiredHSTSPolicy buildMatchingRequiredHSTSPolicy(Predicate<RequiredHSTSPolicyBuilder> predicate) {
      for (RequiredHSTSPolicyBuilder item : requiredHSTSPolicies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<RequiredHSTSPolicy> buildRequiredHSTSPolicies() {
    return this.requiredHSTSPolicies != null ? build(requiredHSTSPolicies) : null;
  }
  
  public RequiredHSTSPolicy buildRequiredHSTSPolicy(int index) {
    return this.requiredHSTSPolicies.get(index).build();
  }
  
  protected void copyInstance(IngressSpec instance) {
    instance = instance != null ? instance : new IngressSpec();
    if (instance != null) {
        this.withAppsDomain(instance.getAppsDomain());
        this.withComponentRoutes(instance.getComponentRoutes());
        this.withDomain(instance.getDomain());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withRequiredHSTSPolicies(instance.getRequiredHSTSPolicies());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComponentRoutesNested<A> editComponentRoute(int index) {
    if (componentRoutes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(index, this.buildComponentRoute(index));
  }
  
  public ComponentRoutesNested<A> editFirstComponentRoute() {
    if (componentRoutes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(0, this.buildComponentRoute(0));
  }
  
  public RequiredHSTSPoliciesNested<A> editFirstRequiredHSTSPolicy() {
    if (requiredHSTSPolicies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requiredHSTSPolicies"));
    }
    return this.setNewRequiredHSTSPolicyLike(0, this.buildRequiredHSTSPolicy(0));
  }
  
  public ComponentRoutesNested<A> editLastComponentRoute() {
    int index = componentRoutes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(index, this.buildComponentRoute(index));
  }
  
  public RequiredHSTSPoliciesNested<A> editLastRequiredHSTSPolicy() {
    int index = requiredHSTSPolicies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requiredHSTSPolicies"));
    }
    return this.setNewRequiredHSTSPolicyLike(index, this.buildRequiredHSTSPolicy(index));
  }
  
  public LoadBalancerNested<A> editLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(null));
  }
  
  public ComponentRoutesNested<A> editMatchingComponentRoute(Predicate<ComponentRouteSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < componentRoutes.size();i++) {
      if (predicate.test(componentRoutes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "componentRoutes"));
    }
    return this.setNewComponentRouteLike(index, this.buildComponentRoute(index));
  }
  
  public RequiredHSTSPoliciesNested<A> editMatchingRequiredHSTSPolicy(Predicate<RequiredHSTSPolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requiredHSTSPolicies.size();i++) {
      if (predicate.test(requiredHSTSPolicies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requiredHSTSPolicies"));
    }
    return this.setNewRequiredHSTSPolicyLike(index, this.buildRequiredHSTSPolicy(index));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancer() {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(new LoadBalancerBuilder().build()));
  }
  
  public LoadBalancerNested<A> editOrNewLoadBalancerLike(LoadBalancer item) {
    return this.withNewLoadBalancerLike(Optional.ofNullable(this.buildLoadBalancer()).orElse(item));
  }
  
  public RequiredHSTSPoliciesNested<A> editRequiredHSTSPolicy(int index) {
    if (requiredHSTSPolicies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requiredHSTSPolicies"));
    }
    return this.setNewRequiredHSTSPolicyLike(index, this.buildRequiredHSTSPolicy(index));
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
    IngressSpecFluent that = (IngressSpecFluent) o;
    if (!(Objects.equals(appsDomain, that.appsDomain))) {
      return false;
    }
    if (!(Objects.equals(componentRoutes, that.componentRoutes))) {
      return false;
    }
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(requiredHSTSPolicies, that.requiredHSTSPolicies))) {
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
  
  public String getAppsDomain() {
    return this.appsDomain;
  }
  
  public String getDomain() {
    return this.domain;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAppsDomain() {
    return this.appsDomain != null;
  }
  
  public boolean hasComponentRoutes() {
    return this.componentRoutes != null && !(this.componentRoutes.isEmpty());
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasMatchingComponentRoute(Predicate<ComponentRouteSpecBuilder> predicate) {
      for (ComponentRouteSpecBuilder item : componentRoutes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequiredHSTSPolicy(Predicate<RequiredHSTSPolicyBuilder> predicate) {
      for (RequiredHSTSPolicyBuilder item : requiredHSTSPolicies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequiredHSTSPolicies() {
    return this.requiredHSTSPolicies != null && !(this.requiredHSTSPolicies.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(appsDomain, componentRoutes, domain, loadBalancer, requiredHSTSPolicies, additionalProperties);
  }
  
  public A removeAllFromComponentRoutes(Collection<ComponentRouteSpec> items) {
    if (this.componentRoutes == null) {
      return (A) this;
    }
    for (ComponentRouteSpec item : items) {
        ComponentRouteSpecBuilder builder = new ComponentRouteSpecBuilder(item);
        _visitables.get("componentRoutes").remove(builder);
        this.componentRoutes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequiredHSTSPolicies(Collection<RequiredHSTSPolicy> items) {
    if (this.requiredHSTSPolicies == null) {
      return (A) this;
    }
    for (RequiredHSTSPolicy item : items) {
        RequiredHSTSPolicyBuilder builder = new RequiredHSTSPolicyBuilder(item);
        _visitables.get("requiredHSTSPolicies").remove(builder);
        this.requiredHSTSPolicies.remove(builder);
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
  
  public A removeFromComponentRoutes(ComponentRouteSpec... items) {
    if (this.componentRoutes == null) {
      return (A) this;
    }
    for (ComponentRouteSpec item : items) {
        ComponentRouteSpecBuilder builder = new ComponentRouteSpecBuilder(item);
        _visitables.get("componentRoutes").remove(builder);
        this.componentRoutes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequiredHSTSPolicies(RequiredHSTSPolicy... items) {
    if (this.requiredHSTSPolicies == null) {
      return (A) this;
    }
    for (RequiredHSTSPolicy item : items) {
        RequiredHSTSPolicyBuilder builder = new RequiredHSTSPolicyBuilder(item);
        _visitables.get("requiredHSTSPolicies").remove(builder);
        this.requiredHSTSPolicies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromComponentRoutes(Predicate<ComponentRouteSpecBuilder> predicate) {
    if (componentRoutes == null) {
      return (A) this;
    }
    Iterator<ComponentRouteSpecBuilder> each = componentRoutes.iterator();
    List visitables = _visitables.get("componentRoutes");
    while (each.hasNext()) {
        ComponentRouteSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequiredHSTSPolicies(Predicate<RequiredHSTSPolicyBuilder> predicate) {
    if (requiredHSTSPolicies == null) {
      return (A) this;
    }
    Iterator<RequiredHSTSPolicyBuilder> each = requiredHSTSPolicies.iterator();
    List visitables = _visitables.get("requiredHSTSPolicies");
    while (each.hasNext()) {
        RequiredHSTSPolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ComponentRoutesNested<A> setNewComponentRouteLike(int index,ComponentRouteSpec item) {
    return new ComponentRoutesNested(index, item);
  }
  
  public RequiredHSTSPoliciesNested<A> setNewRequiredHSTSPolicyLike(int index,RequiredHSTSPolicy item) {
    return new RequiredHSTSPoliciesNested(index, item);
  }
  
  public A setToComponentRoutes(int index,ComponentRouteSpec item) {
    if (this.componentRoutes == null) {
      this.componentRoutes = new ArrayList();
    }
    ComponentRouteSpecBuilder builder = new ComponentRouteSpecBuilder(item);
    if (index < 0 || index >= componentRoutes.size()) {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.add(builder);
    } else {
        _visitables.get("componentRoutes").add(builder);
        componentRoutes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequiredHSTSPolicies(int index,RequiredHSTSPolicy item) {
    if (this.requiredHSTSPolicies == null) {
      this.requiredHSTSPolicies = new ArrayList();
    }
    RequiredHSTSPolicyBuilder builder = new RequiredHSTSPolicyBuilder(item);
    if (index < 0 || index >= requiredHSTSPolicies.size()) {
        _visitables.get("requiredHSTSPolicies").add(builder);
        requiredHSTSPolicies.add(builder);
    } else {
        _visitables.get("requiredHSTSPolicies").add(builder);
        requiredHSTSPolicies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(appsDomain == null)) {
        sb.append("appsDomain:");
        sb.append(appsDomain);
        sb.append(",");
    }
    if (!(componentRoutes == null) && !(componentRoutes.isEmpty())) {
        sb.append("componentRoutes:");
        sb.append(componentRoutes);
        sb.append(",");
    }
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(requiredHSTSPolicies == null) && !(requiredHSTSPolicies.isEmpty())) {
        sb.append("requiredHSTSPolicies:");
        sb.append(requiredHSTSPolicies);
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
  
  public A withAppsDomain(String appsDomain) {
    this.appsDomain = appsDomain;
    return (A) this;
  }
  
  public A withComponentRoutes(List<ComponentRouteSpec> componentRoutes) {
    if (this.componentRoutes != null) {
      this._visitables.get("componentRoutes").clear();
    }
    if (componentRoutes != null) {
        this.componentRoutes = new ArrayList();
        for (ComponentRouteSpec item : componentRoutes) {
          this.addToComponentRoutes(item);
        }
    } else {
      this.componentRoutes = null;
    }
    return (A) this;
  }
  
  public A withComponentRoutes(ComponentRouteSpec... componentRoutes) {
    if (this.componentRoutes != null) {
        this.componentRoutes.clear();
        _visitables.remove("componentRoutes");
    }
    if (componentRoutes != null) {
      for (ComponentRouteSpec item : componentRoutes) {
        this.addToComponentRoutes(item);
      }
    }
    return (A) this;
  }
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withLoadBalancer(LoadBalancer loadBalancer) {
    this._visitables.remove("loadBalancer");
    if (loadBalancer != null) {
        this.loadBalancer = new LoadBalancerBuilder(loadBalancer);
        this._visitables.get("loadBalancer").add(this.loadBalancer);
    } else {
        this.loadBalancer = null;
        this._visitables.get("loadBalancer").remove(this.loadBalancer);
    }
    return (A) this;
  }
  
  public LoadBalancerNested<A> withNewLoadBalancer() {
    return new LoadBalancerNested(null);
  }
  
  public LoadBalancerNested<A> withNewLoadBalancerLike(LoadBalancer item) {
    return new LoadBalancerNested(item);
  }
  
  public A withRequiredHSTSPolicies(List<RequiredHSTSPolicy> requiredHSTSPolicies) {
    if (this.requiredHSTSPolicies != null) {
      this._visitables.get("requiredHSTSPolicies").clear();
    }
    if (requiredHSTSPolicies != null) {
        this.requiredHSTSPolicies = new ArrayList();
        for (RequiredHSTSPolicy item : requiredHSTSPolicies) {
          this.addToRequiredHSTSPolicies(item);
        }
    } else {
      this.requiredHSTSPolicies = null;
    }
    return (A) this;
  }
  
  public A withRequiredHSTSPolicies(RequiredHSTSPolicy... requiredHSTSPolicies) {
    if (this.requiredHSTSPolicies != null) {
        this.requiredHSTSPolicies.clear();
        _visitables.remove("requiredHSTSPolicies");
    }
    if (requiredHSTSPolicies != null) {
      for (RequiredHSTSPolicy item : requiredHSTSPolicies) {
        this.addToRequiredHSTSPolicies(item);
      }
    }
    return (A) this;
  }
  public class ComponentRoutesNested<N> extends ComponentRouteSpecFluent<ComponentRoutesNested<N>> implements Nested<N>{
  
    ComponentRouteSpecBuilder builder;
    int index;
  
    ComponentRoutesNested(int index,ComponentRouteSpec item) {
      this.index = index;
      this.builder = new ComponentRouteSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressSpecFluent.this.setToComponentRoutes(index, builder.build());
    }
    
    public N endComponentRoute() {
      return and();
    }
    
  }
  public class LoadBalancerNested<N> extends LoadBalancerFluent<LoadBalancerNested<N>> implements Nested<N>{
  
    LoadBalancerBuilder builder;
  
    LoadBalancerNested(LoadBalancer item) {
      this.builder = new LoadBalancerBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressSpecFluent.this.withLoadBalancer(builder.build());
    }
    
    public N endLoadBalancer() {
      return and();
    }
    
  }
  public class RequiredHSTSPoliciesNested<N> extends RequiredHSTSPolicyFluent<RequiredHSTSPoliciesNested<N>> implements Nested<N>{
  
    RequiredHSTSPolicyBuilder builder;
    int index;
  
    RequiredHSTSPoliciesNested(int index,RequiredHSTSPolicy item) {
      this.index = index;
      this.builder = new RequiredHSTSPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressSpecFluent.this.setToRequiredHSTSPolicies(index, builder.build());
    }
    
    public N endRequiredHSTSPolicy() {
      return and();
    }
    
  }
}