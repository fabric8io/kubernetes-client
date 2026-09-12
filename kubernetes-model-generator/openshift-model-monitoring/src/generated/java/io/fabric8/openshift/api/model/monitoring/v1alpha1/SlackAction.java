
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SlackAction configures a single Slack action that is sent with each notification. See https://api.slack.com/docs/message-attachments#action_fields and https://api.slack.com/docs/message-buttons for more information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "confirm",
    "name",
    "style",
    "text",
    "type",
    "url",
    "value"
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
public class SlackAction implements Editable<SlackActionBuilder>, KubernetesResource
{

    @JsonProperty("confirm")
    private SlackConfirmationField confirm;
    @JsonProperty("name")
    private String name;
    @JsonProperty("style")
    private String style;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SlackAction() {
    }

    public SlackAction(SlackConfirmationField confirm, String name, String style, String text, String type, String url, String value) {
        super();
        this.confirm = confirm;
        this.name = name;
        this.style = style;
        this.text = text;
        this.type = type;
        this.url = url;
        this.value = value;
    }

    /**
     * SlackAction configures a single Slack action that is sent with each notification. See https://api.slack.com/docs/message-attachments#action_fields and https://api.slack.com/docs/message-buttons for more information.
     */
    @JsonProperty("confirm")
    public SlackConfirmationField getConfirm() {
        return confirm;
    }

    /**
     * SlackAction configures a single Slack action that is sent with each notification. See https://api.slack.com/docs/message-attachments#action_fields and https://api.slack.com/docs/message-buttons for more information.
     */
    @JsonProperty("confirm")
    public void setConfirm(SlackConfirmationField confirm) {
        this.confirm = confirm;
    }

    /**
     * name defines a unique identifier for the action within the message. This value is sent back to your application when the action is triggered.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name defines a unique identifier for the action within the message. This value is sent back to your application when the action is triggered.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * style defines the visual appearance of the action element. Valid values include "default", "primary" (green), and "danger" (red).
     */
    @JsonProperty("style")
    public String getStyle() {
        return style;
    }

    /**
     * style defines the visual appearance of the action element. Valid values include "default", "primary" (green), and "danger" (red).
     */
    @JsonProperty("style")
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * text defines the user-visible label displayed on the action element. For buttons, this is the button text. For select menus, this is the placeholder text.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the user-visible label displayed on the action element. For buttons, this is the button text. For select menus, this is the placeholder text.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * type defines the type of interactive component. Common values include "button" for clickable buttons and "select" for dropdown menus.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type defines the type of interactive component. Common values include "button" for clickable buttons and "select" for dropdown menus.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * url defines the URL to open when the action is triggered. Only applicable for button-type actions. When set, clicking the button opens this URL.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url defines the URL to open when the action is triggered. Only applicable for button-type actions. When set, clicking the button opens this URL.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * value defines the payload sent when the action is triggered. This data is included in the callback sent to your application.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * value defines the payload sent when the action is triggered. This data is included in the callback sent to your application.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public SlackActionBuilder edit() {
        return new SlackActionBuilder(this);
    }

    @JsonIgnore
    public SlackActionBuilder toBuilder() {
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
        if (!(o instanceof SlackAction)) {
            return false;
        }
        SlackAction other = (SlackAction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$confirm = this.getConfirm();
        Object other$confirm = other.getConfirm();
        if (this$confirm == null ? other$confirm != null : !this$confirm.equals(other$confirm)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$style = this.getStyle();
        Object other$style = other.getStyle();
        if (this$style == null ? other$style != null : !this$style.equals(other$style)) {
            return false;
        }
        Object this$text = this.getText();
        Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof SlackAction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $confirm = this.getConfirm();
        result = result * prime + ($confirm == null ? 43 : $confirm.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $style = this.getStyle();
        result = result * prime + ($style == null ? 43 : $style.hashCode());
        Object $text = this.getText();
        result = result * prime + ($text == null ? 43 : $text.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SlackAction(" + "confirm=" + this.getConfirm() + ", name=" + this.getName() + ", style=" + this.getStyle() + ", text=" + this.getText() + ", type=" + this.getType() + ", url=" + this.getUrl() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
