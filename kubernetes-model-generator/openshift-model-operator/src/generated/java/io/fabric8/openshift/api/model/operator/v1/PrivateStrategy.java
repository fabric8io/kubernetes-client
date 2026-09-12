
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

/**
 * PrivateStrategy holds parameters for the Private endpoint publishing strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "protocol"
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
public class PrivateStrategy implements Editable<PrivateStrategyBuilder>, KubernetesResource
{

    @JsonProperty("protocol")
    private String protocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrivateStrategy() {
    }

    public PrivateStrategy(String protocol) {
        super();
        this.protocol = protocol;
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

    @JsonIgnore
    public PrivateStrategyBuilder edit() {
        return new PrivateStrategyBuilder(this);
    }

    @JsonIgnore
    public PrivateStrategyBuilder toBuilder() {
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
        if (!(o instanceof PrivateStrategy)) {
            return false;
        }
        PrivateStrategy other = (PrivateStrategy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
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
        return other instanceof PrivateStrategy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrivateStrategy(" + "protocol=" + this.getProtocol() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
