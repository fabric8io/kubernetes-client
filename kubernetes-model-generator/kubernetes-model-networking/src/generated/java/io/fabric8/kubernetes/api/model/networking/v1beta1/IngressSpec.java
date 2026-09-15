
package io.fabric8.kubernetes.api.model.networking.v1beta1;

import java.util.ArrayList;
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
 * IngressSpec describes the Ingress the user wishes to exist.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backend",
    "ingressClassName",
    "rules",
    "tls"
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
public class IngressSpec implements Editable<IngressSpecBuilder>, KubernetesResource
{

    @JsonProperty("backend")
    private IngressBackend backend;
    @JsonProperty("ingressClassName")
    private String ingressClassName;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressRule> rules = new ArrayList<>();
    @JsonProperty("tls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressTLS> tls = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressSpec() {
    }

    public IngressSpec(IngressBackend backend, String ingressClassName, List<IngressRule> rules, List<IngressTLS> tls) {
        super();
        this.backend = backend;
        this.ingressClassName = ingressClassName;
        this.rules = rules;
        this.tls = tls;
    }

    /**
     * IngressSpec describes the Ingress the user wishes to exist.
     */
    @JsonProperty("backend")
    public IngressBackend getBackend() {
        return backend;
    }

    /**
     * IngressSpec describes the Ingress the user wishes to exist.
     */
    @JsonProperty("backend")
    public void setBackend(IngressBackend backend) {
        this.backend = backend;
    }

    /**
     * IngressClassName is the name of the IngressClass cluster resource. The associated IngressClass defines which controller will implement the resource. This replaces the deprecated `kubernetes.io/ingress.class` annotation. For backwards compatibility, when that annotation is set, it must be given precedence over this field. The controller may emit a warning if the field and annotation have different values. Implementations of this API should ignore Ingresses without a class specified. An IngressClass resource may be marked as default, which can be used to set a default value for this field. For more information, refer to the IngressClass documentation.
     */
    @JsonProperty("ingressClassName")
    public String getIngressClassName() {
        return ingressClassName;
    }

    /**
     * IngressClassName is the name of the IngressClass cluster resource. The associated IngressClass defines which controller will implement the resource. This replaces the deprecated `kubernetes.io/ingress.class` annotation. For backwards compatibility, when that annotation is set, it must be given precedence over this field. The controller may emit a warning if the field and annotation have different values. Implementations of this API should ignore Ingresses without a class specified. An IngressClass resource may be marked as default, which can be used to set a default value for this field. For more information, refer to the IngressClass documentation.
     */
    @JsonProperty("ingressClassName")
    public void setIngressClassName(String ingressClassName) {
        this.ingressClassName = ingressClassName;
    }

    /**
     * A list of host rules used to configure the Ingress. If unspecified, or no rule matches, all traffic is sent to the default backend.
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressRule> getRules() {
        return rules;
    }

    /**
     * A list of host rules used to configure the Ingress. If unspecified, or no rule matches, all traffic is sent to the default backend.
     */
    @JsonProperty("rules")
    public void setRules(List<IngressRule> rules) {
        this.rules = rules;
    }

    /**
     * TLS configuration. Currently the Ingress only supports a single TLS port, 443. If multiple members of this list specify different hosts, they will be multiplexed on the same port according to the hostname specified through the SNI TLS extension, if the ingress controller fulfilling the ingress supports SNI.
     */
    @JsonProperty("tls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressTLS> getTls() {
        return tls;
    }

    /**
     * TLS configuration. Currently the Ingress only supports a single TLS port, 443. If multiple members of this list specify different hosts, they will be multiplexed on the same port according to the hostname specified through the SNI TLS extension, if the ingress controller fulfilling the ingress supports SNI.
     */
    @JsonProperty("tls")
    public void setTls(List<IngressTLS> tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public IngressSpecBuilder edit() {
        return new IngressSpecBuilder(this);
    }

    @JsonIgnore
    public IngressSpecBuilder toBuilder() {
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
        if (!(o instanceof IngressSpec)) {
            return false;
        }
        IngressSpec other = (IngressSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$backend = this.getBackend();
        Object other$backend = other.getBackend();
        if (this$backend == null ? other$backend != null : !this$backend.equals(other$backend)) {
            return false;
        }
        Object this$ingressClassName = this.getIngressClassName();
        Object other$ingressClassName = other.getIngressClassName();
        if (this$ingressClassName == null ? other$ingressClassName != null : !this$ingressClassName.equals(other$ingressClassName)) {
            return false;
        }
        Object this$rules = this.getRules();
        Object other$rules = other.getRules();
        if (this$rules == null ? other$rules != null : !this$rules.equals(other$rules)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
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
        return other instanceof IngressSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $backend = this.getBackend();
        result = result * prime + ($backend == null ? 43 : $backend.hashCode());
        Object $ingressClassName = this.getIngressClassName();
        result = result * prime + ($ingressClassName == null ? 43 : $ingressClassName.hashCode());
        Object $rules = this.getRules();
        result = result * prime + ($rules == null ? 43 : $rules.hashCode());
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressSpec(" + "backend=" + this.getBackend() + ", ingressClassName=" + this.getIngressClassName() + ", rules=" + this.getRules() + ", tls=" + this.getTls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
