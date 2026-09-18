
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
 * Conditions specified in RouteConfigurationMatch must be met for the patch to be applied to a route configuration object or a specific virtual host within the route configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gateway",
    "name",
    "portName",
    "portNumber",
    "vhost"
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
public class EnvoyFilterRouteConfigurationMatch implements Editable<EnvoyFilterRouteConfigurationMatchBuilder>, KubernetesResource
{

    @JsonProperty("gateway")
    private String gateway;
    @JsonProperty("name")
    private String name;
    @JsonProperty("portName")
    private String portName;
    @JsonProperty("portNumber")
    private Long portNumber;
    @JsonProperty("vhost")
    private EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterRouteConfigurationMatch() {
    }

    public EnvoyFilterRouteConfigurationMatch(String gateway, String name, String portName, Long portNumber, EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost) {
        super();
        this.gateway = gateway;
        this.name = name;
        this.portName = portName;
        this.portNumber = portNumber;
        this.vhost = vhost;
    }

    /**
     * The Istio gateway config's namespace/name for which this route configuration was generated. Applies only if the context is GATEWAY. Should be in the namespace/name format. Use this field in conjunction with the `portNumber` and `portName` to accurately select the Envoy route configuration for a specific HTTPS server within a gateway config object.
     */
    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    /**
     * The Istio gateway config's namespace/name for which this route configuration was generated. Applies only if the context is GATEWAY. Should be in the namespace/name format. Use this field in conjunction with the `portNumber` and `portName` to accurately select the Envoy route configuration for a specific HTTPS server within a gateway config object.
     */
    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * Route configuration name to match on. Can be used to match a specific route configuration by name, such as the internally generated `http_proxy` route configuration for all sidecars.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Route configuration name to match on. Can be used to match a specific route configuration by name, such as the internally generated `http_proxy` route configuration for all sidecars.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Applicable only for GATEWAY context. The gateway server port name for which this route configuration was generated.
     */
    @JsonProperty("portName")
    public String getPortName() {
        return portName;
    }

    /**
     * Applicable only for GATEWAY context. The gateway server port name for which this route configuration was generated.
     */
    @JsonProperty("portName")
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * The service port number or gateway server port number for which this route configuration was generated. If omitted, applies to route configurations for all ports.
     */
    @JsonProperty("portNumber")
    public Long getPortNumber() {
        return portNumber;
    }

    /**
     * The service port number or gateway server port number for which this route configuration was generated. If omitted, applies to route configurations for all ports.
     */
    @JsonProperty("portNumber")
    public void setPortNumber(Long portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Conditions specified in RouteConfigurationMatch must be met for the patch to be applied to a route configuration object or a specific virtual host within the route configuration.
     */
    @JsonProperty("vhost")
    public EnvoyFilterRouteConfigurationMatchVirtualHostMatch getVhost() {
        return vhost;
    }

    /**
     * Conditions specified in RouteConfigurationMatch must be met for the patch to be applied to a route configuration object or a specific virtual host within the route configuration.
     */
    @JsonProperty("vhost")
    public void setVhost(EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost) {
        this.vhost = vhost;
    }

    @JsonIgnore
    public EnvoyFilterRouteConfigurationMatchBuilder edit() {
        return new EnvoyFilterRouteConfigurationMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterRouteConfigurationMatchBuilder toBuilder() {
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
        if (!(o instanceof EnvoyFilterRouteConfigurationMatch)) {
            return false;
        }
        EnvoyFilterRouteConfigurationMatch other = (EnvoyFilterRouteConfigurationMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$gateway = this.getGateway();
        Object other$gateway = other.getGateway();
        if (this$gateway == null ? other$gateway != null : !this$gateway.equals(other$gateway)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$portName = this.getPortName();
        Object other$portName = other.getPortName();
        if (this$portName == null ? other$portName != null : !this$portName.equals(other$portName)) {
            return false;
        }
        Object this$portNumber = this.getPortNumber();
        Object other$portNumber = other.getPortNumber();
        if (this$portNumber == null ? other$portNumber != null : !this$portNumber.equals(other$portNumber)) {
            return false;
        }
        Object this$vhost = this.getVhost();
        Object other$vhost = other.getVhost();
        if (this$vhost == null ? other$vhost != null : !this$vhost.equals(other$vhost)) {
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
        return other instanceof EnvoyFilterRouteConfigurationMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $gateway = this.getGateway();
        result = result * prime + ($gateway == null ? 43 : $gateway.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $portName = this.getPortName();
        result = result * prime + ($portName == null ? 43 : $portName.hashCode());
        Object $portNumber = this.getPortNumber();
        result = result * prime + ($portNumber == null ? 43 : $portNumber.hashCode());
        Object $vhost = this.getVhost();
        result = result * prime + ($vhost == null ? 43 : $vhost.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvoyFilterRouteConfigurationMatch(" + "gateway=" + this.getGateway() + ", name=" + this.getName() + ", portName=" + this.getPortName() + ", portNumber=" + this.getPortNumber() + ", vhost=" + this.getVhost() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
