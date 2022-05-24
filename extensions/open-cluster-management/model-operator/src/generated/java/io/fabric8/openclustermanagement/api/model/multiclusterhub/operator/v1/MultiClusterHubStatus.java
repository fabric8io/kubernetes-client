
package io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1;

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
    "components",
    "conditions",
    "currentVersion",
    "desiredVersion",
    "phase"
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
public class MultiClusterHubStatus implements KubernetesResource
{

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, StatusCondition> components = new LinkedHashMap<String, StatusCondition>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HubCondition> conditions = new ArrayList<HubCondition>();
    @JsonProperty("currentVersion")
    private java.lang.String currentVersion;
    @JsonProperty("desiredVersion")
    private java.lang.String desiredVersion;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MultiClusterHubStatus() {
    }

    /**
     * 
     * @param phase
     * @param components
     * @param desiredVersion
     * @param conditions
     * @param currentVersion
     */
    public MultiClusterHubStatus(Map<String, StatusCondition> components, List<HubCondition> conditions, java.lang.String currentVersion, java.lang.String desiredVersion, java.lang.String phase) {
        super();
        this.components = components;
        this.conditions = conditions;
        this.currentVersion = currentVersion;
        this.desiredVersion = desiredVersion;
        this.phase = phase;
    }

    @JsonProperty("components")
    public Map<String, StatusCondition> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(Map<String, StatusCondition> components) {
        this.components = components;
    }

    @JsonProperty("conditions")
    public List<HubCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<HubCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentVersion")
    public java.lang.String getCurrentVersion() {
        return currentVersion;
    }

    @JsonProperty("currentVersion")
    public void setCurrentVersion(java.lang.String currentVersion) {
        this.currentVersion = currentVersion;
    }

    @JsonProperty("desiredVersion")
    public java.lang.String getDesiredVersion() {
        return desiredVersion;
    }

    @JsonProperty("desiredVersion")
    public void setDesiredVersion(java.lang.String desiredVersion) {
        this.desiredVersion = desiredVersion;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
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
