
package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Condition;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * EvictionStatus represents the last observed status of the eviction request.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "observedGeneration",
    "requesters",
    "responders",
    "targetResponders"
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
public class EvictionStatus implements Editable<EvictionStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("requesters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Requester> requesters = new ArrayList<>();
    @JsonProperty("responders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResponderStatus> responders = new ArrayList<>();
    @JsonProperty("targetResponders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TargetResponder> targetResponders = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EvictionStatus() {
    }

    public EvictionStatus(List<Condition> conditions, Long observedGeneration, List<Requester> requesters, List<ResponderStatus> responders, List<TargetResponder> targetResponders) {
        super();
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.requesters = requesters;
        this.responders = responders;
        this.targetResponders = targetResponders;
    }

    /**
     * conditions contain information about the eviction request.<br><p> <br><p> Eviction specific conditions are: TargetEvicted or Failed (managed by evictionrequest-controller). - Failed means that the eviction request is no longer being processed<br><p>   by any eviction responder. This can happen if the request is canceled or if no responder<br><p>   managed to evict the target (e.g. terminate or delete a pod).<br><p> - TargetEvicted means that the target has been evicted (e.g. a pod has been terminated or deleted).<br><p> <br><p> 	The maximum length of the conditions list is 100.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions contain information about the eviction request.<br><p> <br><p> Eviction specific conditions are: TargetEvicted or Failed (managed by evictionrequest-controller). - Failed means that the eviction request is no longer being processed<br><p>   by any eviction responder. This can happen if the request is canceled or if no responder<br><p>   managed to evict the target (e.g. terminate or delete a pod).<br><p> - TargetEvicted means that the target has been evicted (e.g. a pod has been terminated or deleted).<br><p> <br><p> 	The maximum length of the conditions list is 100.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * observedGeneration is Eviction's .metadata.generation observed by the evictionrequest-controller. The observed generation value cannot be negative and can only be incremented. The minimum value is 1. This field is managed by evictionrequest-controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is Eviction's .metadata.generation observed by the evictionrequest-controller. The observed generation value cannot be negative and can only be incremented. The minimum value is 1. This field is managed by evictionrequest-controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * requesters allow you to identify the entities, that requested the eviction of the target. If all the requesters withdraw their eviction intent, the eviction will be canceled.<br><p> <br><p> The maximum length of the requesters list is 100. If this limit is exceeded, requesters with Withdrawn intent should be dropped first.
     */
    @JsonProperty("requesters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Requester> getRequesters() {
        return requesters;
    }

    /**
     * requesters allow you to identify the entities, that requested the eviction of the target. If all the requesters withdraw their eviction intent, the eviction will be canceled.<br><p> <br><p> The maximum length of the requesters list is 100. If this limit is exceeded, requesters with Withdrawn intent should be dropped first.
     */
    @JsonProperty("requesters")
    public void setRequesters(List<Requester> requesters) {
        this.requesters = requesters;
    }

    /**
     * responders represents the eviction process status of each declared responder.<br><p> <br><p> The responder list should be the same length and have the same .name fields as .status.targetResponders. Only responders with .name that have Active state in .targetResponders[].state should be updated and can be mutated. First initialization of the list is allowed.<br><p> <br><p> Each ResponderStatus is initialized by evictionrequest-controller and then managed by the designated responder.
     */
    @JsonProperty("responders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResponderStatus> getResponders() {
        return responders;
    }

    /**
     * responders represents the eviction process status of each declared responder.<br><p> <br><p> The responder list should be the same length and have the same .name fields as .status.targetResponders. Only responders with .name that have Active state in .targetResponders[].state should be updated and can be mutated. First initialization of the list is allowed.<br><p> <br><p> Each ResponderStatus is initialized by evictionrequest-controller and then managed by the designated responder.
     */
    @JsonProperty("responders")
    public void setResponders(List<ResponderStatus> responders) {
        this.responders = responders;
    }

    /**
     * targetResponders reference responders that should eventually respond to this eviction to help with the graceful eviction of a target. These responders are selected sequentially, according to their specified priority by setting the Active state to the TargetResponder .state field. The maximum number of active responders allowed is 1. Eventually each responder can end up in an Interrupted, Canceled or, Completed state. Responders should observe these states in order to navigate their lifecycle.<br><p> <br><p> If the target is a pod, the field is populated from Pod's .spec.evictionResponders. Default responders may be added to the list according to the target.<br><p> <br><p> Default responders: - imperative-eviction.k8s.io/evictor responder with a priority of 100 is added to the list if the<br><p>   target is a pod. It will call the imperative Eviction API (pods/&lt;name&gt;/eviction subresource).<br><p>   This call may not succeed due to PodDisruptionBudgets, which may block the pod termination.<br><p>   It will update the responder message and try again with a backoff.<br><p> <br><p> The maximum length of the responders list is 11. The length and keys of the list cannot change once set. This field is managed by evictionrequest-controller.
     */
    @JsonProperty("targetResponders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TargetResponder> getTargetResponders() {
        return targetResponders;
    }

    /**
     * targetResponders reference responders that should eventually respond to this eviction to help with the graceful eviction of a target. These responders are selected sequentially, according to their specified priority by setting the Active state to the TargetResponder .state field. The maximum number of active responders allowed is 1. Eventually each responder can end up in an Interrupted, Canceled or, Completed state. Responders should observe these states in order to navigate their lifecycle.<br><p> <br><p> If the target is a pod, the field is populated from Pod's .spec.evictionResponders. Default responders may be added to the list according to the target.<br><p> <br><p> Default responders: - imperative-eviction.k8s.io/evictor responder with a priority of 100 is added to the list if the<br><p>   target is a pod. It will call the imperative Eviction API (pods/&lt;name&gt;/eviction subresource).<br><p>   This call may not succeed due to PodDisruptionBudgets, which may block the pod termination.<br><p>   It will update the responder message and try again with a backoff.<br><p> <br><p> The maximum length of the responders list is 11. The length and keys of the list cannot change once set. This field is managed by evictionrequest-controller.
     */
    @JsonProperty("targetResponders")
    public void setTargetResponders(List<TargetResponder> targetResponders) {
        this.targetResponders = targetResponders;
    }

    @JsonIgnore
    public EvictionStatusBuilder edit() {
        return new EvictionStatusBuilder(this);
    }

    @JsonIgnore
    public EvictionStatusBuilder toBuilder() {
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
