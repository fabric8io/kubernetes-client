
package io.fabric8.certmanager.api.model.acme.v1;

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
 * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dns01",
    "http01",
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ACMEChallengeSolver implements Editable<ACMEChallengeSolverBuilder>, KubernetesResource
{

    @JsonProperty("dns01")
    private ACMEChallengeSolverDNS01 dns01;
    @JsonProperty("http01")
    private ACMEChallengeSolverHTTP01 http01;
    @JsonProperty("selector")
    private CertificateDNSNameSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEChallengeSolver() {
    }

    public ACMEChallengeSolver(ACMEChallengeSolverDNS01 dns01, ACMEChallengeSolverHTTP01 http01, CertificateDNSNameSelector selector) {
        super();
        this.dns01 = dns01;
        this.http01 = http01;
        this.selector = selector;
    }

    /**
     * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
     */
    @JsonProperty("dns01")
    public ACMEChallengeSolverDNS01 getDns01() {
        return dns01;
    }

    /**
     * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
     */
    @JsonProperty("dns01")
    public void setDns01(ACMEChallengeSolverDNS01 dns01) {
        this.dns01 = dns01;
    }

    /**
     * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
     */
    @JsonProperty("http01")
    public ACMEChallengeSolverHTTP01 getHttp01() {
        return http01;
    }

    /**
     * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
     */
    @JsonProperty("http01")
    public void setHttp01(ACMEChallengeSolverHTTP01 http01) {
        this.http01 = http01;
    }

    /**
     * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
     */
    @JsonProperty("selector")
    public CertificateDNSNameSelector getSelector() {
        return selector;
    }

    /**
     * An ACMEChallengeSolver describes how to solve ACME challenges for the issuer it is part of. A selector may be provided to use different solving strategies for different DNS names. Only one of HTTP01 or DNS01 must be provided.
     */
    @JsonProperty("selector")
    public void setSelector(CertificateDNSNameSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public ACMEChallengeSolverBuilder edit() {
        return new ACMEChallengeSolverBuilder(this);
    }

    @JsonIgnore
    public ACMEChallengeSolverBuilder toBuilder() {
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
        if (!(o instanceof ACMEChallengeSolver)) {
            return false;
        }
        ACMEChallengeSolver other = (ACMEChallengeSolver) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dns01 = this.getDns01();
        Object other$dns01 = other.getDns01();
        if (this$dns01 == null ? other$dns01 != null : !this$dns01.equals(other$dns01)) {
            return false;
        }
        Object this$http01 = this.getHttp01();
        Object other$http01 = other.getHttp01();
        if (this$http01 == null ? other$http01 != null : !this$http01.equals(other$http01)) {
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
        return other instanceof ACMEChallengeSolver;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dns01 = this.getDns01();
        result = result * prime + ($dns01 == null ? 43 : $dns01.hashCode());
        Object $http01 = this.getHttp01();
        result = result * prime + ($http01 == null ? 43 : $http01.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEChallengeSolver(" + "dns01=" + this.getDns01() + ", http01=" + this.getHttp01() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
