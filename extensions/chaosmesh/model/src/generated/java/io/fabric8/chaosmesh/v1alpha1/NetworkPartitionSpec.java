
package io.fabric8.chaosmesh.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accept-tcp-flags",
    "device",
    "direction",
    "hostname",
    "ip-address",
    "ip-protocol"
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
public class NetworkPartitionSpec implements Editable<NetworkPartitionSpecBuilder>, KubernetesResource
{

    @JsonProperty("accept-tcp-flags")
    private String acceptTcpFlags;
    @JsonProperty("device")
    private String device;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("ip-address")
    private String ipAddress;
    @JsonProperty("ip-protocol")
    private String ipProtocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkPartitionSpec() {
    }

    public NetworkPartitionSpec(String acceptTcpFlags, String device, String direction, String hostname, String ipAddress, String ipProtocol) {
        super();
        this.acceptTcpFlags = acceptTcpFlags;
        this.device = device;
        this.direction = direction;
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.ipProtocol = ipProtocol;
    }

    /**
     * only the packet which match the tcp flag can be accepted, others will be dropped. only set when the IPProtocol is tcp, used for partition.
     */
    @JsonProperty("accept-tcp-flags")
    public String getAcceptTcpFlags() {
        return acceptTcpFlags;
    }

    /**
     * only the packet which match the tcp flag can be accepted, others will be dropped. only set when the IPProtocol is tcp, used for partition.
     */
    @JsonProperty("accept-tcp-flags")
    public void setAcceptTcpFlags(String acceptTcpFlags) {
        this.acceptTcpFlags = acceptTcpFlags;
    }

    /**
     * the network interface to impact
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * the network interface to impact
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * specifies the partition direction, values can be 'from', 'to'. 'from' means packets coming from the 'IPAddress' or 'Hostname' and going to your server, 'to' means packets originating from your server and going to the 'IPAddress' or 'Hostname'.
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * specifies the partition direction, values can be 'from', 'to'. 'from' means packets coming from the 'IPAddress' or 'Hostname' and going to your server, 'to' means packets originating from your server and going to the 'IPAddress' or 'Hostname'.
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * only impact traffic to these hostnames
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * only impact traffic to these hostnames
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * only impact egress traffic to these IP addresses
     */
    @JsonProperty("ip-address")
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * only impact egress traffic to these IP addresses
     */
    @JsonProperty("ip-address")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * only impact egress traffic to these IP addresses
     */
    @JsonProperty("ip-protocol")
    public String getIpProtocol() {
        return ipProtocol;
    }

    /**
     * only impact egress traffic to these IP addresses
     */
    @JsonProperty("ip-protocol")
    public void setIpProtocol(String ipProtocol) {
        this.ipProtocol = ipProtocol;
    }

    @JsonIgnore
    public NetworkPartitionSpecBuilder edit() {
        return new NetworkPartitionSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkPartitionSpecBuilder toBuilder() {
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
