
package io.fabric8.openshift.api.model.machine.v1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "gcp",
    "nutanix",
    "openstack",
    "platform",
    "vsphere"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ControlPlaneMachineSetSpecTMFailureDomains implements Editable<ControlPlaneMachineSetSpecTMFailureDomainsBuilder> , KubernetesResource
{

    @JsonProperty("aws")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMFDAws> aws = new ArrayList<>();
    @JsonProperty("azure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMFDAzure> azure = new ArrayList<>();
    @JsonProperty("gcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMFDGcp> gcp = new ArrayList<>();
    @JsonProperty("nutanix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMFDNutanix> nutanix = new ArrayList<>();
    @JsonProperty("openstack")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMFDOpenstack> openstack = new ArrayList<>();
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("vsphere")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ControlPlaneMachineSetSpecTMFDVsphere> vsphere = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ControlPlaneMachineSetSpecTMFailureDomains() {
    }

    public ControlPlaneMachineSetSpecTMFailureDomains(List<ControlPlaneMachineSetSpecTMFDAws> aws, List<ControlPlaneMachineSetSpecTMFDAzure> azure, List<ControlPlaneMachineSetSpecTMFDGcp> gcp, List<ControlPlaneMachineSetSpecTMFDNutanix> nutanix, List<ControlPlaneMachineSetSpecTMFDOpenstack> openstack, String platform, List<ControlPlaneMachineSetSpecTMFDVsphere> vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.gcp = gcp;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.platform = platform;
        this.vsphere = vsphere;
    }

    @JsonProperty("aws")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMFDAws> getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(List<ControlPlaneMachineSetSpecTMFDAws> aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMFDAzure> getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(List<ControlPlaneMachineSetSpecTMFDAzure> azure) {
        this.azure = azure;
    }

    @JsonProperty("gcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMFDGcp> getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(List<ControlPlaneMachineSetSpecTMFDGcp> gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("nutanix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMFDNutanix> getNutanix() {
        return nutanix;
    }

    @JsonProperty("nutanix")
    public void setNutanix(List<ControlPlaneMachineSetSpecTMFDNutanix> nutanix) {
        this.nutanix = nutanix;
    }

    @JsonProperty("openstack")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMFDOpenstack> getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(List<ControlPlaneMachineSetSpecTMFDOpenstack> openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("vsphere")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ControlPlaneMachineSetSpecTMFDVsphere> getVsphere() {
        return vsphere;
    }

    @JsonProperty("vsphere")
    public void setVsphere(List<ControlPlaneMachineSetSpecTMFDVsphere> vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecTMFailureDomainsBuilder edit() {
        return new ControlPlaneMachineSetSpecTMFailureDomainsBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecTMFailureDomainsBuilder toBuilder() {
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
