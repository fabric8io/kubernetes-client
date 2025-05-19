
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
    "currentGeneration",
    "desiredGeneration",
    "lastFailedGeneration",
    "lastFailedGenerationErrors",
    "name"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineConfigNodeStatusPinnedImageSet implements Editable<MachineConfigNodeStatusPinnedImageSetBuilder>, KubernetesResource
{

    @JsonProperty("currentGeneration")
    private Integer currentGeneration;
    @JsonProperty("desiredGeneration")
    private Integer desiredGeneration;
    @JsonProperty("lastFailedGeneration")
    private Integer lastFailedGeneration;
    @JsonProperty("lastFailedGenerationErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> lastFailedGenerationErrors = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeStatusPinnedImageSet() {
    }

    public MachineConfigNodeStatusPinnedImageSet(Integer currentGeneration, Integer desiredGeneration, Integer lastFailedGeneration, List<String> lastFailedGenerationErrors, String name) {
        super();
        this.currentGeneration = currentGeneration;
        this.desiredGeneration = desiredGeneration;
        this.lastFailedGeneration = lastFailedGeneration;
        this.lastFailedGenerationErrors = lastFailedGenerationErrors;
        this.name = name;
    }

    /**
     * currentGeneration is the generation of the pinned image set that has most recently been successfully pulled and pinned on this node.
     */
    @JsonProperty("currentGeneration")
    public Integer getCurrentGeneration() {
        return currentGeneration;
    }

    /**
     * currentGeneration is the generation of the pinned image set that has most recently been successfully pulled and pinned on this node.
     */
    @JsonProperty("currentGeneration")
    public void setCurrentGeneration(Integer currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    /**
     * desiredGeneration version is the generation of the pinned image set that is targeted to be pulled and pinned on this node.
     */
    @JsonProperty("desiredGeneration")
    public Integer getDesiredGeneration() {
        return desiredGeneration;
    }

    /**
     * desiredGeneration version is the generation of the pinned image set that is targeted to be pulled and pinned on this node.
     */
    @JsonProperty("desiredGeneration")
    public void setDesiredGeneration(Integer desiredGeneration) {
        this.desiredGeneration = desiredGeneration;
    }

    /**
     * lastFailedGeneration is the generation of the most recent pinned image set that failed to be pulled and pinned on this node.
     */
    @JsonProperty("lastFailedGeneration")
    public Integer getLastFailedGeneration() {
        return lastFailedGeneration;
    }

    /**
     * lastFailedGeneration is the generation of the most recent pinned image set that failed to be pulled and pinned on this node.
     */
    @JsonProperty("lastFailedGeneration")
    public void setLastFailedGeneration(Integer lastFailedGeneration) {
        this.lastFailedGeneration = lastFailedGeneration;
    }

    /**
     * lastFailedGenerationErrors is a list of errors why the lastFailed generation failed to be pulled and pinned.
     */
    @JsonProperty("lastFailedGenerationErrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLastFailedGenerationErrors() {
        return lastFailedGenerationErrors;
    }

    /**
     * lastFailedGenerationErrors is a list of errors why the lastFailed generation failed to be pulled and pinned.
     */
    @JsonProperty("lastFailedGenerationErrors")
    public void setLastFailedGenerationErrors(List<String> lastFailedGenerationErrors) {
        this.lastFailedGenerationErrors = lastFailedGenerationErrors;
    }

    /**
     * name is the name of the pinned image set. Must be a lowercase RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) It may consist of only alphanumeric characters, hyphens (-) and periods (.) and must be at most 253 characters in length.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the pinned image set. Must be a lowercase RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) It may consist of only alphanumeric characters, hyphens (-) and periods (.) and must be at most 253 characters in length.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public MachineConfigNodeStatusPinnedImageSetBuilder edit() {
        return new MachineConfigNodeStatusPinnedImageSetBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeStatusPinnedImageSetBuilder toBuilder() {
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

}
