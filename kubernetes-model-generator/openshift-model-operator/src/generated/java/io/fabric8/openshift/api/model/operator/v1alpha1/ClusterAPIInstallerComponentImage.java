
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
 * ClusterAPIInstallerComponentImage defines an image source for a component.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "profile",
    "ref"
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
public class ClusterAPIInstallerComponentImage implements Editable<ClusterAPIInstallerComponentImageBuilder>, KubernetesResource
{

    @JsonProperty("profile")
    private String profile;
    @JsonProperty("ref")
    private String ref;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAPIInstallerComponentImage() {
    }

    public ClusterAPIInstallerComponentImage(String profile, String ref) {
        super();
        this.profile = profile;
        this.ref = ref;
    }

    /**
     * profile is the name of a profile to use from the image.<br><p> <br><p> A profile name may be up to 255 characters long. It must consist of alphanumeric characters, '-', or '_'.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * profile is the name of a profile to use from the image.<br><p> <br><p> A profile name may be up to 255 characters long. It must consist of alphanumeric characters, '-', or '_'.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * ref is an image reference to the image containing the component manifests. The reference must be a valid image digest reference in the format host[:port][/namespace]/name@sha256:&lt;digest&gt;. The digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the field must be between 1 to 447 characters.
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * ref is an image reference to the image containing the component manifests. The reference must be a valid image digest reference in the format host[:port][/namespace]/name@sha256:&lt;digest&gt;. The digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the field must be between 1 to 447 characters.
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonIgnore
    public ClusterAPIInstallerComponentImageBuilder edit() {
        return new ClusterAPIInstallerComponentImageBuilder(this);
    }

    @JsonIgnore
    public ClusterAPIInstallerComponentImageBuilder toBuilder() {
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
