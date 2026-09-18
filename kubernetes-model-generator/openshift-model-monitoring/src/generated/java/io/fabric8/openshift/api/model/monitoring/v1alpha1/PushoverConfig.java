
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "device",
    "expire",
    "html",
    "httpConfig",
    "message",
    "monospace",
    "priority",
    "retry",
    "sendResolved",
    "sound",
    "title",
    "token",
    "tokenFile",
    "ttl",
    "url",
    "urlTitle",
    "userKey",
    "userKeyFile"
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
public class PushoverConfig implements Editable<PushoverConfigBuilder>, KubernetesResource
{

    @JsonProperty("device")
    private String device;
    @JsonProperty("expire")
    private String expire;
    @JsonProperty("html")
    private Boolean html;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("monospace")
    private Boolean monospace;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("retry")
    private String retry;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("sound")
    private String sound;
    @JsonProperty("title")
    private String title;
    @JsonProperty("token")
    private SecretKeySelector token;
    @JsonProperty("tokenFile")
    private String tokenFile;
    @JsonProperty("ttl")
    private String ttl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("urlTitle")
    private String urlTitle;
    @JsonProperty("userKey")
    private SecretKeySelector userKey;
    @JsonProperty("userKeyFile")
    private String userKeyFile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PushoverConfig() {
    }

    public PushoverConfig(String device, String expire, Boolean html, HTTPConfig httpConfig, String message, Boolean monospace, String priority, String retry, Boolean sendResolved, String sound, String title, SecretKeySelector token, String tokenFile, String ttl, String url, String urlTitle, SecretKeySelector userKey, String userKeyFile) {
        super();
        this.device = device;
        this.expire = expire;
        this.html = html;
        this.httpConfig = httpConfig;
        this.message = message;
        this.monospace = monospace;
        this.priority = priority;
        this.retry = retry;
        this.sendResolved = sendResolved;
        this.sound = sound;
        this.title = title;
        this.token = token;
        this.tokenFile = tokenFile;
        this.ttl = ttl;
        this.url = url;
        this.urlTitle = urlTitle;
        this.userKey = userKey;
        this.userKeyFile = userKeyFile;
    }

    /**
     * device defines the name of a specific device to send the notification to. If not specified, the notification is sent to all user's devices.
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * device defines the name of a specific device to send the notification to. If not specified, the notification is sent to all user's devices.
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * expire defines how long your notification will continue to be retried for, unless the user acknowledges the notification. Only applies to priority 2 notifications.
     */
    @JsonProperty("expire")
    public String getExpire() {
        return expire;
    }

    /**
     * expire defines how long your notification will continue to be retried for, unless the user acknowledges the notification. Only applies to priority 2 notifications.
     */
    @JsonProperty("expire")
    public void setExpire(String expire) {
        this.expire = expire;
    }

    /**
     * html defines whether notification message is HTML or plain text. When true, the message can include HTML formatting tags. html and monospace formatting are mutually exclusive.
     */
    @JsonProperty("html")
    public Boolean getHtml() {
        return html;
    }

    /**
     * html defines whether notification message is HTML or plain text. When true, the message can include HTML formatting tags. html and monospace formatting are mutually exclusive.
     */
    @JsonProperty("html")
    public void setHtml(Boolean html) {
        this.html = html;
    }

    /**
     * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * message defines the notification message content. This is the main body text of the Pushover notification.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message defines the notification message content. This is the main body text of the Pushover notification.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * monospace optional HTML/monospace formatting for the message, see https://pushover.net/api#html html and monospace formatting are mutually exclusive.
     */
    @JsonProperty("monospace")
    public Boolean getMonospace() {
        return monospace;
    }

    /**
     * monospace optional HTML/monospace formatting for the message, see https://pushover.net/api#html html and monospace formatting are mutually exclusive.
     */
    @JsonProperty("monospace")
    public void setMonospace(Boolean monospace) {
        this.monospace = monospace;
    }

