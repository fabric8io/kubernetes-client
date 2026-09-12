
package io.fabric8.openshift.api.model.operator.v1;

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
 * StaticIPAMConfig contains configurations for static IPAM (IP Address Management)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "dns",
    "routes"
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
public class StaticIPAMConfig implements Editable<StaticIPAMConfigBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StaticIPAMAddresses> addresses = new ArrayList<>();
    @JsonProperty("dns")
    private StaticIPAMDNS dns;
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StaticIPAMRoutes> routes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StaticIPAMConfig() {
    }

    public StaticIPAMConfig(List<StaticIPAMAddresses> addresses, StaticIPAMDNS dns, List<StaticIPAMRoutes> routes) {
        super();
        this.addresses = addresses;
        this.dns = dns;
        this.routes = routes;
    }

    /**
     * addresses configures IP address for the interface
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StaticIPAMAddresses> getAddresses() {
        return addresses;
    }

    /**
     * addresses configures IP address for the interface
     */
    @JsonProperty("addresses")
    public void setAddresses(List<StaticIPAMAddresses> addresses) {
        this.addresses = addresses;
    }

    /**
     * StaticIPAMConfig contains configurations for static IPAM (IP Address Management)
     */
    @JsonProperty("dns")
    public StaticIPAMDNS getDns() {
        return dns;
    }

    /**
     * StaticIPAMConfig contains configurations for static IPAM (IP Address Management)
     */
    @JsonProperty("dns")
    public void setDns(StaticIPAMDNS dns) {
        this.dns = dns;
    }

    /**
     * routes configures IP routes for the interface
     */
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StaticIPAMRoutes> getRoutes() {
        return routes;
    }

    /**
     * routes configures IP routes for the interface
     */
    @JsonProperty("routes")
    public void setRoutes(List<StaticIPAMRoutes> routes) {
        this.routes = routes;
    }

    @JsonIgnore
    public StaticIPAMConfigBuilder edit() {
        return new StaticIPAMConfigBuilder(this);
    }

    @JsonIgnore
    public StaticIPAMConfigBuilder toBuilder() {
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
        if (!(o instanceof StaticIPAMConfig)) {
            return false;
        }
        StaticIPAMConfig other = (StaticIPAMConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addresses = this.getAddresses();
        Object other$addresses = other.getAddresses();
        if (this$addresses == null ? other$addresses != null : !this$addresses.equals(other$addresses)) {
            return false;
        }
        Object this$dns = this.getDns();
        Object other$dns = other.getDns();
        if (this$dns == null ? other$dns != null : !this$dns.equals(other$dns)) {
            return false;
        }
        Object this$routes = this.getRoutes();
        Object other$routes = other.getRoutes();
        if (this$routes == null ? other$routes != null : !this$routes.equals(other$routes)) {
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
        return other instanceof StaticIPAMConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addresses = this.getAddresses();
        result = result * prime + ($addresses == null ? 43 : $addresses.hashCode());
        Object $dns = this.getDns();
        result = result * prime + ($dns == null ? 43 : $dns.hashCode());
        Object $routes = this.getRoutes();
        result = result * prime + ($routes == null ? 43 : $routes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StaticIPAMConfig(" + "addresses=" + this.getAddresses() + ", dns=" + this.getDns() + ", routes=" + this.getRoutes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
