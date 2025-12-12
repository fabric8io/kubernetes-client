
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * ClusterClassPatch defines a patch which is applied to customize the referenced templates.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "definitions",
    "description",
    "enabledIf",
    "external",
    "name"
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
public class ClusterClassPatch implements Editable<ClusterClassPatchBuilder>, KubernetesResource
{

    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PatchDefinition> definitions = new ArrayList<>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("enabledIf")
    private String enabledIf;
    @JsonProperty("external")
    private ExternalPatchDefinition external;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterClassPatch() {
    }

    public ClusterClassPatch(List<PatchDefinition> definitions, String description, String enabledIf, ExternalPatchDefinition external, String name) {
        super();
        this.definitions = definitions;
        this.description = description;
        this.enabledIf = enabledIf;
        this.external = external;
        this.name = name;
    }

    /**
     * definitions define inline patches. Note: Patches will be applied in the order of the array. Note: Exactly one of Definitions or External must be set.
     */
    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PatchDefinition> getDefinitions() {
        return definitions;
    }

    /**
     * definitions define inline patches. Note: Patches will be applied in the order of the array. Note: Exactly one of Definitions or External must be set.
     */
    @JsonProperty("definitions")
    public void setDefinitions(List<PatchDefinition> definitions) {
        this.definitions = definitions;
    }

    /**
     * description is a human-readable description of this patch.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description is a human-readable description of this patch.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * enabledIf is a Go template to be used to calculate if a patch should be enabled. It can reference variables defined in .spec.variables and builtin variables. The patch will be enabled if the template evaluates to `true`, otherwise it will be disabled. If EnabledIf is not set, the patch will be enabled per default.
     */
    @JsonProperty("enabledIf")
    public String getEnabledIf() {
        return enabledIf;
    }

    /**
     * enabledIf is a Go template to be used to calculate if a patch should be enabled. It can reference variables defined in .spec.variables and builtin variables. The patch will be enabled if the template evaluates to `true`, otherwise it will be disabled. If EnabledIf is not set, the patch will be enabled per default.
     */
    @JsonProperty("enabledIf")
    public void setEnabledIf(String enabledIf) {
        this.enabledIf = enabledIf;
    }

    /**
     * ClusterClassPatch defines a patch which is applied to customize the referenced templates.
     */
    @JsonProperty("external")
    public ExternalPatchDefinition getExternal() {
        return external;
    }

    /**
     * ClusterClassPatch defines a patch which is applied to customize the referenced templates.
     */
    @JsonProperty("external")
    public void setExternal(ExternalPatchDefinition external) {
        this.external = external;
    }

    /**
     * name of the patch.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the patch.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public ClusterClassPatchBuilder edit() {
        return new ClusterClassPatchBuilder(this);
    }

    @JsonIgnore
    public ClusterClassPatchBuilder toBuilder() {
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
