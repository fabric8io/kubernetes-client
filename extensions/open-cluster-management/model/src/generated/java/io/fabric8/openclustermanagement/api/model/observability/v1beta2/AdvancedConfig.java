
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alertmanager",
    "compact",
    "customAlertmanagerHubURL",
    "customObservabilityHubURL",
    "grafana",
    "multiClusterObservabilityAddon",
    "observatoriumAPI",
    "query",
    "queryFrontend",
    "queryFrontendMemcached",
    "rbacQueryProxy",
    "receive",
    "retentionConfig",
    "rule",
    "store",
    "storeMemcached"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AdvancedConfig implements Editable<AdvancedConfigBuilder>, KubernetesResource
{

    @JsonProperty("alertmanager")
    private AlertmanagerSpec alertmanager;
    @JsonProperty("compact")
    private CompactSpec compact;
    @JsonProperty("customAlertmanagerHubURL")
    private String customAlertmanagerHubURL;
    @JsonProperty("customObservabilityHubURL")
    private String customObservabilityHubURL;
    @JsonProperty("grafana")
    private CommonSpec grafana;
    @JsonProperty("multiClusterObservabilityAddon")
    private CommonSpec multiClusterObservabilityAddon;
    @JsonProperty("observatoriumAPI")
    private CommonSpec observatoriumAPI;
    @JsonProperty("query")
    private QuerySpec query;
    @JsonProperty("queryFrontend")
    private QueryFrontendSpec queryFrontend;
    @JsonProperty("queryFrontendMemcached")
    private CacheConfig queryFrontendMemcached;
    @JsonProperty("rbacQueryProxy")
    private CommonSpec rbacQueryProxy;
    @JsonProperty("receive")
    private ReceiveSpec receive;
    @JsonProperty("retentionConfig")
    private RetentionConfig retentionConfig;
    @JsonProperty("rule")
    private RuleSpec rule;
    @JsonProperty("store")
    private StoreSpec store;
    @JsonProperty("storeMemcached")
    private CacheConfig storeMemcached;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AdvancedConfig() {
    }

    public AdvancedConfig(AlertmanagerSpec alertmanager, CompactSpec compact, String customAlertmanagerHubURL, String customObservabilityHubURL, CommonSpec grafana, CommonSpec multiClusterObservabilityAddon, CommonSpec observatoriumAPI, QuerySpec query, QueryFrontendSpec queryFrontend, CacheConfig queryFrontendMemcached, CommonSpec rbacQueryProxy, ReceiveSpec receive, RetentionConfig retentionConfig, RuleSpec rule, StoreSpec store, CacheConfig storeMemcached) {
        super();
        this.alertmanager = alertmanager;
        this.compact = compact;
        this.customAlertmanagerHubURL = customAlertmanagerHubURL;
        this.customObservabilityHubURL = customObservabilityHubURL;
        this.grafana = grafana;
        this.multiClusterObservabilityAddon = multiClusterObservabilityAddon;
        this.observatoriumAPI = observatoriumAPI;
        this.query = query;
        this.queryFrontend = queryFrontend;
        this.queryFrontendMemcached = queryFrontendMemcached;
        this.rbacQueryProxy = rbacQueryProxy;
        this.receive = receive;
        this.retentionConfig = retentionConfig;
        this.rule = rule;
        this.store = store;
        this.storeMemcached = storeMemcached;
    }

    @JsonProperty("alertmanager")
    public AlertmanagerSpec getAlertmanager() {
        return alertmanager;
    }

    @JsonProperty("alertmanager")
    public void setAlertmanager(AlertmanagerSpec alertmanager) {
        this.alertmanager = alertmanager;
    }

    @JsonProperty("compact")
    public CompactSpec getCompact() {
        return compact;
    }

    @JsonProperty("compact")
    public void setCompact(CompactSpec compact) {
        this.compact = compact;
    }

    /**
     * CustomAlertmanagerHubURL overrides the alertmanager URL to send alerts from the spoke to the hub server. For the alertmanager that runs in the hub this setting has no effect.
     */
    @JsonProperty("customAlertmanagerHubURL")
    public String getCustomAlertmanagerHubURL() {
        return customAlertmanagerHubURL;
    }

    /**
     * CustomAlertmanagerHubURL overrides the alertmanager URL to send alerts from the spoke to the hub server. For the alertmanager that runs in the hub this setting has no effect.
     */
    @JsonProperty("customAlertmanagerHubURL")
    public void setCustomAlertmanagerHubURL(String customAlertmanagerHubURL) {
        this.customAlertmanagerHubURL = customAlertmanagerHubURL;
    }

    /**
     * CustomObservabilityHubURL overrides the endpoint used by the metrics-collector to send metrics to the hub server. For the metrics-collector that runs in the hub this setting has no effect.
     */
    @JsonProperty("customObservabilityHubURL")
    public String getCustomObservabilityHubURL() {
        return customObservabilityHubURL;
    }

    /**
     * CustomObservabilityHubURL overrides the endpoint used by the metrics-collector to send metrics to the hub server. For the metrics-collector that runs in the hub this setting has no effect.
     */
    @JsonProperty("customObservabilityHubURL")
    public void setCustomObservabilityHubURL(String customObservabilityHubURL) {
        this.customObservabilityHubURL = customObservabilityHubURL;
    }

    @JsonProperty("grafana")
    public CommonSpec getGrafana() {
        return grafana;
    }

    @JsonProperty("grafana")
    public void setGrafana(CommonSpec grafana) {
        this.grafana = grafana;
    }

    @JsonProperty("multiClusterObservabilityAddon")
    public CommonSpec getMultiClusterObservabilityAddon() {
        return multiClusterObservabilityAddon;
    }

    @JsonProperty("multiClusterObservabilityAddon")
    public void setMultiClusterObservabilityAddon(CommonSpec multiClusterObservabilityAddon) {
        this.multiClusterObservabilityAddon = multiClusterObservabilityAddon;
    }

    @JsonProperty("observatoriumAPI")
    public CommonSpec getObservatoriumAPI() {
        return observatoriumAPI;
    }

    @JsonProperty("observatoriumAPI")
    public void setObservatoriumAPI(CommonSpec observatoriumAPI) {
        this.observatoriumAPI = observatoriumAPI;
    }

    @JsonProperty("query")
    public QuerySpec getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(QuerySpec query) {
        this.query = query;
    }

    @JsonProperty("queryFrontend")
    public QueryFrontendSpec getQueryFrontend() {
        return queryFrontend;
    }

    @JsonProperty("queryFrontend")
    public void setQueryFrontend(QueryFrontendSpec queryFrontend) {
        this.queryFrontend = queryFrontend;
    }

    @JsonProperty("queryFrontendMemcached")
    public CacheConfig getQueryFrontendMemcached() {
        return queryFrontendMemcached;
    }

    @JsonProperty("queryFrontendMemcached")
    public void setQueryFrontendMemcached(CacheConfig queryFrontendMemcached) {
        this.queryFrontendMemcached = queryFrontendMemcached;
    }

    @JsonProperty("rbacQueryProxy")
    public CommonSpec getRbacQueryProxy() {
        return rbacQueryProxy;
    }

    @JsonProperty("rbacQueryProxy")
    public void setRbacQueryProxy(CommonSpec rbacQueryProxy) {
        this.rbacQueryProxy = rbacQueryProxy;
    }

    @JsonProperty("receive")
    public ReceiveSpec getReceive() {
        return receive;
    }

    @JsonProperty("receive")
    public void setReceive(ReceiveSpec receive) {
        this.receive = receive;
    }

    @JsonProperty("retentionConfig")
    public RetentionConfig getRetentionConfig() {
        return retentionConfig;
    }

    @JsonProperty("retentionConfig")
    public void setRetentionConfig(RetentionConfig retentionConfig) {
        this.retentionConfig = retentionConfig;
    }

    @JsonProperty("rule")
    public RuleSpec getRule() {
        return rule;
    }

    @JsonProperty("rule")
    public void setRule(RuleSpec rule) {
        this.rule = rule;
    }

    @JsonProperty("store")
    public StoreSpec getStore() {
        return store;
    }

    @JsonProperty("store")
    public void setStore(StoreSpec store) {
        this.store = store;
    }

    @JsonProperty("storeMemcached")
    public CacheConfig getStoreMemcached() {
        return storeMemcached;
    }

    @JsonProperty("storeMemcached")
    public void setStoreMemcached(CacheConfig storeMemcached) {
        this.storeMemcached = storeMemcached;
    }

    @JsonIgnore
    public AdvancedConfigBuilder edit() {
        return new AdvancedConfigBuilder(this);
    }

    @JsonIgnore
    public AdvancedConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdvancedConfig)) {
            return false;
        }
        AdvancedConfig other = (AdvancedConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alertmanager = this.getAlertmanager();
        Object other$alertmanager = other.getAlertmanager();
        if (this$alertmanager == null ? other$alertmanager != null : !this$alertmanager.equals(other$alertmanager)) {
            return false;
        }
        Object this$compact = this.getCompact();
        Object other$compact = other.getCompact();
        if (this$compact == null ? other$compact != null : !this$compact.equals(other$compact)) {
            return false;
        }
        Object this$customAlertmanagerHubURL = this.getCustomAlertmanagerHubURL();
        Object other$customAlertmanagerHubURL = other.getCustomAlertmanagerHubURL();
        if (this$customAlertmanagerHubURL == null ? other$customAlertmanagerHubURL != null : !this$customAlertmanagerHubURL.equals(other$customAlertmanagerHubURL)) {
            return false;
        }
        Object this$customObservabilityHubURL = this.getCustomObservabilityHubURL();
        Object other$customObservabilityHubURL = other.getCustomObservabilityHubURL();
        if (this$customObservabilityHubURL == null ? other$customObservabilityHubURL != null : !this$customObservabilityHubURL.equals(other$customObservabilityHubURL)) {
            return false;
        }
        Object this$grafana = this.getGrafana();
        Object other$grafana = other.getGrafana();
        if (this$grafana == null ? other$grafana != null : !this$grafana.equals(other$grafana)) {
            return false;
        }
        Object this$multiClusterObservabilityAddon = this.getMultiClusterObservabilityAddon();
        Object other$multiClusterObservabilityAddon = other.getMultiClusterObservabilityAddon();
        if (this$multiClusterObservabilityAddon == null ? other$multiClusterObservabilityAddon != null : !this$multiClusterObservabilityAddon.equals(other$multiClusterObservabilityAddon)) {
            return false;
        }
        Object this$observatoriumAPI = this.getObservatoriumAPI();
        Object other$observatoriumAPI = other.getObservatoriumAPI();
        if (this$observatoriumAPI == null ? other$observatoriumAPI != null : !this$observatoriumAPI.equals(other$observatoriumAPI)) {
            return false;
        }
        Object this$query = this.getQuery();
        Object other$query = other.getQuery();
        if (this$query == null ? other$query != null : !this$query.equals(other$query)) {
            return false;
        }
        Object this$queryFrontend = this.getQueryFrontend();
        Object other$queryFrontend = other.getQueryFrontend();
        if (this$queryFrontend == null ? other$queryFrontend != null : !this$queryFrontend.equals(other$queryFrontend)) {
            return false;
        }
        Object this$queryFrontendMemcached = this.getQueryFrontendMemcached();
        Object other$queryFrontendMemcached = other.getQueryFrontendMemcached();
        if (this$queryFrontendMemcached == null ? other$queryFrontendMemcached != null : !this$queryFrontendMemcached.equals(other$queryFrontendMemcached)) {
            return false;
        }
        Object this$rbacQueryProxy = this.getRbacQueryProxy();
        Object other$rbacQueryProxy = other.getRbacQueryProxy();
        if (this$rbacQueryProxy == null ? other$rbacQueryProxy != null : !this$rbacQueryProxy.equals(other$rbacQueryProxy)) {
            return false;
        }
        Object this$receive = this.getReceive();
        Object other$receive = other.getReceive();
        if (this$receive == null ? other$receive != null : !this$receive.equals(other$receive)) {
            return false;
        }
        Object this$retentionConfig = this.getRetentionConfig();
        Object other$retentionConfig = other.getRetentionConfig();
        if (this$retentionConfig == null ? other$retentionConfig != null : !this$retentionConfig.equals(other$retentionConfig)) {
            return false;
        }
        Object this$rule = this.getRule();
        Object other$rule = other.getRule();
        if (this$rule == null ? other$rule != null : !this$rule.equals(other$rule)) {
            return false;
        }
        Object this$store = this.getStore();
        Object other$store = other.getStore();
        if (this$store == null ? other$store != null : !this$store.equals(other$store)) {
            return false;
        }
        Object this$storeMemcached = this.getStoreMemcached();
        Object other$storeMemcached = other.getStoreMemcached();
        if (this$storeMemcached == null ? other$storeMemcached != null : !this$storeMemcached.equals(other$storeMemcached)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AdvancedConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alertmanager = this.getAlertmanager();
        result = result * prime + ($alertmanager == null ? 43 : $alertmanager.hashCode());
        Object $compact = this.getCompact();
        result = result * prime + ($compact == null ? 43 : $compact.hashCode());
        Object $customAlertmanagerHubURL = this.getCustomAlertmanagerHubURL();
        result = result * prime + ($customAlertmanagerHubURL == null ? 43 : $customAlertmanagerHubURL.hashCode());
        Object $customObservabilityHubURL = this.getCustomObservabilityHubURL();
        result = result * prime + ($customObservabilityHubURL == null ? 43 : $customObservabilityHubURL.hashCode());
        Object $grafana = this.getGrafana();
        result = result * prime + ($grafana == null ? 43 : $grafana.hashCode());
        Object $multiClusterObservabilityAddon = this.getMultiClusterObservabilityAddon();
        result = result * prime + ($multiClusterObservabilityAddon == null ? 43 : $multiClusterObservabilityAddon.hashCode());
        Object $observatoriumAPI = this.getObservatoriumAPI();
        result = result * prime + ($observatoriumAPI == null ? 43 : $observatoriumAPI.hashCode());
        Object $query = this.getQuery();
        result = result * prime + ($query == null ? 43 : $query.hashCode());
        Object $queryFrontend = this.getQueryFrontend();
        result = result * prime + ($queryFrontend == null ? 43 : $queryFrontend.hashCode());
        Object $queryFrontendMemcached = this.getQueryFrontendMemcached();
        result = result * prime + ($queryFrontendMemcached == null ? 43 : $queryFrontendMemcached.hashCode());
        Object $rbacQueryProxy = this.getRbacQueryProxy();
        result = result * prime + ($rbacQueryProxy == null ? 43 : $rbacQueryProxy.hashCode());
        Object $receive = this.getReceive();
        result = result * prime + ($receive == null ? 43 : $receive.hashCode());
        Object $retentionConfig = this.getRetentionConfig();
        result = result * prime + ($retentionConfig == null ? 43 : $retentionConfig.hashCode());
        Object $rule = this.getRule();
        result = result * prime + ($rule == null ? 43 : $rule.hashCode());
        Object $store = this.getStore();
        result = result * prime + ($store == null ? 43 : $store.hashCode());
        Object $storeMemcached = this.getStoreMemcached();
        result = result * prime + ($storeMemcached == null ? 43 : $storeMemcached.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdvancedConfig(" + "alertmanager=" + this.getAlertmanager() + ", compact=" + this.getCompact() + ", customAlertmanagerHubURL=" + this.getCustomAlertmanagerHubURL() + ", customObservabilityHubURL=" + this.getCustomObservabilityHubURL() + ", grafana=" + this.getGrafana() + ", multiClusterObservabilityAddon=" + this.getMultiClusterObservabilityAddon() + ", observatoriumAPI=" + this.getObservatoriumAPI() + ", query=" + this.getQuery() + ", queryFrontend=" + this.getQueryFrontend() + ", queryFrontendMemcached=" + this.getQueryFrontendMemcached() + ", rbacQueryProxy=" + this.getRbacQueryProxy() + ", receive=" + this.getReceive() + ", retentionConfig=" + this.getRetentionConfig() + ", rule=" + this.getRule() + ", store=" + this.getStore() + ", storeMemcached=" + this.getStoreMemcached() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
