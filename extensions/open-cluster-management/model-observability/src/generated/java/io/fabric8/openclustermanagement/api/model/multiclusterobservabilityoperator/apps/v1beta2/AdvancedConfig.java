
package io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "alertmanager",
    "compact",
    "grafana",
    "observatoriumAPI",
    "observatoriumConfig",
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
@Setter
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
public class AdvancedConfig implements KubernetesResource
{

    @JsonProperty("alertmanager")
    private CommonSpec alertmanager;
    @JsonProperty("compact")
    private CompactSpec compact;
    @JsonProperty("grafana")
    private CommonSpec grafana;
    @JsonProperty("observatoriumAPI")
    private CommonSpec observatoriumAPI;
    @JsonProperty("observatoriumConfig")
    private ObservatoriumConfig observatoriumConfig;
    @JsonProperty("query")
    private CommonSpec query;
    @JsonProperty("queryFrontend")
    private CommonSpec queryFrontend;
    @JsonProperty("queryFrontendMemcached")
    private CacheConfig queryFrontendMemcached;
    @JsonProperty("rbacQueryProxy")
    private CommonSpec rbacQueryProxy;
    @JsonProperty("receive")
    private CommonSpec receive;
    @JsonProperty("retentionConfig")
    private RetentionConfig retentionConfig;
    @JsonProperty("rule")
    private RuleSpec rule;
    @JsonProperty("store")
    private CommonSpec store;
    @JsonProperty("storeMemcached")
    private CacheConfig storeMemcached;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AdvancedConfig() {
    }

    /**
     * 
     * @param receive
     * @param compact
     * @param query
     * @param observatoriumConfig
     * @param rule
     * @param store
     * @param queryFrontend
     * @param grafana
     * @param storeMemcached
     * @param queryFrontendMemcached
     * @param rbacQueryProxy
     * @param retentionConfig
     * @param alertmanager
     * @param observatoriumAPI
     */
    public AdvancedConfig(CommonSpec alertmanager, CompactSpec compact, CommonSpec grafana, CommonSpec observatoriumAPI, ObservatoriumConfig observatoriumConfig, CommonSpec query, CommonSpec queryFrontend, CacheConfig queryFrontendMemcached, CommonSpec rbacQueryProxy, CommonSpec receive, RetentionConfig retentionConfig, RuleSpec rule, CommonSpec store, CacheConfig storeMemcached) {
        super();
        this.alertmanager = alertmanager;
        this.compact = compact;
        this.grafana = grafana;
        this.observatoriumAPI = observatoriumAPI;
        this.observatoriumConfig = observatoriumConfig;
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
    public CommonSpec getAlertmanager() {
        return alertmanager;
    }

    @JsonProperty("alertmanager")
    public void setAlertmanager(CommonSpec alertmanager) {
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

    @JsonProperty("grafana")
    public CommonSpec getGrafana() {
        return grafana;
    }

    @JsonProperty("grafana")
    public void setGrafana(CommonSpec grafana) {
        this.grafana = grafana;
    }

    @JsonProperty("observatoriumAPI")
    public CommonSpec getObservatoriumAPI() {
        return observatoriumAPI;
    }

    @JsonProperty("observatoriumAPI")
    public void setObservatoriumAPI(CommonSpec observatoriumAPI) {
        this.observatoriumAPI = observatoriumAPI;
    }

    @JsonProperty("observatoriumConfig")
    public ObservatoriumConfig getObservatoriumConfig() {
        return observatoriumConfig;
    }

    @JsonProperty("observatoriumConfig")
    public void setObservatoriumConfig(ObservatoriumConfig observatoriumConfig) {
        this.observatoriumConfig = observatoriumConfig;
    }

    @JsonProperty("query")
    public CommonSpec getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(CommonSpec query) {
        this.query = query;
    }

    @JsonProperty("queryFrontend")
    public CommonSpec getQueryFrontend() {
        return queryFrontend;
    }

    @JsonProperty("queryFrontend")
    public void setQueryFrontend(CommonSpec queryFrontend) {
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
    public CommonSpec getReceive() {
        return receive;
    }

    @JsonProperty("receive")
    public void setReceive(CommonSpec receive) {
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
    public CommonSpec getStore() {
        return store;
    }

    @JsonProperty("store")
    public void setStore(CommonSpec store) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
