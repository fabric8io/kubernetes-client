
package io.fabric8.openshift.api.model.operator.v1;

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
 * Logo defines a configuration based on theme modes for the console UI logo.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "themes",
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
public class Logo implements Editable<LogoBuilder>, KubernetesResource
{

    @JsonProperty("themes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Theme> themes = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Logo() {
    }

    public Logo(List<Theme> themes, String type) {
        super();
        this.themes = themes;
        this.type = type;
    }

    /**
     * themes specifies the themes for the console UI logo. themes is a required field that allows a list of themes. Each item in the themes list must have a unique mode and a source field. Each mode determines whether the logo is for the dark or light mode of the console UI. If a theme is not specified, the default OpenShift logo will be displayed for that theme. There must be at least one entry and no more than 2 entries.
     */
    @JsonProperty("themes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Theme> getThemes() {
        return themes;
    }

    /**
     * themes specifies the themes for the console UI logo. themes is a required field that allows a list of themes. Each item in the themes list must have a unique mode and a source field. Each mode determines whether the logo is for the dark or light mode of the console UI. If a theme is not specified, the default OpenShift logo will be displayed for that theme. There must be at least one entry and no more than 2 entries.
     */
    @JsonProperty("themes")
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    /**
     * type specifies the type of the logo for the console UI. It determines whether the logo is for the masthead or favicon. type is a required field that allows values of Masthead and Favicon. When set to "Masthead", the logo will be used in the masthead and about modal of the console UI. When set to "Favicon", the logo will be used as the favicon of the console UI.<br><p> <br><p> Possible enum values:<br><p>  - `"Favicon"` Favicon represents the favicon logo.<br><p>  - `"Masthead"` Masthead represents the logo in the masthead.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type specifies the type of the logo for the console UI. It determines whether the logo is for the masthead or favicon. type is a required field that allows values of Masthead and Favicon. When set to "Masthead", the logo will be used in the masthead and about modal of the console UI. When set to "Favicon", the logo will be used as the favicon of the console UI.<br><p> <br><p> Possible enum values:<br><p>  - `"Favicon"` Favicon represents the favicon logo.<br><p>  - `"Masthead"` Masthead represents the logo in the masthead.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public LogoBuilder edit() {
        return new LogoBuilder(this);
    }

    @JsonIgnore
    public LogoBuilder toBuilder() {
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
