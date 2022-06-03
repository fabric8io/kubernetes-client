
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "filterClass",
    "operation",
    "value"
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
public class EnvoyFilterPatch implements KubernetesResource
{

    @JsonProperty("filterClass")
    private EnvoyFilterPatchFilterClass filterClass;
    @JsonProperty("operation")
    private EnvoyFilterPatchOperation operation;
    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> value = new LinkedHashMap<String, Object>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvoyFilterPatch() {
    }

    /**
     * 
     * @param filterClass
     * @param operation
     * @param value
     */
    public EnvoyFilterPatch(EnvoyFilterPatchFilterClass filterClass, EnvoyFilterPatchOperation operation, Map<String, Object> value) {
        super();
        this.filterClass = filterClass;
        this.operation = operation;
        this.value = value;
    }

    @JsonProperty("filterClass")
    public EnvoyFilterPatchFilterClass getFilterClass() {
        return filterClass;
    }

    @JsonProperty("filterClass")
    public void setFilterClass(EnvoyFilterPatchFilterClass filterClass) {
        this.filterClass = filterClass;
    }

    @JsonProperty("operation")
    public EnvoyFilterPatchOperation getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(EnvoyFilterPatchOperation operation) {
        this.operation = operation;
    }

    @JsonProperty("value")
    public Map<String, Object> getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Map<String, Object> value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
