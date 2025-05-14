
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Listener embodies the concept of a logical endpoint where a Gateway accepts network connections.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedRoutes",
    "hostname",
    "name",
    "port",
    "protocol",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Listener implements Editable<ListenerBuilder>, KubernetesResource
{

    @JsonProperty("allowedRoutes")
    private AllowedRoutes allowedRoutes;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("tls")
    private GatewayTLSConfig tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Listener() {
    }

    public Listener(AllowedRoutes allowedRoutes, String hostname, String name, Integer port, String protocol, GatewayTLSConfig tls) {
        super();
        this.allowedRoutes = allowedRoutes;
        this.hostname = hostname;
        this.name = name;
        this.port = port;
        this.protocol = protocol;
        this.tls = tls;
    }

    /**
     * Listener embodies the concept of a logical endpoint where a Gateway accepts network connections.
     */
    @JsonProperty("allowedRoutes")
    public AllowedRoutes getAllowedRoutes() {
        return allowedRoutes;
    }

    /**
     * Listener embodies the concept of a logical endpoint where a Gateway accepts network connections.
     */
    @JsonProperty("allowedRoutes")
    public void setAllowedRoutes(AllowedRoutes allowedRoutes) {
        this.allowedRoutes = allowedRoutes;
    }

    /**
     * Hostname specifies the virtual hostname to match for protocol types that define this concept. When unspecified, all hostnames are matched. This field is ignored for protocols that don't require hostname based matching.<br><p> <br><p> Implementations MUST apply Hostname matching appropriately for each of the following protocols:<br><p> <br><p> &#42; TLS: The Listener Hostname MUST match the SNI. &#42; HTTP: The Listener Hostname MUST match the Host header of the request. &#42; HTTPS: The Listener Hostname SHOULD match at both the TLS and HTTP<br><p>   protocol layers as described above. If an implementation does not<br><p>   ensure that both the SNI and Host header match the Listener hostname,<br><p>   it MUST clearly document that.<br><p> <br><p> For HTTPRoute and TLSRoute resources, there is an interaction with the `spec.hostnames` array. When both listener and route specify hostnames, there MUST be an intersection between the values for a Route to be accepted. For more information, refer to the Route specific Hostnames documentation.<br><p> <br><p> Hostnames that are prefixed with a wildcard label (`&#42;.`) are interpreted as a suffix match. That means that a match for `&#42;.example.com` would match both `test.example.com`, and `foo.test.example.com`, but not `example.com`.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Hostname specifies the virtual hostname to match for protocol types that define this concept. When unspecified, all hostnames are matched. This field is ignored for protocols that don't require hostname based matching.<br><p> <br><p> Implementations MUST apply Hostname matching appropriately for each of the following protocols:<br><p> <br><p> &#42; TLS: The Listener Hostname MUST match the SNI. &#42; HTTP: The Listener Hostname MUST match the Host header of the request. &#42; HTTPS: The Listener Hostname SHOULD match at both the TLS and HTTP<br><p>   protocol layers as described above. If an implementation does not<br><p>   ensure that both the SNI and Host header match the Listener hostname,<br><p>   it MUST clearly document that.<br><p> <br><p> For HTTPRoute and TLSRoute resources, there is an interaction with the `spec.hostnames` array. When both listener and route specify hostnames, there MUST be an intersection between the values for a Route to be accepted. For more information, refer to the Route specific Hostnames documentation.<br><p> <br><p> Hostnames that are prefixed with a wildcard label (`&#42;.`) are interpreted as a suffix match. That means that a match for `&#42;.example.com` would match both `test.example.com`, and `foo.test.example.com`, but not `example.com`.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Name is the name of the Listener. This name MUST be unique within a Gateway.<br><p> <br><p> Support: Core
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the Listener. This name MUST be unique within a Gateway.<br><p> <br><p> Support: Core
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Port is the network port. Multiple listeners may use the same port, subject to the Listener compatibility rules.<br><p> <br><p> Support: Core
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port is the network port. Multiple listeners may use the same port, subject to the Listener compatibility rules.<br><p> <br><p> Support: Core
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Protocol specifies the network protocol this listener expects to receive.<br><p> <br><p> Support: Core
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Protocol specifies the network protocol this listener expects to receive.<br><p> <br><p> Support: Core
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Listener embodies the concept of a logical endpoint where a Gateway accepts network connections.
     */
    @JsonProperty("tls")
    public GatewayTLSConfig getTls() {
        return tls;
    }

    /**
     * Listener embodies the concept of a logical endpoint where a Gateway accepts network connections.
     */
    @JsonProperty("tls")
    public void setTls(GatewayTLSConfig tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public ListenerBuilder edit() {
        return new ListenerBuilder(this);
    }

    @JsonIgnore
    public ListenerBuilder toBuilder() {
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
