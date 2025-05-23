
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
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("agentID")
    public String getAgentID() {
        return agentID;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
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
     * The WeChat API URL.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * The WeChat API URL.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * The corp id for authentication.
     */
    @JsonProperty("corpID")
    public String getCorpID() {
        return corpID;
    }

    /**
     * The corp id for authentication.
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
     * API request data as defined by the WeChat API.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * API request data as defined by the WeChat API.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("messageType")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
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
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("toParty")
    public String getToParty() {
        return toParty;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("toParty")
    public void setToParty(String toParty) {
        this.toParty = toParty;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("toTag")
    public String getToTag() {
        return toTag;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("toTag")
    public void setToTag(String toTag) {
        this.toTag = toTag;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
     */
    @JsonProperty("toUser")
    public String getToUser() {
        return toUser;
    }

    /**
     * WeChatConfig configures notifications via WeChat. See https://prometheus.io/docs/alerting/latest/configuration/#wechat_config
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

}
