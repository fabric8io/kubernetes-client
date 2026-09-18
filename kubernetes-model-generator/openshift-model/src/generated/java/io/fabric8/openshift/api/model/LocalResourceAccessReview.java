
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

/**
 * LocalResourceAccessReview is a means to request a list of which users and groups are authorized to perform the action specified by spec in a particular namespace<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "content",
    "isNonResourceURL",
    "namespace",
    "path",
    "resource",
    "resourceAPIGroup",
    "resourceAPIVersion",
    "resourceName",
    "verb"
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
@Version("v1")
@Group("authorization.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LocalResourceAccessReview implements Editable<LocalResourceAccessReviewBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "authorization.openshift.io/v1";
    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object content;
    @JsonProperty("isNonResourceURL")
    private Boolean isNonResourceURL;
    @JsonProperty("kind")
    private String kind = "LocalResourceAccessReview";
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
    @JsonProperty("verb")
    private String verb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LocalResourceAccessReview() {
    }

    public LocalResourceAccessReview(String apiVersion, Object content, Boolean isNonResourceURL, String kind, ObjectMeta metadata, String namespace, String path, String resource, String resourceAPIGroup, String resourceAPIVersion, String resourceName, String verb) {
        super();
        this.apiVersion = apiVersion;
        this.content = content;
        this.isNonResourceURL = isNonResourceURL;
        this.kind = kind;
        this.metadata = metadata;
        this.namespace = namespace;
        this.path = path;
        this.resource = resource;
        this.resourceAPIGroup = resourceAPIGroup;
        this.resourceAPIVersion = resourceAPIVersion;
        this.resourceName = resourceName;
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
     * LocalResourceAccessReview is a means to request a list of which users and groups are authorized to perform the action specified by spec in a particular namespace<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("content")
    public Object getContent() {
        return content;
    }

    /**
     * LocalResourceAccessReview is a means to request a list of which users and groups are authorized to perform the action specified by spec in a particular namespace<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setContent(Object content) {
        this.content = content;
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
     * LocalResourceAccessReview is a means to request a list of which users and groups are authorized to perform the action specified by spec in a particular namespace<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * LocalResourceAccessReview is a means to request a list of which users and groups are authorized to perform the action specified by spec in a particular namespace<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
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
    public LocalResourceAccessReviewBuilder edit() {
        return new LocalResourceAccessReviewBuilder(this);
    }

    @JsonIgnore
    public LocalResourceAccessReviewBuilder toBuilder() {
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
        if (!(o instanceof LocalResourceAccessReview)) {
            return false;
        }
        LocalResourceAccessReview other = (LocalResourceAccessReview) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$content = this.getContent();
        Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) {
            return false;
        }
        Object this$isNonResourceURL = this.getIsNonResourceURL();
        Object other$isNonResourceURL = other.getIsNonResourceURL();
        if (this$isNonResourceURL == null ? other$isNonResourceURL != null : !this$isNonResourceURL.equals(other$isNonResourceURL)) {
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
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
            return false;
        }
        Object this$resourceAPIGroup = this.getResourceAPIGroup();
        Object other$resourceAPIGroup = other.getResourceAPIGroup();
        if (this$resourceAPIGroup == null ? other$resourceAPIGroup != null : !this$resourceAPIGroup.equals(other$resourceAPIGroup)) {
            return false;
        }
        Object this$resourceAPIVersion = this.getResourceAPIVersion();
        Object other$resourceAPIVersion = other.getResourceAPIVersion();
        if (this$resourceAPIVersion == null ? other$resourceAPIVersion != null : !this$resourceAPIVersion.equals(other$resourceAPIVersion)) {
            return false;
        }
        Object this$resourceName = this.getResourceName();
        Object other$resourceName = other.getResourceName();
        if (this$resourceName == null ? other$resourceName != null : !this$resourceName.equals(other$resourceName)) {
            return false;
        }
        Object this$verb = this.getVerb();
        Object other$verb = other.getVerb();
        if (this$verb == null ? other$verb != null : !this$verb.equals(other$verb)) {
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
        return other instanceof LocalResourceAccessReview;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $content = this.getContent();
        result = result * prime + ($content == null ? 43 : $content.hashCode());
        Object $isNonResourceURL = this.getIsNonResourceURL();
        result = result * prime + ($isNonResourceURL == null ? 43 : $isNonResourceURL.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $resourceAPIGroup = this.getResourceAPIGroup();
        result = result * prime + ($resourceAPIGroup == null ? 43 : $resourceAPIGroup.hashCode());
        Object $resourceAPIVersion = this.getResourceAPIVersion();
        result = result * prime + ($resourceAPIVersion == null ? 43 : $resourceAPIVersion.hashCode());
        Object $resourceName = this.getResourceName();
        result = result * prime + ($resourceName == null ? 43 : $resourceName.hashCode());
        Object $verb = this.getVerb();
        result = result * prime + ($verb == null ? 43 : $verb.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LocalResourceAccessReview(" + "apiVersion=" + this.getApiVersion() + ", content=" + this.getContent() + ", isNonResourceURL=" + this.getIsNonResourceURL() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", namespace=" + this.getNamespace() + ", path=" + this.getPath() + ", resource=" + this.getResource() + ", resourceAPIGroup=" + this.getResourceAPIGroup() + ", resourceAPIVersion=" + this.getResourceAPIVersion() + ", resourceName=" + this.getResourceName() + ", verb=" + this.getVerb() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
