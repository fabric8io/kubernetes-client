
package io.fabric8.istio.api.api.meta.v1alpha1;

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
import io.fabric8.istio.api.api.analysis.v1alpha1.AnalysisMessageBase;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "observedGeneration",
    "validationMessages"
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
public class IstioStatus implements Editable<IstioStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IstioCondition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("validationMessages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AnalysisMessageBase> validationMessages = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IstioStatus() {
    }

    public IstioStatus(List<IstioCondition> conditions, Long observedGeneration, List<AnalysisMessageBase> validationMessages) {
        super();
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.validationMessages = validationMessages;
    }

    /**
     * Current service state of the resource.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IstioCondition> getConditions() {
        return conditions;
    }

    /**
     * Current service state of the resource.
     */
    @JsonProperty("conditions")
    public void setConditions(List<IstioCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * $hide_from_docs Deprecated. IstioCondition observed_generation will show the resource generation for which the condition was generated. Resource Generation to which the Reconciled Condition refers. When this value is not equal to the object's metadata generation, reconciled condition  calculation for the current generation is still in progress.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * $hide_from_docs Deprecated. IstioCondition observed_generation will show the resource generation for which the condition was generated. Resource Generation to which the Reconciled Condition refers. When this value is not equal to the object's metadata generation, reconciled condition  calculation for the current generation is still in progress.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Includes any errors or warnings detected by Istio's analyzers.
     */
    @JsonProperty("validationMessages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AnalysisMessageBase> getValidationMessages() {
        return validationMessages;
    }

    /**
     * Includes any errors or warnings detected by Istio's analyzers.
     */
    @JsonProperty("validationMessages")
    public void setValidationMessages(List<AnalysisMessageBase> validationMessages) {
        this.validationMessages = validationMessages;
    }

    @JsonIgnore
    public IstioStatusBuilder edit() {
        return new IstioStatusBuilder(this);
    }

    @JsonIgnore
    public IstioStatusBuilder toBuilder() {
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
        if (!(o instanceof IstioStatus)) {
            return false;
        }
        IstioStatus other = (IstioStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$validationMessages = this.getValidationMessages();
        Object other$validationMessages = other.getValidationMessages();
        if (this$validationMessages == null ? other$validationMessages != null : !this$validationMessages.equals(other$validationMessages)) {
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
        return other instanceof IstioStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $validationMessages = this.getValidationMessages();
        result = result * prime + ($validationMessages == null ? 43 : $validationMessages.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IstioStatus(" + "conditions=" + this.getConditions() + ", observedGeneration=" + this.getObservedGeneration() + ", validationMessages=" + this.getValidationMessages() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
