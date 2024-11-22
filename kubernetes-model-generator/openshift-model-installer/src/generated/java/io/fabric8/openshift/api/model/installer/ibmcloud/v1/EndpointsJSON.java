
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import java.util.LinkedHashMap;
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
    "IBMCLOUD_CIS_API_ENDPOINT",
    "IBMCLOUD_COS_CONFIG_ENDPOINT",
    "IBMCLOUD_GS_API_ENDPOINT",
    "IBMCLOUD_GT_API_ENDPOINT",
    "IBMCLOUD_HPCS_API_ENDPOINT",
    "IBMCLOUD_IAM_API_ENDPOINT",
    "IBMCLOUD_IS_NG_API_ENDPOINT",
    "IBMCLOUD_KP_API_ENDPOINT",
    "IBMCLOUD_PRIVATE_DNS_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT"
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
public class EndpointsJSON implements Editable<EndpointsJSONBuilder> , KubernetesResource
{

    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_CIS_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_COS_CONFIG_ENDPOINT;
    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_GS_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_GT_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_HPCS_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_IAM_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_IS_NG_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_KP_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_PRIVATE_DNS_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT;
    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EndpointsJSON() {
    }

    public EndpointsJSON(EndpointsVisibility iBMCLOUD_CIS_API_ENDPOINT, EndpointsVisibility iBMCLOUD_COS_CONFIG_ENDPOINT, EndpointsVisibility iBMCLOUD_GS_API_ENDPOINT, EndpointsVisibility iBMCLOUD_GT_API_ENDPOINT, EndpointsVisibility iBMCLOUD_HPCS_API_ENDPOINT, EndpointsVisibility iBMCLOUD_IAM_API_ENDPOINT, EndpointsVisibility iBMCLOUD_IS_NG_API_ENDPOINT, EndpointsVisibility iBMCLOUD_KP_API_ENDPOINT, EndpointsVisibility iBMCLOUD_PRIVATE_DNS_API_ENDPOINT, EndpointsVisibility iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT, EndpointsVisibility iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT) {
        super();
        this.iBMCLOUD_CIS_API_ENDPOINT = iBMCLOUD_CIS_API_ENDPOINT;
        this.iBMCLOUD_COS_CONFIG_ENDPOINT = iBMCLOUD_COS_CONFIG_ENDPOINT;
        this.iBMCLOUD_GS_API_ENDPOINT = iBMCLOUD_GS_API_ENDPOINT;
        this.iBMCLOUD_GT_API_ENDPOINT = iBMCLOUD_GT_API_ENDPOINT;
        this.iBMCLOUD_HPCS_API_ENDPOINT = iBMCLOUD_HPCS_API_ENDPOINT;
        this.iBMCLOUD_IAM_API_ENDPOINT = iBMCLOUD_IAM_API_ENDPOINT;
        this.iBMCLOUD_IS_NG_API_ENDPOINT = iBMCLOUD_IS_NG_API_ENDPOINT;
        this.iBMCLOUD_KP_API_ENDPOINT = iBMCLOUD_KP_API_ENDPOINT;
        this.iBMCLOUD_PRIVATE_DNS_API_ENDPOINT = iBMCLOUD_PRIVATE_DNS_API_ENDPOINT;
        this.iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT = iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT;
        this.iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT = iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_CIS_API_ENDPOINT() {
        return iBMCLOUD_CIS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    public void setIBMCLOUD_CIS_API_ENDPOINT(EndpointsVisibility iBMCLOUD_CIS_API_ENDPOINT) {
        this.iBMCLOUD_CIS_API_ENDPOINT = iBMCLOUD_CIS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_COS_CONFIG_ENDPOINT() {
        return iBMCLOUD_COS_CONFIG_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    public void setIBMCLOUD_COS_CONFIG_ENDPOINT(EndpointsVisibility iBMCLOUD_COS_CONFIG_ENDPOINT) {
        this.iBMCLOUD_COS_CONFIG_ENDPOINT = iBMCLOUD_COS_CONFIG_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_GS_API_ENDPOINT() {
        return iBMCLOUD_GS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    public void setIBMCLOUD_GS_API_ENDPOINT(EndpointsVisibility iBMCLOUD_GS_API_ENDPOINT) {
        this.iBMCLOUD_GS_API_ENDPOINT = iBMCLOUD_GS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_GT_API_ENDPOINT() {
        return iBMCLOUD_GT_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    public void setIBMCLOUD_GT_API_ENDPOINT(EndpointsVisibility iBMCLOUD_GT_API_ENDPOINT) {
        this.iBMCLOUD_GT_API_ENDPOINT = iBMCLOUD_GT_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_HPCS_API_ENDPOINT() {
        return iBMCLOUD_HPCS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    public void setIBMCLOUD_HPCS_API_ENDPOINT(EndpointsVisibility iBMCLOUD_HPCS_API_ENDPOINT) {
        this.iBMCLOUD_HPCS_API_ENDPOINT = iBMCLOUD_HPCS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_IAM_API_ENDPOINT() {
        return iBMCLOUD_IAM_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    public void setIBMCLOUD_IAM_API_ENDPOINT(EndpointsVisibility iBMCLOUD_IAM_API_ENDPOINT) {
        this.iBMCLOUD_IAM_API_ENDPOINT = iBMCLOUD_IAM_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_IS_NG_API_ENDPOINT() {
        return iBMCLOUD_IS_NG_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    public void setIBMCLOUD_IS_NG_API_ENDPOINT(EndpointsVisibility iBMCLOUD_IS_NG_API_ENDPOINT) {
        this.iBMCLOUD_IS_NG_API_ENDPOINT = iBMCLOUD_IS_NG_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_KP_API_ENDPOINT() {
        return iBMCLOUD_KP_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    public void setIBMCLOUD_KP_API_ENDPOINT(EndpointsVisibility iBMCLOUD_KP_API_ENDPOINT) {
        this.iBMCLOUD_KP_API_ENDPOINT = iBMCLOUD_KP_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_PRIVATE_DNS_API_ENDPOINT() {
        return iBMCLOUD_PRIVATE_DNS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    public void setIBMCLOUD_PRIVATE_DNS_API_ENDPOINT(EndpointsVisibility iBMCLOUD_PRIVATE_DNS_API_ENDPOINT) {
        this.iBMCLOUD_PRIVATE_DNS_API_ENDPOINT = iBMCLOUD_PRIVATE_DNS_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT() {
        return iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    public void setIBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT(EndpointsVisibility iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT) {
        this.iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT = iBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT() {
        return iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    public void setIBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT(EndpointsVisibility iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT) {
        this.iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT = iBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT;
    }

    @JsonIgnore
    public EndpointsJSONBuilder edit() {
        return new EndpointsJSONBuilder(this);
    }

    @JsonIgnore
    public EndpointsJSONBuilder toBuilder() {
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
