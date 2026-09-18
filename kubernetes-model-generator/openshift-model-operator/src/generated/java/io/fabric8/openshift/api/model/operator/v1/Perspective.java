
package io.fabric8.openshift.api.model.operator.v1;

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
 * Perspective defines a perspective that cluster admins want to show/hide in the perspective switcher dropdown
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "pinnedResources",
    "visibility"
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
public class Perspective implements Editable<PerspectiveBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("pinnedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PinnedResourceReference> pinnedResources = new ArrayList<>();
    @JsonProperty("visibility")
    private PerspectiveVisibility visibility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Perspective() {
    }

    public Perspective(String id, List<PinnedResourceReference> pinnedResources, PerspectiveVisibility visibility) {
        super();
        this.id = id;
        this.pinnedResources = pinnedResources;
        this.visibility = visibility;
    }

    /**
     * id defines the id of the perspective. Example: "dev", "admin". The available perspective ids can be found in the code snippet section next to the yaml editor. Incorrect or unknown ids will be ignored.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * id defines the id of the perspective. Example: "dev", "admin". The available perspective ids can be found in the code snippet section next to the yaml editor. Incorrect or unknown ids will be ignored.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * pinnedResources defines the list of default pinned resources that users will see on the perspective navigation if they have not customized these pinned resources themselves. The list of available Kubernetes resources could be read via `kubectl api-resources`. The console will also provide a configuration UI and a YAML snippet that will list the available resources that can be pinned to the navigation. Incorrect or unknown resources will be ignored.
     */
    @JsonProperty("pinnedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PinnedResourceReference> getPinnedResources() {
        return pinnedResources;
    }

    /**
     * pinnedResources defines the list of default pinned resources that users will see on the perspective navigation if they have not customized these pinned resources themselves. The list of available Kubernetes resources could be read via `kubectl api-resources`. The console will also provide a configuration UI and a YAML snippet that will list the available resources that can be pinned to the navigation. Incorrect or unknown resources will be ignored.
     */
    @JsonProperty("pinnedResources")
    public void setPinnedResources(List<PinnedResourceReference> pinnedResources) {
        this.pinnedResources = pinnedResources;
    }

    /**
     * Perspective defines a perspective that cluster admins want to show/hide in the perspective switcher dropdown
     */
    @JsonProperty("visibility")
    public PerspectiveVisibility getVisibility() {
        return visibility;
    }

    /**
     * Perspective defines a perspective that cluster admins want to show/hide in the perspective switcher dropdown
     */
    @JsonProperty("visibility")
    public void setVisibility(PerspectiveVisibility visibility) {
        this.visibility = visibility;
    }

    @JsonIgnore
    public PerspectiveBuilder edit() {
        return new PerspectiveBuilder(this);
    }

    @JsonIgnore
    public PerspectiveBuilder toBuilder() {
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
        if (!(o instanceof Perspective)) {
            return false;
        }
        Perspective other = (Perspective) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$pinnedResources = this.getPinnedResources();
        Object other$pinnedResources = other.getPinnedResources();
        if (this$pinnedResources == null ? other$pinnedResources != null : !this$pinnedResources.equals(other$pinnedResources)) {
            return false;
        }
        Object this$visibility = this.getVisibility();
        Object other$visibility = other.getVisibility();
        if (this$visibility == null ? other$visibility != null : !this$visibility.equals(other$visibility)) {
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
        return other instanceof Perspective;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $pinnedResources = this.getPinnedResources();
        result = result * prime + ($pinnedResources == null ? 43 : $pinnedResources.hashCode());
        Object $visibility = this.getVisibility();
        result = result * prime + ($visibility == null ? 43 : $visibility.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Perspective(" + "id=" + this.getId() + ", pinnedResources=" + this.getPinnedResources() + ", visibility=" + this.getVisibility() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
