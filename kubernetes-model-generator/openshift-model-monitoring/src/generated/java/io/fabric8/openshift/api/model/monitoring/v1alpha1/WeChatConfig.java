
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.HashMap;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
public class WeChatConfig implements KubernetesResource
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeChatConfig() {
    }

    /**
     * 
     * @param toUser
     * @param agentID
     * @param sendResolved
     * @param apiURL
     * @param corpID
     * @param httpConfig
     * @param messageType
     * @param toTag
     * @param apiSecret
     * @param toParty
     * @param message
     */
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

    @JsonProperty("agentID")
    public String getAgentID() {
        return agentID;
    }

    @JsonProperty("agentID")
    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    @JsonProperty("apiSecret")
    public SecretKeySelector getApiSecret() {
        return apiSecret;
    }

    @JsonProperty("apiSecret")
    public void setApiSecret(SecretKeySelector apiSecret) {
        this.apiSecret = apiSecret;
    }

    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("corpID")
    public String getCorpID() {
        return corpID;
    }

    @JsonProperty("corpID")
    public void setCorpID(String corpID) {
        this.corpID = corpID;
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

    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    @JsonProperty("messageType")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("toParty")
    public String getToParty() {
        return toParty;
    }

    @JsonProperty("toParty")
    public void setToParty(String toParty) {
        this.toParty = toParty;
    }

    @JsonProperty("toTag")
    public String getToTag() {
        return toTag;
    }

    @JsonProperty("toTag")
    public void setToTag(String toTag) {
        this.toTag = toTag;
    }

    @JsonProperty("toUser")
    public String getToUser() {
        return toUser;
    }

    @JsonProperty("toUser")
    public void setToUser(String toUser) {
        this.toUser = toUser;
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
