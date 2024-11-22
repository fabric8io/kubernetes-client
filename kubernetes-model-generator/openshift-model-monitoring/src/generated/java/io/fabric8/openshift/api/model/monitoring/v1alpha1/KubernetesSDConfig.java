
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
    "apiServer",
    "attachMetadata",
    "authorization",
    "basicAuth",
    "enableHTTP2",
    "followRedirects",
    "namespaces",
    "noProxy",
    "oauth2",
    "proxyConnectHeader",
    "proxyFromEnvironment",
    "proxyUrl",
    "role",
    "selectors",
    "tlsConfig"
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
public class KubernetesSDConfig implements Editable<KubernetesSDConfigBuilder> , KubernetesResource
{

    @JsonProperty("apiServer")
    private String apiServer;
    @JsonProperty("attachMetadata")
    private AttachMetadata attachMetadata;
    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("enableHTTP2")
    private Boolean enableHTTP2;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("namespaces")
    private NamespaceDiscovery namespaces;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonProperty("proxyConnectHeader")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<SecretKeySelector>> proxyConnectHeader = new LinkedHashMap<>();
    @JsonProperty("proxyFromEnvironment")
    private Boolean proxyFromEnvironment;
    @JsonProperty("proxyUrl")
    private String proxyUrl;
    @JsonProperty("role")
    private String role;
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<K8SSelectorConfig> selectors = new ArrayList<>();
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubernetesSDConfig() {
    }

    public KubernetesSDConfig(String apiServer, AttachMetadata attachMetadata, SafeAuthorization authorization, BasicAuth basicAuth, Boolean enableHTTP2, Boolean followRedirects, NamespaceDiscovery namespaces, String noProxy, OAuth2 oauth2, Map<String, List<SecretKeySelector>> proxyConnectHeader, Boolean proxyFromEnvironment, String proxyUrl, String role, List<K8SSelectorConfig> selectors, SafeTLSConfig tlsConfig) {
        super();
        this.apiServer = apiServer;
        this.attachMetadata = attachMetadata;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.enableHTTP2 = enableHTTP2;
        this.followRedirects = followRedirects;
        this.namespaces = namespaces;
        this.noProxy = noProxy;
        this.oauth2 = oauth2;
        this.proxyConnectHeader = proxyConnectHeader;
        this.proxyFromEnvironment = proxyFromEnvironment;
        this.proxyUrl = proxyUrl;
        this.role = role;
        this.selectors = selectors;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("apiServer")
    public String getApiServer() {
        return apiServer;
    }

    @JsonProperty("apiServer")
    public void setApiServer(String apiServer) {
        this.apiServer = apiServer;
    }

    @JsonProperty("attachMetadata")
    public AttachMetadata getAttachMetadata() {
        return attachMetadata;
    }

    @JsonProperty("attachMetadata")
    public void setAttachMetadata(AttachMetadata attachMetadata) {
        this.attachMetadata = attachMetadata;
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

    @JsonProperty("enableHTTP2")
    public Boolean getEnableHTTP2() {
        return enableHTTP2;
    }

    @JsonProperty("enableHTTP2")
    public void setEnableHTTP2(Boolean enableHTTP2) {
        this.enableHTTP2 = enableHTTP2;
    }

    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    @JsonProperty("namespaces")
    public NamespaceDiscovery getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(NamespaceDiscovery namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
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

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<K8SSelectorConfig> getSelectors() {
        return selectors;
    }

    @JsonProperty("selectors")
    public void setSelectors(List<K8SSelectorConfig> selectors) {
        this.selectors = selectors;
    }

    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public KubernetesSDConfigBuilder edit() {
        return new KubernetesSDConfigBuilder(this);
    }

    @JsonIgnore
    public KubernetesSDConfigBuilder toBuilder() {
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
