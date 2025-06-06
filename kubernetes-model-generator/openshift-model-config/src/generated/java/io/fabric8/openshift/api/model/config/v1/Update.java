
package io.fabric8.openshift.api.model.config.v1;

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
 * Update represents an administrator update request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "force",
    "image",
    "version"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Update implements Editable<UpdateBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("force")
    private Boolean force;
    @JsonProperty("image")
    private String image;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Update() {
    }

    public Update(String architecture, Boolean force, String image, String version) {
        super();
        this.architecture = architecture;
        this.force = force;
        this.image = image;
        this.version = version;
    }

    /**
     * architecture is an optional field that indicates the desired value of the cluster architecture. In this context cluster architecture means either a single architecture or a multi architecture. architecture can only be set to Multi thereby only allowing updates from single to multi architecture. If architecture is set, image cannot be set and version must be set. Valid values are 'Multi' and empty.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * architecture is an optional field that indicates the desired value of the cluster architecture. In this context cluster architecture means either a single architecture or a multi architecture. architecture can only be set to Multi thereby only allowing updates from single to multi architecture. If architecture is set, image cannot be set and version must be set. Valid values are 'Multi' and empty.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * force allows an administrator to update to an image that has failed verification or upgradeable checks. This option should only be used when the authenticity of the provided image has been verified out of band because the provided image will run with full administrative access to the cluster. Do not use this flag with images that comes from unknown or potentially malicious sources.
     */
    @JsonProperty("force")
    public Boolean getForce() {
        return force;
    }

    /**
     * force allows an administrator to update to an image that has failed verification or upgradeable checks. This option should only be used when the authenticity of the provided image has been verified out of band because the provided image will run with full administrative access to the cluster. Do not use this flag with images that comes from unknown or potentially malicious sources.
     */
    @JsonProperty("force")
    public void setForce(Boolean force) {
        this.force = force;
    }

    /**
     * image is a container image location that contains the update. image should be used when the desired version does not exist in availableUpdates or history. When image is set, version is ignored. When image is set, version should be empty. When image is set, architecture cannot be specified.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is a container image location that contains the update. image should be used when the desired version does not exist in availableUpdates or history. When image is set, version is ignored. When image is set, version should be empty. When image is set, architecture cannot be specified.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * version is a semantic version identifying the update version. version is ignored if image is specified and required if architecture is specified.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is a semantic version identifying the update version. version is ignored if image is specified and required if architecture is specified.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public UpdateBuilder edit() {
        return new UpdateBuilder(this);
    }

    @JsonIgnore
    public UpdateBuilder toBuilder() {
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
