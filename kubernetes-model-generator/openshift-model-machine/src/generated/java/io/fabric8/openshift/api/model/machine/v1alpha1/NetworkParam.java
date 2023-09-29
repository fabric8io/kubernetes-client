
package io.fabric8.openshift.api.model.machine.v1alpha1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "filter",
    "fixedIp",
    "noAllowedAddressPairs",
    "portSecurity",
    "portTags",
    "profile",
    "subnets",
    "uuid",
    "vnicType"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class NetworkParam implements Editable<NetworkParamBuilder> , KubernetesResource
{

    @JsonProperty("filter")
    private Filter filter;
    @JsonProperty("fixedIp")
    private java.lang.String fixedIp;
    @JsonProperty("noAllowedAddressPairs")
    private Boolean noAllowedAddressPairs;
    @JsonProperty("portSecurity")
    private Boolean portSecurity;
    @JsonProperty("portTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> portTags = new ArrayList<java.lang.String>();
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> profile = new LinkedHashMap<String, String>();
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubnetParam> subnets = new ArrayList<SubnetParam>();
    @JsonProperty("uuid")
    private java.lang.String uuid;
    @JsonProperty("vnicType")
    private java.lang.String vnicType;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkParam() {
    }

    public NetworkParam(Filter filter, java.lang.String fixedIp, Boolean noAllowedAddressPairs, Boolean portSecurity, List<java.lang.String> portTags, Map<String, String> profile, List<SubnetParam> subnets, java.lang.String uuid, java.lang.String vnicType) {
        super();
        this.filter = filter;
        this.fixedIp = fixedIp;
        this.noAllowedAddressPairs = noAllowedAddressPairs;
        this.portSecurity = portSecurity;
        this.portTags = portTags;
        this.profile = profile;
        this.subnets = subnets;
        this.uuid = uuid;
        this.vnicType = vnicType;
    }

    @JsonProperty("filter")
    public Filter getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @JsonProperty("fixedIp")
    public java.lang.String getFixedIp() {
        return fixedIp;
    }

    @JsonProperty("fixedIp")
    public void setFixedIp(java.lang.String fixedIp) {
        this.fixedIp = fixedIp;
    }

    @JsonProperty("noAllowedAddressPairs")
    public Boolean getNoAllowedAddressPairs() {
        return noAllowedAddressPairs;
    }

    @JsonProperty("noAllowedAddressPairs")
    public void setNoAllowedAddressPairs(Boolean noAllowedAddressPairs) {
        this.noAllowedAddressPairs = noAllowedAddressPairs;
    }

    @JsonProperty("portSecurity")
    public Boolean getPortSecurity() {
        return portSecurity;
    }

    @JsonProperty("portSecurity")
    public void setPortSecurity(Boolean portSecurity) {
        this.portSecurity = portSecurity;
    }

    @JsonProperty("portTags")
    public List<java.lang.String> getPortTags() {
        return portTags;
    }

    @JsonProperty("portTags")
    public void setPortTags(List<java.lang.String> portTags) {
        this.portTags = portTags;
    }

    @JsonProperty("profile")
    public Map<String, String> getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Map<String, String> profile) {
        this.profile = profile;
    }

    @JsonProperty("subnets")
    public List<SubnetParam> getSubnets() {
        return subnets;
    }

    @JsonProperty("subnets")
    public void setSubnets(List<SubnetParam> subnets) {
        this.subnets = subnets;
    }

    @JsonProperty("uuid")
    public java.lang.String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("vnicType")
    public java.lang.String getVnicType() {
        return vnicType;
    }

    @JsonProperty("vnicType")
    public void setVnicType(java.lang.String vnicType) {
        this.vnicType = vnicType;
    }

    @JsonIgnore
    public NetworkParamBuilder edit() {
        return new NetworkParamBuilder(this);
    }

    @JsonIgnore
    public NetworkParamBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
