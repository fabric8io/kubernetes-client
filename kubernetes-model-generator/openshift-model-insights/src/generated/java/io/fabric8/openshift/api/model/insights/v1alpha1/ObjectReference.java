
package io.fabric8.openshift.api.model.insights.v1alpha1;

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
 * ObjectReference contains enough information to let you inspect or modify the referred object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "name",
    "namespace",
    "resource"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ObjectReference implements Editable<ObjectReferenceBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("resource")
    private String resource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ObjectReference() {
    }

    public ObjectReference(String group, String name, String namespace, String resource) {
        super();
        this.group = group;
        this.name = name;
        this.namespace = namespace;
        this.resource = resource;
    }

    /**
     * group is the API Group of the Resource. Enter empty string for the core group. This value is empty or should follow the DNS1123 subdomain format and it must be at most 253 characters in length. Example: "", "apps", "build.openshift.io", etc.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group is the API Group of the Resource. Enter empty string for the core group. This value is empty or should follow the DNS1123 subdomain format and it must be at most 253 characters in length. Example: "", "apps", "build.openshift.io", etc.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * name of the referent that follows the DNS1123 subdomain format. It must be at most 256 characters in length.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the referent that follows the DNS1123 subdomain format. It must be at most 256 characters in length.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace of the referent that follows the DNS1123 subdomain format. It must be at most 253 characters in length.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace of the referent that follows the DNS1123 subdomain format. It must be at most 253 characters in length.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * resource is required field of the type that is being referenced. It is normally the plural form of the resource kind in lowercase. This value should consist of only lowercase alphanumeric characters and hyphens. Example: "deployments", "deploymentconfigs", "pods", etc.
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * resource is required field of the type that is being referenced. It is normally the plural form of the resource kind in lowercase. This value should consist of only lowercase alphanumeric characters and hyphens. Example: "deployments", "deploymentconfigs", "pods", etc.
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    @JsonIgnore
    public ObjectReferenceBuilder edit() {
        return new ObjectReferenceBuilder(this);
    }

    @JsonIgnore
    public ObjectReferenceBuilder toBuilder() {
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
