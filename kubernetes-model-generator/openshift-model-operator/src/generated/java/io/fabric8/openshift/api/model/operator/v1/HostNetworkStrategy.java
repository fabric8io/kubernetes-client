
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
 * HostNetworkStrategy holds parameters for the HostNetwork endpoint publishing strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpPort",
    "httpsPort",
    "protocol",
    "statsPort"
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
public class HostNetworkStrategy implements Editable<HostNetworkStrategyBuilder>, KubernetesResource
{

    @JsonProperty("httpPort")
    private Integer httpPort;
    @JsonProperty("httpsPort")
    private Integer httpsPort;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("statsPort")
    private Integer statsPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostNetworkStrategy() {
    }

    public HostNetworkStrategy(Integer httpPort, Integer httpsPort, String protocol, Integer statsPort) {
        super();
        this.httpPort = httpPort;
        this.httpsPort = httpsPort;
        this.protocol = protocol;
        this.statsPort = statsPort;
    }

    /**
     * httpPort is the port on the host which should be used to listen for HTTP requests. This field should be set when port 80 is already in use. The value should not coincide with the NodePort range of the cluster. When the value is 0 or is not specified it defaults to 80.
     */
    @JsonProperty("httpPort")
    public Integer getHttpPort() {
        return httpPort;
    }

    /**
     * httpPort is the port on the host which should be used to listen for HTTP requests. This field should be set when port 80 is already in use. The value should not coincide with the NodePort range of the cluster. When the value is 0 or is not specified it defaults to 80.
     */
    @JsonProperty("httpPort")
    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    /**
     * httpsPort is the port on the host which should be used to listen for HTTPS requests. This field should be set when port 443 is already in use. The value should not coincide with the NodePort range of the cluster. When the value is 0 or is not specified it defaults to 443.
     */
    @JsonProperty("httpsPort")
    public Integer getHttpsPort() {
        return httpsPort;
    }

    /**
     * httpsPort is the port on the host which should be used to listen for HTTPS requests. This field should be set when port 443 is already in use. The value should not coincide with the NodePort range of the cluster. When the value is 0 or is not specified it defaults to 443.
     */
    @JsonProperty("httpsPort")
    public void setHttpsPort(Integer httpsPort) {
        this.httpsPort = httpsPort;
    }

    /**
     * protocol specifies whether the IngressController expects incoming connections to use plain TCP or whether the IngressController expects PROXY protocol.<br><p> <br><p> PROXY protocol can be used with load balancers that support it to communicate the source addresses of client connections when forwarding those connections to the IngressController.  Using PROXY protocol enables the IngressController to report those source addresses instead of reporting the load balancer's address in HTTP headers and logs.  Note that enabling PROXY protocol on the IngressController will cause connections to fail if you are not using a load balancer that uses PROXY protocol to forward connections to the IngressController.  See http://www.haproxy.org/download/2.2/doc/proxy-protocol.txt for information about PROXY protocol.<br><p> <br><p> The following values are valid for this field:<br><p> <br><p> &#42; The empty string. &#42; "TCP". &#42; "PROXY".<br><p> <br><p> The empty string specifies the default, which is TCP without PROXY protocol.  Note that the default is subject to change.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * protocol specifies whether the IngressController expects incoming connections to use plain TCP or whether the IngressController expects PROXY protocol.<br><p> <br><p> PROXY protocol can be used with load balancers that support it to communicate the source addresses of client connections when forwarding those connections to the IngressController.  Using PROXY protocol enables the IngressController to report those source addresses instead of reporting the load balancer's address in HTTP headers and logs.  Note that enabling PROXY protocol on the IngressController will cause connections to fail if you are not using a load balancer that uses PROXY protocol to forward connections to the IngressController.  See http://www.haproxy.org/download/2.2/doc/proxy-protocol.txt for information about PROXY protocol.<br><p> <br><p> The following values are valid for this field:<br><p> <br><p> &#42; The empty string. &#42; "TCP". &#42; "PROXY".<br><p> <br><p> The empty string specifies the default, which is TCP without PROXY protocol.  Note that the default is subject to change.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * statsPort is the port on the host where the stats from the router are published. The value should not coincide with the NodePort range of the cluster. If an external load balancer is configured to forward connections to this IngressController, the load balancer should use this port for health checks. The load balancer can send HTTP probes on this port on a given node, with the path /healthz/ready to determine if the ingress controller is ready to receive traffic on the node. For proper operation the load balancer must not forward traffic to a node until the health check reports ready. The load balancer should also stop forwarding requests within a maximum of 45 seconds after /healthz/ready starts reporting not-ready. Probing every 5 to 10 seconds, with a 5-second timeout and with a threshold of two successful or failed requests to become healthy or unhealthy respectively, are well-tested values. When the value is 0 or is not specified it defaults to 1936.
     */
    @JsonProperty("statsPort")
    public Integer getStatsPort() {
        return statsPort;
    }

    /**
     * statsPort is the port on the host where the stats from the router are published. The value should not coincide with the NodePort range of the cluster. If an external load balancer is configured to forward connections to this IngressController, the load balancer should use this port for health checks. The load balancer can send HTTP probes on this port on a given node, with the path /healthz/ready to determine if the ingress controller is ready to receive traffic on the node. For proper operation the load balancer must not forward traffic to a node until the health check reports ready. The load balancer should also stop forwarding requests within a maximum of 45 seconds after /healthz/ready starts reporting not-ready. Probing every 5 to 10 seconds, with a 5-second timeout and with a threshold of two successful or failed requests to become healthy or unhealthy respectively, are well-tested values. When the value is 0 or is not specified it defaults to 1936.
     */
    @JsonProperty("statsPort")
    public void setStatsPort(Integer statsPort) {
        this.statsPort = statsPort;
    }

    @JsonIgnore
    public HostNetworkStrategyBuilder edit() {
        return new HostNetworkStrategyBuilder(this);
    }

    @JsonIgnore
    public HostNetworkStrategyBuilder toBuilder() {
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
