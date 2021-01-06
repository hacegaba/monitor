package org.example.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuData {
  private static final List<MenuItem> MENU_ITEMS = createMenuItems();

  private static List<MenuItem> createMenuItems() {
    List<MenuItem> menuList = new ArrayList<>();

    menuList.add(new MenuItem("Dashboard", null, null));
    menuList.add(new MenuItem("Clientes", null, null));
    MenuItem catalog = new MenuItem("Catálogos", null, null);
    menuList.add(catalog);
    menuList.add(new MenuItem("Usuarios", catalog, null));
    MenuItem reports = new MenuItem("Reportes", null, null);
    menuList.add(reports);
    menuList.add(new MenuItem("Alertas por Cliente", reports, null));

    return menuList;
  }

  public List<MenuItem> getitems() {
    return MENU_ITEMS;
  }

  public List<MenuItem> getRootItems() {
    return MENU_ITEMS.stream().filter(item -> item.getParent() == null).collect(Collectors.toList());
  }

  public List<MenuItem> getChildItems(MenuItem parent) {
    return MENU_ITEMS.stream().filter(item -> Objects.equals(item.getParent(), parent)).collect(Collectors.toList());
  }
}