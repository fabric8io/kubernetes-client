
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "apiURL",
    "botToken",
    "chatID",
    "disableNotifications",
    "httpConfig",
    "message",
    "parseMode",
    "sendResolved"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class TelegramConfig implements KubernetesResource
{

    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("botToken")
    private SecretKeySelector botToken;
    @JsonProperty("chatID")
    private Long chatID;
    @JsonProperty("disableNotifications")
    private Boolean disableNotifications;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("parseMode")
    private String parseMode;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TelegramConfig() {
    }

    public TelegramConfig(String apiURL, SecretKeySelector botToken, Long chatID, Boolean disableNotifications, HTTPConfig httpConfig, String message, String parseMode, Boolean sendResolved) {
        super();
        this.apiURL = apiURL;
        this.botToken = botToken;
        this.chatID = chatID;
        this.disableNotifications = disableNotifications;
        this.httpConfig = httpConfig;
        this.message = message;
        this.parseMode = parseMode;
        this.sendResolved = sendResolved;
    }

    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("botToken")
    public SecretKeySelector getBotToken() {
        return botToken;
    }

    @JsonProperty("botToken")
    public void setBotToken(SecretKeySelector botToken) {
        this.botToken = botToken;
    }

    @JsonProperty("chatID")
    public Long getChatID() {
        return chatID;
    }

    @JsonProperty("chatID")
    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    @JsonProperty("disableNotifications")
    public Boolean getDisableNotifications() {
        return disableNotifications;
    }

    @JsonProperty("disableNotifications")
    public void setDisableNotifications(Boolean disableNotifications) {
        this.disableNotifications = disableNotifications;
    }

    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("parseMode")
    public String getParseMode() {
        return parseMode;
    }

    @JsonProperty("parseMode")
    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
