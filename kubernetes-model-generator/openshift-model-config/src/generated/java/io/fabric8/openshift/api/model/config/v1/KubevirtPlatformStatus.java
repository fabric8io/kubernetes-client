
package io.fabric8.openshift.api.model.config.v1;

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
 * KubevirtPlatformStatus holds the current status of the kubevirt infrastructure provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalIP",
    "ingressIP"
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
public class KubevirtPlatformStatus implements Editable<KubevirtPlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("apiServerInternalIP")
    private String apiServerInternalIP;
    @JsonProperty("ingressIP")
    private String ingressIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KubevirtPlatformStatus() {
    }

    public KubevirtPlatformStatus(String apiServerInternalIP, String ingressIP) {
        super();
        this.apiServerInternalIP = apiServerInternalIP;
        this.ingressIP = ingressIP;
    }

    /**
     * apiServerInternalIP is an IP address to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. It is the IP that the Infrastructure.status.apiServerInternalURI points to. It is the IP for a self-hosted load balancer in front of the API servers.
     */
    @JsonProperty("apiServerInternalIP")
    public String getApiServerInternalIP() {
        return apiServerInternalIP;
    }

    /**
     * apiServerInternalIP is an IP address to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. It is the IP that the Infrastructure.status.apiServerInternalURI points to. It is the IP for a self-hosted load balancer in front of the API servers.
     */
    @JsonProperty("apiServerInternalIP")
    public void setApiServerInternalIP(String apiServerInternalIP) {
        this.apiServerInternalIP = apiServerInternalIP;
    }

    /**
     * ingressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names.
     */
    @JsonProperty("ingressIP")
    public String getIngressIP() {
        return ingressIP;
    }

    /**
     * ingressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names.
     */
    @JsonProperty("ingressIP")
    public void setIngressIP(String ingressIP) {
        this.ingressIP = ingressIP;
    }

    @JsonIgnore
    public KubevirtPlatformStatusBuilder edit() {
        return new KubevirtPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public KubevirtPlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof KubevirtPlatformStatus)) {
            return false;
        }
        KubevirtPlatformStatus other = (KubevirtPlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiServerInternalIP = this.getApiServerInternalIP();
        Object other$apiServerInternalIP = other.getApiServerInternalIP();
        if (this$apiServerInternalIP == null ? other$apiServerInternalIP != null : !this$apiServerInternalIP.equals(other$apiServerInternalIP)) {
            return false;
        }
        Object this$ingressIP = this.getIngressIP();
        Object other$ingressIP = other.getIngressIP();
        if (this$ingressIP == null ? other$ingressIP != null : !this$ingressIP.equals(other$ingressIP)) {
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
        return other instanceof KubevirtPlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiServerInternalIP = this.getApiServerInternalIP();
        result = result * prime + ($apiServerInternalIP == null ? 43 : $apiServerInternalIP.hashCode());
        Object $ingressIP = this.getIngressIP();
        result = result * prime + ($ingressIP == null ? 43 : $ingressIP.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KubevirtPlatformStatus(" + "apiServerInternalIP=" + this.getApiServerInternalIP() + ", ingressIP=" + this.getIngressIP() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
