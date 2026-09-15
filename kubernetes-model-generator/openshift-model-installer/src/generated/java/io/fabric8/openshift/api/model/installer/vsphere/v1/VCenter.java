
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
 * VCenter stores the vCenter connection fields https://github.com/kubernetes/cloud-provider-vsphere/blob/master/pkg/common/config/types_yaml.go
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datacenters",
    "password",
    "port",
    "server",
    "user"
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
public class VCenter implements Editable<VCenterBuilder>, KubernetesResource
{

    @JsonProperty("datacenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> datacenters = new ArrayList<>();
    @JsonProperty("password")
    private String password;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("server")
    private String server;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VCenter() {
    }

    public VCenter(List<String> datacenters, String password, Integer port, String server, String user) {
        super();
        this.datacenters = datacenters;
        this.password = password;
        this.port = port;
        this.server = server;
        this.user = user;
    }

    /**
     * Datacenter in which VMs are located.
     */
    @JsonProperty("datacenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDatacenters() {
        return datacenters;
    }

    /**
     * Datacenter in which VMs are located.
     */
    @JsonProperty("datacenters")
    public void setDatacenters(List<String> datacenters) {
        this.datacenters = datacenters;
    }

    /**
     * Password is the password for the user to use to connect to the vCenter.
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password is the password for the user to use to connect to the vCenter.
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * port is the TCP port that will be used to communicate to the vCenter endpoint. This is typically unchanged from the default of HTTPS TCP/443.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * port is the TCP port that will be used to communicate to the vCenter endpoint. This is typically unchanged from the default of HTTPS TCP/443.
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

    /**
     * Username is the username that will be used to connect to vCenter
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * Username is the username that will be used to connect to vCenter
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonIgnore
    public VCenterBuilder edit() {
        return new VCenterBuilder(this);
    }

    @JsonIgnore
    public VCenterBuilder toBuilder() {
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
        if (!(o instanceof VCenter)) {
            return false;
        }
        VCenter other = (VCenter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$datacenters = this.getDatacenters();
        Object other$datacenters = other.getDatacenters();
        if (this$datacenters == null ? other$datacenters != null : !this$datacenters.equals(other$datacenters)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
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
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
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
        return other instanceof VCenter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $datacenters = this.getDatacenters();
        result = result * prime + ($datacenters == null ? 43 : $datacenters.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VCenter(" + "datacenters=" + this.getDatacenters() + ", password=" + this.getPassword() + ", port=" + this.getPort() + ", server=" + this.getServer() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
