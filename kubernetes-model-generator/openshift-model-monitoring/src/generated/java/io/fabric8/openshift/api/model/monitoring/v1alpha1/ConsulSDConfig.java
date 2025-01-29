
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowStale",
    "authorization",
    "basicAuth",
    "datacenter",
    "enableHTTP2",
    "filter",
    "followRedirects",
    "namespace",
    "noProxy",
    "nodeMeta",
    "oauth2",
    "partition",
    "pathPrefix",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "refreshInterval",
    "scheme",
    "server",
    "services",
    "tagSeparator",
    "tags",
    "tlsConfig",
    "tokenRef"
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
public class ConsulSDConfig implements Editable<ConsulSDConfigBuilder>, KubernetesResource
{

    @JsonProperty("allowStale")
    private Boolean allowStale;
    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("filter")
    private String filter;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("nodeMeta")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeMeta = new LinkedHashMap<>();
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("partition")
    private String partition;
    @JsonProperty("pathPrefix")
    private String pathPrefix;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("refreshInterval")
    private String refreshInterval;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("server")
    private String server;
    @JsonProperty("services")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> services = new ArrayList<>();
    @JsonProperty("tagSeparator")
    private String tagSeparator;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("tokenRef")
    private SecretKeySelector tokenRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsulSDConfig() {
    }

    public ConsulSDConfig(Boolean allowStale, SafeAuthorization authorization, BasicAuth basicAuth, String datacenter, Boolean enableHTTP2, String filter, Boolean followRedirects, String namespace, String noProxy, Map<String, String> nodeMeta, OAuth2 oauth2, String partition, String pathPrefix, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String refreshInterval, String scheme, String server, List<String> services, String tagSeparator, List<String> tags, SafeTLSConfig tlsConfig, SecretKeySelector tokenRef) {
        super();
        this.allowStale = allowStale;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.datacenter = datacenter;
        this.enableHTTP2 = enableHTTP2;
        this.filter = filter;
        this.followRedirects = followRedirects;
        this.namespace = namespace;
        this.noProxy = noProxy;
        this.nodeMeta = nodeMeta;
        this.oauth2 = oauth2;
        this.partition = partition;
        this.pathPrefix = pathPrefix;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.refreshInterval = refreshInterval;
        this.scheme = scheme;
        this.server = server;
        this.services = services;
        this.tagSeparator = tagSeparator;
        this.tags = tags;
        this.tlsConfig = tlsConfig;
        this.tokenRef = tokenRef;
    }

    @JsonProperty("allowStale")
    public Boolean getAllowStale() {
        return allowStale;
    }

    @JsonProperty("allowStale")
    public void setAllowStale(Boolean allowStale) {
        this.allowStale = allowStale;
    }

    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    @JsonProperty("nodeMeta")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeMeta() {
        return nodeMeta;
    }

    @JsonProperty("nodeMeta")
    public void setNodeMeta(Map<String, String> nodeMeta) {
        this.nodeMeta = nodeMeta;
    }

    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("partition")
    public String getPartition() {
        return partition;
    }

    @JsonProperty("partition")
    public void setPartition(String partition) {
        this.partition = partition;
    }

    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<SecretKeySelector>> getProxyConnectHeader() {
        return proxyConnectHeader;
    }

    @JsonProperty("proxyConnectHeader")
    public void setProxyConnectHeader(Map<String, List<SecretKeySelector>> proxyConnectHeader) {
        this.proxyConnectHeader = proxyConnectHeader;
    }

    @JsonProperty("proxyFromEnvironment")
    public Boolean getProxyFromEnvironment() {
        return proxyFromEnvironment;
    }

    @JsonProperty("proxyFromEnvironment")
    public void setProxyFromEnvironment(Boolean proxyFromEnvironment) {
        this.proxyFromEnvironment = proxyFromEnvironment;
    }

    @JsonProperty("proxyUrl")
    public String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxyUrl")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("refreshInterval")
    public String getRefreshInterval() {
        return refreshInterval;
    }

    @JsonProperty("refreshInterval")
    public void setRefreshInterval(String refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    @JsonProperty("services")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(List<String> services) {
        this.services = services;
    }

    @JsonProperty("tagSeparator")
    public String getTagSeparator() {
        return tagSeparator;
    }

    @JsonProperty("tagSeparator")
    public void setTagSeparator(String tagSeparator) {
        this.tagSeparator = tagSeparator;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("tokenRef")
    public SecretKeySelector getTokenRef() {
        return tokenRef;
    }

    @JsonProperty("tokenRef")
    public void setTokenRef(SecretKeySelector tokenRef) {
        this.tokenRef = tokenRef;
    }

    @JsonIgnore
    public ConsulSDConfigBuilder edit() {
        return new ConsulSDConfigBuilder(this);
    }

    @JsonIgnore
    public ConsulSDConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
