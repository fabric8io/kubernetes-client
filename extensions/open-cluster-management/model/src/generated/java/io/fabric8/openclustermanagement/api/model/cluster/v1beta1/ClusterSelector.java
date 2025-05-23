
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
 * ClusterSelector represents the AND of the containing selectors. An empty cluster selector matches all objects. A null cluster selector matches no objects.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claimSelector",
    "labelSelector"
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
public class ClusterSelector implements Editable<ClusterSelectorBuilder>, KubernetesResource
{

    @JsonProperty("claimSelector")
    private ClusterClaimSelector claimSelector;
    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterSelector() {
    }

    public ClusterSelector(ClusterClaimSelector claimSelector, LabelSelector labelSelector) {
        super();
        this.claimSelector = claimSelector;
        this.labelSelector = labelSelector;
    }

    /**
     * ClusterSelector represents the AND of the containing selectors. An empty cluster selector matches all objects. A null cluster selector matches no objects.
     */
    @JsonProperty("claimSelector")
    public ClusterClaimSelector getClaimSelector() {
        return claimSelector;
    }

    /**
     * ClusterSelector represents the AND of the containing selectors. An empty cluster selector matches all objects. A null cluster selector matches no objects.
     */
    @JsonProperty("claimSelector")
    public void setClaimSelector(ClusterClaimSelector claimSelector) {
        this.claimSelector = claimSelector;
    }

    /**
     * ClusterSelector represents the AND of the containing selectors. An empty cluster selector matches all objects. A null cluster selector matches no objects.
     */
    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    /**
     * ClusterSelector represents the AND of the containing selectors. An empty cluster selector matches all objects. A null cluster selector matches no objects.
     */
    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    @JsonIgnore
    public ClusterSelectorBuilder edit() {
        return new ClusterSelectorBuilder(this);
    }

    @JsonIgnore
    public ClusterSelectorBuilder toBuilder() {
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
