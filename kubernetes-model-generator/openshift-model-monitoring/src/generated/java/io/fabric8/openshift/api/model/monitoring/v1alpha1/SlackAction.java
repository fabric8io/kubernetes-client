
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
