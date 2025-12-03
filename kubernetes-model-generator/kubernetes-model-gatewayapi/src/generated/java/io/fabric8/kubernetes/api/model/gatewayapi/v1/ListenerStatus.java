
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
 * ListenerStatus is the status associated with a Listener.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachedRoutes",
    "conditions",
    "name",
    "supportedKinds"
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
public class ListenerStatus implements Editable<ListenerStatusBuilder>, KubernetesResource
{

    @JsonProperty("attachedRoutes")
    private Integer attachedRoutes;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("supportedKinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteGroupKind> supportedKinds = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerStatus() {
    }

    public ListenerStatus(Integer attachedRoutes, List<Condition> conditions, String name, List<RouteGroupKind> supportedKinds) {
        super();
        this.attachedRoutes = attachedRoutes;
        this.conditions = conditions;
        this.name = name;
        this.supportedKinds = supportedKinds;
    }

    /**
     * AttachedRoutes represents the total number of Routes that have been successfully attached to this Listener.<br><p> <br><p> Successful attachment of a Route to a Listener is based solely on the combination of the AllowedRoutes field on the corresponding Listener and the Route's ParentRefs field. A Route is successfully attached to a Listener when it is selected by the Listener's AllowedRoutes field AND the Route has a valid ParentRef selecting the whole Gateway resource or a specific Listener as a parent resource (more detail on attachment semantics can be found in the documentation on the various Route kinds ParentRefs fields). Listener or Route status does not impact successful attachment, i.e. the AttachedRoutes field count MUST be set for Listeners with condition Accepted: false and MUST count successfully attached Routes that may themselves have Accepted: false conditions.<br><p> <br><p> Uses for this field include troubleshooting Route attachment and measuring blast radius/impact of changes to a Listener.
     */
    @JsonProperty("attachedRoutes")
    public Integer getAttachedRoutes() {
        return attachedRoutes;
    }

    /**
     * AttachedRoutes represents the total number of Routes that have been successfully attached to this Listener.<br><p> <br><p> Successful attachment of a Route to a Listener is based solely on the combination of the AllowedRoutes field on the corresponding Listener and the Route's ParentRefs field. A Route is successfully attached to a Listener when it is selected by the Listener's AllowedRoutes field AND the Route has a valid ParentRef selecting the whole Gateway resource or a specific Listener as a parent resource (more detail on attachment semantics can be found in the documentation on the various Route kinds ParentRefs fields). Listener or Route status does not impact successful attachment, i.e. the AttachedRoutes field count MUST be set for Listeners with condition Accepted: false and MUST count successfully attached Routes that may themselves have Accepted: false conditions.<br><p> <br><p> Uses for this field include troubleshooting Route attachment and measuring blast radius/impact of changes to a Listener.
     */
    @JsonProperty("attachedRoutes")
    public void setAttachedRoutes(Integer attachedRoutes) {
        this.attachedRoutes = attachedRoutes;
    }

    /**
     * Conditions describe the current condition of this listener.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; Notes for implementors:<br><p> <br><p> Conditions are a listType `map`, which means that they function like a map with a key of the `type` field _in the k8s apiserver_.<br><p> <br><p> This means that implementations must obey some rules when updating this section.<br><p> <br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> &#42; Implementations MUST NOT remove or reorder Conditions that they are not<br><p>   directly responsible for. For example, if an implementation sees a Condition<br><p>   with type `special.io/SomeField`, it MUST NOT remove, change or update that<br><p>   Condition.<br><p> &#42; Implementations MUST always _merge_ changes into Conditions of the same Type,<br><p>   rather than creating more than one Condition of the same Type.<br><p> &#42; Implementations MUST always update the `observedGeneration` field of the<br><p>   Condition to the `metadata.generation` of the Gateway at the time of update creation.<br><p> &#42; If the `observedGeneration` of a Condition is _greater than_ the value the<br><p>   implementation knows about, then it MUST NOT perform the update on that Condition,<br><p>   but must wait for a future reconciliation and status update. (The assumption is that<br><p>   the implementation's copy of the object is stale and an update will be re-triggered<br><p>   if relevant.)<br><p> <br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions describe the current condition of this listener.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; Notes for implementors:<br><p> <br><p> Conditions are a listType `map`, which means that they function like a map with a key of the `type` field _in the k8s apiserver_.<br><p> <br><p> This means that implementations must obey some rules when updating this section.<br><p> <br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> &#42; Implementations MUST NOT remove or reorder Conditions that they are not<br><p>   directly responsible for. For example, if an implementation sees a Condition<br><p>   with type `special.io/SomeField`, it MUST NOT remove, change or update that<br><p>   Condition.<br><p> &#42; Implementations MUST always _merge_ changes into Conditions of the same Type,<br><p>   rather than creating more than one Condition of the same Type.<br><p> &#42; Implementations MUST always update the `observedGeneration` field of the<br><p>   Condition to the `metadata.generation` of the Gateway at the time of update creation.<br><p> &#42; If the `observedGeneration` of a Condition is _greater than_ the value the<br><p>   implementation knows about, then it MUST NOT perform the update on that Condition,<br><p>   but must wait for a future reconciliation and status update. (The assumption is that<br><p>   the implementation's copy of the object is stale and an update will be re-triggered<br><p>   if relevant.)<br><p> <br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Name is the name of the Listener that this status corresponds to.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the Listener that this status corresponds to.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * SupportedKinds is the list indicating the Kinds supported by this listener. This MUST represent the kinds an implementation supports for that Listener configuration.<br><p> <br><p> If kinds are specified in Spec that are not supported, they MUST NOT appear in this list and an implementation MUST set the "ResolvedRefs" condition to "False" with the "InvalidRouteKinds" reason. If both valid and invalid Route kinds are specified, the implementation MUST reference the valid Route kinds that have been specified.
     */
    @JsonProperty("supportedKinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteGroupKind> getSupportedKinds() {
        return supportedKinds;
    }

    /**
     * SupportedKinds is the list indicating the Kinds supported by this listener. This MUST represent the kinds an implementation supports for that Listener configuration.<br><p> <br><p> If kinds are specified in Spec that are not supported, they MUST NOT appear in this list and an implementation MUST set the "ResolvedRefs" condition to "False" with the "InvalidRouteKinds" reason. If both valid and invalid Route kinds are specified, the implementation MUST reference the valid Route kinds that have been specified.
     */
    @JsonProperty("supportedKinds")
    public void setSupportedKinds(List<RouteGroupKind> supportedKinds) {
        this.supportedKinds = supportedKinds;
    }

    @JsonIgnore
    public ListenerStatusBuilder edit() {
        return new ListenerStatusBuilder(this);
    }

    @JsonIgnore
    public ListenerStatusBuilder toBuilder() {
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
