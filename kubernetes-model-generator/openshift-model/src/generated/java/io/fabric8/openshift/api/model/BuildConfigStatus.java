
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

/**
 * BuildConfigStatus contains current state of the build config object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageChangeTriggers",
    "lastVersion"
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
     * imageChangeTriggers captures the runtime state of any ImageChangeTrigger specified in the BuildConfigSpec, including the value reconciled by the OpenShift APIServer for the lastTriggeredImageID. There is a single entry in this array for each image change trigger in spec. Each trigger status references the ImageStreamTag that acts as the source of the trigger.
     */
    @JsonProperty("imageChangeTriggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageChangeTriggerStatus> getImageChangeTriggers() {
        return imageChangeTriggers;
    }

    /**
     * imageChangeTriggers captures the runtime state of any ImageChangeTrigger specified in the BuildConfigSpec, including the value reconciled by the OpenShift APIServer for the lastTriggeredImageID. There is a single entry in this array for each image change trigger in spec. Each trigger status references the ImageStreamTag that acts as the source of the trigger.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BuildConfigStatus)) {
            return false;
        }
        BuildConfigStatus other = (BuildConfigStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imageChangeTriggers = this.getImageChangeTriggers();
        Object other$imageChangeTriggers = other.getImageChangeTriggers();
        if (this$imageChangeTriggers == null ? other$imageChangeTriggers != null : !this$imageChangeTriggers.equals(other$imageChangeTriggers)) {
            return false;
        }
        Object this$lastVersion = this.getLastVersion();
        Object other$lastVersion = other.getLastVersion();
        if (this$lastVersion == null ? other$lastVersion != null : !this$lastVersion.equals(other$lastVersion)) {
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
        return other instanceof BuildConfigStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imageChangeTriggers = this.getImageChangeTriggers();
        result = result * prime + ($imageChangeTriggers == null ? 43 : $imageChangeTriggers.hashCode());
        Object $lastVersion = this.getLastVersion();
        result = result * prime + ($lastVersion == null ? 43 : $lastVersion.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildConfigStatus(" + "imageChangeTriggers=" + this.getImageChangeTriggers() + ", lastVersion=" + this.getLastVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
