
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
