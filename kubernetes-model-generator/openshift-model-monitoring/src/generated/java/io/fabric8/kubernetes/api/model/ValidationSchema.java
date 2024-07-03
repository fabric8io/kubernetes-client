
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.monitoring.v1.Alertmanager;
import io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerList;
import io.fabric8.openshift.api.model.monitoring.v1.PodMonitor;
import io.fabric8.openshift.api.model.monitoring.v1.PodMonitorList;
import io.fabric8.openshift.api.model.monitoring.v1.Probe;
import io.fabric8.openshift.api.model.monitoring.v1.ProbeList;
import io.fabric8.openshift.api.model.monitoring.v1.Prometheus;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusList;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRule;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRuleList;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitor;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitorList;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRuler;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRulerList;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfig;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfigList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private Alertmanager alertmanager;
    private AlertmanagerConfig alertmanagerConfig;
    private AlertmanagerConfigList alertmanagerConfigList;
    private AlertmanagerList alertmanagerList;
    private KubernetesList baseKubernetesList;
    private Info info;
    private ObjectMeta objectMeta;
    private Patch patch;
    private PodMonitor podMonitor;
    private PodMonitorList podMonitorList;
    private Probe probe;
    private ProbeList probeList;
    private Prometheus prometheus;
    private PrometheusList prometheusList;
    private PrometheusRule prometheusRule;
    private PrometheusRuleList prometheusRuleList;
    private ServiceMonitor serviceMonitor;
    private ServiceMonitorList serviceMonitorList;
    private Status status;
    private ThanosRuler thanosRuler;
    private ThanosRulerList thanosRulerList;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, Alertmanager alertmanager, AlertmanagerConfig alertmanagerConfig, AlertmanagerConfigList alertmanagerConfigList, AlertmanagerList alertmanagerList, KubernetesList baseKubernetesList, Info info, ObjectMeta objectMeta, Patch patch, PodMonitor podMonitor, PodMonitorList podMonitorList, Probe probe, ProbeList probeList, Prometheus prometheus, PrometheusList prometheusList, PrometheusRule prometheusRule, PrometheusRuleList prometheusRuleList, ServiceMonitor serviceMonitor, ServiceMonitorList serviceMonitorList, Status status, ThanosRuler thanosRuler, ThanosRulerList thanosRulerList, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.alertmanager = alertmanager;
        this.alertmanagerConfig = alertmanagerConfig;
        this.alertmanagerConfigList = alertmanagerConfigList;
        this.alertmanagerList = alertmanagerList;
        this.baseKubernetesList = baseKubernetesList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.podMonitor = podMonitor;
        this.podMonitorList = podMonitorList;
        this.probe = probe;
        this.probeList = probeList;
        this.prometheus = prometheus;
        this.prometheusList = prometheusList;
        this.prometheusRule = prometheusRule;
        this.prometheusRuleList = prometheusRuleList;
        this.serviceMonitor = serviceMonitor;
        this.serviceMonitorList = serviceMonitorList;
        this.status = status;
        this.thanosRuler = thanosRuler;
        this.thanosRulerList = thanosRulerList;
        this.time = time;
        this.typeMeta = typeMeta;
    }

    @JsonProperty("APIGroup")
    public APIGroup getAPIGroup() {
        return aPIGroup;
    }

    @JsonProperty("APIGroup")
    public void setAPIGroup(APIGroup aPIGroup) {
        this.aPIGroup = aPIGroup;
    }

    @JsonProperty("APIGroupList")
    public APIGroupList getAPIGroupList() {
        return aPIGroupList;
    }

    @JsonProperty("APIGroupList")
    public void setAPIGroupList(APIGroupList aPIGroupList) {
        this.aPIGroupList = aPIGroupList;
    }

    @JsonProperty("Alertmanager")
    public Alertmanager getAlertmanager() {
        return alertmanager;
    }

    @JsonProperty("Alertmanager")
    public void setAlertmanager(Alertmanager alertmanager) {
        this.alertmanager = alertmanager;
    }

    @JsonProperty("AlertmanagerConfig")
    public AlertmanagerConfig getAlertmanagerConfig() {
        return alertmanagerConfig;
    }

    @JsonProperty("AlertmanagerConfig")
    public void setAlertmanagerConfig(AlertmanagerConfig alertmanagerConfig) {
        this.alertmanagerConfig = alertmanagerConfig;
    }

    @JsonProperty("AlertmanagerConfigList")
    public AlertmanagerConfigList getAlertmanagerConfigList() {
        return alertmanagerConfigList;
    }

    @JsonProperty("AlertmanagerConfigList")
    public void setAlertmanagerConfigList(AlertmanagerConfigList alertmanagerConfigList) {
        this.alertmanagerConfigList = alertmanagerConfigList;
    }

    @JsonProperty("AlertmanagerList")
    public AlertmanagerList getAlertmanagerList() {
        return alertmanagerList;
    }

    @JsonProperty("AlertmanagerList")
    public void setAlertmanagerList(AlertmanagerList alertmanagerList) {
        this.alertmanagerList = alertmanagerList;
    }

    @JsonProperty("BaseKubernetesList")
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("PodMonitor")
    public PodMonitor getPodMonitor() {
        return podMonitor;
    }

    @JsonProperty("PodMonitor")
    public void setPodMonitor(PodMonitor podMonitor) {
        this.podMonitor = podMonitor;
    }

    @JsonProperty("PodMonitorList")
    public PodMonitorList getPodMonitorList() {
        return podMonitorList;
    }

    @JsonProperty("PodMonitorList")
    public void setPodMonitorList(PodMonitorList podMonitorList) {
        this.podMonitorList = podMonitorList;
    }

    @JsonProperty("Probe")
    public Probe getProbe() {
        return probe;
    }

    @JsonProperty("Probe")
    public void setProbe(Probe probe) {
        this.probe = probe;
    }

    @JsonProperty("ProbeList")
    public ProbeList getProbeList() {
        return probeList;
    }

    @JsonProperty("ProbeList")
    public void setProbeList(ProbeList probeList) {
        this.probeList = probeList;
    }

    @JsonProperty("Prometheus")
    public Prometheus getPrometheus() {
        return prometheus;
    }

    @JsonProperty("Prometheus")
    public void setPrometheus(Prometheus prometheus) {
        this.prometheus = prometheus;
    }

    @JsonProperty("PrometheusList")
    public PrometheusList getPrometheusList() {
        return prometheusList;
    }

    @JsonProperty("PrometheusList")
    public void setPrometheusList(PrometheusList prometheusList) {
        this.prometheusList = prometheusList;
    }

    @JsonProperty("PrometheusRule")
    public PrometheusRule getPrometheusRule() {
        return prometheusRule;
    }

    @JsonProperty("PrometheusRule")
    public void setPrometheusRule(PrometheusRule prometheusRule) {
        this.prometheusRule = prometheusRule;
    }

    @JsonProperty("PrometheusRuleList")
    public PrometheusRuleList getPrometheusRuleList() {
        return prometheusRuleList;
    }

    @JsonProperty("PrometheusRuleList")
    public void setPrometheusRuleList(PrometheusRuleList prometheusRuleList) {
        this.prometheusRuleList = prometheusRuleList;
    }

    @JsonProperty("ServiceMonitor")
    public ServiceMonitor getServiceMonitor() {
        return serviceMonitor;
    }

    @JsonProperty("ServiceMonitor")
    public void setServiceMonitor(ServiceMonitor serviceMonitor) {
        this.serviceMonitor = serviceMonitor;
    }

    @JsonProperty("ServiceMonitorList")
    public ServiceMonitorList getServiceMonitorList() {
        return serviceMonitorList;
    }

    @JsonProperty("ServiceMonitorList")
    public void setServiceMonitorList(ServiceMonitorList serviceMonitorList) {
        this.serviceMonitorList = serviceMonitorList;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("ThanosRuler")
    public ThanosRuler getThanosRuler() {
        return thanosRuler;
    }

    @JsonProperty("ThanosRuler")
    public void setThanosRuler(ThanosRuler thanosRuler) {
        this.thanosRuler = thanosRuler;
    }

    @JsonProperty("ThanosRulerList")
    public ThanosRulerList getThanosRulerList() {
        return thanosRulerList;
    }

    @JsonProperty("ThanosRulerList")
    public void setThanosRulerList(ThanosRulerList thanosRulerList) {
        this.thanosRulerList = thanosRulerList;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<java.lang.String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
