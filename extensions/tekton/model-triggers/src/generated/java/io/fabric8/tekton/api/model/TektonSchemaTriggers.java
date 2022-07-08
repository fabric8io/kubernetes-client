
package io.fabric8.tekton.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.fabric8.tekton.triggers.internal.knative.pkg.apis.Condition;
import io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1.PodSpecable;
import io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1.WithPodSpec;
import io.fabric8.tekton.triggers.v1alpha1.BitbucketInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.CELInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.CELOverlay;
import io.fabric8.tekton.triggers.v1alpha1.ClientConfig;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptorList;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptorSpec;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptorStatus;
import io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBindingList;
import io.fabric8.tekton.triggers.v1alpha1.EventListener;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerConfig;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerList;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerSpec;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerStatus;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerTrigger;
import io.fabric8.tekton.triggers.v1alpha1.GitHubInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.GitLabInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.InterceptorParams;
import io.fabric8.tekton.triggers.v1alpha1.InterceptorRef;
import io.fabric8.tekton.triggers.v1alpha1.KubernetesResource;
import io.fabric8.tekton.triggers.v1alpha1.NamespaceSelector;
import io.fabric8.tekton.triggers.v1alpha1.Param;
import io.fabric8.tekton.triggers.v1alpha1.ParamSpec;
import io.fabric8.tekton.triggers.v1alpha1.PodTemplate;
import io.fabric8.tekton.triggers.v1alpha1.Resources;
import io.fabric8.tekton.triggers.v1alpha1.SecretRef;
import io.fabric8.tekton.triggers.v1alpha1.ServiceReference;
import io.fabric8.tekton.triggers.v1alpha1.Trigger;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBindingList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBindingSpec;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBindingStatus;
import io.fabric8.tekton.triggers.v1alpha1.TriggerInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.TriggerList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerSpec;
import io.fabric8.tekton.triggers.v1alpha1.TriggerSpecBinding;
import io.fabric8.tekton.triggers.v1alpha1.TriggerSpecTemplate;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplate;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplateList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplateSpec;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplateStatus;
import io.fabric8.tekton.triggers.v1alpha1.WebhookInterceptor;
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
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_BitbucketInterceptor",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELInterceptor",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELOverlay",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClientConfig",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptor",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorList",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorSpec",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorStatus",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBinding",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBindingList",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListener",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerConfig",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerList",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerSpec",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerStatus",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerTrigger",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitHubInterceptor",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitLabInterceptor",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorParams",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorRef",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_KubernetesResource",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_NamespaceSelector",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Param",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ParamSpec",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_PodTemplate",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Resources",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_SecretRef",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ServiceReference",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Trigger",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBinding",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingList",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingSpec",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingStatus",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerInterceptor",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerList",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpec",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecBinding",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecTemplate",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplate",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateList",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateSpec",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateStatus",
    "github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_WebhookInterceptor",
    "knative_dev_pkg_apis_Condition",
    "knative_dev_pkg_apis_duck_v1_Addressable",
    "knative_dev_pkg_apis_duck_v1_PodSpecable",
    "knative_dev_pkg_apis_duck_v1_WithPodSpec",
    "knative_dev_pkg_apis_duck_v1alpha1_Addressable"
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
public class TektonSchemaTriggers {

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_BitbucketInterceptor")
    private BitbucketInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELInterceptor")
    private CELInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELOverlay")
    private CELOverlay githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClientConfig")
    private ClientConfig githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptor")
    private ClusterInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorList")
    private ClusterInterceptorList githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorSpec")
    private ClusterInterceptorSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorStatus")
    private ClusterInterceptorStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBinding")
    private ClusterTriggerBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBindingList")
    private ClusterTriggerBindingList githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListener")
    private EventListener githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerConfig")
    private EventListenerConfig githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerList")
    private EventListenerList githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerSpec")
    private EventListenerSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerStatus")
    private EventListenerStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerTrigger")
    private EventListenerTrigger githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitHubInterceptor")
    private GitHubInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitLabInterceptor")
    private GitLabInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorParams")
    private InterceptorParams githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorRef")
    private InterceptorRef githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_KubernetesResource")
    private KubernetesResource githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_NamespaceSelector")
    private NamespaceSelector githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Param")
    private Param githubComTektoncdTriggersPkgApisTriggersV1alpha1Param;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ParamSpec")
    private ParamSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_PodTemplate")
    private PodTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Resources")
    private Resources githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_SecretRef")
    private SecretRef githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ServiceReference")
    private ServiceReference githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Trigger")
    private Trigger githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBinding")
    private TriggerBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingList")
    private TriggerBindingList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingSpec")
    private TriggerBindingSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingStatus")
    private TriggerBindingStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerInterceptor")
    private TriggerInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerList")
    private TriggerList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpec")
    private TriggerSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecBinding")
    private TriggerSpecBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecTemplate")
    private TriggerSpecTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplate")
    private TriggerTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateList")
    private TriggerTemplateList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateSpec")
    private TriggerTemplateSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateStatus")
    private TriggerTemplateStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus;
    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_WebhookInterceptor")
    private WebhookInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor;
    @JsonProperty("knative_dev_pkg_apis_Condition")
    private Condition knativeDevPkgApisCondition;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_Addressable")
    private io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1.Addressable knativeDevPkgApisDuckV1Addressable;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_PodSpecable")
    private PodSpecable knativeDevPkgApisDuckV1PodSpecable;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_WithPodSpec")
    private WithPodSpec knativeDevPkgApisDuckV1WithPodSpec;
    @JsonProperty("knative_dev_pkg_apis_duck_v1alpha1_Addressable")
    private io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1alpha1.Addressable knativeDevPkgApisDuckV1alpha1Addressable;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TektonSchemaTriggers() {
    }

