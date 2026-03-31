
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
 * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "apiURL",
    "channel",
    "color",
    "emoji",
    "fields",
    "httpConfig",
    "iconURL",
    "imageURL",
    "linkNames",
    "sendResolved",
    "shortFields",
    "text",
    "thumbURL",
    "title",
    "titleLink",
    "token",
    "tokenID"
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
public class RocketChatConfig implements Editable<RocketChatConfigBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RocketChatActionConfig> actions = new ArrayList<>();
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("color")
    private String color;
    @JsonProperty("emoji")
    private String emoji;
    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RocketChatFieldConfig> fields = new ArrayList<>();
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("iconURL")
    private String iconURL;
    @JsonProperty("imageURL")
    private String imageURL;
    @JsonProperty("linkNames")
    private Boolean linkNames;
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
    @JsonProperty("token")
    private SecretKeySelector token;
    @JsonProperty("tokenID")
    private SecretKeySelector tokenID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RocketChatConfig() {
    }

    public RocketChatConfig(List<RocketChatActionConfig> actions, String apiURL, String channel, String color, String emoji, List<RocketChatFieldConfig> fields, HTTPConfig httpConfig, String iconURL, String imageURL, Boolean linkNames, Boolean sendResolved, Boolean shortFields, String text, String thumbURL, String title, String titleLink, SecretKeySelector token, SecretKeySelector tokenID) {
        super();
        this.actions = actions;
        this.apiURL = apiURL;
        this.channel = channel;
        this.color = color;
        this.emoji = emoji;
        this.fields = fields;
        this.httpConfig = httpConfig;
        this.iconURL = iconURL;
        this.imageURL = imageURL;
        this.linkNames = linkNames;
        this.sendResolved = sendResolved;
        this.shortFields = shortFields;
        this.text = text;
        this.thumbURL = thumbURL;
        this.title = title;
        this.titleLink = titleLink;
        this.token = token;
        this.tokenID = tokenID;
    }

    /**
     * actions defines interactive actions to include in the message. These appear as buttons that users can click to trigger responses.
     */
    @JsonProperty("actions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RocketChatActionConfig> getActions() {
        return actions;
    }

    /**
     * actions defines interactive actions to include in the message. These appear as buttons that users can click to trigger responses.
     */
    @JsonProperty("actions")
    public void setActions(List<RocketChatActionConfig> actions) {
        this.actions = actions;
    }

    /**
     * apiURL defines the API URL for RocketChat. Defaults to https://open.rocket.chat/ if not specified.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the API URL for RocketChat. Defaults to https://open.rocket.chat/ if not specified.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * channel defines the channel to send alerts to. This can be a channel name (e.g., "#alerts") or a direct message recipient.
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * channel defines the channel to send alerts to. This can be a channel name (e.g., "#alerts") or a direct message recipient.
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * color defines the message color displayed in RocketChat. This appears as a colored bar alongside the message.
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    /**
     * color defines the message color displayed in RocketChat. This appears as a colored bar alongside the message.
     */
    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * emoji defines the emoji to be displayed as an avatar. If provided, this emoji will be used instead of the default avatar or iconURL.
     */
    @JsonProperty("emoji")
    public String getEmoji() {
        return emoji;
    }

    /**
     * emoji defines the emoji to be displayed as an avatar. If provided, this emoji will be used instead of the default avatar or iconURL.
     */
    @JsonProperty("emoji")
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    /**
     * fields defines additional fields for the message attachment. These appear as structured key-value pairs within the message.
     */
    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RocketChatFieldConfig> getFields() {
        return fields;
    }

    /**
     * fields defines additional fields for the message attachment. These appear as structured key-value pairs within the message.
     */
    @JsonProperty("fields")
    public void setFields(List<RocketChatFieldConfig> fields) {
        this.fields = fields;
    }

    /**
     * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * iconURL defines the icon URL for the message avatar. This displays a custom image as the message sender's avatar.
     */
    @JsonProperty("iconURL")
    public String getIconURL() {
        return iconURL;
    }

    /**
     * iconURL defines the icon URL for the message avatar. This displays a custom image as the message sender's avatar.
     */
    @JsonProperty("iconURL")
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    /**
     * imageURL defines the image URL to display within the message. This embeds an image directly in the message attachment.
     */
    @JsonProperty("imageURL")
    public String getImageURL() {
        return imageURL;
    }

    /**
     * imageURL defines the image URL to display within the message. This embeds an image directly in the message attachment.
     */
    @JsonProperty("imageURL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * linkNames defines whether to enable automatic linking of usernames and channels. When true, @username and #channel references become clickable links.
     */
    @JsonProperty("linkNames")
    public Boolean getLinkNames() {
        return linkNames;
    }

    /**
     * linkNames defines whether to enable automatic linking of usernames and channels. When true, @username and #channel references become clickable links.
     */
    @JsonProperty("linkNames")
    public void setLinkNames(Boolean linkNames) {
        this.linkNames = linkNames;
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
     * shortFields defines whether to use short fields in the message layout. When true, fields may be displayed side by side to save space.
     */
    @JsonProperty("shortFields")
    public Boolean getShortFields() {
        return shortFields;
    }

    /**
     * shortFields defines whether to use short fields in the message layout. When true, fields may be displayed side by side to save space.
     */
    @JsonProperty("shortFields")
    public void setShortFields(Boolean shortFields) {
        this.shortFields = shortFields;
    }

    /**
     * text defines the message text to send. This is optional because attachments can be used instead of or alongside text.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the message text to send. This is optional because attachments can be used instead of or alongside text.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * thumbURL defines the thumbnail URL for the message. This displays a small thumbnail image alongside the message content.
     */
    @JsonProperty("thumbURL")
    public String getThumbURL() {
        return thumbURL;
    }

    /**
     * thumbURL defines the thumbnail URL for the message. This displays a small thumbnail image alongside the message content.
     */
    @JsonProperty("thumbURL")
    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    /**
     * title defines the message title displayed prominently in the message. This appears as bold text at the top of the message attachment.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the message title displayed prominently in the message. This appears as bold text at the top of the message attachment.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * titleLink defines the URL that the title will link to when clicked. This makes the message title clickable in the RocketChat interface.
     */
    @JsonProperty("titleLink")
    public String getTitleLink() {
        return titleLink;
    }

    /**
     * titleLink defines the URL that the title will link to when clicked. This makes the message title clickable in the RocketChat interface.
     */
    @JsonProperty("titleLink")
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    /**
     * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("token")
    public SecretKeySelector getToken() {
        return token;
    }

    /**
     * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("token")
    public void setToken(SecretKeySelector token) {
        this.token = token;
    }

    /**
     * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("tokenID")
    public SecretKeySelector getTokenID() {
        return tokenID;
    }

    /**
     * RocketChatConfig configures notifications via RocketChat. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("tokenID")
    public void setTokenID(SecretKeySelector tokenID) {
        this.tokenID = tokenID;
    }

    @JsonIgnore
    public RocketChatConfigBuilder edit() {
        return new RocketChatConfigBuilder(this);
    }

    @JsonIgnore
    public RocketChatConfigBuilder toBuilder() {
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
