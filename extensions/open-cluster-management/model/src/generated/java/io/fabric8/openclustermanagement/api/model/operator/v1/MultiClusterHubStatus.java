
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

/**
 * MultiClusterHubStatus defines the observed state of MultiClusterHub
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "components",
    "conditions",
    "currentVersion",
    "desiredVersion",
    "phase"
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
public class MultiClusterHubStatus implements Editable<MultiClusterHubStatusBuilder>, KubernetesResource
{

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, StatusCondition> components = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HubCondition> conditions = new ArrayList<>();
    @JsonProperty("currentVersion")
    private String currentVersion;
    @JsonProperty("desiredVersion")
    private String desiredVersion;
    @JsonProperty("phase")
    private String phase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MultiClusterHubStatus() {
    }

    public MultiClusterHubStatus(Map<String, StatusCondition> components, List<HubCondition> conditions, String currentVersion, String desiredVersion, String phase) {
        super();
        this.components = components;
        this.conditions = conditions;
        this.currentVersion = currentVersion;
        this.desiredVersion = desiredVersion;
        this.phase = phase;
    }

    /**
     * Components []ComponentCondition `json:"manifests,omitempty"`
     */
    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StatusCondition> getComponents() {
        return components;
    }

    /**
     * Components []ComponentCondition `json:"manifests,omitempty"`
     */
    @JsonProperty("components")
    public void setComponents(Map<String, StatusCondition> components) {
        this.components = components;
    }

    /**
     * Conditions contains the different condition statuses for the MultiClusterHub
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HubCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions contains the different condition statuses for the MultiClusterHub
     */
    @JsonProperty("conditions")
    public void setConditions(List<HubCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * CurrentVersion indicates the current version
     */
    @JsonProperty("currentVersion")
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * CurrentVersion indicates the current version
     */
    @JsonProperty("currentVersion")
    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    /**
     * DesiredVersion indicates the desired version
     */
    @JsonProperty("desiredVersion")
    public String getDesiredVersion() {
        return desiredVersion;
    }

    /**
     * DesiredVersion indicates the desired version
     */
    @JsonProperty("desiredVersion")
    public void setDesiredVersion(String desiredVersion) {
        this.desiredVersion = desiredVersion;
    }

    /**
     * Represents the running phase of the MultiClusterHub
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Represents the running phase of the MultiClusterHub
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonIgnore
    public MultiClusterHubStatusBuilder edit() {
        return new MultiClusterHubStatusBuilder(this);
    }

    @JsonIgnore
    public MultiClusterHubStatusBuilder toBuilder() {
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
