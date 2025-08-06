
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Action describes a request to the API server
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Action implements Editable<ActionBuilder>, KubernetesResource
{

    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object content;
    @JsonProperty("isNonResourceURL")
    private Boolean isNonResourceURL;
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
    public Action() {
    }

    public Action(Object content, Boolean isNonResourceURL, String namespace, String path, String resource, String resourceAPIGroup, String resourceAPIVersion, String resourceName, String verb) {
        super();
        this.content = content;
        this.isNonResourceURL = isNonResourceURL;
        this.namespace = namespace;
        this.path = path;
        this.resource = resource;
        this.resourceAPIGroup = resourceAPIGroup;
        this.resourceAPIVersion = resourceAPIVersion;
        this.resourceName = resourceName;
        this.verb = verb;
    }

    /**
     * Action describes a request to the API server
     */
    @JsonProperty("content")
    public Object getContent() {
        return content;
    }

    /**
     * Action describes a request to the API server
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
    public ActionBuilder edit() {
        return new ActionBuilder(this);
    }

    @JsonIgnore
    public ActionBuilder toBuilder() {
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
