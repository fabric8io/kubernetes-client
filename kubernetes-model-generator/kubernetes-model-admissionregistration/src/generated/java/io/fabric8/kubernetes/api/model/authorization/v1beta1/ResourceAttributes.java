
package io.fabric8.kubernetes.api.model.authorization.v1beta1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ResourceAttributes includes the authorization attributes available for resource requests to the Authorizer interface
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "name",
    "namespace",
    "resource",
    "subresource",
    "verb",
    "version"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceAttributes implements Editable<ResourceAttributesBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("subresource")
    private String subresource;
    @JsonProperty("verb")
    private String verb;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceAttributes() {
    }

    public ResourceAttributes(String group, String name, String namespace, String resource, String subresource, String verb, String version) {
        super();
        this.group = group;
        this.name = name;
        this.namespace = namespace;
        this.resource = resource;
        this.subresource = subresource;
        this.verb = verb;
        this.version = version;
    }

    /**
     * Group is the API Group of the Resource.  "&#42;" means all.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * Group is the API Group of the Resource.  "&#42;" means all.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Name is the name of the resource being requested for a "get" or deleted for a "delete". "" (empty) means all.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the resource being requested for a "get" or deleted for a "delete". "" (empty) means all.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces "" (empty) is defaulted for LocalSubjectAccessReviews "" (empty) is empty for cluster-scoped resources "" (empty) means "all" for namespace scoped resources from a SubjectAccessReview or SelfSubjectAccessReview
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces "" (empty) is defaulted for LocalSubjectAccessReviews "" (empty) is empty for cluster-scoped resources "" (empty) means "all" for namespace scoped resources from a SubjectAccessReview or SelfSubjectAccessReview
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Resource is one of the existing resource types.  "&#42;" means all.
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * Resource is one of the existing resource types.  "&#42;" means all.
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Subresource is one of the existing resource types.  "" means none.
     */
    @JsonProperty("subresource")
    public String getSubresource() {
        return subresource;
    }

    /**
     * Subresource is one of the existing resource types.  "" means none.
     */
    @JsonProperty("subresource")
    public void setSubresource(String subresource) {
        this.subresource = subresource;
    }

    /**
     * Verb is a kubernetes resource API verb, like: get, list, watch, create, update, delete, proxy.  "&#42;" means all.
     */
    @JsonProperty("verb")
    public String getVerb() {
        return verb;
    }

    /**
     * Verb is a kubernetes resource API verb, like: get, list, watch, create, update, delete, proxy.  "&#42;" means all.
     */
    @JsonProperty("verb")
    public void setVerb(String verb) {
        this.verb = verb;
    }

    /**
     * Version is the API Version of the Resource.  "&#42;" means all.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version is the API Version of the Resource.  "&#42;" means all.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public ResourceAttributesBuilder edit() {
        return new ResourceAttributesBuilder(this);
    }

    @JsonIgnore
    public ResourceAttributesBuilder toBuilder() {
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
        if (!(o instanceof ResourceAttributes)) {
            return false;
        }
        ResourceAttributes other = (ResourceAttributes) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
            return false;
        }
        Object this$subresource = this.getSubresource();
        Object other$subresource = other.getSubresource();
        if (this$subresource == null ? other$subresource != null : !this$subresource.equals(other$subresource)) {
            return false;
        }
        Object this$verb = this.getVerb();
        Object other$verb = other.getVerb();
        if (this$verb == null ? other$verb != null : !this$verb.equals(other$verb)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof ResourceAttributes;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $subresource = this.getSubresource();
        result = result * prime + ($subresource == null ? 43 : $subresource.hashCode());
        Object $verb = this.getVerb();
        result = result * prime + ($verb == null ? 43 : $verb.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceAttributes(" + "group=" + this.getGroup() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", resource=" + this.getResource() + ", subresource=" + this.getSubresource() + ", verb=" + this.getVerb() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
