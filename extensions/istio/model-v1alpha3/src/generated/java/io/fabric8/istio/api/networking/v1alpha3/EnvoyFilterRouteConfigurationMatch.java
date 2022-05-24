
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "gateway",
    "name",
    "portName",
    "portNumber",
    "vhost"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class EnvoyFilterRouteConfigurationMatch implements KubernetesResource
{

    @JsonProperty("gateway")
    private String gateway;
    @JsonProperty("name")
    private String name;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("portNumber")
    private Integer portNumber;
    @JsonProperty("vhost")
    private EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvoyFilterRouteConfigurationMatch() {
    }

    /**
     * 
     * @param vhost
     * @param name
     * @param portName
     * @param gateway
     * @param portNumber
     */
    public EnvoyFilterRouteConfigurationMatch(String gateway, String name, String portName, Integer portNumber, EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost) {
        super();
        this.gateway = gateway;
        this.name = name;
        this.portName = portName;
        this.portNumber = portNumber;
        this.vhost = vhost;
    }

    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    @JsonProperty("portNumber")
    public Integer getPortNumber() {
        return portNumber;
    }

    @JsonProperty("portNumber")
    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    @JsonProperty("vhost")
    public EnvoyFilterRouteConfigurationMatchVirtualHostMatch getVhost() {
        return vhost;
    }

    @JsonProperty("vhost")
    public void setVhost(EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost) {
        this.vhost = vhost;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
