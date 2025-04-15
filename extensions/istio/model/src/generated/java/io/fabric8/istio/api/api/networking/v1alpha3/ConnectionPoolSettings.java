
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Connection pool settings for an upstream host. The settings apply to each individual host in the upstream service.  See Envoy's [circuit breaker](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) for more details. Connection pool settings can be applied at the TCP level as well as at HTTP level.<br><p> <br><p> For example, the following rule sets a limit of 100 connections to redis service called myredissrv with a connect timeout of 30ms<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-redis<br><p> <br><p> spec:<br><p> <br><p> 	host: myredissrv.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	      connectTimeout: 30ms<br><p> 	      tcpKeepalive:<br><p> 	        time: 7200s<br><p> 	        interval: 75s<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "http",
    "tcp"
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
public class ConnectionPoolSettings implements Editable<ConnectionPoolSettingsBuilder>, KubernetesResource
{

    @JsonProperty("http")
    private ConnectionPoolSettingsHTTPSettings http;
    @JsonProperty("tcp")
    private ConnectionPoolSettingsTCPSettings tcp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConnectionPoolSettings() {
    }

    public ConnectionPoolSettings(ConnectionPoolSettingsHTTPSettings http, ConnectionPoolSettingsTCPSettings tcp) {
        super();
        this.http = http;
        this.tcp = tcp;
    }

    /**
     * Connection pool settings for an upstream host. The settings apply to each individual host in the upstream service.  See Envoy's [circuit breaker](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) for more details. Connection pool settings can be applied at the TCP level as well as at HTTP level.<br><p> <br><p> For example, the following rule sets a limit of 100 connections to redis service called myredissrv with a connect timeout of 30ms<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-redis<br><p> <br><p> spec:<br><p> <br><p> 	host: myredissrv.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	      connectTimeout: 30ms<br><p> 	      tcpKeepalive:<br><p> 	        time: 7200s<br><p> 	        interval: 75s<br><p> <br><p> ```
     */
    @JsonProperty("http")
    public ConnectionPoolSettingsHTTPSettings getHttp() {
        return http;
    }

    /**
     * Connection pool settings for an upstream host. The settings apply to each individual host in the upstream service.  See Envoy's [circuit breaker](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) for more details. Connection pool settings can be applied at the TCP level as well as at HTTP level.<br><p> <br><p> For example, the following rule sets a limit of 100 connections to redis service called myredissrv with a connect timeout of 30ms<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-redis<br><p> <br><p> spec:<br><p> <br><p> 	host: myredissrv.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	      connectTimeout: 30ms<br><p> 	      tcpKeepalive:<br><p> 	        time: 7200s<br><p> 	        interval: 75s<br><p> <br><p> ```
     */
    @JsonProperty("http")
    public void setHttp(ConnectionPoolSettingsHTTPSettings http) {
        this.http = http;
    }

    /**
     * Connection pool settings for an upstream host. The settings apply to each individual host in the upstream service.  See Envoy's [circuit breaker](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) for more details. Connection pool settings can be applied at the TCP level as well as at HTTP level.<br><p> <br><p> For example, the following rule sets a limit of 100 connections to redis service called myredissrv with a connect timeout of 30ms<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-redis<br><p> <br><p> spec:<br><p> <br><p> 	host: myredissrv.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	      connectTimeout: 30ms<br><p> 	      tcpKeepalive:<br><p> 	        time: 7200s<br><p> 	        interval: 75s<br><p> <br><p> ```
     */
    @JsonProperty("tcp")
    public ConnectionPoolSettingsTCPSettings getTcp() {
        return tcp;
    }

    /**
     * Connection pool settings for an upstream host. The settings apply to each individual host in the upstream service.  See Envoy's [circuit breaker](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) for more details. Connection pool settings can be applied at the TCP level as well as at HTTP level.<br><p> <br><p> For example, the following rule sets a limit of 100 connections to redis service called myredissrv with a connect timeout of 30ms<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-redis<br><p> <br><p> spec:<br><p> <br><p> 	host: myredissrv.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	      connectTimeout: 30ms<br><p> 	      tcpKeepalive:<br><p> 	        time: 7200s<br><p> 	        interval: 75s<br><p> <br><p> ```
     */
    @JsonProperty("tcp")
    public void setTcp(ConnectionPoolSettingsTCPSettings tcp) {
        this.tcp = tcp;
    }

    @JsonIgnore
    public ConnectionPoolSettingsBuilder edit() {
        return new ConnectionPoolSettingsBuilder(this);
    }

    @JsonIgnore
    public ConnectionPoolSettingsBuilder toBuilder() {
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
