
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
 * MachineConfigNodeSpecConfigImage holds the desired image for the node. This structure is populated from the `machineconfiguration.openshift.io/desiredImage` annotation on the target node, which is set by the Machine Config Pool controller to signal the desired image pullspec for the node to update to.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "desiredImage"
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
public class MachineConfigNodeSpecConfigImage implements Editable<MachineConfigNodeSpecConfigImageBuilder>, KubernetesResource
{

    @JsonProperty("desiredImage")
    private String desiredImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeSpecConfigImage() {
    }

    public MachineConfigNodeSpecConfigImage(String desiredImage) {
        super();
        this.desiredImage = desiredImage;
    }

    /**
     * desiredImage is a required field that configures the image that the node should be updated to use. It must be a fully qualified OCI image pull spec of the format host[:port][/namespace]/name@sha256:, where the digest must be exactly 64 characters in length and consist only of lowercase hexadecimal characters, a-f and 0-9. desiredImage must not be an empty string and must not exceed 447 characters in length.
     */
    @JsonProperty("desiredImage")
    public String getDesiredImage() {
        return desiredImage;
    }

    /**
     * desiredImage is a required field that configures the image that the node should be updated to use. It must be a fully qualified OCI image pull spec of the format host[:port][/namespace]/name@sha256:, where the digest must be exactly 64 characters in length and consist only of lowercase hexadecimal characters, a-f and 0-9. desiredImage must not be an empty string and must not exceed 447 characters in length.
     */
    @JsonProperty("desiredImage")
    public void setDesiredImage(String desiredImage) {
        this.desiredImage = desiredImage;
    }

    @JsonIgnore
    public MachineConfigNodeSpecConfigImageBuilder edit() {
        return new MachineConfigNodeSpecConfigImageBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeSpecConfigImageBuilder toBuilder() {
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
