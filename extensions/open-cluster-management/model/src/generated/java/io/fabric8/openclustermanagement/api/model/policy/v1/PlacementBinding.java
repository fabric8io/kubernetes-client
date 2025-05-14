
package io.fabric8.openclustermanagement.api.model.policy.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bindingOverrides",
    "placementRef",
    "status",
    "subFilter",
    "subjects"
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
@Group("policy.open-cluster-management.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PlacementBinding implements Editable<PlacementBindingBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "policy.open-cluster-management.io/v1";
    @JsonProperty("bindingOverrides")
    private BindingOverrides bindingOverrides;
    @JsonProperty("kind")
    private String kind = "PlacementBinding";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("placementRef")
    private PlacementSubject placementRef;
    @JsonProperty("status")
    private PlacementBindingStatus status;
    @JsonProperty("subFilter")
    private String subFilter;
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Subject> subjects = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlacementBinding() {
    }

    public PlacementBinding(String apiVersion, BindingOverrides bindingOverrides, String kind, ObjectMeta metadata, PlacementSubject placementRef, PlacementBindingStatus status, String subFilter, List<Subject> subjects) {
        super();
        this.apiVersion = apiVersion;
        this.bindingOverrides = bindingOverrides;
        this.kind = kind;
        this.metadata = metadata;
        this.placementRef = placementRef;
        this.status = status;
        this.subFilter = subFilter;
        this.subjects = subjects;
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
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("bindingOverrides")
    public BindingOverrides getBindingOverrides() {
        return bindingOverrides;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("bindingOverrides")
    public void setBindingOverrides(BindingOverrides bindingOverrides) {
        this.bindingOverrides = bindingOverrides;
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
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("placementRef")
    public PlacementSubject getPlacementRef() {
        return placementRef;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("placementRef")
    public void setPlacementRef(PlacementSubject placementRef) {
        this.placementRef = placementRef;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("status")
    public PlacementBindingStatus getStatus() {
        return status;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("status")
    public void setStatus(PlacementBindingStatus status) {
        this.status = status;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("subFilter")
    public String getSubFilter() {
        return subFilter;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("subFilter")
    public void setSubFilter(String subFilter) {
        this.subFilter = subFilter;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * PlacementBinding is the schema for the placementbindings API. A PlacementBinding resource binds a managed cluster placement resource to a policy or policy set, along with configurable overrides.
     */
    @JsonProperty("subjects")
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @JsonIgnore
    public PlacementBindingBuilder edit() {
        return new PlacementBindingBuilder(this);
    }

    @JsonIgnore
    public PlacementBindingBuilder toBuilder() {
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
