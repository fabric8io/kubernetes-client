
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DiscordConfig configures notifications via Discord. See https://prometheus.io/docs/alerting/latest/configuration/#discord_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiURL",
    "avatarURL",
    "content",
    "httpConfig",
    "message",
    "sendResolved",
    "title",
    "username"
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
public class DiscordConfig implements Editable<DiscordConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiURL")
    private SecretKeySelector apiURL;
    @JsonProperty("avatarURL")
    private String avatarURL;
    @JsonProperty("content")
    private String content;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("title")
    private String title;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DiscordConfig() {
    }

    public DiscordConfig(SecretKeySelector apiURL, String avatarURL, String content, HTTPConfig httpConfig, String message, Boolean sendResolved, String title, String username) {
        super();
        this.apiURL = apiURL;
        this.avatarURL = avatarURL;
        this.content = content;
        this.httpConfig = httpConfig;
        this.message = message;
        this.sendResolved = sendResolved;
        this.title = title;
        this.username = username;
    }

    /**
     * DiscordConfig configures notifications via Discord. See https://prometheus.io/docs/alerting/latest/configuration/#discord_config
     */
    @JsonProperty("apiURL")
    public SecretKeySelector getApiURL() {
        return apiURL;
    }

    /**
     * DiscordConfig configures notifications via Discord. See https://prometheus.io/docs/alerting/latest/configuration/#discord_config
     */
    @JsonProperty("apiURL")
    public void setApiURL(SecretKeySelector apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * avatarURL defines the avatar url of the message sender.
     */
    @JsonProperty("avatarURL")
    public String getAvatarURL() {
        return avatarURL;
    }

    /**
     * avatarURL defines the avatar url of the message sender.
     */
    @JsonProperty("avatarURL")
    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    /**
     * content defines the template of the content's body.
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * content defines the template of the content's body.
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * DiscordConfig configures notifications via Discord. See https://prometheus.io/docs/alerting/latest/configuration/#discord_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * DiscordConfig configures notifications via Discord. See https://prometheus.io/docs/alerting/latest/configuration/#discord_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * message defines the template of the message's body.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message defines the template of the message's body.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
     * title defines the template of the message's title.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the template of the message's title.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * username defines the username of the message sender.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * username defines the username of the message sender.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public DiscordConfigBuilder edit() {
        return new DiscordConfigBuilder(this);
    }

    @JsonIgnore
    public DiscordConfigBuilder toBuilder() {
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
        if (!(o instanceof DiscordConfig)) {
            return false;
        }
        DiscordConfig other = (DiscordConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
            return false;
        }
        Object this$avatarURL = this.getAvatarURL();
        Object other$avatarURL = other.getAvatarURL();
        if (this$avatarURL == null ? other$avatarURL != null : !this$avatarURL.equals(other$avatarURL)) {
            return false;
        }
        Object this$content = this.getContent();
        Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) {
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
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof DiscordConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $avatarURL = this.getAvatarURL();
        result = result * prime + ($avatarURL == null ? 43 : $avatarURL.hashCode());
        Object $content = this.getContent();
        result = result * prime + ($content == null ? 43 : $content.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DiscordConfig(" + "apiURL=" + this.getApiURL() + ", avatarURL=" + this.getAvatarURL() + ", content=" + this.getContent() + ", httpConfig=" + this.getHttpConfig() + ", message=" + this.getMessage() + ", sendResolved=" + this.getSendResolved() + ", title=" + this.getTitle() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
