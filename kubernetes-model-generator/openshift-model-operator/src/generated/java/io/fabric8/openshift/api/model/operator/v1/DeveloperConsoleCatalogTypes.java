
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * DeveloperConsoleCatalogTypes defines the state of the sub-catalog types.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disabled",
    "enabled",
    "state"
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
public class DeveloperConsoleCatalogTypes implements Editable<DeveloperConsoleCatalogTypesBuilder>, KubernetesResource
{

    @JsonProperty("disabled")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> disabled = new ArrayList<>();
    @JsonProperty("enabled")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> enabled = new ArrayList<>();
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeveloperConsoleCatalogTypes() {
    }

    public DeveloperConsoleCatalogTypes(List<String> disabled, List<String> enabled, String state) {
        super();
        this.disabled = disabled;
        this.enabled = enabled;
        this.state = state;
    }

    /**
     * disabled is a list of developer catalog types (sub-catalogs IDs) that are not shown to users. Types (sub-catalogs) are added via console plugins, the available types (sub-catalog IDs) are available in the console on the cluster configuration page, or when editing the YAML in the console. Example: "Devfile", "HelmChart", "BuilderImage" If the list is empty or all the available sub-catalog types are added, then the complete developer catalog should be hidden.
     */
    @JsonProperty("disabled")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDisabled() {
        return disabled;
    }

    /**
     * disabled is a list of developer catalog types (sub-catalogs IDs) that are not shown to users. Types (sub-catalogs) are added via console plugins, the available types (sub-catalog IDs) are available in the console on the cluster configuration page, or when editing the YAML in the console. Example: "Devfile", "HelmChart", "BuilderImage" If the list is empty or all the available sub-catalog types are added, then the complete developer catalog should be hidden.
     */
    @JsonProperty("disabled")
    public void setDisabled(List<String> disabled) {
        this.disabled = disabled;
    }

    /**
     * enabled is a list of developer catalog types (sub-catalogs IDs) that will be shown to users. Types (sub-catalogs) are added via console plugins, the available types (sub-catalog IDs) are available in the console on the cluster configuration page, or when editing the YAML in the console. Example: "Devfile", "HelmChart", "BuilderImage" If the list is non-empty, a new type will not be shown to the user until it is added to list. If the list is empty the complete developer catalog will be shown.
     */
    @JsonProperty("enabled")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnabled() {
        return enabled;
    }

    /**
     * enabled is a list of developer catalog types (sub-catalogs IDs) that will be shown to users. Types (sub-catalogs) are added via console plugins, the available types (sub-catalog IDs) are available in the console on the cluster configuration page, or when editing the YAML in the console. Example: "Devfile", "HelmChart", "BuilderImage" If the list is non-empty, a new type will not be shown to the user until it is added to list. If the list is empty the complete developer catalog will be shown.
     */
    @JsonProperty("enabled")
    public void setEnabled(List<String> enabled) {
        this.enabled = enabled;
    }

    /**
     * state defines if a list of catalog types should be enabled or disabled.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state defines if a list of catalog types should be enabled or disabled.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public DeveloperConsoleCatalogTypesBuilder edit() {
        return new DeveloperConsoleCatalogTypesBuilder(this);
    }

    @JsonIgnore
    public DeveloperConsoleCatalogTypesBuilder toBuilder() {
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
