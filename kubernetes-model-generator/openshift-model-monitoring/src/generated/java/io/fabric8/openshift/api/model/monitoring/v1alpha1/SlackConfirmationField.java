
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
 * SlackConfirmationField protect users from destructive actions or particularly distinguished decisions by asking them to confirm their button click one more time. See https://api.slack.com/docs/interactive-message-field-guide#confirmation_fields for more information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dismissText",
    "okText",
    "text",
    "title"
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
public class SlackConfirmationField implements Editable<SlackConfirmationFieldBuilder>, KubernetesResource
{

    @JsonProperty("dismissText")
    private String dismissText;
    @JsonProperty("okText")
    private String okText;
    @JsonProperty("text")
    private String text;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SlackConfirmationField() {
    }

    public SlackConfirmationField(String dismissText, String okText, String text, String title) {
        super();
        this.dismissText = dismissText;
        this.okText = okText;
        this.text = text;
        this.title = title;
    }

    /**
     * dismissText defines the label for the cancel button in the dialog. When not specified, defaults to "Cancel". This button cancels the action.
     */
    @JsonProperty("dismissText")
    public String getDismissText() {
        return dismissText;
    }

    /**
     * dismissText defines the label for the cancel button in the dialog. When not specified, defaults to "Cancel". This button cancels the action.
     */
    @JsonProperty("dismissText")
    public void setDismissText(String dismissText) {
        this.dismissText = dismissText;
    }

    /**
     * okText defines the label for the confirmation button in the dialog. When not specified, defaults to "Okay". This button proceeds with the action.
     */
    @JsonProperty("okText")
    public String getOkText() {
        return okText;
    }

    /**
     * okText defines the label for the confirmation button in the dialog. When not specified, defaults to "Okay". This button proceeds with the action.
     */
    @JsonProperty("okText")
    public void setOkText(String okText) {
        this.okText = okText;
    }

    /**
     * text defines the main message displayed in the confirmation dialog. This should be a clear question or statement asking the user to confirm their action.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the main message displayed in the confirmation dialog. This should be a clear question or statement asking the user to confirm their action.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * title defines the title text displayed at the top of the confirmation dialog. When not specified, a default title will be used.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the title text displayed at the top of the confirmation dialog. When not specified, a default title will be used.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnore
    public SlackConfirmationFieldBuilder edit() {
        return new SlackConfirmationFieldBuilder(this);
    }

    @JsonIgnore
    public SlackConfirmationFieldBuilder toBuilder() {
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
        if (!(o instanceof SlackConfirmationField)) {
            return false;
        }
        SlackConfirmationField other = (SlackConfirmationField) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dismissText = this.getDismissText();
        Object other$dismissText = other.getDismissText();
        if (this$dismissText == null ? other$dismissText != null : !this$dismissText.equals(other$dismissText)) {
            return false;
        }
        Object this$okText = this.getOkText();
        Object other$okText = other.getOkText();
        if (this$okText == null ? other$okText != null : !this$okText.equals(other$okText)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof SlackConfirmationField;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dismissText = this.getDismissText();
        result = result * prime + ($dismissText == null ? 43 : $dismissText.hashCode());
        Object $okText = this.getOkText();
        result = result * prime + ($okText == null ? 43 : $okText.hashCode());
        Object $text = this.getText();
        result = result * prime + ($text == null ? 43 : $text.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SlackConfirmationField(" + "dismissText=" + this.getDismissText() + ", okText=" + this.getOkText() + ", text=" + this.getText() + ", title=" + this.getTitle() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