    /**
     * priority defines the notification priority level. See https://pushover.net/api#priority for valid values and behavior.
     */
    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    /**
     * priority defines the notification priority level. See https://pushover.net/api#priority for valid values and behavior.
     */
    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * retry defines how often the Pushover servers will send the same notification to the user. Must be at least 30 seconds. Only applies to priority 2 notifications.
     */
    @JsonProperty("retry")
    public String getRetry() {
        return retry;
    }

    /**
     * retry defines how often the Pushover servers will send the same notification to the user. Must be at least 30 seconds. Only applies to priority 2 notifications.
     */
    @JsonProperty("retry")
    public void setRetry(String retry) {
        this.retry = retry;
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
     * sound defines the name of one of the sounds supported by device clients. This overrides the user's default sound choice for this notification.
     */
    @JsonProperty("sound")
    public String getSound() {
        return sound;
    }

    /**
     * sound defines the name of one of the sounds supported by device clients. This overrides the user's default sound choice for this notification.
     */
    @JsonProperty("sound")
    public void setSound(String sound) {
        this.sound = sound;
    }

    /**
     * title defines the notification title displayed in the Pushover message. This appears as the bold header text in the notification.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the notification title displayed in the Pushover message. This appears as the bold header text in the notification.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
     */
    @JsonProperty("token")
    public SecretKeySelector getToken() {
        return token;
    }

    /**
     * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
     */
    @JsonProperty("token")
    public void setToken(SecretKeySelector token) {
        this.token = token;
    }

    /**
     * tokenFile defines the token file that contains the registered application's API token. See https://pushover.net/apps for application registration. Either `token` or `tokenFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("tokenFile")
    public String getTokenFile() {
        return tokenFile;
    }

    /**
     * tokenFile defines the token file that contains the registered application's API token. See https://pushover.net/apps for application registration. Either `token` or `tokenFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("tokenFile")
    public void setTokenFile(String tokenFile) {
        this.tokenFile = tokenFile;
    }

    /**
     * ttl defines the time to live for the alert notification. This determines how long the notification remains active before expiring.
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * ttl defines the time to live for the alert notification. This determines how long the notification remains active before expiring.
     */
    @JsonProperty("ttl")
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    /**
     * url defines a supplementary URL shown alongside the message. This creates a clickable link within the Pushover notification.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url defines a supplementary URL shown alongside the message. This creates a clickable link within the Pushover notification.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * urlTitle defines a title for the supplementary URL. If not specified, the raw URL is shown instead.
     */
    @JsonProperty("urlTitle")
    public String getUrlTitle() {
        return urlTitle;
    }

    /**
     * urlTitle defines a title for the supplementary URL. If not specified, the raw URL is shown instead.
     */
    @JsonProperty("urlTitle")
    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }

    /**
     * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
     */
    @JsonProperty("userKey")
    public SecretKeySelector getUserKey() {
        return userKey;
    }

    /**
     * PushoverConfig configures notifications via Pushover. See https://prometheus.io/docs/alerting/latest/configuration/#pushover_config
     */
    @JsonProperty("userKey")
    public void setUserKey(SecretKeySelector userKey) {
        this.userKey = userKey;
    }

