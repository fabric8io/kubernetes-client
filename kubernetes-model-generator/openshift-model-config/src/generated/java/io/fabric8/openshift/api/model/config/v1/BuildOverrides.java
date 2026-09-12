
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "forcePull",
    "imageLabels",
    "nodeSelector",
    "tolerations"
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
public class BuildOverrides implements Editable<BuildOverridesBuilder>, KubernetesResource
{

    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLabel> imageLabels = new ArrayList<>();
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildOverrides() {
    }

    public BuildOverrides(Boolean forcePull, List<ImageLabel> imageLabels, Map<String, String> nodeSelector, List<Toleration> tolerations) {
        super();
        this.forcePull = forcePull;
        this.imageLabels = imageLabels;
        this.nodeSelector = nodeSelector;
        this.tolerations = tolerations;
    }

    /**
     * forcePull overrides, if set, the equivalent value in the builds, i.e. false disables force pull for all builds, true enables force pull for all builds, independently of what each build specifies itself
     */
    @JsonProperty("forcePull")
    public Boolean getForcePull() {
        return forcePull;
    }

    /**
     * forcePull overrides, if set, the equivalent value in the builds, i.e. false disables force pull for all builds, true enables force pull for all builds, independently of what each build specifies itself
     */
    @JsonProperty("forcePull")
    public void setForcePull(Boolean forcePull) {
        this.forcePull = forcePull;
    }

    /**
     * imageLabels is a list of docker labels that are applied to the resulting image. If user provided a label in their Build/BuildConfig with the same name as one in this list, the user's label will be overwritten.
     */
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageLabel> getImageLabels() {
        return imageLabels;
    }

    /**
     * imageLabels is a list of docker labels that are applied to the resulting image. If user provided a label in their Build/BuildConfig with the same name as one in this list, the user's label will be overwritten.
     */
    @JsonProperty("imageLabels")
    public void setImageLabels(List<ImageLabel> imageLabels) {
        this.imageLabels = imageLabels;
    }

    /**
     * nodeSelector is a selector which must be true for the build pod to fit on a node
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * nodeSelector is a selector which must be true for the build pod to fit on a node
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * tolerations is a list of Tolerations that will override any existing tolerations set on a build pod.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations is a list of Tolerations that will override any existing tolerations set on a build pod.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public BuildOverridesBuilder edit() {
        return new BuildOverridesBuilder(this);
    }

    @JsonIgnore
    public BuildOverridesBuilder toBuilder() {
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
        if (!(o instanceof BuildOverrides)) {
            return false;
        }
        BuildOverrides other = (BuildOverrides) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$forcePull = this.getForcePull();
        Object other$forcePull = other.getForcePull();
        if (this$forcePull == null ? other$forcePull != null : !this$forcePull.equals(other$forcePull)) {
            return false;
        }
        Object this$imageLabels = this.getImageLabels();
        Object other$imageLabels = other.getImageLabels();
        if (this$imageLabels == null ? other$imageLabels != null : !this$imageLabels.equals(other$imageLabels)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
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
        return other instanceof BuildOverrides;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $forcePull = this.getForcePull();
        result = result * prime + ($forcePull == null ? 43 : $forcePull.hashCode());
        Object $imageLabels = this.getImageLabels();
        result = result * prime + ($imageLabels == null ? 43 : $imageLabels.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildOverrides(" + "forcePull=" + this.getForcePull() + ", imageLabels=" + this.getImageLabels() + ", nodeSelector=" + this.getNodeSelector() + ", tolerations=" + this.getTolerations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
