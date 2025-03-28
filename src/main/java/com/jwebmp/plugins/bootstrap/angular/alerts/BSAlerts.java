/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.bootstrap.angular.alerts;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgDataTypeReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.services.interfaces.IComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.plugins.bootstrap.BSColourTypes;
import com.jwebmp.plugins.bootstrap.alerts.BSAlertsAlert;
import com.jwebmp.plugins.bootstrap.alerts.events.BSAlertEvents;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getNgComponentReference;

/**
 * Alerts
 * <p>
 * Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.
 *
 * @param <J>
 * @author GedMarc
 * @version 1.0
 * @since 31 Dec 2016
 */
@NgComponent("alert-closable")
@ComponentInformation(name = "Bootstrap Alert",
        description = "Provide contextual feedback messages for typical user actions with the handful of available and flexible alert " + "messages.",
        url = "https://v4-alpha.getbootstrap.com/components/alerts/",
        wikiUrl = "https://github.com/GedMarc/JWebMP-BootstrapPlugin/wiki")
@NgDataTypeReference(NgAlert.class)

@NgField("data?: any;")
@NgField("private updated: boolean = false;")
public abstract class BSAlerts<J extends BSAlerts<J>>
        extends Div<GlobalChildren, NoAttributes, GlobalFeatures, BSAlertEvents<?>, J>
        implements IBSAlerts<J>, INgComponent<J>
{
    private AlertDataService<?> alertDataService;

    public BSAlerts(AlertDataService<?> alertDataService)
    {
        this();
        this.alertDataService = alertDataService;
    }

    /**
     * Alerts
     * <p>
     * Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.
     */
    public BSAlerts()
    {

    }

    public String getServiceName()
    {
        if (alertDataService == null)
        {
            return "alertDataService";
        }
        String name = getTsFilename(alertDataService.getClass());
        name = name.substring(0, 1)
                .toLowerCase() + name.substring(1);
        return name;
    }

    @Override
    public List<NgImportReference> getAllImportAnnotations()
    {
        List<NgImportReference> out = INgComponent.super.getAllImportAnnotations();
        NgComponentReference reference = getNgComponentReference((Class<? extends IComponent<?>>) alertDataService.getClass());
        out.addAll(putRelativeLinkInMap(getClass(), reference));
        return out;
    }

    @Override
    public List<String> afterViewInit()
    {
        List<String> out = INgComponent.super.afterViewInit();
        out.add("        this." + getServiceName() + ".data.subscribe((dd) => {\n" +
                "            this.data = dd;\n" +
                "            this.updated = true;\n" +
                "        });\n");
        return out;
    }

    @Override
    public List<String> methods()
    {
        List<String> out = INgComponent.super.methods();
        if (alertDataService != null)
        {
           /* out.add("close(alertItem: Alert) {\n" +
                            "    this.data.out?.splice(this.data.out?.indexOf(alertItem), 1);\n" +
                            "}\n");*/
        }
        else
        {
            return List.of();
        }
        return out;
    }

    @Override
    public List<String> componentConstructorParameters()
    {
        List<String> out = new ArrayList<>();
        if (alertDataService != null)
        {
            out.add("public " + getServiceName() + " : " + getTsFilename(alertDataService.getClass()));
        }
        return out;
    }

    /**
     * Alerts
     * <p>
     * Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.
     */
    public BSAlerts(String paragraph)
    {
        this();
        setText(paragraph);
    }

    /**
     * Alerts
     * <p>
     * Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.
     */
    public BSAlerts(IComponentHierarchyBase<?, ?> component)
    {
        this();
        add(component);
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            String name = getServiceName();
            addAttribute("*ngFor", "let alert of data?.out");

            add(new BSAlertsAlert().setType(BSColourTypes.AlertsType)
                    .bind("alert.message")
                    .addAttribute("(closed)", "close(alert)"));
        }
    }

    /**
     * Neater view of this component
     *
     * @return
     */
    public IBSAlerts<?> asMe()
    {
        return this;
    }

}
