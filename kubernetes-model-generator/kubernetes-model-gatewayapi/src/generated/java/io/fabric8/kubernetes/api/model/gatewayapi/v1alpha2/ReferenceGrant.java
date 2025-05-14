
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

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
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrantSpec;
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
 * ReferenceGrant identifies kinds of resources in other namespaces that are trusted to reference the specified kinds of resources in the same namespace as the policy.<br><p> <br><p> Each ReferenceGrant can be used to represent a unique trust relationship. Additional Reference Grants can be used to add to the set of trusted sources of inbound references for the namespace they are defined within.<br><p> <br><p> A ReferenceGrant is required for all cross-namespace references in Gateway API (with the exception of cross-namespace Route-Gateway attachment, which is governed by the AllowedRoutes configuration on the Gateway, and cross-namespace Service ParentRefs on a "consumer" mesh Route, which defines routing rules applicable only to workloads in the Route namespace). ReferenceGrants allowing a reference from a Route to a Service are only applicable to BackendRefs.<br><p> <br><p> ReferenceGrant is a form of runtime verification allowing users to assert which cross-namespace object references are permitted. Implementations that support ReferenceGrant MUST NOT permit cross-namespace references which have no grant, and MUST respond to the removal of a grant by revoking the access that the grant allowed.
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
@Version("v1alpha2")
@Group("gateway.networking.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ReferenceGrant implements Editable<ReferenceGrantBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "gateway.networking.k8s.io/v1alpha2";
    @JsonProperty("kind")
    private String kind = "ReferenceGrant";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private ReferenceGrantSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReferenceGrant() {
    }

    public ReferenceGrant(String apiVersion, String kind, ObjectMeta metadata, ReferenceGrantSpec spec) {
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
     * ReferenceGrant identifies kinds of resources in other namespaces that are trusted to reference the specified kinds of resources in the same namespace as the policy.<br><p> <br><p> Each ReferenceGrant can be used to represent a unique trust relationship. Additional Reference Grants can be used to add to the set of trusted sources of inbound references for the namespace they are defined within.<br><p> <br><p> A ReferenceGrant is required for all cross-namespace references in Gateway API (with the exception of cross-namespace Route-Gateway attachment, which is governed by the AllowedRoutes configuration on the Gateway, and cross-namespace Service ParentRefs on a "consumer" mesh Route, which defines routing rules applicable only to workloads in the Route namespace). ReferenceGrants allowing a reference from a Route to a Service are only applicable to BackendRefs.<br><p> <br><p> ReferenceGrant is a form of runtime verification allowing users to assert which cross-namespace object references are permitted. Implementations that support ReferenceGrant MUST NOT permit cross-namespace references which have no grant, and MUST respond to the removal of a grant by revoking the access that the grant allowed.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ReferenceGrant identifies kinds of resources in other namespaces that are trusted to reference the specified kinds of resources in the same namespace as the policy.<br><p> <br><p> Each ReferenceGrant can be used to represent a unique trust relationship. Additional Reference Grants can be used to add to the set of trusted sources of inbound references for the namespace they are defined within.<br><p> <br><p> A ReferenceGrant is required for all cross-namespace references in Gateway API (with the exception of cross-namespace Route-Gateway attachment, which is governed by the AllowedRoutes configuration on the Gateway, and cross-namespace Service ParentRefs on a "consumer" mesh Route, which defines routing rules applicable only to workloads in the Route namespace). ReferenceGrants allowing a reference from a Route to a Service are only applicable to BackendRefs.<br><p> <br><p> ReferenceGrant is a form of runtime verification allowing users to assert which cross-namespace object references are permitted. Implementations that support ReferenceGrant MUST NOT permit cross-namespace references which have no grant, and MUST respond to the removal of a grant by revoking the access that the grant allowed.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ReferenceGrant identifies kinds of resources in other namespaces that are trusted to reference the specified kinds of resources in the same namespace as the policy.<br><p> <br><p> Each ReferenceGrant can be used to represent a unique trust relationship. Additional Reference Grants can be used to add to the set of trusted sources of inbound references for the namespace they are defined within.<br><p> <br><p> A ReferenceGrant is required for all cross-namespace references in Gateway API (with the exception of cross-namespace Route-Gateway attachment, which is governed by the AllowedRoutes configuration on the Gateway, and cross-namespace Service ParentRefs on a "consumer" mesh Route, which defines routing rules applicable only to workloads in the Route namespace). ReferenceGrants allowing a reference from a Route to a Service are only applicable to BackendRefs.<br><p> <br><p> ReferenceGrant is a form of runtime verification allowing users to assert which cross-namespace object references are permitted. Implementations that support ReferenceGrant MUST NOT permit cross-namespace references which have no grant, and MUST respond to the removal of a grant by revoking the access that the grant allowed.
     */
    @JsonProperty("spec")
    public ReferenceGrantSpec getSpec() {
        return spec;
    }

    /**
     * ReferenceGrant identifies kinds of resources in other namespaces that are trusted to reference the specified kinds of resources in the same namespace as the policy.<br><p> <br><p> Each ReferenceGrant can be used to represent a unique trust relationship. Additional Reference Grants can be used to add to the set of trusted sources of inbound references for the namespace they are defined within.<br><p> <br><p> A ReferenceGrant is required for all cross-namespace references in Gateway API (with the exception of cross-namespace Route-Gateway attachment, which is governed by the AllowedRoutes configuration on the Gateway, and cross-namespace Service ParentRefs on a "consumer" mesh Route, which defines routing rules applicable only to workloads in the Route namespace). ReferenceGrants allowing a reference from a Route to a Service are only applicable to BackendRefs.<br><p> <br><p> ReferenceGrant is a form of runtime verification allowing users to assert which cross-namespace object references are permitted. Implementations that support ReferenceGrant MUST NOT permit cross-namespace references which have no grant, and MUST respond to the removal of a grant by revoking the access that the grant allowed.
     */
    @JsonProperty("spec")
    public void setSpec(ReferenceGrantSpec spec) {
        this.spec = spec;
    }

    @JsonIgnore
    public ReferenceGrantBuilder edit() {
        return new ReferenceGrantBuilder(this);
    }

    @JsonIgnore
    public ReferenceGrantBuilder toBuilder() {
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
