
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
 * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
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
@Group("security.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodSecurityPolicySubjectReview implements Editable<PodSecurityPolicySubjectReviewBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "security.openshift.io/v1";
    @JsonProperty("kind")
    private String kind = "PodSecurityPolicySubjectReview";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private PodSecurityPolicySubjectReviewSpec spec;
    @JsonProperty("status")
    private PodSecurityPolicySubjectReviewStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSecurityPolicySubjectReview() {
    }

    public PodSecurityPolicySubjectReview(String apiVersion, String kind, ObjectMeta metadata, PodSecurityPolicySubjectReviewSpec spec, PodSecurityPolicySubjectReviewStatus status) {
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
     * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public PodSecurityPolicySubjectReviewSpec getSpec() {
        return spec;
    }

    /**
     * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public void setSpec(PodSecurityPolicySubjectReviewSpec spec) {
        this.spec = spec;
    }

    /**
     * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public PodSecurityPolicySubjectReviewStatus getStatus() {
        return status;
    }

    /**
     * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.<br><p> <br><p> Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public void setStatus(PodSecurityPolicySubjectReviewStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PodSecurityPolicySubjectReviewBuilder edit() {
        return new PodSecurityPolicySubjectReviewBuilder(this);
    }

    @JsonIgnore
    public PodSecurityPolicySubjectReviewBuilder toBuilder() {
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
