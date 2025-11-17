
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
 * GatewayStatus defines the observed state of Gateway.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "conditions",
    "listeners"
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
public class GatewayStatus implements Editable<GatewayStatusBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GatewayStatusAddress> addresses = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("listeners")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ListenerStatus> listeners = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatewayStatus() {
    }

    public GatewayStatus(List<GatewayStatusAddress> addresses, List<Condition> conditions, List<ListenerStatus> listeners) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.listeners = listeners;
    }

    /**
     * Addresses lists the network addresses that have been bound to the Gateway.<br><p> <br><p> This list may differ from the addresses provided in the spec under some conditions:<br><p> <br><p>   &#42; no addresses are specified, all addresses are dynamically assigned<br><p>   &#42; a combination of specified and dynamic addresses are assigned<br><p>   &#42; a specified address was unusable (e.g. already in use)<br><p> <br><p> &lt;gateway:validateIPAddress&gt;
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GatewayStatusAddress> getAddresses() {
        return addresses;
    }

    /**
     * Addresses lists the network addresses that have been bound to the Gateway.<br><p> <br><p> This list may differ from the addresses provided in the spec under some conditions:<br><p> <br><p>   &#42; no addresses are specified, all addresses are dynamically assigned<br><p>   &#42; a combination of specified and dynamic addresses are assigned<br><p>   &#42; a specified address was unusable (e.g. already in use)<br><p> <br><p> &lt;gateway:validateIPAddress&gt;
     */
    @JsonProperty("addresses")
    public void setAddresses(List<GatewayStatusAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * Conditions describe the current conditions of the Gateway.<br><p> <br><p> Implementations should prefer to express Gateway conditions using the `GatewayConditionType` and `GatewayConditionReason` constants so that operators and tools can converge on a common vocabulary to describe Gateway state.<br><p> <br><p> Known condition types are:<br><p> <br><p> &#42; "Accepted" &#42; "Programmed" &#42; "Ready"<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; Notes for implementors:<br><p> <br><p> Conditions are a listType `map`, which means that they function like a map with a key of the `type` field _in the k8s apiserver_.<br><p> <br><p> This means that implementations must obey some rules when updating this section.<br><p> <br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> &#42; Implementations MUST NOT remove or reorder Conditions that they are not<br><p>   directly responsible for. For example, if an implementation sees a Condition<br><p>   with type `special.io/SomeField`, it MUST NOT remove, change or update that<br><p>   Condition.<br><p> &#42; Implementations MUST always _merge_ changes into Conditions of the same Type,<br><p>   rather than creating more than one Condition of the same Type.<br><p> &#42; Implementations MUST always update the `observedGeneration` field of the<br><p>   Condition to the `metadata.generation` of the Gateway at the time of update creation.<br><p> &#42; If the `observedGeneration` of a Condition is _greater than_ the value the<br><p>   implementation knows about, then it MUST NOT perform the update on that Condition,<br><p>   but must wait for a future reconciliation and status update. (The assumption is that<br><p>   the implementation's copy of the object is stale and an update will be re-triggered<br><p>   if relevant.)<br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions describe the current conditions of the Gateway.<br><p> <br><p> Implementations should prefer to express Gateway conditions using the `GatewayConditionType` and `GatewayConditionReason` constants so that operators and tools can converge on a common vocabulary to describe Gateway state.<br><p> <br><p> Known condition types are:<br><p> <br><p> &#42; "Accepted" &#42; "Programmed" &#42; "Ready"<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; Notes for implementors:<br><p> <br><p> Conditions are a listType `map`, which means that they function like a map with a key of the `type` field _in the k8s apiserver_.<br><p> <br><p> This means that implementations must obey some rules when updating this section.<br><p> <br><p> &#42; Implementations MUST perform a read-modify-write cycle on this field<br><p>   before modifying it. That is, when modifying this field, implementations<br><p>   must be confident they have fetched the most recent version of this field,<br><p>   and ensure that changes they make are on that recent version.<br><p> &#42; Implementations MUST NOT remove or reorder Conditions that they are not<br><p>   directly responsible for. For example, if an implementation sees a Condition<br><p>   with type `special.io/SomeField`, it MUST NOT remove, change or update that<br><p>   Condition.<br><p> &#42; Implementations MUST always _merge_ changes into Conditions of the same Type,<br><p>   rather than creating more than one Condition of the same Type.<br><p> &#42; Implementations MUST always update the `observedGeneration` field of the<br><p>   Condition to the `metadata.generation` of the Gateway at the time of update creation.<br><p> &#42; If the `observedGeneration` of a Condition is _greater than_ the value the<br><p>   implementation knows about, then it MUST NOT perform the update on that Condition,<br><p>   but must wait for a future reconciliation and status update. (The assumption is that<br><p>   the implementation's copy of the object is stale and an update will be re-triggered<br><p>   if relevant.)<br><p> &lt;/gateway:util:excludeFromCRD&gt;
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Listeners provide status for each unique listener port defined in the Spec.
     */
    @JsonProperty("listeners")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ListenerStatus> getListeners() {
        return listeners;
    }

    /**
     * Listeners provide status for each unique listener port defined in the Spec.
     */
    @JsonProperty("listeners")
    public void setListeners(List<ListenerStatus> listeners) {
        this.listeners = listeners;
    }

    @JsonIgnore
    public GatewayStatusBuilder edit() {
        return new GatewayStatusBuilder(this);
    }

    @JsonIgnore
    public GatewayStatusBuilder toBuilder() {
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
