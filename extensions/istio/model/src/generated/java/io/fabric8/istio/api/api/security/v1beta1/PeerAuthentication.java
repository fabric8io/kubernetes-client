
package io.fabric8.istio.api.api.security.v1beta1;

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
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mtls",
    "portLevelMtls",
    "selector"
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
@Version("v1beta1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PeerAuthentication implements Editable<PeerAuthenticationBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("mtls")
    private PeerAuthenticationMutualTLS mtls;
    @JsonProperty("portLevelMtls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PeerAuthenticationMutualTLS> portLevelMtls = new LinkedHashMap<>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PeerAuthentication() {
    }

    public PeerAuthentication(PeerAuthenticationMutualTLS mtls, Map<String, PeerAuthenticationMutualTLS> portLevelMtls, WorkloadSelector selector) {
        super();
        this.mtls = mtls;
        this.portLevelMtls = portLevelMtls;
        this.selector = selector;
    }

    /**
     * &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("mtls")
    public PeerAuthenticationMutualTLS getMtls() {
        return mtls;
    }

    /**
     * &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("mtls")
    public void setMtls(PeerAuthenticationMutualTLS mtls) {
        this.mtls = mtls;
    }

    /**
     * Port specific mutual TLS settings. These only apply when a workload selector is specified. The port refers to the port of the workload, not the port of the Kubernetes service.
     */
    @JsonProperty("portLevelMtls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, PeerAuthenticationMutualTLS> getPortLevelMtls() {
        return portLevelMtls;
    }

    /**
     * Port specific mutual TLS settings. These only apply when a workload selector is specified. The port refers to the port of the workload, not the port of the Kubernetes service.
     */
    @JsonProperty("portLevelMtls")
    public void setPortLevelMtls(Map<String, PeerAuthenticationMutualTLS> portLevelMtls) {
        this.portLevelMtls = portLevelMtls;
    }

    /**
     * &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public PeerAuthenticationBuilder edit() {
        return new PeerAuthenticationBuilder(this);
    }

    @JsonIgnore
    public PeerAuthenticationBuilder toBuilder() {
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
        if (!(o instanceof PeerAuthentication)) {
            return false;
        }
        PeerAuthentication other = (PeerAuthentication) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mtls = this.getMtls();
        Object other$mtls = other.getMtls();
        if (this$mtls == null ? other$mtls != null : !this$mtls.equals(other$mtls)) {
            return false;
        }
        Object this$portLevelMtls = this.getPortLevelMtls();
        Object other$portLevelMtls = other.getPortLevelMtls();
        if (this$portLevelMtls == null ? other$portLevelMtls != null : !this$portLevelMtls.equals(other$portLevelMtls)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
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
        return other instanceof PeerAuthentication;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mtls = this.getMtls();
        result = result * prime + ($mtls == null ? 43 : $mtls.hashCode());
        Object $portLevelMtls = this.getPortLevelMtls();
        result = result * prime + ($portLevelMtls == null ? 43 : $portLevelMtls.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PeerAuthentication(" + "mtls=" + this.getMtls() + ", portLevelMtls=" + this.getPortLevelMtls() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
