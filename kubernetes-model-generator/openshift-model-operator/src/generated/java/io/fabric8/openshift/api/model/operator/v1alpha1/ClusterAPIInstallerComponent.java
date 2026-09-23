
package io.fabric8.openshift.api.model.operator.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterAPIInstallerComponent defines a component which will be installed by this revision.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "name",
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
public class ClusterAPIInstallerComponent implements Editable<ClusterAPIInstallerComponentBuilder>, KubernetesResource
{

    @JsonProperty("image")
    private ClusterAPIInstallerComponentImage image;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAPIInstallerComponent() {
    }

    public ClusterAPIInstallerComponent(ClusterAPIInstallerComponentImage image, String name, String type) {
        super();
        this.image = image;
        this.name = name;
        this.type = type;
    }

    /**
     * ClusterAPIInstallerComponent defines a component which will be installed by this revision.
     */
    @JsonProperty("image")
    public ClusterAPIInstallerComponentImage getImage() {
        return image;
    }

    /**
     * ClusterAPIInstallerComponent defines a component which will be installed by this revision.
     */
    @JsonProperty("image")
    public void setImage(ClusterAPIInstallerComponentImage image) {
        this.image = image;
    }

    /**
     * name is the human-readable name of the component. The value has no effect, and will not be set if the component does not define a name in its manifests. If set it must consist of alphanumeric characters, or '-', and may not exceed 255 characters.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the human-readable name of the component. The value has no effect, and will not be set if the component does not define a name in its manifests. If set it must consist of alphanumeric characters, or '-', and may not exceed 255 characters.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * type is the source type of the component. The only valid value is Image. When set to Image, the image field must be set and will define an image source for the component.<br><p> <br><p> Possible enum values:<br><p>  - `"Image"` is an image source for a component.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the source type of the component. The only valid value is Image. When set to Image, the image field must be set and will define an image source for the component.<br><p> <br><p> Possible enum values:<br><p>  - `"Image"` is an image source for a component.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ClusterAPIInstallerComponentBuilder edit() {
        return new ClusterAPIInstallerComponentBuilder(this);
    }

    @JsonIgnore
    public ClusterAPIInstallerComponentBuilder toBuilder() {
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
