
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
 * Server defines the schema for a server that runs per instance of CoreDNS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "forwardPlugin",
    "name",
    "zones"
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
public class Server implements Editable<ServerBuilder>, KubernetesResource
{

    @JsonProperty("forwardPlugin")
    private ForwardPlugin forwardPlugin;
    @JsonProperty("name")
    private String name;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Server() {
    }

    public Server(ForwardPlugin forwardPlugin, String name, List<String> zones) {
        super();
        this.forwardPlugin = forwardPlugin;
        this.name = name;
        this.zones = zones;
    }

    /**
     * Server defines the schema for a server that runs per instance of CoreDNS.
     */
    @JsonProperty("forwardPlugin")
    public ForwardPlugin getForwardPlugin() {
        return forwardPlugin;
    }

    /**
     * Server defines the schema for a server that runs per instance of CoreDNS.
     */
    @JsonProperty("forwardPlugin")
    public void setForwardPlugin(ForwardPlugin forwardPlugin) {
        this.forwardPlugin = forwardPlugin;
    }

    /**
     * name is required and specifies a unique name for the server. Name must comply with the Service Name Syntax of rfc6335.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is required and specifies a unique name for the server. Name must comply with the Service Name Syntax of rfc6335.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * zones is required and specifies the subdomains that Server is authoritative for. Zones must conform to the rfc1123 definition of a subdomain. Specifying the cluster domain (i.e., "cluster.local") is invalid.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * zones is required and specifies the subdomains that Server is authoritative for. Zones must conform to the rfc1123 definition of a subdomain. Specifying the cluster domain (i.e., "cluster.local") is invalid.
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public ServerBuilder edit() {
        return new ServerBuilder(this);
    }

    @JsonIgnore
    public ServerBuilder toBuilder() {
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
        if (!(o instanceof Server)) {
            return false;
        }
        Server other = (Server) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$forwardPlugin = this.getForwardPlugin();
        Object other$forwardPlugin = other.getForwardPlugin();
        if (this$forwardPlugin == null ? other$forwardPlugin != null : !this$forwardPlugin.equals(other$forwardPlugin)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
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
        return other instanceof Server;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $forwardPlugin = this.getForwardPlugin();
        result = result * prime + ($forwardPlugin == null ? 43 : $forwardPlugin.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Server(" + "forwardPlugin=" + this.getForwardPlugin() + ", name=" + this.getName() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
