
package io.fabric8.kubernetes.api.model.ovn;

import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRoute;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteList;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteSpec;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedRouteStatus;
import io.fabric8.kubernetes.api.model.ovn.v1.DynamicHop;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewall;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallDestination;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallPort;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallRule;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallSpec;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallStatus;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIP;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPSpec;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPStatus;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPStatusItem;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoS;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSRule;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSSpec;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSStatus;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressService;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceSpec;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceStatus;
import io.fabric8.kubernetes.api.model.ovn.v1.ExternalNetworkSource;
import io.fabric8.kubernetes.api.model.ovn.v1.ExternalNextHops;
import io.fabric8.kubernetes.api.model.ovn.v1.StaticHop;
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
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRoute",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteList",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteSpec",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedRouteStatus",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_DynamicHop",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNetworkSource",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNextHops",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_StaticHop",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewall",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallDestination",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallList",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallPort",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallRule",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallSpec",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallStatus",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIP",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPList",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPSpec",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatus",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatusItem",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoS",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSList",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSRule",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSSpec",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSStatus",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressService",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceList",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceSpec",
    "github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceStatus"
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
@Generated("jsonschema2pojo")
public class OpenVirtualNetworkingV1Schema implements Editable<OpenVirtualNetworkingV1SchemaBuilder>
{

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRoute")
    private AdminPolicyBasedExternalRoute githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteList")
    private AdminPolicyBasedExternalRouteList githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteSpec")
    private AdminPolicyBasedExternalRouteSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedRouteStatus")
    private AdminPolicyBasedRouteStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_DynamicHop")
    private DynamicHop githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNetworkSource")
    private ExternalNetworkSource githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNextHops")
    private ExternalNextHops githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_StaticHop")
    private StaticHop githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewall")
    private EgressFirewall githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallDestination")
    private EgressFirewallDestination githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallList")
    private EgressFirewallList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallPort")
    private EgressFirewallPort githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallRule")
    private EgressFirewallRule githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallSpec")
    private EgressFirewallSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallStatus")
    private EgressFirewallStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIP")
    private EgressIP githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPList")
    private EgressIPList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPSpec")
    private EgressIPSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatus")
    private EgressIPStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatusItem")
    private EgressIPStatusItem githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoS")
    private EgressQoS githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSList")
    private EgressQoSList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSRule")
    private EgressQoSRule githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSSpec")
    private EgressQoSSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSStatus")
    private EgressQoSStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressService")
    private EgressService githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceList")
    private EgressServiceList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceSpec")
    private EgressServiceSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec;
    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceStatus")
    private EgressServiceStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenVirtualNetworkingV1Schema() {
    }

    public OpenVirtualNetworkingV1Schema(AdminPolicyBasedExternalRoute githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute, AdminPolicyBasedExternalRouteList githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList, AdminPolicyBasedExternalRouteSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec, AdminPolicyBasedRouteStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus, DynamicHop githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop, ExternalNetworkSource githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource, ExternalNextHops githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops, StaticHop githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop, EgressFirewall githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall, EgressFirewallDestination githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination, EgressFirewallList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList, EgressFirewallPort githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort, EgressFirewallRule githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule, EgressFirewallSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec, EgressFirewallStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus, EgressIP githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP, EgressIPList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList, EgressIPSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec, EgressIPStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus, EgressIPStatusItem githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem, EgressQoS githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS, EgressQoSList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList, EgressQoSRule githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule, EgressQoSSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec, EgressQoSStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus, EgressService githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService, EgressServiceList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList, EgressServiceSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec, EgressServiceStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus) {
        super();
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec;
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRoute")
    public AdminPolicyBasedExternalRoute getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRoute")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute(AdminPolicyBasedExternalRoute githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRoute;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteList")
    public AdminPolicyBasedExternalRouteList getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteList")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList(AdminPolicyBasedExternalRouteList githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteSpec")
    public AdminPolicyBasedExternalRouteSpec getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedExternalRouteSpec")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec(AdminPolicyBasedExternalRouteSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedExternalRouteSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedRouteStatus")
    public AdminPolicyBasedRouteStatus getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_AdminPolicyBasedRouteStatus")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus(AdminPolicyBasedRouteStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1AdminPolicyBasedRouteStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_DynamicHop")
    public DynamicHop getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_DynamicHop")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop(DynamicHop githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1DynamicHop;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNetworkSource")
    public ExternalNetworkSource getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNetworkSource")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource(ExternalNetworkSource githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNetworkSource;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNextHops")
    public ExternalNextHops getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_ExternalNextHops")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops(ExternalNextHops githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1ExternalNextHops;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_StaticHop")
    public StaticHop getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_adminpolicybasedroute_v1_StaticHop")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop(StaticHop githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop = githubComOvnOrgOvnKubernetesGoControllerPkgCrdAdminpolicybasedrouteV1StaticHop;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewall")
    public EgressFirewall getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewall")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall(EgressFirewall githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewall;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallDestination")
    public EgressFirewallDestination getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallDestination")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination(EgressFirewallDestination githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallDestination;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallList")
    public EgressFirewallList getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallList")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList(EgressFirewallList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallPort")
    public EgressFirewallPort getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallPort")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort(EgressFirewallPort githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallPort;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallRule")
    public EgressFirewallRule getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallRule")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule(EgressFirewallRule githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallRule;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallSpec")
    public EgressFirewallSpec getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallSpec")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec(EgressFirewallSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallStatus")
    public EgressFirewallStatus getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressfirewall_v1_EgressFirewallStatus")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus(EgressFirewallStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressfirewallV1EgressFirewallStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIP")
    public EgressIP getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIP")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP(EgressIP githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIP;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPList")
    public EgressIPList getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPList")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList(EgressIPList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPSpec")
    public EgressIPSpec getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPSpec")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec(EgressIPSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatus")
    public EgressIPStatus getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatus")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus(EgressIPStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatusItem")
    public EgressIPStatusItem getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressip_v1_EgressIPStatusItem")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem(EgressIPStatusItem githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressipV1EgressIPStatusItem;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoS")
    public EgressQoS getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoS")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS(EgressQoS githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoS;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSList")
    public EgressQoSList getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSList")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList(EgressQoSList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSRule")
    public EgressQoSRule getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSRule")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule(EgressQoSRule githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSRule;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSSpec")
    public EgressQoSSpec getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSSpec")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec(EgressQoSSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSStatus")
    public EgressQoSStatus getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressqos_v1_EgressQoSStatus")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus(EgressQoSStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressqosV1EgressQoSStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressService")
    public EgressService getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressService")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService(EgressService githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressService;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceList")
    public EgressServiceList getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceList")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList(EgressServiceList githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceList;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceSpec")
    public EgressServiceSpec getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceSpec")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec(EgressServiceSpec githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceSpec;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceStatus")
    public EgressServiceStatus getGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus() {
        return githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus;
    }

    @JsonProperty("github_com_ovn-org_ovn-kubernetes_go-controller_pkg_crd_egressservice_v1_EgressServiceStatus")
    public void setGithubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus(EgressServiceStatus githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus) {
        this.githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus = githubComOvnOrgOvnKubernetesGoControllerPkgCrdEgressserviceV1EgressServiceStatus;
    }

    @JsonIgnore
    public OpenVirtualNetworkingV1SchemaBuilder edit() {
        return new OpenVirtualNetworkingV1SchemaBuilder(this);
    }

    @JsonIgnore
    public OpenVirtualNetworkingV1SchemaBuilder toBuilder() {
        return edit();
    }

}
