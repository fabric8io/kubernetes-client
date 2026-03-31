
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    "messageText",
    "mrkdwnIn",
    "pretext",
    "sendResolved",
    "shortFields",
    "text",
    "thumbURL",
    "timeout",
    "title",
    "titleLink",
    "username"
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
public class SlackConfig implements Editable<SlackConfigBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SlackAction> actions = new ArrayList<>();
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
    private List<SlackField> fields = new ArrayList<>();
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
    @JsonProperty("messageText")
    private String messageText;
    @JsonProperty("mrkdwnIn")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mrkdwnIn = new ArrayList<>();
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
    @JsonProperty("timeout")
    private String timeout;
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
     */
    public SlackConfig() {
    }

    public SlackConfig(List<SlackAction> actions, SecretKeySelector apiURL, String callbackId, String channel, String color, String fallback, List<SlackField> fields, String footer, HTTPConfig httpConfig, String iconEmoji, String iconURL, String imageURL, Boolean linkNames, String messageText, List<String> mrkdwnIn, String pretext, Boolean sendResolved, Boolean shortFields, String text, String thumbURL, String timeout, String title, String titleLink, String username) {
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
        this.messageText = messageText;
        this.mrkdwnIn = mrkdwnIn;
        this.pretext = pretext;
        this.sendResolved = sendResolved;
        this.shortFields = shortFields;
        this.text = text;
        this.thumbURL = thumbURL;
        this.timeout = timeout;
        this.title = title;
        this.titleLink = titleLink;
        this.username = username;
    }

    /**
     * actions defines a list of Slack actions that are sent with each notification.
     */
    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackAction> getActions() {
        return actions;
    }

    /**
     * actions defines a list of Slack actions that are sent with each notification.
     */
    @JsonProperty("actions")
    public void setActions(List<SlackAction> actions) {
        this.actions = actions;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("apiURL")
    public SecretKeySelector getApiURL() {
        return apiURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("apiURL")
    public void setApiURL(SecretKeySelector apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * callbackId defines an identifier for the message used in interactive components.
     */
    @JsonProperty("callbackId")
    public String getCallbackId() {
        return callbackId;
    }

    /**
     * callbackId defines an identifier for the message used in interactive components.
     */
    @JsonProperty("callbackId")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    /**
     * channel defines the channel or user to send notifications to.
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * channel defines the channel or user to send notifications to.
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * color defines the color of the left border of the Slack message attachment. Can be a hex color code (e.g., "#ff0000") or a predefined color name.
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    /**
     * color defines the color of the left border of the Slack message attachment. Can be a hex color code (e.g., "#ff0000") or a predefined color name.
     */
    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * fallback defines a plain-text summary of the attachment for clients that don't support attachments.
     */
    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    /**
     * fallback defines a plain-text summary of the attachment for clients that don't support attachments.
     */
    @JsonProperty("fallback")
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    /**
     * fields defines a list of Slack fields that are sent with each notification.
     */
    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackField> getFields() {
        return fields;
    }

    /**
     * fields defines a list of Slack fields that are sent with each notification.
     */
    @JsonProperty("fields")
    public void setFields(List<SlackField> fields) {
        this.fields = fields;
    }

    /**
     * footer defines small text displayed at the bottom of the message attachment.
     */
    @JsonProperty("footer")
    public String getFooter() {
        return footer;
    }

    /**
     * footer defines small text displayed at the bottom of the message attachment.
     */
    @JsonProperty("footer")
    public void setFooter(String footer) {
        this.footer = footer;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * iconEmoji defines the emoji to use as the bot's avatar (e.g., ":ghost:").
     */
    @JsonProperty("iconEmoji")
    public String getIconEmoji() {
        return iconEmoji;
    }

    /**
     * iconEmoji defines the emoji to use as the bot's avatar (e.g., ":ghost:").
     */
    @JsonProperty("iconEmoji")
    public void setIconEmoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }

    /**
     * iconURL defines the URL to an image to use as the bot's avatar.
     */
    @JsonProperty("iconURL")
    public String getIconURL() {
        return iconURL;
    }

    /**
     * iconURL defines the URL to an image to use as the bot's avatar.
     */
    @JsonProperty("iconURL")
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    /**
     * imageURL defines the URL to an image file that will be displayed inside the message attachment.
     */
    @JsonProperty("imageURL")
    public String getImageURL() {
        return imageURL;
    }

    /**
     * imageURL defines the URL to an image file that will be displayed inside the message attachment.
     */
    @JsonProperty("imageURL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * linkNames enables automatic linking of channel names and usernames in the message. When true, @channel and @username will be converted to clickable links.
     */
    @JsonProperty("linkNames")
    public Boolean getLinkNames() {
        return linkNames;
    }

    /**
     * linkNames enables automatic linking of channel names and usernames in the message. When true, @channel and @username will be converted to clickable links.
     */
    @JsonProperty("linkNames")
    public void setLinkNames(Boolean linkNames) {
        this.linkNames = linkNames;
    }

    /**
     * messageText defines text content of the Slack message. If set, this is sent as the top-level 'text' field in the Slack payload. It requires Alertmanager &gt;= v0.31.0.
     */
    @JsonProperty("messageText")
    public String getMessageText() {
        return messageText;
    }

    /**
     * messageText defines text content of the Slack message. If set, this is sent as the top-level 'text' field in the Slack payload. It requires Alertmanager &gt;= v0.31.0.
     */
    @JsonProperty("messageText")
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * mrkdwnIn defines which fields should be parsed as Slack markdown. Valid values include "pretext", "text", and "fields".
     */
    @JsonProperty("mrkdwnIn")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMrkdwnIn() {
        return mrkdwnIn;
    }

    /**
     * mrkdwnIn defines which fields should be parsed as Slack markdown. Valid values include "pretext", "text", and "fields".
     */
    @JsonProperty("mrkdwnIn")
    public void setMrkdwnIn(List<String> mrkdwnIn) {
        this.mrkdwnIn = mrkdwnIn;
    }

    /**
     * pretext defines optional text that appears above the message attachment block.
     */
    @JsonProperty("pretext")
    public String getPretext() {
        return pretext;
    }

    /**
     * pretext defines optional text that appears above the message attachment block.
     */
    @JsonProperty("pretext")
    public void setPretext(String pretext) {
        this.pretext = pretext;
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
     * shortFields determines whether fields are displayed in a compact format. When true, fields are shown side by side when possible.
     */
    @JsonProperty("shortFields")
    public Boolean getShortFields() {
        return shortFields;
    }

    /**
     * shortFields determines whether fields are displayed in a compact format. When true, fields are shown side by side when possible.
     */
    @JsonProperty("shortFields")
    public void setShortFields(Boolean shortFields) {
        this.shortFields = shortFields;
    }

    /**
     * text defines the main text content of the Slack message attachment.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the main text content of the Slack message attachment.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * thumbURL defines the URL to an image file that will be displayed as a thumbnail on the right side of the message attachment.
     */
    @JsonProperty("thumbURL")
    public String getThumbURL() {
        return thumbURL;
    }

    /**
     * thumbURL defines the URL to an image file that will be displayed as a thumbnail on the right side of the message attachment.
     */
    @JsonProperty("thumbURL")
    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    /**
     * timeout defines the maximum time to wait for a webhook request to complete, before failing the request and allowing it to be retried. It requires Alertmanager &gt;= v0.30.0.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout defines the maximum time to wait for a webhook request to complete, before failing the request and allowing it to be retried. It requires Alertmanager &gt;= v0.30.0.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    /**
     * title defines the title text displayed in the Slack message attachment.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the title text displayed in the Slack message attachment.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * titleLink defines the URL that the title will link to when clicked.
     */
    @JsonProperty("titleLink")
    public String getTitleLink() {
        return titleLink;
    }

    /**
     * titleLink defines the URL that the title will link to when clicked.
     */
    @JsonProperty("titleLink")
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    /**
     * username defines the slack bot user name.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * username defines the slack bot user name.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public SlackConfigBuilder edit() {
        return new SlackConfigBuilder(this);
    }

    @JsonIgnore
    public SlackConfigBuilder toBuilder() {
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
