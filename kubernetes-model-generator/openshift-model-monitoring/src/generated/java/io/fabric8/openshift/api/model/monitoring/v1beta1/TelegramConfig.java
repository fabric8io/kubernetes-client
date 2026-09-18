
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
     * apiURL defines the Telegram API URL, e.g. https://api.telegram.org. If not specified, the default Telegram API URL will be used.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the Telegram API URL, e.g. https://api.telegram.org. If not specified, the default Telegram API URL will be used.
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
     * botTokenFile defines the file to read the Telegram bot token from. It is mutually exclusive with `botToken`. Either `botToken` or `botTokenFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("botTokenFile")
    public String getBotTokenFile() {
        return botTokenFile;
    }

    /**
     * botTokenFile defines the file to read the Telegram bot token from. It is mutually exclusive with `botToken`. Either `botToken` or `botTokenFile` is required. It requires Alertmanager &gt;= v0.26.0.
     */
    @JsonProperty("botTokenFile")
    public void setBotTokenFile(String botTokenFile) {
        this.botTokenFile = botTokenFile;
    }

    /**
     * chatID defines the Telegram chat ID where messages will be sent. This can be a user ID, group ID, or channel ID (with @ prefix for public channels).
     */
    @JsonProperty("chatID")
    public Long getChatID() {
        return chatID;
    }

    /**
     * chatID defines the Telegram chat ID where messages will be sent. This can be a user ID, group ID, or channel ID (with @ prefix for public channels).
     */
    @JsonProperty("chatID")
    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    /**
     * disableNotifications controls whether Telegram notifications are sent silently. When true, users will receive the message without notification sounds.
     */
    @JsonProperty("disableNotifications")
    public Boolean getDisableNotifications() {
        return disableNotifications;
    }

    /**
     * disableNotifications controls whether Telegram notifications are sent silently. When true, users will receive the message without notification sounds.
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
     * message defines the message template for the Telegram notification. This is the content that will be sent to the specified chat.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message defines the message template for the Telegram notification. This is the content that will be sent to the specified chat.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * messageThreadID defines the Telegram Group Topic ID for threaded messages. This allows sending messages to specific topics within Telegram groups. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("messageThreadID")
    public Long getMessageThreadID() {
        return messageThreadID;
    }

    /**
     * messageThreadID defines the Telegram Group Topic ID for threaded messages. This allows sending messages to specific topics within Telegram groups. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("messageThreadID")
    public void setMessageThreadID(Long messageThreadID) {
        this.messageThreadID = messageThreadID;
    }

    /**
     * parseMode defines the parse mode for telegram message formatting. Valid values are "MarkdownV2", "Markdown", and "HTML". This determines how text formatting is interpreted in the message.
     */
    @JsonProperty("parseMode")
    public String getParseMode() {
        return parseMode;
    }

    /**
     * parseMode defines the parse mode for telegram message formatting. Valid values are "MarkdownV2", "Markdown", and "HTML". This determines how text formatting is interpreted in the message.
     */
    @JsonProperty("parseMode")
    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
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

    @JsonIgnore
    public TelegramConfigBuilder edit() {
        return new TelegramConfigBuilder(this);
    }

    @JsonIgnore
    public TelegramConfigBuilder toBuilder() {
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
        if (!(o instanceof TelegramConfig)) {
            return false;
        }
        TelegramConfig other = (TelegramConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
            return false;
        }
        Object this$botToken = this.getBotToken();
        Object other$botToken = other.getBotToken();
        if (this$botToken == null ? other$botToken != null : !this$botToken.equals(other$botToken)) {
            return false;
        }
        Object this$botTokenFile = this.getBotTokenFile();
        Object other$botTokenFile = other.getBotTokenFile();
        if (this$botTokenFile == null ? other$botTokenFile != null : !this$botTokenFile.equals(other$botTokenFile)) {
            return false;
        }
        Object this$chatID = this.getChatID();
        Object other$chatID = other.getChatID();
        if (this$chatID == null ? other$chatID != null : !this$chatID.equals(other$chatID)) {
            return false;
        }
        Object this$disableNotifications = this.getDisableNotifications();
        Object other$disableNotifications = other.getDisableNotifications();
        if (this$disableNotifications == null ? other$disableNotifications != null : !this$disableNotifications.equals(other$disableNotifications)) {
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
        Object this$messageThreadID = this.getMessageThreadID();
        Object other$messageThreadID = other.getMessageThreadID();
        if (this$messageThreadID == null ? other$messageThreadID != null : !this$messageThreadID.equals(other$messageThreadID)) {
            return false;
        }
        Object this$parseMode = this.getParseMode();
        Object other$parseMode = other.getParseMode();
        if (this$parseMode == null ? other$parseMode != null : !this$parseMode.equals(other$parseMode)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
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
        return other instanceof TelegramConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $botToken = this.getBotToken();
        result = result * prime + ($botToken == null ? 43 : $botToken.hashCode());
        Object $botTokenFile = this.getBotTokenFile();
        result = result * prime + ($botTokenFile == null ? 43 : $botTokenFile.hashCode());
        Object $chatID = this.getChatID();
        result = result * prime + ($chatID == null ? 43 : $chatID.hashCode());
        Object $disableNotifications = this.getDisableNotifications();
        result = result * prime + ($disableNotifications == null ? 43 : $disableNotifications.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $messageThreadID = this.getMessageThreadID();
        result = result * prime + ($messageThreadID == null ? 43 : $messageThreadID.hashCode());
        Object $parseMode = this.getParseMode();
        result = result * prime + ($parseMode == null ? 43 : $parseMode.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TelegramConfig(" + "apiURL=" + this.getApiURL() + ", botToken=" + this.getBotToken() + ", botTokenFile=" + this.getBotTokenFile() + ", chatID=" + this.getChatID() + ", disableNotifications=" + this.getDisableNotifications() + ", httpConfig=" + this.getHttpConfig() + ", message=" + this.getMessage() + ", messageThreadID=" + this.getMessageThreadID() + ", parseMode=" + this.getParseMode() + ", sendResolved=" + this.getSendResolved() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
