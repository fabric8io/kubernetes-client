
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
import io.fabric8.kubernetes.api.model.NodeSelector;
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
 * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "driverName",
    "parametersRef",
    "structuredParameters",
    "suitableNodes"
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
@Group("resource.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceClass implements Editable<ResourceClassBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "resource.k8s.io/v1alpha2";
    @JsonProperty("driverName")
    private String driverName;
    @JsonProperty("kind")
    private String kind = "ResourceClass";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("parametersRef")
    private ResourceClassParametersReference parametersRef;
    @JsonProperty("structuredParameters")
    private Boolean structuredParameters;
    @JsonProperty("suitableNodes")
    private NodeSelector suitableNodes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceClass() {
    }

    public ResourceClass(String apiVersion, String driverName, String kind, ObjectMeta metadata, ResourceClassParametersReference parametersRef, Boolean structuredParameters, NodeSelector suitableNodes) {
        super();
        this.apiVersion = apiVersion;
        this.driverName = driverName;
        this.kind = kind;
        this.metadata = metadata;
        this.parametersRef = parametersRef;
        this.structuredParameters = structuredParameters;
        this.suitableNodes = suitableNodes;
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
     * DriverName defines the name of the dynamic resource driver that is used for allocation of a ResourceClaim that uses this class.<br><p> <br><p> Resource drivers have a unique name in forward domain order (acme.example.com).
     */
    @JsonProperty("driverName")
    public String getDriverName() {
        return driverName;
    }

    /**
     * DriverName defines the name of the dynamic resource driver that is used for allocation of a ResourceClaim that uses this class.<br><p> <br><p> Resource drivers have a unique name in forward domain order (acme.example.com).
     */
    @JsonProperty("driverName")
    public void setDriverName(String driverName) {
        this.driverName = driverName;
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
     * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
     */
    @JsonProperty("parametersRef")
    public ResourceClassParametersReference getParametersRef() {
        return parametersRef;
    }

    /**
     * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
     */
    @JsonProperty("parametersRef")
    public void setParametersRef(ResourceClassParametersReference parametersRef) {
        this.parametersRef = parametersRef;
    }

    /**
     * If and only if allocation of claims using this class is handled via structured parameters, then StructuredParameters must be set to true.
     */
    @JsonProperty("structuredParameters")
    public Boolean getStructuredParameters() {
        return structuredParameters;
    }

    /**
     * If and only if allocation of claims using this class is handled via structured parameters, then StructuredParameters must be set to true.
     */
    @JsonProperty("structuredParameters")
    public void setStructuredParameters(Boolean structuredParameters) {
        this.structuredParameters = structuredParameters;
    }

    /**
     * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
     */
    @JsonProperty("suitableNodes")
    public NodeSelector getSuitableNodes() {
        return suitableNodes;
    }

    /**
     * ResourceClass is used by administrators to influence how resources are allocated.<br><p> <br><p> This is an alpha type and requires enabling the DynamicResourceAllocation feature gate.
     */
    @JsonProperty("suitableNodes")
    public void setSuitableNodes(NodeSelector suitableNodes) {
        this.suitableNodes = suitableNodes;
    }

    @JsonIgnore
    public ResourceClassBuilder edit() {
        return new ResourceClassBuilder(this);
    }

    @JsonIgnore
    public ResourceClassBuilder toBuilder() {
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
