
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * GenerationStatus keeps track of the generation for a given resource so that decisions about forced updates can be made. The definition matches the GenerationStatus defined in github.com/openshift/api/v1
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "lastGeneration",
    "name",
    "namespace",
    "resource",
    "version"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GenerationStatus implements Editable<GenerationStatusBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("lastGeneration")
    private Long lastGeneration;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenerationStatus() {
    }

    public GenerationStatus(String group, Long lastGeneration, String name, String namespace, String resource, String version) {
        super();
        this.group = group;
        this.lastGeneration = lastGeneration;
        this.name = name;
        this.namespace = namespace;
        this.resource = resource;
        this.version = version;
    }

    /**
     * group is the group of the resource that you're tracking
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group is the group of the resource that you're tracking
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * lastGeneration is the last generation of the resource that controller applies
     */
    @JsonProperty("lastGeneration")
    public Long getLastGeneration() {
        return lastGeneration;
    }

    /**
     * lastGeneration is the last generation of the resource that controller applies
     */
    @JsonProperty("lastGeneration")
    public void setLastGeneration(Long lastGeneration) {
        this.lastGeneration = lastGeneration;
    }

    /**
     * name is the name of the resource that you're tracking
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the resource that you're tracking
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is where the resource that you're tracking is
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is where the resource that you're tracking is
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * resource is the resource type of the resource that you're tracking
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * resource is the resource type of the resource that you're tracking
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * version is the version of the resource that you're tracking
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the version of the resource that you're tracking
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public GenerationStatusBuilder edit() {
        return new GenerationStatusBuilder(this);
    }

    @JsonIgnore
    public GenerationStatusBuilder toBuilder() {
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
