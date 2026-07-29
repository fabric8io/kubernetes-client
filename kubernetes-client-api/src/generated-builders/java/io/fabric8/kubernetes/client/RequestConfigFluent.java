package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RequestConfigFluent<A extends io.fabric8.kubernetes.client.RequestConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,List<String>> impersonateExtras;
  private List<String> impersonateGroups;
  private String impersonateUsername;
  private Integer loggingInterval;
  private Integer requestRetryBackoffInterval;
  private Integer requestRetryBackoffLimit;
  private Integer requestTimeout;
  private Long scaleTimeout;
  private Integer uploadRequestTimeout;
  private Integer watchReconnectInterval;
  private Integer watchReconnectLimit;

  public RequestConfigFluent() {
  }
  
  public RequestConfigFluent(RequestConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToImpersonateGroups(Collection<String> items) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    for (String item : items) {
      this.impersonateGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToImpersonateExtras(Map<String,List<String>> map) {
    if (this.impersonateExtras == null && map != null) {
      this.impersonateExtras = new LinkedHashMap();
    }
    if (map != null) {
      this.impersonateExtras.putAll(map);
    }
    return (A) this;
  }
  
  public A addToImpersonateExtras(String key,List<String> value) {
    if (this.impersonateExtras == null && key != null && value != null) {
      this.impersonateExtras = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.impersonateExtras.put(key, value);
    }
    return (A) this;
  }
  
  public A addToImpersonateGroups(String... items) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    for (String item : items) {
      this.impersonateGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToImpersonateGroups(int index,String item) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    this.impersonateGroups.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RequestConfig instance) {
    instance = instance != null ? instance : new RequestConfig();
    if (instance != null) {
        this.withWatchReconnectLimit(instance.getWatchReconnectLimit());
        this.withWatchReconnectInterval(instance.getWatchReconnectInterval());
        this.withRequestTimeout(instance.getRequestTimeout());
        this.withScaleTimeout(instance.getScaleTimeout());
        this.withLoggingInterval(instance.getLoggingInterval());
        this.withRequestRetryBackoffLimit(instance.getRequestRetryBackoffLimit());
        this.withRequestRetryBackoffInterval(instance.getRequestRetryBackoffInterval());
        this.withUploadRequestTimeout(instance.getUploadRequestTimeout());
        this.withImpersonateUsername(instance.getImpersonateUsername());
        this.withImpersonateGroups(instance.getImpersonateGroups());
        this.withImpersonateExtras(instance.getImpersonateExtras());
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
    RequestConfigFluent that = (RequestConfigFluent) o;
    if (!(Objects.equals(impersonateUsername, that.impersonateUsername))) {
      return false;
    }
    if (!(Objects.equals(impersonateGroups, that.impersonateGroups))) {
      return false;
    }
    if (!(Objects.equals(impersonateExtras, that.impersonateExtras))) {
      return false;
    }
    if (!(Objects.equals(watchReconnectInterval, that.watchReconnectInterval))) {
      return false;
    }
    if (!(Objects.equals(watchReconnectLimit, that.watchReconnectLimit))) {
      return false;
    }
    if (!(Objects.equals(uploadRequestTimeout, that.uploadRequestTimeout))) {
      return false;
    }
    if (!(Objects.equals(requestRetryBackoffLimit, that.requestRetryBackoffLimit))) {
      return false;
    }
    if (!(Objects.equals(requestRetryBackoffInterval, that.requestRetryBackoffInterval))) {
      return false;
    }
    if (!(Objects.equals(requestTimeout, that.requestTimeout))) {
      return false;
    }
    if (!(Objects.equals(scaleTimeout, that.scaleTimeout))) {
      return false;
    }
    if (!(Objects.equals(loggingInterval, that.loggingInterval))) {
      return false;
    }
    return true;
  }
  
  public Map<String,List<String>> getImpersonateExtras() {
    return this.impersonateExtras;
  }
  
  public String[] getImpersonateGroups() {
    int size = impersonateGroups != null ? impersonateGroups.size() : 0;
    String[] result = new String[size];
    if (size == 0) {
      return result;
    }
    int index = 0;
    for (String item : impersonateGroups) {
      result[index++] = item;
    }
    return result;
  }
  
  public String getImpersonateUsername() {
    return this.impersonateUsername;
  }
  
  public Integer getLoggingInterval() {
    return this.loggingInterval;
  }
  
  public Integer getRequestRetryBackoffInterval() {
    return this.requestRetryBackoffInterval;
  }
  
  public Integer getRequestRetryBackoffLimit() {
    return this.requestRetryBackoffLimit;
  }
  
  public Integer getRequestTimeout() {
    return this.requestTimeout;
  }
  
  public Long getScaleTimeout() {
    return this.scaleTimeout;
  }
  
  public Integer getUploadRequestTimeout() {
    return this.uploadRequestTimeout;
  }
  
  public Integer getWatchReconnectInterval() {
    return this.watchReconnectInterval;
  }
  
  public Integer getWatchReconnectLimit() {
    return this.watchReconnectLimit;
  }
  
  public boolean hasImpersonateExtras() {
    return this.impersonateExtras != null;
  }
  
  public boolean hasImpersonateGroups() {
    return this.impersonateGroups != null && !(this.impersonateGroups.isEmpty());
  }
  
  public boolean hasImpersonateUsername() {
    return this.impersonateUsername != null;
  }
  
  public boolean hasLoggingInterval() {
    return this.loggingInterval != null;
  }
  
  public boolean hasRequestRetryBackoffInterval() {
    return this.requestRetryBackoffInterval != null;
  }
  
  public boolean hasRequestRetryBackoffLimit() {
    return this.requestRetryBackoffLimit != null;
  }
  
  public boolean hasRequestTimeout() {
    return this.requestTimeout != null;
  }
  
  public boolean hasScaleTimeout() {
    return this.scaleTimeout != null;
  }
  
  public boolean hasUploadRequestTimeout() {
    return this.uploadRequestTimeout != null;
  }
  
  public boolean hasWatchReconnectInterval() {
    return this.watchReconnectInterval != null;
  }
  
  public boolean hasWatchReconnectLimit() {
    return this.watchReconnectLimit != null;
  }
  
  public int hashCode() {
    return Objects.hash(impersonateUsername, impersonateGroups, impersonateExtras, watchReconnectInterval, watchReconnectLimit, uploadRequestTimeout, requestRetryBackoffLimit, requestRetryBackoffInterval, requestTimeout, scaleTimeout, loggingInterval);
  }
  
  public A removeAllFromImpersonateGroups(Collection<String> items) {
    if (this.impersonateGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.impersonateGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromImpersonateExtras(String key) {
    if (this.impersonateExtras == null) {
      return (A) this;
    }
    if (key != null && this.impersonateExtras != null) {
      this.impersonateExtras.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromImpersonateExtras(Map<String,List<String>> map) {
    if (this.impersonateExtras == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.impersonateExtras != null) {
          this.impersonateExtras.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromImpersonateGroups(String... items) {
    if (this.impersonateGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.impersonateGroups.remove(item);
    }
    return (A) this;
  }
  
  public A setToImpersonateGroups(int index,String item) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    this.impersonateGroups.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(impersonateUsername == null)) {
        sb.append("impersonateUsername:");
        sb.append(impersonateUsername);
        sb.append(",");
    }
    if (!(impersonateGroups == null) && !(impersonateGroups.isEmpty())) {
        sb.append("impersonateGroups:");
        sb.append(impersonateGroups);
        sb.append(",");
    }
    if (!(impersonateExtras == null) && !(impersonateExtras.isEmpty())) {
        sb.append("impersonateExtras:");
        sb.append(impersonateExtras);
        sb.append(",");
    }
    if (!(watchReconnectInterval == null)) {
        sb.append("watchReconnectInterval:");
        sb.append(watchReconnectInterval);
        sb.append(",");
    }
    if (!(watchReconnectLimit == null)) {
        sb.append("watchReconnectLimit:");
        sb.append(watchReconnectLimit);
        sb.append(",");
    }
    if (!(uploadRequestTimeout == null)) {
        sb.append("uploadRequestTimeout:");
        sb.append(uploadRequestTimeout);
        sb.append(",");
    }
    if (!(requestRetryBackoffLimit == null)) {
        sb.append("requestRetryBackoffLimit:");
        sb.append(requestRetryBackoffLimit);
        sb.append(",");
    }
    if (!(requestRetryBackoffInterval == null)) {
        sb.append("requestRetryBackoffInterval:");
        sb.append(requestRetryBackoffInterval);
        sb.append(",");
    }
    if (!(requestTimeout == null)) {
        sb.append("requestTimeout:");
        sb.append(requestTimeout);
        sb.append(",");
    }
    if (!(scaleTimeout == null)) {
        sb.append("scaleTimeout:");
        sb.append(scaleTimeout);
        sb.append(",");
    }
    if (!(loggingInterval == null)) {
        sb.append("loggingInterval:");
        sb.append(loggingInterval);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withImpersonateExtras(Map<String,List<String>> impersonateExtras) {
    if (impersonateExtras == null) {
      this.impersonateExtras = null;
    } else {
      this.impersonateExtras = new LinkedHashMap(impersonateExtras);
    }
    return (A) this;
  }
  
  public A withImpersonateGroups(String... impersonateGroups) {
    if (this.impersonateGroups != null) {
        this.impersonateGroups.clear();
        _visitables.remove("impersonateGroups");
    }
    if (impersonateGroups != null) {
      for (String item : impersonateGroups) {
        this.addToImpersonateGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withImpersonateUsername(String impersonateUsername) {
    this.impersonateUsername = impersonateUsername;
    return (A) this;
  }
  
  public A withLoggingInterval(Integer loggingInterval) {
    this.loggingInterval = loggingInterval;
    return (A) this;
  }
  
  public A withRequestRetryBackoffInterval(Integer requestRetryBackoffInterval) {
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
    return (A) this;
  }
  
  public A withRequestRetryBackoffLimit(Integer requestRetryBackoffLimit) {
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
    return (A) this;
  }
  
  public A withRequestTimeout(Integer requestTimeout) {
    this.requestTimeout = requestTimeout;
    return (A) this;
  }
  
  public A withScaleTimeout(Long scaleTimeout) {
    this.scaleTimeout = scaleTimeout;
    return (A) this;
  }
  
  public A withUploadRequestTimeout(Integer uploadRequestTimeout) {
    this.uploadRequestTimeout = uploadRequestTimeout;
    return (A) this;
  }
  
  public A withWatchReconnectInterval(Integer watchReconnectInterval) {
    this.watchReconnectInterval = watchReconnectInterval;
    return (A) this;
  }
  
  public A withWatchReconnectLimit(Integer watchReconnectLimit) {
    this.watchReconnectLimit = watchReconnectLimit;
    return (A) this;
  }
  
}