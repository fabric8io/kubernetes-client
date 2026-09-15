
package io.fabric8.chaosmesh.v1alpha1;

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
 * StressChaosSpec defines the desired state of StressChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerNames",
    "duration",
    "mode",
    "remoteCluster",
    "selector",
    "stressngStressors",
    "stressors",
    "value"
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
public class StressChaosSpec implements Editable<StressChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("stressngStressors")
    private String stressngStressors;
    @JsonProperty("stressors")
    private Stressors stressors;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StressChaosSpec() {
    }

    public StressChaosSpec(List<String> containerNames, String duration, String mode, String remoteCluster, PodSelectorSpec selector, String stressngStressors, Stressors stressors, String value) {
        super();
        this.containerNames = containerNames;
        this.duration = duration;
        this.mode = mode;
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.stressngStressors = stressngStressors;
        this.stressors = stressors;
        this.value = value;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
        this.containerNames = containerNames;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * StressChaosSpec defines the desired state of StressChaos
     */
    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    /**
     * StressChaosSpec defines the desired state of StressChaos
     */
    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    /**
     * StressngStressors defines plenty of stressors just like `Stressors` except that it's an experimental feature and more powerful. You can define stressors in `stress-ng` (see also `man stress-ng`) dialect, however not all of the supported stressors are well tested. It maybe retired in later releases. You should always use `Stressors` to define the stressors and use this only when you want more stressors unsupported by `Stressors`. When both `StressngStressors` and `Stressors` are defined, `StressngStressors` wins.
     */
    @JsonProperty("stressngStressors")
    public String getStressngStressors() {
        return stressngStressors;
    }

    /**
     * StressngStressors defines plenty of stressors just like `Stressors` except that it's an experimental feature and more powerful. You can define stressors in `stress-ng` (see also `man stress-ng`) dialect, however not all of the supported stressors are well tested. It maybe retired in later releases. You should always use `Stressors` to define the stressors and use this only when you want more stressors unsupported by `Stressors`. When both `StressngStressors` and `Stressors` are defined, `StressngStressors` wins.
     */
    @JsonProperty("stressngStressors")
    public void setStressngStressors(String stressngStressors) {
        this.stressngStressors = stressngStressors;
    }

    /**
     * StressChaosSpec defines the desired state of StressChaos
     */
    @JsonProperty("stressors")
    public Stressors getStressors() {
        return stressors;
    }

    /**
     * StressChaosSpec defines the desired state of StressChaos
     */
    @JsonProperty("stressors")
    public void setStressors(Stressors stressors) {
        this.stressors = stressors;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public StressChaosSpecBuilder edit() {
        return new StressChaosSpecBuilder(this);
    }

    @JsonIgnore
    public StressChaosSpecBuilder toBuilder() {
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
        if (!(o instanceof StressChaosSpec)) {
            return false;
        }
        StressChaosSpec other = (StressChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerNames = this.getContainerNames();
        Object other$containerNames = other.getContainerNames();
        if (this$containerNames == null ? other$containerNames != null : !this$containerNames.equals(other$containerNames)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$stressngStressors = this.getStressngStressors();
        Object other$stressngStressors = other.getStressngStressors();
        if (this$stressngStressors == null ? other$stressngStressors != null : !this$stressngStressors.equals(other$stressngStressors)) {
            return false;
        }
        Object this$stressors = this.getStressors();
        Object other$stressors = other.getStressors();
        if (this$stressors == null ? other$stressors != null : !this$stressors.equals(other$stressors)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof StressChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerNames = this.getContainerNames();
        result = result * prime + ($containerNames == null ? 43 : $containerNames.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $stressngStressors = this.getStressngStressors();
        result = result * prime + ($stressngStressors == null ? 43 : $stressngStressors.hashCode());
        Object $stressors = this.getStressors();
        result = result * prime + ($stressors == null ? 43 : $stressors.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StressChaosSpec(" + "containerNames=" + this.getContainerNames() + ", duration=" + this.getDuration() + ", mode=" + this.getMode() + ", remoteCluster=" + this.getRemoteCluster() + ", selector=" + this.getSelector() + ", stressngStressors=" + this.getStressngStressors() + ", stressors=" + this.getStressors() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
