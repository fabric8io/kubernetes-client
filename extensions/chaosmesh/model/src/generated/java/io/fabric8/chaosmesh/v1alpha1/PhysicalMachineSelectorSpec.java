
package io.fabric8.chaosmesh.v1alpha1;

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
    "annotationSelectors",
    "fieldSelectors",
    "labelSelectors",
    "namespaces",
    "physicalMachines"
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
public class PhysicalMachineSelectorSpec implements Editable<PhysicalMachineSelectorSpecBuilder> , KubernetesResource
{

    @JsonProperty("annotationSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotationSelectors = new LinkedHashMap<>();
    @JsonProperty("fieldSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> fieldSelectors = new LinkedHashMap<>();
    @JsonProperty("labelSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labelSelectors = new LinkedHashMap<>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<>();
    @JsonProperty("physicalMachines")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> physicalMachines = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PhysicalMachineSelectorSpec() {
    }

    public PhysicalMachineSelectorSpec(Map<String, String> annotationSelectors, Map<String, String> fieldSelectors, Map<String, String> labelSelectors, List<String> namespaces, Map<String, List<String>> physicalMachines) {
        super();
        this.annotationSelectors = annotationSelectors;
        this.fieldSelectors = fieldSelectors;
        this.labelSelectors = labelSelectors;
        this.namespaces = namespaces;
        this.physicalMachines = physicalMachines;
    }

    @JsonProperty("annotationSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotationSelectors() {
        return annotationSelectors;
    }

    @JsonProperty("annotationSelectors")
    public void setAnnotationSelectors(Map<String, String> annotationSelectors) {
        this.annotationSelectors = annotationSelectors;
    }

    @JsonProperty("fieldSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getFieldSelectors() {
        return fieldSelectors;
    }

    @JsonProperty("fieldSelectors")
    public void setFieldSelectors(Map<String, String> fieldSelectors) {
        this.fieldSelectors = fieldSelectors;
    }

    @JsonProperty("labelSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabelSelectors() {
        return labelSelectors;
    }

    @JsonProperty("labelSelectors")
    public void setLabelSelectors(Map<String, String> labelSelectors) {
        this.labelSelectors = labelSelectors;
    }

    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("physicalMachines")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getPhysicalMachines() {
        return physicalMachines;
    }

    @JsonProperty("physicalMachines")
    public void setPhysicalMachines(Map<String, List<String>> physicalMachines) {
        this.physicalMachines = physicalMachines;
    }

    @JsonIgnore
    public PhysicalMachineSelectorSpecBuilder edit() {
        return new PhysicalMachineSelectorSpecBuilder(this);
    }

    @JsonIgnore
    public PhysicalMachineSelectorSpecBuilder toBuilder() {
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
