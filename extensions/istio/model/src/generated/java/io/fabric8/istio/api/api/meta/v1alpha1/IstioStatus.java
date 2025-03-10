
package io.fabric8.istio.api.api.meta.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "observedGeneration",
    "validationMessages"
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
     * Current service state of the resource. More info: https://istio.io/docs/reference/config/config-status/
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IstioCondition> getConditions() {
        return conditions;
    }

    /**
     * Current service state of the resource. More info: https://istio.io/docs/reference/config/config-status/
     */
    @JsonProperty("conditions")
    public void setConditions(List<IstioCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * $hide_from_docs Deprecated. IstioCondition observed_generation will show the resource generation for which the condition was generated. Resource Generation to which the Reconciled Condition refers. When this value is not equal to the object's metadata generation, reconciled condition  calculation for the current generation is still in progress.  See https://istio.io/latest/docs/reference/config/config-status/ for more info.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * $hide_from_docs Deprecated. IstioCondition observed_generation will show the resource generation for which the condition was generated. Resource Generation to which the Reconciled Condition refers. When this value is not equal to the object's metadata generation, reconciled condition  calculation for the current generation is still in progress.  See https://istio.io/latest/docs/reference/config/config-status/ for more info.
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
