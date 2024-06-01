package com.jwebmp.plugins.bootstrap.angular.alerts;

import com.guicedee.services.jsonrepresentation.IJsonRepresentation;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.plugins.bootstrap.BSColourTypes;

@NgDataType
public class NgAlert extends Alert implements IJsonRepresentation<NgAlert>, INgDataType<NgAlert>
{
    public NgAlert()
    {
    }

    public NgAlert(BSColourTypes type, String message)
    {
        super(type, message);
    }
}
