
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
    "bind",
    "defaultEndpoint",
    "hosts",
    "name",
    "port",
    "tls"
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
public class Server implements Editable<ServerBuilder> , KubernetesResource
{

    @JsonProperty("bind")
    private String bind;
    @JsonProperty("defaultEndpoint")
    private String defaultEndpoint;
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("port")
    private Port port;
    @JsonProperty("tls")
    private ServerTLSSettings tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Server() {
    }

    public Server(String bind, String defaultEndpoint, List<String> hosts, String name, Port port, ServerTLSSettings tls) {
        super();
        this.bind = bind;
        this.defaultEndpoint = defaultEndpoint;
        this.hosts = hosts;
        this.name = name;
        this.port = port;
        this.tls = tls;
    }

    @JsonProperty("bind")
    public String getBind() {
        return bind;
    }

    @JsonProperty("bind")
    public void setBind(String bind) {
        this.bind = bind;
    }

    @JsonProperty("defaultEndpoint")
    public String getDefaultEndpoint() {
        return defaultEndpoint;
    }

    @JsonProperty("defaultEndpoint")
    public void setDefaultEndpoint(String defaultEndpoint) {
        this.defaultEndpoint = defaultEndpoint;
    }

    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("port")
    public Port getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Port port) {
        this.port = port;
    }

    @JsonProperty("tls")
    public ServerTLSSettings getTls() {
        return tls;
    }

    @JsonProperty("tls")
    public void setTls(ServerTLSSettings tls) {
        this.tls = tls;
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
