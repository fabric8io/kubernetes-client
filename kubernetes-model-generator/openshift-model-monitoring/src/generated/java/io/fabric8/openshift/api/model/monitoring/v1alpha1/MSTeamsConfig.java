
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
 * MSTeamsConfig configures notifications via Microsoft Teams. It requires Alertmanager &gt;= 0.26.0.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "sendResolved",
    "summary",
    "text",
    "title",
    "webhookUrl"
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
public class MSTeamsConfig implements Editable<MSTeamsConfigBuilder>, KubernetesResource
{

    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("text")
    private String text;
    @JsonProperty("title")
    private String title;
    @JsonProperty("webhookUrl")
    private SecretKeySelector webhookUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MSTeamsConfig() {
    }

    public MSTeamsConfig(HTTPConfig httpConfig, Boolean sendResolved, String summary, String text, String title, SecretKeySelector webhookUrl) {
        super();
        this.httpConfig = httpConfig;
        this.sendResolved = sendResolved;
        this.summary = summary;
        this.text = text;
        this.title = title;
        this.webhookUrl = webhookUrl;
    }

    /**
     * MSTeamsConfig configures notifications via Microsoft Teams. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * MSTeamsConfig configures notifications via Microsoft Teams. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
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
     * summary defines the message summary template for Teams notifications. This provides a brief overview that appears in Teams notification previews. It requires Alertmanager &gt;= 0.27.0.
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * summary defines the message summary template for Teams notifications. This provides a brief overview that appears in Teams notification previews. It requires Alertmanager &gt;= 0.27.0.
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * text defines the message body template for Teams notifications. This contains the detailed content of the Teams message.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the message body template for Teams notifications. This contains the detailed content of the Teams message.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * title defines the message title template for Teams notifications. This appears as the main heading of the Teams message card.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the message title template for Teams notifications. This appears as the main heading of the Teams message card.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * MSTeamsConfig configures notifications via Microsoft Teams. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("webhookUrl")
    public SecretKeySelector getWebhookUrl() {
        return webhookUrl;
    }

    /**
     * MSTeamsConfig configures notifications via Microsoft Teams. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("webhookUrl")
    public void setWebhookUrl(SecretKeySelector webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    @JsonIgnore
    public MSTeamsConfigBuilder edit() {
        return new MSTeamsConfigBuilder(this);
    }

    @JsonIgnore
    public MSTeamsConfigBuilder toBuilder() {
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
        if (!(o instanceof MSTeamsConfig)) {
            return false;
        }
        MSTeamsConfig other = (MSTeamsConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$summary = this.getSummary();
        Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary)) {
            return false;
        }
        Object this$text = this.getText();
        Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        Object this$webhookUrl = this.getWebhookUrl();
        Object other$webhookUrl = other.getWebhookUrl();
        if (this$webhookUrl == null ? other$webhookUrl != null : !this$webhookUrl.equals(other$webhookUrl)) {
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
        return other instanceof MSTeamsConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $summary = this.getSummary();
        result = result * prime + ($summary == null ? 43 : $summary.hashCode());
        Object $text = this.getText();
        result = result * prime + ($text == null ? 43 : $text.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $webhookUrl = this.getWebhookUrl();
        result = result * prime + ($webhookUrl == null ? 43 : $webhookUrl.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MSTeamsConfig(" + "httpConfig=" + this.getHttpConfig() + ", sendResolved=" + this.getSendResolved() + ", summary=" + this.getSummary() + ", text=" + this.getText() + ", title=" + this.getTitle() + ", webhookUrl=" + this.getWebhookUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
