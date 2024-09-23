
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configuration",
    "machineConfigSelector",
    "maxUnavailable",
    "nodeSelector",
    "paused"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineConfigPoolSpec implements Editable<MachineConfigPoolSpecBuilder> , KubernetesResource
{

    @JsonProperty("configuration")
    private MachineConfigPoolSpecConfiguration configuration;
    @JsonProperty("machineConfigSelector")
    private MachineConfigPoolSpecMachineConfigSelector machineConfigSelector;
    @JsonProperty("maxUnavailable")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object maxUnavailable;
    @JsonProperty("nodeSelector")
    private MachineConfigPoolSpecNodeSelector nodeSelector;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineConfigPoolSpec() {
    }

    public MachineConfigPoolSpec(MachineConfigPoolSpecConfiguration configuration, MachineConfigPoolSpecMachineConfigSelector machineConfigSelector, Object maxUnavailable, MachineConfigPoolSpecNodeSelector nodeSelector, Boolean paused) {
        super();
        this.configuration = configuration;
        this.machineConfigSelector = machineConfigSelector;
        this.maxUnavailable = maxUnavailable;
        this.nodeSelector = nodeSelector;
        this.paused = paused;
    }

    @JsonProperty("configuration")
    public MachineConfigPoolSpecConfiguration getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(MachineConfigPoolSpecConfiguration configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("machineConfigSelector")
    public MachineConfigPoolSpecMachineConfigSelector getMachineConfigSelector() {
        return machineConfigSelector;
    }

    @JsonProperty("machineConfigSelector")
    public void setMachineConfigSelector(MachineConfigPoolSpecMachineConfigSelector machineConfigSelector) {
        this.machineConfigSelector = machineConfigSelector;
    }

    @JsonProperty("maxUnavailable")
    public Object getMaxUnavailable() {
        return maxUnavailable;
    }

    @JsonProperty("maxUnavailable")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setMaxUnavailable(Object maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    @JsonProperty("nodeSelector")
    public MachineConfigPoolSpecNodeSelector getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(MachineConfigPoolSpecNodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
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
