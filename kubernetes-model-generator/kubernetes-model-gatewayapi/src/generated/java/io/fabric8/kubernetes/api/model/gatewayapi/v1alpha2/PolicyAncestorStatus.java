
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

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
import io.fabric8.kubernetes.api.model.gatewayapi.v1.ParentReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PolicyAncestorStatus describes the status of a route with respect to an associated Ancestor.<br><p> <br><p> Ancestors refer to objects that are either the Target of a policy or above it in terms of object hierarchy. For example, if a policy targets a Service, the Policy's Ancestors are, in order, the Service, the HTTPRoute, the Gateway, and the GatewayClass. Almost always, in this hierarchy, the Gateway will be the most useful object to place Policy status on, so we recommend that implementations SHOULD use Gateway as the PolicyAncestorStatus object unless the designers have a _very_ good reason otherwise.<br><p> <br><p> In the context of policy attachment, the Ancestor is used to distinguish which resource results in a distinct application of this policy. For example, if a policy targets a Service, it may have a distinct result per attached Gateway.<br><p> <br><p> Policies targeting the same resource may have different effects depending on the ancestors of those resources. For example, different Gateways targeting the same Service may have different capabilities, especially if they have different underlying implementations.<br><p> <br><p> For example, in BackendTLSPolicy, the Policy attaches to a Service that is used as a backend in a HTTPRoute that is itself attached to a Gateway. In this case, the relevant object for status is the Gateway, and that is the ancestor object referred to in this status.<br><p> <br><p> Note that a parent is also an ancestor, so for objects where the parent is the relevant object for status, this struct SHOULD still be used.<br><p> <br><p> This struct is intended to be used in a slice that's effectively a map, with a composite key made up of the AncestorRef and the ControllerName.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ancestorRef",
    "conditions",
    "controllerName"
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
public class PolicyAncestorStatus implements Editable<PolicyAncestorStatusBuilder>, KubernetesResource
{

    @JsonProperty("ancestorRef")
    private ParentReference ancestorRef;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("controllerName")
    private String controllerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyAncestorStatus() {
    }

    public PolicyAncestorStatus(ParentReference ancestorRef, List<Condition> conditions, String controllerName) {
        super();
        this.ancestorRef = ancestorRef;
        this.conditions = conditions;
        this.controllerName = controllerName;
    }

    /**
     * PolicyAncestorStatus describes the status of a route with respect to an associated Ancestor.<br><p> <br><p> Ancestors refer to objects that are either the Target of a policy or above it in terms of object hierarchy. For example, if a policy targets a Service, the Policy's Ancestors are, in order, the Service, the HTTPRoute, the Gateway, and the GatewayClass. Almost always, in this hierarchy, the Gateway will be the most useful object to place Policy status on, so we recommend that implementations SHOULD use Gateway as the PolicyAncestorStatus object unless the designers have a _very_ good reason otherwise.<br><p> <br><p> In the context of policy attachment, the Ancestor is used to distinguish which resource results in a distinct application of this policy. For example, if a policy targets a Service, it may have a distinct result per attached Gateway.<br><p> <br><p> Policies targeting the same resource may have different effects depending on the ancestors of those resources. For example, different Gateways targeting the same Service may have different capabilities, especially if they have different underlying implementations.<br><p> <br><p> For example, in BackendTLSPolicy, the Policy attaches to a Service that is used as a backend in a HTTPRoute that is itself attached to a Gateway. In this case, the relevant object for status is the Gateway, and that is the ancestor object referred to in this status.<br><p> <br><p> Note that a parent is also an ancestor, so for objects where the parent is the relevant object for status, this struct SHOULD still be used.<br><p> <br><p> This struct is intended to be used in a slice that's effectively a map, with a composite key made up of the AncestorRef and the ControllerName.
     */
    @JsonProperty("ancestorRef")
    public ParentReference getAncestorRef() {
        return ancestorRef;
    }

    /**
     * PolicyAncestorStatus describes the status of a route with respect to an associated Ancestor.<br><p> <br><p> Ancestors refer to objects that are either the Target of a policy or above it in terms of object hierarchy. For example, if a policy targets a Service, the Policy's Ancestors are, in order, the Service, the HTTPRoute, the Gateway, and the GatewayClass. Almost always, in this hierarchy, the Gateway will be the most useful object to place Policy status on, so we recommend that implementations SHOULD use Gateway as the PolicyAncestorStatus object unless the designers have a _very_ good reason otherwise.<br><p> <br><p> In the context of policy attachment, the Ancestor is used to distinguish which resource results in a distinct application of this policy. For example, if a policy targets a Service, it may have a distinct result per attached Gateway.<br><p> <br><p> Policies targeting the same resource may have different effects depending on the ancestors of those resources. For example, different Gateways targeting the same Service may have different capabilities, especially if they have different underlying implementations.<br><p> <br><p> For example, in BackendTLSPolicy, the Policy attaches to a Service that is used as a backend in a HTTPRoute that is itself attached to a Gateway. In this case, the relevant object for status is the Gateway, and that is the ancestor object referred to in this status.<br><p> <br><p> Note that a parent is also an ancestor, so for objects where the parent is the relevant object for status, this struct SHOULD still be used.<br><p> <br><p> This struct is intended to be used in a slice that's effectively a map, with a composite key made up of the AncestorRef and the ControllerName.
     */
    @JsonProperty("ancestorRef")
    public void setAncestorRef(ParentReference ancestorRef) {
        this.ancestorRef = ancestorRef;
    }

    /**
     * Conditions describes the status of the Policy with respect to the given Ancestor.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions describes the status of the Policy with respect to the given Ancestor.
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

    @JsonIgnore
    public PolicyAncestorStatusBuilder edit() {
        return new PolicyAncestorStatusBuilder(this);
    }

    @JsonIgnore
    public PolicyAncestorStatusBuilder toBuilder() {
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
