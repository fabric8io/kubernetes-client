
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "grpc",
    "https",
    "protocol",
    "usage"
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
public class EndpointExposure implements Editable<EndpointExposureBuilder>, KubernetesResource
{

    @JsonProperty("grpc")
    private Endpoint grpc;
    @JsonProperty("https")
    private Endpoint https;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("usage")
    private String usage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EndpointExposure() {
    }

    public EndpointExposure(Endpoint grpc, Endpoint https, String protocol, String usage) {
        super();
        this.grpc = grpc;
        this.https = https;
        this.protocol = protocol;
        this.usage = usage;
    }

    @JsonProperty("grpc")
    public Endpoint getGrpc() {
        return grpc;
    }

    @JsonProperty("grpc")
    public void setGrpc(Endpoint grpc) {
        this.grpc = grpc;
    }

    @JsonProperty("https")
    public Endpoint getHttps() {
        return https;
    }

    @JsonProperty("https")
    public void setHttps(Endpoint https) {
        this.https = https;
    }

    /**
     * protocol is the protocol used for the endpoint, could be https or grpc.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * protocol is the protocol used for the endpoint, could be https or grpc.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * usage defines the usage of the endpoint. It could be "agentToHub" indicating the endpoint is used for communication between agent and hub, or "consumer" indicating the endpoint is used for external consumer.
     */
    @JsonProperty("usage")
    public String getUsage() {
        return usage;
    }

    /**
     * usage defines the usage of the endpoint. It could be "agentToHub" indicating the endpoint is used for communication between agent and hub, or "consumer" indicating the endpoint is used for external consumer.
     */
    @JsonProperty("usage")
    public void setUsage(String usage) {
        this.usage = usage;
    }

    @JsonIgnore
    public EndpointExposureBuilder edit() {
        return new EndpointExposureBuilder(this);
    }

    @JsonIgnore
    public EndpointExposureBuilder toBuilder() {
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
        if (!(o instanceof EndpointExposure)) {
            return false;
        }
        EndpointExposure other = (EndpointExposure) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$grpc = this.getGrpc();
        Object other$grpc = other.getGrpc();
        if (this$grpc == null ? other$grpc != null : !this$grpc.equals(other$grpc)) {
            return false;
        }
        Object this$https = this.getHttps();
        Object other$https = other.getHttps();
        if (this$https == null ? other$https != null : !this$https.equals(other$https)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$usage = this.getUsage();
        Object other$usage = other.getUsage();
        if (this$usage == null ? other$usage != null : !this$usage.equals(other$usage)) {
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
        return other instanceof EndpointExposure;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $grpc = this.getGrpc();
        result = result * prime + ($grpc == null ? 43 : $grpc.hashCode());
        Object $https = this.getHttps();
        result = result * prime + ($https == null ? 43 : $https.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $usage = this.getUsage();
        result = result * prime + ($usage == null ? 43 : $usage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EndpointExposure(" + "grpc=" + this.getGrpc() + ", https=" + this.getHttps() + ", protocol=" + this.getProtocol() + ", usage=" + this.getUsage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
