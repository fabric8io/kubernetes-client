
package io.fabric8.istio.api.networking.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "exportTo",
    "gateways",
    "hosts",
    "http",
    "tcp",
    "tls"
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
public class VirtualServiceSpec implements KubernetesResource
{

    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exportTo = new ArrayList<String>();
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> gateways = new ArrayList<String>();
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<String>();
    @JsonProperty("http")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPRoute> http = new ArrayList<HTTPRoute>();
    @JsonProperty("tcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TCPRoute> tcp = new ArrayList<TCPRoute>();
    @JsonProperty("tls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TLSRoute> tls = new ArrayList<TLSRoute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VirtualServiceSpec() {
    }

    /**
     * 
     * @param tcp
     * @param gateways
     * @param hosts
     * @param http
     * @param tls
     * @param exportTo
     */
    public VirtualServiceSpec(List<String> exportTo, List<String> gateways, List<String> hosts, List<HTTPRoute> http, List<TCPRoute> tcp, List<TLSRoute> tls) {
        super();
        this.exportTo = exportTo;
        this.gateways = gateways;
        this.hosts = hosts;
        this.http = http;
        this.tcp = tcp;
        this.tls = tls;
    }

    @JsonProperty("exportTo")
    public List<String> getExportTo() {
        return exportTo;
    }

    @JsonProperty("exportTo")
    public void setExportTo(List<String> exportTo) {
        this.exportTo = exportTo;
    }

    @JsonProperty("gateways")
    public List<String> getGateways() {
        return gateways;
    }

    @JsonProperty("gateways")
    public void setGateways(List<String> gateways) {
        this.gateways = gateways;
    }

    @JsonProperty("hosts")
    public List<String> getHosts() {
        return hosts;
    }

    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @JsonProperty("http")
    public List<HTTPRoute> getHttp() {
        return http;
    }

    @JsonProperty("http")
    public void setHttp(List<HTTPRoute> http) {
        this.http = http;
    }

    @JsonProperty("tcp")
    public List<TCPRoute> getTcp() {
        return tcp;
    }

    @JsonProperty("tcp")
    public void setTcp(List<TCPRoute> tcp) {
        this.tcp = tcp;
    }

    @JsonProperty("tls")
    public List<TLSRoute> getTls() {
        return tls;
    }

    @JsonProperty("tls")
    public void setTls(List<TLSRoute> tls) {
        this.tls = tls;
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
