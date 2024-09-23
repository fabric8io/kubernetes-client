
package io.fabric8.openshift.api.model.machine.v1;

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
    "metadata",
    "lifecycleHooks",
    "providerID",
    "providerSpec",
    "taints"
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
public class ControlPlaneMachineSetSpecTMSpec implements Editable<ControlPlaneMachineSetSpecTMSpecBuilder> , KubernetesResource
{

    @JsonProperty("lifecycleHooks")
    private ControlPlaneMachineSetSpecTMSpecLifecycleHooks lifecycleHooks;
    @JsonProperty("metadata")
    private ControlPlaneMachineSetSpecTMSpecMetadata metadata;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("providerSpec")
    private ControlPlaneMachineSetSpecTMSpecProviderSpec providerSpec;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMSpecTaints> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ControlPlaneMachineSetSpecTMSpec() {
    }

    public ControlPlaneMachineSetSpecTMSpec(ControlPlaneMachineSetSpecTMSpecLifecycleHooks lifecycleHooks, ControlPlaneMachineSetSpecTMSpecMetadata metadata, String providerID, ControlPlaneMachineSetSpecTMSpecProviderSpec providerSpec, List<ControlPlaneMachineSetSpecTMSpecTaints> taints) {
        super();
        this.lifecycleHooks = lifecycleHooks;
        this.metadata = metadata;
        this.providerID = providerID;
        this.providerSpec = providerSpec;
        this.taints = taints;
    }

    @JsonProperty("lifecycleHooks")
    public ControlPlaneMachineSetSpecTMSpecLifecycleHooks getLifecycleHooks() {
        return lifecycleHooks;
    }

    @JsonProperty("lifecycleHooks")
    public void setLifecycleHooks(ControlPlaneMachineSetSpecTMSpecLifecycleHooks lifecycleHooks) {
        this.lifecycleHooks = lifecycleHooks;
    }

    @JsonProperty("metadata")
    public ControlPlaneMachineSetSpecTMSpecMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ControlPlaneMachineSetSpecTMSpecMetadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    @JsonProperty("providerSpec")
    public ControlPlaneMachineSetSpecTMSpecProviderSpec getProviderSpec() {
        return providerSpec;
    }

    @JsonProperty("providerSpec")
    public void setProviderSpec(ControlPlaneMachineSetSpecTMSpecProviderSpec providerSpec) {
        this.providerSpec = providerSpec;
    }

    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMSpecTaints> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<ControlPlaneMachineSetSpecTMSpecTaints> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecTMSpecBuilder edit() {
        return new ControlPlaneMachineSetSpecTMSpecBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecTMSpecBuilder toBuilder() {
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
