
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

    public PushoverConfig(String device, String expire, Boolean html, HTTPConfig httpConfig, String message, String priority, String retry, Boolean sendResolved, String sound, String title, SecretKeySelector token, String tokenFile, String ttl, String url, String urlTitle, SecretKeySelector userKey, String userKeyFile) {
        super();
        this.device = device;
        this.expire = expire;
        this.html = html;
        this.httpConfig = httpConfig;
        this.message = message;
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
     * The name of a device to send the notification to
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * The name of a device to send the notification to
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * How long your notification will continue to be retried for, unless the user acknowledges the notification.
     */
    @JsonProperty("expire")
    public String getExpire() {
        return expire;
    }

    /**
     * How long your notification will continue to be retried for, unless the user acknowledges the notification.
     */
    @JsonProperty("expire")
    public void setExpire(String expire) {
        this.expire = expire;
    }

    /**
     * Whether notification message is HTML or plain text.
     */
    @JsonProperty("html")
    public Boolean getHtml() {
        return html;
    }

    /**
     * Whether notification message is HTML or plain text.
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
     * Notification message.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Notification message.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Priority, see https://pushover.net/api#priority
     */
    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    /**
     * Priority, see https://pushover.net/api#priority
     */
    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * How often the Pushover servers will send the same notification to the user. Must be at least 30 seconds.
     */
    @JsonProperty("retry")
    public String getRetry() {
        return retry;
    }

    /**
     * How often the Pushover servers will send the same notification to the user. Must be at least 30 seconds.
     */
    @JsonProperty("retry")
    public void setRetry(String retry) {
        this.retry = retry;
    }

    /**
     * Whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * Whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    /**
     * The name of one of the sounds supported by device clients to override the user's default sound choice
     */
    @JsonProperty("sound")
    public String getSound() {
        return sound;
    }

    /**
     * The name of one of the sounds supported by device clients to override the user's default sound choice
     */
    @JsonProperty("sound")
    public void setSound(String sound) {
        this.sound = sound;
    }

    /**
     * Notification title.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Notification title.
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
     * The token file that contains the registered application's API token, see https://pushover.net/apps. Either `token` or `tokenFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("tokenFile")
    public String getTokenFile() {
        return tokenFile;
    }

    /**
     * The token file that contains the registered application's API token, see https://pushover.net/apps. Either `token` or `tokenFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("tokenFile")
    public void setTokenFile(String tokenFile) {
        this.tokenFile = tokenFile;
    }

    /**
     * The time to live definition for the alert notification
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * The time to live definition for the alert notification
     */
    @JsonProperty("ttl")
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    /**
     * A supplementary URL shown alongside the message.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * A supplementary URL shown alongside the message.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * A title for supplementary URL, otherwise just the URL is shown
     */
    @JsonProperty("urlTitle")
    public String getUrlTitle() {
        return urlTitle;
    }

    /**
     * A title for supplementary URL, otherwise just the URL is shown
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
     * The user key file that contains the recipient user's user key. Either `userKey` or `userKeyFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("userKeyFile")
    public String getUserKeyFile() {
        return userKeyFile;
    }

    /**
     * The user key file that contains the recipient user's user key. Either `userKey` or `userKeyFile` is required. It requires Alertmanager &gt;= v0.26.0.
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

}
