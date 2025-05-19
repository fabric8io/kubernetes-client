
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "from",
    "hello",
    "requireTLS",
    "smartHost"
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
    @JsonProperty("from")
    private String from;
    @JsonProperty("hello")
    private String hello;
    @JsonProperty("requireTLS")
    private Boolean requireTLS;
    @JsonProperty("smartHost")
    private HostPort smartHost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GlobalSMTPConfig() {
    }

    public GlobalSMTPConfig(String authIdentity, SecretKeySelector authPassword, SecretKeySelector authSecret, String authUsername, String from, String hello, Boolean requireTLS, HostPort smartHost) {
        super();
        this.authIdentity = authIdentity;
        this.authPassword = authPassword;
        this.authSecret = authSecret;
        this.authUsername = authUsername;
        this.from = from;
        this.hello = hello;
        this.requireTLS = requireTLS;
        this.smartHost = smartHost;
    }

    /**
     * SMTP Auth using PLAIN
     */
    @JsonProperty("authIdentity")
    public String getAuthIdentity() {
        return authIdentity;
    }

    /**
     * SMTP Auth using PLAIN
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
     * SMTP Auth using CRAM-MD5, LOGIN and PLAIN. If empty, Alertmanager doesn't authenticate to the SMTP server.
     */
    @JsonProperty("authUsername")
    public String getAuthUsername() {
        return authUsername;
    }

    /**
     * SMTP Auth using CRAM-MD5, LOGIN and PLAIN. If empty, Alertmanager doesn't authenticate to the SMTP server.
     */
    @JsonProperty("authUsername")
    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    /**
     * The default SMTP From header field.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * The default SMTP From header field.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * The default hostname to identify to the SMTP server.
     */
    @JsonProperty("hello")
    public String getHello() {
        return hello;
    }

    /**
     * The default hostname to identify to the SMTP server.
     */
    @JsonProperty("hello")
    public void setHello(String hello) {
        this.hello = hello;
    }

    /**
     * The default SMTP TLS requirement. Note that Go does not support unencrypted connections to remote SMTP endpoints.
     */
    @JsonProperty("requireTLS")
    public Boolean getRequireTLS() {
        return requireTLS;
    }

    /**
     * The default SMTP TLS requirement. Note that Go does not support unencrypted connections to remote SMTP endpoints.
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

}
