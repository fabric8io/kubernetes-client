
package io.fabric8.openshift.api.model.console.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ConsoleSampleSpec is the desired sample for the web console. Samples will appear with their title, descriptions and a badge in a samples catalog.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "abstract",
    "description",
    "icon",
    "provider",
    "source",
    "tags",
    "title",
    "type"
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
public class ConsoleSampleSpec implements Editable<ConsoleSampleSpecBuilder>, KubernetesResource
{

    @JsonProperty("abstract")
    private String _abstract;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("source")
    private ConsoleSampleSource source;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleSampleSpec() {
    }

    public ConsoleSampleSpec(String _abstract, String description, String icon, String provider, ConsoleSampleSource source, List<String> tags, String title, String type) {
        super();
        this._abstract = _abstract;
        this.description = description;
        this.icon = icon;
        this.provider = provider;
        this.source = source;
        this.tags = tags;
        this.title = title;
        this.type = type;
    }

    /**
     * abstract is a short introduction to the sample.<br><p> <br><p> It is required and must be no more than 100 characters in length.<br><p> <br><p> The abstract is shown on the sample card tile below the title and provider and is limited to three lines of content.
     */
    @JsonProperty("abstract")
    public String getAbstract() {
        return _abstract;
    }

    /**
     * abstract is a short introduction to the sample.<br><p> <br><p> It is required and must be no more than 100 characters in length.<br><p> <br><p> The abstract is shown on the sample card tile below the title and provider and is limited to three lines of content.
     */
    @JsonProperty("abstract")
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    /**
     * description is a long form explanation of the sample.<br><p> <br><p> It is required and can have a maximum length of &#42;&#42;4096&#42;&#42; characters.<br><p> <br><p> It is a README.md-like content for additional information, links, pre-conditions, and other instructions. It will be rendered as Markdown so that it can contain line breaks, links, and other simple formatting.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description is a long form explanation of the sample.<br><p> <br><p> It is required and can have a maximum length of &#42;&#42;4096&#42;&#42; characters.<br><p> <br><p> It is a README.md-like content for additional information, links, pre-conditions, and other instructions. It will be rendered as Markdown so that it can contain line breaks, links, and other simple formatting.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * icon is an optional base64 encoded image and shown beside the sample title.<br><p> <br><p> The format must follow the data: URL format and can have a maximum size of &#42;&#42;10 KB&#42;&#42;.<br><p> <br><p>   data:[&lt;mediatype&gt;][;base64],&lt;base64 encoded image&gt;<br><p> <br><p> For example:<br><p> <br><p>   data:image;base64,             plus the base64 encoded image.<br><p> <br><p> Vector images can also be used. SVG icons must start with:<br><p> <br><p>   data:image/svg+xml;base64,     plus the base64 encoded SVG image.<br><p> <br><p> All sample catalog icons will be shown on a white background (also when the dark theme is used). The web console ensures that different aspect ratios work correctly. Currently, the surface of the icon is at most 40x100px.<br><p> <br><p> For more information on the data URL format, please visit https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/Data_URLs.
     */
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    /**
     * icon is an optional base64 encoded image and shown beside the sample title.<br><p> <br><p> The format must follow the data: URL format and can have a maximum size of &#42;&#42;10 KB&#42;&#42;.<br><p> <br><p>   data:[&lt;mediatype&gt;][;base64],&lt;base64 encoded image&gt;<br><p> <br><p> For example:<br><p> <br><p>   data:image;base64,             plus the base64 encoded image.<br><p> <br><p> Vector images can also be used. SVG icons must start with:<br><p> <br><p>   data:image/svg+xml;base64,     plus the base64 encoded SVG image.<br><p> <br><p> All sample catalog icons will be shown on a white background (also when the dark theme is used). The web console ensures that different aspect ratios work correctly. Currently, the surface of the icon is at most 40x100px.<br><p> <br><p> For more information on the data URL format, please visit https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/Data_URLs.
     */
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * provider is an optional label to honor who provides the sample.<br><p> <br><p> It is optional and must be no more than 50 characters in length.<br><p> <br><p> A provider can be a company like "Red Hat" or an organization like "CNCF" or "Knative".<br><p> <br><p> Currently, the provider is only shown on the sample card tile below the title with the prefix "Provided by "
     */
    @JsonProperty("provider")
    public String getProvider() {
        return provider;
    }

