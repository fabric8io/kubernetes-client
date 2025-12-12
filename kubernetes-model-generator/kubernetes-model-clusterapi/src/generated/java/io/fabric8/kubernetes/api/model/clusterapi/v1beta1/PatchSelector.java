
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * PatchSelector defines on which templates the patch should be applied. Note: Matching on APIVersion and Kind is mandatory, to enforce that the patches are written for the correct version. The version of the references in the ClusterClass may be automatically updated during reconciliation if there is a newer version for the same contract. Note: The results of selection based on the individual fields are ANDed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "matchResources"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class PatchSelector implements Editable<PatchSelectorBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("matchResources")
    private PatchSelectorMatch matchResources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PatchSelector() {
    }

    public PatchSelector(String apiVersion, String kind, PatchSelectorMatch matchResources) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.matchResources = matchResources;
    }

    /**
     * apiVersion filters templates by apiVersion.
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * apiVersion filters templates by apiVersion.
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * kind filters templates by kind.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * kind filters templates by kind.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * PatchSelector defines on which templates the patch should be applied. Note: Matching on APIVersion and Kind is mandatory, to enforce that the patches are written for the correct version. The version of the references in the ClusterClass may be automatically updated during reconciliation if there is a newer version for the same contract. Note: The results of selection based on the individual fields are ANDed.
     */
    @JsonProperty("matchResources")
    public PatchSelectorMatch getMatchResources() {
        return matchResources;
    }

    /**
     * PatchSelector defines on which templates the patch should be applied. Note: Matching on APIVersion and Kind is mandatory, to enforce that the patches are written for the correct version. The version of the references in the ClusterClass may be automatically updated during reconciliation if there is a newer version for the same contract. Note: The results of selection based on the individual fields are ANDed.
     */
    @JsonProperty("matchResources")
    public void setMatchResources(PatchSelectorMatch matchResources) {
        this.matchResources = matchResources;
    }

    @JsonIgnore
    public PatchSelectorBuilder edit() {
        return new PatchSelectorBuilder(this);
    }

    @JsonIgnore
    public PatchSelectorBuilder toBuilder() {
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
