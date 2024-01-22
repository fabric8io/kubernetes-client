
package io.fabric8.kubernetes.api.model;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRoute;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewall;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIP;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoS;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressService;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceList;
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
    "V1AdminPolicyBasedExternalRoute",
    "V1AdminPolicyBasedExternalRouteList",
    "V1EgressFirewall",
    "V1EgressFirewallList",
    "V1EgressIP",
    "V1EgressIPList",
    "V1EgressQoS",
    "V1EgressQoSList",
    "V1EgressService",
    "V1EgressServiceList"
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
public class KubeSchema implements Editable<KubeSchemaBuilder>
{

    @JsonProperty("V1AdminPolicyBasedExternalRoute")
    private AdminPolicyBasedExternalRoute v1AdminPolicyBasedExternalRoute;
    @JsonProperty("V1AdminPolicyBasedExternalRouteList")
    private AdminPolicyBasedExternalRouteList v1AdminPolicyBasedExternalRouteList;
    @JsonProperty("V1EgressFirewall")
    private EgressFirewall v1EgressFirewall;
    @JsonProperty("V1EgressFirewallList")
    private EgressFirewallList v1EgressFirewallList;
    @JsonProperty("V1EgressIP")
    private EgressIP v1EgressIP;
    @JsonProperty("V1EgressIPList")
    private EgressIPList v1EgressIPList;
    @JsonProperty("V1EgressQoS")
    private EgressQoS v1EgressQoS;
    @JsonProperty("V1EgressQoSList")
    private EgressQoSList v1EgressQoSList;
    @JsonProperty("V1EgressService")
    private EgressService v1EgressService;
    @JsonProperty("V1EgressServiceList")
    private EgressServiceList v1EgressServiceList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(AdminPolicyBasedExternalRoute v1AdminPolicyBasedExternalRoute, AdminPolicyBasedExternalRouteList v1AdminPolicyBasedExternalRouteList, EgressFirewall v1EgressFirewall, EgressFirewallList v1EgressFirewallList, EgressIP v1EgressIP, EgressIPList v1EgressIPList, EgressQoS v1EgressQoS, EgressQoSList v1EgressQoSList, EgressService v1EgressService, EgressServiceList v1EgressServiceList) {
        super();
        this.v1AdminPolicyBasedExternalRoute = v1AdminPolicyBasedExternalRoute;
        this.v1AdminPolicyBasedExternalRouteList = v1AdminPolicyBasedExternalRouteList;
        this.v1EgressFirewall = v1EgressFirewall;
        this.v1EgressFirewallList = v1EgressFirewallList;
        this.v1EgressIP = v1EgressIP;
        this.v1EgressIPList = v1EgressIPList;
        this.v1EgressQoS = v1EgressQoS;
        this.v1EgressQoSList = v1EgressQoSList;
        this.v1EgressService = v1EgressService;
        this.v1EgressServiceList = v1EgressServiceList;
    }

    @JsonProperty("V1AdminPolicyBasedExternalRoute")
    public AdminPolicyBasedExternalRoute getV1AdminPolicyBasedExternalRoute() {
        return v1AdminPolicyBasedExternalRoute;
    }

    @JsonProperty("V1AdminPolicyBasedExternalRoute")
    public void setV1AdminPolicyBasedExternalRoute(AdminPolicyBasedExternalRoute v1AdminPolicyBasedExternalRoute) {
        this.v1AdminPolicyBasedExternalRoute = v1AdminPolicyBasedExternalRoute;
    }

    @JsonProperty("V1AdminPolicyBasedExternalRouteList")
    public AdminPolicyBasedExternalRouteList getV1AdminPolicyBasedExternalRouteList() {
        return v1AdminPolicyBasedExternalRouteList;
    }

    @JsonProperty("V1AdminPolicyBasedExternalRouteList")
    public void setV1AdminPolicyBasedExternalRouteList(AdminPolicyBasedExternalRouteList v1AdminPolicyBasedExternalRouteList) {
        this.v1AdminPolicyBasedExternalRouteList = v1AdminPolicyBasedExternalRouteList;
    }

    @JsonProperty("V1EgressFirewall")
    public EgressFirewall getV1EgressFirewall() {
        return v1EgressFirewall;
    }

    @JsonProperty("V1EgressFirewall")
    public void setV1EgressFirewall(EgressFirewall v1EgressFirewall) {
        this.v1EgressFirewall = v1EgressFirewall;
    }

    @JsonProperty("V1EgressFirewallList")
    public EgressFirewallList getV1EgressFirewallList() {
        return v1EgressFirewallList;
    }

    @JsonProperty("V1EgressFirewallList")
    public void setV1EgressFirewallList(EgressFirewallList v1EgressFirewallList) {
        this.v1EgressFirewallList = v1EgressFirewallList;
    }

    @JsonProperty("V1EgressIP")
    public EgressIP getV1EgressIP() {
        return v1EgressIP;
    }

    @JsonProperty("V1EgressIP")
    public void setV1EgressIP(EgressIP v1EgressIP) {
        this.v1EgressIP = v1EgressIP;
    }

    @JsonProperty("V1EgressIPList")
    public EgressIPList getV1EgressIPList() {
        return v1EgressIPList;
    }

    @JsonProperty("V1EgressIPList")
    public void setV1EgressIPList(EgressIPList v1EgressIPList) {
        this.v1EgressIPList = v1EgressIPList;
    }

    @JsonProperty("V1EgressQoS")
    public EgressQoS getV1EgressQoS() {
        return v1EgressQoS;
    }

    @JsonProperty("V1EgressQoS")
    public void setV1EgressQoS(EgressQoS v1EgressQoS) {
        this.v1EgressQoS = v1EgressQoS;
    }

    @JsonProperty("V1EgressQoSList")
    public EgressQoSList getV1EgressQoSList() {
        return v1EgressQoSList;
    }

    @JsonProperty("V1EgressQoSList")
    public void setV1EgressQoSList(EgressQoSList v1EgressQoSList) {
        this.v1EgressQoSList = v1EgressQoSList;
    }

    @JsonProperty("V1EgressService")
    public EgressService getV1EgressService() {
        return v1EgressService;
    }

    @JsonProperty("V1EgressService")
    public void setV1EgressService(EgressService v1EgressService) {
        this.v1EgressService = v1EgressService;
    }

    @JsonProperty("V1EgressServiceList")
    public EgressServiceList getV1EgressServiceList() {
        return v1EgressServiceList;
    }

    @JsonProperty("V1EgressServiceList")
    public void setV1EgressServiceList(EgressServiceList v1EgressServiceList) {
        this.v1EgressServiceList = v1EgressServiceList;
    }

    @JsonIgnore
    public KubeSchemaBuilder edit() {
        return new KubeSchemaBuilder(this);
    }

    @JsonIgnore
    public KubeSchemaBuilder toBuilder() {
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

}
