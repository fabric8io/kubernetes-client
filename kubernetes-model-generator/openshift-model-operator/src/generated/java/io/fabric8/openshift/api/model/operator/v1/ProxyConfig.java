
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.List;
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
 * ProxyConfig defines the configuration knobs for kubeproxy All of these are optional and have sensible defaults
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindAddress",
    "iptablesSyncPeriod",
    "proxyArguments"
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
public class ProxyConfig implements Editable<ProxyConfigBuilder>, KubernetesResource
{

    @JsonProperty("bindAddress")
    private String bindAddress;
    @JsonProperty("iptablesSyncPeriod")
    private String iptablesSyncPeriod;
    @JsonProperty("proxyArguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> proxyArguments = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProxyConfig() {
    }

    public ProxyConfig(String bindAddress, String iptablesSyncPeriod, Map<String, List<String>> proxyArguments) {
        super();
        this.bindAddress = bindAddress;
        this.iptablesSyncPeriod = iptablesSyncPeriod;
        this.proxyArguments = proxyArguments;
    }

    /**
     * The address to "bind" on Defaults to 0.0.0.0
     */
    @JsonProperty("bindAddress")
    public String getBindAddress() {
        return bindAddress;
    }

    /**
     * The address to "bind" on Defaults to 0.0.0.0
     */
    @JsonProperty("bindAddress")
    public void setBindAddress(String bindAddress) {
        this.bindAddress = bindAddress;
    }

    /**
     * An internal kube-proxy parameter. In older releases of OCP, this sometimes needed to be adjusted in large clusters for performance reasons, but this is no longer necessary, and there is no reason to change this from the default value. Default: 30s
     */
    @JsonProperty("iptablesSyncPeriod")
    public String getIptablesSyncPeriod() {
        return iptablesSyncPeriod;
    }

    /**
     * An internal kube-proxy parameter. In older releases of OCP, this sometimes needed to be adjusted in large clusters for performance reasons, but this is no longer necessary, and there is no reason to change this from the default value. Default: 30s
     */
    @JsonProperty("iptablesSyncPeriod")
    public void setIptablesSyncPeriod(String iptablesSyncPeriod) {
        this.iptablesSyncPeriod = iptablesSyncPeriod;
    }

    /**
     * Any additional arguments to pass to the kubeproxy process
     */
    @JsonProperty("proxyArguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getProxyArguments() {
        return proxyArguments;
    }

    /**
     * Any additional arguments to pass to the kubeproxy process
     */
    @JsonProperty("proxyArguments")
    public void setProxyArguments(Map<String, List<String>> proxyArguments) {
        this.proxyArguments = proxyArguments;
    }

    @JsonIgnore
    public ProxyConfigBuilder edit() {
        return new ProxyConfigBuilder(this);
    }

    @JsonIgnore
    public ProxyConfigBuilder toBuilder() {
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
        if (!(o instanceof ProxyConfig)) {
            return false;
        }
        ProxyConfig other = (ProxyConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bindAddress = this.getBindAddress();
        Object other$bindAddress = other.getBindAddress();
        if (this$bindAddress == null ? other$bindAddress != null : !this$bindAddress.equals(other$bindAddress)) {
            return false;
        }
        Object this$iptablesSyncPeriod = this.getIptablesSyncPeriod();
        Object other$iptablesSyncPeriod = other.getIptablesSyncPeriod();
        if (this$iptablesSyncPeriod == null ? other$iptablesSyncPeriod != null : !this$iptablesSyncPeriod.equals(other$iptablesSyncPeriod)) {
            return false;
        }
        Object this$proxyArguments = this.getProxyArguments();
        Object other$proxyArguments = other.getProxyArguments();
        if (this$proxyArguments == null ? other$proxyArguments != null : !this$proxyArguments.equals(other$proxyArguments)) {
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
        return other instanceof ProxyConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bindAddress = this.getBindAddress();
        result = result * prime + ($bindAddress == null ? 43 : $bindAddress.hashCode());
        Object $iptablesSyncPeriod = this.getIptablesSyncPeriod();
        result = result * prime + ($iptablesSyncPeriod == null ? 43 : $iptablesSyncPeriod.hashCode());
        Object $proxyArguments = this.getProxyArguments();
        result = result * prime + ($proxyArguments == null ? 43 : $proxyArguments.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProxyConfig(" + "bindAddress=" + this.getBindAddress() + ", iptablesSyncPeriod=" + this.getIptablesSyncPeriod() + ", proxyArguments=" + this.getProxyArguments() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
