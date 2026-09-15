
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configuration",
    "machineConfigSelector",
    "maxUnavailable",
    "nodeSelector",
    "paused",
    "pinnedImageSets"
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
public class MachineConfigPoolSpec implements Editable<MachineConfigPoolSpecBuilder>, KubernetesResource
{

    @JsonProperty("configuration")
    private MachineConfigPoolStatusConfiguration configuration;
    @JsonProperty("machineConfigSelector")
    private LabelSelector machineConfigSelector;
    @JsonProperty("maxUnavailable")
    private IntOrString maxUnavailable;
    @JsonProperty("nodeSelector")
    private LabelSelector nodeSelector;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("pinnedImageSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PinnedImageSetRef> pinnedImageSets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigPoolSpec() {
    }

    public MachineConfigPoolSpec(MachineConfigPoolStatusConfiguration configuration, LabelSelector machineConfigSelector, IntOrString maxUnavailable, LabelSelector nodeSelector, Boolean paused, List<PinnedImageSetRef> pinnedImageSets) {
        super();
        this.configuration = configuration;
        this.machineConfigSelector = machineConfigSelector;
        this.maxUnavailable = maxUnavailable;
        this.nodeSelector = nodeSelector;
        this.paused = paused;
        this.pinnedImageSets = pinnedImageSets;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("configuration")
    public MachineConfigPoolStatusConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("configuration")
    public void setConfiguration(MachineConfigPoolStatusConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("machineConfigSelector")
    public LabelSelector getMachineConfigSelector() {
        return machineConfigSelector;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("machineConfigSelector")
    public void setMachineConfigSelector(LabelSelector machineConfigSelector) {
        this.machineConfigSelector = machineConfigSelector;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("maxUnavailable")
    public IntOrString getMaxUnavailable() {
        return maxUnavailable;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(IntOrString maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("nodeSelector")
    public LabelSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(LabelSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * paused specifies whether or not changes to this machine config pool should be stopped. This includes generating new desiredMachineConfig and update of machines.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused specifies whether or not changes to this machine config pool should be stopped. This includes generating new desiredMachineConfig and update of machines.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * pinnedImageSets specifies a sequence of PinnedImageSetRef objects for the pool. Nodes within this pool will preload and pin images defined in the PinnedImageSet. Before pulling images the MachineConfigDaemon will ensure the total uncompressed size of all the images does not exceed available resources. If the total size of the images exceeds the available resources the controller will report a Degraded status to the MachineConfigPool and not attempt to pull any images. Also to help ensure the kubelet can mitigate storage risk, the pinned_image configuration and subsequent service reload will happen only after all of the images have been pulled for each set. Images from multiple PinnedImageSets are loaded and pinned sequentially as listed. Duplicate and existing images will be skipped.<br><p> <br><p> Any failure to prefetch or pin images will result in a Degraded pool. Resolving these failures is the responsibility of the user. The admin should be proactive in ensuring adequate storage and proper image authentication exists in advance.
     */
    @JsonProperty("pinnedImageSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PinnedImageSetRef> getPinnedImageSets() {
        return pinnedImageSets;
    }

    /**
     * pinnedImageSets specifies a sequence of PinnedImageSetRef objects for the pool. Nodes within this pool will preload and pin images defined in the PinnedImageSet. Before pulling images the MachineConfigDaemon will ensure the total uncompressed size of all the images does not exceed available resources. If the total size of the images exceeds the available resources the controller will report a Degraded status to the MachineConfigPool and not attempt to pull any images. Also to help ensure the kubelet can mitigate storage risk, the pinned_image configuration and subsequent service reload will happen only after all of the images have been pulled for each set. Images from multiple PinnedImageSets are loaded and pinned sequentially as listed. Duplicate and existing images will be skipped.<br><p> <br><p> Any failure to prefetch or pin images will result in a Degraded pool. Resolving these failures is the responsibility of the user. The admin should be proactive in ensuring adequate storage and proper image authentication exists in advance.
     */
    @JsonProperty("pinnedImageSets")
    public void setPinnedImageSets(List<PinnedImageSetRef> pinnedImageSets) {
        this.pinnedImageSets = pinnedImageSets;
    }

    @JsonIgnore
    public MachineConfigPoolSpecBuilder edit() {
        return new MachineConfigPoolSpecBuilder(this);
    }

    @JsonIgnore
    public MachineConfigPoolSpecBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigPoolSpec)) {
            return false;
        }
        MachineConfigPoolSpec other = (MachineConfigPoolSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configuration = this.getConfiguration();
        Object other$configuration = other.getConfiguration();
        if (this$configuration == null ? other$configuration != null : !this$configuration.equals(other$configuration)) {
            return false;
        }
        Object this$machineConfigSelector = this.getMachineConfigSelector();
        Object other$machineConfigSelector = other.getMachineConfigSelector();
        if (this$machineConfigSelector == null ? other$machineConfigSelector != null : !this$machineConfigSelector.equals(other$machineConfigSelector)) {
            return false;
        }
        Object this$maxUnavailable = this.getMaxUnavailable();
        Object other$maxUnavailable = other.getMaxUnavailable();
        if (this$maxUnavailable == null ? other$maxUnavailable != null : !this$maxUnavailable.equals(other$maxUnavailable)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$paused = this.getPaused();
        Object other$paused = other.getPaused();
        if (this$paused == null ? other$paused != null : !this$paused.equals(other$paused)) {
            return false;
        }
        Object this$pinnedImageSets = this.getPinnedImageSets();
        Object other$pinnedImageSets = other.getPinnedImageSets();
        if (this$pinnedImageSets == null ? other$pinnedImageSets != null : !this$pinnedImageSets.equals(other$pinnedImageSets)) {
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
        return other instanceof MachineConfigPoolSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configuration = this.getConfiguration();
        result = result * prime + ($configuration == null ? 43 : $configuration.hashCode());
        Object $machineConfigSelector = this.getMachineConfigSelector();
        result = result * prime + ($machineConfigSelector == null ? 43 : $machineConfigSelector.hashCode());
        Object $maxUnavailable = this.getMaxUnavailable();
        result = result * prime + ($maxUnavailable == null ? 43 : $maxUnavailable.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $paused = this.getPaused();
        result = result * prime + ($paused == null ? 43 : $paused.hashCode());
        Object $pinnedImageSets = this.getPinnedImageSets();
        result = result * prime + ($pinnedImageSets == null ? 43 : $pinnedImageSets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigPoolSpec(" + "configuration=" + this.getConfiguration() + ", machineConfigSelector=" + this.getMachineConfigSelector() + ", maxUnavailable=" + this.getMaxUnavailable() + ", nodeSelector=" + this.getNodeSelector() + ", paused=" + this.getPaused() + ", pinnedImageSets=" + this.getPinnedImageSets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
