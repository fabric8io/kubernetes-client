
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

/**
 * MachineOSBuilderReference describes which ImageBuilder backend to use for this build
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageBuilderType",
    "job"
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
public class MachineOSBuilderReference implements Editable<MachineOSBuilderReferenceBuilder>, KubernetesResource
{

    @JsonProperty("imageBuilderType")
    private String imageBuilderType;
    @JsonProperty("job")
    private ObjectReference job;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSBuilderReference() {
    }

    public MachineOSBuilderReference(String imageBuilderType, ObjectReference job) {
        super();
        this.imageBuilderType = imageBuilderType;
        this.job = job;
    }

    /**
     * imageBuilderType describes the type of image builder used to build this image. Valid values are Job only. When set to Job, a pod based builder, using buildah, is launched to build the specified image.<br><p> <br><p> Possible enum values:<br><p>  - `"Job"` describes that the machine-os-builder will use a Job to spin up a custom pod builder that uses buildah
     */
    @JsonProperty("imageBuilderType")
    public String getImageBuilderType() {
        return imageBuilderType;
    }

    /**
     * imageBuilderType describes the type of image builder used to build this image. Valid values are Job only. When set to Job, a pod based builder, using buildah, is launched to build the specified image.<br><p> <br><p> Possible enum values:<br><p>  - `"Job"` describes that the machine-os-builder will use a Job to spin up a custom pod builder that uses buildah
     */
    @JsonProperty("imageBuilderType")
    public void setImageBuilderType(String imageBuilderType) {
        this.imageBuilderType = imageBuilderType;
    }

    /**
     * MachineOSBuilderReference describes which ImageBuilder backend to use for this build
     */
    @JsonProperty("job")
    public ObjectReference getJob() {
        return job;
    }

    /**
     * MachineOSBuilderReference describes which ImageBuilder backend to use for this build
     */
    @JsonProperty("job")
    public void setJob(ObjectReference job) {
        this.job = job;
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
        if (!(o instanceof MachineOSBuilderReference)) {
            return false;
        }
        MachineOSBuilderReference other = (MachineOSBuilderReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imageBuilderType = this.getImageBuilderType();
        Object other$imageBuilderType = other.getImageBuilderType();
        if (this$imageBuilderType == null ? other$imageBuilderType != null : !this$imageBuilderType.equals(other$imageBuilderType)) {
            return false;
        }
        Object this$job = this.getJob();
        Object other$job = other.getJob();
        if (this$job == null ? other$job != null : !this$job.equals(other$job)) {
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
        return other instanceof MachineOSBuilderReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imageBuilderType = this.getImageBuilderType();
        result = result * prime + ($imageBuilderType == null ? 43 : $imageBuilderType.hashCode());
        Object $job = this.getJob();
        result = result * prime + ($job == null ? 43 : $job.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineOSBuilderReference(" + "imageBuilderType=" + this.getImageBuilderType() + ", job=" + this.getJob() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
