
package io.fabric8.openshift.api.model.machineconfig.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "configuration",
    "machineConfigSelector",
    "maxUnavailable",
    "nodeSelector",
    "paused"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineConfigPoolSpec implements KubernetesResource
{

    @JsonProperty("configuration")
    private MachineConfigPoolStatusConfiguration configuration;
    @JsonProperty("machineConfigSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector machineConfigSelector;
    @JsonProperty("maxUnavailable")
    private io.fabric8.kubernetes.api.model.IntOrString maxUnavailable;
    @JsonProperty("nodeSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector nodeSelector;
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

    public MachineConfigPoolSpec(MachineConfigPoolStatusConfiguration configuration, io.fabric8.kubernetes.api.model.LabelSelector machineConfigSelector, io.fabric8.kubernetes.api.model.IntOrString maxUnavailable, io.fabric8.kubernetes.api.model.LabelSelector nodeSelector, Boolean paused) {
        super();
        this.configuration = configuration;
        this.machineConfigSelector = machineConfigSelector;
        this.maxUnavailable = maxUnavailable;
        this.nodeSelector = nodeSelector;
        this.paused = paused;
    }

    @JsonProperty("configuration")
    public MachineConfigPoolStatusConfiguration getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(MachineConfigPoolStatusConfiguration configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("machineConfigSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getMachineConfigSelector() {
        return machineConfigSelector;
    }

    @JsonProperty("machineConfigSelector")
    public void setMachineConfigSelector(io.fabric8.kubernetes.api.model.LabelSelector machineConfigSelector) {
        this.machineConfigSelector = machineConfigSelector;
    }

    @JsonProperty("maxUnavailable")
    public io.fabric8.kubernetes.api.model.IntOrString getMaxUnavailable() {
        return maxUnavailable;
    }

    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(io.fabric8.kubernetes.api.model.IntOrString maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    @JsonProperty("nodeSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(io.fabric8.kubernetes.api.model.LabelSelector nodeSelector) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
