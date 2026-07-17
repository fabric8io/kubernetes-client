package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class ConsoleSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.ConsoleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConsoleCustomizationBuilder customization;
  private IngressBuilder ingress;
  private String logLevel;
  private String managementState;
  private Object observedConfig;
  private String operatorLogLevel;
  private List<String> plugins = new ArrayList<String>();
  private ConsoleProvidersBuilder providers;
  private ConsoleConfigRouteBuilder route;
  private Object unsupportedConfigOverrides;

  public ConsoleSpecFluent() {
  }
  
  public ConsoleSpecFluent(ConsoleSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToPlugins(Collection<String> items) {
    if (this.plugins == null) {
      this.plugins = new ArrayList();
    }
    for (String item : items) {
      this.plugins.add(item);
    }
    return (A) this;
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
  
  public A addToPlugins(String... items) {
    if (this.plugins == null) {
      this.plugins = new ArrayList();
    }
    for (String item : items) {
      this.plugins.add(item);
    }
    return (A) this;
  }
  
  public A addToPlugins(int index,String item) {
    if (this.plugins == null) {
      this.plugins = new ArrayList();
    }
    this.plugins.add(index, item);
    return (A) this;
  }
  
  public ConsoleCustomization buildCustomization() {
    return this.customization != null ? this.customization.build() : null;
  }
  
  public Ingress buildIngress() {
    return this.ingress != null ? this.ingress.build() : null;
  }
  
  public ConsoleProviders buildProviders() {
    return this.providers != null ? this.providers.build() : null;
  }
  
  public ConsoleConfigRoute buildRoute() {
    return this.route != null ? this.route.build() : null;
  }
  
  protected void copyInstance(ConsoleSpec instance) {
    instance = instance != null ? instance : new ConsoleSpec();
    if (instance != null) {
        this.withCustomization(instance.getCustomization());
        this.withIngress(instance.getIngress());
        this.withLogLevel(instance.getLogLevel());
        this.withManagementState(instance.getManagementState());
        this.withObservedConfig(instance.getObservedConfig());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withPlugins(instance.getPlugins());
        this.withProviders(instance.getProviders());
        this.withRoute(instance.getRoute());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomizationNested<A> editCustomization() {
    return this.withNewCustomizationLike(Optional.ofNullable(this.buildCustomization()).orElse(null));
  }
  
  public IngressNested<A> editIngress() {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(null));
  }
  
  public CustomizationNested<A> editOrNewCustomization() {
    return this.withNewCustomizationLike(Optional.ofNullable(this.buildCustomization()).orElse(new ConsoleCustomizationBuilder().build()));
  }
  
  public CustomizationNested<A> editOrNewCustomizationLike(ConsoleCustomization item) {
    return this.withNewCustomizationLike(Optional.ofNullable(this.buildCustomization()).orElse(item));
  }
  
  public IngressNested<A> editOrNewIngress() {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(new IngressBuilder().build()));
  }
  
  public IngressNested<A> editOrNewIngressLike(Ingress item) {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(item));
  }
  
  public ProvidersNested<A> editOrNewProviders() {
    return this.withNewProvidersLike(Optional.ofNullable(this.buildProviders()).orElse(new ConsoleProvidersBuilder().build()));
  }
  
  public ProvidersNested<A> editOrNewProvidersLike(ConsoleProviders item) {
    return this.withNewProvidersLike(Optional.ofNullable(this.buildProviders()).orElse(item));
  }
  
  public RouteNested<A> editOrNewRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(new ConsoleConfigRouteBuilder().build()));
  }
  
  public RouteNested<A> editOrNewRouteLike(ConsoleConfigRoute item) {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(item));
  }
  
  public ProvidersNested<A> editProviders() {
    return this.withNewProvidersLike(Optional.ofNullable(this.buildProviders()).orElse(null));
  }
  
  public RouteNested<A> editRoute() {
    return this.withNewRouteLike(Optional.ofNullable(this.buildRoute()).orElse(null));
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
    ConsoleSpecFluent that = (ConsoleSpecFluent) o;
    if (!(Objects.equals(customization, that.customization))) {
      return false;
    }
    if (!(Objects.equals(ingress, that.ingress))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(observedConfig, that.observedConfig))) {
      return false;
    }
    if (!(Objects.equals(operatorLogLevel, that.operatorLogLevel))) {
      return false;
    }
    if (!(Objects.equals(plugins, that.plugins))) {
      return false;
    }
    if (!(Objects.equals(providers, that.providers))) {
      return false;
    }
    if (!(Objects.equals(route, that.route))) {
      return false;
    }
    if (!(Objects.equals(unsupportedConfigOverrides, that.unsupportedConfigOverrides))) {
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
  
  public String getFirstPlugin() {
    return this.plugins.get(0);
  }
  
  public String getLastPlugin() {
    return this.plugins.get(plugins.size() - 1);
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public String getMatchingPlugin(Predicate<String> predicate) {
      for (String item : plugins) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Object getObservedConfig() {
    return this.observedConfig;
  }
  
  public String getOperatorLogLevel() {
    return this.operatorLogLevel;
  }
  
  public String getPlugin(int index) {
    return this.plugins.get(index);
  }
  
  public List<String> getPlugins() {
    return this.plugins;
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustomization() {
    return this.customization != null;
  }
  
  public boolean hasIngress() {
    return this.ingress != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasMatchingPlugin(Predicate<String> predicate) {
      for (String item : plugins) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedConfig() {
    return this.observedConfig != null;
  }
  
  public boolean hasOperatorLogLevel() {
    return this.operatorLogLevel != null;
  }
  
  public boolean hasPlugins() {
    return this.plugins != null && !(this.plugins.isEmpty());
  }
  
  public boolean hasProviders() {
    return this.providers != null;
  }
  
  public boolean hasRoute() {
    return this.route != null;
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(customization, ingress, logLevel, managementState, observedConfig, operatorLogLevel, plugins, providers, route, unsupportedConfigOverrides, additionalProperties);
  }
  
  public A removeAllFromPlugins(Collection<String> items) {
    if (this.plugins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.plugins.remove(item);
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
  
  public A removeFromPlugins(String... items) {
    if (this.plugins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.plugins.remove(item);
    }
    return (A) this;
  }
  
  public A setToPlugins(int index,String item) {
    if (this.plugins == null) {
      this.plugins = new ArrayList();
    }
    this.plugins.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(customization == null)) {
        sb.append("customization:");
        sb.append(customization);
        sb.append(",");
    }
    if (!(ingress == null)) {
        sb.append("ingress:");
        sb.append(ingress);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(observedConfig == null)) {
        sb.append("observedConfig:");
        sb.append(observedConfig);
        sb.append(",");
    }
    if (!(operatorLogLevel == null)) {
        sb.append("operatorLogLevel:");
        sb.append(operatorLogLevel);
        sb.append(",");
    }
    if (!(plugins == null) && !(plugins.isEmpty())) {
        sb.append("plugins:");
        sb.append(plugins);
        sb.append(",");
    }
    if (!(providers == null)) {
        sb.append("providers:");
        sb.append(providers);
        sb.append(",");
    }
    if (!(route == null)) {
        sb.append("route:");
        sb.append(route);
        sb.append(",");
    }
    if (!(unsupportedConfigOverrides == null)) {
        sb.append("unsupportedConfigOverrides:");
        sb.append(unsupportedConfigOverrides);
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
  
  public A withCustomization(ConsoleCustomization customization) {
    this._visitables.remove("customization");
    if (customization != null) {
        this.customization = new ConsoleCustomizationBuilder(customization);
        this._visitables.get("customization").add(this.customization);
    } else {
        this.customization = null;
        this._visitables.get("customization").remove(this.customization);
    }
    return (A) this;
  }
  
  public A withIngress(Ingress ingress) {
    this._visitables.remove("ingress");
    if (ingress != null) {
        this.ingress = new IngressBuilder(ingress);
        this._visitables.get("ingress").add(this.ingress);
    } else {
        this.ingress = null;
        this._visitables.get("ingress").remove(this.ingress);
    }
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public CustomizationNested<A> withNewCustomization() {
    return new CustomizationNested(null);
  }
  
  public CustomizationNested<A> withNewCustomizationLike(ConsoleCustomization item) {
    return new CustomizationNested(item);
  }
  
  public IngressNested<A> withNewIngress() {
    return new IngressNested(null);
  }
  
  public A withNewIngress(String clientDownloadsURL,String consoleURL) {
    return (A) this.withIngress(new Ingress(clientDownloadsURL, consoleURL));
  }
  
  public IngressNested<A> withNewIngressLike(Ingress item) {
    return new IngressNested(item);
  }
  
  public ProvidersNested<A> withNewProviders() {
    return new ProvidersNested(null);
  }
  
  public ProvidersNested<A> withNewProvidersLike(ConsoleProviders item) {
    return new ProvidersNested(item);
  }
  
  public RouteNested<A> withNewRoute() {
    return new RouteNested(null);
  }
  
  public RouteNested<A> withNewRouteLike(ConsoleConfigRoute item) {
    return new RouteNested(item);
  }
  
  public A withObservedConfig(Object observedConfig) {
    this.observedConfig = observedConfig;
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withPlugins(List<String> plugins) {
    if (plugins != null) {
        this.plugins = new ArrayList();
        for (String item : plugins) {
          this.addToPlugins(item);
        }
    } else {
      this.plugins = null;
    }
    return (A) this;
  }
  
  public A withPlugins(String... plugins) {
    if (this.plugins != null) {
        this.plugins.clear();
        _visitables.remove("plugins");
    }
    if (plugins != null) {
      for (String item : plugins) {
        this.addToPlugins(item);
      }
    }
    return (A) this;
  }
  
  public A withProviders(ConsoleProviders providers) {
    this._visitables.remove("providers");
    if (providers != null) {
        this.providers = new ConsoleProvidersBuilder(providers);
        this._visitables.get("providers").add(this.providers);
    } else {
        this.providers = null;
        this._visitables.get("providers").remove(this.providers);
    }
    return (A) this;
  }
  
  public A withRoute(ConsoleConfigRoute route) {
    this._visitables.remove("route");
    if (route != null) {
        this.route = new ConsoleConfigRouteBuilder(route);
        this._visitables.get("route").add(this.route);
    } else {
        this.route = null;
        this._visitables.get("route").remove(this.route);
    }
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  public class CustomizationNested<N> extends ConsoleCustomizationFluent<CustomizationNested<N>> implements Nested<N>{
  
    ConsoleCustomizationBuilder builder;
  
    CustomizationNested(ConsoleCustomization item) {
      this.builder = new ConsoleCustomizationBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSpecFluent.this.withCustomization(builder.build());
    }
    
    public N endCustomization() {
      return and();
    }
    
  }
  public class IngressNested<N> extends IngressFluent<IngressNested<N>> implements Nested<N>{
  
    IngressBuilder builder;
  
    IngressNested(Ingress item) {
      this.builder = new IngressBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSpecFluent.this.withIngress(builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
  public class ProvidersNested<N> extends ConsoleProvidersFluent<ProvidersNested<N>> implements Nested<N>{
  
    ConsoleProvidersBuilder builder;
  
    ProvidersNested(ConsoleProviders item) {
      this.builder = new ConsoleProvidersBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSpecFluent.this.withProviders(builder.build());
    }
    
    public N endProviders() {
      return and();
    }
    
  }
  public class RouteNested<N> extends ConsoleConfigRouteFluent<RouteNested<N>> implements Nested<N>{
  
    ConsoleConfigRouteBuilder builder;
  
    RouteNested(ConsoleConfigRoute item) {
      this.builder = new ConsoleConfigRouteBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSpecFluent.this.withRoute(builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}