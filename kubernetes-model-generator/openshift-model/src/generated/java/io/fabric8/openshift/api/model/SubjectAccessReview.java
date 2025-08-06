
package io.fabric8.openshift.api.model;

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
 * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "content",
    "groups",
    "isNonResourceURL",
    "namespace",
    "path",
    "resource",
    "resourceAPIGroup",
    "resourceAPIVersion",
    "resourceName",
    "scopes",
    "user",
    "verb"
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
@Group("authorization.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SubjectAccessReview implements Editable<SubjectAccessReviewBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "authorization.openshift.io/v1";
    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object content;
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("isNonResourceURL")
    private Boolean isNonResourceURL;
    @JsonProperty("kind")
    private String kind = "SubjectAccessReview";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("path")
    private String path;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("resourceAPIGroup")
    private String resourceAPIGroup;
    @JsonProperty("resourceAPIVersion")
    private String resourceAPIVersion;
    @JsonProperty("resourceName")
    private String resourceName;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonProperty("user")
    private String user;
    @JsonProperty("verb")
    private String verb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubjectAccessReview() {
    }

    public SubjectAccessReview(String apiVersion, Object content, List<String> groups, Boolean isNonResourceURL, String kind, ObjectMeta metadata, String namespace, String path, String resource, String resourceAPIGroup, String resourceAPIVersion, String resourceName, List<String> scopes, String user, String verb) {
        super();
        this.apiVersion = apiVersion;
        this.content = content;
        this.groups = groups;
        this.isNonResourceURL = isNonResourceURL;
        this.kind = kind;
        this.metadata = metadata;
        this.namespace = namespace;
        this.path = path;
        this.resource = resource;
        this.resourceAPIGroup = resourceAPIGroup;
        this.resourceAPIVersion = resourceAPIVersion;
        this.resourceName = resourceName;
        this.scopes = scopes;
        this.user = user;
        this.verb = verb;
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
     * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("content")
    public Object getContent() {
        return content;
    }

    /**
     * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setContent(Object content) {
        this.content = content;
    }

    /**
     * GroupsSlice is optional. Groups is the list of groups to which the User belongs.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * GroupsSlice is optional. Groups is the list of groups to which the User belongs.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * isNonResourceURL is true if this is a request for a non-resource URL (outside of the resource hierarchy)
     */
    @JsonProperty("isNonResourceURL")
    public Boolean getIsNonResourceURL() {
        return isNonResourceURL;
    }

    /**
     * isNonResourceURL is true if this is a request for a non-resource URL (outside of the resource hierarchy)
     */
    @JsonProperty("isNonResourceURL")
    public void setIsNonResourceURL(Boolean isNonResourceURL) {
        this.isNonResourceURL = isNonResourceURL;
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
     * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * path is the path of a non resource URL
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path is the path of a non resource URL
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * resource is one of the existing resource types
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * resource is one of the existing resource types
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Group is the API group of the resource Serialized as resourceAPIGroup to avoid confusion with the 'groups' field when inlined
     */
    @JsonProperty("resourceAPIGroup")
    public String getResourceAPIGroup() {
        return resourceAPIGroup;
    }

    /**
     * Group is the API group of the resource Serialized as resourceAPIGroup to avoid confusion with the 'groups' field when inlined
     */
    @JsonProperty("resourceAPIGroup")
    public void setResourceAPIGroup(String resourceAPIGroup) {
        this.resourceAPIGroup = resourceAPIGroup;
    }

    /**
     * Version is the API version of the resource Serialized as resourceAPIVersion to avoid confusion with TypeMeta.apiVersion and ObjectMeta.resourceVersion when inlined
     */
    @JsonProperty("resourceAPIVersion")
    public String getResourceAPIVersion() {
        return resourceAPIVersion;
    }

    /**
     * Version is the API version of the resource Serialized as resourceAPIVersion to avoid confusion with TypeMeta.apiVersion and ObjectMeta.resourceVersion when inlined
     */
    @JsonProperty("resourceAPIVersion")
    public void setResourceAPIVersion(String resourceAPIVersion) {
        this.resourceAPIVersion = resourceAPIVersion;
    }

    /**
     * resourceName is the name of the resource being requested for a "get" or deleted for a "delete"
     */
    @JsonProperty("resourceName")
    public String getResourceName() {
        return resourceName;
    }

    /**
     * resourceName is the name of the resource being requested for a "get" or deleted for a "delete"
     */
    @JsonProperty("resourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups". Nil for a self-SAR, means "use the scopes on this request". Nil for a regular SAR, means the same as empty.
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups". Nil for a self-SAR, means "use the scopes on this request". Nil for a regular SAR, means the same as empty.
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * user is optional. If both User and Groups are empty, the current authenticated user is used.
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * user is optional. If both User and Groups are empty, the current authenticated user is used.
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * verb is one of: get, list, watch, create, update, delete
     */
    @JsonProperty("verb")
    public String getVerb() {
        return verb;
    }

    /**
     * verb is one of: get, list, watch, create, update, delete
     */
    @JsonProperty("verb")
    public void setVerb(String verb) {
        this.verb = verb;
    }

    @JsonIgnore
    public SubjectAccessReviewBuilder edit() {
        return new SubjectAccessReviewBuilder(this);
    }

    @JsonIgnore
    public SubjectAccessReviewBuilder toBuilder() {
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