    /**
     * userKeyFile defines the user key file that contains the recipient user's user key. Either `userKey` or `userKeyFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("userKeyFile")
    public String getUserKeyFile() {
        return userKeyFile;
    }

    /**
     * userKeyFile defines the user key file that contains the recipient user's user key. Either `userKey` or `userKeyFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("userKeyFile")
    public void setUserKeyFile(String userKeyFile) {
        this.userKeyFile = userKeyFile;
    }

    @JsonIgnore
    public PushoverConfigBuilder edit() {
        return new PushoverConfigBuilder(this);
    }

    @JsonIgnore
    public PushoverConfigBuilder toBuilder() {
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
        if (!(o instanceof PushoverConfig)) {
            return false;
        }
        PushoverConfig other = (PushoverConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$device = this.getDevice();
        Object other$device = other.getDevice();
        if (this$device == null ? other$device != null : !this$device.equals(other$device)) {
            return false;
        }
        Object this$expire = this.getExpire();
        Object other$expire = other.getExpire();
        if (this$expire == null ? other$expire != null : !this$expire.equals(other$expire)) {
            return false;
        }
        Object this$html = this.getHtml();
        Object other$html = other.getHtml();
        if (this$html == null ? other$html != null : !this$html.equals(other$html)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$monospace = this.getMonospace();
        Object other$monospace = other.getMonospace();
        if (this$monospace == null ? other$monospace != null : !this$monospace.equals(other$monospace)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        Object this$retry = this.getRetry();
        Object other$retry = other.getRetry();
        if (this$retry == null ? other$retry != null : !this$retry.equals(other$retry)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$sound = this.getSound();
        Object other$sound = other.getSound();
        if (this$sound == null ? other$sound != null : !this$sound.equals(other$sound)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        Object this$token = this.getToken();
        Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
            return false;
        }
        Object this$tokenFile = this.getTokenFile();
        Object other$tokenFile = other.getTokenFile();
        if (this$tokenFile == null ? other$tokenFile != null : !this$tokenFile.equals(other$tokenFile)) {
            return false;
        }
        Object this$ttl = this.getTtl();
        Object other$ttl = other.getTtl();
        if (this$ttl == null ? other$ttl != null : !this$ttl.equals(other$ttl)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$urlTitle = this.getUrlTitle();
        Object other$urlTitle = other.getUrlTitle();
        if (this$urlTitle == null ? other$urlTitle != null : !this$urlTitle.equals(other$urlTitle)) {
            return false;
        }
        Object this$userKey = this.getUserKey();
        Object other$userKey = other.getUserKey();
        if (this$userKey == null ? other$userKey != null : !this$userKey.equals(other$userKey)) {
            return false;
        }
        Object this$userKeyFile = this.getUserKeyFile();
        Object other$userKeyFile = other.getUserKeyFile();
        if (this$userKeyFile == null ? other$userKeyFile != null : !this$userKeyFile.equals(other$userKeyFile)) {
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
        return other instanceof PushoverConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $device = this.getDevice();
        result = result * prime + ($device == null ? 43 : $device.hashCode());
        Object $expire = this.getExpire();
        result = result * prime + ($expire == null ? 43 : $expire.hashCode());
        Object $html = this.getHtml();
        result = result * prime + ($html == null ? 43 : $html.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $monospace = this.getMonospace();
        result = result * prime + ($monospace == null ? 43 : $monospace.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $retry = this.getRetry();
        result = result * prime + ($retry == null ? 43 : $retry.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $sound = this.getSound();
        result = result * prime + ($sound == null ? 43 : $sound.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $token = this.getToken();
        result = result * prime + ($token == null ? 43 : $token.hashCode());
        Object $tokenFile = this.getTokenFile();
        result = result * prime + ($tokenFile == null ? 43 : $tokenFile.hashCode());
        Object $ttl = this.getTtl();
        result = result * prime + ($ttl == null ? 43 : $ttl.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $urlTitle = this.getUrlTitle();
        result = result * prime + ($urlTitle == null ? 43 : $urlTitle.hashCode());
        Object $userKey = this.getUserKey();
        result = result * prime + ($userKey == null ? 43 : $userKey.hashCode());
        Object $userKeyFile = this.getUserKeyFile();
        result = result * prime + ($userKeyFile == null ? 43 : $userKeyFile.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PushoverConfig(" + "device=" + this.getDevice() + ", expire=" + this.getExpire() + ", html=" + this.getHtml() + ", httpConfig=" + this.getHttpConfig() + ", message=" + this.getMessage() + ", monospace=" + this.getMonospace() + ", priority=" + this.getPriority() + ", retry=" + this.getRetry() + ", sendResolved=" + this.getSendResolved() + ", sound=" + this.getSound() + ", title=" + this.getTitle() + ", token=" + this.getToken() + ", tokenFile=" + this.getTokenFile() + ", ttl=" + this.getTtl() + ", url=" + this.getUrl() + ", urlTitle=" + this.getUrlTitle() + ", userKey=" + this.getUserKey() + ", userKeyFile=" + this.getUserKeyFile() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
