
package io.fabric8.openclustermanagement.api.model.cluster.v1;

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
 * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
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
@Version("v1")
@Group("cluster.open-cluster-management.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ManagedCluster implements Editable<ManagedClusterBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cluster.open-cluster-management.io/v1";
    @JsonProperty("kind")
    private String kind = "ManagedCluster";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private ManagedClusterSpec spec;
    @JsonProperty("status")
    private ManagedClusterStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedCluster() {
    }

    public ManagedCluster(String apiVersion, String kind, ObjectMeta metadata, ManagedClusterSpec spec, ManagedClusterStatus status) {
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
     * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
     */
    @JsonProperty("spec")
    public ManagedClusterSpec getSpec() {
        return spec;
    }

    /**
     * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
     */
    @JsonProperty("spec")
    public void setSpec(ManagedClusterSpec spec) {
        this.spec = spec;
    }

    /**
     * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
     */
    @JsonProperty("status")
    public ManagedClusterStatus getStatus() {
        return status;
    }

    /**
     * ManagedCluster represents the desired state and current status of a managed cluster. ManagedCluster is a cluster-scoped resource. The name is the cluster UID.<br><p> <br><p> The cluster join process is a double opt-in process. See the following join process steps:<br><p> <br><p> 1. The agent on the managed cluster creates a CSR on the hub with the cluster UID and agent name. 2. The agent on the managed cluster creates a ManagedCluster on the hub. 3. The cluster admin on the hub cluster approves the CSR for the UID and agent name of the ManagedCluster. 4. The cluster admin sets the spec.acceptClient of the ManagedCluster to true. 5. The cluster admin on the managed cluster creates a credential of the kubeconfig for the hub cluster.<br><p> <br><p> After the hub cluster creates the cluster namespace, the klusterlet agent on the ManagedCluster pushes the credential to the hub cluster to use against the kube-apiserver of the ManagedCluster.
     */
    @JsonProperty("status")
    public void setStatus(ManagedClusterStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public ManagedClusterBuilder edit() {
        return new ManagedClusterBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterBuilder toBuilder() {
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
