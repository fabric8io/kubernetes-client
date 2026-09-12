
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerTokenSecret",
    "enableHttp2",
    "followRedirects",
    "oauth2"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HTTPConfigWithoutTLS implements Editable<HTTPConfigWithoutTLSBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenSecret")
    private SecretKeySelector bearerTokenSecret;
    @JsonProperty("enableHttp2")
    private Boolean enableHttp2;
    @JsonProperty("followRedirects")
    private Boolean followRedirects;
    @JsonProperty("oauth2")
    private OAuth2 oauth2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPConfigWithoutTLS() {
    }

    public HTTPConfigWithoutTLS(SafeAuthorization authorization, BasicAuth basicAuth, SecretKeySelector bearerTokenSecret, Boolean enableHttp2, Boolean followRedirects, OAuth2 oauth2) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenSecret = bearerTokenSecret;
        this.enableHttp2 = enableHttp2;
        this.followRedirects = followRedirects;
        this.oauth2 = oauth2;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("bearerTokenSecret")
    public SecretKeySelector getBearerTokenSecret() {
        return bearerTokenSecret;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("bearerTokenSecret")
    public void setBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
        this.bearerTokenSecret = bearerTokenSecret;
    }

    /**
     * enableHttp2 can be used to disable HTTP2.
     */
    @JsonProperty("enableHttp2")
    public Boolean getEnableHttp2() {
        return enableHttp2;
    }

    /**
     * enableHttp2 can be used to disable HTTP2.
     */
    @JsonProperty("enableHttp2")
    public void setEnableHttp2(Boolean enableHttp2) {
        this.enableHttp2 = enableHttp2;
    }

    /**
     * followRedirects defines whether the client should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public Boolean getFollowRedirects() {
        return followRedirects;
    }

    /**
     * followRedirects defines whether the client should follow HTTP 3xx redirects.
     */
    @JsonProperty("followRedirects")
    public void setFollowRedirects(Boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("oauth2")
    public OAuth2 getOauth2() {
        return oauth2;
    }

    /**
     * HTTPConfigWithoutTLS defines the configuration for the HTTP client.
     */
    @JsonProperty("oauth2")
    public void setOauth2(OAuth2 oauth2) {
        this.oauth2 = oauth2;
    }

    @JsonIgnore
    public HTTPConfigWithoutTLSBuilder edit() {
        return new HTTPConfigWithoutTLSBuilder(this);
    }

    @JsonIgnore
    public HTTPConfigWithoutTLSBuilder toBuilder() {
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
        if (!(o instanceof HTTPConfigWithoutTLS)) {
            return false;
        }
        HTTPConfigWithoutTLS other = (HTTPConfigWithoutTLS) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authorization = this.getAuthorization();
        Object other$authorization = other.getAuthorization();
        if (this$authorization == null ? other$authorization != null : !this$authorization.equals(other$authorization)) {
            return false;
        }
        Object this$basicAuth = this.getBasicAuth();
        Object other$basicAuth = other.getBasicAuth();
        if (this$basicAuth == null ? other$basicAuth != null : !this$basicAuth.equals(other$basicAuth)) {
            return false;
        }
        Object this$bearerTokenSecret = this.getBearerTokenSecret();
        Object other$bearerTokenSecret = other.getBearerTokenSecret();
        if (this$bearerTokenSecret == null ? other$bearerTokenSecret != null : !this$bearerTokenSecret.equals(other$bearerTokenSecret)) {
            return false;
        }
        Object this$enableHttp2 = this.getEnableHttp2();
        Object other$enableHttp2 = other.getEnableHttp2();
        if (this$enableHttp2 == null ? other$enableHttp2 != null : !this$enableHttp2.equals(other$enableHttp2)) {
            return false;
        }
        Object this$followRedirects = this.getFollowRedirects();
        Object other$followRedirects = other.getFollowRedirects();
        if (this$followRedirects == null ? other$followRedirects != null : !this$followRedirects.equals(other$followRedirects)) {
            return false;
        }
        Object this$oauth2 = this.getOauth2();
        Object other$oauth2 = other.getOauth2();
        if (this$oauth2 == null ? other$oauth2 != null : !this$oauth2.equals(other$oauth2)) {
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
        return other instanceof HTTPConfigWithoutTLS;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $basicAuth = this.getBasicAuth();
        result = result * prime + ($basicAuth == null ? 43 : $basicAuth.hashCode());
        Object $bearerTokenSecret = this.getBearerTokenSecret();
        result = result * prime + ($bearerTokenSecret == null ? 43 : $bearerTokenSecret.hashCode());
        Object $enableHttp2 = this.getEnableHttp2();
        result = result * prime + ($enableHttp2 == null ? 43 : $enableHttp2.hashCode());
        Object $followRedirects = this.getFollowRedirects();
        result = result * prime + ($followRedirects == null ? 43 : $followRedirects.hashCode());
        Object $oauth2 = this.getOauth2();
        result = result * prime + ($oauth2 == null ? 43 : $oauth2.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPConfigWithoutTLS(" + "authorization=" + this.getAuthorization() + ", basicAuth=" + this.getBasicAuth() + ", bearerTokenSecret=" + this.getBearerTokenSecret() + ", enableHttp2=" + this.getEnableHttp2() + ", followRedirects=" + this.getFollowRedirects() + ", oauth2=" + this.getOauth2() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
