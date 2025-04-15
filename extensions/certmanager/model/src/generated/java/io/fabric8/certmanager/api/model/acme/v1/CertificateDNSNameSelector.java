
package io.fabric8.certmanager.api.model.acme.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * CertificateDNSNameSelector selects certificates using a label selector, and can optionally select individual DNS names within those certificates. If both MatchLabels and DNSNames are empty, this selector will match all certificates and DNS names within them.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dnsNames",
    "dnsZones",
    "matchLabels"
})
@ToString
@EqualsAndHashCode
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CertificateDNSNameSelector implements Editable<CertificateDNSNameSelectorBuilder>, KubernetesResource
{

    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsNames = new ArrayList<>();
    @JsonProperty("dnsZones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsZones = new ArrayList<>();
    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> matchLabels = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateDNSNameSelector() {
    }

    public CertificateDNSNameSelector(List<String> dnsNames, List<String> dnsZones, Map<String, String> matchLabels) {
        super();
        this.dnsNames = dnsNames;
        this.dnsZones = dnsZones;
        this.matchLabels = matchLabels;
    }

    /**
     * List of DNSNames that this solver will be used to solve. If specified and a match is found, a dnsNames selector will take precedence over a dnsZones selector. If multiple solvers match with the same dnsNames value, the solver with the most matching labels in matchLabels will be selected. If neither has more matches, the solver defined earlier in the list will be selected.
     */
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsNames() {
        return dnsNames;
    }

    /**
     * List of DNSNames that this solver will be used to solve. If specified and a match is found, a dnsNames selector will take precedence over a dnsZones selector. If multiple solvers match with the same dnsNames value, the solver with the most matching labels in matchLabels will be selected. If neither has more matches, the solver defined earlier in the list will be selected.
     */
    @JsonProperty("dnsNames")
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    /**
     * List of DNSZones that this solver will be used to solve. The most specific DNS zone match specified here will take precedence over other DNS zone matches, so a solver specifying sys.example.com will be selected over one specifying example.com for the domain www.sys.example.com. If multiple solvers match with the same dnsZones value, the solver with the most matching labels in matchLabels will be selected. If neither has more matches, the solver defined earlier in the list will be selected.
     */
    @JsonProperty("dnsZones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsZones() {
        return dnsZones;
    }

    /**
     * List of DNSZones that this solver will be used to solve. The most specific DNS zone match specified here will take precedence over other DNS zone matches, so a solver specifying sys.example.com will be selected over one specifying example.com for the domain www.sys.example.com. If multiple solvers match with the same dnsZones value, the solver with the most matching labels in matchLabels will be selected. If neither has more matches, the solver defined earlier in the list will be selected.
     */
    @JsonProperty("dnsZones")
    public void setDnsZones(List<String> dnsZones) {
        this.dnsZones = dnsZones;
    }

    /**
     * A label selector that is used to refine the set of certificate's that this challenge solver will apply to.
     */
    @JsonProperty("matchLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getMatchLabels() {
        return matchLabels;
    }

    /**
     * A label selector that is used to refine the set of certificate's that this challenge solver will apply to.
     */
    @JsonProperty("matchLabels")
    public void setMatchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
    }

    @JsonIgnore
    public CertificateDNSNameSelectorBuilder edit() {
        return new CertificateDNSNameSelectorBuilder(this);
    }

    @JsonIgnore
    public CertificateDNSNameSelectorBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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

}
