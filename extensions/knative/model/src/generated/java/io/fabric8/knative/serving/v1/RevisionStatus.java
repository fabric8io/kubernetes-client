
package io.fabric8.knative.serving.v1;

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
import io.fabric8.knative.pkg.apis.Condition;
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
 * RevisionStatus communicates the observed state of the Revision (from the controller).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actualReplicas",
    "annotations",
    "conditions",
    "containerStatuses",
    "desiredReplicas",
    "initContainerStatuses",
    "logUrl",
    "observedGeneration"
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
public class RevisionStatus implements Editable<RevisionStatusBuilder>, KubernetesResource
{

    @JsonProperty("actualReplicas")
    private Integer actualReplicas;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> containerStatuses = new ArrayList<>();
    @JsonProperty("desiredReplicas")
    private Integer desiredReplicas;
    @JsonProperty("initContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> initContainerStatuses = new ArrayList<>();
    @JsonProperty("logUrl")
    private String logUrl;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RevisionStatus() {
    }

    public RevisionStatus(Integer actualReplicas, Map<String, String> annotations, List<Condition> conditions, List<ContainerStatus> containerStatuses, Integer desiredReplicas, List<ContainerStatus> initContainerStatuses, String logUrl, Long observedGeneration) {
        super();
        this.actualReplicas = actualReplicas;
        this.annotations = annotations;
        this.conditions = conditions;
        this.containerStatuses = containerStatuses;
        this.desiredReplicas = desiredReplicas;
        this.initContainerStatuses = initContainerStatuses;
        this.logUrl = logUrl;
        this.observedGeneration = observedGeneration;
    }

    /**
     * ActualReplicas reflects the amount of ready pods running this revision.
     */
    @JsonProperty("actualReplicas")
    public Integer getActualReplicas() {
        return actualReplicas;
    }

    /**
     * ActualReplicas reflects the amount of ready pods running this revision.
     */
    @JsonProperty("actualReplicas")
    public void setActualReplicas(Integer actualReplicas) {
        this.actualReplicas = actualReplicas;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ContainerStatuses is a slice of images present in .Spec.Container[&#42;].Image to their respective digests and their container name. The digests are resolved during the creation of Revision. ContainerStatuses holds the container name and image digests for both serving and non serving containers. ref: https://bit.ly/image-digests
     */
    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getContainerStatuses() {
        return containerStatuses;
    }

    /**
     * ContainerStatuses is a slice of images present in .Spec.Container[&#42;].Image to their respective digests and their container name. The digests are resolved during the creation of Revision. ContainerStatuses holds the container name and image digests for both serving and non serving containers. ref: https://bit.ly/image-digests
     */
    @JsonProperty("containerStatuses")
    public void setContainerStatuses(List<ContainerStatus> containerStatuses) {
        this.containerStatuses = containerStatuses;
    }

    /**
     * DesiredReplicas reflects the desired amount of pods running this revision.
     */
    @JsonProperty("desiredReplicas")
    public Integer getDesiredReplicas() {
        return desiredReplicas;
    }

    /**
     * DesiredReplicas reflects the desired amount of pods running this revision.
     */
    @JsonProperty("desiredReplicas")
    public void setDesiredReplicas(Integer desiredReplicas) {
        this.desiredReplicas = desiredReplicas;
    }

    /**
     * InitContainerStatuses is a slice of images present in .Spec.InitContainer[&#42;].Image to their respective digests and their container name. The digests are resolved during the creation of Revision. ContainerStatuses holds the container name and image digests for both serving and non serving containers. ref: https://bit.ly/image-digests
     */
    @JsonProperty("initContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getInitContainerStatuses() {
        return initContainerStatuses;
    }

    /**
     * InitContainerStatuses is a slice of images present in .Spec.InitContainer[&#42;].Image to their respective digests and their container name. The digests are resolved during the creation of Revision. ContainerStatuses holds the container name and image digests for both serving and non serving containers. ref: https://bit.ly/image-digests
     */
    @JsonProperty("initContainerStatuses")
    public void setInitContainerStatuses(List<ContainerStatus> initContainerStatuses) {
        this.initContainerStatuses = initContainerStatuses;
    }

    /**
     * LogURL specifies the generated logging url for this particular revision based on the revision url template specified in the controller's config.
     */
    @JsonProperty("logUrl")
    public String getLogUrl() {
        return logUrl;
    }

    /**
     * LogURL specifies the generated logging url for this particular revision based on the revision url template specified in the controller's config.
     */
    @JsonProperty("logUrl")
    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonIgnore
    public RevisionStatusBuilder edit() {
        return new RevisionStatusBuilder(this);
    }

    @JsonIgnore
    public RevisionStatusBuilder toBuilder() {
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
        if (!(o instanceof RevisionStatus)) {
            return false;
        }
        RevisionStatus other = (RevisionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actualReplicas = this.getActualReplicas();
        Object other$actualReplicas = other.getActualReplicas();
        if (this$actualReplicas == null ? other$actualReplicas != null : !this$actualReplicas.equals(other$actualReplicas)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$containerStatuses = this.getContainerStatuses();
        Object other$containerStatuses = other.getContainerStatuses();
        if (this$containerStatuses == null ? other$containerStatuses != null : !this$containerStatuses.equals(other$containerStatuses)) {
            return false;
        }
        Object this$desiredReplicas = this.getDesiredReplicas();
        Object other$desiredReplicas = other.getDesiredReplicas();
        if (this$desiredReplicas == null ? other$desiredReplicas != null : !this$desiredReplicas.equals(other$desiredReplicas)) {
            return false;
        }
        Object this$initContainerStatuses = this.getInitContainerStatuses();
        Object other$initContainerStatuses = other.getInitContainerStatuses();
        if (this$initContainerStatuses == null ? other$initContainerStatuses != null : !this$initContainerStatuses.equals(other$initContainerStatuses)) {
            return false;
        }
        Object this$logUrl = this.getLogUrl();
        Object other$logUrl = other.getLogUrl();
        if (this$logUrl == null ? other$logUrl != null : !this$logUrl.equals(other$logUrl)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
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
        return other instanceof RevisionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actualReplicas = this.getActualReplicas();
        result = result * prime + ($actualReplicas == null ? 43 : $actualReplicas.hashCode());
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $containerStatuses = this.getContainerStatuses();
        result = result * prime + ($containerStatuses == null ? 43 : $containerStatuses.hashCode());
        Object $desiredReplicas = this.getDesiredReplicas();
        result = result * prime + ($desiredReplicas == null ? 43 : $desiredReplicas.hashCode());
        Object $initContainerStatuses = this.getInitContainerStatuses();
        result = result * prime + ($initContainerStatuses == null ? 43 : $initContainerStatuses.hashCode());
        Object $logUrl = this.getLogUrl();
        result = result * prime + ($logUrl == null ? 43 : $logUrl.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RevisionStatus(" + "actualReplicas=" + this.getActualReplicas() + ", annotations=" + this.getAnnotations() + ", conditions=" + this.getConditions() + ", containerStatuses=" + this.getContainerStatuses() + ", desiredReplicas=" + this.getDesiredReplicas() + ", initContainerStatuses=" + this.getInitContainerStatuses() + ", logUrl=" + this.getLogUrl() + ", observedGeneration=" + this.getObservedGeneration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
