
package io.fabric8.certmanager.api.model.acme.v1;

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
    "dns01",
    "http01",
    "selector"
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
public class ACMEChallengeSolver implements KubernetesResource
{

    @JsonProperty("dns01")
    private ACMEChallengeSolverDNS01 dns01;
    @JsonProperty("http01")
    private ACMEChallengeSolverHTTP01 http01;
    @JsonProperty("selector")
    private CertificateDNSNameSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEChallengeSolver() {
    }

    /**
     * 
     * @param http01
     * @param selector
     * @param dns01
     */
    public ACMEChallengeSolver(ACMEChallengeSolverDNS01 dns01, ACMEChallengeSolverHTTP01 http01, CertificateDNSNameSelector selector) {
        super();
        this.dns01 = dns01;
        this.http01 = http01;
        this.selector = selector;
    }

    @JsonProperty("dns01")
    public ACMEChallengeSolverDNS01 getDns01() {
        return dns01;
    }

    @JsonProperty("dns01")
    public void setDns01(ACMEChallengeSolverDNS01 dns01) {
        this.dns01 = dns01;
    }

    @JsonProperty("http01")
    public ACMEChallengeSolverHTTP01 getHttp01() {
        return http01;
    }

    @JsonProperty("http01")
    public void setHttp01(ACMEChallengeSolverHTTP01 http01) {
        this.http01 = http01;
    }

    @JsonProperty("selector")
    public CertificateDNSNameSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(CertificateDNSNameSelector selector) {
        this.selector = selector;
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
