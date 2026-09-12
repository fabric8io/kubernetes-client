
package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

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

/**
 * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
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
@Version("v1beta2")
@Group("cluster.open-cluster-management.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ManagedClusterSet implements Editable<ManagedClusterSetBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cluster.open-cluster-management.io/v1beta2";
    @JsonProperty("kind")
    private String kind = "ManagedClusterSet";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private ManagedClusterSetSpec spec;
    @JsonProperty("status")
    private ManagedClusterSetStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterSet() {
    }

    public ManagedClusterSet(String apiVersion, String kind, ObjectMeta metadata, ManagedClusterSetSpec spec, ManagedClusterSetStatus status) {
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
     * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
     */
    @JsonProperty("spec")
    public ManagedClusterSetSpec getSpec() {
        return spec;
    }

    /**
     * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
     */
    @JsonProperty("spec")
    public void setSpec(ManagedClusterSetSpec spec) {
        this.spec = spec;
    }

    /**
     * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
     */
    @JsonProperty("status")
    public ManagedClusterSetStatus getStatus() {
        return status;
    }

    /**
     * ManagedClusterSet defines a group of ManagedClusters that you can run workloads on. You can define a workload to be deployed on a ManagedClusterSet. See the following options  for the workload: - The workload can run on any ManagedCluster in the ManagedClusterSet - The workload cannot run on any ManagedCluster outside the ManagedClusterSet - The service exposed by the workload can be shared in any ManagedCluster in the ManagedClusterSet<br><p> <br><p> To assign a ManagedCluster to a certain ManagedClusterSet, add a label with the name cluster.open-cluster-management.io/clusterset on the ManagedCluster to refer to the ManagedClusterSet. You are not allowed to add or remove this label on a ManagedCluster unless you have an RBAC rule to CREATE on a virtual subresource of managedclustersets/join. To update this label, you must have the permission on both the old and new ManagedClusterSet.
     */
    @JsonProperty("status")
    public void setStatus(ManagedClusterSetStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public ManagedClusterSetBuilder edit() {
        return new ManagedClusterSetBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSetBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ManagedClusterSet)) {
            return false;
        }
        ManagedClusterSet other = (ManagedClusterSet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ManagedClusterSet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ManagedClusterSet(" + "apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", spec=" + this.getSpec() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
