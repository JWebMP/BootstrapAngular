package com.jwebmp.plugins.bootstrap.angular;

import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgPolyfill;
import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgScript;
import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgStyleSheet;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootModuleImport;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;

@NgBootModuleImport("NgbModule")
@NgBootImportReference(value = "NgbModule", reference = "@ng-bootstrap/ng-bootstrap")

@TsDependency(value = "@ng-bootstrap/ng-bootstrap", version = "^16.0.0")
@TsDependency(value = "@popperjs/core", version = "^2.1..8")
@TsDependency(value = "bootstrap", version = "^5.3.2")
@TsDependency(value = "@angular/localize", version = "^18.0.1")

/*@TsDependency(value = "ng-bootstrap-datetime-angular-13", version = "^0.1.33")
@NgBootImportReference(name = "NgBootstrapDatetimeAngularModule ", reference = "ng-bootstrap-datetime-angular-13")
@NgBootModuleImport("NgBootstrapDatetimeAngularModule")*/

@NgPolyfill("@angular/localize/init")

@NgStyleSheet(value = "node_modules/bootstrap/scss/bootstrap.scss", name = "bootstrap")
@NgScript(value = "@popperjs/core/dist/umd/popper.js", sortOrder = 4)
@NgScript(value = "bootstrap/dist/js/bootstrap.js", sortOrder = 5)
public class BootstrapAngularPageConfigurator implements IPageConfigurator<BootstrapAngularPageConfigurator>
{
    @Override
    public IPage<?> configure(IPage<?> page)
    {
        return page;
    }

    @Override
    public boolean enabled()
    {
        return true;
    }
}
