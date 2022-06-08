
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
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
    "connectTimeout",
    "maxConnections",
    "tcpKeepalive"
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
public class ConnectionPoolSettingsTCPSettings implements KubernetesResource
{

    @JsonProperty("connectTimeout")
    private String connectTimeout;
    @JsonProperty("maxConnections")
    private Integer maxConnections;
    @JsonProperty("tcpKeepalive")
    private ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConnectionPoolSettingsTCPSettings() {
    }

    /**
     * 
     * @param tcpKeepalive
     * @param connectTimeout
     * @param maxConnections
     */
    public ConnectionPoolSettingsTCPSettings(String connectTimeout, Integer maxConnections, ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive) {
        super();
        this.connectTimeout = connectTimeout;
        this.maxConnections = maxConnections;
        this.tcpKeepalive = tcpKeepalive;
    }

    @JsonProperty("connectTimeout")
    public String getConnectTimeout() {
        return connectTimeout;
    }

    @JsonProperty("connectTimeout")
    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    @JsonProperty("maxConnections")
    public Integer getMaxConnections() {
        return maxConnections;
    }

    @JsonProperty("maxConnections")
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    @JsonProperty("tcpKeepalive")
    public ConnectionPoolSettingsTCPSettingsTcpKeepalive getTcpKeepalive() {
        return tcpKeepalive;
    }

    @JsonProperty("tcpKeepalive")
    public void setTcpKeepalive(ConnectionPoolSettingsTCPSettingsTcpKeepalive tcpKeepalive) {
        this.tcpKeepalive = tcpKeepalive;
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
