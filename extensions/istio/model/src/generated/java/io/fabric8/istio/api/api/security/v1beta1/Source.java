
package io.fabric8.istio.api.api.security.v1beta1;

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
 * Source specifies the source identities of a request. Fields in the source are ANDed together.<br><p> <br><p> For example, the following source matches if the principal is `admin` or `dev` and the namespace is `prod` or `test` and the ip is not `203.0.113.4`.<br><p> <br><p> ```yaml principals: ["admin", "dev"] namespaces: ["prod", "test"] notIpBlocks: ["203.0.113.4"] ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipBlocks",
    "namespaces",
    "notIpBlocks",
    "notNamespaces",
    "notPrincipals",
    "notRemoteIpBlocks",
    "notRequestPrincipals",
    "notServiceAccounts",
    "notTrustDomains",
    "principals",
    "remoteIpBlocks",
    "requestPrincipals",
    "serviceAccounts",
    "trustDomains"
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
public class Source implements Editable<SourceBuilder>, KubernetesResource
{

    @JsonProperty("ipBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipBlocks = new ArrayList<>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<>();
    @JsonProperty("notIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notIpBlocks = new ArrayList<>();
    @JsonProperty("notNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notNamespaces = new ArrayList<>();
    @JsonProperty("notPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notPrincipals = new ArrayList<>();
    @JsonProperty("notRemoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notRemoteIpBlocks = new ArrayList<>();
    @JsonProperty("notRequestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notRequestPrincipals = new ArrayList<>();
    @JsonProperty("notServiceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notServiceAccounts = new ArrayList<>();
    @JsonProperty("notTrustDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notTrustDomains = new ArrayList<>();
    @JsonProperty("principals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> principals = new ArrayList<>();
    @JsonProperty("remoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> remoteIpBlocks = new ArrayList<>();
    @JsonProperty("requestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requestPrincipals = new ArrayList<>();
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceAccounts = new ArrayList<>();
    @JsonProperty("trustDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> trustDomains = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Source() {
    }

    public Source(List<String> ipBlocks, List<String> namespaces, List<String> notIpBlocks, List<String> notNamespaces, List<String> notPrincipals, List<String> notRemoteIpBlocks, List<String> notRequestPrincipals, List<String> notServiceAccounts, List<String> notTrustDomains, List<String> principals, List<String> remoteIpBlocks, List<String> requestPrincipals, List<String> serviceAccounts, List<String> trustDomains) {
        super();
        this.ipBlocks = ipBlocks;
        this.namespaces = namespaces;
        this.notIpBlocks = notIpBlocks;
        this.notNamespaces = notNamespaces;
        this.notPrincipals = notPrincipals;
        this.notRemoteIpBlocks = notRemoteIpBlocks;
        this.notRequestPrincipals = notRequestPrincipals;
        this.notServiceAccounts = notServiceAccounts;
        this.notTrustDomains = notTrustDomains;
        this.principals = principals;
        this.remoteIpBlocks = remoteIpBlocks;
        this.requestPrincipals = requestPrincipals;
        this.serviceAccounts = serviceAccounts;
        this.trustDomains = trustDomains;
    }

    /**
     * Optional. A list of IP blocks, populated from the source address of the IP packet. Single IP (e.g. `203.0.113.4`) and CIDR (e.g. `203.0.113.0/24`) are supported. This is the same as the `source.ip` attribute.<br><p> <br><p> If not set, any IP is allowed.
     */
    @JsonProperty("ipBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpBlocks() {
        return ipBlocks;
    }

    /**
     * Optional. A list of IP blocks, populated from the source address of the IP packet. Single IP (e.g. `203.0.113.4`) and CIDR (e.g. `203.0.113.0/24`) are supported. This is the same as the `source.ip` attribute.<br><p> <br><p> If not set, any IP is allowed.
     */
    @JsonProperty("ipBlocks")
    public void setIpBlocks(List<String> ipBlocks) {
        this.ipBlocks = ipBlocks;
    }

    /**
     * Optional. A list of namespaces derived from the peer certificate. This field requires mTLS enabled and is the same as the `source.namespace` attribute.<br><p> <br><p> If not set, any namespace is allowed.
     */
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    /**
     * Optional. A list of namespaces derived from the peer certificate. This field requires mTLS enabled and is the same as the `source.namespace` attribute.<br><p> <br><p> If not set, any namespace is allowed.
     */
    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    /**
     * Optional. A list of negative match of IP blocks.
     */
    @JsonProperty("notIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotIpBlocks() {
        return notIpBlocks;
    }

    /**
     * Optional. A list of negative match of IP blocks.
     */
    @JsonProperty("notIpBlocks")
    public void setNotIpBlocks(List<String> notIpBlocks) {
        this.notIpBlocks = notIpBlocks;
    }

    /**
     * Optional. A list of negative match of namespaces.
     */
    @JsonProperty("notNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotNamespaces() {
        return notNamespaces;
    }

    /**
     * Optional. A list of negative match of namespaces.
     */
    @JsonProperty("notNamespaces")
    public void setNotNamespaces(List<String> notNamespaces) {
        this.notNamespaces = notNamespaces;
    }

    /**
     * Optional. A list of negative match of peer identities.
     */
    @JsonProperty("notPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotPrincipals() {
        return notPrincipals;
    }

    /**
     * Optional. A list of negative match of peer identities.
     */
    @JsonProperty("notPrincipals")
    public void setNotPrincipals(List<String> notPrincipals) {
        this.notPrincipals = notPrincipals;
    }

    /**
     * Optional. A list of negative match of remote IP blocks.
     */
    @JsonProperty("notRemoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotRemoteIpBlocks() {
        return notRemoteIpBlocks;
    }

    /**
     * Optional. A list of negative match of remote IP blocks.
     */
    @JsonProperty("notRemoteIpBlocks")
    public void setNotRemoteIpBlocks(List<String> notRemoteIpBlocks) {
        this.notRemoteIpBlocks = notRemoteIpBlocks;
    }

    /**
     * Optional. A list of negative match of request identities.
     */
    @JsonProperty("notRequestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotRequestPrincipals() {
        return notRequestPrincipals;
    }

    /**
     * Optional. A list of negative match of request identities.
     */
    @JsonProperty("notRequestPrincipals")
    public void setNotRequestPrincipals(List<String> notRequestPrincipals) {
        this.notRequestPrincipals = notRequestPrincipals;
    }

    /**
     * Optional. A list of negative match of Kubernetes service accounts.<br><p> <br><p> This takes the format `&lt;namespace&gt;/&lt;serviceaccount&gt;`. `&lt;serviceaccount&gt;` may also be used to use the same namespace as the `AuthorizationPolicy`.<br><p> <br><p> No form of wildcard (`&#42;`) is allowed.
     */
    @JsonProperty("notServiceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotServiceAccounts() {
        return notServiceAccounts;
    }

    /**
     * Optional. A list of negative match of Kubernetes service accounts.<br><p> <br><p> This takes the format `&lt;namespace&gt;/&lt;serviceaccount&gt;`. `&lt;serviceaccount&gt;` may also be used to use the same namespace as the `AuthorizationPolicy`.<br><p> <br><p> No form of wildcard (`&#42;`) is allowed.
     */
    @JsonProperty("notServiceAccounts")
    public void setNotServiceAccounts(List<String> notServiceAccounts) {
        this.notServiceAccounts = notServiceAccounts;
    }

    /**
     * Optional. A list of negative match of trust domains. Can be exact, prefix, suffix and presence.
     */
    @JsonProperty("notTrustDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotTrustDomains() {
        return notTrustDomains;
    }

    /**
     * Optional. A list of negative match of trust domains. Can be exact, prefix, suffix and presence.
     */
    @JsonProperty("notTrustDomains")
    public void setNotTrustDomains(List<String> notTrustDomains) {
        this.notTrustDomains = notTrustDomains;
    }

    /**
     * Optional. A list of peer identities derived from the peer certificate. The peer identity is in the format of `"&lt;TRUST_DOMAIN&gt;/ns/&lt;NAMESPACE&gt;/sa/&lt;SERVICE_ACCOUNT&gt;"`, for example, `"cluster.local/ns/default/sa/productpage"`. This field requires mTLS enabled and is the same as the `source.principal` attribute.<br><p> <br><p> Usage of `serviceAccounts` is typically simpler and offers the same functionality.<br><p> <br><p> If not set, any principal is allowed.
     */
    @JsonProperty("principals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPrincipals() {
        return principals;
    }

    /**
     * Optional. A list of peer identities derived from the peer certificate. The peer identity is in the format of `"&lt;TRUST_DOMAIN&gt;/ns/&lt;NAMESPACE&gt;/sa/&lt;SERVICE_ACCOUNT&gt;"`, for example, `"cluster.local/ns/default/sa/productpage"`. This field requires mTLS enabled and is the same as the `source.principal` attribute.<br><p> <br><p> Usage of `serviceAccounts` is typically simpler and offers the same functionality.<br><p> <br><p> If not set, any principal is allowed.
     */
    @JsonProperty("principals")
    public void setPrincipals(List<String> principals) {
        this.principals = principals;
    }

    /**
     * Optional. A list of IP blocks, populated from `X-Forwarded-For` header or proxy protocol. To make use of this field, you must configure the `numTrustedProxies` field of the `gatewayTopology` under the `meshConfig` when you install Istio or using an annotation on the ingress gateway.  See the documentation here: [Configuring Gateway Network Topology](https://istio.io/latest/docs/ops/configuration/traffic-management/network-topologies/). Single IP (e.g. `203.0.113.4`) and CIDR (e.g. `203.0.113.0/24`) are supported. This is the same as the `remote.ip` attribute.<br><p> <br><p> If not set, any IP is allowed.
     */
    @JsonProperty("remoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemoteIpBlocks() {
        return remoteIpBlocks;
    }

    /**
     * Optional. A list of IP blocks, populated from `X-Forwarded-For` header or proxy protocol. To make use of this field, you must configure the `numTrustedProxies` field of the `gatewayTopology` under the `meshConfig` when you install Istio or using an annotation on the ingress gateway.  See the documentation here: [Configuring Gateway Network Topology](https://istio.io/latest/docs/ops/configuration/traffic-management/network-topologies/). Single IP (e.g. `203.0.113.4`) and CIDR (e.g. `203.0.113.0/24`) are supported. This is the same as the `remote.ip` attribute.<br><p> <br><p> If not set, any IP is allowed.
     */
    @JsonProperty("remoteIpBlocks")
    public void setRemoteIpBlocks(List<String> remoteIpBlocks) {
        this.remoteIpBlocks = remoteIpBlocks;
    }

    /**
     * Optional. A list of request identities derived from the JWT. The request identity is in the format of `"&lt;ISS&gt;/&lt;SUB&gt;"`, for example, `"example.com/sub-1"`. This field requires request authentication enabled and is the same as the `request.auth.principal` attribute.<br><p> <br><p> If not set, any request principal is allowed.
     */
    @JsonProperty("requestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequestPrincipals() {
        return requestPrincipals;
    }

    /**
     * Optional. A list of request identities derived from the JWT. The request identity is in the format of `"&lt;ISS&gt;/&lt;SUB&gt;"`, for example, `"example.com/sub-1"`. This field requires request authentication enabled and is the same as the `request.auth.principal` attribute.<br><p> <br><p> If not set, any request principal is allowed.
     */
    @JsonProperty("requestPrincipals")
    public void setRequestPrincipals(List<String> requestPrincipals) {
        this.requestPrincipals = requestPrincipals;
    }

    /**
     * Optional. A list of Kubernetes service accounts derived from the peer certificate. This field requires mTLS enabled and is the same as the `source.serviceaccount` attribute.<br><p> <br><p> This takes the format `&lt;namespace&gt;/&lt;serviceaccount&gt;`. `&lt;serviceaccount&gt;` may also be used to use the same namespace as the `AuthorizationPolicy`.<br><p> <br><p> If not set, any service account is allowed.<br><p> <br><p> No form of wildcard (`&#42;`) is allowed. Cannot be set with `principals` or `namespaces`.
     */
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceAccounts() {
        return serviceAccounts;
    }

    /**
     * Optional. A list of Kubernetes service accounts derived from the peer certificate. This field requires mTLS enabled and is the same as the `source.serviceaccount` attribute.<br><p> <br><p> This takes the format `&lt;namespace&gt;/&lt;serviceaccount&gt;`. `&lt;serviceaccount&gt;` may also be used to use the same namespace as the `AuthorizationPolicy`.<br><p> <br><p> If not set, any service account is allowed.<br><p> <br><p> No form of wildcard (`&#42;`) is allowed. Cannot be set with `principals` or `namespaces`.
     */
    @JsonProperty("serviceAccounts")
    public void setServiceAccounts(List<String> serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
    }

    /**
     * Optional. A list of trust domains derived from the peer certificate. Can be exact, prefix, suffix and presence. This field requires mTLS enabled and is the same as the `source.trustDomain` attribute.<br><p> <br><p> If not set, any trust domain is allowed.
     */
    @JsonProperty("trustDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTrustDomains() {
        return trustDomains;
    }

    /**
     * Optional. A list of trust domains derived from the peer certificate. Can be exact, prefix, suffix and presence. This field requires mTLS enabled and is the same as the `source.trustDomain` attribute.<br><p> <br><p> If not set, any trust domain is allowed.
     */
    @JsonProperty("trustDomains")
    public void setTrustDomains(List<String> trustDomains) {
        this.trustDomains = trustDomains;
    }

    @JsonIgnore
    public SourceBuilder edit() {
        return new SourceBuilder(this);
    }

    @JsonIgnore
    public SourceBuilder toBuilder() {
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
        if (!(o instanceof Source)) {
            return false;
        }
        Source other = (Source) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ipBlocks = this.getIpBlocks();
        Object other$ipBlocks = other.getIpBlocks();
        if (this$ipBlocks == null ? other$ipBlocks != null : !this$ipBlocks.equals(other$ipBlocks)) {
            return false;
        }
        Object this$namespaces = this.getNamespaces();
        Object other$namespaces = other.getNamespaces();
        if (this$namespaces == null ? other$namespaces != null : !this$namespaces.equals(other$namespaces)) {
            return false;
        }
        Object this$notIpBlocks = this.getNotIpBlocks();
        Object other$notIpBlocks = other.getNotIpBlocks();
        if (this$notIpBlocks == null ? other$notIpBlocks != null : !this$notIpBlocks.equals(other$notIpBlocks)) {
            return false;
        }
        Object this$notNamespaces = this.getNotNamespaces();
        Object other$notNamespaces = other.getNotNamespaces();
        if (this$notNamespaces == null ? other$notNamespaces != null : !this$notNamespaces.equals(other$notNamespaces)) {
            return false;
        }
        Object this$notPrincipals = this.getNotPrincipals();
        Object other$notPrincipals = other.getNotPrincipals();
        if (this$notPrincipals == null ? other$notPrincipals != null : !this$notPrincipals.equals(other$notPrincipals)) {
            return false;
        }
        Object this$notRemoteIpBlocks = this.getNotRemoteIpBlocks();
        Object other$notRemoteIpBlocks = other.getNotRemoteIpBlocks();
        if (this$notRemoteIpBlocks == null ? other$notRemoteIpBlocks != null : !this$notRemoteIpBlocks.equals(other$notRemoteIpBlocks)) {
            return false;
        }
        Object this$notRequestPrincipals = this.getNotRequestPrincipals();
        Object other$notRequestPrincipals = other.getNotRequestPrincipals();
        if (this$notRequestPrincipals == null ? other$notRequestPrincipals != null : !this$notRequestPrincipals.equals(other$notRequestPrincipals)) {
            return false;
        }
        Object this$notServiceAccounts = this.getNotServiceAccounts();
        Object other$notServiceAccounts = other.getNotServiceAccounts();
        if (this$notServiceAccounts == null ? other$notServiceAccounts != null : !this$notServiceAccounts.equals(other$notServiceAccounts)) {
            return false;
        }
        Object this$notTrustDomains = this.getNotTrustDomains();
        Object other$notTrustDomains = other.getNotTrustDomains();
        if (this$notTrustDomains == null ? other$notTrustDomains != null : !this$notTrustDomains.equals(other$notTrustDomains)) {
            return false;
        }
        Object this$principals = this.getPrincipals();
        Object other$principals = other.getPrincipals();
        if (this$principals == null ? other$principals != null : !this$principals.equals(other$principals)) {
            return false;
        }
        Object this$remoteIpBlocks = this.getRemoteIpBlocks();
        Object other$remoteIpBlocks = other.getRemoteIpBlocks();
        if (this$remoteIpBlocks == null ? other$remoteIpBlocks != null : !this$remoteIpBlocks.equals(other$remoteIpBlocks)) {
            return false;
        }
        Object this$requestPrincipals = this.getRequestPrincipals();
        Object other$requestPrincipals = other.getRequestPrincipals();
        if (this$requestPrincipals == null ? other$requestPrincipals != null : !this$requestPrincipals.equals(other$requestPrincipals)) {
            return false;
        }
        Object this$serviceAccounts = this.getServiceAccounts();
        Object other$serviceAccounts = other.getServiceAccounts();
        if (this$serviceAccounts == null ? other$serviceAccounts != null : !this$serviceAccounts.equals(other$serviceAccounts)) {
            return false;
        }
        Object this$trustDomains = this.getTrustDomains();
        Object other$trustDomains = other.getTrustDomains();
        if (this$trustDomains == null ? other$trustDomains != null : !this$trustDomains.equals(other$trustDomains)) {
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
        return other instanceof Source;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ipBlocks = this.getIpBlocks();
        result = result * prime + ($ipBlocks == null ? 43 : $ipBlocks.hashCode());
        Object $namespaces = this.getNamespaces();
        result = result * prime + ($namespaces == null ? 43 : $namespaces.hashCode());
        Object $notIpBlocks = this.getNotIpBlocks();
        result = result * prime + ($notIpBlocks == null ? 43 : $notIpBlocks.hashCode());
        Object $notNamespaces = this.getNotNamespaces();
        result = result * prime + ($notNamespaces == null ? 43 : $notNamespaces.hashCode());
        Object $notPrincipals = this.getNotPrincipals();
        result = result * prime + ($notPrincipals == null ? 43 : $notPrincipals.hashCode());
        Object $notRemoteIpBlocks = this.getNotRemoteIpBlocks();
        result = result * prime + ($notRemoteIpBlocks == null ? 43 : $notRemoteIpBlocks.hashCode());
        Object $notRequestPrincipals = this.getNotRequestPrincipals();
        result = result * prime + ($notRequestPrincipals == null ? 43 : $notRequestPrincipals.hashCode());
        Object $notServiceAccounts = this.getNotServiceAccounts();
        result = result * prime + ($notServiceAccounts == null ? 43 : $notServiceAccounts.hashCode());
        Object $notTrustDomains = this.getNotTrustDomains();
        result = result * prime + ($notTrustDomains == null ? 43 : $notTrustDomains.hashCode());
        Object $principals = this.getPrincipals();
        result = result * prime + ($principals == null ? 43 : $principals.hashCode());
        Object $remoteIpBlocks = this.getRemoteIpBlocks();
        result = result * prime + ($remoteIpBlocks == null ? 43 : $remoteIpBlocks.hashCode());
        Object $requestPrincipals = this.getRequestPrincipals();
        result = result * prime + ($requestPrincipals == null ? 43 : $requestPrincipals.hashCode());
        Object $serviceAccounts = this.getServiceAccounts();
        result = result * prime + ($serviceAccounts == null ? 43 : $serviceAccounts.hashCode());
        Object $trustDomains = this.getTrustDomains();
        result = result * prime + ($trustDomains == null ? 43 : $trustDomains.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Source(" + "ipBlocks=" + this.getIpBlocks() + ", namespaces=" + this.getNamespaces() + ", notIpBlocks=" + this.getNotIpBlocks() + ", notNamespaces=" + this.getNotNamespaces() + ", notPrincipals=" + this.getNotPrincipals() + ", notRemoteIpBlocks=" + this.getNotRemoteIpBlocks() + ", notRequestPrincipals=" + this.getNotRequestPrincipals() + ", notServiceAccounts=" + this.getNotServiceAccounts() + ", notTrustDomains=" + this.getNotTrustDomains() + ", principals=" + this.getPrincipals() + ", remoteIpBlocks=" + this.getRemoteIpBlocks() + ", requestPrincipals=" + this.getRequestPrincipals() + ", serviceAccounts=" + this.getServiceAccounts() + ", trustDomains=" + this.getTrustDomains() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
