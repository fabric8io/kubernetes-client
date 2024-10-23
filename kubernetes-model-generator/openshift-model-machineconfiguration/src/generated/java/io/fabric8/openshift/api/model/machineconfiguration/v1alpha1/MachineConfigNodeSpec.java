
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configVersion",
    "node",
    "pinnedImageSets",
    "pool"
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
@Generated("jsonschema2pojo")
public class MachineConfigNodeSpec implements Editable<MachineConfigNodeSpecBuilder> , KubernetesResource
{

    @JsonProperty("configVersion")
    private MachineConfigNodeSpecMachineConfigVersion configVersion;
    @JsonProperty("node")
    private MCOObjectReference node;
    @JsonProperty("pinnedImageSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineConfigNodeSpecPinnedImageSet> pinnedImageSets = new ArrayList<>();
    @JsonProperty("pool")
    private MCOObjectReference pool;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineConfigNodeSpec() {
    }

    public MachineConfigNodeSpec(MachineConfigNodeSpecMachineConfigVersion configVersion, MCOObjectReference node, List<MachineConfigNodeSpecPinnedImageSet> pinnedImageSets, MCOObjectReference pool) {
        super();
        this.configVersion = configVersion;
        this.node = node;
        this.pinnedImageSets = pinnedImageSets;
        this.pool = pool;
    }

    @JsonProperty("configVersion")
    public MachineConfigNodeSpecMachineConfigVersion getConfigVersion() {
        return configVersion;
    }

    @JsonProperty("configVersion")
    public void setConfigVersion(MachineConfigNodeSpecMachineConfigVersion configVersion) {
        this.configVersion = configVersion;
    }

    @JsonProperty("node")
    public MCOObjectReference getNode() {
        return node;
    }

    @JsonProperty("node")
    public void setNode(MCOObjectReference node) {
        this.node = node;
    }

    @JsonProperty("pinnedImageSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineConfigNodeSpecPinnedImageSet> getPinnedImageSets() {
        return pinnedImageSets;
    }

    @JsonProperty("pinnedImageSets")
    public void setPinnedImageSets(List<MachineConfigNodeSpecPinnedImageSet> pinnedImageSets) {
        this.pinnedImageSets = pinnedImageSets;
    }

    @JsonProperty("pool")
    public MCOObjectReference getPool() {
        return pool;
    }

    @JsonProperty("pool")
    public void setPool(MCOObjectReference pool) {
        this.pool = pool;
    }

    @JsonIgnore
    public MachineConfigNodeSpecBuilder edit() {
        return new MachineConfigNodeSpecBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeSpecBuilder toBuilder() {
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
