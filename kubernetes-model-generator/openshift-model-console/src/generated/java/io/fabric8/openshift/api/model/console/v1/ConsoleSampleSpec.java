
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
