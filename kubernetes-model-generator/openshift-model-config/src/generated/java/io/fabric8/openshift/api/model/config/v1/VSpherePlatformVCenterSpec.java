
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VSpherePlatformVCenterSpec stores the vCenter connection fields. This is used by the vSphere CCM.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datacenters",
    "port",
    "server"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VSpherePlatformVCenterSpec implements Editable<VSpherePlatformVCenterSpecBuilder>, KubernetesResource
{

    @JsonProperty("datacenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> datacenters = new ArrayList<>();
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("server")
    private String server;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformVCenterSpec() {
    }

    public VSpherePlatformVCenterSpec(List<String> datacenters, Integer port, String server) {
        super();
        this.datacenters = datacenters;
        this.port = port;
        this.server = server;
    }

    /**
     * The vCenter Datacenters in which the RHCOS vm guests are located. This field will be used by the Cloud Controller Manager. Each datacenter listed here should be used within a topology.
     */
    @JsonProperty("datacenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDatacenters() {
        return datacenters;
    }

    /**
     * The vCenter Datacenters in which the RHCOS vm guests are located. This field will be used by the Cloud Controller Manager. Each datacenter listed here should be used within a topology.
     */
    @JsonProperty("datacenters")
    public void setDatacenters(List<String> datacenters) {
        this.datacenters = datacenters;
    }

    /**
     * port is the TCP port that will be used to communicate to the vCenter endpoint. When omitted, this means the user has no opinion and it is up to the platform to choose a sensible default, which is subject to change over time.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * port is the TCP port that will be used to communicate to the vCenter endpoint. When omitted, this means the user has no opinion and it is up to the platform to choose a sensible default, which is subject to change over time.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * server is the fully-qualified domain name or the IP address of the vCenter server.
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * server is the fully-qualified domain name or the IP address of the vCenter server.
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    @JsonIgnore
    public VSpherePlatformVCenterSpecBuilder edit() {
        return new VSpherePlatformVCenterSpecBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformVCenterSpecBuilder toBuilder() {
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
        if (!(o instanceof VSpherePlatformVCenterSpec)) {
            return false;
        }
        VSpherePlatformVCenterSpec other = (VSpherePlatformVCenterSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$datacenters = this.getDatacenters();
        Object other$datacenters = other.getDatacenters();
        if (this$datacenters == null ? other$datacenters != null : !this$datacenters.equals(other$datacenters)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$server = this.getServer();
        Object other$server = other.getServer();
        if (this$server == null ? other$server != null : !this$server.equals(other$server)) {
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
        return other instanceof VSpherePlatformVCenterSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $datacenters = this.getDatacenters();
        result = result * prime + ($datacenters == null ? 43 : $datacenters.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VSpherePlatformVCenterSpec(" + "datacenters=" + this.getDatacenters() + ", port=" + this.getPort() + ", server=" + this.getServer() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
