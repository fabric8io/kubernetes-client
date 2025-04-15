
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import java.util.LinkedHashMap;
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
 * PlacementDecision indicates a decision from a placement. PlacementDecision must have a cluster.open-cluster-management.io/placement={placement name} label to reference a certain placement.<br><p> <br><p> If a placement has spec.numberOfClusters specified, the total number of decisions contained in the status.decisions of PlacementDecisions must be the same as NumberOfClusters. Otherwise, the total number of decisions must equal the number of ManagedClusters that match the placement requirements.<br><p> <br><p> Some of the decisions might be empty when there are not enough ManagedClusters to meet the placement requirements.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
public class PlacementDecision implements Editable<PlacementDecisionBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cluster.open-cluster-management.io/v1beta1";
    @JsonProperty("kind")
    private String kind = "PlacementDecision";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("status")
    private PlacementDecisionStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlacementDecision() {
    }

    public PlacementDecision(String apiVersion, String kind, ObjectMeta metadata, PlacementDecisionStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
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
     * PlacementDecision indicates a decision from a placement. PlacementDecision must have a cluster.open-cluster-management.io/placement={placement name} label to reference a certain placement.<br><p> <br><p> If a placement has spec.numberOfClusters specified, the total number of decisions contained in the status.decisions of PlacementDecisions must be the same as NumberOfClusters. Otherwise, the total number of decisions must equal the number of ManagedClusters that match the placement requirements.<br><p> <br><p> Some of the decisions might be empty when there are not enough ManagedClusters to meet the placement requirements.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * PlacementDecision indicates a decision from a placement. PlacementDecision must have a cluster.open-cluster-management.io/placement={placement name} label to reference a certain placement.<br><p> <br><p> If a placement has spec.numberOfClusters specified, the total number of decisions contained in the status.decisions of PlacementDecisions must be the same as NumberOfClusters. Otherwise, the total number of decisions must equal the number of ManagedClusters that match the placement requirements.<br><p> <br><p> Some of the decisions might be empty when there are not enough ManagedClusters to meet the placement requirements.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * PlacementDecision indicates a decision from a placement. PlacementDecision must have a cluster.open-cluster-management.io/placement={placement name} label to reference a certain placement.<br><p> <br><p> If a placement has spec.numberOfClusters specified, the total number of decisions contained in the status.decisions of PlacementDecisions must be the same as NumberOfClusters. Otherwise, the total number of decisions must equal the number of ManagedClusters that match the placement requirements.<br><p> <br><p> Some of the decisions might be empty when there are not enough ManagedClusters to meet the placement requirements.
     */
    @JsonProperty("status")
    public PlacementDecisionStatus getStatus() {
        return status;
    }

    /**
     * PlacementDecision indicates a decision from a placement. PlacementDecision must have a cluster.open-cluster-management.io/placement={placement name} label to reference a certain placement.<br><p> <br><p> If a placement has spec.numberOfClusters specified, the total number of decisions contained in the status.decisions of PlacementDecisions must be the same as NumberOfClusters. Otherwise, the total number of decisions must equal the number of ManagedClusters that match the placement requirements.<br><p> <br><p> Some of the decisions might be empty when there are not enough ManagedClusters to meet the placement requirements.
     */
    @JsonProperty("status")
    public void setStatus(PlacementDecisionStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PlacementDecisionBuilder edit() {
        return new PlacementDecisionBuilder(this);
    }

    @JsonIgnore
    public PlacementDecisionBuilder toBuilder() {
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
