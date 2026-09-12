
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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

/**
 * WorkloadSpec defines the desired state of a Workload.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compositePodGroupTemplates",
    "controllerRef",
    "podGroupTemplates"
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
public class WorkloadSpec implements Editable<WorkloadSpecBuilder>, KubernetesResource
{

    @JsonProperty("compositePodGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CompositePodGroupTemplate> compositePodGroupTemplates = new ArrayList<>();
    @JsonProperty("controllerRef")
    private TypedLocalObjectReference controllerRef;
    @JsonProperty("podGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodGroupTemplate> podGroupTemplates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkloadSpec() {
    }

    public WorkloadSpec(List<CompositePodGroupTemplate> compositePodGroupTemplates, TypedLocalObjectReference controllerRef, List<PodGroupTemplate> podGroupTemplates) {
        super();
        this.compositePodGroupTemplates = compositePodGroupTemplates;
        this.controllerRef = controllerRef;
        this.podGroupTemplates = podGroupTemplates;
    }

    /**
     * compositePodGroupTemplates is the list of CompositePodGroup templates that make up the Workload. The maximum number of templates is 8. This field is immutable. Exactly one of CompositePodGroupTemplates and PodGroupTemplates must be set.<br><p> <br><p> This field is used only when the CompositePodGroup feature gate is enabled.
     */
    @JsonProperty("compositePodGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CompositePodGroupTemplate> getCompositePodGroupTemplates() {
        return compositePodGroupTemplates;
    }

    /**
     * compositePodGroupTemplates is the list of CompositePodGroup templates that make up the Workload. The maximum number of templates is 8. This field is immutable. Exactly one of CompositePodGroupTemplates and PodGroupTemplates must be set.<br><p> <br><p> This field is used only when the CompositePodGroup feature gate is enabled.
     */
    @JsonProperty("compositePodGroupTemplates")
    public void setCompositePodGroupTemplates(List<CompositePodGroupTemplate> compositePodGroupTemplates) {
        this.compositePodGroupTemplates = compositePodGroupTemplates;
    }

    /**
     * WorkloadSpec defines the desired state of a Workload.
     */
    @JsonProperty("controllerRef")
    public TypedLocalObjectReference getControllerRef() {
        return controllerRef;
    }

    /**
     * WorkloadSpec defines the desired state of a Workload.
     */
    @JsonProperty("controllerRef")
    public void setControllerRef(TypedLocalObjectReference controllerRef) {
        this.controllerRef = controllerRef;
    }

    /**
     * podGroupTemplates is the list of templates that make up the Workload. The maximum number of templates is 8. Templates cannot be added or removed after the workload is created. Existing templates may still be updated where their individual fields allow it. Exactly one of CompositePodGroupTemplates and PodGroupTemplates must be set.
     */
    @JsonProperty("podGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodGroupTemplate> getPodGroupTemplates() {
        return podGroupTemplates;
    }

    /**
     * podGroupTemplates is the list of templates that make up the Workload. The maximum number of templates is 8. Templates cannot be added or removed after the workload is created. Existing templates may still be updated where their individual fields allow it. Exactly one of CompositePodGroupTemplates and PodGroupTemplates must be set.
     */
    @JsonProperty("podGroupTemplates")
    public void setPodGroupTemplates(List<PodGroupTemplate> podGroupTemplates) {
        this.podGroupTemplates = podGroupTemplates;
    }

    @JsonIgnore
    public WorkloadSpecBuilder edit() {
        return new WorkloadSpecBuilder(this);
    }

    @JsonIgnore
    public WorkloadSpecBuilder toBuilder() {
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
        if (!(o instanceof WorkloadSpec)) {
            return false;
        }
        WorkloadSpec other = (WorkloadSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$compositePodGroupTemplates = this.getCompositePodGroupTemplates();
        Object other$compositePodGroupTemplates = other.getCompositePodGroupTemplates();
        if (this$compositePodGroupTemplates == null ? other$compositePodGroupTemplates != null : !this$compositePodGroupTemplates.equals(other$compositePodGroupTemplates)) {
            return false;
        }
        Object this$controllerRef = this.getControllerRef();
        Object other$controllerRef = other.getControllerRef();
        if (this$controllerRef == null ? other$controllerRef != null : !this$controllerRef.equals(other$controllerRef)) {
            return false;
        }
        Object this$podGroupTemplates = this.getPodGroupTemplates();
        Object other$podGroupTemplates = other.getPodGroupTemplates();
        if (this$podGroupTemplates == null ? other$podGroupTemplates != null : !this$podGroupTemplates.equals(other$podGroupTemplates)) {
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
        return other instanceof WorkloadSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compositePodGroupTemplates = this.getCompositePodGroupTemplates();
        result = result * prime + ($compositePodGroupTemplates == null ? 43 : $compositePodGroupTemplates.hashCode());
        Object $controllerRef = this.getControllerRef();
        result = result * prime + ($controllerRef == null ? 43 : $controllerRef.hashCode());
        Object $podGroupTemplates = this.getPodGroupTemplates();
        result = result * prime + ($podGroupTemplates == null ? 43 : $podGroupTemplates.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WorkloadSpec(" + "compositePodGroupTemplates=" + this.getCompositePodGroupTemplates() + ", controllerRef=" + this.getControllerRef() + ", podGroupTemplates=" + this.getPodGroupTemplates() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
