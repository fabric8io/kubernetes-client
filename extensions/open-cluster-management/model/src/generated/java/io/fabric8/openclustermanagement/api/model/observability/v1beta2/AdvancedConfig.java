
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
