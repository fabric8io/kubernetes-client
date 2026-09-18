
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
 * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agentID",
    "apiSecret",
    "apiURL",
    "corpID",
    "httpConfig",
    "message",
    "messageType",
    "sendResolved",
    "toParty",
    "toTag",
    "toUser"
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
public class WeChatConfig implements Editable<WeChatConfigBuilder>, KubernetesResource
{

    @JsonProperty("agentID")
    private String agentID;
    @JsonProperty("apiSecret")
    private SecretKeySelector apiSecret;
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("corpID")
    private String corpID;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("messageType")
    private String messageType;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("toParty")
    private String toParty;
    @JsonProperty("toTag")
    private String toTag;
    @JsonProperty("toUser")
    private String toUser;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WeChatConfig() {
    }

    public WeChatConfig(String agentID, SecretKeySelector apiSecret, String apiURL, String corpID, HTTPConfig httpConfig, String message, String messageType, Boolean sendResolved, String toParty, String toTag, String toUser) {
        super();
        this.agentID = agentID;
        this.apiSecret = apiSecret;
        this.apiURL = apiURL;
        this.corpID = corpID;
        this.httpConfig = httpConfig;
        this.message = message;
        this.messageType = messageType;
        this.sendResolved = sendResolved;
        this.toParty = toParty;
        this.toTag = toTag;
        this.toUser = toUser;
    }

    /**
     * agentID defines the application agent ID within WeChat Work. This identifies which WeChat Work application will send the notifications.
     */
    @JsonProperty("agentID")
    public String getAgentID() {
        return agentID;
    }

    /**
     * agentID defines the application agent ID within WeChat Work. This identifies which WeChat Work application will send the notifications.
     */
    @JsonProperty("agentID")
    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("apiSecret")
    public SecretKeySelector getApiSecret() {
        return apiSecret;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("apiSecret")
    public void setApiSecret(SecretKeySelector apiSecret) {
        this.apiSecret = apiSecret;
    }

    /**
     * apiURL defines the WeChat API URL. When not specified, defaults to the standard WeChat Work API endpoint.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the WeChat API URL. When not specified, defaults to the standard WeChat Work API endpoint.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * corpID defines the corp id for authentication. This is the unique identifier for your WeChat Work organization.
     */
    @JsonProperty("corpID")
    public String getCorpID() {
        return corpID;
    }

    /**
     * corpID defines the corp id for authentication. This is the unique identifier for your WeChat Work organization.
     */
    @JsonProperty("corpID")
    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * message defines the API request data as defined by the WeChat API. This contains the actual notification content to be sent.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message defines the API request data as defined by the WeChat API. This contains the actual notification content to be sent.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * messageType defines the type of message to send. Valid values include "text", "markdown", and other WeChat Work supported message types.
     */
    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    /**
     * messageType defines the type of message to send. Valid values include "text", "markdown", and other WeChat Work supported message types.
     */
    @JsonProperty("messageType")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
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
     * toParty defines the target department(s) to receive the notification. Can be a single department ID or multiple department IDs separated by '|'.
     */
    @JsonProperty("toParty")
    public String getToParty() {
        return toParty;
    }

    /**
     * toParty defines the target department(s) to receive the notification. Can be a single department ID or multiple department IDs separated by '|'.
     */
    @JsonProperty("toParty")
    public void setToParty(String toParty) {
        this.toParty = toParty;
    }

    /**
     * toTag defines the target tag(s) to receive the notification. Can be a single tag ID or multiple tag IDs separated by '|'.
     */
    @JsonProperty("toTag")
    public String getToTag() {
        return toTag;
    }

    /**
     * toTag defines the target tag(s) to receive the notification. Can be a single tag ID or multiple tag IDs separated by '|'.
     */
    @JsonProperty("toTag")
    public void setToTag(String toTag) {
        this.toTag = toTag;
    }

    /**
     * toUser defines the target user(s) to receive the notification. Can be a single user ID or multiple user IDs separated by '|'.
     */
    @JsonProperty("toUser")
    public String getToUser() {
        return toUser;
    }

    /**
     * toUser defines the target user(s) to receive the notification. Can be a single user ID or multiple user IDs separated by '|'.
     */
    @JsonProperty("toUser")
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    @JsonIgnore
    public WeChatConfigBuilder edit() {
        return new WeChatConfigBuilder(this);
    }

    @JsonIgnore
    public WeChatConfigBuilder toBuilder() {
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
        if (!(o instanceof WeChatConfig)) {
            return false;
        }
        WeChatConfig other = (WeChatConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$agentID = this.getAgentID();
        Object other$agentID = other.getAgentID();
        if (this$agentID == null ? other$agentID != null : !this$agentID.equals(other$agentID)) {
            return false;
        }
        Object this$apiSecret = this.getApiSecret();
        Object other$apiSecret = other.getApiSecret();
        if (this$apiSecret == null ? other$apiSecret != null : !this$apiSecret.equals(other$apiSecret)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
            return false;
        }
        Object this$corpID = this.getCorpID();
        Object other$corpID = other.getCorpID();
        if (this$corpID == null ? other$corpID != null : !this$corpID.equals(other$corpID)) {
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
        Object this$messageType = this.getMessageType();
        Object other$messageType = other.getMessageType();
        if (this$messageType == null ? other$messageType != null : !this$messageType.equals(other$messageType)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$toParty = this.getToParty();
        Object other$toParty = other.getToParty();
        if (this$toParty == null ? other$toParty != null : !this$toParty.equals(other$toParty)) {
            return false;
        }
        Object this$toTag = this.getToTag();
        Object other$toTag = other.getToTag();
        if (this$toTag == null ? other$toTag != null : !this$toTag.equals(other$toTag)) {
            return false;
        }
        Object this$toUser = this.getToUser();
        Object other$toUser = other.getToUser();
        if (this$toUser == null ? other$toUser != null : !this$toUser.equals(other$toUser)) {
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
        return other instanceof WeChatConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $agentID = this.getAgentID();
        result = result * prime + ($agentID == null ? 43 : $agentID.hashCode());
        Object $apiSecret = this.getApiSecret();
        result = result * prime + ($apiSecret == null ? 43 : $apiSecret.hashCode());
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $corpID = this.getCorpID();
        result = result * prime + ($corpID == null ? 43 : $corpID.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $messageType = this.getMessageType();
        result = result * prime + ($messageType == null ? 43 : $messageType.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $toParty = this.getToParty();
        result = result * prime + ($toParty == null ? 43 : $toParty.hashCode());
        Object $toTag = this.getToTag();
        result = result * prime + ($toTag == null ? 43 : $toTag.hashCode());
        Object $toUser = this.getToUser();
        result = result * prime + ($toUser == null ? 43 : $toUser.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WeChatConfig(" + "agentID=" + this.getAgentID() + ", apiSecret=" + this.getApiSecret() + ", apiURL=" + this.getApiURL() + ", corpID=" + this.getCorpID() + ", httpConfig=" + this.getHttpConfig() + ", message=" + this.getMessage() + ", messageType=" + this.getMessageType() + ", sendResolved=" + this.getSendResolved() + ", toParty=" + this.getToParty() + ", toTag=" + this.getToTag() + ", toUser=" + this.getToUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
