
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
 * IBMLoadBalancerParameters provides configuration settings that are specific to IBM Cloud load balancers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "protocol"
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
public class IBMLoadBalancerParameters implements Editable<IBMLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("protocol")
    private String protocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IBMLoadBalancerParameters() {
    }

    public IBMLoadBalancerParameters(String protocol) {
        super();
        this.protocol = protocol;
    }

    /**
     * protocol specifies whether the load balancer uses PROXY protocol to forward connections to the IngressController. See "service.kubernetes.io/ibm-load-balancer-cloud-provider-enable-features: "proxy-protocol"" at https://cloud.ibm.com/docs/containers?topic=containers-vpc-lbaas"<br><p> <br><p> PROXY protocol can be used with load balancers that support it to communicate the source addresses of client connections when forwarding those connections to the IngressController.  Using PROXY protocol enables the IngressController to report those source addresses instead of reporting the load balancer's address in HTTP headers and logs.  Note that enabling PROXY protocol on the IngressController will cause connections to fail if you are not using a load balancer that uses PROXY protocol to forward connections to the IngressController.  See http://www.haproxy.org/download/2.2/doc/proxy-protocol.txt for information about PROXY protocol.<br><p> <br><p> Valid values for protocol are TCP, PROXY and omitted. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is TCP, without the proxy protocol enabled.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * protocol specifies whether the load balancer uses PROXY protocol to forward connections to the IngressController. See "service.kubernetes.io/ibm-load-balancer-cloud-provider-enable-features: "proxy-protocol"" at https://cloud.ibm.com/docs/containers?topic=containers-vpc-lbaas"<br><p> <br><p> PROXY protocol can be used with load balancers that support it to communicate the source addresses of client connections when forwarding those connections to the IngressController.  Using PROXY protocol enables the IngressController to report those source addresses instead of reporting the load balancer's address in HTTP headers and logs.  Note that enabling PROXY protocol on the IngressController will cause connections to fail if you are not using a load balancer that uses PROXY protocol to forward connections to the IngressController.  See http://www.haproxy.org/download/2.2/doc/proxy-protocol.txt for information about PROXY protocol.<br><p> <br><p> Valid values for protocol are TCP, PROXY and omitted. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is TCP, without the proxy protocol enabled.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonIgnore
    public IBMLoadBalancerParametersBuilder edit() {
        return new IBMLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public IBMLoadBalancerParametersBuilder toBuilder() {
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
