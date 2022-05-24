
package io.fabric8.verticalpodautoscaler.api.model.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
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
    "containerName",
    "controlledResources",
    "controlledValues",
    "maxAllowed",
    "minAllowed",
    "mode"
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
public class ContainerResourcePolicy implements KubernetesResource
{

    @JsonProperty("containerName")
    private java.lang.String containerName;
    @JsonProperty("controlledResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> controlledResources = new ArrayList<java.lang.String>();
    @JsonProperty("controlledValues")
    private String controlledValues;
    @JsonProperty("maxAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> maxAllowed = new LinkedHashMap<String, Quantity>();
    @JsonProperty("minAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> minAllowed = new LinkedHashMap<String, Quantity>();
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContainerResourcePolicy() {
    }

    /**
     * 
     * @param mode
     * @param maxAllowed
     * @param containerName
     * @param controlledValues
     * @param minAllowed
     * @param controlledResources
     */
    public ContainerResourcePolicy(java.lang.String containerName, List<java.lang.String> controlledResources, String controlledValues, Map<String, Quantity> maxAllowed, Map<String, Quantity> minAllowed, String mode) {
        super();
        this.containerName = containerName;
        this.controlledResources = controlledResources;
        this.controlledValues = controlledValues;
        this.maxAllowed = maxAllowed;
        this.minAllowed = minAllowed;
        this.mode = mode;
    }

    @JsonProperty("containerName")
    public java.lang.String getContainerName() {
        return containerName;
    }

    @JsonProperty("containerName")
    public void setContainerName(java.lang.String containerName) {
        this.containerName = containerName;
    }

    @JsonProperty("controlledResources")
    public List<java.lang.String> getControlledResources() {
        return controlledResources;
    }

    @JsonProperty("controlledResources")
    public void setControlledResources(List<java.lang.String> controlledResources) {
        this.controlledResources = controlledResources;
    }

    @JsonProperty("controlledValues")
    public String getControlledValues() {
        return controlledValues;
    }

    @JsonProperty("controlledValues")
    public void setControlledValues(String controlledValues) {
        this.controlledValues = controlledValues;
    }

    @JsonProperty("maxAllowed")
    public Map<String, Quantity> getMaxAllowed() {
        return maxAllowed;
    }

    @JsonProperty("maxAllowed")
    public void setMaxAllowed(Map<String, Quantity> maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    @JsonProperty("minAllowed")
    public Map<String, Quantity> getMinAllowed() {
        return minAllowed;
    }

    @JsonProperty("minAllowed")
    public void setMinAllowed(Map<String, Quantity> minAllowed) {
        this.minAllowed = minAllowed;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
