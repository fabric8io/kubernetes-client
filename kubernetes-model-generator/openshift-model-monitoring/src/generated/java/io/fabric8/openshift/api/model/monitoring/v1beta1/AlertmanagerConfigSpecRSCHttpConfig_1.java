
package io.fabric8.openshift.api.model.monitoring.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
    "followRedirects",
    "oauth2",
    "proxyURL",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerConfigSpecRSCHttpConfig_1 implements Editable<AlertmanagerConfigSpecRSCHttpConfig_1Builder> , KubernetesResource
{

    @JsonProperty("authorization")
    private AlertmanagerConfigSpecRSCHCAuthorization_1 authorization;
    @JsonProperty("basicAuth")
    private AlertmanagerConfigSpecRSCHCBasicAuth_1 basicAuth;
    @JsonProperty("bearerTokenSecret")
    private AlertmanagerConfigSpecRSCHCBearerTokenSecret_1 bearerTokenSecret;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("oauth2")
    private AlertmanagerConfigSpecRSCHCOauth2_1 oauth2;
    @JsonProperty("proxyURL")
    private String proxyURL;
    @JsonProperty("tlsConfig")
    private AlertmanagerConfigSpecRSCHCTlsConfig_1 tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecRSCHttpConfig_1() {
    }

    public AlertmanagerConfigSpecRSCHttpConfig_1(AlertmanagerConfigSpecRSCHCAuthorization_1 authorization, AlertmanagerConfigSpecRSCHCBasicAuth_1 basicAuth, AlertmanagerConfigSpecRSCHCBearerTokenSecret_1 bearerTokenSecret, Boolean followRedirects, AlertmanagerConfigSpecRSCHCOauth2_1 oauth2, String proxyURL, AlertmanagerConfigSpecRSCHCTlsConfig_1 tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
        this.followRedirects = followRedirects;
        this.oauth2 = oauth2;
        this.proxyURL = proxyURL;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("authorization")
    public AlertmanagerConfigSpecRSCHCAuthorization_1 getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(AlertmanagerConfigSpecRSCHCAuthorization_1 authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("basicAuth")
    public AlertmanagerConfigSpecRSCHCBasicAuth_1 getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(AlertmanagerConfigSpecRSCHCBasicAuth_1 basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerTokenSecret")
    public AlertmanagerConfigSpecRSCHCBearerTokenSecret_1 getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(AlertmanagerConfigSpecRSCHCBearerTokenSecret_1 bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
    }

    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    @JsonProperty("oauth2")
    public AlertmanagerConfigSpecRSCHCOauth2_1 getOauth2() {
        return oauth2;
    }

    @JsonProperty("oauth2")
    public void setOauth2(AlertmanagerConfigSpecRSCHCOauth2_1 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonProperty("proxyURL")
    public String getProxyURL() {
        return proxyURL;
    }

    @JsonProperty("proxyURL")
    public void setProxyURL(String proxyURL) {
        this.proxyURL = proxyURL;
    }

    @JsonProperty("tlsConfig")
    public AlertmanagerConfigSpecRSCHCTlsConfig_1 getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(AlertmanagerConfigSpecRSCHCTlsConfig_1 tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRSCHttpConfig_1Builder edit() {
        return new AlertmanagerConfigSpecRSCHttpConfig_1Builder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRSCHttpConfig_1Builder toBuilder() {
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
