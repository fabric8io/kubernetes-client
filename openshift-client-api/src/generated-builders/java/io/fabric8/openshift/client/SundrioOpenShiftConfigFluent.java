package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.ConfigFluent;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SundrioOpenShiftConfigFluent<A extends io.fabric8.openshift.client.SundrioOpenShiftConfigFluent<A>> extends ConfigFluent<A>{

  private Long buildTimeout;
  private Boolean disableApiGroupCheck;
  private String oapiVersion;
  private String openShiftUrl;

  public SundrioOpenShiftConfigFluent() {
  }
  
  public SundrioOpenShiftConfigFluent(SundrioOpenShiftConfig instance) {
    this.copyInstance(instance);
  }

  protected void copyInstance(SundrioOpenShiftConfig instance) {
    instance = instance != null ? instance : new SundrioOpenShiftConfig();
    if (instance != null) {
        this.withOapiVersion(instance.getOapiVersion());
        this.withOpenShiftUrl(instance.getOpenShiftUrl());
        this.withBuildTimeout(instance.getBuildTimeout());
        this.withDisableApiGroupCheck(instance.isDisableApiGroupCheck());
        this.withTrustCerts(instance.isTrustCerts());
        this.withDisableHostnameVerification(instance.isDisableHostnameVerification());
        this.withMasterUrl(instance.getMasterUrl());
        this.withApiVersion(instance.getApiVersion());
        this.withNamespace(instance.getNamespace());
        this.withDefaultNamespace(instance.isDefaultNamespace());
        this.withCaCertFile(instance.getCaCertFile());
        this.withCaCertData(instance.getCaCertData());
        this.withClientCertFile(instance.getClientCertFile());
        this.withClientCertData(instance.getClientCertData());
        this.withClientKeyFile(instance.getClientKeyFile());
        this.withClientKeyData(instance.getClientKeyData());
        this.withClientKeyAlgo(instance.getClientKeyAlgo());
        this.withClientKeyPassphrase(instance.getClientKeyPassphrase());
        this.withTrustStoreFile(instance.getTrustStoreFile());
        this.withTrustStorePassphrase(instance.getTrustStorePassphrase());
        this.withKeyStoreFile(instance.getKeyStoreFile());
        this.withKeyStorePassphrase(instance.getKeyStorePassphrase());
        this.withAuthProvider(instance.getAuthProvider());
        this.withUsername(instance.getUsername());
        this.withPassword(instance.getPassword());
        this.withOauthToken(instance.getOauthToken());
        this.withAutoOAuthToken(instance.getAutoOAuthToken());
        this.withOauthTokenProvider(instance.getOauthTokenProvider());
        this.withWebsocketPingInterval(instance.getWebsocketPingInterval());
        this.withConnectionTimeout(instance.getConnectionTimeout());
        this.withMaxConcurrentRequests(instance.getMaxConcurrentRequests());
        this.withMaxConcurrentRequestsPerHost(instance.getMaxConcurrentRequestsPerHost());
        this.withContexts(instance.getContexts());
        this.withCurrentContext(instance.getCurrentContext());
        this.withWatchReconnectInterval(instance.getWatchReconnectInterval());
        this.withWatchReconnectLimit(instance.getWatchReconnectLimit());
        this.withUploadRequestTimeout(instance.getUploadRequestTimeout());
        this.withRequestRetryBackoffLimit(instance.getRequestRetryBackoffLimit());
        this.withRequestRetryBackoffInterval(instance.getRequestRetryBackoffInterval());
        this.withRequestTimeout(instance.getRequestTimeout());
        this.withScaleTimeout(instance.getScaleTimeout());
        this.withLoggingInterval(instance.getLoggingInterval());
        this.withImpersonateUsername(instance.getImpersonateUsername());
        this.withImpersonateGroups(instance.getImpersonateGroups());
        this.withImpersonateExtras(instance.getImpersonateExtras());
        this.withHttp2Disable(instance.isHttp2Disable());
        this.withHttpProxy(instance.getHttpProxy());
        this.withHttpsProxy(instance.getHttpsProxy());
        this.withProxyUsername(instance.getProxyUsername());
        this.withProxyPassword(instance.getProxyPassword());
        this.withNoProxy(instance.getNoProxy());
        this.withUserAgent(instance.getUserAgent());
        this.withTlsVersions(instance.getTlsVersions());
        this.withTlsServerName(instance.getTlsServerName());
        this.withOnlyHttpWatches(instance.isOnlyHttpWatches());
        this.withWatchList(instance.isWatchList());
        this.withCustomHeaders(instance.getCustomHeaders());
        this.withAutoConfigure(instance.getAutoConfigure());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    SundrioOpenShiftConfigFluent that = (SundrioOpenShiftConfigFluent) o;
    if (!(Objects.equals(oapiVersion, that.oapiVersion))) {
      return false;
    }
    if (!(Objects.equals(openShiftUrl, that.openShiftUrl))) {
      return false;
    }
    if (!(Objects.equals(buildTimeout, that.buildTimeout))) {
      return false;
    }
    if (!(Objects.equals(disableApiGroupCheck, that.disableApiGroupCheck))) {
      return false;
    }
    return true;
  }
  
  public Long getBuildTimeout() {
    return this.buildTimeout;
  }
  
  public Boolean getDisableApiGroupCheck() {
    return this.disableApiGroupCheck;
  }
  
  public String getOapiVersion() {
    return this.oapiVersion;
  }
  
  public String getOpenShiftUrl() {
    return this.openShiftUrl;
  }
  
  public boolean hasBuildTimeout() {
    return this.buildTimeout != null;
  }
  
  public boolean hasDisableApiGroupCheck() {
    return this.disableApiGroupCheck != null;
  }
  
  public boolean hasOapiVersion() {
    return this.oapiVersion != null;
  }
  
  public boolean hasOpenShiftUrl() {
    return this.openShiftUrl != null;
  }
  
  public int hashCode() {
    return Objects.hash(oapiVersion, openShiftUrl, buildTimeout, disableApiGroupCheck);
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(oapiVersion == null)) {
        sb.append("oapiVersion:");
        sb.append(oapiVersion);
        sb.append(",");
    }
    if (!(openShiftUrl == null)) {
        sb.append("openShiftUrl:");
        sb.append(openShiftUrl);
        sb.append(",");
    }
    if (!(buildTimeout == null)) {
        sb.append("buildTimeout:");
        sb.append(buildTimeout);
        sb.append(",");
    }
    if (!(disableApiGroupCheck == null)) {
        sb.append("disableApiGroupCheck:");
        sb.append(disableApiGroupCheck);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withBuildTimeout(Long buildTimeout) {
    this.buildTimeout = buildTimeout;
    return (A) this;
  }
  
  public A withDisableApiGroupCheck() {
    return withDisableApiGroupCheck(true);
  }
  
  public A withDisableApiGroupCheck(Boolean disableApiGroupCheck) {
    this.disableApiGroupCheck = disableApiGroupCheck;
    return (A) this;
  }
  
  public A withOapiVersion(String oapiVersion) {
    this.oapiVersion = oapiVersion;
    return (A) this;
  }
  
  public A withOpenShiftUrl(String openShiftUrl) {
    this.openShiftUrl = openShiftUrl;
    return (A) this;
  }
  
}