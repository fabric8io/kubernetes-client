
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * VSphereCSIDriverConfigSpec defines properties that can be configured for vsphere CSI driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "globalMaxSnapshotsPerBlockVolume",
    "granularMaxSnapshotsPerBlockVolumeInVSAN",
    "granularMaxSnapshotsPerBlockVolumeInVVOL",
    "maxAllowedBlockVolumesPerNode",
    "topologyCategories"
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
public class VSphereCSIDriverConfigSpec implements Editable<VSphereCSIDriverConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    private Long globalMaxSnapshotsPerBlockVolume;
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    private Long granularMaxSnapshotsPerBlockVolumeInVSAN;
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    private Long granularMaxSnapshotsPerBlockVolumeInVVOL;
    @JsonProperty("maxAllowedBlockVolumesPerNode")
    private Integer maxAllowedBlockVolumesPerNode;
    @JsonProperty("topologyCategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> topologyCategories = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSphereCSIDriverConfigSpec() {
    }

    public VSphereCSIDriverConfigSpec(Long globalMaxSnapshotsPerBlockVolume, Long granularMaxSnapshotsPerBlockVolumeInVSAN, Long granularMaxSnapshotsPerBlockVolumeInVVOL, Integer maxAllowedBlockVolumesPerNode, List<String> topologyCategories) {
        super();
        this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
        this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
        this.granularMaxSnapshotsPerBlockVolumeInVVOL = granularMaxSnapshotsPerBlockVolumeInVVOL;
        this.maxAllowedBlockVolumesPerNode = maxAllowedBlockVolumesPerNode;
        this.topologyCategories = topologyCategories;
    }

    /**
     * globalMaxSnapshotsPerBlockVolume is a global configuration parameter that applies to volumes on all kinds of datastores. If omitted, the platform chooses a default, which is subject to change over time, currently that default is 3. Snapshots can not be disabled using this parameter. Increasing number of snapshots above 3 can have negative impact on performance, for more details see: https://kb.vmware.com/s/article/1025279 Volume snapshot documentation: https://docs.vmware.com/en/VMware-vSphere-Container-Storage-Plug-in/3.0/vmware-vsphere-csp-getting-started/GUID-E0B41C69-7EEB-450F-A73D-5FD2FF39E891.html
     */
    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    public Long getGlobalMaxSnapshotsPerBlockVolume() {
        return globalMaxSnapshotsPerBlockVolume;
    }

    /**
     * globalMaxSnapshotsPerBlockVolume is a global configuration parameter that applies to volumes on all kinds of datastores. If omitted, the platform chooses a default, which is subject to change over time, currently that default is 3. Snapshots can not be disabled using this parameter. Increasing number of snapshots above 3 can have negative impact on performance, for more details see: https://kb.vmware.com/s/article/1025279 Volume snapshot documentation: https://docs.vmware.com/en/VMware-vSphere-Container-Storage-Plug-in/3.0/vmware-vsphere-csp-getting-started/GUID-E0B41C69-7EEB-450F-A73D-5FD2FF39E891.html
     */
    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    public void setGlobalMaxSnapshotsPerBlockVolume(Long globalMaxSnapshotsPerBlockVolume) {
        this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
    }

    /**
     * granularMaxSnapshotsPerBlockVolumeInVSAN is a granular configuration parameter on vSAN datastore only. It overrides GlobalMaxSnapshotsPerBlockVolume if set, while it falls back to the global constraint if unset. Snapshots for VSAN can not be disabled using this parameter.
     */
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    public Long getGranularMaxSnapshotsPerBlockVolumeInVSAN() {
        return granularMaxSnapshotsPerBlockVolumeInVSAN;
    }

    /**
     * granularMaxSnapshotsPerBlockVolumeInVSAN is a granular configuration parameter on vSAN datastore only. It overrides GlobalMaxSnapshotsPerBlockVolume if set, while it falls back to the global constraint if unset. Snapshots for VSAN can not be disabled using this parameter.
     */
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    public void setGranularMaxSnapshotsPerBlockVolumeInVSAN(Long granularMaxSnapshotsPerBlockVolumeInVSAN) {
        this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
    }

    /**
     * granularMaxSnapshotsPerBlockVolumeInVVOL is a granular configuration parameter on Virtual Volumes datastore only. It overrides GlobalMaxSnapshotsPerBlockVolume if set, while it falls back to the global constraint if unset. Snapshots for VVOL can not be disabled using this parameter.
     */
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    public Long getGranularMaxSnapshotsPerBlockVolumeInVVOL() {
        return granularMaxSnapshotsPerBlockVolumeInVVOL;
    }

    /**
     * granularMaxSnapshotsPerBlockVolumeInVVOL is a granular configuration parameter on Virtual Volumes datastore only. It overrides GlobalMaxSnapshotsPerBlockVolume if set, while it falls back to the global constraint if unset. Snapshots for VVOL can not be disabled using this parameter.
     */
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    public void setGranularMaxSnapshotsPerBlockVolumeInVVOL(Long granularMaxSnapshotsPerBlockVolumeInVVOL) {
        this.granularMaxSnapshotsPerBlockVolumeInVVOL = granularMaxSnapshotsPerBlockVolumeInVVOL;
    }

    /**
     * maxAllowedBlockVolumesPerNode is an optional configuration parameter that allows setting a custom value for the limit of the number of PersistentVolumes attached to a node. In vSphere version 7 this limit was set to 59 by default, however in vSphere version 8 this limit was increased to 255. Before increasing this value above 59 the cluster administrator needs to ensure that every node forming the cluster is updated to ESXi version 8 or higher and that all nodes are running the same version. The limit must be between 1 and 255, which matches the vSphere version 8 maximum. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 59, which matches the limit for vSphere version 7.
     */
    @JsonProperty("maxAllowedBlockVolumesPerNode")
    public Integer getMaxAllowedBlockVolumesPerNode() {
        return maxAllowedBlockVolumesPerNode;
    }

    /**
     * maxAllowedBlockVolumesPerNode is an optional configuration parameter that allows setting a custom value for the limit of the number of PersistentVolumes attached to a node. In vSphere version 7 this limit was set to 59 by default, however in vSphere version 8 this limit was increased to 255. Before increasing this value above 59 the cluster administrator needs to ensure that every node forming the cluster is updated to ESXi version 8 or higher and that all nodes are running the same version. The limit must be between 1 and 255, which matches the vSphere version 8 maximum. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 59, which matches the limit for vSphere version 7.
     */
    @JsonProperty("maxAllowedBlockVolumesPerNode")
    public void setMaxAllowedBlockVolumesPerNode(Integer maxAllowedBlockVolumesPerNode) {
        this.maxAllowedBlockVolumesPerNode = maxAllowedBlockVolumesPerNode;
    }

    /**
     * topologyCategories indicates tag categories with which vcenter resources such as hostcluster or datacenter were tagged with. If cluster Infrastructure object has a topology, values specified in Infrastructure object will be used and modifications to topologyCategories will be rejected.
     */
    @JsonProperty("topologyCategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTopologyCategories() {
        return topologyCategories;
    }

    /**
     * topologyCategories indicates tag categories with which vcenter resources such as hostcluster or datacenter were tagged with. If cluster Infrastructure object has a topology, values specified in Infrastructure object will be used and modifications to topologyCategories will be rejected.
     */
    @JsonProperty("topologyCategories")
    public void setTopologyCategories(List<String> topologyCategories) {
        this.topologyCategories = topologyCategories;
    }

    @JsonIgnore
    public VSphereCSIDriverConfigSpecBuilder edit() {
        return new VSphereCSIDriverConfigSpecBuilder(this);
    }

    @JsonIgnore
    public VSphereCSIDriverConfigSpecBuilder toBuilder() {
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
