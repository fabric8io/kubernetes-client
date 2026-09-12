
package io.fabric8.istio.api.api.networking.v1alpha3;

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

/**
 * Port describes the properties of a specific port of a service.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "number",
    "protocol",
    "targetPort"
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
public class SidecarPort implements Editable<SidecarPortBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("number")
    private Long number;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("targetPort")
    private Long targetPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SidecarPort() {
    }

    public SidecarPort(String name, Long number, String protocol, Long targetPort) {
        super();
        this.name = name;
        this.number = number;
        this.protocol = protocol;
        this.targetPort = targetPort;
    }

    /**
     * Label assigned to the port.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Label assigned to the port.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A valid non-negative integer port number.
     */
    @JsonProperty("number")
    public Long getNumber() {
        return number;
    }

    /**
     * A valid non-negative integer port number.
     */
    @JsonProperty("number")
    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     * The protocol exposed on the port. MUST be one of HTTP|HTTPS|GRPC|HTTP2|MONGO|TCP|TLS. TLS can be either used to terminate non-HTTP based connections on a specific port or to route traffic based on SNI header to the destination without terminating the TLS connection.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * The protocol exposed on the port. MUST be one of HTTP|HTTPS|GRPC|HTTP2|MONGO|TCP|TLS. TLS can be either used to terminate non-HTTP based connections on a specific port or to route traffic based on SNI header to the destination without terminating the TLS connection.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Has no effect, only for backwards compatibility received. Applicable only when used with ServiceEntries. $hide_from_docs<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/sidecar.proto.
     */
    @JsonProperty("targetPort")
    public Long getTargetPort() {
        return targetPort;
    }

    /**
     * Has no effect, only for backwards compatibility received. Applicable only when used with ServiceEntries. $hide_from_docs<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/sidecar.proto.
     */
    @JsonProperty("targetPort")
    public void setTargetPort(Long targetPort) {
        this.targetPort = targetPort;
    }

    @JsonIgnore
    public SidecarPortBuilder edit() {
        return new SidecarPortBuilder(this);
    }

    @JsonIgnore
    public SidecarPortBuilder toBuilder() {
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
        if (!(o instanceof SidecarPort)) {
            return false;
        }
        SidecarPort other = (SidecarPort) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$number = this.getNumber();
        Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$targetPort = this.getTargetPort();
        Object other$targetPort = other.getTargetPort();
        if (this$targetPort == null ? other$targetPort != null : !this$targetPort.equals(other$targetPort)) {
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
        return other instanceof SidecarPort;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $number = this.getNumber();
        result = result * prime + ($number == null ? 43 : $number.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $targetPort = this.getTargetPort();
        result = result * prime + ($targetPort == null ? 43 : $targetPort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SidecarPort(" + "name=" + this.getName() + ", number=" + this.getNumber() + ", protocol=" + this.getProtocol() + ", targetPort=" + this.getTargetPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
