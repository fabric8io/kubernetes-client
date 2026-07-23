package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import java.lang.Boolean;
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
public class ImageRegistrySpecFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistrySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private Boolean defaultRoute;
  private Boolean disableRedirect;
  private String httpSecret;
  private String logLevel;
  private Long logging;
  private String managementState;
  private Map<String,String> nodeSelector;
  private Object observedConfig;
  private String operatorLogLevel;
  private ImageRegistryConfigProxyBuilder proxy;
  private Boolean readOnly;
  private Integer replicas;
  private ImageRegistryConfigRequestsBuilder requests;
  private ResourceRequirementsBuilder resources;
  private String rolloutStrategy;
  private ArrayList<ImageRegistryConfigRouteBuilder> routes = new ArrayList<ImageRegistryConfigRouteBuilder>();
  private ImageRegistryConfigStorageBuilder storage;
  private List<Toleration> tolerations = new ArrayList<Toleration>();
  private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
  private Object unsupportedConfigOverrides;

  public ImageRegistrySpecFluent() {
  }
  
  public ImageRegistrySpecFluent(ImageRegistrySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToRoutes(Collection<ImageRegistryConfigRoute> items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (ImageRegistryConfigRoute item : items) {
        ImageRegistryConfigRouteBuilder builder = new ImageRegistryConfigRouteBuilder(item);
        _visitables.get("routes").add(builder);
        this.routes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTopologySpreadConstraints(Collection<TopologySpreadConstraint> items) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    for (TopologySpreadConstraint item : items) {
      this.topologySpreadConstraints.add(item);
    }
    return (A) this;
  }
  
  public RoutesNested<A> addNewRoute() {
    return new RoutesNested(-1, null);
  }
  
  public A addNewRoute(String hostname,String name,String secretName) {
    return (A) this.addToRoutes(new ImageRegistryConfigRoute(hostname, name, secretName));
  }
  
  public RoutesNested<A> addNewRouteLike(ImageRegistryConfigRoute item) {
    return new RoutesNested(-1, item);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToRoutes(ImageRegistryConfigRoute... items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (ImageRegistryConfigRoute item : items) {
        ImageRegistryConfigRouteBuilder builder = new ImageRegistryConfigRouteBuilder(item);
        _visitables.get("routes").add(builder);
        this.routes.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoutes(int index,ImageRegistryConfigRoute item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    ImageRegistryConfigRouteBuilder builder = new ImageRegistryConfigRouteBuilder(item);
    if (index < 0 || index >= routes.size()) {
        _visitables.get("routes").add(builder);
        routes.add(builder);
    } else {
        _visitables.get("routes").add(builder);
        routes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public A addToTopologySpreadConstraints(TopologySpreadConstraint... items) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    for (TopologySpreadConstraint item : items) {
      this.topologySpreadConstraints.add(item);
    }
    return (A) this;
  }
  
  public A addToTopologySpreadConstraints(int index,TopologySpreadConstraint item) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    this.topologySpreadConstraints.add(index, item);
    return (A) this;
  }
  
  public ImageRegistryConfigRoute buildFirstRoute() {
    return this.routes.get(0).build();
  }
  
  public ImageRegistryConfigRoute buildLastRoute() {
    return this.routes.get(routes.size() - 1).build();
  }
  
  public ImageRegistryConfigRoute buildMatchingRoute(Predicate<ImageRegistryConfigRouteBuilder> predicate) {
      for (ImageRegistryConfigRouteBuilder item : routes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageRegistryConfigProxy buildProxy() {
    return this.proxy != null ? this.proxy.build() : null;
  }
  
  public ImageRegistryConfigRequests buildRequests() {
    return this.requests != null ? this.requests.build() : null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public ImageRegistryConfigRoute buildRoute(int index) {
    return this.routes.get(index).build();
  }
  
  public List<ImageRegistryConfigRoute> buildRoutes() {
    return this.routes != null ? build(routes) : null;
  }
  
  public ImageRegistryConfigStorage buildStorage() {
    return this.storage != null ? this.storage.build() : null;
  }
  
  protected void copyInstance(ImageRegistrySpec instance) {
    instance = instance != null ? instance : new ImageRegistrySpec();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withDefaultRoute(instance.getDefaultRoute());
        this.withDisableRedirect(instance.getDisableRedirect());
        this.withHttpSecret(instance.getHttpSecret());
        this.withLogLevel(instance.getLogLevel());
        this.withLogging(instance.getLogging());
        this.withManagementState(instance.getManagementState());
        this.withNodeSelector(instance.getNodeSelector());
        this.withObservedConfig(instance.getObservedConfig());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withProxy(instance.getProxy());
        this.withReadOnly(instance.getReadOnly());
        this.withReplicas(instance.getReplicas());
        this.withRequests(instance.getRequests());
        this.withResources(instance.getResources());
        this.withRolloutStrategy(instance.getRolloutStrategy());
        this.withRoutes(instance.getRoutes());
        this.withStorage(instance.getStorage());
        this.withTolerations(instance.getTolerations());
        this.withTopologySpreadConstraints(instance.getTopologySpreadConstraints());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RoutesNested<A> editFirstRoute() {
    if (routes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "routes"));
    }
    return this.setNewRouteLike(0, this.buildRoute(0));
  }
  
  public RoutesNested<A> editLastRoute() {
    int index = routes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public RoutesNested<A> editMatchingRoute(Predicate<ImageRegistryConfigRouteBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < routes.size();i++) {
      if (predicate.test(routes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public ProxyNested<A> editOrNewProxy() {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(new ImageRegistryConfigProxyBuilder().build()));
  }
  
  public ProxyNested<A> editOrNewProxyLike(ImageRegistryConfigProxy item) {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(item));
  }
  
  public RequestsNested<A> editOrNewRequests() {
    return this.withNewRequestsLike(Optional.ofNullable(this.buildRequests()).orElse(new ImageRegistryConfigRequestsBuilder().build()));
  }
  
  public RequestsNested<A> editOrNewRequestsLike(ImageRegistryConfigRequests item) {
    return this.withNewRequestsLike(Optional.ofNullable(this.buildRequests()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public StorageNested<A> editOrNewStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(new ImageRegistryConfigStorageBuilder().build()));
  }
  
  public StorageNested<A> editOrNewStorageLike(ImageRegistryConfigStorage item) {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(item));
  }
  
  public ProxyNested<A> editProxy() {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(null));
  }
  
  public RequestsNested<A> editRequests() {
    return this.withNewRequestsLike(Optional.ofNullable(this.buildRequests()).orElse(null));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public RoutesNested<A> editRoute(int index) {
    if (routes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public StorageNested<A> editStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(null));
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
    ImageRegistrySpecFluent that = (ImageRegistrySpecFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(defaultRoute, that.defaultRoute))) {
      return false;
    }
    if (!(Objects.equals(disableRedirect, that.disableRedirect))) {
      return false;
    }
    if (!(Objects.equals(httpSecret, that.httpSecret))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(logging, that.logging))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(observedConfig, that.observedConfig))) {
      return false;
    }
    if (!(Objects.equals(operatorLogLevel, that.operatorLogLevel))) {
      return false;
    }
    if (!(Objects.equals(proxy, that.proxy))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(requests, that.requests))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(rolloutStrategy, that.rolloutStrategy))) {
      return false;
    }
    if (!(Objects.equals(routes, that.routes))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
      return false;
    }
    if (!(Objects.equals(topologySpreadConstraints, that.topologySpreadConstraints))) {
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
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public Boolean getDefaultRoute() {
    return this.defaultRoute;
  }
  
  public Boolean getDisableRedirect() {
    return this.disableRedirect;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public TopologySpreadConstraint getFirstTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(0);
  }
  
  public String getHttpSecret() {
    return this.httpSecret;
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public TopologySpreadConstraint getLastTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(topologySpreadConstraints.size() - 1);
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public Long getLogging() {
    return this.logging;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public TopologySpreadConstraint getMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraint> predicate) {
      for (TopologySpreadConstraint item : topologySpreadConstraints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Object getObservedConfig() {
    return this.observedConfig;
  }
  
  public String getOperatorLogLevel() {
    return this.operatorLogLevel;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getRolloutStrategy() {
    return this.rolloutStrategy;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public TopologySpreadConstraint getTopologySpreadConstraint(int index) {
    return this.topologySpreadConstraints.get(index);
  }
  
  public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
    return this.topologySpreadConstraints;
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasDefaultRoute() {
    return this.defaultRoute != null;
  }
  
  public boolean hasDisableRedirect() {
    return this.disableRedirect != null;
  }
  
  public boolean hasHttpSecret() {
    return this.httpSecret != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasLogging() {
    return this.logging != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasMatchingRoute(Predicate<ImageRegistryConfigRouteBuilder> predicate) {
      for (ImageRegistryConfigRouteBuilder item : routes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraint> predicate) {
      for (TopologySpreadConstraint item : topologySpreadConstraints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasObservedConfig() {
    return this.observedConfig != null;
  }
  
  public boolean hasOperatorLogLevel() {
    return this.operatorLogLevel != null;
  }
  
  public boolean hasProxy() {
    return this.proxy != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasRequests() {
    return this.requests != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRolloutStrategy() {
    return this.rolloutStrategy != null;
  }
  
  public boolean hasRoutes() {
    return this.routes != null && !(this.routes.isEmpty());
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public boolean hasTopologySpreadConstraints() {
    return this.topologySpreadConstraints != null && !(this.topologySpreadConstraints.isEmpty());
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(affinity, defaultRoute, disableRedirect, httpSecret, logLevel, logging, managementState, nodeSelector, observedConfig, operatorLogLevel, proxy, readOnly, replicas, requests, resources, rolloutStrategy, routes, storage, tolerations, topologySpreadConstraints, unsupportedConfigOverrides, additionalProperties);
  }
  
  public A removeAllFromRoutes(Collection<ImageRegistryConfigRoute> items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (ImageRegistryConfigRoute item : items) {
        ImageRegistryConfigRouteBuilder builder = new ImageRegistryConfigRouteBuilder(item);
        _visitables.get("routes").remove(builder);
        this.routes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTopologySpreadConstraints(Collection<TopologySpreadConstraint> items) {
    if (this.topologySpreadConstraints == null) {
      return (A) this;
    }
    for (TopologySpreadConstraint item : items) {
      this.topologySpreadConstraints.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromRoutes(ImageRegistryConfigRoute... items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (ImageRegistryConfigRoute item : items) {
        ImageRegistryConfigRouteBuilder builder = new ImageRegistryConfigRouteBuilder(item);
        _visitables.get("routes").remove(builder);
        this.routes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTopologySpreadConstraints(TopologySpreadConstraint... items) {
    if (this.topologySpreadConstraints == null) {
      return (A) this;
    }
    for (TopologySpreadConstraint item : items) {
      this.topologySpreadConstraints.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoutes(Predicate<ImageRegistryConfigRouteBuilder> predicate) {
    if (routes == null) {
      return (A) this;
    }
    Iterator<ImageRegistryConfigRouteBuilder> each = routes.iterator();
    List visitables = _visitables.get("routes");
    while (each.hasNext()) {
        ImageRegistryConfigRouteBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RoutesNested<A> setNewRouteLike(int index,ImageRegistryConfigRoute item) {
    return new RoutesNested(index, item);
  }
  
  public A setToRoutes(int index,ImageRegistryConfigRoute item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    ImageRegistryConfigRouteBuilder builder = new ImageRegistryConfigRouteBuilder(item);
    if (index < 0 || index >= routes.size()) {
        _visitables.get("routes").add(builder);
        routes.add(builder);
    } else {
        _visitables.get("routes").add(builder);
        routes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public A setToTopologySpreadConstraints(int index,TopologySpreadConstraint item) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    this.topologySpreadConstraints.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(defaultRoute == null)) {
        sb.append("defaultRoute:");
        sb.append(defaultRoute);
        sb.append(",");
    }
    if (!(disableRedirect == null)) {
        sb.append("disableRedirect:");
        sb.append(disableRedirect);
        sb.append(",");
    }
    if (!(httpSecret == null)) {
        sb.append("httpSecret:");
        sb.append(httpSecret);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(logging == null)) {
        sb.append("logging:");
        sb.append(logging);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
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
    if (!(proxy == null)) {
        sb.append("proxy:");
        sb.append(proxy);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(requests == null)) {
        sb.append("requests:");
        sb.append(requests);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(rolloutStrategy == null)) {
        sb.append("rolloutStrategy:");
        sb.append(rolloutStrategy);
        sb.append(",");
    }
    if (!(routes == null) && !(routes.isEmpty())) {
        sb.append("routes:");
        sb.append(routes);
        sb.append(",");
    }
    if (!(storage == null)) {
        sb.append("storage:");
        sb.append(storage);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
        sb.append(",");
    }
    if (!(topologySpreadConstraints == null) && !(topologySpreadConstraints.isEmpty())) {
        sb.append("topologySpreadConstraints:");
        sb.append(topologySpreadConstraints);
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
  
  public A withAffinity(Affinity affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withDefaultRoute() {
    return withDefaultRoute(true);
  }
  
  public A withDefaultRoute(Boolean defaultRoute) {
    this.defaultRoute = defaultRoute;
    return (A) this;
  }
  
  public A withDisableRedirect() {
    return withDisableRedirect(true);
  }
  
  public A withDisableRedirect(Boolean disableRedirect) {
    this.disableRedirect = disableRedirect;
    return (A) this;
  }
  
  public A withHttpSecret(String httpSecret) {
    this.httpSecret = httpSecret;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withLogging(Long logging) {
    this.logging = logging;
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public ProxyNested<A> withNewProxy() {
    return new ProxyNested(null);
  }
  
  public A withNewProxy(String http,String https,String noProxy) {
    return (A) this.withProxy(new ImageRegistryConfigProxy(http, https, noProxy));
  }
  
  public ProxyNested<A> withNewProxyLike(ImageRegistryConfigProxy item) {
    return new ProxyNested(item);
  }
  
  public RequestsNested<A> withNewRequests() {
    return new RequestsNested(null);
  }
  
  public RequestsNested<A> withNewRequestsLike(ImageRegistryConfigRequests item) {
    return new RequestsNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public StorageNested<A> withNewStorage() {
    return new StorageNested(null);
  }
  
  public StorageNested<A> withNewStorageLike(ImageRegistryConfigStorage item) {
    return new StorageNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withObservedConfig(Object observedConfig) {
    this.observedConfig = observedConfig;
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withProxy(ImageRegistryConfigProxy proxy) {
    this._visitables.remove("proxy");
    if (proxy != null) {
        this.proxy = new ImageRegistryConfigProxyBuilder(proxy);
        this._visitables.get("proxy").add(this.proxy);
    } else {
        this.proxy = null;
        this._visitables.get("proxy").remove(this.proxy);
    }
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withRequests(ImageRegistryConfigRequests requests) {
    this._visitables.remove("requests");
    if (requests != null) {
        this.requests = new ImageRegistryConfigRequestsBuilder(requests);
        this._visitables.get("requests").add(this.requests);
    } else {
        this.requests = null;
        this._visitables.get("requests").remove(this.requests);
    }
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withRolloutStrategy(String rolloutStrategy) {
    this.rolloutStrategy = rolloutStrategy;
    return (A) this;
  }
  
  public A withRoutes(List<ImageRegistryConfigRoute> routes) {
    if (this.routes != null) {
      this._visitables.get("routes").clear();
    }
    if (routes != null) {
        this.routes = new ArrayList();
        for (ImageRegistryConfigRoute item : routes) {
          this.addToRoutes(item);
        }
    } else {
      this.routes = null;
    }
    return (A) this;
  }
  
  public A withRoutes(ImageRegistryConfigRoute... routes) {
    if (this.routes != null) {
        this.routes.clear();
        _visitables.remove("routes");
    }
    if (routes != null) {
      for (ImageRegistryConfigRoute item : routes) {
        this.addToRoutes(item);
      }
    }
    return (A) this;
  }
  
  public A withStorage(ImageRegistryConfigStorage storage) {
    this._visitables.remove("storage");
    if (storage != null) {
        this.storage = new ImageRegistryConfigStorageBuilder(storage);
        this._visitables.get("storage").add(this.storage);
    } else {
        this.storage = null;
        this._visitables.get("storage").remove(this.storage);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  
  public A withTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
    if (topologySpreadConstraints != null) {
        this.topologySpreadConstraints = new ArrayList();
        for (TopologySpreadConstraint item : topologySpreadConstraints) {
          this.addToTopologySpreadConstraints(item);
        }
    } else {
      this.topologySpreadConstraints = null;
    }
    return (A) this;
  }
  
  public A withTopologySpreadConstraints(TopologySpreadConstraint... topologySpreadConstraints) {
    if (this.topologySpreadConstraints != null) {
        this.topologySpreadConstraints.clear();
        _visitables.remove("topologySpreadConstraints");
    }
    if (topologySpreadConstraints != null) {
      for (TopologySpreadConstraint item : topologySpreadConstraints) {
        this.addToTopologySpreadConstraints(item);
      }
    }
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  public class ProxyNested<N> extends ImageRegistryConfigProxyFluent<ProxyNested<N>> implements Nested<N>{
  
    ImageRegistryConfigProxyBuilder builder;
  
    ProxyNested(ImageRegistryConfigProxy item) {
      this.builder = new ImageRegistryConfigProxyBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistrySpecFluent.this.withProxy(builder.build());
    }
    
    public N endProxy() {
      return and();
    }
    
  }
  public class RequestsNested<N> extends ImageRegistryConfigRequestsFluent<RequestsNested<N>> implements Nested<N>{
  
    ImageRegistryConfigRequestsBuilder builder;
  
    RequestsNested(ImageRegistryConfigRequests item) {
      this.builder = new ImageRegistryConfigRequestsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistrySpecFluent.this.withRequests(builder.build());
    }
    
    public N endRequests() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistrySpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class RoutesNested<N> extends ImageRegistryConfigRouteFluent<RoutesNested<N>> implements Nested<N>{
  
    ImageRegistryConfigRouteBuilder builder;
    int index;
  
    RoutesNested(int index,ImageRegistryConfigRoute item) {
      this.index = index;
      this.builder = new ImageRegistryConfigRouteBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistrySpecFluent.this.setToRoutes(index, builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
  public class StorageNested<N> extends ImageRegistryConfigStorageFluent<StorageNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageBuilder builder;
  
    StorageNested(ImageRegistryConfigStorage item) {
      this.builder = new ImageRegistryConfigStorageBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistrySpecFluent.this.withStorage(builder.build());
    }
    
    public N endStorage() {
      return and();
    }
    
  }
}