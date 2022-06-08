
package io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.GroupKind;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "addOwnerRef",
    "assemblyPhase",
    "componentKinds",
    "descriptor",
    "info",
    "selector"
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
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ApplicationSpec implements KubernetesResource
{

    @JsonProperty("addOwnerRef")
    private Boolean addOwnerRef;
    @JsonProperty("assemblyPhase")
    private String assemblyPhase;
    @JsonProperty("componentKinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GroupKind> componentKinds = new ArrayList<GroupKind>();
    @JsonProperty("descriptor")
    private Descriptor descriptor;
    @JsonProperty("info")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InfoItem> info = new ArrayList<InfoItem>();
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ApplicationSpec() {
    }

    /**
     * 
     * @param assemblyPhase
     * @param selector
     * @param descriptor
     * @param componentKinds
     * @param addOwnerRef
     * @param info
     */
    public ApplicationSpec(Boolean addOwnerRef, String assemblyPhase, List<GroupKind> componentKinds, Descriptor descriptor, List<InfoItem> info, io.fabric8.kubernetes.api.model.LabelSelector selector) {
        super();
        this.addOwnerRef = addOwnerRef;
        this.assemblyPhase = assemblyPhase;
        this.componentKinds = componentKinds;
        this.descriptor = descriptor;
        this.info = info;
        this.selector = selector;
    }

    @JsonProperty("addOwnerRef")
    public Boolean getAddOwnerRef() {
        return addOwnerRef;
    }

    @JsonProperty("addOwnerRef")
    public void setAddOwnerRef(Boolean addOwnerRef) {
        this.addOwnerRef = addOwnerRef;
    }

    @JsonProperty("assemblyPhase")
    public String getAssemblyPhase() {
        return assemblyPhase;
    }

    @JsonProperty("assemblyPhase")
    public void setAssemblyPhase(String assemblyPhase) {
        this.assemblyPhase = assemblyPhase;
    }

    @JsonProperty("componentKinds")
    public List<GroupKind> getComponentKinds() {
        return componentKinds;
    }

    @JsonProperty("componentKinds")
    public void setComponentKinds(List<GroupKind> componentKinds) {
        this.componentKinds = componentKinds;
    }

    @JsonProperty("descriptor")
    public Descriptor getDescriptor() {
        return descriptor;
    }

    @JsonProperty("descriptor")
    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    @JsonProperty("info")
    public List<InfoItem> getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(List<InfoItem> info) {
        this.info = info;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
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
