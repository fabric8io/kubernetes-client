
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
 * MachineManager describes a target machine resource that is registered for boot image updates. It stores identifying information such as the resource type and the API Group of the resource. It also provides granular control via the selection field.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiGroup",
    "resource",
    "selection"
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
public class MachineManager implements Editable<MachineManagerBuilder>, KubernetesResource
{

    @JsonProperty("apiGroup")
    private String apiGroup;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("selection")
    private MachineManagerSelector selection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineManager() {
    }

    public MachineManager(String apiGroup, String resource, MachineManagerSelector selection) {
        super();
        this.apiGroup = apiGroup;
        this.resource = resource;
        this.selection = selection;
    }

    /**
     * apiGroup is name of the APIGroup that the machine management resource belongs to. The only current valid value is machine.openshift.io. machine.openshift.io means that the machine manager will only register resources that belong to OpenShift machine API group.
     */
    @JsonProperty("apiGroup")
    public String getApiGroup() {
        return apiGroup;
    }

    /**
     * apiGroup is name of the APIGroup that the machine management resource belongs to. The only current valid value is machine.openshift.io. machine.openshift.io means that the machine manager will only register resources that belong to OpenShift machine API group.
     */
    @JsonProperty("apiGroup")
    public void setApiGroup(String apiGroup) {
        this.apiGroup = apiGroup;
    }

    /**
     * resource is the machine management resource's type. The only current valid value is machinesets. machinesets means that the machine manager will only register resources of the kind MachineSet.
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * resource is the machine management resource's type. The only current valid value is machinesets. machinesets means that the machine manager will only register resources of the kind MachineSet.
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * MachineManager describes a target machine resource that is registered for boot image updates. It stores identifying information such as the resource type and the API Group of the resource. It also provides granular control via the selection field.
     */
    @JsonProperty("selection")
    public MachineManagerSelector getSelection() {
        return selection;
    }

    /**
     * MachineManager describes a target machine resource that is registered for boot image updates. It stores identifying information such as the resource type and the API Group of the resource. It also provides granular control via the selection field.
     */
    @JsonProperty("selection")
    public void setSelection(MachineManagerSelector selection) {
        this.selection = selection;
    }

    @JsonIgnore
    public MachineManagerBuilder edit() {
        return new MachineManagerBuilder(this);
    }

    @JsonIgnore
    public MachineManagerBuilder toBuilder() {
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
        if (!(o instanceof MachineManager)) {
            return false;
        }
        MachineManager other = (MachineManager) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiGroup = this.getApiGroup();
        Object other$apiGroup = other.getApiGroup();
        if (this$apiGroup == null ? other$apiGroup != null : !this$apiGroup.equals(other$apiGroup)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
            return false;
        }
        Object this$selection = this.getSelection();
        Object other$selection = other.getSelection();
        if (this$selection == null ? other$selection != null : !this$selection.equals(other$selection)) {
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
        return other instanceof MachineManager;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiGroup = this.getApiGroup();
        result = result * prime + ($apiGroup == null ? 43 : $apiGroup.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $selection = this.getSelection();
        result = result * prime + ($selection == null ? 43 : $selection.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineManager(" + "apiGroup=" + this.getApiGroup() + ", resource=" + this.getResource() + ", selection=" + this.getSelection() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
