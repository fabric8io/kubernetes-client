
package io.fabric8.certmanager.api.model.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "countries",
    "localities",
    "organizationalUnits",
    "organizations",
    "postalCodes",
    "provinces",
    "serialNumber",
    "streetAddresses"
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
public class X509Subject implements Editable<X509SubjectBuilder> , KubernetesResource
{

    @JsonProperty("countries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> countries = new ArrayList<>();
    @JsonProperty("localities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> localities = new ArrayList<>();
    @JsonProperty("organizationalUnits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> organizationalUnits = new ArrayList<>();
    @JsonProperty("organizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> organizations = new ArrayList<>();
    @JsonProperty("postalCodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> postalCodes = new ArrayList<>();
    @JsonProperty("provinces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> provinces = new ArrayList<>();
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("streetAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> streetAddresses = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public X509Subject() {
    }

    public X509Subject(List<String> countries, List<String> localities, List<String> organizationalUnits, List<String> organizations, List<String> postalCodes, List<String> provinces, String serialNumber, List<String> streetAddresses) {
        super();
        this.countries = countries;
        this.localities = localities;
        this.organizationalUnits = organizationalUnits;
        this.organizations = organizations;
        this.postalCodes = postalCodes;
        this.provinces = provinces;
        this.serialNumber = serialNumber;
        this.streetAddresses = streetAddresses;
    }

    @JsonProperty("countries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @JsonProperty("localities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLocalities() {
        return localities;
    }

    @JsonProperty("localities")
    public void setLocalities(List<String> localities) {
        this.localities = localities;
    }

    @JsonProperty("organizationalUnits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrganizationalUnits() {
        return organizationalUnits;
    }

    @JsonProperty("organizationalUnits")
    public void setOrganizationalUnits(List<String> organizationalUnits) {
        this.organizationalUnits = organizationalUnits;
    }

    @JsonProperty("organizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrganizations() {
        return organizations;
    }

    @JsonProperty("organizations")
    public void setOrganizations(List<String> organizations) {
        this.organizations = organizations;
    }

    @JsonProperty("postalCodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPostalCodes() {
        return postalCodes;
    }

    @JsonProperty("postalCodes")
    public void setPostalCodes(List<String> postalCodes) {
        this.postalCodes = postalCodes;
    }

    @JsonProperty("provinces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getProvinces() {
        return provinces;
    }

    @JsonProperty("provinces")
    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonProperty("streetAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getStreetAddresses() {
        return streetAddresses;
    }

    @JsonProperty("streetAddresses")
    public void setStreetAddresses(List<String> streetAddresses) {
        this.streetAddresses = streetAddresses;
    }

    @JsonIgnore
    public X509SubjectBuilder edit() {
        return new X509SubjectBuilder(this);
    }

    @JsonIgnore
    public X509SubjectBuilder toBuilder() {
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
