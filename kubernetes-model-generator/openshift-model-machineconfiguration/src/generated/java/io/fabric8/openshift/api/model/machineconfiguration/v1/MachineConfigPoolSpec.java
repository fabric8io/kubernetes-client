
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
