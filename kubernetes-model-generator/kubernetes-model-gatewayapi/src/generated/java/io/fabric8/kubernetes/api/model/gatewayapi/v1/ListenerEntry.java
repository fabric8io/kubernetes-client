
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
public class ListenerEntry implements Editable<ListenerEntryBuilder>, KubernetesResource
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
    private ListenerTLSConfig tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerEntry() {
    }

    public ListenerEntry(AllowedRoutes allowedRoutes, String hostname, String name, Integer port, String protocol, ListenerTLSConfig tls) {
        super();
        this.allowedRoutes = allowedRoutes;
        this.hostname = hostname;
        this.name = name;
        this.port = port;
        this.protocol = protocol;
        this.tls = tls;
    }

    @JsonProperty("allowedRoutes")
    public AllowedRoutes getAllowedRoutes() {
        return allowedRoutes;
    }

    @JsonProperty("allowedRoutes")
    public void setAllowedRoutes(AllowedRoutes allowedRoutes) {
        this.allowedRoutes = allowedRoutes;
    }

    /**
     * Hostname specifies the virtual hostname to match for protocol types that define this concept. When unspecified, all hostnames are matched. This field is ignored for protocols that don't require hostname based matching.<br><p> <br><p> Implementations MUST apply Hostname matching appropriately for each of the following protocols:<br><p> <br><p> &#42; TLS: The Listener Hostname MUST match the SNI. &#42; HTTP: The Listener Hostname MUST match the Host header of the request. &#42; HTTPS: The Listener Hostname SHOULD match at both the TLS and HTTP<br><p>   protocol layers as described above. If an implementation does not<br><p>   ensure that both the SNI and Host header match the Listener hostname,<br><p>   it MUST clearly document that.<br><p> <br><p> For HTTPRoute and TLSRoute resources, there is an interaction with the `spec.hostnames` array. When both listener and route specify hostnames, there MUST be an intersection between the values for a Route to be accepted. For more information, refer to the Route specific Hostnames documentation.<br><p> <br><p> Hostnames that are prefixed with a wildcard label (`&#42;.`) are interpreted as a suffix match. That means that a match for `&#42;.example.com` would match both `test.example.com`, and `foo.test.example.com`, but not `example.com`.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Hostname specifies the virtual hostname to match for protocol types that define this concept. When unspecified, all hostnames are matched. This field is ignored for protocols that don't require hostname based matching.<br><p> <br><p> Implementations MUST apply Hostname matching appropriately for each of the following protocols:<br><p> <br><p> &#42; TLS: The Listener Hostname MUST match the SNI. &#42; HTTP: The Listener Hostname MUST match the Host header of the request. &#42; HTTPS: The Listener Hostname SHOULD match at both the TLS and HTTP<br><p>   protocol layers as described above. If an implementation does not<br><p>   ensure that both the SNI and Host header match the Listener hostname,<br><p>   it MUST clearly document that.<br><p> <br><p> For HTTPRoute and TLSRoute resources, there is an interaction with the `spec.hostnames` array. When both listener and route specify hostnames, there MUST be an intersection between the values for a Route to be accepted. For more information, refer to the Route specific Hostnames documentation.<br><p> <br><p> Hostnames that are prefixed with a wildcard label (`&#42;.`) are interpreted as a suffix match. That means that a match for `&#42;.example.com` would match both `test.example.com`, and `foo.test.example.com`, but not `example.com`.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Name is the name of the Listener. This name MUST be unique within a ListenerSet.<br><p> <br><p> Name is not required to be unique across a Gateway and ListenerSets. Routes can attach to a Listener by having a ListenerSet as a parentRef and setting the SectionName
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the Listener. This name MUST be unique within a ListenerSet.<br><p> <br><p> Name is not required to be unique across a Gateway and ListenerSets. Routes can attach to a Listener by having a ListenerSet as a parentRef and setting the SectionName
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Port is the network port. Multiple listeners may use the same port, subject to the Listener compatibility rules.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port is the network port. Multiple listeners may use the same port, subject to the Listener compatibility rules.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Protocol specifies the network protocol this listener expects to receive.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Protocol specifies the network protocol this listener expects to receive.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonProperty("tls")
    public ListenerTLSConfig getTls() {
        return tls;
    }

    @JsonProperty("tls")
    public void setTls(ListenerTLSConfig tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public ListenerEntryBuilder edit() {
        return new ListenerEntryBuilder(this);
    }

    @JsonIgnore
    public ListenerEntryBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListenerEntry)) {
            return false;
        }
        ListenerEntry other = (ListenerEntry) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowedRoutes = this.getAllowedRoutes();
        Object other$allowedRoutes = other.getAllowedRoutes();
        if (this$allowedRoutes == null ? other$allowedRoutes != null : !this$allowedRoutes.equals(other$allowedRoutes)) {
            return false;
        }
        Object this$hostname = this.getHostname();
        Object other$hostname = other.getHostname();
        if (this$hostname == null ? other$hostname != null : !this$hostname.equals(other$hostname)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ListenerEntry;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowedRoutes = this.getAllowedRoutes();
        result = result * prime + ($allowedRoutes == null ? 43 : $allowedRoutes.hashCode());
        Object $hostname = this.getHostname();
        result = result * prime + ($hostname == null ? 43 : $hostname.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ListenerEntry(" + "allowedRoutes=" + this.getAllowedRoutes() + ", hostname=" + this.getHostname() + ", name=" + this.getName() + ", port=" + this.getPort() + ", protocol=" + this.getProtocol() + ", tls=" + this.getTls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
