
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

/**
 * BuildOutput is input to a build strategy and describes the container image that the strategy should produce.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageLabels",
    "pushSecret",
    "to"
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
public class BuildOutput implements Editable<BuildOutputBuilder>, KubernetesResource
{

    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLabel> imageLabels = new ArrayList<>();
    @JsonProperty("pushSecret")
    private LocalObjectReference pushSecret;
    @JsonProperty("to")
    private ObjectReference to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildOutput() {
    }

    public BuildOutput(List<ImageLabel> imageLabels, LocalObjectReference pushSecret, ObjectReference to) {
        super();
        this.imageLabels = imageLabels;
        this.pushSecret = pushSecret;
        this.to = to;
    }

    /**
     * imageLabels define a list of labels that are applied to the resulting image. If there are multiple labels with the same name then the last one in the list is used.
     */
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageLabel> getImageLabels() {
        return imageLabels;
    }

    /**
     * imageLabels define a list of labels that are applied to the resulting image. If there are multiple labels with the same name then the last one in the list is used.
     */
    @JsonProperty("imageLabels")
    public void setImageLabels(List<ImageLabel> imageLabels) {
        this.imageLabels = imageLabels;
    }

    /**
     * BuildOutput is input to a build strategy and describes the container image that the strategy should produce.
     */
    @JsonProperty("pushSecret")
    public LocalObjectReference getPushSecret() {
        return pushSecret;
    }

    /**
     * BuildOutput is input to a build strategy and describes the container image that the strategy should produce.
     */
    @JsonProperty("pushSecret")
    public void setPushSecret(LocalObjectReference pushSecret) {
        this.pushSecret = pushSecret;
    }

    /**
     * BuildOutput is input to a build strategy and describes the container image that the strategy should produce.
     */
    @JsonProperty("to")
    public ObjectReference getTo() {
        return to;
    }

    /**
     * BuildOutput is input to a build strategy and describes the container image that the strategy should produce.
     */
    @JsonProperty("to")
    public void setTo(ObjectReference to) {
        this.to = to;
    }

    @JsonIgnore
    public BuildOutputBuilder edit() {
        return new BuildOutputBuilder(this);
    }

    @JsonIgnore
    public BuildOutputBuilder toBuilder() {
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
        if (!(o instanceof BuildOutput)) {
            return false;
        }
        BuildOutput other = (BuildOutput) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imageLabels = this.getImageLabels();
        Object other$imageLabels = other.getImageLabels();
        if (this$imageLabels == null ? other$imageLabels != null : !this$imageLabels.equals(other$imageLabels)) {
            return false;
        }
        Object this$pushSecret = this.getPushSecret();
        Object other$pushSecret = other.getPushSecret();
        if (this$pushSecret == null ? other$pushSecret != null : !this$pushSecret.equals(other$pushSecret)) {
            return false;
        }
        Object this$to = this.getTo();
        Object other$to = other.getTo();
        if (this$to == null ? other$to != null : !this$to.equals(other$to)) {
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
        return other instanceof BuildOutput;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imageLabels = this.getImageLabels();
        result = result * prime + ($imageLabels == null ? 43 : $imageLabels.hashCode());
        Object $pushSecret = this.getPushSecret();
        result = result * prime + ($pushSecret == null ? 43 : $pushSecret.hashCode());
        Object $to = this.getTo();
        result = result * prime + ($to == null ? 43 : $to.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildOutput(" + "imageLabels=" + this.getImageLabels() + ", pushSecret=" + this.getPushSecret() + ", to=" + this.getTo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
