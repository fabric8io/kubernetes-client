
package io.fabric8.openshift.api.model;

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
 * BuildConfigStatus contains current state of the build config object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageChangeTriggers",
    "lastVersion"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildConfigStatus implements Editable<BuildConfigStatusBuilder>, KubernetesResource
{

    @JsonProperty("imageChangeTriggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageChangeTriggerStatus> imageChangeTriggers = new ArrayList<>();
    @JsonProperty("lastVersion")
    private Long lastVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildConfigStatus() {
    }

    public BuildConfigStatus(List<ImageChangeTriggerStatus> imageChangeTriggers, Long lastVersion) {
        super();
        this.imageChangeTriggers = imageChangeTriggers;
        this.lastVersion = lastVersion;
    }

    /**
     * ImageChangeTriggers captures the runtime state of any ImageChangeTrigger specified in the BuildConfigSpec, including the value reconciled by the OpenShift APIServer for the lastTriggeredImageID. There is a single entry in this array for each image change trigger in spec. Each trigger status references the ImageStreamTag that acts as the source of the trigger.
     */
    @JsonProperty("imageChangeTriggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageChangeTriggerStatus> getImageChangeTriggers() {
        return imageChangeTriggers;
    }

    /**
     * ImageChangeTriggers captures the runtime state of any ImageChangeTrigger specified in the BuildConfigSpec, including the value reconciled by the OpenShift APIServer for the lastTriggeredImageID. There is a single entry in this array for each image change trigger in spec. Each trigger status references the ImageStreamTag that acts as the source of the trigger.
     */
    @JsonProperty("imageChangeTriggers")
    public void setImageChangeTriggers(List<ImageChangeTriggerStatus> imageChangeTriggers) {
        this.imageChangeTriggers = imageChangeTriggers;
    }

    /**
     * lastVersion is used to inform about number of last triggered build.
     */
    @JsonProperty("lastVersion")
    public Long getLastVersion() {
        return lastVersion;
    }

    /**
     * lastVersion is used to inform about number of last triggered build.
     */
    @JsonProperty("lastVersion")
    public void setLastVersion(Long lastVersion) {
        this.lastVersion = lastVersion;
    }

    @JsonIgnore
    public BuildConfigStatusBuilder edit() {
        return new BuildConfigStatusBuilder(this);
    }

    @JsonIgnore
    public BuildConfigStatusBuilder toBuilder() {
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
