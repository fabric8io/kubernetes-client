
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
