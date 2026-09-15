
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterTLSConfig defines the mutual TLS configuration for the Alertmanager cluster TLS protocol.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "client",
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
public class ClusterTLSConfig implements Editable<ClusterTLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("client")
    private SafeTLSConfig client;
    @JsonProperty("server")
    private WebTLSConfig server;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterTLSConfig() {
    }

    public ClusterTLSConfig(SafeTLSConfig client, WebTLSConfig server) {
        super();
        this.client = client;
        this.server = server;
    }

    /**
     * ClusterTLSConfig defines the mutual TLS configuration for the Alertmanager cluster TLS protocol.
     */
    @JsonProperty("client")
    public SafeTLSConfig getClient() {
        return client;
    }

    /**
     * ClusterTLSConfig defines the mutual TLS configuration for the Alertmanager cluster TLS protocol.
     */
    @JsonProperty("client")
    public void setClient(SafeTLSConfig client) {
        this.client = client;
    }

    /**
     * ClusterTLSConfig defines the mutual TLS configuration for the Alertmanager cluster TLS protocol.
     */
    @JsonProperty("server")
    public WebTLSConfig getServer() {
        return server;
    }

    /**
     * ClusterTLSConfig defines the mutual TLS configuration for the Alertmanager cluster TLS protocol.
     */
    @JsonProperty("server")
    public void setServer(WebTLSConfig server) {
        this.server = server;
    }

    @JsonIgnore
    public ClusterTLSConfigBuilder edit() {
        return new ClusterTLSConfigBuilder(this);
    }

    @JsonIgnore
    public ClusterTLSConfigBuilder toBuilder() {
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
        if (!(o instanceof ClusterTLSConfig)) {
            return false;
        }
        ClusterTLSConfig other = (ClusterTLSConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$client = this.getClient();
        Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) {
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
        return other instanceof ClusterTLSConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $client = this.getClient();
        result = result * prime + ($client == null ? 43 : $client.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterTLSConfig(" + "client=" + this.getClient() + ", server=" + this.getServer() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
