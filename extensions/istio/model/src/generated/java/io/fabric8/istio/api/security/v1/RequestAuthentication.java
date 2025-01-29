
package io.fabric8.istio.api.security.v1;

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
import io.fabric8.istio.api.api.meta.v1alpha1.IstioStatus;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("security.istio.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RequestAuthentication implements Editable<RequestAuthenticationBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "security.istio.io/v1";
    @JsonProperty("kind")
    private String kind = "RequestAuthentication";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private io.fabric8.istio.api.api.security.v1beta1.RequestAuthentication spec;
    @JsonProperty("status")
    private IstioStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RequestAuthentication() {
    }

    public RequestAuthentication(String apiVersion, String kind, ObjectMeta metadata, io.fabric8.istio.api.api.security.v1beta1.RequestAuthentication spec, IstioStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("spec")
    public io.fabric8.istio.api.api.security.v1beta1.RequestAuthentication getSpec() {
        return spec;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("spec")
    public void setSpec(io.fabric8.istio.api.api.security.v1beta1.RequestAuthentication spec) {
        this.spec = spec;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("status")
    public IstioStatus getStatus() {
        return status;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("status")
    public void setStatus(IstioStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public RequestAuthenticationBuilder edit() {
        return new RequestAuthenticationBuilder(this);
    }

    @JsonIgnore
    public RequestAuthenticationBuilder toBuilder() {
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
