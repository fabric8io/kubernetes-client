
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * ResourceList represents a list of resources which are of the same Group/Kind
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "group",
    "instances"
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
public class ResourceList implements Editable<ResourceListBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("instances")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceInstance> instances = new ArrayList<>();
    @JsonProperty("kind")
    private String kind;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceList() {
    }

    public ResourceList(String group, List<ResourceInstance> instances, String kind) {
        super();
        this.group = group;
        this.instances = instances;
        this.kind = kind;
    }

    /**
     * ResourceList represents a list of resources which are of the same Group/Kind
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * ResourceList represents a list of resources which are of the same Group/Kind
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * ResourceList represents a list of resources which are of the same Group/Kind
     */
    @JsonProperty("instances")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceInstance> getInstances() {
        return instances;
    }

    /**
     * ResourceList represents a list of resources which are of the same Group/Kind
     */
    @JsonProperty("instances")
    public void setInstances(List<ResourceInstance> instances) {
        this.instances = instances;
    }

    /**
     * ResourceList represents a list of resources which are of the same Group/Kind
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * ResourceList represents a list of resources which are of the same Group/Kind
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonIgnore
    public ResourceListBuilder edit() {
        return new ResourceListBuilder(this);
    }

    @JsonIgnore
    public ResourceListBuilder toBuilder() {
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
        if (!(o instanceof ResourceList)) {
            return false;
        }
        ResourceList other = (ResourceList) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$instances = this.getInstances();
        Object other$instances = other.getInstances();
        if (this$instances == null ? other$instances != null : !this$instances.equals(other$instances)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
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
        return other instanceof ResourceList;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $instances = this.getInstances();
        result = result * prime + ($instances == null ? 43 : $instances.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceList(" + "group=" + this.getGroup() + ", instances=" + this.getInstances() + ", kind=" + this.getKind() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
