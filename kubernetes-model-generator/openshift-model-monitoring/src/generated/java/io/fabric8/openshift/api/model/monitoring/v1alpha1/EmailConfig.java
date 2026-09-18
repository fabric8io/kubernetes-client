
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * EmailConfig configures notifications via Email.
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
    "headers",
    "hello",
    "html",
    "requireTLS",
    "sendResolved",
    "smarthost",
    "text",
    "threading",
    "tlsConfig",
    "to"
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
public class EmailConfig implements Editable<EmailConfigBuilder>, KubernetesResource
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
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KeyValue> headers = new ArrayList<>();
    @JsonProperty("hello")
    private String hello;
    @JsonProperty("html")
    private String html;
    @JsonProperty("requireTLS")
    private Boolean requireTLS;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("smarthost")
    private String smarthost;
    @JsonProperty("text")
    private String text;
    @JsonProperty("threading")
    private EmailThreadingConfig threading;
    @JsonProperty("tlsConfig")
    private SafeTLSConfig tlsConfig;
    @JsonProperty("to")
    private String to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EmailConfig() {
    }

    public EmailConfig(String authIdentity, SecretKeySelector authPassword, SecretKeySelector authSecret, String authUsername, Boolean forceImplicitTLS, String from, List<KeyValue> headers, String hello, String html, Boolean requireTLS, Boolean sendResolved, String smarthost, String text, EmailThreadingConfig threading, SafeTLSConfig tlsConfig, String to) {
        super();
        this.authIdentity = authIdentity;
        this.authPassword = authPassword;
        this.authSecret = authSecret;
        this.authUsername = authUsername;
        this.forceImplicitTLS = forceImplicitTLS;
        this.from = from;
        this.headers = headers;
        this.hello = hello;
        this.html = html;
        this.requireTLS = requireTLS;
        this.sendResolved = sendResolved;
        this.smarthost = smarthost;
        this.text = text;
        this.threading = threading;
        this.tlsConfig = tlsConfig;
        this.to = to;
    }

    /**
     * authIdentity defines the identity to use for SMTP authentication. This is typically used with PLAIN authentication mechanism.
     */
    @JsonProperty("authIdentity")
    public String getAuthIdentity() {
        return authIdentity;
    }

    /**
     * authIdentity defines the identity to use for SMTP authentication. This is typically used with PLAIN authentication mechanism.
     */
    @JsonProperty("authIdentity")
    public void setAuthIdentity(String authIdentity) {
        this.authIdentity = authIdentity;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("authPassword")
    public SecretKeySelector getAuthPassword() {
        return authPassword;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("authPassword")
    public void setAuthPassword(SecretKeySelector authPassword) {
        this.authPassword = authPassword;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("authSecret")
    public SecretKeySelector getAuthSecret() {
        return authSecret;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("authSecret")
    public void setAuthSecret(SecretKeySelector authSecret) {
        this.authSecret = authSecret;
    }

    /**
     * authUsername defines the username to use for SMTP authentication. This is used for SMTP AUTH when the server requires authentication.
     */
    @JsonProperty("authUsername")
    public String getAuthUsername() {
        return authUsername;
    }

    /**
     * authUsername defines the username to use for SMTP authentication. This is used for SMTP AUTH when the server requires authentication.
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
     * from defines the sender address for email notifications. This appears as the "From" field in the email header.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * from defines the sender address for email notifications. This appears as the "From" field in the email header.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * headers defines additional email header key/value pairs. These override any headers previously set by the notification implementation.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KeyValue> getHeaders() {
        return headers;
    }

    /**
     * headers defines additional email header key/value pairs. These override any headers previously set by the notification implementation.
     */
    @JsonProperty("headers")
    public void setHeaders(List<KeyValue> headers) {
        this.headers = headers;
    }

    /**
     * hello defines the hostname to identify to the SMTP server. This is used in the SMTP HELO/EHLO command during the connection handshake.
     */
    @JsonProperty("hello")
    public String getHello() {
        return hello;
    }

    /**
     * hello defines the hostname to identify to the SMTP server. This is used in the SMTP HELO/EHLO command during the connection handshake.
     */
    @JsonProperty("hello")
    public void setHello(String hello) {
        this.hello = hello;
    }

    /**
     * html defines the HTML body of the email notification. This allows for rich formatting in the email content.
     */
    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    /**
     * html defines the HTML body of the email notification. This allows for rich formatting in the email content.
     */
    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * requireTLS defines the SMTP TLS requirement. Note that Go does not support unencrypted connections to remote SMTP endpoints.
     */
    @JsonProperty("requireTLS")
    public Boolean getRequireTLS() {
        return requireTLS;
    }

    /**
     * requireTLS defines the SMTP TLS requirement. Note that Go does not support unencrypted connections to remote SMTP endpoints.
     */
    @JsonProperty("requireTLS")
    public void setRequireTLS(Boolean requireTLS) {
        this.requireTLS = requireTLS;
    }

    /**
     * sendResolved defines whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * sendResolved defines whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    /**
     * smarthost defines the SMTP host and port through which emails are sent. Format should be "hostname:port", e.g. "smtp.example.com:587".
     */
    @JsonProperty("smarthost")
    public String getSmarthost() {
        return smarthost;
    }

    /**
     * smarthost defines the SMTP host and port through which emails are sent. Format should be "hostname:port", e.g. "smtp.example.com:587".
     */
    @JsonProperty("smarthost")
    public void setSmarthost(String smarthost) {
        this.smarthost = smarthost;
    }

    /**
     * text defines the plain text body of the email notification. This provides a fallback for email clients that don't support HTML.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the plain text body of the email notification. This provides a fallback for email clients that don't support HTML.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("threading")
    public EmailThreadingConfig getThreading() {
        return threading;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("threading")
    public void setThreading(EmailThreadingConfig threading) {
        this.threading = threading;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("tlsConfig")
    public SafeTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * EmailConfig configures notifications via Email.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(SafeTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    /**
     * to defines the email address to send notifications to. This is the recipient address for alert notifications.
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * to defines the email address to send notifications to. This is the recipient address for alert notifications.
     */
    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonIgnore
    public EmailConfigBuilder edit() {
        return new EmailConfigBuilder(this);
    }

    @JsonIgnore
    public EmailConfigBuilder toBuilder() {
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
        if (!(o instanceof EmailConfig)) {
            return false;
        }
        EmailConfig other = (EmailConfig) o;
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
        Object this$headers = this.getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null ? other$headers != null : !this$headers.equals(other$headers)) {
            return false;
        }
        Object this$hello = this.getHello();
        Object other$hello = other.getHello();
        if (this$hello == null ? other$hello != null : !this$hello.equals(other$hello)) {
            return false;
        }
        Object this$html = this.getHtml();
        Object other$html = other.getHtml();
        if (this$html == null ? other$html != null : !this$html.equals(other$html)) {
            return false;
        }
        Object this$requireTLS = this.getRequireTLS();
        Object other$requireTLS = other.getRequireTLS();
        if (this$requireTLS == null ? other$requireTLS != null : !this$requireTLS.equals(other$requireTLS)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$smarthost = this.getSmarthost();
        Object other$smarthost = other.getSmarthost();
        if (this$smarthost == null ? other$smarthost != null : !this$smarthost.equals(other$smarthost)) {
            return false;
        }
        Object this$text = this.getText();
        Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) {
            return false;
        }
        Object this$threading = this.getThreading();
        Object other$threading = other.getThreading();
        if (this$threading == null ? other$threading != null : !this$threading.equals(other$threading)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
            return false;
        }
        Object this$to = this.getTo();
        Object other$to = other.getTo();
        if (this$to == null ? other$to != null : !this$to.equals(other$to)) {
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
        return other instanceof EmailConfig;
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
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $hello = this.getHello();
        result = result * prime + ($hello == null ? 43 : $hello.hashCode());
        Object $html = this.getHtml();
        result = result * prime + ($html == null ? 43 : $html.hashCode());
        Object $requireTLS = this.getRequireTLS();
        result = result * prime + ($requireTLS == null ? 43 : $requireTLS.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $smarthost = this.getSmarthost();
        result = result * prime + ($smarthost == null ? 43 : $smarthost.hashCode());
        Object $text = this.getText();
        result = result * prime + ($text == null ? 43 : $text.hashCode());
        Object $threading = this.getThreading();
        result = result * prime + ($threading == null ? 43 : $threading.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $to = this.getTo();
        result = result * prime + ($to == null ? 43 : $to.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EmailConfig(" + "authIdentity=" + this.getAuthIdentity() + ", authPassword=" + this.getAuthPassword() + ", authSecret=" + this.getAuthSecret() + ", authUsername=" + this.getAuthUsername() + ", forceImplicitTLS=" + this.getForceImplicitTLS() + ", from=" + this.getFrom() + ", headers=" + this.getHeaders() + ", hello=" + this.getHello() + ", html=" + this.getHtml() + ", requireTLS=" + this.getRequireTLS() + ", sendResolved=" + this.getSendResolved() + ", smarthost=" + this.getSmarthost() + ", text=" + this.getText() + ", threading=" + this.getThreading() + ", tlsConfig=" + this.getTlsConfig() + ", to=" + this.getTo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
