package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AdvancedConfigFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.AdvancedConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AlertmanagerSpecBuilder alertmanager;
  private CompactSpecBuilder compact;
  private String customAlertmanagerHubURL;
  private String customObservabilityHubURL;
  private CommonSpecBuilder grafana;
  private CommonSpecBuilder multiClusterObservabilityAddon;
  private CommonSpecBuilder observatoriumAPI;
  private QuerySpecBuilder query;
  private QueryFrontendSpecBuilder queryFrontend;
  private CacheConfigBuilder queryFrontendMemcached;
  private CommonSpecBuilder rbacQueryProxy;
  private ReceiveSpecBuilder receive;
  private RetentionConfigBuilder retentionConfig;
  private RuleSpecBuilder rule;
  private StoreSpecBuilder store;
  private CacheConfigBuilder storeMemcached;

  public AdvancedConfigFluent() {
  }
  
  public AdvancedConfigFluent(AdvancedConfig instance) {
    this.copyInstance(instance);
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
  
  public AlertmanagerSpec buildAlertmanager() {
    return this.alertmanager != null ? this.alertmanager.build() : null;
  }
  
  public CompactSpec buildCompact() {
    return this.compact != null ? this.compact.build() : null;
  }
  
  public CommonSpec buildGrafana() {
    return this.grafana != null ? this.grafana.build() : null;
  }
  
  public CommonSpec buildMultiClusterObservabilityAddon() {
    return this.multiClusterObservabilityAddon != null ? this.multiClusterObservabilityAddon.build() : null;
  }
  
  public CommonSpec buildObservatoriumAPI() {
    return this.observatoriumAPI != null ? this.observatoriumAPI.build() : null;
  }
  
  public QuerySpec buildQuery() {
    return this.query != null ? this.query.build() : null;
  }
  
  public QueryFrontendSpec buildQueryFrontend() {
    return this.queryFrontend != null ? this.queryFrontend.build() : null;
  }
  
  public CacheConfig buildQueryFrontendMemcached() {
    return this.queryFrontendMemcached != null ? this.queryFrontendMemcached.build() : null;
  }
  
  public CommonSpec buildRbacQueryProxy() {
    return this.rbacQueryProxy != null ? this.rbacQueryProxy.build() : null;
  }
  
  public ReceiveSpec buildReceive() {
    return this.receive != null ? this.receive.build() : null;
  }
  
  public RetentionConfig buildRetentionConfig() {
    return this.retentionConfig != null ? this.retentionConfig.build() : null;
  }
  
  public RuleSpec buildRule() {
    return this.rule != null ? this.rule.build() : null;
  }
  
  public StoreSpec buildStore() {
    return this.store != null ? this.store.build() : null;
  }
  
  public CacheConfig buildStoreMemcached() {
    return this.storeMemcached != null ? this.storeMemcached.build() : null;
  }
  
  protected void copyInstance(AdvancedConfig instance) {
    instance = instance != null ? instance : new AdvancedConfig();
    if (instance != null) {
        this.withAlertmanager(instance.getAlertmanager());
        this.withCompact(instance.getCompact());
        this.withCustomAlertmanagerHubURL(instance.getCustomAlertmanagerHubURL());
        this.withCustomObservabilityHubURL(instance.getCustomObservabilityHubURL());
        this.withGrafana(instance.getGrafana());
        this.withMultiClusterObservabilityAddon(instance.getMultiClusterObservabilityAddon());
        this.withObservatoriumAPI(instance.getObservatoriumAPI());
        this.withQuery(instance.getQuery());
        this.withQueryFrontend(instance.getQueryFrontend());
        this.withQueryFrontendMemcached(instance.getQueryFrontendMemcached());
        this.withRbacQueryProxy(instance.getRbacQueryProxy());
        this.withReceive(instance.getReceive());
        this.withRetentionConfig(instance.getRetentionConfig());
        this.withRule(instance.getRule());
        this.withStore(instance.getStore());
        this.withStoreMemcached(instance.getStoreMemcached());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlertmanagerNested<A> editAlertmanager() {
    return this.withNewAlertmanagerLike(Optional.ofNullable(this.buildAlertmanager()).orElse(null));
  }
  
  public CompactNested<A> editCompact() {
    return this.withNewCompactLike(Optional.ofNullable(this.buildCompact()).orElse(null));
  }
  
  public GrafanaNested<A> editGrafana() {
    return this.withNewGrafanaLike(Optional.ofNullable(this.buildGrafana()).orElse(null));
  }
  
  public MultiClusterObservabilityAddonNested<A> editMultiClusterObservabilityAddon() {
    return this.withNewMultiClusterObservabilityAddonLike(Optional.ofNullable(this.buildMultiClusterObservabilityAddon()).orElse(null));
  }
  
  public ObservatoriumAPINested<A> editObservatoriumAPI() {
    return this.withNewObservatoriumAPILike(Optional.ofNullable(this.buildObservatoriumAPI()).orElse(null));
  }
  
  public AlertmanagerNested<A> editOrNewAlertmanager() {
    return this.withNewAlertmanagerLike(Optional.ofNullable(this.buildAlertmanager()).orElse(new AlertmanagerSpecBuilder().build()));
  }
  
  public AlertmanagerNested<A> editOrNewAlertmanagerLike(AlertmanagerSpec item) {
    return this.withNewAlertmanagerLike(Optional.ofNullable(this.buildAlertmanager()).orElse(item));
  }
  
  public CompactNested<A> editOrNewCompact() {
    return this.withNewCompactLike(Optional.ofNullable(this.buildCompact()).orElse(new CompactSpecBuilder().build()));
  }
  
  public CompactNested<A> editOrNewCompactLike(CompactSpec item) {
    return this.withNewCompactLike(Optional.ofNullable(this.buildCompact()).orElse(item));
  }
  
  public GrafanaNested<A> editOrNewGrafana() {
    return this.withNewGrafanaLike(Optional.ofNullable(this.buildGrafana()).orElse(new CommonSpecBuilder().build()));
  }
  
  public GrafanaNested<A> editOrNewGrafanaLike(CommonSpec item) {
    return this.withNewGrafanaLike(Optional.ofNullable(this.buildGrafana()).orElse(item));
  }
  
  public MultiClusterObservabilityAddonNested<A> editOrNewMultiClusterObservabilityAddon() {
    return this.withNewMultiClusterObservabilityAddonLike(Optional.ofNullable(this.buildMultiClusterObservabilityAddon()).orElse(new CommonSpecBuilder().build()));
  }
  
  public MultiClusterObservabilityAddonNested<A> editOrNewMultiClusterObservabilityAddonLike(CommonSpec item) {
    return this.withNewMultiClusterObservabilityAddonLike(Optional.ofNullable(this.buildMultiClusterObservabilityAddon()).orElse(item));
  }
  
  public ObservatoriumAPINested<A> editOrNewObservatoriumAPI() {
    return this.withNewObservatoriumAPILike(Optional.ofNullable(this.buildObservatoriumAPI()).orElse(new CommonSpecBuilder().build()));
  }
  
  public ObservatoriumAPINested<A> editOrNewObservatoriumAPILike(CommonSpec item) {
    return this.withNewObservatoriumAPILike(Optional.ofNullable(this.buildObservatoriumAPI()).orElse(item));
  }
  
  public QueryNested<A> editOrNewQuery() {
    return this.withNewQueryLike(Optional.ofNullable(this.buildQuery()).orElse(new QuerySpecBuilder().build()));
  }
  
  public QueryFrontendNested<A> editOrNewQueryFrontend() {
    return this.withNewQueryFrontendLike(Optional.ofNullable(this.buildQueryFrontend()).orElse(new QueryFrontendSpecBuilder().build()));
  }
  
  public QueryFrontendNested<A> editOrNewQueryFrontendLike(QueryFrontendSpec item) {
    return this.withNewQueryFrontendLike(Optional.ofNullable(this.buildQueryFrontend()).orElse(item));
  }
  
  public QueryFrontendMemcachedNested<A> editOrNewQueryFrontendMemcached() {
    return this.withNewQueryFrontendMemcachedLike(Optional.ofNullable(this.buildQueryFrontendMemcached()).orElse(new CacheConfigBuilder().build()));
  }
  
  public QueryFrontendMemcachedNested<A> editOrNewQueryFrontendMemcachedLike(CacheConfig item) {
    return this.withNewQueryFrontendMemcachedLike(Optional.ofNullable(this.buildQueryFrontendMemcached()).orElse(item));
  }
  
  public QueryNested<A> editOrNewQueryLike(QuerySpec item) {
    return this.withNewQueryLike(Optional.ofNullable(this.buildQuery()).orElse(item));
  }
  
  public RbacQueryProxyNested<A> editOrNewRbacQueryProxy() {
    return this.withNewRbacQueryProxyLike(Optional.ofNullable(this.buildRbacQueryProxy()).orElse(new CommonSpecBuilder().build()));
  }
  
  public RbacQueryProxyNested<A> editOrNewRbacQueryProxyLike(CommonSpec item) {
    return this.withNewRbacQueryProxyLike(Optional.ofNullable(this.buildRbacQueryProxy()).orElse(item));
  }
  
  public ReceiveNested<A> editOrNewReceive() {
    return this.withNewReceiveLike(Optional.ofNullable(this.buildReceive()).orElse(new ReceiveSpecBuilder().build()));
  }
  
  public ReceiveNested<A> editOrNewReceiveLike(ReceiveSpec item) {
    return this.withNewReceiveLike(Optional.ofNullable(this.buildReceive()).orElse(item));
  }
  
  public RetentionConfigNested<A> editOrNewRetentionConfig() {
    return this.withNewRetentionConfigLike(Optional.ofNullable(this.buildRetentionConfig()).orElse(new RetentionConfigBuilder().build()));
  }
  
  public RetentionConfigNested<A> editOrNewRetentionConfigLike(RetentionConfig item) {
    return this.withNewRetentionConfigLike(Optional.ofNullable(this.buildRetentionConfig()).orElse(item));
  }
  
  public RuleNested<A> editOrNewRule() {
    return this.withNewRuleLike(Optional.ofNullable(this.buildRule()).orElse(new RuleSpecBuilder().build()));
  }
  
  public RuleNested<A> editOrNewRuleLike(RuleSpec item) {
    return this.withNewRuleLike(Optional.ofNullable(this.buildRule()).orElse(item));
  }
  
  public StoreNested<A> editOrNewStore() {
    return this.withNewStoreLike(Optional.ofNullable(this.buildStore()).orElse(new StoreSpecBuilder().build()));
  }
  
  public StoreNested<A> editOrNewStoreLike(StoreSpec item) {
    return this.withNewStoreLike(Optional.ofNullable(this.buildStore()).orElse(item));
  }
  
  public StoreMemcachedNested<A> editOrNewStoreMemcached() {
    return this.withNewStoreMemcachedLike(Optional.ofNullable(this.buildStoreMemcached()).orElse(new CacheConfigBuilder().build()));
  }
  
  public StoreMemcachedNested<A> editOrNewStoreMemcachedLike(CacheConfig item) {
    return this.withNewStoreMemcachedLike(Optional.ofNullable(this.buildStoreMemcached()).orElse(item));
  }
  
  public QueryNested<A> editQuery() {
    return this.withNewQueryLike(Optional.ofNullable(this.buildQuery()).orElse(null));
  }
  
  public QueryFrontendNested<A> editQueryFrontend() {
    return this.withNewQueryFrontendLike(Optional.ofNullable(this.buildQueryFrontend()).orElse(null));
  }
  
  public QueryFrontendMemcachedNested<A> editQueryFrontendMemcached() {
    return this.withNewQueryFrontendMemcachedLike(Optional.ofNullable(this.buildQueryFrontendMemcached()).orElse(null));
  }
  
  public RbacQueryProxyNested<A> editRbacQueryProxy() {
    return this.withNewRbacQueryProxyLike(Optional.ofNullable(this.buildRbacQueryProxy()).orElse(null));
  }
  
  public ReceiveNested<A> editReceive() {
    return this.withNewReceiveLike(Optional.ofNullable(this.buildReceive()).orElse(null));
  }
  
  public RetentionConfigNested<A> editRetentionConfig() {
    return this.withNewRetentionConfigLike(Optional.ofNullable(this.buildRetentionConfig()).orElse(null));
  }
  
  public RuleNested<A> editRule() {
    return this.withNewRuleLike(Optional.ofNullable(this.buildRule()).orElse(null));
  }
  
  public StoreNested<A> editStore() {
    return this.withNewStoreLike(Optional.ofNullable(this.buildStore()).orElse(null));
  }
  
  public StoreMemcachedNested<A> editStoreMemcached() {
    return this.withNewStoreMemcachedLike(Optional.ofNullable(this.buildStoreMemcached()).orElse(null));
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
    AdvancedConfigFluent that = (AdvancedConfigFluent) o;
    if (!(Objects.equals(alertmanager, that.alertmanager))) {
      return false;
    }
    if (!(Objects.equals(compact, that.compact))) {
      return false;
    }
    if (!(Objects.equals(customAlertmanagerHubURL, that.customAlertmanagerHubURL))) {
      return false;
    }
    if (!(Objects.equals(customObservabilityHubURL, that.customObservabilityHubURL))) {
      return false;
    }
    if (!(Objects.equals(grafana, that.grafana))) {
      return false;
    }
    if (!(Objects.equals(multiClusterObservabilityAddon, that.multiClusterObservabilityAddon))) {
      return false;
    }
    if (!(Objects.equals(observatoriumAPI, that.observatoriumAPI))) {
      return false;
    }
    if (!(Objects.equals(query, that.query))) {
      return false;
    }
    if (!(Objects.equals(queryFrontend, that.queryFrontend))) {
      return false;
    }
    if (!(Objects.equals(queryFrontendMemcached, that.queryFrontendMemcached))) {
      return false;
    }
    if (!(Objects.equals(rbacQueryProxy, that.rbacQueryProxy))) {
      return false;
    }
    if (!(Objects.equals(receive, that.receive))) {
      return false;
    }
    if (!(Objects.equals(retentionConfig, that.retentionConfig))) {
      return false;
    }
    if (!(Objects.equals(rule, that.rule))) {
      return false;
    }
    if (!(Objects.equals(store, that.store))) {
      return false;
    }
    if (!(Objects.equals(storeMemcached, that.storeMemcached))) {
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
  
  public String getCustomAlertmanagerHubURL() {
    return this.customAlertmanagerHubURL;
  }
  
  public String getCustomObservabilityHubURL() {
    return this.customObservabilityHubURL;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlertmanager() {
    return this.alertmanager != null;
  }
  
  public boolean hasCompact() {
    return this.compact != null;
  }
  
  public boolean hasCustomAlertmanagerHubURL() {
    return this.customAlertmanagerHubURL != null;
  }
  
  public boolean hasCustomObservabilityHubURL() {
    return this.customObservabilityHubURL != null;
  }
  
  public boolean hasGrafana() {
    return this.grafana != null;
  }
  
  public boolean hasMultiClusterObservabilityAddon() {
    return this.multiClusterObservabilityAddon != null;
  }
  
  public boolean hasObservatoriumAPI() {
    return this.observatoriumAPI != null;
  }
  
  public boolean hasQuery() {
    return this.query != null;
  }
  
  public boolean hasQueryFrontend() {
    return this.queryFrontend != null;
  }
  
  public boolean hasQueryFrontendMemcached() {
    return this.queryFrontendMemcached != null;
  }
  
  public boolean hasRbacQueryProxy() {
    return this.rbacQueryProxy != null;
  }
  
  public boolean hasReceive() {
    return this.receive != null;
  }
  
  public boolean hasRetentionConfig() {
    return this.retentionConfig != null;
  }
  
  public boolean hasRule() {
    return this.rule != null;
  }
  
  public boolean hasStore() {
    return this.store != null;
  }
  
  public boolean hasStoreMemcached() {
    return this.storeMemcached != null;
  }
  
  public int hashCode() {
    return Objects.hash(alertmanager, compact, customAlertmanagerHubURL, customObservabilityHubURL, grafana, multiClusterObservabilityAddon, observatoriumAPI, query, queryFrontend, queryFrontendMemcached, rbacQueryProxy, receive, retentionConfig, rule, store, storeMemcached, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(alertmanager == null)) {
        sb.append("alertmanager:");
        sb.append(alertmanager);
        sb.append(",");
    }
    if (!(compact == null)) {
        sb.append("compact:");
        sb.append(compact);
        sb.append(",");
    }
    if (!(customAlertmanagerHubURL == null)) {
        sb.append("customAlertmanagerHubURL:");
        sb.append(customAlertmanagerHubURL);
        sb.append(",");
    }
    if (!(customObservabilityHubURL == null)) {
        sb.append("customObservabilityHubURL:");
        sb.append(customObservabilityHubURL);
        sb.append(",");
    }
    if (!(grafana == null)) {
        sb.append("grafana:");
        sb.append(grafana);
        sb.append(",");
    }
    if (!(multiClusterObservabilityAddon == null)) {
        sb.append("multiClusterObservabilityAddon:");
        sb.append(multiClusterObservabilityAddon);
        sb.append(",");
    }
    if (!(observatoriumAPI == null)) {
        sb.append("observatoriumAPI:");
        sb.append(observatoriumAPI);
        sb.append(",");
    }
    if (!(query == null)) {
        sb.append("query:");
        sb.append(query);
        sb.append(",");
    }
    if (!(queryFrontend == null)) {
        sb.append("queryFrontend:");
        sb.append(queryFrontend);
        sb.append(",");
    }
    if (!(queryFrontendMemcached == null)) {
        sb.append("queryFrontendMemcached:");
        sb.append(queryFrontendMemcached);
        sb.append(",");
    }
    if (!(rbacQueryProxy == null)) {
        sb.append("rbacQueryProxy:");
        sb.append(rbacQueryProxy);
        sb.append(",");
    }
    if (!(receive == null)) {
        sb.append("receive:");
        sb.append(receive);
        sb.append(",");
    }
    if (!(retentionConfig == null)) {
        sb.append("retentionConfig:");
        sb.append(retentionConfig);
        sb.append(",");
    }
    if (!(rule == null)) {
        sb.append("rule:");
        sb.append(rule);
        sb.append(",");
    }
    if (!(store == null)) {
        sb.append("store:");
        sb.append(store);
        sb.append(",");
    }
    if (!(storeMemcached == null)) {
        sb.append("storeMemcached:");
        sb.append(storeMemcached);
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
  
  public A withAlertmanager(AlertmanagerSpec alertmanager) {
    this._visitables.remove("alertmanager");
    if (alertmanager != null) {
        this.alertmanager = new AlertmanagerSpecBuilder(alertmanager);
        this._visitables.get("alertmanager").add(this.alertmanager);
    } else {
        this.alertmanager = null;
        this._visitables.get("alertmanager").remove(this.alertmanager);
    }
    return (A) this;
  }
  
  public A withCompact(CompactSpec compact) {
    this._visitables.remove("compact");
    if (compact != null) {
        this.compact = new CompactSpecBuilder(compact);
        this._visitables.get("compact").add(this.compact);
    } else {
        this.compact = null;
        this._visitables.get("compact").remove(this.compact);
    }
    return (A) this;
  }
  
  public A withCustomAlertmanagerHubURL(String customAlertmanagerHubURL) {
    this.customAlertmanagerHubURL = customAlertmanagerHubURL;
    return (A) this;
  }
  
  public A withCustomObservabilityHubURL(String customObservabilityHubURL) {
    this.customObservabilityHubURL = customObservabilityHubURL;
    return (A) this;
  }
  
  public A withGrafana(CommonSpec grafana) {
    this._visitables.remove("grafana");
    if (grafana != null) {
        this.grafana = new CommonSpecBuilder(grafana);
        this._visitables.get("grafana").add(this.grafana);
    } else {
        this.grafana = null;
        this._visitables.get("grafana").remove(this.grafana);
    }
    return (A) this;
  }
  
  public A withMultiClusterObservabilityAddon(CommonSpec multiClusterObservabilityAddon) {
    this._visitables.remove("multiClusterObservabilityAddon");
    if (multiClusterObservabilityAddon != null) {
        this.multiClusterObservabilityAddon = new CommonSpecBuilder(multiClusterObservabilityAddon);
        this._visitables.get("multiClusterObservabilityAddon").add(this.multiClusterObservabilityAddon);
    } else {
        this.multiClusterObservabilityAddon = null;
        this._visitables.get("multiClusterObservabilityAddon").remove(this.multiClusterObservabilityAddon);
    }
    return (A) this;
  }
  
  public AlertmanagerNested<A> withNewAlertmanager() {
    return new AlertmanagerNested(null);
  }
  
  public AlertmanagerNested<A> withNewAlertmanagerLike(AlertmanagerSpec item) {
    return new AlertmanagerNested(item);
  }
  
  public CompactNested<A> withNewCompact() {
    return new CompactNested(null);
  }
  
  public CompactNested<A> withNewCompactLike(CompactSpec item) {
    return new CompactNested(item);
  }
  
  public GrafanaNested<A> withNewGrafana() {
    return new GrafanaNested(null);
  }
  
  public GrafanaNested<A> withNewGrafanaLike(CommonSpec item) {
    return new GrafanaNested(item);
  }
  
  public MultiClusterObservabilityAddonNested<A> withNewMultiClusterObservabilityAddon() {
    return new MultiClusterObservabilityAddonNested(null);
  }
  
  public MultiClusterObservabilityAddonNested<A> withNewMultiClusterObservabilityAddonLike(CommonSpec item) {
    return new MultiClusterObservabilityAddonNested(item);
  }
  
  public ObservatoriumAPINested<A> withNewObservatoriumAPI() {
    return new ObservatoriumAPINested(null);
  }
  
  public ObservatoriumAPINested<A> withNewObservatoriumAPILike(CommonSpec item) {
    return new ObservatoriumAPINested(item);
  }
  
  public QueryNested<A> withNewQuery() {
    return new QueryNested(null);
  }
  
  public QueryFrontendNested<A> withNewQueryFrontend() {
    return new QueryFrontendNested(null);
  }
  
  public QueryFrontendNested<A> withNewQueryFrontendLike(QueryFrontendSpec item) {
    return new QueryFrontendNested(item);
  }
  
  public QueryFrontendMemcachedNested<A> withNewQueryFrontendMemcached() {
    return new QueryFrontendMemcachedNested(null);
  }
  
  public QueryFrontendMemcachedNested<A> withNewQueryFrontendMemcachedLike(CacheConfig item) {
    return new QueryFrontendMemcachedNested(item);
  }
  
  public QueryNested<A> withNewQueryLike(QuerySpec item) {
    return new QueryNested(item);
  }
  
  public RbacQueryProxyNested<A> withNewRbacQueryProxy() {
    return new RbacQueryProxyNested(null);
  }
  
  public RbacQueryProxyNested<A> withNewRbacQueryProxyLike(CommonSpec item) {
    return new RbacQueryProxyNested(item);
  }
  
  public ReceiveNested<A> withNewReceive() {
    return new ReceiveNested(null);
  }
  
  public ReceiveNested<A> withNewReceiveLike(ReceiveSpec item) {
    return new ReceiveNested(item);
  }
  
  public RetentionConfigNested<A> withNewRetentionConfig() {
    return new RetentionConfigNested(null);
  }
  
  public RetentionConfigNested<A> withNewRetentionConfigLike(RetentionConfig item) {
    return new RetentionConfigNested(item);
  }
  
  public RuleNested<A> withNewRule() {
    return new RuleNested(null);
  }
  
  public RuleNested<A> withNewRuleLike(RuleSpec item) {
    return new RuleNested(item);
  }
  
  public StoreNested<A> withNewStore() {
    return new StoreNested(null);
  }
  
  public StoreNested<A> withNewStoreLike(StoreSpec item) {
    return new StoreNested(item);
  }
  
  public StoreMemcachedNested<A> withNewStoreMemcached() {
    return new StoreMemcachedNested(null);
  }
  
  public StoreMemcachedNested<A> withNewStoreMemcachedLike(CacheConfig item) {
    return new StoreMemcachedNested(item);
  }
  
  public A withObservatoriumAPI(CommonSpec observatoriumAPI) {
    this._visitables.remove("observatoriumAPI");
    if (observatoriumAPI != null) {
        this.observatoriumAPI = new CommonSpecBuilder(observatoriumAPI);
        this._visitables.get("observatoriumAPI").add(this.observatoriumAPI);
    } else {
        this.observatoriumAPI = null;
        this._visitables.get("observatoriumAPI").remove(this.observatoriumAPI);
    }
    return (A) this;
  }
  
  public A withQuery(QuerySpec query) {
    this._visitables.remove("query");
    if (query != null) {
        this.query = new QuerySpecBuilder(query);
        this._visitables.get("query").add(this.query);
    } else {
        this.query = null;
        this._visitables.get("query").remove(this.query);
    }
    return (A) this;
  }
  
  public A withQueryFrontend(QueryFrontendSpec queryFrontend) {
    this._visitables.remove("queryFrontend");
    if (queryFrontend != null) {
        this.queryFrontend = new QueryFrontendSpecBuilder(queryFrontend);
        this._visitables.get("queryFrontend").add(this.queryFrontend);
    } else {
        this.queryFrontend = null;
        this._visitables.get("queryFrontend").remove(this.queryFrontend);
    }
    return (A) this;
  }
  
  public A withQueryFrontendMemcached(CacheConfig queryFrontendMemcached) {
    this._visitables.remove("queryFrontendMemcached");
    if (queryFrontendMemcached != null) {
        this.queryFrontendMemcached = new CacheConfigBuilder(queryFrontendMemcached);
        this._visitables.get("queryFrontendMemcached").add(this.queryFrontendMemcached);
    } else {
        this.queryFrontendMemcached = null;
        this._visitables.get("queryFrontendMemcached").remove(this.queryFrontendMemcached);
    }
    return (A) this;
  }
  
  public A withRbacQueryProxy(CommonSpec rbacQueryProxy) {
    this._visitables.remove("rbacQueryProxy");
    if (rbacQueryProxy != null) {
        this.rbacQueryProxy = new CommonSpecBuilder(rbacQueryProxy);
        this._visitables.get("rbacQueryProxy").add(this.rbacQueryProxy);
    } else {
        this.rbacQueryProxy = null;
        this._visitables.get("rbacQueryProxy").remove(this.rbacQueryProxy);
    }
    return (A) this;
  }
  
  public A withReceive(ReceiveSpec receive) {
    this._visitables.remove("receive");
    if (receive != null) {
        this.receive = new ReceiveSpecBuilder(receive);
        this._visitables.get("receive").add(this.receive);
    } else {
        this.receive = null;
        this._visitables.get("receive").remove(this.receive);
    }
    return (A) this;
  }
  
  public A withRetentionConfig(RetentionConfig retentionConfig) {
    this._visitables.remove("retentionConfig");
    if (retentionConfig != null) {
        this.retentionConfig = new RetentionConfigBuilder(retentionConfig);
        this._visitables.get("retentionConfig").add(this.retentionConfig);
    } else {
        this.retentionConfig = null;
        this._visitables.get("retentionConfig").remove(this.retentionConfig);
    }
    return (A) this;
  }
  
  public A withRule(RuleSpec rule) {
    this._visitables.remove("rule");
    if (rule != null) {
        this.rule = new RuleSpecBuilder(rule);
        this._visitables.get("rule").add(this.rule);
    } else {
        this.rule = null;
        this._visitables.get("rule").remove(this.rule);
    }
    return (A) this;
  }
  
  public A withStore(StoreSpec store) {
    this._visitables.remove("store");
    if (store != null) {
        this.store = new StoreSpecBuilder(store);
        this._visitables.get("store").add(this.store);
    } else {
        this.store = null;
        this._visitables.get("store").remove(this.store);
    }
    return (A) this;
  }
  
  public A withStoreMemcached(CacheConfig storeMemcached) {
    this._visitables.remove("storeMemcached");
    if (storeMemcached != null) {
        this.storeMemcached = new CacheConfigBuilder(storeMemcached);
        this._visitables.get("storeMemcached").add(this.storeMemcached);
    } else {
        this.storeMemcached = null;
        this._visitables.get("storeMemcached").remove(this.storeMemcached);
    }
    return (A) this;
  }
  public class AlertmanagerNested<N> extends AlertmanagerSpecFluent<AlertmanagerNested<N>> implements Nested<N>{
  
    AlertmanagerSpecBuilder builder;
  
    AlertmanagerNested(AlertmanagerSpec item) {
      this.builder = new AlertmanagerSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withAlertmanager(builder.build());
    }
    
    public N endAlertmanager() {
      return and();
    }
    
  }
  public class CompactNested<N> extends CompactSpecFluent<CompactNested<N>> implements Nested<N>{
  
    CompactSpecBuilder builder;
  
    CompactNested(CompactSpec item) {
      this.builder = new CompactSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withCompact(builder.build());
    }
    
    public N endCompact() {
      return and();
    }
    
  }
  public class GrafanaNested<N> extends CommonSpecFluent<GrafanaNested<N>> implements Nested<N>{
  
    CommonSpecBuilder builder;
  
    GrafanaNested(CommonSpec item) {
      this.builder = new CommonSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withGrafana(builder.build());
    }
    
    public N endGrafana() {
      return and();
    }
    
  }
  public class MultiClusterObservabilityAddonNested<N> extends CommonSpecFluent<MultiClusterObservabilityAddonNested<N>> implements Nested<N>{
  
    CommonSpecBuilder builder;
  
    MultiClusterObservabilityAddonNested(CommonSpec item) {
      this.builder = new CommonSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withMultiClusterObservabilityAddon(builder.build());
    }
    
    public N endMultiClusterObservabilityAddon() {
      return and();
    }
    
  }
  public class ObservatoriumAPINested<N> extends CommonSpecFluent<ObservatoriumAPINested<N>> implements Nested<N>{
  
    CommonSpecBuilder builder;
  
    ObservatoriumAPINested(CommonSpec item) {
      this.builder = new CommonSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withObservatoriumAPI(builder.build());
    }
    
    public N endObservatoriumAPI() {
      return and();
    }
    
  }
  public class QueryFrontendMemcachedNested<N> extends CacheConfigFluent<QueryFrontendMemcachedNested<N>> implements Nested<N>{
  
    CacheConfigBuilder builder;
  
    QueryFrontendMemcachedNested(CacheConfig item) {
      this.builder = new CacheConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withQueryFrontendMemcached(builder.build());
    }
    
    public N endQueryFrontendMemcached() {
      return and();
    }
    
  }
  public class QueryFrontendNested<N> extends QueryFrontendSpecFluent<QueryFrontendNested<N>> implements Nested<N>{
  
    QueryFrontendSpecBuilder builder;
  
    QueryFrontendNested(QueryFrontendSpec item) {
      this.builder = new QueryFrontendSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withQueryFrontend(builder.build());
    }
    
    public N endQueryFrontend() {
      return and();
    }
    
  }
  public class QueryNested<N> extends QuerySpecFluent<QueryNested<N>> implements Nested<N>{
  
    QuerySpecBuilder builder;
  
    QueryNested(QuerySpec item) {
      this.builder = new QuerySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withQuery(builder.build());
    }
    
    public N endQuery() {
      return and();
    }
    
  }
  public class RbacQueryProxyNested<N> extends CommonSpecFluent<RbacQueryProxyNested<N>> implements Nested<N>{
  
    CommonSpecBuilder builder;
  
    RbacQueryProxyNested(CommonSpec item) {
      this.builder = new CommonSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withRbacQueryProxy(builder.build());
    }
    
    public N endRbacQueryProxy() {
      return and();
    }
    
  }
  public class ReceiveNested<N> extends ReceiveSpecFluent<ReceiveNested<N>> implements Nested<N>{
  
    ReceiveSpecBuilder builder;
  
    ReceiveNested(ReceiveSpec item) {
      this.builder = new ReceiveSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withReceive(builder.build());
    }
    
    public N endReceive() {
      return and();
    }
    
  }
  public class RetentionConfigNested<N> extends RetentionConfigFluent<RetentionConfigNested<N>> implements Nested<N>{
  
    RetentionConfigBuilder builder;
  
    RetentionConfigNested(RetentionConfig item) {
      this.builder = new RetentionConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withRetentionConfig(builder.build());
    }
    
    public N endRetentionConfig() {
      return and();
    }
    
  }
  public class RuleNested<N> extends RuleSpecFluent<RuleNested<N>> implements Nested<N>{
  
    RuleSpecBuilder builder;
  
    RuleNested(RuleSpec item) {
      this.builder = new RuleSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withRule(builder.build());
    }
    
    public N endRule() {
      return and();
    }
    
  }
  public class StoreMemcachedNested<N> extends CacheConfigFluent<StoreMemcachedNested<N>> implements Nested<N>{
  
    CacheConfigBuilder builder;
  
    StoreMemcachedNested(CacheConfig item) {
      this.builder = new CacheConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withStoreMemcached(builder.build());
    }
    
    public N endStoreMemcached() {
      return and();
    }
    
  }
  public class StoreNested<N> extends StoreSpecFluent<StoreNested<N>> implements Nested<N>{
  
    StoreSpecBuilder builder;
  
    StoreNested(StoreSpec item) {
      this.builder = new StoreSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AdvancedConfigFluent.this.withStore(builder.build());
    }
    
    public N endStore() {
      return and();
    }
    
  }
}