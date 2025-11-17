
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
 * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "allowedListeners",
    "defaultScope",
    "gatewayClassName",
    "infrastructure",
    "listeners",
    "tls"
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
public class GatewaySpec implements Editable<GatewaySpecBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GatewaySpecAddress> addresses = new ArrayList<>();
    @JsonProperty("allowedListeners")
    private AllowedListeners allowedListeners;
    @JsonProperty("defaultScope")
    private String defaultScope;
    @JsonProperty("gatewayClassName")
    private String gatewayClassName;
    @JsonProperty("infrastructure")
    private GatewayInfrastructure infrastructure;
    @JsonProperty("listeners")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Listener> listeners = new ArrayList<>();
    @JsonProperty("tls")
    private GatewayTLSConfig tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatewaySpec() {
    }

    public GatewaySpec(List<GatewaySpecAddress> addresses, AllowedListeners allowedListeners, String defaultScope, String gatewayClassName, GatewayInfrastructure infrastructure, List<Listener> listeners, GatewayTLSConfig tls) {
        super();
        this.addresses = addresses;
        this.allowedListeners = allowedListeners;
        this.defaultScope = defaultScope;
        this.gatewayClassName = gatewayClassName;
        this.infrastructure = infrastructure;
        this.listeners = listeners;
        this.tls = tls;
    }

    /**
     * Addresses requested for this Gateway. This is optional and behavior can depend on the implementation. If a value is set in the spec and the requested address is invalid or unavailable, the implementation MUST indicate this in an associated entry in GatewayStatus.Conditions.<br><p> <br><p> The Addresses field represents a request for the address(es) on the "outside of the Gateway", that traffic bound for this Gateway will use. This could be the IP address or hostname of an external load balancer or other networking infrastructure, or some other address that traffic will be sent to.<br><p> <br><p> If no Addresses are specified, the implementation MAY schedule the Gateway in an implementation-specific manner, assigning an appropriate set of Addresses.<br><p> <br><p> The implementation MUST bind all Listeners to every GatewayAddress that it assigns to the Gateway and add a corresponding entry in GatewayStatus.Addresses.<br><p> <br><p> Support: Extended<br><p> <br><p> &lt;gateway:validateIPAddress&gt;
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GatewaySpecAddress> getAddresses() {
        return addresses;
    }

    /**
     * Addresses requested for this Gateway. This is optional and behavior can depend on the implementation. If a value is set in the spec and the requested address is invalid or unavailable, the implementation MUST indicate this in an associated entry in GatewayStatus.Conditions.<br><p> <br><p> The Addresses field represents a request for the address(es) on the "outside of the Gateway", that traffic bound for this Gateway will use. This could be the IP address or hostname of an external load balancer or other networking infrastructure, or some other address that traffic will be sent to.<br><p> <br><p> If no Addresses are specified, the implementation MAY schedule the Gateway in an implementation-specific manner, assigning an appropriate set of Addresses.<br><p> <br><p> The implementation MUST bind all Listeners to every GatewayAddress that it assigns to the Gateway and add a corresponding entry in GatewayStatus.Addresses.<br><p> <br><p> Support: Extended<br><p> <br><p> &lt;gateway:validateIPAddress&gt;
     */
    @JsonProperty("addresses")
    public void setAddresses(List<GatewaySpecAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
     */
    @JsonProperty("allowedListeners")
    public AllowedListeners getAllowedListeners() {
        return allowedListeners;
    }

    /**
     * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
     */
    @JsonProperty("allowedListeners")
    public void setAllowedListeners(AllowedListeners allowedListeners) {
        this.allowedListeners = allowedListeners;
    }

    /**
     * DefaultScope, when set, configures the Gateway as a default Gateway, meaning it will dynamically and implicitly have Routes (e.g. HTTPRoute) attached to it, according to the scope configured here.<br><p> <br><p> If unset (the default) or set to None, the Gateway will not act as a default Gateway; if set, the Gateway will claim any Route with a matching scope set in its UseDefaultGateway field, subject to the usual rules about which routes the Gateway can attach to.<br><p> <br><p> Think carefully before using this functionality! While the normal rules about which Route can apply are still enforced, it is simply easier for the wrong Route to be accidentally attached to this Gateway in this configuration. If the Gateway operator is not also the operator in control of the scope (e.g. namespace) with tight controls and checks on what kind of workloads and Routes get added in that scope, we strongly recommend not using this just because it seems convenient, and instead stick to direct Route attachment.<br><p> <br><p> &lt;gateway:experimental&gt;
     */
    @JsonProperty("defaultScope")
    public String getDefaultScope() {
        return defaultScope;
    }

    /**
     * DefaultScope, when set, configures the Gateway as a default Gateway, meaning it will dynamically and implicitly have Routes (e.g. HTTPRoute) attached to it, according to the scope configured here.<br><p> <br><p> If unset (the default) or set to None, the Gateway will not act as a default Gateway; if set, the Gateway will claim any Route with a matching scope set in its UseDefaultGateway field, subject to the usual rules about which routes the Gateway can attach to.<br><p> <br><p> Think carefully before using this functionality! While the normal rules about which Route can apply are still enforced, it is simply easier for the wrong Route to be accidentally attached to this Gateway in this configuration. If the Gateway operator is not also the operator in control of the scope (e.g. namespace) with tight controls and checks on what kind of workloads and Routes get added in that scope, we strongly recommend not using this just because it seems convenient, and instead stick to direct Route attachment.<br><p> <br><p> &lt;gateway:experimental&gt;
     */
    @JsonProperty("defaultScope")
    public void setDefaultScope(String defaultScope) {
        this.defaultScope = defaultScope;
    }

    /**
     * GatewayClassName used for this Gateway. This is the name of a GatewayClass resource.
     */
    @JsonProperty("gatewayClassName")
    public String getGatewayClassName() {
        return gatewayClassName;
    }

    /**
     * GatewayClassName used for this Gateway. This is the name of a GatewayClass resource.
     */
    @JsonProperty("gatewayClassName")
    public void setGatewayClassName(String gatewayClassName) {
        this.gatewayClassName = gatewayClassName;
    }

    /**
     * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
     */
    @JsonProperty("infrastructure")
    public GatewayInfrastructure getInfrastructure() {
        return infrastructure;
    }

    /**
     * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
     */
    @JsonProperty("infrastructure")
    public void setInfrastructure(GatewayInfrastructure infrastructure) {
        this.infrastructure = infrastructure;
    }

    /**
     * Listeners associated with this Gateway. Listeners define logical endpoints that are bound on this Gateway's addresses. At least one Listener MUST be specified.<br><p> <br><p> ## Distinct Listeners<br><p> <br><p> Each Listener in a set of Listeners (for example, in a single Gateway) MUST be _distinct_, in that a traffic flow MUST be able to be assigned to exactly one listener. (This section uses "set of Listeners" rather than "Listeners in a single Gateway" because implementations MAY merge configuration from multiple Gateways onto a single data plane, and these rules _also_ apply in that case).<br><p> <br><p> Practically, this means that each listener in a set MUST have a unique combination of Port, Protocol, and, if supported by the protocol, Hostname.<br><p> <br><p> Some combinations of port, protocol, and TLS settings are considered Core support and MUST be supported by implementations based on the objects they support:<br><p> <br><p> HTTPRoute<br><p> <br><p> 1. HTTPRoute, Port: 80, Protocol: HTTP 2. HTTPRoute, Port: 443, Protocol: HTTPS, TLS Mode: Terminate, TLS keypair provided<br><p> <br><p> TLSRoute<br><p> <br><p> 1. TLSRoute, Port: 443, Protocol: TLS, TLS Mode: Passthrough<br><p> <br><p> "Distinct" Listeners have the following property:<br><p> <br><p> &#42;&#42;The implementation can match inbound requests to a single distinct Listener&#42;&#42;.<br><p> <br><p> When multiple Listeners share values for fields (for example, two Listeners with the same Port value), the implementation can match requests to only one of the Listeners using other Listener fields.<br><p> <br><p> When multiple listeners have the same value for the Protocol field, then each of the Listeners with matching Protocol values MUST have different values for other fields.<br><p> <br><p> The set of fields that MUST be different for a Listener differs per protocol. The following rules define the rules for what fields MUST be considered for Listeners to be distinct with each protocol currently defined in the Gateway API spec.<br><p> <br><p> The set of listeners that all share a protocol value MUST have _different_ values for _at least one_ of these fields to be distinct:<br><p> <br><p> &#42; &#42;&#42;HTTP, HTTPS, TLS&#42;&#42;: Port, Hostname &#42; &#42;&#42;TCP, UDP&#42;&#42;: Port<br><p> <br><p> One &#42;&#42;very&#42;&#42; important rule to call out involves what happens when an implementation:<br><p> <br><p> &#42; Supports TCP protocol Listeners, as well as HTTP, HTTPS, or TLS protocol<br><p>   Listeners, and<br><p> &#42; sees HTTP, HTTPS, or TLS protocols with the same `port` as one with TCP<br><p>   Protocol.<br><p> <br><p> In this case all the Listeners that share a port with the TCP Listener are not distinct and so MUST NOT be accepted.<br><p> <br><p> If an implementation does not support TCP Protocol Listeners, then the previous rule does not apply, and the TCP Listeners SHOULD NOT be accepted.<br><p> <br><p> Note that the `tls` field is not used for determining if a listener is distinct, because Listeners that _only_ differ on TLS config will still conflict in all cases.<br><p> <br><p> ### Listeners that are distinct only by Hostname<br><p> <br><p> When the Listeners are distinct based only on Hostname, inbound request hostnames MUST match from the most specific to least specific Hostname values to choose the correct Listener and its associated set of Routes.<br><p> <br><p> Exact matches MUST be processed before wildcard matches, and wildcard matches MUST be processed before fallback (empty Hostname value) matches. For example, `"foo.example.com"` takes precedence over `"&#42;.example.com"`, and `"&#42;.example.com"` takes precedence over `""`.<br><p> <br><p> Additionally, if there are multiple wildcard entries, more specific wildcard entries must be processed before less specific wildcard entries. For example, `"&#42;.foo.example.com"` takes precedence over `"&#42;.example.com"`.<br><p> <br><p> The precise definition here is that the higher the number of dots in the hostname to the right of the wildcard character, the higher the precedence.<br><p> <br><p> The wildcard character will match any number of characters _and dots_ to the left, however, so `"&#42;.example.com"` will match both `"foo.bar.example.com"` _and_ `"bar.example.com"`.<br><p> <br><p> ## Handling indistinct Listeners<br><p> <br><p> If a set of Listeners contains Listeners that are not distinct, then those Listeners are _Conflicted_, and the implementation MUST set the "Conflicted" condition in the Listener Status to "True".<br><p> <br><p> The words "indistinct" and "conflicted" are considered equivalent for the purpose of this documentation.<br><p> <br><p> Implementations MAY choose to accept a Gateway with some Conflicted Listeners only if they only accept the partial Listener set that contains no Conflicted Listeners.<br><p> <br><p> Specifically, an implementation MAY accept a partial Listener set subject to the following rules:<br><p> <br><p> &#42; The implementation MUST NOT pick one conflicting Listener as the winner.<br><p>   ALL indistinct Listeners must not be accepted for processing.<br><p> &#42; At least one distinct Listener MUST be present, or else the Gateway effectively<br><p>   contains _no_ Listeners, and must be rejected from processing as a whole.<br><p> <br><p> The implementation MUST set a "ListenersNotValid" condition on the Gateway Status when the Gateway contains Conflicted Listeners whether or not they accept the Gateway. That Condition SHOULD clearly indicate in the Message which Listeners are conflicted, and which are Accepted. Additionally, the Listener status for those listeners SHOULD indicate which Listeners are conflicted and not Accepted.<br><p> <br><p> ## General Listener behavior<br><p> <br><p> Note that, for all distinct Listeners, requests SHOULD match at most one Listener. For example, if Listeners are defined for "foo.example.com" and "&#42;.example.com", a request to "foo.example.com" SHOULD only be routed using routes attached to the "foo.example.com" Listener (and not the "&#42;.example.com" Listener).<br><p> <br><p> This concept is known as "Listener Isolation", and it is an Extended feature of Gateway API. Implementations that do not support Listener Isolation MUST clearly document this, and MUST NOT claim support for the `GatewayHTTPListenerIsolation` feature.<br><p> <br><p> Implementations that _do_ support Listener Isolation SHOULD claim support for the Extended `GatewayHTTPListenerIsolation` feature and pass the associated conformance tests.<br><p> <br><p> ## Compatible Listeners<br><p> <br><p> A Gateway's Listeners are considered _compatible_ if:<br><p> <br><p> 1. They are distinct. 2. The implementation can serve them in compliance with the Addresses<br><p>    requirement that all Listeners are available on all assigned<br><p>    addresses.<br><p> <br><p> Compatible combinations in Extended support are expected to vary across implementations. A combination that is compatible for one implementation may not be compatible for another.<br><p> <br><p> For example, an implementation that cannot serve both TCP and UDP listeners on the same address, or cannot mix HTTPS and generic TLS listens on the same port would not consider those cases compatible, even though they are distinct.<br><p> <br><p> Implementations MAY merge separate Gateways onto a single set of Addresses if all Listeners across all Gateways are compatible.<br><p> <br><p> In a future release the MinItems=1 requirement MAY be dropped.<br><p> <br><p> Support: Core
     */
    @JsonProperty("listeners")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Listener> getListeners() {
        return listeners;
    }

    /**
     * Listeners associated with this Gateway. Listeners define logical endpoints that are bound on this Gateway's addresses. At least one Listener MUST be specified.<br><p> <br><p> ## Distinct Listeners<br><p> <br><p> Each Listener in a set of Listeners (for example, in a single Gateway) MUST be _distinct_, in that a traffic flow MUST be able to be assigned to exactly one listener. (This section uses "set of Listeners" rather than "Listeners in a single Gateway" because implementations MAY merge configuration from multiple Gateways onto a single data plane, and these rules _also_ apply in that case).<br><p> <br><p> Practically, this means that each listener in a set MUST have a unique combination of Port, Protocol, and, if supported by the protocol, Hostname.<br><p> <br><p> Some combinations of port, protocol, and TLS settings are considered Core support and MUST be supported by implementations based on the objects they support:<br><p> <br><p> HTTPRoute<br><p> <br><p> 1. HTTPRoute, Port: 80, Protocol: HTTP 2. HTTPRoute, Port: 443, Protocol: HTTPS, TLS Mode: Terminate, TLS keypair provided<br><p> <br><p> TLSRoute<br><p> <br><p> 1. TLSRoute, Port: 443, Protocol: TLS, TLS Mode: Passthrough<br><p> <br><p> "Distinct" Listeners have the following property:<br><p> <br><p> &#42;&#42;The implementation can match inbound requests to a single distinct Listener&#42;&#42;.<br><p> <br><p> When multiple Listeners share values for fields (for example, two Listeners with the same Port value), the implementation can match requests to only one of the Listeners using other Listener fields.<br><p> <br><p> When multiple listeners have the same value for the Protocol field, then each of the Listeners with matching Protocol values MUST have different values for other fields.<br><p> <br><p> The set of fields that MUST be different for a Listener differs per protocol. The following rules define the rules for what fields MUST be considered for Listeners to be distinct with each protocol currently defined in the Gateway API spec.<br><p> <br><p> The set of listeners that all share a protocol value MUST have _different_ values for _at least one_ of these fields to be distinct:<br><p> <br><p> &#42; &#42;&#42;HTTP, HTTPS, TLS&#42;&#42;: Port, Hostname &#42; &#42;&#42;TCP, UDP&#42;&#42;: Port<br><p> <br><p> One &#42;&#42;very&#42;&#42; important rule to call out involves what happens when an implementation:<br><p> <br><p> &#42; Supports TCP protocol Listeners, as well as HTTP, HTTPS, or TLS protocol<br><p>   Listeners, and<br><p> &#42; sees HTTP, HTTPS, or TLS protocols with the same `port` as one with TCP<br><p>   Protocol.<br><p> <br><p> In this case all the Listeners that share a port with the TCP Listener are not distinct and so MUST NOT be accepted.<br><p> <br><p> If an implementation does not support TCP Protocol Listeners, then the previous rule does not apply, and the TCP Listeners SHOULD NOT be accepted.<br><p> <br><p> Note that the `tls` field is not used for determining if a listener is distinct, because Listeners that _only_ differ on TLS config will still conflict in all cases.<br><p> <br><p> ### Listeners that are distinct only by Hostname<br><p> <br><p> When the Listeners are distinct based only on Hostname, inbound request hostnames MUST match from the most specific to least specific Hostname values to choose the correct Listener and its associated set of Routes.<br><p> <br><p> Exact matches MUST be processed before wildcard matches, and wildcard matches MUST be processed before fallback (empty Hostname value) matches. For example, `"foo.example.com"` takes precedence over `"&#42;.example.com"`, and `"&#42;.example.com"` takes precedence over `""`.<br><p> <br><p> Additionally, if there are multiple wildcard entries, more specific wildcard entries must be processed before less specific wildcard entries. For example, `"&#42;.foo.example.com"` takes precedence over `"&#42;.example.com"`.<br><p> <br><p> The precise definition here is that the higher the number of dots in the hostname to the right of the wildcard character, the higher the precedence.<br><p> <br><p> The wildcard character will match any number of characters _and dots_ to the left, however, so `"&#42;.example.com"` will match both `"foo.bar.example.com"` _and_ `"bar.example.com"`.<br><p> <br><p> ## Handling indistinct Listeners<br><p> <br><p> If a set of Listeners contains Listeners that are not distinct, then those Listeners are _Conflicted_, and the implementation MUST set the "Conflicted" condition in the Listener Status to "True".<br><p> <br><p> The words "indistinct" and "conflicted" are considered equivalent for the purpose of this documentation.<br><p> <br><p> Implementations MAY choose to accept a Gateway with some Conflicted Listeners only if they only accept the partial Listener set that contains no Conflicted Listeners.<br><p> <br><p> Specifically, an implementation MAY accept a partial Listener set subject to the following rules:<br><p> <br><p> &#42; The implementation MUST NOT pick one conflicting Listener as the winner.<br><p>   ALL indistinct Listeners must not be accepted for processing.<br><p> &#42; At least one distinct Listener MUST be present, or else the Gateway effectively<br><p>   contains _no_ Listeners, and must be rejected from processing as a whole.<br><p> <br><p> The implementation MUST set a "ListenersNotValid" condition on the Gateway Status when the Gateway contains Conflicted Listeners whether or not they accept the Gateway. That Condition SHOULD clearly indicate in the Message which Listeners are conflicted, and which are Accepted. Additionally, the Listener status for those listeners SHOULD indicate which Listeners are conflicted and not Accepted.<br><p> <br><p> ## General Listener behavior<br><p> <br><p> Note that, for all distinct Listeners, requests SHOULD match at most one Listener. For example, if Listeners are defined for "foo.example.com" and "&#42;.example.com", a request to "foo.example.com" SHOULD only be routed using routes attached to the "foo.example.com" Listener (and not the "&#42;.example.com" Listener).<br><p> <br><p> This concept is known as "Listener Isolation", and it is an Extended feature of Gateway API. Implementations that do not support Listener Isolation MUST clearly document this, and MUST NOT claim support for the `GatewayHTTPListenerIsolation` feature.<br><p> <br><p> Implementations that _do_ support Listener Isolation SHOULD claim support for the Extended `GatewayHTTPListenerIsolation` feature and pass the associated conformance tests.<br><p> <br><p> ## Compatible Listeners<br><p> <br><p> A Gateway's Listeners are considered _compatible_ if:<br><p> <br><p> 1. They are distinct. 2. The implementation can serve them in compliance with the Addresses<br><p>    requirement that all Listeners are available on all assigned<br><p>    addresses.<br><p> <br><p> Compatible combinations in Extended support are expected to vary across implementations. A combination that is compatible for one implementation may not be compatible for another.<br><p> <br><p> For example, an implementation that cannot serve both TCP and UDP listeners on the same address, or cannot mix HTTPS and generic TLS listens on the same port would not consider those cases compatible, even though they are distinct.<br><p> <br><p> Implementations MAY merge separate Gateways onto a single set of Addresses if all Listeners across all Gateways are compatible.<br><p> <br><p> In a future release the MinItems=1 requirement MAY be dropped.<br><p> <br><p> Support: Core
     */
    @JsonProperty("listeners")
    public void setListeners(List<Listener> listeners) {
        this.listeners = listeners;
    }

    /**
     * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
     */
    @JsonProperty("tls")
    public GatewayTLSConfig getTls() {
        return tls;
    }

    /**
     * GatewaySpec defines the desired state of Gateway.<br><p> <br><p> Not all possible combinations of options specified in the Spec are valid. Some invalid configurations can be caught synchronously via CRD validation, but there are many cases that will require asynchronous signaling via the GatewayStatus block.
     */
    @JsonProperty("tls")
    public void setTls(GatewayTLSConfig tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public GatewaySpecBuilder edit() {
        return new GatewaySpecBuilder(this);
    }

    @JsonIgnore
    public GatewaySpecBuilder toBuilder() {
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
