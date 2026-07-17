package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RocketChatConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.RocketChatConfigFluent<A>> extends BaseFluent<A>{

  private ArrayList<RocketChatActionConfigBuilder> actions = new ArrayList<RocketChatActionConfigBuilder>();
  private Map<String,Object> additionalProperties;
  private String apiURL;
  private String channel;
  private String color;
  private String emoji;
  private ArrayList<RocketChatFieldConfigBuilder> fields = new ArrayList<RocketChatFieldConfigBuilder>();
  private HTTPConfigBuilder httpConfig;
  private String iconURL;
  private String imageURL;
  private Boolean linkNames;
  private Boolean sendResolved;
  private Boolean shortFields;
  private String text;
  private String thumbURL;
  private String title;
  private String titleLink;
  private SecretKeySelector token;
  private SecretKeySelector tokenID;

  public RocketChatConfigFluent() {
  }
  
  public RocketChatConfigFluent(RocketChatConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToActions(Collection<RocketChatActionConfig> items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (RocketChatActionConfig item : items) {
        RocketChatActionConfigBuilder builder = new RocketChatActionConfigBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFields(Collection<RocketChatFieldConfig> items) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    for (RocketChatFieldConfig item : items) {
        RocketChatFieldConfigBuilder builder = new RocketChatFieldConfigBuilder(item);
        _visitables.get("fields").add(builder);
        this.fields.add(builder);
    }
    return (A) this;
  }
  
  public ActionsNested<A> addNewAction() {
    return new ActionsNested(-1, null);
  }
  
  public A addNewAction(String msg,String text,String url) {
    return (A) this.addToActions(new RocketChatActionConfig(msg, text, url));
  }
  
  public ActionsNested<A> addNewActionLike(RocketChatActionConfig item) {
    return new ActionsNested(-1, item);
  }
  
  public FieldsNested<A> addNewField() {
    return new FieldsNested(-1, null);
  }
  
  public A addNewField(Boolean _short,String title,String value) {
    return (A) this.addToFields(new RocketChatFieldConfig(_short, title, value));
  }
  
  public FieldsNested<A> addNewFieldLike(RocketChatFieldConfig item) {
    return new FieldsNested(-1, item);
  }
  
  public A addToActions(RocketChatActionConfig... items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (RocketChatActionConfig item : items) {
        RocketChatActionConfigBuilder builder = new RocketChatActionConfigBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public A addToActions(int index,RocketChatActionConfig item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    RocketChatActionConfigBuilder builder = new RocketChatActionConfigBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.add(index, builder);
    }
    return (A) this;
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
  
  public A addToFields(RocketChatFieldConfig... items) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    for (RocketChatFieldConfig item : items) {
        RocketChatFieldConfigBuilder builder = new RocketChatFieldConfigBuilder(item);
        _visitables.get("fields").add(builder);
        this.fields.add(builder);
    }
    return (A) this;
  }
  
  public A addToFields(int index,RocketChatFieldConfig item) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    RocketChatFieldConfigBuilder builder = new RocketChatFieldConfigBuilder(item);
    if (index < 0 || index >= fields.size()) {
        _visitables.get("fields").add(builder);
        fields.add(builder);
    } else {
        _visitables.get("fields").add(builder);
        fields.add(index, builder);
    }
    return (A) this;
  }
  
  public RocketChatActionConfig buildAction(int index) {
    return this.actions.get(index).build();
  }
  
  public List<RocketChatActionConfig> buildActions() {
    return this.actions != null ? build(actions) : null;
  }
  
  public RocketChatFieldConfig buildField(int index) {
    return this.fields.get(index).build();
  }
  
  public List<RocketChatFieldConfig> buildFields() {
    return this.fields != null ? build(fields) : null;
  }
  
  public RocketChatActionConfig buildFirstAction() {
    return this.actions.get(0).build();
  }
  
  public RocketChatFieldConfig buildFirstField() {
    return this.fields.get(0).build();
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public RocketChatActionConfig buildLastAction() {
    return this.actions.get(actions.size() - 1).build();
  }
  
  public RocketChatFieldConfig buildLastField() {
    return this.fields.get(fields.size() - 1).build();
  }
  
  public RocketChatActionConfig buildMatchingAction(Predicate<RocketChatActionConfigBuilder> predicate) {
      for (RocketChatActionConfigBuilder item : actions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RocketChatFieldConfig buildMatchingField(Predicate<RocketChatFieldConfigBuilder> predicate) {
      for (RocketChatFieldConfigBuilder item : fields) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RocketChatConfig instance) {
    instance = instance != null ? instance : new RocketChatConfig();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withApiURL(instance.getApiURL());
        this.withChannel(instance.getChannel());
        this.withColor(instance.getColor());
        this.withEmoji(instance.getEmoji());
        this.withFields(instance.getFields());
        this.withHttpConfig(instance.getHttpConfig());
        this.withIconURL(instance.getIconURL());
        this.withImageURL(instance.getImageURL());
        this.withLinkNames(instance.getLinkNames());
        this.withSendResolved(instance.getSendResolved());
        this.withShortFields(instance.getShortFields());
        this.withText(instance.getText());
        this.withThumbURL(instance.getThumbURL());
        this.withTitle(instance.getTitle());
        this.withTitleLink(instance.getTitleLink());
        this.withToken(instance.getToken());
        this.withTokenID(instance.getTokenID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editAction(int index) {
    if (actions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public FieldsNested<A> editField(int index) {
    if (fields.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public ActionsNested<A> editFirstAction() {
    if (actions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(0, this.buildAction(0));
  }
  
  public FieldsNested<A> editFirstField() {
    if (fields.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fields"));
    }
    return this.setNewFieldLike(0, this.buildField(0));
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public ActionsNested<A> editLastAction() {
    int index = actions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public FieldsNested<A> editLastField() {
    int index = fields.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public ActionsNested<A> editMatchingAction(Predicate<RocketChatActionConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < actions.size();i++) {
      if (predicate.test(actions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public FieldsNested<A> editMatchingField(Predicate<RocketChatFieldConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fields.size();i++) {
      if (predicate.test(fields.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
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
    RocketChatConfigFluent that = (RocketChatConfigFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
      return false;
    }
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(channel, that.channel))) {
      return false;
    }
    if (!(Objects.equals(color, that.color))) {
      return false;
    }
    if (!(Objects.equals(emoji, that.emoji))) {
      return false;
    }
    if (!(Objects.equals(fields, that.fields))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(iconURL, that.iconURL))) {
      return false;
    }
    if (!(Objects.equals(imageURL, that.imageURL))) {
      return false;
    }
    if (!(Objects.equals(linkNames, that.linkNames))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(shortFields, that.shortFields))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
      return false;
    }
    if (!(Objects.equals(thumbURL, that.thumbURL))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
      return false;
    }
    if (!(Objects.equals(titleLink, that.titleLink))) {
      return false;
    }
    if (!(Objects.equals(token, that.token))) {
      return false;
    }
    if (!(Objects.equals(tokenID, that.tokenID))) {
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
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public String getChannel() {
    return this.channel;
  }
  
  public String getColor() {
    return this.color;
  }
  
  public String getEmoji() {
    return this.emoji;
  }
  
  public String getIconURL() {
    return this.iconURL;
  }
  
  public String getImageURL() {
    return this.imageURL;
  }
  
  public Boolean getLinkNames() {
    return this.linkNames;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public Boolean getShortFields() {
    return this.shortFields;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getThumbURL() {
    return this.thumbURL;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String getTitleLink() {
    return this.titleLink;
  }
  
  public SecretKeySelector getToken() {
    return this.token;
  }
  
  public SecretKeySelector getTokenID() {
    return this.tokenID;
  }
  
  public boolean hasActions() {
    return this.actions != null && !(this.actions.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasChannel() {
    return this.channel != null;
  }
  
  public boolean hasColor() {
    return this.color != null;
  }
  
  public boolean hasEmoji() {
    return this.emoji != null;
  }
  
  public boolean hasFields() {
    return this.fields != null && !(this.fields.isEmpty());
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasIconURL() {
    return this.iconURL != null;
  }
  
  public boolean hasImageURL() {
    return this.imageURL != null;
  }
  
  public boolean hasLinkNames() {
    return this.linkNames != null;
  }
  
  public boolean hasMatchingAction(Predicate<RocketChatActionConfigBuilder> predicate) {
      for (RocketChatActionConfigBuilder item : actions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingField(Predicate<RocketChatFieldConfigBuilder> predicate) {
      for (RocketChatFieldConfigBuilder item : fields) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasShortFields() {
    return this.shortFields != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public boolean hasThumbURL() {
    return this.thumbURL != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public boolean hasTitleLink() {
    return this.titleLink != null;
  }
  
  public boolean hasToken() {
    return this.token != null;
  }
  
  public boolean hasTokenID() {
    return this.tokenID != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, apiURL, channel, color, emoji, fields, httpConfig, iconURL, imageURL, linkNames, sendResolved, shortFields, text, thumbURL, title, titleLink, token, tokenID, additionalProperties);
  }
  
  public A removeAllFromActions(Collection<RocketChatActionConfig> items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (RocketChatActionConfig item : items) {
        RocketChatActionConfigBuilder builder = new RocketChatActionConfigBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFields(Collection<RocketChatFieldConfig> items) {
    if (this.fields == null) {
      return (A) this;
    }
    for (RocketChatFieldConfig item : items) {
        RocketChatFieldConfigBuilder builder = new RocketChatFieldConfigBuilder(item);
        _visitables.get("fields").remove(builder);
        this.fields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromActions(RocketChatActionConfig... items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (RocketChatActionConfig item : items) {
        RocketChatActionConfigBuilder builder = new RocketChatActionConfigBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
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
  
  public A removeFromFields(RocketChatFieldConfig... items) {
    if (this.fields == null) {
      return (A) this;
    }
    for (RocketChatFieldConfig item : items) {
        RocketChatFieldConfigBuilder builder = new RocketChatFieldConfigBuilder(item);
        _visitables.get("fields").remove(builder);
        this.fields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromActions(Predicate<RocketChatActionConfigBuilder> predicate) {
    if (actions == null) {
      return (A) this;
    }
    Iterator<RocketChatActionConfigBuilder> each = actions.iterator();
    List visitables = _visitables.get("actions");
    while (each.hasNext()) {
        RocketChatActionConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFields(Predicate<RocketChatFieldConfigBuilder> predicate) {
    if (fields == null) {
      return (A) this;
    }
    Iterator<RocketChatFieldConfigBuilder> each = fields.iterator();
    List visitables = _visitables.get("fields");
    while (each.hasNext()) {
        RocketChatFieldConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActionsNested<A> setNewActionLike(int index,RocketChatActionConfig item) {
    return new ActionsNested(index, item);
  }
  
  public FieldsNested<A> setNewFieldLike(int index,RocketChatFieldConfig item) {
    return new FieldsNested(index, item);
  }
  
  public A setToActions(int index,RocketChatActionConfig item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    RocketChatActionConfigBuilder builder = new RocketChatActionConfigBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFields(int index,RocketChatFieldConfig item) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    RocketChatFieldConfigBuilder builder = new RocketChatFieldConfigBuilder(item);
    if (index < 0 || index >= fields.size()) {
        _visitables.get("fields").add(builder);
        fields.add(builder);
    } else {
        _visitables.get("fields").add(builder);
        fields.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actions == null) && !(actions.isEmpty())) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(channel == null)) {
        sb.append("channel:");
        sb.append(channel);
        sb.append(",");
    }
    if (!(color == null)) {
        sb.append("color:");
        sb.append(color);
        sb.append(",");
    }
    if (!(emoji == null)) {
        sb.append("emoji:");
        sb.append(emoji);
        sb.append(",");
    }
    if (!(fields == null) && !(fields.isEmpty())) {
        sb.append("fields:");
        sb.append(fields);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(iconURL == null)) {
        sb.append("iconURL:");
        sb.append(iconURL);
        sb.append(",");
    }
    if (!(imageURL == null)) {
        sb.append("imageURL:");
        sb.append(imageURL);
        sb.append(",");
    }
    if (!(linkNames == null)) {
        sb.append("linkNames:");
        sb.append(linkNames);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(shortFields == null)) {
        sb.append("shortFields:");
        sb.append(shortFields);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
        sb.append(",");
    }
    if (!(thumbURL == null)) {
        sb.append("thumbURL:");
        sb.append(thumbURL);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
        sb.append(",");
    }
    if (!(titleLink == null)) {
        sb.append("titleLink:");
        sb.append(titleLink);
        sb.append(",");
    }
    if (!(token == null)) {
        sb.append("token:");
        sb.append(token);
        sb.append(",");
    }
    if (!(tokenID == null)) {
        sb.append("tokenID:");
        sb.append(tokenID);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(List<RocketChatActionConfig> actions) {
    if (this.actions != null) {
      this._visitables.get("actions").clear();
    }
    if (actions != null) {
        this.actions = new ArrayList();
        for (RocketChatActionConfig item : actions) {
          this.addToActions(item);
        }
    } else {
      this.actions = null;
    }
    return (A) this;
  }
  
  public A withActions(RocketChatActionConfig... actions) {
    if (this.actions != null) {
        this.actions.clear();
        _visitables.remove("actions");
    }
    if (actions != null) {
      for (RocketChatActionConfig item : actions) {
        this.addToActions(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withChannel(String channel) {
    this.channel = channel;
    return (A) this;
  }
  
  public A withColor(String color) {
    this.color = color;
    return (A) this;
  }
  
  public A withEmoji(String emoji) {
    this.emoji = emoji;
    return (A) this;
  }
  
  public A withFields(List<RocketChatFieldConfig> fields) {
    if (this.fields != null) {
      this._visitables.get("fields").clear();
    }
    if (fields != null) {
        this.fields = new ArrayList();
        for (RocketChatFieldConfig item : fields) {
          this.addToFields(item);
        }
    } else {
      this.fields = null;
    }
    return (A) this;
  }
  
  public A withFields(RocketChatFieldConfig... fields) {
    if (this.fields != null) {
        this.fields.clear();
        _visitables.remove("fields");
    }
    if (fields != null) {
      for (RocketChatFieldConfig item : fields) {
        this.addToFields(item);
      }
    }
    return (A) this;
  }
  
  public A withHttpConfig(HTTPConfig httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withIconURL(String iconURL) {
    this.iconURL = iconURL;
    return (A) this;
  }
  
  public A withImageURL(String imageURL) {
    this.imageURL = imageURL;
    return (A) this;
  }
  
  public A withLinkNames() {
    return withLinkNames(true);
  }
  
  public A withLinkNames(Boolean linkNames) {
    this.linkNames = linkNames;
    return (A) this;
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withNewToken(String key,String name,Boolean optional) {
    return (A) this.withToken(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewTokenID(String key,String name,Boolean optional) {
    return (A) this.withTokenID(new SecretKeySelector(key, name, optional));
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withShortFields() {
    return withShortFields(true);
  }
  
  public A withShortFields(Boolean shortFields) {
    this.shortFields = shortFields;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
  public A withThumbURL(String thumbURL) {
    this.thumbURL = thumbURL;
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  
  public A withTitleLink(String titleLink) {
    this.titleLink = titleLink;
    return (A) this;
  }
  
  public A withToken(SecretKeySelector token) {
    this.token = token;
    return (A) this;
  }
  
  public A withTokenID(SecretKeySelector tokenID) {
    this.tokenID = tokenID;
    return (A) this;
  }
  public class ActionsNested<N> extends RocketChatActionConfigFluent<ActionsNested<N>> implements Nested<N>{
  
    RocketChatActionConfigBuilder builder;
    int index;
  
    ActionsNested(int index,RocketChatActionConfig item) {
      this.index = index;
      this.builder = new RocketChatActionConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RocketChatConfigFluent.this.setToActions(index, builder.build());
    }
    
    public N endAction() {
      return and();
    }
    
  }
  public class FieldsNested<N> extends RocketChatFieldConfigFluent<FieldsNested<N>> implements Nested<N>{
  
    RocketChatFieldConfigBuilder builder;
    int index;
  
    FieldsNested(int index,RocketChatFieldConfig item) {
      this.index = index;
      this.builder = new RocketChatFieldConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RocketChatConfigFluent.this.setToFields(index, builder.build());
    }
    
    public N endField() {
      return and();
    }
    
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RocketChatConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}