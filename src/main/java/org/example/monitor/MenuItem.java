package org.example.monitor;

import com.vaadin.flow.component.Component;

public class MenuItem {

  private String name;
  private MenuItem parent;
  private Class<? extends Component> viewClass;

  public MenuItem(String name, MenuItem parent) {
    super();
    this.name = name;
    this.parent = parent;
  }

  public MenuItem(String name, MenuItem parent, Class<? extends Component> viewClass) {
    super();
    this.name = name;
    this.parent = parent;
    this.viewClass = viewClass;
  }

  public MenuItem() {
    super();
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public MenuItem getParent() {
    return parent;
  }
  public void setParent(MenuItem parent) {
    this.parent = parent;
  }

  public Class<? extends Component> getViewClass() {
    return viewClass;
  }
  public void setViewClass(Class<? extends Component> viewClass) {
    this.viewClass = viewClass;
  }

}
