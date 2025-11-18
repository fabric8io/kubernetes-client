
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

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
import io.fabric8.kubernetes.api.model.gatewayapi.v1.RouteParentStatus;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TCPRouteStatus defines the observed state of TCPRoute
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parents"
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
public class TCPRouteStatus implements Editable<TCPRouteStatusBuilder>, KubernetesResource
{

    @JsonProperty("parents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteParentStatus> parents = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TCPRouteStatus() {
    }

    public TCPRouteStatus(List<RouteParentStatus> parents) {
        super();
        this.parents = parents;
    }

    /**
     * Parents is a list of parent resources (usually Gateways) that are associated with the route, and the status of the route with respect to each parent. When this route attaches to a parent, the controller that manages the parent must add an entry to this list when the controller first sees the route and should update the entry as appropriate when the route or gateway is modified.<br><p> <br><p> Note that parent references that cannot be resolved by an implementation of this API will not be added to this list. Implementations of this API can only populate Route status for the Gateways/parent resources they are responsible for.<br><p> <br><p> A maximum of 32 Gateways will be represented in this list. An empty list means the route has not been attached to any Gateway.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; Notes for implementors:<br><p> <br><p> While parents is not a listType `map`, this is due to the fact that the list key is not scalar, and Kubernetes is unable to represent this.<br><p> <br><p> Parent status MUST be considered to be namespaced by the combination of the parentRef and controllerName fields, and implementations should keep the following rules in mind when updating this status:<br><p> <br><p> &#42; Implementations MUST update only entries that have a matching value of<br><p>   `controllerName` for that implementation.<br><p> &#42; Implementations MUST NOT update entries with non-matching `controllerName`<br><p>   fields.<br><p> &#42; Implementations MUST treat each `parentRef`` in the Route separately and<br><p>   update its status based on the relationship with that parent.<br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> <br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("parents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteParentStatus> getParents() {
        return parents;
    }

    /**
     * Parents is a list of parent resources (usually Gateways) that are associated with the route, and the status of the route with respect to each parent. When this route attaches to a parent, the controller that manages the parent must add an entry to this list when the controller first sees the route and should update the entry as appropriate when the route or gateway is modified.<br><p> <br><p> Note that parent references that cannot be resolved by an implementation of this API will not be added to this list. Implementations of this API can only populate Route status for the Gateways/parent resources they are responsible for.<br><p> <br><p> A maximum of 32 Gateways will be represented in this list. An empty list means the route has not been attached to any Gateway.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; Notes for implementors:<br><p> <br><p> While parents is not a listType `map`, this is due to the fact that the list key is not scalar, and Kubernetes is unable to represent this.<br><p> <br><p> Parent status MUST be considered to be namespaced by the combination of the parentRef and controllerName fields, and implementations should keep the following rules in mind when updating this status:<br><p> <br><p> &#42; Implementations MUST update only entries that have a matching value of<br><p>   `controllerName` for that implementation.<br><p> &#42; Implementations MUST NOT update entries with non-matching `controllerName`<br><p>   fields.<br><p> &#42; Implementations MUST treat each `parentRef`` in the Route separately and<br><p>   update its status based on the relationship with that parent.<br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> <br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("parents")
    public void setParents(List<RouteParentStatus> parents) {
        this.parents = parents;
    }

    @JsonIgnore
    public TCPRouteStatusBuilder edit() {
        return new TCPRouteStatusBuilder(this);
    }

    @JsonIgnore
    public TCPRouteStatusBuilder toBuilder() {
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
