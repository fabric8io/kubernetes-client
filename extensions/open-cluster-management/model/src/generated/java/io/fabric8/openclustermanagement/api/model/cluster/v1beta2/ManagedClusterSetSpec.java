
package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedNamespaceConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ManagedClusterSetSpec describes the attributes of the ManagedClusterSet
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterSelector",
    "managedNamespaces"
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
public class ManagedClusterSetSpec implements Editable<ManagedClusterSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterSelector")
    private ManagedClusterSelector clusterSelector;
    @JsonProperty("managedNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManagedNamespaceConfig> managedNamespaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterSetSpec() {
    }

    public ManagedClusterSetSpec(ManagedClusterSelector clusterSelector, List<ManagedNamespaceConfig> managedNamespaces) {
        super();
        this.clusterSelector = clusterSelector;
        this.managedNamespaces = managedNamespaces;
    }

    /**
     * ManagedClusterSetSpec describes the attributes of the ManagedClusterSet
     */
    @JsonProperty("clusterSelector")
    public ManagedClusterSelector getClusterSelector() {
        return clusterSelector;
    }

    /**
     * ManagedClusterSetSpec describes the attributes of the ManagedClusterSet
     */
    @JsonProperty("clusterSelector")
    public void setClusterSelector(ManagedClusterSelector clusterSelector) {
        this.clusterSelector = clusterSelector;
    }

    /**
     * managedNamespaces defines the list of namespace on the managedclusters across the clusterset to be managed.
     */
    @JsonProperty("managedNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ManagedNamespaceConfig> getManagedNamespaces() {
        return managedNamespaces;
    }

    /**
     * managedNamespaces defines the list of namespace on the managedclusters across the clusterset to be managed.
     */
    @JsonProperty("managedNamespaces")
    public void setManagedNamespaces(List<ManagedNamespaceConfig> managedNamespaces) {
        this.managedNamespaces = managedNamespaces;
    }

    @JsonIgnore
    public ManagedClusterSetSpecBuilder edit() {
        return new ManagedClusterSetSpecBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSetSpecBuilder toBuilder() {
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
