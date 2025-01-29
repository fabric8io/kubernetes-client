
package io.fabric8.knative.bindings.v1alpha1;

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
 * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
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
@Version("v1alpha1")
@Group("bindings.knative.dev")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GitLabBinding implements Editable<GitLabBindingBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "bindings.knative.dev/v1alpha1";
    @JsonProperty("kind")
    private String kind = "GitLabBinding";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private GitLabBindingSpec spec;
    @JsonProperty("status")
    private GitLabBindingStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitLabBinding() {
    }

    public GitLabBinding(String apiVersion, String kind, ObjectMeta metadata, GitLabBindingSpec spec, GitLabBindingStatus status) {
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
     * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
     */
    @JsonProperty("spec")
    public GitLabBindingSpec getSpec() {
        return spec;
    }

    /**
     * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
     */
    @JsonProperty("spec")
    public void setSpec(GitLabBindingSpec spec) {
        this.spec = spec;
    }

    /**
     * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
     */
    @JsonProperty("status")
    public GitLabBindingStatus getStatus() {
        return status;
    }

    /**
     * GitLabBinding describes a Binding that is also a Source. The `sink` (from the Source duck) is resolved to a URL and then projected into the `subject` by augmenting the runtime contract of the referenced containers to have a `K_SINK` environment variable holding the endpoint to which to send cloud events.
     */
    @JsonProperty("status")
    public void setStatus(GitLabBindingStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public GitLabBindingBuilder edit() {
        return new GitLabBindingBuilder(this);
    }

    @JsonIgnore
    public GitLabBindingBuilder toBuilder() {
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
