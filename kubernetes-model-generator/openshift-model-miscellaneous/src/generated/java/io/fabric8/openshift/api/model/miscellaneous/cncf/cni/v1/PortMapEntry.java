
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
 * PortMapEntry for CNI PortMapEntry
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerPort",
    "hostIP",
    "hostPort",
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
public class PortMapEntry implements Editable<PortMapEntryBuilder>, KubernetesResource
{

    @JsonProperty("containerPort")
    private Integer containerPort;
    @JsonProperty("hostIP")
    private String hostIP;
    @JsonProperty("hostPort")
    private Integer hostPort;
    @JsonProperty("protocol")
    private String protocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PortMapEntry() {
    }

    public PortMapEntry(Integer containerPort, String hostIP, Integer hostPort, String protocol) {
        super();
        this.containerPort = containerPort;
        this.hostIP = hostIP;
        this.hostPort = hostPort;
        this.protocol = protocol;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("containerPort")
    public Integer getContainerPort() {
        return containerPort;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("containerPort")
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("hostIP")
    public String getHostIP() {
        return hostIP;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("hostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("hostPort")
    public Integer getHostPort() {
        return hostPort;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("hostPort")
    public void setHostPort(Integer hostPort) {
        this.hostPort = hostPort;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * PortMapEntry for CNI PortMapEntry
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonIgnore
    public PortMapEntryBuilder edit() {
        return new PortMapEntryBuilder(this);
    }

    @JsonIgnore
    public PortMapEntryBuilder toBuilder() {
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
        if (!(o instanceof PortMapEntry)) {
            return false;
        }
        PortMapEntry other = (PortMapEntry) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerPort = this.getContainerPort();
        Object other$containerPort = other.getContainerPort();
        if (this$containerPort == null ? other$containerPort != null : !this$containerPort.equals(other$containerPort)) {
            return false;
        }
        Object this$hostIP = this.getHostIP();
        Object other$hostIP = other.getHostIP();
        if (this$hostIP == null ? other$hostIP != null : !this$hostIP.equals(other$hostIP)) {
            return false;
        }
        Object this$hostPort = this.getHostPort();
        Object other$hostPort = other.getHostPort();
        if (this$hostPort == null ? other$hostPort != null : !this$hostPort.equals(other$hostPort)) {
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
        return other instanceof PortMapEntry;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerPort = this.getContainerPort();
        result = result * prime + ($containerPort == null ? 43 : $containerPort.hashCode());
        Object $hostIP = this.getHostIP();
        result = result * prime + ($hostIP == null ? 43 : $hostIP.hashCode());
        Object $hostPort = this.getHostPort();
        result = result * prime + ($hostPort == null ? 43 : $hostPort.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PortMapEntry(" + "containerPort=" + this.getContainerPort() + ", hostIP=" + this.getHostIP() + ", hostPort=" + this.getHostPort() + ", protocol=" + this.getProtocol() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
