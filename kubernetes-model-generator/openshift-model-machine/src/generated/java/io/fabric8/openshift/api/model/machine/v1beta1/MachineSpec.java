
package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class MachineSpec implements Editable<MachineSpecBuilder> , KubernetesResource
{

    @JsonProperty("lifecycleHooks")
    private MachineSpecLifecycleHooks lifecycleHooks;
    @JsonProperty("metadata")
    private MachineSpecMetadata metadata;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("providerSpec")
    private MachineSpecProviderSpec providerSpec;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineSpecTaints> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineSpec() {
    }

    public MachineSpec(MachineSpecLifecycleHooks lifecycleHooks, MachineSpecMetadata metadata, String providerID, MachineSpecProviderSpec providerSpec, List<MachineSpecTaints> taints) {
        super();
        this.lifecycleHooks = lifecycleHooks;
        this.metadata = metadata;
        this.providerID = providerID;
        this.providerSpec = providerSpec;
        this.taints = taints;
    }

    @JsonProperty("lifecycleHooks")
    public MachineSpecLifecycleHooks getLifecycleHooks() {
        return lifecycleHooks;
    }

    @JsonProperty("lifecycleHooks")
    public void setLifecycleHooks(MachineSpecLifecycleHooks lifecycleHooks) {
        this.lifecycleHooks = lifecycleHooks;
    }

    @JsonProperty("metadata")
    public MachineSpecMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(MachineSpecMetadata metadata) {
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
    public MachineSpecProviderSpec getProviderSpec() {
        return providerSpec;
    }

    @JsonProperty("providerSpec")
    public void setProviderSpec(MachineSpecProviderSpec providerSpec) {
        this.providerSpec = providerSpec;
    }

    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineSpecTaints> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<MachineSpecTaints> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public MachineSpecBuilder edit() {
        return new MachineSpecBuilder(this);
    }

    @JsonIgnore
    public MachineSpecBuilder toBuilder() {
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
