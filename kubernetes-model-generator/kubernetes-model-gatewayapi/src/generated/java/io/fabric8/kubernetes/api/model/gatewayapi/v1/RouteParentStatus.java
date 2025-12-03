
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * RouteParentStatus describes the status of a route with respect to an associated Parent.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "controllerName",
    "parentRef"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RouteParentStatus implements Editable<RouteParentStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("controllerName")
    private String controllerName;
    @JsonProperty("parentRef")
    private ParentReference parentRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RouteParentStatus() {
    }

    public RouteParentStatus(List<Condition> conditions, String controllerName, ParentReference parentRef) {
        super();
        this.conditions = conditions;
        this.controllerName = controllerName;
        this.parentRef = parentRef;
    }

    /**
     * Conditions describes the status of the route with respect to the Gateway. Note that the route's availability is also subject to the Gateway's own status conditions and listener status.<br><p> <br><p> If the Route's ParentRef specifies an existing Gateway that supports Routes of this kind AND that Gateway's controller has sufficient access, then that Gateway's controller MUST set the "Accepted" condition on the Route, to indicate whether the route has been accepted or rejected by the Gateway, and why.<br><p> <br><p> A Route MUST be considered "Accepted" if at least one of the Route's rules is implemented by the Gateway.<br><p> <br><p> There are a number of cases where the "Accepted" condition may not be set due to lack of controller visibility, that includes when:<br><p> <br><p> &#42; The Route refers to a nonexistent parent. &#42; The Route is of a type that the controller does not support. &#42; The Route is in a namespace the controller does not have access to.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt;<br><p> <br><p> Notes for implementors:<br><p> <br><p> Conditions are a listType `map`, which means that they function like a map with a key of the `type` field _in the k8s apiserver_.<br><p> <br><p> This means that implementations must obey some rules when updating this section.<br><p> <br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> &#42; Implementations MUST NOT remove or reorder Conditions that they are not<br><p>   directly responsible for. For example, if an implementation sees a Condition<br><p>   with type `special.io/SomeField`, it MUST NOT remove, change or update that<br><p>   Condition.<br><p> &#42; Implementations MUST always _merge_ changes into Conditions of the same Type,<br><p>   rather than creating more than one Condition of the same Type.<br><p> &#42; Implementations MUST always update the `observedGeneration` field of the<br><p>   Condition to the `metadata.generation` of the Gateway at the time of update creation.<br><p> &#42; If the `observedGeneration` of a Condition is _greater than_ the value the<br><p>   implementation knows about, then it MUST NOT perform the update on that Condition,<br><p>   but must wait for a future reconciliation and status update. (The assumption is that<br><p>   the implementation's copy of the object is stale and an update will be re-triggered<br><p>   if relevant.)<br><p> <br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions describes the status of the route with respect to the Gateway. Note that the route's availability is also subject to the Gateway's own status conditions and listener status.<br><p> <br><p> If the Route's ParentRef specifies an existing Gateway that supports Routes of this kind AND that Gateway's controller has sufficient access, then that Gateway's controller MUST set the "Accepted" condition on the Route, to indicate whether the route has been accepted or rejected by the Gateway, and why.<br><p> <br><p> A Route MUST be considered "Accepted" if at least one of the Route's rules is implemented by the Gateway.<br><p> <br><p> There are a number of cases where the "Accepted" condition may not be set due to lack of controller visibility, that includes when:<br><p> <br><p> &#42; The Route refers to a nonexistent parent. &#42; The Route is of a type that the controller does not support. &#42; The Route is in a namespace the controller does not have access to.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt;<br><p> <br><p> Notes for implementors:<br><p> <br><p> Conditions are a listType `map`, which means that they function like a map with a key of the `type` field _in the k8s apiserver_.<br><p> <br><p> This means that implementations must obey some rules when updating this section.<br><p> <br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> &#42; Implementations MUST NOT remove or reorder Conditions that they are not<br><p>   directly responsible for. For example, if an implementation sees a Condition<br><p>   with type `special.io/SomeField`, it MUST NOT remove, change or update that<br><p>   Condition.<br><p> &#42; Implementations MUST always _merge_ changes into Conditions of the same Type,<br><p>   rather than creating more than one Condition of the same Type.<br><p> &#42; Implementations MUST always update the `observedGeneration` field of the<br><p>   Condition to the `metadata.generation` of the Gateway at the time of update creation.<br><p> &#42; If the `observedGeneration` of a Condition is _greater than_ the value the<br><p>   implementation knows about, then it MUST NOT perform the update on that Condition,<br><p>   but must wait for a future reconciliation and status update. (The assumption is that<br><p>   the implementation's copy of the object is stale and an update will be re-triggered<br><p>   if relevant.)<br><p> <br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ControllerName is a domain/path string that indicates the name of the controller that wrote this status. This corresponds with the controllerName field on GatewayClass.<br><p> <br><p> Example: "example.net/gateway-controller".<br><p> <br><p> The format of this field is DOMAIN "/" PATH, where DOMAIN and PATH are valid Kubernetes names (https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names).<br><p> <br><p> Controllers MUST populate this field when writing status. Controllers should ensure that entries to status populated with their ControllerName are cleaned up when they are no longer necessary.
     */
    @JsonProperty("controllerName")
    public String getControllerName() {
        return controllerName;
    }

    /**
     * ControllerName is a domain/path string that indicates the name of the controller that wrote this status. This corresponds with the controllerName field on GatewayClass.<br><p> <br><p> Example: "example.net/gateway-controller".<br><p> <br><p> The format of this field is DOMAIN "/" PATH, where DOMAIN and PATH are valid Kubernetes names (https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names).<br><p> <br><p> Controllers MUST populate this field when writing status. Controllers should ensure that entries to status populated with their ControllerName are cleaned up when they are no longer necessary.
     */
    @JsonProperty("controllerName")
    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    /**
     * RouteParentStatus describes the status of a route with respect to an associated Parent.
     */
    @JsonProperty("parentRef")
    public ParentReference getParentRef() {
        return parentRef;
    }

    /**
     * RouteParentStatus describes the status of a route with respect to an associated Parent.
     */
    @JsonProperty("parentRef")
    public void setParentRef(ParentReference parentRef) {
        this.parentRef = parentRef;
    }

    @JsonIgnore
    public RouteParentStatusBuilder edit() {
        return new RouteParentStatusBuilder(this);
    }

    @JsonIgnore
    public RouteParentStatusBuilder toBuilder() {
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
