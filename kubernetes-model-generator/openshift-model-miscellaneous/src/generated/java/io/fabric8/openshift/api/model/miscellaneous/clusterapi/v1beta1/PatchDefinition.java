
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * PatchDefinition defines a patch which is applied to customize the referenced templates.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jsonPatches",
    "selector"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class PatchDefinition implements Editable<PatchDefinitionBuilder>, KubernetesResource
{

    @JsonProperty("jsonPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JSONPatch> jsonPatches = new ArrayList<>();
    @JsonProperty("selector")
    private PatchSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PatchDefinition() {
    }

    public PatchDefinition(List<JSONPatch> jsonPatches, PatchSelector selector) {
        super();
        this.jsonPatches = jsonPatches;
        this.selector = selector;
    }

    /**
     * jsonPatches defines the patches which should be applied on the templates matching the selector. Note: Patches will be applied in the order of the array.
     */
    @JsonProperty("jsonPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JSONPatch> getJsonPatches() {
        return jsonPatches;
    }

    /**
     * jsonPatches defines the patches which should be applied on the templates matching the selector. Note: Patches will be applied in the order of the array.
     */
    @JsonProperty("jsonPatches")
    public void setJsonPatches(List<JSONPatch> jsonPatches) {
        this.jsonPatches = jsonPatches;
    }

    /**
     * PatchDefinition defines a patch which is applied to customize the referenced templates.
     */
    @JsonProperty("selector")
    public PatchSelector getSelector() {
        return selector;
    }

    /**
     * PatchDefinition defines a patch which is applied to customize the referenced templates.
     */
    @JsonProperty("selector")
    public void setSelector(PatchSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public PatchDefinitionBuilder edit() {
        return new PatchDefinitionBuilder(this);
    }

    @JsonIgnore
    public PatchDefinitionBuilder toBuilder() {
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
