
package io.fabric8.openshift.api.model;

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
@Group("authorization.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LocalResourceAccessReview implements Editable<LocalResourceAccessReviewBuilder> , HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "authorization.openshift.io/v1";
    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object content;
    @JsonProperty("isNonResourceURL")
    private Boolean isNonResourceURL;
    /**
     * 
     * (Required)
     * 
     */
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
     * 
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("content")
    public Object getContent() {
        return content;
    }

    @JsonProperty("content")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setContent(Object content) {
        this.content = content;
    }

    @JsonProperty("isNonResourceURL")
    public Boolean getIsNonResourceURL() {
        return isNonResourceURL;
    }

    @JsonProperty("isNonResourceURL")
    public void setIsNonResourceURL(Boolean isNonResourceURL) {
        this.isNonResourceURL = isNonResourceURL;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    @JsonProperty("resourceAPIGroup")
    public String getResourceAPIGroup() {
        return resourceAPIGroup;
    }

    @JsonProperty("resourceAPIGroup")
    public void setResourceAPIGroup(String resourceAPIGroup) {
        this.resourceAPIGroup = resourceAPIGroup;
    }

    @JsonProperty("resourceAPIVersion")
    public String getResourceAPIVersion() {
        return resourceAPIVersion;
    }

    @JsonProperty("resourceAPIVersion")
    public void setResourceAPIVersion(String resourceAPIVersion) {
        this.resourceAPIVersion = resourceAPIVersion;
    }

    @JsonProperty("resourceName")
    public String getResourceName() {
        return resourceName;
    }

    @JsonProperty("resourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @JsonProperty("verb")
    public String getVerb() {
        return verb;
    }

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