    /**
     * 
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource
     * @param knativeDevPkgApisDuckV1PodSpecable
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams
     * @param knativeDevPkgApisDuckV1Addressable
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener
     * @param knativeDevPkgApisCondition
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec
     * @param knativeDevPkgApisDuckV1alpha1Addressable
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1Param
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor
     * @param knativeDevPkgApisDuckV1WithPodSpec
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec
     * @param githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference
     */
    public TektonSchemaTriggers(BitbucketInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor, CELInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor, CELOverlay githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay, ClientConfig githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig, ClusterInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor, ClusterInterceptorList githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList, ClusterInterceptorSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec, ClusterInterceptorStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus, ClusterTriggerBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding, ClusterTriggerBindingList githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList, EventListener githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener, EventListenerConfig githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig, EventListenerList githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList, EventListenerSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec, EventListenerStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus, EventListenerTrigger githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger, GitHubInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor, GitLabInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor, InterceptorParams githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams, InterceptorRef githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef, KubernetesResource githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource, NamespaceSelector githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector, Param githubComTektoncdTriggersPkgApisTriggersV1alpha1Param, ParamSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec, PodTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate, Resources githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources, SecretRef githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef, ServiceReference githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference, Trigger githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger, TriggerBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding, TriggerBindingList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList, TriggerBindingSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec, TriggerBindingStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus, TriggerInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor, TriggerList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList, TriggerSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec, TriggerSpecBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding, TriggerSpecTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate, TriggerTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate, TriggerTemplateList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList, TriggerTemplateSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec, TriggerTemplateStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus, WebhookInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor, Condition knativeDevPkgApisCondition, io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1.Addressable knativeDevPkgApisDuckV1Addressable, PodSpecable knativeDevPkgApisDuckV1PodSpecable, WithPodSpec knativeDevPkgApisDuckV1WithPodSpec, io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1alpha1.Addressable knativeDevPkgApisDuckV1alpha1Addressable) {
        super();
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay = githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams = githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef = githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource = githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector = githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1Param = githubComTektoncdTriggersPkgApisTriggersV1alpha1Param;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate = githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources = githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef = githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference = githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger = githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus;
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor;
        this.knativeDevPkgApisCondition = knativeDevPkgApisCondition;
        this.knativeDevPkgApisDuckV1Addressable = knativeDevPkgApisDuckV1Addressable;
        this.knativeDevPkgApisDuckV1PodSpecable = knativeDevPkgApisDuckV1PodSpecable;
        this.knativeDevPkgApisDuckV1WithPodSpec = knativeDevPkgApisDuckV1WithPodSpec;
        this.knativeDevPkgApisDuckV1alpha1Addressable = knativeDevPkgApisDuckV1alpha1Addressable;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_BitbucketInterceptor")
    public BitbucketInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_BitbucketInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor(BitbucketInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1BitbucketInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELInterceptor")
    public CELInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor(CELInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1CELInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELOverlay")
    public CELOverlay getGithubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_CELOverlay")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay(CELOverlay githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay = githubComTektoncdTriggersPkgApisTriggersV1alpha1CELOverlay;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClientConfig")
    public ClientConfig getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClientConfig")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig(ClientConfig githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClientConfig;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptor")
    public ClusterInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor(ClusterInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorList")
    public ClusterInterceptorList getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorList")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList(ClusterInterceptorList githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorSpec")
    public ClusterInterceptorSpec getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorSpec")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec(ClusterInterceptorSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorStatus")
    public ClusterInterceptorStatus getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterInterceptorStatus")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus(ClusterInterceptorStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterInterceptorStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBinding")
    public ClusterTriggerBinding getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBinding")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding(ClusterTriggerBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBinding;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBindingList")
    public ClusterTriggerBindingList getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ClusterTriggerBindingList")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList(ClusterTriggerBindingList githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList = githubComTektoncdTriggersPkgApisTriggersV1alpha1ClusterTriggerBindingList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListener")
    public EventListener getGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListener")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener(EventListener githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListener;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerConfig")
    public EventListenerConfig getGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerConfig")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig(EventListenerConfig githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerConfig;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerList")
    public EventListenerList getGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerList")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList(EventListenerList githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerSpec")
    public EventListenerSpec getGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerSpec")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec(EventListenerSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerStatus")
    public EventListenerStatus getGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerStatus")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus(EventListenerStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerTrigger")
    public EventListenerTrigger getGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_EventListenerTrigger")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger(EventListenerTrigger githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger = githubComTektoncdTriggersPkgApisTriggersV1alpha1EventListenerTrigger;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitHubInterceptor")
    public GitHubInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitHubInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor(GitHubInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1GitHubInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitLabInterceptor")
    public GitLabInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_GitLabInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor(GitLabInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1GitLabInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorParams")
    public InterceptorParams getGithubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorParams")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams(InterceptorParams githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams = githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorParams;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorRef")
    public InterceptorRef getGithubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_InterceptorRef")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef(InterceptorRef githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef = githubComTektoncdTriggersPkgApisTriggersV1alpha1InterceptorRef;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_KubernetesResource")
    public KubernetesResource getGithubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_KubernetesResource")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource(KubernetesResource githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource = githubComTektoncdTriggersPkgApisTriggersV1alpha1KubernetesResource;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_NamespaceSelector")
    public NamespaceSelector getGithubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_NamespaceSelector")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector(NamespaceSelector githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector = githubComTektoncdTriggersPkgApisTriggersV1alpha1NamespaceSelector;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Param")
    public Param getGithubComTektoncdTriggersPkgApisTriggersV1alpha1Param() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1Param;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Param")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1Param(Param githubComTektoncdTriggersPkgApisTriggersV1alpha1Param) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1Param = githubComTektoncdTriggersPkgApisTriggersV1alpha1Param;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ParamSpec")
    public ParamSpec getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ParamSpec")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec(ParamSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1ParamSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_PodTemplate")
    public PodTemplate getGithubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_PodTemplate")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate(PodTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate = githubComTektoncdTriggersPkgApisTriggersV1alpha1PodTemplate;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Resources")
    public Resources getGithubComTektoncdTriggersPkgApisTriggersV1alpha1Resources() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Resources")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1Resources(Resources githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources = githubComTektoncdTriggersPkgApisTriggersV1alpha1Resources;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_SecretRef")
    public SecretRef getGithubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_SecretRef")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef(SecretRef githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef = githubComTektoncdTriggersPkgApisTriggersV1alpha1SecretRef;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ServiceReference")
    public ServiceReference getGithubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_ServiceReference")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference(ServiceReference githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference = githubComTektoncdTriggersPkgApisTriggersV1alpha1ServiceReference;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Trigger")
    public Trigger getGithubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_Trigger")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger(Trigger githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger = githubComTektoncdTriggersPkgApisTriggersV1alpha1Trigger;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBinding")
    public TriggerBinding getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBinding")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding(TriggerBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBinding;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingList")
    public TriggerBindingList getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingList")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList(TriggerBindingList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingSpec")
    public TriggerBindingSpec getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingSpec")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec(TriggerBindingSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingStatus")
    public TriggerBindingStatus getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerBindingStatus")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus(TriggerBindingStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerBindingStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerInterceptor")
    public TriggerInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor(TriggerInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerList")
    public TriggerList getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerList")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList(TriggerList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpec")
    public TriggerSpec getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpec")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec(TriggerSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecBinding")
    public TriggerSpecBinding getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecBinding")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding(TriggerSpecBinding githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecBinding;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecTemplate")
    public TriggerSpecTemplate getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerSpecTemplate")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate(TriggerSpecTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerSpecTemplate;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplate")
    public TriggerTemplate getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplate")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate(TriggerTemplate githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplate;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateList")
    public TriggerTemplateList getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateList")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList(TriggerTemplateList githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateList;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateSpec")
    public TriggerTemplateSpec getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateSpec")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec(TriggerTemplateSpec githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateSpec;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateStatus")
    public TriggerTemplateStatus getGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_TriggerTemplateStatus")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus(TriggerTemplateStatus githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus = githubComTektoncdTriggersPkgApisTriggersV1alpha1TriggerTemplateStatus;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_WebhookInterceptor")
    public WebhookInterceptor getGithubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor() {
        return githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor;
    }

    @JsonProperty("github_com_tektoncd_triggers_pkg_apis_triggers_v1alpha1_WebhookInterceptor")
    public void setGithubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor(WebhookInterceptor githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor) {
        this.githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor = githubComTektoncdTriggersPkgApisTriggersV1alpha1WebhookInterceptor;
    }

    @JsonProperty("knative_dev_pkg_apis_Condition")
    public Condition getKnativeDevPkgApisCondition() {
        return knativeDevPkgApisCondition;
    }

    @JsonProperty("knative_dev_pkg_apis_Condition")
    public void setKnativeDevPkgApisCondition(Condition knativeDevPkgApisCondition) {
        this.knativeDevPkgApisCondition = knativeDevPkgApisCondition;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_Addressable")
    public io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1.Addressable getKnativeDevPkgApisDuckV1Addressable() {
        return knativeDevPkgApisDuckV1Addressable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_Addressable")
    public void setKnativeDevPkgApisDuckV1Addressable(io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1.Addressable knativeDevPkgApisDuckV1Addressable) {
        this.knativeDevPkgApisDuckV1Addressable = knativeDevPkgApisDuckV1Addressable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_PodSpecable")
    public PodSpecable getKnativeDevPkgApisDuckV1PodSpecable() {
        return knativeDevPkgApisDuckV1PodSpecable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_PodSpecable")
    public void setKnativeDevPkgApisDuckV1PodSpecable(PodSpecable knativeDevPkgApisDuckV1PodSpecable) {
        this.knativeDevPkgApisDuckV1PodSpecable = knativeDevPkgApisDuckV1PodSpecable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_WithPodSpec")
    public WithPodSpec getKnativeDevPkgApisDuckV1WithPodSpec() {
        return knativeDevPkgApisDuckV1WithPodSpec;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_WithPodSpec")
    public void setKnativeDevPkgApisDuckV1WithPodSpec(WithPodSpec knativeDevPkgApisDuckV1WithPodSpec) {
        this.knativeDevPkgApisDuckV1WithPodSpec = knativeDevPkgApisDuckV1WithPodSpec;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1alpha1_Addressable")
    public io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1alpha1.Addressable getKnativeDevPkgApisDuckV1alpha1Addressable() {
        return knativeDevPkgApisDuckV1alpha1Addressable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1alpha1_Addressable")
    public void setKnativeDevPkgApisDuckV1alpha1Addressable(io.fabric8.tekton.triggers.internal.knative.pkg.apis.duck.v1alpha1.Addressable knativeDevPkgApisDuckV1alpha1Addressable) {
        this.knativeDevPkgApisDuckV1alpha1Addressable = knativeDevPkgApisDuckV1alpha1Addressable;
    }

}
