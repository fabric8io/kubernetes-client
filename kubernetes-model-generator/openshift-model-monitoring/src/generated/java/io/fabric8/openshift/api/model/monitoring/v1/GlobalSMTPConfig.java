
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
 * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authIdentity",
    "authPassword",
    "authSecret",
    "authUsername",
    "forceImplicitTLS",
    "from",
    "hello",
    "requireTLS",
    "smartHost",
    "tlsConfig"
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
public class GlobalSMTPConfig implements Editable<GlobalSMTPConfigBuilder>, KubernetesResource
{

    @JsonProperty("authIdentity")
    private String authIdentity;
    @JsonProperty("authPassword")
    private SecretKeySelector authPassword;
    @JsonProperty("authSecret")
    private SecretKeySelector authSecret;
    @JsonProperty("authUsername")
    private String authUsername;
    @JsonProperty("forceImplicitTLS")
    private Boolean forceImplicitTLS;
    @JsonProperty("from")
    private String from;
    @JsonProperty("hello")
    private String hello;
    @JsonProperty("requireTLS")
    private Boolean requireTLS;
    @JsonProperty("smartHost")
    private HostPort smartHost;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GlobalSMTPConfig() {
    }

    public GlobalSMTPConfig(String authIdentity, SecretKeySelector authPassword, SecretKeySelector authSecret, String authUsername, Boolean forceImplicitTLS, String from, String hello, Boolean requireTLS, HostPort smartHost, SafeTLSConfig tlsConfig) {
        super();
        this.authIdentity = authIdentity;
        this.authPassword = authPassword;
        this.authSecret = authSecret;
        this.authUsername = authUsername;
        this.forceImplicitTLS = forceImplicitTLS;
        this.from = from;
        this.hello = hello;
        this.requireTLS = requireTLS;
        this.smartHost = smartHost;
        this.tlsConfig = tlsConfig;
    }

    /**
     * authIdentity represents SMTP Auth using PLAIN
     */
    @JsonProperty("authIdentity")
    public String getAuthIdentity() {
        return authIdentity;
    }

