package org.example.monitor;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "dashboard", layout = MainView.class)
public class DashboardView extends VerticalLayout {

  private static final long serialVersionUID = -8527651397044764594L;

  IFrame iframe1;
  IFrame iframe2;
  IFrame iframe3;
  IFrame iframe4;

  @Autowired
  public DashboardView() {
    this.setSizeFull();
    this.setPadding(false);

    add(buildHeader());
    add(buildContent());
  }

  private Component buildHeader() {
    FlexLayout layout = new FlexLayout();
    layout.setWidthFull();
    layout.setHeight("35px");
    layout.setClassName("greenbackground");

    Label title = new Label("Dashboard");
    title.setClassName("greenbackground");
    title.getStyle().set("color", "white");
    title.getStyle().set("font-size", "20px");
    title.getStyle().set("font-weight", "lighter");
    title.getStyle().set("padding-left", "16px");
    layout.add(title);

    return layout;
  }

  private Component buildContent() {
    VerticalLayout layout = new VerticalLayout();
    layout.setSizeFull();
    layout.getStyle().set("padding", "0px");
    layout.getStyle().set("margin-top", "0px");
    layout.add(buildSectionCam());

    return layout;
  }

  private Component buildSectionCam() {
    VerticalLayout principal = new VerticalLayout();
    principal.setHeightFull();

    HorizontalLayout section1 = new HorizontalLayout();
    section1.setHeight("50%");
    section1.setWidthFull();

    HorizontalLayout section2 = new HorizontalLayout();
    section2.setHeight("50%");
    section2.setWidthFull();

    VerticalLayout cam1 = new VerticalLayout();
    cam1.setSizeFull();
    cam1.setPadding(false);
    cam1.setSpacing(false);
    iframe1 = new IFrame();
    iframe1.setSizeFull();
    FlexLayout buttons1 = new FlexLayout();
    Button btnPlay1 = new Button(VaadinIcon.PLAY.create());
    btnPlay1.setText("Play");
    btnPlay1.addClickListener(event -> Notification.show("Play Camera 1."));
    Button btnStop1 = new Button(VaadinIcon.STOP.create());
    btnStop1.setText("Stop");
    btnStop1.addClickListener(event -> Notification.show("Stop Camera 1."));
    Button btnSnap1 = new Button(VaadinIcon.CAMERA.create());
    btnSnap1.setText("Snapshot");
    btnSnap1.addClickListener(event -> Notification.show("Snapshot Camera 1."));
    buttons1.add(btnPlay1, btnStop1, btnSnap1);
    cam1.add(iframe1, buttons1);

    VerticalLayout cam2 = new VerticalLayout();
    cam2.setSizeFull();
    cam2.setPadding(false);
    cam2.setSpacing(false);
    iframe2 = new IFrame();
    iframe2.setSizeFull();
    FlexLayout buttons2 = new FlexLayout();
    Button btnPlay2 = new Button(VaadinIcon.PLAY.create());
    btnPlay2.setText("Play");
    btnPlay2.addClickListener(event -> Notification.show("Play Camera 2."));
    Button btnStop2 = new Button(VaadinIcon.STOP.create());
    btnStop2.setText("Stop");
    btnStop2.addClickListener(event -> Notification.show("Stop Camera 2."));
    Button btnSnap2 = new Button(VaadinIcon.CAMERA.create());
    btnSnap2.setText("Snapshot");
    btnSnap2.addClickListener(event -> Notification.show("Snapshot Camera 2."));
    buttons2.add(btnPlay2, btnStop2, btnSnap2);
    cam2.add(iframe2, buttons2);

    VerticalLayout cam3 = new VerticalLayout();
    cam3.setSizeFull();
    cam3.setPadding(false);
    cam3.setSpacing(false);
    iframe3 = new IFrame();
    iframe3.setSizeFull();
    FlexLayout buttons3 = new FlexLayout();
    Button btnPlay3 = new Button(VaadinIcon.PLAY.create());
    btnPlay3.setText("Play");
    btnPlay3.addClickListener(event -> Notification.show("Play Camera 3."));
    Button btnStop3 = new Button(VaadinIcon.STOP.create());
    btnStop3.setText("Stop");
    btnStop3.addClickListener(event -> Notification.show("Stop Camera 3."));
    Button btnSnap3 = new Button(VaadinIcon.CAMERA.create());
    btnSnap3.setText("Snapshot");
    btnSnap3.addClickListener(event -> Notification.show("Snapshot Camera 3."));
    buttons3.add(btnPlay3, btnStop3, btnSnap3);
    cam3.add(iframe3, buttons3);

    VerticalLayout cam4 = new VerticalLayout();
    cam4.setSizeFull();
    cam4.setPadding(false);
    cam4.setSpacing(false);
    iframe4 = new IFrame();
    iframe4.setSizeFull();
    FlexLayout buttons4 = new FlexLayout();
    Button btnPlay4 = new Button(VaadinIcon.PLAY.create());
    btnPlay4.setText("Play");
    btnPlay4.addClickListener(event -> Notification.show("Play Camera 4."));
    Button btnStop4 = new Button(VaadinIcon.STOP.create());
    btnStop4.setText("Stop");
    btnStop4.addClickListener(event -> Notification.show("Stop Camera 4."));
    Button btnSnap4 = new Button(VaadinIcon.CAMERA.create());
    btnSnap4.setText("Snapshot");
    btnSnap4.addClickListener(event -> Notification.show("Snapshot Camera 4."));
    buttons4.add(btnPlay4, btnStop4, btnSnap4);
    cam4.add(iframe4, buttons4);

    section1.addAndExpand(cam1, cam2);
    section2.addAndExpand(cam3, cam4);

    principal.add(section1);
    principal.add(section2);

    return principal;
  }
}
