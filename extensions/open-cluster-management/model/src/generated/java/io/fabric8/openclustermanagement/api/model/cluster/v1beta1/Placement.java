
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("cluster.open-cluster-management.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Placement implements Editable<PlacementBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cluster.open-cluster-management.io/v1beta1";
    @JsonProperty("kind")
    private String kind = "Placement";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private PlacementSpec spec;
    @JsonProperty("status")
    private PlacementStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Placement() {
    }

    public Placement(String apiVersion, String kind, ObjectMeta metadata, PlacementSpec spec, PlacementStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
     */
    @JsonProperty("spec")
    public PlacementSpec getSpec() {
        return spec;
    }

    /**
     * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
     */
    @JsonProperty("spec")
    public void setSpec(PlacementSpec spec) {
        this.spec = spec;
    }

    /**
     * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
     */
    @JsonProperty("status")
    public PlacementStatus getStatus() {
        return status;
    }

    /**
     * Placement defines a rule to select a set of ManagedClusters from the ManagedClusterSets bound to the placement namespace.<br><p> <br><p> Here is how the placement policy combines with other selection methods to determine a matching list of ManagedClusters:<br><p>  1. Kubernetes clusters are registered with hub as cluster-scoped ManagedClusters;<br><p>  2. ManagedClusters are organized into cluster-scoped ManagedClusterSets;<br><p>  3. ManagedClusterSets are bound to workload namespaces;<br><p>  4. Namespace-scoped Placements specify a slice of ManagedClusterSets which select a working set<br><p>     of potential ManagedClusters;<br><p>  5. Then Placements subselect from that working set using label/claim selection.<br><p> <br><p> A ManagedCluster will not be selected if no ManagedClusterSet is bound to the placement namespace. A user is able to bind a ManagedClusterSet to a namespace by creating a ManagedClusterSetBinding in that namespace if they have an RBAC rule to CREATE on the virtual subresource of `managedclustersets/bind`.<br><p> <br><p> A slice of PlacementDecisions with the label cluster.open-cluster-management.io/placement={placement name} will be created to represent the ManagedClusters selected by this placement.<br><p> <br><p> If a ManagedCluster is selected and added into the PlacementDecisions, other components may apply workload on it; once it is removed from the PlacementDecisions, the workload applied on this ManagedCluster should be evicted accordingly.
     */
    @JsonProperty("status")
    public void setStatus(PlacementStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PlacementBuilder edit() {
        return new PlacementBuilder(this);
    }

    @JsonIgnore
    public PlacementBuilder toBuilder() {
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