    /**
     * authIdentity represents SMTP Auth using PLAIN
     */
    @JsonProperty("authIdentity")
    public void setAuthIdentity(String authIdentity) {
        this.authIdentity = authIdentity;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("authPassword")
    public SecretKeySelector getAuthPassword() {
        return authPassword;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("authPassword")
    public void setAuthPassword(SecretKeySelector authPassword) {
        this.authPassword = authPassword;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("authSecret")
    public SecretKeySelector getAuthSecret() {
        return authSecret;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("authSecret")
    public void setAuthSecret(SecretKeySelector authSecret) {
        this.authSecret = authSecret;
    }

    /**
     * authUsername represents SMTP Auth using CRAM-MD5, LOGIN and PLAIN. If empty, Alertmanager doesn't authenticate to the SMTP server.
     */
    @JsonProperty("authUsername")
    public String getAuthUsername() {
        return authUsername;
    }

    /**
     * authUsername represents SMTP Auth using CRAM-MD5, LOGIN and PLAIN. If empty, Alertmanager doesn't authenticate to the SMTP server.
     */
    @JsonProperty("authUsername")
    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    /**
     * forceImplicitTLS defines whether to force use of implicit TLS (direct TLS connection) for better security. true: force use of implicit TLS (direct TLS connection on any port) false: force disable implicit TLS (use explicit TLS/STARTTLS if required) nil (default): auto-detect based on port (465=implicit, other=explicit) for backward compatibility It requires Alertmanager &gt;= v0.31.0.
     */
    @JsonProperty("forceImplicitTLS")
    public Boolean getForceImplicitTLS() {
        return forceImplicitTLS;
    }

    /**
     * forceImplicitTLS defines whether to force use of implicit TLS (direct TLS connection) for better security. true: force use of implicit TLS (direct TLS connection on any port) false: force disable implicit TLS (use explicit TLS/STARTTLS if required) nil (default): auto-detect based on port (465=implicit, other=explicit) for backward compatibility It requires Alertmanager &gt;= v0.31.0.
     */
    @JsonProperty("forceImplicitTLS")
    public void setForceImplicitTLS(Boolean forceImplicitTLS) {
        this.forceImplicitTLS = forceImplicitTLS;
    }

    /**
     * from defines the default SMTP From header field.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * from defines the default SMTP From header field.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * hello defines the default hostname to identify to the SMTP server.
     */
    @JsonProperty("hello")
    public String getHello() {
        return hello;
    }

    /**
     * hello defines the default hostname to identify to the SMTP server.
     */
    @JsonProperty("hello")
    public void setHello(String hello) {
        this.hello = hello;
    }

    /**
     * requireTLS defines the default SMTP TLS requirement. Note that Go does not support unencrypted connections to remote SMTP endpoints.
     */
    @JsonProperty("requireTLS")
    public Boolean getRequireTLS() {
        return requireTLS;
    }

    /**
     * requireTLS defines the default SMTP TLS requirement. Note that Go does not support unencrypted connections to remote SMTP endpoints.
     */
    @JsonProperty("requireTLS")
    public void setRequireTLS(Boolean requireTLS) {
        this.requireTLS = requireTLS;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("smartHost")
    public HostPort getSmartHost() {
        return smartHost;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("smartHost")
    public void setSmartHost(HostPort smartHost) {
        this.smartHost = smartHost;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * GlobalSMTPConfig configures global SMTP parameters. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public GlobalSMTPConfigBuilder edit() {
        return new GlobalSMTPConfigBuilder(this);
    }

    @JsonIgnore
    public GlobalSMTPConfigBuilder toBuilder() {
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
        if (!(o instanceof GlobalSMTPConfig)) {
            return false;
        }
        GlobalSMTPConfig other = (GlobalSMTPConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authIdentity = this.getAuthIdentity();
        Object other$authIdentity = other.getAuthIdentity();
        if (this$authIdentity == null ? other$authIdentity != null : !this$authIdentity.equals(other$authIdentity)) {
            return false;
        }
        Object this$authPassword = this.getAuthPassword();
        Object other$authPassword = other.getAuthPassword();
        if (this$authPassword == null ? other$authPassword != null : !this$authPassword.equals(other$authPassword)) {
            return false;
        }
        Object this$authSecret = this.getAuthSecret();
        Object other$authSecret = other.getAuthSecret();
        if (this$authSecret == null ? other$authSecret != null : !this$authSecret.equals(other$authSecret)) {
            return false;
        }
        Object this$authUsername = this.getAuthUsername();
        Object other$authUsername = other.getAuthUsername();
        if (this$authUsername == null ? other$authUsername != null : !this$authUsername.equals(other$authUsername)) {
            return false;
        }
        Object this$forceImplicitTLS = this.getForceImplicitTLS();
        Object other$forceImplicitTLS = other.getForceImplicitTLS();
        if (this$forceImplicitTLS == null ? other$forceImplicitTLS != null : !this$forceImplicitTLS.equals(other$forceImplicitTLS)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$hello = this.getHello();
        Object other$hello = other.getHello();
        if (this$hello == null ? other$hello != null : !this$hello.equals(other$hello)) {
            return false;
        }
        Object this$requireTLS = this.getRequireTLS();
        Object other$requireTLS = other.getRequireTLS();
        if (this$requireTLS == null ? other$requireTLS != null : !this$requireTLS.equals(other$requireTLS)) {
            return false;
        }
        Object this$smartHost = this.getSmartHost();
        Object other$smartHost = other.getSmartHost();
        if (this$smartHost == null ? other$smartHost != null : !this$smartHost.equals(other$smartHost)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
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
        return other instanceof GlobalSMTPConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authIdentity = this.getAuthIdentity();
        result = result * prime + ($authIdentity == null ? 43 : $authIdentity.hashCode());
        Object $authPassword = this.getAuthPassword();
        result = result * prime + ($authPassword == null ? 43 : $authPassword.hashCode());
        Object $authSecret = this.getAuthSecret();
        result = result * prime + ($authSecret == null ? 43 : $authSecret.hashCode());
        Object $authUsername = this.getAuthUsername();
        result = result * prime + ($authUsername == null ? 43 : $authUsername.hashCode());
        Object $forceImplicitTLS = this.getForceImplicitTLS();
        result = result * prime + ($forceImplicitTLS == null ? 43 : $forceImplicitTLS.hashCode());
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $hello = this.getHello();
        result = result * prime + ($hello == null ? 43 : $hello.hashCode());
        Object $requireTLS = this.getRequireTLS();
        result = result * prime + ($requireTLS == null ? 43 : $requireTLS.hashCode());
        Object $smartHost = this.getSmartHost();
        result = result * prime + ($smartHost == null ? 43 : $smartHost.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GlobalSMTPConfig(" + "authIdentity=" + this.getAuthIdentity() + ", authPassword=" + this.getAuthPassword() + ", authSecret=" + this.getAuthSecret() + ", authUsername=" + this.getAuthUsername() + ", forceImplicitTLS=" + this.getForceImplicitTLS() + ", from=" + this.getFrom() + ", hello=" + this.getHello() + ", requireTLS=" + this.getRequireTLS() + ", smartHost=" + this.getSmartHost() + ", tlsConfig=" + this.getTlsConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
