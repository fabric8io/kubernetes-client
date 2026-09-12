
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

/**
 * DockerImageReference points to a container image.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "iD",
    "name",
    "namespace",
    "registry",
    "tag"
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
public class DockerImageReference implements Editable<DockerImageReferenceBuilder>, KubernetesResource
{

    @JsonProperty("iD")
    private String iD;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("registry")
    private String registry;
    @JsonProperty("tag")
    private String tag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DockerImageReference() {
    }

    public DockerImageReference(String iD, String name, String namespace, String registry, String tag) {
        super();
        this.iD = iD;
        this.name = name;
        this.namespace = namespace;
        this.registry = registry;
        this.tag = tag;
    }

    /**
     * ID is the identifier for the container image
     */
    @JsonProperty("iD")
    public String getID() {
        return iD;
    }

    /**
     * ID is the identifier for the container image
     */
    @JsonProperty("iD")
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     * Name is the name of the container image
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the container image
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Namespace is the namespace that contains the container image
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace is the namespace that contains the container image
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Registry is the registry that contains the container image
     */
    @JsonProperty("registry")
    public String getRegistry() {
        return registry;
    }

    /**
     * Registry is the registry that contains the container image
     */
    @JsonProperty("registry")
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    /**
     * Tag is which tag of the container image is being referenced
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * Tag is which tag of the container image is being referenced
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonIgnore
    public DockerImageReferenceBuilder edit() {
        return new DockerImageReferenceBuilder(this);
    }

    @JsonIgnore
    public DockerImageReferenceBuilder toBuilder() {
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
        if (!(o instanceof DockerImageReference)) {
            return false;
        }
        DockerImageReference other = (DockerImageReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$iD = this.getID();
        Object other$iD = other.getID();
        if (this$iD == null ? other$iD != null : !this$iD.equals(other$iD)) {
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
        Object this$registry = this.getRegistry();
        Object other$registry = other.getRegistry();
        if (this$registry == null ? other$registry != null : !this$registry.equals(other$registry)) {
            return false;
        }
        Object this$tag = this.getTag();
        Object other$tag = other.getTag();
        if (this$tag == null ? other$tag != null : !this$tag.equals(other$tag)) {
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
        return other instanceof DockerImageReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $iD = this.getID();
        result = result * prime + ($iD == null ? 43 : $iD.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $registry = this.getRegistry();
        result = result * prime + ($registry == null ? 43 : $registry.hashCode());
        Object $tag = this.getTag();
        result = result * prime + ($tag == null ? 43 : $tag.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DockerImageReference(" + "iD=" + this.getID() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", registry=" + this.getRegistry() + ", tag=" + this.getTag() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
