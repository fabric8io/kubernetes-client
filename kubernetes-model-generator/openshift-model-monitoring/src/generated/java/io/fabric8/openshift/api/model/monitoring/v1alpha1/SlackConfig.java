
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "actions",
    "apiURL",
    "callbackId",
    "channel",
    "color",
    "fallback",
    "fields",
    "footer",
    "httpConfig",
    "iconEmoji",
    "iconURL",
    "imageURL",
    "linkNames",
    "mrkdwnIn",
    "pretext",
    "sendResolved",
    "shortFields",
    "text",
    "thumbURL",
    "title",
    "titleLink",
    "username"
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
public class SlackConfig implements KubernetesResource
{

    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SlackAction> actions = new ArrayList<SlackAction>();
    @JsonProperty("apiURL")
    private SecretKeySelector apiURL;
    @JsonProperty("callbackId")
    private String callbackId;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("color")
    private String color;
    @JsonProperty("fallback")
    private String fallback;
    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SlackField> fields = new ArrayList<SlackField>();
    @JsonProperty("footer")
    private String footer;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("iconEmoji")
    private String iconEmoji;
    @JsonProperty("iconURL")
    private String iconURL;
    @JsonProperty("imageURL")
    private String imageURL;
    @JsonProperty("linkNames")
    private Boolean linkNames;
    @JsonProperty("mrkdwnIn")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mrkdwnIn = new ArrayList<String>();
    @JsonProperty("pretext")
    private String pretext;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("shortFields")
    private Boolean shortFields;
    @JsonProperty("text")
    private String text;
    @JsonProperty("thumbURL")
    private String thumbURL;
    @JsonProperty("title")
    private String title;
    @JsonProperty("titleLink")
    private String titleLink;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SlackConfig() {
    }

    public SlackConfig(List<SlackAction> actions, SecretKeySelector apiURL, String callbackId, String channel, String color, String fallback, List<SlackField> fields, String footer, HTTPConfig httpConfig, String iconEmoji, String iconURL, String imageURL, Boolean linkNames, List<String> mrkdwnIn, String pretext, Boolean sendResolved, Boolean shortFields, String text, String thumbURL, String title, String titleLink, String username) {
        super();
        this.actions = actions;
        this.apiURL = apiURL;
        this.callbackId = callbackId;
        this.channel = channel;
        this.color = color;
        this.fallback = fallback;
        this.fields = fields;
        this.footer = footer;
        this.httpConfig = httpConfig;
        this.iconEmoji = iconEmoji;
        this.iconURL = iconURL;
        this.imageURL = imageURL;
        this.linkNames = linkNames;
        this.mrkdwnIn = mrkdwnIn;
        this.pretext = pretext;
        this.sendResolved = sendResolved;
        this.shortFields = shortFields;
        this.text = text;
        this.thumbURL = thumbURL;
        this.title = title;
        this.titleLink = titleLink;
        this.username = username;
    }

    @JsonProperty("actions")
    public List<SlackAction> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<SlackAction> actions) {
        this.actions = actions;
    }

    @JsonProperty("apiURL")
    public SecretKeySelector getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(SecretKeySelector apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("callbackId")
    public String getCallbackId() {
        return callbackId;
    }

    @JsonProperty("callbackId")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    @JsonProperty("fallback")
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    @JsonProperty("fields")
    public List<SlackField> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<SlackField> fields) {
        this.fields = fields;
    }

    @JsonProperty("footer")
    public String getFooter() {
        return footer;
    }

    @JsonProperty("footer")
    public void setFooter(String footer) {
        this.footer = footer;
    }

    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("iconEmoji")
    public String getIconEmoji() {
        return iconEmoji;
    }

    @JsonProperty("iconEmoji")
    public void setIconEmoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }

    @JsonProperty("iconURL")
    public String getIconURL() {
        return iconURL;
    }

    @JsonProperty("iconURL")
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    @JsonProperty("imageURL")
    public String getImageURL() {
        return imageURL;
    }

    @JsonProperty("imageURL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @JsonProperty("linkNames")
    public Boolean getLinkNames() {
        return linkNames;
    }

    @JsonProperty("linkNames")
    public void setLinkNames(Boolean linkNames) {
        this.linkNames = linkNames;
    }

    @JsonProperty("mrkdwnIn")
    public List<String> getMrkdwnIn() {
        return mrkdwnIn;
    }

    @JsonProperty("mrkdwnIn")
    public void setMrkdwnIn(List<String> mrkdwnIn) {
        this.mrkdwnIn = mrkdwnIn;
    }

    @JsonProperty("pretext")
    public String getPretext() {
        return pretext;
    }

    @JsonProperty("pretext")
    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("shortFields")
    public Boolean getShortFields() {
        return shortFields;
    }

    @JsonProperty("shortFields")
    public void setShortFields(Boolean shortFields) {
        this.shortFields = shortFields;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("thumbURL")
    public String getThumbURL() {
        return thumbURL;
    }

    @JsonProperty("thumbURL")
    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("titleLink")
    public String getTitleLink() {
        return titleLink;
    }

    @JsonProperty("titleLink")
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
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
