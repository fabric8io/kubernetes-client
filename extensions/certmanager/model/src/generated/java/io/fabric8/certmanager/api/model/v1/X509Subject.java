
package io.fabric8.certmanager.api.model.v1;

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
 * X509Subject Full X509 name specification
 */
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
public class X509Subject implements Editable<X509SubjectBuilder>, KubernetesResource
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

    /**
     * Countries to be used on the Certificate.
     */
    @JsonProperty("countries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCountries() {
        return countries;
    }

    /**
     * Countries to be used on the Certificate.
     */
    @JsonProperty("countries")
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    /**
     * Cities to be used on the Certificate.
     */
    @JsonProperty("localities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLocalities() {
        return localities;
    }

    /**
     * Cities to be used on the Certificate.
     */
    @JsonProperty("localities")
    public void setLocalities(List<String> localities) {
        this.localities = localities;
    }

    /**
     * Organizational Units to be used on the Certificate.
     */
    @JsonProperty("organizationalUnits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrganizationalUnits() {
        return organizationalUnits;
    }

    /**
     * Organizational Units to be used on the Certificate.
     */
    @JsonProperty("organizationalUnits")
    public void setOrganizationalUnits(List<String> organizationalUnits) {
        this.organizationalUnits = organizationalUnits;
    }

    /**
     * Organizations to be used on the Certificate.
     */
    @JsonProperty("organizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrganizations() {
        return organizations;
    }

    /**
     * Organizations to be used on the Certificate.
     */
    @JsonProperty("organizations")
    public void setOrganizations(List<String> organizations) {
        this.organizations = organizations;
    }

    /**
     * Postal codes to be used on the Certificate.
     */
    @JsonProperty("postalCodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPostalCodes() {
        return postalCodes;
    }

    /**
     * Postal codes to be used on the Certificate.
     */
    @JsonProperty("postalCodes")
    public void setPostalCodes(List<String> postalCodes) {
        this.postalCodes = postalCodes;
    }

    /**
     * State/Provinces to be used on the Certificate.
     */
    @JsonProperty("provinces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getProvinces() {
        return provinces;
    }

    /**
     * State/Provinces to be used on the Certificate.
     */
    @JsonProperty("provinces")
    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    /**
     * Serial number to be used on the Certificate.
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Serial number to be used on the Certificate.
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Street addresses to be used on the Certificate.
     */
    @JsonProperty("streetAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getStreetAddresses() {
        return streetAddresses;
    }

    /**
     * Street addresses to be used on the Certificate.
     */
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
        if (!(o instanceof X509Subject)) {
            return false;
        }
        X509Subject other = (X509Subject) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$countries = this.getCountries();
        Object other$countries = other.getCountries();
        if (this$countries == null ? other$countries != null : !this$countries.equals(other$countries)) {
            return false;
        }
        Object this$localities = this.getLocalities();
        Object other$localities = other.getLocalities();
        if (this$localities == null ? other$localities != null : !this$localities.equals(other$localities)) {
            return false;
        }
        Object this$organizationalUnits = this.getOrganizationalUnits();
        Object other$organizationalUnits = other.getOrganizationalUnits();
        if (this$organizationalUnits == null ? other$organizationalUnits != null : !this$organizationalUnits.equals(other$organizationalUnits)) {
            return false;
        }
        Object this$organizations = this.getOrganizations();
        Object other$organizations = other.getOrganizations();
        if (this$organizations == null ? other$organizations != null : !this$organizations.equals(other$organizations)) {
            return false;
        }
        Object this$postalCodes = this.getPostalCodes();
        Object other$postalCodes = other.getPostalCodes();
        if (this$postalCodes == null ? other$postalCodes != null : !this$postalCodes.equals(other$postalCodes)) {
            return false;
        }
        Object this$provinces = this.getProvinces();
        Object other$provinces = other.getProvinces();
        if (this$provinces == null ? other$provinces != null : !this$provinces.equals(other$provinces)) {
            return false;
        }
        Object this$serialNumber = this.getSerialNumber();
        Object other$serialNumber = other.getSerialNumber();
        if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(other$serialNumber)) {
            return false;
        }
        Object this$streetAddresses = this.getStreetAddresses();
        Object other$streetAddresses = other.getStreetAddresses();
        if (this$streetAddresses == null ? other$streetAddresses != null : !this$streetAddresses.equals(other$streetAddresses)) {
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
        return other instanceof X509Subject;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $countries = this.getCountries();
        result = result * prime + ($countries == null ? 43 : $countries.hashCode());
        Object $localities = this.getLocalities();
        result = result * prime + ($localities == null ? 43 : $localities.hashCode());
        Object $organizationalUnits = this.getOrganizationalUnits();
        result = result * prime + ($organizationalUnits == null ? 43 : $organizationalUnits.hashCode());
        Object $organizations = this.getOrganizations();
        result = result * prime + ($organizations == null ? 43 : $organizations.hashCode());
        Object $postalCodes = this.getPostalCodes();
        result = result * prime + ($postalCodes == null ? 43 : $postalCodes.hashCode());
        Object $provinces = this.getProvinces();
        result = result * prime + ($provinces == null ? 43 : $provinces.hashCode());
        Object $serialNumber = this.getSerialNumber();
        result = result * prime + ($serialNumber == null ? 43 : $serialNumber.hashCode());
        Object $streetAddresses = this.getStreetAddresses();
        result = result * prime + ($streetAddresses == null ? 43 : $streetAddresses.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "X509Subject(" + "countries=" + this.getCountries() + ", localities=" + this.getLocalities() + ", organizationalUnits=" + this.getOrganizationalUnits() + ", organizations=" + this.getOrganizations() + ", postalCodes=" + this.getPostalCodes() + ", provinces=" + this.getProvinces() + ", serialNumber=" + this.getSerialNumber() + ", streetAddresses=" + this.getStreetAddresses() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
