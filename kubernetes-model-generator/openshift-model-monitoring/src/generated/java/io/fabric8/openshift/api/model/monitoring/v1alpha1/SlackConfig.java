
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

    /**
     * A list of Slack actions that are sent with each notification.
     */
    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackAction> getActions() {
        return actions;
    }

    /**
     * A list of Slack actions that are sent with each notification.
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
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("callbackId")
    public String getCallbackId() {
        return callbackId;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("callbackId")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    /**
     * The channel or user to send notifications to.
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * The channel or user to send notifications to.
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("fallback")
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    /**
     * A list of Slack fields that are sent with each notification.
     */
    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackField> getFields() {
        return fields;
    }

    /**
     * A list of Slack fields that are sent with each notification.
     */
    @JsonProperty("fields")
    public void setFields(List<SlackField> fields) {
        this.fields = fields;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("footer")
    public String getFooter() {
        return footer;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
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
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("iconEmoji")
    public String getIconEmoji() {
        return iconEmoji;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("iconEmoji")
    public void setIconEmoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("iconURL")
    public String getIconURL() {
        return iconURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("iconURL")
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("imageURL")
    public String getImageURL() {
        return imageURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("imageURL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("linkNames")
    public Boolean getLinkNames() {
        return linkNames;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("linkNames")
    public void setLinkNames(Boolean linkNames) {
        this.linkNames = linkNames;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("mrkdwnIn")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMrkdwnIn() {
        return mrkdwnIn;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("mrkdwnIn")
    public void setMrkdwnIn(List<String> mrkdwnIn) {
        this.mrkdwnIn = mrkdwnIn;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("pretext")
    public String getPretext() {
        return pretext;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("pretext")
    public void setPretext(String pretext) {
        this.pretext = pretext;
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
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("shortFields")
    public Boolean getShortFields() {
        return shortFields;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("shortFields")
    public void setShortFields(Boolean shortFields) {
        this.shortFields = shortFields;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("thumbURL")
    public String getThumbURL() {
        return thumbURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("thumbURL")
    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("titleLink")
    public String getTitleLink() {
        return titleLink;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("titleLink")
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * SlackConfig configures notifications via Slack. See https://prometheus.io/docs/alerting/latest/configuration/#slack_config
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
