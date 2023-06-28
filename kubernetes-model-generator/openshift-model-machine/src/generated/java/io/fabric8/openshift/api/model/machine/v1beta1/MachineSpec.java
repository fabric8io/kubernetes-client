
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Taint;
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
    "lifecycleHooks",
    "providerID",
    "providerSpec",
    "taints"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineSpec implements KubernetesResource
{

    @JsonProperty("lifecycleHooks")
    private LifecycleHooks lifecycleHooks;
    @JsonProperty("metadata")
    private io.fabric8.openshift.api.model.machine.v1beta1.ObjectMeta metadata;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("providerSpec")
    private ProviderSpec providerSpec;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<Taint>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineSpec() {
    }

    public MachineSpec(LifecycleHooks lifecycleHooks, io.fabric8.openshift.api.model.machine.v1beta1.ObjectMeta metadata, String providerID, ProviderSpec providerSpec, List<Taint> taints) {
        super();
        this.lifecycleHooks = lifecycleHooks;
        this.metadata = metadata;
        this.providerID = providerID;
        this.providerSpec = providerSpec;
        this.taints = taints;
    }

    @JsonProperty("lifecycleHooks")
    public LifecycleHooks getLifecycleHooks() {
        return lifecycleHooks;
    }

    @JsonProperty("lifecycleHooks")
    public void setLifecycleHooks(LifecycleHooks lifecycleHooks) {
        this.lifecycleHooks = lifecycleHooks;
    }

    @JsonProperty("metadata")
    public io.fabric8.openshift.api.model.machine.v1beta1.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.openshift.api.model.machine.v1beta1.ObjectMeta metadata) {
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
    public ProviderSpec getProviderSpec() {
        return providerSpec;
    }

    @JsonProperty("providerSpec")
    public void setProviderSpec(ProviderSpec providerSpec) {
        this.providerSpec = providerSpec;
    }

    @JsonProperty("taints")
    public List<Taint> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
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
