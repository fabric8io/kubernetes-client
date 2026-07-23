package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProbeFluent<A extends io.fabric8.volcano.api.model.flow.v1alpha1.ProbeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HttpGetBuilder> httpGetList = new ArrayList<HttpGetBuilder>();
  private ArrayList<TaskStatusBuilder> taskStatusList = new ArrayList<TaskStatusBuilder>();
  private ArrayList<TcpSocketBuilder> tcpSocketList = new ArrayList<TcpSocketBuilder>();

  public ProbeFluent() {
  }
  
  public ProbeFluent(Probe instance) {
    this.copyInstance(instance);
  }

  public A addAllToHttpGetList(Collection<HttpGet> items) {
    if (this.httpGetList == null) {
      this.httpGetList = new ArrayList();
    }
    for (HttpGet item : items) {
        HttpGetBuilder builder = new HttpGetBuilder(item);
        _visitables.get("httpGetList").add(builder);
        this.httpGetList.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTaskStatusList(Collection<TaskStatus> items) {
    if (this.taskStatusList == null) {
      this.taskStatusList = new ArrayList();
    }
    for (TaskStatus item : items) {
        TaskStatusBuilder builder = new TaskStatusBuilder(item);
        _visitables.get("taskStatusList").add(builder);
        this.taskStatusList.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTcpSocketList(Collection<TcpSocket> items) {
    if (this.tcpSocketList == null) {
      this.tcpSocketList = new ArrayList();
    }
    for (TcpSocket item : items) {
        TcpSocketBuilder builder = new TcpSocketBuilder(item);
        _visitables.get("tcpSocketList").add(builder);
        this.tcpSocketList.add(builder);
    }
    return (A) this;
  }
  
  public HttpGetListNested<A> addNewHttpGetList() {
    return new HttpGetListNested(-1, null);
  }
  
  public HttpGetListNested<A> addNewHttpGetListLike(HttpGet item) {
    return new HttpGetListNested(-1, item);
  }
  
  public TaskStatusListNested<A> addNewTaskStatusList() {
    return new TaskStatusListNested(-1, null);
  }
  
  public A addNewTaskStatusList(String phase,String taskName) {
    return (A) this.addToTaskStatusList(new TaskStatus(phase, taskName));
  }
  
  public TaskStatusListNested<A> addNewTaskStatusListLike(TaskStatus item) {
    return new TaskStatusListNested(-1, item);
  }
  
  public TcpSocketListNested<A> addNewTcpSocketList() {
    return new TcpSocketListNested(-1, null);
  }
  
  public A addNewTcpSocketList(Integer port,String taskName) {
    return (A) this.addToTcpSocketList(new TcpSocket(port, taskName));
  }
  
  public TcpSocketListNested<A> addNewTcpSocketListLike(TcpSocket item) {
    return new TcpSocketListNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToHttpGetList(HttpGet... items) {
    if (this.httpGetList == null) {
      this.httpGetList = new ArrayList();
    }
    for (HttpGet item : items) {
        HttpGetBuilder builder = new HttpGetBuilder(item);
        _visitables.get("httpGetList").add(builder);
        this.httpGetList.add(builder);
    }
    return (A) this;
  }
  
  public A addToHttpGetList(int index,HttpGet item) {
    if (this.httpGetList == null) {
      this.httpGetList = new ArrayList();
    }
    HttpGetBuilder builder = new HttpGetBuilder(item);
    if (index < 0 || index >= httpGetList.size()) {
        _visitables.get("httpGetList").add(builder);
        httpGetList.add(builder);
    } else {
        _visitables.get("httpGetList").add(builder);
        httpGetList.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTaskStatusList(TaskStatus... items) {
    if (this.taskStatusList == null) {
      this.taskStatusList = new ArrayList();
    }
    for (TaskStatus item : items) {
        TaskStatusBuilder builder = new TaskStatusBuilder(item);
        _visitables.get("taskStatusList").add(builder);
        this.taskStatusList.add(builder);
    }
    return (A) this;
  }
  
  public A addToTaskStatusList(int index,TaskStatus item) {
    if (this.taskStatusList == null) {
      this.taskStatusList = new ArrayList();
    }
    TaskStatusBuilder builder = new TaskStatusBuilder(item);
    if (index < 0 || index >= taskStatusList.size()) {
        _visitables.get("taskStatusList").add(builder);
        taskStatusList.add(builder);
    } else {
        _visitables.get("taskStatusList").add(builder);
        taskStatusList.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTcpSocketList(TcpSocket... items) {
    if (this.tcpSocketList == null) {
      this.tcpSocketList = new ArrayList();
    }
    for (TcpSocket item : items) {
        TcpSocketBuilder builder = new TcpSocketBuilder(item);
        _visitables.get("tcpSocketList").add(builder);
        this.tcpSocketList.add(builder);
    }
    return (A) this;
  }
  
  public A addToTcpSocketList(int index,TcpSocket item) {
    if (this.tcpSocketList == null) {
      this.tcpSocketList = new ArrayList();
    }
    TcpSocketBuilder builder = new TcpSocketBuilder(item);
    if (index < 0 || index >= tcpSocketList.size()) {
        _visitables.get("tcpSocketList").add(builder);
        tcpSocketList.add(builder);
    } else {
        _visitables.get("tcpSocketList").add(builder);
        tcpSocketList.add(index, builder);
    }
    return (A) this;
  }
  
  public HttpGet buildFirstHttpGetList() {
    return this.httpGetList.get(0).build();
  }
  
  public TaskStatus buildFirstTaskStatusList() {
    return this.taskStatusList.get(0).build();
  }
  
  public TcpSocket buildFirstTcpSocketList() {
    return this.tcpSocketList.get(0).build();
  }
  
  public List<HttpGet> buildHttpGetList() {
    return this.httpGetList != null ? build(httpGetList) : null;
  }
  
  public HttpGet buildHttpGetList(int index) {
    return this.httpGetList.get(index).build();
  }
  
  public HttpGet buildLastHttpGetList() {
    return this.httpGetList.get(httpGetList.size() - 1).build();
  }
  
  public TaskStatus buildLastTaskStatusList() {
    return this.taskStatusList.get(taskStatusList.size() - 1).build();
  }
  
  public TcpSocket buildLastTcpSocketList() {
    return this.tcpSocketList.get(tcpSocketList.size() - 1).build();
  }
  
  public HttpGet buildMatchingHttpGetList(Predicate<HttpGetBuilder> predicate) {
      for (HttpGetBuilder item : httpGetList) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskStatus buildMatchingTaskStatusList(Predicate<TaskStatusBuilder> predicate) {
      for (TaskStatusBuilder item : taskStatusList) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TcpSocket buildMatchingTcpSocketList(Predicate<TcpSocketBuilder> predicate) {
      for (TcpSocketBuilder item : tcpSocketList) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TaskStatus> buildTaskStatusList() {
    return this.taskStatusList != null ? build(taskStatusList) : null;
  }
  
  public TaskStatus buildTaskStatusList(int index) {
    return this.taskStatusList.get(index).build();
  }
  
  public List<TcpSocket> buildTcpSocketList() {
    return this.tcpSocketList != null ? build(tcpSocketList) : null;
  }
  
  public TcpSocket buildTcpSocketList(int index) {
    return this.tcpSocketList.get(index).build();
  }
  
  protected void copyInstance(Probe instance) {
    instance = instance != null ? instance : new Probe();
    if (instance != null) {
        this.withHttpGetList(instance.getHttpGetList());
        this.withTaskStatusList(instance.getTaskStatusList());
        this.withTcpSocketList(instance.getTcpSocketList());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpGetListNested<A> editFirstHttpGetList() {
    if (httpGetList.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "httpGetList"));
    }
    return this.setNewHttpGetListLike(0, this.buildHttpGetList(0));
  }
  
  public TaskStatusListNested<A> editFirstTaskStatusList() {
    if (taskStatusList.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "taskStatusList"));
    }
    return this.setNewTaskStatusListLike(0, this.buildTaskStatusList(0));
  }
  
  public TcpSocketListNested<A> editFirstTcpSocketList() {
    if (tcpSocketList.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tcpSocketList"));
    }
    return this.setNewTcpSocketListLike(0, this.buildTcpSocketList(0));
  }
  
  public HttpGetListNested<A> editHttpGetList(int index) {
    if (httpGetList.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "httpGetList"));
    }
    return this.setNewHttpGetListLike(index, this.buildHttpGetList(index));
  }
  
  public HttpGetListNested<A> editLastHttpGetList() {
    int index = httpGetList.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "httpGetList"));
    }
    return this.setNewHttpGetListLike(index, this.buildHttpGetList(index));
  }
  
  public TaskStatusListNested<A> editLastTaskStatusList() {
    int index = taskStatusList.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "taskStatusList"));
    }
    return this.setNewTaskStatusListLike(index, this.buildTaskStatusList(index));
  }
  
  public TcpSocketListNested<A> editLastTcpSocketList() {
    int index = tcpSocketList.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tcpSocketList"));
    }
    return this.setNewTcpSocketListLike(index, this.buildTcpSocketList(index));
  }
  
  public HttpGetListNested<A> editMatchingHttpGetList(Predicate<HttpGetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < httpGetList.size();i++) {
      if (predicate.test(httpGetList.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "httpGetList"));
    }
    return this.setNewHttpGetListLike(index, this.buildHttpGetList(index));
  }
  
  public TaskStatusListNested<A> editMatchingTaskStatusList(Predicate<TaskStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < taskStatusList.size();i++) {
      if (predicate.test(taskStatusList.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "taskStatusList"));
    }
    return this.setNewTaskStatusListLike(index, this.buildTaskStatusList(index));
  }
  
  public TcpSocketListNested<A> editMatchingTcpSocketList(Predicate<TcpSocketBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tcpSocketList.size();i++) {
      if (predicate.test(tcpSocketList.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tcpSocketList"));
    }
    return this.setNewTcpSocketListLike(index, this.buildTcpSocketList(index));
  }
  
  public TaskStatusListNested<A> editTaskStatusList(int index) {
    if (taskStatusList.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "taskStatusList"));
    }
    return this.setNewTaskStatusListLike(index, this.buildTaskStatusList(index));
  }
  
  public TcpSocketListNested<A> editTcpSocketList(int index) {
    if (tcpSocketList.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tcpSocketList"));
    }
    return this.setNewTcpSocketListLike(index, this.buildTcpSocketList(index));
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
    ProbeFluent that = (ProbeFluent) o;
    if (!(Objects.equals(httpGetList, that.httpGetList))) {
      return false;
    }
    if (!(Objects.equals(taskStatusList, that.taskStatusList))) {
      return false;
    }
    if (!(Objects.equals(tcpSocketList, that.tcpSocketList))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpGetList() {
    return this.httpGetList != null && !(this.httpGetList.isEmpty());
  }
  
  public boolean hasMatchingHttpGetList(Predicate<HttpGetBuilder> predicate) {
      for (HttpGetBuilder item : httpGetList) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTaskStatusList(Predicate<TaskStatusBuilder> predicate) {
      for (TaskStatusBuilder item : taskStatusList) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTcpSocketList(Predicate<TcpSocketBuilder> predicate) {
      for (TcpSocketBuilder item : tcpSocketList) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTaskStatusList() {
    return this.taskStatusList != null && !(this.taskStatusList.isEmpty());
  }
  
  public boolean hasTcpSocketList() {
    return this.tcpSocketList != null && !(this.tcpSocketList.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(httpGetList, taskStatusList, tcpSocketList, additionalProperties);
  }
  
  public A removeAllFromHttpGetList(Collection<HttpGet> items) {
    if (this.httpGetList == null) {
      return (A) this;
    }
    for (HttpGet item : items) {
        HttpGetBuilder builder = new HttpGetBuilder(item);
        _visitables.get("httpGetList").remove(builder);
        this.httpGetList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTaskStatusList(Collection<TaskStatus> items) {
    if (this.taskStatusList == null) {
      return (A) this;
    }
    for (TaskStatus item : items) {
        TaskStatusBuilder builder = new TaskStatusBuilder(item);
        _visitables.get("taskStatusList").remove(builder);
        this.taskStatusList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTcpSocketList(Collection<TcpSocket> items) {
    if (this.tcpSocketList == null) {
      return (A) this;
    }
    for (TcpSocket item : items) {
        TcpSocketBuilder builder = new TcpSocketBuilder(item);
        _visitables.get("tcpSocketList").remove(builder);
        this.tcpSocketList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromHttpGetList(HttpGet... items) {
    if (this.httpGetList == null) {
      return (A) this;
    }
    for (HttpGet item : items) {
        HttpGetBuilder builder = new HttpGetBuilder(item);
        _visitables.get("httpGetList").remove(builder);
        this.httpGetList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTaskStatusList(TaskStatus... items) {
    if (this.taskStatusList == null) {
      return (A) this;
    }
    for (TaskStatus item : items) {
        TaskStatusBuilder builder = new TaskStatusBuilder(item);
        _visitables.get("taskStatusList").remove(builder);
        this.taskStatusList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTcpSocketList(TcpSocket... items) {
    if (this.tcpSocketList == null) {
      return (A) this;
    }
    for (TcpSocket item : items) {
        TcpSocketBuilder builder = new TcpSocketBuilder(item);
        _visitables.get("tcpSocketList").remove(builder);
        this.tcpSocketList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHttpGetList(Predicate<HttpGetBuilder> predicate) {
    if (httpGetList == null) {
      return (A) this;
    }
    Iterator<HttpGetBuilder> each = httpGetList.iterator();
    List visitables = _visitables.get("httpGetList");
    while (each.hasNext()) {
        HttpGetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTaskStatusList(Predicate<TaskStatusBuilder> predicate) {
    if (taskStatusList == null) {
      return (A) this;
    }
    Iterator<TaskStatusBuilder> each = taskStatusList.iterator();
    List visitables = _visitables.get("taskStatusList");
    while (each.hasNext()) {
        TaskStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTcpSocketList(Predicate<TcpSocketBuilder> predicate) {
    if (tcpSocketList == null) {
      return (A) this;
    }
    Iterator<TcpSocketBuilder> each = tcpSocketList.iterator();
    List visitables = _visitables.get("tcpSocketList");
    while (each.hasNext()) {
        TcpSocketBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HttpGetListNested<A> setNewHttpGetListLike(int index,HttpGet item) {
    return new HttpGetListNested(index, item);
  }
  
  public TaskStatusListNested<A> setNewTaskStatusListLike(int index,TaskStatus item) {
    return new TaskStatusListNested(index, item);
  }
  
  public TcpSocketListNested<A> setNewTcpSocketListLike(int index,TcpSocket item) {
    return new TcpSocketListNested(index, item);
  }
  
  public A setToHttpGetList(int index,HttpGet item) {
    if (this.httpGetList == null) {
      this.httpGetList = new ArrayList();
    }
    HttpGetBuilder builder = new HttpGetBuilder(item);
    if (index < 0 || index >= httpGetList.size()) {
        _visitables.get("httpGetList").add(builder);
        httpGetList.add(builder);
    } else {
        _visitables.get("httpGetList").add(builder);
        httpGetList.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTaskStatusList(int index,TaskStatus item) {
    if (this.taskStatusList == null) {
      this.taskStatusList = new ArrayList();
    }
    TaskStatusBuilder builder = new TaskStatusBuilder(item);
    if (index < 0 || index >= taskStatusList.size()) {
        _visitables.get("taskStatusList").add(builder);
        taskStatusList.add(builder);
    } else {
        _visitables.get("taskStatusList").add(builder);
        taskStatusList.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTcpSocketList(int index,TcpSocket item) {
    if (this.tcpSocketList == null) {
      this.tcpSocketList = new ArrayList();
    }
    TcpSocketBuilder builder = new TcpSocketBuilder(item);
    if (index < 0 || index >= tcpSocketList.size()) {
        _visitables.get("tcpSocketList").add(builder);
        tcpSocketList.add(builder);
    } else {
        _visitables.get("tcpSocketList").add(builder);
        tcpSocketList.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(httpGetList == null) && !(httpGetList.isEmpty())) {
        sb.append("httpGetList:");
        sb.append(httpGetList);
        sb.append(",");
    }
    if (!(taskStatusList == null) && !(taskStatusList.isEmpty())) {
        sb.append("taskStatusList:");
        sb.append(taskStatusList);
        sb.append(",");
    }
    if (!(tcpSocketList == null) && !(tcpSocketList.isEmpty())) {
        sb.append("tcpSocketList:");
        sb.append(tcpSocketList);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withHttpGetList(List<HttpGet> httpGetList) {
    if (this.httpGetList != null) {
      this._visitables.get("httpGetList").clear();
    }
    if (httpGetList != null) {
        this.httpGetList = new ArrayList();
        for (HttpGet item : httpGetList) {
          this.addToHttpGetList(item);
        }
    } else {
      this.httpGetList = null;
    }
    return (A) this;
  }
  
  public A withHttpGetList(HttpGet... httpGetList) {
    if (this.httpGetList != null) {
        this.httpGetList.clear();
        _visitables.remove("httpGetList");
    }
    if (httpGetList != null) {
      for (HttpGet item : httpGetList) {
        this.addToHttpGetList(item);
      }
    }
    return (A) this;
  }
  
  public A withTaskStatusList(List<TaskStatus> taskStatusList) {
    if (this.taskStatusList != null) {
      this._visitables.get("taskStatusList").clear();
    }
    if (taskStatusList != null) {
        this.taskStatusList = new ArrayList();
        for (TaskStatus item : taskStatusList) {
          this.addToTaskStatusList(item);
        }
    } else {
      this.taskStatusList = null;
    }
    return (A) this;
  }
  
  public A withTaskStatusList(TaskStatus... taskStatusList) {
    if (this.taskStatusList != null) {
        this.taskStatusList.clear();
        _visitables.remove("taskStatusList");
    }
    if (taskStatusList != null) {
      for (TaskStatus item : taskStatusList) {
        this.addToTaskStatusList(item);
      }
    }
    return (A) this;
  }
  
  public A withTcpSocketList(List<TcpSocket> tcpSocketList) {
    if (this.tcpSocketList != null) {
      this._visitables.get("tcpSocketList").clear();
    }
    if (tcpSocketList != null) {
        this.tcpSocketList = new ArrayList();
        for (TcpSocket item : tcpSocketList) {
          this.addToTcpSocketList(item);
        }
    } else {
      this.tcpSocketList = null;
    }
    return (A) this;
  }
  
  public A withTcpSocketList(TcpSocket... tcpSocketList) {
    if (this.tcpSocketList != null) {
        this.tcpSocketList.clear();
        _visitables.remove("tcpSocketList");
    }
    if (tcpSocketList != null) {
      for (TcpSocket item : tcpSocketList) {
        this.addToTcpSocketList(item);
      }
    }
    return (A) this;
  }
  public class HttpGetListNested<N> extends HttpGetFluent<HttpGetListNested<N>> implements Nested<N>{
  
    HttpGetBuilder builder;
    int index;
  
    HttpGetListNested(int index,HttpGet item) {
      this.index = index;
      this.builder = new HttpGetBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.setToHttpGetList(index, builder.build());
    }
    
    public N endHttpGetList() {
      return and();
    }
    
  }
  public class TaskStatusListNested<N> extends TaskStatusFluent<TaskStatusListNested<N>> implements Nested<N>{
  
    TaskStatusBuilder builder;
    int index;
  
    TaskStatusListNested(int index,TaskStatus item) {
      this.index = index;
      this.builder = new TaskStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.setToTaskStatusList(index, builder.build());
    }
    
    public N endTaskStatusList() {
      return and();
    }
    
  }
  public class TcpSocketListNested<N> extends TcpSocketFluent<TcpSocketListNested<N>> implements Nested<N>{
  
    TcpSocketBuilder builder;
    int index;
  
    TcpSocketListNested(int index,TcpSocket item) {
      this.index = index;
      this.builder = new TcpSocketBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.setToTcpSocketList(index, builder.build());
    }
    
    public N endTcpSocketList() {
      return and();
    }
    
  }
}