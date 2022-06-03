
package io.fabric8.knative.serving.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.internal.pkg.apis.Condition;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "actualReplicas",
    "annotations",
    "conditions",
    "containerStatuses",
    "desiredReplicas",
    "imageDigest",
    "logUrl",
    "observedGeneration",
    "serviceName"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class RevisionStatus implements KubernetesResource
{

    @JsonProperty("actualReplicas")
    private Integer actualReplicas;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> containerStatuses = new ArrayList<ContainerStatus>();
    @JsonProperty("desiredReplicas")
    private Integer desiredReplicas;
    @JsonProperty("imageDigest")
    private java.lang.String imageDigest;
    @JsonProperty("logUrl")
    private java.lang.String logUrl;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("serviceName")
    private java.lang.String serviceName;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RevisionStatus() {
    }

    /**
     * 
     * @param containerStatuses
     * @param desiredReplicas
     * @param annotations
     * @param actualReplicas
     * @param conditions
     * @param logUrl
     * @param serviceName
     * @param observedGeneration
     * @param imageDigest
     */
    public RevisionStatus(Integer actualReplicas, Map<String, String> annotations, List<Condition> conditions, List<ContainerStatus> containerStatuses, Integer desiredReplicas, java.lang.String imageDigest, java.lang.String logUrl, Long observedGeneration, java.lang.String serviceName) {
        super();
        this.actualReplicas = actualReplicas;
        this.annotations = annotations;
        this.conditions = conditions;
        this.containerStatuses = containerStatuses;
        this.desiredReplicas = desiredReplicas;
        this.imageDigest = imageDigest;
        this.logUrl = logUrl;
        this.observedGeneration = observedGeneration;
        this.serviceName = serviceName;
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
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("containerStatuses")
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

    @JsonProperty("imageDigest")
    public java.lang.String getImageDigest() {
        return imageDigest;
    }

    @JsonProperty("imageDigest")
    public void setImageDigest(java.lang.String imageDigest) {
        this.imageDigest = imageDigest;
    }

    @JsonProperty("logUrl")
    public java.lang.String getLogUrl() {
        return logUrl;
    }

    @JsonProperty("logUrl")
    public void setLogUrl(java.lang.String logUrl) {
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

    @JsonProperty("serviceName")
    public java.lang.String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
