
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * MachineOSBuilderReference describes which ImageBuilder backend to use for this build/
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildPod",
    "imageBuilderType"
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
public class MachineOSBuilderReference implements Editable<MachineOSBuilderReferenceBuilder>, KubernetesResource
{

    @JsonProperty("buildPod")
    private ObjectReference buildPod;
    @JsonProperty("imageBuilderType")
    private String imageBuilderType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSBuilderReference() {
    }

    public MachineOSBuilderReference(ObjectReference buildPod, String imageBuilderType) {
        super();
        this.buildPod = buildPod;
        this.imageBuilderType = imageBuilderType;
    }

    /**
     * MachineOSBuilderReference describes which ImageBuilder backend to use for this build/
     */
    @JsonProperty("buildPod")
    public ObjectReference getBuildPod() {
        return buildPod;
    }

    /**
     * MachineOSBuilderReference describes which ImageBuilder backend to use for this build/
     */
    @JsonProperty("buildPod")
    public void setBuildPod(ObjectReference buildPod) {
        this.buildPod = buildPod;
    }

    /**
     * ImageBuilderType describes the image builder set in the MachineOSConfig
     */
    @JsonProperty("imageBuilderType")
    public String getImageBuilderType() {
        return imageBuilderType;
    }

    /**
     * ImageBuilderType describes the image builder set in the MachineOSConfig
     */
    @JsonProperty("imageBuilderType")
    public void setImageBuilderType(String imageBuilderType) {
        this.imageBuilderType = imageBuilderType;
    }

    @JsonIgnore
    public MachineOSBuilderReferenceBuilder edit() {
        return new MachineOSBuilderReferenceBuilder(this);
    }

    @JsonIgnore
    public MachineOSBuilderReferenceBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
