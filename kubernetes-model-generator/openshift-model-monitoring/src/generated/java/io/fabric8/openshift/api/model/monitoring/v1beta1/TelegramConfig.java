
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
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TelegramConfig configures notifications via Telegram. See https://prometheus.io/docs/alerting/latest/configuration/#telegram_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiURL",
    "botToken",
    "botTokenFile",
    "chatID",
    "disableNotifications",
    "httpConfig",
    "message",
    "messageThreadID",
    "parseMode",
    "sendResolved"
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
public class TelegramConfig implements Editable<TelegramConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("botToken")
    private SecretKeySelector botToken;
    @JsonProperty("botTokenFile")
    private String botTokenFile;
    @JsonProperty("chatID")
    private Long chatID;
    @JsonProperty("disableNotifications")
    private Boolean disableNotifications;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("messageThreadID")
    private Long messageThreadID;
    @JsonProperty("parseMode")
    private String parseMode;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TelegramConfig() {
    }

    public TelegramConfig(String apiURL, SecretKeySelector botToken, String botTokenFile, Long chatID, Boolean disableNotifications, HTTPConfig httpConfig, String message, Long messageThreadID, String parseMode, Boolean sendResolved) {
        super();
        this.apiURL = apiURL;
        this.botToken = botToken;
        this.botTokenFile = botTokenFile;
        this.chatID = chatID;
        this.disableNotifications = disableNotifications;
        this.httpConfig = httpConfig;
        this.message = message;
        this.messageThreadID = messageThreadID;
        this.parseMode = parseMode;
        this.sendResolved = sendResolved;
    }

    /**
     * The Telegram API URL i.e. https://api.telegram.org. If not specified, default API URL will be used.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * The Telegram API URL i.e. https://api.telegram.org. If not specified, default API URL will be used.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * TelegramConfig configures notifications via Telegram. See https://prometheus.io/docs/alerting/latest/configuration/#telegram_config
     */
    @JsonProperty("botToken")
    public SecretKeySelector getBotToken() {
        return botToken;
    }

    /**
     * TelegramConfig configures notifications via Telegram. See https://prometheus.io/docs/alerting/latest/configuration/#telegram_config
     */
    @JsonProperty("botToken")
    public void setBotToken(SecretKeySelector botToken) {
        this.botToken = botToken;
    }

    /**
     * File to read the Telegram bot token from. It is mutually exclusive with `botToken`. Either `botToken` or `botTokenFile` is required.<br><p> <br><p> It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("botTokenFile")
    public String getBotTokenFile() {
        return botTokenFile;
    }

    /**
     * File to read the Telegram bot token from. It is mutually exclusive with `botToken`. Either `botToken` or `botTokenFile` is required.<br><p> <br><p> It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("botTokenFile")
    public void setBotTokenFile(String botTokenFile) {
        this.botTokenFile = botTokenFile;
    }

    /**
     * The Telegram chat ID.
     */
    @JsonProperty("chatID")
    public Long getChatID() {
        return chatID;
    }

    /**
     * The Telegram chat ID.
     */
    @JsonProperty("chatID")
    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    /**
     * Disable telegram notifications
     */
    @JsonProperty("disableNotifications")
    public Boolean getDisableNotifications() {
        return disableNotifications;
    }

    /**
     * Disable telegram notifications
     */
    @JsonProperty("disableNotifications")
    public void setDisableNotifications(Boolean disableNotifications) {
        this.disableNotifications = disableNotifications;
    }

    /**
     * TelegramConfig configures notifications via Telegram. See https://prometheus.io/docs/alerting/latest/configuration/#telegram_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * TelegramConfig configures notifications via Telegram. See https://prometheus.io/docs/alerting/latest/configuration/#telegram_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * Message template
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message template
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The Telegram Group Topic ID. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("messageThreadID")
    public Long getMessageThreadID() {
        return messageThreadID;
    }

    /**
     * The Telegram Group Topic ID. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("messageThreadID")
    public void setMessageThreadID(Long messageThreadID) {
        this.messageThreadID = messageThreadID;
    }

    /**
     * Parse mode for telegram message
     */
    @JsonProperty("parseMode")
    public String getParseMode() {
        return parseMode;
    }

    /**
     * Parse mode for telegram message
     */
    @JsonProperty("parseMode")
    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    /**
     * Whether to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * Whether to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonIgnore
    public TelegramConfigBuilder edit() {
        return new TelegramConfigBuilder(this);
    }

    @JsonIgnore
    public TelegramConfigBuilder toBuilder() {
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
