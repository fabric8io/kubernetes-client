
package io.fabric8.knative.serving.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
public class RevisionStatus implements Editable<RevisionStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("actualReplicas")
    public Integer getActualReplicas() {
        return actualReplicas;
    }

    @JsonProperty("actualReplicas")
    public void setActualReplicas(Integer actualReplicas) {
        this.actualReplicas = actualReplicas;
    }

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getContainerStatuses() {
        return containerStatuses;
    }

    @JsonProperty("containerStatuses")
    public void setContainerStatuses(List<ContainerStatus> containerStatuses) {
        this.containerStatuses = containerStatuses;
    }

    @JsonProperty("desiredReplicas")
    public Integer getDesiredReplicas() {
        return desiredReplicas;
    }

    @JsonProperty("desiredReplicas")
    public void setDesiredReplicas(Integer desiredReplicas) {
        this.desiredReplicas = desiredReplicas;
    }

    @JsonProperty("initContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getInitContainerStatuses() {
        return initContainerStatuses;
    }

    @JsonProperty("initContainerStatuses")
    public void setInitContainerStatuses(List<ContainerStatus> initContainerStatuses) {
        this.initContainerStatuses = initContainerStatuses;
    }

    @JsonProperty("logUrl")
    public String getLogUrl() {
        return logUrl;
    }

    @JsonProperty("logUrl")
    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

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
