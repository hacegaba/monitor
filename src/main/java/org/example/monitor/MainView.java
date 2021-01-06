package org.example.monitor;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Monitor 911")
@CssImport(value = "./stylecolors.css")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
public class MainView extends AppLayout {

  private static final long serialVersionUID = -1225385299217427695L;

  public MainView() {
    Image logo = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
    logo.setHeight("44px");

    this.addToNavbar(new DrawerToggle(), logo);
    this.addToNavbar(true, createExitButton());
    this.addToDrawer(createMenuBar());
    this.setPrimarySection(AppLayout.Section.NAVBAR);
  }

  private Component createExitButton() {
    Button exit = new Button("logout", VaadinIcon.SIGN_OUT.create());
    exit.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
    exit.setClassName("greencolor");
    exit.getStyle().set("cursor", "pointer");
    exit.addClickListener(event -> {
      Notification.show("logout button clicked.");
    });

    FlexLayout tools = new FlexLayout();
    tools.setWidthFull();
    tools.getStyle().set("justify-content", "flex-end");
    tools.getStyle().set("margin-right", "5px");
    tools.add(exit);
    return tools;
  }

  private Component createMenuBar() {
    MenuData menuData = new MenuData();
    List<MenuItem> rootList = menuData.getRootItems();
    List<MenuItem> rootListTemp = new ArrayList<MenuItem>(rootList);

    TreeGrid<MenuItem> grid = new TreeGrid<>();
    grid.removeAllColumns();
    grid.setSizeFull();
    grid.setItems(rootList, menuData::getChildItems);
    grid.addHierarchyColumn(MenuItem::getName);
    //grid.setWidthFull();
    grid.addThemeVariants(GridVariant.LUMO_COMPACT);
    grid.setClassName("my-grid");
    grid.addItemClickListener(event -> {
      Notification.show(event.getItem().getName()+" clicked!");
    });

    return grid;
  }
}
