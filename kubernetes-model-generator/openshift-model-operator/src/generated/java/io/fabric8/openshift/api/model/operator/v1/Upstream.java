
package io.fabric8.openshift.api.model.operator.v1;

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
 * Upstream can either be of type SystemResolvConf, or of type Network.<br><p> <br><p>   - For an Upstream of type SystemResolvConf, no further fields are necessary:<br><p>     The upstream will be configured to use /etc/resolv.conf.<br><p>   - For an Upstream of type Network, a NetworkResolver field needs to be defined<br><p>     with an IP address or IP:port if the upstream listens on a port other than 53.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "port",
    "type"
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
public class Upstream implements Editable<UpstreamBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private String address;
    @JsonProperty("port")
    private Long port;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Upstream() {
    }

    public Upstream(String address, Long port, String type) {
        super();
        this.address = address;
        this.port = port;
        this.type = type;
    }

    /**
     * Address must be defined when Type is set to Network. It will be ignored otherwise. It must be a valid ipv4 or ipv6 address.
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * Address must be defined when Type is set to Network. It will be ignored otherwise. It must be a valid ipv4 or ipv6 address.
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Port may be defined when Type is set to Network. It will be ignored otherwise. Port must be between 65535
     */
    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    /**
     * Port may be defined when Type is set to Network. It will be ignored otherwise. Port must be between 65535
     */
    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    /**
     * Type defines whether this upstream contains an IP/IP:port resolver or the local /etc/resolv.conf. Type accepts 2 possible values: SystemResolvConf or Network.<br><p> <br><p> &#42; When SystemResolvConf is used, the Upstream structure does not require any further fields to be defined:<br><p>   /etc/resolv.conf will be used<br><p> &#42; When Network is used, the Upstream structure must contain at least an Address
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines whether this upstream contains an IP/IP:port resolver or the local /etc/resolv.conf. Type accepts 2 possible values: SystemResolvConf or Network.<br><p> <br><p> &#42; When SystemResolvConf is used, the Upstream structure does not require any further fields to be defined:<br><p>   /etc/resolv.conf will be used<br><p> &#42; When Network is used, the Upstream structure must contain at least an Address
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public UpstreamBuilder edit() {
        return new UpstreamBuilder(this);
    }

    @JsonIgnore
    public UpstreamBuilder toBuilder() {
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
