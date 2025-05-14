
package io.fabric8.openshift.api.model;

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
 * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
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
@Group("build.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildConfig implements Editable<BuildConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "build.openshift.io/v1";
    @JsonProperty("kind")
    private String kind = "BuildConfig";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private BuildConfigSpec spec;
    @JsonProperty("status")
    private BuildConfigStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildConfig() {
    }

    public BuildConfig(String apiVersion, String kind, ObjectMeta metadata, BuildConfigSpec spec, BuildConfigStatus status) {
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
     * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public BuildConfigSpec getSpec() {
        return spec;
    }

    /**
     * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public void setSpec(BuildConfigSpec spec) {
        this.spec = spec;
    }

    /**
     * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public BuildConfigStatus getStatus() {
        return status;
    }

    /**
     * Build configurations define a build process for new container images. There are three types of builds possible - a container image build using a Dockerfile, a Source-to-Image build that uses a specially prepared base image that accepts source code that it can make runnable, and a custom build that can run // arbitrary container images as a base and accept the build parameters. Builds run on the cluster and on completion are pushed to the container image registry specified in the "output" section. A build can be triggered via a webhook, when the base image changes, or when a user manually requests a new build be // created.<br><p> <br><p> Each build created by a build configuration is numbered and refers back to its parent configuration. Multiple builds can be triggered at once. Builds that do not have "output" set can be used to test code or run a verification build.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public void setStatus(BuildConfigStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public BuildConfigBuilder edit() {
        return new BuildConfigBuilder(this);
    }

    @JsonIgnore
    public BuildConfigBuilder toBuilder() {
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
