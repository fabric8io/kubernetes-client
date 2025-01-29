
package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
 * ClusterClaim represents cluster information that a managed cluster claims ClusterClaims with well known names include,<br><p>  1. id.k8s.io, it contains a unique identifier for the cluster.<br><p>  2. clusterset.k8s.io, it contains an identifier that relates the cluster<br><p>     to the ClusterSet in which it belongs.<br><p> <br><p> ClusterClaims created on a managed cluster will be collected and saved into the status of the corresponding ManagedCluster on hub.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec"
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
@Version("v1alpha1")
@Group("cluster.open-cluster-management.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterClaim implements Editable<ClusterClaimBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cluster.open-cluster-management.io/v1alpha1";
    @JsonProperty("kind")
    private String kind = "ClusterClaim";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private ClusterClaimSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterClaim() {
    }

    public ClusterClaim(String apiVersion, String kind, ObjectMeta metadata, ClusterClaimSpec spec) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
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
     * ClusterClaim represents cluster information that a managed cluster claims ClusterClaims with well known names include,<br><p>  1. id.k8s.io, it contains a unique identifier for the cluster.<br><p>  2. clusterset.k8s.io, it contains an identifier that relates the cluster<br><p>     to the ClusterSet in which it belongs.<br><p> <br><p> ClusterClaims created on a managed cluster will be collected and saved into the status of the corresponding ManagedCluster on hub.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ClusterClaim represents cluster information that a managed cluster claims ClusterClaims with well known names include,<br><p>  1. id.k8s.io, it contains a unique identifier for the cluster.<br><p>  2. clusterset.k8s.io, it contains an identifier that relates the cluster<br><p>     to the ClusterSet in which it belongs.<br><p> <br><p> ClusterClaims created on a managed cluster will be collected and saved into the status of the corresponding ManagedCluster on hub.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ClusterClaim represents cluster information that a managed cluster claims ClusterClaims with well known names include,<br><p>  1. id.k8s.io, it contains a unique identifier for the cluster.<br><p>  2. clusterset.k8s.io, it contains an identifier that relates the cluster<br><p>     to the ClusterSet in which it belongs.<br><p> <br><p> ClusterClaims created on a managed cluster will be collected and saved into the status of the corresponding ManagedCluster on hub.
     */
    @JsonProperty("spec")
    public ClusterClaimSpec getSpec() {
        return spec;
    }

    /**
     * ClusterClaim represents cluster information that a managed cluster claims ClusterClaims with well known names include,<br><p>  1. id.k8s.io, it contains a unique identifier for the cluster.<br><p>  2. clusterset.k8s.io, it contains an identifier that relates the cluster<br><p>     to the ClusterSet in which it belongs.<br><p> <br><p> ClusterClaims created on a managed cluster will be collected and saved into the status of the corresponding ManagedCluster on hub.
     */
    @JsonProperty("spec")
    public void setSpec(ClusterClaimSpec spec) {
        this.spec = spec;
    }

    @JsonIgnore
    public ClusterClaimBuilder edit() {
        return new ClusterClaimBuilder(this);
    }

    @JsonIgnore
    public ClusterClaimBuilder toBuilder() {
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