    /**
     * provider is an optional label to honor who provides the sample.<br><p> <br><p> It is optional and must be no more than 50 characters in length.<br><p> <br><p> A provider can be a company like "Red Hat" or an organization like "CNCF" or "Knative".<br><p> <br><p> Currently, the provider is only shown on the sample card tile below the title with the prefix "Provided by "
     */
    @JsonProperty("provider")
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * ConsoleSampleSpec is the desired sample for the web console. Samples will appear with their title, descriptions and a badge in a samples catalog.
     */
    @JsonProperty("source")
    public ConsoleSampleSource getSource() {
        return source;
    }

    /**
     * ConsoleSampleSpec is the desired sample for the web console. Samples will appear with their title, descriptions and a badge in a samples catalog.
     */
    @JsonProperty("source")
    public void setSource(ConsoleSampleSource source) {
        this.source = source;
    }

    /**
     * tags are optional string values that can be used to find samples in the samples catalog.<br><p> <br><p> Examples of common tags may be "Java", "Quarkus", etc.<br><p> <br><p> They will be displayed on the samples details page.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * tags are optional string values that can be used to find samples in the samples catalog.<br><p> <br><p> Examples of common tags may be "Java", "Quarkus", etc.<br><p> <br><p> They will be displayed on the samples details page.
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * title is the display name of the sample.<br><p> <br><p> It is required and must be no more than 50 characters in length.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title is the display name of the sample.<br><p> <br><p> It is required and must be no more than 50 characters in length.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * type is an optional label to group multiple samples.<br><p> <br><p> It is optional and must be no more than 20 characters in length.<br><p> <br><p> Recommendation is a singular term like "Builder Image", "Devfile" or "Serverless Function".<br><p> <br><p> Currently, the type is shown a badge on the sample card tile in the top right corner.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is an optional label to group multiple samples.<br><p> <br><p> It is optional and must be no more than 20 characters in length.<br><p> <br><p> Recommendation is a singular term like "Builder Image", "Devfile" or "Serverless Function".<br><p> <br><p> Currently, the type is shown a badge on the sample card tile in the top right corner.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ConsoleSampleSpecBuilder edit() {
        return new ConsoleSampleSpecBuilder(this);
    }

    @JsonIgnore
    public ConsoleSampleSpecBuilder toBuilder() {
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
        if (!(o instanceof ConsoleSampleSpec)) {
            return false;
        }
        ConsoleSampleSpec other = (ConsoleSampleSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_abstract = this.getAbstract();
        Object other$_abstract = other.getAbstract();
        if (this$_abstract == null ? other$_abstract != null : !this$_abstract.equals(other$_abstract)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$icon = this.getIcon();
        Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) {
            return false;
        }
        Object this$provider = this.getProvider();
        Object other$provider = other.getProvider();
        if (this$provider == null ? other$provider != null : !this$provider.equals(other$provider)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof ConsoleSampleSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_abstract = this.getAbstract();
        result = result * prime + ($_abstract == null ? 43 : $_abstract.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $icon = this.getIcon();
        result = result * prime + ($icon == null ? 43 : $icon.hashCode());
        Object $provider = this.getProvider();
        result = result * prime + ($provider == null ? 43 : $provider.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleSampleSpec(" + "_abstract=" + this.getAbstract() + ", description=" + this.getDescription() + ", icon=" + this.getIcon() + ", provider=" + this.getProvider() + ", source=" + this.getSource() + ", tags=" + this.getTags() + ", title=" + this.getTitle() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
